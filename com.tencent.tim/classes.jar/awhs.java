import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class awhs
  implements Downloader.DownloadListener
{
  awhs(awhr paramawhr, String paramString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDownloadCanceled:" + paramString);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", -1);
      localJSONObject.put("message", paramString);
      awhr.a(this.a).callJs(this.val$callback, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QzoneSoundPlugin", 2, "DownloaderFactory onDownloadCanceled : " + paramString.getMessage());
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDownloadFailed:" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        if (paramDownloadResult == null) {
          continue;
        }
        DownloadResult.Status localStatus = paramDownloadResult.getStatus();
        if (localStatus == null) {
          continue;
        }
        paramString.put("code", localStatus.failReason);
        paramString.put("message", paramDownloadResult.getDetailDownloadInfo());
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("QzoneSoundPlugin", 2, "DownloaderFactory onDownloadFailed : " + paramString.getMessage());
        return;
        paramString.put("code", -1);
        paramString.put("message", "DownloadFailed");
        continue;
      }
      awhr.b(this.a).callJs(this.val$callback, new String[] { paramString.toString() });
      return;
      paramString.put("code", -1);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, new Object[] { "onDownloadProgress: ", paramString + " : " + paramLong + " : " + paramFloat });
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDownloadSucceed");
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("code", 0);
      paramString.put("message", "success");
      awhr.c(this.a).callJs(this.val$callback, new String[] { paramString.toString() });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QzoneSoundPlugin", 2, "DownloaderFactory onDownloadSucceed : " + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhs
 * JD-Core Version:    0.7.0.1
 */