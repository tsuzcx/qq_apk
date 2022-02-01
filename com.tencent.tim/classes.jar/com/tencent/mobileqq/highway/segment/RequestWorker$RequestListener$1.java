package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.conn.IConnection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestWorker$RequestListener$1
  implements Runnable
{
  RequestWorker$RequestListener$1(RequestWorker.RequestListener paramRequestListener, RequestWorker paramRequestWorker, HwRequest paramHwRequest) {}
  
  public void run()
  {
    if (RequestWorker.RequestListener.access$200(this.this$1).isCancel.get())
    {
      RequestWorker.access$300(this.this$1.this$0).remove(Integer.valueOf(RequestWorker.RequestListener.access$200(this.this$1).getHwSeq()));
      return;
    }
    IConnection localIConnection = (IConnection)this.this$1.this$0.engine.mConnManager.connections.get(Integer.valueOf(this.val$req.sendConnId));
    this.this$1.handleError(-1000, "NoNetWork", localIConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestWorker.RequestListener.1
 * JD-Core Version:    0.7.0.1
 */