package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tnv;
import tnv.a;

public class BaseMessageProcessor$1
  extends SendMessageHandler.SendMessageRunnable
{
  public BaseMessageProcessor$1(tnv paramtnv, tnv.a parama, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.a.a();
    if (localToServiceMsg == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "prepareRetryRunnable cmd=" + localToServiceMsg.getServiceCmd() + ",reqSeq=" + this.sP + " timeout: " + this.timeout + " retryIndex:" + this.aaU);
    }
    localToServiceMsg.extraData.putLong("timeOut", this.timeout);
    localToServiceMsg.extraData.putLong("startTime", this.val$startTime);
    localToServiceMsg.extraData.putInt("retryIndex", this.aaU);
    localToServiceMsg.setTimeout(this.timeout);
    this.this$0.a(localToServiceMsg, this.sP, this.aPW, this.aPX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */