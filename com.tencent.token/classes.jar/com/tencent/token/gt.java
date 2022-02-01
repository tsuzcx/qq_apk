package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public final class gt
  extends Drawable
{
  private static final float b = (float)Math.toRadians(45.0D);
  private final Paint a;
  private float c;
  private float d;
  private float e;
  private float f;
  private boolean g;
  private final Path h;
  private final int i;
  private boolean j;
  private float k;
  private float l;
  private int m;
  
  public final void a(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      this.k = paramFloat;
      invalidateSelf();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      invalidateSelf();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i2 = this.m;
    int i1 = 0;
    int n;
    if (i2 != 3) {
      n = i1;
    }
    switch (i2)
    {
    default: 
      n = i1;
      if (dg.e(this) == 1) {
        n = 1;
      }
      break;
    case 1: 
      n = 1;
      break;
      n = i1;
      if (dg.e(this) == 0) {
        n = 1;
      }
      break;
    }
    float f1 = this.c;
    float f6 = (float)Math.sqrt(f1 * f1 * 2.0F);
    float f7 = this.d;
    float f8 = this.k;
    float f3 = f7 + (this.e - f7) * f8;
    float f4 = Math.round((this.l - 0.0F) * f8 + 0.0F);
    float f9 = b;
    float f10 = this.k;
    if (n != 0) {
      f1 = 0.0F;
    } else {
      f1 = -180.0F;
    }
    float f2;
    if (n != 0) {
      f2 = 180.0F;
    } else {
      f2 = 0.0F;
    }
    float f5 = this.k;
    double d1 = (f6 - f7) * f8 + f7;
    double d2 = (f9 - 0.0F) * f10 + 0.0F;
    double d3 = Math.cos(d2);
    Double.isNaN(d1);
    f6 = (float)Math.round(d3 * d1);
    d2 = Math.sin(d2);
    Double.isNaN(d1);
    f7 = (float)Math.round(d1 * d2);
    this.h.rewind();
    f8 = this.f + this.a.getStrokeWidth();
    f8 += (-this.l - f8) * this.k;
    f9 = -f3 / 2.0F;
    this.h.moveTo(f9 + f4, 0.0F);
    this.h.rLineTo(f3 - f4 * 2.0F, 0.0F);
    this.h.moveTo(f9, f8);
    this.h.rLineTo(f6, f7);
    this.h.moveTo(f9, -f8);
    this.h.rLineTo(f6, -f7);
    this.h.close();
    paramCanvas.save();
    f3 = this.a.getStrokeWidth();
    f6 = localRect.height();
    f4 = this.f;
    f6 = (int)(f6 - 3.0F * f3 - 2.0F * f4) / 4 * 2;
    paramCanvas.translate(localRect.centerX(), f6 + (f3 * 1.5F + f4));
    if (this.g)
    {
      if ((this.j ^ n)) {
        n = -1;
      } else {
        n = 1;
      }
      paramCanvas.rotate((f1 + (f2 - f1) * f5) * n);
    }
    else if (n != 0)
    {
      paramCanvas.rotate(180.0F);
    }
    paramCanvas.drawPath(this.h, this.a);
    paramCanvas.restore();
  }
  
  public final int getIntrinsicHeight()
  {
    return this.i;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    if (paramInt != this.a.getAlpha())
    {
      this.a.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gt
 * JD-Core Version:    0.7.0.1
 */