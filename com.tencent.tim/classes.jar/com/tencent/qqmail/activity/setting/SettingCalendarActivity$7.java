package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.model.QMCalendarManager;

class SettingCalendarActivity$7
  implements Runnable
{
  SettingCalendarActivity$7(SettingCalendarActivity paramSettingCalendarActivity, Account paramAccount) {}
  
  public void run()
  {
    synchronized (this.this$0.lock)
    {
      SettingCalendarActivity.access$100(this.this$0).logout(this.val$account);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.7
 * JD-Core Version:    0.7.0.1
 */