package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class rw
  implements View.OnClickListener
{
  rw(NetActiveVryQQTokenActivity paramNetActiveVryQQTokenActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, SelectCountryCodeActivity.class);
    this.a.startActivityForResult(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rw
 * JD-Core Version:    0.7.0.1
 */