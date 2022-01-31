package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;

final class adw
  implements View.OnClickListener
{
  adw(UtilsGameLockActivity paramUtilsGameLockActivity) {}
  
  public final void onClick(View paramView)
  {
    e.c("retry: ");
    this.a.queryGameLockStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adw
 * JD-Core Version:    0.7.0.1
 */