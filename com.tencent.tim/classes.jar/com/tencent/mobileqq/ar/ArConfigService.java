package com.tencent.mobileqq.ar;

import adas;
import adef;
import adeg;
import adeh;
import adei;
import adej;
import adek;
import adel;
import adem;
import adeq;
import ades;
import adev;
import adex;
import adfa;
import adfh;
import adgj.a;
import adgk;
import adgm;
import adgn;
import adgo;
import adgt;
import adgv;
import adis.a;
import adjr;
import afem;
import afem.b;
import afes;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import rwg;

public class ArConfigService
  extends AppService
{
  adex jdField_a_of_type_Adex = null;
  private adfh jdField_a_of_type_Adfh = new adef(this);
  private final adgj.a jdField_a_of_type_Adgj$a = new a(this);
  private adis.a jdField_a_of_type_Adis$a = new adej(this);
  private afem.b jdField_a_of_type_Afem$b = new adei(this);
  adas jdField_b_of_type_Adas = null;
  private adis.a jdField_b_of_type_Adis$a = new adek(this);
  private boolean bMl;
  private boolean bMm;
  private boolean bMn;
  private boolean bMo;
  private boolean bMp;
  private boolean bMq;
  private adis.a jdField_c_of_type_Adis$a = new adel(this);
  private RemoteCallbackList<adgn> jdField_c_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private int cDV;
  private int cDW;
  private int cDX;
  private int cDY;
  private int cDZ;
  public Object cQ = new Object();
  private adis.a jdField_d_of_type_Adis$a = new adem(this);
  private RemoteCallbackList<adgk> jdField_d_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private RemoteCallbackList<adgm> e = new RemoteCallbackList();
  private RemoteCallbackList<adgo> f = new RemoteCallbackList();
  private Handler mHandler = new Handler();
  public WeakReference<QQAppInterface> weakApp;
  
  public ArConfigService()
  {
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  private void KK(int paramInt)
  {
    if (this.f != null) {}
    try
    {
      int j = this.f.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((adgo)this.f.getBroadcastItem(i)).Ky(paramInt);
            i += 1;
          }
          catch (Exception localException1) {}
        }
      }
      this.f.finishBroadcast();
      return;
    }
    catch (Exception localException2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadProcess fail!", localException2);
    }
  }
  
  private boolean adN()
  {
    return d(this.app);
  }
  
  private static boolean adO()
  {
    return adeq.kQ("ArMapEngine836");
  }
  
  private boolean adP()
  {
    return e(this.app);
  }
  
  private boolean adQ()
  {
    return f(this.app);
  }
  
  private boolean adR()
  {
    return g(this.app);
  }
  
  private boolean adS()
  {
    return i(this.app);
  }
  
  private void cQN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    if (adO()) {}
    afes localafes;
    for (boolean bool = true;; bool = adN())
    {
      this.bMm = bool;
      if (this.bMm) {
        break label118;
      }
      localafes = (afes)((afem)this.app.getManager(77)).a("qq.android.ar.native.so_v8.3.6");
      if (localafes != null)
      {
        localafes.a(this.jdField_a_of_type_Afem$b);
        this.cDV = 0;
        XmlData localXmlData = localafes.b();
        if ((localXmlData == null) || (localXmlData.loadState != 2)) {
          break;
        }
        QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
        localafes.bS(true, true);
      }
      return;
    }
    localafes.HL(true);
    return;
    label118:
    this.cDV = 100;
  }
  
  private void cQO()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downArCoreSoInternal,mApp is null! ");
    }
    do
    {
      adgv localadgv;
      Object localObject;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "downArCoreSoInternal");
        }
        localadgv = adgt.a();
        if (localadgv == null)
        {
          this.bMp = true;
          this.cDY = 100;
          return;
        }
        this.bMp = adP();
        if (this.bMp) {
          break;
        }
        localObject = (adas)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((adas)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new ades(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, localadgv.getKey(), this.jdField_c_of_type_Adis$a);
        }
        this.cDY = 0;
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ArConfig_ArConfigService", 1, "downArCoreSoInternal fail!", localException);
      }
    } while (this.bMl);
    this.mHandler.post(new ArConfigService.9(this));
    this.bMl = true;
    return;
    this.cDY = 100;
  }
  
  private void cQP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArFeatureSoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArFeatureSoInternal,mApp is null! ");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        this.bMq = adQ();
        if (this.bMq) {
          break;
        }
        localObject = (adas)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((adas)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new ades(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arfeature", this.jdField_d_of_type_Adis$a);
        }
        this.cDZ = 0;
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", localException);
      }
    } while (this.bMl);
    this.mHandler.post(new ArConfigService.10(this));
    this.bMl = true;
    return;
    this.cDZ = 100;
  }
  
  private void cQQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArCloudSoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal,mApp is null! ");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        this.bMn = adR();
        if (this.bMn) {
          break;
        }
        localObject = (adas)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((adas)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new ades(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud", this.jdField_b_of_type_Adis$a);
        }
        this.cDW = 0;
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", localException);
      }
    } while (this.bMl);
    this.mHandler.post(new ArConfigService.11(this));
    this.bMl = true;
    return;
    this.cDW = 100;
  }
  
  private void cQR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSDK2SoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal,mApp is null! ");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        this.bMo = adS();
        if (this.bMo) {
          break;
        }
        localObject = (adas)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((adas)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new ades(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2", this.jdField_a_of_type_Adis$a);
        }
        this.cDX = 0;
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal fail!", localException);
      }
    } while (this.bMl);
    this.mHandler.post(new ArConfigService.12(this));
    this.bMl = true;
    return;
    this.cDX = 100;
  }
  
  private void cQS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess ");
    }
    if (this.f != null) {}
    try
    {
      int j = this.f.beginBroadcast();
      int i = 0;
      while (i < j) {
        try
        {
          ((adgo)this.f.getBroadcastItem(i)).cPS();
          i += 1;
        }
        catch (Exception localException1) {}
      }
      this.f.finishBroadcast();
      return;
    }
    catch (Exception localException2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess fail!", localException2);
    }
  }
  
  private void cQT()
  {
    if (this.f != null) {}
    try
    {
      int j = this.f.beginBroadcast();
      int i = 0;
      while (i < j) {
        try
        {
          ((adgo)this.f.getBroadcastItem(i)).cPT();
          i += 1;
        }
        catch (Exception localException1) {}
      }
      this.f.finishBroadcast();
      return;
    }
    catch (Exception localException2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadFail fail!", localException2);
    }
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    boolean bool2 = false;
    paramAppRuntime = (afes)((afem)paramAppRuntime.getManager(77)).a("qq.android.ar.native.so_v8.3.6");
    boolean bool3;
    int i;
    if (paramAppRuntime != null)
    {
      bool3 = paramAppRuntime.isSuccess();
      i = paramAppRuntime.getVersion();
      if ((!paramAppRuntime.isSuccess()) || (i <= 0)) {
        break label140;
      }
    }
    label140:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool4 = adeq.kR("ArMapEngine836");
      bool2 = bool1 & bool4;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, String.format("isArSoDownload isSuccess=%s version=%s fileExist = %s result=%s ", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool2) }));
      }
      QLog.d("ArConfig_ArConfigService", 1, "isArSoDownload ArNativeSoDownloadHandler so ready:=" + bool2);
      return bool2;
    }
  }
  
  public static boolean e(AppRuntime paramAppRuntime)
  {
    adgv localadgv = adgt.a();
    if (localadgv == null) {
      return true;
    }
    Object localObject = (adas)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((adas)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label118;
        }
        bool = new ades((QQAppInterface)paramAppRuntime).b(((ARCommonConfigInfo)localObject).nativeSoResList, localadgv.getKey());
      }
      catch (Exception paramAppRuntime)
      {
        for (;;)
        {
          QLog.e("ArConfig_ArConfigService", 1, "isARCoreSoDownload fail!", paramAppRuntime);
          boolean bool = false;
          continue;
          bool = false;
        }
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isARCoreSoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    label118:
    return false;
  }
  
  public static boolean f(AppRuntime paramAppRuntime)
  {
    return true;
  }
  
  public static boolean g(AppRuntime paramAppRuntime)
  {
    Object localObject = (adas)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((adas)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new ades((QQAppInterface)paramAppRuntime).b(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud");
      }
      catch (Exception paramAppRuntime)
      {
        for (;;)
        {
          QLog.e("ArConfig_ArConfigService", 1, "isArCloudSoDownload fail!", paramAppRuntime);
          boolean bool = false;
          continue;
          bool = false;
        }
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isArCloudSoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    label105:
    return false;
  }
  
  public static boolean h(AppRuntime paramAppRuntime)
  {
    return (adO()) && (g(paramAppRuntime)) && (i(paramAppRuntime)) && (e(paramAppRuntime));
  }
  
  public static boolean i(AppRuntime paramAppRuntime)
  {
    Object localObject = (adas)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((adas)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new ades((QQAppInterface)paramAppRuntime).b(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2");
      }
      catch (Exception paramAppRuntime)
      {
        for (;;)
        {
          QLog.e("ArConfig_ArConfigService", 1, "isArSDK2SoDownload fail!", paramAppRuntime);
          boolean bool = false;
          continue;
          bool = false;
        }
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isArSDK2SoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    label105:
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "onBind");
    }
    return this.jdField_a_of_type_Adgj$a;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "onCreate, " + this);
    }
    QQAppInterface localQQAppInterface;
    if ((this.app instanceof QQAppInterface))
    {
      this.weakApp = new WeakReference((QQAppInterface)this.app);
      localQQAppInterface = (QQAppInterface)this.weakApp.get();
      if (localQQAppInterface == null) {
        QLog.d("ArConfig_ArConfigService", 1, "onCreate,mApp is null! ");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Adex = ((adex)localQQAppInterface.getManager(168));
    if (this.jdField_a_of_type_Adex != null) {
      this.jdField_a_of_type_Adex.a(this.jdField_a_of_type_Adfh);
    }
    this.jdField_b_of_type_Adas = ((adas)localQQAppInterface.getManager(220));
    if (this.jdField_b_of_type_Adas != null) {
      this.jdField_b_of_type_Adas.a(this.jdField_a_of_type_Adfh);
    }
    adfa.a(new adeg(this));
    adjr.a(new adeh(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "onDestroy, " + this);
    }
    this.jdField_c_of_type_AndroidOsRemoteCallbackList.kill();
    this.jdField_d_of_type_AndroidOsRemoteCallbackList.kill();
    this.jdField_c_of_type_AndroidOsRemoteCallbackList = null;
    this.jdField_d_of_type_AndroidOsRemoteCallbackList = null;
    this.e.kill();
    this.e = null;
    this.weakApp = null;
    adfa.clearCallback();
    adjr.clearCallback();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Adex != null) {
      this.jdField_a_of_type_Adex.b(this.jdField_a_of_type_Adfh);
    }
    return super.onUnbind(paramIntent);
  }
  
  static class a
    extends adgj.a
  {
    WeakReference<ArConfigService> gm;
    
    public a(ArConfigService paramArConfigService)
    {
      QLog.d("ArConfig_ArConfigService", 1, "ArConfigManagerStub constructor");
      this.gm = new WeakReference(paramArConfigService);
    }
    
    public void KL(int paramInt)
      throws RemoteException
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "downloadFaceResource error arConfigService is null");
      }
      while (!(ArConfigService.a(localArConfigService) instanceof QQAppInterface)) {
        return;
      }
      adfa.e(paramInt, (QQAppInterface)ArConfigService.b(localArConfigService));
    }
    
    public void KM(int paramInt)
      throws RemoteException
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "downloadMiniResource error arConfigService is null");
      }
      while (!(ArConfigService.f(localArConfigService) instanceof QQAppInterface)) {
        return;
      }
      adjr.f(paramInt, (QQAppInterface)ArConfigService.g(localArConfigService));
    }
    
    public ArConfigInfo a()
      throws RemoteException
    {
      if (this.gm != null) {}
      for (Object localObject = (ArConfigService)this.gm.get();; localObject = null)
      {
        if (localObject == null)
        {
          QLog.d("ArConfig_ArConfigService", 1, "getArConfigInfo error arConfigService is null");
          return null;
        }
        if (((ArConfigService)localObject).a != null) {}
        for (localObject = ((ArConfigService)localObject).a.a();; localObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "getArConfigInfo | mConfigInfo = " + localObject);
          }
          return localObject;
        }
      }
    }
    
    public ArEffectConfig a()
      throws RemoteException
    {
      if (this.gm != null) {}
      for (Object localObject = (ArConfigService)this.gm.get();; localObject = null)
      {
        if (localObject == null)
        {
          QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error arConfigService is null");
          return null;
        }
        if (((ArConfigService)localObject).a != null) {}
        for (localObject = ((ArConfigService)localObject).a.b();; localObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "getArEffectConfig|mEffectConfig=" + localObject);
          }
          return localObject;
        }
      }
    }
    
    public void a(adgk paramadgk)
      throws RemoteException
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "registerFaceCallback error arConfigService is null");
      }
      while ((paramadgk == null) || (ArConfigService.b(localArConfigService) == null)) {
        return;
      }
      ArConfigService.b(localArConfigService).register(paramadgk);
    }
    
    public void a(adgm paramadgm)
      throws RemoteException
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "registerMiniCallback error arConfigService is null");
      }
      while ((paramadgm == null) || (ArConfigService.c(localArConfigService) == null)) {
        return;
      }
      ArConfigService.c(localArConfigService).register(paramadgm);
    }
    
    public void a(adgn paramadgn)
      throws RemoteException
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "registerArCallback error arConfigService is null");
      }
      while ((paramadgn == null) || (ArConfigService.a(localArConfigService) == null)) {
        return;
      }
      ArConfigService.a(localArConfigService).register(paramadgn);
    }
    
    public void a(adgo paramadgo)
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "registerArSoCallback error arConfigService is null");
      }
      while (paramadgo == null) {
        return;
      }
      ArConfigService.d(localArConfigService).register(paramadgo);
    }
    
    public boolean adU()
      throws RemoteException
    {
      if (this.gm != null) {}
      for (ArConfigService localArConfigService = (ArConfigService)this.gm.get();; localArConfigService = null)
      {
        if (localArConfigService == null)
        {
          QLog.d("ArConfig_ArConfigService", 1, "isFaceResConfigReady error arConfigService is null");
          return false;
        }
        if ((ArConfigService.c(localArConfigService) instanceof QQAppInterface))
        {
          boolean bool = adfa.al((QQAppInterface)ArConfigService.d(localArConfigService));
          if (!bool) {
            adfa.cG((QQAppInterface)ArConfigService.e(localArConfigService));
          }
          return bool;
        }
        return false;
      }
    }
    
    public boolean adV()
      throws RemoteException
    {
      if (this.gm != null) {}
      for (ArConfigService localArConfigService = (ArConfigService)this.gm.get();; localArConfigService = null)
      {
        if (localArConfigService == null)
        {
          QLog.d("ArConfig_ArConfigService", 1, "isMiniResConfigReady error arConfigService is null");
          return false;
        }
        if ((ArConfigService.h(localArConfigService) instanceof QQAppInterface))
        {
          boolean bool = adjr.a(true, (QQAppInterface)ArConfigService.i(localArConfigService));
          if (!bool) {
            adjr.a(true, (QQAppInterface)ArConfigService.j(localArConfigService));
          }
          if (!adjr.a(false, (QQAppInterface)ArConfigService.k(localArConfigService))) {
            adjr.a(false, (QQAppInterface)ArConfigService.l(localArConfigService));
          }
          return bool;
        }
        return false;
      }
    }
    
    public boolean adW()
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "isArSoReady error arConfigService is null");
        return false;
      }
      if ((ArConfigService.adT()) && (ArConfigService.a(localArConfigService)) && (ArConfigService.b(localArConfigService)) && (ArConfigService.c(localArConfigService)) && (ArConfigService.d(localArConfigService))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public boolean adX()
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "isArCoreSoReady error arConfigService is null");
        return false;
      }
      return ArConfigService.c(localArConfigService);
    }
    
    public ARCommonConfigInfo b()
      throws RemoteException
    {
      if (this.gm != null) {}
      for (Object localObject = (ArConfigService)this.gm.get();; localObject = null)
      {
        if (localObject == null)
        {
          QLog.d("ArConfig_ArConfigService", 1, "getARCommonConfigInfo error arConfigService is null");
          return null;
        }
        if (((ArConfigService)localObject).b != null) {}
        for (localObject = ((ArConfigService)localObject).b.a();; localObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", new Object[] { localObject }));
          }
          return localObject;
        }
      }
    }
    
    public void b(adgk paramadgk)
      throws RemoteException
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "unregisterFaceCallback error arConfigService is null");
      }
      while ((paramadgk == null) || (ArConfigService.b(localArConfigService) == null)) {
        return;
      }
      ArConfigService.b(localArConfigService).unregister(paramadgk);
    }
    
    public void b(adgm paramadgm)
      throws RemoteException
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "unregisterMiniCallback error arConfigService is null");
      }
      while ((paramadgm == null) || (ArConfigService.c(localArConfigService) == null)) {
        return;
      }
      ArConfigService.c(localArConfigService).unregister(paramadgm);
    }
    
    public void b(adgn paramadgn)
      throws RemoteException
    {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback");
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback error arConfigService is null");
      }
      while ((paramadgn == null) || (ArConfigService.a(localArConfigService) == null)) {
        return;
      }
      ArConfigService.a(localArConfigService).unregister(paramadgn);
    }
    
    public void b(adgo paramadgo)
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "unregisterArSoCallback error arConfigService is null");
      }
      while (paramadgo == null) {
        return;
      }
      ArConfigService.d(localArConfigService).unregister(paramadgo);
    }
    
    public void b(ArConfigInfo paramArConfigInfo)
      throws RemoteException
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "handleNewConfig error arConfigService is null");
      }
      while (localArConfigService.a == null) {
        return;
      }
      localArConfigService.a.b(paramArConfigInfo);
    }
    
    public void cQW()
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "downloadArSo error arConfigService is null");
      }
      int i;
      do
      {
        do
        {
          return;
          ArConfigService.a(localArConfigService, false);
          ArConfigService.a(localArConfigService);
          ArConfigService.b(localArConfigService);
          ArConfigService.c(localArConfigService);
          ArConfigService.d(localArConfigService);
          ArConfigService.e(localArConfigService);
        } while (ArConfigService.e(localArConfigService));
        i = (ArConfigService.a(localArConfigService) + ArConfigService.b(localArConfigService) + ArConfigService.c(localArConfigService) + ArConfigService.d(localArConfigService) + ArConfigService.e(localArConfigService)) / 5;
        ArConfigService.a(localArConfigService).post(new ArConfigService.ArConfigManagerStub.1(this, localArConfigService, i));
      } while (i != 100);
      ArConfigService.a(localArConfigService).post(new ArConfigService.ArConfigManagerStub.2(this, localArConfigService));
    }
    
    public void cQX()
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "downloadArCoreSo error arConfigService is null");
        return;
      }
      ArConfigService.d(localArConfigService);
    }
    
    public void cancelDownload()
      throws RemoteException
    {
      ArConfigService localArConfigService = null;
      if (this.gm != null) {
        localArConfigService = (ArConfigService)this.gm.get();
      }
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "cancelDownload error arConfigService is null");
      }
      while (localArConfigService.a == null) {
        return;
      }
      localArConfigService.a.a.cancelDownload();
    }
    
    public void downloadResource()
      throws RemoteException
    {
      if (this.gm != null) {}
      for (Object localObject = (ArConfigService)this.gm.get();; localObject = null)
      {
        if (localObject == null) {
          QLog.d("ArConfig_ArConfigService", 1, "downloadResource error arConfigService is null");
        }
        while (((ArConfigService)localObject).a == null) {
          return;
        }
        ((ArConfigService)localObject).a.bN(false, false);
        HashMap localHashMap = new HashMap();
        localHashMap.put("click_download", "1");
        localObject = (QQAppInterface)((ArConfigService)localObject).weakApp.get();
        if (localObject == null)
        {
          QLog.d("ArConfig_ArConfigService", 1, "downloadResource,mApp is null! ");
          return;
        }
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(((QQAppInterface)localObject).getCurrentAccountUin(), "ar_client_download_times", true, 0L, 0L, localHashMap, null);
        return;
      }
    }
    
    public void yd(int paramInt)
    {
      Object localObject = null;
      if (this.gm != null) {
        localObject = (ArConfigService)this.gm.get();
      }
      if (localObject == null) {
        QLog.d("ArConfig_ArConfigService", 1, "onToolScannerActivityStateChanged error arConfigService is null");
      }
      do
      {
        return;
        localObject = (rwg)ArConfigService.m((ArConfigService)localObject).getManager(243);
      } while (localObject == null);
      ((rwg)localObject).yd(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */