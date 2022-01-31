package com.tencent.token.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class df
  implements View.OnTouchListener
{
  df(TitleOptionMenu paramTitleOptionMenu) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (TitleOptionMenu.b(this.a).findFocus() == null))
    {
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.df
 * JD-Core Version:    0.7.0.1
 */