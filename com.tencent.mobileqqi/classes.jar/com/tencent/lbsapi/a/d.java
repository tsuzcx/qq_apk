package com.tencent.lbsapi.a;

import LBSAPIProtocol.Cell;
import LBSAPIProtocol.DeviceData;
import LBSAPIProtocol.GPS;
import LBSAPIProtocol.Measure;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.tencent.lbsapi.QLBSNotification;
import com.tencent.lbsapi.model.CellInfo;
import com.tencent.lbsapi.model.GpsInfo;
import com.tencent.lbsapi.model.WifiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  private static final int b = 5;
  private static final int c = 900000000;
  private static final int d = 900000000;
  protected Runnable a = new h(this);
  private Context e;
  private QLBSNotification f;
  private Handler g = new Handler(Looper.getMainLooper());
  private TelephonyManager h = null;
  private LocationManager i = null;
  private LocationListener j = null;
  private LocationListener k = null;
  private WifiManager l = null;
  private BroadcastReceiver m = null;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = true;
  private CellInfo r;
  private GpsInfo s;
  private String t = null;
  private String u = null;
  private ArrayList v = null;
  private ArrayList w = null;
  private int x = 5;
  
  public d(Context paramContext, QLBSNotification paramQLBSNotification)
  {
    this.e = paramContext;
    this.f = paramQLBSNotification;
    this.h = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.l = ((WifiManager)paramContext.getSystemService("wifi"));
    this.i = ((LocationManager)paramContext.getSystemService("location"));
  }
  
  private void a(Location paramLocation)
  {
    try
    {
      this.s.lon = ((int)(paramLocation.getLongitude() * 1000000.0D));
      this.s.lat = ((int)(paramLocation.getLatitude() * 1000000.0D));
      if (paramLocation.hasAltitude()) {
        this.s.alt = ((int)paramLocation.getAltitude());
      }
      this.s.hasAccuracy = paramLocation.hasAccuracy();
      if (this.s.hasAccuracy) {
        this.s.accuracy = paramLocation.getAccuracy();
      }
      i.a("----processReceiveNetwork gps:" + this.s + " provider:" + paramLocation.getProvider());
      if (this.j != null) {
        this.i.removeUpdates(this.j);
      }
      if (this.p)
      {
        this.p = false;
        k();
      }
      return;
    }
    catch (Exception paramLocation)
    {
      paramLocation.printStackTrace();
      this.p = false;
      if (this.j != null) {
        this.i.removeUpdates(this.j);
      }
      k();
    }
  }
  
  private void b(Location paramLocation)
  {
    try
    {
      this.s.lon = ((int)(paramLocation.getLongitude() * 1000000.0D));
      this.s.lat = ((int)(paramLocation.getLatitude() * 1000000.0D));
      if (paramLocation.hasAltitude()) {
        this.s.alt = ((int)paramLocation.getAltitude());
      }
      this.s.hasAccuracy = paramLocation.hasAccuracy();
      if (this.s.hasAccuracy) {
        this.s.accuracy = paramLocation.getAccuracy();
      }
      i.a("----processReceiveGps gps:" + this.s + " provider:" + paramLocation.getProvider());
      if (this.p)
      {
        this.p = false;
        if (this.j != null) {
          this.i.removeUpdates(this.j);
        }
      }
      if (this.k != null) {
        this.i.removeUpdates(this.k);
      }
      if (this.o)
      {
        this.o = false;
        k();
      }
      return;
    }
    catch (Exception paramLocation)
    {
      paramLocation.printStackTrace();
      this.o = false;
      if (this.k != null) {
        this.i.removeUpdates(this.k);
      }
      k();
    }
  }
  
  private boolean b(String paramString)
  {
    boolean bool = false;
    if (this.i != null) {}
    try
    {
      bool = this.i.isProviderEnabled(paramString);
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private void k()
  {
    if ((!this.p) && (!this.o) && (!this.n))
    {
      i.a("----notifyCallback---");
      e();
      int i1 = 0;
      if (g()) {
        i1 = 1;
      }
      if (this.f != null) {
        this.f.onLocationNotification(i1);
      }
    }
  }
  
  private void l()
  {
    this.s = new GpsInfo();
    this.r = new CellInfo();
    if (this.v == null)
    {
      this.v = new ArrayList();
      if (this.w != null) {
        break label74;
      }
      this.w = new ArrayList();
    }
    for (;;)
    {
      this.u = null;
      return;
      this.v.clear();
      break;
      label74:
      this.w.clear();
    }
  }
  
  private void m()
  {
    Object localObject1;
    if ((Settings.System.getInt(this.e.getContentResolver(), "airplane_mode_on", 0) == 0) && (this.h != null))
    {
      if (this.h.getPhoneType() != 1) {
        break label261;
      }
      localObject1 = (GsmCellLocation)this.h.getCellLocation();
      if (localObject1 != null)
      {
        this.r.lac = ((GsmCellLocation)localObject1).getLac();
        this.r.cellId = ((GsmCellLocation)localObject1).getCid();
        if ((this.r.lac > 0) || (this.r.cellId > 0))
        {
          Object localObject2 = this.h.getNetworkOperator();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() >= 3)) {
            localObject1 = localObject2;
          }
          try
          {
            localObject2 = localObject2.split(",")[0];
            localObject1 = localObject2;
            this.r.mcc = Integer.parseInt(((String)localObject2).substring(0, 3));
            localObject1 = localObject2;
            this.r.mnc = Integer.parseInt(((String)localObject2).substring(3));
            localObject1 = this.h.getNeighboringCellInfo();
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (NeighboringCellInfo)((Iterator)localObject1).next();
                this.v.add(new CellInfo(this.r.mcc, this.r.mnc, ((NeighboringCellInfo)localObject2).getLac(), ((NeighboringCellInfo)localObject2).getCid(), ((NeighboringCellInfo)localObject2).getRssi(), 0.0D, 0.0D));
              }
            }
            return;
          }
          catch (Exception localException2)
          {
            this.u = ((String)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      label261:
      if (this.h.getPhoneType() != 2) {
        continue;
      }
      try
      {
        if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 5)
        {
          localObject1 = (CdmaCellLocation)this.h.getCellLocation();
          if (localObject1 != null)
          {
            this.r.mnc = ((CdmaCellLocation)localObject1).getSystemId();
            this.r.lac = ((CdmaCellLocation)localObject1).getNetworkId();
            this.r.cellId = ((CdmaCellLocation)localObject1).getBaseStationId();
            this.r.stationLat = ((CdmaCellLocation)localObject1).getBaseStationLatitude();
            this.r.stationLon = ((CdmaCellLocation)localObject1).getBaseStationLongitude();
          }
        }
        localObject1 = this.h.getNetworkOperator();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        int i1 = ((String)localObject1).length();
        if (i1 < 3) {
          continue;
        }
        try
        {
          this.r.mcc = Integer.parseInt(((String)localObject1).substring(0, 3));
          return;
        }
        catch (Exception localException3)
        {
          this.u = ((String)localObject1);
          return;
        }
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
  }
  
  private void n()
  {
    if (!d()) {
      return;
    }
    try
    {
      o();
      if (this.w.size() == 0)
      {
        i.a("-----如果没读到则扫描一次");
        if (this.m == null)
        {
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
          this.m = new e(this);
          this.e.registerReceiver(this.m, localIntentFilter);
        }
        this.n = this.l.startScan();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    i.a("----直接读到wifi了，不用扫描");
  }
  
  private void o()
  {
    List localList = this.l.getScanResults();
    int i1 = 0;
    while (i1 < localList.size())
    {
      ScanResult localScanResult = (ScanResult)localList.get(i1);
      this.w.add(new WifiInfo(localScanResult.BSSID, localScanResult.level));
      i1 += 1;
    }
  }
  
  private void p()
  {
    try
    {
      if (this.n)
      {
        this.n = false;
        o();
        k();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.n = false;
      k();
    }
  }
  
  private void q()
  {
    if (this.i == null) {}
    do
    {
      return;
      if (b("network"))
      {
        i.a("----开始网络定位");
        if (this.j == null) {
          this.j = new f(this);
        }
        this.i.requestLocationUpdates("network", 0L, 5.0F, this.j);
        this.p = true;
      }
    } while (!b("gps"));
    i.a("----开始gps定位");
    if (this.k == null) {
      this.k = new g(this);
    }
    this.i.requestLocationUpdates("gps", 0L, 5.0F, this.k);
    this.o = true;
  }
  
  private boolean r()
  {
    return (this.r != null) && (this.r.cellId != -1);
  }
  
  private boolean s()
  {
    return (this.w != null) && (this.w.size() > 0);
  }
  
  private boolean t()
  {
    return (this.s != null) && ((this.s.lat != 900000000) || (this.s.lon != 900000000));
  }
  
  private Measure u()
  {
    localMeasure = new Measure();
    if (g()) {
      try
      {
        Object localObject = new ArrayList();
        ((ArrayList)localObject).add(new Cell((short)this.r.mcc, (short)this.r.mnc, this.r.lac, this.r.cellId));
        Iterator localIterator = this.v.iterator();
        while (localIterator.hasNext())
        {
          CellInfo localCellInfo = (CellInfo)localIterator.next();
          ((ArrayList)localObject).add(new Cell((short)localCellInfo.mcc, (short)localCellInfo.mnc, localCellInfo.lac, localCellInfo.cellId));
        }
        localMeasure.setVCells((ArrayList)localObject);
        localMeasure.setStGps(new GPS(this.s.lat, this.s.lon, this.s.alt, this.s.eType));
        localMeasure.setVMacs(b.a(this.w));
        if (this.u == null) {}
        for (localObject = "";; localObject = this.u)
        {
          localMeasure.setStrExtraInfo((String)localObject);
          break;
        }
        return localMeasure;
      }
      catch (Exception localException)
      {
        return null;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        throw new IllegalStateException("startLocation must invoked in main thread!");
      }
    }
    finally {}
    l();
    m();
    n();
    if (this.q) {
      q();
    }
    this.g.postDelayed(this.a, this.x * 1000);
    k();
  }
  
  public void a(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public byte[] a(String paramString)
  {
    DeviceData localDeviceData = new DeviceData();
    localDeviceData.setStCurMeasure(u());
    localDeviceData.setStrImei(j());
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localDeviceData.setStrAppUA(str);
    localDeviceData.setEDeviceType(1);
    return b.a(localDeviceData);
  }
  
  public CellInfo b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.r = new CellInfo();
      if (this.v != null) {
        break label42;
      }
      this.v = new ArrayList();
    }
    for (;;)
    {
      m();
      return this.r;
      label42:
      this.v.clear();
    }
  }
  
  public boolean b()
  {
    return (b("network")) || (b("gps"));
  }
  
  public int c()
  {
    if (!r()) {
      m();
    }
    if ((this.r.mcc == -1) && (this.r.mnc == -1)) {}
    do
    {
      return -1;
      if ((this.r.mnc == 0) || (this.r.mnc == 2) || (this.r.mnc == 7)) {
        return 0;
      }
      if ((this.r.mnc == 1) || (this.r.mnc == 6)) {
        return 1;
      }
      if ((this.r.mnc == 3) || (this.r.mnc == 5)) {
        return 2;
      }
    } while (this.h.getPhoneType() != 2);
    return 2;
  }
  
  public ArrayList c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.w != null) {
        break label31;
      }
      this.w = new ArrayList();
    }
    for (;;)
    {
      n();
      return this.w;
      label31:
      this.w.clear();
    }
  }
  
  public boolean d()
  {
    boolean bool = false;
    try
    {
      if (this.l != null) {
        bool = this.l.isWifiEnabled();
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void e()
  {
    i.a("----stopLocation---");
    if (this.m != null) {}
    try
    {
      this.e.unregisterReceiver(this.m);
      this.m = null;
      label29:
      if ((this.j != null) && (this.i != null)) {
        this.i.removeUpdates(this.j);
      }
      if ((this.k != null) && (this.i != null)) {
        this.i.removeUpdates(this.k);
      }
      this.o = false;
      this.p = false;
      this.n = false;
      this.g.removeCallbacksAndMessages(null);
      return;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
  
  public void f()
  {
    e();
    this.j = null;
    this.k = null;
    this.f = null;
    this.e = null;
  }
  
  public boolean g()
  {
    return (r()) || (t()) || (s());
  }
  
  public ArrayList h()
  {
    return this.v;
  }
  
  public GpsInfo i()
  {
    return this.s;
  }
  
  public String j()
  {
    if (TextUtils.isEmpty(this.t)) {}
    try
    {
      this.t = this.h.getDeviceId();
      if (this.t == null) {
        this.t = "";
      }
      return this.t;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.t = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.lbsapi.a.d
 * JD-Core Version:    0.7.0.1
 */