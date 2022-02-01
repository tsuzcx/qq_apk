import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;

public class ezc
  implements Runnable
{
  public ezc(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (BaseActivity.a() == null)
    {
      ezf localezf = new ezf(null);
      SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
      localSensorManager.registerListener(localezf, localSensorManager.getDefaultSensor(1), 0);
      BaseActivity.a(localezf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezc
 * JD-Core Version:    0.7.0.1
 */