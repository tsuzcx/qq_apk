import android.os.Process;
import com.tencent.mobileqq.app.ProcessExitReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class few
  extends Thread
{
  public few(ProcessExitReceiver paramProcessExitReceiver) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProcessExitReceiver", 2, "Kill process " + MobileQQ.getMobileQQ().getProcessName());
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     few
 * JD-Core Version:    0.7.0.1
 */