package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AppBrandProxyImpl
{
  private static final String TAG = "minisdk-start_AppBrandProxy";
  private static byte[] lock = new byte[0];
  private boolean isConnecting = false;
  private MiniAppInfo mAppConfig;
  private Messenger mClientMessenger;
  private ServiceConnection mConnection = new AppBrandProxyImpl.2(this);
  private Context mContext;
  private Handler.Callback mMessengerCallback = new AppBrandProxyImpl.1(this);
  private int mMiniAppStatus;
  private boolean mNeedSyncStatus = false;
  private IAppMainService mService;
  private Bundle mStartBundle;
  private List<Runnable> mTaskAfterConnected = new ArrayList();
  
  public AppBrandProxyImpl(Context paramContext)
  {
    this.mContext = paramContext;
    if (!isMainProcess()) {
      this.mClientMessenger = new Messenger(new Handler(Looper.getMainLooper(), this.mMessengerCallback));
    }
    ensureService();
  }
  
  private void doAfterServiceConnected()
  {
    try
    {
      Object localObject = new ArrayList(this.mTaskAfterConnected);
      this.mTaskAfterConnected.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "doAfterServiceConnected exception!", localThrowable);
    }
  }
  
  /* Error */
  private boolean ensureService()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 68	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:isMainProcess	()Z
    //   8: istore_1
    //   9: iload_1
    //   10: ifeq +9 -> 19
    //   13: iload_2
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 101	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:mService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   23: ifnull +8 -> 31
    //   26: iconst_1
    //   27: istore_1
    //   28: goto -13 -> 15
    //   31: iload_2
    //   32: istore_1
    //   33: aload_0
    //   34: getfield 43	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:isConnecting	Z
    //   37: ifne -22 -> 15
    //   40: iload_2
    //   41: istore_1
    //   42: aload_0
    //   43: getfield 101	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:mService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   46: ifnonnull -31 -> 15
    //   49: ldc 8
    //   51: ldc 157
    //   53: invokestatic 161	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: new 163	android/content/Intent
    //   59: dup
    //   60: aload_0
    //   61: getfield 64	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:mContext	Landroid/content/Context;
    //   64: ldc 165
    //   66: invokespecial 168	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   69: astore_3
    //   70: aload_3
    //   71: ldc 170
    //   73: invokestatic 176	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   76: invokevirtual 180	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getCurrentProcessName	()Ljava/lang/String;
    //   79: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   82: pop
    //   83: aload_3
    //   84: ldc 186
    //   86: aload_0
    //   87: getfield 86	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:mClientMessenger	Landroid/os/Messenger;
    //   90: invokevirtual 189	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   93: pop
    //   94: aload_0
    //   95: iconst_1
    //   96: putfield 43	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:isConnecting	Z
    //   99: aload_0
    //   100: getfield 64	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:mContext	Landroid/content/Context;
    //   103: aload_3
    //   104: aload_0
    //   105: getfield 62	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:mConnection	Landroid/content/ServiceConnection;
    //   108: iconst_1
    //   109: invokevirtual 195	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   112: pop
    //   113: iload_2
    //   114: istore_1
    //   115: goto -100 -> 15
    //   118: astore_3
    //   119: ldc 8
    //   121: ldc 197
    //   123: aload_3
    //   124: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: iload_2
    //   128: istore_1
    //   129: goto -114 -> 15
    //   132: astore_3
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	AppBrandProxyImpl
    //   8	121	1	bool1	boolean
    //   1	127	2	bool2	boolean
    //   69	35	3	localIntent	android.content.Intent
    //   118	6	3	localThrowable	Throwable
    //   132	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   99	113	118	java/lang/Throwable
    //   4	9	132	finally
    //   19	26	132	finally
    //   33	40	132	finally
    //   42	99	132	finally
    //   99	113	132	finally
    //   119	127	132	finally
  }
  
  private static BaseRuntime getBaseRuntime(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    paramMiniAppInfo = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime loader is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return null;
    }
    paramMiniAppInfo = paramMiniAppInfo.getRuntime();
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return null;
    }
    return paramMiniAppInfo;
  }
  
  private void handleCmdFromMainProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    QMLog.i("minisdk-start_AppBrandProxy", "Messenger handleCmdFromMainProcess cmd=" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if (paramBundle == null)
      {
        QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_SHARE_RESULT. bundle is null");
        sendResult(paramResultReceiver, -1, paramBundle);
        return;
      }
      notifyShareResult(paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    if (paramBundle == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_PERIODIC_CACHE_UPDATE. bundle is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    notifyPeriodicCacheUpdate(paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  private boolean isMainProcess()
  {
    return AppLoaderFactory.g().isMainProcess();
  }
  
  private void notifyLifeCycleLocked(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putParcelableArrayList("bundle_key_runtime_list", AppRuntimeLoaderManager.g().getAllLoadedAppInfos());
    this.mService.onAppLifecycle(paramInt, paramString, paramMiniAppInfo, localBundle);
  }
  
  private void notifyToService()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.mNeedSyncStatus;
        if (!bool) {
          return;
        }
        this.mNeedSyncStatus = false;
        try
        {
          String str1 = AppLoaderFactory.g().getCurrentProcessName();
          if (!queryIsMiniProcess()) {
            continue;
          }
          QMLog.w("minisdk-start_AppBrandProxy", "Sync Process Status=" + this.mMiniAppStatus);
          notifyLifeCycleLocked(1, str1, this.mAppConfig, this.mStartBundle);
          if (this.mMiniAppStatus != 3) {
            break label115;
          }
          notifyLifeCycleLocked(3, str1, this.mAppConfig, null);
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("minisdk-start_AppBrandProxy", "onAppStart exception.", localThrowable);
        }
        continue;
        if (this.mMiniAppStatus != 2) {
          continue;
        }
      }
      finally {}
      label115:
      notifyLifeCycleLocked(2, str2, this.mAppConfig, null);
    }
  }
  
  private void performStartMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    try
    {
      this.mService.startMiniApp(paramMiniAppInfo, paramBundle, new AppBrandProxyImpl.5(this, new Handler(Looper.getMainLooper()), paramResultReceiver, paramActivity));
      return;
    }
    catch (Throwable paramActivity)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp exception.", paramActivity);
    }
  }
  
  private static void sendResult(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    if (paramResultReceiver == null) {
      return;
    }
    paramResultReceiver.send(paramInt, paramBundle);
  }
  
  /* Error */
  public IAppMainService getService()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 101	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:mService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 101	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:mService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokespecial 89	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:ensureService	()Z
    //   22: pop
    //   23: aload_0
    //   24: getfield 101	com/tencent/qqmini/sdk/ipc/AppBrandProxyImpl:mService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   27: astore_1
    //   28: goto -14 -> 14
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	AppBrandProxyImpl
    //   13	15	1	localIAppMainService	IAppMainService
    //   31	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	31	finally
    //   18	28	31	finally
  }
  
  public void notifyPeriodicCacheUpdate(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Object localObject = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    if (localObject == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime loader is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    localObject = ((BaseRuntimeLoader)localObject).getRuntime();
    if (localObject == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    localObject = ((BaseRuntime)localObject).getJsService();
    if (localObject == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, jsService is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    QMLog.i("minisdk-start_AppBrandProxy", "evaluateSubscribeJS ON_BACKGROUND_FETCH_DATA appid:" + paramMiniAppInfo.appId);
    ((IJsService)localObject).evaluateSubscribeJS("onBackgroundFetchData", new JSONObject().toString(), 0);
    sendResult(paramResultReceiver, 0, paramBundle);
  }
  
  public void notifyShareResult(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    paramMiniAppInfo = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime loader is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    paramMiniAppInfo = paramMiniAppInfo.getRuntime();
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    IJsService localIJsService = paramMiniAppInfo.getJsService();
    if (localIJsService == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, jsService is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    paramResultReceiver = GetShareState.obtain(paramMiniAppInfo);
    if (paramBundle.getInt("key_share_result") == 0) {}
    for (paramMiniAppInfo = ApiUtil.wrapCallbackOk(paramResultReceiver.shareEvent, null);; paramMiniAppInfo = ApiUtil.wrapCallbackFail(paramResultReceiver.shareEvent, null))
    {
      localIJsService.evaluateCallbackJs(paramResultReceiver.shareCallbackId, paramMiniAppInfo.toString());
      return;
    }
  }
  
  public void onAppLifecycle(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    this.mAppConfig = paramMiniAppInfo;
    if (paramInt == 1)
    {
      if (this.mMiniAppStatus < 1) {
        this.mMiniAppStatus = 1;
      }
      if (getService() == null)
      {
        this.mNeedSyncStatus = true;
        this.mStartBundle = paramBundle;
        QMLog.e("minisdk-start_AppBrandProxy", "onAppStart IAppBrandService Connection is Null.");
      }
    }
    for (;;)
    {
      return;
      try
      {
        QMLog.i("minisdk-start_AppBrandProxy", "notify onAppStart");
        notifyLifeCycleLocked(1, paramString, paramMiniAppInfo, paramBundle);
        if (paramMiniAppInfo == null) {
          continue;
        }
        QMLog.i("minisdk-start_AppBrandProxy", "notify onAppForeground after onAppStart");
        notifyLifeCycleLocked(2, paramString, paramMiniAppInfo, paramBundle);
        return;
      }
      catch (Throwable paramString)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppStart exception.", paramString);
        return;
      }
      this.mMiniAppStatus = paramInt;
      if (getService() == null)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppLifecycle IAppBrandService Connection is Null. lifecycle:" + paramInt);
        return;
      }
      try
      {
        QMLog.i("minisdk-start_AppBrandProxy", "notify lifecycle:" + paramInt);
        notifyLifeCycleLocked(paramInt, paramString, paramMiniAppInfo, paramBundle);
        if (paramInt == 4)
        {
          releaseService();
          return;
        }
      }
      catch (Throwable paramString)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppLifecycle exception. lifecycle:" + paramInt, paramString);
      }
    }
  }
  
  public void preloadPackage(MiniAppInfo paramMiniAppInfo)
  {
    IAppMainService localIAppMainService = getService();
    paramMiniAppInfo = new AppBrandProxyImpl.3(this, localIAppMainService, paramMiniAppInfo);
    if (localIAppMainService != null)
    {
      paramMiniAppInfo.run();
      return;
    }
    this.mTaskAfterConnected.add(paramMiniAppInfo);
  }
  
  public boolean queryIsMiniProcess()
  {
    bool2 = false;
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "queryiIsMiniProcess IAppBrandService Connection is Null.");
      return false;
    }
    try
    {
      Bundle localBundle = this.mService.requestAync("query_mini_process", AppLoaderFactory.g().getCurrentProcessName(), null);
      bool1 = bool2;
      if (localBundle != null) {
        bool1 = localBundle.getBoolean("key_result");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "queryiIsMiniProcess exception.", localThrowable);
        boolean bool1 = bool2;
      }
    }
    QMLog.i("minisdk-start_AppBrandProxy", "queryiIsMiniProcess " + bool1);
    return bool1;
  }
  
  protected void releaseService()
  {
    QMLog.w("minisdk-start_AppBrandProxy", "releaseService.");
    try
    {
      if (this.mService != null)
      {
        this.mContext.unbindService(this.mConnection);
        this.mService = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "exception when releaseService.");
    }
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "sendCmd IAppBrandService Connection is Null. cmd=" + paramString);
      this.mTaskAfterConnected.add(new AppBrandProxyImpl.8(this, paramString, paramMiniCmdCallback, paramBundle));
      return;
    }
    try
    {
      this.mService.sendCmd(paramString, AppLoaderFactory.g().getCurrentProcessName(), paramBundle, paramMiniCmdCallback);
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "sendCmd exception.", paramString);
    }
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp IAppBrandService Connection is Null.");
      this.mTaskAfterConnected.add(new AppBrandProxyImpl.4(this, paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver));
      return;
    }
    performStartMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void stopAllMiniApp()
  {
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopAllMiniApp IAppBrandService Connection is Null.");
      this.mTaskAfterConnected.add(new AppBrandProxyImpl.7(this));
      return;
    }
    try
    {
      this.mService.stopAllMiniApp();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", localThrowable);
    }
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp IAppBrandService Connection is Null.");
      this.mTaskAfterConnected.add(new AppBrandProxyImpl.6(this, paramMiniAppInfo));
      return;
    }
    try
    {
      this.mService.stopMiniApp(paramMiniAppInfo);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", paramMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl
 * JD-Core Version:    0.7.0.1
 */