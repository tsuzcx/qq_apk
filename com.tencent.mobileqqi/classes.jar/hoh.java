import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener;

public class hoh
  implements Runnable
{
  public hoh(MyAppApi.QQDownloadListener paramQQDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hoh
 * JD-Core Version:    0.7.0.1
 */