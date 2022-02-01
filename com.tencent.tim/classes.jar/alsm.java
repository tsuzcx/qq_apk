import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

final class alsm
  implements Downloader.DownloadListener
{
  alsm(QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (this.b != null) {
      this.b.onResult(false);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.b != null) {
      this.b.onResult(false);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.b != null) {
      this.b.onResult(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsm
 * JD-Core Version:    0.7.0.1
 */