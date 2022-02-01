package com.tencent.qqmini.minigame.task;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.EnvConfig;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.TTEngineBuilder;
import com.tencent.mobileqq.triton.sdk.TTEngineBuilder.EngineCreationException;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.qqmini.minigame.manager.GameEngineWrapper;
import com.tencent.qqmini.minigame.manager.GameEnvManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.MiniAppClassloader;
import java.io.File;

@ClassTag(tag="TritonEngineInitTask")
public class TritonEngineInitTask
  extends AsyncTask
{
  public static final int ENG_NOT_LOAD = -1;
  public static final int ERR_ENGINE_NEED_UPDATE = 101;
  public static final int ERR_ENGINE_NULL = 105;
  public static final int ERR_ENGINE_TIMEOUT = 103;
  public static final int ERR_ENGINE_VERSION = 104;
  public static final int ERR_INIT_ENGINE = 109;
  public static final int ERR_INIT_NDK = 108;
  public static final int ERR_INTERNAL = 102;
  public static final int ERR_LOAD_JAR = 106;
  public static final int ERR_LOAD_SO = 107;
  public static final int ERR_UNKNOWN = 100;
  public static final int SUCCEED = 0;
  public final String LOG_TAG = toString();
  private int mEngineLoadResult = -1;
  private EnvConfig mEnvConfig;
  private GameEngineWrapper mGameEngine;
  private final IJSEngine mJSEngine;
  private MiniAppInfo mMiniAppInfo;
  private IQQEnv mQQEnv;
  
  public TritonEngineInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader, IQQEnv paramIQQEnv, IJSEngine paramIJSEngine)
  {
    super(paramContext, paramBaseRuntimeLoader);
    GameLog.getInstance().i(this.LOG_TAG, "new TritonEngineInitTask");
    this.mQQEnv = paramIQQEnv;
    this.mJSEngine = paramIJSEngine;
    this.mGameEngine = new GameEngineWrapper();
  }
  
  private String getTritonDexPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramString.endsWith(File.separator)) {}
    for (paramString = "";; paramString = File.separator) {
      return paramString + "triton.jar";
    }
  }
  
  private boolean hasNewEngineDex(String paramString)
  {
    if (!GameWnsUtils.gameEnableDexLoader()) {
      return false;
    }
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localChannelProxy != null) && (localChannelProxy.isGooglePlayVersion()))
    {
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_load_so_switch", 0) == 1) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
    }
    paramString = getTritonDexPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  private boolean isGameSatisfy(EnvConfig paramEnvConfig, MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (paramEnvConfig == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy envConfig == null");
      return false;
    }
    if (paramMiniAppInfo == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy info == null");
      return false;
    }
    paramMiniAppInfo = paramMiniAppInfo.baselibMiniVersion;
    GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]isGameSatisfy minVersion=" + paramMiniAppInfo);
    if (TextUtils.isEmpty(paramMiniAppInfo)) {
      return true;
    }
    paramMiniAppInfo = new EngineVersion(paramMiniAppInfo);
    paramEnvConfig = EngineVersion.fromFolderName(paramEnvConfig.getJSPath());
    if ((paramEnvConfig != null) && (EngineVersion.compareVersion(paramEnvConfig.mMinor, paramMiniAppInfo.mMinor) >= 0)) {}
    for (;;)
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]isGameSatisfy appMinVersion=" + paramMiniAppInfo + ", jsSdkVersion=" + paramEnvConfig + ",ret=" + bool);
      return bool;
      bool = false;
    }
  }
  
  private int loadEngine(EnvConfig paramEnvConfig)
  {
    for (;;)
    {
      try
      {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1014, "1");
        TTEngineBuilder localTTEngineBuilder = new TTEngineBuilder();
        localTTEngineBuilder.setContext(this.mContext).setQQEnv(this.mQQEnv).setLog(GameLog.getInstance()).setJsEngine(this.mJSEngine).setEnvConfig(paramEnvConfig);
        ClassLoader localClassLoader = getClass().getClassLoader();
        localObject = null;
        try
        {
          if (hasNewEngineDex(paramEnvConfig.getTritonPath()))
          {
            GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] TTEngineBuilder create TTEngine from dex");
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1003, "1");
            paramEnvConfig = localTTEngineBuilder.build(new MiniAppClassloader(getTritonDexPath(paramEnvConfig.getTritonPath()), this.mContext.getApplicationInfo().nativeLibraryDir, getClass().getClassLoader()));
            localObject = paramEnvConfig;
            if (paramEnvConfig == null) {}
          }
        }
        catch (TTEngineBuilder.EngineCreationException localEngineCreationException2)
        {
          paramEnvConfig = (EnvConfig)localObject;
          localObject = localEngineCreationException2;
        }
      }
      finally {}
      try
      {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1004, "1");
        localObject = paramEnvConfig;
        if (localObject != null) {
          continue;
        }
        GameLog.getInstance().e(this.LOG_TAG, "[MiniEng] TTEngineBuilder create TTEngine return null");
        i = 106;
        return i;
      }
      catch (TTEngineBuilder.EngineCreationException localEngineCreationException1)
      {
        continue;
      }
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] TTEngineBuilder create TTEngine from local lib");
      paramEnvConfig = localTTEngineBuilder.build(localClassLoader);
      Object localObject = paramEnvConfig;
      continue;
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng] TTEngineBuilder create TTEngine failed with exception", (Throwable)localObject);
      localObject = paramEnvConfig;
      continue;
      this.mGameEngine.setBaseEngine((ITTEngine)localObject);
      long l = System.currentTimeMillis();
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] initEngine");
      QMLog.e("[minigame][timecost] ", "[MiniEng] step[initTTEngine] cost time " + (System.currentTimeMillis() - l) + ", includes steps[load so, cache jssdk]");
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1015, "1");
      int i = 0;
    }
  }
  
  private void loadTritonEngine(EnvConfig paramEnvConfig)
  {
    if (this.mMiniAppInfo == null)
    {
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.LOG_TAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
        return;
      }
      this.mEngineLoadResult = loadEngine(paramEnvConfig);
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      onTaskFailed(this.mEngineLoadResult, "加载引擎失败");
      return;
    }
    if (isGameSatisfy(paramEnvConfig, this.mMiniAppInfo))
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1012, "1");
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.LOG_TAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
        return;
      }
      this.mEngineLoadResult = loadEngine(paramEnvConfig);
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "load_baselib_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "load_baselib_fail", null, this.mMiniAppInfo);
      onTaskFailed(this.mEngineLoadResult, "加载引擎失败");
      return;
    }
    if ((this.mMiniAppInfo != null) && (!TextUtils.isEmpty(this.mMiniAppInfo.appId))) {
      MiniAppStartState.setBaseLibLoad(this.mMiniAppInfo.appId, false);
    }
    onTaskFailed(104, "请升级QQ版本");
  }
  
  public void executeAsync()
  {
    this.mEnvConfig = GameEnvManager.getEnvConfig();
    this.mEnvConfig.setDisplayMetrics(DisplayUtil.getDisplayMetrics(this.mContext));
    this.mEnvConfig.setScreenRefreshRate(DisplayUtil.getScreenRefreshRate(this.mContext));
    loadTritonEngine(this.mEnvConfig);
  }
  
  public EnvConfig getEnvConfig()
  {
    return this.mEnvConfig;
  }
  
  @NonNull
  public TaskExecutionStatics getExecutionStatics()
  {
    return super.getExecutionStatics();
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mGameEngine;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public void reset()
  {
    try
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]" + this + " reset ");
      this.mMiniAppInfo = null;
      this.mEngineLoadResult = -1;
      super.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.TritonEngineInitTask
 * JD-Core Version:    0.7.0.1
 */