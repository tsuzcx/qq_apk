import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class kxt
  implements SensorEventListener
{
  private static volatile kxt a;
  private boolean aiF = false;
  private boolean aiG;
  private boolean aiH;
  private final float alpha = 0.8F;
  private double[] f = new double[3];
  private final double[] g = new double[4];
  private float[] gravity = new float[3];
  private Sensor h;
  private Sensor i;
  private Context mContext;
  private SensorManager mSensorManager;
  private float timestamp;
  
  public static kxt a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new kxt();
      }
      return a;
    }
    finally {}
  }
  
  public double[] a()
  {
    return this.g;
  }
  
  public double[] b()
  {
    return this.f;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 4: 
      if (this.timestamp != 0.0F)
      {
        float f7 = (float)paramSensorEvent.timestamp;
        float f8 = this.timestamp;
        float f6 = paramSensorEvent.values[0];
        float f5 = paramSensorEvent.values[1];
        float f4 = paramSensorEvent.values[2];
        double d1 = Math.sqrt(f6 * f6 + f5 * f5 + f4 * f4);
        float f3 = f4;
        float f2 = f5;
        float f1 = f6;
        if (d1 > 9.999999717180685E-010D)
        {
          f1 = (float)(f6 / d1);
          f2 = (float)(f5 / d1);
          f3 = (float)(f4 / d1);
        }
        double d2 = d1 * ((f7 - f8) * 1.0E-009F) / 2.0D;
        d1 = Math.sin(d2);
        d2 = Math.cos(d2);
        this.g[0] = (f1 * d1);
        this.g[1] = (f2 * d1);
        this.g[2] = (f3 * d1);
        this.g[3] = d2;
      }
      this.timestamp = ((float)paramSensorEvent.timestamp);
      return;
    }
    this.gravity[0] = (this.gravity[0] * 0.8F + paramSensorEvent.values[0] * 0.2F);
    this.gravity[1] = (this.gravity[1] * 0.8F + paramSensorEvent.values[1] * 0.2F);
    this.gravity[2] = (this.gravity[2] * 0.8F + paramSensorEvent.values[2] * 0.2F);
    this.f[0] = (paramSensorEvent.values[0] - this.gravity[0]);
    this.f[1] = (paramSensorEvent.values[1] - this.gravity[1]);
    this.f[2] = (paramSensorEvent.values[2] - this.gravity[2]);
  }
  
  public void register()
  {
    if (this.mContext == null) {
      this.mContext = BaseApplication.getContext();
    }
    if (this.mSensorManager == null) {
      this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    }
    if (this.mSensorManager == null) {}
    do
    {
      return;
      if (this.h == null) {
        this.h = this.mSensorManager.getDefaultSensor(4);
      }
      if (this.i == null) {
        this.i = this.mSensorManager.getDefaultSensor(1);
      }
    } while (this.aiF);
    this.aiG = this.mSensorManager.registerListener(this, this.h, 3);
    this.aiH = this.mSensorManager.registerListener(this, this.i, 3);
    this.aiF = true;
    QLog.d("ReadinjoySensorUtils", 1, "register,gyroscopeEnable=" + this.aiG + " ,accelerometerEnable" + this.aiH);
  }
  
  public void unRegister()
  {
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this);
    }
    this.aiF = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kxt
 * JD-Core Version:    0.7.0.1
 */