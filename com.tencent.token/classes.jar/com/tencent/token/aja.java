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
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.List;

public class aja
  extends ko
{
  private LocationManager a;
  
  public aja(LocationManager paramLocationManager)
  {
    super(paramLocationManager);
    this.a = paramLocationManager;
  }
  
  @SuppressLint({"MissingPermission"})
  public boolean addGpsStatusListener(GpsStatus.Listener paramListener)
  {
    boolean bool = this.a.addGpsStatusListener(paramListener);
    paramListener = new StringBuilder("addGpsStatusListener:");
    paramListener.append(bool);
    paramListener.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public boolean addNmeaListener(OnNmeaMessageListener paramOnNmeaMessageListener)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.a.addNmeaListener(paramOnNmeaMessageListener);
    } else {
      bool = false;
    }
    paramOnNmeaMessageListener = new StringBuilder("addNmeaListener:");
    paramOnNmeaMessageListener.append(bool);
    paramOnNmeaMessageListener.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public boolean addNmeaListener(OnNmeaMessageListener paramOnNmeaMessageListener, Handler paramHandler)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.a.addNmeaListener(paramOnNmeaMessageListener, paramHandler);
    } else {
      bool = false;
    }
    paramOnNmeaMessageListener = new StringBuilder("addNmeaListener:");
    paramOnNmeaMessageListener.append(bool);
    paramOnNmeaMessageListener.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public void addProximityAlert(double paramDouble1, double paramDouble2, float paramFloat, long paramLong, PendingIntent paramPendingIntent)
  {
    aji.a("[API]LocationManager_");
    this.a.addProximityAlert(paramDouble1, paramDouble2, paramFloat, paramLong, paramPendingIntent);
  }
  
  public void addTestProvider(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt1, int paramInt2)
  {
    aji.a("[API]LocationManager_");
    this.a.addTestProvider(paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, paramInt1, paramInt2);
  }
  
  public void clearTestProviderEnabled(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("clearTestProviderEnabled:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    aji.a("[API]LocationManager_");
    this.a.clearTestProviderEnabled(paramString);
  }
  
  public void clearTestProviderLocation(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("clearTestProviderLocation:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    aji.a("[API]LocationManager_");
    this.a.clearTestProviderLocation(paramString);
  }
  
  public void clearTestProviderStatus(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("clearTestProviderStatus:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    aji.a("[API]LocationManager_");
    this.a.clearTestProviderStatus(paramString);
  }
  
  public List<String> getAllProviders()
  {
    aji.a("[API]LocationManager_");
    return this.a.getAllProviders();
  }
  
  public String getBestProvider(Criteria paramCriteria, boolean paramBoolean)
  {
    paramCriteria = this.a.getBestProvider(paramCriteria, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder("getBestProvider, enabledOnly:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]ret:[");
    localStringBuilder.append(paramCriteria);
    localStringBuilder.append("]");
    aji.a("[API]LocationManager_");
    return paramCriteria;
  }
  
  @SuppressLint({"MissingPermission"})
  public GpsStatus getGpsStatus(GpsStatus paramGpsStatus)
  {
    aji.a("[API]LocationManager_");
    return this.a.getGpsStatus(paramGpsStatus);
  }
  
  @SuppressLint({"MissingPermission"})
  public Location getLastKnownLocation(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("getLastKnownLocation, provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    aji.a("[API]LocationManager_");
    return this.a.getLastKnownLocation(paramString);
  }
  
  public LocationProvider getProvider(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("getProvider, provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    aji.a("[API]LocationManager_");
    return this.a.getProvider(paramString);
  }
  
  public List<String> getProviders(Criteria paramCriteria, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("getProviders, enabledOnly:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    aji.a("[API]LocationManager_");
    return this.a.getProviders(paramCriteria, paramBoolean);
  }
  
  public List<String> getProviders(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("getProviders, enabledOnly:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    aji.a("[API]LocationManager_");
    return this.a.getProviders(paramBoolean);
  }
  
  public boolean isProviderEnabled(String paramString)
  {
    boolean bool = this.a.isProviderEnabled(paramString);
    StringBuilder localStringBuilder = new StringBuilder("isProviderEnabled, provider:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]ret:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public boolean registerGnssMeasurementsCallback(GnssMeasurementsEvent.Callback paramCallback)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.a.registerGnssMeasurementsCallback(paramCallback);
    } else {
      bool = false;
    }
    paramCallback = new StringBuilder("registerGnssMeasurementsCallback, ret:[");
    paramCallback.append(bool);
    paramCallback.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public boolean registerGnssMeasurementsCallback(GnssMeasurementsEvent.Callback paramCallback, Handler paramHandler)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.a.registerGnssMeasurementsCallback(paramCallback, paramHandler);
    } else {
      bool = false;
    }
    paramCallback = new StringBuilder("registerGnssMeasurementsCallback, ret:[");
    paramCallback.append(bool);
    paramCallback.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  public boolean registerGnssNavigationMessageCallback(GnssNavigationMessage.Callback paramCallback)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.a.registerGnssNavigationMessageCallback(paramCallback);
    } else {
      bool = false;
    }
    paramCallback = new StringBuilder("registerGnssNavigationMessageCallback, ret:[");
    paramCallback.append(bool);
    paramCallback.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public boolean registerGnssNavigationMessageCallback(GnssNavigationMessage.Callback paramCallback, Handler paramHandler)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.a.registerGnssNavigationMessageCallback(paramCallback, paramHandler);
    } else {
      bool = false;
    }
    paramCallback = new StringBuilder("registerGnssNavigationMessageCallback, ret:[");
    paramCallback.append(bool);
    paramCallback.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public boolean registerGnssStatusCallback(GnssStatus.Callback paramCallback)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.a.registerGnssStatusCallback(paramCallback);
    } else {
      bool = false;
    }
    paramCallback = new StringBuilder("registerGnssStatusCallback, ret:[");
    paramCallback.append(bool);
    paramCallback.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  @SuppressLint({"MissingPermission"})
  public boolean registerGnssStatusCallback(GnssStatus.Callback paramCallback, Handler paramHandler)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.a.registerGnssStatusCallback(paramCallback, paramHandler);
    } else {
      bool = false;
    }
    paramCallback = new StringBuilder("registerGnssStatusCallback, ret:[");
    paramCallback.append(bool);
    paramCallback.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  public void removeGpsStatusListener(GpsStatus.Listener paramListener)
  {
    aji.a("[API]LocationManager_");
    this.a.removeGpsStatusListener(paramListener);
  }
  
  public void removeNmeaListener(OnNmeaMessageListener paramOnNmeaMessageListener)
  {
    aji.a("[API]LocationManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.removeNmeaListener(paramOnNmeaMessageListener);
    }
  }
  
  public void removeProximityAlert(PendingIntent paramPendingIntent)
  {
    aji.a("[API]LocationManager_");
    this.a.removeProximityAlert(paramPendingIntent);
  }
  
  public void removeTestProvider(String paramString)
  {
    aji.a("[API]LocationManager_");
    this.a.removeTestProvider(paramString);
  }
  
  public void removeUpdates(PendingIntent paramPendingIntent)
  {
    aji.a("[API]LocationManager_");
    this.a.removeUpdates(paramPendingIntent);
  }
  
  public void removeUpdates(LocationListener paramLocationListener)
  {
    aji.a("[API]LocationManager_");
    this.a.removeUpdates(paramLocationListener);
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestLocationUpdates(long paramLong, float paramFloat, Criteria paramCriteria, PendingIntent paramPendingIntent)
  {
    aji.a("[API]LocationManager_");
    this.a.requestLocationUpdates(paramLong, paramFloat, paramCriteria, paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestLocationUpdates(long paramLong, float paramFloat, Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
  {
    aji.a("[API]LocationManager_");
    this.a.requestLocationUpdates(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestLocationUpdates(String paramString, long paramLong, float paramFloat, PendingIntent paramPendingIntent)
  {
    aji.a("[API]LocationManager_");
    this.a.requestLocationUpdates(paramString, paramLong, paramFloat, paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestLocationUpdates(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener)
  {
    aji.a("[API]LocationManager_");
    this.a.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener);
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestLocationUpdates(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener, Looper paramLooper)
  {
    aji.a("[API]LocationManager_");
    this.a.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestSingleUpdate(Criteria paramCriteria, PendingIntent paramPendingIntent)
  {
    aji.a("[API]LocationManager_");
    this.a.requestSingleUpdate(paramCriteria, paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestSingleUpdate(Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
  {
    aji.a("[API]LocationManager_");
    this.a.requestSingleUpdate(paramCriteria, paramLocationListener, paramLooper);
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestSingleUpdate(String paramString, PendingIntent paramPendingIntent)
  {
    aji.a("[API]LocationManager_");
    this.a.requestSingleUpdate(paramString, paramPendingIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestSingleUpdate(String paramString, LocationListener paramLocationListener, Looper paramLooper)
  {
    aji.a("[API]LocationManager_");
    this.a.requestSingleUpdate(paramString, paramLocationListener, paramLooper);
  }
  
  public boolean sendExtraCommand(String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool = this.a.sendExtraCommand(paramString1, paramString2, paramBundle);
    paramString1 = new StringBuilder("sendExtraCommand, ret:[");
    paramString1.append(bool);
    paramString1.append("]");
    aji.a("[API]LocationManager_");
    return bool;
  }
  
  public void setTestProviderEnabled(String paramString, boolean paramBoolean)
  {
    aji.a("[API]LocationManager_");
    this.a.setTestProviderEnabled(paramString, paramBoolean);
  }
  
  public void setTestProviderLocation(String paramString, Location paramLocation)
  {
    aji.a("[API]LocationManager_");
    this.a.setTestProviderLocation(paramString, paramLocation);
  }
  
  public void setTestProviderStatus(String paramString, int paramInt, Bundle paramBundle, long paramLong)
  {
    aji.a("[API]LocationManager_");
    this.a.setTestProviderStatus(paramString, paramInt, paramBundle, paramLong);
  }
  
  public void unregisterGnssMeasurementsCallback(GnssMeasurementsEvent.Callback paramCallback)
  {
    aji.a("[API]LocationManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.unregisterGnssMeasurementsCallback(paramCallback);
    }
  }
  
  public void unregisterGnssNavigationMessageCallback(GnssNavigationMessage.Callback paramCallback)
  {
    aji.a("[API]LocationManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.unregisterGnssNavigationMessageCallback(paramCallback);
    }
  }
  
  public void unregisterGnssStatusCallback(GnssStatus.Callback paramCallback)
  {
    aji.a("[API]LocationManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.unregisterGnssStatusCallback(paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aja
 * JD-Core Version:    0.7.0.1
 */