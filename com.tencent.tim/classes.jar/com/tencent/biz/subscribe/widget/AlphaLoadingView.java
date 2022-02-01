package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import sik;

public class AlphaLoadingView
  extends View
{
  private int Xc = this.bwZ;
  private String aEj = "#00CAFC";
  private int bwY = -1;
  private int bwZ = 100;
  private int bxa = 16;
  private int mDefaultHeight = 5;
  private Handler mHandler;
  private int mHeight;
  private boolean mIsPause;
  private Paint mPaint = new Paint();
  private int mWidth;
  
  public AlphaLoadingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AlphaLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AlphaLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mPaint.setAntiAlias(true);
    this.mHandler = new sik(this);
  }
  
  private int n(int paramInt, boolean paramBoolean)
  {
    int j = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    switch (j)
    {
    default: 
      if (paramBoolean) {
        return this.bwY;
      }
      break;
    case 1073741824: 
      return i;
    case -2147483648: 
      if (paramBoolean) {}
      for (paramInt = this.bwY;; paramInt = this.mDefaultHeight) {
        return Math.min(paramInt, i);
      }
    case 0: 
      if (paramBoolean) {
        return this.bwY;
      }
      return this.mDefaultHeight;
    }
    return this.mDefaultHeight;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    start();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    pause();
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 255;
    int j = 30;
    super.onDraw(paramCanvas);
    int k;
    if (this.Xc < this.mWidth)
    {
      this.Xc += 30;
      k = 255 - this.Xc * 255 / this.mWidth;
      if (k <= 255) {
        break label190;
      }
    }
    for (;;)
    {
      if (i < 30) {
        i = j;
      }
      for (;;)
      {
        String str = Integer.toHexString(i);
        i = Color.parseColor("#" + str + this.aEj.substring(1, this.aEj.length()));
        this.mPaint.setColor(i);
        paramCanvas.drawLine(this.mWidth / 2 - this.Xc / 2, this.mDefaultHeight / 2, this.mWidth / 2 + this.Xc / 2, this.mDefaultHeight / 2, this.mPaint);
        return;
        this.Xc = this.bwZ;
        break;
      }
      label190:
      i = k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(n(paramInt1, true), n(paramInt2, false));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    if (this.mWidth < this.Xc) {
      this.mWidth = this.Xc;
    }
    this.mPaint.setStrokeWidth(this.mHeight);
  }
  
  public void pause()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mIsPause = true;
      setVisibility(8);
    }
  }
  
  public void setTimePeriod(int paramInt)
  {
    if (this.bxa > 0) {
      this.bxa = paramInt;
    }
  }
  
  public void start()
  {
    if (this.mHandler != null)
    {
      this.mIsPause = false;
      this.mHandler.sendEmptyMessage(1);
      setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AlphaLoadingView
 * JD-Core Version:    0.7.0.1
 */