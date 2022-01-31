import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.av.ui.VideoControlUI;

public class bkw
  implements SensorEventListener
{
  float jdField_a_of_type_Float;
  float b;
  float c;
  
  public bkw(VideoControlUI paramVideoControlUI) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1;
    float f2;
    float f3;
    int i;
    int j;
    label73:
    int k;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      f1 = paramSensorEvent.values[0];
      f2 = paramSensorEvent.values[1];
      f3 = paramSensorEvent.values[2];
      if (Math.abs(this.jdField_a_of_type_Float - f1) <= 0.5D) {
        break label134;
      }
      i = 1;
      if (Math.abs(this.b - f2) <= 0.5D) {
        break label140;
      }
      j = 1;
      if (Math.abs(this.c - f3) <= 0.5D) {
        break label146;
      }
      k = 1;
      label94:
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label152;
      }
    }
    for (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.j = true;; this.jdField_a_of_type_ComTencentAvUiVideoControlUI.j = false) {
      label134:
      label140:
      label146:
      label152:
      do
      {
        this.jdField_a_of_type_Float = f1;
        this.b = f2;
        this.c = f3;
        return;
        i = 0;
        break;
        j = 0;
        break label73;
        k = 0;
        break label94;
      } while ((i != 0) || (j != 0) || (k != 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkw
 * JD-Core Version:    0.7.0.1
 */