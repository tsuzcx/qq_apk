import android.os.Handler;
import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterSendUpSms;

public class bin
  implements Runnable
{
  public bin(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void run()
  {
    if (RegisterSendUpSms.a(this.a) == 1)
    {
      RegisterSendUpSms.a(this.a).setText(2131363353);
      RegisterSendUpSms.a(this.a).setEnabled(true);
      return;
    }
    RegisterSendUpSms.b(this.a);
    RegisterSendUpSms.a(this.a).setText(this.a.getString(2131363353) + "(" + RegisterSendUpSms.a(this.a) + ")");
    this.a.b.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bin
 * JD-Core Version:    0.7.0.1
 */