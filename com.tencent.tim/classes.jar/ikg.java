import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import java.lang.ref.WeakReference;

public class ikg
  implements CameraInterFace
{
  private static volatile ikg a;
  private boolean RV = true;
  private volatile int aod = -1;
  private WeakReference<SensorEventHandler.CameraChangedCallBack> bo;
  private SensorManager sensorManager;
  
  public static ikg a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ikg();
      }
      return a;
    }
    finally {}
  }
  
  public void UpdateCameraOrientation(boolean paramBoolean)
  {
    this.RV = paramBoolean;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.aod = i;
      return;
    }
  }
  
  public void a(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
  {
    if (paramCameraChangedCallBack == null) {
      return;
    }
    this.bo = new WeakReference(paramCameraChangedCallBack);
  }
  
  public void aw(Activity paramActivity)
  {
    if (paramActivity == null) {
      this.sensorManager = null;
    }
    while (this.sensorManager != null) {
      return;
    }
    this.sensorManager = ((SensorManager)paramActivity.getSystemService("sensor"));
  }
  
  public int getCameraID()
  {
    return this.aod;
  }
  
  public void ih(boolean paramBoolean)
  {
    UpdateCameraOrientation(paramBoolean);
    if (this.bo == null) {}
    SensorEventHandler.CameraChangedCallBack localCameraChangedCallBack;
    do
    {
      return;
      localCameraChangedCallBack = (SensorEventHandler.CameraChangedCallBack)this.bo.get();
    } while (localCameraChangedCallBack == null);
    localCameraChangedCallBack.onCameraChanged(paramBoolean);
  }
  
  public void registerListener(SensorEventListener paramSensorEventListener)
  {
    if ((this.sensorManager == null) || (paramSensorEventListener == null)) {}
    Sensor localSensor;
    do
    {
      return;
      localSensor = this.sensorManager.getDefaultSensor(11);
    } while (localSensor == null);
    this.sensorManager.registerListener(paramSensorEventListener, localSensor, 1);
  }
  
  public boolean tC()
  {
    if (this.sensorManager == null) {}
    while (this.sensorManager.getDefaultSensor(11) == null) {
      return false;
    }
    return true;
  }
  
  public boolean tD()
  {
    return this.RV;
  }
  
  public void unregisterListener(SensorEventListener paramSensorEventListener)
  {
    if ((this.sensorManager == null) || (paramSensorEventListener == null)) {
      return;
    }
    this.sensorManager.unregisterListener(paramSensorEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikg
 * JD-Core Version:    0.7.0.1
 */