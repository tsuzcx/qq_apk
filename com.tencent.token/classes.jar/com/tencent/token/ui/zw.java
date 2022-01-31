package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class zw
  implements View.OnClickListener
{
  zw(StartPwdGestureIndexActivity paramStartPwdGestureIndexActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, StartPwdUpdateInfoActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zw
 * JD-Core Version:    0.7.0.1
 */