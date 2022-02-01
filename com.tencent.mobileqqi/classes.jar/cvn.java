import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class cvn
  implements Runnable
{
  public cvn(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity2.a(this.a) != null) && (LoginVerifyCodeActivity2.a(this.a).isShowing()))
      {
        LoginVerifyCodeActivity2.a(this.a).dismiss();
        LoginVerifyCodeActivity2.a(this.a).cancel();
      }
      LoginVerifyCodeActivity2.a(this.a, null);
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
 * Qualified Name:     cvn
 * JD-Core Version:    0.7.0.1
 */