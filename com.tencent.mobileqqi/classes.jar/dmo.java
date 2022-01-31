import android.os.Handler;
import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterSendUpSms;

public class dmo
  implements Runnable
{
  public dmo(RegisterSendUpSms paramRegisterSendUpSms) {}
  
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
 * Qualified Name:     dmo
 * JD-Core Version:    0.7.0.1
 */