package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.token.cy;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.bs;

class zr
  implements bs
{
  zr(StartPwdGestureDeleteActivity paramStartPwdGestureDeleteActivity) {}
  
  public void a()
  {
    cy.a().a(this.a);
    this.a.setResult(257);
    SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("start_pwd_config", 0).edit();
    localEditor.clear();
    localEditor.commit();
    if (!cy.a().c()) {
      this.a.pwdIsDelete();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231116), 2131230897, new zs(this));
  }
  
  public void b()
  {
    StartPwdGestureDeleteActivity.access$302(this.a, 1);
    StartPwdGestureDeleteActivity.access$400(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zr
 * JD-Core Version:    0.7.0.1
 */