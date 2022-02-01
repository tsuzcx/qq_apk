package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ProgressCircle
  extends View
{
  public Paint.Style a = Paint.Style.STROKE;
  public boolean daY = true;
  public boolean daZ;
  private int ehC;
  private int ehD;
  public int ehE;
  public int ehF;
  public int ehG = 2;
  private Paint mPaint;
  private int mProgress;
  private RectF w;
  
  public ProgressCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  protected void init()
  {
    this.mPaint = new Paint();
    this.w = new RectF();
    this.ehC = 2;
    this.ehD = 18;
    this.ehE = getResources().getColor(2131167344);
    this.ehF = getResources().getColor(2131167344);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if (i != j) {
      if (i < j) {
        j = i;
      }
    }
    for (;;)
    {
      this.mPaint.setAntiAlias(true);
      this.mPaint.setColor(-1);
      paramCanvas.drawColor(0);
      this.w.left = (this.ehC / 2);
      this.w.top = (this.ehC / 2);
      this.w.right = (i - this.ehC / 2);
      this.w.bottom = (j - this.ehC / 2);
      this.mPaint.setStrokeWidth(this.ehC);
      this.mPaint.setColor(this.ehE);
      this.mPaint.setStyle(this.a);
      paramCanvas.drawArc(this.w, -90.0F, 360.0F, false, this.mPaint);
      this.mPaint.setColor(this.ehF);
      this.mPaint.setStrokeWidth(this.ehC * this.ehG);
      this.w.left = this.ehC;
      this.w.top = this.ehC;
      this.w.right = (i - this.ehC);
      this.w.bottom = (j - this.ehC);
      paramCanvas.drawArc(this.w, -90.0F, 360.0F * (this.mProgress / 100.0F), false, this.mPaint);
      if (this.daY)
      {
        i /= 2;
        j /= 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(this.ehC);
        paramCanvas.drawRect(new RectF(i - this.ehD / 2, j - this.ehD / 2, i + this.ehD / 2, j + this.ehD / 2), this.mPaint);
      }
      if (this.daZ)
      {
        String str = this.mProgress + "%";
        this.mPaint.setTextSize(40.0F);
        this.mPaint.setStrokeWidth(1.0F);
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        float f = this.mPaint.measureText(str);
        Paint.FontMetricsInt localFontMetricsInt = this.mPaint.getFontMetricsInt();
        i = (int)((getWidth() - f) / 2.0F);
        j = (getHeight() - (localFontMetricsInt.descent - localFontMetricsInt.ascent)) / 2;
        int k = -localFontMetricsInt.ascent;
        paramCanvas.drawText(str, i, k + j, this.mPaint);
      }
      return;
      i = j;
      break;
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.mProgress = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressCircle
 * JD-Core Version:    0.7.0.1
 */