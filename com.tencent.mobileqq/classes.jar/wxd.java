import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import mqq.os.MqqHandler;

public class wxd
  extends DownloadListener
{
  public wxd(PreloadImgManager paramPreloadImgManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    ThreadManager.getFileThreadHandler().post(new wxe(this, paramDownloadTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxd
 * JD-Core Version:    0.7.0.1
 */