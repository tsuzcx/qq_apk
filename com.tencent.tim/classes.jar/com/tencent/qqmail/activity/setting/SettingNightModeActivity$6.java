package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SettingNightModeActivity$6
  implements View.OnClickListener
{
  SettingNightModeActivity$6(SettingNightModeActivity paramSettingNightModeActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.showTimeDialog(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNightModeActivity.6
 * JD-Core Version:    0.7.0.1
 */