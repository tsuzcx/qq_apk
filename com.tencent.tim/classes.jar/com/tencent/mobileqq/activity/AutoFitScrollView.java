package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import mqq.os.MqqHandler;
import uhu;

public class AutoFitScrollView
  extends FrameLayout
{
  private long Fo;
  private uhu a;
  private boolean aRO;
  private boolean aRP;
  public int bEd;
  private int bEe;
  private int mItemWidth;
  private float mLastMotionX;
  private int mTouchSlop;
  private int mTouchState = 0;
  private VelocityTracker mVelocityTracker;
  private MqqHandler n;
  private float oT;
  private float oU;
  
  public AutoFitScrollView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AutoFitScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AutoFitScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.a = new uhu(getContext());
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setFitWidth(paramContext.getResources().getDisplayMetrics().widthPixels, 10);
  }
  
  public void bGx()
  {
    this.aRP = true;
  }
  
  public void bGy()
  {
    this.aRP = false;
  }
  
  public void computeScroll()
  {
    if (this.a.computeScrollOffset())
    {
      scrollTo(this.a.getCurrX(), this.a.getCurrY());
      postInvalidate();
    }
    while (!this.aRO) {
      return;
    }
    int i;
    if (this.n != null)
    {
      this.n.removeMessages(65539);
      this.n.removeMessages(65540);
      this.n.removeMessages(65538);
      i = this.bEd - getWidth();
      if (getScrollX() <= i) {
        break label151;
      }
      if (i <= 0) {
        break label159;
      }
    }
    for (;;)
    {
      Message localMessage = this.n.obtainMessage(65540, i, getScrollX() - this.bEe, Integer.valueOf(this.bEd));
      this.n.sendMessage(localMessage);
      this.n.sendEmptyMessageDelayed(65538, 3000L);
      this.aRO = false;
      return;
      label151:
      i = getScrollX();
      break;
      label159:
      i = 0;
    }
  }
  
  public void eQ(int paramInt1, int paramInt2)
  {
    if (this.a.getCurrX() == 0) {
      this.a.startScroll(this.a.getCurrX(), this.a.getCurrY(), paramInt1, paramInt2);
    }
    for (;;)
    {
      scrollTo(this.a.getCurrX(), this.a.getCurrY());
      postInvalidate();
      return;
      this.a.startScroll(this.a.getCurrX(), this.a.getCurrY(), paramInt1 - this.a.getCurrX(), paramInt2);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
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
        this.mLastMotionX = f1;
        this.oT = f2;
        if (this.a.isFinished()) {}
        for (i = 0;; i = 1)
        {
          this.mTouchState = i;
          break;
        }
        i = (int)(f1 - this.mLastMotionX);
        if ((Math.abs((int)(f2 - this.oT)) < Math.abs(i)) && (Math.abs(i) > this.mTouchSlop))
        {
          this.mTouchState = 1;
          continue;
          this.mTouchState = 0;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0) {
      getChildAt(0).layout(0, 0, this.bEd, paramInt4 - paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    super.onTouchEvent(paramMotionEvent);
    if (this.aRP) {}
    long l;
    do
    {
      return true;
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      float f = paramMotionEvent.getX();
      paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      default: 
        return true;
      case 0: 
        if ((this.a != null) && (!this.a.isFinished())) {
          this.a.abortAnimation();
        }
        this.oU = f;
        this.aRO = false;
        this.bEe = getScrollX();
        return true;
      case 2: 
        scrollBy((int)(this.oU - f), 0);
        this.oU = f;
        this.aRO = false;
        l = System.currentTimeMillis();
      }
    } while ((this.n == null) || (l - this.Fo <= 50L));
    this.Fo = l;
    this.n.removeMessages(65539);
    int i = this.bEd - getWidth();
    if (getScrollX() > i) {}
    for (;;)
    {
      if (i > 0) {
        j = i;
      }
      paramMotionEvent = this.n.obtainMessage(65539, j, this.mItemWidth);
      this.n.sendMessage(paramMotionEvent);
      return true;
      i = getScrollX();
    }
    paramMotionEvent = this.mVelocityTracker;
    paramMotionEvent.computeCurrentVelocity(1000);
    int k = (int)paramMotionEvent.getXVelocity();
    boolean bool;
    if (getChildCount() > 0)
    {
      if (Math.abs(k) <= 1000) {
        break label473;
      }
      j = this.a.eH(k);
      i = j;
      if (k > 0) {
        i = -j;
      }
      i = Math.round((i + getScrollX()) / this.mItemWidth);
      j = this.mItemWidth;
      paramMotionEvent = this.a;
      if (k >= 0) {
        break label436;
      }
      bool = true;
      i = paramMotionEvent.b(bool, Math.abs(j * i - getScrollX()));
      if (i >= 0) {
        break label442;
      }
      this.a.fling(getScrollX(), getScrollY(), -i, 0, 0, this.bEd - getWidth(), 0, 0);
      label401:
      postInvalidate();
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.mTouchState = 0;
      this.aRO = true;
      return true;
      label436:
      bool = false;
      break;
      label442:
      this.a.fling(getScrollX(), getScrollY(), -i, 0, 0, this.a.getCurrX(), 0, 0);
      break label401;
      label473:
      i = getScrollX();
      j = Math.max(Math.min(Math.round((i + 0.1F) / this.mItemWidth) * this.mItemWidth, this.bEd - getWidth()), 0);
      this.a.startScroll(i, getScrollY(), j - i, 0);
      postInvalidate();
    }
  }
  
  public void setCallback(MqqHandler paramMqqHandler)
  {
    this.n = paramMqqHandler;
  }
  
  public void setFitWidth(int paramInt1, int paramInt2)
  {
    this.mItemWidth = paramInt2;
    this.bEd = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoFitScrollView
 * JD-Core Version:    0.7.0.1
 */