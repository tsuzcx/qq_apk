package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aocx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfigSettingForDataLine$3
  implements Runnable
{
  public ConfigSettingForDataLine$3(aocx paramaocx) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.this$0.mApp.getApp().getSharedPreferences(this.this$0.mApp.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0);
    localSharedPreferences.edit().putInt("file_str_key_max_count_local", aocx.a(this.this$0)).commit();
    localSharedPreferences.edit().putLong("file_str_lstat_show_time_local", aocx.a(this.this$0)).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.3
 * JD-Core Version:    0.7.0.1
 */