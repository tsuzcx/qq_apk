import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class ze
  implements Runnable
{
  public ze(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ze
 * JD-Core Version:    0.7.0.1
 */