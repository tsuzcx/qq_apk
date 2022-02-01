import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class advc
  extends adva
{
  private float[] mRotationMatrix = new float[16];
  
  public advc(Context paramContext, int paramInt, SensorManager paramSensorManager, adus.a parama)
    throws OrientationProviderNotFound
  {
    super(paramContext, paramInt, paramSensorManager, parama);
    paramContext = paramSensorManager.getDefaultSensor(11);
    if ((Build.VERSION.SDK_INT >= 9) && (paramContext != null))
    {
      this.sensorList.add(paramContext);
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(3));
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    aduu.a(this.mRotationMatrix, paramSensorEvent);
    super.e(this.mRotationMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advc
 * JD-Core Version:    0.7.0.1
 */