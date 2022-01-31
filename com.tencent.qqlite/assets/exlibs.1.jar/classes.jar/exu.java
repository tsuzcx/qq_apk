import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.mobileqq.utils.QQLSSensor.ProximitySensorChangeListener;
import com.tencent.qphone.base.util.QLog;

public class exu
  implements SensorEventListener
{
  public exu(QQLSSensor paramQQLSSensor) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "QQLSSensor onSensorChanged" + paramSensorEvent.values[0]);
    }
    if (QQLSSensor.a(this.a) == null) {
      return;
    }
    if (AIOUtils.b())
    {
      this.a.a = false;
      return;
    }
    if (paramSensorEvent.values[0] < QQLSSensor.a(this.a)) {
      QQLSSensor.a(this.a, true);
    }
    for (;;)
    {
      paramSensorEvent = Build.MODEL;
      if (!AIOUtils.a()) {
        break;
      }
      if (QQLSSensor.a(this.a).hasMessages(1)) {
        QQLSSensor.a(this.a).removeMessages(1);
      }
      QQLSSensor.a(this.a).sendMessageDelayed(QQLSSensor.a(this.a).obtainMessage(1), 150L);
      return;
      QQLSSensor.a(this.a, false);
    }
    if ((paramSensorEvent.equalsIgnoreCase("mi 3c")) || (paramSensorEvent.equalsIgnoreCase("K-Touch W619")) || (paramSensorEvent.equalsIgnoreCase("mi 3w")))
    {
      if (QQLSSensor.a(this.a).hasMessages(1)) {
        QQLSSensor.a(this.a).removeMessages(1);
      }
      QQLSSensor.a(this.a).sendMessageDelayed(QQLSSensor.a(this.a).obtainMessage(1), 250L);
      return;
    }
    QQLSSensor.a(this.a).a(QQLSSensor.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     exu
 * JD-Core Version:    0.7.0.1
 */