package com.tencent.mobileqq.activity;

import aqvk;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class NotificationActivity$35
  implements Runnable
{
  NotificationActivity$35(NotificationActivity paramNotificationActivity) {}
  
  public void run()
  {
    boolean bool = NotificationActivity.a(this.this$0).aFI();
    QLog.e("LhHelper", 1, "receiveLhCard result = " + bool);
    if (bool)
    {
      if (NotificationActivity.a(this.this$0).aFJ())
      {
        NotificationActivity.a(this.this$0).sendEmptyMessage(5);
        return;
      }
      NotificationActivity.a(this.this$0).sendEmptyMessage(6);
      return;
    }
    NotificationActivity.a(this.this$0).sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.35
 * JD-Core Version:    0.7.0.1
 */