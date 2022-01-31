package com.tencent.mobileqq.highway.conn;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.highway.utils.HwStatisticMgr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ConnManager
  implements IHwManager, IConnectionListener
{
  public static boolean CONN_NUM_CUSTOM = false;
  public static final int CONN_TYPE_LONG = 1;
  public static final int CONN_TYPE_SHORT = 2;
  private static final int HB_RESP_COUNT_MAX = 4;
  public static final int IO_TYPE_SYNC = 1;
  public static AtomicInteger connSeq = new AtomicInteger(1);
  public ArrayList<ConnReportInfo> connInfoList = new ArrayList();
  private volatile int connType = 1;
  public ConcurrentHashMap<Integer, IConnection> connections = new ConcurrentHashMap();
  public HwEngine engine;
  public ConcurrentHashMap<Integer, EndPoint> heartBreakResp = new ConcurrentHashMap();
  public ConcurrentHashMap<Integer, Runnable> heartBreaks = new ConcurrentHashMap();
  private int ioType = 1;
  private int mReportFailCnt = 0;
  private ArrayList<Integer> mReportFailCode;
  private ArrayList<EndPoint> mReportFailIp;
  private ArrayList<Long> mReportFaillConnTimeCost;
  private boolean mReportHasStart = false;
  private long mTotalDuration = -1L;
  
  public ConnManager(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void createNewConnectionIfNeed(int paramInt, boolean paramBoolean)
  {
    try
    {
      int j = (int)this.engine.getCurrentConfig().curConnNum;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (paramInt <= 1) {
          i = 1;
        }
      }
      synchronized (this.connections)
      {
        do
        {
          if (this.connections.size() >= i) {
            break;
          }
          if (HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType() == 0L)
          {
            BdhLogUtil.LogEvent("C", "CreateNewConnectionIfNeed : No network in networkCenter : ConnSize:" + this.connections.size() + " currentRequests:" + paramInt + " maxConnNum:" + i);
            HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
            this.engine.mRequestWorker.sendConnectRequest(5000L, false);
            return;
          }
        } while (openNewConnection());
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      BdhLogUtil.LogException("C", "Create Conn Error.", localException);
    }
  }
  
  private boolean openNewConnection()
  {
    EndPoint localEndPoint = ConfigManager.getInstance(this.engine.getAppContext(), this.engine.app, this.engine.appId, this.engine.currentUin).getNextSrvAddr(this.engine.getAppContext(), this.engine.app, this.engine.currentUin);
    synchronized (this.connections)
    {
      int i = this.connections.size();
      if (localEndPoint == null)
      {
        BdhLogUtil.LogEvent("C", "OpenNewConnection : ep is Null, connSize:" + i);
        if (i == 0)
        {
          this.engine.mTransWorker.switchToBackupChannel();
          reportChannelStop(false);
        }
        return false;
      }
      if (localEndPoint.protoType == 1) {
        this.connType = 1;
      }
      reportChannelStart();
      ??? = null;
      ConnReportInfo localConnReportInfo = new ConnReportInfo();
      if (this.ioType == 1)
      {
        ??? = new SyncTcpConnection(this, 32768, 30000, connSeq.incrementAndGet(), this.connType, localEndPoint, localConnReportInfo);
        this.connections.put(Integer.valueOf(((IConnection)???).getConnId()), ???);
      }
      ((IConnection)???).setConnectListener(this);
      ((IConnection)???).connect();
      return true;
    }
  }
  
  public int getCurrentConnNum()
  {
    synchronized (this.connections)
    {
      int i = this.connections.size();
      return i;
    }
  }
  
  public String getHeartBreakInfo()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.heartBreakResp.values());
    this.heartBreakResp.clear();
    String str = "null";
    if (!localArrayList.isEmpty()) {
      str = Arrays.toString(localArrayList.toArray());
    }
    return str;
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
  
  public void onConnect(boolean paramBoolean, int paramInt1, IConnection paramIConnection, EndPoint paramEndPoint, int paramInt2, ConnReportInfo paramConnReportInfo)
  {
    if (paramBoolean)
    {
      this.engine.mRequestWorker.onConnConnected(paramInt1);
      if (paramIConnection.getConnType() != 2) {
        this.engine.mRequestWorker.sendHeartBreak(paramInt1, false, false, 0);
      }
      reportChannelStop(true);
      BdhLogUtil.LogEvent("C", "OnConnect :　connId:" + paramInt1 + " Size:" + this.connections.size() + " errno:" + paramInt2);
      return;
    }
    this.connections.remove(Integer.valueOf(paramIConnection.getConnId()));
    paramIConnection = this.engine.getAppContext();
    if (paramIConnection != null) {
      ConfigManager.getInstance(paramIConnection, this.engine.app, this.engine.appId, this.engine.currentUin).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, paramEndPoint.host, paramInt2);
    }
    if (paramInt2 == 3) {
      this.engine.mRequestWorker.sendConnectRequest(5000L, false);
    }
    for (;;)
    {
      reportConnectFail(paramEndPoint, paramInt2, paramConnReportInfo.connElapseTime);
      break;
      this.engine.mRequestWorker.sendConnectRequest(0L, false);
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
    this.connections.remove(Integer.valueOf(paramIConnection.getConnId()));
    this.engine.mRequestWorker.onConnClose(paramInt);
    BdhLogUtil.LogEvent("C", "OnDisConnect :　connId:" + paramInt + " Size:" + this.connections.size());
  }
  
  public void onHeartBreakResp(int paramInt, EndPoint paramEndPoint)
  {
    BdhLogUtil.LogEvent("C", "onHeartBreakResp : connId:" + paramInt);
    IConnection localIConnection = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localIConnection != null) {
      localIConnection.setUrgentFlag(false);
    }
    if (this.heartBreakResp.size() < 4) {
      this.heartBreakResp.put(Integer.valueOf(paramInt), paramEndPoint);
    }
  }
  
  public void onInit() {}
  
  public void onRecvInvalidData(EndPoint paramEndPoint)
  {
    Context localContext = this.engine.getAppContext();
    if ((paramEndPoint != null) && (localContext != null))
    {
      ConfigManager localConfigManager = ConfigManager.getInstance(localContext, this.engine.app, this.engine.appId, this.engine.currentUin);
      if (localConfigManager != null) {
        localConfigManager.onSrvAddrUnavailable(localContext, this.engine.app, this.engine.currentUin, paramEndPoint.host, 15);
      }
    }
  }
  
  public void onRequestTimeOut(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "onRequestTimeOut : connId:" + paramInt);
    IConnection localIConnection = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localIConnection != null)
    {
      if (localIConnection.getProtoType() != 1) {
        break label62;
      }
      localIConnection.setUrgentFlag(true);
    }
    label62:
    while (localIConnection.getProtoType() != 2) {
      return;
    }
    Object localObject = this.engine.getAppContext();
    EndPoint localEndPoint = localIConnection.getEndPoint();
    if ((localEndPoint != null) && (localObject != null))
    {
      localObject = ConfigManager.getInstance((Context)localObject, this.engine.app, this.engine.appId, this.engine.currentUin);
      if (localObject != null) {
        ((ConfigManager)localObject).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, localEndPoint.host, 7);
      }
    }
    this.connType = 2;
    localIConnection.disConnect();
    createNewConnectionIfNeed(1, false);
  }
  
  public void onUrgentHeartBreakTimeout(int paramInt, EndPoint paramEndPoint)
  {
    BdhLogUtil.LogEvent("C", "onUrgentHeartBreakTimeout : connId:" + paramInt);
    Object localObject = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((IConnection)localObject).disConnect();
    }
    localObject = this.engine.getAppContext();
    if ((paramEndPoint != null) && (localObject != null))
    {
      localObject = ConfigManager.getInstance((Context)localObject, this.engine.app, this.engine.appId, this.engine.currentUin);
      if (localObject != null) {
        ((ConfigManager)localObject).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, paramEndPoint.host, 7);
      }
    }
    createNewConnectionIfNeed(1, false);
  }
  
  public HwRequest pullNextRequest(IConnection paramIConnection, boolean paramBoolean)
  {
    int i = 2;
    if (paramBoolean) {
      i = 0;
    }
    return this.engine.mRequestWorker.getMaxPriorityRequest(paramIConnection.getConnId(), i);
  }
  
  public void reportChannelStart()
  {
    if (this.mReportHasStart) {
      return;
    }
    this.mTotalDuration = SystemClock.uptimeMillis();
    this.mReportHasStart = true;
    this.mReportFailCnt = 0;
    this.mReportFailIp = new ArrayList();
    this.mReportFailCode = new ArrayList();
    this.mReportFaillConnTimeCost = new ArrayList();
  }
  
  public void reportChannelStop(boolean paramBoolean)
  {
    if (!this.mReportHasStart) {
      return;
    }
    this.mTotalDuration = (SystemClock.uptimeMillis() - this.mTotalDuration);
    this.mReportHasStart = false;
    int i = 0;
    if (!paramBoolean) {
      this.mReportFailCnt += 1;
    }
    for (;;)
    {
      int j = this.mReportFailCnt;
      HwStatisticMgr.doReportConnection(this.engine.appId, this.engine.currentUin, paramBoolean, j + i, i, this.mReportFailCnt, this.mReportFailIp, this.mReportFailCode, this.mReportFaillConnTimeCost, this.mTotalDuration);
      return;
      i = 1;
    }
  }
  
  public void reportConnectFail(EndPoint paramEndPoint, int paramInt, long paramLong)
  {
    this.mReportFailCnt += 1;
    this.mReportFailIp.add(paramEndPoint);
    this.mReportFailCode.add(Integer.valueOf(paramInt));
    this.mReportFaillConnTimeCost.add(Long.valueOf(paramLong));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.ConnManager
 * JD-Core Version:    0.7.0.1
 */