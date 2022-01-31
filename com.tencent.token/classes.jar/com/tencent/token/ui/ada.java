package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;

final class ada
  implements View.OnClickListener
{
  ada(UtilsAccountLockActivity paramUtilsAccountLockActivity) {}
  
  public final void onClick(View paramView)
  {
    e.c("retry: ");
    this.a.queryAccountLockStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ada
 * JD-Core Version:    0.7.0.1
 */