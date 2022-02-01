package com.tencent.mobileqq.highway.conn;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.ipv6.HappyEyeballsRace;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.segment.RequestWorker.RequestHandler;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.highway.utils.HwStatisticMgr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ConnManager
  implements IHwManager, IConnectionListener
{
  private static final int IP_TIMEOUT_FOR_HTTP_PATCH_MAX = 3;
  public static AtomicInteger connSeq = new AtomicInteger(1);
  private long _connStartTime = -1L;
  private AtomicBoolean bUseHttpPatch = new AtomicBoolean(false);
  private int connCount = -1;
  public ArrayList<ConnReportInfo> connInfoList = new ArrayList();
  public volatile int connectedConn;
  public ConcurrentHashMap<Integer, IConnection> connections = new ConcurrentHashMap();
  public HwEngine engine;
  public ConcurrentHashMap<Integer, Runnable> heartBreaks = new ConcurrentHashMap();
  private int iHttpPatchConnId = -1;
  public EndPoint lastEndPoint;
  private HappyEyeballsRace mHERace = new HappyEyeballsRace();
  public boolean mHasIpv6List;
  private ConcurrentHashMap<String, String> mIpTimeOutCounter = new ConcurrentHashMap();
  private List<EndPoint> mReportEndPoint;
  private int mReportFailCnt;
  private boolean mReportHasStart;
  private long mReportStart = -1L;
  private int mReportSuccCnt;
  public volatile AtomicLong vConnCost = new AtomicLong(-1L);
  public volatile int vConnErrCode;
  
  public ConnManager(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void createMultiConn(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    BdhLogUtil.LogEvent("C", "createMultiConn， isIpv6 = " + paramBoolean + ", maxConnNum = " + paramInt1 + ", netType = " + paramInt2);
    while ((this.connections.size() < paramInt1) && (openNewConnection(paramInt2, false, paramBoolean) != null)) {}
  }
  
  private void createNewConnectionIfNeed(int paramInt, boolean paramBoolean)
  {
    int j;
    label366:
    for (int i = 1;; i = j)
    {
      for (;;)
      {
        try
        {
          j = (int)this.engine.getCurrentConfig().curConnNum;
          if ((paramBoolean) || (paramInt > 1)) {
            break label366;
          }
          j = i;
          if (this.bUseHttpPatch.get()) {
            j = i + 1;
          }
          synchronized (this.connections)
          {
            if (this.connections.size() >= j) {
              break;
            }
            i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
            if (i == 0)
            {
              BdhLogUtil.LogEvent("C", "CreateNewConnectionIfNeed : No network in networkCenter : ConnSize:" + this.connections.size() + " currentRequests:" + paramInt + " maxConnNum:" + j);
              HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
              this.engine.mRequestWorker.sendConnectRequest(5000L, false);
              return;
            }
            if (this.mHERace.mIsRacing)
            {
              BdhLogUtil.LogEvent("C", "CreateNewConnectionIfNeed : is racing , return. ");
              return;
            }
          }
          paramBoolean = Ipv6Config.getInstance().isIpv6SwitchOpen(this.engine);
        }
        catch (Exception localException)
        {
          BdhLogUtil.LogException("C", "Create Conn Error.", localException);
          return;
        }
        int k = Ipv6Config.getInstance().getNetType();
        boolean bool = hasIpv6List();
        this.mHasIpv6List = bool;
        BdhLogUtil.LogEvent("C", "CreateNewConnectionIfNeed : ipv6SwitchOpen = " + paramBoolean + " , netStack = " + k + " , hasIpv6List = " + bool);
        if (k == 3)
        {
          if ((this.connections.size() == 0) && (paramBoolean) && (bool)) {
            startRacing(i);
          } else {
            createMultiConn(this.mHERace.mIsIpv6Fast, j, i);
          }
        }
        else if (k == 2) {
          createMultiConn(true, j, i);
        } else {
          createMultiConn(false, j, i);
        }
      }
      return;
    }
  }
  
  private void createRacingConn(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    BdhLogUtil.LogEvent("C", "createRacingConn，isIpv6 =  " + paramBoolean2);
    IConnection localIConnection = openNewConnection(paramInt, paramBoolean1, paramBoolean2);
    if (localIConnection != null) {
      synchronized (this.mHERace)
      {
        this.mHERace.mConnList.add(localIConnection);
        return;
      }
    }
  }
  
  private boolean hasIpv6List()
  {
    if (this.engine != null)
    {
      ConfigManager localConfigManager = ConfigManager.getInstance(this.engine.getAppContext(), this.engine);
      if (localConfigManager != null) {
        return localConfigManager.hasIpv6List(this.engine.getAppContext());
      }
    }
    return false;
  }
  
  private IConnection openNewConnection(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    EndPoint localEndPoint1 = ConfigManager.getInstance(this.engine.getAppContext(), this.engine).getNextSrvAddr(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, paramBoolean2);
    BdhLogUtil.LogEvent("C", "openNewConnection, isIpv6 = " + paramBoolean2 + ",ep = " + localEndPoint1.toString());
    if ((this.connectedConn <= 0) && (this._connStartTime == -1L)) {
      this._connStartTime = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      synchronized (this.connections)
      {
        int i = this.connections.size();
        if (localEndPoint1 == null)
        {
          BdhLogUtil.LogEvent("C", "OpenNewConnection : ep is Null, connSize:" + i);
          if (i == 0) {
            this.engine.mTransWorker.switchToBackupChannel();
          }
          return null;
        }
        this.lastEndPoint = localEndPoint1;
        reportChannelStart(localEndPoint1);
        if ((paramBoolean1) || (localEndPoint1.protoType != 1)) {
          break label299;
        }
        i = connSeq.incrementAndGet();
        if (paramInt == 1)
        {
          paramInt = 10000;
          ??? = new TcpConnection(this, i, localEndPoint1, paramInt, 30000, paramBoolean2);
          if ((??? == null) || (!((IConnection)???).connect())) {
            break;
          }
          ((IConnection)???).setConnectListener(this);
          this.connections.put(Integer.valueOf(((IConnection)???).getConnId()), ???);
          return ???;
        }
      }
      paramInt = 20000;
      continue;
      label299:
      HttpConnection localHttpConnection = new HttpConnection(this, connSeq.incrementAndGet(), localEndPoint2, paramBoolean2);
      ??? = localHttpConnection;
      if (paramBoolean1)
      {
        this.iHttpPatchConnId = localHttpConnection.getConnId();
        BdhLogUtil.LogEvent("C", "OpenNewConnection For Http Patch : ID[" + this.iHttpPatchConnId + "]");
        ??? = localHttpConnection;
      }
    }
    return null;
  }
  
  private void startRacing(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "startRacing . ");
    this.mHERace.mIsRacing = true;
    boolean bool = Ipv6Config.getInstance().isIpv6BDHFirst(this.engine);
    BdhLogUtil.LogEvent("C", "startRacing，ipv6First =  " + bool);
    createRacingConn(paramInt, false, bool);
    this.mHERace.mRacingRunnable = new ConnManager.1(this, paramInt, bool);
    this.engine.mRequestWorker.mRequestHandler.postDelayed(this.mHERace.mRacingRunnable, Ipv6Config.getInstance().mConnAttemptDelay);
  }
  
  public long getConnCost()
  {
    return this.vConnCost.getAndSet(-1L);
  }
  
  public int getCurrentConnNum()
  {
    synchronized (this.connections)
    {
      int i = this.connections.size();
      return i;
    }
  }
  
  public boolean hasNet()
  {
    HwNetworkCenter localHwNetworkCenter = HwNetworkCenter.getInstance(this.engine.getAppContext());
    localHwNetworkCenter.updateNetInfo(this.engine.getAppContext());
    return localHwNetworkCenter.getNetType() != 0;
  }
  
  public void increaseDataFlowDw(long paramLong)
  {
    int i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
    if (i == 1) {
      this.engine.dwFlow_Wifi.addAndGet(paramLong);
    }
    while (i == 0) {
      return;
    }
    this.engine.dwFlow_Xg.addAndGet(paramLong);
  }
  
  public void increaseDataFlowUp(long paramLong)
  {
    int i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
    if (i == 1) {
      this.engine.upFlow_Wifi.addAndGet(paramLong);
    }
    while (i == 0) {
      return;
    }
    this.engine.upFlow_Xg.addAndGet(paramLong);
  }
  
  public boolean isIpv6Fast()
  {
    return this.mHERace.mIsIpv6Fast;
  }
  
  public void onConnect(boolean paramBoolean, int paramInt1, IConnection paramIConnection, EndPoint paramEndPoint, int paramInt2, ConnReportInfo paramConnReportInfo)
  {
    BdhLogUtil.LogEvent("C", "ConnManager.onConnect, isSuccess = " + paramBoolean + ", errno = " + paramInt2);
    ConfigManager localConfigManager = null;
    ??? = this.engine.getAppContext();
    if (??? != null) {
      localConfigManager = ConfigManager.getInstance((Context)???, this.engine);
    }
    if (paramIConnection.getProtoType() != 2) {}
    for (;;)
    {
      synchronized (this.connections)
      {
        this.mHERace.doOnConect(paramBoolean, paramIConnection, this.engine);
        if (paramBoolean)
        {
          this.connectedConn += 1;
          this.engine.mRequestWorker.onConnConnected(paramInt1);
          if (paramIConnection.getProtoType() != 2) {
            this.engine.mRequestWorker.sendHeartBreak(paramInt1, false, false, 0);
          }
          if (this._connStartTime >= 0L)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this._connStartTime;
            this._connStartTime = -1L;
            this.vConnCost.compareAndSet(-1L, l1 - l2);
          }
          if (localConfigManager != null) {
            localConfigManager.onSvrConnFinish(paramEndPoint, paramInt2);
          }
          this.vConnErrCode = paramInt2;
          reportConnectResult(paramEndPoint, paramBoolean, paramInt2, paramConnReportInfo.connElapseTime);
          BdhLogUtil.LogEvent("C", "OnConnect :　connId:" + paramInt1 + " Size:" + this.connections.size() + " errno:" + paramInt2);
          return;
        }
      }
      this.connections.remove(Integer.valueOf(paramIConnection.getConnId()));
      if (localConfigManager != null) {
        localConfigManager.onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, paramEndPoint.host, paramInt2, paramIConnection.isIpv6());
      }
      if (paramInt2 == 3) {
        this.engine.mRequestWorker.sendConnectRequest(5000L, false);
      } else {
        this.engine.mRequestWorker.sendConnectRequest(0L, false);
      }
    }
  }
  
  public void onConnectionIdle(int paramInt, boolean paramBoolean)
  {
    this.engine.mRequestWorker.sendHeartBreak(paramInt, false, paramBoolean, 60000);
  }
  
  public void onDecodeSucessfully(List<HwResponse> paramList)
  {
    this.engine.mRequestWorker.onReceiveResp(paramList);
  }
  
  public void onDestroy() {}
  
  public void onDisConnect(int paramInt, IConnection paramIConnection)
  {
    HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
    if ((IConnection)this.connections.remove(Integer.valueOf(paramIConnection.getConnId())) != null)
    {
      this.connectedConn -= 1;
      this.engine.mRequestWorker.onConnClose(paramInt);
      BdhLogUtil.LogEvent("C", "OnDisConnect :　connId:" + paramInt + " Size:" + this.connections.size());
    }
    if (paramIConnection.getConnId() == this.iHttpPatchConnId)
    {
      this.iHttpPatchConnId = -1;
      this.bUseHttpPatch.set(false);
    }
  }
  
  public void onHeartBreakResp(int paramInt, EndPoint paramEndPoint, boolean paramBoolean)
  {
    BdhLogUtil.LogEvent("C", "onHeartBreakResp : connId = " + paramInt + ", isUrgent = " + paramBoolean);
    paramEndPoint = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if ((paramEndPoint != null) && (paramBoolean))
    {
      paramEndPoint.setUrgentFlag(false);
      this.heartBreaks.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void onIPV6IllegalUserErr(int paramInt)
  {
    Object localObject2 = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localObject2 != null)
    {
      Object localObject1 = ((IConnection)localObject2).getEndPoint();
      ((IConnection)localObject2).disConnect();
      localObject2 = this.engine.getAppContext();
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject1 = ConfigManager.getInstance((Context)localObject2, this.engine);
        if (localObject1 != null) {
          ((ConfigManager)localObject1).clearIpv6Cfg((Context)localObject2);
        }
      }
    }
    createNewConnectionIfNeed(1, false);
  }
  
  public void onInit() {}
  
  public void onRecvInvalidData(EndPoint paramEndPoint, IConnection paramIConnection)
  {
    Context localContext = this.engine.getAppContext();
    if ((paramEndPoint != null) && (localContext != null))
    {
      ConfigManager localConfigManager = ConfigManager.getInstance(localContext, this.engine);
      if (localConfigManager != null) {
        localConfigManager.onSrvAddrUnavailable(localContext, this.engine.app, this.engine.currentUin, paramEndPoint.host, 15, paramIConnection.isIpv6());
      }
      BdhLogUtil.LogEvent("P", "receive the invalid data,start weak net probe! ip:" + paramEndPoint.host);
    }
  }
  
  public void onRequestTimeOut(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "onRequestTimeOut : connId:" + paramInt);
    IConnection localIConnection = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localIConnection != null)
    {
      ??? = localIConnection.getEndPoint();
      if (localIConnection.getProtoType() == 1)
      {
        localIConnection.setUrgentFlag(true);
        this.mIpTimeOutCounter.put(((EndPoint)???).host, ((EndPoint)???).host);
        if ((this.bUseHttpPatch.compareAndSet(false, true)) && (this.mIpTimeOutCounter.size() >= 3))
        {
          this.mIpTimeOutCounter.clear();
          paramInt = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
          BdhLogUtil.LogEvent("C", "onRequestTimeOut : About to create a http patch. netType:" + paramInt);
          if (paramInt == 1)
          {
            paramInt = (int)this.engine.getCurrentConfig().curConnNum;
            synchronized (this.connections)
            {
              if (this.connections.size() < paramInt) {
                openNewConnection(1, true, localIConnection.isIpv6());
              }
              return;
            }
          }
          this.bUseHttpPatch.set(false);
        }
      }
      else if (localObject1.getProtoType() == 2)
      {
        this.mIpTimeOutCounter.clear();
        Object localObject3 = this.engine.getAppContext();
        if ((??? != null) && (localObject3 != null))
        {
          localObject3 = ConfigManager.getInstance((Context)localObject3, this.engine);
          if (localObject3 != null) {
            ((ConfigManager)localObject3).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, ((EndPoint)???).host, 7, localObject1.isIpv6());
          }
        }
        localObject1.disConnect();
        createNewConnectionIfNeed(1, false);
      }
    }
  }
  
  public void onRequestWriteTimeout(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "onRequestWriteTimeout : connId:" + paramInt);
    IConnection localIConnection = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localIConnection != null) {
      localIConnection.disConnect();
    }
  }
  
  public void onUrgentHeartBreakTimeout(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "onUrgentHeartBreakTimeout : connId:" + paramInt);
    IConnection localIConnection = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localIConnection != null)
    {
      EndPoint localEndPoint = localIConnection.getEndPoint();
      localIConnection.disConnect();
      Object localObject = this.engine.getAppContext();
      if ((localEndPoint != null) && (localObject != null))
      {
        localObject = ConfigManager.getInstance((Context)localObject, this.engine);
        if (localObject != null) {
          ((ConfigManager)localObject).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, localEndPoint.host, 7, localIConnection.isIpv6());
        }
      }
    }
    createNewConnectionIfNeed(1, false);
  }
  
  public HwRequest pullNextRequest(IConnection paramIConnection, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    int i = 2;
    if (paramBoolean) {
      i = 0;
    }
    HwRequest localHwRequest = this.engine.mRequestWorker.getMaxPriorityRequest(paramIConnection.getConnId(), i, paramLong1, paramLong2, paramInt);
    if ((localHwRequest == null) && (paramIConnection.getProtoType() == 2) && (this.engine.mTransWorker.getTransactionNum() == 0)) {
      paramIConnection.disConnect();
    }
    return localHwRequest;
  }
  
  public void reportChannelStart(EndPoint paramEndPoint)
  {
    int i = this.connCount + 1;
    this.connCount = i;
    paramEndPoint.connIndex = i;
    if (this.mReportHasStart) {
      return;
    }
    this.mReportStart = SystemClock.uptimeMillis();
    this.mReportHasStart = true;
    this.mReportFailCnt = 0;
    this.mReportSuccCnt = 0;
    this.mReportEndPoint = Collections.synchronizedList(new ArrayList());
  }
  
  public void reportChannelStop(boolean paramBoolean)
  {
    if (!this.mReportHasStart) {
      return;
    }
    this.mReportHasStart = false;
    if (paramBoolean) {
      this.connCount = -1;
    }
    int i = this.mReportFailCnt;
    int j = this.mReportSuccCnt;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mReportStart;
    HwEngine localHwEngine = this.engine;
    HwStatisticMgr.doReportConnection(HwEngine.appId, this.engine.currentUin, paramBoolean, i + j, this.mReportSuccCnt, this.mReportFailCnt, this.mReportEndPoint, l1 - l2);
  }
  
  public void reportConnectResult(EndPoint paramEndPoint, boolean paramBoolean, int paramInt, long paramLong)
  {
    paramEndPoint.connResult = paramInt;
    paramEndPoint.cost = paramLong;
    if (paramBoolean) {
      this.mReportSuccCnt += 1;
    }
    for (;;)
    {
      this.mReportEndPoint.add(paramEndPoint);
      if ((paramBoolean) || (this.mReportFailCnt >= 8)) {
        reportChannelStop(paramBoolean);
      }
      return;
      this.mReportFailCnt += 1;
    }
  }
  
  public void wakeupConnectionToWrite(int paramInt, boolean paramBoolean)
  {
    createNewConnectionIfNeed(paramInt, paramBoolean);
    synchronized (this.connections)
    {
      Iterator localIterator = this.connections.values().iterator();
      while (localIterator.hasNext())
      {
        IConnection localIConnection = (IConnection)localIterator.next();
        if (localIConnection.isWritable()) {
          localIConnection.wakeupChannel();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.ConnManager
 * JD-Core Version:    0.7.0.1
 */