import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;

class awfa
  implements Downloader.DownloadListener
{
  awfa(awey paramawey, String[] paramArrayOfString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "onDownloadCanceled");
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.w("QZoneSharePictureJsPlugin", "下载GIF组件失败，请稍后重试");
    awey.a(this.this$0, acfp.m(2131713369), 1);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "下载GIF组件成功");
    if (this.this$0.f != null)
    {
      awey.a(this.this$0, this.this$0.f.mRuntime, this.val$args);
      return;
    }
    QZLog.w("QZoneSharePictureJsPlugin", "parentPlugin is null");
    awey.a(this.this$0, acfp.m(2131713356), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfa
 * JD-Core Version:    0.7.0.1
 */