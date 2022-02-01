import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.qphone.base.util.QLog;

public class cui
  extends Handler
{
  public cui(LoginInfoActivity paramLoginInfoActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cui
 * JD-Core Version:    0.7.0.1
 */