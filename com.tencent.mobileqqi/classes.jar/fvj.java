import com.tencent.mobileqq.filemanager.activity.FMRecentFileActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;

public class fvj
  extends FMObserver
{
  public fvj(FMRecentFileActivity paramFMRecentFileActivity) {}
  
  protected void a()
  {
    super.a();
    this.a.runOnUiThread(new fvo(this));
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    this.a.runOnUiThread(new fvm(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.runOnUiThread(new fvk(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a.runOnUiThread(new fvl(this, paramLong2));
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.runOnUiThread(new fvn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fvj
 * JD-Core Version:    0.7.0.1
 */