import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.CrashGuard;
import cooperation.qzone.QZoneHelper.LocalConfig;
import java.util.concurrent.atomic.AtomicBoolean;

public class ibp
  implements Runnable
{
  public ibp(CrashGuard paramCrashGuard, long paramLong) {}
  
  public void run()
  {
    CrashGuard.a(this.jdField_a_of_type_CooperationQzoneCrashGuard).set(true);
    QLog.i("QZLog", 1, "clear crash count with no crash");
    QZoneHelper.LocalConfig.a("key_crash_count", 0, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ibp
 * JD-Core Version:    0.7.0.1
 */