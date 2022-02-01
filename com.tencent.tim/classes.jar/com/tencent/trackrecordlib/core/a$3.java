package com.tencent.trackrecordlib.core;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.trackrecordlib.f.b.b;

class a$3
  implements b.b
{
  a$3(a parama) {}
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    try
    {
      int i = paramMotionEvent.getActionIndex();
      c.a().a(paramView, paramMotionEvent.getAction(), paramMotionEvent.getPointerId(i), paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getX(i), paramMotionEvent.getY(i), paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.a.3
 * JD-Core Version:    0.7.0.1
 */