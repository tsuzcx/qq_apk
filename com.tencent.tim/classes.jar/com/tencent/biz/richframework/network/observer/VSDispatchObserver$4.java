package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import rxc;
import rxc.a;

public class VSDispatchObserver$4
  implements Runnable
{
  public VSDispatchObserver$4(rxc paramrxc, rxc.a parama, VSBaseRequest paramVSBaseRequest, long paramLong, Exception paramException) {}
  
  public void run()
  {
    this.b.a(false, -2L, "网络错误", null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: ParseException: CmdName:" + this.a.getCmdName() + " | TraceId:" + this.a.getTraceId() + " | SeqId:" + this.a.getCurrentSeq() + " | errorMsg: inform VSBaseRequest resultcode fail | final dispatch costTime:" + (System.currentTimeMillis() - this.CC) + " | exception:" + this.val$e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.4
 * JD-Core Version:    0.7.0.1
 */