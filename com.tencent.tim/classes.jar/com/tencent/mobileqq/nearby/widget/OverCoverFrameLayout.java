package com.tencent.mobileqq.nearby.widget;

import akku;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;

public class OverCoverFrameLayout
  extends FrameLayout
{
  public a a;
  private boolean ahD;
  protected boolean csD = true;
  private boolean csE;
  protected boolean csF = true;
  public int csM;
  protected int dnr;
  protected int dns;
  protected final int dnt = 200;
  public int dnu;
  protected Context mContext;
  protected int mDownY;
  protected GestureDetector mGestureDetector;
  protected Scroller mScroller;
  
  public OverCoverFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public OverCoverFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public boolean arS()
  {
    if (!this.csD) {}
    while (!this.mScroller.isFinished()) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OverCoverFrameLayout", 2, "slideUp, isFgViewOnBottom=" + this.csD);
    }
    this.mScroller.abortAnimation();
    this.csE = true;
    this.ahD = false;
    this.mScroller.startScroll(this.dnr, 0, -this.dnr, 0, 200);
    if (this.a != null) {
      this.a.m(1, 0, this.dnr);
    }
    invalidate();
    this.csD = false;
    return true;
  }
  
  public boolean arT()
  {
    if (this.csD) {}
    while (!this.mScroller.isFinished()) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OverCoverFrameLayout", 2, "slideDown, isFgViewOnBottom=" + this.csD);
    }
    this.mScroller.abortAnimation();
    this.csE = false;
    this.ahD = true;
    this.mScroller.startScroll(0, 0, this.dnr, 0, 200);
    if (this.a != null) {
      this.a.m(1, 1, 0);
    }
    invalidate();
    this.csD = true;
    return true;
  }
  
  public boolean arU()
  {
    return this.csD;
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      this.dns = this.mScroller.getCurrX();
      invalidate();
      requestLayout();
    }
  }
  
  protected void dBE()
  {
    if (((this.csE) || (this.ahD)) && (this.mScroller.isFinished()) && ((this.dns == this.dnr) || (this.dns == 0))) {
      if (this.a != null)
      {
        if ((!this.csE) || (this.dns != 0)) {
          break label90;
        }
        this.a.m(0, 0, this.dns);
      }
    }
    for (;;)
    {
      this.csE = false;
      this.ahD = false;
      return;
      label90:
      if ((this.ahD) && (this.dns == this.dnr)) {
        this.a.m(0, 1, this.dns);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int k = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    switch (k)
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("OverCoverFrameLayout", 2, "dispatchTouchEvent, action=" + k + ", ret=" + bool + ", distance=" + i + ", isNeedDetector=" + this.csF + ", mBgViewHeight=" + this.dnr);
      }
      return bool;
      View localView = getChildAt(0);
      if (this.csD) {
        if ((localView != null) && (j <= localView.getHeight())) {
          this.csF = false;
        }
      }
      for (;;)
      {
        this.mDownY = j;
        break;
        this.csF = true;
        continue;
        this.csF = true;
      }
      j -= this.mDownY;
      i = j;
      if (this.csF) {
        if (j > 0)
        {
          i = j;
          if (Math.abs(j) >= (int)(this.dnr * 0.8D)) {
            i = j;
          }
        }
        else
        {
          i = j;
          if (j < 0)
          {
            i = j;
            if (Math.abs(j) >= this.dnu)
            {
              i = j;
              continue;
              this.csF = true;
            }
          }
        }
      }
    }
  }
  
  protected void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mScroller = new Scroller(paramContext, new LinearInterpolator());
    this.dnu = ViewConfiguration.getTouchSlop();
    this.csM = ViewConfiguration.getMinimumFlingVelocity();
    if (QLog.isColorLevel()) {
      QLog.d("OverCoverFrameLayout", 2, "init: minDis=" + this.dnu + ", minVelocity=" + this.csM);
    }
    this.mGestureDetector = new GestureDetector(paramContext, new akku(this));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView1 = getChildAt(0);
    View localView2 = getChildAt(1);
    localView1.layout(0, 0, localView1.getMeasuredWidth(), localView1.getMeasuredHeight());
    if (localView2 != null)
    {
      localView2.layout(0, this.dns, localView2.getMeasuredWidth(), getMeasuredHeight());
      dBE();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getChildAt(0).getMeasuredHeight();
    if (this.dnr != paramInt1)
    {
      this.dnr = paramInt1;
      this.mScroller.abortAnimation();
      if (this.csD) {
        this.dns = this.dnr;
      }
    }
    else
    {
      return;
    }
    this.dns = 0;
  }
  
  public void setOnActionListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean Ne();
    
    public abstract boolean m(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout
 * JD-Core Version:    0.7.0.1
 */