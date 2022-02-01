package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar.OnSeekBarChangeListener;
import aqcx;
import com.tencent.qphone.base.util.QLog;

public class VerticalSeekBar
  extends View
{
  Rect aU;
  long agx;
  boolean cwX;
  int dtK;
  int dtL;
  Bitmap fY;
  float mLastY;
  int mMaxProgress = 100;
  int mMinWidth;
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener;
  Paint mPaint;
  int mProgress = 0;
  
  public VerticalSeekBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VerticalSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public VerticalSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  void init()
  {
    Resources localResources = super.getResources();
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(-1);
    this.mPaint.setStrokeWidth(2.0F);
    this.mPaint.setStyle(Paint.Style.STROKE);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = localResources.getDisplayMetrics().densityDpi;
    try
    {
      this.fY = BitmapFactory.decodeResource(localResources, 2130848287, localOptions);
      this.aU = new Rect();
      this.dtL = aqcx.dip2px(getContext(), 5.0F);
      this.mMinWidth = aqcx.dip2px(getContext(), 30.0F);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("VerticalSeekBar", 1, "thumb picture decode failed");
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getMeasuredWidth();
    int i = getMeasuredHeight();
    if (this.dtK <= 0) {
      this.dtK = ((int)((i - this.fY.getHeight()) / this.mMaxProgress * this.mProgress));
    }
    float f3 = j / 2;
    float f2 = this.dtK + this.fY.getHeight() + this.dtL;
    if (this.dtK < this.dtL)
    {
      f1 = 0.0F;
      paramCanvas.drawLine(f3, 0.0F, f3, f1, this.mPaint);
      j = (j - this.fY.getWidth()) / 2;
      this.aU.set(j, this.dtK, this.fY.getWidth() + j, this.dtK + this.fY.getHeight());
      paramCanvas.drawBitmap(this.fY, null, this.aU, this.mPaint);
      if (f2 <= i) {
        break label214;
      }
    }
    label214:
    for (float f1 = i;; f1 = f2)
    {
      paramCanvas.drawLine(f3, f1, f3, i, this.mPaint);
      return;
      f1 = this.dtK - this.dtL;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getMeasuredWidth();
    int i = getMeasuredHeight();
    paramInt1 = paramInt2;
    if (paramInt2 < this.fY.getWidth()) {
      paramInt1 = this.fY.getWidth();
    }
    paramInt2 = i;
    if (i < this.fY.getHeight()) {
      paramInt2 = this.fY.getHeight();
    }
    i = paramInt1;
    if (paramInt1 < this.mMinWidth) {
      i = this.mMinWidth;
    }
    setMeasuredDimension(i, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 0.0F;
    if (!isEnabled()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return true;
        this.mLastY = paramMotionEvent.getY();
        if ((this.mLastY > this.dtK - this.dtL) && (this.mLastY < this.dtK + this.fY.getHeight() + this.dtL))
        {
          this.cwX = true;
          if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onStartTrackingTouch(null);
          }
        }
        this.agx = System.currentTimeMillis();
        continue;
        if (this.cwX)
        {
          f1 = paramMotionEvent.getY() - this.mLastY;
          f2 = getMeasuredHeight() - this.fY.getHeight();
          if ((this.dtK + f1 <= f2) && (this.dtK + f1 >= 0.0F))
          {
            this.dtK = ((int)(this.dtK + f1));
            if (this.mOnSeekBarChangeListener != null)
            {
              this.mProgress = ((int)(this.dtK / f2 * this.mMaxProgress));
              this.mOnSeekBarChangeListener.onProgressChanged(null, this.mProgress, false);
            }
          }
          this.mLastY = paramMotionEvent.getY();
          invalidate();
        }
      }
      if ((this.cwX) && (this.mOnSeekBarChangeListener != null)) {
        this.mOnSeekBarChangeListener.onStopTrackingTouch(null);
      }
      this.cwX = false;
    } while (System.currentTimeMillis() - this.agx >= 100L);
    float f2 = getMeasuredHeight() - this.fY.getHeight();
    float f4 = paramMotionEvent.getY() - this.fY.getHeight() / 2;
    float f1 = f4;
    if (f4 > f2) {
      f1 = f2;
    }
    if (f1 < 0.0F) {
      f1 = f3;
    }
    for (;;)
    {
      this.dtK = ((int)f1);
      if (this.mOnSeekBarChangeListener != null)
      {
        this.mProgress = ((int)(this.dtK / f2 * this.mMaxProgress));
        this.mOnSeekBarChangeListener.onProgressChanged(null, this.mProgress, false);
      }
      invalidate();
      break;
    }
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.mMaxProgress = paramInt;
  }
  
  public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.mOnSeekBarChangeListener = paramOnSeekBarChangeListener;
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.mMaxProgress))
    {
      this.mProgress = paramInt;
      if (getMeasuredHeight() >= 0) {
        this.dtK = ((int)((getMeasuredHeight() - this.fY.getHeight()) / this.mMaxProgress * this.mProgress));
      }
      if (this.mOnSeekBarChangeListener != null) {
        this.mOnSeekBarChangeListener.onProgressChanged(null, paramInt, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VerticalSeekBar
 * JD-Core Version:    0.7.0.1
 */