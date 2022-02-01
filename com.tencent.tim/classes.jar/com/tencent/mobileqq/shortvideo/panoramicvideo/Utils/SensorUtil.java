package com.tencent.mobileqq.shortvideo.panoramicvideo.Utils;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;

public class SensorUtil
{
  private static float[] mTmp = new float[16];
  private static float[] oTmp = new float[16];
  
  public static void getOrientation(SensorEvent paramSensorEvent, float[] paramArrayOfFloat)
  {
    SensorManager.getRotationMatrixFromVector(oTmp, paramSensorEvent.values);
    SensorManager.getOrientation(oTmp, paramArrayOfFloat);
  }
  
  public static void getOrientationFromRotationMatrix(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    SensorManager.getOrientation(paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public static void sensorRotationVectorToMatrix(SensorEvent paramSensorEvent, int paramInt, float[] paramArrayOfFloat)
  {
    paramSensorEvent = paramSensorEvent.values;
    switch (paramInt)
    {
    default: 
      SensorManager.getRotationMatrixFromVector(mTmp, paramSensorEvent);
      SensorManager.remapCoordinateSystem(mTmp, 2, 129, paramArrayOfFloat);
    }
    for (;;)
    {
      Matrix.rotateM(paramArrayOfFloat, 0, 90.0F, 1.0F, 0.0F, 0.0F);
      return;
      SensorManager.getRotationMatrixFromVector(paramArrayOfFloat, paramSensorEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.Utils.SensorUtil
 * JD-Core Version:    0.7.0.1
 */