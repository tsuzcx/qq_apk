package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import aqcx;

public class ColorSelectView
  extends View
{
  private float Bf;
  private boolean cZK;
  private int mColor;
  private int mInterval;
  private Paint mPaint;
  
  public ColorSelectView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ColorSelectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ColorSelectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mInterval = aqcx.dip2px(getContext(), 5.0F);
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.Bf = getResources().getDisplayMetrics().density;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getMeasuredWidth();
    this.mPaint.setColor(this.mColor);
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(i / 2, i / 2, (i - this.mInterval) / 2, this.mPaint);
    if (this.cZK)
    {
      this.mPaint.setColor(-15550475);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.Bf);
      paramCanvas.drawCircle(i / 2, i / 2, i / 2 - this.Bf, this.mPaint);
    }
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
    invalidate();
  }
  
  public void setSelect(boolean paramBoolean)
  {
    this.cZK = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorSelectView
 * JD-Core Version:    0.7.0.1
 */