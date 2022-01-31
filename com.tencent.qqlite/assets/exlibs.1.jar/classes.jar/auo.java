import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;

public class auo
  extends Handler
{
  public auo(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     auo
 * JD-Core Version:    0.7.0.1
 */