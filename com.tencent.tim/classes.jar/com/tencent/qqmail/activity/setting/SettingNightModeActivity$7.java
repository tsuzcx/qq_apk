package com.tencent.qqmail.activity.setting;

import android.widget.ImageView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableContainer;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingNightModeActivity$7
  implements UITableView.ClickListener
{
  SettingNightModeActivity$7(SettingNightModeActivity paramSettingNightModeActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool2 = true;
    label80:
    ImageView localImageView;
    if (paramUITableItemView == SettingNightModeActivity.access$100(this.this$0)) {
      if (paramUITableItemView.isChecked() == true)
      {
        paramUITableItemView.setChecked(false);
        SharedPreferenceUtil.setNightMode(false);
        DataCollector.logEvent("Event_NightMode_turn_off");
        this.this$0.updateNightModeTemper();
        this.this$0.showOrHideSomeSetting(8);
        QMLog.log(4, "SettingNightModeActivit", "Turn on/off nightmode " + SharedPreferenceUtil.inNightMode());
        localImageView = paramUITableItemView.getTailImage();
        if (!paramUITableItemView.isChecked()) {
          break label268;
        }
      }
    }
    label263:
    label268:
    for (paramUITableItemView = this.this$0.getString(2131720844);; paramUITableItemView = this.this$0.getString(2131720811))
    {
      localImageView.setContentDescription(paramUITableItemView);
      return;
      paramUITableItemView.setChecked(true);
      SharedPreferenceUtil.setNightMode(true);
      DataCollector.logEvent("Event_NightMode_turn_on");
      this.this$0.updateNightModeTemper();
      this.this$0.showOrHideSomeSetting(0);
      break;
      if (paramUITableItemView != SettingNightModeActivity.access$200(this.this$0)) {
        break label80;
      }
      if (!paramUITableItemView.isChecked())
      {
        bool1 = true;
        label163:
        SharedPreferenceUtil.setNightModeAllDay(bool1);
        if (!paramUITableItemView.isChecked()) {
          break label243;
        }
        SettingNightModeActivity.access$300(this.this$0).setVisibility(0);
        label185:
        if (paramUITableItemView.isChecked()) {
          break label263;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramUITableItemView.setChecked(bool1);
        QMLog.log(4, "SettingNightModeActivit", "Turn on/off all-day nightmode " + SharedPreferenceUtil.isNightModeAllDay());
        this.this$0.updateNightModeTemper();
        break;
        bool1 = false;
        break label163;
        label243:
        SettingNightModeActivity.access$300(this.this$0).setVisibility(8);
        DataCollector.logEvent("Event_NightMode_choose_allday");
        break label185;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNightModeActivity.7
 * JD-Core Version:    0.7.0.1
 */