package com.tencent.mobileqq.mini.report;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

final class MiniAppReportManager2$1
  implements Runnable
{
  MiniAppReportManager2$1(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("app_config", this.val$miniAppConfig);
    localBundle.putString("action_type", "page_view");
    localBundle.putString("sub_action", this.val$subActionType);
    localBundle.putString("path", this.val$path);
    localBundle.putString("reserves", this.val$reserves);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "launch_report2", localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager2.1
 * JD-Core Version:    0.7.0.1
 */