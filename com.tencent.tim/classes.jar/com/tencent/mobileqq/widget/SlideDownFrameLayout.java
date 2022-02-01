package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import aqcx;
import arjd;
import arje;
import arjf;

public class SlideDownFrameLayout
  extends FrameLayout
{
  private a a;
  private int aEp = 0;
  private float iq;
  private float mTouchY;
  private VelocityTracker mVelocityTracker;
  
  public SlideDownFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void ejc()
  {
    if (this.a == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.a.aj().getY(), 0.0F });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new arjd(this));
    localValueAnimator.start();
  }
  
  public void ejd()
  {
    if (this.a == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.a.aj().getY(), this.a.aj().getHeight() });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new arje(this));
    localValueAnimator.addListener(new arjf(this));
    localValueAnimator.start();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a == null) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    this.mTouchY = paramMotionEvent.getY();
    if (i == 0)
    {
      this.iq = this.mTouchY;
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      float f = Math.abs(this.mTouchY - this.iq);
      if ((this.aEp == 0) && (f < aqcx.dip2px(getContext(), 5.0F))) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      f = this.mTouchY - this.iq;
      if (Math.abs(f) > 0.0F)
      {
        if ((this.aEp == 0) && (f > 0.0F))
        {
          if (this.a.BU())
          {
            this.iq = this.mTouchY;
            this.aEp = 1;
            return true;
          }
          this.iq = this.mTouchY;
          return super.onInterceptTouchEvent(paramMotionEvent);
        }
      }
      else
      {
        this.iq = this.mTouchY;
        this.aEp = 0;
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
    }
    else if ((i == 1) || (i == 3))
    {
      this.aEp = 0;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    this.mTouchY = paramMotionEvent.getY();
    if (i == 0) {
      this.iq = this.mTouchY;
    }
    do
    {
      do
      {
        return super.onTouchEvent(paramMotionEvent);
        if (i != 2) {
          break;
        }
      } while (this.aEp != 1);
      if (this.a != null)
      {
        this.a.aj().setY(Math.max(this.mTouchY - this.iq, 0.0F));
        this.a.c(Math.max(this.mTouchY - this.iq, 0.0F), this.a.aj().getHeight());
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      return true;
    } while ((i != 1) && (i != 3));
    if ((this.aEp != 0) && (this.a != null) && (this.mVelocityTracker != null))
    {
      float f = this.a.aj().getY();
      this.mVelocityTracker.computeCurrentVelocity(1000);
      if ((f <= aqcx.dip2px(getContext(), 100.0F)) && ((f <= aqcx.dip2px(getContext(), 30.0F)) || (this.mVelocityTracker.getYVelocity() <= 1000.0F))) {
        break label262;
      }
      ejd();
    }
    for (;;)
    {
      this.aEp = 0;
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      break;
      label262:
      ejc();
    }
  }
  
  public void setOnSlideListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean BU();
    
    public abstract void aKG();
    
    public abstract View aj();
    
    public abstract void c(float paramFloat, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDownFrameLayout
 * JD-Core Version:    0.7.0.1
 */