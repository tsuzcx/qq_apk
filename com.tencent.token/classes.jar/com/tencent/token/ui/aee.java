package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

final class aee
  implements View.OnClickListener
{
  aee(aec paramaec, String paramString, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.c.a, UtilsModSetMobileStep1Activity.class);
    paramView.putExtra("title", this.c.a.getResources().getString(2131361814) + this.a);
    paramView.putExtra("op_type", 1);
    paramView.putExtra("position", this.b);
    this.c.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aee
 * JD-Core Version:    0.7.0.1
 */