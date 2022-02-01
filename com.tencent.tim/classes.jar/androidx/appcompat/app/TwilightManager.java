package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

class TwilightManager
{
  private static final int SUNRISE = 6;
  private static final int SUNSET = 22;
  private static final String TAG = "TwilightManager";
  private static TwilightManager sInstance;
  private final Context mContext;
  private final LocationManager mLocationManager;
  private final TwilightState mTwilightState = new TwilightState();
  
  @VisibleForTesting
  TwilightManager(@NonNull Context paramContext, @NonNull LocationManager paramLocationManager)
  {
    this.mContext = paramContext;
    this.mLocationManager = paramLocationManager;
  }
  
  static TwilightManager getInstance(@NonNull Context paramContext)
  {
    if (sInstance == null)
    {
      paramContext = paramContext.getApplicationContext();
      sInstance = new TwilightManager(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    return sInstance;
  }
  
  @SuppressLint({"MissingPermission"})
  private Location getLastKnownLocation()
  {
    Object localObject1 = null;
    if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
    for (Location localLocation = getLastKnownLocationForProvider("network");; localLocation = null)
    {
      if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localObject1 = getLastKnownLocationForProvider("gps");
      }
      if ((localObject1 != null) && (localLocation != null))
      {
        Object localObject2 = localLocation;
        if (((Location)localObject1).getTime() > localLocation.getTime()) {
          localObject2 = localObject1;
        }
        return localObject2;
      }
      if (localObject1 != null) {}
      for (;;)
      {
        return localObject1;
        localObject1 = localLocation;
      }
    }
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  private Location getLastKnownLocationForProvider(String paramString)
  {
    try
    {
      if (this.mLocationManager.isProviderEnabled(paramString))
      {
        paramString = this.mLocationManager.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.d("TwilightManager", "Failed to get last known location", paramString);
    }
    return null;
  }
  
  private boolean isStateValid()
  {
    return this.mTwilightState.nextUpdate > System.currentTimeMillis();
  }
  
  @VisibleForTesting
  static void setInstance(TwilightManager paramTwilightManager)
  {
    sInstance = paramTwilightManager;
  }
  
  private void updateState(@NonNull Location paramLocation)
  {
    TwilightState localTwilightState = this.mTwilightState;
    long l1 = System.currentTimeMillis();
    TwilightCalculator localTwilightCalculator = TwilightCalculator.getInstance();
    localTwilightCalculator.calculateTwilight(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localTwilightCalculator.sunset;
    localTwilightCalculator.calculateTwilight(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localTwilightCalculator.state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localTwilightCalculator.sunrise;
      l4 = localTwilightCalculator.sunset;
      localTwilightCalculator.calculateTwilight(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localTwilightCalculator.sunrise;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      localTwilightState.isNight = bool;
      localTwilightState.yesterdaySunset = l2;
      localTwilightState.todaySunrise = l3;
      localTwilightState.todaySunset = l4;
      localTwilightState.tomorrowSunrise = l5;
      localTwilightState.nextUpdate = l1;
      return;
    }
    if (l1 > l4) {
      l1 = 0L + l5;
    }
    for (;;)
    {
      l1 += 60000L;
      break;
      if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      }
    }
  }
  
  boolean isNight()
  {
    TwilightState localTwilightState = this.mTwilightState;
    if (isStateValid()) {
      return localTwilightState.isNight;
    }
    Location localLocation = getLastKnownLocation();
    if (localLocation != null)
    {
      updateState(localLocation);
      return localTwilightState.isNight;
    }
    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  static class TwilightState
  {
    boolean isNight;
    long nextUpdate;
    long todaySunrise;
    long todaySunset;
    long tomorrowSunrise;
    long yesterdaySunset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.TwilightManager
 * JD-Core Version:    0.7.0.1
 */