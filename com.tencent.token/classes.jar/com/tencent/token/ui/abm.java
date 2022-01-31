package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;

class abm
  implements View.OnClickListener
{
  abm(UtilsAccountLockActivity paramUtilsAccountLockActivity) {}
  
  public void onClick(View paramView)
  {
    h.c("retry: ");
    this.a.queryAccountLockStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abm
 * JD-Core Version:    0.7.0.1
 */