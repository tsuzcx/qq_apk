package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;
import com.tencent.token.utils.w;

class aag
  implements View.OnClickListener
{
  aag(StartPwdGestureSelActivity paramStartPwdGestureSelActivity) {}
  
  public void onClick(View paramView)
  {
    ch.a().a(System.currentTimeMillis(), 15);
    paramView = new Intent(this.a, StartPwdGestureModifyActivity.class);
    this.a.startActivityForResult(paramView, 258);
    w.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aag
 * JD-Core Version:    0.7.0.1
 */