package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import aqcx;
import aqhu;

public class SectorProgressView
  extends View
{
  private static Rect cc;
  private static int dce;
  private static int dcf;
  private static Bitmap fn;
  private static int mIconWidth;
  private static int mStrokeWidth;
  private Rect cb = new Rect();
  private Rect cd = new Rect();
  private boolean ciW;
  public boolean ciX;
  private Paint mPaint;
  private int mProgress;
  private RectF mProgressRect = new RectF();
  
  public SectorProgressView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SectorProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SectorProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (dce == 0) {
      dce = aqcx.dip2px(getContext(), 26.0F);
    }
    if (mStrokeWidth == 0) {
      mStrokeWidth = aqcx.dip2px(getContext(), 3.0F);
    }
    if (mIconWidth == 0) {
      mIconWidth = aqcx.dip2px(getContext(), 18.0F);
    }
    if (dcf == 0) {
      dcf = aqcx.dip2px(getContext(), 8.0F);
    }
    if (fn == null)
    {
      fn = aqhu.g(getResources(), 2130848278);
      cc = new Rect(0, 0, fn.getWidth(), fn.getHeight());
    }
  }
  
  public void clf()
  {
    boolean bool = this.ciW;
    this.ciW = true;
    if (!bool) {
      invalidate();
    }
  }
  
  public void dqT()
  {
    boolean bool = this.ciW;
    this.ciW = false;
    if (bool) {
      invalidate();
    }
  }
  
  public boolean isInProgress()
  {
    return this.ciW;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
    }
    this.cb.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    if (this.ciW)
    {
      this.mPaint.setColor(1073741824);
      paramCanvas.drawRect(this.cb, this.mPaint);
      f = this.mProgress * 360 / 100;
      i = (getMeasuredWidth() - dce) / 2;
      j = (getMeasuredHeight() - dce) / 2;
      k = (getMeasuredWidth() + dce) / 2;
      m = (getMeasuredWidth() + dce) / 2;
      this.mProgressRect.set(i, j, k, m);
      this.mPaint.setColor(-8354924);
      this.mPaint.setStrokeWidth(mStrokeWidth);
      this.mPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, dce / 2, this.mPaint);
      this.mPaint.setColor(-13646081);
      paramCanvas.drawArc(this.mProgressRect, -90.0F, -f, false, this.mPaint);
    }
    while (!this.ciX)
    {
      float f;
      int k;
      int m;
      return;
    }
    int i = getMeasuredWidth() - dcf - mIconWidth;
    int j = getMeasuredHeight() - dcf - mIconWidth;
    this.cd.set(i, j, mIconWidth + i, mIconWidth + j);
    paramCanvas.drawBitmap(fn, cc, this.cd, this.mPaint);
  }
  
  public void setProgress(int paramInt)
  {
    int i = this.mProgress;
    this.mProgress = paramInt;
    if (i != this.mProgress) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.SectorProgressView
 * JD-Core Version:    0.7.0.1
 */