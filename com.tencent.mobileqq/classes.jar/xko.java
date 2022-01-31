import android.os.Handler;
import android.widget.ProgressBar;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.qphone.base.util.QLog;

class xko
  implements Downloader.DownloadListener
{
  xko(xkm paramxkm) {}
  
  public void onDownloadCanceled(String paramString)
  {
    this.a.a.a.post(new xkp(this));
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    this.a.a.a.post(new xkq(this));
    QLog.d("EditLocalVideoActivity", 2, "onDownloadFailed");
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    QLog.d("EditLocalVideoActivity", 2, "onDownloadProgress = totalSize=" + paramLong + "  progress=" + paramFloat);
    EditLocalVideoActivity.a(this.a.a).setProgress((int)(100.0F * paramFloat));
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    this.a.a.a.post(new xkr(this));
    QLog.d("EditLocalVideoActivity", 2, "onDownloadSucceed：" + EditLocalVideoActivity.d(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xko
 * JD-Core Version:    0.7.0.1
 */