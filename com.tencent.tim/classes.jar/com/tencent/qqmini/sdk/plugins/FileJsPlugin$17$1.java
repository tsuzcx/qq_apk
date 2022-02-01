package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$17$1
  implements DownloaderProxy.DownloadListener
{
  FileJsPlugin$17$1(FileJsPlugin.17 param17, long paramLong, String paramString1, String paramString2) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    long l = System.currentTimeMillis() - this.val$startMS;
    QMLog.i("FileJsPlugin", "doDownloadWithCache failed [timecost = " + l + "ms], url:" + this.val$url);
    this.this$1.val$req.fail(paramString);
    FileJsPlugin.access$7300(this.this$1.this$0, l, paramInt, this.val$url);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    long l = System.currentTimeMillis() - this.val$startMS;
    QMLog.i("FileJsPlugin", "doDownloadWithCache success [timecost = " + l + "ms] url:" + this.val$url + ", save to file:" + this.val$tmpFilePath);
    paramString = new JSONObject();
    try
    {
      paramString.put("statusCode", paramDownloadResult.httpStatusCode);
      paramString.put("tempFilePath", FileJsPlugin.access$2500(this.this$1.this$0).getWxFilePath(this.val$tmpFilePath));
      this.this$1.val$req.ok(paramString);
      FileJsPlugin.access$7300(this.this$1.this$0, l, paramInt, this.val$url);
      return;
    }
    catch (JSONException paramString)
    {
      QMLog.i("FileJsPlugin", "doDownloadWithCache exception, url:" + this.val$url, paramString);
      this.this$1.val$req.fail("download exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.17.1
 * JD-Core Version:    0.7.0.1
 */