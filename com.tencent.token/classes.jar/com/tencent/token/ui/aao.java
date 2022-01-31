package com.tencent.token.ui;

import android.content.res.Resources;
import com.tencent.token.ch;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.bs;

class aao
  implements bs
{
  aao(StartPwdGestureVerifyActivity paramStartPwdGestureVerifyActivity) {}
  
  public void a()
  {
    this.a.setResult(35);
    ch.a().a(System.currentTimeMillis(), 18);
    IndexActivity.need_query_dual_msg = true;
    this.a.finish();
  }
  
  public void a(boolean paramBoolean)
  {
    h.a("verifyinit limit");
    if (paramBoolean)
    {
      this.a.mActivityType = 3;
      StartPwdGestureVerifyActivity.access$300(this.a);
      return;
    }
    this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231116), 2131230897, new aap(this));
  }
  
  public void b()
  {
    StartPwdGestureVerifyActivity.access$300(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aao
 * JD-Core Version:    0.7.0.1
 */