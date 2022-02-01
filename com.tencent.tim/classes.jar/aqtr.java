import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.qphone.base.util.QLog;

public class aqtr
  implements SensorEventListener
{
  public aqtr(PathTraceManager paramPathTraceManager) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    QLog.d("PathTraceManager", 1, "step Changed:" + paramSensorEvent.values[0]);
    if (PathTraceManager.a(this.this$0) == 1)
    {
      PathTraceManager.a(this.this$0, (int)paramSensorEvent.values[0]);
      if ((PathTraceManager.a(this.this$0) == null) || (PathTraceManager.b(this.this$0) <= PathTraceManager.c(this.this$0)) || (PathTraceManager.c(this.this$0) == 0)) {
        break label331;
      }
      i = PathTraceManager.a(this.this$0).totalSteps;
      if (!this.this$0.debug) {
        break label246;
      }
      paramSensorEvent = PathTraceManager.a(this.this$0);
      paramSensorEvent.totalSteps += (PathTraceManager.b(this.this$0) - PathTraceManager.c(this.this$0)) * (int)(20.0D * Math.random());
      PathTraceManager.b(this.this$0, PathTraceManager.b(this.this$0));
      PathTraceManager.a(this.this$0, null);
      if (PathTraceManager.a(this.this$0).type == 1)
      {
        if ((i >= PathTraceManager.a(this.this$0).stepsGoal) || (PathTraceManager.a(this.this$0).totalSteps < PathTraceManager.a(this.this$0).stepsGoal)) {
          break label281;
        }
        this.this$0.a(PathTraceManager.a(this.this$0), false, true);
      }
    }
    label246:
    while (PathTraceManager.c(this.this$0) != 0)
    {
      int i;
      do
      {
        for (;;)
        {
          return;
          paramSensorEvent = PathTraceManager.a(this.this$0);
          paramSensorEvent.totalSteps += PathTraceManager.b(this.this$0) - PathTraceManager.c(this.this$0);
        }
      } while (Math.floor(PathTraceManager.a(this.this$0).totalSteps / 1000) - Math.floor(i / 1000) <= 0.0D);
      this.this$0.a(PathTraceManager.a(this.this$0), false, false);
      return;
    }
    label281:
    label331:
    PathTraceManager.b(this.this$0, PathTraceManager.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtr
 * JD-Core Version:    0.7.0.1
 */