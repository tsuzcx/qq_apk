package com.tencent.qqmini.miniapp.widget.media;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePusher$5
  implements DownloaderProxy.DownloadListener
{
  MiniAppLivePusher$5(MiniAppLivePusher paramMiniAppLivePusher, String paramString1, String paramString2, RequestEvent paramRequestEvent, String paramString3, JSONObject paramJSONObject, String paramString4, DownloaderProxy paramDownloaderProxy) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    MiniAppLivePusher.access$300(this.this$0).remove(this.val$downloadId, this.val$BGMUrl);
    QMLog.e("MiniAppLivePusher", "playBGM - download onDownloadFailed failed:" + paramString);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.this$0.livePusherId);
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", 10003);
      this.val$req.jsService.evaluateSubscribeJS("onLivePusherError", localJSONObject.toString(), this.this$0.webviewId);
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
    if (MiniAppLivePusher.access$400(this.this$0))
    {
      QMLog.d("MiniAppLivePusher", "playBGM - download onDownloadProgress, abort");
      this.val$downloaderProxy.abort(this.val$BGMUrl);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    for (;;)
    {
      try
      {
        QMLog.e("MiniAppLivePusher", "playBGM - download onDownloadSucceed:" + this.val$BGMUrl);
        if (MiniAppLivePusher.access$400(this.this$0))
        {
          QMLog.e("MiniAppLivePusher", "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
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
            QMLog.e("MiniAppLivePusher", "file no exists, try to copy again.");
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
                QMLog.w("MiniAppLivePusher", "download Succeed but target file not exists, try copy from download tmp file:" + paramString + ", length:" + localFile.length() + ", to:" + this.val$BGMFilePath);
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
          QMLog.i("MiniAppLivePusher", "copy from download tmp file:" + paramString + " success");
          localObject = paramDownloadResult;
        }
        catch (Throwable localThrowable1)
        {
          QMLog.e("MiniAppLivePusher", "try copy from download tmp file exception! tmp file:" + paramString, localThrowable1);
          localDownloadResult = paramDownloadResult;
          break;
          QMLog.d("MiniAppLivePusher", "download failed, filepath not exists, tmpFile:" + paramString);
          return;
        }
      }
      MiniAppLivePusher.access$300(this.this$0).remove(this.val$downloadId);
      if ((!((File)localObject).exists()) || (!((File)localObject).canRead())) {
        break label420;
      }
      if (QMLog.isColorLevel()) {
        QMLog.d("MiniAppLivePusher", "download success BGMFilePath:" + this.val$BGMFilePath);
      }
      this.val$jsonObject.put("BGMFilePath", this.val$BGMFilePath);
      MiniAppLivePusher.access$000(this.this$0).operateLivePusher(this.val$operateName, this.val$jsonObject);
      return;
      Object localObject = paramDownloadResult;
      if (paramDownloadResult.exists())
      {
        paramDownloadResult.delete();
        localObject = paramDownloadResult;
      }
    }
    label420:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.5
 * JD-Core Version:    0.7.0.1
 */