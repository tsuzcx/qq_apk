package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CaptureCommonLoadingView
  extends View
{
  private static float scale;
  private Path N;
  private RectF aP;
  private RectF aQ = new RectF(this.centerX - 16843176, this.centerY - 16843176, this.centerX + 16843176, this.centerY + 16843176);
  private float aU = a(2.5F, getContext());
  private int centerX;
  private int centerY;
  private Paint ci;
  private Paint cj;
  private int mHeight;
  private int mMax = 100;
  private int mProgress;
  private float mRadius = a(17.5F, getContext());
  private int mWidth;
  private float zc = a(2.0F, getContext());
  
  public CaptureCommonLoadingView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CaptureCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CaptureCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public static int a(float paramFloat, Context paramContext)
  {
    if (scale == 0.0F) {
      scale = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(scale * paramFloat);
  }
  
  private void init()
  {
    this.ci = new Paint(1);
    this.ci.setStyle(Paint.Style.FILL);
    this.ci.setColor(2130706432);
    this.cj = new Paint(1);
    this.ci.setStyle(Paint.Style.FILL);
    this.cj.setColor(0);
    this.cj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.N = new Path();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawRoundRect(this.aP, this.zc, this.zc, this.ci);
    paramCanvas.drawCircle(this.centerX, this.centerY, this.mRadius, this.cj);
    paramCanvas.drawCircle(this.centerX, this.centerY, this.mRadius - this.aU, this.ci);
    float f = this.mProgress * 360.0F / this.mMax;
    this.N.moveTo(this.centerX, this.centerY);
    this.N.arcTo(this.aQ, 270.0F, f);
    paramCanvas.drawPath(this.N, this.cj);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.centerX = (this.mWidth / 2);
    this.centerY = (this.mHeight / 2);
    this.aP = new RectF(0.0F, 0.0F, this.mWidth, this.mHeight);
    float f = this.mRadius - this.aU;
    this.aQ = new RectF(this.centerX - f, this.centerY - f, this.centerX + f, f + this.centerY);
  }
  
  public void setCorner(int paramInt)
  {
    this.zc = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    this.mMax = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.mProgress = paramInt;
    invalidate();
    if (this.mProgress == this.mMax) {
      setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CaptureCommonLoadingView
 * JD-Core Version:    0.7.0.1
 */