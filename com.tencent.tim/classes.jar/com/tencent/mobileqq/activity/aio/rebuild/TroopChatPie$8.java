package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import yjm;

class TroopChatPie$8
  implements Runnable
{
  TroopChatPie$8(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(700L);
      if ((!this.this$0.bme) && (!this.bmh) && (this.this$0.app.cs(this.this$0.sessionInfo.aTl) == 3) && ((this.this$0.a == null) || (!this.this$0.a.isShowing())))
      {
        this.this$0.bme = true;
        TroopChatPie.a(this.this$0).post(new TroopChatPie.8.1(this));
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, QLog.getStackTraceString(localInterruptedException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.8
 * JD-Core Version:    0.7.0.1
 */