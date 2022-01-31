package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;

class rc
  implements View.OnClickListener
{
  rc(NetActiveVryQQTokenActivity paramNetActiveVryQQTokenActivity) {}
  
  public void onClick(View paramView)
  {
    NetActiveVryQQTokenActivity.access$700(this.a);
    paramView = abi.a().a(this.a);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rc
 * JD-Core Version:    0.7.0.1
 */