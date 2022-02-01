package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;

public final class zs
  extends Drawable
{
  private int a;
  private Paint b;
  private float c;
  private float d;
  private float e;
  
  public zs(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramInt;
    this.b = new Paint();
    this.b.setColor(this.a);
    this.b.setAlpha(154);
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.c, this.d, this.e, this.b);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zs
 * JD-Core Version:    0.7.0.1
 */