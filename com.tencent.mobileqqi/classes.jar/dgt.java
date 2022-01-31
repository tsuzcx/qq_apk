import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dgt
  implements Runnable
{
  public dgt(RegisterSendUpSms paramRegisterSendUpSms) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dgt
 * JD-Core Version:    0.7.0.1
 */