import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class bhz
  implements Runnable
{
  public bhz(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    try
    {
      if ((RegisterQQNumberActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        RegisterQQNumberActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        RegisterQQNumberActivity.a(this.a).b(2131363564);
      }
      if ((RegisterQQNumberActivity.a(this.a) != null) && (!RegisterQQNumberActivity.a(this.a).isShowing())) {
        RegisterQQNumberActivity.a(this.a).show();
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
 * Qualified Name:     bhz
 * JD-Core Version:    0.7.0.1
 */