package com.tencent.qqmail.activity.setting;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class SettingNightModeActivity$2
  implements SeekBar.OnSeekBarChangeListener
{
  SettingNightModeActivity$2(SettingNightModeActivity paramSettingNightModeActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.this$0.colorTemp = (100 - paramInt);
    SharedPreferenceUtil.setNightModeTemperature(this.this$0.colorTemp);
    this.this$0.showNightModeJustOneSecond();
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNightModeActivity.2
 * JD-Core Version:    0.7.0.1
 */