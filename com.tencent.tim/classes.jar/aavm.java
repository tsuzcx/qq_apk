import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.activity.richmedia.view.SensorFrameImageView;

public class aavm
  implements SensorEventListener
{
  public aavm(SensorFrameImageView paramSensorFrameImageView) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    }
    for (;;)
    {
      SensorFrameImageView.a(this.a);
      SensorFrameImageView.b(this.a);
      return;
      SensorFrameImageView.a(this.a, paramSensorEvent.values);
      continue;
      SensorFrameImageView.b(this.a, paramSensorEvent.values);
      continue;
      SensorFrameImageView.c(this.a, paramSensorEvent.values);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavm
 * JD-Core Version:    0.7.0.1
 */