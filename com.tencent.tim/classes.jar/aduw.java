import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class aduw
  extends adva
{
  boolean bRb = false;
  boolean bRc = false;
  boolean bRd = false;
  private final float[] cc = new float[4];
  private float[] cd = new float[3];
  private float[] ce = new float[3];
  private float[] cf = new float[3];
  private float[] cg = new float[3];
  private float[] ch = new float[3];
  private float[] ci = new float[3];
  private float[] cj = new float[9];
  private float[] ck = new float[16];
  private float lastAzimuth = -1.0F;
  private float lastPitch = -1.0F;
  private float lastRoll = -1.0F;
  private float[] rotationMatrix = new float[9];
  private float timestamp;
  
  public aduw(Context paramContext, int paramInt, SensorManager paramSensorManager, adus.a parama)
    throws OrientationProviderNotFound
  {
    super(paramContext, paramInt, paramSensorManager, parama);
    paramContext = paramSensorManager.getDefaultSensor(4);
    parama = paramSensorManager.getDefaultSensor(1);
    paramSensorManager = paramSensorManager.getDefaultSensor(2);
    if ((paramContext != null) && (parama != null) && (paramSensorManager != null))
    {
      this.sensorList.add(paramContext);
      this.sensorList.add(parama);
      this.sensorList.add(paramSensorManager);
      initData();
      return;
    }
    throw new OrientationProviderNotFound("4,1,2");
  }
  
  private void c(SensorEvent paramSensorEvent)
  {
    if (!this.bRb) {
      return;
    }
    float[] arrayOfFloat;
    if (!this.bRd)
    {
      arrayOfFloat = new float[9];
      arrayOfFloat = aduu.d(this.ci);
      SensorManager.getOrientation(arrayOfFloat, new float[3]);
      this.cj = aduu.b(this.cj, arrayOfFloat);
      this.bRd = true;
    }
    if ((this.timestamp != 0.0F) && (this.bRd))
    {
      float f7 = (float)paramSensorEvent.timestamp;
      float f8 = this.timestamp;
      System.arraycopy(paramSensorEvent.values, 0, this.ch, 0, 3);
      float f6 = this.ch[0];
      float f5 = this.ch[1];
      float f4 = this.ch[2];
      float f9 = (float)Math.sqrt(f6 * f6 + f5 * f5 + f4 * f4);
      float f3 = f4;
      float f2 = f5;
      float f1 = f6;
      if (f9 > 1.0E-009F)
      {
        f1 = f6 / f9;
        f2 = f5 / f9;
        f3 = f4 / f9;
      }
      f5 = (f7 - f8) * 1.0E-009F * f9 / 2.0F;
      f4 = (float)Math.sin(f5);
      f5 = (float)Math.cos(f5);
      this.cc[0] = (f1 * f4);
      this.cc[1] = (f2 * f4);
      this.cc[2] = (f3 * f4);
      this.cc[3] = f5;
      arrayOfFloat = new float[9];
      aduu.getRotationMatrixFromVector(arrayOfFloat, this.cc);
      this.cj = aduu.b(this.cj, arrayOfFloat);
      SensorManager.getOrientation(this.cj, this.cd);
      cUC();
      if ((this.cKk == 1) && (this.a != null)) {
        j((float)(Math.toDegrees(this.cd[0] + getDeclination()) + 360.0D) % 360.0F, (float)(this.cd[1] * 180.0F / 3.141592653589793D), (float)(this.cd[2] * 180.0F / 3.141592653589793D));
      }
    }
    this.timestamp = ((float)paramSensorEvent.timestamp);
  }
  
  private void cUB()
  {
    if (SensorManager.getRotationMatrix(this.rotationMatrix, null, this.cg, this.cf))
    {
      SensorManager.getOrientation(this.rotationMatrix, this.ci);
      this.bRb = true;
    }
  }
  
  private void cUC()
  {
    float[] arrayOfFloat;
    double d2;
    double d1;
    if ((this.cd[0] < -1.570796326794897D) && (this.ci[0] > 0.0D))
    {
      this.ce[0] = ((float)(0.9980000257492065D * (this.cd[0] + 6.283185307179586D) + this.ci[0] * 0.001999974F));
      arrayOfFloat = this.ce;
      d2 = arrayOfFloat[0];
      if (this.ce[0] > 3.141592653589793D)
      {
        d1 = 6.283185307179586D;
        arrayOfFloat[0] = ((float)(d2 - d1));
        label97:
        if ((this.cd[1] >= -1.570796326794897D) || (this.ci[1] <= 0.0D)) {
          break label493;
        }
        this.ce[1] = ((float)(0.9980000257492065D * (this.cd[1] + 6.283185307179586D) + this.ci[1] * 0.001999974F));
        arrayOfFloat = this.ce;
        d2 = arrayOfFloat[1];
        if (this.ce[1] <= 3.141592653589793D) {
          break label488;
        }
        d1 = 6.283185307179586D;
        label186:
        arrayOfFloat[1] = ((float)(d2 - d1));
        label194:
        if ((this.cd[2] >= -1.570796326794897D) || (this.ci[2] <= 0.0D)) {
          break label631;
        }
        arrayOfFloat = this.ce;
        d1 = this.cd[2];
        arrayOfFloat[2] = ((float)(0.001999974F * this.ci[2] + 0.9980000257492065D * (d1 + 6.283185307179586D)));
        arrayOfFloat = this.ce;
        d2 = arrayOfFloat[2];
        if (this.ce[2] <= 3.141592653589793D) {
          break label626;
        }
        d1 = 6.283185307179586D;
        label289:
        arrayOfFloat[2] = ((float)(d2 - d1));
      }
    }
    for (;;)
    {
      this.cj = aduu.d(this.ce);
      aduu.b(this.cj, this.ck);
      if (this.cKk != 1) {
        super.e(this.ck);
      }
      System.arraycopy(this.ce, 0, this.cd, 0, 3);
      return;
      d1 = 0.0D;
      break;
      if ((this.ci[0] < -1.570796326794897D) && (this.cd[0] > 0.0D))
      {
        this.ce[0] = ((float)(0.998F * this.cd[0] + 0.001999974F * (this.ci[0] + 6.283185307179586D)));
        arrayOfFloat = this.ce;
        d2 = arrayOfFloat[0];
        if (this.ce[0] > 3.141592653589793D) {}
        for (d1 = 6.283185307179586D;; d1 = 0.0D)
        {
          arrayOfFloat[0] = ((float)(d2 - d1));
          break;
        }
      }
      this.ce[0] = (0.998F * this.cd[0] + this.ci[0] * 0.001999974F);
      break label97;
      label488:
      d1 = 0.0D;
      break label186;
      label493:
      if ((this.ci[1] < -1.570796326794897D) && (this.cd[1] > 0.0D))
      {
        this.ce[1] = ((float)(0.998F * this.cd[1] + 0.001999974F * (this.ci[1] + 6.283185307179586D)));
        arrayOfFloat = this.ce;
        d2 = arrayOfFloat[1];
        if (this.ce[1] > 3.141592653589793D) {}
        for (d1 = 6.283185307179586D;; d1 = 0.0D)
        {
          arrayOfFloat[1] = ((float)(d2 - d1));
          break;
        }
      }
      this.ce[1] = (0.998F * this.cd[1] + this.ci[1] * 0.001999974F);
      break label194;
      label626:
      d1 = 0.0D;
      break label289;
      label631:
      if ((this.ci[2] < -1.570796326794897D) && (this.cd[2] > 0.0D))
      {
        arrayOfFloat = this.ce;
        d1 = 0.998F * this.cd[2];
        arrayOfFloat[2] = ((float)(0.001999974F * (this.ci[2] + 6.283185307179586D) + d1));
        arrayOfFloat = this.ce;
        d2 = arrayOfFloat[2];
        if (this.ce[2] > 3.141592653589793D) {}
        for (d1 = 6.283185307179586D;; d1 = 0.0D)
        {
          arrayOfFloat[2] = ((float)(d2 - d1));
          break;
        }
      }
      arrayOfFloat = this.ce;
      float f = this.cd[2];
      arrayOfFloat[2] = (0.001999974F * this.ci[2] + 0.998F * f);
    }
  }
  
  private void h(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.a == null) {
      return;
    }
    this.a.updateAccelerometer(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  private void i(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.a == null) {
      return;
    }
    this.a.updateGyroscope(paramFloat1, paramFloat2, paramFloat3, paramLong);
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
  
  void initData()
  {
    this.cd[0] = 0.0F;
    this.cd[1] = 0.0F;
    this.cd[2] = 0.0F;
    this.cj[0] = 1.0F;
    this.cj[1] = 0.0F;
    this.cj[2] = 0.0F;
    this.cj[3] = 0.0F;
    this.cj[4] = 1.0F;
    this.cj[5] = 0.0F;
    this.cj[6] = 0.0F;
    this.cj[7] = 0.0F;
    this.cj[8] = 1.0F;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 4)
    {
      c(paramSensorEvent);
      i(paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.timestamp);
    }
    do
    {
      return;
      if (paramSensorEvent.sensor.getType() == 2)
      {
        System.arraycopy(paramSensorEvent.values, 0, this.cf, 0, 3);
        this.bRc = true;
        return;
      }
    } while (paramSensorEvent.sensor.getType() != 1);
    System.arraycopy(paramSensorEvent.values, 0, this.cg, 0, 3);
    cUB();
    h(paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aduw
 * JD-Core Version:    0.7.0.1
 */