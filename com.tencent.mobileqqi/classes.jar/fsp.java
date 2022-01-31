import com.tencent.mobileqq.filemanager.activity.VerifyPwdActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class fsp
  extends FMObserver
{
  public fsp(VerifyPwdActivity paramVerifyPwdActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    this.a.runOnUiThread(new fsr(this, paramBoolean));
  }
  
  protected void b(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
    this.a.runOnUiThread(new fss(this));
  }
  
  protected void d()
  {
    this.a.runOnUiThread(new fsq(this));
  }
  
  protected void d(int paramInt, String paramString)
  {
    FMToastUtil.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fsp
 * JD-Core Version:    0.7.0.1
 */