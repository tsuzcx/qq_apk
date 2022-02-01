package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05115;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05116;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GamePreConnectManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$3
  implements Downloader.DownloadListener
{
  FileJsPlugin$3(FileJsPlugin paramFileJsPlugin, long paramLong, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, JSONObject paramJSONObject) {}
  
  private void reportDownloadFileResult(long paramLong, int paramInt)
  {
    if (this.this$0.isMiniGameRuntime()) {}
    for (String str = "1";; str = "0")
    {
      MiniReportManager.reportEventType(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, 640, null, null, null, paramInt, str, paramLong, null);
      return;
    }
  }
  
  public void onDownloadCanceled(String paramString)
  {
    QLog.w("[mini] FileJsPlugin", 1, "download canceled! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], downloadTaskId:" + this.val$downloadId + ", url:" + paramString);
    try
    {
      FileJsPlugin.access$000(this.this$0).remove(this.val$downloadId);
      paramString = new JSONObject();
      paramString.put("downloadTaskId", this.val$downloadId);
      paramString.put("state", "fail");
      paramString.put("errMsg", "download:fail abort");
      this.val$webview1.evaluateSubcribeJS("onDownloadTaskStateChange", paramString.toString(), 0);
      reportDownloadFileResult(System.currentTimeMillis() - this.val$startMS, -1);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("[mini] FileJsPlugin", 1, "download onDownloadCanceled failed." + paramString);
      }
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.e("[mini] FileJsPlugin", 1, new Object[] { "download failed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], downloadTaskId:", this.val$downloadId, ", url:", paramString });
    try
    {
      FileJsPlugin.access$000(this.this$0).remove(this.val$downloadId);
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("downloadTaskId", this.val$downloadId);
      ((JSONObject)localObject).put("state", "fail");
      ((JSONObject)localObject).put("errMsg", "Download Failed.");
      this.val$webview1.evaluateSubcribeJS("onDownloadTaskStateChange", ((JSONObject)localObject).toString(), 0);
      if ((this.this$0.jsPluginEngine != null) && (this.this$0.jsPluginEngine.appBrandRuntime != null) && (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo() != null)) {
        MiniProgramLpReportDC05325.reportApiReport(paramDownloadResult, 10, this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
      }
      localObject = paramDownloadResult.getStatus();
      int i = 200;
      if (localObject != null) {
        i = ((DownloadResult.Status)localObject).httpStatus;
      }
      reportDownloadFileResult(System.currentTimeMillis() - this.val$startMS, i);
      MiniProgramLpReportDC05115.reportDownloadResult(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, paramDownloadResult, System.currentTimeMillis() - this.val$startMS, true);
      MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, paramString, 0L, System.currentTimeMillis() - this.val$startMS, i, paramDownloadResult);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("[mini] FileJsPlugin", 1, "download onDownloadFailed failed." + localException);
      }
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.val$webview1 == null) {
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("downloadTaskId", this.val$downloadId);
      paramString.put("progress", (int)(100.0F * paramFloat));
      paramString.put("totalBytesWritten", (float)paramLong * paramFloat);
      paramString.put("totalBytesExpectedToWrite", paramLong);
      paramString.put("state", "progressUpdate");
      this.val$webview1.evaluateSubcribeJS("onDownloadTaskStateChange", paramString.toString(), 0);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("[mini] FileJsPlugin", 1, "download onDownloadProgress failed." + paramString);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.i("[mini] FileJsPlugin", 1, "download Succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], downloadTaskId:" + this.val$downloadId + ", url:" + paramString);
    if (this.this$0.isMiniGameRuntime()) {
      GamePreConnectManager.onUrlConnect(paramString, paramDownloadResult.getReport().httpStatus);
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.val$filePath))
        {
          localObject1 = new File(this.val$filePath);
          localObject7 = paramDownloadResult.getPath();
          if (((File)localObject1).exists()) {
            continue;
          }
          boolean bool = TextUtils.isEmpty((CharSequence)localObject7);
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject7;
        Object localObject8;
        Object localObject3;
        QLog.e("[mini] FileJsPlugin", 1, "download onDownloadSucceed exception.", localException1);
        Object localObject5 = new JSONObject();
        try
        {
          FileJsPlugin.access$000(this.this$0).remove(this.val$downloadId);
          ((JSONObject)localObject5).put("downloadTaskId", this.val$downloadId);
          ((JSONObject)localObject5).put("state", "fail");
          ((JSONObject)localObject5).put("errMsg", "Download Failed.");
          this.val$webview1.evaluateSubcribeJS("onDownloadTaskStateChange", ((JSONObject)localObject5).toString(), 0);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("[mini] FileJsPlugin", 1, "download onDownloadSucceed callback fail exception.", localException1);
        }
        continue;
        localJSONException.put("filePath", this.val$params.optString("filePath"));
        continue;
        QLog.e("[mini] FileJsPlugin", 1, "download failed, filepath not exists, tmpFile:" + paramDownloadResult.getPath() + ", downloadTaskId:" + this.val$downloadId + ", url:" + paramString);
        FileJsPlugin.access$000(this.this$0).remove(this.val$downloadId);
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("downloadTaskId", this.val$downloadId);
        ((JSONObject)localObject2).put("state", "fail");
        ((JSONObject)localObject2).put("errMsg", "Download Failed: file not exists or can not read.");
        this.val$webview1.evaluateSubcribeJS("onDownloadTaskStateChange", ((JSONObject)localObject2).toString(), 0);
        continue;
        Object localObject6 = localObject2;
        continue;
      }
      try
      {
        localObject8 = new File((String)localObject7);
        localObject3 = localObject1;
        if (((File)localObject8).exists())
        {
          localObject3 = localObject1;
          if (((File)localObject8).isFile())
          {
            localObject3 = localObject1;
            if (((File)localObject8).length() > 0L)
            {
              QLog.w("[mini] FileJsPlugin", 1, "download Succeed but target file not exists, try copy from download tmp file:" + (String)localObject7 + ", length:" + ((File)localObject8).length() + ", to:" + this.val$filePath);
              localObject3 = FileUtils.createFile(this.val$filePath);
              localObject1 = localObject3;
            }
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        continue;
        localObject2 = localObject7;
        continue;
      }
      try
      {
        if ((!FileUtils.copyFile((File)localObject8, (File)localObject1)) || (!((File)localObject1).exists()) || (((File)localObject1).length() != ((File)localObject8).length())) {
          continue;
        }
        QLog.i("[mini] FileJsPlugin", 1, "copy from download tmp file:" + (String)localObject7 + " success");
        localObject3 = localObject1;
      }
      catch (Throwable localThrowable2)
      {
        QLog.e("[mini] FileJsPlugin", 1, "try copy from download tmp file exception! tmp file:" + (String)localObject7, localThrowable2);
        localObject5 = localObject1;
        continue;
        if (!"png".equalsIgnoreCase((String)localObject8)) {
          continue;
        }
        localObject1 = "png";
        continue;
        if (!"gif".equalsIgnoreCase((String)localObject8)) {
          continue;
        }
        localObject1 = "gif";
        continue;
        if (!"svg+xml".equalsIgnoreCase((String)localObject8)) {
          continue;
        }
        localObject1 = "svg";
        continue;
        if (!"webp".equalsIgnoreCase((String)localObject8)) {
          continue;
        }
        localObject1 = "webp";
        continue;
      }
      if ((!((File)localObject3).exists()) || (!((File)localObject3).canRead())) {
        continue;
      }
      localObject7 = this.val$filePath;
      try
      {
        localObject1 = MimeTypeMap.getFileExtensionFromUrl((String)localObject7);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        localObject8 = paramDownloadResult.getContent();
        if ((localObject8 == null) || (TextUtils.isEmpty(((DownloadResult.Content)localObject8).type))) {
          continue;
        }
        localObject8 = ((DownloadResult.Content)localObject8).type.trim().split("/");
        if ((localObject8.length <= 1) || (!"image".equalsIgnoreCase(localObject8[0]))) {
          continue;
        }
        localObject8 = localObject8[1];
        if (!"jpeg".equalsIgnoreCase((String)localObject8)) {
          continue;
        }
        localObject1 = "jpg";
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        localObject1 = (String)localObject7 + "." + (String)localObject1;
        if (!FileUtils.copyFile(this.val$filePath, (String)localObject1)) {
          continue;
        }
        FileUtils.deleteFile(this.val$filePath);
        localObject7 = localObject1;
      }
      catch (Throwable localThrowable1)
      {
        Object localObject4;
        int i;
        QLog.e("[mini] FileJsPlugin", 1, "create file extension failed! " + localThrowable1);
        continue;
      }
      MiniAppFileManager.getInstance().updateFolderSize(this.val$fileType, ((File)localObject3).length());
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("downloadTaskId", this.val$downloadId);
      ((JSONObject)localObject1).put("progress", 100);
      ((JSONObject)localObject1).put("totalBytesWritten", ((File)localObject3).length());
      ((JSONObject)localObject1).put("totalBytesExpectedToWrite", ((File)localObject3).length());
      ((JSONObject)localObject1).put("state", "progressUpdate");
      this.val$webview1.evaluateSubcribeJS("onDownloadTaskStateChange", ((JSONObject)localObject1).toString(), 0);
      QLog.d("[mini] FileJsPlugin", 1, "download success.");
      localObject1 = new JSONObject();
      try
      {
        if ((paramDownloadResult.getReport() != null) && (paramDownloadResult.getReport().response != null))
        {
          localObject3 = paramDownloadResult.getReport().response.headerIterator();
          if (((HeaderIterator)localObject3).hasNext())
          {
            localObject8 = ((HeaderIterator)localObject3).nextHeader();
            ((JSONObject)localObject1).put(((Header)localObject8).getName(), ((Header)localObject8).getValue());
            continue;
          }
        }
        if (!TextUtils.isEmpty(this.val$params.optString("filePath"))) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        QLog.e("[mini] FileJsPlugin", 1, "onDownloadSucceed headerJson error." + localException2);
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("downloadTaskId", this.val$downloadId);
        ((JSONObject)localObject4).put("statusCode", 200);
        ((JSONObject)localObject4).put("header", localObject1);
        ((JSONObject)localObject4).put("state", "headersReceived");
        this.val$webview1.evaluateSubcribeJS("onDownloadTaskStateChange", ((JSONObject)localObject4).toString(), 0);
        FileJsPlugin.access$000(this.this$0).remove(this.val$downloadId);
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("statusCode", 200);
        ((JSONObject)localObject4).put("downloadTaskId", this.val$downloadId);
        if (this.val$params.isNull("filePath")) {}
      }
      ((JSONObject)localObject4).put("tempFilePath", MiniAppFileManager.getInstance().getWxFilePath((String)localObject7));
      ((JSONObject)localObject4).put("header", localObject1);
      ((JSONObject)localObject4).put("state", "success");
      this.val$webview1.evaluateSubcribeJS("onDownloadTaskStateChange", ((JSONObject)localObject4).toString(), 0);
      if ((this.this$0.jsPluginEngine != null) && (this.this$0.jsPluginEngine.appBrandRuntime != null) && (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo() != null)) {
        MiniProgramLpReportDC05325.reportApiReport(paramDownloadResult, 10, this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
      }
      localObject1 = paramDownloadResult.getStatus();
      i = 200;
      if (localObject1 != null) {
        i = ((DownloadResult.Status)localObject1).httpStatus;
      }
      reportDownloadFileResult(System.currentTimeMillis() - this.val$startMS, i);
      MiniProgramLpReportDC05115.reportDownloadResult(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, paramDownloadResult, System.currentTimeMillis() - this.val$startMS, false);
      MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, paramString, 0L, System.currentTimeMillis() - this.val$startMS, i, paramDownloadResult);
      return;
      localObject4 = localObject1;
      if (((File)localObject1).exists())
      {
        ((File)localObject1).delete();
        localObject4 = localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */