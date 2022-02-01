import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class aqua
  implements SensorEventListener
{
  aqua(aqtz paramaqtz, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.values[0] > 1.0E+008F) || (NetConnInfoCenter.getServerTimeMillis() > this.atO))
    {
      QLog.e("SportManager", 1, "unregister listener:" + paramSensorEvent.values[0]);
      if (aqtz.e != null) {
        aqtz.e.unregisterListener(this);
      }
      return;
    }
    if ((aqtw.atM == 0L) || (aqtw.ecO == 0))
    {
      QLog.e("SportManager", 1, "lastReportStepTime:" + aqtw.atM + ",cur_total:" + aqtw.ecO);
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis() - aqtw.atM;
    int i = (int)(paramSensorEvent.values[0] - aqtw.ecO);
    if ((l > this.val$interval) && (i > this.ecS))
    {
      this.this$0.VI("timer1 report");
      return;
    }
    QLog.e("SportManager", 1, "sensor event step:" + paramSensorEvent.values[0] + ",cur_total:" + aqtw.ecO + ",interval time:" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqua
 * JD-Core Version:    0.7.0.1
 */