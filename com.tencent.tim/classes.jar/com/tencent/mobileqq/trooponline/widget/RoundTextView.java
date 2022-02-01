package com.tencent.mobileqq.trooponline.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import atau.a;

public class RoundTextView
  extends TextView
{
  protected int mColor = -1;
  protected Paint mPaint;
  protected RectF mRectF;
  
  public RoundTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rT);
    this.mColor = paramContext.getColor(0, 2131167654);
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
    }
    this.mPaint.setColor(this.mColor);
    if (this.mRectF == null) {
      this.mRectF = new RectF();
    }
    this.mRectF.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    paramCanvas.drawRoundRect(this.mRectF, getMeasuredHeight() / 2, getMeasuredHeight() / 2, this.mPaint);
    super.onDraw(paramCanvas);
  }
  
  public void setRoundBgColor(int paramInt)
  {
    this.mColor = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.widget.RoundTextView
 * JD-Core Version:    0.7.0.1
 */