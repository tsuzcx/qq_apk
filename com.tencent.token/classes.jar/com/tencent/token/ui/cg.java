package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;

class cg
  implements View.OnClickListener
{
  cg(BindUinActivity paramBindUinActivity) {}
  
  public void onClick(View paramView)
  {
    h.c("removeTimeTask showProgressDialog");
    this.a.removeTimeTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cg
 * JD-Core Version:    0.7.0.1
 */