package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import rxc;
import rxc.a;

public class VSDispatchObserver$5
  implements Runnable
{
  public VSDispatchObserver$5(rxc paramrxc, rxc.a parama, VSBaseRequest paramVSBaseRequest, long paramLong) {}
  
  public void run()
  {
    this.b.a(false, -1L, "网络错误", null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: ParseException: CmdName:" + this.a.getCmdName() + " | TraceId:" + this.a.getTraceId() + " | SeqId:" + this.a.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - this.CC) + " | errorMsg:VSBaseRequest or FromServiceMsg is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.5
 * JD-Core Version:    0.7.0.1
 */