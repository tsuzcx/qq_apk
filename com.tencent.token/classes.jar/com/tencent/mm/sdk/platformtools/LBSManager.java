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
  private static LBSManager.LocationCache F;
  public static final String FILTER_GPS = "filter_gps";
  public static final int INVALID_ACC = -1000;
  public static final float INVALID_LAT = -1000.0F;
  public static final float INVALID_LNG = -1000.0F;
  public static final int MM_SOURCE_HARDWARE = 0;
  public static final int MM_SOURCE_NET = 1;
  public static final int MM_SOURCE_REPORT_HARWARE = 3;
  public static final int MM_SOURCE_REPORT_NETWORK = 4;
  private LBSManager.OnLocationGotListener G;
  private LocationManager H;
  private PendingIntent I;
  private boolean J = false;
  boolean K;
  boolean L = false;
  boolean M = false;
  int N;
  private MTimerHandler O = new MTimerHandler(new LBSManager.1(this), false);
  private Context q;
  
  public LBSManager(Context paramContext, LBSManager.OnLocationGotListener paramOnLocationGotListener)
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
    boolean bool = false;
    if (this.H != null) {}
    try
    {
      this.H.sendExtraCommand("gps", "force_xtra_injection", null);
      this.H.sendExtraCommand("gps", "force_time_injection", null);
      bool = true;
      return bool;
    }
    catch (Exception localException) {}
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
    Log.v("MicroMsg.LBSManager", "setLocationCache [" + paramFloat1 + "," + paramFloat2 + "] acc:" + paramInt1 + " source:" + paramInt2);
    if (F == null) {
      F = new LBSManager.LocationCache();
    }
    F.Q = paramFloat1;
    F.R = paramFloat2;
    F.S = paramInt1;
    F.time = System.currentTimeMillis();
    F.T = paramInt2;
  }
  
  public String getTelLocation()
  {
    return PhoneUtil.getCellXml(PhoneUtil.getCellInfoList(this.q));
  }
  
  public String getWIFILocation()
  {
    Object localObject = (WifiManager)this.q.getSystemService("wifi");
    if (localObject == null)
    {
      Log.e("MicroMsg.LBSManager", "no wifi service");
      return "";
    }
    if (((WifiManager)localObject).getConnectionInfo() == null)
    {
      Log.e("MicroMsg.LBSManager", "WIFILocation wifi info null");
      return "";
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((WifiManager)localObject).getScanResults();
    if (localObject != null)
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        localLinkedList.add(new PhoneUtil.MacInfo(((ScanResult)((List)localObject).get(i)).BSSID, ((ScanResult)((List)localObject).get(i)).level));
        i += 1;
      }
    }
    return PhoneUtil.getMacXml(localLinkedList);
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
    boolean bool;
    int i;
    String str;
    if (paramContext != null)
    {
      bool = "gps".equals(paramContext.getProvider());
      if (((bool) && (paramContext.getAccuracy() <= 200.0F)) || ((!bool) && (paramContext.getAccuracy() <= 1000.0F) && (paramContext.getAccuracy() > 0.0F)))
      {
        if (!bool) {
          break label271;
        }
        i = 0;
        setLocationCache((float)paramContext.getLatitude(), (float)paramContext.getLongitude(), (int)paramContext.getAccuracy(), i);
        if ((this.G != null) && ((!this.K) || (!this.L) || (!this.M)))
        {
          paramIntent = Util.nullAsNil(getWIFILocation());
          str = Util.nullAsNil(getTelLocation());
          if (this.K) {
            break label276;
          }
          b();
          this.K = true;
          Log.v("MicroMsg.LBSManager", "location by provider ok:[" + paramContext.getLatitude() + " , " + paramContext.getLongitude() + "]  accuracy:" + paramContext.getAccuracy() + "  retry count:" + this.N + " isGpsProvider:" + bool);
          this.G.onLocationGot((float)paramContext.getLatitude(), (float)paramContext.getLongitude(), (int)paramContext.getAccuracy(), i, paramIntent, str, true);
        }
      }
    }
    label271:
    label276:
    do
    {
      return;
      i = 1;
      break;
      if ((!this.L) && (i == 0))
      {
        this.L = true;
        Log.v("MicroMsg.LBSManager", "report location by GPS ok:[" + paramContext.getLatitude() + " , " + paramContext.getLongitude() + "]  accuracy:" + paramContext.getAccuracy() + "  retry count:" + this.N + " isGpsProvider:" + bool);
        this.G.onLocationGot((float)paramContext.getLatitude(), (float)paramContext.getLongitude(), (int)paramContext.getAccuracy(), 3, paramIntent, str, true);
        return;
      }
    } while ((this.M) || (i != 1));
    this.M = true;
    Log.v("MicroMsg.LBSManager", "report location by Network ok:[" + paramContext.getLatitude() + " , " + paramContext.getLongitude() + "]  accuracy:" + paramContext.getAccuracy() + "  retry count:" + this.N + " isGpsProvider:" + bool);
    this.G.onLocationGot((float)paramContext.getLatitude(), (float)paramContext.getLongitude(), (int)paramContext.getAccuracy(), 4, paramIntent, str, true);
  }
  
  public void removeGpsUpdate()
  {
    Log.v("MicroMsg.LBSManager", "removed gps update");
    if (this.H != null) {
      this.H.removeUpdates(this.I);
    }
    try
    {
      this.q.unregisterReceiver(this);
      return;
    }
    catch (Exception localException)
    {
      Log.v("MicroMsg.LBSManager", "location receiver has already unregistered");
    }
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
    if (paramInt > 0) {}
    for (;;)
    {
      Log.v("MicroMsg.LBSManager", "requested gps update");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("filter_gps");
      this.q.registerReceiver(this, localIntentFilter);
      if (isGpsEnable()) {
        this.H.requestLocationUpdates("gps", paramInt, 0.0F, this.I);
      }
      if (!isNetworkPrividerEnable()) {
        break;
      }
      this.H.requestLocationUpdates("network", paramInt, 0.0F, this.I);
      return;
      paramInt = 500;
    }
  }
  
  public void resetForContinueGetLocation()
  {
    this.L = false;
    this.M = false;
  }
  
  public void start()
  {
    String str1 = Util.nullAsNil(getWIFILocation());
    String str2 = Util.nullAsNil(getTelLocation());
    int i;
    if ((isGpsEnable()) || (isNetworkPrividerEnable()))
    {
      i = 1;
      if ((i == 0) || (this.J)) {
        break label73;
      }
      this.J = true;
      this.N = 0;
      requestGpsUpdate();
      this.O.startTimer(3000L);
    }
    label73:
    label241:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        if (F == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label241;
          }
          if (this.G == null) {
            break;
          }
          this.K = true;
          Log.v("MicroMsg.LBSManager", "location by GPS cache ok:[" + F.Q + " , " + F.R + "]  accuracy:" + F.S + " source:" + F.T);
          this.G.onLocationGot(F.Q, F.R, F.S, F.T, str1, str2, true);
          return;
          if ((System.currentTimeMillis() - F.time > 180000L) || (F.S <= 0)) {
            i = 0;
          } else {
            i = 1;
          }
        }
        this.K = true;
        if ((!str1.equals("")) || (!str2.equals(""))) {
          break label302;
        }
        Log.v("MicroMsg.LBSManager", "get location by network failed");
      } while (this.G == null);
      this.G.onLocationGot(-1000.0F, -1000.0F, -1000, 0, "", "", false);
      return;
      Log.v("MicroMsg.LBSManager", "get location by network ok, macs : " + str1 + " cell ids :" + str2);
    } while (this.G == null);
    label302:
    this.G.onLocationGot(-1000.0F, -1000.0F, -1000, 0, str1, str2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LBSManager
 * JD-Core Version:    0.7.0.1
 */