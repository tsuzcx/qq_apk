package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.Conversation;
import hmd;
import java.util.Timer;

public class WorkSpaceView
  extends FrameLayout
{
  private static final int jdField_b_of_type_Int = 500;
  private static final int d = -2;
  private static final int f = 0;
  private static final int g = 1;
  private float jdField_a_of_type_Float;
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new hmd(this);
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  private WorkSpaceView.OnScreenChangeListener jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int c = 0;
  private int e = -2;
  private int h = 0;
  private int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  
  public WorkSpaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = this.c;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < getChildCount());
  }
  
  private void c()
  {
    int j = getWidth();
    a((getScrollX() + j / 2) / j);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return;
    }
    int j = Math.max(-1, Math.min(paramInt, getChildCount()));
    if (j != this.jdField_a_of_type_Int) {}
    for (paramInt = 1;; paramInt = 0)
    {
      this.e = j;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.jdField_a_of_type_Int))) {
        localView.clearFocus();
      }
      paramInt = getWidth() * j - getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt) * 2);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener.a(j);
      }
      invalidate();
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return;
    }
    int j = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (j != this.jdField_a_of_type_Int) {}
    for (paramInt = 1;; paramInt = 0)
    {
      this.e = j;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.jdField_a_of_type_Int))) {
        localView.clearFocus();
      }
      paramInt = getWidth() * j - getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt) * 2);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener.a(j);
      }
      invalidate();
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
    while (this.e == -2) {
      return;
    }
    if (this.e == -1)
    {
      this.jdField_a_of_type_Int = (getChildCount() - 1);
      scrollTo(this.jdField_a_of_type_Int * getWidth(), getScrollY());
    }
    for (;;)
    {
      this.e = -2;
      return;
      if (this.e == getChildCount())
      {
        this.jdField_a_of_type_Int = 0;
        scrollTo(0, getScrollY());
      }
      else
      {
        this.jdField_a_of_type_Int = Math.max(0, Math.min(this.e, getChildCount() - 1));
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int k = 0;
    int j;
    if ((this.h != 1) && (this.e == -2))
    {
      j = 1;
      if (j == 0) {
        break label65;
      }
      if ((paramCanvas != null) && (getChildAt(this.jdField_a_of_type_Int) != null)) {
        drawChild(paramCanvas, getChildAt(this.jdField_a_of_type_Int), getDrawingTime());
      }
    }
    label65:
    long l;
    label266:
    for (;;)
    {
      return;
      j = 0;
      break;
      l = getDrawingTime();
      int n = getWidth();
      float f1 = getScrollX() / n;
      int i1 = getChildCount();
      int m;
      if (f1 < 0.0F)
      {
        m = i1 - 1;
        j = 0;
        if (a(m))
        {
          if ((j != 0) || (k != 0)) {
            break label251;
          }
          int i2 = i1 * n;
          paramCanvas.translate(-i2, 0.0F);
          drawChild(paramCanvas, getChildAt(m), l);
          paramCanvas.translate(i2, 0.0F);
        }
      }
      for (;;)
      {
        if ((f1 == m) || (!a(j))) {
          break label266;
        }
        if ((j != 0) || (k == 0)) {
          break label268;
        }
        k = i1 * n;
        paramCanvas.translate(k, 0.0F);
        drawChild(paramCanvas, getChildAt(j), l);
        paramCanvas.translate(-k, 0.0F);
        return;
        m = Math.min((int)f1, i1 - 1);
        j = (m + 1) % i1;
        k = 1;
        break;
        label251:
        drawChild(paramCanvas, getChildAt(m), l);
      }
    }
    label268:
    drawChild(paramCanvas, getChildAt(j), l);
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (a() > 0)
      {
        a(a() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (a() < getChildCount() - 1))
    {
      a(a() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (m)
    {
    default: 
      if (m == 0) {
        Conversation.d(false);
      }
      break;
    }
    for (;;)
    {
      if (this.h == 0) {
        break label236;
      }
      return true;
      int n = (int)Math.abs(f1 - this.jdField_a_of_type_Float);
      int i1 = (int)Math.abs(f2 - this.b);
      int k = this.i;
      if (n > k)
      {
        j = 1;
        label108:
        if (i1 <= k) {
          break label150;
        }
      }
      label150:
      for (k = 1;; k = 0)
      {
        double d1 = i1 / n;
        if ((j == 0) && (k == 0)) {
          break label156;
        }
        this.h = 1;
        break;
        j = 0;
        break label108;
      }
      label156:
      this.h = 0;
      break;
      this.jdField_a_of_type_Float = f1;
      this.b = f2;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {}
      for (int j = 0;; j = 1)
      {
        this.h = j;
        break;
      }
      this.h = 0;
      break;
      if ((m == 1) || (m == 3)) {
        Conversation.d(true);
      }
    }
    label236:
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = getMeasuredWidth();
        localView.layout(paramInt2, 0, paramInt2 + paramInt3, getMeasuredHeight());
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int k = getChildCount();
    int j = 0;
    while (j < k)
    {
      getChildAt(j).measure(paramInt1, paramInt2);
      j += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    switch (j)
    {
    default: 
      if (j == 0) {
        Conversation.d(false);
      }
      break;
    }
    label301:
    while ((j != 1) && (j != 3))
    {
      return true;
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
      this.jdField_a_of_type_Float = f1;
      this.h = 1;
      break;
      if (this.h != 1) {
        break;
      }
      int k = (int)(this.jdField_a_of_type_Float - f1);
      this.jdField_a_of_type_Float = f1;
      int m = getScrollX();
      if (k < 0)
      {
        if (m > 0)
        {
          scrollBy(Math.max(-m, k), 0);
          break;
        }
        if (m <= -getWidth()) {
          break;
        }
        scrollBy(k, 0);
        break;
      }
      if (k <= 0) {
        break;
      }
      m = getChildAt(getChildCount() - 1).getRight() - m;
      if (m <= 0) {
        break;
      }
      scrollBy(Math.min(m, k), 0);
      break;
      if (this.h == 1)
      {
        paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000);
        k = (int)paramMotionEvent.getXVelocity();
        if ((k <= 500) || (this.jdField_a_of_type_Int <= -1)) {
          break label301;
        }
        a(this.jdField_a_of_type_Int - 1);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        this.h = 0;
        break;
        if ((k < -500) && (this.jdField_a_of_type_Int < getChildCount())) {
          a(this.jdField_a_of_type_Int + 1);
        } else {
          c();
        }
      }
    }
    Conversation.d(true);
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    paramView1 = new Rect();
    paramView2.getDrawingRect(paramView1);
    paramView2.requestRectangleOnScreen(paramView1);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int j = indexOfChild(paramView);
    if ((j != this.jdField_a_of_type_Int) || (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()))
    {
      a(j);
      return true;
    }
    return false;
  }
  
  public void setOnScreenChangeListener(WorkSpaceView.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener = paramOnScreenChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WorkSpaceView
 * JD-Core Version:    0.7.0.1
 */