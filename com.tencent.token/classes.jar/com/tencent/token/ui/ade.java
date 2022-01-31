package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class ade
  implements View.OnClickListener
{
  ade(acz paramacz, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.c.a, UtilsModSetMobileStep1Activity.class);
    paramView.putExtra("title", this.c.a.getResources().getString(2131231428) + this.a);
    paramView.putExtra("op_type", 1);
    paramView.putExtra("position", this.b);
    paramView.putExtra("page_id", 10);
    this.c.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ade
 * JD-Core Version:    0.7.0.1
 */