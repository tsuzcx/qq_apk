package com.tencent.mobileqq.olympic.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

public class ARTipsCircleProgress
  extends TextView
{
  private RectF H;
  private int atu;
  private Paint mPaint;
  private int mProgressBgColor = -1;
  private int mProgressColor = getResources().getColor(2131165446);
  private int mStrokeWidth = 8;
  
  public ARTipsCircleProgress(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ARTipsCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ARTipsCircleProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.mStrokeWidth);
      this.mPaint.setAntiAlias(true);
    }
    if (this.H != null)
    {
      this.mPaint.setColor(this.mProgressBgColor);
      paramCanvas.drawArc(this.H, -90.0F, 360.0F, false, this.mPaint);
      this.mPaint.setColor(this.mProgressColor);
      paramCanvas.drawArc(this.H, -90.0F, 360.0F * (this.atu / 100.0F), false, this.mPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.H == null) {
      this.H = new RectF();
    }
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    this.H.left = (this.mStrokeWidth / 2);
    this.H.top = (this.mStrokeWidth / 2);
    this.H.right = (paramInt1 - this.mStrokeWidth / 2);
    this.H.bottom = (paramInt2 - this.mStrokeWidth / 2);
  }
  
  public void setProgress(int paramInt)
  {
    this.atu = paramInt;
    setText(this.atu + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsCircleProgress
 * JD-Core Version:    0.7.0.1
 */