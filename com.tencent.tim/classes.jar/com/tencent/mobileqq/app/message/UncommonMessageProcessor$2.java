package com.tencent.mobileqq.app.message;

import acsb;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class UncommonMessageProcessor$2
  extends SendMessageHandler.SendMessageRunnable
{
  public UncommonMessageProcessor$2(acsb paramacsb, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    this.j.setTimeout(this.timeout);
    this.j.extraData.putInt("retryIndex", this.aaU);
    this.j.extraData.putLong("timeOut", this.timeout);
    acsb.b(this.this$0).o(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.UncommonMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */