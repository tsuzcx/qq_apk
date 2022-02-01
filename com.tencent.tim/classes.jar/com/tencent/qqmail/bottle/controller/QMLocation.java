package com.tencent.qqmail.bottle.controller;

import alky;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.RxUtil;
import rx.Observable;

public class QMLocation
{
  private static final int GPS_WAIT_TIME = 120000;
  private static final long MIN_UPDATE_GPS_TIME = 86400000L;
  private static final long MIN_UPDATE_NET_TIME = 3600000L;
  private static final int NET_WATI_TIME = 60000;
  public static final int PROVIDER_GPS = 1;
  public static final int PROVIDER_NET = 2;
  public static final int PROVIDER_NONE = 0;
  private static final String SHARED_PREF_LAST_UPDATE_TIME_KEY = "location_last_update_time";
  private static final String SHARED_PREF_LOCATION = "user_info";
  private static final String TAG = "QMLocation";
  private Location_LocationListener gpsListener = null;
  private final Context mContext;
  private Location mLocation = null;
  private LocationListener mLocationListener;
  private Location_LocationListener netListener = null;
  
  public QMLocation(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @Nullable
  private Location getLastKnownLocation()
  {
    Object localObject;
    if (this.mLocation != null) {
      localObject = this.mLocation;
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (LocationManager)this.mContext.getSystemService("location");
        Location localLocation = alky.a((LocationManager)localObject, "gps");
        if (localLocation != null) {
          return localLocation;
        }
        localLocation = alky.a((LocationManager)localObject, "network");
        localObject = localLocation;
        if (localLocation != null) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.log(6, "QMLocation", "getLastKnownLocation failed: " + localException.toString());
        }
      }
    }
    return null;
  }
  
  public static void gotoEnableLocationPage(Context paramContext)
  {
    int i = new QMLocation(paramContext).getProvider();
    if ((i & 0x1) != 1) {
      paramContext.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
    while ((i & 0x2) == 2) {
      return;
    }
    paramContext.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
  }
  
  private void invokeLocationChanged(Location paramLocation)
  {
    if (this.mLocationListener != null) {
      this.mLocationListener.onLocationChanged(paramLocation);
    }
  }
  
  private void invokeLocationError()
  {
    if (this.mLocationListener != null) {
      this.mLocationListener.onError();
    }
  }
  
  private boolean requestGPSLocationUpdates(LocationManager paramLocationManager)
  {
    if (!paramLocationManager.isProviderEnabled("gps")) {
      return false;
    }
    if (this.gpsListener != null) {
      return true;
    }
    this.gpsListener = new Location_LocationListener(1, 120000);
    try
    {
      alky.a(paramLocationManager, "gps", 10000L, 100.0F, this.gpsListener);
      return true;
    }
    catch (Exception paramLocationManager)
    {
      QMLog.log(6, "QMLocation", "requestGPSLocationUpdates", paramLocationManager);
    }
    return false;
  }
  
  private void requestLocationUpdates(Location paramLocation)
  {
    int j = 0;
    LocationManager localLocationManager = (LocationManager)this.mContext.getSystemService("location");
    int i;
    if (paramLocation == null) {
      if (!requestNETLocationUpdates(localLocationManager))
      {
        i = 0;
        if ((requestGPSLocationUpdates(localLocationManager)) || (i != 0)) {
          j = 1;
        }
        if (j == 0) {
          invokeLocationError();
        }
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      i = 1;
      break;
      invokeLocationChanged(paramLocation);
      l1 = System.currentTimeMillis();
      l2 = this.mContext.getSharedPreferences("user_info", 0).getLong("location_last_update_time", 0L);
    } while (((l1 - l2 > 3600000L) && (requestNETLocationUpdates(localLocationManager))) || (l1 - l2 <= 86400000L) || (!requestGPSLocationUpdates(localLocationManager)));
  }
  
  private boolean requestNETLocationUpdates(LocationManager paramLocationManager)
  {
    if (!paramLocationManager.isProviderEnabled("network")) {
      return false;
    }
    if (this.netListener != null) {
      return true;
    }
    this.netListener = new Location_LocationListener(2, 60000);
    try
    {
      alky.a(paramLocationManager, "network", 0L, 0.0F, this.netListener);
      return true;
    }
    catch (Exception paramLocationManager)
    {
      QMLog.log(6, "QMLocation", "requestNETLocationUpdates", paramLocationManager);
    }
    return false;
  }
  
  public Observable<Location> getLastKnownLocationObservable()
  {
    return RxUtil.runInBackgroundThenBackToCallerThread(new QMLocation.1(this));
  }
  
  public int getProvider()
  {
    LocationManager localLocationManager = (LocationManager)this.mContext.getSystemService("location");
    int j = 0;
    int i = 0;
    try
    {
      if (localLocationManager.isProviderEnabled("gps")) {
        i = 1;
      }
      j = i;
      boolean bool = localLocationManager.isProviderEnabled("network");
      if (bool) {
        return i | 0x2;
      }
    }
    catch (SecurityException localSecurityException)
    {
      return j;
    }
    return i;
  }
  
  public void removeLocationUpdates()
  {
    if (this.netListener != null) {
      this.netListener.abort();
    }
    if (this.gpsListener != null) {
      this.gpsListener.abort();
    }
  }
  
  public void requestLocationUpdates()
  {
    if (getProvider() == 0)
    {
      invokeLocationError();
      return;
    }
    getLastKnownLocationObservable().subscribe(new QMLocation.2(this));
  }
  
  public void setLocationListener(LocationListener paramLocationListener)
  {
    this.mLocationListener = paramLocationListener;
  }
  
  public static abstract interface LocationListener
  {
    public abstract void onError();
    
    public abstract void onLocationChanged(Location paramLocation);
  }
  
  class Location_LocationListener
    implements LocationListener, Runnable
  {
    private boolean mComplete;
    private final int mProvider;
    
    public Location_LocationListener(int paramInt1, int paramInt2)
    {
      this.mProvider = paramInt1;
      this.mComplete = false;
      new Handler().postDelayed(this, paramInt2);
    }
    
    private void removeUpdate()
    {
      ((LocationManager)QMLocation.this.mContext.getSystemService("location")).removeUpdates(this);
      this.mComplete = true;
      switch (this.mProvider)
      {
      default: 
        throw new DevRuntimeException("provider:" + this.mProvider);
      case 1: 
        QMLocation.access$502(QMLocation.this, null);
        return;
      }
      QMLocation.access$602(QMLocation.this, null);
    }
    
    public void abort()
    {
      if (this.mComplete) {
        return;
      }
      removeUpdate();
      new Handler().removeCallbacks(this);
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      QMLog.log(3, "QMLocation", "Location succ:" + this.mProvider + ", " + this.mComplete);
      BottleManager.log("Location get: " + paramLocation);
      if (this.mComplete) {
        return;
      }
      QMLocation.access$102(QMLocation.this, paramLocation);
      removeUpdate();
      QMLocation.this.mContext.getSharedPreferences("user_info", 0).edit().putLong("location_last_update_time", System.currentTimeMillis()).commit();
      QMLocation.this.invokeLocationChanged(paramLocation);
    }
    
    public void onProviderDisabled(String paramString) {}
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
    
    public void run()
    {
      QMLog.log(3, "QMLocation", "Location timeout:" + this.mProvider + ", " + this.mComplete);
      if (this.mComplete) {
        return;
      }
      removeUpdate();
      QMLocation.this.invokeLocationError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.QMLocation
 * JD-Core Version:    0.7.0.1
 */