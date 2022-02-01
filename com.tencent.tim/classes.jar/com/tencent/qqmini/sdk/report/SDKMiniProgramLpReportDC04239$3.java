package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class SDKMiniProgramLpReportDC04239$3
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$3(String paramString1, String paramString2, String paramString3, String paramString4, MiniAppInfo paramMiniAppInfo, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      QMLog.d("MiniProgramLpReportDC04239", "reportMiniAppEvent() called with: actionType = [" + this.val$actionType + "],subActionType = [" + this.val$subActionType + "], reserves = [" + this.val$reserves + "], appType = [" + this.val$appType + "]");
    }
    SDKMiniProgramLpReportDC04239.report(this.val$miniAppConfig, this.val$appType, this.val$path, this.val$actionType, this.val$subActionType, this.val$reserves, this.val$reserves2, this.val$reserves3, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.3
 * JD-Core Version:    0.7.0.1
 */