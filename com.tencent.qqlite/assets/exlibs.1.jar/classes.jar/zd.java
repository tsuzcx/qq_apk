import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class zd
  implements Runnable
{
  public zd(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        AuthDevVerifyCodeActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        AuthDevVerifyCodeActivity.a(this.a).b(2131363564);
        AuthDevVerifyCodeActivity.a(this.a).d(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zd
 * JD-Core Version:    0.7.0.1
 */