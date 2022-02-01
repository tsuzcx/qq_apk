package com.tencent.qqmini.sdk.launcher;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniToast;

public class AppStateManager
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  private static final int LAUNCH_STATUS_CLICK = 0;
  private static final int LAUNCH_STATUS_FIRST_FRAME = 2;
  private static final int LAUNCH_STATUS_LOAD = 1;
  private static final String TAG = "minisdk-start_RuntimeState";
  public boolean hasFirstDomReadied;
  public boolean hasPreloadCompleted;
  public boolean isFlutter;
  public boolean isFromPrelaunch;
  public boolean isFromPreload;
  public int launchStatus = 0;
  private long mBeginOnCreate;
  private int mLaunchResult = 0;
  private BaseRuntimeLoader mRuntimeLoader;
  private long onResumeTime = 0L;
  
  public AppStateManager(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    this.mRuntimeLoader = paramBaseRuntimeLoader;
  }
  
  private void notifyEvent(MiniAppInfo paramMiniAppInfo, String paramString, long paramLong)
  {
    if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null)) {
      return;
    }
    String str = paramMiniAppInfo.appId;
    paramMiniAppInfo = paramMiniAppInfo.via;
    Bundle localBundle = new Bundle();
    localBundle.putString("key_appid", str);
    localBundle.putInt("key_scene", 9999);
    localBundle.putString("key_via", paramMiniAppInfo);
    localBundle.putString("key_event", paramString);
    localBundle.putLong("key_timestamp", paramLong);
    AppBrandCmdProxy.g().sendCmd("cmd_notify_event_info", localBundle, null);
  }
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if (paramMiniAppStateMessage == null) {}
    label4:
    MiniAppInfo localMiniAppInfo;
    label61:
    label223:
    label352:
    label1135:
    do
    {
      BaseRuntime localBaseRuntime;
      int j;
      do
      {
        do
        {
          do
          {
            return;
            QMLog.i("minisdk-start_RuntimeState", "onStateChange message:" + paramMiniAppStateMessage.what);
            localBaseRuntime = this.mRuntimeLoader.getRuntime();
            localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
            if (localMiniAppInfo != null)
            {
              i = localMiniAppInfo.getReportType();
              if ((localBaseRuntime == null) || (localBaseRuntime.getPage() == null)) {
                break label223;
              }
            }
            for (localObject = PageAction.obtain(localBaseRuntime).getPageUrl();; localObject = null) {
              switch (paramMiniAppStateMessage.what)
              {
              default: 
                return;
              case 3: 
                if (!this.isFromPreload) {
                  break label4;
                }
                this.hasPreloadCompleted = true;
                return;
                i = 0;
                break label61;
              }
            }
            this.mBeginOnCreate = System.currentTimeMillis();
            if (localMiniAppInfo != null)
            {
              paramMiniAppStateMessage = localMiniAppInfo.appId;
              if (localMiniAppInfo == null) {
                break label345;
              }
              localObject = localMiniAppInfo.name;
              QMLog.i("minisdk-start_RuntimeState", "[" + paramMiniAppStateMessage + "][" + (String)localObject + "] 启动(MiniActivity onCreate)");
              if (!this.isFromPrelaunch) {
                break label352;
              }
            }
            for (paramMiniAppStateMessage = "preLaunch";; paramMiniAppStateMessage = null)
            {
              MiniReportManager.reportEventType(localMiniAppInfo, 24, null, paramMiniAppStateMessage, null, 0, String.valueOf(i), 0L, null, "", "", "", "");
              this.launchStatus = 0;
              return;
              paramMiniAppStateMessage = "";
              break;
              localObject = "";
              break label259;
            }
            this.launchStatus = 1;
            localObject = new StringBuilder().append("--- report load appid:");
            if (localMiniAppInfo != null) {}
            for (paramMiniAppStateMessage = localMiniAppInfo.appId;; paramMiniAppStateMessage = Integer.valueOf(0))
            {
              QMLog.i("minisdk-start_RuntimeState", paramMiniAppStateMessage);
              MiniAppReportManager2.reportPageView("2load", null, null, localMiniAppInfo);
              return;
            }
            this.launchStatus = 2;
          } while (this.hasFirstDomReadied);
          this.hasFirstDomReadied = true;
          if ((localBaseRuntime != null) && (localMiniAppInfo != null))
          {
            QMLog.i("minisdk-start_RuntimeState", "--- report show firstframe appid:" + localMiniAppInfo.appId);
            MiniAppReportManager2.reportPageView("2launch", "first_frame", (String)localObject, localMiniAppInfo);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label654;
            }
            paramMiniAppStateMessage = localMiniAppInfo.launchParam.entryPath;
            if (!this.isFromPrelaunch) {
              break label660;
            }
            localObject = "preLaunch";
            MiniReportManager.reportEventType(localMiniAppInfo, 21, paramMiniAppStateMessage, (String)localObject, null, 0);
            l1 = System.currentTimeMillis();
            l2 = this.mBeginOnCreate;
            j = this.mLaunchResult;
            if (i != 0) {
              break label666;
            }
          }
          for (paramMiniAppStateMessage = "0";; paramMiniAppStateMessage = "1")
          {
            MiniReportManager.reportEventType(localMiniAppInfo, 1043, null, null, null, j, paramMiniAppStateMessage, l1 - l2, null);
            paramMiniAppStateMessage = new Bundle();
            paramMiniAppStateMessage.putString("bundle_key_runtime_lifecycle", "first_frame");
            paramMiniAppStateMessage.putParcelable("bundle_key_appinfo", localMiniAppInfo);
            AppBrandCmdProxy.g().sendCmd("cmd_notify_runtime_lifecycle", paramMiniAppStateMessage, null);
            paramMiniAppStateMessage = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
            if ((this.isFlutter) && (paramMiniAppStateMessage.isDebugVersion())) {
              MiniToast.makeText(AppLoaderFactory.g().getMiniAppEnv().getContext(), "进入native小程序,仅debug可见", 0).show();
            }
            paramMiniAppStateMessage.notifyMiniAppInfo(1, localMiniAppInfo);
            return;
            paramMiniAppStateMessage = (AppRuntimeEventCenter.MiniAppStateMessage)localObject;
            break;
            localObject = null;
            break label513;
          }
        } while (localMiniAppInfo == null);
        QMLog.i("minisdk-start_RuntimeState", "--- report bring_to_front appid:" + localMiniAppInfo.appId);
        l1 = System.currentTimeMillis();
        this.onResumeTime = l1;
        MiniAppReportManager2.reportPageView("2show", "bring_to_front", (String)localObject, localMiniAppInfo);
        notifyEvent(localMiniAppInfo, "onResume", l1);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (paramMiniAppStateMessage = localMiniAppInfo.launchParam.entryPath;; paramMiniAppStateMessage = (AppRuntimeEventCenter.MiniAppStateMessage)localObject)
        {
          MiniReportManager.reportEventType(localMiniAppInfo, 1, paramMiniAppStateMessage, null, null, 0);
          if ((localBaseRuntime == null) || (!this.hasFirstDomReadied)) {
            break;
          }
          QMLog.i("minisdk-start_RuntimeState", "--- report click_resume appid:" + localMiniAppInfo.appId);
          MiniAppReportManager2.reportPageView("2launch", "click_resume", (String)localObject, localMiniAppInfo);
          MiniReportManager.reportEventType(localMiniAppInfo, 21, paramMiniAppStateMessage, null, null, 0);
          return;
        }
      } while (localMiniAppInfo == null);
      QMLog.i("minisdk-start_RuntimeState", "--- report launch fail appid:" + localMiniAppInfo.appId);
      MiniAppReportManager2.reportPageView("2launch_fail", "flutter_sdk_fail", (String)localObject, localMiniAppInfo);
      return;
      MiniAppReportManager2.reportPageView("2close", "loading_page", null, localMiniAppInfo);
      return;
      MiniAppReportManager2.reportPageView("2close", "inner_page", (String)localObject, localMiniAppInfo);
      if ((this.mRuntimeLoader.isLoadSucceed()) && (localBaseRuntime != null) && (localBaseRuntime.isMiniGame()))
      {
        MiniReportManager.reportEventType(localMiniAppInfo, 1025, "1");
        return;
      }
      MiniReportManager.reportEventType(localMiniAppInfo, 1026, "1");
      return;
      MiniAppReportManager2.reportPageView("2unload", null, (String)localObject, localMiniAppInfo);
      return;
      long l3 = System.currentTimeMillis();
      long l2 = l3 - this.onResumeTime;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      MiniAppReportManager2.reportPageView("2hide", String.valueOf(l1), (String)localObject, localMiniAppInfo);
      notifyEvent(localMiniAppInfo, "onPause", l3);
      MiniReportManager.reportEventType(localMiniAppInfo, 20, "" + i, l1);
      return;
      if (i == 1)
      {
        if (localMiniAppInfo == null) {
          break label1135;
        }
        if (this.launchStatus != 0) {
          break label1109;
        }
        SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "load_fail", "loading_page_back_press");
      }
      while (this.hasFirstDomReadied)
      {
        MiniAppReportManager2.reportPageView("2back_key", "inner_page", (String)localObject, localMiniAppInfo);
        return;
        if (this.launchStatus == 1)
        {
          SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "show_fail", "loading_page_back_press");
          continue;
          QMLog.e("minisdk-start_RuntimeState", "doOnBackPressed gameConfig=null");
        }
      }
      MiniAppReportManager2.reportPageView("2back_key", "loading_page", (String)localObject, localMiniAppInfo);
      return;
      Object localObject = (Pair)paramMiniAppStateMessage.obj;
      if (paramMiniAppStateMessage.obj != null) {}
      for (int i = ((Integer)((Pair)localObject).first).intValue();; i = 0)
      {
        j = i;
        if (i >= 0) {
          j = 0;
        }
        this.mLaunchResult = j;
        return;
      }
      if (localMiniAppInfo == null) {
        break;
      }
    } while ((this.launchStatus != 0) && (this.launchStatus != 1));
    label259:
    label345:
    SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "load_fail", "loading_page_kill");
    label513:
    label654:
    label660:
    label666:
    label1109:
    MiniAppReportManager2.reportPageView("2launch_fail", "loading_page_kill", null, localMiniAppInfo);
    return;
    QMLog.e("minisdk-start_RuntimeState", "doOnDestroy kill self gameConfig=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppStateManager
 * JD-Core Version:    0.7.0.1
 */