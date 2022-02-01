package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class SettingAboutActivity$3
  implements View.OnClickListener
{
  SettingAboutActivity$3(SettingAboutActivity paramSettingAboutActivity) {}
  
  public void onClick(View paramView)
  {
    if ((!StringExtention.isNullOrEmpty(SettingAboutActivity.access$300(this.this$0))) && (SettingAboutActivity.access$300(this.this$0).equals(SettingAboutActivity.access$400())))
    {
      Intent localIntent = SettingActivity.createIntent("from_none");
      localIntent.addFlags(65536);
      this.this$0.startActivity(localIntent);
    }
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAboutActivity.3
 * JD-Core Version:    0.7.0.1
 */