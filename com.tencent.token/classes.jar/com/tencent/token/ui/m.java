package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.UtilsAccountLockTipDialog;
import com.tencent.token.ui.base.ds;

final class m
  implements CompoundButton.OnCheckedChangeListener
{
  m(k paramk) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (ds)((SwitchButton)paramCompoundButton).getTag();
    if (paramCompoundButton == null) {
      return;
    }
    if ((!g.b()) && (!paramBoolean)) {
      try
      {
        SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("sp_name_global", 0).edit();
        localEditor.putBoolean("utils_account_lock_tip", true);
        localEditor.commit();
        new UtilsAccountLockTipDialog(k.a(this.a), k.b(this.a), paramCompoundButton, paramBoolean).show();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          e.c("SharedPreferences msg " + localException.getMessage());
        }
      }
    }
    this.a.b(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.m
 * JD-Core Version:    0.7.0.1
 */