import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.base.img.ImageDownCallback;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

public class fei
  implements ImageDownCallback
{
  public fei(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    LogUtility.d(DownloadManager.a, ">>download apk icon err,should load another size icon");
    ImageCache.a("app", ImageUtil.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b, 75), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fei
 * JD-Core Version:    0.7.0.1
 */