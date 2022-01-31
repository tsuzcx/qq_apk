package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;
import com.tencent.token.utils.w;

class aah
  implements View.OnClickListener
{
  aah(StartPwdGestureSelActivity paramStartPwdGestureSelActivity) {}
  
  public void onClick(View paramView)
  {
    ch.a().a(System.currentTimeMillis(), 21);
    paramView = new Intent(this.a, StartPwdGestureDeleteActivity.class);
    this.a.startActivityForResult(paramView, 256);
    w.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aah
 * JD-Core Version:    0.7.0.1
 */