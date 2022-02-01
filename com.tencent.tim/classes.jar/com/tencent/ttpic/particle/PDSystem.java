package com.tencent.ttpic.particle;

public class PDSystem
{
  private long lastTime;
  private long mNativeObject;
  
  private PDSystem(long paramLong)
  {
    this.mNativeObject = paramLong;
    reset();
  }
  
  public static PDSystem create(boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
  {
    return new PDSystem(nCreateSystem(paramBoolean, paramString, paramArrayOfByte));
  }
  
  private static native long nCreateSystem(boolean paramBoolean, String paramString, byte[] paramArrayOfByte);
  
  private static native void nDestroy(long paramLong);
  
  private static native void nLoadAllTextures(long paramLong);
  
  private static native void nRender(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native void nReset(long paramLong);
  
  private static native void nSetBaseRotation(long paramLong, float paramFloat);
  
  private static native void nSetImage(long paramLong, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native void nSetRotateX(long paramLong, float paramFloat);
  
  private static native void nSetRotateY(long paramLong, float paramFloat);
  
  private static native void nSetRotateZ(long paramLong, float paramFloat);
  
  private static native void nSetSourcePosition(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetTextureImage(long paramLong, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native boolean nTotalFinished(long paramLong);
  
  private static native void nUpdateFboSize(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void destroy()
  {
    nDestroy(this.mNativeObject);
    this.mNativeObject = 0L;
  }
  
  public void loadAllTextures()
  {
    nLoadAllTextures(this.mNativeObject);
  }
  
  public void render(long paramLong, boolean paramBoolean)
  {
    if (this.lastTime <= 0L) {
      this.lastTime = paramLong;
    }
    long l = this.lastTime;
    nRender(this.mNativeObject, paramLong - l, paramBoolean);
    this.lastTime = paramLong;
  }
  
  public void reset()
  {
    this.lastTime = -1L;
    nReset(this.mNativeObject);
  }
  
  public void setBaseRotation(float paramFloat)
  {
    nSetBaseRotation(this.mNativeObject, paramFloat);
  }
  
  public void setImage(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    nSetImage(this.mNativeObject, paramString, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void setRotateX(float paramFloat)
  {
    nSetRotateX(this.mNativeObject, paramFloat);
  }
  
  public void setRotateY(float paramFloat)
  {
    nSetRotateY(this.mNativeObject, paramFloat);
  }
  
  public void setRotateZ(float paramFloat)
  {
    nSetRotateZ(this.mNativeObject, paramFloat);
  }
  
  public void setSourcePosition(Vector3 paramVector3)
  {
    nSetSourcePosition(this.mNativeObject, paramVector3.x, paramVector3.y, paramVector3.z);
  }
  
  public void setTextureImage(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    nSetTextureImage(this.mNativeObject, paramString, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean totalFinished()
  {
    return nTotalFinished(this.mNativeObject);
  }
  
  public void updateFboSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    nUpdateFboSize(this.mNativeObject, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.PDSystem
 * JD-Core Version:    0.7.0.1
 */