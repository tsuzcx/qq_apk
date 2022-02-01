package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingCalendarActivity$1
  implements View.OnClickListener
{
  SettingCalendarActivity$1(SettingCalendarActivity paramSettingCalendarActivity, Account paramAccount, UITableItemView paramUITableItemView) {}
  
  public void onClick(View paramView)
  {
    if (SettingCalendarActivity.access$000(this.this$0))
    {
      SettingCalendarActivity.access$002(this.this$0, false);
      SettingCalendarActivity.access$100(this.this$0).cancelRequest(this.val$account);
      if (this.val$itemView != null) {
        this.val$itemView.setChecked(false);
      }
      SettingCalendarActivity.access$200(this.this$0, null, null);
      SettingCalendarActivity.access$300(this.this$0, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.finish();
      this.this$0.overridePendingTransition(2130772421, 2130772420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.1
 * JD-Core Version:    0.7.0.1
 */