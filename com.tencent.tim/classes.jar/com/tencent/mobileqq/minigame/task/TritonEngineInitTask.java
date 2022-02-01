package com.tencent.mobileqq.minigame.task;

import acfp;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.MiniAppClassloader;
import com.tencent.mobileqq.minigame.manager.EngineVersion;
import com.tencent.mobileqq.minigame.manager.GameEngineWrapper;
import com.tencent.mobileqq.minigame.manager.GameEnvManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.sdk.EnvConfig;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.TTEngineBuilder;
import com.tencent.mobileqq.triton.sdk.TTEngineBuilder.EngineCreationException;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import java.io.File;

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
  private MiniAppConfig mAppConfig;
  private int mEngineLoadResult = -1;
  private EnvConfig mEnvConfig;
  private GameEngineWrapper mGameEngine;
  private final IJSEngine mJSEngine;
  private IQQEnv mQQEnv;
  
  public TritonEngineInitTask(Context paramContext, IQQEnv paramIQQEnv, IJSEngine paramIJSEngine)
  {
    super(paramContext);
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
    if (!GameWnsUtils.gameEnableDexLoader()) {}
    do
    {
      return false;
      paramString = getTritonDexPath(paramString);
    } while (TextUtils.isEmpty(paramString));
    return new File(paramString).exists();
  }
  
  private boolean isGameSatisfy(EnvConfig paramEnvConfig, MiniAppConfig paramMiniAppConfig)
  {
    boolean bool = true;
    if (paramEnvConfig == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy envConfig == null");
      return false;
    }
    if (paramMiniAppConfig == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy gameConfig == null");
      return false;
    }
    paramMiniAppConfig = paramMiniAppConfig.config;
    if (paramMiniAppConfig == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy info == null");
      return false;
    }
    paramMiniAppConfig = paramMiniAppConfig.baselibMiniVersion;
    GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]isGameSatisfy minVersion=" + paramMiniAppConfig);
    if (TextUtils.isEmpty(paramMiniAppConfig)) {
      return true;
    }
    paramMiniAppConfig = new EngineVersion(paramMiniAppConfig);
    paramEnvConfig = EngineVersion.fromFolderName(paramEnvConfig.getJSPath());
    if (EngineVersion.compareVersion(paramEnvConfig.mMinor, paramMiniAppConfig.mMinor) >= 0) {}
    for (;;)
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]isGameSatisfy appMinVersion=" + paramMiniAppConfig + ", jsSdkVersion=" + paramEnvConfig + ",ret=" + bool);
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
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] TTEngineBuilder create TTEngine failed with exception", (Throwable)localObject);
      localObject = paramEnvConfig;
      continue;
      this.mGameEngine.setBaseEngine((ITTEngine)localObject);
      long l = System.currentTimeMillis();
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] initEngine");
      QLog.e("[minigame][timecost] ", 1, "[MiniEng] step[initTTEngine] cost time " + (System.currentTimeMillis() - l) + ", includes steps[load so, cache jssdk]");
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1015, "1");
      int i = 0;
    }
  }
  
  private void loadTritonEngine(EnvConfig paramEnvConfig)
  {
    if (this.mAppConfig == null)
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
      onTaskFailed(this.mEngineLoadResult, acfp.m(2131706748));
      return;
    }
    if (isGameSatisfy(paramEnvConfig, this.mAppConfig))
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
      MiniProgramLpReportDC04239.reportPageView(this.mAppConfig, "1", null, "load_fail", "load_baselib_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "load_baselib_fail", null, this.mAppConfig);
      onTaskFailed(this.mEngineLoadResult, acfp.m(2131706748));
      return;
    }
    if ((this.mAppConfig != null) && (this.mAppConfig.config != null) && (!TextUtils.isEmpty(this.mAppConfig.config.appId))) {
      MiniAppStartState.setBaseLibLoad(this.mAppConfig.config.appId, false);
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
  
  public MiniAppConfig getAppConfig()
  {
    return this.mAppConfig;
  }
  
  public EnvConfig getEnvConfig()
  {
    return this.mEnvConfig;
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mGameEngine;
  }
  
  @NonNull
  public String getName()
  {
    return "TritonEngineInitTask";
  }
  
  public void reset()
  {
    try
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]" + this + " reset ");
      this.mAppConfig = null;
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
  
  public void setAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.mAppConfig = paramMiniAppConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.TritonEngineInitTask
 * JD-Core Version:    0.7.0.1
 */