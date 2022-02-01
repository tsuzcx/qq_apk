package com.tencent.token;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;

public final class awc
{
  private static final PathMeasure a = new PathMeasure();
  private static final Path b = new Path();
  private static final Path c = new Path();
  private static final float[] d = new float[4];
  private static final float e = (float)Math.sqrt(2.0D);
  
  public static float a(Matrix paramMatrix)
  {
    float[] arrayOfFloat = d;
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    float f1 = e;
    arrayOfFloat[2] = f1;
    arrayOfFloat[3] = f1;
    paramMatrix.mapPoints(arrayOfFloat);
    paramMatrix = d;
    f1 = paramMatrix[2];
    float f2 = paramMatrix[0];
    float f3 = paramMatrix[3];
    float f4 = paramMatrix[1];
    return (float)Math.hypot(f1 - f2, f3 - f4) / 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.awc
 * JD-Core Version:    0.7.0.1
 */