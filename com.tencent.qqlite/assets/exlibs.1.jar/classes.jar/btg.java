import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;

public class btg
  implements SensorEventListener
{
  public btg(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f3;
    float f2;
    float f1;
    int i;
    int j;
    int k;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      float f6 = paramSensorEvent.values[0];
      float f5 = paramSensorEvent.values[1];
      float f4 = paramSensorEvent.values[2];
      f3 = f4;
      f2 = f5;
      f1 = f6;
      if (MediaPlayerManager.a())
      {
        f1 = f6 * 10.0F;
        f2 = f5 * 10.0F;
        f3 = f4 * 10.0F;
      }
      i = (int)(this.a.jdField_a_of_type_Float - f1);
      j = (int)(this.a.b - f2);
      k = (int)(this.a.c - f3);
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label156;
      }
    }
    for (this.a.jdField_a_of_type_Boolean = true;; this.a.jdField_a_of_type_Boolean = false) {
      label156:
      do
      {
        this.a.jdField_a_of_type_Float = f1;
        this.a.b = f2;
        this.a.c = f3;
        return;
      } while ((i != 0) || (j != 0) || (k != 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     btg
 * JD-Core Version:    0.7.0.1
 */