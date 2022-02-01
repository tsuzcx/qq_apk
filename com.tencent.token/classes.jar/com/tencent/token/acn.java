package com.tencent.token;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import java.util.Arrays;

public final class acn
{
  public final int a;
  public final long b;
  public final float[] c;
  
  public acn(SensorEvent paramSensorEvent, long paramLong)
  {
    this.a = paramSensorEvent.sensor.getType();
    this.b = paramLong;
    paramSensorEvent = paramSensorEvent.values;
    this.c = Arrays.copyOf(paramSensorEvent, paramSensorEvent.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acn
 * JD-Core Version:    0.7.0.1
 */