import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class yk
  implements Runnable
{
  public yk(AuthDevActivity paramAuthDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevActivity.a(this.a) == null) && (!this.a.isFinishing())) {
        AuthDevActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
      }
      if ((AuthDevActivity.a(this.a) != null) && (!AuthDevActivity.a(this.a).isShowing())) {
        AuthDevActivity.a(this.a).show();
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
 * Qualified Name:     yk
 * JD-Core Version:    0.7.0.1
 */