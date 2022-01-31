import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.dataline.mpfile.MpfileFileListDownloader.MpFileHttpDownloadListener;

public class dl
  implements MpfileFileListDownloader.MpFileHttpDownloadListener
{
  public dl(LiteMpFileFileListActivity paramLiteMpFileFileListActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.isFinishing()) {
      return;
    }
    LiteMpFileFileListActivity.b(this.a, System.currentTimeMillis());
    this.a.runOnUiThread(new dm(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    LiteMpFileFileListActivity.b(this.a, System.currentTimeMillis());
    LiteMpFileFileListActivity.b(this.a, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     dl
 * JD-Core Version:    0.7.0.1
 */