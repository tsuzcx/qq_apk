import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class adux
  extends adva
{
  boolean bRc = false;
  private float[] cf = new float[3];
  private float[] cg = new float[3];
  private float[] ci = new float[3];
  private float[] cl = new float[3];
  private float[] cm = new float[3];
  private float lastAzimuth = -1.0F;
  private float lastPitch = -1.0F;
  private float lastRoll = -1.0F;
  private float[] rotationMatrix = new float[16];
  
  public adux(Context paramContext, int paramInt, SensorManager paramSensorManager, adus.a parama)
    throws OrientationProviderNotFound
  {
    super(paramContext, paramInt, paramSensorManager, parama);
    paramContext = paramSensorManager.getDefaultSensor(1);
    paramSensorManager = paramSensorManager.getDefaultSensor(2);
    if ((paramContext != null) && (paramSensorManager != null))
    {
      this.sensorList.add(paramContext);
      this.sensorList.add(paramSensorManager);
      return;
    }
    throw new OrientationProviderNotFound("1,2");
  }
  
  private void j(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.a == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.lastAzimuth) > 2.0F)
    {
      this.lastAzimuth = paramFloat1;
      this.a.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.lastPitch) > 2.0F)
    {
      this.lastPitch = paramFloat2;
      this.a.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.lastRoll) > 2.0F)
    {
      this.lastRoll = paramFloat3;
      this.a.updateRoll(paramFloat3);
    }
    this.a.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 2)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.cf, 0, 3);
      adut.a(this.cf, this.cm);
      System.arraycopy(this.cf, 0, this.cm, 0, 3);
      this.bRc = true;
    }
    for (;;)
    {
      if ((this.bRc) && (SensorManager.getRotationMatrix(this.rotationMatrix, null, this.cg, this.cf)))
      {
        SensorManager.getOrientation(this.rotationMatrix, this.ci);
        if (this.cKk == 1) {
          break;
        }
        super.e(this.rotationMatrix);
      }
      return;
      if (paramSensorEvent.sensor.getType() == 1)
      {
        System.arraycopy(paramSensorEvent.values, 0, this.cg, 0, 3);
        adut.a(this.cg, this.cl);
        System.arraycopy(this.cg, 0, this.cl, 0, 3);
      }
    }
    j((float)(Math.toDegrees(this.ci[0] + getDeclination()) + 360.0D) % 360.0F, (float)(this.ci[1] * 180.0F / 3.141592653589793D), (float)(this.ci[2] * 180.0F / 3.141592653589793D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adux
 * JD-Core Version:    0.7.0.1
 */