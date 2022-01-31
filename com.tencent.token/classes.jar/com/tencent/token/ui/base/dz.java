package com.tencent.token.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.x;

final class dz
  implements View.OnClickListener
{
  dz(WtloginCaptchaDialog paramWtloginCaptchaDialog) {}
  
  public final void onClick(View paramView)
  {
    this.a.a.b(WtloginCaptchaDialog.b(this.a), this.a.b);
    WtloginCaptchaDialog.c(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dz
 * JD-Core Version:    0.7.0.1
 */