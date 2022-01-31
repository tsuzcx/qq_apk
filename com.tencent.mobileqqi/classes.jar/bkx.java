import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.DataReport;
import com.tencent.qphone.base.util.QLog;

public class bkx
  implements SensorEventListener
{
  public bkx(VideoControlUI paramVideoControlUI) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int k = 0;
    float f2 = paramSensorEvent.values[0];
    float f1 = 3.1F;
    if (3.1F > this.a.b.getMaximumRange()) {
      f1 = this.a.b.getMaximumRange();
    }
    int i;
    if ((f2 >= 0.0D) && (f2 < f1) && (f2 < this.a.b.getMaximumRange()))
    {
      i = 1;
      if ((i == 0) || (!this.a.j)) {
        break label231;
      }
      paramSensorEvent = this.a.a.a().a;
      if (!this.a.a.a().n) {
        break label222;
      }
      if (paramSensorEvent != null)
      {
        i = 0;
        label123:
        if (i >= paramSensorEvent.length) {
          break label357;
        }
        j = k;
        if (!paramSensorEvent[i].equals("DEVICE_WIREDHEADSET")) {
          if (!paramSensorEvent[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label213;
          }
        }
      }
    }
    label213:
    label222:
    label357:
    for (int j = k;; j = 1)
    {
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoControlUI", 2, "setSensors pressHandFreeBtn");
        }
        this.a.s();
        this.a.k = true;
        DataReport.p(this.a.a);
      }
      label231:
      do
      {
        return;
        i = 0;
        break;
        i += 1;
        break label123;
        this.a.k = false;
        return;
      } while (!this.a.k);
      if (this.a.a != null) {}
      for (paramSensorEvent = this.a.a.a().a;; paramSensorEvent = null)
      {
        if (paramSensorEvent != null)
        {
          i = 0;
          if (i >= paramSensorEvent.length) {
            break label346;
          }
          if ((!paramSensorEvent[i].equals("DEVICE_WIREDHEADSET")) && (!paramSensorEvent[i].equals("DEVICE_BLUETOOTHHEADSET"))) {
            break label337;
          }
        }
        for (i = 0;; i = 1)
        {
          if (i != 0)
          {
            this.a.s();
            DataReport.p(this.a.a);
          }
          this.a.k = false;
          return;
          i += 1;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkx
 * JD-Core Version:    0.7.0.1
 */