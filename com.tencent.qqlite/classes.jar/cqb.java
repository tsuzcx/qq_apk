import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;

public class cqb
  implements Runnable
{
  public cqb(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (BaseActivity.a() == null)
    {
      cqe localcqe = new cqe(null);
      SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
      localSensorManager.registerListener(localcqe, localSensorManager.getDefaultSensor(1), 0);
      BaseActivity.a(localcqe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cqb
 * JD-Core Version:    0.7.0.1
 */