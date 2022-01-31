import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

public class feh
  implements Runnable
{
  public feh(DownloadManager paramDownloadManager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     feh
 * JD-Core Version:    0.7.0.1
 */