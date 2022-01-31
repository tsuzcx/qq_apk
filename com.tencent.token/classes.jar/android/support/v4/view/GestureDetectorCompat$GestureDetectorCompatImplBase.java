package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class GestureDetectorCompat$GestureDetectorCompatImplBase
  implements GestureDetectorCompat.GestureDetectorCompatImpl
{
  private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
  private static final int LONGPRESS_TIMEOUT = ;
  private static final int LONG_PRESS = 2;
  private static final int SHOW_PRESS = 1;
  private static final int TAP = 3;
  private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
  private boolean mAlwaysInBiggerTapRegion;
  private boolean mAlwaysInTapRegion;
  MotionEvent mCurrentDownEvent;
  boolean mDeferConfirmSingleTap;
  GestureDetector.OnDoubleTapListener mDoubleTapListener;
  private int mDoubleTapSlopSquare;
  private float mDownFocusX;
  private float mDownFocusY;
  private final Handler mHandler;
  private boolean mInLongPress;
  private boolean mIsDoubleTapping;
  private boolean mIsLongpressEnabled;
  private float mLastFocusX;
  private float mLastFocusY;
  final GestureDetector.OnGestureListener mListener;
  private int mMaximumFlingVelocity;
  private int mMinimumFlingVelocity;
  private MotionEvent mPreviousUpEvent;
  boolean mStillDown;
  private int mTouchSlopSquare;
  private VelocityTracker mVelocityTracker;
  
  GestureDetectorCompat$GestureDetectorCompatImplBase(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (this.mHandler = new GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(this, paramHandler);; this.mHandler = new GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(this))
    {
      this.mListener = paramOnGestureListener;
      if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
        setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
      }
      init(paramContext);
      return;
    }
  }
  
  private void cancel()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
    this.mHandler.removeMessages(3);
    this.mVelocityTracker.recycle();
    this.mVelocityTracker = null;
    this.mIsDoubleTapping = false;
    this.mStillDown = false;
    this.mAlwaysInTapRegion = false;
    this.mAlwaysInBiggerTapRegion = false;
    this.mDeferConfirmSingleTap = false;
    if (this.mInLongPress) {
      this.mInLongPress = false;
    }
  }
  
  private void cancelTaps()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
    this.mHandler.removeMessages(3);
    this.mIsDoubleTapping = false;
    this.mAlwaysInTapRegion = false;
    this.mAlwaysInBiggerTapRegion = false;
    this.mDeferConfirmSingleTap = false;
    if (this.mInLongPress) {
      this.mInLongPress = false;
    }
  }
  
  private void init(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null");
    }
    if (this.mListener == null) {
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    this.mIsLongpressEnabled = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i = paramContext.getScaledTouchSlop();
    int j = paramContext.getScaledDoubleTapSlop();
    this.mMinimumFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
    this.mMaximumFlingVelocity = paramContext.getScaledMaximumFlingVelocity();
    this.mTouchSlopSquare = (i * i);
    this.mDoubleTapSlopSquare = (j * j);
  }
  
  private boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (!this.mAlwaysInBiggerTapRegion) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > DOUBLE_TAP_TIMEOUT);
      i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= this.mDoubleTapSlopSquare);
    return true;
  }
  
  void dispatchLongPress()
  {
    this.mHandler.removeMessages(3);
    this.mDeferConfirmSingleTap = false;
    this.mInLongPress = true;
    this.mListener.onLongPress(this.mCurrentDownEvent);
  }
  
  public boolean isLongpressEnabled()
  {
    return this.mIsLongpressEnabled;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i;
    int k;
    label53:
    int n;
    int m;
    float f1;
    float f2;
    if ((i1 & 0xFF) == 6)
    {
      i = 1;
      if (i == 0) {
        break label95;
      }
      k = paramMotionEvent.getActionIndex();
      n = paramMotionEvent.getPointerCount();
      m = 0;
      f1 = 0.0F;
      f2 = 0.0F;
      label66:
      if (m >= n) {
        break label122;
      }
      if (k != m) {
        break label101;
      }
    }
    for (;;)
    {
      m += 1;
      break label66;
      i = 0;
      break;
      label95:
      k = -1;
      break label53;
      label101:
      f2 += paramMotionEvent.getX(m);
      f1 += paramMotionEvent.getY(m);
    }
    label122:
    if (i != 0)
    {
      i = n - 1;
      f2 /= i;
      f1 /= i;
    }
    float f3;
    boolean bool2;
    float f4;
    int j;
    switch (i1 & 0xFF)
    {
    case 4: 
    default: 
    case 5: 
    case 6: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return false;
          i = n;
          break;
          this.mLastFocusX = f2;
          this.mDownFocusX = f2;
          this.mLastFocusY = f1;
          this.mDownFocusY = f1;
          cancelTaps();
          return false;
          this.mLastFocusX = f2;
          this.mDownFocusX = f2;
          this.mLastFocusY = f1;
          this.mDownFocusY = f1;
          this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
          k = paramMotionEvent.getActionIndex();
          i = paramMotionEvent.getPointerId(k);
          f1 = this.mVelocityTracker.getXVelocity(i);
          f2 = this.mVelocityTracker.getYVelocity(i);
          i = 0;
        } while (i >= n);
        if (i == k) {}
        do
        {
          i += 1;
          break;
          m = paramMotionEvent.getPointerId(i);
          f3 = this.mVelocityTracker.getXVelocity(m);
        } while (this.mVelocityTracker.getYVelocity(m) * f2 + f3 * f1 >= 0.0F);
        this.mVelocityTracker.clear();
        return false;
        if (this.mDoubleTapListener != null)
        {
          bool2 = this.mHandler.hasMessages(3);
          if (bool2) {
            this.mHandler.removeMessages(3);
          }
          if ((this.mCurrentDownEvent != null) && (this.mPreviousUpEvent != null) && (bool2) && (isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, paramMotionEvent))) {
            this.mIsDoubleTapping = true;
          }
        }
        for (boolean bool1 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
        {
          this.mLastFocusX = f2;
          this.mDownFocusX = f2;
          this.mLastFocusY = f1;
          this.mDownFocusY = f1;
          if (this.mCurrentDownEvent != null) {
            this.mCurrentDownEvent.recycle();
          }
          this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
          this.mAlwaysInTapRegion = true;
          this.mAlwaysInBiggerTapRegion = true;
          this.mStillDown = true;
          this.mInLongPress = false;
          this.mDeferConfirmSingleTap = false;
          if (this.mIsLongpressEnabled)
          {
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
          }
          this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
          return bool1 | this.mListener.onDown(paramMotionEvent);
          this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
        }
      } while (this.mInLongPress);
      f3 = this.mLastFocusX - f2;
      f4 = this.mLastFocusY - f1;
      if (this.mIsDoubleTapping) {
        return false | this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
      }
      if (this.mAlwaysInTapRegion)
      {
        j = (int)(f2 - this.mDownFocusX);
        k = (int)(f1 - this.mDownFocusY);
        j = j * j + k * k;
        if (j <= this.mTouchSlopSquare) {
          break label1136;
        }
        bool2 = this.mListener.onScroll(this.mCurrentDownEvent, paramMotionEvent, f3, f4);
        this.mLastFocusX = f2;
        this.mLastFocusY = f1;
        this.mAlwaysInTapRegion = false;
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (j > this.mTouchSlopSquare) {
        this.mAlwaysInBiggerTapRegion = false;
      }
      return bool2;
      if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
        break;
      }
      bool2 = this.mListener.onScroll(this.mCurrentDownEvent, paramMotionEvent, f3, f4);
      this.mLastFocusX = f2;
      this.mLastFocusY = f1;
      return bool2;
      this.mStillDown = false;
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (this.mIsDoubleTapping) {
        bool2 = this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        if (this.mPreviousUpEvent != null) {
          this.mPreviousUpEvent.recycle();
        }
        this.mPreviousUpEvent = localMotionEvent;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.mIsDoubleTapping = false;
        this.mDeferConfirmSingleTap = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        return bool2;
        if (this.mInLongPress)
        {
          this.mHandler.removeMessages(3);
          this.mInLongPress = false;
          bool2 = false;
        }
        else if (this.mAlwaysInTapRegion)
        {
          boolean bool3 = this.mListener.onSingleTapUp(paramMotionEvent);
          bool2 = bool3;
          if (this.mDeferConfirmSingleTap)
          {
            bool2 = bool3;
            if (this.mDoubleTapListener != null)
            {
              this.mDoubleTapListener.onSingleTapConfirmed(paramMotionEvent);
              bool2 = bool3;
            }
          }
        }
        else
        {
          VelocityTracker localVelocityTracker = this.mVelocityTracker;
          j = paramMotionEvent.getPointerId(0);
          localVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
          f1 = localVelocityTracker.getYVelocity(j);
          f2 = localVelocityTracker.getXVelocity(j);
          if ((Math.abs(f1) > this.mMinimumFlingVelocity) || (Math.abs(f2) > this.mMinimumFlingVelocity))
          {
            bool2 = this.mListener.onFling(this.mCurrentDownEvent, paramMotionEvent, f2, f1);
            continue;
            cancel();
            return false;
          }
          else
          {
            bool2 = false;
          }
        }
      }
      label1136:
      bool2 = false;
    }
  }
  
  public void setIsLongpressEnabled(boolean paramBoolean)
  {
    this.mIsLongpressEnabled = paramBoolean;
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.mDoubleTapListener = paramOnDoubleTapListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImplBase
 * JD-Core Version:    0.7.0.1
 */