package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation.AnimationListener;

public class AnimationPoint
  extends View
{
  protected long Cv;
  protected long Cw;
  protected int JO;
  AccelerateDecelerateInterpolator a;
  protected Animation.AnimationListener a;
  protected boolean aJq;
  protected boolean aJr;
  protected int buk;
  protected int bul;
  private Runnable mAnimationRunnable = new AnimationPoint.1(this);
  protected long mDuration;
  protected Paint mPaint = new Paint();
  protected int mRadius;
  protected long mStartTime;
  protected Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public AnimationPoint(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AnimationPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AnimationPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-1);
    this.Cw = 1000L;
    this.Cv = (this.Cw * 2L);
    this.mDuration = 2000L;
    this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
  }
  
  protected int E(long paramLong)
  {
    float f = this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator.getInterpolation((float)(paramLong % this.Cw) / (float)this.Cw);
    int i;
    int j;
    if (this.aJq)
    {
      i = this.buk - this.mRadius * 2;
      if (paramLong <= this.Cw) {
        break label90;
      }
      j = this.mRadius;
    }
    label90:
    for (this.bul = ((int)(i * f) + j);; this.bul = (this.mRadius + i - (int)(i * f)))
    {
      return this.bul;
      i = this.JO - this.mRadius * 2;
      break;
    }
  }
  
  protected int F(long paramLong)
  {
    if (paramLong < this.Cw) {
      return this.bul + this.mRadius / 2;
    }
    return this.bul - this.mRadius / 2;
  }
  
  protected int G(long paramLong)
  {
    if (paramLong < this.Cw) {
      return this.bul + this.mRadius;
    }
    return this.bul - this.mRadius;
  }
  
  protected float c(long paramLong)
  {
    float f = 1.0F;
    paramLong %= this.Cw;
    if (paramLong < this.Cw * 16L / 100L) {
      f = 1.0F * (float)paramLong / (float)(this.Cw * 16L / 100L);
    }
    while (paramLong < 60L * this.Cw / 100L) {
      return f;
    }
    return 1.0F * (float)(this.Cw - paramLong) / (float)(40L * this.Cw / 100L);
  }
  
  protected float d(long paramLong)
  {
    paramLong %= this.Cw;
    if (paramLong < 16L * this.Cw / 100L) {
      return 0.0F;
    }
    if (paramLong < 24L * this.Cw / 100L) {
      return (float)(paramLong - 16L * this.Cw / 100L) * 0.4F / (float)(8L * this.Cw / 100L);
    }
    if (paramLong < 60L * this.Cw / 100L) {
      return (float)(60L * this.Cw / 100L - paramLong) * 0.4F / (float)(36L * this.Cw / 100L);
    }
    return 0.0F;
  }
  
  protected float e(long paramLong)
  {
    paramLong %= this.Cw;
    if (paramLong < 24L * this.Cw / 100L) {
      return 0.0F;
    }
    if (paramLong < 36L * this.Cw / 100L) {
      return (float)(paramLong - 24L * this.Cw / 100L) * 0.2F / (float)(12L * this.Cw / 100L);
    }
    if (paramLong < 60L * this.Cw / 100L) {
      return (float)(60L * this.Cw / 100L - paramLong) * 0.2F / (float)(24L * this.Cw / 100L);
    }
    return 0.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.JO = super.getWidth();
    this.buk = super.getHeight();
    int j = this.JO / 2;
    int k = this.buk / 2;
    long l = (SystemClock.uptimeMillis() - this.mStartTime) % this.Cv;
    int m = E(l);
    int n = F(l);
    int i1 = G(l);
    float f1 = c(l);
    float f2 = d(l);
    float f3 = e(l);
    int i;
    if (this.mRadius == 0)
    {
      if (this.aJq)
      {
        i = this.JO / 2;
        this.mRadius = i;
      }
    }
    else
    {
      if (f3 != 0.0F)
      {
        this.mPaint.setAlpha((int)(f3 * 255.0F));
        if (!this.aJq) {
          break label272;
        }
        paramCanvas.drawCircle(j, i1, this.mRadius, this.mPaint);
      }
      label172:
      if (f2 != 0.0F)
      {
        this.mPaint.setAlpha((int)(f2 * 255.0F));
        if (!this.aJq) {
          break label294;
        }
        paramCanvas.drawCircle(j, n, this.mRadius, this.mPaint);
      }
    }
    for (;;)
    {
      if (f1 != 0.0F)
      {
        this.mPaint.setAlpha((int)(f1 * 255.0F));
        if (!this.aJq) {
          break label316;
        }
        paramCanvas.drawCircle(j, m, this.mRadius, this.mPaint);
      }
      return;
      i = this.buk / 2;
      break;
      label272:
      paramCanvas.drawCircle(i1, k, this.mRadius, this.mPaint);
      break label172;
      label294:
      paramCanvas.drawCircle(n, k, this.mRadius, this.mPaint);
    }
    label316:
    paramCanvas.drawCircle(m, k, this.mRadius, this.mPaint);
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }
  
  public void setIsVertical(boolean paramBoolean)
  {
    this.aJq = paramBoolean;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams != null)
    {
      int i = localLayoutParams.width;
      localLayoutParams.width = localLayoutParams.height;
      localLayoutParams.height = i;
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void setLoopTime(long paramLong)
  {
    this.Cv = paramLong;
    this.Cw = (paramLong / 2L);
  }
  
  public void setOnAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
  
  public void setRadius(int paramInt)
  {
    this.mRadius = paramInt;
  }
  
  public void startAnimation()
  {
    this.aJr = false;
    this.mStartTime = SystemClock.uptimeMillis();
    this.JO = super.getWidth();
    this.buk = super.getHeight();
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationStart(null);
    }
    this.mUIHandler.post(this.mAnimationRunnable);
  }
  
  public void stopAnimation()
  {
    this.mUIHandler.removeCallbacks(this.mAnimationRunnable);
    this.aJr = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.AnimationPoint
 * JD-Core Version:    0.7.0.1
 */