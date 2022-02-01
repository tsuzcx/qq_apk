package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener;
import org.json.JSONObject;

class SubpackageJsPlugin$1
  implements ApkgManager.OnInitApkgListener
{
  SubpackageJsPlugin$1(SubpackageJsPlugin paramSubpackageJsPlugin, int paramInt, String paramString, RequestEvent paramRequestEvent) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    paramApkgInfo = new JSONObject();
    try
    {
      paramApkgInfo.put("taskId", this.val$loadTaskId);
      paramApkgInfo.put("moduleName", this.val$moduleName);
      if (paramInt == 0) {
        paramApkgInfo.put("state", "success");
      }
      for (;;)
      {
        this.val$req.jsService.evaluateSubscribeJS("onLoadSubPackageTaskStateChange", paramApkgInfo.toString(), 0);
        return;
        paramApkgInfo.put("state", "fail");
      }
      try
      {
        paramApkgInfo.put("taskId", this.val$loadTaskId);
        paramApkgInfo.put("moduleName", this.val$moduleName);
        paramApkgInfo.put("state", "fail");
        this.val$req.jsService.evaluateSubscribeJS("onLoadSubPackageTaskStateChange", paramApkgInfo.toString(), 0);
        paramString.printStackTrace();
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    catch (Throwable paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.SubpackageJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */