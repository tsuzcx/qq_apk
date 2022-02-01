package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class SDKMiniProgramLpReportDC04239$4
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$4(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo, String paramString4) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      QMLog.d("MiniProgramLpReportDC04239", "reportUserClick() called with: subActionType = [" + this.val$subActionType + "], reserves = [" + this.val$reserves + "], appType = [" + this.val$appType + "]");
    }
    SDKMiniProgramLpReportDC04239.access$300(this.val$miniAppConfig, this.val$appType, this.val$path, "page_view", this.val$subActionType, this.val$reserves);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.4
 * JD-Core Version:    0.7.0.1
 */