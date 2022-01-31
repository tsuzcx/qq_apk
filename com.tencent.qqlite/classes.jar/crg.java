import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity2;

public class crg
  extends Thread
{
  public crg(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    cri localcri = new cri(null);
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    localSensorManager.registerListener(localcri, localSensorManager.getDefaultSensor(1), 0);
    BaseActivity2.a(localcri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     crg
 * JD-Core Version:    0.7.0.1
 */