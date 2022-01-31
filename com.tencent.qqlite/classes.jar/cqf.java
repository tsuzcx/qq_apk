import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;

public class cqf
  extends Thread
{
  public cqf(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    cqh localcqh = new cqh(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    localSensorManager.registerListener(localcqh, localSensorManager.getDefaultSensor(1), 0);
    BaseActivity2.a(localcqh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cqf
 * JD-Core Version:    0.7.0.1
 */