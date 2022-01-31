package com.tencent.token.ui;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

final class cl
  implements SensorEventListener
{
  cl(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    CorrectTokenActivity.access$102(this.a, paramSensorEvent.values[0]);
    CorrectTokenActivity.access$202(this.a, paramSensorEvent.values[1]);
    CorrectTokenActivity.access$302(this.a, paramSensorEvent.values[2]);
    if (System.currentTimeMillis() - CorrectTokenActivity.access$400(this.a) > 100L)
    {
      this.a.didAccelerate(new j(CorrectTokenActivity.access$100(this.a), CorrectTokenActivity.access$200(this.a), CorrectTokenActivity.access$300(this.a)));
      CorrectTokenActivity.access$402(this.a, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cl
 * JD-Core Version:    0.7.0.1
 */