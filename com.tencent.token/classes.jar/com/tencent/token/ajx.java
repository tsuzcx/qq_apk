package com.tencent.token;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.location.Criteria;
import android.location.GnssMeasurementsEvent.Callback;
import android.location.GnssNavigationMessage.Callback;
import android.location.GnssStatus.Callback;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.location.OnNmeaMessageListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.List;

public final class ajx
{
  static LocationManager a;
  
  @SuppressLint({"MissingPermission"})
  public static GpsStatus a(GpsStatus paramGpsStatus)
  {
    if (!ll.b()) {
      return null;
    }
    akg.a("[API]LocationManagerInvoke_");
    return a.getGpsStatus(paramGpsStatus);
  }
  
  public static List<String> a()
  {
    if (!ll.b()) {
      return null;
    }
    akg.a("[API]LocationManagerInvoke_");
    return a.getAllProviders();
  }
  
  public static List<String> a(Criteria paramCriteria, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("getProviders, enabledOnly:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return null;
    }
    akg.a("[API]LocationManagerInvoke_");
    return a.getProviders(paramCriteria, paramBoolean);
  }
  
  public static List<String> a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("getProviders, enabledOnly:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return null;
    }
    akg.a("[API]LocationManagerInvoke_");
    return a.getProviders(paramBoolean);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(double paramDouble1, double paramDouble2, float paramFloat, long paramLong, PendingIntent paramPendingIntent)
  {
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.addProximityAlert(paramDouble1, paramDouble2, paramFloat, paramLong, paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(long paramLong, float paramFloat, Criteria paramCriteria, PendingIntent paramPendingIntent)
  {
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.requestLocationUpdates(paramLong, paramFloat, paramCriteria, paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(long paramLong, float paramFloat, Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
  {
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.requestLocationUpdates(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
  }
  
  public static void a(PendingIntent paramPendingIntent)
  {
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.removeUpdates(paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(Criteria paramCriteria, PendingIntent paramPendingIntent)
  {
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.requestSingleUpdate(paramCriteria, paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
  {
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.requestSingleUpdate(paramCriteria, paramLocationListener, paramLooper);
  }
  
  public static void a(LocationListener paramLocationListener)
  {
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.removeUpdates(paramLocationListener);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(String paramString, long paramLong, float paramFloat, PendingIntent paramPendingIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("requestLocationUpdates, 4provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.requestLocationUpdates(paramString, paramLong, paramFloat, paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener)
  {
    StringBuilder localStringBuilder = new StringBuilder("requestLocationUpdates, 1provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener, Looper paramLooper)
  {
    StringBuilder localStringBuilder = new StringBuilder("requestLocationUpdates, 2provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(String paramString, PendingIntent paramPendingIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("requestSingleUpdate, 3provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.requestSingleUpdate(paramString, paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(String paramString, LocationListener paramLocationListener, Looper paramLooper)
  {
    StringBuilder localStringBuilder = new StringBuilder("requestSingleUpdate, 1provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.requestSingleUpdate(paramString, paramLocationListener, paramLooper);
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean a(GnssMeasurementsEvent.Callback paramCallback)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = a.registerGnssMeasurementsCallback(paramCallback);
    } else {
      bool = false;
    }
    paramCallback = new StringBuilder("registerGnssMeasurementsCallback, ret:[");
    paramCallback.append(bool);
    paramCallback.append("]");
    akg.a("[API]LocationManagerInvoke_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean a(GnssMeasurementsEvent.Callback paramCallback, Handler paramHandler)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = a.registerGnssMeasurementsCallback(paramCallback, paramHandler);
    } else {
      bool = false;
    }
    paramCallback = new StringBuilder("registerGnssMeasurementsCallback, ret:[");
    paramCallback.append(bool);
    paramCallback.append("]");
    akg.a("[API]LocationManagerInvoke_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean a(GnssNavigationMessage.Callback paramCallback, Handler paramHandler)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = a.registerGnssNavigationMessageCallback(paramCallback, paramHandler);
    } else {
      bool = false;
    }
    paramCallback = new StringBuilder("registerGnssNavigationMessageCallback, ret:[");
    paramCallback.append(bool);
    paramCallback.append("]");
    akg.a("[API]LocationManagerInvoke_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean a(GnssStatus.Callback paramCallback)
  {
    if (!ll.b()) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      akg.a("[API]LocationManagerInvoke_");
      return a.registerGnssStatusCallback(paramCallback);
    }
    return false;
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean a(GnssStatus.Callback paramCallback, Handler paramHandler)
  {
    if (!ll.b()) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      akg.a("[API]LocationManagerInvoke_");
      return a.registerGnssStatusCallback(paramCallback, paramHandler);
    }
    return false;
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean a(GpsStatus.Listener paramListener)
  {
    if (!ll.b()) {
      return false;
    }
    akg.a("[API]LocationManagerInvoke_");
    return a.addGpsStatusListener(paramListener);
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean a(OnNmeaMessageListener paramOnNmeaMessageListener)
  {
    boolean bool2 = ll.b();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 24) {
      bool1 = a.addNmeaListener(paramOnNmeaMessageListener);
    }
    paramOnNmeaMessageListener = new StringBuilder("addNmeaListener:");
    paramOnNmeaMessageListener.append(bool1);
    paramOnNmeaMessageListener.append("]");
    akg.a("[API]LocationManagerInvoke_");
    return bool1;
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean a(OnNmeaMessageListener paramOnNmeaMessageListener, Handler paramHandler)
  {
    if (!ll.b()) {
      return false;
    }
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = a.addNmeaListener(paramOnNmeaMessageListener, paramHandler);
    } else {
      bool = false;
    }
    paramOnNmeaMessageListener = new StringBuilder("addNmeaListener:");
    paramOnNmeaMessageListener.append(bool);
    paramOnNmeaMessageListener.append("]");
    akg.a("[API]LocationManagerInvoke_");
    return false;
  }
  
  public static boolean a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("isProviderEnabled, provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return false;
    }
    akg.a("[API]LocationManagerInvoke_");
    return a.isProviderEnabled(paramString);
  }
  
  public static LocationProvider b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("getProvider, name:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return null;
    }
    akg.a("[API]LocationManagerInvoke_");
    return a.getProvider(paramString);
  }
  
  public static String b(Criteria paramCriteria, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("getBestProvider, enabledOnly:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return null;
    }
    akg.a("[API]LocationManagerInvoke_");
    return a.getBestProvider(paramCriteria, paramBoolean);
  }
  
  public static void b(GnssStatus.Callback paramCallback)
  {
    if (!ll.b()) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      akg.a("[API]LocationManagerInvoke_");
      a.unregisterGnssStatusCallback(paramCallback);
    }
  }
  
  public static void b(GpsStatus.Listener paramListener)
  {
    if (!ll.b()) {
      return;
    }
    akg.a("[API]LocationManagerInvoke_");
    a.removeGpsStatusListener(paramListener);
  }
  
  @SuppressLint({"MissingPermission"})
  public static Location c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("getLastKnownLocation, provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    if (!ll.b()) {
      return null;
    }
    akg.a("[API]LocationManagerInvoke_");
    return a.getLastKnownLocation(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajx
 * JD-Core Version:    0.7.0.1
 */