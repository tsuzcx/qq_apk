import com.dataline.mpfile.LiteMpFileMainActivity;
import com.dataline.mpfile.MpfileFileListDownloader.MpFileHttpDownloadListener;

public class dm
  implements MpfileFileListDownloader.MpFileHttpDownloadListener
{
  public dm(LiteMpFileMainActivity paramLiteMpFileMainActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.isFinishing()) {
      return;
    }
    LiteMpFileMainActivity.a(this.a, System.currentTimeMillis());
    this.a.runOnUiThread(new dn(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    LiteMpFileMainActivity.a(this.a, System.currentTimeMillis());
    LiteMpFileMainActivity.b(this.a, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     dm
 * JD-Core Version:    0.7.0.1
 */