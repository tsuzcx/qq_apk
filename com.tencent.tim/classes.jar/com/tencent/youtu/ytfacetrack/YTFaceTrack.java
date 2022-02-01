package com.tencent.youtu.ytfacetrack;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.tencent.youtu.ytfacetrack.param.YTFaceAlignParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;

public class YTFaceTrack
{
  public static String Version = "2.3.3.3";
  private static YTFaceTrack instance = null;
  public long handleId = 0L;
  private long nativePtr;
  
  static
  {
    nativeInit();
  }
  
  public YTFaceTrack()
  {
    NativeConstructor();
  }
  
  public static int GlobalInit(String paramString)
  {
    int i = GlobalInitInner(paramString);
    if (i == 0) {
      instance = new YTFaceTrack();
    }
    return i;
  }
  
  private static native int GlobalInitInner(String paramString);
  
  private static native int GlobalInitSuccessCount();
  
  public static boolean GlobalRelease()
  {
    if (instance != null)
    {
      instance.destroy();
      instance = null;
    }
    return GlobalReleaseInner();
  }
  
  private static native boolean GlobalReleaseInner();
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static YTFaceTrack getInstance()
  {
    try
    {
      if (instance == null)
      {
        Log.w("TAG", "Please call YTFaceTrack.GlobalInit() before YTFaceTrack.getInstance()");
        instance = new YTFaceTrack();
      }
      YTFaceTrack localYTFaceTrack = instance;
      return localYTFaceTrack;
    }
    finally {}
  }
  
  private static native boolean nativeInit();
  
  public native FaceStatus[] DoDetectionProcess(YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessBitmap(Bitmap paramBitmap, int paramInt, YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessYUVWithBlur(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, float[] paramArrayOfFloat, YTImage paramYTImage);
  
  public native YTFaceAlignParam GetFaceAlignParam();
  
  public native YTFaceDetectParam GetFaceDetectParam();
  
  public native Rect[] GetFaceRect(YTImage paramYTImage);
  
  public native YTFaceTrackParam GetFaceTrackParam();
  
  public native YTImage GetYTImageBitmap(Bitmap paramBitmap, int paramInt);
  
  public native int GetYTImageBitmapReuseData(Bitmap paramBitmap, int paramInt, YTImage paramYTImage);
  
  public native YTImage GetYTImageRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native YTImage GetYTImageRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int GetYTImageRGBAReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native int GetYTImageRGBReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native YTImage GetYTImageYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int GetYTImageYUVReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native byte[] RotateYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native void SaveYTImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native boolean SetFaceAlignParam(YTFaceAlignParam paramYTFaceAlignParam);
  
  public native boolean SetFaceDetectParam(YTFaceDetectParam paramYTFaceDetectParam);
  
  public native boolean SetFaceTrackParam(YTFaceTrackParam paramYTFaceTrackParam);
  
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
    public float pitch;
    public float[] pointsVis;
    public float roll;
    public float[] xys;
    public float[] xys5p;
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
  
  public static class YTImage
  {
    public byte[] data;
    public int height;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrack.YTFaceTrack
 * JD-Core Version:    0.7.0.1
 */