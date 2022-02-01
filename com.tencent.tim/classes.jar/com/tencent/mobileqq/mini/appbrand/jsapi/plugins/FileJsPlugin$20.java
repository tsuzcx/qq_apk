package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.FileDownloadManager;
import org.json.JSONObject;

class FileJsPlugin$20
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$20(FileJsPlugin paramFileJsPlugin, JSONObject paramJSONObject, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    String str1 = this.val$params.optString("url");
    if (!NetworkUtils.isNetworkUrl(str1))
    {
      str1 = ApiUtil.wrapCallbackFail(this.val$event, null, "invalid url").toString();
      this.val$jsRuntime.evaluateCallbackJs(this.val$callbackId, str1);
      return null;
    }
    String str2 = MiniAppFileManager.getInstance().getTmpPathByUrl(str1);
    FileDownloadManager.download(str1, null, str2, 60, new FileJsPlugin.20.1(this, l, str1, str2));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.20
 * JD-Core Version:    0.7.0.1
 */