package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import rxc;
import rxc.a;

public class VSDispatchObserver$2
  implements Runnable
{
  public VSDispatchObserver$2(rxc paramrxc, rxc.a parama, long paramLong1, String paramString, VSBaseRequest paramVSBaseRequest, long paramLong2) {}
  
  public void run()
  {
    this.b.a(false, this.val$retCode, this.val$errMsg, null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + this.a.getCmdName() + " | TraceId:" + this.a.getTraceId() + " | SeqId:" + this.a.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - this.CC) + " | errorMsg: inform VSBaseRequest finalRsp is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.2
 * JD-Core Version:    0.7.0.1
 */