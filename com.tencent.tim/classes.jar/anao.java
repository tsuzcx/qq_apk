import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class anao
  extends Handler
{
  anao(anan paramanan) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
    {
      anan.cEB = false;
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "wtlogin time out");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anao
 * JD-Core Version:    0.7.0.1
 */