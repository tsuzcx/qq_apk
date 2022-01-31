import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.statistics.battery.BackgroundCpuMonitor;

public class zan
  implements Runnable
{
  public zan(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    zap localzap = new zap(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    Sensor localSensor = localSensorManager.getDefaultSensor(1);
    if (BackgroundCpuMonitor.a().a()) {}
    for (int i = 2;; i = 0)
    {
      localSensorManager.registerListener(localzap, localSensor, i);
      BaseActivity2.a(localzap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zan
 * JD-Core Version:    0.7.0.1
 */