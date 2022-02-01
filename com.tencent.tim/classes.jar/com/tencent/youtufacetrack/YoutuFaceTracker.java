package com.tencent.youtufacetrack;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class YoutuFaceTracker
{
  private static long handle;
  private static YoutuFaceTracker instance;
  private long nativePtr;
  
  public YoutuFaceTracker()
  {
    NativeConstructor();
  }
  
  public static native boolean GlobalInit(String paramString);
  
  public static native boolean GlobalRelease();
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static long getHandle()
  {
    return handle;
  }
  
  public static YoutuFaceTracker getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new YoutuFaceTracker();
      }
      YoutuFaceTracker localYoutuFaceTracker = instance;
      return localYoutuFaceTracker;
    }
    finally {}
  }
  
  public static native boolean nativeInit();
  
  public native FaceStatus[] DoDetectionProcessBitmap(Bitmap paramBitmap);
  
  public native FaceStatus[] DoDetectionProcessYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native FaceStatus3d[] DoDetectionProcessYUVPoses(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native Bitmap convertYUV2Bitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public void destroy()
  {
    NativeDestructor();
  }
  
  protected void finalize()
    throws Throwable
  {
    NativeDestructor();
  }
  
  public static class FaceStatus
  {
    public double illumination_score;
    public float pitch;
    public float[] pointsVis;
    public float roll;
    public float[] xys;
    public float yaw;
  }
  
  public static class FaceStatus3d
  {
    public float[] denseFaceModel;
    public float[] expression;
    public float pitch;
    public float roll;
    public float[] transform;
    public float yaw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtufacetrack.YoutuFaceTracker
 * JD-Core Version:    0.7.0.1
 */