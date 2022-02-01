import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class aqln
  implements SensorEventListener
{
  aqln(aqlm paramaqlm) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (aqlm.a(this.b) == null) {
      return;
    }
    if (wja.Rc())
    {
      this.b.hasSensor = false;
      return;
    }
    if (???.values[0] < aqlm.a(this.b)) {
      aqlm.a(this.b, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!wja.Rb()) {
        break;
      }
      if (aqlm.a(this.b).hasMessages(1)) {
        aqlm.a(this.b).removeMessages(1);
      }
      aqlm.a(this.b).sendMessageDelayed(aqlm.a(this.b).obtainMessage(1), 150L);
      return;
      aqlm.a(this.b, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (aqlm.a(this.b).hasMessages(1)) {
        aqlm.a(this.b).removeMessages(1);
      }
      aqlm.a(this.b).sendMessageDelayed(aqlm.a(this.b).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.b)
    {
      if (aqlm.a(this.b) != null) {
        aqlm.a(this.b).xP(aqlm.a(this.b));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqln
 * JD-Core Version:    0.7.0.1
 */