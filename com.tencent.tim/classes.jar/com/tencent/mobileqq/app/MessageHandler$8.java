package com.tencent.mobileqq.app;

import apdd;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$8
  implements Runnable
{
  MessageHandler$8(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, "onReceive,cost:" + (System.currentTimeMillis() - apdd.aqY));
    }
    try
    {
      MessageHandler.a(this.this$0, this.g, this.f, this.val$data, false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgResp_PB exception ! ", localException);
      }
      MessageHandler.a(this.this$0, this.g, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.8
 * JD-Core Version:    0.7.0.1
 */