package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class CircleProgress
  extends ImageView
{
  RectF aW = new RectF();
  int bjX;
  boolean cZE = true;
  boolean cZF = true;
  int efi;
  int mBgColor;
  float mDensity;
  int mHeight;
  Paint mPaint;
  float mProgress;
  int mProgressColor;
  int mShadowColor;
  int mStrokeWidth;
  int mWidth;
  
  public CircleProgress(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    this.mBgColor = getResources().getColor(2131165822);
    this.mProgressColor = getResources().getColor(2131165750);
    this.bjX = 51;
    this.efi = 255;
    this.mShadowColor = getResources().getColor(2131165808);
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    this.mPaint.setColor(this.mBgColor);
    if (this.cZE) {
      this.mPaint.setAlpha(this.bjX * 255 / 100);
    }
    this.mPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.mShadowColor);
    this.aW.set(this.mStrokeWidth, this.mStrokeWidth, this.mWidth - this.mStrokeWidth, this.mHeight - this.mStrokeWidth);
    paramCanvas.drawArc(this.aW, -90.0F, 360.0F, false, this.mPaint);
    this.mPaint.setColor(this.mProgressColor);
    if (this.cZF) {
      this.mPaint.setAlpha(this.efi * 255 / 100);
    }
    this.mPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.mShadowColor);
    this.aW.set(this.mStrokeWidth, this.mStrokeWidth, this.mWidth - this.mStrokeWidth, this.mHeight - this.mStrokeWidth);
    paramCanvas.drawArc(this.aW, -90.0F, (float)(3.6D * this.mProgress), false, this.mPaint);
  }
  
  public void setBgAndProgressColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mBgColor = paramInt2;
    this.bjX = paramInt1;
    this.mProgressColor = paramInt4;
    this.efi = paramInt3;
  }
  
  public void setBgAndProgressUseAlpha(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.cZE = paramBoolean1;
    this.cZF = paramBoolean2;
  }
  
  public void setProgress(float paramFloat)
  {
    float f = 100.0F;
    if (paramFloat > 100.0F) {}
    for (;;)
    {
      this.mProgress = f;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      this.mProgress = f;
      invalidate();
      return;
      f = paramFloat;
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.mStrokeWidth = ((int)(this.mDensity * paramFloat + 0.5D));
    this.mPaint.setStrokeWidth(this.mStrokeWidth);
  }
  
  public void setmShadowColor(int paramInt)
  {
    this.mShadowColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgress
 * JD-Core Version:    0.7.0.1
 */