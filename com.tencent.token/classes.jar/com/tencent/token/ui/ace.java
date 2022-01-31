package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.token.p;
import com.tencent.token.ui.base.bz;

final class ace
  implements bz
{
  ace(StartPwdGestureVerifyActivity paramStartPwdGestureVerifyActivity) {}
  
  public final void a()
  {
    this.a.setResult(35);
    p.a().a(System.currentTimeMillis(), 18);
    this.a.finish();
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Intent localIntent = new Intent(this.a, StartPwdGestureForgetActivity.class);
      localIntent.putExtra("startpwd_forget_source", 3);
      this.a.startActivity(localIntent);
      this.a.finish();
      return;
    }
    this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362152), 2131361800, new acf(this));
  }
  
  public final void b()
  {
    Intent localIntent = new Intent(this.a, StartPwdGestureForgetActivity.class);
    localIntent.putExtra("startpwd_forget_source", this.a.mActivityType);
    this.a.startActivityForResult(localIntent, 256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ace
 * JD-Core Version:    0.7.0.1
 */