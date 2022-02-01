package com.huawei.hiar;

public final class ARFace
  extends ARTrackableBase
{
  ARFace(long paramLong, ARSession paramARSession)
  {
    super(paramLong, paramARSession);
  }
  
  private native ARPose nativeGetPose(long paramLong1, long paramLong2);
  
  public ARPose getPose()
  {
    return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARFace
 * JD-Core Version:    0.7.0.1
 */