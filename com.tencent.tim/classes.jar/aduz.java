import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class aduz
  implements SensorEventListener
{
  protected adus.a a;
  private float accuracy = -1.0F;
  private boolean bRe;
  protected float[] cp = new float[3];
  private float latitude = -1.0F;
  private float longitude = -1.0F;
  protected List<Sensor> sensorList = new ArrayList();
  protected SensorManager sensorManager;
  
  public aduz(SensorManager paramSensorManager, adus.a parama)
  {
    this.sensorManager = paramSensorManager;
    this.a = parama;
  }
  
  private GeomagneticField a()
  {
    if (this.bRe) {
      return new GeomagneticField(this.latitude, this.longitude, this.accuracy, System.currentTimeMillis());
    }
    return null;
  }
  
  protected float getDeclination()
  {
    GeomagneticField localGeomagneticField = a();
    if (localGeomagneticField != null) {
      return localGeomagneticField.getDeclination();
    }
    return 0.0F;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void start()
  {
    Iterator localIterator = this.sensorList.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.sensorManager.registerListener(this, localSensor, 1);
    }
  }
  
  public void start(int paramInt)
  {
    Iterator localIterator = this.sensorList.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.sensorManager.registerListener(this, localSensor, paramInt);
    }
  }
  
  public void stop()
  {
    Iterator localIterator = this.sensorList.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.sensorManager.unregisterListener(this, localSensor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aduz
 * JD-Core Version:    0.7.0.1
 */