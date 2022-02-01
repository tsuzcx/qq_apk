package com.tencent.qqmini.sdk.launcher;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.annotation.BindClass;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.log.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IBuild;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import com.tencent.qqmini.sdk.launcher.shell.IShareManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@MiniKeep
public class AppLoaderFactory
{
  private static final String GAME_UI_PROXY_CLASS_NAME = "com.tencent.qqmini.minigame.ui.GameUIProxy";
  public static final String LOG_FLAG_LIFECYCLE = " [MiniLifecycle] ";
  public static final String TAG = "minisdk-start";
  private static volatile AppLoaderFactory instance;
  private static volatile byte[] lock = new byte[0];
  @BindClass(className="com.tencent.qqmini.sdk.core.manager.ActivityResultManagerFaker")
  private IActivityResultManager activityResultManager;
  @BindClass(className="com.tencent.qqmini.sdk.ipc.AppBrandProxy")
  private IAppBrandProxy appBrandProxy;
  @BindClass(className="com.tencent.qqmini.sdk.launcher.AppUIProxy")
  private IUIProxy appInternalUIProxy;
  @BindClass(className="com.tencent.qqmini.sdk.launcher.AppUIProxy")
  private IUIProxy appUIProxy;
  private BaselibLoader baselibLoader;
  @BindClass(className="com.tencent.qqmini.sdk.core.Build")
  private IBuild build;
  @BindClass(className="com.tencent.qqmini.sdk.manager.CommonManager")
  private ICommonManager commonManager;
  @BindClass(className="com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager")
  private ILaunchManager launchManager;
  Context mContext;
  private String mProcessName;
  private Map<String, WeakReference<IUIProxy>> mUIProxyMap = new HashMap();
  private Class mainServiceBinderClass;
  @BindClass(className="com.tencent.qqmini.sdk.core.MiniAppEnv")
  private IMiniAppEnv miniAppEnv;
  @BindClass(className="com.tencent.qqmini.sdk.cache.MiniCacheFreeManager")
  private IMiniCacheFreeManager miniCacheFreeManager;
  @BindClass(className="com.tencent.qqmini.sdk.log.LogImpl")
  private Log minilog;
  private List<ILaunchManager.MiniProcessorConfig> processList;
  @BindClass(className="com.tencent.qqmini.sdk.core.proxy.FakeProxyManager")
  private IProxyManager proxyManager;
  @BindClass(className="com.tencent.qqmini.sdk.receiver.MainReceiverProxy")
  private IReceiverProxy receiverProxy;
  @BindClass(className="com.tencent.qqmini.sdk.core.manager.ShareManager")
  private IShareManager shareManager;
  
  /* Error */
  private void doAnnotation()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 97	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   7: astore_3
    //   8: aload_3
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_1
    //   13: iload_1
    //   14: iload_2
    //   15: if_icmpge +25 -> 40
    //   18: aload_3
    //   19: iload_1
    //   20: aaload
    //   21: astore 4
    //   23: ldc 99
    //   25: aload 4
    //   27: invokevirtual 104	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   30: if_acmpne +82 -> 112
    //   33: aload_0
    //   34: aload 4
    //   36: invokespecial 108	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:processFieldAnnotation	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   39: pop
    //   40: aload_3
    //   41: arraylength
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge +25 -> 72
    //   50: aload_3
    //   51: iload_1
    //   52: aaload
    //   53: astore 4
    //   55: ldc 110
    //   57: aload 4
    //   59: invokevirtual 104	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   62: if_acmpne +68 -> 130
    //   65: aload_0
    //   66: aload 4
    //   68: invokespecial 108	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:processFieldAnnotation	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   71: pop
    //   72: aload_3
    //   73: arraylength
    //   74: istore_2
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: iload_2
    //   79: if_icmpge +90 -> 169
    //   82: aload_3
    //   83: iload_1
    //   84: aaload
    //   85: astore 4
    //   87: aload_0
    //   88: aload 4
    //   90: invokespecial 108	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:processFieldAnnotation	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   93: pop
    //   94: iload_1
    //   95: iconst_1
    //   96: iadd
    //   97: istore_1
    //   98: goto -21 -> 77
    //   101: astore 4
    //   103: ldc 15
    //   105: ldc 111
    //   107: aload 4
    //   109: invokestatic 117	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: iload_1
    //   113: iconst_1
    //   114: iadd
    //   115: istore_1
    //   116: goto -103 -> 13
    //   119: astore 4
    //   121: ldc 15
    //   123: ldc 119
    //   125: aload 4
    //   127: invokestatic 117	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: istore_1
    //   134: goto -89 -> 45
    //   137: astore 5
    //   139: ldc 15
    //   141: new 121	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   148: ldc 124
    //   150: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 4
    //   155: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: aload 5
    //   163: invokestatic 117	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   166: goto -72 -> 94
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	AppLoaderFactory
    //   12	122	1	i	int
    //   10	70	2	j	int
    //   7	76	3	arrayOfField	Field[]
    //   21	68	4	localField	Field
    //   101	7	4	localThrowable1	Throwable
    //   119	35	4	localThrowable2	Throwable
    //   137	25	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   23	40	101	java/lang/Throwable
    //   55	72	119	java/lang/Throwable
    //   87	94	137	java/lang/Throwable
  }
  
  public static AppLoaderFactory g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new AppLoaderFactory();
      }
      return instance;
    }
  }
  
  private Object processFieldAnnotation(Field paramField)
    throws Exception
  {
    Object localObject = paramField.get(this);
    if (localObject != null) {
      return localObject;
    }
    if (paramField.isAnnotationPresent(BindClass.class))
    {
      paramField.setAccessible(true);
      localObject = ((BindClass)paramField.getAnnotation(BindClass.class)).className();
      localObject = MiniAppDexLoader.g().create((String)localObject);
      paramField.set(this, localObject);
      return localObject;
    }
    return null;
  }
  
  public IBinder createMainServiceBinder(Context paramContext, String paramString)
  {
    if (this.mainServiceBinderClass == null) {
      this.mainServiceBinderClass = findClass("com.tencent.qqmini.sdk.ipc.AppMainServiceBinder");
    }
    if (this.mainServiceBinderClass == null)
    {
      QMLog.e("minisdk-start", "mainServiceBinderClass is null!");
      return null;
    }
    try
    {
      paramContext = (IBinder)this.mainServiceBinderClass.getConstructor(new Class[] { Context.class, String.class }).newInstance(new Object[] { paramContext, paramString });
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("minisdk-start", "exception when createMainServiceBinder", paramContext);
    }
    return null;
  }
  
  public Class findClass(String paramString)
  {
    return MiniAppDexLoader.g().findClass(paramString);
  }
  
  public IActivityResultManager getActivityResultManager()
  {
    return this.activityResultManager;
  }
  
  public IAppBrandProxy getAppBrandProxy()
  {
    return this.appBrandProxy;
  }
  
  public IUIProxy getAppUIProxy(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start", "Failed to getAppUIProxy, miniAppInfo is null, return default appUIProxy");
      localObject = this.appUIProxy;
    }
    IUIProxy localIUIProxy;
    do
    {
      return localObject;
      if (!paramMiniAppInfo.isEngineTypeMiniGame()) {
        break label96;
      }
      localObject = (WeakReference)this.mUIProxyMap.get(paramMiniAppInfo.appId);
      if (localObject == null) {
        break;
      }
      localIUIProxy = (IUIProxy)((WeakReference)localObject).get();
      localObject = localIUIProxy;
    } while (localIUIProxy != null);
    Object localObject = (IUIProxy)MiniAppDexLoader.g().create("com.tencent.qqmini.minigame.ui.GameUIProxy");
    this.mUIProxyMap.put(paramMiniAppInfo.appId, new WeakReference(localObject));
    return localObject;
    label96:
    if (paramMiniAppInfo.isInternalApp()) {
      return this.appInternalUIProxy;
    }
    return this.appUIProxy;
  }
  
  public BaselibLoader getBaselibLoader()
  {
    return this.baselibLoader;
  }
  
  public ICommonManager getCommonManager()
  {
    return this.commonManager;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public ILaunchManager.MiniProcessorConfig getCurrentProcessConfig()
  {
    if (this.processList == null) {
      return null;
    }
    String str = getProcessName();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Iterator localIterator = this.processList.iterator();
    while (localIterator.hasNext())
    {
      ILaunchManager.MiniProcessorConfig localMiniProcessorConfig = (ILaunchManager.MiniProcessorConfig)localIterator.next();
      if ((localMiniProcessorConfig != null) && (str.equals(localMiniProcessorConfig.processName))) {
        return localMiniProcessorConfig;
      }
    }
    return null;
  }
  
  public String getCurrentProcessName()
  {
    return getProcessName();
  }
  
  public ILaunchManager getLaunchManager()
  {
    return this.launchManager;
  }
  
  public IMiniAppEnv getMiniAppEnv()
  {
    return this.miniAppEnv;
  }
  
  public IMiniCacheFreeManager getMiniCacheFreeManager()
  {
    return this.miniCacheFreeManager;
  }
  
  public String getProcessName()
  {
    if (!TextUtils.isEmpty(this.mProcessName)) {
      return this.mProcessName;
    }
    try
    {
      Object localObject = (ActivityManager)this.mContext.getSystemService("activity");
      int i = Process.myPid();
      localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i) {
          this.mProcessName = localRunningAppProcessInfo.processName;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("minisdk-start", "getProcessName exception!", localThrowable);
      }
    }
    return this.mProcessName;
  }
  
  public IProxyManager getProxyManager()
  {
    return this.proxyManager;
  }
  
  public IReceiverProxy getReceiverProxy()
  {
    return this.receiverProxy;
  }
  
  public IBuild getSDKBuild()
  {
    return this.build;
  }
  
  public IShareManager getShareManager()
  {
    return this.shareManager;
  }
  
  public void init(Context paramContext, Configuration paramConfiguration)
  {
    if (this.mContext != null) {
      return;
    }
    this.mContext = paramContext;
    MiniAppDexLoader localMiniAppDexLoader = MiniAppDexLoader.g();
    if (paramConfiguration != null) {}
    for (boolean bool = paramConfiguration.dexLoaderEnable;; bool = true)
    {
      localMiniAppDexLoader.init(paramContext, bool, paramConfiguration.dexConfig);
      MiniAppDexLoader.g().loadDex();
      doAnnotation();
      QMLog.setLog(this.minilog);
      this.miniAppEnv.init(paramContext);
      this.appBrandProxy.init(paramContext);
      this.mainServiceBinderClass = findClass("com.tencent.qqmini.sdk.ipc.AppMainServiceBinder");
      return;
    }
  }
  
  public boolean isMainProcess()
  {
    return this.mContext.getPackageName().equals(getCurrentProcessName());
  }
  
  public void registerProcessInfo(Context paramContext, List<ILaunchManager.MiniProcessorConfig> paramList)
  {
    if (this.launchManager == null) {
      return;
    }
    QMLog.i("minisdk-start", "registerProcessInfo");
    this.launchManager.registerProcessInfo(paramList);
    this.launchManager.init(paramContext);
    this.processList = paramList;
  }
  
  public void setBaselibLoader(BaselibLoader paramBaselibLoader)
  {
    if (paramBaselibLoader != null) {
      this.baselibLoader = paramBaselibLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppLoaderFactory
 * JD-Core Version:    0.7.0.1
 */