package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SettingCalendarDefaultFragment$1
  implements View.OnClickListener
{
  SettingCalendarDefaultFragment$1(SettingCalendarDefaultFragment paramSettingCalendarDefaultFragment) {}
  
  public void onClick(View paramView)
  {
    SettingCalendarDefaultFragment.access$000(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarDefaultFragment.1
 * JD-Core Version:    0.7.0.1
 */