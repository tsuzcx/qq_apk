import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class abps
  implements SensorEventListener
{
  private long On;
  boolean aJE = false;
  private int mInterval;
  private SensorManager mSensorManager;
  
  public abps(Context paramContext, long paramLong, int paramInt)
  {
    this.mInterval = paramInt;
    this.On = paramLong;
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  public void cEa()
  {
    if (this.aJE) {
      return;
    }
    if (this.mSensorManager == null)
    {
      QLog.e("ApolloRender", 1, "SensorManager is null");
      abmt.a().callbackFromRequest(this.On, 1, "cs.xy_device_gyro_sensor_start.local", "{}");
      return;
    }
    Object localObject = this.mSensorManager.getDefaultSensor(4);
    if (localObject == null)
    {
      QLog.e("ApolloRender", 1, "Sensor gyro is null");
      abmt.a().callbackFromRequest(this.On, 2, "cs.xy_device_gyro_sensor_start.local", "{}");
      return;
    }
    boolean bool = this.mSensorManager.registerListener(this, (Sensor)localObject, this.mInterval);
    this.aJE = true;
    localObject = abmt.a();
    long l = this.On;
    if (bool) {}
    for (int i = 0;; i = 5)
    {
      ((ApolloCmdChannel)localObject).callbackFromRequest(l, i, "cs.xy_device_gyro_sensor_start.local", "{}");
      return;
    }
  }
  
  public void cEb()
  {
    if (!this.aJE) {
      return;
    }
    if (this.mSensorManager == null)
    {
      QLog.e("ApolloRender", 1, "SensorManager is null");
      return;
    }
    this.mSensorManager.unregisterListener(this);
    this.aJE = false;
    QLog.e("ApolloRender", 1, "Sensor unRegister");
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    try
    {
      paramSensorEvent = paramSensorEvent.values;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("gyroX", paramSensorEvent[0]);
      localJSONObject.put("gyroY", paramSensorEvent[1]);
      localJSONObject.put("gyroZ", paramSensorEvent[2]);
      abmt.a().callbackFromRequest(this.On, 0, "cs.xy_device_gyro_sensor_scope_update.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramSensorEvent)
    {
      QLog.e("ApolloRender", 1, paramSensorEvent, new Object[0]);
    }
  }
  
  public void setState(long paramLong)
  {
    this.On = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abps
 * JD-Core Version:    0.7.0.1
 */