package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.mobileqq.triton.sdk.statics.GameLaunchStatistic;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.minigame.task.LaunchEngineUISteps;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.AppRuntimeEventCenter.MiniAppStateMessage;
import com.tencent.qqmini.sdk.launcher.AppRuntimeEventCenter.RuntimeStateObserver;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniGdtReporter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer;
import java.util.List;
import org.json.JSONObject;

public class GameRuntimeStateObserver
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  private static final long JANK_TRACE_REPORT_MIN_RUN_DURATION_MS = 30000L;
  private static final String TAG = "GameRuntimeState";
  private Activity mActivity;
  private long mBeginOnCreate;
  private final Runnable mGameLaunchWatchDog = new GameRuntimeStateObserver.1(this);
  private GameUIProxy mGameUI;
  private long mLastOnShowTime;
  private final LaunchEngineUISteps mLaunchEngineUISteps = new LaunchEngineUISteps(AppLoaderFactory.g().getContext());
  private long mLoadGameStartTime;
  private LoadingUI mLoadingUI;
  private final Handler mMainHandler = new Handler(Looper.getMainLooper());
  private MiniAppInfo mMiniAppInfo;
  private long mOnGameLaunchedTime;
  private long mOnGameSurfaceCreateTime;
  
  GameRuntimeStateObserver(GameUIProxy paramGameUIProxy)
  {
    this.mGameUI = paramGameUIProxy;
  }
  
  private IJsService getJsService()
  {
    return this.mGameUI.getJsService();
  }
  
  @NonNull
  private List<TaskExecutionStatics> getTaskExecutionStatics()
  {
    List localList = this.mGameUI.getTaskStatics();
    localList.add(this.mLaunchEngineUISteps.getExecutionStatics());
    return localList;
  }
  
  private void notifyGameOnHide()
  {
    if (getJsService() != null)
    {
      QMLog.i("GameRuntimeState", "onHide(). " + this.mMiniAppInfo);
      getJsService().evaluateSubscribeJS("onAppEnterBackground", "", -1);
    }
  }
  
  private void notifyGameOnShow()
  {
    if (getJsService() != null)
    {
      localObject = this.mGameUI.getGameRuntime().getGameInfoManager();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    JSONObject localJSONObject = ((GameInfoManager)localObject).getOnShowParam();
    StringBuilder localStringBuilder = new StringBuilder().append("onShow(");
    if (localJSONObject == null) {}
    for (Object localObject = "";; localObject = localJSONObject.toString())
    {
      QMLog.i("GameRuntimeState", (String)localObject + "). " + this.mMiniAppInfo);
      getJsService().evaluateSubscribeJS("onAppEnterForeground", localJSONObject.toString(), -1);
      return;
    }
  }
  
  private void notifyGameStop()
  {
    if (getJsService() != null)
    {
      QMLog.i("GameRuntimeState", "onAppStop(). " + this.mMiniAppInfo);
      getJsService().evaluateSubscribeJS("onAppStop", "", -1);
    }
  }
  
  private void reportJankTraceStatistics(boolean paramBoolean)
  {
    this.mGameUI.getTraceStatistics(new GameRuntimeStateObserver.6(this, paramBoolean));
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    this.mMainHandler.post(paramRunnable);
  }
  
  private void updateLoadingProcessText(String paramString, float paramFloat)
  {
    if (this.mLoadingUI == null) {
      return;
    }
    runOnUiThread(new GameRuntimeStateObserver.7(this, paramString, paramFloat));
  }
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if (paramMiniAppStateMessage.appRuntimeLoader != this.mGameUI.getRuntimeLoader()) {}
    label565:
    do
    {
      do
      {
        return;
        this.mMiniAppInfo = this.mGameUI.getMiniAppInfo();
        this.mActivity = this.mGameUI.getActivity();
        this.mLoadingUI = this.mGameUI.getLoadingUI();
        switch (paramMiniAppStateMessage.what)
        {
        default: 
          return;
        case 20: 
          QMLog.i("GameRuntimeState", "User click. onCreate/onNewIntent. " + this.mMiniAppInfo);
          this.mLoadGameStartTime = System.currentTimeMillis();
          this.mMainHandler.postDelayed(this.mGameLaunchWatchDog, 10000L);
          return;
        case 2011: 
          QMLog.i("GameRuntimeState", "Game engine loading. " + this.mMiniAppInfo);
        }
      } while (!(paramMiniAppStateMessage.obj instanceof LoadingStatus));
      paramMiniAppStateMessage = (LoadingStatus)paramMiniAppStateMessage.obj;
      updateLoadingProcessText(paramMiniAppStateMessage.getProcessInPercentage(), paramMiniAppStateMessage.getProgress());
      return;
      QMLog.i("GameRuntimeState", "Game engine loaded. " + this.mMiniAppInfo);
      if ((paramMiniAppStateMessage.obj instanceof String)) {
        updateLoadingProcessText((String)paramMiniAppStateMessage.obj, 1.0F);
      }
      if (paramMiniAppStateMessage.appRuntimeLoader != null) {
        paramMiniAppStateMessage.appRuntimeLoader.notifyRuntimeEvent(4, new Object[0]);
      }
      l1 = System.currentTimeMillis() - this.mLoadGameStartTime;
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1033, null, String.valueOf(this.mGameUI.getStatMode()), null, 0, "1", l1, null);
      QMLog.e("[minigame][timecost] ", "step[load baseLib] succeed, cost time: " + l1);
      return;
      QMLog.i("GameRuntimeState", "Failed to load game engine. " + this.mMiniAppInfo);
      if ((paramMiniAppStateMessage.obj instanceof Integer))
      {
        if (((Integer)paramMiniAppStateMessage.obj).intValue() != 104) {
          break label565;
        }
        this.mGameUI.showUpdateMobileQQDialog();
      }
      for (;;)
      {
        MiniGdtReporter.report(this.mMiniAppInfo, 510);
        l1 = System.currentTimeMillis() - this.mLoadGameStartTime;
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1033, null, String.valueOf(this.mGameUI.getStatMode()), null, -1, "1", l1, null);
        QMLog.e("[minigame][timecost] ", "step[load baseLib] fail, cost time: " + l1);
        runOnUiThread(new GameRuntimeStateObserver.3(this));
        return;
        runOnUiThread(new GameRuntimeStateObserver.2(this));
      }
      QMLog.i("GameRuntimeState", "Game package loading. " + paramMiniAppStateMessage.obj + this.mMiniAppInfo);
    } while (!(paramMiniAppStateMessage.obj instanceof LoadingStatus));
    paramMiniAppStateMessage = (LoadingStatus)paramMiniAppStateMessage.obj;
    if (paramMiniAppStateMessage.isInProgress()) {
      this.mGameUI.setPackageDownloadFlag(true);
    }
    updateLoadingProcessText(paramMiniAppStateMessage.getProcessInPercentage(), paramMiniAppStateMessage.getProgress());
    return;
    QMLog.i("GameRuntimeState", "Game package loaded. " + this.mMiniAppInfo);
    updateLoadingProcessText("100%", 1.0F);
    long l1 = System.currentTimeMillis() - this.mLoadGameStartTime;
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1036, null, this.mGameUI.getLaunchMsg(), null, 0, "1", l1, null);
    QMLog.e("[minigame][timecost] ", "step[load gpkg] succeed, cost time: " + l1);
    return;
    QMLog.i("GameRuntimeState", "Failed to load game package. " + this.mMiniAppInfo);
    runOnUiThread(new GameRuntimeStateObserver.4(this));
    l1 = System.currentTimeMillis() - this.mLoadGameStartTime;
    MiniGdtReporter.report(this.mMiniAppInfo, 511);
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1036, null, null, null, -1, "1", l1, null);
    QMLog.e("[minigame][timecost] ", "step[load gpkg] fail, cost time: " + l1);
    return;
    l1 = System.currentTimeMillis() - this.mLoadGameStartTime;
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1037, null, this.mGameUI.getLaunchMsg(), null, 0, "1", l1, null);
    QMLog.e("[minigame][timecost] ", "[MiniEng] step[init runTime] cost time " + l1 + ", include steps[load baseLib, load gpkg]");
    this.mLaunchEngineUISteps.onRuntimeInitDone();
    return;
    QMLog.i("GameRuntimeState", "Game surface create. " + this.mMiniAppInfo);
    this.mOnGameSurfaceCreateTime = System.currentTimeMillis();
    return;
    QMLog.i("GameRuntimeState", "Game launched. " + this.mMiniAppInfo);
    this.mOnGameLaunchedTime = System.currentTimeMillis();
    paramMiniAppStateMessage = (Pair)paramMiniAppStateMessage.obj;
    this.mLaunchEngineUISteps.onGameLaunched((GameLaunchStatistic)paramMiniAppStateMessage.second);
    return;
    QMLog.i("GameRuntimeState", "Game First render. " + this.mMiniAppInfo);
    int i = 0;
    if ((paramMiniAppStateMessage.obj instanceof Integer)) {
      i = ((Integer)paramMiniAppStateMessage.obj).intValue();
    }
    l1 = System.currentTimeMillis();
    long l2 = this.mOnGameSurfaceCreateTime;
    long l3 = l1 - this.mBeginOnCreate;
    long l4 = this.mOnGameLaunchedTime;
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1043, null, this.mGameUI.getLaunchMsg(), null, i, "1", l3, null);
    QMLog.e("[minigame][timecost] ", "step[onFirstFrameAppear] (首帧出现) cost time " + (l1 - l2) + "(from create surfaceView), " + l3 + "(from onCreate) " + (l1 - l4) + " ms(from gameLaunched)");
    runOnUiThread(new GameRuntimeStateObserver.5(this));
    if (paramMiniAppStateMessage.appRuntimeLoader != null) {
      paramMiniAppStateMessage.appRuntimeLoader.notifyRuntimeEvent(11, new Object[0]);
    }
    this.mLaunchEngineUISteps.onFirstFrame();
    List localList = getTaskExecutionStatics();
    if (this.mMiniAppInfo != null) {}
    for (paramMiniAppStateMessage = this.mMiniAppInfo.appId;; paramMiniAppStateMessage = "")
    {
      MiniGameBeaconReport.reportLaunchStatics(localList, paramMiniAppStateMessage, true);
      reportJankTraceStatistics(true);
      QMLog.e("[minigame][timecost] ", "launchGame " + this.mGameUI.getMiniAppInfo() + " GameLoadTaskExecutionStatics: \n" + TaskStaticsVisualizer.visualizeToString(localList));
      return;
    }
    this.mLastOnShowTime = SystemClock.uptimeMillis();
    notifyGameOnShow();
    return;
    if (SystemClock.uptimeMillis() - this.mLastOnShowTime > 30000L) {
      reportJankTraceStatistics(false);
    }
    notifyGameOnHide();
    return;
    notifyGameStop();
  }
  
  void setOnCreateTimeStamp()
  {
    this.mBeginOnCreate = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver
 * JD-Core Version:    0.7.0.1
 */