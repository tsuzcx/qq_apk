import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import mqq.os.MqqHandler;

public class xai
  extends DownloadListener
{
  public xai(PreloadImgManager paramPreloadImgManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    ThreadManager.getFileThreadHandler().post(new xaj(this, paramDownloadTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xai
 * JD-Core Version:    0.7.0.1
 */