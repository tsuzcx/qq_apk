package com.tencent.mobileqq.microapp.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public final class e
  extends Drawable
{
  private static final RectF c = new RectF();
  private Paint a;
  private float b;
  
  public e(int paramInt1, Paint.Style paramStyle, float paramFloat1, int paramInt2, float paramFloat2)
  {
    this.b = paramFloat2;
    this.a = new Paint(1);
    this.a.setColor(paramInt1);
    this.a.setAlpha(paramInt2);
    this.a.setStyle(paramStyle);
    this.a.setStrokeWidth(paramFloat1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    if ((i > 0) && (j > 0))
    {
      paramCanvas.save();
      c.set(localRect);
      paramCanvas.drawRoundRect(c, this.b, this.b, this.a);
      paramCanvas.restore();
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.e
 * JD-Core Version:    0.7.0.1
 */