package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import aqcx;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;

public class DragFrameLayout
  extends FrameLayout
{
  private a a;
  private int aEp = 0;
  protected boolean acR;
  private AnimationSet jdField_d_of_type_AndroidViewAnimationAnimationSet;
  private ScaleAnimation jdField_d_of_type_AndroidViewAnimationScaleAnimation;
  private TranslateAnimation h;
  private float iq;
  private float is;
  private View jk;
  private int mHeight;
  protected boolean mIsEnabled = true;
  private float mTouchX;
  private float mTouchY;
  private int mWidth;
  public int minWidth;
  
  public DragFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt, Interpolator paramInterpolator)
  {
    a(paramInt, paramInterpolator, null);
  }
  
  public void a(int paramInt, Interpolator paramInterpolator, Animation.AnimationListener paramAnimationListener)
  {
    float f1 = ViewHelper.getScaleX(this.jk);
    float f2 = ViewHelper.getScaleY(this.jk);
    if (this.h != null) {
      this.h.cancel();
    }
    this.h = new TranslateAnimation(0, ViewHelper.getX(this.jk), 0, 0.0F, 0, ViewHelper.getY(this.jk), 0, 0.0F);
    this.h.setDuration(paramInt);
    this.h.setFillAfter(true);
    if (paramAnimationListener != null) {
      this.h.setAnimationListener(paramAnimationListener);
    }
    if (this.jdField_d_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    this.jdField_d_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(f1, 1.0F, f2, 1.0F, 0.0F, 0.0F);
    this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setDuration(paramInt);
    this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    if (this.jdField_d_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_d_of_type_AndroidViewAnimationAnimationSet.cancel();
    }
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_d_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.h);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.setInterpolator(paramInterpolator);
    this.jk.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimationSet);
    this.acR = false;
  }
  
  @Deprecated
  public void onDestroy() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.h != null)
    {
      this.h.cancel();
      this.h = null;
    }
    if (this.jdField_d_of_type_AndroidViewAnimationScaleAnimation != null)
    {
      this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.cancel();
      this.jdField_d_of_type_AndroidViewAnimationScaleAnimation = null;
    }
    if (this.jdField_d_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_d_of_type_AndroidViewAnimationAnimationSet.cancel();
      this.jdField_d_of_type_AndroidViewAnimationAnimationSet = null;
    }
    if (this.jk != null)
    {
      this.jk.clearAnimation();
      AnimatorProxy.wrap(this.jk).reset();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.mIsEnabled) || (this.jk == null)) {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    do
    {
      return bool;
      if (paramMotionEvent.getPointerCount() > 1) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
    } while (this.acR);
    int i = paramMotionEvent.getAction();
    this.mTouchX = paramMotionEvent.getX();
    this.mTouchY = paramMotionEvent.getY();
    if (i == 0)
    {
      this.is = this.mTouchX;
      this.iq = this.mTouchY;
      if (this.mWidth == 0)
      {
        this.mWidth = super.getWidth();
        this.mHeight = super.getHeight();
      }
      this.jk.clearAnimation();
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      float f1 = Math.abs(this.mTouchX - this.is);
      float f2 = Math.abs(this.mTouchY - this.iq);
      if ((this.aEp == 0) && (f1 + f2 < aqcx.dip2px(getContext(), 10.0F))) {
        return false;
      }
      f1 = this.mTouchX - this.is;
      f2 = this.mTouchY - this.iq;
      if ((f2 < 0.0F) && (Math.abs(f2) > Math.abs(f1)) && (this.aEp == 0))
      {
        this.is = this.mTouchX;
        this.iq = this.mTouchY;
        return false;
      }
      if (Math.abs(f2) > 1.2D * Math.abs(f1))
      {
        if (this.aEp == 0)
        {
          if ((this.mIsEnabled) && (this.a.yB()))
          {
            this.is = this.mTouchX;
            this.iq = this.mTouchY;
            this.aEp = 1;
            return true;
          }
          this.is = this.mTouchX;
          this.iq = this.mTouchY;
          return false;
        }
      }
      else if (f1 < 0.0F)
      {
        if (this.aEp == 0)
        {
          if ((this.mIsEnabled) && (this.a.yC()))
          {
            this.is = this.mTouchX;
            this.iq = this.mTouchY;
            this.aEp = 2;
            return true;
          }
          this.is = this.mTouchX;
          this.iq = this.mTouchY;
          return false;
        }
      }
      else if (f1 > 0.0F)
      {
        if (this.aEp == 0)
        {
          if ((this.mIsEnabled) && (this.a != null) && (this.a.yD()))
          {
            this.is = this.mTouchX;
            this.iq = this.mTouchY;
            this.aEp = 4;
            return true;
          }
          this.is = this.mTouchX;
          this.iq = this.mTouchY;
          return false;
        }
      }
      else
      {
        this.is = this.mTouchX;
        this.iq = this.mTouchY;
        return false;
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mIsEnabled) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (this.acR) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    this.mTouchX = paramMotionEvent.getX();
    this.mTouchY = paramMotionEvent.getY();
    if (i == 0)
    {
      this.is = this.mTouchX;
      this.iq = this.mTouchY;
      return true;
    }
    float f3;
    float f5;
    float f1;
    float f4;
    float f2;
    if (i == 2)
    {
      f3 = this.mTouchX - this.is;
      f5 = this.mTouchY - this.iq;
      if (this.aEp == 1) {
        if (f5 > 0.0F)
        {
          f1 = (int)(this.mHeight - f5 * 1.1D);
          f4 = this.mWidth * f1 / this.mHeight;
          f2 = f1;
          f1 = f4;
        }
      }
    }
    for (;;)
    {
      f4 = f1;
      if (f1 <= this.minWidth)
      {
        f4 = this.minWidth;
        f2 = this.mHeight * f4 / this.mWidth;
      }
      if (this.aEp == 1)
      {
        f2 = f4 / this.mWidth;
        i = (int)(f3 + this.is - f4 * this.is / this.mWidth);
        if (f5 > 0.0F)
        {
          f1 = f5;
          label232:
          setSizeAndPosition(f2, i, (int)f1);
        }
      }
      do
      {
        return true;
        f1 = this.mHeight;
        break;
        if (this.aEp == 2)
        {
          if (f3 < 0.0F) {}
          for (f1 = (int)(this.mWidth + f3 * 1.1D);; f1 = this.mWidth)
          {
            f2 = this.mHeight * f1 / this.mWidth;
            break;
          }
        }
        if (this.aEp != 4) {
          break label637;
        }
        if (f3 > 0.0F) {}
        for (f1 = (int)(this.mWidth - f3 * 1.1D);; f1 = this.mWidth)
        {
          f2 = this.mHeight * f1 / this.mWidth;
          break;
        }
        f1 = f5 / 2.0F;
        break label232;
        if (this.aEp == 2)
        {
          f1 = f4 / this.mWidth;
          float f6 = this.mWidth;
          if (f3 < 0.0F) {}
          for (;;)
          {
            setSizeAndPosition(f1, (int)(f3 + (f6 - f4)), (int)(this.iq + f5 - f2 * this.iq / this.mHeight));
            break;
            f3 /= 2.0F;
          }
        }
      } while (this.aEp != 4);
      f1 = f4 / this.mWidth;
      if (f3 > 0.0F) {}
      for (;;)
      {
        setSizeAndPosition(f1, (int)f3, (int)(f5 + this.iq - f2 * this.iq / this.mHeight));
        break;
        f3 /= 2.0F;
      }
      if ((i != 1) && (i != 3)) {
        break;
      }
      if (this.aEp != 0)
      {
        this.acR = true;
        if (this.a != null)
        {
          f1 = ViewHelper.getScaleX(this.jk);
          f2 = ViewHelper.getScaleY(this.jk);
          if ((f1 > 0.0F) && (f2 > 0.0F)) {
            this.a.a(this.jk, this.mWidth, this.mHeight, (int)(f1 * this.mWidth), (int)(f2 * this.mHeight), (int)ViewHelper.getX(this.jk), (int)ViewHelper.getY(this.jk));
          }
        }
      }
      this.aEp = 0;
      break;
      label637:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public void setDraggableView(View paramView)
  {
    this.jk = paramView;
  }
  
  public void setDraggableView(View paramView, int paramInt1, int paramInt2)
  {
    this.jk = paramView;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.mIsEnabled = paramBoolean;
  }
  
  public void setOnDraggingListener(a parama)
  {
    this.a = parama;
  }
  
  public void setSizeAndPosition(float paramFloat, int paramInt1, int paramInt2)
  {
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    ViewHelper.setPivotX(this.jk, 0.0F);
    ViewHelper.setPivotY(this.jk, 0.0F);
    ViewHelper.setScaleX(this.jk, f);
    ViewHelper.setScaleY(this.jk, f);
    ViewHelper.setX(this.jk, paramInt1);
    ViewHelper.setY(this.jk, paramInt2);
    if (this.a != null) {
      this.a.c(paramInt1, paramInt2, this.mWidth, this.mHeight, (int)(this.mWidth * f), (int)(this.mHeight * f));
    }
  }
  
  public void xV(int paramInt)
  {
    a(paramInt, new LinearInterpolator(), null);
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
    
    public abstract void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
    
    public abstract boolean yB();
    
    public abstract boolean yC();
    
    public abstract boolean yD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */