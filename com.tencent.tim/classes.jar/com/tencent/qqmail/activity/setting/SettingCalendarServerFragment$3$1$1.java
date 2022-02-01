package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class SettingCalendarServerFragment$3$1$1
  implements Runnable
{
  SettingCalendarServerFragment$3$1$1(SettingCalendarServerFragment.3.1 param1, Object paramObject) {}
  
  public void run()
  {
    QMNetworkError localQMNetworkError = (QMNetworkError)this.val$object;
    SettingCalendarServerFragment.access$702(this.this$2.this$1.this$0, false);
    SettingCalendarServerFragment.access$800(this.this$2.this$1.this$0);
    SettingCalendarServerFragment.access$900(this.this$2.this$1.this$0, true);
    if (localQMNetworkError.code == 5) {
      SettingCalendarServerFragment.access$1300(this.this$2.this$1.this$0, 2131691084);
    }
    while (localQMNetworkError.code == 10) {
      return;
    }
    if (localQMNetworkError.code == 1)
    {
      SettingCalendarServerFragment.access$1300(this.this$2.this$1.this$0, 2131691082);
      return;
    }
    if (localQMNetworkError.code == 4)
    {
      SettingCalendarServerFragment.access$1300(this.this$2.this$1.this$0, 2131691085);
      return;
    }
    if (localQMNetworkError.code == 2)
    {
      SettingCalendarServerFragment.access$1300(this.this$2.this$1.this$0, 2131691081);
      return;
    }
    if ((localQMNetworkError.code == 6) || (localQMNetworkError.code == 7))
    {
      SettingCalendarServerFragment.access$1300(this.this$2.this$1.this$0, 2131691083);
      return;
    }
    SettingCalendarServerFragment.access$1300(this.this$2.this$1.this$0, 2131719697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarServerFragment.3.1.1
 * JD-Core Version:    0.7.0.1
 */