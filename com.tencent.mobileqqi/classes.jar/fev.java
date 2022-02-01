import android.os.Process;
import com.tencent.mobileqq.app.ProcessExitReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class fev
  extends Thread
{
  public fev(ProcessExitReceiver paramProcessExitReceiver) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProcessExitReceiver", 2, "Kill process " + MobileQQ.getMobileQQ().getProcessNames());
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fev
 * JD-Core Version:    0.7.0.1
 */