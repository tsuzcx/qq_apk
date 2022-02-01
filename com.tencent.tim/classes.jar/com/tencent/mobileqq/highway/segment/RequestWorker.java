package com.tencent.mobileqq.highway.segment;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.conn.IConnection;
import com.tencent.mobileqq.highway.conn.TcpConnection;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class RequestWorker
  implements IHwManager
{
  public static final int PRIORITY_NUM = 3;
  public static final int REQ_PRIORITY_DATA = 2;
  public static final int REQ_PRIORITY_HEART = 0;
  public static final int REQ_PRIORITY_QUERY = 1;
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  HwEngine engine;
  public volatile int mCurrentRequests;
  private HandlerThread mHandlerThread;
  public RequestHandler mRequestHandler;
  private AtomicBoolean mWorking = new AtomicBoolean(false);
  private SparseArray<List<HwRequest>> priorityList = new SparseArray();
  private ConcurrentHashMap<Integer, HwRequest> sendUrgentHB = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, HwRequest> sentRequests = new ConcurrentHashMap();
  
  public RequestWorker(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void addHwRequest(HwRequest paramHwRequest)
  {
    int i = 2;
    int j = paramHwRequest.getPriority();
    if (j + 0 > 3) {}
    for (;;)
    {
      synchronized (this.priorityList)
      {
        paramHwRequest.status.set(2);
        ((List)this.priorityList.get(i)).add(paramHwRequest);
        if (paramHwRequest.getPriority() > 0) {
          this.mCurrentRequests += 1;
        }
        return;
      }
      i = j;
    }
  }
  
  private void cancelAllRequest()
  {
    ??? = this.priorityList;
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      Iterator localIterator;
      try
      {
        ((List)this.priorityList.get(i)).clear();
        i += 1;
      }
      finally {}
    }
    synchronized (this.sentRequests)
    {
      localIterator = this.sentRequests.values().iterator();
      if (localIterator.hasNext()) {
        ((HwRequest)localIterator.next()).isCancel.set(true);
      }
    }
    this.sentRequests.clear();
    this.sendUrgentHB.clear();
  }
  
  private void cancelRequestByTrans(Transaction paramTransaction)
  {
    Object localObject2 = new ArrayList();
    Object localObject3;
    synchronized (this.priorityList)
    {
      localObject3 = (List)this.priorityList.get(2);
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        HwRequest localHwRequest = (HwRequest)localIterator.next();
        if (localHwRequest.transId == paramTransaction.getTransationId())
        {
          localHwRequest.isCancel.set(true);
          localHwRequest.onCancle();
          ((ArrayList)localObject2).add(localHwRequest);
        }
      }
    }
    ((List)localObject3).removeAll((Collection)localObject2);
    ((ArrayList)localObject2).clear();
    synchronized (this.sentRequests)
    {
      localObject2 = this.sentRequests.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HwRequest)((Iterator)localObject2).next();
        if ((((HwRequest)localObject3).transId == paramTransaction.getTransationId()) && (((HwRequest)localObject3).getPriority() == 2))
        {
          ((HwRequest)localObject3).isCancel.set(true);
          ((HwRequest)localObject3).onCancle();
        }
      }
    }
  }
  
  private void doQuit()
  {
    cancelAllRequest();
    this.mRequestHandler = null;
    this.mHandlerThread.quit();
  }
  
  public static int getNextSeq()
  {
    try
    {
      int i = seqFactory.incrementAndGet();
      if (i > 1000000) {
        seqFactory.set(new Random().nextInt(1060000));
      }
      return i;
    }
    finally {}
  }
  
  private void handleConnClosed(int paramInt)
  {
    ArrayList localArrayList;
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      synchronized (this.sentRequests)
      {
        SparseArray localSparseArray = new SparseArray();
        localArrayList = new ArrayList();
        localObject2 = this.sentRequests.values().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (HwRequest)((Iterator)localObject2).next();
        if ((((HwRequest)localObject3).isCancel.get()) || (((HwRequest)localObject3).sendConnId != paramInt)) {
          continue;
        }
        localObject4 = (IConnection)this.engine.mConnManager.connections.get(Integer.valueOf(paramInt));
        if (((HwRequest)localObject3).hwCmd.equalsIgnoreCase("PicUp.Echo"))
        {
          ((HwRequest)localObject3).isCancel.set(true);
          ((HwRequest)localObject3).reqListener.handleError(-1003, "ConnClose", (IConnection)localObject4);
        }
      }
      if (((HwRequest)localObject3).hwCmd.equalsIgnoreCase("PicUp.QueryOffset"))
      {
        ((HwRequest)localObject3).reqListener.handleError(-1003, "ConnClose", (IConnection)localObject4);
      }
      else if ((localObject3 instanceof RequestFilter))
      {
        if (((HwRequest)localObject3).retryCount > 1)
        {
          this.sentRequests.remove(Integer.valueOf(((HwRequest)localObject3).getHwSeq()));
          ((HwRequest)localObject3).onError(-1003);
          return;
        }
        ((HwRequest)localObject3).reqListener.handleError(-1003, "ConnClose", (IConnection)localObject4);
      }
      else if ((((HwRequest)localObject3).hwCmd.equalsIgnoreCase("PicUp.DataUp")) && (!((HwRequest)localObject3).isCancel.get()) && (((HwRequest)localObject3).status.get() == 3))
      {
        localObject4 = this.engine.mTransWorker.getTransactionById(((HwRequest)localObject3).transId);
        if (localObject4 != null) {
          localObject1.put(((Transaction)localObject4).getTransationId(), localObject4);
        }
        localArrayList.add(localObject3);
      }
    }
    Object localObject2 = localArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (HwRequest)((Iterator)localObject2).next();
      ((HwRequest)localObject3).isCancel.set(true);
      this.sentRequests.remove(Integer.valueOf(((HwRequest)localObject3).getHwSeq()));
    }
    int k = localObject1.size();
    int i = 0;
    if (i < k)
    {
      localObject2 = (Transaction)localObject1.valueAt(i);
      localObject3 = new byte[((Transaction)localObject2).bitmap.length];
      localObject4 = localArrayList.iterator();
    }
    for (;;)
    {
      int j;
      int m;
      if (((Iterator)localObject4).hasNext())
      {
        HwRequest localHwRequest = (HwRequest)((Iterator)localObject4).next();
        if (localHwRequest.transId != ((Transaction)localObject2).getTransationId()) {
          continue;
        }
        RequestDataTrans localRequestDataTrans = (RequestDataTrans)localHwRequest;
        j = localRequestDataTrans.mInfo.bitmapS;
        m = localRequestDataTrans.mInfo.bitmapE;
        BdhLogUtil.LogEvent("R", "QueryDebug Waiting Resp : " + localHwRequest.dumpBaseInfo());
      }
      else
      {
        BdhLogUtil.LogEvent("R", "QueryDebug Before Query : TransId:" + ((Transaction)localObject2).getTransationId() + " CopyBitmap:" + Arrays.toString((byte[])localObject3) + " CurrentBitmap:" + Arrays.toString(((Transaction)localObject2).bitmap));
        sendInfoQueryRequest((Transaction)localObject2, (byte[])localObject3);
        i += 1;
        break;
        if ((k == 0) && (this.engine.mTransWorker.getTransactionNum() > 0)) {
          this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
        }
        this.sendUrgentHB.remove(Integer.valueOf(paramInt));
        return;
      }
      while (j <= m)
      {
        localObject3[j] = 2;
        j += 1;
      }
    }
  }
  
  private void handleResp(List<HwResponse> paramList)
  {
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      HwResponse localHwResponse = (HwResponse)localIterator.next();
      HwRequest localHwRequest = (HwRequest)this.sentRequests.get(Integer.valueOf(localHwResponse.hwSeq));
      Object localObject = new StringBuilder().append("HandleResp : Resp.hwSeq:").append(localHwResponse.hwSeq).append(" SegmentResp:").append(localHwResponse.segmentResp).append(" FIN:");
      if (localHwResponse.segmentResp != null)
      {
        paramList = Integer.valueOf(localHwResponse.segmentResp.uint32_flag.get());
        label112:
        BdhLogUtil.LogEvent("R", paramList);
        paramList = localHwRequest;
        if (localHwRequest == null)
        {
          localObject = this.engine.mTransWorker.getTransactionById(localHwResponse.mTransId);
          paramList = localHwRequest;
          if (localObject != null)
          {
            localHwRequest = (HwRequest)((Transaction)localObject).getRetryRequests().get(Integer.valueOf(localHwResponse.hwSeq));
            paramList = localHwRequest;
            if (localHwRequest != null)
            {
              localObject = new StringBuilder().append("HandleRetryRequestsResp : Resp.hwSeq:").append(localHwResponse.hwSeq).append(" SegmentResp:").append(localHwResponse.segmentResp).append(" FIN:");
              if (localHwResponse.segmentResp == null) {
                break label298;
              }
            }
          }
        }
      }
      label298:
      for (paramList = Integer.valueOf(localHwResponse.segmentResp.uint32_flag.get());; paramList = "null")
      {
        BdhLogUtil.LogEvent("R", paramList);
        paramList = localHwRequest;
        if ((paramList == null) || (paramList.reqListener == null)) {
          break;
        }
        paramList.reqListener.handleResponse(localHwResponse);
        break;
        paramList = "null";
        break label112;
      }
    }
    prepareRequests();
  }
  
  private void prepareRequests()
  {
    Object localObject = this.engine.getCurrentConfig();
    int i = ((List)this.priorityList.get(2)).size();
    i = this.sentRequests.size() + i;
    long l = ((HwNetSegConf)localObject).segNum;
    int j;
    if (l > 8L)
    {
      QLog.i("BDH_LOG", 1, "seg num beyond default,value :" + l);
      l = 8L;
      j = 0;
    }
    for (;;)
    {
      if (i < l)
      {
        localObject = this.engine.mTransWorker.pullNextSegment(this.engine.getCurrentBuzConfigs());
        if (localObject != null)
        {
          RequestDataTrans localRequestDataTrans = new RequestDataTrans(((DataTransInfo)localObject).parent.peerUin, "PicUp.DataUp", ((DataTransInfo)localObject).parent.mBuzCmdId, (DataTransInfo)localObject, ((DataTransInfo)localObject).parent.ticket, ((DataTransInfo)localObject).parent.getTransationId(), 30000L);
          addHwRequest(localRequestDataTrans);
          i += 1;
          ((DataTransInfo)localObject).parent.TRACKER.logStep("QUEUE", " SLICEINFO Start:" + ((DataTransInfo)localObject).bitmapS + " End:" + ((DataTransInfo)localObject).bitmapE + " Seq:" + localRequestDataTrans.getHwSeq());
          BdhLogUtil.LogEvent("R", "PrepareRequests : T_Id:" + ((DataTransInfo)localObject).parent.getTransationId() + " Offset:" + ((DataTransInfo)localObject).offset + " Len:" + ((DataTransInfo)localObject).length + " HwSeq:" + localRequestDataTrans.getHwSeq() + " Status:" + localRequestDataTrans.status.get() + " dataSize:" + i);
          j = 1;
          continue;
        }
      }
      if (j != 0) {
        this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
      }
      return;
      j = 0;
    }
  }
  
  public void cancelAckRequest(HwRequest paramHwRequest)
  {
    paramHwRequest.isCancel.set(true);
    paramHwRequest.onCancle();
    synchronized (this.priorityList)
    {
      ((List)this.priorityList.get(2)).remove(paramHwRequest);
    }
    synchronized (this.sentRequests)
    {
      this.sentRequests.remove(paramHwRequest);
      return;
      paramHwRequest = finally;
      throw paramHwRequest;
    }
  }
  
  public HwRequest getMaxPriorityRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    if (!this.mWorking.get()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.sentRequests)
    {
      localObject6 = this.sentRequests.values().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (HwRequest)((Iterator)localObject6).next();
        if (((HwRequest)localObject7).isCancel.get()) {
          localArrayList.add(Integer.valueOf(((HwRequest)localObject7).getHwSeq()));
        }
      }
    }
    Object localObject5 = localObject4.iterator();
    while (((Iterator)localObject5).hasNext())
    {
      i = ((Integer)((Iterator)localObject5).next()).intValue();
      this.sentRequests.remove(Integer.valueOf(i));
    }
    ??? = null;
    Object localObject7 = new ArrayList();
    Object localObject6 = this.priorityList;
    int i = 0;
    localObject5 = ???;
    List localList;
    label313:
    Object localObject3;
    if (i <= paramInt2)
    {
      try
      {
        localList = (List)this.priorityList.get(i);
        localObject5 = ???;
        if (localList.size() == 0) {
          break label585;
        }
        if (i == 0) {
          break label408;
        }
        ??? = (HwRequest)localList.remove(0);
        if (((HwRequest)???).status.get() == 3)
        {
          localObject5 = ???;
          break label585;
        }
        localObject5 = ???;
        if (!(??? instanceof RequestDataTrans)) {
          break label575;
        }
        localObject5 = ???;
        if (BdhSegTimeoutUtil.sEnableDynTimeout != 1) {
          break label575;
        }
        paramLong1 = BdhSegTimeoutUtil.calculateTimeout(this.engine.getAppContext(), (RequestDataTrans)???, paramLong2, paramInt3, paramLong1);
        if (paramLong1 <= 1000L) {
          break label598;
        }
        ((HwRequest)???).timeOut = paramLong1;
      }
      finally {}
      if (??? != null)
      {
        if (((HwRequest)???).getPriority() > 0) {
          this.mCurrentRequests -= 1;
        }
        ((HwRequest)???).updateStaus(3);
        this.sentRequests.put(Integer.valueOf(((HwRequest)???).getHwSeq()), ???);
        if (((HwRequest)???).reqListener == null) {
          ((HwRequest)???).reqListener = new RequestListener((HwRequest)???);
        }
        ((HwRequest)???).reqListener.handleSendBegin(paramInt1);
      }
      return ???;
      label408:
      Iterator localIterator = localList.iterator();
      do
      {
        for (;;)
        {
          localObject5 = localObject2;
          if (!localIterator.hasNext()) {
            break label547;
          }
          localObject5 = (HwRequest)localIterator.next();
          if (this.engine.mConnManager.connections.containsKey(Integer.valueOf(((RequestHeartBreak)localObject5).connId))) {
            break;
          }
          ((ArrayList)localObject7).add(localObject5);
        }
      } while (((RequestHeartBreak)localObject5).connId != paramInt1);
      if (!(localObject5 instanceof RequestHeartBreak)) {
        break label582;
      }
      localObject3 = (RequestHeartBreak)localObject5;
      if (!((RequestHeartBreak)localObject3).isUrgent) {
        break label601;
      }
      long l = BdhSegTimeoutUtil.getUrgentHbTimeout(this.engine.getAppContext());
      if (l <= 1000L) {
        break label601;
      }
      ((RequestHeartBreak)localObject3).timeOut = l;
      break label601;
    }
    label547:
    label575:
    label582:
    label585:
    label598:
    label601:
    for (;;)
    {
      if (localObject5 != null) {
        localList.remove(localObject5);
      }
      localList.removeAll((Collection)localObject7);
      break label585;
      localObject3 = localObject5;
      break label313;
      continue;
      i += 1;
      localObject3 = localObject5;
      break;
      break label313;
    }
  }
  
  public void notifyTransactionChange(int paramInt, Transaction paramTransaction)
  {
    Object localObject = this.mRequestHandler;
    if ((!this.mWorking.get()) || (localObject == null)) {}
    do
    {
      return;
      if (paramInt == 1)
      {
        ((RequestHandler)localObject).sendEmptyMessage(1);
        return;
      }
    } while (paramInt != 2);
    localObject = Message.obtain(this.mRequestHandler);
    ((Message)localObject).what = 3;
    ((Message)localObject).obj = paramTransaction;
    ((Message)localObject).sendToTarget();
  }
  
  public void onConnClose(int paramInt)
  {
    RequestHandler localRequestHandler = this.mRequestHandler;
    if ((!this.mWorking.get()) || (localRequestHandler == null)) {
      return;
    }
    localRequestHandler.post(new RequestWorker.1(this, paramInt));
  }
  
  public void onConnConnected(int paramInt) {}
  
  public void onConnIdle(int paramInt) {}
  
  public void onDestroy()
  {
    if ((this.mWorking.compareAndSet(true, false)) && (this.mRequestHandler != null)) {
      this.mRequestHandler.sendEmptyMessage(2);
    }
  }
  
  public void onInit()
  {
    int i = 0;
    while (i < 3)
    {
      LinkedList localLinkedList = new LinkedList();
      this.priorityList.put(i, localLinkedList);
      i += 1;
    }
    this.mHandlerThread = new HandlerThread("Highway-BDH-REQ", 5);
    this.mHandlerThread.start();
    this.mRequestHandler = new RequestHandler(this.mHandlerThread.getLooper());
    this.mWorking.set(true);
  }
  
  public void onNetworkChanged(boolean paramBoolean)
  {
    BdhLogUtil.LogEvent("N", "RequestWorker onNetworkChanged : about to clear the request - hasNetwork:" + paramBoolean);
    RequestHandler localRequestHandler = this.mRequestHandler;
    if ((!paramBoolean) || (!this.mWorking.get()) || (localRequestHandler == null)) {
      return;
    }
    if ((!this.sentRequests.isEmpty()) || (this.mCurrentRequests != 0))
    {
      sendConnectRequest(0L, false);
      return;
    }
    localRequestHandler.obtainMessage(1).sendToTarget();
  }
  
  public void onReceiveResp(List<HwResponse> paramList)
  {
    if (!this.mWorking.get()) {
      return;
    }
    handleResp(paramList);
  }
  
  public void remove2SENDRequest(int paramInt1, int paramInt2)
  {
    List localList = (List)this.priorityList.get(2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      HwRequest localHwRequest = (HwRequest)localIterator.next();
      if (localHwRequest.transId == paramInt1)
      {
        RequestDataTrans localRequestDataTrans = (RequestDataTrans)localHwRequest;
        if ((localRequestDataTrans.mInfo.bitmapE <= paramInt2) && (localRequestDataTrans.status.get() == 2)) {
          localList.remove(localHwRequest.getHwSeq());
        }
      }
    }
  }
  
  public void sendAckRequest(HwRequest paramHwRequest)
  {
    addHwRequest(paramHwRequest);
    this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
  }
  
  public void sendConnectRequest(long paramLong, boolean paramBoolean)
  {
    int i = 5;
    RequestHandler localRequestHandler = this.mRequestHandler;
    if ((!this.mWorking.get()) || (localRequestHandler == null)) {
      return;
    }
    if (paramLong > 0L)
    {
      if (paramBoolean) {}
      for (;;)
      {
        localRequestHandler.sendMessageDelayed(localRequestHandler.obtainMessage(i), paramLong);
        return;
        i = 4;
      }
    }
    if (paramBoolean) {}
    for (;;)
    {
      localRequestHandler.obtainMessage(i).sendToTarget();
      return;
      i = 4;
    }
  }
  
  public void sendFinishQueryRequest(Transaction paramTransaction, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new RequestFinishQuery(paramTransaction.peerUin, "PicUp.QueryOffset", paramTransaction.mBuzCmdId, paramTransaction.ticket, paramTransaction, 30000L, paramArrayOfByte);
    paramTransaction.mCurrentQueryFinishCount += 1;
    paramArrayOfByte.mQueryHoleFinishIndex = paramInt;
    addHwRequest(paramArrayOfByte);
    BdhLogUtil.LogEvent("R", "sendFinishQueryRequest : " + paramArrayOfByte.dumpBaseInfo() + " size:" + this.mCurrentRequests + " queryIndex:" + paramArrayOfByte.mQueryHoleFinishIndex);
    this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
  }
  
  public void sendHeartBreak(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    RequestHandler localRequestHandler = this.mRequestHandler;
    if ((!this.mWorking.get()) || (localRequestHandler == null)) {
      return;
    }
    Object localObject = new RequestHeartBreak(this.engine.currentUin, "PicUp.Echo", 0, 30000L, paramInt1, paramBoolean1);
    Runnable localRunnable = (Runnable)this.engine.mConnManager.heartBreaks.remove(Integer.valueOf(paramInt1));
    if ((paramBoolean2) && (localRunnable != null)) {
      localRequestHandler.removeCallbacks(localRunnable);
    }
    if (paramInt2 == 0)
    {
      addHwRequest((HwRequest)localObject);
      if (paramBoolean1) {
        this.sendUrgentHB.put(Integer.valueOf(paramInt1), localObject);
      }
      BdhLogUtil.LogEvent("N", "SendHeartBreak : " + ((HwRequest)localObject).dumpBaseInfo() + " size:" + this.mCurrentRequests + " delay:" + paramInt2);
      this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
      return;
    }
    localObject = new RequestWorker.2(this, paramInt1, (HwRequest)localObject, paramInt2);
    localRequestHandler.postDelayed((Runnable)localObject, paramInt2);
    this.engine.mConnManager.heartBreaks.put(Integer.valueOf(paramInt1), localObject);
  }
  
  public void sendInfoQueryFinish(Transaction paramTransaction, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt == 0)
    {
      sendFinishQueryRequest(paramTransaction, paramArrayOfByte, paramInt);
      return;
    }
    paramTransaction = new RequestWorker.3(this, paramTransaction, paramArrayOfByte, paramInt);
    this.mRequestHandler.postDelayed(paramTransaction, RequestFinishQuery.QUERY_HOLE_INTERVAL);
  }
  
  public void sendInfoQueryRequest(Transaction paramTransaction, byte[] paramArrayOfByte)
  {
    paramTransaction = new RequestInfoQuery(paramTransaction.peerUin, "PicUp.QueryOffset", paramTransaction.mBuzCmdId, paramTransaction.ticket, paramTransaction, 30000L, paramArrayOfByte);
    addHwRequest(paramTransaction);
    BdhLogUtil.LogEvent("R", "SendInfoQueryRequest : " + paramTransaction.dumpBaseInfo() + " size:" + this.mCurrentRequests);
    this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
  }
  
  public class RequestHandler
    extends Handler
  {
    public static final int CANCEL = 3;
    public static final int CONN = 4;
    public static final int PRECONN = 5;
    public static final int QUIT = 2;
    public static final int SEND = 1;
    
    public RequestHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i == 1) {
        RequestWorker.this.prepareRequests();
      }
      do
      {
        return;
        if (i == 3)
        {
          RequestWorker.this.cancelRequestByTrans((Transaction)paramMessage.obj);
          return;
        }
        if (i == 2)
        {
          RequestWorker.this.doQuit();
          return;
        }
        if (i == 4)
        {
          RequestWorker.this.engine.mConnManager.wakeupConnectionToWrite(RequestWorker.this.mCurrentRequests, false);
          return;
        }
      } while (i != 5);
      RequestWorker.this.engine.mConnManager.wakeupConnectionToWrite(RequestWorker.this.mCurrentRequests, true);
    }
  }
  
  class RequestListener
    implements IRequestListener
  {
    private Runnable netDetectTimer;
    private final HwRequest req;
    private Runnable reqTimeoutTimer;
    private Runnable writeTimeoutTimer;
    
    public RequestListener(HwRequest paramHwRequest)
    {
      this.req = paramHwRequest;
      this.netDetectTimer = new RequestWorker.RequestListener.1(this, RequestWorker.this, paramHwRequest);
      this.reqTimeoutTimer = new RequestWorker.RequestListener.2(this, RequestWorker.this);
      this.writeTimeoutTimer = new RequestWorker.RequestListener.3(this, RequestWorker.this);
    }
    
    private void recordConnInfo(HwRequest paramHwRequest, long paramLong)
    {
      int i = 0;
      Object localObject = ((RequestDataTrans)paramHwRequest).mInfo;
      if (localObject != null) {
        i = ((DataTransInfo)localObject).length;
      }
      if ((RequestWorker.this.engine != null) && (RequestWorker.this.engine.mConnManager != null))
      {
        localObject = (IConnection)RequestWorker.this.engine.mConnManager.connections.get(Integer.valueOf(paramHwRequest.sendConnId));
        if ((localObject != null) && (((IConnection)localObject).getProtoType() == 1))
        {
          localObject = (TcpConnection)localObject;
          ((TcpConnection)localObject).mLastDataSegSize = i;
          ((TcpConnection)localObject).mLastDataTransTime = paramLong;
          BdhLogUtil.LogEvent("R", "recordConnInfo: conId = " + paramHwRequest.sendConnId + " record con.mLastDataTransTime = " + paramLong + " con.mLastDataSegSize = " + i);
        }
      }
    }
    
    private void scheduleRetry(int paramInt, long paramLong)
    {
      if ((!RequestWorker.this.mWorking.get()) || (this.req.isCancel.get()) || (RequestWorker.this.mRequestHandler == null)) {
        return;
      }
      this.req.lastSendStartTime = SystemClock.uptimeMillis();
      if (HwNetworkCenter.getInstance(RequestWorker.this.engine.getAppContext()).getNetType() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        if ((this.req instanceof RequestDataTrans))
        {
          localObject = RequestWorker.this.engine.mTransWorker.getTransactionById(this.req.transId);
          if (localObject != null) {
            ((Transaction)localObject).getRetryRequests().put(Integer.valueOf(this.req.getHwSeq()), this.req);
          }
        }
        BdhLogUtil.LogEvent("R", "conId:" + this.req.sendConnId + " ScheduleRetry : " + this.req.getHwSeq() + " retry:" + this.req.retryCount + " delay:" + paramLong + " hasNet:" + bool + " sentRequestsRetry.size()");
        if (!bool) {
          break label299;
        }
        Object localObject = this.req;
        ((HwRequest)localObject).retryCount += 1;
        this.req.onRetry(paramInt);
        if (paramLong == 0L) {
          break;
        }
        RequestWorker.this.mRequestHandler.postDelayed(new RequestWorker.RequestListener.4(this), paramLong);
        return;
      }
      RequestWorker.this.engine.mConnManager.wakeupConnectionToWrite(RequestWorker.this.mCurrentRequests, false);
      return;
      label299:
      RequestWorker.this.mRequestHandler.postDelayed(this.netDetectTimer, paramLong);
    }
    
    public void handleConnClosed() {}
    
    public void handleError(int paramInt, String paramString, IConnection paramIConnection)
    {
      if (!(this.req instanceof RequestAck)) {
        this.req.onError(paramInt);
      }
      boolean bool1 = true;
      if (HwNetworkCenter.getInstance(RequestWorker.this.engine.getAppContext()).getNetType() != 0L) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        RequestWorker.this.mRequestHandler.removeCallbacks(this.reqTimeoutTimer);
        BdhLogUtil.LogEvent("R", "conId:" + this.req.sendConnId + " HandleError : Seq:" + this.req.getHwSeq() + " ErrCode:" + paramInt + " HasNet:" + bool2);
        if (!this.req.isCancel.get()) {
          break;
        }
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.req.lastSendStartTime;
      Object localObject1 = this.req;
      ((HwRequest)localObject1).timeComsume = (l1 - l2 + ((HwRequest)localObject1).timeComsume);
      int i = paramInt;
      if (paramInt == -1004)
      {
        if (this.req.hwCmd.equalsIgnoreCase("PicUp.DataUp")) {
          paramInt = ((RequestDataTrans)this.req).mInfo.errno;
        }
        bool1 = false;
        i = paramInt;
      }
      Object localObject2;
      label336:
      Object localObject3;
      boolean bool3;
      label469:
      int j;
      if ((bool2) && (i != -1000))
      {
        localObject1 = this.req;
        ((HwRequest)localObject1).continueErrCount += 1;
        if (i == -1003)
        {
          localObject1 = null;
          if (this.req.endpoint != null) {
            localObject1 = this.req.endpoint.host;
          }
          if ((this.req.lastUseAddress != null) && (this.req.lastUseAddress.equalsIgnoreCase((String)localObject1)))
          {
            localObject2 = this.req;
            ((HwRequest)localObject2).continueConnClose += 1;
            this.req.lastUseAddress = ((String)localObject1);
            if (this.req.continueConnClose >= 3)
            {
              BdhLogUtil.LogEvent("C", "ContinueConnClose exceed the ContinueConnClosedLimitation. Host : " + (String)localObject1 + " retryCount:" + this.req.retryCount);
              localObject2 = ConfigManager.getInstance(RequestWorker.this.engine.getAppContext(), RequestWorker.this.engine);
              if (localObject2 != null)
              {
                localObject3 = RequestWorker.this.engine.getAppContext();
                AppRuntime localAppRuntime = RequestWorker.this.engine.app;
                String str = RequestWorker.this.engine.currentUin;
                if (paramIConnection != null) {
                  break label781;
                }
                bool3 = false;
                ((ConfigManager)localObject2).onSrvAddrUnavailable((Context)localObject3, localAppRuntime, str, (String)localObject1, 9, bool3);
              }
              localObject1 = RequestWorker.this.engine.mTransWorker.getTransactionById(this.req.transId);
              if (localObject1 != null) {
                ((Transaction)localObject1).onRequestFailed(i);
              }
            }
            label520:
            if (this.req.timeComsume < 600000L) {
              break label817;
            }
            paramInt = 1;
            label536:
            if (this.req.continueErrCount < 10) {
              break label822;
            }
            j = 1;
            label551:
            localObject1 = null;
            if (!(this.req instanceof RequestAck))
            {
              localObject2 = RequestWorker.this.engine.mTransWorker.getTransactionById(this.req.transId);
              if (localObject2 != null)
              {
                localObject3 = ((Transaction)localObject2).mTransReport;
                if (this.req.protoType != 1) {
                  break label828;
                }
              }
            }
          }
        }
      }
      label781:
      label817:
      label822:
      label828:
      for (localObject1 = "TCP";; localObject1 = "HTTP")
      {
        ((TransReport)localObject3).protoType = ((String)localObject1);
        if (this.req.endpoint != null)
        {
          ((Transaction)localObject2).mTransReport.ipIndex = this.req.endpoint.ipIndex;
          if (paramIConnection != null) {
            ((Transaction)localObject2).mTransReport.isIpv6 = paramIConnection.isIpv6();
          }
          ((Transaction)localObject2).mTransReport.mHasIpv6List = RequestWorker.this.engine.mConnManager.mHasIpv6List;
          ((Transaction)localObject2).mTransReport.mIPv6Fast = RequestWorker.this.engine.mConnManager.isIpv6Fast();
        }
        localObject1 = localObject2;
        if ((!bool1) || (paramInt != 0) || (j != 0)) {
          break label836;
        }
        l1 = 0L;
        if (!bool2) {
          l1 = 6000L;
        }
        if ((this.req instanceof RequestHeartBreak)) {
          break;
        }
        RequestWorker.this.addHwRequest(this.req);
        scheduleRetry(i, l1);
        return;
        this.req.continueConnClose = 1;
        break label336;
        bool3 = paramIConnection.isIpv6();
        break label469;
        if (i == -1014)
        {
          bool1 = false;
          break label520;
          this.req.continueConnClose = 0;
        }
        break label520;
        paramInt = 0;
        break label536;
        j = 0;
        break label551;
      }
      label836:
      BdhLogUtil.LogEvent("R", "HandleError : Seq:" + this.req.getHwSeq() + " NotifyError :" + i + "req.timeComsume:" + this.req.timeComsume + " allowRetry:" + bool1 + " req.continueErrCount:" + this.req.continueErrCount);
      this.req.onError(i);
      if (localObject1 != null)
      {
        paramIConnection = new HwResponse();
        paramIConnection.hwSeq = this.req.getHwSeq();
        paramIConnection.errCode = i;
        if (paramInt != 0) {
          paramIConnection.errCode = -1005;
        }
        ((Transaction)localObject1).onTransFailed(paramIConnection.errCode, paramString, 0, 0, this.req.retryCount, null);
      }
      RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
    }
    
    public void handleResponse(HwResponse paramHwResponse)
    {
      Object localObject = RequestWorker.this.mRequestHandler;
      long l1 = paramHwResponse.recvTime - this.req.sendTime;
      long l2 = SystemClock.uptimeMillis();
      long l3 = paramHwResponse.recvTime;
      if ((this.req instanceof RequestDataTrans)) {
        recordConnInfo(this.req, l1);
      }
      paramHwResponse.reqCost = l1;
      paramHwResponse.switchCost = (l2 - l3);
      paramHwResponse.mBuCmdId = this.req.mBuCmdId;
      paramHwResponse.mTransId = this.req.transId;
      if (localObject != null) {
        ((RequestWorker.RequestHandler)localObject).removeCallbacks(this.reqTimeoutTimer);
      }
      BdhLogUtil.LogEvent("R", "HandleResp :" + paramHwResponse.dumpRespInfo() + " ,isCancle:" + this.req.isCancel);
      if ((this.req.isCancel.get()) && ("PicUp.Echo".equalsIgnoreCase(this.req.hwCmd)))
      {
        RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
        return;
      }
      if ((paramHwResponse.isIpv6) && (paramHwResponse.retCode == 97))
      {
        BdhLogUtil.LogEvent("R", "handleResponse , ipv6 illegal user");
        RequestWorker.this.engine.mConnManager.onIPV6IllegalUserErr(this.req.sendConnId);
        RequestWorker.this.addHwRequest(this.req);
        scheduleRetry(paramHwResponse.buzRetCode, 0L);
        return;
      }
      if ((paramHwResponse.shouldRetry) && (this.req.buzRetryCount < 3))
      {
        localObject = this.req;
        ((HwRequest)localObject).buzRetryCount += 1;
        RequestWorker.this.addHwRequest(this.req);
        scheduleRetry(paramHwResponse.buzRetCode, 0L);
        return;
      }
      RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
      this.req.updateStaus(4);
      localObject = (IConnection)RequestWorker.this.engine.mConnManager.connections.get(Integer.valueOf(this.req.sendConnId));
      if (localObject != null) {
        paramHwResponse.isIpv6 = ((IConnection)localObject).isIpv6();
      }
      this.req.onResponse(RequestWorker.this, paramHwResponse);
    }
    
    public void handleSendBegin(int paramInt)
    {
      RequestWorker.RequestHandler localRequestHandler = RequestWorker.this.mRequestHandler;
      if ((RequestWorker.this.mWorking.get()) && (localRequestHandler != null))
      {
        localRequestHandler.removeCallbacks(this.reqTimeoutTimer);
        localRequestHandler.removeCallbacks(this.netDetectTimer);
        this.req.sendConnId = paramInt;
        this.req.lastSendStartTime = SystemClock.uptimeMillis();
        localRequestHandler.postDelayed(this.reqTimeoutTimer, this.req.timeOut);
        localRequestHandler.postDelayed(this.writeTimeoutTimer, this.req.timeOut);
        this.req.onSendBegin();
      }
    }
    
    public void handleSendEnd(int paramInt1, int paramInt2)
    {
      this.req.sendComsume = (SystemClock.uptimeMillis() - this.req.lastSendStartTime);
      this.req.protoType = paramInt2;
      Object localObject = RequestWorker.this.mRequestHandler;
      if (localObject != null) {
        ((RequestWorker.RequestHandler)localObject).removeCallbacks(this.writeTimeoutTimer);
      }
      this.req.onSendEnd();
      if ((this.req instanceof RequestDataTrans))
      {
        localObject = ((RequestDataTrans)this.req).mInfo.parent;
        if (localObject != null)
        {
          localAtomicInteger = (AtomicInteger)((Transaction)localObject).mTransReport.mDataFlowOfChannel.get(Integer.valueOf(paramInt1));
          if (localAtomicInteger == null) {
            break label112;
          }
          localAtomicInteger.incrementAndGet();
        }
      }
      return;
      label112:
      AtomicInteger localAtomicInteger = new AtomicInteger(1);
      ((Transaction)localObject).mTransReport.mDataFlowOfChannel.put(Integer.valueOf(paramInt1), localAtomicInteger);
    }
    
    public void handleSendTimeOut()
    {
      if (this.req.isCancel.get())
      {
        RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
        return;
      }
      BdhLogUtil.LogEvent("R", "conId:" + this.req.sendConnId + " handleSendTimeOut->req.hwSeq:" + this.req.getHwSeq());
      this.req.onError(-1005);
      int i = this.req.sendConnId;
      Object localObject1;
      if ((this.req instanceof RequestHeartBreak))
      {
        localObject1 = (RequestHeartBreak)this.req;
        if (((RequestHeartBreak)localObject1).isUrgent) {
          try
          {
            this.req.isCancel.set(true);
            RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
            RequestWorker.this.engine.mConnManager.onUrgentHeartBreakTimeout(this.req.sendConnId);
            return;
          }
          finally {}
        }
      }
      RequestWorker.this.engine.mConnManager.onRequestTimeOut(i);
      if ((RequestWorker.this.sendUrgentHB.get(Integer.valueOf(i)) != null) && (!((HwRequest)RequestWorker.this.sendUrgentHB.get(Integer.valueOf(i))).isCancel.get()) && (((HwRequest)RequestWorker.this.sendUrgentHB.get(Integer.valueOf(i))).status.get() != 4)) {
        BdhLogUtil.LogEvent("R", "conId:" + i + " handleSendTimeOut->there has been a HB sending !");
      }
      for (;;)
      {
        localObject1 = this.req;
        ((HwRequest)localObject1).timeOut += 15000L;
        localObject1 = this.req;
        ((HwRequest)localObject1).timeOutCount += 1;
        handleError(-1005, "ReqTimeOut", (IConnection)RequestWorker.this.engine.mConnManager.connections.get(Integer.valueOf(i)));
        return;
        RequestWorker.this.sendHeartBreak(i, true, true, 0);
      }
    }
    
    public void handleWriteTimeout()
    {
      if (this.req.isCancel.get())
      {
        RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
        return;
      }
      BdhLogUtil.LogEvent("R", "conId:" + this.req.sendConnId + " handleWriteTimeout->req.hwSeq:" + this.req.getHwSeq());
      this.req.onError(-1006);
      RequestWorker.this.engine.mConnManager.onRequestWriteTimeout(this.req.sendConnId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestWorker
 * JD-Core Version:    0.7.0.1
 */