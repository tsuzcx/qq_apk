package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import java.lang.reflect.Method;

public final class yo
  extends GradientDrawable
{
  private int a;
  private int b;
  private boolean c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public yo(GradientDrawable.Orientation paramOrientation, int paramInt1, int paramInt2)
  {
    setDither(true);
    setShape(0);
    mutate();
    if (aad.l() >= 16) {
      try
      {
        getClass().getMethod("setOrientation", new Class[] { GradientDrawable.Orientation.class }).invoke(this, new Object[] { paramOrientation });
        getClass().getMethod("setColors", new Class[] { [I.class }).invoke(this, new Object[] { { paramInt1, paramInt2 } });
      }
      catch (Exception paramOrientation)
      {
        paramOrientation.printStackTrace();
      }
    } else {
      setColor(paramInt1);
    }
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 == paramInt4 - 1) {
      return paramInt2 | 0xFF000000;
    }
    int i = paramInt1 >> 16 & 0xFF;
    int j = paramInt1 >> 8 & 0xFF;
    paramInt1 &= 0xFF;
    return (((paramInt2 >> 16 & 0xFF) - i) / paramInt4 * paramInt3 + i << 16 | ((paramInt2 >> 8 & 0xFF) - j) / paramInt4 * paramInt3 + j << 8 | ((paramInt2 & 0xFF) - paramInt1) / paramInt4 * paramInt3 + paramInt1) & 0xFFFFFF | 0xFF000000;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.c = true;
    this.b = 20;
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.d = paramInt1;
    this.g = paramInt2;
    this.e = paramInt2;
    this.c = true;
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.c)
    {
      mutate();
      this.a += 1;
      if (this.a <= this.b)
      {
        try
        {
          if (aad.l() >= 16) {
            getClass().getMethod("setColors", new Class[] { [I.class }).invoke(this, new Object[] { { a(this.d, this.f, this.a, this.b), a(this.e, this.g, this.a, this.b) } });
          } else {
            setColor(a(this.d, this.f, this.a, this.b));
          }
        }
        catch (Exception paramCanvas)
        {
          paramCanvas.printStackTrace();
        }
        invalidateSelf();
        return;
      }
      this.d = this.f;
      this.e = this.g;
      this.c = false;
      this.a = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yo
 * JD-Core Version:    0.7.0.1
 */