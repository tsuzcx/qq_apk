package com.tencent.token.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.token.ui.base.by;

class my
  implements View.OnTouchListener
{
  my(KnowTokenActivity paramKnowTokenActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView == KnowTokenActivity.access$500(this.a)) && (paramMotionEvent.getAction() == 0)) {
      KnowTokenActivity.access$500(this.a).b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.my
 * JD-Core Version:    0.7.0.1
 */