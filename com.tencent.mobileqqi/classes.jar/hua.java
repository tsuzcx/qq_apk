import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;

public class hua
  implements Runnable
{
  public hua(AuthDevVerifyCodeActivity2 paramAuthDevVerifyCodeActivity2) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity2.a(this.a) != null) && (AuthDevVerifyCodeActivity2.a(this.a).isShowing()))
      {
        AuthDevVerifyCodeActivity2.a(this.a).dismiss();
        AuthDevVerifyCodeActivity2.a(this.a).cancel();
      }
      AuthDevVerifyCodeActivity2.a(this.a, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hua
 * JD-Core Version:    0.7.0.1
 */