import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.richmedia.LBSDetetor;
import com.tencent.qphone.base.util.QLog;

public class xvu
  implements Handler.Callback
{
  public xvu(LBSDetetor paramLBSDetetor) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "check timeout. reqCookie:" + paramMessage.what);
    }
    LBSDetetor.a(this.a, false, null, paramMessage.what);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xvu
 * JD-Core Version:    0.7.0.1
 */