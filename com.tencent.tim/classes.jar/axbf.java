import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.OrientationListener;
import com.tencent.ttpic.baseutils.log.LogUtils;

public abstract class axbf
{
  private OrientationListener a;
  private int efy;
  private boolean mEnabled;
  private int mOrientation = -1;
  private Sensor mSensor;
  private SensorEventListener mSensorEventListener;
  private SensorManager mSensorManager;
  
  public axbf(Context paramContext)
  {
    this(paramContext, 3);
  }
  
  public axbf(Context paramContext, int paramInt)
  {
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.efy = paramInt;
    this.mSensor = this.mSensorManager.getDefaultSensor(1);
    if (this.mSensor != null) {
      this.mSensorEventListener = new axbf.a();
    }
  }
  
  public boolean canDetectOrientation()
  {
    return this.mSensor != null;
  }
  
  public void disable()
  {
    if (this.mSensor == null) {
      LogUtils.w("MOEL", "Cannot detect sensors. Invalid disable");
    }
    while (this.mEnabled != true) {
      return;
    }
    this.mSensorManager.unregisterListener(this.mSensorEventListener);
    this.mEnabled = false;
  }
  
  public void enable()
  {
    if (this.mSensor == null) {
      LogUtils.w("MOEL", "Cannot detect sensors. Not enabled");
    }
    while (this.mEnabled) {
      return;
    }
    this.mSensorManager.registerListener(this.mSensorEventListener, this.mSensor, this.efy);
    this.mEnabled = true;
  }
  
  public abstract void o(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void onOrientationChanged(int paramInt);
  
  class a
    implements SensorEventListener
  {
    a() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      float[] arrayOfFloat = paramSensorEvent.values;
      int j = -1;
      float f1 = -arrayOfFloat[0];
      float f2 = -arrayOfFloat[1];
      float f3 = -arrayOfFloat[2];
      if ((f1 * f1 + f2 * f2) * 35.0F >= f3 * f3)
      {
        j = 90 - Math.round(57.29578F * (float)Math.atan2(-f2, f1));
        int i;
        for (;;)
        {
          i = j;
          if (j < 360) {
            break;
          }
          j -= 360;
        }
        for (;;)
        {
          j = i;
          if (i >= 0) {
            break;
          }
          i += 360;
        }
      }
      if (axbf.a(axbf.this) != null) {
        axbf.a(axbf.this).onSensorChanged(1, paramSensorEvent.values);
      }
      if (j != axbf.a(axbf.this))
      {
        axbf.a(axbf.this, j);
        axbf.this.onOrientationChanged(j);
      }
      axbf.this.o((f1 + 9.8F) * 180.0F / 19.6F, (f2 + 9.8F) * 180.0F / 19.6F, (f3 + 9.8F) * 180.0F / 19.6F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbf
 * JD-Core Version:    0.7.0.1
 */