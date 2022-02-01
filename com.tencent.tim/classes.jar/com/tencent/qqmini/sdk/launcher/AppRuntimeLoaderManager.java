package com.tencent.qqmini.sdk.launcher;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.sdk.annotation.RuntimeLoaderConfig;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.report.MiniAppPrelaunchRecorder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@RuntimeLoaderConfig(loaders={@com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.flutter.FlutterRuntimeLoader", type=2), @com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.miniapp.AppRuntimeLoader", type=1), @com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.minigame.GameRuntimeLoader", type=4)})
public class AppRuntimeLoaderManager
{
  private static final String TAG = "minisdk-start_AppRuntimeLoaderManager";
  private static volatile AppRuntimeLoaderManager instance;
  private static volatile byte[] lock = new byte[0];
  private final LinkedList<BaseRuntimeLoader> loadedRuntimeLinkedList = new LinkedList();
  private final HashMap<Class<BaseRuntimeLoader>, BaseRuntimeLoader> mEmptyRuntimeLoaderList = new HashMap();
  private long mEnterBackgroundTimestamp = 0L;
  private final int mGameMaxLoaderCount;
  private Handler mHandler = ThreadManager.getSubThreadHandler();
  private int mMaxLoaderCount = 3;
  private final Vector<AppRuntimeEventCenter.RuntimeStateObserver> mObservers = new Vector();
  private BaseRuntimeLoader mPrelaunchRuntimeLoader;
  private Bundle mPreloadBundle;
  private BaseRuntimeLoader mPreloadRuntimeLoader;
  private int mProcessType = -1;
  private RuntimeLoaderConfiguration mRuntimeConfiguration = new RuntimeLoaderConfiguration(this);
  private long mRuntimeLoaderRecycleTime = 900000L;
  private AppRuntimeEventCenter.RuntimeStateObserver mRuntimeObserver = new AppRuntimeLoaderManager.1(this);
  public Runnable processRecycleRunnable = new AppRuntimeLoaderManager.2(this);
  
  private AppRuntimeLoaderManager()
  {
    initProcessConfig(null);
    this.mMaxLoaderCount = WnsConfig.getConfig("qqminiapp", "MiniAppRuntimeCacheMax", 3);
    this.mGameMaxLoaderCount = WnsConfig.getConfig("qqminiapp", "mini_game_multi_instance", 5);
    this.mRuntimeLoaderRecycleTime = WnsConfig.getConfig("qqminiapp", "mini_app_runtime_recycle_time", 900000L);
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "RuntimeLoaderConfig:" + this.mRuntimeConfiguration.toString() + " ProcessType=" + this.mProcessType + " maxRuntime=" + this.mMaxLoaderCount);
  }
  
  /* Error */
  private void addRuntimeLoader(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +18 -> 21
    //   6: aload_1
    //   7: invokevirtual 192	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:getMiniAppInfo	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   10: ifnull +11 -> 21
    //   13: aload_0
    //   14: getfield 65	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:loadedRuntimeLinkedList	Ljava/util/LinkedList;
    //   17: aload_1
    //   18: invokevirtual 196	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   21: aload_0
    //   22: getfield 93	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:mMaxLoaderCount	I
    //   25: istore_2
    //   26: aload_0
    //   27: getfield 91	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:mProcessType	I
    //   30: iconst_4
    //   31: if_icmpne +8 -> 39
    //   34: aload_0
    //   35: getfield 128	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:mGameMaxLoaderCount	I
    //   38: istore_2
    //   39: iload_2
    //   40: iconst_1
    //   41: if_icmplt +64 -> 105
    //   44: aload_0
    //   45: getfield 65	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:loadedRuntimeLinkedList	Ljava/util/LinkedList;
    //   48: invokevirtual 200	java/util/LinkedList:size	()I
    //   51: iload_2
    //   52: if_icmple +53 -> 105
    //   55: aload_0
    //   56: getfield 65	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:loadedRuntimeLinkedList	Ljava/util/LinkedList;
    //   59: invokevirtual 204	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   62: checkcast 188	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader
    //   65: astore_1
    //   66: aload_1
    //   67: invokevirtual 207	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:destroy	()V
    //   70: new 135	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   77: ldc 209
    //   79: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: astore_3
    //   83: aload_1
    //   84: ifnull +28 -> 112
    //   87: aload_1
    //   88: invokevirtual 212	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:toSimpleString	()Ljava/lang/String;
    //   91: astore_1
    //   92: ldc 19
    //   94: aload_3
    //   95: aload_1
    //   96: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 215	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: invokespecial 218	com/tencent/qqmini/sdk/launcher/AppRuntimeLoaderManager:notifyRuntimeListInfo	()V
    //   109: aload_0
    //   110: monitorexit
    //   111: return
    //   112: ldc 220
    //   114: astore_1
    //   115: goto -23 -> 92
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	AppRuntimeLoaderManager
    //   0	123	1	paramBaseRuntimeLoader	BaseRuntimeLoader
    //   25	28	2	i	int
    //   82	13	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	21	118	finally
    //   21	26	118	finally
    //   26	39	118	finally
    //   44	83	118	finally
    //   87	92	118	finally
    //   92	105	118	finally
    //   105	109	118	finally
  }
  
  private void cleanRuntimeLoader()
  {
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "clean RuntimeLoader");
    try
    {
      if (this.loadedRuntimeLinkedList.size() <= 1) {
        return;
      }
      while (this.loadedRuntimeLinkedList.size() > 1)
      {
        BaseRuntimeLoader localBaseRuntimeLoader = (BaseRuntimeLoader)this.loadedRuntimeLinkedList.removeLast();
        if (localBaseRuntimeLoader != null)
        {
          QMLog.i("minisdk-start_AppRuntimeLoaderManager", "removed RuntimeLoader:" + localBaseRuntimeLoader.toSimpleString());
          localBaseRuntimeLoader.destroy();
        }
      }
      notifyRuntimeListInfo();
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "cleanRuntimeLoader exception!", localThrowable);
      return;
    }
    preloadRuntime(null);
  }
  
  public static AppRuntimeLoaderManager g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new AppRuntimeLoaderManager();
      }
      return instance;
    }
  }
  
  private void initProcessConfig(Bundle paramBundle)
  {
    if (this.mProcessType >= 0) {}
    do
    {
      do
      {
        return;
        ILaunchManager.MiniProcessorConfig localMiniProcessorConfig = AppLoaderFactory.g().getCurrentProcessConfig();
        if (localMiniProcessorConfig != null) {
          this.mProcessType = localMiniProcessorConfig.supportRuntimeType;
        }
      } while ((this.mProcessType >= 0) || (paramBundle == null) || (!paramBundle.containsKey("mini_key_preload_type")));
      paramBundle = paramBundle.getString("mini_key_preload_type");
      if ("preload_app".equals(paramBundle))
      {
        this.mProcessType = 3;
        return;
      }
    } while (!"preload_game".equals(paramBundle));
    this.mProcessType = 4;
  }
  
  private boolean isMatch(BaseRuntimeLoader paramBaseRuntimeLoader, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramBaseRuntimeLoader == null) || (paramMiniAppInfo == null)) {
      return false;
    }
    Iterator localIterator = this.mRuntimeConfiguration.getLoaderInfoListForPreload().iterator();
    while (localIterator.hasNext())
    {
      RuntimeLoaderConfiguration.RuntimeLoaderInfo localRuntimeLoaderInfo = (RuntimeLoaderConfiguration.RuntimeLoaderInfo)localIterator.next();
      if ((localRuntimeLoaderInfo != null) && (paramBaseRuntimeLoader.getClass() == localRuntimeLoaderInfo.runtimeLoaderClass) && (localRuntimeLoaderInfo.creator != null) && (localRuntimeLoaderInfo.creator.support(paramMiniAppInfo)) && ((paramBaseRuntimeLoader.getMiniAppInfo() == null) || (paramBaseRuntimeLoader.getMiniAppInfo().equals(paramMiniAppInfo)))) {
        return true;
      }
    }
    return false;
  }
  
  private void notifyAppStateMessage(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    try
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext()) {
        ((AppRuntimeEventCenter.RuntimeStateObserver)localIterator.next()).onStateChange(paramMiniAppStateMessage);
      }
    }
    finally {}
  }
  
  private void notifyRuntimeListInfo()
  {
    ArrayList localArrayList = getAllLoadedAppInfos();
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "notify runtime info to main process.");
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("bundle_key_runtime_list", localArrayList);
    AppBrandCmdProxy.g().sendCmd("cmd_notify_runtime_info", localBundle, new AppRuntimeLoaderManager.5(this));
  }
  
  private BaseRuntimeLoader obtainEmptyRuntimeLoader(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Iterator localIterator = this.mRuntimeConfiguration.getLoaderInfoList().iterator();
    while (localIterator.hasNext())
    {
      RuntimeLoaderConfiguration.RuntimeLoaderInfo localRuntimeLoaderInfo = (RuntimeLoaderConfiguration.RuntimeLoaderInfo)localIterator.next();
      if ((localRuntimeLoaderInfo.creator.isEnginePrepared(paramBundle)) && (localRuntimeLoaderInfo.creator.support(paramMiniAppInfo)))
      {
        if (this.mProcessType < 0)
        {
          QMLog.w("minisdk-start_AppRuntimeLoaderManager", "set ProcessType to " + this.mProcessType);
          this.mProcessType = localRuntimeLoaderInfo.type;
        }
        if (this.mEmptyRuntimeLoaderList.containsKey(localRuntimeLoaderInfo.runtimeLoaderClass)) {}
        for (paramMiniAppInfo = (BaseRuntimeLoader)this.mEmptyRuntimeLoaderList.remove(localRuntimeLoaderInfo.runtimeLoaderClass);; paramMiniAppInfo = (BaseRuntimeLoader)localRuntimeLoaderInfo.creator.create(AppLoaderFactory.g().getMiniAppEnv().getContext(), paramBundle))
        {
          paramMiniAppInfo.addRuntimeStateObserver(this.mRuntimeObserver);
          return paramMiniAppInfo;
        }
      }
    }
    return null;
  }
  
  public void addAppEventObserver(AppRuntimeEventCenter.RuntimeStateObserver paramRuntimeStateObserver)
  {
    if (paramRuntimeStateObserver != null) {}
    try
    {
      if (!this.mObservers.contains(paramRuntimeStateObserver)) {
        this.mObservers.addElement(paramRuntimeStateObserver);
      }
      return;
    }
    finally
    {
      paramRuntimeStateObserver = finally;
      throw paramRuntimeStateObserver;
    }
  }
  
  public void bringToFront(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    try
    {
      this.loadedRuntimeLinkedList.remove(paramBaseRuntimeLoader);
      this.loadedRuntimeLinkedList.addFirst(paramBaseRuntimeLoader);
      return;
    }
    catch (Throwable paramBaseRuntimeLoader)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "bringToFront exception!", paramBaseRuntimeLoader);
    }
  }
  
  public BaseRuntimeLoader createAppRuntimeLoader(MiniAppInfo paramMiniAppInfo, BaseRuntimeLoader.OnAppRuntimeLoadListener paramOnAppRuntimeLoadListener, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "Failed to createAppRuntimeLoader, appInfo is null");
      return null;
    }
    try
    {
      if ((this.mPreloadRuntimeLoader != null) && (!isMatch(this.mPreloadRuntimeLoader, paramMiniAppInfo)) && (this.mPreloadRuntimeLoader.isRunning()))
      {
        QMLog.i("minisdk-start_AppRuntimeLoaderManager", "createAppRuntimeLoader, stop the preloading runtimeloader " + this.mPreloadRuntimeLoader.toSimpleString());
        this.mPreloadRuntimeLoader.pause();
      }
      if ((this.mPrelaunchRuntimeLoader != null) && (!isMatch(this.mPrelaunchRuntimeLoader, paramMiniAppInfo)) && (this.mPrelaunchRuntimeLoader.isRunning()))
      {
        QMLog.i("minisdk-start_AppRuntimeLoaderManager", "createAppRuntimeLoader, stop the prelaunch runtimeloader " + this.mPrelaunchRuntimeLoader.toSimpleString());
        this.mPrelaunchRuntimeLoader.pause();
      }
      paramBundle = obtainEmptyRuntimeLoader(paramMiniAppInfo, paramBundle);
      QMLog.i("minisdk-start_AppRuntimeLoaderManager", "createAppRuntimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version + " obtainRuntimeLoader:" + paramBundle);
      paramBundle.setRuntimeLoadListener(new AppRuntimeLoaderManager.3(this, paramOnAppRuntimeLoadListener));
      paramBundle.setMiniAppInfo(paramMiniAppInfo);
      addRuntimeLoader(paramBundle);
      return paramBundle;
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public void deleteAppEventObserver(AppRuntimeEventCenter.RuntimeStateObserver paramRuntimeStateObserver)
  {
    if (paramRuntimeStateObserver != null) {}
    try
    {
      this.mObservers.removeElement(paramRuntimeStateObserver);
      return;
    }
    finally
    {
      paramRuntimeStateObserver = finally;
      throw paramRuntimeStateObserver;
    }
  }
  
  public ArrayList<MiniAppInfo> getAllLoadedAppInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = new ArrayList(this.loadedRuntimeLinkedList).iterator();
    while (localIterator.hasNext())
    {
      MiniAppInfo localMiniAppInfo = ((BaseRuntimeLoader)localIterator.next()).getMiniAppInfo();
      if (localMiniAppInfo != null) {
        localArrayList.add(localMiniAppInfo);
      }
    }
    return localArrayList;
  }
  
  public BaseRuntimeLoader getCurrentRunTimeLoader()
  {
    try
    {
      Object localObject = new LinkedList(this.loadedRuntimeLinkedList);
      if (((LinkedList)localObject).size() > 0)
      {
        localObject = (BaseRuntimeLoader)((LinkedList)localObject).peekFirst();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "getCurrentRunTimeLoader exception!", localThrowable);
    }
    return null;
  }
  
  public void notifyRuntimeEvent(int paramInt, Object... paramVarArgs)
  {
    if (getCurrentRunTimeLoader() != null) {
      getCurrentRunTimeLoader().notifyRuntimeEvent(paramInt, paramVarArgs);
    }
  }
  
  public void onEnterBackground()
  {
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "onEnterBackground");
    this.mEnterBackgroundTimestamp = System.currentTimeMillis();
    this.mHandler.removeCallbacks(this.processRecycleRunnable);
    this.mHandler.postDelayed(this.processRecycleRunnable, this.mRuntimeLoaderRecycleTime);
    preloadRuntime(null);
  }
  
  public void onEnterForeground()
  {
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "onEnterForeground");
    this.mEnterBackgroundTimestamp = 0L;
    this.mHandler.removeCallbacks(this.processRecycleRunnable);
  }
  
  public void preLaunchRuntimeLoader(MiniAppInfo paramMiniAppInfo, BaseRuntimeLoader.OnAppRuntimeLoadListener paramOnAppRuntimeLoadListener, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "Failed to preLaunchRuntimeLoader, appInfo is null");
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "Failed to preLaunch RuntimeLoader, appInfo is null");
      return;
    }
    if (this.mPrelaunchRuntimeLoader != null)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "There is a preLaunch loader now! Stop preLaunch!");
      return;
    }
    MiniAppPrelaunchRecorder.get().onPrelaunch(paramMiniAppInfo.appId);
    try
    {
      localBaseRuntimeLoader = queryAppRunTimeLoader(paramMiniAppInfo);
      if (localBaseRuntimeLoader != null)
      {
        QMLog.w("minisdk-start_AppRuntimeLoaderManager", "preLaunchRuntimeLoader, There is a loader now! No need PreLaunch! " + localBaseRuntimeLoader.toSimpleString());
        return;
      }
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "preLaunchRuntimeLoader exception!", paramMiniAppInfo);
      return;
    }
    BaseRuntimeLoader localBaseRuntimeLoader = getCurrentRunTimeLoader();
    if ((localBaseRuntimeLoader != null) && (localBaseRuntimeLoader.isRunning()))
    {
      QMLog.w("minisdk-start_AppRuntimeLoaderManager", "preLaunchRuntimeLoader, There is a running loader now! Stop prelaunch! " + localBaseRuntimeLoader.toSimpleString());
      return;
    }
    if ((this.mPreloadRuntimeLoader != null) && (this.mPreloadRuntimeLoader.isRunning()))
    {
      QMLog.i("minisdk-start_AppRuntimeLoaderManager", "preLaunchRuntimeLoader, There is a running preload loader now " + this.mPreloadRuntimeLoader.toSimpleString());
      return;
    }
    paramBundle = obtainEmptyRuntimeLoader(paramMiniAppInfo, paramBundle);
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "preLaunchRuntimeLoader, appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version + " obtainRuntimeLoader:" + paramBundle.toSimpleString());
    paramBundle.setRuntimeLoadListener(new AppRuntimeLoaderManager.4(this, paramOnAppRuntimeLoadListener));
    paramBundle.setMiniAppInfo(paramMiniAppInfo);
    paramBundle.getAppStateManager().isFromPrelaunch = true;
    this.mPrelaunchRuntimeLoader = paramBundle;
    paramBundle.start();
    addRuntimeLoader(paramBundle);
  }
  
  public void preloadRuntime(Bundle paramBundle)
  {
    initProcessConfig(paramBundle);
    if (paramBundle != null) {
      this.mPreloadBundle = paramBundle;
    }
    QMLog.w("minisdk-start_AppRuntimeLoaderManager", "preloadRuntime with ProcessType=" + this.mProcessType);
    if (this.mProcessType < 0) {}
    Object localObject1;
    label294:
    do
    {
      return;
      for (;;)
      {
        localObject1 = getCurrentRunTimeLoader();
        if ((localObject1 != null) && (((BaseRuntimeLoader)localObject1).isRunning()))
        {
          QMLog.w("minisdk-start_AppRuntimeLoaderManager", "There is a running loader now! Stop preload! " + ((BaseRuntimeLoader)localObject1).toSimpleString());
          return;
        }
        if (this.mPreloadRuntimeLoader != null)
        {
          if (this.mPreloadRuntimeLoader.isPause())
          {
            QMLog.w("minisdk-start_AppRuntimeLoaderManager", "Resume the preload runtime! " + this.mPreloadRuntimeLoader.toSimpleString());
            this.mPreloadRuntimeLoader.resume();
            return;
          }
          if (this.mPreloadRuntimeLoader.isRunning())
          {
            QMLog.w("minisdk-start_AppRuntimeLoaderManager", "There is already a preload runtime now! " + this.mPreloadRuntimeLoader.toSimpleString());
            return;
          }
        }
        localObject2 = this.mRuntimeConfiguration.getLoaderInfoListForPreload().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (RuntimeLoaderConfiguration.RuntimeLoaderInfo)((Iterator)localObject2).next();
          if ((this.mProcessType & ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).type) != 0)
          {
            if (((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).creator.isEnginePrepared(paramBundle)) {
              break label294;
            }
            QMLog.e("minisdk-start_AppRuntimeLoaderManager", "The loader engine is not prepared! " + ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).runtimeLoaderClass.getSimpleName());
            ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).creator.doPrepareEngine(paramBundle);
          }
        }
      }
    } while (this.mEmptyRuntimeLoaderList.containsKey(((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).runtimeLoaderClass));
    Object localObject2 = ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).creator;
    Context localContext = AppLoaderFactory.g().getMiniAppEnv().getContext();
    if (paramBundle != null) {}
    for (;;)
    {
      paramBundle = (BaseRuntimeLoader)((BaseRuntimeLoader.Creator)localObject2).create(localContext, paramBundle);
      paramBundle.addRuntimeStateObserver(this.mRuntimeObserver);
      paramBundle.getAppStateManager().isFromPreload = true;
      paramBundle.start();
      this.mEmptyRuntimeLoaderList.put(((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).runtimeLoaderClass, paramBundle);
      this.mPreloadRuntimeLoader = paramBundle;
      return;
      paramBundle = new Bundle();
    }
  }
  
  public BaseRuntimeLoader queryAppRunTimeLoader(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "queryAppRunTimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version);
    try
    {
      Iterator localIterator = new ArrayList(this.loadedRuntimeLinkedList).iterator();
      while (localIterator.hasNext())
      {
        BaseRuntimeLoader localBaseRuntimeLoader = (BaseRuntimeLoader)localIterator.next();
        if (localBaseRuntimeLoader.getMiniAppInfo() != null)
        {
          boolean bool = localBaseRuntimeLoader.getMiniAppInfo().equals(paramMiniAppInfo);
          if (bool) {
            return localBaseRuntimeLoader;
          }
        }
      }
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public void removeRuntimeLoader(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    if (paramBaseRuntimeLoader != null) {}
    try
    {
      if (this.loadedRuntimeLinkedList.remove(paramBaseRuntimeLoader))
      {
        QMLog.i("minisdk-start_AppRuntimeLoaderManager", "removed RuntimeLoader:" + paramBaseRuntimeLoader.toSimpleString());
        paramBaseRuntimeLoader.destroy();
        notifyRuntimeListInfo();
      }
      return;
    }
    finally
    {
      paramBaseRuntimeLoader = finally;
      throw paramBaseRuntimeLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager
 * JD-Core Version:    0.7.0.1
 */