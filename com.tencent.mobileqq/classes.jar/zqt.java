import android.os.Process;
import com.tencent.mobileqq.app.ProcessExitReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class zqt
  implements Runnable
{
  public zqt(ProcessExitReceiver paramProcessExitReceiver) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProcessExitReceiver", 2, "Kill process " + MobileQQ.getMobileQQ().getProcessName());
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqt
 * JD-Core Version:    0.7.0.1
 */