package com.tencent.mobileqq.app;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class ShakeListener
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long;
  private float jdField_c_of_type_Float;
  private long jdField_c_of_type_Long;
  private float jdField_d_of_type_Float;
  private long jdField_d_of_type_Long;
  private float e;
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {}
  
  public void b()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.e = 0.0F;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1;
    float f2;
    float f3;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      f1 = paramSensorEvent.values[0];
      f2 = paramSensorEvent.values[1];
      f3 = paramSensorEvent.values[2];
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      float f4 = (float)(this.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long > 100L)
      {
        this.jdField_c_of_type_Long = (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
        if ((this.jdField_a_of_type_Float != 0.0F) || (this.jdField_b_of_type_Float != 0.0F) || (this.jdField_c_of_type_Float != 0.0F)) {
          break label225;
        }
        this.jdField_d_of_type_Long = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      this.e += this.jdField_d_of_type_Float;
      if (this.jdField_a_of_type_Int > 10)
      {
        b();
        this.jdField_a_of_type_Int = 0;
      }
      a(f1, f2, f3, (int)this.e);
      if ((this.e > 100.0F) && (this.jdField_a_of_type_Int >= 3))
      {
        a();
        this.jdField_a_of_type_Int = 0;
        b();
      }
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f3;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      return;
      label225:
      this.jdField_d_of_type_Float = (Math.abs(f1 - this.jdField_a_of_type_Float) + Math.abs(f2 - this.jdField_b_of_type_Float) + Math.abs(f3 - this.jdField_c_of_type_Float));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShakeListener
 * JD-Core Version:    0.7.0.1
 */