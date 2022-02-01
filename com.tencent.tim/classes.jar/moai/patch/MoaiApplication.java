package moai.patch;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.webkit.WebView;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import moai.patch.conf.Action;
import moai.patch.exception.MoaiExceptionHandler;
import moai.patch.extra.QuickLaunch;
import moai.patch.extra.QuickSilver;
import moai.patch.handle.NameGenerator;
import moai.patch.handle.PatchBlackList;
import moai.patch.handle.PatchCleanTask;
import moai.patch.handle.PatchHandler;
import moai.patch.handle.PatchTask;
import moai.patch.handle.ProcessKiller;
import moai.patch.log.PatchLog;
import moai.patch.log.StartUpLog;
import moai.patch.multidex.MoaiDexLoader;
import moai.patch.multidex.MultiDex;
import moai.patch.natives.MoaiNativeLoader;
import moai.patch.resource.Hack;
import moai.patch.resource.Hack.HackedClass;
import moai.patch.resource.Hack.HackedField;
import moai.patch.resource.Hack.HackedMethod;
import moai.patch.resource.MoaiResourceLoader;
import moai.patch.sharedpref.SharedPrefUtil;
import moai.patch.util.BroadCastUtil;
import moai.patch.util.DeviceUtil;
import moai.patch.util.ManifestUtil;
import moai.patch.util.VersionUtil;

@SuppressLint({"CommitPrefEdits"})
public class MoaiApplication
  extends Application
{
  private static int mActiveActivityCount = 0;
  private static boolean mAttachRealContextEnd;
  private static String mProcessName = "";
  private ActivityManager mActivityManager;
  private Context mBaseContext = null;
  private Application mDelegateApplication;
  private boolean mPatchSuccess;
  private boolean mProxyFailed;
  
  private void attachContext(Application paramApplication)
    throws Exception
  {
    Hack.clazz(Application.class).method("attach", new Class[] { Context.class }).invoke(paramApplication, new Object[] { this.mBaseContext });
  }
  
  private void attachRealContext()
  {
    PatchLog.i(2006, "start attach real context:" + System.currentTimeMillis());
    long l = SystemClock.uptimeMillis();
    String str3 = null;
    try
    {
      Bundle localBundle = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData;
      String str1 = str3;
      if (localBundle == null) {
        break label227;
      }
      str1 = str3;
      if (!localBundle.containsKey("APP_DELEGATE")) {
        break label227;
      }
      str3 = localBundle.getString("APP_DELEGATE");
      if ((str3 != null) && (!str3.equals(""))) {
        break label191;
      }
      throw new RuntimeException("application name not found.");
    }
    catch (Exception localException1)
    {
      this.mProxyFailed = true;
      PatchLog.e(2008, "attachRealContext fail1:" + localException1.toString());
    }
    if (!this.mProxyFailed)
    {
      this.mDelegateApplication.onCreate();
      monitorActivity(this.mDelegateApplication);
      l = SystemClock.uptimeMillis() - l;
      StartUpLog.attachRealContext(l);
      PatchLog.w(2007, "attach real context", l);
    }
    for (;;)
    {
      PatchLog.flushPendingLogs();
      mAttachRealContextEnd = true;
      return;
      label191:
      String str2 = str3;
      if (str3.startsWith(".")) {
        str2 = getPackageName() + str3;
      }
      label227:
      this.mDelegateApplication = ((Application)Class.forName(str2, true, getClassLoader()).newInstance());
      resetContext((Application)getApplicationContext(), this.mDelegateApplication);
      attachContext(this.mDelegateApplication);
      break;
      try
      {
        resetContext(this.mDelegateApplication, this);
      }
      catch (Exception localException2) {}
    }
  }
  
  private static void checkProcess(ActivityManager paramActivityManager)
  {
    paramActivityManager = paramActivityManager.getRunningAppProcesses();
    int i = Process.myPid();
    if (paramActivityManager != null)
    {
      paramActivityManager = paramActivityManager.iterator();
      while (paramActivityManager.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramActivityManager.next();
        if (localRunningAppProcessInfo.pid == i) {
          mProcessName = localRunningAppProcessInfo.processName;
        }
      }
    }
    if ((mProcessName == null) || (mProcessName.equals(""))) {
      throw new RuntimeException("process name empty");
    }
  }
  
  private String chooseCodeDir(File paramFile, boolean paramBoolean)
  {
    if (SharedPrefUtil.isRevertPatch(this))
    {
      if (paramBoolean) {
        return "";
      }
      if (isMainProcessAlive()) {
        return SharedPrefUtil.mainUsingDexDir(this);
      }
      return "";
    }
    if (paramBoolean)
    {
      String str = NameGenerator.currentPatchDirName(this);
      new PatchCleanTask().clearPreviousPatch(paramFile, str);
      return str;
    }
    if (isMainProcessAlive())
    {
      if (SharedPrefUtil.isMainProcessInitEnd(this)) {
        return SharedPrefUtil.mainUsingDexDir(this);
      }
      PatchLog.i(2031, "main process init not finish");
      return NameGenerator.currentPatchDirName(this);
    }
    return NameGenerator.currentPatchDirName(this);
  }
  
  private void clearPatchForce()
  {
    PatchLog.w(1032, "clean patch force.");
    PatchBlackList.increasePatchFailCountBy(this, SharedPrefUtil.getCurrentPatchKey(this), 2147483647);
    PatchTask.setRevertPatch(this);
    new PatchCleanTask().checkCleanPatch(this);
  }
  
  private boolean isMainProcess()
  {
    return mProcessName.equals(getPackageName());
  }
  
  private boolean isMainProcessAlive()
  {
    Object localObject = this.mActivityManager.getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals(getPackageName())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isPatchProcess(Context paramContext)
  {
    return mProcessName.equals(paramContext.getPackageName() + ":patch");
  }
  
  public static boolean isStartUpEnd()
  {
    return mAttachRealContextEnd;
  }
  
  public static void killProcessIfNeed(Context paramContext, boolean paramBoolean)
  {
    if ((mActiveActivityCount == 0) && (!SharedPrefUtil.isPatchRestarted(paramContext)))
    {
      BroadCastUtil.send(paramContext, Action.ACTION_KILL.name());
      new Thread(new MoaiApplication.2(paramBoolean, paramContext), "moai-killer-thread").start();
    }
  }
  
  private void monitorActivity(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(new MoaiApplication.1(this, paramApplication));
  }
  
  /* Error */
  private boolean patch(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 361	java/io/File:exists	()Z
    //   4: ifne +32 -> 36
    //   7: sipush 2002
    //   10: new 73	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 363
    //   20: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 366	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 156	moai/patch/log/PatchLog:e	(ILjava/lang/String;)V
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 372	moai/patch/multidex/MoaiDexLoader:attachPatchDex	(Landroid/app/Application;Ljava/io/File;)Z
    //   41: istore 4
    //   43: aload_0
    //   44: invokestatic 375	moai/patch/handle/PatchTask:hasResPatch	(Landroid/content/Context;)Z
    //   47: istore 5
    //   49: iload 5
    //   51: ifeq +300 -> 351
    //   54: aload_0
    //   55: aload_1
    //   56: invokestatic 381	moai/patch/resource/MoaiResourceLoader:attachPatchResources	(Landroid/content/ContextWrapper;Ljava/io/File;)Z
    //   59: istore_2
    //   60: aload_0
    //   61: aload_1
    //   62: invokestatic 387	moai/patch/natives/MoaiNativeLoader:attachPatchNative	(Landroid/content/Context;Ljava/io/File;)Z
    //   65: istore_3
    //   66: iload 4
    //   68: ifeq +16 -> 84
    //   71: iload 5
    //   73: ifeq +276 -> 349
    //   76: iload_2
    //   77: ifeq +7 -> 84
    //   80: iload_3
    //   81: ifne +268 -> 349
    //   84: sipush 1026
    //   87: new 73	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 389
    //   97: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 392	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   105: ldc_w 394
    //   108: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload_2
    //   112: invokevirtual 392	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   115: ldc_w 396
    //   118: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_3
    //   122: invokevirtual 392	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 282	moai/patch/log/PatchLog:w	(ILjava/lang/String;)V
    //   131: aload_0
    //   132: invokespecial 399	moai/patch/MoaiApplication:revertAll	()V
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_1
    //   138: sipush 2003
    //   141: new 73	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 401
    //   151: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   158: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 156	moai/patch/log/PatchLog:e	(ILjava/lang/String;)V
    //   167: new 143	java/lang/RuntimeException
    //   170: dup
    //   171: new 73	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 403
    //   181: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   188: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokespecial 148	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   197: athrow
    //   198: astore_1
    //   199: sipush 2004
    //   202: new 73	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 405
    //   212: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   219: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 156	moai/patch/log/PatchLog:e	(ILjava/lang/String;)V
    //   228: new 143	java/lang/RuntimeException
    //   231: dup
    //   232: new 73	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   239: ldc_w 407
    //   242: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_1
    //   246: invokestatic 413	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   249: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokespecial 148	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   258: athrow
    //   259: astore_1
    //   260: sipush 2005
    //   263: new 73	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 415
    //   273: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   280: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 156	moai/patch/log/PatchLog:e	(ILjava/lang/String;)V
    //   289: new 143	java/lang/RuntimeException
    //   292: dup
    //   293: new 73	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 417
    //   303: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_1
    //   307: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   310: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokespecial 148	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   319: athrow
    //   320: astore_1
    //   321: new 143	java/lang/RuntimeException
    //   324: dup
    //   325: new 73	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 419
    //   335: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokespecial 148	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   348: athrow
    //   349: iconst_1
    //   350: ireturn
    //   351: iconst_0
    //   352: istore_3
    //   353: iconst_0
    //   354: istore_2
    //   355: goto -289 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	MoaiApplication
    //   0	358	1	paramFile	File
    //   59	296	2	bool1	boolean
    //   65	288	3	bool2	boolean
    //   41	60	4	bool3	boolean
    //   47	25	5	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   36	43	137	java/lang/Exception
    //   54	60	198	java/lang/Exception
    //   60	66	259	java/lang/Exception
    //   84	135	320	java/lang/Throwable
  }
  
  private void resetContext(Application paramApplication1, Application paramApplication2)
    throws Exception
  {
    Object localObject1 = Hack.clazz("android.app.ContextImpl");
    ((Hack.HackedClass)localObject1).field("mOuterContext").set(this.mBaseContext, paramApplication2);
    Object localObject2 = ((Hack.HackedClass)localObject1).field("mPackageInfo").get(this.mBaseContext);
    Hack.HackedClass localHackedClass = Hack.clazz("android.app.LoadedApk");
    localHackedClass.field("mApplication").set(localObject2, paramApplication2);
    localObject1 = Hack.clazz("android.app.ActivityThread");
    localObject2 = localHackedClass.field("mActivityThread").get(localObject2);
    ((Hack.HackedClass)localObject1).field("mInitialApplication").set(localObject2, paramApplication2);
    localObject1 = (Collection)((Hack.HackedClass)localObject1).field("mAllApplications").get(localObject2);
    ((Collection)localObject1).add(paramApplication2);
    ((Collection)localObject1).remove(paramApplication1);
  }
  
  private void revertAll()
    throws Exception
  {
    MoaiDexLoader.revertClassLoader(this);
    MoaiResourceLoader.revertResource();
    MoaiNativeLoader.revertNative(this);
    Process.myPid();
    if (isMainProcess())
    {
      ProcessKiller.killAll(this, true);
      PatchLog.w(1029, "revert all,main process clear patch");
      clearPatchForce();
      return;
    }
    if (isMainProcessAlive())
    {
      PatchLog.w(1028, "revert all,main alive,kill self");
      ProcessKiller.killSelf(3000L);
      return;
    }
    ProcessKiller.killAll(this, true);
    PatchLog.w(1030, "revert all,main process clear patch");
    clearPatchForce();
    ProcessKiller.killSelf(3000L);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    boolean bool3 = false;
    super.attachBaseContext(paramContext);
    long l = SystemClock.uptimeMillis();
    this.mBaseContext = paramContext;
    this.mActivityManager = ((ActivityManager)getSystemService("activity"));
    checkProcess(this.mActivityManager);
    PatchLog.init(this, paramContext.getCacheDir(), mProcessName, Process.myPid());
    PatchLog.reportCrashedFile(this);
    Thread.setDefaultUncaughtExceptionHandler(new MoaiExceptionHandler(this, mProcessName));
    boolean bool4 = isMainProcess();
    StartUpLog.init(this, bool4);
    boolean bool1;
    boolean bool2;
    if (bool4)
    {
      SharedPrefUtil.markMainProcessInitEnd(this, false);
      bool1 = new PatchCleanTask().checkCleanPatch(this);
      bool2 = SharedPrefUtil.isPatchRestarted(this);
      if ((bool1) || (!bool2))
      {
        PatchLog.w(1033, "main process check kill all other");
        ProcessKiller.killAll(this, true);
        SharedPrefUtil.setPatchRestarted(this);
      }
    }
    boolean bool5 = DeviceUtil.isSystemOTA(this);
    if ((Build.VERSION.SDK_INT < 21) && (VersionUtil.isCurrentVersionFirstLaunch(this)))
    {
      bool1 = true;
      paramContext = null;
      Object localObject = ManifestUtil.quickLaunchClassName(this);
      if (!((String)localObject).equals("")) {
        paramContext = new QuickSilver().launch(this, mProcessName, (String)localObject, bool1, l);
      }
      if ((!isPatchProcess(this)) && (!ManifestUtil.mainDexOnly(this, mProcessName)))
      {
        if (bool4) {
          VersionUtil.setCurrentVersionFirstLaunched(this);
        }
        boolean bool6 = SharedPrefUtil.isAppPatched(this);
        PatchLog.d("startup, isPatched:" + bool6 + ",romOTA:" + bool5);
        if ((bool4) && (bool6) && (bool5)) {
          PatchHandler.reodex(this);
        }
        String str = "";
        localObject = str;
        bool2 = bool3;
        if (bool6)
        {
          localObject = str;
          bool2 = bool3;
          if (!bool5)
          {
            File localFile = getDir("patch", 0);
            str = chooseCodeDir(localFile, bool4);
            localObject = str;
            bool2 = bool3;
            if (!str.equals(""))
            {
              PatchLog.d("start patch, dir:" + str);
              bool2 = patch(new File(localFile, str));
              this.mPatchSuccess = bool2;
              PatchLog.w(2001, "attach base context end. patch success:" + bool2, SystemClock.uptimeMillis() - l);
              localObject = str;
            }
          }
        }
        if (!bool2) {
          MultiDex.install(this, MultiDex.getDefaultMultiDexDir(this));
        }
        if (bool4)
        {
          if (!bool2) {
            break label523;
          }
          SharedPrefUtil.setMainUsingDexDir(this, (String)localObject);
        }
      }
    }
    for (;;)
    {
      l = SystemClock.uptimeMillis() - l;
      if (paramContext != null)
      {
        paramContext.onFinish(l);
        if (bool1) {
          PatchLog.w(2034, "quick launch finish", l);
        }
      }
      StartUpLog.attachBaseContext(l);
      PatchLog.w(2021, "attach base context done", l);
      if (bool4) {
        SharedPrefUtil.markMainProcessInitEnd(this, true);
      }
      return;
      bool1 = false;
      break;
      label523:
      SharedPrefUtil.setMainUsingDexDir(this, "");
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.mProxyFailed) && (this.mDelegateApplication != null))
    {
      this.mDelegateApplication.onConfigurationChanged(paramConfiguration);
      return;
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((!isPatchProcess(this)) && (!ManifestUtil.mainDexOnly(this, mProcessName)))
    {
      attachRealContext();
      if ((!isMainProcess()) || (!PatchTask.hasResPatch(this)) || (!this.mPatchSuccess)) {}
    }
    try
    {
      long l = SystemClock.elapsedRealtime();
      new WebView(this.mDelegateApplication).removeJavascriptInterface("searchBoxJavaBridge_");
      PatchLog.i(1040, "load webview resource success", SystemClock.elapsedRealtime() - l);
      if ((!this.mProxyFailed) || (this.mDelegateApplication == null)) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        attachContext(this.mDelegateApplication);
        label103:
        this.mDelegateApplication.onCreate();
        PatchLog.flushPendingLogs();
        MoaiExceptionHandler.done();
        return;
        localThrowable = localThrowable;
        PatchLog.e(1041, "load webview resource failed", localThrowable);
      }
      catch (Exception localException)
      {
        break label103;
      }
    }
  }
  
  public void onLowMemory()
  {
    if ((this.mProxyFailed) && (this.mDelegateApplication != null))
    {
      this.mDelegateApplication.onLowMemory();
      return;
    }
    super.onLowMemory();
  }
  
  public void onTerminate()
  {
    if ((this.mProxyFailed) && (this.mDelegateApplication != null))
    {
      this.mDelegateApplication.onTerminate();
      return;
    }
    super.onTerminate();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if ((this.mProxyFailed) && (this.mDelegateApplication != null))
    {
      this.mDelegateApplication.onTrimMemory(paramInt);
      return;
    }
    super.onTrimMemory(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.MoaiApplication
 * JD-Core Version:    0.7.0.1
 */