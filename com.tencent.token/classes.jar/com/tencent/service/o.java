package com.tencent.service;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import java.util.ArrayList;

public class o
  implements SensorEventListener
{
  boolean a = false;
  protected SensorManager b;
  private long c = 0L;
  private double[] d = new double[3];
  private float[] e = new float[3];
  private float[] f = new float[3];
  private double g;
  private ArrayList h = new ArrayList();
  private Context i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private int m = 0;
  private int n = 0;
  
  o(Context paramContext)
  {
    this.i = paramContext;
  }
  
  private void a(SensorEvent paramSensorEvent)
  {
    boolean bool = false;
    if (this.c != 0L)
    {
      double d1 = (paramSensorEvent.timestamp - this.c) * 9.999999717180685E-010D;
      double[] arrayOfDouble = this.d;
      arrayOfDouble[0] += paramSensorEvent.values[0] * d1;
      arrayOfDouble = this.d;
      arrayOfDouble[1] += paramSensorEvent.values[1] * d1;
      arrayOfDouble = this.d;
      double d2 = arrayOfDouble[2];
      arrayOfDouble[2] = (d1 * paramSensorEvent.values[2] + d2);
      i1 = 0;
      if (i1 >= 3) {
        break label239;
      }
      if ((paramSensorEvent.values[i1] <= 1.0D) && (paramSensorEvent.values[i1] >= -1.0D)) {
        break label197;
      }
    }
    label197:
    label239:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.l = true;
        this.n = 0;
      }
      for (;;)
      {
        if ((this.k) || (this.l)) {
          bool = true;
        }
        this.a = bool;
        if (this.a) {}
        this.c = paramSensorEvent.timestamp;
        return;
        i1 += 1;
        break;
        i1 = this.n + 1;
        this.n = i1;
        if (i1 == 1)
        {
          this.n = 0;
          this.l = false;
        }
      }
    }
  }
  
  private void b(SensorEvent paramSensorEvent)
  {
    int i1 = 0;
    while (i1 < 3)
    {
      this.e[i1] = ((float)(0.1D * paramSensorEvent.values[i1] + 0.9D * this.e[i1]));
      this.f[i1] = (paramSensorEvent.values[i1] - this.e[i1]);
      i1 += 1;
    }
    this.g = (this.e[1] / 9.80665F);
    if (this.g > 1.0D) {
      this.g = 1.0D;
    }
    if (this.g < -1.0D) {
      this.g = -1.0D;
    }
    double d1 = Math.toDegrees(Math.acos(this.g));
    if (this.e[2] < 0.0F) {
      d1 = -d1;
    }
    int i3 = 0;
    i1 = 0;
    int i2 = i3;
    if (i1 < 3)
    {
      if ((this.f[i1] > 1.0D) || (this.f[i1] < -1.0D)) {
        i2 = 1;
      }
    }
    else
    {
      if (i2 == 0) {
        break label246;
      }
      this.m = 0;
      this.k = true;
      label206:
      if ((!this.k) && (!this.l)) {
        break label279;
      }
    }
    label279:
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      if (this.a) {}
      return;
      i1 += 1;
      break;
      label246:
      i1 = this.m + 1;
      this.m = i1;
      if (i1 != 1) {
        break label206;
      }
      this.m = 0;
      this.k = false;
      break label206;
    }
  }
  
  public void a()
  {
    if (this.j) {
      return;
    }
    this.b = ((SensorManager)this.i.getSystemService("sensor"));
    Sensor localSensor = this.b.getDefaultSensor(4);
    if (localSensor == null)
    {
      Log.d("error", "deveice not support TYPE_GYROSCOPE");
      this.l = false;
      localSensor = this.b.getDefaultSensor(1);
      if (localSensor != null) {
        break label105;
      }
      Log.d("error", "deveice not support TYPE_ACCELEROMETER");
      this.k = false;
    }
    for (;;)
    {
      this.j = true;
      return;
      this.b.registerListener(this, localSensor, 0);
      this.h.add(localSensor);
      break;
      label105:
      this.h.add(localSensor);
      this.b.registerListener(this, localSensor, 0);
    }
  }
  
  public void b()
  {
    int i1 = 0;
    while (i1 < this.h.size())
    {
      this.b.unregisterListener(this, (Sensor)this.h.get(i1));
      i1 += 1;
    }
    this.a = false;
    this.j = false;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 4: 
      a(paramSensorEvent);
      return;
    }
    b(paramSensorEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.o
 * JD-Core Version:    0.7.0.1
 */