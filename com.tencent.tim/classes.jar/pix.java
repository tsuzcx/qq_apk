import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class pix
{
  private pja a;
  private int mActivePointerId = -1;
  private int mActivePointerIndex;
  private final ScaleGestureDetector mDetector;
  private boolean mIsDragging;
  private float mLastTouchX;
  private float mLastTouchY;
  private final float mMinimumVelocity;
  private final float mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public pix(Context paramContext, pja parampja)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.a = parampja;
    this.mDetector = new ScaleGestureDetector(paramContext, new piy(this));
  }
  
  private boolean D(MotionEvent paramMotionEvent)
  {
    int j = 0;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    label259:
    do
    {
      for (;;)
      {
        i = j;
        if (this.mActivePointerId != -1) {
          i = this.mActivePointerId;
        }
        this.mActivePointerIndex = paramMotionEvent.findPointerIndex(i);
        return true;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mVelocityTracker = VelocityTracker.obtain();
        if (this.mVelocityTracker != null) {
          this.mVelocityTracker.addMovement(paramMotionEvent);
        }
        this.mLastTouchX = getActiveX(paramMotionEvent);
        this.mLastTouchY = getActiveY(paramMotionEvent);
        this.mIsDragging = false;
        continue;
        float f1 = getActiveX(paramMotionEvent);
        float f2 = getActiveY(paramMotionEvent);
        i = paramMotionEvent.getPointerCount();
        float f3 = f1 - this.mLastTouchX;
        float f4 = f2 - this.mLastTouchY;
        if (!this.mIsDragging) {
          if (Math.sqrt(f3 * f3 + f4 * f4) < this.mTouchSlop) {
            break label259;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          this.mIsDragging = bool;
          if (i > 1) {
            this.mIsDragging = false;
          }
          if (!this.mIsDragging) {
            break;
          }
          this.mLastTouchX = f1;
          this.mLastTouchY = f2;
          if (this.mVelocityTracker == null) {
            break;
          }
          this.mVelocityTracker.addMovement(paramMotionEvent);
          break;
        }
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
          continue;
          this.mActivePointerId = -1;
          if ((this.mIsDragging) && (this.mVelocityTracker != null))
          {
            this.mLastTouchX = getActiveX(paramMotionEvent);
            this.mLastTouchY = getActiveY(paramMotionEvent);
            this.mVelocityTracker.addMovement(paramMotionEvent);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            f1 = this.mVelocityTracker.getXVelocity();
            f2 = this.mVelocityTracker.getYVelocity();
            if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.mMinimumVelocity) {
              this.a.onFling(this.mLastTouchX, this.mLastTouchY, -f1, -f2);
            }
          }
          if (this.mVelocityTracker != null)
          {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
          }
        }
      }
      i = pjm.getPointerIndex(paramMotionEvent.getAction());
    } while (paramMotionEvent.getPointerId(i) != this.mActivePointerId);
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      this.mLastTouchX = paramMotionEvent.getX(i);
      this.mLastTouchY = paramMotionEvent.getY(i);
      break;
    }
  }
  
  private float getActiveX(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getX(this.mActivePointerIndex);
      return f;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getX();
  }
  
  private float getActiveY(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getY(this.mActivePointerIndex);
      return f;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getY();
  }
  
  public boolean isDragging()
  {
    return this.mIsDragging;
  }
  
  public boolean isScaling()
  {
    return this.mDetector.isInProgress();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    try
    {
      boolean bool3 = this.mDetector.onTouchEvent(paramMotionEvent);
      boolean bool4 = D(paramMotionEvent);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pix
 * JD-Core Version:    0.7.0.1
 */