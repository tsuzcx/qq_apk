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
      if ((AuthDevVerifyCodeActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        AuthDevVerifyCodeActivity.a(this.a, new QQProgressDialog(this.a.a(), this.a.d()));
        AuthDevVerifyCodeActivity.a(this.a).b(2131562645);
        AuthDevVerifyCodeActivity.a(this.a).c(true);
      }
      if ((AuthDevVerifyCodeActivity.a(this.a) != null) && (!AuthDevVerifyCodeActivity.a(this.a).isShowing())) {
        AuthDevVerifyCodeActivity.a(this.a).show();
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
 * Qualified Name:     bwe
 * JD-Core Version:    0.7.0.1
 */