package com.tencent.qqmini.sdk.task;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import org.json.JSONObject;

class MiniAppInfoLoadTask$2
  implements AsyncResult
{
  MiniAppInfoLoadTask$2(MiniAppInfoLoadTask paramMiniAppInfoLoadTask) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      QMLog.i("MiniAppInfoLoadTask", "getAppInfoById, retCode = " + l + ",errMsg = " + str);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        paramJSONObject.launchParam.clone(MiniAppInfoLoadTask.access$100(this.this$0).launchParam);
        paramJSONObject.apkgInfo = MiniAppInfoLoadTask.access$100(this.this$0).apkgInfo;
        paramJSONObject.launchParam.miniAppId = paramJSONObject.appId;
        if ((paramJSONObject.firstPage != null) && (!TextUtils.isEmpty(paramJSONObject.firstPage.pagePath)))
        {
          if (paramJSONObject.firstPage.pagePath.startsWith("/")) {
            paramJSONObject.firstPage.pagePath = paramJSONObject.firstPage.pagePath.substring(1);
          }
          if (!paramJSONObject.firstPage.pagePath.contains(".html")) {
            break label270;
          }
          paramJSONObject.launchParam.entryPath = paramJSONObject.firstPage.pagePath;
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(MiniAppInfoLoadTask.access$100(this.this$0).launchParam.extendData)) {
            paramJSONObject.extendData = MiniAppInfoLoadTask.access$100(this.this$0).launchParam.extendData;
          }
          if (paramJSONObject.verType != 3) {
            paramJSONObject.forceReroad = 3;
          }
          MiniReportManager.reportEventType(paramJSONObject, 1028, "main_loading", MiniReportManager.getAppType(paramJSONObject));
          MiniAppInfoLoadTask.access$102(this.this$0, paramJSONObject);
          this.this$0.onTaskSucceed();
          return;
          label270:
          if (paramJSONObject.firstPage.pagePath.contains("?")) {
            paramJSONObject.launchParam.entryPath = paramJSONObject.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
          } else {
            paramJSONObject.launchParam.entryPath = (paramJSONObject.firstPage.pagePath + ".html");
          }
        }
      }
      SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
      this.this$0.onTaskFailed();
      return;
    }
    SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
    this.this$0.onTaskFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.2
 * JD-Core Version:    0.7.0.1
 */