package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.filament.proguard.UsedByReflection;

public class Skybox
{
  private long mNativeObject;
  
  @UsedByReflection("KtxLoader.java")
  Skybox(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native void nBuilderEnvironment(long paramLong1, long paramLong2);
  
  private static native void nBuilderIntensity(long paramLong, float paramFloat);
  
  private static native void nBuilderShowSun(long paramLong, boolean paramBoolean);
  
  private static native long nCreateBuilder();
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native float nGetIntensity(long paramLong);
  
  private static native int nGetLayerMask(long paramLong);
  
  private static native void nSetLayerMask(long paramLong, int paramInt1, int paramInt2);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public float getIntensity()
  {
    return nGetIntensity(getNativeObject());
  }
  
  public int getLayerMask()
  {
    return nGetLayerMask(getNativeObject());
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Skybox");
    }
    return this.mNativeObject;
  }
  
  public void setLayerMask(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    nSetLayerMask(getNativeObject(), paramInt1 & 0xFF, paramInt2 & 0xFF);
  }
  
  public static class Builder
  {
    private final BuilderFinalizer mFinalizer = new BuilderFinalizer(this.mNativeBuilder);
    private final long mNativeBuilder = Skybox.access$000();
    
    @NonNull
    public Skybox build(@NonNull Engine paramEngine)
    {
      long l = Skybox.nBuilderBuild(this.mNativeBuilder, paramEngine.getNativeObject());
      if (l == 0L) {
        throw new IllegalStateException("Couldn't create Skybox");
      }
      return new Skybox(l);
    }
    
    @NonNull
    public Builder environment(@NonNull Texture paramTexture)
    {
      Skybox.nBuilderEnvironment(this.mNativeBuilder, paramTexture.getNativeObject());
      return this;
    }
    
    @NonNull
    public Builder intensity(float paramFloat)
    {
      Skybox.nBuilderIntensity(this.mNativeBuilder, paramFloat);
      return this;
    }
    
    @NonNull
    public Builder showSun(boolean paramBoolean)
    {
      Skybox.nBuilderShowSun(this.mNativeBuilder, paramBoolean);
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
        //   5: getfield 19	com/google/android/filament/Skybox$Builder$BuilderFinalizer:mNativeObject	J
        //   8: invokestatic 28	com/google/android/filament/Skybox:access$500	(J)V
        //   11: return
        //   12: astore_1
        //   13: aload_0
        //   14: getfield 19	com/google/android/filament/Skybox$Builder$BuilderFinalizer:mNativeObject	J
        //   17: invokestatic 28	com/google/android/filament/Skybox:access$500	(J)V
        //   20: return
        //   21: astore_1
        //   22: aload_0
        //   23: getfield 19	com/google/android/filament/Skybox$Builder$BuilderFinalizer:mNativeObject	J
        //   26: invokestatic 28	com/google/android/filament/Skybox:access$500	(J)V
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
 * Qualified Name:     com.google.android.filament.Skybox
 * JD-Core Version:    0.7.0.1
 */