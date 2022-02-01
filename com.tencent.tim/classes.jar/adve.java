import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class adve
  extends adva
{
  private float[] co = new float[16];
  float[] ct = new float[3];
  private float lastAzimuth = -1.0F;
  private float lastPitch = -1.0F;
  private float lastRoll = -1.0F;
  
  public adve(Context paramContext, int paramInt, SensorManager paramSensorManager, adus.a parama)
    throws OrientationProviderNotFound
  {
    super(paramContext, paramInt, paramSensorManager, parama);
    if (paramSensorManager.getDefaultSensor(3) != null)
    {
      this.sensorList.add(paramSensorManager.getDefaultSensor(3));
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(3));
  }
  
  private void j(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.a == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.lastAzimuth) > 1.0F)
    {
      this.lastAzimuth = paramFloat1;
      this.a.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.lastPitch) > 1.0F)
    {
      this.lastPitch = paramFloat2;
      this.a.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.lastRoll) > 1.0F)
    {
      this.lastRoll = paramFloat3;
      this.a.updateRoll(paramFloat3);
    }
    this.a.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 3)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.cp, 0, 3);
      if (this.cKk != 1)
      {
        this.ct[0] = ((float)Math.toRadians(this.cp[0]));
        this.ct[1] = ((float)Math.toRadians(this.cp[1]));
        this.ct[2] = ((float)Math.toRadians(this.cp[2]));
        aduu.b(aduu.d(this.ct), this.co);
        super.e(this.co);
      }
    }
    else
    {
      return;
    }
    j(this.cp[0], this.cp[1], this.cp[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adve
 * JD-Core Version:    0.7.0.1
 */