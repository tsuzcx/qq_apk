package com.tencent.wifisdk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import wf7.bn;
import wf7.bq;
import wf7.dg;
import wf7.fo;
import wf7.fp;
import wf7.fq;
import wf7.fr;
import wf7.gd;
import wf7.ha;
import wf7.hj;
import wf7.hk;
import wf7.hl;
import wf7.hm;

public class TMSDKWifiManager
{
  public static final int CONN_RET_CANCELED = -6;
  public static final int CONN_RET_CONNECTED_TO_OTHER = -7;
  public static final int CONN_RET_FAILED = -8;
  public static final int CONN_RET_INVALID_ARGS = -2;
  public static final int CONN_RET_NO_CACHE = -5;
  public static final int CONN_RET_SUCCESS = 0;
  public static final int CONN_RET_UNKNOWN = -1;
  public static final int CONN_RET_WIFI_DISABLED = -3;
  public static final int CONN_RET_WIFI_NOT_FOUND = -4;
  public static final int MOBILE_SIGNAL_GOOD = 3;
  public static final int MOBILE_SIGNAL_GREAT = 4;
  public static final int MOBILE_SIGNAL_MODERATE = 2;
  public static final int MOBILE_SIGNAL_NONE = 0;
  public static final int MOBILE_SIGNAL_POOR = 1;
  public static final int MOBILE_SIGNAL_UNKNOWN = -1;
  public static final int UPDATE_ERR_GPS_SWITCH_DISABLED = -3;
  public static final int UPDATE_ERR_NONE = 0;
  public static final int UPDATE_ERR_NO_LOCATION_PERMISSION = -1;
  public static final int UPDATE_ERR_SCAN_FAILED = -4;
  public static final int UPDATE_ERR_UNKNOWN = -999;
  public static final int UPDATE_ERR_WIFI_SWITCH_DISABLED = -2;
  private static TMSDKWifiManager qj = null;
  private static boolean qk = false;
  private static TMSDKCustomConfig ql;
  private fp qm = fp.dX();
  private Set<TMSDKWifiEventListener> qn = new CopyOnWriteArraySet();
  private Set<TMSDKWifiListUpdateListener> qo = new CopyOnWriteArraySet();
  private fr qp = new b(null);
  private fo qq = new a(null);
  
  private TMSDKWifiManager()
  {
    this.qm.a(this.qq);
    this.qm.a(this.qp);
  }
  
  @NonNull
  public static TMSDKCustomConfig getCustomConfig()
  {
    try
    {
      if (ql == null) {
        ql = new TMSDKCustomConfig();
      }
      TMSDKCustomConfig localTMSDKCustomConfig = ql;
      return localTMSDKCustomConfig;
    }
    finally {}
  }
  
  public static TMSDKWifiManager getInstance()
  {
    if (qj == null) {}
    try
    {
      if (qj == null) {
        qj = new TMSDKWifiManager();
      }
      return qj;
    }
    finally {}
  }
  
  public static boolean init(Context paramContext, TMSDKCustomConfig paramTMSDKCustomConfig)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = qk;
        if (!bool2) {
          continue;
        }
      }
      finally
      {
        try
        {
          if (dg.bI()) {
            System.currentTimeMillis();
          }
          TMSDKCustomConfig localTMSDKCustomConfig = paramTMSDKCustomConfig;
          if (paramTMSDKCustomConfig == null) {
            localTMSDKCustomConfig = new TMSDKCustomConfig();
          }
          ql = localTMSDKCustomConfig;
          ql.apply();
          fq.p(paramContext);
          if (dg.bI()) {
            System.currentTimeMillis();
          }
          qk = true;
        }
        catch (Throwable paramContext)
        {
          bool1 = false;
        }
        paramContext = finally;
      }
      return bool1;
    }
  }
  
  public static boolean isWiFiManagerExist()
  {
    return hl.fo();
  }
  
  public static void setEnableLog(boolean paramBoolean)
  {
    fq.G(paramBoolean);
  }
  
  public void cancelWifi()
  {
    this.qm.cancelWifi();
  }
  
  public void connectWifi(TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo, String paramString)
  {
    if ((paramTMSDKFreeWifiInfo == null) || (!ha.Y(paramTMSDKFreeWifiInfo.ssid))) {}
    do
    {
      return;
      paramTMSDKFreeWifiInfo = hm.fq().a(paramTMSDKFreeWifiInfo.ssid, paramTMSDKFreeWifiInfo.security);
    } while (paramTMSDKFreeWifiInfo == null);
    this.qm.a(paramTMSDKFreeWifiInfo, paramString);
  }
  
  public void registerListUpdateListener(TMSDKWifiListUpdateListener paramTMSDKWifiListUpdateListener)
  {
    if ((paramTMSDKWifiListUpdateListener == null) || (this.qo.contains(paramTMSDKWifiListUpdateListener))) {
      return;
    }
    this.qo.add(paramTMSDKWifiListUpdateListener);
  }
  
  public void registerWifiEventListener(TMSDKWifiEventListener paramTMSDKWifiEventListener)
  {
    if ((paramTMSDKWifiEventListener == null) || (this.qn.contains(paramTMSDKWifiEventListener))) {
      return;
    }
    this.qn.add(paramTMSDKWifiEventListener);
  }
  
  public void release()
  {
    this.qo.clear();
    this.qn.clear();
    this.qp = null;
    this.qq = null;
    this.qm.destroy();
    this.qm = null;
    qj = null;
  }
  
  public void setBackgroundRefreshRate(long paramLong)
  {
    this.qm.h(paramLong);
  }
  
  public void setFgUpdateTaskSwitch(boolean paramBoolean)
  {
    this.qm.setFgUpdateTaskSwitch(paramBoolean);
  }
  
  public void setForegroundRefreshRate(long paramLong)
  {
    this.qm.g(paramLong);
  }
  
  public void setUpdateTaskMaxLoopCount(int paramInt)
  {
    this.qm.setUpdateTaskMaxLoopCount(paramInt);
  }
  
  public void startCheckFreeWifi(IFreeWifiCheckCallback paramIFreeWifiCheckCallback)
  {
    hk.az(398582);
    if (paramIFreeWifiCheckCallback == null) {
      return;
    }
    fq.em().addTask(new TMSDKWifiManager.1(this, paramIFreeWifiCheckCallback), "tsk-scfw", 1);
  }
  
  public void startUpdateTask(boolean paramBoolean)
  {
    this.qm.startUpdateTask(paramBoolean);
  }
  
  public void stopUpdateTask(boolean paramBoolean)
  {
    this.qm.stopUpdateTask(paramBoolean);
  }
  
  public void unregisterAll()
  {
    this.qn.clear();
    this.qo.clear();
  }
  
  public void unregisterListUpdateListener(TMSDKWifiListUpdateListener paramTMSDKWifiListUpdateListener)
  {
    if (paramTMSDKWifiListUpdateListener == null) {
      return;
    }
    this.qo.remove(paramTMSDKWifiListUpdateListener);
  }
  
  public void unregisterWifiEventListener(TMSDKWifiEventListener paramTMSDKWifiEventListener)
  {
    if (paramTMSDKWifiEventListener == null) {
      return;
    }
    this.qn.remove(paramTMSDKWifiEventListener);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ConnectResultCode {}
  
  public static abstract interface IConnectResultCallback
  {
    public abstract void onLastTry();
    
    public abstract void onResult(int paramInt);
  }
  
  public static abstract interface IFreeWifiCheckCallback
  {
    public abstract void onResult(int paramInt, List<TMSDKFreeWifiInfo> paramList);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MobileSignalLevel {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface UpdateErrCode {}
  
  class a
    implements fo
  {
    private a() {}
    
    public void a(int paramInt, CurrentSessionItem paramCurrentSessionItem)
    {
      paramCurrentSessionItem = hm.g(paramCurrentSessionItem);
      if (paramCurrentSessionItem != null) {}
      for (paramCurrentSessionItem = hm.x(paramCurrentSessionItem);; paramCurrentSessionItem = null)
      {
        Iterator localIterator = TMSDKWifiManager.c(TMSDKWifiManager.this).iterator();
        while (localIterator.hasNext()) {
          ((TMSDKWifiEventListener)localIterator.next()).onConnectionStateChanged(paramInt, paramCurrentSessionItem);
        }
        return;
      }
    }
    
    public void d(CurrentSessionItem paramCurrentSessionItem)
    {
      paramCurrentSessionItem = hm.h(paramCurrentSessionItem);
      Iterator localIterator = TMSDKWifiManager.c(TMSDKWifiManager.this).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiEventListener)localIterator.next()).onConnectionSuccess(paramCurrentSessionItem);
      }
    }
    
    public void onConnectionFailed(int paramInt)
    {
      Iterator localIterator = TMSDKWifiManager.c(TMSDKWifiManager.this).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiEventListener)localIterator.next()).onConnectionFailed(paramInt);
      }
    }
    
    public void onGPSDisabled()
    {
      Iterator localIterator = TMSDKWifiManager.c(TMSDKWifiManager.this).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiEventListener)localIterator.next()).onGPSDisabled();
      }
    }
    
    public void onGPSEnabled()
    {
      Iterator localIterator = TMSDKWifiManager.c(TMSDKWifiManager.this).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiEventListener)localIterator.next()).onGPSEnabled();
      }
    }
    
    public void onWifiDisabled()
    {
      Iterator localIterator = TMSDKWifiManager.c(TMSDKWifiManager.this).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiEventListener)localIterator.next()).onWifiDisabled();
      }
    }
    
    public void onWifiEnabled()
    {
      Iterator localIterator = TMSDKWifiManager.c(TMSDKWifiManager.this).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiEventListener)localIterator.next()).onWifiEnabled();
      }
    }
    
    public void t(bn parambn)
    {
      parambn = hm.x(parambn);
      Iterator localIterator = TMSDKWifiManager.c(TMSDKWifiManager.this).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiEventListener)localIterator.next()).onConnectionStart(parambn);
      }
    }
  }
  
  class b
    implements fr
  {
    private b() {}
    
    public void onScanResult(@NonNull List<bn> paramList)
    {
      Iterator localIterator = TMSDKWifiManager.b(TMSDKWifiManager.this).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiListUpdateListener)localIterator.next()).onScanResult(paramList);
      }
    }
    
    public void onUpdateFinish(int paramInt, @Nullable List<bn> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramInt == 0) && (hj.a(paramList)))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          bn localbn = (bn)paramList.next();
          if ((localbn != null) && (hm.d(localbn))) {
            localArrayList.add(hm.x(localbn));
          }
        }
      }
      paramList = TMSDKWifiManager.b(TMSDKWifiManager.this).iterator();
      while (paramList.hasNext()) {
        ((TMSDKWifiListUpdateListener)paramList.next()).onUpdateFinish(paramInt, localArrayList);
      }
    }
    
    public void onUpdateStart()
    {
      Iterator localIterator = TMSDKWifiManager.b(TMSDKWifiManager.this).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiListUpdateListener)localIterator.next()).onUpdateStart();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wifisdk.TMSDKWifiManager
 * JD-Core Version:    0.7.0.1
 */