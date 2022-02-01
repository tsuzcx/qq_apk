package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;

public class BorderTextView
  extends SimpleTextView
{
  private int mBorderWidth;
  private int mColor;
  private Paint mPaint;
  private float mRadius;
  
  public BorderTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BorderTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BorderTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(this.mColor);
    this.mPaint.setStrokeWidth(this.mBorderWidth);
    paramCanvas.drawRoundRect(new RectF(this.mBorderWidth, this.mBorderWidth, getMeasuredWidth() - this.mBorderWidth, getMeasuredHeight() - this.mBorderWidth), this.mRadius, this.mRadius, this.mPaint);
  }
  
  public void setBorderColor(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.mBorderWidth = paramInt;
    this.mRadius = paramInt;
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.BorderTextView
 * JD-Core Version:    0.7.0.1
 */