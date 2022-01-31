import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;

public class ezd
  implements Runnable
{
  public ezd(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (BaseActivity.a() == null)
    {
      ezg localezg = new ezg(null);
      SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
      localSensorManager.registerListener(localezg, localSensorManager.getDefaultSensor(1), 0);
      BaseActivity.a(localezg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezd
 * JD-Core Version:    0.7.0.1
 */