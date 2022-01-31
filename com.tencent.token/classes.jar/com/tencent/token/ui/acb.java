package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.p;
import com.tencent.token.utils.s;

final class acb
  implements View.OnClickListener
{
  acb(StartPwdGestureSelActivity paramStartPwdGestureSelActivity) {}
  
  public final void onClick(View paramView)
  {
    p.a().a(System.currentTimeMillis(), 15);
    paramView = new Intent(this.a, StartPwdGestureModifyActivity.class);
    this.a.startActivityForResult(paramView, 258);
    s.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acb
 * JD-Core Version:    0.7.0.1
 */