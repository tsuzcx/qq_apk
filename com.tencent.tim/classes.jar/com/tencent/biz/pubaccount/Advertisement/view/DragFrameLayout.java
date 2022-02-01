package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import aqcx;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;

public class DragFrameLayout
  extends FrameLayout
{
  private int aEp = 0;
  protected boolean acR;
  private a b;
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
  
  private void setSizeAndPosition(float paramFloat, int paramInt1, int paramInt2)
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
    if (this.b != null) {
      this.b.c(paramInt1, paramInt2, this.mWidth, this.mHeight, (int)(this.mWidth * f), (int)(this.mHeight * f));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Animation.AnimationListener paramAnimationListener)
  {
    float f1 = ViewHelper.getScaleX(this.jk);
    float f2 = ViewHelper.getScaleY(this.jk);
    if (this.h != null) {
      this.h.cancel();
    }
    this.h = new TranslateAnimation(0, ViewHelper.getX(this.jk), 0, paramInt1, 0, ViewHelper.getY(this.jk), 0, paramInt2);
    this.h.setDuration(paramInt5);
    this.h.setFillAfter(true);
    this.h.setAnimationListener(paramAnimationListener);
    if (this.jdField_d_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    float f3 = paramInt3 / super.getWidth();
    this.jdField_d_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(f1, f3, f2, f3, 0.0F, 0.0F);
    this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setDuration(paramInt5);
    this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    if (this.jdField_d_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_d_of_type_AndroidViewAnimationAnimationSet.cancel();
    }
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_d_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.h);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    this.jk.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimationSet);
    this.acR = true;
  }
  
  public void aBc()
  {
    float f1 = ViewHelper.getScaleX(this.jk);
    float f2 = ViewHelper.getScaleY(this.jk);
    if (this.h != null) {
      this.h.cancel();
    }
    this.h = new TranslateAnimation(0, ViewHelper.getX(this.jk), 0, 0.0F, 0, ViewHelper.getY(this.jk), 0, 0.0F);
    this.h.setDuration(200L);
    this.h.setFillAfter(true);
    if (this.jdField_d_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    this.jdField_d_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(f1, 1.0F, f2, 1.0F, 0.0F, 0.0F);
    this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    if (this.jdField_d_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_d_of_type_AndroidViewAnimationAnimationSet.cancel();
    }
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_d_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.h);
    this.jk.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimationSet);
    this.acR = false;
  }
  
  public void onDestroy()
  {
    AnimatorProxy.wrap(this.jk).reset();
    this.jk.clearAnimation();
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
    super.removeView(this.jk);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
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
          if ((this.mIsEnabled) && (this.b.yB()))
          {
            this.is = this.mTouchX;
            this.iq = this.mTouchY;
            f1 = this.mTouchX;
            f1 = this.is;
            f1 = this.mTouchY;
            f1 = this.iq;
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
          if ((this.mIsEnabled) && (this.b.yC()))
          {
            this.is = this.mTouchX;
            this.iq = this.mTouchY;
            f1 = this.mTouchX;
            f1 = this.is;
            f1 = this.mTouchY;
            f1 = this.iq;
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
          if ((this.mIsEnabled) && (this.b.yD()))
          {
            this.is = this.mTouchX;
            this.iq = this.mTouchY;
            f1 = this.mTouchX;
            f1 = this.is;
            f1 = this.mTouchY;
            f1 = this.iq;
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
        if (f5 > 0.0F) {}
        for (f1 = f5;; f1 = f5 / 2.0F)
        {
          setSizeAndPosition(f2, i, (int)f1);
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
            break label621;
          }
          if (f3 > 0.0F) {}
          for (f1 = (int)(this.mWidth - f3 * 1.1D);; f1 = this.mWidth)
          {
            f2 = this.mHeight * f1 / this.mWidth;
            break;
          }
        }
      }
      if (this.aEp == 2)
      {
        f1 = f4 / this.mWidth;
        float f6 = this.mWidth;
        if (f3 < 0.0F) {}
        for (;;)
        {
          setSizeAndPosition(f1, (int)(f3 + (f6 - f4)), (int)(this.iq + f5 - f2 * this.iq / this.mHeight));
          return true;
          f3 /= 2.0F;
        }
      }
      if (this.aEp != 4) {
        break;
      }
      f1 = f4 / this.mWidth;
      if (f3 > 0.0F) {}
      for (;;)
      {
        setSizeAndPosition(f1, (int)f3, (int)(f5 + this.iq - f2 * this.iq / this.mHeight));
        return true;
        f3 /= 2.0F;
      }
      if ((i != 1) && (i != 3)) {
        break;
      }
      if (this.aEp != 0)
      {
        this.acR = true;
        if (this.b != null)
        {
          f1 = ViewHelper.getScaleX(this.jk);
          f2 = ViewHelper.getScaleY(this.jk);
          if ((f1 > 0.0F) && (f2 > 0.0F)) {
            this.b.a(this.jk, this.mWidth, this.mHeight, (int)(f1 * this.mWidth), (int)(f2 * this.mHeight), (int)ViewHelper.getX(this.jk), (int)ViewHelper.getY(this.jk));
          }
        }
      }
      this.aEp = 0;
      return true;
      label621:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public void setDraggableView(View paramView)
  {
    this.jk = paramView;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.mIsEnabled = paramBoolean;
  }
  
  public void setOnDraggingListener(a parama)
  {
    this.b = parama;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */