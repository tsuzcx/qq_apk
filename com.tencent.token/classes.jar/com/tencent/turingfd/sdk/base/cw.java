package com.tencent.turingfd.sdk.base;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import java.util.Arrays;

public class cw
{
  public final int a;
  public final long b;
  public final float[] c;
  
  public cw(SensorEvent paramSensorEvent, long paramLong)
  {
    this.a = paramSensorEvent.sensor.getType();
    this.b = paramLong;
    paramSensorEvent = paramSensorEvent.values;
    this.c = Arrays.copyOf(paramSensorEvent, paramSensorEvent.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cw
 * JD-Core Version:    0.7.0.1
 */