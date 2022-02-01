package moai.view.moaiphoto.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import moai.view.moaiphoto.log.LogManager;
import moai.view.moaiphoto.log.Logger;

public class CupcakeGestureDetector
  implements GestureDetector
{
  private static final String LOG_TAG = "CupcakeGestureDetector";
  private boolean mIsDragging;
  float mLastTouchX;
  float mLastTouchY;
  protected OnGestureListener mListener;
  final float mMinimumVelocity;
  final float mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public CupcakeGestureDetector(Context paramContext)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.mMinimumVelocity = paramContext.getScaledMinimumFlingVelocity();
    this.mTouchSlop = paramContext.getScaledTouchSlop();
  }
  
  float getActiveX(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getX();
  }
  
  float getActiveY(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getY();
  }
  
  public boolean isDragging()
  {
    return this.mIsDragging;
  }
  
  public boolean isScaling()
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      float f1;
      float f2;
      do
      {
        do
        {
          float f3;
          float f4;
          do
          {
            return true;
            this.mVelocityTracker = VelocityTracker.obtain();
            if (this.mVelocityTracker != null) {
              this.mVelocityTracker.addMovement(paramMotionEvent);
            }
            for (;;)
            {
              this.mLastTouchX = getActiveX(paramMotionEvent);
              this.mLastTouchY = getActiveY(paramMotionEvent);
              this.mIsDragging = false;
              return true;
              LogManager.getLogger().i("CupcakeGestureDetector", "Velocity tracker is null");
            }
            f1 = getActiveX(paramMotionEvent);
            f2 = getActiveY(paramMotionEvent);
            f3 = f1 - this.mLastTouchX;
            f4 = f2 - this.mLastTouchY;
            if (!this.mIsDragging)
            {
              if (Math.sqrt(f3 * f3 + f4 * f4) >= this.mTouchSlop) {
                bool = true;
              }
              this.mIsDragging = bool;
            }
          } while (!this.mIsDragging);
          this.mListener.onDrag(f3, f4);
          this.mLastTouchX = f1;
          this.mLastTouchY = f2;
        } while (this.mVelocityTracker == null);
        this.mVelocityTracker.addMovement(paramMotionEvent);
        return true;
      } while (this.mVelocityTracker == null);
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      return true;
      if ((this.mIsDragging) && (this.mVelocityTracker != null))
      {
        this.mLastTouchX = getActiveX(paramMotionEvent);
        this.mLastTouchY = getActiveY(paramMotionEvent);
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        f1 = this.mVelocityTracker.getXVelocity();
        f2 = this.mVelocityTracker.getYVelocity();
        if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.mMinimumVelocity) {
          this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -f1, -f2);
        }
      }
    } while (this.mVelocityTracker == null);
    this.mVelocityTracker.recycle();
    this.mVelocityTracker = null;
    return true;
  }
  
  public void setOnGestureListener(OnGestureListener paramOnGestureListener)
  {
    this.mListener = paramOnGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.gestures.CupcakeGestureDetector
 * JD-Core Version:    0.7.0.1
 */