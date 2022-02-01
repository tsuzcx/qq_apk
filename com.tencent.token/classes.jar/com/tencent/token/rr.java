package com.tencent.token;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;

public final class rr
  implements SensorEventListener
{
  boolean a = false;
  protected SensorManager b;
  private long c = 0L;
  private double[] d = new double[3];
  private float[] e = new float[3];
  private float[] f = new float[3];
  private double g;
  private ArrayList<Sensor> h = new ArrayList();
  private Context i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private int m = 0;
  private int n = 0;
  
  rr(Context paramContext)
  {
    this.i = paramContext;
  }
  
  public final void a()
  {
    if (this.j) {
      return;
    }
    this.b = ((SensorManager)this.i.getSystemService("sensor"));
    Sensor localSensor = this.b.getDefaultSensor(4);
    if (localSensor == null)
    {
      this.l = false;
    }
    else
    {
      this.b.registerListener(this, localSensor, 0);
      this.h.add(localSensor);
    }
    localSensor = this.b.getDefaultSensor(1);
    if (localSensor == null)
    {
      this.k = false;
    }
    else
    {
      this.h.add(localSensor);
      this.b.registerListener(this, localSensor, 0);
    }
    this.j = true;
  }
  
  public final void b()
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
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i1 = paramSensorEvent.sensor.getType();
    double d1;
    Object localObject;
    double d2;
    if (i1 != 1)
    {
      if (i1 != 4) {
        return;
      }
      if (this.c != 0L)
      {
        d1 = paramSensorEvent.timestamp - this.c;
        Double.isNaN(d1);
        d1 *= 9.999999717180685E-010D;
        localObject = this.d;
        d2 = localObject[0];
        double d3 = paramSensorEvent.values[0];
        Double.isNaN(d3);
        localObject[0] = (d2 + d3 * d1);
        localObject = this.d;
        d2 = localObject[1];
        d3 = paramSensorEvent.values[1];
        Double.isNaN(d3);
        localObject[1] = (d2 + d3 * d1);
        localObject = this.d;
        d2 = localObject[2];
        d3 = paramSensorEvent.values[2];
        Double.isNaN(d3);
        localObject[2] = (d2 + d3 * d1);
        i1 = 0;
        while (i1 < 3) {
          if ((paramSensorEvent.values[i1] <= 1.0D) && (paramSensorEvent.values[i1] >= -1.0D))
          {
            i1 += 1;
          }
          else
          {
            i1 = 1;
            break label225;
          }
        }
        i1 = 0;
        label225:
        if (i1 != 0)
        {
          this.l = true;
          this.n = 0;
        }
        else
        {
          i1 = this.n + 1;
          this.n = i1;
          if (i1 == 1)
          {
            this.n = 0;
            this.l = false;
          }
        }
        if ((!this.k) && (!this.l)) {
          bool = false;
        } else {
          bool = true;
        }
        this.a = bool;
      }
      this.c = paramSensorEvent.timestamp;
      return;
    }
    i1 = 0;
    while (i1 < 3)
    {
      localObject = this.e;
      d1 = paramSensorEvent.values[i1];
      Double.isNaN(d1);
      d2 = this.e[i1];
      Double.isNaN(d2);
      localObject[i1] = ((float)(d1 * 0.1D + d2 * 0.9D));
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
    Math.toDegrees(Math.acos(this.g));
    i1 = 0;
    while (i1 < 3)
    {
      paramSensorEvent = this.f;
      if ((paramSensorEvent[i1] <= 1.0D) && (paramSensorEvent[i1] >= -1.0D))
      {
        i1 += 1;
      }
      else
      {
        i1 = 1;
        break label522;
      }
    }
    i1 = 0;
    label522:
    if (i1 != 0)
    {
      this.m = 0;
      this.k = true;
    }
    else
    {
      i1 = this.m + 1;
      this.m = i1;
      if (i1 == 1)
      {
        this.m = 0;
        this.k = false;
      }
    }
    boolean bool = false;
    if ((this.k) || (this.l)) {
      bool = true;
    }
    this.a = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rr
 * JD-Core Version:    0.7.0.1
 */