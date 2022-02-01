package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.ApkgManager.OnInitApkgListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class SubpackageJsPlugin$2
  implements ApkgManager.OnInitApkgListener
{
  SubpackageJsPlugin$2(SubpackageJsPlugin paramSubpackageJsPlugin, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    paramApkgInfo = (JsRuntime)this.val$webviewRef.get();
    if (paramApkgInfo == null) {
      return;
    }
    paramString = new JSONObject();
    for (;;)
    {
      try
      {
        paramString.put("taskId", this.val$loadTaskId);
        paramString.put("moduleName", this.val$moduleName);
        if (paramInt == 0)
        {
          paramString.put("state", "success");
          paramApkgInfo.evaluateSubcribeJS("onLoadSubPackageTaskStateChange", paramString.toString(), 0);
          return;
        }
      }
      catch (Throwable localThrowable1) {}
      try
      {
        paramString.put("taskId", this.val$loadTaskId);
        paramString.put("moduleName", this.val$moduleName);
        paramString.put("state", "fail");
        paramApkgInfo.evaluateSubcribeJS("onLoadSubPackageTaskStateChange", paramString.toString(), 0);
        localThrowable1.printStackTrace();
        return;
        paramString.put("state", "fail");
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */