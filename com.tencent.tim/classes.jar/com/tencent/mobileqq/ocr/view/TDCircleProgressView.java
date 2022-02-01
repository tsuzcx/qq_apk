package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class TDCircleProgressView
  extends View
{
  private Paint Q;
  private Paint cd;
  private int doy;
  private Context mContext;
  private int mCurrent;
  private int mProgressColor = Color.rgb(107, 203, 250);
  private Paint mProgressPaint;
  private float xH;
  private float xI;
  
  public TDCircleProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TDCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TDCircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  public static int d(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mContext = paramContext;
    this.doy = 2;
    this.xH = d(paramContext, 4.0F);
    this.Q = new Paint();
    this.Q.setAntiAlias(true);
    this.Q.setStrokeWidth(this.xH);
    this.Q.setStyle(Paint.Style.STROKE);
    this.Q.setColor(Color.rgb(144, 144, 144));
    this.Q.setStrokeCap(Paint.Cap.ROUND);
    this.mProgressPaint = new Paint();
    this.mProgressPaint.setAntiAlias(true);
    this.mProgressPaint.setStyle(Paint.Style.STROKE);
    this.mProgressPaint.setStrokeWidth(this.xH);
    this.mProgressPaint.setColor(this.mProgressColor);
    this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
    if (this.doy == 1) {
      this.xI = -180.0F;
    }
    for (;;)
    {
      this.cd = new Paint();
      this.cd.setTextSize(d(paramContext, 11.0F));
      this.cd.setTextAlign(Paint.Align.CENTER);
      this.cd.setStyle(Paint.Style.FILL);
      this.cd.setColor(Color.rgb(144, 144, 144));
      return;
      if (this.doy == 2) {
        this.xI = -90.0F;
      } else if (this.doy == 3) {
        this.xI = 0.0F;
      } else if (this.doy == 4) {
        this.xI = 90.0F;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    RectF localRectF = new RectF(this.xH / 2.0F, this.xH / 2.0F, getWidth() - this.xH / 2.0F, getHeight() - this.xH / 2.0F);
    paramCanvas.drawArc(localRectF, 0.0F, 360.0F, false, this.Q);
    float f = this.mCurrent * 360 / 100;
    paramCanvas.drawArc(localRectF, this.xI, f, false, this.mProgressPaint);
    paramCanvas.drawText(this.mCurrent + "%", getWidth() / 2, getHeight() / 2 + d(this.mContext, 4.0F), this.cd);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 < paramInt2) {}
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt1);
      return;
      paramInt1 = paramInt2;
    }
  }
  
  public void setCurrent(int paramInt)
  {
    this.mCurrent = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TDCircleProgressView
 * JD-Core Version:    0.7.0.1
 */