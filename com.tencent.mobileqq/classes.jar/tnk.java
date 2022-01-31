import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

public class tnk
  implements Runnable
{
  public tnk(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)this.a.getSystemService("power");
      this.a.a = localPowerManager.newWakeLock(268435462, "QQLSActivity");
      this.a.a.acquire(10000L);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQLSActivity", 2, "acquireBrightWakeLock:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnk
 * JD-Core Version:    0.7.0.1
 */