package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;

public class SplitedProgressBar
  extends View
{
  public int Xd = 3;
  public int buA = 50;
  public int buB;
  public int buC = 2147483647;
  public int buD = 4;
  public int buE = 0;
  public int buF = 1;
  public Paint mPaint = new Paint();
  public int mProgress;
  public int mProgressBgColor = 872415231;
  public int mTotalCount = 1;
  
  public SplitedProgressBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = super.getWidth();
    if (this.mTotalCount == 0) {
      return;
    }
    this.mPaint.setStrokeWidth(this.Xd);
    float f1 = (i - (this.buF - this.buE - 1) * this.buD) / (this.buF - this.buE);
    i = this.buE;
    label69:
    int j;
    int k;
    if (i < this.buF)
    {
      j = (int)((i - this.buE) * (this.buD + f1));
      k = (int)((i - this.buE) * (this.buD + f1) + f1);
      if (i >= this.buB) {
        break label213;
      }
      this.mPaint.setStrokeWidth(this.Xd);
      this.mPaint.setColor(this.buC);
      paramCanvas.drawLine(j + 1, 1.0F, k - 1, 1.0F, this.mPaint);
      this.mPaint.setStrokeWidth(1.0F);
      paramCanvas.drawPoint(j, 1.0F, this.mPaint);
      paramCanvas.drawPoint(k - 1, 1.0F, this.mPaint);
    }
    for (;;)
    {
      i += 1;
      break label69;
      break;
      label213:
      if (i == this.buB)
      {
        this.mPaint.setStrokeWidth(this.Xd);
        this.mPaint.setColor(this.buC);
        float f2 = j + 1;
        float f3 = j;
        paramCanvas.drawLine(f2, 1.0F, this.mProgress * f1 / 100.0F + f3, 1.0F, this.mPaint);
        this.mPaint.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(j + this.mProgress * f1 / 100.0F, 1.0F, this.mPaint);
        paramCanvas.drawPoint(j, 1.0F, this.mPaint);
        this.mPaint.setStrokeWidth(this.Xd);
        this.mPaint.setColor(this.mProgressBgColor);
        f2 = j;
        paramCanvas.drawLine(this.mProgress * f1 / 100.0F + f2, 1.0F, k - 1, 1.0F, this.mPaint);
        this.mPaint.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(k - 1, 1.0F, this.mPaint);
      }
      else
      {
        this.mPaint.setStrokeWidth(this.Xd);
        this.mPaint.setColor(this.mProgressBgColor);
        paramCanvas.drawLine(j + 1, 1.0F, k - 1, 1.0F, this.mPaint);
        this.mPaint.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(j, 1.0F, this.mPaint);
        paramCanvas.drawPoint(k - 1, 1.0F, this.mPaint);
      }
    }
  }
  
  public void setProgress(int paramInt1, int paramInt2)
  {
    if (this.mTotalCount <= 0) {}
    while ((paramInt1 < 0) || (paramInt1 >= this.mTotalCount) || (paramInt2 < 0) || (paramInt2 > 100)) {
      return;
    }
    this.buB = paramInt1;
    this.mProgress = paramInt2;
    if (this.buB < this.buA)
    {
      this.buE = 0;
      if (this.mTotalCount < this.buA) {}
      for (paramInt1 = this.mTotalCount;; paramInt1 = this.buA)
      {
        this.buF = paramInt1;
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        super.invalidate();
        return;
      }
    }
    for (this.buE = this.buA; this.buE + this.buA <= this.buB; this.buE += this.buA) {}
    if (this.mTotalCount < this.buE + this.buA) {}
    for (paramInt1 = this.mTotalCount;; paramInt1 = this.buE + this.buA)
    {
      this.buF = paramInt1;
      break;
    }
    super.postInvalidate();
  }
  
  public void setShowMaxCount(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("setShowMaxCount Exception, count is < 1, count = " + paramInt);
    }
    this.buA = paramInt;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.invalidate();
      return;
    }
    super.postInvalidate();
  }
  
  public void setTotalCount(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("setTotalCount Exception, count is < 0, count = " + paramInt);
    }
    this.mTotalCount = paramInt;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.invalidate();
      return;
    }
    super.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.SplitedProgressBar
 * JD-Core Version:    0.7.0.1
 */