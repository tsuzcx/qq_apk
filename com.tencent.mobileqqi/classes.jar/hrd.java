import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.UpdateManager;

public class hrd
  implements Runnable
{
  public hrd(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    this.a.a = null;
    if (UpdateManager.a()) {
      UpdateManager.a().a();
    }
    if (MyAppApi.d()) {
      MyAppApi.a().h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hrd
 * JD-Core Version:    0.7.0.1
 */