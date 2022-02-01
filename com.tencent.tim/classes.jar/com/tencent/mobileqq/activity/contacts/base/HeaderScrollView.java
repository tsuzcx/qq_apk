package com.tencent.mobileqq.activity.contacts.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.app.FrameHelperActivity;
import yzo;
import yzo.a;

public class HeaderScrollView
  extends LinearLayout
{
  private int Fy;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView$a;
  private yzo jdField_a_of_type_Yzo;
  private int aLL;
  private boolean azx;
  private boolean bpX;
  public boolean bpY;
  private boolean bpZ;
  private int cbU;
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
  private int mMinimumVelocity;
  private Scroller mScroller;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private int topOffset;
  
  public HeaderScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HeaderScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeaderScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mScroller = new Scroller(paramContext);
    this.jdField_a_of_type_Yzo = new yzo();
    paramContext = ViewConfiguration.get(paramContext);
    this.mTouchSlop = paramContext.getScaledTouchSlop();
    this.mMinimumVelocity = paramContext.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = paramContext.getScaledMaximumFlingVelocity();
    this.cbU = Build.VERSION.SDK_INT;
  }
  
  private void U(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
  }
  
  @SuppressLint({"NewApi"})
  private int ak(int paramInt1, int paramInt2)
  {
    if (this.mScroller == null) {
      return 0;
    }
    if (this.cbU >= 14) {
      return (int)this.mScroller.getCurrVelocity();
    }
    return paramInt1 / paramInt2;
  }
  
  private int al(int paramInt1, int paramInt2)
  {
    return paramInt1 - paramInt2;
  }
  
  private void aw(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt3 <= paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      this.bpX = bool;
      return;
    }
  }
  
  private void recycleVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public boolean US()
  {
    return this.Fy == this.cbW;
  }
  
  public boolean UT()
  {
    return (this.Fy == this.aLL) && (this.jdField_a_of_type_Yzo.isTop());
  }
  
  public void computeScroll()
  {
    int i;
    if (this.mScroller.computeScrollOffset())
    {
      i = this.mScroller.getCurrY();
      if (this.mDirection != 1) {
        break label101;
      }
      if (US())
      {
        i = this.mScroller.getFinalY() - i;
        int j = al(this.mScroller.getDuration(), this.mScroller.timePassed());
        this.jdField_a_of_type_Yzo.smoothScrollBy(ak(i, j), i, j);
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
      label101:
      if ((this.jdField_a_of_type_Yzo.isTop()) || (this.bpX))
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
      this.jdField_a_of_type_Yzo.setChildViewCanAction(true);
      this.bpZ = false;
      this.azx = false;
      this.bpY = false;
      this.mDownX = f3;
      this.mDownY = f4;
      this.mLastY = f4;
      this.mDeltaY = 0.0F;
      aw((int)f4, this.cbV, getScrollY());
      this.mScroller.abortAnimation();
      continue;
      if (!this.azx)
      {
        this.mDeltaY = (this.mLastY - f4);
        this.mLastY = f4;
        if ((f1 > this.mTouchSlop) && (f1 > 2.0F * f2)) {}
        boolean bool;
        for (this.bpY = false;; this.bpY = true) {
          do
          {
            bool = US();
            if ((!this.bpY) || (((this.mDeltaY <= 0.0F) || (bool)) && (!this.jdField_a_of_type_Yzo.isTop()) && (!this.bpX))) {
              break;
            }
            if (!this.bpZ)
            {
              this.bpZ = true;
              this.jdField_a_of_type_Yzo.setChildViewCanAction(false);
            }
            scrollBy(0, (int)(this.mDeltaY + 0.5D));
            invalidate();
            break;
          } while ((f2 <= this.mTouchSlop) || (f2 <= f1));
        }
        if (this.bpY)
        {
          if ((this.mDeltaY < 0.0F) || (!US()))
          {
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            f3 = this.mVelocityTracker.getYVelocity();
            if (f3 <= 0.0F) {
              break label467;
            }
          }
          label467:
          for (int i = 2;; i = 1)
          {
            this.mDirection = i;
            this.mScroller.fling(0, getScrollY(), 0, -(int)f3, 0, 0, -2147483647, 2147483647);
            this.mLastScrollerY = getScrollY();
            invalidate();
            if (((f1 <= this.mTouchSlop) && (f2 <= this.mTouchSlop)) || ((!this.bpX) && (US()))) {
              break;
            }
            i = paramMotionEvent.getAction();
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            paramMotionEvent.setAction(i);
            return bool;
          }
        }
        FrameHelperActivity.EO(true);
        recycleVelocityTracker();
        continue;
        FrameHelperActivity.EO(true);
        recycleVelocityTracker();
      }
    }
  }
  
  public int kk()
  {
    return this.cbW;
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
    if (this.mHeadView.getVisibility() == 8) {}
    for (this.cbV = 0;; this.cbV = this.mHeadView.getMeasuredHeight())
    {
      this.cbW = (this.cbV - this.topOffset);
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) + this.cbW, 1073741824));
      return;
    }
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView$a.onScroll(i, this.cbW);
      }
      super.scrollTo(paramInt1, i);
      return;
      i = paramInt2;
      if (paramInt2 <= this.aLL) {
        i = this.aLL;
      }
    }
  }
  
  public void setCurrentScrollableContainer(yzo.a parama)
  {
    this.jdField_a_of_type_Yzo.setCurrentScrollableContainer(parama);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView$a = parama;
  }
  
  public void setTopOffset(int paramInt)
  {
    this.topOffset = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void onScroll(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.HeaderScrollView
 * JD-Core Version:    0.7.0.1
 */