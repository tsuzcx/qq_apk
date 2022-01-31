import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;

public final class vkv
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "self-destory BOOM!!!!");
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkv
 * JD-Core Version:    0.7.0.1
 */