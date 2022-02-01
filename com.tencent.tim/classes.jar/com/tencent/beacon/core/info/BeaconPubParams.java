package com.tencent.beacon.core.info;

import android.content.Context;
import android.os.Build;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.a.c.c;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.net.b.d;
import com.tencent.beacon.qimei.QimeiSDK;

public class BeaconPubParams
{
  private static BeaconPubParams sParamsHolder;
  private String androidId;
  private String appFirstInstallTime;
  private String appLastUpdatedTime;
  private String appVersion;
  private String beaconId;
  private String boundleId;
  private String brand;
  private String cid;
  private Context context;
  private String dpi;
  private String dtImei2;
  private String dtMeid;
  private String dtMf;
  private String fingerprint;
  private String gpu;
  private String hardwareOs;
  private String imei;
  private String imsi;
  private String isRooted;
  private String language;
  private String mac;
  private String model;
  private String modelApn;
  private String networkType;
  private String osVersion;
  private String platform;
  private String productId;
  private String qimei;
  private String resolution;
  private String sdkId;
  private String sdkVersion;
  private String wifiMac;
  private String wifiSsid;
  
  private BeaconPubParams(Context paramContext)
  {
    this.context = paramContext;
    init(paramContext);
  }
  
  /* Error */
  public static BeaconPubParams getPubParams(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 56	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   6: ifnonnull +26 -> 32
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 56	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   15: ifnonnull +14 -> 29
    //   18: new 2	com/tencent/beacon/core/info/BeaconPubParams
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 58	com/tencent/beacon/core/info/BeaconPubParams:<init>	(Landroid/content/Context;)V
    //   26: putstatic 56	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   29: ldc 2
    //   31: monitorexit
    //   32: getstatic 56	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   35: invokespecial 61	com/tencent/beacon/core/info/BeaconPubParams:refresh	()V
    //   38: getstatic 56	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   12	29	47	finally
    //   29	32	47	finally
    //   48	51	47	finally
    //   3	12	53	finally
    //   32	42	53	finally
    //   51	53	53	finally
  }
  
  private void init(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext != paramContext.getApplicationContext()) {
      localObject = paramContext.getApplicationContext();
    }
    paramContext = c.d();
    paramContext.a((Context)localObject);
    this.appVersion = b.a();
    this.boundleId = b.b();
    this.sdkId = paramContext.h();
    this.sdkVersion = paramContext.i();
    this.productId = paramContext.f();
    this.beaconId = QimeiSDK.getInstance().getBeaconIdInfo();
    this.appFirstInstallTime = b.a((Context)localObject);
    e locale = e.l();
    this.appLastUpdatedTime = locale.a((Context)localObject);
    this.platform = String.valueOf(paramContext.g());
    this.dtMf = locale.o();
    this.osVersion = locale.s();
    this.hardwareOs = (locale.f() + "_" + locale.e());
    this.brand = Build.BRAND;
    localObject = f.e();
    this.model = ((f)localObject).h();
    this.language = locale.n();
    this.resolution = locale.u();
    this.dpi = String.valueOf(locale.y());
    this.gpu = "";
    if (locale.m()) {}
    for (paramContext = "1";; paramContext = "0")
    {
      this.isRooted = paramContext;
      this.fingerprint = locale.v();
      this.qimei = QimeiSDK.getInstance().getQimeiInternal();
      this.mac = ((f)localObject).f();
      this.wifiMac = ((f)localObject).j();
      this.wifiSsid = ((f)localObject).k();
      this.cid = locale.p();
      return;
    }
  }
  
  private void refresh()
  {
    e locale = e.l();
    f localf = f.e();
    this.networkType = locale.q();
    this.modelApn = d.c();
    this.imei = localf.b();
    this.dtImei2 = localf.c();
    this.dtMeid = localf.g();
    this.imsi = localf.d();
    this.androidId = localf.a();
    this.mac = localf.f();
    this.wifiMac = localf.j();
    this.wifiSsid = localf.k();
  }
  
  public String getAndroidId()
  {
    return this.androidId;
  }
  
  public String getAppFirstInstallTime()
  {
    return this.appFirstInstallTime;
  }
  
  public String getAppLastUpdatedTime()
  {
    return this.appLastUpdatedTime;
  }
  
  public String getAppVersion()
  {
    return this.appVersion;
  }
  
  public String getBeaconId()
  {
    return this.beaconId;
  }
  
  public String getBoundleId()
  {
    return this.boundleId;
  }
  
  public String getBrand()
  {
    return this.brand;
  }
  
  public String getCid()
  {
    return this.cid;
  }
  
  public String getDpi()
  {
    return this.dpi;
  }
  
  public String getDtImei2()
  {
    return this.dtImei2;
  }
  
  public String getDtMeid()
  {
    return this.dtMeid;
  }
  
  public String getDtMf()
  {
    return this.dtMf;
  }
  
  public String getFingerprint()
  {
    return this.fingerprint;
  }
  
  public String getHardwareOs()
  {
    return this.hardwareOs;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public String getImsi()
  {
    return this.imsi;
  }
  
  public String getIsRooted()
  {
    return this.isRooted;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getModelApn()
  {
    return this.modelApn;
  }
  
  public String getNetworkType()
  {
    return this.networkType;
  }
  
  public String getOsVersion()
  {
    return this.osVersion;
  }
  
  public String getPlatform()
  {
    return this.platform;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public String getQimei()
  {
    return this.qimei;
  }
  
  public String getResolution()
  {
    return this.resolution;
  }
  
  public String getSdkId()
  {
    return this.sdkId;
  }
  
  public String getSdkVersion()
  {
    return this.sdkVersion;
  }
  
  public String getWifiMac()
  {
    return this.wifiMac;
  }
  
  public String getWifiSsid()
  {
    return this.wifiSsid;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.core.info.BeaconPubParams
 * JD-Core Version:    0.7.0.1
 */