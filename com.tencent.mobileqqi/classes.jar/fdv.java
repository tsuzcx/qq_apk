import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;

public class fdv
  extends Thread
{
  public fdv(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    fdw localfdw = new fdw(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    localSensorManager.registerListener(localfdw, localSensorManager.getDefaultSensor(1), 0);
    BaseActivity2.a(localfdw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdv
 * JD-Core Version:    0.7.0.1
 */