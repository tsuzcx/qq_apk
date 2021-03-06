package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.android.filament.proguard.UsedByReflection;

public class IndirectLight
{
  long mNativeObject;
  
  @UsedByReflection("KtxLoader.java")
  IndirectLight(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  @NonNull
  @Size(min=4L)
  public static float[] getColorEstimate(@Nullable @Size(min=4L) float[] paramArrayOfFloat1, @NonNull float[] paramArrayOfFloat2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramArrayOfFloat2.length < 27) {
      throw new ArrayIndexOutOfBoundsException("3 bands SH required, array must be at least 9 x float3");
    }
    paramArrayOfFloat1 = Asserts.assertFloat4(paramArrayOfFloat1);
    nGetColorEstimateStatic(paramArrayOfFloat1, paramArrayOfFloat2, paramFloat1, paramFloat2, paramFloat3);
    return paramArrayOfFloat1;
  }
  
  @NonNull
  @Size(min=3L)
  public static float[] getDirectionEstimate(@NonNull float[] paramArrayOfFloat1, @Nullable @Size(min=3L) float[] paramArrayOfFloat2)
  {
    if (paramArrayOfFloat1.length < 27) {
      throw new ArrayIndexOutOfBoundsException("3 bands SH required, array must be at least 9 x float3");
    }
    paramArrayOfFloat2 = Asserts.assertFloat3(paramArrayOfFloat2);
    nGetDirectionEstimateStatic(paramArrayOfFloat1, paramArrayOfFloat2);
    return paramArrayOfFloat2;
  }
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native void nBuilderReflections(long paramLong1, long paramLong2);
  
  private static native long nCreateBuilder();
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native void nGetColorEstimate(long paramLong, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nGetColorEstimateStatic(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nGetDirectionEstimate(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nGetDirectionEstimateStatic(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private static native float nGetIntensity(long paramLong);
  
  private static native void nGetRotation(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nIntensity(long paramLong, float paramFloat);
  
  private static native void nIrradiance(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native void nIrradianceAsTexture(long paramLong1, long paramLong2);
  
  private static native void nRadiance(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native void nRotation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);
  
  private static native void nSetIntensity(long paramLong, float paramFloat);
  
  private static native void nSetRotation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  @NonNull
  @Size(min=4L)
  public float[] getColorEstimate(@Nullable @Size(min=4L) float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramArrayOfFloat = Asserts.assertFloat4(paramArrayOfFloat);
    nGetColorEstimate(getNativeObject(), paramArrayOfFloat, paramFloat1, paramFloat2, paramFloat3);
    return paramArrayOfFloat;
  }
  
  @NonNull
  @Size(min=3L)
  public float[] getDirectionEstimate(@Nullable @Size(min=3L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat3(paramArrayOfFloat);
    nGetDirectionEstimate(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  public float getIntensity()
  {
    return nGetIntensity(getNativeObject());
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed IndirectLight");
    }
    return this.mNativeObject;
  }
  
  @NonNull
  @Size(min=9L)
  public float[] getRotation(@Nullable @Size(min=9L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertMat3f(paramArrayOfFloat);
    nGetRotation(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  public void setIntensity(float paramFloat)
  {
    nSetIntensity(getNativeObject(), paramFloat);
  }
  
  public void setRotation(@NonNull @Size(min=9L) float[] paramArrayOfFloat)
  {
    Asserts.assertMat3fIn(paramArrayOfFloat);
    nSetRotation(getNativeObject(), paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3], paramArrayOfFloat[4], paramArrayOfFloat[5], paramArrayOfFloat[6], paramArrayOfFloat[7], paramArrayOfFloat[8]);
  }
  
  public static class Builder
  {
    private final BuilderFinalizer mFinalizer = new BuilderFinalizer(this.mNativeBuilder);
    private final long mNativeBuilder = IndirectLight.access$000();
    
    @NonNull
    public IndirectLight build(@NonNull Engine paramEngine)
    {
      long l = IndirectLight.nBuilderBuild(this.mNativeBuilder, paramEngine.getNativeObject());
      if (l == 0L) {
        throw new IllegalStateException("Couldn't create IndirectLight");
      }
      return new IndirectLight(l);
    }
    
    @NonNull
    public Builder intensity(float paramFloat)
    {
      IndirectLight.nIntensity(this.mNativeBuilder, paramFloat);
      return this;
    }
    
    @NonNull
    public Builder irradiance(@IntRange(from=1L, to=3L) int paramInt, @NonNull float[] paramArrayOfFloat)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("bands must be 1, 2 or 3");
      case 1: 
        if (paramArrayOfFloat.length < 3) {
          throw new ArrayIndexOutOfBoundsException("1 band SH, array must be at least 1 x float3");
        }
        break;
      case 2: 
        if (paramArrayOfFloat.length < 12) {
          throw new ArrayIndexOutOfBoundsException("2 bands SH, array must be at least 4 x float3");
        }
        break;
      case 3: 
        if (paramArrayOfFloat.length < 27) {
          throw new ArrayIndexOutOfBoundsException("3 bands SH, array must be at least 9 x float3");
        }
        break;
      }
      IndirectLight.nIrradiance(this.mNativeBuilder, paramInt, paramArrayOfFloat);
      return this;
    }
    
    @NonNull
    public Builder irradiance(@NonNull Texture paramTexture)
    {
      IndirectLight.nIrradianceAsTexture(this.mNativeBuilder, paramTexture.getNativeObject());
      return this;
    }
    
    @NonNull
    public Builder radiance(@IntRange(from=1L, to=3L) int paramInt, @NonNull float[] paramArrayOfFloat)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("bands must be 1, 2 or 3");
      case 1: 
        if (paramArrayOfFloat.length < 3) {
          throw new ArrayIndexOutOfBoundsException("1 band SH, array must be at least 1 x float3");
        }
        break;
      case 2: 
        if (paramArrayOfFloat.length < 12) {
          throw new ArrayIndexOutOfBoundsException("2 bands SH, array must be at least 4 x float3");
        }
        break;
      case 3: 
        if (paramArrayOfFloat.length < 27) {
          throw new ArrayIndexOutOfBoundsException("3 bands SH, array must be at least 9 x float3");
        }
        break;
      }
      IndirectLight.nRadiance(this.mNativeBuilder, paramInt, paramArrayOfFloat);
      return this;
    }
    
    @NonNull
    public Builder reflections(@NonNull Texture paramTexture)
    {
      IndirectLight.nBuilderReflections(this.mNativeBuilder, paramTexture.getNativeObject());
      return this;
    }
    
    @NonNull
    public Builder rotation(@NonNull @Size(min=9L) float[] paramArrayOfFloat)
    {
      IndirectLight.nRotation(this.mNativeBuilder, paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3], paramArrayOfFloat[4], paramArrayOfFloat[5], paramArrayOfFloat[6], paramArrayOfFloat[7], paramArrayOfFloat[8]);
      return this;
    }
    
    static class BuilderFinalizer
    {
      private final long mNativeObject;
      
      BuilderFinalizer(long paramLong)
      {
        this.mNativeObject = paramLong;
      }
      
      /* Error */
      public void finalize()
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 25	java/lang/Object:finalize	()V
        //   4: aload_0
        //   5: getfield 19	com/google/android/filament/IndirectLight$Builder$BuilderFinalizer:mNativeObject	J
        //   8: invokestatic 28	com/google/android/filament/IndirectLight:access$800	(J)V
        //   11: return
        //   12: astore_1
        //   13: aload_0
        //   14: getfield 19	com/google/android/filament/IndirectLight$Builder$BuilderFinalizer:mNativeObject	J
        //   17: invokestatic 28	com/google/android/filament/IndirectLight:access$800	(J)V
        //   20: return
        //   21: astore_1
        //   22: aload_0
        //   23: getfield 19	com/google/android/filament/IndirectLight$Builder$BuilderFinalizer:mNativeObject	J
        //   26: invokestatic 28	com/google/android/filament/IndirectLight:access$800	(J)V
        //   29: aload_1
        //   30: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	31	0	this	BuilderFinalizer
        //   12	1	1	localThrowable	java.lang.Throwable
        //   21	9	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   0	4	12	java/lang/Throwable
        //   0	4	21	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.IndirectLight
 * JD-Core Version:    0.7.0.1
 */