import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener;

public class hsm
  implements Runnable
{
  public hsm(MyAppApi.QQDownloadListener paramQQDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hsm
 * JD-Core Version:    0.7.0.1
 */