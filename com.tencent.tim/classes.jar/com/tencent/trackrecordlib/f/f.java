package com.tencent.trackrecordlib.f;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.trackrecordlib.core.c;

public class f
  extends TouchDelegate
{
  private View a;
  private TouchDelegate b;
  
  public f(TouchDelegate paramTouchDelegate, Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
    this.b = paramTouchDelegate;
    this.a = paramView;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      int i = paramMotionEvent.getActionIndex();
      c.a().a(this.a, paramMotionEvent.getAction(), paramMotionEvent.getPointerId(i), paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getX(i), paramMotionEvent.getY(i), paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
      if ((this.b != null) && (this.b.onTouchEvent(paramMotionEvent))) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.f.f
 * JD-Core Version:    0.7.0.1
 */