package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Calendar;

final class gn
{
  private static gn a;
  private final Context b;
  private final LocationManager c;
  private final a d = new a();
  
  private gn(Context paramContext, LocationManager paramLocationManager)
  {
    this.b = paramContext;
    this.c = paramLocationManager;
  }
  
  private Location a(String paramString)
  {
    try
    {
      if (this.c.isProviderEnabled(paramString))
      {
        paramString = this.c.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      label22:
      break label22;
    }
    return null;
  }
  
  static gn a(Context paramContext)
  {
    if (a == null)
    {
      paramContext = paramContext.getApplicationContext();
      a = new gn(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    return a;
  }
  
  private void a(Location paramLocation)
  {
    a locala = this.d;
    long l1 = System.currentTimeMillis();
    gm localgm = gm.a();
    localgm.a(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localgm.a;
    localgm.a(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    boolean bool;
    if (localgm.c == 1) {
      bool = true;
    } else {
      bool = false;
    }
    long l3 = localgm.b;
    long l4 = localgm.a;
    localgm.a(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l5 = localgm.b;
    if ((l3 != -1L) && (l4 != -1L))
    {
      if (l1 > l4) {
        l1 = 0L + l5;
      } else if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      }
      l1 += 60000L;
    }
    else
    {
      l1 = 43200000L + l1;
    }
    locala.a = bool;
    locala.b = l2;
    locala.c = l3;
    locala.d = l4;
    locala.e = l5;
    locala.f = l1;
  }
  
  @SuppressLint({"MissingPermission"})
  private Location b()
  {
    int i = cv.a(this.b, "android.permission.ACCESS_COARSE_LOCATION");
    Location localLocation2 = null;
    Location localLocation1;
    if (i == 0) {
      localLocation1 = a("network");
    } else {
      localLocation1 = null;
    }
    if (cv.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
      localLocation2 = a("gps");
    }
    if ((localLocation2 != null) && (localLocation1 != null))
    {
      if (localLocation2.getTime() > localLocation1.getTime()) {
        return localLocation2;
      }
      return localLocation1;
    }
    if (localLocation2 != null) {
      return localLocation2;
    }
    return localLocation1;
  }
  
  private boolean c()
  {
    return this.d.f > System.currentTimeMillis();
  }
  
  final boolean a()
  {
    a locala = this.d;
    if (c()) {
      return locala.a;
    }
    Location localLocation = b();
    if (localLocation != null)
    {
      a(localLocation);
      return locala.a;
    }
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  static final class a
  {
    boolean a;
    long b;
    long c;
    long d;
    long e;
    long f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gn
 * JD-Core Version:    0.7.0.1
 */