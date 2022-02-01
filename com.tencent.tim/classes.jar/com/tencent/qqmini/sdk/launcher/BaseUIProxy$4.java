package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnChooseAdEndListener;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class BaseUIProxy$4
  implements MiniLoadingAdManager.OnChooseAdEndListener
{
  BaseUIProxy$4(BaseUIProxy paramBaseUIProxy, long paramLong, MiniAppInfo paramMiniAppInfo, Activity paramActivity) {}
  
  public void onChooseAdEnd(String paramString, long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.val$loadingAdSelectStartTime;
    if (!this.this$0.hasCompletedLoading)
    {
      if ((paramString != null) && (paramLong != -1L))
      {
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "request_success_online", String.valueOf(l1));
        this.this$0.updateLoadingAdUI(this.val$activity, this.val$miniAppInfo, paramString, paramLong);
        return;
      }
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "request_success_offline", String.valueOf(l1));
      return;
    }
    paramLong = this.this$0.loadCompleteTimeForLoadingAdReport;
    long l2 = this.val$loadingAdSelectStartTime;
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "request_timeout", String.valueOf(paramLong - l2), String.valueOf(l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.BaseUIProxy.4
 * JD-Core Version:    0.7.0.1
 */