package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import aqcx;

public class MutliSeletedBottomLine
  extends View
{
  private final float BD = 0.2F;
  private final float BE = 1.0F;
  private final float BF = 2.0F;
  private final float BG = 6.0F;
  private boolean daq;
  private float mHeight = 29.0F;
  private Paint mPaint = new Paint();
  private int mPointCount;
  private float mWidth;
  
  public MutliSeletedBottomLine(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.mWidth = paramInt;
    this.mHeight = aqcx.dip2px(paramContext, 29.0F);
    this.daq = paramBoolean;
    this.mPointCount = ((int)(paramInt / 8.0F));
  }
  
  @SuppressLint({"ResourceAsColor"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mPaint.setColor(getResources().getColor(2131165316));
    this.mPaint.setAntiAlias(true);
    float f1;
    int i;
    if (!this.daq)
    {
      f1 = 0.2F;
      i = 0;
      label43:
      if (i >= this.mPointCount) {
        return;
      }
      if (this.daq) {
        break label133;
      }
    }
    label133:
    for (double d = f1 + i / this.mPointCount * 0.8D;; d = f1 - i / this.mPointCount * 0.8D)
    {
      float f2 = (float)d;
      this.mPaint.setAlpha((int)(f2 * 255.0F));
      paramCanvas.drawCircle(i * 8.0F + 2.0F, this.mHeight / 2.0F, 2.0F, this.mPaint);
      i += 1;
      break label43;
      f1 = 1.0F;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension((int)this.mWidth, getMeasuredHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MutliSeletedBottomLine
 * JD-Core Version:    0.7.0.1
 */