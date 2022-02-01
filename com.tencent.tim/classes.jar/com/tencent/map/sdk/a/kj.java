package com.tencent.map.sdk.a;

import android.os.Handler;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.json.JSONArray;

public final class kj
  implements hb, mg
{
  public gc a;
  public hh b;
  boolean c;
  public pn d;
  TencentMap.OnIndoorStateChangeListener e = null;
  public Handler f = new Handler();
  public pm g = null;
  public boolean h = false;
  public IndoorBuilding i = null;
  
  public kj(pn parampn, String paramString)
  {
    this.d = parampn;
    if (this.d != null)
    {
      if (paramString != null) {
        break label223;
      }
      this.a = gf.a(this.d.ay);
    }
    for (;;)
    {
      int j = this.a.b("AIEnabled");
      int k = this.a.b("AIType");
      try
      {
        parampn = new JSONArray(this.a.a("AIBuildingList"));
        if ((j != -1) && (k != -1) && (parampn != null)) {
          this.b = new hh(j, k, parampn);
        }
        if ((this.g != null) && (k == 1)) {
          this.g.a(a());
        }
        this.c = false;
        a(this.c);
        this.g = this.d.az;
        if (this.g != null)
        {
          this.g.a(this);
          this.g.b.a(this);
          this.e = new pj(this.d);
        }
        return;
        label223:
        this.a = ge.a(this.d.ay, paramString);
      }
      catch (Exception parampn)
      {
        for (;;)
        {
          or.a("indoor auth init failed", parampn);
          parampn = null;
        }
      }
    }
  }
  
  private boolean d()
  {
    return (this.b != null) && (this.b.a == 1);
  }
  
  public final void a(int paramInt)
  {
    if ((!this.c) || (this.d == null) || (this.d.az == null) || (this.d.n == null)) {
      return;
    }
    if (this.h)
    {
      this.d.n.a(true);
      return;
    }
    this.d.n.a(false);
    c();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.g == null) {}
    do
    {
      do
      {
        return;
        if (!d())
        {
          this.g.b(false);
          return;
        }
        if ((this.d != null) && (this.d.n != null)) {
          this.d.n.a(paramBoolean);
        }
        this.g.b(paramBoolean);
      } while ((paramBoolean) || (!this.h));
      this.h = false;
      this.i = null;
    } while (this.e == null);
    this.e.onIndoorBuildingDeactivated();
  }
  
  public final String[] a()
  {
    if (this.b != null) {
      return this.b.d;
    }
    return null;
  }
  
  public final void b()
  {
    if ((!this.c) || (this.d == null) || (this.d.az == null)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = this.d.az;
      localObject2 = new GeoPoint();
      localObject1 = ((pm)localObject1).b.a.b((GeoPoint)localObject2);
    } while (localObject1 == null);
    Object localObject2 = new LatLng(((GeoPoint)localObject2).getLatitudeE6() * 1.0D / 1000000.0D, ((GeoPoint)localObject2).getLongitudeE6() * 1.0D / 1000000.0D);
    String str1 = ((ii)localObject1).a;
    String str2 = ((ii)localObject1).b;
    String[] arrayOfString = ((ii)localObject1).d;
    int j = ((ii)localObject1).c;
    this.f.post(new kj.2(this, str1, str2, (LatLng)localObject2, arrayOfString, j));
  }
  
  final void c()
  {
    if ((this.d == null) || (this.d.az == null) || (this.h)) {}
    pm localpm;
    int j;
    do
    {
      return;
      localpm = this.d.az;
      j = Math.min(20, this.d.g);
    } while (localpm.e() >= j);
    localpm.e(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.kj
 * JD-Core Version:    0.7.0.1
 */