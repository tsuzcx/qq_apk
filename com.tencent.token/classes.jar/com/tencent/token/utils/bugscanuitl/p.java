package com.tencent.token.utils.bugscanuitl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public final class p
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private Bitmap f;
  private Bitmap g;
  private boolean h;
  private View i;
  private String j;
  private e k;
  private boolean l = true;
  private boolean m;
  
  public p(View paramView)
  {
    this.i = paramView;
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public final void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this.f = paramBitmap1;
    this.g = paramBitmap2;
  }
  
  public final void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (this.f != null)
    {
      if (!this.m) {
        break label231;
      }
      if (!this.h) {
        break label172;
      }
      new NinePatch(this.g, this.g.getNinePatchChunk(), null).draw(paramCanvas, new Rect(this.a, this.b, this.a + this.c, this.b + this.d));
    }
    for (;;)
    {
      if (this.j != null)
      {
        String str = this.j;
        float f1 = this.a + (this.c - (int)paramPaint.measureText(this.j)) / 2;
        Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
        float f2 = localFontMetrics.bottom;
        float f3 = localFontMetrics.top;
        paramCanvas.drawText(str, f1, this.b + this.d - (this.d - (f2 - f3)) / 2.0F - localFontMetrics.bottom, paramPaint);
      }
      return;
      label172:
      new NinePatch(this.f, this.f.getNinePatchChunk(), null).draw(paramCanvas, new Rect(this.a, this.b, this.a + this.c, this.b + this.d));
      continue;
      label231:
      if (this.h) {
        paramCanvas.drawBitmap(this.g, this.a, this.b + (this.d - this.f.getHeight()) / 2, paramPaint);
      } else {
        paramCanvas.drawBitmap(this.f, this.a, this.b + (this.d - this.f.getHeight()) / 2, paramPaint);
      }
    }
  }
  
  public final void a(e parame)
  {
    this.k = parame;
  }
  
  public final void a(String paramString)
  {
    this.j = paramString;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    boolean bool1;
    if (paramMotionEvent.getAction() == 1)
    {
      bool1 = bool2;
      if (this.f != null)
      {
        bool1 = bool2;
        if (f1 > this.a - this.c)
        {
          bool1 = bool2;
          if (f1 < this.a + this.c * 3)
          {
            bool1 = bool2;
            if (f2 > this.b)
            {
              bool1 = bool2;
              if (f2 < this.b + this.d) {
                if (this.l)
                {
                  this.h = false;
                  if (this.k != null) {
                    this.k.a(this.e);
                  }
                  if (this.i != null) {
                    this.i.postInvalidate();
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  if (paramMotionEvent.getAction() != 0) {
                    break;
                  }
                  bool1 = bool2;
                } while (this.f == null);
                bool1 = bool2;
              } while (f1 <= this.a - this.c);
              bool1 = bool2;
            } while (f1 >= this.a + this.c * 3);
            bool1 = bool2;
          } while (f2 <= this.b);
          bool1 = bool2;
        } while (f2 >= this.b + this.d);
        if (!this.l) {
          break;
        }
        this.h = true;
        if (this.i == null) {
          break;
        }
        this.i.postInvalidate();
        break;
        if (paramMotionEvent.getAction() != 2) {
          break;
        }
        if (((this.f != null) && (f1 < this.a - this.c)) || (f1 > this.a + this.c * 3) || (f2 < this.b)) {
          break label353;
        }
        bool1 = bool2;
      } while (f2 <= this.b + this.d);
      label353:
      if ((this.l) && (this.h))
      {
        this.h = false;
        if (this.i != null) {
          this.i.postInvalidate();
        }
      }
    }
  }
  
  public final void b(int paramInt)
  {
    this.a = paramInt;
    this.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.p
 * JD-Core Version:    0.7.0.1
 */