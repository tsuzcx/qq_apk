import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;

public class crc
  implements Runnable
{
  public crc(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (BaseActivity.a() == null)
    {
      crf localcrf = new crf(null);
      SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
      localSensorManager.registerListener(localcrf, localSensorManager.getDefaultSensor(1), 0);
      BaseActivity.a(localcrf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     crc
 * JD-Core Version:    0.7.0.1
 */