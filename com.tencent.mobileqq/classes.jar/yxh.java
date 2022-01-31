import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.statistics.battery.BackgroundCpuMonitor;

public class yxh
  implements Runnable
{
  public yxh(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    yxj localyxj = new yxj(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    Sensor localSensor = localSensorManager.getDefaultSensor(1);
    if (BackgroundCpuMonitor.a().a()) {}
    for (int i = 2;; i = 0)
    {
      localSensorManager.registerListener(localyxj, localSensor, i);
      BaseActivity2.a(localyxj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yxh
 * JD-Core Version:    0.7.0.1
 */