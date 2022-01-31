import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mobileqq.app.BaseActivity;

public class yxc
  implements Runnable
{
  public yxc(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    try
    {
      if (BaseActivity.access$300() != null)
      {
        ((SensorManager)this.a.getApplicationContext().getSystemService("sensor")).unregisterListener(BaseActivity.access$300());
        BaseActivity.access$302(null);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yxc
 * JD-Core Version:    0.7.0.1
 */