package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorController
  extends BroadcastReceiver
  implements SensorEventListener
{
  private static float aX = 4.294967E+009F;
  private static float ba = 0.5F;
  private SensorManager aY;
  private float aZ;
  private SensorEventCallBack bb;
  private Sensor bc;
  private final boolean bd;
  private boolean be = false;
  private boolean bf = false;
  
  public SensorController(Context paramContext)
  {
    this.aY = ((SensorManager)paramContext.getSystemService("sensor"));
    this.bc = this.aY.getDefaultSensor(8);
    if (this.bc != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.bd = bool;
      this.aZ = (ba + 1.0F);
      return;
    }
  }
  
  public boolean isSensorEnable()
  {
    return this.bd;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"))
    {
      int i = paramIntent.getIntExtra("state", 0);
      if (i == 1) {
        this.be = true;
      }
      if (i == 0) {
        this.be = false;
      }
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.be) {
      return;
    }
    float f = paramSensorEvent.values[0];
    switch (paramSensorEvent.sensor.getType())
    {
    default: 
      return;
    }
    if (f < aX)
    {
      aX = f;
      ba = 0.5F + f;
    }
    if ((this.aZ >= ba) && (f < ba)) {
      if (this.bb != null)
      {
        Log.v("MicroMsg.SensorController", "sensor event false");
        this.bb.onSensorEvent(false);
      }
    }
    for (;;)
    {
      this.aZ = f;
      return;
      if ((this.aZ <= ba) && (f > ba) && (this.bb != null))
      {
        Log.v("MicroMsg.SensorController", "sensor event true");
        this.bb.onSensorEvent(true);
      }
    }
  }
  
  public void removeSensorCallBack()
  {
    Log.v("MicroMsg.SensorController", "sensor callback removed");
    this.aY.unregisterListener(this, this.bc);
    this.aY.unregisterListener(this);
    this.bf = false;
    this.bb = null;
  }
  
  public void setSensorCallBack(SensorEventCallBack paramSensorEventCallBack)
  {
    Log.v("MicroMsg.SensorController", "sensor callback set");
    if (!this.bf)
    {
      this.aY.registerListener(this, this.bc, 2);
      this.bf = true;
    }
    this.bb = paramSensorEventCallBack;
  }
  
  public static abstract interface SensorEventCallBack
  {
    public abstract void onSensorEvent(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */