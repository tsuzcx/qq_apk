package com.tencent.mobileqq.teamwork.spread;

import acfp;
import ahao;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aocw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfigSetting$4
  implements Runnable
{
  public void run()
  {
    this.this$0.mApp.getApp().getSharedPreferences(this.this$0.mApp.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0).edit().putInt("file_str_key_max_count_local", aocw.a(this.this$0)).commit();
    ahao.JG(acfp.m(2131704330));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting.4
 * JD-Core Version:    0.7.0.1
 */