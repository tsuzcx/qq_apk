package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;

final class aeg
  implements View.OnClickListener
{
  aeg(UtilsLoginProtectActivity paramUtilsLoginProtectActivity) {}
  
  public final void onClick(View paramView)
  {
    e.c("retry: ");
    this.a.queryLoginProtect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aeg
 * JD-Core Version:    0.7.0.1
 */