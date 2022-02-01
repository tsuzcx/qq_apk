import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class cvh
  implements Runnable
{
  public cvh(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity.a(this.a) != null) && (LoginVerifyCodeActivity.a(this.a).isShowing()))
      {
        LoginVerifyCodeActivity.a(this.a).dismiss();
        LoginVerifyCodeActivity.a(this.a).cancel();
      }
      LoginVerifyCodeActivity.a(this.a, null);
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
 * Qualified Name:     cvh
 * JD-Core Version:    0.7.0.1
 */