package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;

public class ImageAnimationView
  extends View
{
  private Bitmap bitmap;
  float bottom;
  private RectF dst = new RectF();
  private long duration = 1000L;
  private Rect endDstRect;
  private Rect endSrcRect;
  boolean isInAnimation = false;
  float left;
  Paint paint = new Paint(6);
  Interpolator q;
  float right;
  private Rect src = new Rect();
  private Rect startDstRect;
  private Rect startSrcRect;
  long startTime = 0L;
  float top;
  private Animation.AnimationListener z;
  
  public ImageAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.bitmap = paramBitmap;
    this.startSrcRect = paramRect1;
    this.endSrcRect = paramRect2;
    this.startDstRect = paramRect3;
    this.endDstRect = paramRect4;
    this.duration = paramLong;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.startTime > 0L)
    {
      long l = System.currentTimeMillis() - this.startTime;
      float f2 = (float)l / (float)this.duration;
      float f1 = f2;
      if (this.q != null) {
        f1 = this.q.getInterpolation(f2);
      }
      f2 = 1.0F - f1;
      if ((l > this.duration) || (!this.isInAnimation)) {
        break label354;
      }
      this.top = (this.startSrcRect.top * f2 + this.endSrcRect.top * f1);
      this.bottom = (this.startSrcRect.bottom * f2 + this.endSrcRect.bottom * f1);
      this.left = (this.startSrcRect.left * f2 + this.endSrcRect.left * f1);
      this.right = (this.startSrcRect.right * f2 + this.endSrcRect.right * f1);
      this.src.set((int)this.left, (int)this.top, (int)this.right, (int)this.bottom);
      this.top = (this.startDstRect.top * f2 + this.endDstRect.top * f1);
      this.bottom = (this.startDstRect.bottom * f2 + this.endDstRect.bottom * f1);
      this.left = (this.startDstRect.left * f2 + this.endDstRect.left * f1);
      float f3 = this.startDstRect.right;
      this.right = (f1 * this.endDstRect.right + f2 * f3);
      this.dst.set(this.left, this.top, this.right, this.bottom);
    }
    for (;;)
    {
      paramCanvas.drawBitmap(this.bitmap, this.src, this.dst, this.paint);
      invalidate();
      return;
      label354:
      if (this.isInAnimation)
      {
        this.isInAnimation = false;
        this.z.onAnimationEnd(null);
      }
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.z = paramAnimationListener;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.q = paramInterpolator;
  }
  
  public void startAnimation()
  {
    this.startTime = System.currentTimeMillis();
    if (this.z != null) {
      this.z.onAnimationStart(null);
    }
    this.isInAnimation = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageAnimationView
 * JD-Core Version:    0.7.0.1
 */