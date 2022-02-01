package com.google.android.filament;

public class NativeSurface
{
  private final int mHeight;
  private final long mNativeObject;
  private final int mWidth;
  
  public NativeSurface(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mNativeObject = nCreateSurface(paramInt1, paramInt2);
  }
  
  private static native long nCreateSurface(int paramInt1, int paramInt2);
  
  private static native void nDestroySurface(long paramLong);
  
  public void dispose()
  {
    nDestroySurface(this.mNativeObject);
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.NativeSurface
 * JD-Core Version:    0.7.0.1
 */