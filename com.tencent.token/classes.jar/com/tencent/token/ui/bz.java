package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;

final class bz
  implements View.OnClickListener
{
  bz(CheckMobileAvailableActivity paramCheckMobileAvailableActivity) {}
  
  public final void onClick(View paramView)
  {
    e.c("removeTimeTask showProgressDialog");
    this.a.removeTimeTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bz
 * JD-Core Version:    0.7.0.1
 */