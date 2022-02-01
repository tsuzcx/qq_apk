import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vru
  extends MqqHandler
{
  public vru(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.this$0.finish();
      return;
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        RegisterPhoneNumActivity.a(this.this$0).OU(paramMessage);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RegisterPhoneNumActivity", 2, "captcha sig is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vru
 * JD-Core Version:    0.7.0.1
 */