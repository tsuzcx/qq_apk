import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class cvg
  implements Runnable
{
  public cvg(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        LoginVerifyCodeActivity.a(this.a, new QQProgressDialog(this.a.a(), this.a.d()));
        LoginVerifyCodeActivity.a(this.a).b(2131562645);
      }
      if ((LoginVerifyCodeActivity.a(this.a) != null) && (!LoginVerifyCodeActivity.a(this.a).isShowing())) {
        LoginVerifyCodeActivity.a(this.a).show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cvg
 * JD-Core Version:    0.7.0.1
 */