import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;

public class fdr
  implements Runnable
{
  public fdr(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (BaseActivity.a() == null)
    {
      fdu localfdu = new fdu(null);
      SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
      localSensorManager.registerListener(localfdu, localSensorManager.getDefaultSensor(1), 0);
      BaseActivity.a(localfdu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdr
 * JD-Core Version:    0.7.0.1
 */