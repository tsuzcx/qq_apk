package com.tencent.mobileqq.webprocess;

import acbw;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import anot;
import anpc;
import aqgz;
import aqiw;
import aqmc;
import aqmk;
import aqyd;
import aqye;
import aqyf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jqo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class WebProcessManager
  implements Manager
{
  protected static boolean cWY;
  private static int edG = -1;
  private static final AtomicBoolean ex = new AtomicBoolean(false);
  public static final ConcurrentHashMap<String, Integer> jh = new ConcurrentHashMap();
  public static HashMap<String, String> pw = new HashMap();
  protected QQAppInterface app;
  protected long auc;
  private final acbw b = new aqyf(this);
  private final BroadcastReceiver bE = new aqye(this);
  private boolean cWX;
  protected boolean lm;
  protected BroadcastReceiver mReceiver = new aqyd(this);
  
  public WebProcessManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    egs();
    registerReceiver();
    this.auc = (aqgz.getSystemTotalMemory() / 1048576L);
  }
  
  public static void E(List<String> paramList, String paramString)
  {
    if (!rJ(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "begin to parse dns,isNeedPreparseDns = " + edG);
    }
    bw(paramString, System.currentTimeMillis());
    ThreadManager.post(new WebProcessManager.6(paramList), 5, null, true);
  }
  
  public static void SZ(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload", paramBoolean).commit();
  }
  
  public static void Ta(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload_web_process", paramBoolean).commit();
  }
  
  public static void Tb(boolean paramBoolean)
  {
    cWY = paramBoolean;
  }
  
  public static void Yd(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "preloadWebProcess");
    }
    try
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CrashControl_com.tencent.mobileqq:web", 4);
      if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("allowpreload", true)))
      {
        long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
        int i = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
        long l2 = System.currentTimeMillis();
        if ((l1 <= 0L) || (i <= 0) || (l2 <= l1) || (l2 - l1 <= i * 1000)) {
          break label198;
        }
        ((SharedPreferences)localObject).edit().putBoolean("allowpreload", true).commit();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.printStackTrace();
      }
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("from", paramInt);
    ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
    BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "Send preload web process broadcast...");
    }
    return;
    label198:
    QLog.d("WebProcessManager", 1, "preloadWebProcess is not allowed as crash frequently.");
    Ta(false);
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actNoPreloadWeb", true, 0L, 0L, null, "");
  }
  
  public static boolean aFQ()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload", false);
  }
  
  public static boolean aFR()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload_web_process", false);
  }
  
  public static boolean aFS()
  {
    jqo.le("Web_Module_Check_Is_Exit");
    boolean bool = QIPCServerHelper.getInstance().isModuleRunning("modular_web");
    jqo.lf("Web_Module_Check_Is_Exit");
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "Web module is exist: " + bool);
    }
    return bool;
  }
  
  public static long bh(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("health_dns_profile", aqmc.dw()).getLong(paramString, -1L);
  }
  
  public static long bi(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("vip_dns_profile", aqmc.dw()).getLong(paramString, -1L);
  }
  
  public static long bj(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("vip_gamecenter_profile", aqmc.dw()).getLong(paramString, -1L);
  }
  
  public static void bt(String paramString, long paramLong)
  {
    int i = aqmc.dw();
    BaseApplicationImpl.getApplication().getSharedPreferences("health_dns_profile", i).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void bu(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("vip_dns_profile", aqmc.dw()).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void bv(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("vip_gamecenter_profile", aqmc.dw()).edit().putLong(paramString, paramLong).commit();
  }
  
  private static void bw(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("dns_profile", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  private static void bx(String paramString, long paramLong)
  {
    int i = 0;
    try
    {
      int j = aqiw.getSystemNetwork(BaseApplicationImpl.getApplication());
      i = j;
    }
    catch (Exception localException)
    {
      label13:
      String str;
      break label13;
    }
    switch (i)
    {
    default: 
      str = "";
    }
    try
    {
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("net_state", str);
        localHashMap.put("current_url", paramString);
        localHashMap.put("time_used", String.valueOf(paramLong));
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "dns_parse_time", true, paramLong, 1L, localHashMap, "", false);
        VasWebviewUtil.reportVasStatus("dns_parse_time", "", paramString, 0, 0, (int)paramLong, 0, str, "");
        return;
        str = "2G";
        continue;
        str = "3G";
        continue;
        str = "4G";
        continue;
        str = "wifi";
      }
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("WebProcessManager", 2, "report dns parse time error=" + paramString.toString());
      return;
    }
  }
  
  private static Long c(String paramString)
  {
    return Long.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("dns_profile", 0).getLong(paramString, 0L));
  }
  
  public static void egr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "stop web core service");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.stop_web_core_service");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
  }
  
  public static void egw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "releaseHalfToolProcess, send release tool process broadcast!");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.release_tool_process");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
  }
  
  public static long g(String paramString1, String paramString2)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("business_click_profile", aqmc.dw()).getLong(paramString1 + "_" + paramString2, -1L);
  }
  
  public static void iy(String paramString1, String paramString2)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("business_click_profile", aqmc.dw()).edit().putLong(paramString1 + "_" + paramString2, System.currentTimeMillis()).commit();
  }
  
  public static boolean rJ(String paramString)
  {
    if (edG == 0) {}
    long l;
    do
    {
      return false;
      l = c(paramString).longValue();
    } while ((l != 0L) && (System.currentTimeMillis() - l <= 600000L));
    return true;
  }
  
  public boolean U(ArrayList<SonicPreloadData> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {}
    do
    {
      do
      {
        return false;
      } while (!SonicPreloader.isWifiOrG3OrG4());
      if (aFS())
      {
        Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), WebProcessReceiver.class);
        localIntent.setAction("action_preload_sonic_session");
        localIntent.putParcelableArrayListExtra("com.tencent.mobileqq.webprocess.sonic_preload_data", paramArrayList);
        try
        {
          BaseApplicationImpl.getApplication().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
          return true;
        }
        catch (Exception paramArrayList)
        {
          QLog.e("WebProcessManager", 2, "preloadSonicSession, sendBroadcast exception, e = ", paramArrayList);
          return false;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebProcessManager", 2, "preloadSonicSession, web process not exists");
    return false;
  }
  
  public void Yc(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt, a parama)
  {
    if (ex.compareAndSet(false, true)) {
      ThreadManager.excute(new WebProcessPreloadJob(paramInt, parama), 128, null, false);
    }
    while (parama == null) {
      return;
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      parama.onResult(false);
      return;
    }
    ThreadManager.excute(new WebProcessManager.1(this, parama), 128, null, false);
  }
  
  public boolean aFT()
  {
    Integer localInteger = (Integer)jh.get("key_preload_strategy");
    if ((localInteger != null) && (localInteger.intValue() == 2))
    {
      localInteger = (Integer)jh.get("key_preload_flag");
      if ((localInteger != null) && (localInteger.intValue() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessManager", 2, "is need prload, totalMemSize = " + this.auc + "M");
        }
        localInteger = (Integer)jh.get("key_red_ram");
        if ((localInteger != null) && (this.auc > localInteger.intValue())) {
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else
    {
      return aFV();
    }
    return false;
  }
  
  public boolean aFU()
  {
    Integer[] arrayOfInteger = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
    if ((arrayOfInteger != null) && (arrayOfInteger[9].intValue() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebProcessManager", 2, "now enable preload tool process for public account!");
      }
      return true;
    }
    QLog.e("WebProcessManager", 1, "can not preload tool process for public account!");
    return false;
  }
  
  protected boolean aFV()
  {
    return true;
  }
  
  public void aca()
  {
    if (aFQ())
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "isPreloadSucess");
      }
      anot.b(null, "P_CliOper", "Vip", "", "0X8004874", "0X8004874", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      SZ(false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "isPreloadFail");
      }
      anot.b(null, "P_CliOper", "Vip", "", "0X8004875", "0X8004875", 0, 1, 0, "", "", "", "");
    }
  }
  
  public void egs()
  {
    jh.clear();
    pw.clear();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
    Object localObject = aqmk.a(localSharedPreferences, "key_web_plugin_list" + this.app.getCurrentAccountUin(), null);
    if ((localObject != null) && (!((Set)localObject).isEmpty()))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        pw.put(str, str);
      }
    }
    jh.put("key_preload_strategy", Integer.valueOf(localSharedPreferences.getInt("key_preload_strategy" + this.app.getCurrentAccountUin(), 1)));
    localObject = jh;
    if (localSharedPreferences.getBoolean("key_preload_flag" + this.app.getCurrentAccountUin(), false)) {}
    for (int i = 1;; i = 0)
    {
      ((ConcurrentHashMap)localObject).put("key_preload_flag", Integer.valueOf(i));
      jh.put("key_red_ram", Integer.valueOf(localSharedPreferences.getInt("key_red_ram" + this.app.getCurrentAccountUin(), 512)));
      jh.put("key_click_ram", Integer.valueOf(localSharedPreferences.getInt("key_click_ram" + this.app.getCurrentAccountUin(), 1024)));
      return;
    }
  }
  
  public void egt()
  {
    if ((cWY) && (aFT())) {
      egu();
    }
  }
  
  public void egu()
  {
    Yc(-1);
  }
  
  public void egv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "restartWebProcess");
    }
    new Handler().postDelayed(new WebProcessManager.2(this), 800L);
  }
  
  public void onDestroy()
  {
    unregisterReceiver();
  }
  
  public boolean rI(String paramString)
  {
    boolean bool1;
    if (pw.isEmpty())
    {
      Object localObject = aqmk.a(BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4), "key_web_plugin_list" + this.app.getCurrentAccountUin(), null);
      boolean bool2 = false;
      bool1 = bool2;
      if (localObject == null) {
        break label137;
      }
      bool1 = bool2;
      if (((Set)localObject).isEmpty()) {
        break label137;
      }
      localObject = ((Set)localObject).iterator();
      bool1 = false;
      if (!((Iterator)localObject).hasNext()) {
        return bool1;
      }
      String str = (String)((Iterator)localObject).next();
      pw.put(str, str);
      if (!str.equals(paramString)) {
        break label139;
      }
      bool1 = true;
    }
    label137:
    label139:
    for (;;)
    {
      break;
      bool1 = pw.containsKey(paramString);
      return bool1;
    }
    return bool1;
  }
  
  protected void registerReceiver()
  {
    if ((this.mReceiver != null) && (!this.lm)) {
      this.lm = true;
    }
    try
    {
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.restart_web_process");
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.report");
      BaseApplicationImpl.getContext().registerReceiver(this.mReceiver, localIntentFilter);
      if (!this.cWX) {
        this.cWX = true;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.mobileqq.babyq.add");
          BaseApplicationImpl.getContext().registerReceiver(this.bE, localIntentFilter);
          this.app.addObserver(this.b);
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  public void unregisterReceiver()
  {
    if ((this.mReceiver != null) && (this.lm)) {}
    try
    {
      this.lm = false;
      BaseApplicationImpl.getContext().unregisterReceiver(this.mReceiver);
      if (!this.cWX) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.cWX = false;
          BaseApplicationImpl.getContext().unregisterReceiver(this.bE);
          this.app.removeObserver(this.b);
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  static class WebProcessPreloadJob
    implements Runnable
  {
    int from;
    WeakReference<WebProcessManager.a> listener;
    
    WebProcessPreloadJob(int paramInt, WebProcessManager.a parama)
    {
      this.from = paramInt;
      this.listener = new WeakReference(parama);
    }
    
    public void run()
    {
      WebProcessManager.a locala = (WebProcessManager.a)this.listener.get();
      if (!WebProcessManager.aFS())
      {
        WebProcessManager.Ta(true);
        WebProcessManager.SZ(false);
        WebProcessManager.Yd(this.from);
        if (locala != null) {
          locala.onResult(true);
        }
      }
      for (;;)
      {
        WebProcessManager.ex.set(false);
        return;
        if (locala != null) {
          locala.onResult(false);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager
 * JD-Core Version:    0.7.0.1
 */