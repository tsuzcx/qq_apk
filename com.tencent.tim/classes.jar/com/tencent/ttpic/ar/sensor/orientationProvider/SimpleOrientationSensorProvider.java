package com.tencent.ttpic.ar.sensor.orientationProvider;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SimpleOrientationSensorProvider
  extends OrientationProvider
{
  private int ANGLE_QUEUE_MAX_SIZE = 5;
  private Queue<Float> azimuthQueue = new LinkedList();
  private float[] geomagnetic = new float[3];
  private float[] gravity = new float[3];
  private float lastAzimuth;
  private float lastPitch;
  private float lastRoll;
  private Queue<Float> pitchQueue = new LinkedList();
  private Queue<Float> rollQueue = new LinkedList();
  private float[] rotationMat = new float[9];
  private float[] values = new float[3];
  
  public SimpleOrientationSensorProvider(SensorManager paramSensorManager)
  {
    super(paramSensorManager);
    this.sensorList.add(paramSensorManager.getDefaultSensor(2));
    this.sensorList.add(paramSensorManager.getDefaultSensor(1));
  }
  
  public void getEulerAngles(float[] paramArrayOfFloat)
  {
    for (;;)
    {
      float f1;
      synchronized (this.synchronizationToken)
      {
        SensorManager.getRotationMatrix(this.rotationMat, null, this.gravity, this.geomagnetic);
        SensorManager.getOrientation(this.rotationMat, this.values);
        f2 = (float)Math.toDegrees(this.values[0]);
        f1 = f2;
        if (f2 >= 0.0F) {
          break label534;
        }
        f1 = f2 + 360.0F;
        break label534;
        f1 = (float)Math.toDegrees(this.values[1]);
        float f3 = -(float)Math.toDegrees(this.values[2]);
        if (Math.abs(f2 - this.lastAzimuth) > 20.0F) {
          this.azimuthQueue.clear();
        }
        this.lastAzimuth = f2;
        if (Math.abs(f1 - this.lastPitch) > 20.0F) {
          this.pitchQueue.clear();
        }
        this.lastPitch = f1;
        if (Math.abs(f3 - this.lastRoll) > 20.0F) {
          this.rollQueue.clear();
        }
        this.lastRoll = f3;
        this.azimuthQueue.offer(Float.valueOf(f2));
        this.pitchQueue.offer(Float.valueOf(f1));
        this.rollQueue.offer(Float.valueOf(f3));
        if (this.azimuthQueue.size() > this.ANGLE_QUEUE_MAX_SIZE) {
          this.azimuthQueue.poll();
        }
      }
      while (this.pitchQueue.size() > this.ANGLE_QUEUE_MAX_SIZE) {
        this.pitchQueue.poll();
      }
      while (this.rollQueue.size() > this.ANGLE_QUEUE_MAX_SIZE) {
        this.rollQueue.poll();
      }
      paramArrayOfFloat[2] = 0.0F;
      paramArrayOfFloat[1] = 0.0F;
      paramArrayOfFloat[0] = 0.0F;
      Iterator localIterator = this.azimuthQueue.iterator();
      Float localFloat;
      while (localIterator.hasNext())
      {
        localFloat = (Float)localIterator.next();
        f1 = paramArrayOfFloat[0];
        paramArrayOfFloat[0] = (localFloat.floatValue() + f1);
      }
      localIterator = this.pitchQueue.iterator();
      while (localIterator.hasNext())
      {
        localFloat = (Float)localIterator.next();
        f1 = paramArrayOfFloat[1];
        paramArrayOfFloat[1] = (localFloat.floatValue() + f1);
      }
      localIterator = this.rollQueue.iterator();
      while (localIterator.hasNext())
      {
        localFloat = (Float)localIterator.next();
        f1 = paramArrayOfFloat[2];
        paramArrayOfFloat[2] = (localFloat.floatValue() + f1);
      }
      paramArrayOfFloat[0] /= this.azimuthQueue.size();
      paramArrayOfFloat[1] /= this.pitchQueue.size();
      paramArrayOfFloat[2] /= this.rollQueue.size();
      return;
      label534:
      float f2 = f1;
      if (180.0F <= f1)
      {
        f2 = f1;
        if (f1 <= 360.0F) {
          f2 = f1 - 360.0F;
        }
      }
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 2) {
      this.geomagnetic = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 1) {
      this.gravity = paramSensorEvent.values;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.orientationProvider.SimpleOrientationSensorProvider
 * JD-Core Version:    0.7.0.1
 */