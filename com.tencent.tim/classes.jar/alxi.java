import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.QLog;

public class alxi
{
  private alxi.a jdField_a_of_type_Alxi$a;
  private alxi.b jdField_a_of_type_Alxi$b;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private boolean mHasStarted;
  
  public static alxi a()
  {
    return alxi.c.b();
  }
  
  public int a(Context paramContext, alxi.b paramb)
  {
    QLog.d("MicroMsg.LightSensor", 1, "SensorShower start");
    if (this.mHasStarted)
    {
      QLog.d("MicroMsg.LightSensor", 1, "[SensorShower.start] light sensor has started");
      return 2;
    }
    this.mHasStarted = true;
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getApplicationContext().getSystemService("sensor"));
    paramContext = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(5);
    if (paramContext != null)
    {
      this.jdField_a_of_type_Alxi$a = new alxi.a(null);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Alxi$a, paramContext, 3);
      this.jdField_a_of_type_Alxi$b = paramb;
      return 0;
    }
    QLog.e("MicroMsg.LightSensor", 1, "[SensorShower.start] System do not have lightSensor");
    return 1;
  }
  
  public void stop()
  {
    QLog.d("MicroMsg.LightSensor", 1, "sensorshower stop");
    if ((!this.mHasStarted) || (this.jdField_a_of_type_AndroidHardwareSensorManager == null))
    {
      QLog.d("MicroMsg.LightSensor", 1, "sensorshower stop mHasStarted is false or mSensorShower is null");
      return;
    }
    this.mHasStarted = false;
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Alxi$a);
  }
  
  class a
    implements SensorEventListener
  {
    private float lux;
    
    private a() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (paramSensorEvent.sensor.getType() == 5)
      {
        this.lux = paramSensorEvent.values[0];
        if (alxi.a(alxi.this) != null) {
          alxi.a(alxi.this).onGetValue(this.lux);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onGetValue(float paramFloat);
  }
  
  static class c
  {
    private static alxi b = new alxi(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxi
 * JD-Core Version:    0.7.0.1
 */