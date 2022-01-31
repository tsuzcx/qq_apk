import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;

public class cpz
  extends Thread
{
  public cpz(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    cqb localcqb = new cqb(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    localSensorManager.registerListener(localcqb, localSensorManager.getDefaultSensor(1), 0);
    BaseActivity2.a(localcqb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cpz
 * JD-Core Version:    0.7.0.1
 */