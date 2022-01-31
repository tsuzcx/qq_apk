import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.qphone.base.util.QLog;

public class asu
  extends Handler
{
  public asu(LoginActivity paramLoginActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 20140107: 
      do
      {
        return;
      } while (this.a.isFinishing());
      try
      {
        this.a.dismissDialog(0);
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "recv message FINISH_ACTIVITY.. finish activity");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asu
 * JD-Core Version:    0.7.0.1
 */