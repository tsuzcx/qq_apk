import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class big
  implements Runnable
{
  public big(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void run()
  {
    try
    {
      if ((RegisterSendUpSms.a(this.a) != null) && (RegisterSendUpSms.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        RegisterSendUpSms.a(this.a).dismiss();
        RegisterSendUpSms.a(this.a).cancel();
      }
      RegisterSendUpSms.a(this.a, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     big
 * JD-Core Version:    0.7.0.1
 */