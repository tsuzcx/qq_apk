package com.tencent.mobileqq.activity;

import android.os.Message;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import ury;

public class Conversation$1$4
  implements Runnable
{
  public Conversation$1$4(ury paramury) {}
  
  public void run()
  {
    long l = aqmj.j(this.a.this$0.app.getApplication(), this.a.this$0.app.getCurrentAccountUin());
    if (System.currentTimeMillis() - l >= 86400000L)
    {
      localUpgradeTIMWrapper = UpgradeTIMWrapper.a();
      if (localUpgradeTIMWrapper != null)
      {
        localMessage = this.a.this$0.k.obtainMessage(1134045);
        localMessage.obj = localUpgradeTIMWrapper;
        this.a.this$0.runOnUiThread(new Conversation.1.4.1(this, localMessage));
      }
    }
    while (!QLog.isColorLevel())
    {
      UpgradeTIMWrapper localUpgradeTIMWrapper;
      Message localMessage;
      return;
    }
    QLog.e("UpgradeTIMWrapper", 2, "Conversation onReceiveShowTIMUpgradeTips smaller than 24 hours");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.4
 * JD-Core Version:    0.7.0.1
 */