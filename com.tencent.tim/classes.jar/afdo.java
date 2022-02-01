import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class afdo
  extends Handler
{
  afdo(afdm paramafdm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (afdm.a(this.a));
    QLog.e("CameraHelper", 1, "checkPermission uncertain");
    afdm.a(this.a, false, 1830004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdo
 * JD-Core Version:    0.7.0.1
 */