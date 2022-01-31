import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.dataline.mpfile.MpfileFileListDownloader.MpFileHttpDownloadListener;

public class dd
  implements MpfileFileListDownloader.MpFileHttpDownloadListener
{
  public dd(LiteMpFileFileListActivity paramLiteMpFileFileListActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.isFinishing()) {
      return;
    }
    LiteMpFileFileListActivity.b(this.a, System.currentTimeMillis());
    this.a.runOnUiThread(new de(this));
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
 * Qualified Name:     dd
 * JD-Core Version:    0.7.0.1
 */