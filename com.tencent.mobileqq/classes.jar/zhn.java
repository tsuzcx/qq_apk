import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.statistics.battery.BackgroundCpuMonitor;

public class zhn
  implements Runnable
{
  public zhn(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    zhp localzhp = new zhp(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    Sensor localSensor = localSensorManager.getDefaultSensor(1);
    if (BackgroundCpuMonitor.a().a()) {}
    for (int i = 2;; i = 0)
    {
      localSensorManager.registerListener(localzhp, localSensor, i);
      BaseActivity2.a(localzhp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhn
 * JD-Core Version:    0.7.0.1
 */