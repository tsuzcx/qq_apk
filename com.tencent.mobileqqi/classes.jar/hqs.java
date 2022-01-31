import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;

public final class hqs
  implements Runnable
{
  public hqs(DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hqs
 * JD-Core Version:    0.7.0.1
 */