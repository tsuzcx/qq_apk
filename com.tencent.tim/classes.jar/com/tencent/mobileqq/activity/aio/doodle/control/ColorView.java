package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import wja;
import wsl;

public class ColorView
  extends View
{
  private a a;
  private Bitmap bd;
  private int mColor;
  private Paint mPaint;
  private int mRadius = wja.dp2px(4.0F, getResources());
  
  public ColorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.bd != null) {
      paramCanvas.drawBitmap(this.bd, null, new RectF(0.0F, 0.0F, getWidth(), getHeight()), null);
    }
    while (this.mPaint == null) {
      return;
    }
    int j = getWidth();
    int k = getHeight();
    if (j > k) {}
    for (int i = j;; i = k)
    {
      this.mPaint.setStrokeWidth(i);
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, j, k), this.mRadius, this.mRadius, this.mPaint);
      return;
    }
  }
  
  public void setBtmap(Bitmap paramBitmap)
  {
    this.bd = paramBitmap;
    this.mPaint = null;
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
    }
    this.mPaint.setColor(this.mColor);
    this.bd = null;
    invalidate();
  }
  
  public void setListener(a parama)
  {
    this.a = parama;
    setOnClickListener(new wsl(this));
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorView
 * JD-Core Version:    0.7.0.1
 */