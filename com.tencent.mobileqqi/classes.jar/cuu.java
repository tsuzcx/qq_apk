import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;

public class cuu
  extends Handler
{
  public cuu(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
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
 * Qualified Name:     cuu
 * JD-Core Version:    0.7.0.1
 */