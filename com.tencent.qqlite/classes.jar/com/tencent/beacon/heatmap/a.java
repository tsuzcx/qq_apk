package com.tencent.beacon.heatmap;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.WindowManager;

public final class a
  extends GestureDetector.SimpleOnGestureListener
{
  private Activity a;
  private String b;
  
  public a(Activity paramActivity, String paramString)
  {
    this.a = paramActivity;
    this.b = paramString;
  }
  
  private void a(MotionEvent paramMotionEvent1, int paramInt, MotionEvent paramMotionEvent2)
  {
    String str = (int)paramMotionEvent1.getX() + "-" + (int)paramMotionEvent1.getY();
    int i;
    if (paramInt == 0)
    {
      i = 2;
      paramInt = 1;
    }
    for (;;)
    {
      paramMotionEvent1 = "";
      if ((paramInt == 3) || (paramInt == 4)) {
        paramMotionEvent1 = (int)paramMotionEvent2.getX() + "-" + (int)paramMotionEvent2.getY();
      }
      c.a().a(new b(this.b, paramInt, this.a.getResources().getConfiguration().orientation, str, paramMotionEvent1, i));
      return;
      i = 1;
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.getWindowManager().getDefaultDisplay().getRotation() == 0) {
      a(paramMotionEvent, 0, null);
    }
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.a.getWindowManager().getDefaultDisplay().getRotation() == 0) {
      a(paramMotionEvent1, 3, paramMotionEvent2);
    }
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.a.getWindowManager().getDefaultDisplay().getRotation() == 0) {
      a(paramMotionEvent, 2, null);
    }
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.a.getWindowManager().getDefaultDisplay().getRotation() == 0) {
      a(paramMotionEvent1, 4, paramMotionEvent2);
    }
    return true;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a.getWindowManager().getDefaultDisplay().getRotation() == 0) {
      a(paramMotionEvent, 1, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.heatmap.a
 * JD-Core Version:    0.7.0.1
 */