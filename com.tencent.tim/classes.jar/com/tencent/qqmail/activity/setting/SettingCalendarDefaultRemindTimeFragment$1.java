package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SettingCalendarDefaultRemindTimeFragment$1
  implements View.OnClickListener
{
  SettingCalendarDefaultRemindTimeFragment$1(SettingCalendarDefaultRemindTimeFragment paramSettingCalendarDefaultRemindTimeFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.popBackStack();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarDefaultRemindTimeFragment.1
 * JD-Core Version:    0.7.0.1
 */