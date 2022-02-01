package com.google.android.filament;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

final class Asserts
{
  @NonNull
  @Size(min=3L)
  static float[] assertFloat3(@Nullable float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if (paramArrayOfFloat == null) {
      arrayOfFloat = new float[3];
    }
    do
    {
      return arrayOfFloat;
      arrayOfFloat = paramArrayOfFloat;
    } while (paramArrayOfFloat.length >= 3);
    throw new ArrayIndexOutOfBoundsException("Array length must be at least 3");
  }
  
  @NonNull
  @Size(min=4L)
  static float[] assertFloat4(@Nullable float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if (paramArrayOfFloat == null) {
      arrayOfFloat = new float[4];
    }
    do
    {
      return arrayOfFloat;
      arrayOfFloat = paramArrayOfFloat;
    } while (paramArrayOfFloat.length >= 4);
    throw new ArrayIndexOutOfBoundsException("Array length must be at least 4");
  }
  
  @NonNull
  @Size(min=9L)
  static float[] assertMat3f(@Nullable float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if (paramArrayOfFloat == null) {
      arrayOfFloat = new float[9];
    }
    do
    {
      return arrayOfFloat;
      arrayOfFloat = paramArrayOfFloat;
    } while (paramArrayOfFloat.length >= 9);
    throw new ArrayIndexOutOfBoundsException("Array length must be at least 9");
  }
  
  static void assertMat3fIn(@NonNull @Size(min=9L) float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length < 9) {
      throw new ArrayIndexOutOfBoundsException("Array length must be at least 9");
    }
  }
  
  @NonNull
  @Size(min=16L)
  static double[] assertMat4d(@Nullable double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble;
    if (paramArrayOfDouble == null) {
      arrayOfDouble = new double[16];
    }
    do
    {
      return arrayOfDouble;
      arrayOfDouble = paramArrayOfDouble;
    } while (paramArrayOfDouble.length >= 16);
    throw new ArrayIndexOutOfBoundsException("Array length must be at least 16");
  }
  
  static void assertMat4dIn(@NonNull @Size(min=16L) double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length < 16) {
      throw new ArrayIndexOutOfBoundsException("Array length must be at least 16");
    }
  }
  
  @NonNull
  @Size(min=16L)
  static float[] assertMat4f(@Nullable float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if (paramArrayOfFloat == null) {
      arrayOfFloat = new float[16];
    }
    do
    {
      return arrayOfFloat;
      arrayOfFloat = paramArrayOfFloat;
    } while (paramArrayOfFloat.length >= 16);
    throw new ArrayIndexOutOfBoundsException("Array length must be at least 16");
  }
  
  static void assertMat4fIn(@NonNull @Size(min=16L) float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length < 16) {
      throw new ArrayIndexOutOfBoundsException("Array length must be at least 16");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.Asserts
 * JD-Core Version:    0.7.0.1
 */