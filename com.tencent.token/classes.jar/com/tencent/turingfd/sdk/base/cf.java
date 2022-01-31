package com.tencent.turingfd.sdk.base;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class cf
  implements SensorEventListener
{
  public final AtomicBoolean a = new AtomicBoolean(false);
  public long b = 0L;
  public int c = 0;
  public long d = 0L;
  
  public cf(ce paramce) {}
  
  public void a()
  {
    synchronized (this.a)
    {
      if (!this.a.get()) {
        return;
      }
      this.a.set(false);
      this.d = (System.currentTimeMillis() - this.b);
      if (this.d < 0L) {
        this.d = 0L;
      }
      this.b = 0L;
      return;
    }
  }
  
  public void a(long paramLong)
  {
    synchronized (this.a)
    {
      if (this.a.get()) {
        return;
      }
      this.a.set(true);
      this.b = System.currentTimeMillis();
      this.c = ((int)Math.ceil(paramLong * 1.0D / dy.b));
      return;
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    label236:
    for (;;)
    {
      synchronized (this.a)
      {
        if (!this.a.get()) {
          return;
        }
        if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null)) {
          break;
        }
        cw localcw = new cw(paramSensorEvent, System.currentTimeMillis());
        long l = localcw.b - this.b;
        if (l < 0L) {
          break;
        }
        int j = localcw.a;
        int i = (int)(l / dy.b);
        synchronized (ce.a(this.e))
        {
          paramSensorEvent = (cv)ce.a(this.e).get(j);
          if (paramSensorEvent != null) {
            break label236;
          }
          paramSensorEvent = new cv(j, dy.c, this.c);
          ce.a(this.e).put(j, paramSensorEvent);
          if (i >= paramSensorEvent.d) {
            return;
          }
        }
        if (i > paramSensorEvent.c)
        {
          j = i / paramSensorEvent.e;
          List localList = (List)paramSensorEvent.b[j];
          ??? = localList;
          if (localList == null)
          {
            ??? = new ArrayList();
            paramSensorEvent.b[j] = ???;
          }
          ((List)???).add(localcw);
          paramSensorEvent.c = i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cf
 * JD-Core Version:    0.7.0.1
 */