import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class bwe
  implements Runnable
{
  public bwe(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.a(this.a) != null) && (AuthDevVerifyCodeActivity.a(this.a).isShowing()))
      {
        AuthDevVerifyCodeActivity.a(this.a).dismiss();
        AuthDevVerifyCodeActivity.a(this.a).cancel();
      }
      AuthDevVerifyCodeActivity.a(this.a, null);
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
 * Qualified Name:     bwe
 * JD-Core Version:    0.7.0.1
 */