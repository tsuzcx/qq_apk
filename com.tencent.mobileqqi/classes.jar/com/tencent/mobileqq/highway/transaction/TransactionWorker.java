package com.tencent.mobileqq.highway.transaction;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
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
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.segment.RequestWorker.RequestHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionWorker
  implements IHwManager
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
  private volatile int index = 0;
  private SparseArray<ArrayList<Transaction>> transQueues = new SparseArray();
  
  public TransactionWorker(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
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
      try
      {
        Object localObject5 = (ArrayList)this.transQueues.get(i);
        localObject4 = localObject1;
        if (localObject5 != null)
        {
          localObject5 = ((ArrayList)localObject5).iterator();
          for (;;)
          {
            localObject4 = localObject1;
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            localObject4 = (Transaction)((Iterator)localObject5).next();
            if (((Transaction)localObject4).getTransationId() == paramInt) {
              localObject1 = localObject4;
            }
          }
          return localObject1;
        }
      }
      finally {}
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public int getTransactionNum()
  {
    int j = 0;
    SparseArray localSparseArray = this.transQueues;
    int i = 0;
    for (;;)
    {
      int k;
      if (i < 3) {
        k = j;
      }
      try
      {
        if (this.transQueues.get(i) == null) {
          break label64;
        }
        k = j + ((ArrayList)this.transQueues.get(i)).size();
      }
      finally {}
      return j;
      label64:
      i += 1;
      j = k;
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
            break label111;
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
        return;
      }
      label111:
      i += 1;
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
    Object localObject2 = localObject1;
    for (;;)
    {
      try
      {
        if (i < round_array.length)
        {
          Object localObject3 = (ArrayList)this.transQueues.get(round_array[this.index]);
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (((ArrayList)localObject3).size() > 0)
            {
              localObject3 = ((ArrayList)localObject3).iterator();
              localObject2 = localObject1;
              if (((Iterator)localObject3).hasNext())
              {
                localObject2 = (Transaction)((Iterator)localObject3).next();
                HwNetSegConf localHwNetSegConf = (HwNetSegConf)paramSparseArray.get(((Transaction)localObject2).getBuzType());
                if (localHwNetSegConf == null) {
                  paramSparseArray.get(0);
                }
                localObject2 = ((Transaction)localObject2).peekNextSegment(localHwNetSegConf);
                if (localObject2 == null) {
                  continue;
                }
              }
            }
          }
          if (this.index >= round_array.length - 1)
          {
            this.index = 0;
            break label180;
          }
        }
        else
        {
          return localObject2;
        }
        this.index += 1;
      }
      finally {}
      label180:
      i += 1;
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
    }
  }
  
  public void queryTransaction(Transaction paramTransaction, byte[] paramArrayOfByte)
  {
    this.engine.mRequestWorker.sendInfoQueryRequest(paramTransaction, paramArrayOfByte);
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
    boolean bool;
    if (this.engine.mConnManager.getCurrentConnNum() > 0) {
      bool = true;
    }
    for (;;)
    {
      int j = paramTransaction.initSegmentList(this, bool);
      i = j;
      if (j != 0) {
        break;
      }
      paramTransaction.transationId = seqFactory.incrementAndGet();
      BdhLogUtil.LogEvent("T", "SubmitTransation : T_Id:" + paramTransaction.transationId + " ukey:" + String.valueOf(paramTransaction.ticket));
      synchronized (this.transQueues)
      {
        if (this.transQueues.get(0) != null)
        {
          ((ArrayList)this.transQueues.get(0)).add(paramTransaction);
          BdhLogUtil.LogEvent("T", "SubmitTransation : T_Id:" + paramTransaction.transationId + " : add to queue[ " + 0 + "]");
        }
        notifyToSend();
        return j;
        bool = false;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.TransactionWorker
 * JD-Core Version:    0.7.0.1
 */