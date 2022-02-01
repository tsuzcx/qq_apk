package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolylineClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class lt
  implements lb, mb
{
  public pn a = null;
  private TencentMap.OnPolylineClickListener b = null;
  
  public lt(IMapRenderView paramIMapRenderView)
  {
    this.a = ((pn)paramIMapRenderView.getVectorMapDelegate());
    if ((this.a != null) && (this.a.a(mw.class) == null)) {
      this.a.a(mw.class, this);
    }
  }
  
  public final Polyline a(PolylineOptions paramPolylineOptions, kq paramkq)
  {
    if (this.a == null) {}
    mw localmw;
    do
    {
      return null;
      localmw = new mw(this.a);
      localmw.a(paramPolylineOptions);
      localmw.d();
    } while (!this.a.a(localmw));
    this.a.az.b.k();
    paramPolylineOptions = new Polyline(paramPolylineOptions, paramkq, localmw.L);
    localmw.i = paramPolylineOptions;
    return paramPolylineOptions;
  }
  
  public final void a()
  {
    if (this.a != null) {
      this.a.c(mw.class);
    }
  }
  
  public final void a(TencentMap.OnPolylineClickListener paramOnPolylineClickListener)
  {
    this.b = paramOnPolylineClickListener;
  }
  
  public final void a(String paramString)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    this.a.a(paramString, true);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, float paramFloat)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    paramString.a(paramFloat);
    paramString.d();
    this.a.az.b.k();
  }
  
  public final void a(String paramString, int paramInt)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.b(paramInt);
    paramString.d();
    this.a.az.b.k();
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    if (paramString.h != null)
    {
      paramString.h.a();
      paramString.h.a(paramInt1, paramInt2);
      paramString.e();
    }
    paramString.d();
    this.a.az.b.k();
  }
  
  public final void a(String paramString, int paramInt, LatLng paramLatLng)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    paramLatLng = fz.a(paramLatLng);
    if ((paramInt == -1) || (paramLatLng == null)) {}
    for (;;)
    {
      this.a.az.b.k();
      return;
      paramString.r = paramInt;
      paramString.s = paramLatLng;
      if (paramString.h != null) {
        paramString.h.a(paramString.r, paramString.s);
      }
      if (paramString.k != null) {
        paramString.k.s();
      }
    }
  }
  
  public final void a(String paramString, GlAnimation paramGlAnimation)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if ((paramString == null) || (!(paramString instanceof mw))) {
        return;
      }
    }
    ((mw)paramString).a(paramGlAnimation);
  }
  
  public final void a(String paramString, BitmapDescriptor paramBitmapDescriptor)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    paramString.a(paramBitmapDescriptor);
    paramString.d();
    this.a.az.b.k();
  }
  
  public final void a(String paramString, PolylineOptions.Text paramText)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (!(paramString instanceof mw)) {
        return;
      }
    }
    paramString = (mw)paramString;
    paramString.o = paramText;
    paramString.d();
    this.a.az.b.k();
  }
  
  public final void a(String paramString, PolylineOptions paramPolylineOptions)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if ((paramString == null) || (!(paramString instanceof mw))) {
        return;
      }
    }
    ((mw)paramString).a(paramPolylineOptions);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, List<LatLng> paramList)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    try
    {
      paramString.a(paramList);
      label69:
      paramString.d();
      this.a.az.b.k();
      return;
    }
    catch (IndexOutOfBoundsException paramList)
    {
      break label69;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.c(paramBoolean);
    paramString.d();
    this.a.az.b.k();
  }
  
  public final void a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    paramString.a(paramArrayOfInt1, paramArrayOfInt2);
    paramString.d();
    this.a.az.b.k();
  }
  
  public final boolean a(mu parammu, GeoPoint paramGeoPoint)
  {
    parammu = (mw)parammu;
    boolean bool = parammu.i.isClickable();
    if ((this.b != null) && (bool))
    {
      paramGeoPoint = fz.a(paramGeoPoint);
      this.b.onPolylineClick(parammu.i, paramGeoPoint);
      return true;
    }
    return false;
  }
  
  public final void b(String paramString, float paramFloat)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    paramString.b(paramFloat);
    paramString.d();
    this.a.az.b.k();
  }
  
  public final void b(String paramString, int paramInt)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.d(paramInt);
    paramString.d();
    this.a.az.b.k();
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    paramString.l = paramBoolean;
    paramString.d();
    this.a.az.b.k();
  }
  
  public final int[][] b(String paramString)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return null;
    }
    for (;;)
    {
      mw localmw;
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return null;
        }
        if (!(paramString instanceof mw)) {
          return null;
        }
        localmw = (mw)paramString;
        if (localmw.m == null) {
          break label158;
        }
        if (localmw.n == null)
        {
          break label158;
          return paramString;
        }
      }
      if (localmw.m.length != localmw.n.length)
      {
        paramString = null;
      }
      else
      {
        int i = localmw.m.length;
        paramString = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i });
        paramString[0] = localmw.m;
        paramString[1] = localmw.n;
        continue;
        label158:
        paramString = null;
      }
    }
  }
  
  public final void c(String paramString)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    if (paramString.h != null) {
      paramString.h.a();
    }
    paramString.d();
    this.a.az.b.k();
  }
  
  public final void c(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    paramString.p = paramBoolean;
    paramString.d();
    this.a.az.b.k();
  }
  
  public final Rect d(String paramString)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return new Rect();
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null)
      {
        paramString = new Rect();
        return paramString;
      }
    }
    if (!(paramString instanceof mw))
    {
      paramString = new Rect();
      return paramString;
    }
    paramString = ((mw)paramString).h.b();
    return paramString;
  }
  
  public final void d(String paramString, boolean paramBoolean)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mw)) {
      return;
    }
    paramString = (mw)paramString;
    paramString.q = paramBoolean;
    if (paramString.h != null) {
      paramString.h.a.q = paramBoolean;
    }
    this.a.az.b.k();
  }
  
  public final List<gg> e(String paramString)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return null;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (!(paramString instanceof mw)) {
        return null;
      }
      paramString = (mw)paramString;
      ??? = new ArrayList(1);
      ((List)???).add(paramString.h);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.lt
 * JD-Core Version:    0.7.0.1
 */