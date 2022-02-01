package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.calendar.view.ScheduleTimeModifyView;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.nightmode.NightModeUtils;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.view.DatePickerListenerAdapter;
import java.util.Calendar;

class SettingNightModeActivity$4
  extends DatePickerListenerAdapter
{
  SettingNightModeActivity$4(SettingNightModeActivity paramSettingNightModeActivity, boolean paramBoolean) {}
  
  public boolean onPickConfirm(Calendar paramCalendar)
  {
    int i = paramCalendar.get(11);
    int j = paramCalendar.get(12);
    if (this.val$isBeginTime)
    {
      SettingNightModeActivity.access$000(this.this$0).setStartTimeRawText(i, j);
      SharedPreferenceUtil.setNightModeStartTime(i * 100 + j);
    }
    for (;;)
    {
      QMLog.log(4, "SettingNightModeActivit", "Setting NightMode Time " + NightModeUtils.getInstance().logDetailOfNightModeSetting());
      this.this$0.updateNightModeTemper();
      return true;
      SettingNightModeActivity.access$000(this.this$0).setEndTimeRawText(i, j);
      SharedPreferenceUtil.setNightModeEndTime(i * 100 + j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNightModeActivity.4
 * JD-Core Version:    0.7.0.1
 */