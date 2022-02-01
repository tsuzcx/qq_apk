import android.os.Message;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Map;

class avwg
  implements Downloader.DownloadListener
{
  avwg(avwf paramavwf) {}
  
  public void onDownloadCanceled(String paramString)
  {
    Message localMessage = Message.obtain(avwf.a(this.a));
    localMessage.what = 5;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = Message.obtain(avwf.a(this.a));
    paramDownloadResult.what = 3;
    paramDownloadResult.obj = paramString;
    paramDownloadResult.sendToTarget();
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    paramString = (avwf.a)avwf.a(this.a).get(paramString);
    if (paramString != null) {
      paramString.obj = Float.valueOf(paramFloat);
    }
    Message localMessage = Message.obtain(avwf.a(this.a));
    localMessage.what = 6;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = Message.obtain(avwf.a(this.a));
    paramDownloadResult.what = 2;
    paramDownloadResult.obj = paramString;
    paramDownloadResult.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwg
 * JD-Core Version:    0.7.0.1
 */