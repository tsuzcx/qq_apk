import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class bgv
  implements Runnable
{
  public bgv(RegisterActivity paramRegisterActivity) {}
  
  public void run()
  {
    try
    {
      if (RegisterActivity.a(this.a) != null)
      {
        RegisterActivity.a(this.a).dismiss();
        RegisterActivity.a(this.a).cancel();
        RegisterActivity.a(this.a, null);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bgv
 * JD-Core Version:    0.7.0.1
 */