import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class aduy
  extends adva
{
  boolean bRb = false;
  private float[] ci = new float[3];
  private float[] cn = new float[3];
  private float[] co = new float[16];
  private float lastAzimuth = -1.0F;
  private float lastPitch = -1.0F;
  private float lastRoll = -1.0F;
  
  public aduy(Context paramContext, int paramInt, SensorManager paramSensorManager, adus.a parama)
    throws OrientationProviderNotFound
  {
    super(paramContext, paramInt, paramSensorManager, parama);
    paramContext = paramSensorManager.getDefaultSensor(1);
    if (paramContext != null)
    {
      this.sensorList.add(paramContext);
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(1));
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
    if (paramSensorEvent.sensor.getType() == 1)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.cp, 0, 3);
      float f1 = this.cp[0];
      float f2 = this.cp[1];
      float f3 = this.cp[2];
      this.ci[1] = (-(float)Math.atan2(f2, f3));
      this.ci[2] = ((float)Math.atan2(-f1, Math.sqrt(f2 * f2 + f3 * f3)));
      if (this.bRb) {
        this.ci = adut.a(this.ci, this.cn);
      }
      System.arraycopy(this.ci, 0, this.cn, 0, 3);
      this.bRb = true;
      aduu.b(aduu.d(this.ci), this.co);
      if (this.cKk != 1) {
        super.e(this.co);
      }
    }
    else
    {
      return;
    }
    j(0.0F, (float)(this.ci[1] * 180.0F / 3.141592653589793D), (float)(this.ci[2] * 180.0F / 3.141592653589793D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aduy
 * JD-Core Version:    0.7.0.1
 */