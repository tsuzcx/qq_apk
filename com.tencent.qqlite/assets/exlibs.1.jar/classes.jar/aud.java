import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.qphone.base.util.QLog;

public class aud
  extends Handler
{
  public aud(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "handleMessage.msg.arg1=" + paramMessage.arg1);
      }
    } while (LoginInfoActivity.a(this.a) == null);
    LoginInfoActivity.a(this.a).DevSetup = paramMessage.arg1;
    LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aud
 * JD-Core Version:    0.7.0.1
 */