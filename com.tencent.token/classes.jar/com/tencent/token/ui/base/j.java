package com.tencent.token.ui.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;

public class j
  extends Drawable
{
  private int a;
  private Paint b;
  private float c;
  private float d;
  private float e;
  
  public j(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramInt1;
    this.b = new Paint();
    this.b.setColor(this.a);
    this.b.setAlpha(paramInt2);
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.c, this.d, this.e, this.b);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.j
 * JD-Core Version:    0.7.0.1
 */