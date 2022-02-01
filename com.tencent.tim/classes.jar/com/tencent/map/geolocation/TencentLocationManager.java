package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import c.t.m.g.ad;
import c.t.m.g.ai;
import c.t.m.g.al;
import c.t.m.g.am;
import c.t.m.g.an;
import c.t.m.g.ap;
import c.t.m.g.aw;
import c.t.m.g.az;
import c.t.m.g.ba;
import c.t.m.g.bs;
import c.t.m.g.cf;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  public static final String TYPE_OAID = "oaId";
  public static final String TYPE_QIMEI = "qImei";
  private static TencentLocationManager d;
  private final byte[] a = new byte[0];
  private final ap b;
  private final az c;
  
  private TencentLocationManager(Context paramContext)
  {
    ad.a(paramContext);
    ad.b();
    an.a();
    this.b = ap.a(paramContext);
    this.c = new az(this.b);
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
    throws NullPointerException, IllegalArgumentException
  {
    try
    {
      if (d != null) {
        break label76;
      }
      if (paramContext == null) {
        throw new NullPointerException("context is null");
      }
    }
    finally {}
    if (paramContext.getApplicationContext() == null) {
      throw new NullPointerException("application context is null");
    }
    if (Looper.myLooper() == null) {
      throw new IllegalArgumentException("getInstance must be use in Thread with looper. Please first use Looper.prapare()");
    }
    d = new TencentLocationManager(paramContext.getApplicationContext());
    label76:
    paramContext = d;
    return paramContext;
  }
  
  public final int clearPedometerData()
  {
    return this.c.b();
  }
  
  public final String getBuild()
  {
    al localal = this.b.e();
    if (localal != null) {
      return localal.e();
    }
    return "None";
  }
  
  public final int getCoordinateType()
  {
    return this.c.a;
  }
  
  public final String getKey()
  {
    return ai.e(this.b.b.g);
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    az localaz = this.c;
    if (localaz.m == 0)
    {
      localaz.a(localaz.l);
      return localaz.l;
    }
    return null;
  }
  
  public final int getPedometerData()
  {
    az localaz = this.c;
    if (localaz.c != null) {
      return localaz.c.h;
    }
    return -1;
  }
  
  public final TencentPedestrianData getPedometerDataFromLastCheck()
  {
    return this.c.c();
  }
  
  public final String getVersion()
  {
    al localal = this.b.e();
    if (localal != null) {
      return localal.d();
    }
    return "None";
  }
  
  public final boolean isSupportPedometer()
  {
    return this.c.a();
  }
  
  public final void removeUpdates(TencentLocationListener arg1)
  {
    new StringBuilder("remove location update,thread name:").append(Thread.currentThread().getName());
    synchronized (this.a)
    {
      this.c.d();
      return;
    }
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    new StringBuilder("request location with no looper,thread name:").append(Thread.currentThread().getName());
    return requestLocationUpdates(paramTencentLocationRequest, paramTencentLocationListener, Looper.myLooper());
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    new StringBuilder("request location with looper,thread name:").append(Thread.currentThread().getName());
    if (paramTencentLocationRequest == null) {
      throw new NullPointerException("request is null");
    }
    if (paramTencentLocationListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentLocationRequest, paramTencentLocationListener, paramLooper);
      return i;
    }
  }
  
  public final void setCoordinateType(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      synchronized (this.a)
      {
        az localaz = this.c;
        if (localaz.a != paramInt) {
          localaz.a = paramInt;
        }
        return;
      }
    }
    throw new IllegalArgumentException("unknown coordinate type: ".concat(String.valueOf(paramInt)));
  }
  
  public final void setDeviceID(Pair<String, String> paramPair)
  {
    if (paramPair == null) {
      throw new IllegalArgumentException("deviceID is null!");
    }
    if (((!((String)paramPair.first).equals("qImei")) && (!((String)paramPair.first).equals("oaId")) && (!((String)paramPair.first).matches("^[a-z0-9A-Z]{6,32}$"))) || (TextUtils.isEmpty((CharSequence)paramPair.second))) {
      throw new IllegalArgumentException("your deviceID is illegal!");
    }
    al localal = this.b.b;
    am.a("LocationSDK", "location_device_id_type", paramPair.first);
    am.a("LocationSDK", "location_device_id", paramPair.second);
    localal.p = paramPair;
  }
  
  public final void setKey(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      throw new IllegalArgumentException("bad key: ".concat(String.valueOf(paramString)));
    }
    this.b.b.g = paramString;
  }
  
  public final int startDirectionUpdates(TencentDirectionListener paramTencentDirectionListener, Looper paramLooper)
  {
    if (paramTencentDirectionListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    az localaz = this.c;
    int i;
    if ((paramTencentDirectionListener == null) || (paramLooper == null)) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      if (localaz.b == null) {
        return -2;
      }
      localaz.b.a();
      paramLooper = new Handler(paramLooper);
      j = localaz.b.a(paramLooper, paramTencentDirectionListener);
      i = j;
    } while (j != 0);
    localaz.b.a = true;
    return j;
  }
  
  public final int startDistanceCalculate(TencentDistanceListener paramTencentDistanceListener)
  {
    int i = 1;
    if (paramTencentDistanceListener == null) {
      throw new NullPointerException("listener is null");
    }
    synchronized (this.a)
    {
      az localaz = this.c;
      if (localaz.d == null) {}
      for (;;)
      {
        return i;
        if (!localaz.e) {
          break;
        }
        i = 2;
      }
      localaz.e = true;
      localaz.k = paramTencentDistanceListener;
      i = 0;
    }
  }
  
  public final void stopDirectionUpdate()
  {
    az localaz = this.c;
    if (localaz.b != null) {
      localaz.b.a();
    }
  }
  
  public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener arg1)
  {
    synchronized (this.a)
    {
      az localaz = this.c;
      localaz.k = null;
      localaz.f = 0.0D;
      localaz.e = false;
      localaz.j = null;
      bs localbs = new bs();
      localbs.a = (cf.a((localaz.g + 1) / (localaz.i + 1), 4) * 100.0D);
      localbs.b = localaz.g;
      localbs.c = localaz.h;
      localaz.g = 0;
      localaz.h = 0;
      localaz.i = 0;
      return localbs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */