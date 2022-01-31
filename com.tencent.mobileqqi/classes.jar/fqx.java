import com.tencent.mobileqq.filemanager.activity.FMRecentFileActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;

public class fqx
  extends FMObserver
{
  public fqx(FMRecentFileActivity paramFMRecentFileActivity) {}
  
  protected void a()
  {
    super.a();
    this.a.runOnUiThread(new frc(this));
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    this.a.runOnUiThread(new fra(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.runOnUiThread(new fqy(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a.runOnUiThread(new fqz(this, paramLong2));
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.runOnUiThread(new frb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqx
 * JD-Core Version:    0.7.0.1
 */