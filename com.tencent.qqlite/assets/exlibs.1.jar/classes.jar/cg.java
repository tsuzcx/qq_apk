import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.dataline.mpfile.MpfileFileListDownloader.MpFileHttpDownloadListener;

public class cg
  implements MpfileFileListDownloader.MpFileHttpDownloadListener
{
  public cg(LiteMpFileFileListActivity paramLiteMpFileFileListActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.isFinishing()) {
      return;
    }
    LiteMpFileFileListActivity.b(this.a, System.currentTimeMillis());
    this.a.runOnUiThread(new ch(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cg
 * JD-Core Version:    0.7.0.1
 */