package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.core.functions.animation.GlAnimation.SetAnimatePropertyListener;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.security.SecureRandom;
import javax.microedition.khronos.opengles.GL10;

public class ms
  extends mu
{
  public boolean A = false;
  public boolean B = true;
  public boolean C = false;
  public int D = 0;
  public int E = 0;
  public pn F = null;
  public Marker G = null;
  public ir H;
  public GlAnimation I = null;
  public gj J;
  public GlAnimation.SetAnimatePropertyListener K = new ms.1(this);
  private boolean O = false;
  private GeoPoint P = null;
  private lq Q;
  private AnimationListener R = null;
  private TencentMap.OnMarkerClickListener S;
  protected Object h = null;
  protected Bitmap i = null;
  boolean j = false;
  protected byte[] k = new byte[0];
  float l = 0.5F;
  float m = 0.5F;
  protected float n = 0.0F;
  protected boolean o = false;
  protected float p = 0.0F;
  protected float q = 0.0F;
  protected float r = -1.0F;
  protected MarkerOptions s = null;
  protected String t = null;
  protected GeoPoint u = null;
  protected GeoPoint v = null;
  protected GeoPoint w = null;
  protected float x = 1.0F;
  protected float y = 1.0F;
  protected float z = 1.0F;
  
  public ms(lq paramlq, pn parampn)
  {
    this.Q = paramlq;
    this.F = parampn;
  }
  
  private void a(Bitmap paramBitmap)
  {
    synchronized (this.k)
    {
      this.i = paramBitmap;
      if (this.t == null) {
        this.t = paramBitmap.toString();
      }
      if (this.H != null) {
        this.H.a(this.t, new Bitmap[] { this.i });
      }
      return;
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.k)
    {
      this.t = paramString;
      return;
    }
  }
  
  private void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    a(paramBitmap);
    s();
  }
  
  private void s()
  {
    synchronized (this.k)
    {
      if ((this.i != null) && (!this.i.isRecycled())) {
        this.j = true;
      }
      return;
    }
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return;
    }
    if (this.u == null) {
      this.u = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    for (;;)
    {
      if (this.H != null) {
        this.H.a(this.u);
      }
      if (this.J == null) {
        break;
      }
      this.J.a(fz.a(this.u));
      return;
      this.u.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.u.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  public final void a(BitmapDescriptor paramBitmapDescriptor)
  {
    if ((this.F == null) || (paramBitmapDescriptor == null)) {}
    do
    {
      return;
      paramBitmapDescriptor = paramBitmapDescriptor.getFormater();
      if ((paramBitmapDescriptor != null) && (this.F != null))
      {
        Bitmap localBitmap = paramBitmapDescriptor.a(this.F.ay);
        a(paramBitmapDescriptor.g);
        b(localBitmap);
      }
    } while (this.J == null);
    this.J.f();
  }
  
  public final void a(MarkerOptions paramMarkerOptions)
  {
    if (paramMarkerOptions == null) {}
    do
    {
      return;
      this.s = paramMarkerOptions;
      a(fz.a(paramMarkerOptions.getPosition()));
      b(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV());
      c(paramMarkerOptions.isVisible());
      c(paramMarkerOptions.getRotation());
      a(paramMarkerOptions.getIcon());
      d(paramMarkerOptions.getAlpha());
      b(paramMarkerOptions.getZIndex());
      d(paramMarkerOptions.getLevel());
      this.N = paramMarkerOptions.getIndoorInfo();
      this.h = paramMarkerOptions.getTag();
    } while ((this.F == null) || (paramMarkerOptions == null) || (this.H != null));
    is localis = new is();
    localis.a = fz.a(paramMarkerOptions.getPosition());
    localis.e = paramMarkerOptions.getAlpha();
    localis.a(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV());
    Object localObject1 = new SecureRandom();
    Object localObject2 = new byte[20];
    ((SecureRandom)localObject1).nextBytes((byte[])localObject2);
    localObject1 = new String((byte[])localObject2);
    try
    {
      localObject2 = paramMarkerOptions.getIcon().getFormater().g;
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
      }
    }
    localObject1 = localis.a((String)localObject1, new Bitmap[] { paramMarkerOptions.getIcon().getBitmap(this.F.ay) });
    ((is)localObject1).g = ((int)paramMarkerOptions.getRotation());
    ((is)localObject1).f = paramMarkerOptions.isFlat();
    ((is)localObject1).j = ((int)paramMarkerOptions.getZIndex());
    ((is)localObject1).l = this.C;
    ((is)localObject1).o = paramMarkerOptions.isAvoidAnnocation();
    ((is)localObject1).p = paramMarkerOptions.isClockwise();
    ((is)localObject1).m = paramMarkerOptions.isFastLoad();
    ((is)localObject1).k = paramMarkerOptions.getLevel();
    this.H = new ir(this.F.az.b.f, localis);
  }
  
  public final void a(GL10 paramGL10)
  {
    if (this.F == null) {
      return;
    }
    if (!a())
    {
      c();
      return;
    }
    if ((this.F == null) || (!this.A)) {}
    for (;;)
    {
      if ((this.F != null) && (this.I != null))
      {
        this.I.drawAnimation();
        this.O = this.I.isRunning();
        if ((this.O) && (this.F.az != null)) {
          this.F.az.b.k();
        }
      }
      if (this.F.az == null) {
        break;
      }
      if ((this.F.az.b.f != null) && (this.H != null)) {
        this.H.a(paramGL10);
      }
      if ((this.J == null) || (!this.J.e())) {
        break;
      }
      this.J.a(paramGL10);
      return;
      a(this.F.n());
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.C = paramBoolean;
    if (this.H != null) {
      this.H.a(paramBoolean);
    }
    if (this.J != null)
    {
      if (paramBoolean) {
        this.J.a(this.D, this.E);
      }
    }
    else {
      return;
    }
    this.J.b(false);
  }
  
  public final boolean a()
  {
    if (q() != null) {
      return (this.e) && (this.M);
    }
    return this.e;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.F != null)
    {
      if (this.B) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.H == null);
        bool2 = this.H.a(paramFloat1, paramFloat2);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (this.S == null);
    this.S.onMarkerClick(this.G);
    return bool2;
  }
  
  public final void b()
  {
    this.u = null;
    this.F = null;
    this.Q = null;
    if (this.H != null) {
      this.H.b();
    }
    if (this.J != null) {
      this.J.b();
    }
  }
  
  public final void b(float paramFloat)
  {
    this.d = paramFloat;
    if (this.H != null) {
      this.H.c((int)paramFloat);
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    float f;
    if (paramFloat1 > 1.0F)
    {
      f = 1.0F;
      if (paramFloat2 <= 1.0F) {
        break label78;
      }
      paramFloat1 = 1.0F;
    }
    for (;;)
    {
      this.l = f;
      this.m = paramFloat1;
      if (this.H != null) {
        this.H.b(this.l, this.m);
      }
      if (this.J != null) {
        this.J.a_();
      }
      return;
      f = paramFloat1;
      if (paramFloat1 >= 0.0F) {
        break;
      }
      f = 0.0F;
      break;
      label78:
      paramFloat1 = paramFloat2;
      if (paramFloat2 < 0.0F) {
        paramFloat1 = 0.0F;
      }
    }
  }
  
  public final void c()
  {
    if (this.J != null)
    {
      this.J.b();
      this.J = null;
    }
    if (this.H != null) {
      this.H.b();
    }
  }
  
  public final void c(float paramFloat)
  {
    this.n = paramFloat;
    if (this.H != null) {
      this.H.b((int)this.n);
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.H != null) {
      this.H.d = paramBoolean;
    }
    if ((this.F != null) && (this.F.az != null)) {
      this.F.az.b.k();
    }
  }
  
  public final void d() {}
  
  public final void d(float paramFloat)
  {
    this.x = paramFloat;
    if (this.H != null) {
      this.H.a(paramFloat);
    }
  }
  
  public final void d(int paramInt)
  {
    super.d(paramInt);
    if (this.H != null) {
      this.H.a(paramInt);
    }
  }
  
  public final GeoPoint e()
  {
    return this.u;
  }
  
  public final boolean f()
  {
    if ((this.F == null) || (this.I == null)) {
      return false;
    }
    GeoPoint localGeoPoint2 = this.u;
    GeoPoint localGeoPoint1 = localGeoPoint2;
    if (this.C)
    {
      localGeoPoint1 = localGeoPoint2;
      if (this.F.az != null)
      {
        localGeoPoint1 = this.F.az.b.h.a(new DoublePoint(this.D, this.E));
        this.P = new GeoPoint(localGeoPoint1);
      }
    }
    return this.I.startAnimation(localGeoPoint1, this.w);
  }
  
  public final Rect g()
  {
    if ((this.H != null) && (this.F != null) && (this.F.az != null)) {
      return this.H.a(this.F.az.b.h);
    }
    return new Rect();
  }
  
  public final void h()
  {
    b();
  }
  
  public final String k()
  {
    MarkerOptions localMarkerOptions = this.s;
    if (localMarkerOptions == null) {
      return null;
    }
    return localMarkerOptions.getContentDescription();
  }
  
  public final float l()
  {
    return this.n;
  }
  
  public final boolean m()
  {
    return true;
  }
  
  public final void n()
  {
    if (this.F == null) {
      return;
    }
    this.F.a("");
    this.F.az.b.k();
    synchronized (this.F.a)
    {
      if (this.J == null) {
        return;
      }
    }
    this.J.a(false);
  }
  
  public final void o()
  {
    if ((this.F == null) || (this.s == null)) {
      return;
    }
    for (;;)
    {
      synchronized (this.F.a)
      {
        if (this.J != null) {
          break label125;
        }
        if (this.s.isViewInfowindow())
        {
          this.J = new mx(this.Q, this.G);
          if (this.C) {
            this.J.a(this.D, this.E);
          }
          this.J.a(true);
          return;
        }
      }
      this.J = new mr(this.Q, this.G);
      continue;
      label125:
      this.J.f();
    }
  }
  
  public final boolean p()
  {
    return (this.h != null) && ("AUTH_MARKER".equals(this.h.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ms
 * JD-Core Version:    0.7.0.1
 */