import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager.ARSensorTrackCallback;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;

public class zxe
  extends SimpleSensorChangeListener
{
  public zxe(SensorTrackManager paramSensorTrackManager) {}
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    if (SensorTrackManager.a(this.a) != null) {
      SensorTrackManager.a(this.a).a(paramArrayOfFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxe
 * JD-Core Version:    0.7.0.1
 */