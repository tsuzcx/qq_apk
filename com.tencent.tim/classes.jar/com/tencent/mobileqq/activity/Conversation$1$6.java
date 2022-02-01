package com.tencent.mobileqq.activity;

import aqiz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import ury;

public class Conversation$1$6
  implements Runnable
{
  public Conversation$1$6(ury paramury) {}
  
  public void run()
  {
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a(this.a.this$0.app);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "UpgradeTIMWrapper MSG_TIM_UPGRADE_BAR_SHOW, tips on: ", Boolean.valueOf(localUpgradeTIMWrapper.aBP()) });
    }
    if (!localUpgradeTIMWrapper.aBP()) {
      this.a.this$0.h(1134058, 0L, true);
    }
    do
    {
      return;
      if (aqiz.isAppInstalled(this.a.this$0.app.getApp(), "com.tencent.tim"))
      {
        this.a.this$0.h(1134058, 0L, true);
        return;
      }
    } while ((UpgradeTIMWrapper.aBQ()) || (Conversation.a(this.a.this$0) != null));
    this.a.this$0.runOnUiThread(new Conversation.1.6.1(this, localUpgradeTIMWrapper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.6
 * JD-Core Version:    0.7.0.1
 */