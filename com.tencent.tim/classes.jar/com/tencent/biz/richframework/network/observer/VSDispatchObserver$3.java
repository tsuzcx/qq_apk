package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import rxc;
import rxc.a;

public class VSDispatchObserver$3
  implements Runnable
{
  public VSDispatchObserver$3(rxc paramrxc, boolean paramBoolean, long paramLong1, VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte, rxc.a parama, String paramString, MessageMicro paramMessageMicro, long paramLong2) {}
  
  public void run()
  {
    if ((this.val$isSuccess) && (this.val$retCode == 0L) && (this.a.isEnableCache())) {
      rxc.a(this.this$0, this.a, this.bN);
    }
    this.b.a(this.val$isSuccess, this.val$retCode, this.val$errMsg, this.c);
    QLog.d("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + this.a.getCmdName() + " | TraceId:" + this.a.getTraceId() + " | SeqId:" + this.a.getCurrentSeq() + " | retCode:" + this.val$retCode + " | retMessage:" + this.val$errMsg + " | busiBuff size:" + this.bN.length + " | final dispatch costTime:" + (System.currentTimeMillis() - this.CC));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.3
 * JD-Core Version:    0.7.0.1
 */