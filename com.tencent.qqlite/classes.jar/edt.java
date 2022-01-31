import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.qphone.base.util.QLog;

public class edt
  extends Handler
{
  public edt(AppLaucherHelper paramAppLaucherHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
    {
      AppLaucherHelper.a = false;
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "wtlogin time out");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     edt
 * JD-Core Version:    0.7.0.1
 */