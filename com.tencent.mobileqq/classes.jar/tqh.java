import android.os.Message;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import mqq.os.MqqHandler;

public class tqh
  extends MqqHandler
{
  public tqh(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqh
 * JD-Core Version:    0.7.0.1
 */