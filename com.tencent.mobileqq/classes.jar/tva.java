import android.os.Handler;
import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterSendUpSms;

public class tva
  implements Runnable
{
  public tva(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void run()
  {
    if (RegisterSendUpSms.a(this.a) == 1)
    {
      RegisterSendUpSms.a(this.a).setText("重新发送");
      RegisterSendUpSms.a(this.a).setEnabled(true);
      RegisterSendUpSms.a(this.a).setClickable(true);
      RegisterSendUpSms.a(this.a, 0);
      RegisterSendUpSms.b(this.a, 10);
      return;
    }
    RegisterSendUpSms.b(this.a);
    RegisterSendUpSms.a(this.a).setText("正在验证(" + RegisterSendUpSms.a(this.a) + "s)");
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tva
 * JD-Core Version:    0.7.0.1
 */