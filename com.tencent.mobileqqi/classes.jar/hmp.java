import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;

public final class hmp
  implements Runnable
{
  public hmp(DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hmp
 * JD-Core Version:    0.7.0.1
 */