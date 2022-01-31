import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

public class hms
  implements Runnable
{
  public hms(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    if (!this.a.a)
    {
      if (!MyAppApi.a().b()) {
        this.a.a(true);
      }
      this.a.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hms
 * JD-Core Version:    0.7.0.1
 */