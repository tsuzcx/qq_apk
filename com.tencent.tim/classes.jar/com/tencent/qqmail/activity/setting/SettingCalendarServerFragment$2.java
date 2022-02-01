package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.model.QMCalendarManager;

class SettingCalendarServerFragment$2
  implements View.OnClickListener
{
  SettingCalendarServerFragment$2(SettingCalendarServerFragment paramSettingCalendarServerFragment) {}
  
  public void onClick(View paramView)
  {
    if (SettingCalendarServerFragment.access$700(this.this$0))
    {
      SettingCalendarServerFragment.access$702(this.this$0, false);
      SettingCalendarServerFragment.access$800(this.this$0);
      SettingCalendarServerFragment.access$900(this.this$0, true);
      QMCalendarManager.getInstance().cancelRequest(SettingCalendarServerFragment.access$500(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarServerFragment.2
 * JD-Core Version:    0.7.0.1
 */