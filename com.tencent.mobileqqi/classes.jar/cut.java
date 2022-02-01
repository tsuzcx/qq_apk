import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;

public class cut
  extends Handler
{
  public cut(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2014: 
      this.a.finish();
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cut
 * JD-Core Version:    0.7.0.1
 */