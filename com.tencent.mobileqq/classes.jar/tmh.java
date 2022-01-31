import android.os.Message;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;
import mqq.os.MqqHandler;

public class tmh
  extends MqqHandler
{
  public tmh(RegisterChooseLoginActivity paramRegisterChooseLoginActivity) {}
  
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
 * Qualified Name:     tmh
 * JD-Core Version:    0.7.0.1
 */