package com.tencent.token.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.token.ui.base.cf;

final class nv
  implements View.OnTouchListener
{
  nv(KnowTokenActivity paramKnowTokenActivity) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView == KnowTokenActivity.access$500(this.a)) && (paramMotionEvent.getAction() == 0)) {
      KnowTokenActivity.access$500(this.a).a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nv
 * JD-Core Version:    0.7.0.1
 */