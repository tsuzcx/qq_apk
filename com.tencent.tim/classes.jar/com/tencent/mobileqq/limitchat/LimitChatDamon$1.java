package com.tencent.mobileqq.limitchat;

import aind;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ujt;

public class LimitChatDamon$1
  implements Runnable
{
  public LimitChatDamon$1(aind paramaind, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      aind.a(this.this$0, null);
      ??? = new SessionInfo();
      ((SessionInfo)???).aTl = this.bPe;
      ((SessionInfo)???).troopUin = this.bPe;
      ((SessionInfo)???).cZ = 1037;
      ujt.a(this.val$app, (SessionInfo)???);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm , real send:" + this.bPe);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatDamon.1
 * JD-Core Version:    0.7.0.1
 */