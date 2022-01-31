package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public final class l
  extends Overlay
{
  private Drawable a = null;
  private Bitmap b = null;
  private String c = "logo.png";
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private float m = 0.02F;
  private float n = 0.022F;
  private float o = 0.0185F;
  private float p = 0.6675F;
  private float q = 0.673F;
  private float r = 0.6853F;
  private float s = 0.012F;
  private float t = 0.0125F;
  private float u = 0.0104F;
  private int v = -2147483648;
  private int w = -2147483648;
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i = paramInt1;
    this.j = paramInt3;
    this.k = paramInt2;
    this.l = paramInt4;
    if (this.h <= 0)
    {
      paramInt1 = this.i;
      paramInt3 = this.j;
      paramInt2 = this.k;
      paramInt4 = this.l;
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.setBounds(paramInt1, paramInt3, paramInt2, paramInt4);
      }
      return;
      if (this.h <= 1)
      {
        paramInt1 = this.f - this.k;
        paramInt3 = this.j;
        paramInt2 = this.f - this.i;
        paramInt4 = this.l;
      }
      else if (this.h <= 2)
      {
        paramInt1 = this.f - this.k;
        paramInt3 = this.g - this.l;
        paramInt2 = this.f - this.i;
        paramInt4 = this.g - this.j;
      }
      else
      {
        paramInt1 = this.i;
        paramInt3 = this.g - this.l;
        paramInt2 = this.k;
        paramInt4 = this.g - this.j;
      }
    }
  }
  
  final void a(int paramInt)
  {
    this.v = paramInt;
    a(this.f, this.g, null);
  }
  
  final void a(int paramInt1, int paramInt2, Context paramContext)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    if ((this.f == 0) || (this.g == 0)) {}
    do
    {
      do
      {
        return;
        if (this.a != null) {
          break;
        }
        if ((this.b == null) && (paramContext != null)) {
          this.b = q.a(paramContext, this.c);
        }
      } while (this.b == null);
      this.a = new BitmapDrawable(this.b);
    } while (this.a == null);
    this.d = this.a.getIntrinsicWidth();
    this.e = this.a.getIntrinsicHeight();
    float f2 = this.m;
    float f3 = this.p;
    float f1 = this.s;
    if (this.f >= 1080)
    {
      f2 = this.o;
      f3 = this.r;
      f1 = this.u;
    }
    for (;;)
    {
      paramInt1 = (int)(this.f * f2);
      paramInt2 = this.f - (int)(this.f * f3);
      int i4 = paramInt2 - paramInt1;
      int i3 = this.e * i4 / this.d;
      int i1 = this.g - (int)(this.g * f1);
      int i2 = i1 - i3;
      if (this.v != -2147483648)
      {
        paramInt1 = this.v;
        paramInt2 = paramInt1 + i4;
      }
      if (this.w != -2147483648)
      {
        i1 = this.g - this.w;
        i2 = i1 - i3;
      }
      a(paramInt1, paramInt2, i2, i1);
      return;
      if (this.f >= 720)
      {
        f2 = this.n;
        f3 = this.q;
        f1 = this.t;
      }
    }
  }
  
  final void a(q.b paramb, Context paramContext)
  {
    if (paramb == q.b.d) {}
    for (this.c = "logo_satelite.png";; this.c = "logo.png")
    {
      if (this.a != null) {
        this.a = null;
      }
      if ((this.b != null) && (!this.b.isRecycled()))
      {
        this.b.recycle();
        this.b = null;
      }
      a(this.f, this.g, paramContext);
      return;
    }
  }
  
  final void b(int paramInt)
  {
    this.w = paramInt;
    a(this.f, this.g, null);
  }
  
  final void c(int paramInt)
  {
    this.h = paramInt;
    a(this.i, this.k, this.j, this.l);
  }
  
  protected final void draw(Canvas paramCanvas, MapView paramMapView)
  {
    if (this.a == null) {
      return;
    }
    this.a.draw(paramCanvas);
    super.draw(paramCanvas, paramMapView);
  }
  
  protected final void onRemoveOverlay()
  {
    super.onRemoveOverlay();
    if (this.a != null) {
      this.a = null;
    }
    if ((this.b != null) && (!this.b.isRecycled()))
    {
      this.b.recycle();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.l
 * JD-Core Version:    0.7.0.1
 */