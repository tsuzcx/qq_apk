package com.tencent.jni;

public class FaceDetector
{
  private FaceInfo mFaceInfo;
  private boolean mIdle = true;
  private long mNativeDetector = 0L;
  
  static
  {
    System.loadLibrary("FaceAlgClinet");
  }
  
  public static void IdCardDestroy() {}
  
  public static int IdCardDetect(IdCardInfo paramIdCardInfo, FaceDetector.IdCardDirection paramIdCardDirection, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return NativeIdCardDetect(paramIdCardInfo, paramIdCardDirection.ordinal(), paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  public static boolean IdCardDetectInitial(String paramString)
  {
    return NativeIdCardInitial(paramString);
  }
  
  public static void IdCardReset() {}
  
  public static boolean IsSupportNeon()
  {
    return NativeIsSupportNeon();
  }
  
  public static int LiveActionDetect(LiveRectInfo paramLiveRectInfo, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, FaceDetector.LiveAction paramLiveAction)
  {
    return NativeLiveActionDetect(paramLiveRectInfo, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLiveAction.ordinal());
  }
  
  public static void LiveDestroy() {}
  
  public static boolean LiveDetectInitial(String paramString, LiveThreshold paramLiveThreshold)
  {
    return NativeLiveDetectInitial(paramString, paramLiveThreshold);
  }
  
  public static void LiveDetectReset() {}
  
  public static int LiveDirectionDetect(DirectionInfo paramDirectionInfo, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return NativeLiveDirectionDetect(paramDirectionInfo, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  private static native void NativeDestroy(long paramLong);
  
  private static native int NativeFaceDetect(FaceInfo paramFaceInfo, long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4);
  
  private static native int NativeFaceLightDetect(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt);
  
  private static native void NativeIdCardDestroy();
  
  private static native int NativeIdCardDetect(IdCardInfo paramIdCardInfo, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  private static native boolean NativeIdCardInitial(String paramString);
  
  private static native void NativeIdCardReset();
  
  private static native long NativeInitial(String paramString, FaceThreshold paramFaceThreshold);
  
  private static native long NativeInitialMode(String paramString, int paramInt, FaceThreshold paramFaceThreshold);
  
  private static native boolean NativeIsSupportNeon();
  
  private static native int NativeLiveActionDetect(LiveRectInfo paramLiveRectInfo, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void NativeLiveDetectDestroy();
  
  private static native boolean NativeLiveDetectInitial(String paramString, LiveThreshold paramLiveThreshold);
  
  private static native void NativeLiveDetectReset();
  
  private static native int NativeLiveDirectionDetect(DirectionInfo paramDirectionInfo, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public long Destroy()
  {
    NativeDestroy(this.mNativeDetector);
    this.mNativeDetector = 0L;
    return 0L;
  }
  
  public FaceDetector.ErrorCode FaceLightDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    switch (NativeFaceLightDetect(this.mNativeDetector, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramArrayOfInt))
    {
    default: 
      return FaceDetector.ErrorCode.UNKNOW;
    case 0: 
      return FaceDetector.ErrorCode.NO_ERROR;
    case -1: 
      return FaceDetector.ErrorCode.NO_LIGHT;
    case -2: 
      return FaceDetector.ErrorCode.NO_FACE;
    }
    return FaceDetector.ErrorCode.BAD_PARAM;
  }
  
  public int FaceRegister(FaceInfo paramFaceInfo, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    return NativeFaceDetect(paramFaceInfo, this.mNativeDetector, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramArrayOfInt, 1);
  }
  
  public int FaceValidate(FaceInfo paramFaceInfo, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    return NativeFaceDetect(paramFaceInfo, this.mNativeDetector, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramArrayOfInt, 0);
  }
  
  public long Initial(String paramString, FaceDetector.AlgMode paramAlgMode, FaceThreshold paramFaceThreshold)
  {
    if (FaceDetector.AlgMode.ALG_OPENCV == paramAlgMode) {}
    for (this.mNativeDetector = NativeInitialMode(paramString, 0, paramFaceThreshold);; this.mNativeDetector = NativeInitialMode(paramString, 1, paramFaceThreshold)) {
      return 0L;
    }
  }
  
  public boolean Initial(String paramString, FaceThreshold paramFaceThreshold)
  {
    this.mNativeDetector = NativeInitial(paramString, paramFaceThreshold);
    return 0L != this.mNativeDetector;
  }
  
  public boolean idle()
  {
    return this.mIdle;
  }
  
  public void setIdle(boolean paramBoolean)
  {
    this.mIdle = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.jni.FaceDetector
 * JD-Core Version:    0.7.0.1
 */