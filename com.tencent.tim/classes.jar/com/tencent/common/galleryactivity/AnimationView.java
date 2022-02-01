package com.tencent.common.galleryactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import aurt;
import sxv;

public class AnimationView
  extends View
{
  aurt a = new aurt();
  AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
  private sxv b;
  private int backState = 3;
  float bottom;
  private int cutValue;
  private Drawable drawable;
  private Rect drawableRect;
  private RectF dst = new RectF();
  private Rect endDstRect;
  private Rect endSrcRect;
  boolean freeMode = false;
  float input;
  private boolean isBackAnimationing;
  boolean isEnter = true;
  private boolean isEnterAnimationing;
  public boolean isImgCenterCropMode;
  boolean isInAnimation = false;
  float left;
  private long mAnimationDuringTime = 350L;
  private long mAnimationStartTime;
  Paint paint = new Paint(6);
  float right;
  private Rect src = new Rect();
  private Rect startDstRect;
  private Rect startSrcRect;
  private int startState = 3;
  long startTime = 0L;
  private int startX;
  private int startY;
  private Rect tempBounds = new Rect();
  float top;
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void createBackAnimation(Canvas paramCanvas)
  {
    switch (this.backState)
    {
    default: 
    case 1: 
      do
      {
        return;
        if ((this.startDstRect != null) && (this.endDstRect != null) && (this.drawable != null)) {
          break;
        }
        this.backState = 3;
        this.isBackAnimationing = false;
        super.onDraw(paramCanvas);
      } while (this.b == null);
      this.b.onExitAnimationEnd();
      return;
      this.mAnimationStartTime = SystemClock.uptimeMillis();
      this.backState = 2;
    case 2: 
      float f1 = (float)(SystemClock.uptimeMillis() - this.mAnimationStartTime) / (float)this.mAnimationDuringTime;
      if (f1 >= 1.0F) {
        this.backState = 3;
      }
      f1 = Math.min(f1, 1.0F);
      f1 = this.a.getInterpolation(f1);
      Rect localRect1 = this.startDstRect;
      Rect localRect2 = this.endDstRect;
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      localRect2 = new Rect(localRect2.left + arrayOfInt[0], localRect2.top + arrayOfInt[1], localRect2.right + arrayOfInt[0], localRect2.bottom + arrayOfInt[1]);
      int i = localRect2.right - localRect2.left;
      int j = localRect2.bottom - localRect2.top;
      float f2 = localRect1.right - localRect1.left + this.startX;
      float f3 = localRect1.bottom - localRect1.top + this.startY;
      float f4 = f2 / i;
      float f5 = f3 / j;
      paramCanvas.save();
      if (this.cutValue == 1)
      {
        paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.startX - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - this.startY - (localRect2.top - arrayOfInt[1]) * f5) * f1);
        paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f5) * f1);
        if (this.isImgCenterCropMode)
        {
          f2 = (i - j) / 2.0F;
          paramCanvas.translate(-f2 * f1, 0.0F);
          paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + f2 * f1, localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1 * f2, localRect2.bottom - arrayOfInt[1]);
        }
      }
      for (;;)
      {
        this.drawable.setBounds(this.endDstRect);
        this.drawable.draw(paramCanvas);
        paramCanvas.restore();
        invalidate();
        return;
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.startX / (1.0F - (1.0F - f5) * f1) * f1, localRect2.top - arrayOfInt[1] + this.startY / (1.0F - (1.0F - f5) * f1) * f1, localRect2.right - arrayOfInt[0] - f1 * (i - f2 / f5), localRect2.bottom - arrayOfInt[1]);
        continue;
        if (this.cutValue == 2)
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.startX - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - this.startY - (localRect2.top - arrayOfInt[1]) * f4) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - (1.0F - f4) * f1);
          if (this.isImgCenterCropMode)
          {
            f2 = (j - i) / 2.0F;
            paramCanvas.translate(0.0F, -f2 * f1);
            paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1] + f2 * f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * f2);
          }
          else
          {
            paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.startX / (1.0F - (1.0F - f4) * f1) * f1, localRect2.top - arrayOfInt[1] + this.startY / (1.0F - (1.0F - f4) * f1) * f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * (j - f3 / f4));
          }
        }
        else
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - f1 * (1.0F - f5));
        }
      }
    }
    if (this.b != null) {
      this.b.onExitAnimationEnd();
    }
    this.isBackAnimationing = false;
    this.drawable.setBounds(this.drawableRect);
  }
  
  private void createEnterAnimation(Canvas paramCanvas)
  {
    switch (this.startState)
    {
    default: 
      return;
    case 1: 
      if ((this.startDstRect == null) || (this.endDstRect == null) || (this.drawable == null))
      {
        this.startState = 3;
        this.isEnterAnimationing = false;
        if (this.b != null) {
          this.b.onEnterAnimationEnd();
        }
        super.onDraw(paramCanvas);
        return;
      }
      this.mAnimationStartTime = SystemClock.uptimeMillis();
      this.startState = 2;
      paramCanvas.save();
    case 2: 
      float f1 = (float)(SystemClock.uptimeMillis() - this.mAnimationStartTime) / (float)this.mAnimationDuringTime;
      if (f1 >= 1.0F) {
        this.startState = 3;
      }
      f1 = Math.min(f1, 1.0F);
      f1 = 1.0F - this.accelerateDecelerateInterpolator.getInterpolation(f1);
      Rect localRect1 = this.startDstRect;
      Rect localRect2 = this.endDstRect;
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      localRect2 = new Rect(localRect2.left + arrayOfInt[0], localRect2.top + arrayOfInt[1], localRect2.right + arrayOfInt[0], localRect2.bottom + arrayOfInt[1]);
      int i = localRect2.width();
      int j = localRect2.height();
      float f2 = localRect1.width();
      float f3 = localRect1.height();
      float f4 = f2 / i;
      float f5 = f3 / j;
      paramCanvas.save();
      if (this.cutValue == 1)
      {
        paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
        paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f5) * f1);
        if (this.isImgCenterCropMode)
        {
          f2 = (i - j) / 2.0F;
          paramCanvas.translate(-f2 * f1, 0.0F);
          paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + f2 * f1, localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1 * f2, localRect2.bottom - arrayOfInt[1]);
        }
      }
      for (;;)
      {
        this.drawable.setBounds(this.endDstRect);
        this.drawable.draw(paramCanvas);
        paramCanvas.restore();
        invalidate();
        return;
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1 * (i - f2 / f5), localRect2.bottom - arrayOfInt[1]);
        continue;
        if (this.cutValue == 2)
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f4) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - (1.0F - f4) * f1);
          if (this.isImgCenterCropMode)
          {
            f2 = (j - i) / 2.0F;
            paramCanvas.translate(0.0F, -f2 * f1);
            paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1] + f2 * f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * f2);
          }
          else
          {
            paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * (j - f3 / f4));
          }
        }
        else
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - f1 * (1.0F - f5));
        }
      }
    }
    this.isEnterAnimationing = false;
    if (this.b != null) {
      this.b.onEnterAnimationEnd();
    }
    paramCanvas.save();
    this.drawable.setBounds(this.endDstRect);
    this.drawable.draw(paramCanvas);
    paramCanvas.restore();
    this.drawable.setBounds(this.drawableRect);
  }
  
  private void onDrawFreeMode(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    float f1;
    if (this.startTime > 0L)
    {
      long l = System.currentTimeMillis() - this.startTime;
      this.input = ((float)l / (float)this.mAnimationDuringTime);
      if (!this.isEnter) {
        break label468;
      }
      this.input = this.accelerateDecelerateInterpolator.getInterpolation(this.input);
      f1 = 1.0F - this.input;
      if (this.isInAnimation)
      {
        if (l > this.mAnimationDuringTime) {
          break label486;
        }
        this.top = (this.startSrcRect.top * f1 + this.endSrcRect.top * this.input);
        this.bottom = (this.startSrcRect.bottom * f1 + this.endSrcRect.bottom * this.input);
        this.left = (this.startSrcRect.left * f1 + this.endSrcRect.left * this.input);
        this.right = (this.startSrcRect.right * f1 + this.endSrcRect.right * this.input);
        this.src.set((int)this.left, (int)this.top, (int)this.right, (int)this.bottom);
        this.top = (this.startDstRect.top * f1 + this.endDstRect.top * this.input);
        this.bottom = (this.startDstRect.bottom * f1 + this.endDstRect.bottom * this.input);
        this.left = (this.startDstRect.left * f1 + this.endDstRect.left * this.input);
        this.right = (this.startDstRect.right * f1 + this.endDstRect.right * this.input);
        this.dst.set(this.left, this.top, this.right, this.bottom);
      }
    }
    for (;;)
    {
      f1 = this.dst.width() / this.src.width();
      float f2 = this.dst.height() / this.src.height();
      paramCanvas.translate(this.dst.left - this.src.left * f1, this.dst.top - this.src.top * f2);
      paramCanvas.scale(f1, f2);
      paramCanvas.clipRect(this.src);
      this.drawable.draw(paramCanvas);
      invalidate();
      paramCanvas.restore();
      return;
      label468:
      this.input = this.a.getInterpolation(this.input);
      break;
      label486:
      this.isInAnimation = false;
      if (this.b != null) {
        if (this.isEnter) {
          this.b.onEnterAnimationEnd();
        } else {
          this.b.onExitAnimationEnd();
        }
      }
    }
  }
  
  private void startAnimation()
  {
    this.startTime = System.currentTimeMillis();
    this.isInAnimation = true;
    this.drawableRect = this.drawable.copyBounds();
    this.tempBounds = new Rect(0, 0, this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
    this.drawable.setBounds(this.tempBounds);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.freeMode)
    {
      onDrawFreeMode(paramCanvas);
      return;
    }
    if (this.isEnterAnimationing)
    {
      createEnterAnimation(paramCanvas);
      return;
    }
    if (this.isBackAnimationing)
    {
      createBackAnimation(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setAnimationListener(sxv paramsxv)
  {
    this.b = paramsxv;
  }
  
  public void startBackAnimation(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.backState = 1;
    this.isBackAnimationing = true;
    this.drawable = paramDrawable;
    this.drawableRect = paramDrawable.copyBounds();
    this.startDstRect = paramRect1;
    this.endDstRect = paramRect2;
    this.cutValue = paramInt1;
    this.startX = paramInt2;
    this.startY = paramInt3;
    this.mAnimationDuringTime = paramLong;
    if (this.b != null) {
      this.b.onExitAnimationStart();
    }
    invalidate();
  }
  
  public void startBackAnimationFreeMode(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.freeMode = true;
    this.isEnter = false;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.startSrcRect = paramRect2;
    this.endSrcRect = paramRect1;
    this.startDstRect = paramRect4;
    this.endDstRect = paramRect3;
    this.drawable = paramDrawable;
    this.mAnimationDuringTime = paramLong;
    startAnimation();
    if (this.b != null) {
      this.b.onExitAnimationStart();
    }
  }
  
  public void startEnterAnimation(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt, long paramLong)
  {
    this.startState = 1;
    this.isEnterAnimationing = true;
    this.drawable = paramDrawable;
    this.drawableRect = paramDrawable.copyBounds();
    this.startDstRect = paramRect1;
    this.endDstRect = paramRect2;
    this.cutValue = paramInt;
    this.mAnimationDuringTime = paramLong;
    if (this.b != null) {
      this.b.onEnterAnimationStart();
    }
    invalidate();
  }
  
  public void startEnterAnimationFreeMode(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.freeMode = true;
    this.isEnter = true;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.startSrcRect = paramRect1;
    this.endSrcRect = paramRect2;
    this.startDstRect = paramRect3;
    this.endDstRect = paramRect4;
    this.drawable = paramDrawable;
    this.mAnimationDuringTime = paramLong;
    startAnimation();
    if (this.b != null) {
      this.b.onEnterAnimationStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationView
 * JD-Core Version:    0.7.0.1
 */