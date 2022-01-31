import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;

public class htz
  implements Runnable
{
  public htz(AuthDevVerifyCodeActivity2 paramAuthDevVerifyCodeActivity2) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity2.a(this.a) == null) && (!this.a.isFinishing()))
      {
        AuthDevVerifyCodeActivity2.a(this.a, new QQProgressDialog(this.a, this.a.d()));
        AuthDevVerifyCodeActivity2.a(this.a).b(2131562645);
        AuthDevVerifyCodeActivity2.a(this.a).c(true);
      }
      if ((AuthDevVerifyCodeActivity2.a(this.a) != null) && (!AuthDevVerifyCodeActivity2.a(this.a).isShowing())) {
        AuthDevVerifyCodeActivity2.a(this.a).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     htz
 * JD-Core Version:    0.7.0.1
 */