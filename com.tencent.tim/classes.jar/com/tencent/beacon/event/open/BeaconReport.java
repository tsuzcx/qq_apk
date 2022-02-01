package com.tencent.beacon.event.open;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.net.adapter.AbstractNetAdapter;
import com.tencent.beacon.base.util.BeaconLogger;
import com.tencent.beacon.core.info.BeaconPubParams;
import com.tencent.beacon.event.immediate.IBeaconImmediateReport;
import com.tencent.beacon.module.BeaconModule;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.beacon.qimei.QimeiSDK;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BeaconReport
{
  private static volatile BeaconReport a;
  private static String b = "";
  private Context c;
  private boolean d;
  private String e;
  private BeaconConfig f;
  private boolean g;
  private String h;
  private IBeaconImmediateReport i;
  
  private void a()
  {
    com.tencent.beacon.base.util.c.a(this.g);
    Object localObject = this.f;
    if (localObject != null)
    {
      com.tencent.beacon.base.util.c.a("BeaconReport", ((BeaconConfig)localObject).toString(), new Object[0]);
      com.tencent.beacon.base.net.b.b.a(this.f.getConfigHost(), this.f.getUploadHost());
      d();
      com.tencent.beacon.a.c.c.d().a(this.f.isEnableQmsp());
    }
    com.tencent.beacon.base.net.c localc = com.tencent.beacon.base.net.c.c();
    Context localContext = this.c;
    localObject = this.f;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((BeaconConfig)localObject).getHttpAdapter())
    {
      localc.a(localContext, (AbstractNetAdapter)localObject);
      com.tencent.beacon.a.d.a.a().a(this.c);
      com.tencent.beacon.a.c.b.f();
      com.tencent.beacon.a.c.e.l().C();
      return;
    }
  }
  
  private void a(BeaconConfig paramBeaconConfig)
  {
    f localf = f.e();
    if (!TextUtils.isEmpty(paramBeaconConfig.getAndroidID())) {
      localf.a(paramBeaconConfig.getAndroidID());
    }
    if (!TextUtils.isEmpty(paramBeaconConfig.getImei())) {
      localf.b(paramBeaconConfig.getImei());
    }
    if (!TextUtils.isEmpty(paramBeaconConfig.getImei2())) {
      localf.c(paramBeaconConfig.getImei2());
    }
    if (!TextUtils.isEmpty(paramBeaconConfig.getImsi())) {
      localf.d(paramBeaconConfig.getImsi());
    }
    if (!TextUtils.isEmpty(paramBeaconConfig.getMeid())) {
      localf.f(paramBeaconConfig.getMeid());
    }
    if (!TextUtils.isEmpty(paramBeaconConfig.getModel())) {
      localf.g(paramBeaconConfig.getModel());
    }
    if (!TextUtils.isEmpty(paramBeaconConfig.getMac())) {
      localf.e(paramBeaconConfig.getMac());
    }
    if (!TextUtils.isEmpty(paramBeaconConfig.getWifiMacAddress())) {
      localf.i(paramBeaconConfig.getWifiMacAddress());
    }
    if (!TextUtils.isEmpty(paramBeaconConfig.getWifiSSID())) {
      localf.j(paramBeaconConfig.getWifiSSID());
    }
    if (!TextUtils.isEmpty(paramBeaconConfig.getOaid())) {
      localf.h(paramBeaconConfig.getOaid());
    }
  }
  
  private void b()
  {
    com.tencent.beacon.a.c.c localc = com.tencent.beacon.a.c.c.d();
    localc.a(this.c);
    localc.d(this.e);
    QimeiSDK.getInstance().setAppKey(this.e);
    localc.a(this.h);
  }
  
  private void c()
  {
    int k = 0;
    ModuleName[] arrayOfModuleName = ModuleName.values();
    int m = arrayOfModuleName.length;
    int j = 0;
    for (;;)
    {
      if (j < m)
      {
        ModuleName localModuleName = arrayOfModuleName[j];
        try
        {
          BeaconModule localBeaconModule = com.tencent.beacon.event.c.d.e(localModuleName.getClassName());
          BeaconModule.a.put(localModuleName, localBeaconModule);
          j += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.beacon.base.util.c.b("init Module error: " + localException.getMessage(), new Object[0]);
            com.tencent.beacon.base.util.c.a(localException);
          }
        }
      }
    }
    m = arrayOfModuleName.length;
    j = k;
    while (j < m)
    {
      Object localObject = arrayOfModuleName[j];
      localObject = (BeaconModule)BeaconModule.a.get(localObject);
      if (localObject != null) {
        ((BeaconModule)localObject).a(this.c);
      }
      j += 1;
    }
    QimeiSDK.getInstance().init(this.c);
  }
  
  private void d()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("u_c_a_e", Boolean.valueOf(this.f.isAuditEnable()));
    ((Map)localObject).put("u_c_b_e", Boolean.valueOf(this.f.isBidEnable()));
    ((Map)localObject).put("u_c_d_s", Integer.valueOf(this.f.getMaxDBCount()));
    ((Map)localObject).put("u_c_p_s", Boolean.valueOf(this.f.isPagePathEnable()));
    ((Map)localObject).put("u_s_o_h", Boolean.valueOf(this.f.isSocketMode()));
    localObject = new com.tencent.beacon.a.a.c(8, (Map)localObject);
    com.tencent.beacon.a.a.b.a().b((com.tencent.beacon.a.a.c)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("s_e_e", Boolean.valueOf(this.f.isEventReportEnable()));
    localObject = new com.tencent.beacon.a.a.c(7, (Map)localObject);
    com.tencent.beacon.a.a.b.a().b((com.tencent.beacon.a.a.c)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("u_c_r_p", Long.valueOf(this.f.getRealtimePollingTime()));
    ((Map)localObject).put("u_c_n_p", Long.valueOf(this.f.getNormalPollingTIme()));
    com.tencent.beacon.a.a.b.a().b(new com.tencent.beacon.a.a.c(11, (Map)localObject));
  }
  
  public static BeaconReport getInstance()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new BeaconReport();
      }
      return a;
    }
    finally {}
  }
  
  public static String getSoPath()
  {
    return b;
  }
  
  public static void setSoPath(String paramString)
  {
    b = paramString;
  }
  
  public BeaconPubParams getCommonParams(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return BeaconPubParams.getPubParams(paramContext);
  }
  
  public IBeaconImmediateReport getImmediateReport()
  {
    return this.i;
  }
  
  public String getOAID()
  {
    return f.e().i();
  }
  
  @Nullable
  public Qimei getQimei()
  {
    return QimeiSDK.getInstance().getQimei();
  }
  
  public void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    QimeiSDK.getInstance().getQimei(paramIAsyncQimeiListener);
  }
  
  @Nullable
  public Qimei getRtQimei(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    com.tencent.beacon.a.c.c.d().a(paramContext.getApplicationContext());
    return QimeiSDK.getInstance().getQimei();
  }
  
  public String getSDKVersion()
  {
    return "4.1.26.2";
  }
  
  public EventResult report(BeaconEvent paramBeaconEvent)
  {
    try
    {
      if (TextUtils.isEmpty(paramBeaconEvent.getCode())) {
        return EventResult.a.a(106);
      }
      paramBeaconEvent = BeaconEvent.newBuilder(paramBeaconEvent).build();
      Object localObject = (EventModule)com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
      if ((localObject != null) && (((EventModule)localObject).d())) {
        return ((EventModule)localObject).a(paramBeaconEvent);
      }
      localObject = new HashMap();
      ((Map)localObject).put("b_e", paramBeaconEvent);
      com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(6, (Map)localObject));
      paramBeaconEvent = new EventResult(0, -1L, "Beacon SDK not init beaconEvent add to cache!");
      return paramBeaconEvent;
    }
    catch (Throwable paramBeaconEvent)
    {
      com.tencent.beacon.base.util.c.a(paramBeaconEvent);
      com.tencent.beacon.a.b.d.b().a("598", "error while report", paramBeaconEvent);
    }
    return new EventResult(199, -1L, "REPORT ERROR");
  }
  
  public void resumeReport()
  {
    com.tencent.beacon.base.util.c.a("BeaconReport", "resume report by user.", new Object[0]);
    com.tencent.beacon.a.b.a.a().c();
    com.tencent.beacon.base.net.c.c().e();
  }
  
  public void setAdditionalParams(String paramString, @NonNull Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("i_c_ad", new HashMap(paramMap));
    localHashMap.put("i_c_ak", paramString);
    paramString = new com.tencent.beacon.a.a.c(3, localHashMap);
    com.tencent.beacon.a.a.b.a().b(paramString);
  }
  
  public void setAdditionalParams(@NonNull Map<String, String> paramMap)
  {
    setAdditionalParams(this.e, paramMap);
  }
  
  public void setAndroidID(String paramString)
  {
    f.e().a(paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.beacon.a.c.b.a = paramString;
    }
  }
  
  public void setChannelID(String paramString)
  {
    this.h = paramString;
    com.tencent.beacon.a.c.c.d().a(paramString);
  }
  
  @Deprecated
  public void setCollectAndroidID(boolean paramBoolean)
  {
    com.tencent.beacon.base.util.c.b("setCollectAndroidID has been Deprecated since 4.1.24", new Object[0]);
  }
  
  @Deprecated
  public void setCollectImei(boolean paramBoolean)
  {
    com.tencent.beacon.base.util.c.b("setCollectImei has been Deprecated since 4.1.24", new Object[0]);
  }
  
  @Deprecated
  public void setCollectMac(boolean paramBoolean)
  {
    com.tencent.beacon.base.util.c.b("setCollectMac has been Deprecated since 4.1.24", new Object[0]);
  }
  
  @Deprecated
  public void setCollectModel(boolean paramBoolean)
  {
    com.tencent.beacon.base.util.c.b("setCollectModel has been Deprecated since 4.1.24", new Object[0]);
  }
  
  @Deprecated
  public void setCollectOAID(boolean paramBoolean)
  {
    com.tencent.beacon.base.util.c.b("setCollectOAID has been Deprecated since 4.1.24", new Object[0]);
  }
  
  @Deprecated
  public void setCollectPersonalInfo(boolean paramBoolean)
  {
    com.tencent.beacon.base.util.c.b("setCollectPersonalInfo has been Deprecated since 4.1.24", new Object[0]);
  }
  
  public void setCollectProcessInfo(boolean paramBoolean)
  {
    com.tencent.beacon.e.b.a().a(paramBoolean);
  }
  
  public void setImei(String paramString)
  {
    f.e().b(paramString);
  }
  
  public void setImei2(String paramString)
  {
    f.e().c(paramString);
  }
  
  public void setImmediateReport(IBeaconImmediateReport paramIBeaconImmediateReport)
  {
    this.i = paramIBeaconImmediateReport;
  }
  
  public void setImsi(String paramString)
  {
    f.e().d(paramString);
  }
  
  public void setLogAble(boolean paramBoolean)
  {
    this.g = paramBoolean;
    com.tencent.beacon.base.util.c.a(paramBoolean);
  }
  
  public void setLogger(BeaconLogger paramBeaconLogger)
  {
    com.tencent.beacon.base.util.c.a(paramBeaconLogger);
  }
  
  public void setMac(String paramString)
  {
    f.e().e(paramString);
  }
  
  public void setMeid(String paramString)
  {
    f.e().f(paramString);
  }
  
  public void setModel(String paramString)
  {
    f.e().g(paramString);
  }
  
  public void setOAID(String paramString)
  {
    f.e().h(paramString);
  }
  
  @Deprecated
  public void setOaid(String paramString)
  {
    f.e().h(paramString);
    com.tencent.beacon.base.util.c.b("setOaid has been Deprecated since 4.1.24, please use setOAID", new Object[0]);
  }
  
  public void setOmgID(String paramString)
  {
    QimeiSDK.getInstance().setOmgId(paramString);
  }
  
  public void setQQ(String paramString)
  {
    com.tencent.beacon.a.c.b.a(paramString);
  }
  
  public void setStrictMode(boolean paramBoolean)
  {
    com.tencent.beacon.base.util.e.a.set(paramBoolean);
  }
  
  public void setUserID(String paramString)
  {
    setUserID(this.e, paramString);
  }
  
  public void setUserID(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("i_c_ak", paramString1);
    localHashMap.put("i_c_u_i", paramString2);
    paramString1 = new com.tencent.beacon.a.a.c(4, localHashMap);
    com.tencent.beacon.a.a.b.a().b(paramString1);
  }
  
  public void setWifiMacAddress(String paramString)
  {
    f.e().i(paramString);
  }
  
  public void setWifiSSID(String paramString)
  {
    f.e().j(paramString);
  }
  
  public void start(@NonNull Context paramContext, @NonNull String paramString, @Nullable BeaconConfig paramBeaconConfig)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = this.d;
        if (bool2) {
          return;
        }
        com.tencent.beacon.base.util.e.a("Context", paramContext);
        this.c = paramContext.getApplicationContext();
        com.tencent.beacon.base.util.e.a("AppKey", paramString);
        this.e = paramString;
        this.f = paramBeaconConfig;
        com.tencent.beacon.a.c.c.d().a(paramContext);
        paramContext = com.tencent.beacon.a.b.d.b();
        if ((paramBeaconConfig != null) && (paramBeaconConfig.isForceEnableAtta()))
        {
          paramContext.a(bool1);
          ((Application)this.c).registerActivityLifecycleCallbacks(new com.tencent.beacon.b.b());
          if (paramBeaconConfig != null) {
            a(paramBeaconConfig);
          }
          com.tencent.beacon.a.b.a.a().a(new b(this));
          this.d = true;
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public void stopReport(boolean paramBoolean)
  {
    com.tencent.beacon.base.util.c.a("BeaconReport", "stop report by user.", new Object[0]);
    com.tencent.beacon.a.b.a.a().a(paramBoolean);
    com.tencent.beacon.base.net.c.c().close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconReport
 * JD-Core Version:    0.7.0.1
 */