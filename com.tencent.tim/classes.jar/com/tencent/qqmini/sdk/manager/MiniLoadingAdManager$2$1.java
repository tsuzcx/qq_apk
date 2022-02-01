package com.tencent.qqmini.sdk.manager;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class MiniLoadingAdManager$2$1
  implements AdProxy.ILoadingAdListener
{
  MiniLoadingAdManager$2$1(MiniLoadingAdManager.2 param2, long paramLong) {}
  
  public void getLoadingAdLayoutReady() {}
  
  public void onAdClick() {}
  
  public void onAdDismiss(boolean paramBoolean) {}
  
  public void onAdShow(View paramView) {}
  
  public void onPreloadAdReceive(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.val$preloadStartTime;
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.this$0.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.this$0.val$miniAppInfo), null, "ad", "ad_loading", "preload_success", String.valueOf(l1 - l2));
      MiniLoadingAdManager.access$100(this.this$0.val$miniAppInfo.appId, this.this$0.val$uin, 1);
      MiniLoadingAdManager.access$200(this.this$0.val$miniAppInfo.appId, this.this$0.val$uin);
      return;
    }
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.this$0.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.this$0.val$miniAppInfo), null, "ad", "ad_loading", "preload_fail", null);
  }
  
  public void onSelectAdProcessDone(String paramString, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.2.1
 * JD-Core Version:    0.7.0.1
 */