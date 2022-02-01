package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.models.CircleInfo;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import javax.microedition.khronos.opengles.GL10;

public class mq
  extends mu
  implements go
{
  private GeoPoint h = new GeoPoint(39909230, 116397428);
  private double i = 0.0D;
  private float j = 1000.0F;
  private pn k = null;
  private CircleOptions l;
  private int m = -1;
  private CircleInfo n = new CircleInfo();
  
  public mq(pn parampn)
  {
    this.k = parampn;
  }
  
  private static double a(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 / Math.cos(3.141592653589793D * paramDouble2 / 180.0D);
  }
  
  private static fw a(LatLng paramLatLng)
  {
    double d = paramLatLng.latitude;
    return new fw(paramLatLng.longitude * 20037508.34D / 180.0D, Math.log(Math.tan((d + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
  }
  
  private static LatLng a(fw paramfw)
  {
    float f = (float)(paramfw.b * 180.0D / 20037508.34D);
    return new LatLng((float)(57.295779513082323D * (2.0D * Math.atan(Math.exp((float)(paramfw.a * 180.0D / 20037508.34D) * 3.141592653589793D / 180.0D)) - 1.570796326794897D)), f);
  }
  
  public final Rect a(fu paramfu)
  {
    Object localObject1 = b(paramfu);
    int i1 = ((Rect)localObject1).left;
    int i2 = ((Rect)localObject1).right;
    int i3 = ((Rect)localObject1).top;
    int i4 = ((Rect)localObject1).bottom;
    Object localObject2 = new GeoPoint(i3, i1);
    Object localObject4 = new GeoPoint(i4, i1);
    Object localObject3 = new GeoPoint(i4, i2);
    localObject1 = new GeoPoint(i3, i2);
    localObject2 = paramfu.a((GeoPoint)localObject2);
    localObject4 = paramfu.a((GeoPoint)localObject4);
    localObject3 = paramfu.a((GeoPoint)localObject3);
    paramfu = paramfu.a((GeoPoint)localObject1);
    return new Rect((int)Math.min(Math.min(((DoublePoint)localObject2).x, ((DoublePoint)localObject4).x), Math.min(((DoublePoint)localObject3).x, paramfu.x)), (int)Math.min(Math.min(((DoublePoint)localObject2).y, ((DoublePoint)localObject4).y), Math.min(((DoublePoint)localObject3).y, paramfu.y)), (int)Math.max(Math.max(((DoublePoint)localObject2).x, ((DoublePoint)localObject4).x), Math.max(((DoublePoint)localObject3).x, paramfu.x)), (int)Math.max(Math.max(((DoublePoint)localObject2).y, ((DoublePoint)localObject4).y), Math.max(((DoublePoint)localObject3).y, paramfu.y)));
  }
  
  public final void a(double paramDouble)
  {
    if (paramDouble < 0.0D) {}
    double d;
    do
    {
      return;
      d = paramDouble;
      if (paramDouble == 0.0D) {
        d = 1.0E-010D;
      }
    } while ((this.l == null) || (this.l.getCenter() == null));
    this.i = d;
    this.j = ((float)fz.a(d, this.l.getCenter().latitude));
    this.f = true;
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return;
    }
    if (this.h == null) {
      this.h = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    for (;;)
    {
      this.f = true;
      return;
      this.h.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.h.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  public final void a(CircleOptions paramCircleOptions)
  {
    if (paramCircleOptions == null) {
      return;
    }
    this.l = paramCircleOptions;
    LatLng localLatLng = paramCircleOptions.getCenter();
    if (localLatLng != null) {
      a(fz.a(localLatLng));
    }
    a(paramCircleOptions.getRadius());
    a(paramCircleOptions.getStrokeWidth());
    b(paramCircleOptions.getStrokeColor());
    c(paramCircleOptions.getFillColor());
    b(paramCircleOptions.getZIndex());
    c(paramCircleOptions.isVisible());
    d(paramCircleOptions.getLevel());
    this.l = paramCircleOptions;
    this.f = true;
  }
  
  public final void a(GL10 paramGL10)
  {
    if ((this.k == null) || (this.k.az == null)) {
      return;
    }
    d();
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.h == null) || (this.k == null) || (this.k.az == null)) {}
    GeoPoint localGeoPoint;
    do
    {
      return false;
      localGeoPoint = this.k.az.b.h.a(new DoublePoint(paramFloat1, paramFloat2));
    } while (Math.hypot(localGeoPoint.getLatitudeE6() - this.h.getLatitudeE6(), localGeoPoint.getLongitudeE6() - this.h.getLongitudeE6()) > this.j);
    return true;
  }
  
  public final Rect b(fu paramfu)
  {
    double d = a(this.i, this.h.getLatitudeE6() / 1000000.0D);
    Object localObject = a(new LatLng(this.h.getLatitudeE6() / 1000000.0D, this.h.getLongitudeE6() / 1000000.0D));
    paramfu = new fw(((fw)localObject).b - d, ((fw)localObject).a + d);
    localObject = new fw(((fw)localObject).b + d, ((fw)localObject).a - d);
    paramfu = a(paramfu);
    localObject = a((fw)localObject);
    Rect localRect = new Rect();
    localRect.left = ((int)(paramfu.longitude * 1000000.0D));
    localRect.top = ((int)(paramfu.latitude * 1000000.0D));
    localRect.right = ((int)(((LatLng)localObject).longitude * 1000000.0D));
    localRect.bottom = ((int)(((LatLng)localObject).latitude * 1000000.0D));
    return localRect;
  }
  
  public final void b()
  {
    Object localObject;
    int i1;
    if ((this.m != -1) && (this.k != null) && (this.k.az != null))
    {
      localObject = this.k.az;
      i1 = this.m;
      localObject = ((pm)localObject).b;
      if ((((lw)localObject).a != null) && (i1 != -1)) {
        break label61;
      }
    }
    for (;;)
    {
      this.m = -1;
      return;
      label61:
      localObject = ((lw)localObject).a;
      if ((((pf)localObject).b != 0L) && (i1 >= 0) && (((pf)localObject).f != null)) {
        ((pf)localObject).f.a(new pf.1((pf)localObject, i1));
      }
    }
  }
  
  public final void c() {}
  
  public final void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.f = true;
  }
  
  public final void d()
  {
    if (((this.m > 0) && (!this.f)) || (this.k == null) || (this.k.az == null)) {
      return;
    }
    this.n.zIndex = ((int)this.d);
    this.n.borderColor = this.c;
    this.n.borderWidth = ((int)this.a);
    this.n.fillColor = this.b;
    this.n.radius = ((float)this.i);
    this.n.centerX = this.h.getLongitudeE6();
    this.n.centerY = this.h.getLatitudeE6();
    this.n.isVisible = this.e;
    this.n.level = this.g;
    if (this.m == -1) {
      this.m = this.k.az.a(this.n);
    }
    for (;;)
    {
      this.f = false;
      return;
      if (this.f) {
        this.k.az.a(this.m, this.n);
      }
    }
  }
  
  public final void h()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.mq
 * JD-Core Version:    0.7.0.1
 */