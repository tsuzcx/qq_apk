import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dey
  implements Runnable
{
  public dey(RegisterActivity paramRegisterActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dey
 * JD-Core Version:    0.7.0.1
 */