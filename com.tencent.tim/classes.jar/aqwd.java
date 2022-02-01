import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aqwd
  extends MqqHandler
{
  aqwd(aqwc paramaqwc) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 104: 
      do
      {
        return;
        paramMessage = (String)paramMessage.obj;
        if ((this.this$0.b != null) && (!TextUtils.isEmpty(paramMessage)))
        {
          this.this$0.b.OU(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(aqwc.TAG, 2, "captcha sig is empty");
      return;
    }
    aqwc.a(this.this$0).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwd
 * JD-Core Version:    0.7.0.1
 */