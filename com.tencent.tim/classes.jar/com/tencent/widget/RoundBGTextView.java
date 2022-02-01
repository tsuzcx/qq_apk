package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import wja;

public class RoundBGTextView
  extends SingleLineTextView
{
  private int eut;
  private int mColor;
  private Paint mPaint;
  
  public RoundBGTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundBGTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundBGTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(this.mColor);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight()), this.eut, this.eut, this.mPaint);
    super.onDraw(paramCanvas);
  }
  
  public void setBgColor(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public void setRoundCornerSize(int paramInt)
  {
    this.eut = wja.dp2px(paramInt, getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.RoundBGTextView
 * JD-Core Version:    0.7.0.1
 */