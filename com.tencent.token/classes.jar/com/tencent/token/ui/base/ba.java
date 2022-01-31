package com.tencent.token.ui.base;

import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import com.tencent.token.utils.s;
import java.lang.reflect.Method;

public final class ba
  extends GradientDrawable
{
  private int a;
  private int b;
  private boolean c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ba(GradientDrawable.Orientation paramOrientation, int paramInt1, int paramInt2)
  {
    setDither(true);
    setShape(0);
    mutate();
    if (s.l() >= 16) {}
    for (;;)
    {
      try
      {
        getClass().getMethod("setOrientation", new Class[] { GradientDrawable.Orientation.class }).invoke(this, new Object[] { paramOrientation });
        getClass().getMethod("setColors", new Class[] { [I.class }).invoke(this, new Object[] { { paramInt1, paramInt2 } });
        this.d = paramInt1;
        this.e = paramInt2;
        return;
      }
      catch (Exception paramOrientation)
      {
        paramOrientation.printStackTrace();
        continue;
      }
      setColor(paramInt1);
    }
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 == paramInt4 - 1) {
      return paramInt2 | 0xFF000000;
    }
    int i = paramInt1 >> 16 & 0xFF;
    int j = paramInt1 >> 8 & 0xFF;
    paramInt1 &= 0xFF;
    return (i + ((paramInt2 >> 16 & 0xFF) - i) / paramInt4 * paramInt3 << 16 | j + ((paramInt2 >> 8 & 0xFF) - j) / paramInt4 * paramInt3 << 8 | paramInt1 + ((paramInt2 & 0xFF) - paramInt1) / paramInt4 * paramInt3) & 0xFFFFFF | 0xFF000000;
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
      if (this.a > this.b) {}
    }
    else
    {
      try
      {
        if (s.l() >= 16) {
          getClass().getMethod("setColors", new Class[] { [I.class }).invoke(this, new Object[] { { a(this.d, this.f, this.a, this.b), a(this.e, this.g, this.a, this.b) } });
        }
        for (;;)
        {
          invalidateSelf();
          return;
          setColor(a(this.d, this.f, this.a, this.b));
        }
      }
      catch (Exception paramCanvas)
      {
        for (;;)
        {
          paramCanvas.printStackTrace();
        }
      }
    }
    this.d = this.f;
    this.e = this.g;
    this.c = false;
    this.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ba
 * JD-Core Version:    0.7.0.1
 */