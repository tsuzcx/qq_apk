import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class tom
  extends MqqHandler
{
  public tom(RegisterActivity paramRegisterActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        RegisterActivity.b(this.a, paramMessage);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "captcha sig is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tom
 * JD-Core Version:    0.7.0.1
 */