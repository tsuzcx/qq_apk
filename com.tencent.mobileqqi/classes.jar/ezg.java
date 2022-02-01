import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;

public class ezg
  extends Thread
{
  public ezg(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    ezh localezh = new ezh(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    localSensorManager.registerListener(localezh, localSensorManager.getDefaultSensor(1), 0);
    BaseActivity2.a(localezh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezg
 * JD-Core Version:    0.7.0.1
 */