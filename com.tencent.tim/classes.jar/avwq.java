import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class avwq
  implements SensorEventListener
{
  private avwq.a a;
  private float[] angle = new float[3];
  private float[] cX = new float[3];
  private Sensor l;
  private SensorManager mSensorManager;
  private long timestamp;
  
  public avwq(Context paramContext, avwq.a parama)
  {
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.l = this.mSensorManager.getDefaultSensor(4);
    this.a = parama;
  }
  
  public void eCa()
  {
    this.mSensorManager.registerListener(this, this.l, 1);
  }
  
  public void eCb()
  {
    this.mSensorManager.unregisterListener(this, this.l);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 4)
    {
      if (this.timestamp != 0L)
      {
        float f1 = (float)(paramSensorEvent.timestamp - this.timestamp) * 1.0E-009F;
        float[] arrayOfFloat = this.angle;
        arrayOfFloat[0] += paramSensorEvent.values[0] * f1;
        arrayOfFloat = this.angle;
        arrayOfFloat[1] += paramSensorEvent.values[1] * f1;
        arrayOfFloat = this.angle;
        float f2 = arrayOfFloat[2];
        arrayOfFloat[2] = (f1 * paramSensorEvent.values[2] + f2);
        f1 = (float)Math.toDegrees(this.angle[0] - this.cX[0]);
        f2 = (float)Math.toDegrees(this.angle[1] - this.cX[1]);
        float f3 = (float)Math.toDegrees(this.angle[2] - this.cX[2]);
        if (this.a != null) {
          this.a.n(f1 * 1.0F, f2 * 1.0F, f3 * 1.0F);
        }
        this.cX[0] = this.angle[0];
        this.cX[1] = this.angle[1];
        this.cX[2] = this.angle[2];
      }
      this.timestamp = paramSensorEvent.timestamp;
    }
  }
  
  public static abstract interface a
  {
    public abstract void n(float paramFloat1, float paramFloat2, float paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwq
 * JD-Core Version:    0.7.0.1
 */