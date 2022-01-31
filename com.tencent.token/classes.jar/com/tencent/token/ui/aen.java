package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class aen
  implements View.OnClickListener
{
  aen(UtilsTokenLabActivity paramUtilsTokenLabActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, RealNameProtectActivity.class);
    paramView.putExtra("realname_result", UtilsTokenLabActivity.access$100(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aen
 * JD-Core Version:    0.7.0.1
 */