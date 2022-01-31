package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.ch;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.SwitchButton;

class aai
  implements CompoundButton.OnCheckedChangeListener
{
  aai(StartPwdGestureSelActivity paramStartPwdGestureSelActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean != StartPwdGestureSelActivity.access$000(this.a)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramCompoundButton = RqdApplication.l().getSharedPreferences("start_pwd_config", 0).edit();
        if (StartPwdGestureSelActivity.access$100(this.a) == 1)
        {
          ch.a().a(System.currentTimeMillis(), 65);
          paramCompoundButton.putInt("is_set_start_pwd_show", 0);
          StartPwdGestureSelActivity.access$102(this.a, 0);
          StartPwdGestureSelActivity.access$200(this.a).a(true, false);
          StartPwdGestureSelActivity.access$002(this.a, false);
          paramCompoundButton.commit();
          return;
        }
      }
      catch (Exception paramCompoundButton)
      {
        paramCompoundButton.printStackTrace();
        return;
      }
      paramCompoundButton.putInt("is_set_start_pwd_show", 1);
      StartPwdGestureSelActivity.access$102(this.a, 1);
      StartPwdGestureSelActivity.access$200(this.a).a(false, false);
      StartPwdGestureSelActivity.access$002(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aai
 * JD-Core Version:    0.7.0.1
 */