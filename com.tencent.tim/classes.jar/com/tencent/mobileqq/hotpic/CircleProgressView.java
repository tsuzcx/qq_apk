package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CircleProgressView
  extends View
{
  private Paint as;
  private int dcw;
  private int dcx;
  private Paint mBackgroundPaint = new Paint();
  private int mCircleWidth = 50;
  private int mCurrentProgress;
  private RectF mRectF = new RectF();
  
  public CircleProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initPaint();
    initData();
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void initData()
  {
    setMeasureSize(dip2px(getContext(), 50.0F), dip2px(getContext(), 50.0F));
    setCircleWidth(dip2px(getContext(), 2.0F));
  }
  
  private void initPaint()
  {
    this.as = new Paint();
    this.as.setStyle(Paint.Style.STROKE);
    this.as.setAntiAlias(true);
    this.as.setARGB(255, 18, 183, 245);
    this.mBackgroundPaint.setStyle(Paint.Style.FILL);
    this.mBackgroundPaint.setAntiAlias(true);
    this.mBackgroundPaint.setARGB(89, 78, 76, 67);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = getWidth() / 2;
    float f2 = f1 - this.mCircleWidth;
    this.mRectF.left = (f1 - f2 - this.mCircleWidth / 2);
    this.mRectF.top = (f1 - f2 - this.mCircleWidth / 2);
    this.mRectF.right = (f1 + f2 + this.mCircleWidth / 2);
    this.mRectF.bottom = (f2 + f1 + this.mCircleWidth / 2);
    this.as.setStrokeWidth(this.mCircleWidth);
    paramCanvas.drawCircle(f1, f1, f1, this.mBackgroundPaint);
    paramCanvas.save();
    paramCanvas.drawArc(this.mRectF, 270.0F, 3.6F * this.mCurrentProgress, false, this.as);
    paramCanvas.restore();
    postInvalidateDelayed(20L);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.dcw, this.dcx);
  }
  
  public void setCircleWidth(int paramInt)
  {
    this.mCircleWidth = paramInt;
  }
  
  public void setMeasureSize(int paramInt1, int paramInt2)
  {
    this.dcw = paramInt1;
    this.dcx = paramInt2;
  }
  
  public void setProgress(int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 100) {}
    }
    else
    {
      i = 0;
    }
    this.mCurrentProgress = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */