import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;

public class ezh
  extends Thread
{
  public ezh(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    ezi localezi = new ezi(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    localSensorManager.registerListener(localezi, localSensorManager.getDefaultSensor(1), 0);
    BaseActivity2.a(localezi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezh
 * JD-Core Version:    0.7.0.1
 */