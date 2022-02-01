package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SettingActivity$2
  implements View.OnClickListener
{
  SettingActivity$2(SettingActivity paramSettingActivity) {}
  
  public void onClick(View paramView)
  {
    SettingActivity.access$100(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingActivity.2
 * JD-Core Version:    0.7.0.1
 */