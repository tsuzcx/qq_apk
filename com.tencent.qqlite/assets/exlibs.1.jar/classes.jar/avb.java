import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class avb
  implements Runnable
{
  public avb(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity2.a(this.a) == null) && (!this.a.isFinishing()))
      {
        LoginVerifyCodeActivity2.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        LoginVerifyCodeActivity2.a(this.a).b(2131363569);
      }
      if ((LoginVerifyCodeActivity2.a(this.a) != null) && (!LoginVerifyCodeActivity2.a(this.a).isShowing())) {
        LoginVerifyCodeActivity2.a(this.a).show();
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
 * Qualified Name:     avb
 * JD-Core Version:    0.7.0.1
 */