package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime.RuntimeMsgObserver;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.TaskFlowEngine;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@MiniKeep
public abstract class BaseRuntimeLoader
  extends TaskFlowEngine
  implements Handler.Callback, IMiniLifecycle, BaseRuntime.RuntimeMsgObserver
{
  public static final String TAG = "BaseRuntimeLoader";
  private boolean hasTaskFailed;
  private boolean isSucceed;
  private Map<String, BaseTask> mActivatedTasks;
  private final AppStateManager mAppStateManager;
  protected Context mContext;
  private final AppRuntimeEventCenter mEventCenter;
  protected Handler mHandler;
  protected boolean mIsRunning;
  protected MiniAppInfo mMiniAppInfo;
  protected BaseRuntime mRuntime;
  protected OnAppRuntimeLoadListener mRuntimeLoadListener;
  protected boolean runtimeLoadCompleted;
  
  /* Error */
  public BaseRuntimeLoader(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 50	com/tencent/qqmini/sdk/task/TaskFlowEngine:<init>	()V
    //   4: aload_0
    //   5: new 52	com/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter
    //   8: dup
    //   9: invokespecial 53	com/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter:<init>	()V
    //   12: putfield 55	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mEventCenter	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter;
    //   15: aload_0
    //   16: new 57	com/tencent/qqmini/sdk/launcher/AppStateManager
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 60	com/tencent/qqmini/sdk/launcher/AppStateManager:<init>	(Lcom/tencent/qqmini/sdk/launcher/BaseRuntimeLoader;)V
    //   24: putfield 62	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mAppStateManager	Lcom/tencent/qqmini/sdk/launcher/AppStateManager;
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 64	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mIsRunning	Z
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield 66	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:runtimeLoadCompleted	Z
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 68	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:isSucceed	Z
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 70	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:hasTaskFailed	Z
    //   47: aload_0
    //   48: aload_1
    //   49: putfield 72	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mContext	Landroid/content/Context;
    //   52: aload_0
    //   53: new 74	java/util/HashMap
    //   56: dup
    //   57: invokespecial 75	java/util/HashMap:<init>	()V
    //   60: putfield 77	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mActivatedTasks	Ljava/util/Map;
    //   63: aload_0
    //   64: getfield 55	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mEventCenter	Lcom/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter;
    //   67: aload_0
    //   68: getfield 62	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mAppStateManager	Lcom/tencent/qqmini/sdk/launcher/AppStateManager;
    //   71: invokevirtual 81	com/tencent/qqmini/sdk/launcher/AppRuntimeEventCenter:addObserver	(Ljava/util/Observer;)V
    //   74: aload_0
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 72	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mContext	Landroid/content/Context;
    //   80: invokevirtual 85	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:createRuntime	(Landroid/content/Context;)Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;
    //   83: putfield 87	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mRuntime	Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;
    //   86: aload_0
    //   87: getfield 87	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mRuntime	Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;
    //   90: aload_0
    //   91: invokevirtual 93	com/tencent/qqmini/sdk/launcher/core/BaseRuntime:setRuntimeMsgObserver	(Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime$RuntimeMsgObserver;)V
    //   94: new 95	android/os/HandlerThread
    //   97: dup
    //   98: ldc 97
    //   100: iconst_5
    //   101: invokespecial 100	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   104: astore_2
    //   105: aload_2
    //   106: astore_1
    //   107: aload_2
    //   108: invokevirtual 103	android/os/HandlerThread:start	()V
    //   111: aload_2
    //   112: ifnull +31 -> 143
    //   115: aload_2
    //   116: invokevirtual 107	android/os/HandlerThread:isAlive	()Z
    //   119: ifeq +24 -> 143
    //   122: aload_0
    //   123: new 109	android/os/Handler
    //   126: dup
    //   127: aload_2
    //   128: invokevirtual 113	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   131: aload_0
    //   132: invokespecial 116	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   135: putfield 118	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   138: aload_0
    //   139: invokespecial 121	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:initTask	()V
    //   142: return
    //   143: aload_0
    //   144: new 109	android/os/Handler
    //   147: dup
    //   148: invokestatic 126	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   151: aload_0
    //   152: invokespecial 116	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   155: putfield 118	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   158: goto -20 -> 138
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_2
    //   164: aload_2
    //   165: astore_1
    //   166: ldc 21
    //   168: ldc 128
    //   170: aload_3
    //   171: invokestatic 134	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_2
    //   175: ifnull +29 -> 204
    //   178: aload_2
    //   179: invokevirtual 107	android/os/HandlerThread:isAlive	()Z
    //   182: ifeq +22 -> 204
    //   185: aload_0
    //   186: new 109	android/os/Handler
    //   189: dup
    //   190: aload_2
    //   191: invokevirtual 113	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   194: aload_0
    //   195: invokespecial 116	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   198: putfield 118	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   201: goto -63 -> 138
    //   204: aload_0
    //   205: new 109	android/os/Handler
    //   208: dup
    //   209: invokestatic 126	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   212: aload_0
    //   213: invokespecial 116	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   216: putfield 118	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   219: goto -81 -> 138
    //   222: astore_2
    //   223: aconst_null
    //   224: astore_1
    //   225: aload_1
    //   226: ifnull +28 -> 254
    //   229: aload_1
    //   230: invokevirtual 107	android/os/HandlerThread:isAlive	()Z
    //   233: ifeq +21 -> 254
    //   236: aload_0
    //   237: new 109	android/os/Handler
    //   240: dup
    //   241: aload_1
    //   242: invokevirtual 113	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   245: aload_0
    //   246: invokespecial 116	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   249: putfield 118	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   252: aload_2
    //   253: athrow
    //   254: aload_0
    //   255: new 109	android/os/Handler
    //   258: dup
    //   259: invokestatic 126	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   262: aload_0
    //   263: invokespecial 116	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   266: putfield 118	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   269: goto -17 -> 252
    //   272: astore_2
    //   273: goto -48 -> 225
    //   276: astore_3
    //   277: goto -113 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	BaseRuntimeLoader
    //   0	280	1	paramContext	Context
    //   104	87	2	localHandlerThread	android.os.HandlerThread
    //   222	31	2	localObject1	Object
    //   272	1	2	localObject2	Object
    //   161	10	3	localException1	java.lang.Exception
    //   276	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   94	105	161	java/lang/Exception
    //   94	105	222	finally
    //   107	111	272	finally
    //   166	174	272	finally
    //   107	111	276	java/lang/Exception
  }
  
  private final void initTask()
  {
    BaseTask[] arrayOfBaseTask = createTasks();
    initTasks(arrayOfBaseTask);
    if (arrayOfBaseTask != null)
    {
      int j = arrayOfBaseTask.length;
      int i = 0;
      while (i < j)
      {
        registTaskName(arrayOfBaseTask[i]);
        i += 1;
      }
    }
  }
  
  private void registTaskName(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    for (;;)
    {
      return;
      addTask(paramBaseTask);
      paramBaseTask = paramBaseTask.getDependTasks();
      if ((paramBaseTask != null) && (paramBaseTask.size() > 0))
      {
        paramBaseTask = paramBaseTask.iterator();
        while (paramBaseTask.hasNext()) {
          registTaskName((BaseTask)paramBaseTask.next());
        }
      }
    }
  }
  
  /* Error */
  private void restartFailTaskIfNeed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:hasTaskFailed	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 70	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:hasTaskFailed	Z
    //   19: aload_0
    //   20: getfield 180	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:mAllTasks	Ljava/util/List;
    //   23: invokeinterface 166 1 0
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 171 1 0
    //   35: ifeq -24 -> 11
    //   38: aload_2
    //   39: invokeinterface 175 1 0
    //   44: checkcast 152	com/tencent/qqmini/sdk/task/BaseTask
    //   47: astore_3
    //   48: aload_3
    //   49: invokevirtual 182	com/tencent/qqmini/sdk/task/BaseTask:isSucceed	()Z
    //   52: ifne -23 -> 29
    //   55: aload_3
    //   56: invokevirtual 185	com/tencent/qqmini/sdk/task/BaseTask:reset	()V
    //   59: aload_0
    //   60: aload_3
    //   61: invokevirtual 188	com/tencent/qqmini/sdk/launcher/BaseRuntimeLoader:executeTask	(Lcom/tencent/qqmini/sdk/task/BaseTask;)V
    //   64: goto -35 -> 29
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	BaseRuntimeLoader
    //   6	2	1	bool	boolean
    //   28	11	2	localIterator	Iterator
    //   67	4	2	localObject	Object
    //   47	14	3	localBaseTask	BaseTask
    // Exception table:
    //   from	to	target	type
    //   2	7	67	finally
    //   14	29	67	finally
    //   29	64	67	finally
  }
  
  public void addRuntimeStateObserver(AppRuntimeEventCenter.RuntimeStateObserver paramRuntimeStateObserver)
  {
    this.mEventCenter.addObserver(paramRuntimeStateObserver);
  }
  
  public void addTask(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    String str;
    do
    {
      return;
      str = paramBaseTask.getClass().getCanonicalName();
    } while (this.mActivatedTasks.containsKey(str));
    this.mActivatedTasks.put(str, paramBaseTask);
  }
  
  protected abstract BaseRuntime createRuntime(Context paramContext);
  
  public abstract BaseTask[] createTasks();
  
  public void destroy()
  {
    pause();
    this.mRuntimeLoadListener = null;
    this.mEventCenter.deleteObservers();
    if (this.mRuntime != null) {
      this.mRuntime.onRuntimeDestroy();
    }
  }
  
  public boolean dismissLoadingAfterLoaded()
  {
    return false;
  }
  
  public AppStateManager getAppStateManager()
  {
    return this.mAppStateManager;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public MiniAppInfo getMiniAppInfoForReport()
  {
    if (this.mMiniAppInfo == null) {
      return MiniProgramReportHelper.miniAppConfigForPreload();
    }
    return this.mMiniAppInfo;
  }
  
  public BaseRuntime getRuntime()
  {
    return this.mRuntime;
  }
  
  public BaseTask getTask(Class paramClass)
  {
    return (BaseTask)this.mActivatedTasks.get(paramClass.getCanonicalName());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    QMLog.d("BaseRuntimeLoader", "handleMessage " + paramMessage.what);
    return false;
  }
  
  public boolean isLoadSucceed()
  {
    return (this.runtimeLoadCompleted) && (this.isSucceed);
  }
  
  public void notifyRuntimeEvent(int paramInt, Object... paramVarArgs)
  {
    AppRuntimeEventCenter.MiniAppStateMessage localMiniAppStateMessage = AppRuntimeEventCenter.MiniAppStateMessage.obtainMessage(paramInt, this);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      localMiniAppStateMessage.obj = paramVarArgs[0];
    }
    this.mEventCenter.notifyChange(localMiniAppStateMessage);
  }
  
  public void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onAttachActivity isLoadSucceed=" + isLoadSucceed());
    this.mRuntime.onRuntimeAttachActivity(paramActivity, paramViewGroup);
  }
  
  public void onDetachActivity(Activity paramActivity)
  {
    onDetachActivity(paramActivity, true);
  }
  
  public void onDetachActivity(Activity paramActivity, boolean paramBoolean)
  {
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onDetachActivity needDestroy=" + paramBoolean + " isLoadSucceed=" + isLoadSucceed());
    this.mRuntime.onRuntimeDetachActivity(paramActivity);
    notifyRuntimeEvent(62, new Object[0]);
    if (paramBoolean)
    {
      AppRuntimeLoaderManager.g().removeRuntimeLoader(this);
      destroy();
    }
  }
  
  @Deprecated
  public void onIntentUpdate(Intent paramIntent) {}
  
  public void onMiniPause()
  {
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onMiniPause isLoadSucceed=" + isLoadSucceed());
    this.mRuntime.onRuntimePause();
    notifyRuntimeEvent(24, new Object[0]);
  }
  
  public void onMiniResume()
  {
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onMiniResume isLoadSucceed=" + isLoadSucceed());
    this.mRuntime.onRuntimeResume();
    notifyRuntimeEvent(21, new Object[0]);
  }
  
  public void onMiniStart()
  {
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onMiniStart");
    this.mRuntime.onRuntimeStart();
  }
  
  public void onMiniStop()
  {
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onMiniStop isLoadSucceed=" + isLoadSucceed());
    this.mRuntime.onRuntimeStop();
    notifyRuntimeEvent(22, new Object[0]);
  }
  
  protected void onRuntimeLoadResult(int paramInt, String paramString)
  {
    boolean bool = true;
    this.runtimeLoadCompleted = true;
    if (paramInt == 0) {}
    for (;;)
    {
      this.isSucceed = bool;
      if (this.mRuntimeLoadListener != null) {
        this.mRuntimeLoadListener.onResult(paramInt, paramString, this);
      }
      return;
      bool = false;
    }
  }
  
  public void onRuntimeMessage(int paramInt, Object paramObject)
  {
    notifyRuntimeEvent(paramInt, new Object[] { paramObject });
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    QMLog.d("BaseRuntimeLoader", toSimpleString() + " onTaskDone " + paramBaseTask + " isSucc=" + paramBaseTask.isSucceed());
    if (!paramBaseTask.isSucceed()) {
      this.hasTaskFailed = true;
    }
    super.onTaskDone(paramBaseTask);
  }
  
  public void pause()
  {
    this.mIsRunning = false;
    super.pause();
  }
  
  public void removeRuntimeStateObserver(AppRuntimeEventCenter.RuntimeStateObserver paramRuntimeStateObserver)
  {
    this.mEventCenter.deleteObserver(paramRuntimeStateObserver);
  }
  
  public void resetAndStart(MiniAppInfo paramMiniAppInfo) {}
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    if ((paramMiniAppInfo.apkgInfo == null) && (this.mMiniAppInfo != null)) {
      paramMiniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
    }
    this.mMiniAppInfo = paramMiniAppInfo;
    restartFailTaskIfNeed();
  }
  
  public void setRuntime(BaseRuntime paramBaseRuntime)
  {
    this.mRuntime = paramBaseRuntime;
  }
  
  public void setRuntimeLoadListener(OnAppRuntimeLoadListener paramOnAppRuntimeLoadListener)
  {
    this.mRuntimeLoadListener = paramOnAppRuntimeLoadListener;
  }
  
  public void start()
  {
    if (this.mIsRunning) {
      return;
    }
    this.mIsRunning = true;
    this.runtimeLoadCompleted = false;
    this.isSucceed = false;
    super.start();
    notifyRuntimeEvent(2, new Object[0]);
  }
  
  public void startLoadMiniAppContent(boolean paramBoolean)
  {
    this.mRuntime.onLoadMiniAppInfo(this.mMiniAppInfo, paramBoolean, null);
  }
  
  public void startUpdateMiniAppInfo()
  {
    if (this.mRuntime == null) {
      return;
    }
    this.mRuntime.onUpdateMiniAppInfo(this.mMiniAppInfo);
  }
  
  public String toSimpleString()
  {
    return "RuntimeLoader(" + getClass().getSimpleName() + ")@" + hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{Runtime:");
    if (this.mRuntime != null)
    {
      str = this.mRuntime.getClass().getSimpleName() + "@" + this.mRuntime.hashCode();
      localStringBuilder = localStringBuilder.append(str).append(" AppInfo=");
      if (this.mMiniAppInfo == null) {
        break label110;
      }
    }
    label110:
    for (String str = this.mMiniAppInfo.toSimpleString();; str = "N/A")
    {
      return str + "}";
      str = "N/A";
      break;
    }
  }
  
  public void updateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    paramMiniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
    this.mMiniAppInfo = paramMiniAppInfo;
    startUpdateMiniAppInfo();
  }
  
  public void updateMiniAppInfoFromReload(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    paramMiniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
    this.mMiniAppInfo = paramMiniAppInfo;
    startLoadMiniAppContent(true);
  }
  
  protected void updateMiniGameInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
  }
  
  public static abstract interface Creator<T>
  {
    public abstract T create(Context paramContext, Bundle paramBundle);
    
    public abstract void doPrepareEngine(Bundle paramBundle);
    
    public abstract boolean isEnginePrepared(Bundle paramBundle);
    
    public abstract boolean support(MiniAppInfo paramMiniAppInfo);
  }
  
  public static abstract interface OnAppRuntimeLoadListener
  {
    public abstract void onResult(int paramInt, String paramString, BaseRuntimeLoader paramBaseRuntimeLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */