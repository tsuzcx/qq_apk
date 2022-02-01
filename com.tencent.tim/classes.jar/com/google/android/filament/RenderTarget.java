package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RenderTarget
{
  private long mNativeObject;
  private final Texture[] mTextures = new Texture[2];
  
  private RenderTarget(long paramLong, Builder paramBuilder)
  {
    this.mNativeObject = paramLong;
    this.mTextures[0] = paramBuilder.mTextures[0];
    this.mTextures[1] = paramBuilder.mTextures[1];
  }
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native long nBuilderFace(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nBuilderLayer(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nBuilderMipLevel(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nBuilderTexture(long paramLong1, int paramInt, long paramLong2);
  
  private static native long nCreateBuilder();
  
  private static native long nDestroyBuilder(long paramLong);
  
  private static native int nGetFace(long paramLong, int paramInt);
  
  private static native int nGetLayer(long paramLong, int paramInt);
  
  private static native int nGetMipLevel(long paramLong, int paramInt);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public Texture.CubemapFace getFace(AttachmentPoint paramAttachmentPoint)
  {
    return Texture.CubemapFace.values()[nGetFace(getNativeObject(), paramAttachmentPoint.ordinal())];
  }
  
  @IntRange(from=0L)
  public int getLayer(@NonNull AttachmentPoint paramAttachmentPoint)
  {
    return nGetLayer(getNativeObject(), paramAttachmentPoint.ordinal());
  }
  
  @IntRange(from=0L)
  public int getMipLevel(@NonNull AttachmentPoint paramAttachmentPoint)
  {
    return nGetMipLevel(getNativeObject(), paramAttachmentPoint.ordinal());
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed RenderTarget");
    }
    return this.mNativeObject;
  }
  
  @Nullable
  public Texture getTexture(@NonNull AttachmentPoint paramAttachmentPoint)
  {
    return this.mTextures[paramAttachmentPoint.ordinal()];
  }
  
  public static enum AttachmentPoint
  {
    COLOR,  DEPTH;
    
    private AttachmentPoint() {}
  }
  
  public static class Builder
  {
    private final BuilderFinalizer mFinalizer = new BuilderFinalizer(this.mNativeBuilder);
    private final long mNativeBuilder = RenderTarget.access$100();
    private final Texture[] mTextures = new Texture[2];
    
    @NonNull
    public RenderTarget build(@NonNull Engine paramEngine)
    {
      long l = RenderTarget.nBuilderBuild(this.mNativeBuilder, paramEngine.getNativeObject());
      if (l == 0L) {
        throw new IllegalStateException("Couldn't create RenderTarget");
      }
      return new RenderTarget(l, this, null);
    }
    
    @NonNull
    public Builder face(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint, Texture.CubemapFace paramCubemapFace)
    {
      RenderTarget.nBuilderFace(this.mNativeBuilder, paramAttachmentPoint.ordinal(), paramCubemapFace.ordinal());
      return this;
    }
    
    @NonNull
    public Builder layer(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint, @IntRange(from=0L) int paramInt)
    {
      RenderTarget.nBuilderLayer(this.mNativeBuilder, paramAttachmentPoint.ordinal(), paramInt);
      return this;
    }
    
    @NonNull
    public Builder mipLevel(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint, @IntRange(from=0L) int paramInt)
    {
      RenderTarget.nBuilderMipLevel(this.mNativeBuilder, paramAttachmentPoint.ordinal(), paramInt);
      return this;
    }
    
    @NonNull
    public Builder texture(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint, @Nullable Texture paramTexture)
    {
      this.mTextures[paramAttachmentPoint.ordinal()] = paramTexture;
      long l2 = this.mNativeBuilder;
      int i = paramAttachmentPoint.ordinal();
      if (paramTexture != null) {}
      for (long l1 = paramTexture.getNativeObject();; l1 = 0L)
      {
        RenderTarget.nBuilderTexture(l2, i, l1);
        return this;
      }
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
        //   5: getfield 19	com/google/android/filament/RenderTarget$Builder$BuilderFinalizer:mNativeObject	J
        //   8: invokestatic 29	com/google/android/filament/RenderTarget:access$800	(J)J
        //   11: pop2
        //   12: return
        //   13: astore_1
        //   14: aload_0
        //   15: getfield 19	com/google/android/filament/RenderTarget$Builder$BuilderFinalizer:mNativeObject	J
        //   18: invokestatic 29	com/google/android/filament/RenderTarget:access$800	(J)J
        //   21: pop2
        //   22: return
        //   23: astore_1
        //   24: aload_0
        //   25: getfield 19	com/google/android/filament/RenderTarget$Builder$BuilderFinalizer:mNativeObject	J
        //   28: invokestatic 29	com/google/android/filament/RenderTarget:access$800	(J)J
        //   31: pop2
        //   32: aload_1
        //   33: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	34	0	this	BuilderFinalizer
        //   13	1	1	localThrowable	java.lang.Throwable
        //   23	10	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   0	4	13	java/lang/Throwable
        //   0	4	23	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.RenderTarget
 * JD-Core Version:    0.7.0.1
 */