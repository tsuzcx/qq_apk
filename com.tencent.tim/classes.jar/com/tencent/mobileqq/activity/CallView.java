package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.View;

public class CallView
  extends View
{
  private int bEQ = 4;
  private volatile boolean isRun = true;
  private int mColor;
  private Paint mPaint = new Paint();
  private long period = 150L;
  private RectF rect = new RectF();
  private long startTime = 0L;
  
  public CallView(Context paramContext)
  {
    super(paramContext);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(this.bEQ);
    this.mColor = -65536;
  }
  
  private void au(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() - this.bEQ;
    float f2 = getMeasuredHeight() - this.bEQ;
    this.rect.left = (-f1 / 3.0F);
    this.rect.top = (2.0F * f2 / 3.0F);
    this.rect.right = (f1 / 3.0F);
    this.rect.bottom = (f2 * 4.0F / 3.0F);
    this.mPaint.setColor(this.mColor);
    paramCanvas.drawArc(this.rect, -100.0F, 100.0F, false, this.mPaint);
  }
  
  private void av(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() - this.bEQ;
    float f2 = getMeasuredHeight() - this.bEQ;
    this.rect.left = (-f1 * 2.0F / 3.0F);
    this.rect.top = (f2 / 3.0F);
    this.rect.right = (f1 * 2.0F / 3.0F);
    this.rect.bottom = (f2 * 5.0F / 3.0F);
    this.mPaint.setColor(this.mColor);
    paramCanvas.drawArc(this.rect, -100.0F, 100.0F, false, this.mPaint);
  }
  
  private void aw(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() - this.bEQ;
    float f2 = getMeasuredHeight();
    float f3 = this.bEQ;
    this.rect.left = (-f1);
    this.rect.top = this.bEQ;
    this.rect.right = f1;
    this.rect.bottom = ((f2 - f3) * 2.0F);
    this.mPaint.setColor(this.mColor);
    paramCanvas.drawArc(this.rect, -100.0F, 100.0F, false, this.mPaint);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.isRun)
    {
      if (SystemClock.uptimeMillis() - this.startTime <= this.period * 6L) {
        break label47;
      }
      this.startTime = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      postInvalidateDelayed(150L);
      return;
      label47:
      if (SystemClock.uptimeMillis() - this.startTime > this.period * 5L)
      {
        au(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.startTime > this.period * 4L)
      {
        au(paramCanvas);
        av(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.startTime > this.period * 3L)
      {
        au(paramCanvas);
        av(paramCanvas);
        aw(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.startTime > this.period * 2L)
      {
        au(paramCanvas);
        av(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.startTime > this.period)
      {
        au(paramCanvas);
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.CallView
 * JD-Core Version:    0.7.0.1
 */