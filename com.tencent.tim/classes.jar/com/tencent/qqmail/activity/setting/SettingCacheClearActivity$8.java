package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

final class SettingCacheClearActivity$8
  implements View.OnClickListener
{
  SettingCacheClearActivity$8(RelativeLayout paramRelativeLayout, SettingCacheClearActivity.ClickRemindClearCache paramClickRemindClearCache) {}
  
  public void onClick(View paramView)
  {
    this.val$layout.setVisibility(8);
    this.val$clickRemindClearCache.click();
    DataCollector.logEvent("Event_Click_Tip_To_Clear_Cache");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCacheClearActivity.8
 * JD-Core Version:    0.7.0.1
 */