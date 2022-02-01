package com.tencent.av.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class SparkDot
  extends LinearLayout
{
  int aBa = 40;
  int aBb = 0;
  int aBc = 6;
  public int aBd = -849386130;
  public int aBe = 1281320302;
  public boolean aaa = true;
  Bitmap bH = null;
  ImageView[] f = null;
  private boolean isStart;
  Bitmap mBitmap = null;
  int mDuration = 400;
  Handler mHandler = new Handler();
  int mIndex = 0;
  Runnable mRunnable = new SparkDot.1(this);
  float mScale = 0.0F;
  
  public SparkDot(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SparkDot(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
  }
  
  public void axF()
  {
    this.isStart = false;
    if (this.mRunnable != null)
    {
      this.mHandler.removeCallbacks(this.mRunnable);
      this.f[this.mIndex].setImageBitmap(this.mBitmap);
      this.mIndex = 0;
      this.aBb = 0;
    }
  }
  
  public void axG()
  {
    if (this.isStart) {}
    do
    {
      return;
      this.isStart = true;
    } while (this.mRunnable == null);
    this.mHandler.removeCallbacks(this.mRunnable);
    this.mHandler.postDelayed(this.mRunnable, this.mDuration);
  }
  
  Bitmap d(int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.aBa, this.aBa, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setColor(paramInt);
    localPaint.setStyle(Paint.Style.FILL);
    if (this.aaa) {
      localPaint.setMaskFilter(new BlurMaskFilter(this.mScale * 3.0F, BlurMaskFilter.Blur.SOLID));
    }
    localCanvas.drawOval(new RectF(this.mScale * 3.0F, this.mScale * 3.0F, this.mScale * 10.0F, this.mScale * 10.0F), localPaint);
    return localBitmap;
  }
  
  @SuppressLint({"NewApi"})
  void init()
  {
    this.mScale = getResources().getDisplayMetrics().scaledDensity;
    this.aBa = ((int)(13.0F * this.mScale));
    this.mBitmap = d(this.aBe);
    this.bH = d(this.aBd);
    int i = 0;
    while (i < this.aBc)
    {
      ImageView localImageView = new ImageView(getContext());
      localImageView.setImageBitmap(this.mBitmap);
      localImageView.layout(this.aBa * i, 0, this.aBa * (i + 1), this.aBa);
      this.f[i] = localImageView;
      super.addViewInLayout(localImageView, getChildCount(), generateDefaultLayoutParams());
      i += 1;
    }
  }
  
  void nP(int paramInt)
  {
    this.mIndex = paramInt;
    this.f[paramInt].setImageBitmap(this.bH);
    if (paramInt > 0)
    {
      this.f[(paramInt - 1)].setImageBitmap(this.mBitmap);
      return;
    }
    this.f[(this.aBc - 1)].setImageBitmap(this.mBitmap);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = (this.aBa * this.aBc);
    setLayoutParams(localLayoutParams);
  }
  
  public void setDotCount(int paramInt)
  {
    this.aBc = paramInt;
    this.f = new ImageView[this.aBc];
    init();
    this.mHandler.postDelayed(this.mRunnable, this.mDuration);
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      axG();
      return;
    }
    axF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.SparkDot
 * JD-Core Version:    0.7.0.1
 */