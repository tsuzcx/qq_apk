package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import aocx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfigSettingForDataLine$2
  implements Runnable
{
  public ConfigSettingForDataLine$2(aocx paramaocx) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.this$0.mApp.getApp().getSharedPreferences(this.this$0.mApp.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0);
    aocx.a(this.this$0, localSharedPreferences.getInt("file_str_key_max_count_local", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.2
 * JD-Core Version:    0.7.0.1
 */