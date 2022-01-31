import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;

public class cpv
  implements Runnable
{
  public cpv(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (BaseActivity.a() == null)
    {
      cpy localcpy = new cpy(null);
      SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
      localSensorManager.registerListener(localcpy, localSensorManager.getDefaultSensor(1), 0);
      BaseActivity.a(localcpy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cpv
 * JD-Core Version:    0.7.0.1
 */