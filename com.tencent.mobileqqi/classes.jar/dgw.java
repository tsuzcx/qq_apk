import android.os.Handler;
import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterSendUpSms;

public class dgw
  implements Runnable
{
  public dgw(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void run()
  {
    if (RegisterSendUpSms.a(this.a) == 1)
    {
      RegisterSendUpSms.a(this.a).setText(2131562881);
      RegisterSendUpSms.a(this.a).setEnabled(true);
      return;
    }
    RegisterSendUpSms.b(this.a);
    RegisterSendUpSms.a(this.a).setText(this.a.getString(2131562881) + "(" + RegisterSendUpSms.a(this.a) + ")");
    this.a.b.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dgw
 * JD-Core Version:    0.7.0.1
 */