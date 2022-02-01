package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AppBrandLaunchManager$3
  implements AsyncResult
{
  AppBrandLaunchManager$3(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("minisdk-start_AppBrandLaunchManager", "---startApp---- useUserApp isSuccess = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.3
 * JD-Core Version:    0.7.0.1
 */