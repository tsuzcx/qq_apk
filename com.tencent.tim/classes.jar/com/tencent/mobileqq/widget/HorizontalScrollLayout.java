package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class HorizontalScrollLayout
  extends LinearLayout
{
  private int egs;
  private float mLastMotionX;
  private float mLastMotionY;
  private Scroller mScroller;
  private int mTouchSlop;
  private int mTouchState = 0;
  private VelocityTracker mVelocityTracker;
  private int screenWidth;
  
  public HorizontalScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mScroller = new Scroller(paramContext);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.screenWidth = MG();
  }
  
  public int MG()
  {
    return getResources().getDisplayMetrics().widthPixels;
  }
  
  public void TI(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.egs <= 0)
      {
        i = -getScrollX();
        this.mScroller.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
        invalidate();
        return;
      }
      if (this.screenWidth + getScrollX() > this.egs) {}
      for (i = this.egs - getScrollX();; i = this.screenWidth) {
        break;
      }
    }
    if (-this.screenWidth + getScrollX() > 0) {}
    for (int i = -this.screenWidth;; i = getScrollX() * -1)
    {
      this.mScroller.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
      break;
    }
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public void eib()
  {
    int i = getScrollX();
    if (i < 0) {
      this.mScroller.startScroll(i, 0, -i, 0, Math.abs(i) * 1);
    }
    while (this.egs >= i)
    {
      invalidate();
      return;
    }
    if (this.egs <= 0) {}
    for (i = getScrollX();; i = getScrollX() - this.egs)
    {
      this.mScroller.startScroll(getScrollX(), 0, -i, 0, Math.abs(i) * 1);
      break;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mTouchState != 0)) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (i)
      {
      }
      while (this.mTouchState == 0)
      {
        return false;
        i = (int)Math.abs(this.mLastMotionX - f1);
        int j = (int)Math.abs(this.mLastMotionY - f2);
        if ((i > this.mTouchSlop) && (i > j))
        {
          this.mTouchState = 1;
          paramMotionEvent = getParent();
          if (paramMotionEvent != null)
          {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            continue;
            this.mLastMotionX = f1;
            this.mLastMotionY = f2;
            if (this.mScroller.isFinished()) {}
            for (i = 0;; i = 1)
            {
              this.mTouchState = i;
              break;
            }
            this.mTouchState = 0;
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (1 <= getChildCount()) {
      this.egs = (getChildAt(getChildCount() - 1).getRight() - this.screenWidth);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    switch (i)
    {
    default: 
      return true;
    case 0: 
      if (!this.mScroller.isFinished()) {
        this.mScroller.abortAnimation();
      }
      this.mLastMotionX = f;
      return true;
    case 2: 
      i = (int)(this.mLastMotionX - f);
      this.mLastMotionX = f;
      scrollBy(i, 0);
      return true;
    case 1: 
      paramMotionEvent = this.mVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i = (int)paramMotionEvent.getXVelocity();
      if (i > 600) {
        TI(false);
      }
      for (;;)
      {
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.mTouchState = 0;
        return true;
        if (i < -600) {
          TI(true);
        } else {
          eib();
        }
      }
    }
    eib();
    this.mTouchState = 0;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HorizontalScrollLayout
 * JD-Core Version:    0.7.0.1
 */