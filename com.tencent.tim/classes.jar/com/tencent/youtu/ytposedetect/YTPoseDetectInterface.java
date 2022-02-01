package com.tencent.youtu.ytposedetect;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager;

public class YTPoseDetectInterface
{
  private static final String TAG = "YoutuFaceDetect";
  public static final String VERSION = "3.4.5";
  private static PoseDetectResult mCheckResult;
  private static int mInitModel = 0;
  private static boolean mIsStarted = false;
  public static int mModelRetainCount = 0;
  private static PoseDetectProcessManager mPoseDetectProcessManager;
  
  public static YTActRefData getActReflectData()
  {
    return YTPoseDetectJNIInterface.getActionReflectData(YTCameraSetting.getRotateTag(mPoseDetectProcessManager.mCameraRotate, 1));
  }
  
  public static YTPoseImage getBestImage(int paramInt)
  {
    YTPoseImage localYTPoseImage = new YTPoseImage();
    localYTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getBestImage(paramInt);
    if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8))
    {
      localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
      localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
      return localYTPoseImage;
    }
    localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
    localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
    return localYTPoseImage;
  }
  
  public static void getBestImage(PoseDetectGetBestImage paramPoseDetectGetBestImage, boolean paramBoolean)
  {
    int i = 1;
    if (!paramBoolean) {}
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = YTPoseDetectJNIInterface.getBestImage(i);
      if ((i != 5) && (i != 6) && (i != 7) && (i != 8)) {
        break;
      }
      paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewHeight, mPoseDetectProcessManager.mDesiredPreviewWidth);
      return;
      i = YTCameraSetting.getRotateTag(mPoseDetectProcessManager.mCameraRotate, 1);
    }
    paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
  }
  
  public static YTPoseImage getEyeImage(int paramInt)
  {
    YTPoseImage localYTPoseImage = new YTPoseImage();
    localYTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getEyeImage(paramInt);
    if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8))
    {
      localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
      localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
      return localYTPoseImage;
    }
    localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
    localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
    return localYTPoseImage;
  }
  
  public static YTPoseImage getMouthImage(int paramInt)
  {
    YTPoseImage localYTPoseImage = new YTPoseImage();
    localYTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getMouthImage(paramInt);
    if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8))
    {
      localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
      localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
      return localYTPoseImage;
    }
    localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
    localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
    return localYTPoseImage;
  }
  
  public static String getVersion()
  {
    return "jar3.4.5_native" + YTPoseDetectJNIInterface.getVersion();
  }
  
  public static int initModel()
  {
    int i;
    try
    {
      YTLogger.i("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] ---");
      if (mInitModel > 0)
      {
        YTLogger.i("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] has already inited.");
        mInitModel += 1;
        return 0;
      }
      i = YTPoseDetectJNIInterface.initModel("");
      if (i == 0)
      {
        mPoseDetectProcessManager = new PoseDetectProcessManager();
        mPoseDetectProcessManager.initAll();
        mInitModel += 1;
        return 0;
      }
    }
    catch (Exception localException)
    {
      YTLogger.w("YoutuFaceDetect", "initModel failed. message: " + localException.getMessage());
      YTException.report(localException);
      return 10;
    }
    return i;
  }
  
  public static boolean isDetecting()
  {
    return (mPoseDetectProcessManager != null) && (mPoseDetectProcessManager.mIsDetecting);
  }
  
  private static void noticeFailed(int paramInt, String paramString1, String paramString2)
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.noticeFailed] resultCode: " + paramInt + " \r\nmessage: " + paramString1 + " \r\ntips: " + paramString2);
    mPoseDetectProcessManager.restoreCamera();
    mCheckResult.onFailed(paramInt, paramString1, paramString2);
    mCheckResult = null;
    mIsStarted = false;
  }
  
  private static void noticeSuccess()
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.noticeSuccess] ---");
    mCheckResult.onSuccess();
    mCheckResult = null;
    mIsStarted = true;
  }
  
  public static void poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt, byte[] paramArrayOfByte, Camera paramCamera, float paramFloat1, float paramFloat2, float paramFloat3, PoseDetectOnFrame paramPoseDetectOnFrame)
  {
    if (mInitModel <= 0) {
      paramPoseDetectOnFrame.onFailed(2, "Not init model on poseDetect.", "Call YTPoseDetectInterface.initModel() before.");
    }
    do
    {
      return;
      if (!mIsStarted)
      {
        paramPoseDetectOnFrame.onFailed(3, "Not call start() interface before.", "Call YTPoseDetectInterface.start() before.");
        return;
      }
      paramPoseDetectOnFrame.onSuccess(mPoseDetectProcessManager.poseDetect(paramArrayOfFloat1, paramArrayOfFloat2, paramInt, paramArrayOfByte, paramFloat1, paramFloat2, paramFloat3));
      if (YTPoseDetectJNIInterface.canReflect()) {
        paramPoseDetectOnFrame.onCanReflect();
      }
    } while (!YTPoseDetectJNIInterface.isRecordingDone());
    paramArrayOfFloat1 = YTPoseDetectJNIInterface.getFrameList();
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.poseDetect] list num: " + paramArrayOfFloat1.length);
    paramPoseDetectOnFrame.onRecordingDone(paramArrayOfFloat1, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
  }
  
  public static void releaseModel()
  {
    YTLogger.i("YoutuFaceDetect", "[YTFacePreviewInterface.finalize] ---");
    mInitModel -= 1;
    if (mInitModel <= 0)
    {
      if (mPoseDetectProcessManager != null) {
        mPoseDetectProcessManager.clearAll();
      }
      YTPoseDetectJNIInterface.releaseAll();
      mInitModel = 0;
    }
  }
  
  public static void reset() {}
  
  public static void setSafetyLevel(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {
      YTPoseDetectJNIInterface.setSafetyLevel(paramInt);
    }
  }
  
  public static int start(Context paramContext, Camera paramCamera, int paramInt, PoseDetectResult paramPoseDetectResult)
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.start] ---");
    if (paramPoseDetectResult == null) {
      return -1;
    }
    mCheckResult = paramPoseDetectResult;
    if (mInitModel > 0) {
      mPoseDetectProcessManager.start(paramContext, paramCamera, paramInt, new YTPoseDetectInterface.1());
    }
    for (;;)
    {
      return 0;
      noticeFailed(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
    }
  }
  
  public static void stop()
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.stop] ---");
    if (mPoseDetectProcessManager != null) {
      mPoseDetectProcessManager.stop();
    }
    mIsStarted = false;
  }
  
  public static abstract interface PoseDetectGetBestImage
  {
    public abstract void onGetBestImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  public static abstract interface PoseDetectGetImage
  {
    public abstract void onGetImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  public static abstract interface PoseDetectLiveType
  {
    public static final int LIVETYPE_BLINK_EYE = 1;
    public static final int LIVETYPE_OPEN_MOUTH = 2;
  }
  
  public static abstract interface PoseDetectLiveType_NotSuggest
  {
    public static final int LIVETYPE_NOD_HEAD = 3;
    public static final int LIVETYPE_SHAKE_HEAD = 4;
  }
  
  public static abstract interface PoseDetectOnFrame
  {
    public static final int DETECT_AUTH_FAILED = 1;
    public static final int DETECT_NOT_CALL_START = 3;
    public static final int DETECT_NOT_INIT_MODEL = 2;
    public static final int DETECT_SUCCESS = 0;
    
    public abstract void onCanReflect();
    
    public abstract void onFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onRecordingDone(byte[][] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract void onSuccess(int paramInt);
  }
  
  public static abstract interface PoseDetectResult
  {
    public static final int ERROR_AUTH_FAILED = 1;
    public static final int ERROR_NOT_INIT_MODEL = 2;
    public static final int SUCCESS = 0;
    
    public abstract void onFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onSuccess();
  }
  
  public static abstract interface PoseDetectSafetyLevel
  {
    public static final int SAFETY_COUNT = 3;
    public static final int SAFETY_HIGH = 2;
    public static final int SAFETY_LOW = 1;
    public static final int SAFETY_RECOMMAND = 0;
  }
  
  public class PoseImage
  {
    byte[] data;
    int height;
    int width;
    
    public PoseImage() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.YTPoseDetectInterface
 * JD-Core Version:    0.7.0.1
 */