package com.tencent.qqmail.activity.setting;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMTips;

class SettingCalendarServerFragment$3$2$1
  implements Runnable
{
  SettingCalendarServerFragment$3$2$1(SettingCalendarServerFragment.3.2 param2) {}
  
  public void run()
  {
    int[] arrayOfInt = this.this$2.val$rightResIds;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      this.this$2.this$1.this$0.findViewById(k).setVisibility(0);
      i += 1;
    }
    SettingCalendarServerFragment.access$1602(this.this$2.this$1.this$0, true);
    SettingCalendarServerFragment.access$702(this.this$2.this$1.this$0, false);
    SettingCalendarServerFragment.access$800(this.this$2.this$1.this$0);
    this.this$2.this$1.this$0.getTips().showSuccess(2131719700);
    this.this$2.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarServerFragment.3.2.1
 * JD-Core Version:    0.7.0.1
 */