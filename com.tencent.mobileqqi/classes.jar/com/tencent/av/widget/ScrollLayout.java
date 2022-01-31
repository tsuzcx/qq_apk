package com.tencent.av.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.av.utils.ScrollListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ScrollLayout
  extends ViewGroup
{
  static final int jdField_a_of_type_Int = 0;
  static final String jdField_a_of_type_JavaLangString = "ScrollLayout";
  static final int jdField_b_of_type_Int = 1;
  static final int c = 600;
  float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  Scroller jdField_a_of_type_AndroidWidgetScroller;
  ScrollListener jdField_a_of_type_ComTencentAvUtilsScrollListener = null;
  ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  float jdField_b_of_type_Float;
  int d = 0;
  int e = 0;
  int f = 1;
  int g = 0;
  int h;
  int i = 0;
  int j = 0;
  int k = 0;
  int l = 0;
  
  public ScrollLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.d = this.e;
    this.h = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.d = this.e;
    this.h = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a()
  {
    int m = super.getWidth();
    a((super.getScrollX() + m / 2) / m);
  }
  
  public void a(int paramInt)
  {
    paramInt = Math.max(0, Math.min(paramInt, super.getChildCount() - 1));
    if (super.getScrollX() != super.getWidth() * paramInt)
    {
      this.d = paramInt;
      paramInt = paramInt * super.getWidth() - super.getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(super.getScrollX(), 0, paramInt, 0, Math.abs(paramInt) * 2);
      super.invalidate();
      if (this.jdField_a_of_type_ComTencentAvUtilsScrollListener != null) {
        this.jdField_a_of_type_ComTencentAvUtilsScrollListener.a();
      }
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      super.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      super.postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = 1;
    if (QLog.isColorLevel()) {
      QLog.e("ScrollLayout", 2, "onItemClick In ScrollLayout onInterceptTouchEvent + Action=" + paramMotionEvent.getAction());
    }
    int n = paramMotionEvent.getAction();
    if ((n == 2) && (this.g != 0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (n)
    {
    }
    for (;;)
    {
      return false;
      if ((int)Math.abs(this.jdField_a_of_type_Float - f1) > this.h)
      {
        this.g = 1;
        continue;
        this.jdField_a_of_type_Float = f1;
        this.b = f2;
        if (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
          m = 0;
        }
        this.g = m;
        continue;
        this.g = 0;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = super.getChildCount();
    paramInt2 = this.i;
    paramInt1 = 0;
    while (paramInt1 < this.f)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = localView.getMeasuredWidth();
        localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
      paramInt2 = paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i1 = super.getChildCount();
    int m = 0;
    while (m < i1)
    {
      super.getChildAt(m).measure(paramInt1, paramInt2);
      m += 1;
    }
    super.scrollTo(this.d * n, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScrollLayout", 2, "ClickItem:Event In ScrollLayout --> Action=" + paramMotionEvent.getAction());
    }
    if (this.f <= 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int m = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    switch (m)
    {
    default: 
      return true;
    case 0: 
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
      this.jdField_a_of_type_Float = f1;
      return true;
    case 2: 
      m = (int)(this.jdField_a_of_type_Float - f1);
      this.jdField_a_of_type_Float = f1;
      super.scrollBy(m, 0);
      return true;
    case 1: 
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      m = (int)paramMotionEvent.getXVelocity();
      if ((m > 600) && (this.d > 0)) {
        a(this.d - 1);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        this.g = 0;
        return true;
        if ((m < -600) && (this.d < super.getChildCount() - 1)) {
          a(this.d + 1);
        } else {
          a();
        }
      }
    }
    this.g = 0;
    return true;
  }
  
  public void setOnScrollListener(ScrollListener paramScrollListener)
  {
    this.jdField_a_of_type_ComTencentAvUtilsScrollListener = paramScrollListener;
  }
  
  public void setPagePos(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setToPage(int paramInt)
  {
    paramInt = Math.max(0, Math.min(paramInt, super.getChildCount() - 1));
    this.d = paramInt;
    super.scrollTo(paramInt * super.getWidth(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.widget.ScrollLayout
 * JD-Core Version:    0.7.0.1
 */