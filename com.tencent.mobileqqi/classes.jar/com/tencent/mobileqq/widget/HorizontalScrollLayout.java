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
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 600;
  private static final int d = 1;
  private float jdField_a_of_type_Float;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private int e = 0;
  private int f;
  private int g;
  private int h = 0;
  
  public HorizontalScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.g = a();
  }
  
  public int a()
  {
    return getResources().getDisplayMetrics().widthPixels;
  }
  
  public void a()
  {
    int i = getScrollX();
    if (i < 0) {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, -i, 0, Math.abs(i) * 1);
    }
    while (this.h >= i)
    {
      invalidate();
      return;
    }
    if (this.h <= 0) {}
    for (i = getScrollX();; i = getScrollX() - this.h)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, -i, 0, Math.abs(i) * 1);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.h <= 0)
      {
        i = -getScrollX();
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
        invalidate();
        return;
      }
      if (this.g + getScrollX() > this.h) {}
      for (i = this.h - getScrollX();; i = this.g) {
        break;
      }
    }
    if (-this.g + getScrollX() > 0) {}
    for (int i = -this.g;; i = getScrollX() * -1)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
      break;
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.e != 0)) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      switch (i)
      {
      }
      while (this.e == 0)
      {
        return false;
        if ((int)Math.abs(this.jdField_a_of_type_Float - f1) > this.f)
        {
          this.e = 1;
          continue;
          this.jdField_a_of_type_Float = f1;
          if (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {}
          for (i = 0;; i = 1)
          {
            this.e = i;
            break;
          }
          this.e = 0;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (1 <= getChildCount()) {
      this.h = (getChildAt(getChildCount() - 1).getRight() - this.g);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    switch (i)
    {
    default: 
      return true;
    case 0: 
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished())
      {
        paramMotionEvent = getParent();
        if (paramMotionEvent != null) {
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
        }
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
      this.jdField_a_of_type_Float = f1;
      return true;
    case 2: 
      i = (int)(this.jdField_a_of_type_Float - f1);
      if (Math.abs(i) > this.f)
      {
        paramMotionEvent = getParent();
        if (paramMotionEvent != null) {
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
        }
      }
      this.jdField_a_of_type_Float = f1;
      scrollBy(i, 0);
      return true;
    case 1: 
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i = (int)paramMotionEvent.getXVelocity();
      if (i > 600) {
        a(false);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        this.e = 0;
        return true;
        if (i < -600) {
          a(true);
        } else {
          a();
        }
      }
    }
    a();
    this.e = 0;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HorizontalScrollLayout
 * JD-Core Version:    0.7.0.1
 */