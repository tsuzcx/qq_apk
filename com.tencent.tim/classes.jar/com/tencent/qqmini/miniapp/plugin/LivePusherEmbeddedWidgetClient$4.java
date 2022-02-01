package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.FileUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class LivePusherEmbeddedWidgetClient$4
  implements DownloaderProxy.DownloadListener
{
  LivePusherEmbeddedWidgetClient$4(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient, String paramString1, String paramString2, int paramInt, String paramString3, JSONObject paramJSONObject, String paramString4, DownloaderProxy paramDownloaderProxy) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    LivePusherEmbeddedWidgetClient.access$400(this.this$0).remove(this.val$downloadId, this.val$BGMUrl);
    QMLog.e("miniapp-embedded-live-pusher", "playBGM - download onDownloadFailed failed:" + paramString);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", this.val$viewId);
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", 10003);
      LivePusherEmbeddedWidgetClient.access$300(this.this$0, "onXWebLivePusherError", localJSONObject.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (LivePusherEmbeddedWidgetClient.access$500(this.this$0))
    {
      QMLog.d("miniapp-embedded-live-pusher", "playBGM - download onDownloadProgress, abort");
      this.val$downloaderProxy.abort(this.val$BGMUrl);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    for (;;)
    {
      try
      {
        QMLog.e("miniapp-embedded-live-pusher", "playBGM - download onDownloadSucceed statusCode:" + paramInt);
        if (LivePusherEmbeddedWidgetClient.access$500(this.this$0))
        {
          QMLog.e("miniapp-embedded-live-pusher", "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
          return;
        }
        if (TextUtils.isEmpty(this.val$BGMFilePath)) {
          return;
        }
        paramDownloadResult = new File(this.val$BGMFilePath);
        localObject = paramDownloadResult;
        if (!paramDownloadResult.exists())
        {
          localObject = paramDownloadResult;
          if (!TextUtils.isEmpty(paramString)) {
            QMLog.e("miniapp-embedded-live-pusher", "file no exists, try to copy again.");
          }
        }
      }
      catch (JSONException paramString)
      {
        File localFile;
        paramString.printStackTrace();
        return;
      }
      for (;;)
      {
        try
        {
          localFile = new File(paramString);
          localObject = paramDownloadResult;
          if (localFile.exists())
          {
            localObject = paramDownloadResult;
            if (localFile.isFile())
            {
              localObject = paramDownloadResult;
              if (localFile.length() > 0L)
              {
                QMLog.w("miniapp-embedded-live-pusher", "download Succeed but target file not exists, try copy from download tmp file:" + paramString + ", length:" + localFile.length() + ", to:" + this.val$BGMFilePath);
                localObject = FileUtils.createFile(this.val$BGMFilePath);
                paramDownloadResult = (DownloaderProxy.DownloadListener.DownloadResult)localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          DownloaderProxy.DownloadListener.DownloadResult localDownloadResult;
          continue;
        }
        try
        {
          if ((!FileUtils.copyFile(localFile, paramDownloadResult)) || (!paramDownloadResult.exists()) || (paramDownloadResult.length() != localFile.length())) {
            continue;
          }
          QMLog.d("miniapp-embedded-live-pusher", "copy from download tmp file:" + paramString + " success");
          localObject = paramDownloadResult;
        }
        catch (Throwable localThrowable1)
        {
          QMLog.e("miniapp-embedded-live-pusher", "try copy from download tmp file exception! tmp file:" + paramString, localThrowable1);
          localDownloadResult = paramDownloadResult;
          break;
          QMLog.d("miniapp-embedded-live-pusher", "download failed, filepath not exists, tmpFile:" + paramString);
          return;
        }
      }
      LivePusherEmbeddedWidgetClient.access$400(this.this$0).remove(this.val$downloadId);
      if ((!((File)localObject).exists()) || (!((File)localObject).canRead())) {
        break label417;
      }
      if (QMLog.isColorLevel()) {
        QMLog.d("miniapp-embedded-live-pusher", "download success BGMFilePath:" + this.val$BGMFilePath);
      }
      this.val$jsonObject.put("BGMFilePath", this.val$BGMFilePath);
      LivePusherEmbeddedWidgetClient.access$000(this.this$0).operateLivePusher(this.val$type, this.val$jsonObject);
      return;
      Object localObject = paramDownloadResult;
      if (paramDownloadResult.exists())
      {
        paramDownloadResult.delete();
        localObject = paramDownloadResult;
      }
    }
    label417:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.4
 * JD-Core Version:    0.7.0.1
 */