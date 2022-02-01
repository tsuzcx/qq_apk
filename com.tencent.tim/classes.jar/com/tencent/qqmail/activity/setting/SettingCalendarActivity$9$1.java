package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import java.util.List;

class SettingCalendarActivity$9$1
  implements Runnable
{
  SettingCalendarActivity$9$1(SettingCalendarActivity.9 param9) {}
  
  public void run()
  {
    SettingCalendarActivity.access$002(this.this$1.this$0, false);
    SettingCalendarActivity.access$200(this.this$1.this$0, null, null);
    this.this$1.val$itemView.setChecked(true);
    SettingCalendarActivity.access$900(this.this$1.this$0).set(this.this$1.val$iIndex, Boolean.valueOf(true));
    this.this$1.this$0.getTips().showSuccess(2131719701);
    SettingCalendarActivity.access$300(this.this$1.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.9.1
 * JD-Core Version:    0.7.0.1
 */