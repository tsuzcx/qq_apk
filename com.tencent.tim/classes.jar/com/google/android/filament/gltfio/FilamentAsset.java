package com.google.android.filament.gltfio;

import androidx.annotation.NonNull;
import com.google.android.filament.Box;
import com.google.android.filament.Entity;

public class FilamentAsset
{
  private Animator mAnimator;
  private long mNativeObject;
  
  FilamentAsset(long paramLong)
  {
    this.mNativeObject = paramLong;
    this.mAnimator = null;
  }
  
  private static native long nGetAnimator(long paramLong);
  
  private static native void nGetBoundingBox(long paramLong, float[] paramArrayOfFloat);
  
  private static native void nGetEntities(long paramLong, int[] paramArrayOfInt);
  
  private static native int nGetEntity(long paramLong, @NonNull String paramString);
  
  private static native int nGetEntityCount(long paramLong);
  
  private static native String nGetName(long paramLong, int paramInt);
  
  private static native int nGetResourceUriCount(long paramLong);
  
  private static native void nGetResourceUris(long paramLong, String[] paramArrayOfString);
  
  private static native int nGetRoot(long paramLong);
  
  private static native void nSetMorphBuffer(long paramLong, String paramString);
  
  private static native void nSetMorphWeights(long paramLong, String paramString, float[] paramArrayOfFloat);
  
  private static native void nUpdateMorphWeights(long paramLong, String paramString, float[] paramArrayOfFloat);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  @NonNull
  public Animator getAnimator()
  {
    if (this.mAnimator != null) {
      return this.mAnimator;
    }
    this.mAnimator = new Animator(nGetAnimator(getNativeObject()));
    return this.mAnimator;
  }
  
  @NonNull
  public Box getBoundingBox()
  {
    float[] arrayOfFloat = new float[6];
    nGetBoundingBox(this.mNativeObject, arrayOfFloat);
    return new Box(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5]);
  }
  
  @NonNull
  @Entity
  public int[] getEntities()
  {
    int[] arrayOfInt = new int[nGetEntityCount(this.mNativeObject)];
    nGetEntities(this.mNativeObject, arrayOfInt);
    return arrayOfInt;
  }
  
  @Entity
  public int getEntity(@NonNull String paramString)
  {
    return nGetEntity(this.mNativeObject, paramString);
  }
  
  public String getName(@Entity int paramInt)
  {
    return nGetName(getNativeObject(), paramInt);
  }
  
  long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  @NonNull
  public String[] getResourceUris()
  {
    String[] arrayOfString = new String[nGetResourceUriCount(this.mNativeObject)];
    nGetResourceUris(this.mNativeObject, arrayOfString);
    return arrayOfString;
  }
  
  @Entity
  public int getRoot()
  {
    return nGetRoot(this.mNativeObject);
  }
  
  public void setMorphWeights(String paramString)
  {
    nSetMorphBuffer(getNativeObject(), paramString);
  }
  
  public void setMorphWeights(String paramString, float[] paramArrayOfFloat)
  {
    nSetMorphWeights(getNativeObject(), paramString, paramArrayOfFloat);
  }
  
  public void updateMorphWeights(String paramString, float[] paramArrayOfFloat)
  {
    nUpdateMorphWeights(getNativeObject(), paramString, paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.gltfio.FilamentAsset
 * JD-Core Version:    0.7.0.1
 */