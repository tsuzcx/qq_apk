import com.tencent.TMG.utils.QLog;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class awlq
  implements Downloader.DownloadListener
{
  awlq(awlp paramawlp, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download fail url = " + paramString);
    }
    awlp.a(this.a, 2);
    awlp.a(this.a, false, paramString, this.val$filePath, this.bkl);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download success url = " + paramString);
    }
    awlp.b(this.a, true, paramString, this.val$filePath, this.bkl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlq
 * JD-Core Version:    0.7.0.1
 */