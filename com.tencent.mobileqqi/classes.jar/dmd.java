import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dmd
  implements Runnable
{
  public dmd(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    try
    {
      if ((RegisterQQNumberActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        RegisterQQNumberActivity.a(this.a, new QQProgressDialog(this.a.a(), this.a.d()));
        RegisterQQNumberActivity.a(this.a).b(2131562645);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmd
 * JD-Core Version:    0.7.0.1
 */