package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class RoundProgressBar
  extends View
{
  private boolean aMq = true;
  private RectF aa = new RectF();
  private int byx = -252645121;
  private int byy = -1529614848;
  private int mDestProgress;
  private int mMax = 100;
  private Paint mPaint = new Paint();
  private int mProgress = 0;
  private int mTextColor = -16777216;
  private float mTextSize = 20.0F;
  Runnable mUpdateProgressRunnable = new RoundProgressBar.1(this);
  private float ok = 18.0F;
  private float ol = 5.0F;
  
  public RoundProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void yK(int paramInt)
  {
    this.mDestProgress = paramInt;
    ThreadManager.getUIHandler().postDelayed(this.mUpdateProgressRunnable, 30L);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = (int)(i - this.ol / 2.0F);
    this.mPaint.setColor(this.byx);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(this.ol);
    this.mPaint.setAntiAlias(true);
    paramCanvas.drawCircle(i, i, j, this.mPaint);
    this.mPaint.setStrokeWidth(this.ol);
    this.mPaint.setColor(this.byy);
    this.aa.set(i - j, i - j, i + j, j + i);
    this.mPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawArc(this.aa, -90.0F, this.mProgress * 360 / this.mMax, false, this.mPaint);
    this.mPaint.setStrokeWidth(0.0F);
    this.mPaint.setColor(this.mTextColor);
    this.mPaint.setTextSize(this.mTextSize);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
    j = this.mProgress * 100 / this.mMax;
    float f1 = this.mPaint.measureText(j + "");
    this.mPaint.setTextSize(this.ok);
    float f2 = this.mPaint.measureText("%");
    if ((j != 0) && (this.aMq))
    {
      this.mPaint.setTextSize(this.mTextSize);
      paramCanvas.drawText(j + "", i - (f1 + f2) / 2.0F, i + this.mTextSize / 2.0F, this.mPaint);
      this.mPaint.setTextSize(this.ok);
      paramCanvas.drawText("%", f1 + (i - (f2 + f1) / 2.0F), i + this.mTextSize / 2.0F, this.mPaint);
    }
  }
  
  public void setCircleColor(int paramInt)
  {
    this.byx = paramInt;
  }
  
  public void setCircleProgressColor(int paramInt)
  {
    this.byy = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt < 0) {
      try
      {
        throw new IllegalArgumentException("max not less than 0");
      }
      finally {}
    }
    this.mMax = paramInt;
  }
  
  public void setNeedShowProgreeText(boolean paramBoolean)
  {
    this.aMq = paramBoolean;
  }
  
  public void setPercentMarkTextSize(float paramFloat)
  {
    this.ok = paramFloat;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt < 0) {
      try
      {
        throw new IllegalArgumentException("progress not less than 0");
      }
      finally {}
    }
    int i = paramInt;
    if (paramInt > this.mMax) {
      i = this.mMax;
    }
    if ((i <= this.mMax) && (this.mProgress != i)) {
      yK(i);
    }
  }
  
  public void setRoundWidth(float paramFloat)
  {
    this.ol = paramFloat;
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.mTextSize = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.ui.RoundProgressBar
 * JD-Core Version:    0.7.0.1
 */