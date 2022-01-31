import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class tux
  implements Runnable
{
  public tux(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    try
    {
      if ((RegisterQQNumberActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        RegisterQQNumberActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        RegisterQQNumberActivity.a(this.a).c(2131435086);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tux
 * JD-Core Version:    0.7.0.1
 */