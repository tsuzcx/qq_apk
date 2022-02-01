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
import com.tencent.qqmini.sdk.utils.DebugUtil;
import org.json.JSONObject;

class MiniAppInfoLoadTask$3
  implements AsyncResult
{
  MiniAppInfoLoadTask$3(MiniAppInfoLoadTask paramMiniAppInfoLoadTask) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l;
      Object localObject;
      for (;;)
      {
        try
        {
          l = paramJSONObject.optLong("retCode");
          localObject = paramJSONObject.optString("errMsg");
          QMLog.d("MiniAppInfoLoadTask", "getAppInfoByLink, retCode = " + l + ",errMsg = " + (String)localObject);
          if (l != 0L)
          {
            if ((TextUtils.isEmpty((CharSequence)localObject)) && (DebugUtil.isDebugVersion())) {
              new StringBuilder().append("请求失败").append(", retCode = ").append(l).toString();
            }
            this.this$0.onTaskFailed();
          }
          localObject = (MiniAppInfo)paramJSONObject.opt("appInfo");
          paramJSONObject = paramJSONObject.optString("shareTicket", "");
          if ((l != 0L) || (localObject == null) || (TextUtils.isEmpty(((MiniAppInfo)localObject).appId))) {
            break;
          }
          ((MiniAppInfo)localObject).launchParam.clone(MiniAppInfoLoadTask.access$100(this.this$0).launchParam);
          ((MiniAppInfo)localObject).apkgInfo = MiniAppInfoLoadTask.access$100(this.this$0).apkgInfo;
          if ((((MiniAppInfo)localObject).firstPage != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).firstPage.pagePath)))
          {
            if (((MiniAppInfo)localObject).firstPage.pagePath.startsWith("/")) {
              ((MiniAppInfo)localObject).firstPage.pagePath = ((MiniAppInfo)localObject).firstPage.pagePath.substring(1);
            }
            if (((MiniAppInfo)localObject).firstPage.pagePath.contains(".html")) {
              ((MiniAppInfo)localObject).launchParam.entryPath = ((MiniAppInfo)localObject).firstPage.pagePath;
            }
          }
          else
          {
            ((MiniAppInfo)localObject).launchParam.miniAppId = ((MiniAppInfo)localObject).appId;
            ((MiniAppInfo)localObject).launchParam.shareTicket = paramJSONObject;
            ((MiniAppInfo)localObject).launchParam.navigateExtData = ((MiniAppInfo)localObject).extraData;
            if (!TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.shareTicket)) {
              ((MiniAppInfo)localObject).launchParam.scene = 1044;
            }
            if (!TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.reportData)) {
              break label490;
            }
            ((MiniAppInfo)localObject).launchParam.reportData = ((MiniAppInfo)localObject).reportData;
            if (((MiniAppInfo)localObject).verType != 3) {
              ((MiniAppInfo)localObject).forceReroad = 3;
            }
            MiniAppInfoLoadTask.access$102(this.this$0, (MiniAppInfo)localObject);
            this.this$0.onTaskSucceed();
            return;
          }
          if (((MiniAppInfo)localObject).firstPage.pagePath.contains("?"))
          {
            ((MiniAppInfo)localObject).launchParam.entryPath = ((MiniAppInfo)localObject).firstPage.pagePath.replaceFirst("\\?", ".html\\?");
            continue;
          }
          ((MiniAppInfo)localObject).launchParam.entryPath = (((MiniAppInfo)localObject).firstPage.pagePath + ".html");
        }
        catch (Throwable paramJSONObject)
        {
          QMLog.e("MiniAppInfoLoadTask", "", paramJSONObject);
          this.this$0.onTaskFailed();
          return;
        }
        continue;
        label490:
        if (!TextUtils.isEmpty(((MiniAppInfo)localObject).reportData)) {
          ((MiniAppInfo)localObject).launchParam.reportData = (((MiniAppInfo)localObject).launchParam.reportData + "&" + ((MiniAppInfo)localObject).reportData);
        }
      }
      SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
      if (localObject == null) {
        QMLog.e("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener appinfo==null retCode= " + l);
      }
      for (;;)
      {
        this.this$0.onTaskFailed();
        return;
        QMLog.e("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener retCode= " + l + " appid=" + ((MiniAppInfo)localObject).appId);
      }
    }
    SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.access$100(this.this$0), MiniReportManager.getAppType(MiniAppInfoLoadTask.access$100(this.this$0)), null, "load_fail", "shortcut_request_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.access$100(this.this$0));
    this.this$0.onTaskFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.3
 * JD-Core Version:    0.7.0.1
 */