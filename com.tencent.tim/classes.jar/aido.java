import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.PluginLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.RunningPlugin;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.3;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class aido
{
  private static Map<String, aido> lr = new HashMap();
  private final List<aido.a> Cw = new LinkedList();
  private final InstalledPlugin jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin;
  private RunningPlugin jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginloaderRunningPlugin;
  private final Context appContext;
  private final PluginLoader jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginloaderPluginLoader = new DynamicPluginLoader();
  private IVPluginDataReporter jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  private String bNe;
  private IVPluginInfo c;
  private boolean cjW;
  public volatile boolean cjY = false;
  volatile boolean cjZ = false;
  private boolean cka;
  private Handler.Callback g = new aidp(this);
  private String mAppName;
  private int mProgress;
  private boolean mRunning;
  private long mStartTime;
  private final Handler mUiHandler = new Handler(Looper.getMainLooper(), this.g);
  private String mUin;
  
  private aido(Context paramContext, InstalledPlugin paramInstalledPlugin)
  {
    this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin = paramInstalledPlugin;
    this.appContext = paramContext.getApplicationContext();
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
  }
  
  @NonNull
  private Intent A()
  {
    Intent localIntent = new Intent();
    if (this.bNe != null) {
      localIntent.setData(Uri.parse(this.bNe));
    }
    localIntent.putExtras(this.c.mExtras);
    if (this.cjW) {}
    for (int i = 1;; i = 2)
    {
      localIntent.putExtra("PluginStartMode", i);
      localIntent.putExtra("isNeedTransparent", true);
      localIntent.putExtra("qqVersion", "3.4.4");
      return localIntent;
    }
  }
  
  public static aido a(Context paramContext, InstalledPlugin paramInstalledPlugin)
  {
    try
    {
      aido localaido2 = (aido)lr.get(paramInstalledPlugin.pluginFile.getName());
      aido localaido1 = localaido2;
      if (localaido2 == null)
      {
        localaido1 = new aido(paramContext, paramInstalledPlugin);
        lr.put(paramInstalledPlugin.pluginFile.getName(), localaido1);
      }
      return localaido1;
    }
    finally {}
  }
  
  private RunningPlugin a()
  {
    long l = System.currentTimeMillis();
    log("HuayangPluginLauncher", acfp.m(2131707292));
    try
    {
      ProgressFuture localProgressFuture = this.jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginloaderPluginLoader.loadPlugin(this.appContext, this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin);
      if (localProgressFuture == null)
      {
        log("HuayangPluginLauncher", acfp.m(2131707302) + (System.currentTimeMillis() - l));
        b(false, new Exception("loadFuture == null"));
        return null;
      }
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HuayangPluginLauncher", 2, "在加载插件并调用其Application的OnCreate方法过程中出错", localException1);
      }
      b(false, localException1);
      return null;
    }
    HuayangPluginLauncher.3 local3 = new HuayangPluginLauncher.3(this);
    this.mUiHandler.post(local3);
    RunningPlugin localRunningPlugin;
    try
    {
      localRunningPlugin = (RunningPlugin)localException1.get(100L, TimeUnit.SECONDS);
      localThrowable = null;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Throwable localThrowable;
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginLauncher", 2, localException2, new Object[0]);
        }
        localRunningPlugin = null;
      }
      publishProgress(80);
      log("HuayangPluginLauncher", acfp.m(2131707306) + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile + acfp.m(2131707301) + (System.currentTimeMillis() - l));
    }
    this.mUiHandler.removeCallbacks(local3);
    if (localThrowable != null)
    {
      b(false, localThrowable);
      return null;
    }
    return localRunningPlugin;
  }
  
  private void a(RunningPlugin paramRunningPlugin)
  {
    this.cjZ = true;
    long l = System.currentTimeMillis();
    log("HuayangPluginLauncher", acfp.m(2131707290) + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile);
    paramRunningPlugin = paramRunningPlugin.startLauncherActivity(A());
    publishProgress(90);
    for (;;)
    {
      try
      {
        paramRunningPlugin.get();
        b(true, null);
        if (!aidi.mU(this.c.mPackageName)) {
          continue;
        }
        aids.Lb("2691707");
        paramRunningPlugin = this.appContext.getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit();
        paramRunningPlugin.putBoolean("huayang_plugin_start_flag" + this.mUin + this.c.mPackageName, true);
        paramRunningPlugin.putString("huayang_plugin_launch_appType_", this.mAppName);
        paramRunningPlugin.apply();
        aids.Lb("2585917");
      }
      catch (Throwable paramRunningPlugin)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("HuayangPluginLauncher", 2, paramRunningPlugin, new Object[0]);
        b(false, paramRunningPlugin);
        continue;
      }
      log("HuayangPluginLauncher", acfp.m(2131707305) + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile + acfp.m(2131707298) + (System.currentTimeMillis() - l));
      return;
      if (aidi.mV(this.c.mPackageName)) {
        aids.Lb("2597725");
      }
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment(this.mAppName).opName(paramString1).opType(paramString1).opIn(paramInt1).opResult(paramInt2).d1(paramString2).d2(paramString3).d4(this.c.mPackageName).report();
  }
  
  private void aE(boolean paramBoolean, String paramString)
  {
    int j = (int)(System.currentTimeMillis() - this.mStartTime);
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!this.cka) {
        break label81;
      }
    }
    label81:
    for (String str = "1";; str = "0")
    {
      a("launchFinish", i, j, paramString, str, this.mAppName + "_" + this.c.mPackageName);
      return;
      i = 0;
      break;
    }
  }
  
  private void b(RunningPlugin paramRunningPlugin)
  {
    long l = System.currentTimeMillis();
    log("HuayangPluginLauncher", acfp.m(2131707296) + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile);
    Intent localIntent = A();
    try
    {
      paramRunningPlugin.startInitActivity(localIntent).get();
      log("HuayangPluginLauncher", acfp.m(2131707294) + this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin.pluginFile + acfp.m(2131707291) + (System.currentTimeMillis() - l));
      return;
    }
    catch (Throwable paramRunningPlugin)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginLauncher", 2, paramRunningPlugin, new Object[0]);
        }
        aide.j(paramRunningPlugin);
      }
    }
  }
  
  private void b(boolean paramBoolean, Throwable paramThrowable)
  {
    publishProgress(100);
    if ((!paramBoolean) && (!(paramThrowable instanceof TimeoutException)) && (!(paramThrowable instanceof InterruptedException)))
    {
      this.jdField_b_of_type_ComTencentHydevteamPluginframeworkPluginloaderPluginLoader.setPluginDisabled(this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin);
      if (QLog.isColorLevel()) {
        QLog.e("HuayangPluginLauncher", 2, "设置插件启动失败标志失败");
      }
    }
    Object localObject = this.mUiHandler;
    int i;
    if (paramBoolean)
    {
      i = 0;
      localObject = Message.obtain((Handler)localObject, 3, i, 0, paramThrowable);
      this.mUiHandler.sendMessage((Message)localObject);
      if (!paramBoolean) {
        break label107;
      }
      aE(paramBoolean, null);
    }
    for (;;)
    {
      this.mRunning = false;
      return;
      i = 1;
      break;
      label107:
      aE(paramBoolean, paramThrowable.toString());
      aide.j(paramThrowable);
    }
  }
  
  private void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private void publishProgress(int paramInt)
  {
    if (paramInt < this.mProgress) {
      return;
    }
    log("HuayangPluginLauncher", acfp.m(2131707300) + paramInt);
    this.mProgress = paramInt;
    Message localMessage = Message.obtain(this.mUiHandler, 1, paramInt, 0);
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void a(aido.a parama)
  {
    if (parama != null) {
      this.Cw.add(parama);
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, IVPluginInfo paramIVPluginInfo, String paramString2, String paramString3)
  {
    if (this.mRunning)
    {
      log("HuayangPluginLauncher", "launchPlugin mRunning return");
      return;
    }
    this.mRunning = true;
    this.mAppName = paramString3;
    this.cjY = false;
    this.cjZ = false;
    this.cka = paramBoolean1;
    this.cjW = paramBoolean2;
    this.c = paramIVPluginInfo;
    this.mUin = paramString2;
    this.mStartTime = System.currentTimeMillis();
    this.bNe = paramString1;
    ThreadManager.executeOnSubThread(new HuayangPluginLauncher.2(this, paramBoolean2));
  }
  
  public boolean aoT()
  {
    return this.cjZ;
  }
  
  public void b(aido.a parama)
  {
    if (parama != null) {
      this.Cw.remove(parama);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, Throwable paramThrowable);
    
    public abstract void onProgressUpdate(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aido
 * JD-Core Version:    0.7.0.1
 */