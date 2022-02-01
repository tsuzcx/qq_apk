package com.tencent.mobileqq.app;

import acce;
import accf;
import accg;
import aczq;
import aihl;
import aija;
import ajro;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import anpc;
import aolm;
import aomf;
import aopd;
import apsz;
import aqcl;
import aqgz;
import aqmq;
import aqqu;
import aqva;
import arcj;
import aved;
import avnn;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebCoreService;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import jpa;
import jpm;
import jpn;
import jql;
import jrc;
import kec;
import lcd;
import mqq.app.AppRuntime;
import mqq.app.IToolProcEventListener;
import mqq.app.MSFServlet;
import mqq.app.TicketManagerImpl;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import ykm;

public class BrowserAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public static final AtomicBoolean cA = new AtomicBoolean(false);
  public static final AtomicBoolean cz;
  public static final AtomicBoolean sTBSDownloading = new AtomicBoolean(false);
  long Pf;
  public Intent V;
  aczq jdField_a_of_type_Aczq = new aczq(this);
  protected ajro a;
  private aomf jdField_a_of_type_Aomf;
  public aqqu a;
  protected lcd a;
  private accg[] jdField_a_of_type_ArrayOfAccg = new accg[1];
  public boolean bGT = false;
  public boolean bGU;
  public boolean bGV;
  private int cuA;
  int cuy = 0;
  public int cuz = -1;
  Map<Integer, Manager> iX = new HashMap(20);
  private EntityManagerFactory mFactory;
  
  static
  {
    cz = new AtomicBoolean(false);
  }
  
  public BrowserAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public static void Dr(String paramString)
  {
    if (!cz.get())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BrowserAppInterface", 2, "try get lock from sHasRemoveLastCookies");
      }
      synchronized (cz)
      {
        if (!cz.get())
        {
          SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("qb_info", 4);
          if (QLog.isColorLevel()) {
            QLog.i("BrowserAppInterface", 2, String.format("removeLastUinCookies, last uin: %s, current uin is: %s", new Object[] { localSharedPreferences.getString("LastUIN", ""), paramString }));
          }
          if (!localSharedPreferences.getString("LastUIN", "").equals(paramString))
          {
            long l = System.currentTimeMillis();
            IE(1);
            QLog.e("BrowserAppInterface", 1, "User account changed, need remove all cookies. cost=" + (System.currentTimeMillis() - l));
            if (!TextUtils.isEmpty(paramString)) {
              localSharedPreferences.edit().putString("LastUIN", paramString).commit();
            }
          }
          cz.set(true);
        }
        return;
      }
    }
  }
  
  public static void IE(int paramInt)
  {
    String str1 = DeviceProfileManager.b().jf(DeviceProfileManager.DpcNames.RemoveSessionConfig.name());
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(str1)) {
          break label163;
        }
        i = Integer.parseInt(str1);
        if ((i & paramInt) != paramInt) {
          break label147;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          CookieSyncManager.createInstance(BaseApplicationImpl.getContext());
          if (1 == paramInt)
          {
            CookieManager.getInstance().removeAllCookie();
            CookieSyncManager.getInstance().sync();
            if (1 != paramInt) {
              break label169;
            }
            str1 = "all";
            QLog.e("BrowserAppInterface", 1, String.format("Remove %s cookies", new Object[] { str1 }));
            return;
          }
          if (2 != paramInt) {
            continue;
          }
          CookieManager.getInstance().removeSessionCookie();
          continue;
        }
        if (1 != paramInt) {
          break label132;
        }
      }
      catch (Exception localException)
      {
        QLog.e("BrowserAppInterface", 1, "Remove all cookies failed", localException);
        return;
      }
      CookieManager.getInstance().removeAllCookies(null);
      continue;
      label132:
      if (2 == paramInt)
      {
        CookieManager.getInstance().removeSessionCookies(null);
        continue;
        label147:
        if (QLog.isColorLevel()) {
          QLog.d("BrowserAppInterface", 2, "Not required remove cookies");
        }
        return;
        label163:
        i = 15;
        continue;
        label169:
        String str2 = "session";
      }
    }
  }
  
  private boolean S(Intent paramIntent)
  {
    boolean bool3 = WebProcessManager.aFR();
    int i = BaseApplicationImpl.getApplication().getRuntime().getRunningModuleSize();
    boolean bool1;
    boolean bool2;
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("qq_mode_foreground", false)))
    {
      bool1 = true;
      boolean bool4 = BaseApplicationImpl.getApplication().getRuntime().isModuleRunning("modular_web");
      if (WebAccelerateHelper.isWebViewCache) {
        break label161;
      }
      bool2 = true;
      label55:
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, String.format("qq_mode_foreground= %b, runningModuleSize: %d, isPreloadWebProcess: %b, isWebModuleExit: %b, isPreloadSucess: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool2) }));
      }
      if (!bool1) {
        break label262;
      }
      if ((!bool3) || (!bool4) || (!bool2) || (i > 1)) {
        break label167;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "don't need kill web process!");
      }
    }
    label161:
    label167:
    do
    {
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label55;
      if ((!SnapshotService.aBK()) || (this.cuA >= 10)) {
        break label235;
      }
      this.cuA += 1;
    } while (!QLog.isColorLevel());
    QLog.d("BrowserAppInterface", 2, "don't kill web process for debug snapshot, " + this.cuA + "times");
    return true;
    label235:
    if (QLog.isColorLevel()) {
      QLog.d("BrowserAppInterface", 2, "try restart web process");
    }
    this.cuA = 0;
    this.bGU = true;
    for (;;)
    {
      return false;
      label262:
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "exit web process");
      }
      if (bool3) {
        this.bGV = true;
      }
    }
  }
  
  private accg a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new kec(this);
  }
  
  private boolean c(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    String str = paramIntent.getAction();
    if (str == null) {
      return false;
    }
    QLog.e("BrowserAppInterface", 1, "exitBrowserRunTime: receiveAction: " + str);
    if (str.equals("com.tencent.process.exit"))
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      try
      {
        paramContext = paramContext.getRunningTasks(1);
        if ((paramContext != null) && (paramContext.size() >= 1))
        {
          paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
          if (QLog.isColorLevel()) {
            QLog.d("BrowserAppInterface", 2, "runningActivity=" + paramContext);
          }
          if ((paramContext != null) && (paramContext.length() > 0) && ((paramContext.contains("com.pay")) || (paramContext.contains("com.tenpay")))) {
            return true;
          }
        }
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
        if (sTBSDownloading.get())
        {
          this.bGT = true;
          this.V = paramIntent;
          return true;
        }
        paramContext = (PathTraceManager)getManager(210);
        if ((paramContext != null) && (paramContext.isRunning())) {
          return true;
        }
        if (!aihl.aoY())
        {
          int i = j;
          if (paramIntent != null)
          {
            i = j;
            if (paramIntent.getBooleanExtra("qq_mode_foreground", false)) {
              i = 1;
            }
          }
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BrowserAppInterface", 2, " has floating window， not exit tool process");
            }
            return true;
          }
        }
        return S(paramIntent);
      }
    }
    if ((str.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (str.equals("mqq.intent.action.ACCOUNT_KICKED")))
    {
      IE(1);
      return S(paramIntent);
    }
    if ((!isLogin()) && (str.equals("mqq.intent.action.ACCOUNT_EXPIRED")))
    {
      QLog.e("BrowserAppInterface", 1, "ACTION_ACCOUNT_EXPIRED, need remove all cookie: " + cA.get());
      if (cA.compareAndSet(false, true)) {
        IE(1);
      }
      return true;
    }
    return false;
  }
  
  private void cHi()
  {
    QbSdk.setTbsLogClient(new acce(this, BaseApplicationImpl.getContext()));
  }
  
  public void Ep(boolean paramBoolean)
  {
    bt(paramBoolean, false);
  }
  
  public ajro a()
  {
    if (this.jdField_a_of_type_Ajro == null) {
      this.jdField_a_of_type_Ajro = new ajro(this);
    }
    return this.jdField_a_of_type_Ajro;
  }
  
  public lcd a()
  {
    if (this.jdField_a_of_type_Lcd == null) {
      this.jdField_a_of_type_Lcd = new lcd(this);
    }
    return this.jdField_a_of_type_Lcd;
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.iX.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.iX.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public void bt(boolean paramBoolean1, boolean paramBoolean2)
  {
    downloadTbs(paramBoolean1, paramBoolean2, true);
  }
  
  public void downloadTbs(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = BaseApplication.getContext();
    if ((!paramBoolean1) && ((!AppNetConnInfo.isNetSupport()) || (!AppNetConnInfo.isWifiConn()))) {
      if (!AppNetConnInfo.isNetSupport()) {
        QbSdk.setUploadCode(BaseApplication.getContext(), 151);
      }
    }
    do
    {
      do
      {
        return;
      } while (AppNetConnInfo.isWifiConn());
      QbSdk.setUploadCode(BaseApplication.getContext(), 152);
      return;
      QbSdk.setUploadCode(BaseApplication.getContext(), 153);
      if (sTBSDownloading.compareAndSet(false, true))
      {
        QbSdk.setUploadCode(BaseApplication.getContext(), 154);
        long l = System.currentTimeMillis();
        localObject = ((Context)localObject).getSharedPreferences(((Context)localObject).getPackageName() + "_preferences", 4);
        QbSdk.setTbsListener(new accf(this, (SharedPreferences)localObject, l));
        QLog.d("TBS_update", 1, "tbs start download");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("tbs_downloading", true);
        ((SharedPreferences.Editor)localObject).remove("tbs_download_complete");
        ((SharedPreferences.Editor)localObject).remove("tbs_download_progress");
        ((SharedPreferences.Editor)localObject).commit();
        this.cuy = 0;
        if (AppNetConnInfo.isWifiConn())
        {
          QbSdk.setUploadCode(BaseApplication.getContext(), 155);
          TbsDownloader.startDownload(BaseApplication.getContext(), paramBoolean2);
          return;
        }
        TbsDownloader.startDownload(BaseApplication.getContext(), paramBoolean3);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TBS_update", 2, "tbs has started downloading");
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return 0;
  }
  
  public accg getBusinessHandler(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAccg[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAccg)
    {
      accg localaccg = this.jdField_a_of_type_ArrayOfAccg[paramInt];
      localObject1 = localaccg;
      if (localaccg == null)
      {
        localaccg = a(paramInt);
        localObject1 = localaccg;
        if (localaccg != null)
        {
          this.jdField_a_of_type_ArrayOfAccg[paramInt] = localaccg;
          localObject1 = localaccg;
        }
      }
      return localObject1;
    }
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.mFactory == null) {
      this.mFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.mFactory;
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = (Manager)this.iX.get(Integer.valueOf(paramInt));
    Object localObject4 = localObject1;
    Map localMap;
    if (localObject1 == null)
    {
      localMap = this.iX;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      try
      {
        if (this.iX.get(Integer.valueOf(paramInt)) == null) {
          break label239;
        }
        localObject4 = (Manager)this.iX.get(Integer.valueOf(paramInt));
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = super.getManager(paramInt);
        }
        return localObject1;
      }
      finally {}
      localObject1 = new aqva(this);
      continue;
      Object localObject3 = new apsz(this);
      continue;
      localObject3 = new TicketManagerImpl(this);
      continue;
      localObject3 = new aved(this);
      continue;
      localObject3 = new PathTraceManager(this);
      continue;
      localObject3 = new ykm(this);
      continue;
      localObject3 = new avnn();
      continue;
      label239:
      localObject4 = localObject3;
      if (localObject3 != null)
      {
        this.iX.put(Integer.valueOf(paramInt), localObject3);
        localObject4 = localObject3;
      }
    }
  }
  
  public String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush.GameStatusPush" };
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { jrc.class };
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public aolm getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Aomf == null) {
      this.jdField_a_of_type_Aomf = new aomf();
    }
    return this.jdField_a_of_type_Aomf.a(this, paramInt);
  }
  
  public String getVkey()
  {
    return null;
  }
  
  public void onBeforeExitProc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BrowserAppInterface", 2, "onBeforeExitProc, now it will exit web process!");
    }
    boolean bool = WebProcessManager.aFR();
    WebProcessManager.Ta(false);
    if (this.bGU)
    {
      this.bGU = false;
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.webprocess.restart_web_process");
      localIntent.putExtra("isPreloadWebProcess", bool);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
    while (!this.bGV) {
      return;
    }
    this.bGV = false;
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.report");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    aqmq.track(null, "web_browserAppinterface_onCreate");
    super.onCreate(paramBundle);
    this.Pf = System.currentTimeMillis();
    try
    {
      if (Build.VERSION.SDK_INT >= 28) {
        android.webkit.WebView.setDataDirectorySuffix("tool");
      }
      arcj.a(this);
      cHi();
      str = getAccount();
      if (TextUtils.isEmpty(str))
      {
        paramBundle = null;
        QbSdk.setCurrentID(paramBundle);
        jpa.a(new jql());
        jpa.a(new jpn());
        jpa.a(new jpm());
        jpa.setApplicationContext(BaseApplicationImpl.getContext());
        if (getLongAccountUin() % 10L != 6L) {
          break label261;
        }
        bool = true;
        jpa.aba = bool;
        if (!cz.get())
        {
          if (QLog.isColorLevel()) {
            QLog.i("BrowserAppInterface", 2, "BrowserAppInterface.onCreate: try removeLastUinCookies!");
          }
          ThreadManager.getSubThreadHandler().post(new BrowserAppInterface.1(this, str));
        }
        paramBundle = BaseApplication.getContext().getSharedPreferences("webview_report_config", 0);
        if (!paramBundle.getBoolean("is_set", false)) {
          paramBundle.edit().putBoolean("hide_back_text", true).putBoolean("is_set", true).commit();
        }
        arbz.auH = SystemClock.elapsedRealtime();
        aqmq.track("web_browserAppinterface_onCreate", null);
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        String str;
        QLog.e("BrowserAppInterface", 1, "setDataDirectorySuffix error");
        continue;
        paramBundle = "QQ:" + str;
        continue;
        label261:
        boolean bool = false;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ajro != null) {}
    try
    {
      this.jdField_a_of_type_Ajro.onDestroy();
      this.jdField_a_of_type_Ajro = null;
      if (this.jdField_a_of_type_Aomf != null) {
        this.jdField_a_of_type_Aomf.onDestroy();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_Aomf.onDestroy();
        this.jdField_a_of_type_Aomf = null;
        synchronized (this.iX)
        {
          Object localObject1 = this.iX.keySet();
          if ((localObject1 == null) || (((Set)localObject1).size() <= 0)) {
            break label196;
          }
          localObject1 = ((Set)localObject1).iterator();
          do
          {
            for (;;)
            {
              boolean bool = ((Iterator)localObject1).hasNext();
              if (!bool) {
                break label196;
              }
              try
              {
                Manager localManager = (Manager)this.iX.get(((Iterator)localObject1).next());
                if (localManager != null) {
                  localManager.onDestroy();
                }
              }
              catch (Exception localException3)
              {
                localException3.printStackTrace();
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("BrowserAppInterface", 2, "onDesotry", localException3);
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
        label196:
        this.iX.clear();
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAccg)
      {
        accg[] arrayOfaccg2 = this.jdField_a_of_type_ArrayOfAccg;
        int j = arrayOfaccg2.length;
        i = 0;
        if (i < j)
        {
          accg localaccg = arrayOfaccg2[i];
          if (localaccg != null) {
            localaccg.onDestroy();
          }
        }
        else
        {
          if (aopd.a != null) {
            aopd.a().aoq();
          }
          aija.dsH();
          UiApiPlugin.unRegisterReceiver();
          if (this.jdField_a_of_type_Lcd != null) {
            this.jdField_a_of_type_Lcd.aEL();
          }
          return;
        }
      }
      i += 1;
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BrowserAppInterface", 2, "onReceiveAccountAction");
    }
    return c(BaseApplicationImpl.getContext(), paramIntent);
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BrowserAppInterface", 2, "onReceiveLegalExitProcAction");
    }
    return c(BaseApplicationImpl.getContext(), paramIntent);
  }
  
  public void onRunningBackground()
  {
    super.onRunningBackground();
    boolean bool = com.tencent.smtt.sdk.WebView.getTbsNeedReboot();
    if (QLog.isColorLevel()) {
      QLog.d("BrowserAppInterface", 2, "tbs need reboot: " + bool);
    }
    if (bool) {
      getHandler(BrowserAppInterface.class).postDelayed(new BrowserAppInterface.4(this), 3000L);
    }
    if ((WebCoreService.isRunning) && (aqgz.getSystemAvaialbeMemory() >>> 20 < 20L)) {
      WebCoreService.egr();
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_totalMem", String.valueOf(aqgz.getSystemTotalMemory()));
      localHashMap.put("param_availableMem", String.valueOf(aqgz.getSystemAvaialbeMemory()));
      localHashMap.put("param_cpuNum", String.valueOf(aqgz.getCpuNumber()));
      localHashMap.put("param_cpuFreq", String.valueOf(aqgz.getCpuFrequency()));
      localHashMap.put("param_releaseType", String.valueOf(1));
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "releaseWebCoreServiceReport:" + localHashMap.toString());
      }
      anpc.a(getApplication()).collectPerformance(getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onRunningForeground()
  {
    super.onRunningForeground();
    this.bGT = false;
    this.V = null;
    aqcl.fu(getApp());
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Aczq.g(paramToServiceMsg);
  }
  
  public class TBSLogRunnable
    implements Runnable
  {
    String SI = null;
    
    public TBSLogRunnable(String paramString)
    {
      this.SI = paramString;
    }
    
    public void run()
    {
      if (!TextUtils.isEmpty(this.SI)) {
        QQToast.a(BrowserAppInterface.this.getApp(), this.SI, 1).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface
 * JD-Core Version:    0.7.0.1
 */