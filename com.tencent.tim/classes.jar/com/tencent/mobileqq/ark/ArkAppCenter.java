package com.tencent.mobileqq.ark;

import adph;
import adqb;
import adqb.a;
import adqk;
import adql;
import adqm;
import adqn;
import adqo;
import adqp;
import adqr;
import adqv;
import adqw;
import adqy;
import adrc;
import adsm;
import adta;
import adtr;
import adtu;
import aeix;
import aeix.e;
import aeiy;
import aeje.h;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anot;
import aurl;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Locale;
import mqq.manager.Manager;
import wyw;

public class ArkAppCenter
  implements Manager
{
  public static volatile boolean bQl;
  public static volatile boolean bQm;
  private static boolean bQn;
  private static boolean bQo = BaseApplicationImpl.getApplication().getSharedPreferences("arkappmsg_entry", 4).getBoolean("arkapp_pa_nshow", bQo);
  private static boolean bQp;
  static boolean bQq;
  private static String bve;
  private static double cq;
  private static double cr;
  private adph jdField_a_of_type_Adph;
  private adqb jdField_a_of_type_Adqb;
  private adqv jdField_a_of_type_Adqv;
  private adqy jdField_a_of_type_Adqy;
  private adrc jdField_a_of_type_Adrc;
  private adtr jdField_a_of_type_Adtr;
  private adtu jdField_a_of_type_Adtu;
  private ProxyChangeNotifier jdField_a_of_type_ComTencentMobileqqArkArkAppCenter$ProxyChangeNotifier = new ProxyChangeNotifier(null);
  private INetInfoHandler b = new adqk(this);
  private final int cJa = 0;
  private final int cJb = 1;
  private final int cJc = 2;
  private WeakReference<QQAppInterface> gj;
  
  static
  {
    adta.GI(true);
    adta.cUm();
  }
  
  public ArkAppCenter(QQAppInterface paramQQAppInterface)
  {
    cTI();
    this.gj = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Adqb = new adqb(paramQQAppInterface);
    this.jdField_a_of_type_Adrc = new adrc(paramQQAppInterface);
    this.jdField_a_of_type_Adqv = new adqv(paramQQAppInterface.getCurrentAccountUin());
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.b);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PROXY_CHANGE");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter$ProxyChangeNotifier, localIntentFilter);
    this.jdField_a_of_type_Adph = new adph(this);
    this.jdField_a_of_type_Adqy = new adqy(paramQQAppInterface);
    this.jdField_a_of_type_Adtr = new adtr(paramQQAppInterface);
    this.jdField_a_of_type_Adtu = new adtu(paramQQAppInterface);
  }
  
  public static void GH(boolean paramBoolean) {}
  
  public static void GK(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        bQo = "1".equalsIgnoreCase(paramString);
        BaseApplicationImpl.getApplication().getSharedPreferences("arkappmsg_entry", 4).edit().putBoolean("arkapp_pa_nshow", bQo).apply();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        r("ArkApp", "updatePANShowSwitch, value = null");
      }
      if (paramString == null) {
        continue;
      }
      r("ArkApp", "updatePANShowSwitch, value = " + paramString);
      return;
      bQo = false;
    }
  }
  
  private void I(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2)
    {
      wyw.setArkHttpProxy();
      return;
    }
    wyw.clearArkHttpProxy();
  }
  
  public static ArkDispatchTask a()
  {
    setupArkEnvironment(true);
    return ArkDispatchTask.getInstance();
  }
  
  private static boolean aK(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool = false;
    }
    do
    {
      return bool;
      paramString1 = new File(paramString1, paramString2);
    } while ((paramString1 != null) && (paramString1.exists()) && (paramString1.isFile()));
    QLog.d("ArkApp", 1, "load lib " + paramString2 + " NOT exist.");
    return false;
  }
  
  public static void ad(Runnable paramRunnable)
  {
    a().post("logicqueue", paramRunnable);
  }
  
  public static boolean afs()
  {
    return bQq;
  }
  
  public static boolean aft()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ArkApp", 4, "isPANonShow,  bRet = " + bQo);
    }
    return (bQo) || (!ArkUtil.isDeviceSupportArkMsg());
  }
  
  public static boolean afu()
  {
    String str = adsm.sV();
    if (aK(str, "libjsc_ark.so"))
    {
      ark.arkSetLibraryPath(str, "libjsc_ark.so");
      if (QLog.isDevelopLevel()) {
        QLog.i("ArkApp", 4, "InitJSCLibPath with debug libjsc_ark.so ");
      }
      return true;
    }
    str = aurl.jg();
    if (str == null)
    {
      QLog.d("ArkApp", 1, "InitJSCLibPath folder path is null.");
      return false;
    }
    ark.arkSetLibraryPath(str, "libjsc.so");
    QLog.i("ArkApp", 4, "InitJSCLibPath with  libjsc.so");
    return true;
  }
  
  public static boolean afv()
  {
    if (aK(adsm.sV(), "libjsc_ark.so")) {}
    String str;
    do
    {
      return true;
      str = aurl.jg();
      if (str == null)
      {
        QLog.d("ArkApp", 1, "isJSCLibExist folder path is null.");
        return false;
      }
    } while (aK(str, "libjsc.so"));
    return false;
  }
  
  public static double[] c()
  {
    if (!bQp) {
      return null;
    }
    return new double[] { cq, cr };
  }
  
  private void cTI()
  {
    Object localObject = aeiy.b(380).a();
    if ((localObject != null) && (((aeix.e)localObject).a() != null))
    {
      QLog.d("ArkApp", 1, "ArkSafe.initGlobalWhiteListAndUrlCheckStatus.loadConfig content = " + ((aeix.e)localObject).getContent());
      localObject = ((aeix.e)localObject).a();
      ArkAppConfigMgr.getInstance().initGlobalWhiteListAndUrlCheckStatus(((aeje.h)localObject).bUl, ((aeje.h)localObject).vC, ((aeje.h)localObject).eZ);
    }
  }
  
  public static void cTK()
  {
    r("ArkApp", "cleanArkAppCache");
    cTL();
    cTN();
  }
  
  public static void cTL()
  {
    int i = 0;
    File localFile = new File(ArkEnvironmentManager.getInstance().getCacheDirectory());
    File[] arrayOfFile = localFile.listFiles(new adql());
    if (arrayOfFile != null)
    {
      r("ArkApp", String.format(Locale.CHINA, "cleanWebCache, count=%d, path=%s", new Object[] { Integer.valueOf(arrayOfFile.length), localFile.getAbsolutePath() }));
      int j = arrayOfFile.length;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public static void cTM()
  {
    new File(ArkEnvironmentManager.getInstance().getStorageDirectory() + "/storage.db").delete();
  }
  
  public static void cTN()
  {
    String str = ArkEnvironmentManager.getInstance().getResDirectory();
    String[] arrayOfString = new File(str).list();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int i = 0;
      while (i < arrayOfString.length)
      {
        File localFile = new File(str + "/" + arrayOfString[i]);
        if (localFile.isDirectory())
        {
          File[] arrayOfFile = localFile.listFiles();
          if (arrayOfFile != null)
          {
            r("ArkApp", String.format(Locale.CHINA, "cleanAppRes, count=%d, path=%s", new Object[] { Integer.valueOf(arrayOfFile.length), localFile.getAbsolutePath() }));
            int j = 0;
            while (j < arrayOfFile.length)
            {
              arrayOfFile[j].delete();
              j += 1;
            }
          }
        }
        else
        {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public static void cTO()
  {
    if ((bQm) || (!ArkUtil.sARMv7Compatible)) {}
    do
    {
      return;
      if ((!bQm) && (ArkUtil.sARMv7Compatible))
      {
        long l1 = System.currentTimeMillis();
        UpdateArkSo.ad(BaseApplicationImpl.getContext(), UpdateArkSo.Ah());
        bQm = UpdateArkSo.af(BaseApplicationImpl.getContext(), "ark");
        long l2 = System.currentTimeMillis();
        QLog.d("ArkApp", 1, "load libark.so for ARMv7!, loaded=" + Boolean.toString(bQm) + ", time=" + (l2 - l1));
      }
    } while (bQn);
    bQn = true;
    if (bQm)
    {
      afu();
      return;
    }
    anot.a(null, "CliOper", "", "", "0X8006365", "ark.lib.load.fail", 1, 1, "1", "1", Build.CPU_ABI, Build.CPU_ABI2);
  }
  
  public static void cl(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putString("big_brother_source_key", "biz_src_jc_ark");
    }
  }
  
  public static void dn(Intent paramIntent)
  {
    r(paramIntent, null);
  }
  
  public static boolean f(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    setupArkEnvironment(true);
    return ark.arkNotify(paramString1, paramString2, paramString3, paramString4);
  }
  
  public static void i(Runnable paramRunnable, long paramLong)
  {
    a().postDelayed("logicqueue", paramRunnable, paramLong);
  }
  
  public static void o(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static void q(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  public static void r(Intent paramIntent, String paramString)
  {
    if (paramIntent != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "biz_src_jc_ark";
      }
      paramIntent.putExtra("big_brother_source_key", str);
    }
  }
  
  public static void r(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public static String sM()
  {
    return bve;
  }
  
  public static String sN()
  {
    return adqw.a().sS();
  }
  
  public static String sO()
  {
    return adqw.a().sO();
  }
  
  public static String sP()
  {
    String str = adqw.a().sT();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static void setupArkEnvironment(boolean paramBoolean)
  {
    Object localObject1 = ArkEnvironmentManager.getInstance();
    if (!bQl) {}
    for (;;)
    {
      try
      {
        if (!bQl)
        {
          ((ArkEnvironmentManager)localObject1).setThreadCreator(new adqm());
          ((ArkEnvironmentManager)localObject1).setLogCallback(new adqn());
          ((ArkEnvironmentManager)localObject1).setLibraryLoader(new adqo());
          ((ArkEnvironmentManager)localObject1).setDebugFlag(false);
          ((ArkEnvironmentManager)localObject1).setProfilingLogFlag(true);
          ((ArkEnvironmentManager)localObject1).setDataReport(new adqp());
          bQl = true;
        }
        if ((paramBoolean) && (!bQm))
        {
          ((ArkEnvironmentManager)localObject1).loadLibrary();
          if (bQm)
          {
            boolean bool1 = adph.afo();
            ark.SetUseAndroidHTTP(bool1);
            boolean bool2 = adph.afp();
            ark.arkSetAndroid9EmojiFeatureSupport(bool2);
            if (BaseApplicationImpl.getContext() != null)
            {
              localObject1 = adqr.m;
              ark.arkSetScreenSize(((DisplayMetrics)localObject1).widthPixels / ((DisplayMetrics)localObject1).density, ((DisplayMetrics)localObject1).heightPixels / ((DisplayMetrics)localObject1).density);
            }
            boolean bool3 = "true".equals(adph.jT("ark_engine_multi_thread"));
            localObject1 = ArkEnvironmentManager.getInstance();
            if (bool3) {
              break label244;
            }
            paramBoolean = true;
            ((ArkEnvironmentManager)localObject1).setSingleThreadMode(paramBoolean);
            ArkEnvironmentManager.getInstance().setThreadMode();
            r("ArkApp", String.format("setupArkEnvironment, https=%s, multithreads=%s, supportAndroid9EmojiFeature=%s", new Object[] { Boolean.toString(bool1), Boolean.toString(bool3), Boolean.toString(bool2) }));
          }
        }
        return;
      }
      finally {}
      label244:
      paramBoolean = false;
    }
  }
  
  public adph a()
  {
    return this.jdField_a_of_type_Adph;
  }
  
  public adqb a()
  {
    return this.jdField_a_of_type_Adqb;
  }
  
  public adqy a()
  {
    return this.jdField_a_of_type_Adqy;
  }
  
  public adrc a()
  {
    return this.jdField_a_of_type_Adrc;
  }
  
  public adtr a()
  {
    return this.jdField_a_of_type_Adtr;
  }
  
  public adtu a()
  {
    return this.jdField_a_of_type_Adtu;
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)this.gj.get();
  }
  
  public boolean a(String paramString, Object paramObject, adqb.a parama)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    this.jdField_a_of_type_Adqb.a(paramString, paramObject, parama);
    return true;
  }
  
  public void cTJ()
  {
    ArkAppMgr.getInstance().updateInstalledApps();
    if (this.jdField_a_of_type_Adph != null) {
      this.jdField_a_of_type_Adph.cTA();
    }
  }
  
  public QQAppInterface getAppInterface()
  {
    return (QQAppInterface)this.gj.get();
  }
  
  public void onDestroy()
  {
    ArkAppMgr.getInstance().onDestroy();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.b);
      localQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter$ProxyChangeNotifier);
    }
  }
  
  static final class ProxyChangeNotifier
    extends BroadcastReceiver
    implements Runnable
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.PROXY_CHANGE".equals(paramIntent.getAction()))
      {
        ArkAppCenter.r("ArkApp", "receive broadcast proxy change.");
        ThreadManager.executeOnSubThread(this);
      }
    }
    
    public void run()
    {
      if (AppNetConnInfo.isWifiConn())
      {
        wyw.setArkHttpProxy();
        return;
      }
      wyw.clearArkHttpProxy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenter
 * JD-Core Version:    0.7.0.1
 */