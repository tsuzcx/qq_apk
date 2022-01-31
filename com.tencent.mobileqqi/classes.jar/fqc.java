import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class fqc
  extends FMObserver
{
  public fqc(FMActivity paramFMActivity) {}
  
  protected void a()
  {
    super.a();
    this.a.runOnUiThread(new fqg(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.d) {
      return;
    }
    this.a.runOnUiThread(new fqh(this, paramBoolean));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.runOnUiThread(new fqd(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a.runOnUiThread(new fqe(this, paramLong2));
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (!this.a.d) {
      FMToastUtil.a(paramString);
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.runOnUiThread(new fqf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqc
 * JD-Core Version:    0.7.0.1
 */