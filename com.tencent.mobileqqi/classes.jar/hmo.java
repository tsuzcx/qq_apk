import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;

public final class hmo
  implements Runnable
{
  public hmo(DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hmo
 * JD-Core Version:    0.7.0.1
 */