package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;

class aco
  implements View.OnClickListener
{
  aco(UtilsGameProtectActivity paramUtilsGameProtectActivity) {}
  
  public void onClick(View paramView)
  {
    h.c("retry: ");
    this.a.queryGameProtectStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aco
 * JD-Core Version:    0.7.0.1
 */