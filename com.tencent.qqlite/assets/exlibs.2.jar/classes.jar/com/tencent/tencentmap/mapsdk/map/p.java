package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import android.graphics.PointF;
import java.util.ArrayList;

final class p
{
  public PointF a;
  n.b b = null;
  public int c = 1;
  public int d = 18;
  public int e = 10;
  public final int f = 18;
  float[] g = null;
  double[] h = null;
  double[] i = null;
  double[] j = null;
  a k = null;
  private Point l = null;
  private GeoPoint m = new GeoPoint(39908716, 116397529);
  
  public p(n.b paramb)
  {
    this.b = paramb;
    if (this.k == null) {
      this.k = new a();
    }
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int n;
    if (paramInt2 < 0) {
      n = paramInt2 + paramInt1;
    }
    do
    {
      return n;
      n = paramInt2;
    } while (paramInt2 < paramInt1);
    return paramInt2 - paramInt1;
  }
  
  private void h()
  {
    this.a = a(this.m, this.e);
  }
  
  final PointF a(GeoPoint paramGeoPoint, int paramInt)
  {
    double d5 = Math.min(Math.max(Math.sin(paramGeoPoint.getLatitudeE6() / 1000000.0D * 0.0174532925199433D), -0.9999D), 0.9999D);
    double d1 = this.h[paramInt];
    double d2 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    double d3 = this.i[paramInt];
    double d4 = this.h[paramInt];
    d5 = Math.log((1.0D + d5) / (1.0D - d5));
    double d6 = this.j[paramInt];
    return new PointF((float)(d1 + d2 * d3), (float)(d4 + d5 * d6 * 0.5D));
  }
  
  public final GeoPoint a(PointF paramPointF, int paramInt)
  {
    return b(new PointF(this.a.x + (paramPointF.x - this.l.x), this.a.y - (paramPointF.y - this.l.y)), paramInt);
  }
  
  public final ArrayList<v.b> a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = a(this.m, paramInt1);
    int n = (int)Math.floor(((PointF)localObject).x / 256.0F);
    int i1 = (int)Math.floor(((PointF)localObject).y / 256.0F);
    float f1 = this.l.x - ((PointF)localObject).x % 256.0F;
    float f2 = this.l.y - (256.0F - ((PointF)localObject).y % 256.0F);
    int i6 = (int)Math.ceil(f1 / 256.0F);
    int i2 = (int)Math.ceil((paramInt2 * 1.0F - f1 - 256.0F) / 256.0F);
    int i3 = (int)Math.ceil(f2 / 256.0F);
    int i4 = (int)Math.ceil((paramInt3 * 1.0F - f2 - 256.0F) / 256.0F);
    localObject = new ArrayList();
    int i5 = (int)Math.pow(2.0D, paramInt1 + 1);
    paramInt2 = -i6;
    while (paramInt2 <= i2)
    {
      paramInt3 = -i4;
      while (paramInt3 <= i3)
      {
        v.c localc = new v.c(a(i5, n + paramInt2), a(i5, i1 + paramInt3), paramInt1);
        localc.e = (paramInt2 * 256 + f1);
        localc.f = (f2 - paramInt3 * 256);
        ((ArrayList)localObject).add(localc);
        paramInt3 += 1;
      }
      paramInt2 += 1;
    }
    return localObject;
  }
  
  public final ArrayList<v.b> a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    int i2 = (int)Math.floor(this.a.x / 256.0F);
    int i3 = (int)Math.floor(this.a.y / 256.0F);
    float f1 = this.l.x - this.a.x % 256.0F;
    float f2 = this.l.y - (256.0F - this.a.y % 256.0F);
    double d3 = paramInt2 * (1.0D / paramFloat - 1.0D) / 2.0D;
    double d2 = f1 + d3;
    double d1 = d2;
    if (d2 < 0.0D) {
      d1 = 0.0D;
    }
    d3 = paramInt2 * 1.0F - f1 - 256.0F + d3;
    d2 = d3;
    if (d3 < 0.0D) {
      d2 = 0.0D;
    }
    double d5 = paramInt3 * (1.0D / paramFloat - 1.0D) / 2.0D;
    double d4 = f2 + d5;
    d3 = d4;
    if (d4 < 0.0D) {
      d3 = 0.0D;
    }
    d5 = paramInt3 * 1.0F - f2 - 256.0F + d5;
    d4 = d5;
    if (d5 < 0.0D) {
      d4 = 0.0D;
    }
    int i4 = (int)Math.ceil(d1 / 256.0D);
    int i5 = (int)Math.ceil(d2 / 256.0D);
    int i6 = (int)Math.ceil(d3 / 256.0D);
    int i7 = (int)Math.ceil(d4 / 256.0D);
    ArrayList localArrayList = new ArrayList();
    int i8 = (int)Math.pow(2.0D, paramInt1 + 1);
    int n = 1;
    paramInt3 = 1;
    while (paramInt3 != 0)
    {
      paramInt2 = 0;
      paramInt3 = 0;
      int i9 = i3 + n - 1;
      int i1;
      int i10;
      v.b localb;
      if (i9 <= i3 + i6)
      {
        i1 = 0;
        for (;;)
        {
          paramInt2 = paramInt3;
          if (i1 >= n * 2 - 1) {
            break;
          }
          i10 = i2 - (n - 1) + i1;
          paramInt2 = paramInt3;
          if (i10 >= i2 - i4)
          {
            paramInt2 = paramInt3;
            if (i10 <= i2 + i5)
            {
              paramInt2 = paramInt3;
              if (i9 >= i3 - i7)
              {
                paramInt2 = paramInt3;
                if (i9 <= i3 + i6)
                {
                  localb = new v.b(a(i8, i10), a(i8, i9), paramInt1);
                  localb.e = (f1 - (n - 1 - i1) * 256);
                  localb.f = (f2 - (n - 1) * 256);
                  localArrayList.add(localb);
                  paramInt2 = paramInt3;
                  if (paramInt3 == 0) {
                    paramInt2 = 1;
                  }
                }
              }
            }
          }
          i1 += 1;
          paramInt3 = paramInt2;
        }
      }
      i9 = i2 + (n - 1);
      paramInt3 = paramInt2;
      if (i9 <= i2 + i5)
      {
        i1 = 1;
        for (;;)
        {
          paramInt3 = paramInt2;
          if (i1 >= n * 2 - 1) {
            break;
          }
          i10 = i3 + n - 1 - i1;
          paramInt3 = paramInt2;
          if (i9 >= i2 - i4)
          {
            paramInt3 = paramInt2;
            if (i9 <= i2 + i5)
            {
              paramInt3 = paramInt2;
              if (i10 >= i3 - i7)
              {
                paramInt3 = paramInt2;
                if (i10 <= i3 + i6)
                {
                  localb = new v.b(a(i8, i9), a(i8, i10), paramInt1);
                  localb.e = ((n - 1) * 256 + f1);
                  localb.f = (f2 - (n - 1 - i1) * 256);
                  localArrayList.add(localb);
                  paramInt3 = paramInt2;
                  if (paramInt2 == 0) {
                    paramInt3 = 1;
                  }
                }
              }
            }
          }
          i1 += 1;
          paramInt2 = paramInt3;
        }
      }
      i9 = i3 - (n - 1);
      paramInt2 = paramInt3;
      if (i9 >= i3 - i7)
      {
        i1 = 0;
        for (;;)
        {
          paramInt2 = paramInt3;
          if (i1 >= n * 2 - 2) {
            break;
          }
          i10 = i2 - (n - 1) + i1;
          paramInt2 = paramInt3;
          if (i10 >= i2 - i4)
          {
            paramInt2 = paramInt3;
            if (i10 <= i2 + i5)
            {
              paramInt2 = paramInt3;
              if (i9 >= i3 - i7)
              {
                paramInt2 = paramInt3;
                if (i9 <= i3 + i6)
                {
                  localb = new v.b(a(i8, i10), a(i8, i9), paramInt1);
                  localb.e = (f1 - (n - 1 - i1) * 256);
                  localb.f = ((n - 1) * 256 + f2);
                  localArrayList.add(localb);
                  paramInt2 = paramInt3;
                  if (paramInt3 == 0) {
                    paramInt2 = 1;
                  }
                }
              }
            }
          }
          i1 += 1;
          paramInt3 = paramInt2;
        }
      }
      i9 = i2 - (n - 1);
      paramInt3 = paramInt2;
      if (i9 >= i2 - i4)
      {
        i1 = 1;
        for (;;)
        {
          paramInt3 = paramInt2;
          if (i1 >= n * 2 - 2) {
            break;
          }
          i10 = i3 + n - 1 - i1;
          paramInt3 = paramInt2;
          if (i9 >= i2 - i4)
          {
            paramInt3 = paramInt2;
            if (i9 <= i2 + i5)
            {
              paramInt3 = paramInt2;
              if (i10 >= i3 - i7)
              {
                paramInt3 = paramInt2;
                if (i10 <= i3 + i6)
                {
                  localb = new v.b(a(i8, i9), a(i8, i10), paramInt1);
                  localb.e = (f1 - (n - 1) * 256);
                  localb.f = (f2 - (n - 1 - i1) * 256);
                  localArrayList.add(localb);
                  paramInt3 = paramInt2;
                  if (paramInt2 == 0) {
                    paramInt3 = 1;
                  }
                }
              }
            }
          }
          i1 += 1;
          paramInt2 = paramInt3;
        }
      }
      n += 1;
    }
    return localArrayList;
  }
  
  public final void a()
  {
    this.l = new Point(this.b.e() / 2, this.b.f() / 2);
    this.g = new float[19];
    this.h = new double[19];
    this.i = new double[19];
    this.j = new double[19];
    int n = 0;
    while (n <= 18)
    {
      double d1 = Math.pow(2.0D, n + 1) * 256.0D;
      this.g[n] = ((float)(d1 / 40075700.0D));
      this.h[n] = (d1 / 2.0D);
      this.i[n] = (d1 / 360.0D);
      this.j[n] = (d1 / 6.283185307179586D);
      n += 1;
    }
    h();
  }
  
  public final void a(Point paramPoint)
  {
    if (this.l == null) {
      this.l = new Point();
    }
    this.l.x = paramPoint.x;
    this.l.y = paramPoint.y;
  }
  
  public final PointF b(GeoPoint paramGeoPoint, int paramInt)
  {
    paramGeoPoint = a(paramGeoPoint, paramInt);
    return new PointF(this.l.x + (paramGeoPoint.x - this.a.x), this.l.y - (paramGeoPoint.y - this.a.y));
  }
  
  final GeoPoint b(PointF paramPointF, int paramInt)
  {
    double d1 = (paramPointF.x - this.h[paramInt]) / this.i[paramInt];
    return new GeoPoint((int)(1000000.0D * (Math.asin(1.0D - 2.0D / (1.0D + Math.pow(2.718281828459045D, (paramPointF.y - this.h[paramInt]) / 0.5D / this.j[paramInt]))) * 180.0D / 3.141592653589793D)), (int)(1000000.0D * d1));
  }
  
  public final void b()
  {
    h();
  }
  
  public final Point c()
  {
    return new Point(this.l.x, this.l.y);
  }
  
  final GeoPoint d()
  {
    return this.m;
  }
  
  public final void e()
  {
    int n = (int)this.h[this.e] * 2;
    if (this.a.x < 0.0F)
    {
      localPointF = this.a;
      localPointF.x += n;
    }
    do
    {
      while (this.a.y < 0.0F)
      {
        localPointF = this.a;
        localPointF.y += n;
        return;
        if (this.a.x > n)
        {
          localPointF = this.a;
          localPointF.x -= n;
        }
      }
    } while (this.a.y <= n);
    PointF localPointF = this.a;
    localPointF.y -= n;
  }
  
  public final void f()
  {
    this.m = b(this.a, this.e);
  }
  
  public final v.c g()
  {
    int n = (int)Math.floor(this.a.x / 256.0F);
    int i1 = (int)Math.floor(this.a.y / 256.0F);
    float f1 = this.l.x;
    float f2 = this.a.x;
    float f3 = this.l.y;
    float f4 = this.a.y;
    v.c localc = new v.c(n, i1, this.b.g());
    localc.e = (f1 - f2 % 256.0F);
    localc.f = (f3 - (256.0F - f4 % 256.0F));
    return localc;
  }
  
  final class a
    implements Projection
  {
    a() {}
    
    private static double a(double paramDouble)
    {
      return paramDouble / 180.0D * 3.141592653589793D;
    }
    
    private int a(boolean paramBoolean)
    {
      int i = p.this.b.e();
      GeoPoint localGeoPoint1 = fromPixels(0, p.this.b.f());
      GeoPoint localGeoPoint2 = fromPixels(i, 0);
      if (paramBoolean) {
        return Math.abs(localGeoPoint1.getLongitudeE6() - localGeoPoint2.getLongitudeE6());
      }
      return Math.abs(localGeoPoint1.getLatitudeE6() - localGeoPoint2.getLatitudeE6());
    }
    
    public final int a()
    {
      return a(false);
    }
    
    public final int b()
    {
      return a(true);
    }
    
    public final double distanceBetween(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
    {
      double d3 = paramGeoPoint1.getLatitudeE6() / 1000000.0D;
      double d2 = paramGeoPoint1.getLongitudeE6() / 1000000.0D;
      double d4 = paramGeoPoint2.getLatitudeE6() / 1000000.0D;
      double d5 = paramGeoPoint2.getLongitudeE6() / 1000000.0D;
      double d1 = a(d4 - d3);
      d2 = a(d5 - d2);
      d3 = a(d3);
      d4 = a(d4);
      d5 = Math.sin(d1 / 2.0D);
      d1 = Math.sin(d1 / 2.0D);
      double d6 = Math.sin(d2 / 2.0D);
      d1 = d1 * d5 + Math.sin(d2 / 2.0D) * d6 * Math.cos(d3) * Math.cos(d4);
      return Math.atan2(Math.sqrt(d1), Math.sqrt(1.0D - d1)) * 2.0D * 6381480.0D;
    }
    
    public final GeoPoint fromPixels(int paramInt1, int paramInt2)
    {
      Object localObject = p.this.c();
      float f = p.this.b.b();
      localObject = new PointF((paramInt1 - ((Point)localObject).x) / f + ((Point)localObject).x, (paramInt2 - ((Point)localObject).y) / f + ((Point)localObject).y);
      return p.this.a((PointF)localObject, p.this.e);
    }
    
    public final float metersToEquatorPixels(float paramFloat)
    {
      return paramFloat * p.this.b.b() * p.this.g[p.this.e];
    }
    
    public final float metersToPixels(double paramDouble1, double paramDouble2)
    {
      paramDouble1 = paramDouble2 / (float)Math.cos(3.141592653589793D * paramDouble1 / 180.0D);
      return (float)(p.this.b.b() * paramDouble1 * p.this.g[p.this.e]);
    }
    
    public final Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
    {
      int i = p.this.b.g();
      float f1 = p.this.b.b();
      paramGeoPoint = p.this.b(paramGeoPoint, i);
      Point localPoint = p.this.c();
      float f2 = paramGeoPoint.x;
      float f3 = localPoint.x;
      float f4 = localPoint.x;
      float f5 = paramGeoPoint.y;
      float f6 = localPoint.y;
      float f7 = localPoint.y;
      paramGeoPoint = new Point(Math.round((f2 - f3) * f1 + f4), Math.round((f5 - f6) * f1 + f7));
      if (paramPoint != null)
      {
        paramPoint.x = paramGeoPoint.x;
        paramPoint.y = paramGeoPoint.y;
      }
      return paramGeoPoint;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.p
 * JD-Core Version:    0.7.0.1
 */