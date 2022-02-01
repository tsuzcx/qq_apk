package moai.view.moaiphoto.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import moai.view.moaiphoto.Compat;

@TargetApi(5)
public class EclairGestureDetector
  extends CupcakeGestureDetector
{
  private static final int INVALID_POINTER_ID = -1;
  private int mActivePointerId = -1;
  private int mActivePointerIndex = 0;
  
  public EclairGestureDetector(Context paramContext)
  {
    super(paramContext);
  }
  
  float getActiveX(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getX(this.mActivePointerIndex);
      return f;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getX();
  }
  
  float getActiveY(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getY(this.mActivePointerIndex);
      return f;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getY();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      for (;;)
      {
        i = j;
        if (this.mActivePointerId != -1) {
          i = this.mActivePointerId;
        }
        this.mActivePointerIndex = paramMotionEvent.findPointerIndex(i);
        try
        {
          boolean bool = super.onTouchEvent(paramMotionEvent);
          return bool;
        }
        catch (IllegalArgumentException paramMotionEvent) {}
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        continue;
        this.mActivePointerId = -1;
      }
      i = Compat.getPointerIndex(paramMotionEvent.getAction());
    } while (paramMotionEvent.getPointerId(i) != this.mActivePointerId);
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      this.mLastTouchX = paramMotionEvent.getX(i);
      this.mLastTouchY = paramMotionEvent.getY(i);
      break;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.gestures.EclairGestureDetector
 * JD-Core Version:    0.7.0.1
 */