import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class fqb
  extends FMObserver
{
  public fqb(FMActivity paramFMActivity) {}
  
  protected void a()
  {
    super.a();
    this.a.runOnUiThread(new fqf(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.d) {
      return;
    }
    this.a.runOnUiThread(new fqg(this, paramBoolean));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.runOnUiThread(new fqc(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a.runOnUiThread(new fqd(this, paramLong2));
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (!this.a.d) {
      FMToastUtil.a(paramString);
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.runOnUiThread(new fqe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqb
 * JD-Core Version:    0.7.0.1
 */