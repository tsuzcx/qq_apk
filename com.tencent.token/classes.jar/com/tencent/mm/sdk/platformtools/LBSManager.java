package com.tencent.mm.sdk.platformtools;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import java.util.LinkedList;
import java.util.List;

public class LBSManager
  extends BroadcastReceiver
{
  private static LocationCache F;
  public static final String FILTER_GPS = "filter_gps";
  public static final int INVALID_ACC = -1000;
  public static final float INVALID_LAT = -1000.0F;
  public static final float INVALID_LNG = -1000.0F;
  public static final int MM_SOURCE_HARDWARE = 0;
  public static final int MM_SOURCE_NET = 1;
  public static final int MM_SOURCE_REPORT_HARWARE = 3;
  public static final int MM_SOURCE_REPORT_NETWORK = 4;
  private OnLocationGotListener G;
  private LocationManager H;
  private PendingIntent I;
  private boolean J = false;
  boolean K;
  boolean L = false;
  boolean M = false;
  int N;
  private MTimerHandler O = new MTimerHandler(new LBSManager.1(this), false);
  private Context q;
  
  public LBSManager(Context paramContext, OnLocationGotListener paramOnLocationGotListener)
  {
    this.G = paramOnLocationGotListener;
    this.K = false;
    this.N = 0;
    this.q = paramContext;
    PhoneUtil.getSignalStrength(paramContext);
    this.H = ((LocationManager)paramContext.getSystemService("location"));
    a();
    this.I = PendingIntent.getBroadcast(paramContext, 0, new Intent("filter_gps"), 134217728);
  }
  
  private boolean a()
  {
    LocationManager localLocationManager = this.H;
    if (localLocationManager != null) {}
    try
    {
      localLocationManager.sendExtraCommand("gps", "force_xtra_injection", null);
      this.H.sendExtraCommand("gps", "force_time_injection", null);
      return true;
    }
    catch (Exception localException) {}
    return false;
    return false;
  }
  
  private void b()
  {
    this.O.stopTimer();
    this.K = true;
  }
  
  public static void setLocationCache(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return;
    }
    Object localObject = new StringBuilder("setLocationCache [");
    ((StringBuilder)localObject).append(paramFloat1);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramFloat2);
    ((StringBuilder)localObject).append("] acc:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" source:");
    ((StringBuilder)localObject).append(paramInt2);
    Log.v("MicroMsg.LBSManager", ((StringBuilder)localObject).toString());
    if (F == null) {
      F = new LocationCache();
    }
    localObject = F;
    ((LocationCache)localObject).Q = paramFloat1;
    ((LocationCache)localObject).R = paramFloat2;
    ((LocationCache)localObject).S = paramInt1;
    ((LocationCache)localObject).time = System.currentTimeMillis();
    F.T = paramInt2;
  }
  
  public String getTelLocation()
  {
    return PhoneUtil.getCellXml(PhoneUtil.getCellInfoList(this.q));
  }
  
  public String getWIFILocation()
  {
    Object localObject2 = (WifiManager)this.q.getSystemService("wifi");
    if (localObject2 == null) {}
    for (Object localObject1 = "no wifi service";; localObject1 = "WIFILocation wifi info null")
    {
      Log.e("MicroMsg.LBSManager", (String)localObject1);
      return "";
      if (((WifiManager)localObject2).getConnectionInfo() != null) {
        break;
      }
    }
    localObject1 = new LinkedList();
    localObject2 = ((WifiManager)localObject2).getScanResults();
    if (localObject2 != null)
    {
      int i = 0;
      while (i < ((List)localObject2).size())
      {
        String str = ((ScanResult)((List)localObject2).get(i)).BSSID;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ScanResult)((List)localObject2).get(i)).level);
        ((List)localObject1).add(new PhoneUtil.MacInfo(str, localStringBuilder.toString()));
        i += 1;
      }
    }
    return PhoneUtil.getMacXml((List)localObject1);
  }
  
  public boolean isGpsEnable()
  {
    try
    {
      boolean bool = this.H.isProviderEnabled("gps");
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean isNetworkPrividerEnable()
  {
    try
    {
      boolean bool = this.H.isProviderEnabled("network");
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (Location)paramIntent.getExtras().get("location");
    this.N += 1;
    if (paramContext != null)
    {
      boolean bool = "gps".equals(paramContext.getProvider());
      if (((bool) && (paramContext.getAccuracy() <= 200.0F)) || ((!bool) && (paramContext.getAccuracy() <= 1000.0F) && (paramContext.getAccuracy() > 0.0F)))
      {
        int i = bool ^ true;
        setLocationCache((float)paramContext.getLatitude(), (float)paramContext.getLongitude(), (int)paramContext.getAccuracy(), i);
        if ((this.G != null) && ((!this.K) || (!this.L) || (!this.M)))
        {
          paramIntent = Util.nullAsNil(getWIFILocation());
          String str = Util.nullAsNil(getTelLocation());
          StringBuilder localStringBuilder;
          if (!this.K)
          {
            b();
            this.K = true;
            localStringBuilder = new StringBuilder("location by provider ok:[");
            localStringBuilder.append(paramContext.getLatitude());
            localStringBuilder.append(" , ");
            localStringBuilder.append(paramContext.getLongitude());
            localStringBuilder.append("]  accuracy:");
            localStringBuilder.append(paramContext.getAccuracy());
            localStringBuilder.append("  retry count:");
            localStringBuilder.append(this.N);
            localStringBuilder.append(" isGpsProvider:");
            localStringBuilder.append(bool);
            Log.v("MicroMsg.LBSManager", localStringBuilder.toString());
            this.G.onLocationGot((float)paramContext.getLatitude(), (float)paramContext.getLongitude(), (int)paramContext.getAccuracy(), i, paramIntent, str, true);
            return;
          }
          if ((!this.L) && (i == 0))
          {
            this.L = true;
            localStringBuilder = new StringBuilder("report location by GPS ok:[");
            localStringBuilder.append(paramContext.getLatitude());
            localStringBuilder.append(" , ");
            localStringBuilder.append(paramContext.getLongitude());
            localStringBuilder.append("]  accuracy:");
            localStringBuilder.append(paramContext.getAccuracy());
            localStringBuilder.append("  retry count:");
            localStringBuilder.append(this.N);
            localStringBuilder.append(" isGpsProvider:");
            localStringBuilder.append(bool);
            Log.v("MicroMsg.LBSManager", localStringBuilder.toString());
            this.G.onLocationGot((float)paramContext.getLatitude(), (float)paramContext.getLongitude(), (int)paramContext.getAccuracy(), 3, paramIntent, str, true);
            return;
          }
          if ((!this.M) && (i == 1))
          {
            this.M = true;
            localStringBuilder = new StringBuilder("report location by Network ok:[");
            localStringBuilder.append(paramContext.getLatitude());
            localStringBuilder.append(" , ");
            localStringBuilder.append(paramContext.getLongitude());
            localStringBuilder.append("]  accuracy:");
            localStringBuilder.append(paramContext.getAccuracy());
            localStringBuilder.append("  retry count:");
            localStringBuilder.append(this.N);
            localStringBuilder.append(" isGpsProvider:");
            localStringBuilder.append(bool);
            Log.v("MicroMsg.LBSManager", localStringBuilder.toString());
            this.G.onLocationGot((float)paramContext.getLatitude(), (float)paramContext.getLongitude(), (int)paramContext.getAccuracy(), 4, paramIntent, str, true);
          }
        }
      }
    }
  }
  
  public void removeGpsUpdate()
  {
    Log.v("MicroMsg.LBSManager", "removed gps update");
    LocationManager localLocationManager = this.H;
    if (localLocationManager != null) {
      localLocationManager.removeUpdates(this.I);
    }
    try
    {
      this.q.unregisterReceiver(this);
      return;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    Log.v("MicroMsg.LBSManager", "location receiver has already unregistered");
  }
  
  public void removeListener()
  {
    Log.v("MicroMsg.LBSManager", "removed gps update on destroy");
    removeGpsUpdate();
    if (this.O != null) {
      b();
    }
    this.G = null;
    this.q = null;
    this.O = null;
    this.H = null;
  }
  
  public void requestGpsUpdate()
  {
    requestGpsUpdate(500);
  }
  
  public void requestGpsUpdate(int paramInt)
  {
    if ((!isGpsEnable()) && (!isNetworkPrividerEnable())) {
      return;
    }
    if (paramInt <= 0) {
      paramInt = 500;
    }
    Log.v("MicroMsg.LBSManager", "requested gps update");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("filter_gps");
    this.q.registerReceiver(this, localIntentFilter);
    if (isGpsEnable()) {
      this.H.requestLocationUpdates("gps", paramInt, 0.0F, this.I);
    }
    if (isNetworkPrividerEnable()) {
      this.H.requestLocationUpdates("network", paramInt, 0.0F, this.I);
    }
  }
  
  public void resetForContinueGetLocation()
  {
    this.L = false;
    this.M = false;
  }
  
  public void start()
  {
    Object localObject1 = Util.nullAsNil(getWIFILocation());
    String str = Util.nullAsNil(getTelLocation());
    boolean bool = isGpsEnable();
    int j = 0;
    int i;
    if ((!bool) && (!isNetworkPrividerEnable())) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i != 0) && (!this.J))
    {
      this.J = true;
      this.N = 0;
      requestGpsUpdate();
      this.O.startTimer(3000L);
      return;
    }
    if (F == null)
    {
      i = j;
    }
    else
    {
      i = j;
      if (System.currentTimeMillis() - F.time <= 180000L) {
        if (F.S <= 0) {
          i = j;
        } else {
          i = 1;
        }
      }
    }
    Object localObject2;
    if (i != 0)
    {
      if (this.G != null)
      {
        this.K = true;
        localObject2 = new StringBuilder("location by GPS cache ok:[");
        ((StringBuilder)localObject2).append(F.Q);
        ((StringBuilder)localObject2).append(" , ");
        ((StringBuilder)localObject2).append(F.R);
        ((StringBuilder)localObject2).append("]  accuracy:");
        ((StringBuilder)localObject2).append(F.S);
        ((StringBuilder)localObject2).append(" source:");
        ((StringBuilder)localObject2).append(F.T);
        Log.v("MicroMsg.LBSManager", ((StringBuilder)localObject2).toString());
        this.G.onLocationGot(F.Q, F.R, F.S, F.T, (String)localObject1, str, true);
      }
    }
    else
    {
      this.K = true;
      if ((((String)localObject1).equals("")) && (str.equals("")))
      {
        Log.v("MicroMsg.LBSManager", "get location by network failed");
        localObject1 = this.G;
        if (localObject1 != null) {
          ((OnLocationGotListener)localObject1).onLocationGot(-1000.0F, -1000.0F, -1000, 0, "", "", false);
        }
      }
      else
      {
        localObject2 = new StringBuilder("get location by network ok, macs : ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" cell ids :");
        ((StringBuilder)localObject2).append(str);
        Log.v("MicroMsg.LBSManager", ((StringBuilder)localObject2).toString());
        localObject2 = this.G;
        if (localObject2 != null) {
          ((OnLocationGotListener)localObject2).onLocationGot(-1000.0F, -1000.0F, -1000, 0, (String)localObject1, str, true);
        }
      }
    }
  }
  
  static class LocationCache
  {
    float Q = -1000.0F;
    float R = -1000.0F;
    int S = -1000;
    int T = 1;
    long time;
  }
  
  public static abstract interface OnLocationGotListener
  {
    public abstract void onLocationGot(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LBSManager
 * JD-Core Version:    0.7.0.1
 */