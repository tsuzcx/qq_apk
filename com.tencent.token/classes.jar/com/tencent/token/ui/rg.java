package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class rg
  implements View.OnClickListener
{
  rg(NetActiveVryQuesActivity paramNetActiveVryQuesActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, SelectCountryCodeActivity.class);
    this.a.startActivityForResult(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rg
 * JD-Core Version:    0.7.0.1
 */