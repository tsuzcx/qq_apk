import com.tencent.mobileqq.filemanager.activity.VerifyPwdActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class fxb
  extends FMObserver
{
  public fxb(VerifyPwdActivity paramVerifyPwdActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    this.a.runOnUiThread(new fxd(this, paramBoolean));
  }
  
  protected void b(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
    this.a.runOnUiThread(new fxe(this));
  }
  
  protected void d()
  {
    this.a.runOnUiThread(new fxc(this));
  }
  
  protected void d(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxb
 * JD-Core Version:    0.7.0.1
 */