package com.tencent.mobileqq.nearby.profilecard;

import akhn;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NestScrollLayout
  extends LinearLayout
{
  private int Fy;
  private akhn a;
  private int aLL;
  private boolean bpY;
  private int cbV;
  private int cbW;
  private float mDeltaY;
  private int mDirection;
  private float mDownX;
  private float mDownY;
  private View mHeadView;
  private int mLastScrollerY;
  private float mLastY;
  private int mMaximumVelocity;
  private Scroller mScroller;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private int topOffset;
  
  public NestScrollLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = paramContext.getResources().getDimensionPixelSize(2131299627) + ImmersiveUtils.getStatusBarHeight(paramContext);
    this.topOffset = paramInt;
    this.topOffset = paramInt;
    this.mScroller = new Scroller(paramContext);
    this.a = new akhn();
    paramContext = ViewConfiguration.get(paramContext);
    this.mTouchSlop = paramContext.getScaledTouchSlop();
    this.mMaximumVelocity = paramContext.getScaledMaximumFlingVelocity();
  }
  
  private int GP()
  {
    return (int)this.mScroller.getCurrVelocity();
  }
  
  private void U(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private int al(int paramInt1, int paramInt2)
  {
    return paramInt1 - paramInt2;
  }
  
  private boolean arP()
  {
    return this.Fy == this.cbW;
  }
  
  private void recycleVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public void computeScroll()
  {
    int i;
    if (this.mScroller.computeScrollOffset())
    {
      i = this.mScroller.getCurrY();
      if (this.mDirection != 1) {
        break label99;
      }
      if (arP())
      {
        int j = this.mScroller.getFinalY();
        int k = al(this.mScroller.getDuration(), this.mScroller.timePassed());
        this.a.smoothScrollBy(GP(), j - i, k);
        this.mScroller.abortAnimation();
      }
    }
    else
    {
      return;
    }
    scrollTo(0, i);
    invalidate();
    for (;;)
    {
      this.mLastScrollerY = i;
      return;
      label99:
      if (this.a.isTop())
      {
        scrollTo(0, i - this.mLastScrollerY + getScrollY());
        if (this.Fy <= this.aLL)
        {
          this.mScroller.abortAnimation();
          return;
        }
      }
      invalidate();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    float f1 = Math.abs(f3 - this.mDownX);
    float f2 = Math.abs(f4 - this.mDownY);
    U(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      this.bpY = false;
      this.mDownX = f3;
      this.mDownY = f4;
      this.mLastY = f4;
      this.mDeltaY = 0.0F;
      this.mScroller.abortAnimation();
      continue;
      this.mDeltaY = (this.mLastY - f4);
      this.mLastY = f4;
      if ((f1 > this.mTouchSlop) && (f1 > 2.0F * f2)) {}
      boolean bool;
      for (this.bpY = false;; this.bpY = true) {
        do
        {
          bool = arP();
          if ((!this.bpY) || (((this.mDeltaY <= 0.0F) || (bool)) && ((!this.a.isTop()) || (this.mDeltaY >= 0.0F)))) {
            break;
          }
          scrollBy(0, (int)(this.mDeltaY + 0.5D));
          invalidate();
          return true;
        } while ((f2 <= this.mTouchSlop) || (f2 <= f1));
      }
      if (this.bpY)
      {
        if ((this.mDeltaY < 0.0F) || (!arP()))
        {
          this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
          f3 = this.mVelocityTracker.getYVelocity();
          if (f3 <= 0.0F) {
            break label401;
          }
        }
        label401:
        for (int i = 2;; i = 1)
        {
          this.mDirection = i;
          this.mScroller.fling(0, getScrollY(), 0, -(int)f3, 0, 0, -2147483647, 2147483647);
          this.mLastScrollerY = getScrollY();
          invalidate();
          if (((f1 <= this.mTouchSlop) && (f2 <= this.mTouchSlop)) || (arP())) {
            break;
          }
          i = paramMotionEvent.getAction();
          paramMotionEvent.setAction(3);
          bool = super.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(i);
          return bool;
        }
      }
      recycleVelocityTracker();
      continue;
      recycleVelocityTracker();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if ((this.mHeadView != null) && (!this.mHeadView.isClickable())) {
      this.mHeadView.setClickable(true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mHeadView = getChildAt(0);
    measureChildWithMargins(this.mHeadView, paramInt1, 0, 0, 0);
    this.cbV = this.mHeadView.getMeasuredHeight();
    this.cbW = (this.cbV - this.topOffset);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) + this.cbW, 1073741824));
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    int j = getScrollY();
    int i = j + paramInt2;
    if (i >= this.cbW) {
      paramInt2 = this.cbW;
    }
    for (;;)
    {
      super.scrollBy(paramInt1, paramInt2 - j);
      return;
      paramInt2 = i;
      if (i <= this.aLL) {
        paramInt2 = this.aLL;
      }
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 >= this.cbW) {
      i = this.cbW;
    }
    for (;;)
    {
      this.Fy = i;
      super.scrollTo(paramInt1, i);
      return;
      i = paramInt2;
      if (paramInt2 <= this.aLL) {
        i = this.aLL;
      }
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.a.setPosition(paramInt);
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.a.setViewPager(paramViewPager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NestScrollLayout
 * JD-Core Version:    0.7.0.1
 */