package com.tencent.qqmail.view.listscroller;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class MyGestureDetector
{
  protected static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
  protected static final int LONGPRESS_TIMEOUT = ;
  protected static final int LONG_PRESS = 2;
  protected static final int SHOW_PRESS = 1;
  protected static final int TAP = 3;
  protected static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
  protected boolean mAlwaysInBiggerTapRegion;
  protected boolean mAlwaysInTapRegion;
  protected int mBiggerTouchSlopSquare = 400;
  protected MotionEvent mCurrentDownEvent;
  protected GestureDetector.OnDoubleTapListener mDoubleTapListener;
  protected int mDoubleTapSlopSquare;
  protected final Handler mHandler;
  protected boolean mInLongPress;
  protected boolean mIsDoubleTapping;
  protected boolean mIsLongpressEnabled;
  protected float mLastMotionX;
  protected float mLastMotionY;
  protected final GestureDetector.OnGestureListener mListener;
  protected int mMaximumFlingVelocity;
  protected int mMinimumFlingVelocity;
  protected MotionEvent mPreviousUpEvent;
  protected boolean mStillDown;
  protected int mTouchSlopSquare;
  protected VelocityTracker mVelocityTracker;
  
  public MyGestureDetector(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, null);
  }
  
  public MyGestureDetector(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (this.mHandler = new GestureHandler(paramHandler);; this.mHandler = new GestureHandler())
    {
      this.mListener = paramOnGestureListener;
      if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
        setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
      }
      init(paramContext);
      return;
    }
  }
  
  public MyGestureDetector(GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(null, paramOnGestureListener, null);
  }
  
  public MyGestureDetector(GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    this(null, paramOnGestureListener, paramHandler);
  }
  
  private void dispatchLongPress()
  {
    this.mHandler.removeMessages(3);
    this.mInLongPress = true;
    this.mListener.onLongPress(this.mCurrentDownEvent);
  }
  
  private void init(Context paramContext)
  {
    if (this.mListener == null) {
      throw new NullPointerException("OnGestureListener must not be null");
    }
    this.mIsLongpressEnabled = true;
    int j;
    int i;
    if (paramContext == null)
    {
      j = ViewConfiguration.getTouchSlop();
      i = 100;
      this.mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
    }
    for (this.mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();; this.mMaximumFlingVelocity = paramContext.getScaledMaximumFlingVelocity())
    {
      this.mTouchSlopSquare = (j * j);
      this.mDoubleTapSlopSquare = (i * i);
      return;
      paramContext = ViewConfiguration.get(paramContext);
      j = paramContext.getScaledTouchSlop();
      i = paramContext.getScaledDoubleTapSlop();
      this.mMinimumFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
    }
  }
  
  protected boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
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
  
  public boolean isLongpressEnabled()
  {
    return this.mIsLongpressEnabled;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    float f2 = paramMotionEvent.getX();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    boolean bool2;
    float f3;
    float f4;
    int j;
    switch (i)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
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
          this.mLastMotionX = f2;
          this.mLastMotionY = f1;
          this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
          this.mAlwaysInBiggerTapRegion = true;
          this.mStillDown = true;
          this.mInLongPress = false;
          this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
          return this.mListener.onDown(paramMotionEvent) | bool1;
          this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
        }
      } while (this.mInLongPress);
      f3 = this.mLastMotionX - f2;
      f4 = this.mLastMotionY - f1;
      if (this.mIsDoubleTapping) {
        return false | this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
      }
      if (this.mAlwaysInTapRegion)
      {
        j = (int)(f2 - this.mCurrentDownEvent.getX());
        int k = (int)(f1 - this.mCurrentDownEvent.getY());
        j = j * j + k * k;
        if (j <= this.mTouchSlopSquare) {
          break label758;
        }
        bool2 = this.mListener.onScroll(this.mCurrentDownEvent, paramMotionEvent, f3, f4);
        this.mLastMotionX = f2;
        this.mLastMotionY = f1;
        this.mAlwaysInTapRegion = false;
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (j > this.mBiggerTouchSlopSquare) {
        this.mAlwaysInBiggerTapRegion = false;
      }
      return bool2;
      if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
        break;
      }
      bool2 = this.mListener.onScroll(this.mCurrentDownEvent, paramMotionEvent, f3, f4);
      this.mLastMotionX = f2;
      this.mLastMotionY = f1;
      return bool2;
      this.mStillDown = false;
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (this.mIsDoubleTapping) {
        bool2 = this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        this.mPreviousUpEvent = MotionEvent.obtain(paramMotionEvent);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mIsDoubleTapping = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        localMotionEvent.recycle();
        return bool2;
        if (this.mInLongPress)
        {
          this.mHandler.removeMessages(3);
          this.mInLongPress = false;
          bool2 = false;
        }
        else if (this.mAlwaysInTapRegion)
        {
          bool2 = this.mListener.onSingleTapUp(paramMotionEvent);
        }
        else
        {
          VelocityTracker localVelocityTracker = this.mVelocityTracker;
          localVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
          f1 = localVelocityTracker.getYVelocity();
          f2 = localVelocityTracker.getXVelocity();
          if ((Math.abs(f1) > this.mMinimumFlingVelocity) || (Math.abs(f2) > this.mMinimumFlingVelocity))
          {
            bool2 = this.mListener.onFling(this.mCurrentDownEvent, localMotionEvent, f2, f1);
            continue;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            if (!this.mInLongPress) {
              break;
            }
            this.mInLongPress = false;
            return false;
          }
          bool2 = false;
        }
      }
      label758:
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
  
  class GestureHandler
    extends Handler
  {
    GestureHandler() {}
    
    GestureHandler(Handler paramHandler)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        throw new RuntimeException("Unknown message " + paramMessage);
      case 1: 
        MyGestureDetector.this.mListener.onShowPress(MyGestureDetector.this.mCurrentDownEvent);
      }
      do
      {
        return;
        MyGestureDetector.this.dispatchLongPress();
        return;
      } while ((MyGestureDetector.this.mDoubleTapListener == null) || (MyGestureDetector.this.mStillDown));
      MyGestureDetector.this.mDoubleTapListener.onSingleTapConfirmed(MyGestureDetector.this.mCurrentDownEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.listscroller.MyGestureDetector
 * JD-Core Version:    0.7.0.1
 */