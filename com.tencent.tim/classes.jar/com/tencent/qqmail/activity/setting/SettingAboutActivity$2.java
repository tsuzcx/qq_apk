package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SettingAboutActivity$2
  implements View.OnClickListener
{
  SettingAboutActivity$2(SettingAboutActivity paramSettingAboutActivity) {}
  
  public void onClick(View paramView)
  {
    SettingAboutActivity localSettingAboutActivity = this.this$0;
    if (!SettingAboutActivity.access$000(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      SettingAboutActivity.access$002(localSettingAboutActivity, bool);
      SettingAboutActivity.access$200(this.this$0, new SettingAboutActivity.2.1(this));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAboutActivity.2
 * JD-Core Version:    0.7.0.1
 */