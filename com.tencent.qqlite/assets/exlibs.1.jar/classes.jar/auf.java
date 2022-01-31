import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class auf
  implements Runnable
{
  public auf(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void run()
  {
    try
    {
      if ((LoginInfoActivity.a(this.a) != null) && (LoginInfoActivity.a(this.a).isShowing()))
      {
        LoginInfoActivity.a(this.a).dismiss();
        LoginInfoActivity.a(this.a).cancel();
      }
      LoginInfoActivity.a(this.a, null);
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
 * Qualified Name:     auf
 * JD-Core Version:    0.7.0.1
 */