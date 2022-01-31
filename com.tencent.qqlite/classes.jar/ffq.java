import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener;

public class ffq
  implements Runnable
{
  public ffq(MyAppApi.QQDownloadListener paramQQDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ffq
 * JD-Core Version:    0.7.0.1
 */