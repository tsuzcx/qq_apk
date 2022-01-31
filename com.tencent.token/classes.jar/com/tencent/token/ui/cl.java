package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;

class cl
  implements View.OnClickListener
{
  cl(CheckMobileAvailableActivity paramCheckMobileAvailableActivity) {}
  
  public void onClick(View paramView)
  {
    h.c("removeTimeTask showProgressDialog");
    this.a.removeTimeTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cl
 * JD-Core Version:    0.7.0.1
 */