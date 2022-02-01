import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.qphone.base.util.QLog;

public class acln
  implements SensorEventListener
{
  private int cnt;
  private long lastTime;
  private float sR;
  private float sS;
  private float sT;
  private float sU;
  
  private void hO(long paramLong)
  {
    this.lastTime = paramLong;
    this.sR = 0.0F;
    this.sS = 0.0F;
    this.sT = 0.0F;
    this.sU = 0.0F;
    this.cnt = 0;
  }
  
  protected void FZ() {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = 0.0F;
    float f2;
    float f3;
    float f4;
    long l1;
    long l2;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      f2 = paramSensorEvent.values[0];
      f3 = paramSensorEvent.values[1];
      f4 = paramSensorEvent.values[2];
      l1 = System.currentTimeMillis();
      l2 = l1 - this.lastTime;
      if (l2 <= 5000L) {
        break label66;
      }
      hO(l1);
    }
    label66:
    while (l2 <= 80L) {
      return;
    }
    if ((this.sR != 0.0F) || (this.sS != 0.0F) || (this.sT != 0.0F)) {
      f1 = Math.abs(f2 - this.sR) + Math.abs(f3 - this.sS) + Math.abs(f4 - this.sT);
    }
    this.sU += f1;
    if ((this.sU > 180.0F) && (this.cnt >= 3))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("CIO_test", 2, "now[" + f2 + "," + f3 + "," + f4 + "]duration:" + l2 + " shake:" + f1);
        QLog.d("CIO_test", 2, "last[" + this.sR + "," + this.sS + "," + this.sT + "]total_shake:" + f1);
      }
      FZ();
      hO(l1);
      return;
    }
    if (this.cnt < 10)
    {
      this.cnt += 1;
      this.sR = f2;
      this.sS = f3;
      this.sT = f4;
      this.lastTime = l1;
      return;
    }
    hO(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acln
 * JD-Core Version:    0.7.0.1
 */