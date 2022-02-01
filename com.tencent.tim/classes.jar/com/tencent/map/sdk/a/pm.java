package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.models.CircleInfo;
import com.tencent.map.sdk.engine.jni.models.Polygon2D;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;

public final class pm
{
  public boolean a = false;
  public lw b;
  public int c = 20;
  public int d = 3;
  public boolean e = true;
  private GeoPoint f = new GeoPoint();
  private int g = 0;
  
  public pm(lw paramlw)
  {
    this.b = paramlw;
  }
  
  public final int a()
  {
    return this.b.c.m();
  }
  
  public final int a(CircleInfo paramCircleInfo)
  {
    return this.b.a(paramCircleInfo);
  }
  
  public final int a(Polygon2D paramPolygon2D)
  {
    return this.b.a(paramPolygon2D);
  }
  
  public final TileOverlay a(TileOverlayOptions paramTileOverlayOptions)
  {
    return this.b.D.a(paramTileOverlayOptions);
  }
  
  public final void a(double paramDouble)
  {
    this.b.c.c(paramDouble);
  }
  
  public final void a(float paramFloat)
  {
    this.b.c.a(paramFloat);
  }
  
  public final void a(int paramInt)
  {
    this.b.c.b(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.b.c.a(paramInt1, paramInt2, 1);
  }
  
  public final void a(int paramInt, CircleInfo paramCircleInfo)
  {
    this.b.a(paramInt, paramCircleInfo);
  }
  
  public final void a(go paramgo)
  {
    this.b.e.a(paramgo);
    this.b.q = true;
  }
  
  public final void a(gq paramgq)
  {
    this.b.e.b = paramgq;
  }
  
  public final void a(hb paramhb)
  {
    this.b.c.a(paramhb);
  }
  
  public final void a(he paramhe)
  {
    this.b.c.a(paramhe);
  }
  
  public final void a(lh paramlh)
  {
    this.b.c.a(paramlh);
  }
  
  public final void a(mi parammi)
  {
    this.b.a(parammi);
  }
  
  public final void a(nv paramnv)
  {
    this.b.c.a(paramnv);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.b != null) {
      this.b.a(paramString1, paramString2);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public final void a(String[] paramArrayOfString)
  {
    this.b.a(paramArrayOfString);
  }
  
  public final GeoPoint b()
  {
    return this.b.c.i.m;
  }
  
  public final void b(float paramFloat)
  {
    this.b.c.b(paramFloat);
  }
  
  public final void b(int paramInt)
  {
    this.b.c.a(paramInt);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.b.c.a(paramInt1, paramInt2);
  }
  
  public final void b(go paramgo)
  {
    this.b.e.b(paramgo);
    this.b.q = true;
  }
  
  public final void b(he paramhe)
  {
    this.b.c.b(paramhe);
  }
  
  public final void b(Polygon2D paramPolygon2D)
  {
    this.b.b(paramPolygon2D);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }
  
  public final int c()
  {
    return this.b.c.i.b.f;
  }
  
  public final void c(float paramFloat)
  {
    this.b.c.a(paramFloat);
  }
  
  public final void c(int paramInt)
  {
    this.b.b(paramInt);
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    this.b.a(paramInt1, paramInt2);
  }
  
  public final float d()
  {
    return this.b.c.i.b.e;
  }
  
  public final void d(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public final float e()
  {
    float f1 = c();
    double d1 = f();
    return (float)(f1 + Math.log(d1) / Math.log(2.0D));
  }
  
  public final void e(int paramInt)
  {
    this.c = paramInt;
    this.b.a.a(paramInt);
    this.b.n.c(paramInt);
  }
  
  public final float f()
  {
    return this.b.c.j();
  }
  
  public final float g()
  {
    return this.b.c.h();
  }
  
  public final float h()
  {
    return this.b.c.i();
  }
  
  @Deprecated
  public final fu i()
  {
    return new kb(this.b);
  }
  
  public final void j()
  {
    this.b.c.a.c();
  }
  
  public final String k()
  {
    String str = null;
    if (this.b != null) {
      str = this.b.l();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pm
 * JD-Core Version:    0.7.0.1
 */