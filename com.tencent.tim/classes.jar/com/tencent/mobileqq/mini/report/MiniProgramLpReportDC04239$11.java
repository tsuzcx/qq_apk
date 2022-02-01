package com.tencent.mobileqq.mini.report;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.utils.EnvUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

final class MiniProgramLpReportDC04239$11
  implements Runnable
{
  MiniProgramLpReportDC04239$11(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("app_config", this.val$miniAppConfig);
    localBundle.putString("actiontype", this.val$actionType);
    localBundle.putString("sub_action", this.val$subActionType);
    localBundle.putString("path", this.val$path);
    localBundle.putString("reserves", this.val$reserves);
    localBundle.putString("reserves2", this.val$reserves2);
    localBundle.putString("app_type", this.val$appType);
    if (this.val$miniAppConfig != null) {}
    for (MiniAppInfo localMiniAppInfo = this.val$miniAppConfig.config;; localMiniAppInfo = null)
    {
      localBundle.putBoolean("x5_enable", EnvUtils.isX5Enabled(localMiniAppInfo));
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "launch_report", localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.11
 * JD-Core Version:    0.7.0.1
 */