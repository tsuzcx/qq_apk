package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.token.pp;

public class SensorController
  extends BroadcastReceiver
  implements SensorEventListener
{
  private static float a = 4.294967E+009F;
  private static float c = 0.5F;
  private float b;
  private a d;
  private boolean e;
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"))
    {
      int i = paramIntent.getIntExtra("state", 0);
      if (i == 1) {
        this.e = true;
      }
      if (i == 0) {
        this.e = false;
      }
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.e) {
      return;
    }
    float f1 = paramSensorEvent.values[0];
    if (paramSensorEvent.sensor.getType() != 8) {
      return;
    }
    if (f1 < a)
    {
      a = f1;
      c = 0.5F + f1;
    }
    float f2 = this.b;
    float f3 = c;
    if ((f2 >= f3) && (f1 < f3))
    {
      if (this.d == null) {}
    }
    else {
      for (paramSensorEvent = "sensor event false";; paramSensorEvent = "sensor event true")
      {
        pp.d("MicroMsg.SensorController", paramSensorEvent);
        break;
        f2 = this.b;
        f3 = c;
        if ((f2 > f3) || (f1 <= f3) || (this.d == null)) {
          break;
        }
      }
    }
    this.b = f1;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */