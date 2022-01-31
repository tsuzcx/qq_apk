package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class acg
  implements View.OnClickListener
{
  acg(StartPwdUpdateInfoActivity paramStartPwdUpdateInfoActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, StartPwdGestureModifyActivity.class);
    this.a.startActivityForResult(paramView, 258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acg
 * JD-Core Version:    0.7.0.1
 */