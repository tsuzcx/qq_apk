package com.tencent.token;

import android.app.PendingIntent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Looper;
import java.util.List;

public class lc
  extends LocationManager
{
  private LocationManager a;
  
  public lc(LocationManager paramLocationManager)
  {
    this.a = paramLocationManager;
  }
  
  public List<String> getAllProviders()
  {
    return this.a.getAllProviders();
  }
  
  public String getBestProvider(Criteria paramCriteria, boolean paramBoolean)
  {
    return this.a.getBestProvider(paramCriteria, paramBoolean);
  }
  
  public Location getLastKnownLocation(String paramString)
  {
    return this.a.getLastKnownLocation(paramString);
  }
  
  public LocationProvider getProvider(String paramString)
  {
    return this.a.getProvider(paramString);
  }
  
  public List<String> getProviders(Criteria paramCriteria, boolean paramBoolean)
  {
    return this.a.getProviders(paramCriteria, paramBoolean);
  }
  
  public List<String> getProviders(boolean paramBoolean)
  {
    return this.a.getProviders(paramBoolean);
  }
  
  public boolean isProviderEnabled(String paramString)
  {
    return this.a.isProviderEnabled(paramString);
  }
  
  public void removeUpdates(PendingIntent paramPendingIntent)
  {
    this.a.removeUpdates(paramPendingIntent);
  }
  
  public void removeUpdates(LocationListener paramLocationListener)
  {
    this.a.removeUpdates(paramLocationListener);
  }
  
  public void requestLocationUpdates(long paramLong, float paramFloat, Criteria paramCriteria, PendingIntent paramPendingIntent)
  {
    this.a.requestLocationUpdates(paramLong, paramFloat, paramCriteria, paramPendingIntent);
  }
  
  public void requestLocationUpdates(long paramLong, float paramFloat, Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
  {
    this.a.requestLocationUpdates(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
  }
  
  public void requestLocationUpdates(String paramString, long paramLong, float paramFloat, PendingIntent paramPendingIntent)
  {
    this.a.requestLocationUpdates(paramString, paramLong, paramFloat, paramPendingIntent);
  }
  
  public void requestLocationUpdates(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener)
  {
    this.a.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener);
  }
  
  public void requestLocationUpdates(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener, Looper paramLooper)
  {
    this.a.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
  }
  
  public void requestSingleUpdate(Criteria paramCriteria, PendingIntent paramPendingIntent)
  {
    this.a.requestSingleUpdate(paramCriteria, paramPendingIntent);
  }
  
  public void requestSingleUpdate(Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
  {
    this.a.requestSingleUpdate(paramCriteria, paramLocationListener, paramLooper);
  }
  
  public void requestSingleUpdate(String paramString, PendingIntent paramPendingIntent)
  {
    this.a.requestSingleUpdate(paramString, paramPendingIntent);
  }
  
  public void requestSingleUpdate(String paramString, LocationListener paramLocationListener, Looper paramLooper)
  {
    this.a.requestSingleUpdate(paramString, paramLocationListener, paramLooper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lc
 * JD-Core Version:    0.7.0.1
 */