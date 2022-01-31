package com.tencent.token.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class cy
  implements View.OnTouchListener
{
  cy(TitleOptionMenu paramTitleOptionMenu) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (TitleOptionMenu.b(this.a).findFocus() == null))
    {
      this.a.b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cy
 * JD-Core Version:    0.7.0.1
 */