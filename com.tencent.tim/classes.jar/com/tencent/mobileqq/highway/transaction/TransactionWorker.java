package com.tencent.mobileqq.highway.transaction;

import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.config.HwServlet.OnGetConfigListener;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.netprobe.EchoProbe;
import com.tencent.mobileqq.highway.netprobe.LoginWifiProbe;
import com.tencent.mobileqq.highway.netprobe.MtuProbe;
import com.tencent.mobileqq.highway.netprobe.ProbeCallback;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeRequest;
import com.tencent.mobileqq.highway.netprobe.ProbeTask;
import com.tencent.mobileqq.highway.netprobe.TracerouteProbe;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.segment.RequestWorker.RequestHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;

public class TransactionWorker
  implements IHwManager, HwServlet.OnGetConfigListener
{
  public static final int PRIORITY_HIGH = 0;
  public static final int PRIORITY_LOW = 2;
  public static final int PRIORITY_MEDIUM = 1;
  public static final int PRIORITY_NUM = 3;
  public static final int TRANS_OP_CNCL = 2;
  public static final int TRANS_OP_SEND = 1;
  private static final int[] round_array = { 0, 0, 1, 0, 0, 1, 2 };
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private HwEngine engine;
  private volatile int index;
  private SparseArray<ArrayList<Transaction>> transQueues = new SparseArray();
  private ArrayList<Transaction> transWaitForSessionKeyQueue = new ArrayList();
  
  public TransactionWorker(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void submitTransactionToTransQuene(Transaction paramTransaction)
  {
    paramTransaction.transationId = seqFactory.incrementAndGet();
    BdhLogUtil.LogEvent("T", "SubmitTransation : T_Id:" + paramTransaction.transationId + " ukey:" + String.valueOf(paramTransaction.ticket));
    for (;;)
    {
      synchronized (this.transQueues)
      {
        if (paramTransaction.mBuzCmdId == 25)
        {
          i = 1;
          if (this.transQueues.get(i) != null)
          {
            ((ArrayList)this.transQueues.get(i)).add(paramTransaction);
            BdhLogUtil.LogEvent("T", "SubmitTransation : T_Id:" + paramTransaction.transationId + " : add to queue[ " + i + "]");
          }
          notifyToSend();
          paramTransaction.startTime = SystemClock.uptimeMillis();
          return;
        }
      }
      int i = 0;
    }
  }
  
  private int submitTransactionToWaitForSessionKeyQuene(Transaction paramTransaction)
  {
    if ((this.engine == null) || (this.engine.app == null) || (this.engine.app.getAccount() == null) || (this.engine.mRequestWorker == null) || (this.engine.mRequestWorker.mRequestHandler == null)) {
      return -1018;
    }
    String str = this.engine.app.getAccount();
    HwServlet.getConfig(this.engine.app, str, this);
    try
    {
      this.transWaitForSessionKeyQueue.add(paramTransaction);
      paramTransaction.startTimeoutTimer();
      BdhLogUtil.LogEvent("T", "Submit Trans to transWaitForSessionKeyQueue ,Transaction path:" + paramTransaction.filePath + " transWaitForSessionKeyQueue size:" + this.transWaitForSessionKeyQueue.size());
      return 0;
    }
    finally {}
  }
  
  public void cancelTransaction(Transaction paramTransaction)
  {
    paramTransaction.cancelTransaction();
    this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
  }
  
  void dumpEngineInfo()
  {
    int i = this.engine.mRequestWorker.mCurrentRequests;
    int j = this.engine.mTransWorker.getTransactionNum();
    int k = this.engine.mConnManager.connectedConn;
    QLog.d("E", 1, "EngineInfo : Request:" + i + " TransCnt:" + j + " ConnCnt:" + k);
  }
  
  int getConnErroCode()
  {
    return this.engine.mConnManager.vConnErrCode;
  }
  
  public HwEngine getHwEngine()
  {
    return this.engine;
  }
  
  public long getIpConnectCost()
  {
    return this.engine.mConnManager.getConnCost();
  }
  
  String getLastUsedIp()
  {
    EndPoint localEndPoint = this.engine.mConnManager.lastEndPoint;
    if (localEndPoint != null) {
      return localEndPoint.host;
    }
    return "";
  }
  
  String getLastUsedPort()
  {
    EndPoint localEndPoint = this.engine.mConnManager.lastEndPoint;
    if (localEndPoint != null) {
      return String.valueOf(localEndPoint.port);
    }
    return "";
  }
  
  long[] getReportDataFlow()
  {
    return new long[] { this.engine.upFlow_Wifi.getAndSet(0L), this.engine.dwFlow_Wifi.getAndSet(0L), this.engine.upFlow_Xg.getAndSet(0L), this.engine.dwFlow_Xg.getAndSet(0L) };
  }
  
  public Transaction getTransactionById(int paramInt)
  {
    Object localObject1 = null;
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      Object localObject4;
      label97:
      for (;;)
      {
        try
        {
          Object localObject5 = (ArrayList)this.transQueues.get(i);
          localObject4 = localObject1;
          if (localObject5 == null) {
            break;
          }
          localObject5 = ((ArrayList)localObject5).iterator();
          localObject4 = localObject1;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject4 = (Transaction)((Iterator)localObject5).next();
          if (((Transaction)localObject4).getTransationId() != paramInt) {
            break label97;
          }
          localObject1 = localObject4;
        }
        finally {}
        return localObject1;
      }
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public int getTransactionNum()
  {
    SparseArray localSparseArray = this.transQueues;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < 3) {}
      try
      {
        if (this.transQueues.get(j) == null) {
          break label58;
        }
        i = ((ArrayList)this.transQueues.get(j)).size() + i;
      }
      finally {}
      return i;
      label58:
      j += 1;
    }
  }
  
  public boolean isNetworkConnected()
  {
    return BdhUtils.isBdhNetConnected(this.engine.getAppContext());
  }
  
  public void notifyToSend()
  {
    this.engine.mRequestWorker.notifyTransactionChange(1, null);
  }
  
  public void onDestroy()
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      if (i < 3)
      {
        try
        {
          Object localObject1 = new ArrayList();
          if (this.transQueues.get(i) == null) {
            break label122;
          }
          ((ArrayList)localObject1).addAll((Collection)this.transQueues.get(i));
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            cancelTransaction((Transaction)((Iterator)localObject1).next());
          }
          ((ArrayList)this.transQueues.get(i)).clear();
        }
        finally {}
      }
      else
      {
        this.transQueues.clear();
        this.transWaitForSessionKeyQueue = new ArrayList();
        return;
      }
      label122:
      i += 1;
    }
  }
  
  public void onGetConfig()
  {
    if ((this.engine == null) || (this.engine.currentUin == null)) {
      return;
    }
    String str1 = this.engine.currentUin;
    for (;;)
    {
      Transaction localTransaction;
      try
      {
        byte[] arrayOfByte1 = SessionInfo.getInstance(str1).getHttpconn_sig_session();
        if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0)) {
          break label297;
        }
        BdhLogUtil.LogEvent("E", "onGetConfig suc,transWaitForSessionKeyQueue size:" + this.transWaitForSessionKeyQueue.size());
        int i = arrayOfByte1.length;
        Iterator localIterator2 = this.transWaitForSessionKeyQueue.iterator();
        if (!localIterator2.hasNext()) {
          break;
        }
        localTransaction = (Transaction)localIterator2.next();
        localTransaction.ticket = new byte[i];
        System.arraycopy(arrayOfByte1, 0, localTransaction.ticket, 0, i);
        if (!localTransaction.needCryptExtendInfo) {
          break label277;
        }
        byte[] arrayOfByte2 = SessionInfo.getInstance(str1).getSessionKey();
        if ((arrayOfByte2 != null) && (arrayOfByte2.length != 0))
        {
          int j = arrayOfByte2.length;
          byte[] arrayOfByte3 = new byte[j];
          System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, j);
          localTransaction.extendInfo = new Cryptor().encrypt(localTransaction.extendInfo, arrayOfByte3);
          submitTransactionToTransQuene(localTransaction);
          continue;
        }
        BdhLogUtil.LogEvent("T", "onGetConfig,get sessionKey successfully,but task has mSigSession, not has mSessionKey, transaction path:" + localTransaction.filePath);
      }
      finally {}
      HwServlet.getConfig(this.engine.app, str2);
      localTransaction.onTransFailed(-1017, "", 0, 0, 0, null);
      continue;
      label277:
      submitTransactionToTransQuene(localTransaction);
    }
    this.transWaitForSessionKeyQueue.clear();
    for (;;)
    {
      return;
      label297:
      BdhLogUtil.LogEvent("E", "onGetConfig failed,transWaitForSessionKeyQueue size:" + this.transWaitForSessionKeyQueue.size());
      Iterator localIterator1 = this.transWaitForSessionKeyQueue.iterator();
      while (localIterator1.hasNext()) {
        ((Transaction)localIterator1.next()).onTransFailed(-1016, "", 0, 0, 0, null);
      }
    }
  }
  
  public void onInit()
  {
    localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        ArrayList localArrayList = new ArrayList();
        this.transQueues.put(i, localArrayList);
        i += 1;
      }
      finally {}
    }
  }
  
  public void onTransactionFinish(boolean paramBoolean, Transaction paramTransaction)
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        if (this.transQueues.get(i) == null) {
          break label72;
        }
        ((ArrayList)this.transQueues.get(i)).remove(paramTransaction);
      }
      finally {}
      if (!paramBoolean) {
        this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
      }
      return;
      label72:
      i += 1;
    }
  }
  
  public DataTransInfo pullNextSegment(SparseArray<HwNetSegConf> paramSparseArray)
  {
    Object localObject1 = null;
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < round_array.length)
        {
          Object localObject2 = (ArrayList)this.transQueues.get(round_array[this.index]);
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            Iterator localIterator = ((ArrayList)localObject2).iterator();
            if (localIterator.hasNext())
            {
              localObject2 = (Transaction)localIterator.next();
              HwNetSegConf localHwNetSegConf = (HwNetSegConf)paramSparseArray.get(((Transaction)localObject2).getBuzType());
              if (localHwNetSegConf == null) {
                paramSparseArray.get(0);
              }
              localObject2 = ((Transaction)localObject2).peekNextSegment(localHwNetSegConf);
              if (localObject2 == null) {
                continue;
              }
              BdhLogUtil.LogEvent("R", "pullNextSegment : T_Id:" + ((DataTransInfo)localObject2).parent.getTransationId() + " ConfSegNum:" + localHwNetSegConf.segNum + " ConfSegSize:" + localHwNetSegConf.segSize);
              localObject1 = localObject2;
              label186:
              if (this.index >= round_array.length - 1)
              {
                this.index = 0;
                break label244;
                label207:
                return localObject1;
              }
              else
              {
                this.index += 1;
              }
            }
          }
        }
      }
      finally {}
      label244:
      do
      {
        i += 1;
        break;
        break label186;
        break label207;
      } while (localObject1 == null);
    }
  }
  
  public void resumeTransaction(Transaction paramTransaction)
  {
    paramTransaction.setPause(false);
    this.engine.mRequestWorker.notifyTransactionChange(1, paramTransaction);
  }
  
  boolean startNetDetection(ProbeCallback paramProbeCallback)
  {
    try
    {
      Object localObject = this.engine.mConnManager.lastEndPoint;
      if (localObject != null)
      {
        ProbeChain localProbeChain = new ProbeChain();
        localProbeChain.addProbeItem(new LoginWifiProbe());
        localProbeChain.addProbeItem(new MtuProbe());
        localProbeChain.addProbeItem(new EchoProbe());
        localProbeChain.addProbeItem(new TracerouteProbe());
        localObject = new ProbeRequest(((EndPoint)localObject).host, localProbeChain);
        boolean bool = this.engine.mWeakNetLearner.startProbe(new ProbeTask((ProbeRequest)localObject, paramProbeCallback));
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramProbeCallback) {}
    return false;
  }
  
  void startTransRunnable(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    RequestWorker.RequestHandler localRequestHandler = this.engine.mRequestWorker.mRequestHandler;
    if (localRequestHandler != null)
    {
      if (paramRunnable1 != null) {
        localRequestHandler.removeCallbacks(paramRunnable1);
      }
      localRequestHandler.postDelayed(paramRunnable2, 600000L);
    }
  }
  
  void stopTransRunnable(Runnable paramRunnable)
  {
    RequestWorker.RequestHandler localRequestHandler = this.engine.mRequestWorker.mRequestHandler;
    if (localRequestHandler != null) {
      localRequestHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void stopTransaction(Transaction paramTransaction)
  {
    paramTransaction.setPause(true);
    this.engine.mRequestWorker.notifyTransactionChange(2, paramTransaction);
  }
  
  public int submitTransation(Transaction paramTransaction)
  {
    int i;
    if ((paramTransaction == null) || (paramTransaction.filePath == null) || (paramTransaction.transationId != -1))
    {
      i = 9042;
      return i;
    }
    if (this.engine.mConnManager.getCurrentConnNum() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      int j = paramTransaction.initSegmentList(this, bool);
      i = j;
      if (j != 0) {
        break;
      }
      if (paramTransaction.ticket == null) {
        break label75;
      }
      submitTransactionToTransQuene(paramTransaction);
      return j;
    }
    label75:
    return submitTransactionToWaitForSessionKeyQuene(paramTransaction);
  }
  
  public void switchToBackupChannel()
  {
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    while (i < 3) {
      try
      {
        if (this.transQueues.get(i) != null)
        {
          Object localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll((Collection)this.transQueues.get(i));
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Transaction localTransaction = (Transaction)((Iterator)localObject1).next();
            cancelTransaction(localTransaction);
            localTransaction.onSwitchToBackupChannel();
          }
        }
        i += 1;
      }
      finally {}
    }
  }
  
  boolean updateAndCheckNet()
  {
    HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
    return HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType() != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.TransactionWorker
 * JD-Core Version:    0.7.0.1
 */