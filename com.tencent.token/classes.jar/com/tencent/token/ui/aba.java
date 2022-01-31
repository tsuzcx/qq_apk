package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.bz;

final class aba
  implements bz
{
  aba(StartPwdGestureDeleteActivity paramStartPwdGestureDeleteActivity) {}
  
  public final void a()
  {
    ah.a().f();
    this.a.setResult(257);
    SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("start_pwd_config", 0).edit();
    localEditor.clear();
    localEditor.commit();
    if (!ah.a().c()) {
      this.a.pwdIsDelete();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362152), 2131361800, new abc(this));
  }
  
  public final void b()
  {
    ax.a().a(StartPwdGestureDeleteActivity.access$100(this.a));
    this.a.showProDialog(this.a, 2131362146, new abb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aba
 * JD-Core Version:    0.7.0.1
 */