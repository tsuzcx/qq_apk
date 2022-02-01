package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GamePreConnectManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$20$1
  implements DownloaderProxy.DownloadListener
{
  FileJsPlugin$20$1(FileJsPlugin.20 param20, long paramLong, String paramString1, String paramString2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    long l = System.currentTimeMillis() - this.val$startMS;
    GameLog.getInstance().i("[mini] FileJsPlugin", "doDownloadWithCache failed [timecost = " + l + "ms], url:" + this.val$url);
    this.this$1.val$jsRuntime.evaluateCallbackJs(this.this$1.val$callbackId, ApiUtil.wrapCallbackFail(this.this$1.val$event, null, paramString).toString());
    FileJsPlugin.access$700(this.this$1.this$0, l, paramInt, this.val$url);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    if (this.this$1.this$0.isMiniGameRuntime()) {
      GamePreConnectManager.onUrlConnect(this.val$url, paramInt);
    }
    long l = System.currentTimeMillis() - this.val$startMS;
    GameLog.getInstance().i("[mini] FileJsPlugin", "doDownloadWithCache success [timecost = " + l + "ms] url:" + this.val$url + ", save to file:" + this.val$tmpFilePath);
    paramString = new JSONObject();
    try
    {
      paramString.put("statusCode", paramInt);
      paramString.put("tempFilePath", MiniAppFileManager.getInstance().getWxFilePath(this.val$tmpFilePath));
      this.this$1.val$jsRuntime.evaluateCallbackJs(this.this$1.val$callbackId, ApiUtil.wrapCallbackOk(this.this$1.val$event, paramString).toString());
      FileJsPlugin.access$700(this.this$1.this$0, l, paramInt, this.val$url);
      return;
    }
    catch (JSONException paramString)
    {
      GameLog.getInstance().i("[mini] FileJsPlugin", "doDownloadWithCache exception, url:" + this.val$url, paramString);
      this.this$1.val$jsRuntime.evaluateCallbackJs(this.this$1.val$callbackId, ApiUtil.wrapCallbackFail(this.this$1.val$event, null, "download exception").toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.20.1
 * JD-Core Version:    0.7.0.1
 */