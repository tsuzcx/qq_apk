package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.ArrayList;

public class YTAGReflectLiveCheckInterface
{
  private static final String TAG = "YoutuLightLiveCheck";
  public static final String VERSION = "3.4.7";
  private static GetLiveStyleResult getLiveStyleResultHandler = null;
  public static YTAGReflectSettings mAGSettings;
  public static String mAppId = "";
  private static ArrayList mCanceledList;
  private static LightLiveCheckResult mCheckResult;
  private static long mCurrentTag;
  private static TimerWorker mGetValueTimer;
  private static int mInitModel;
  private static int mOnGetValueCount;
  public static YTReflectLayout mReflectLayout;
  private static IYTReflectListener mReflectListener;
  public static YTReflectNotice mReflectNotice;
  public static RGBConfigRequester mRgbConfigRequester;
  public static UploadVideoRequester mUploadVideoRequester;
  public static UploadVideoRequesterV2 mUploadVideoRequesterV2;
  public static UploadVideoRequesterV3 mUploadVideoRequesterV3;
  private static long tagIndex;
  
  static
  {
    mAGSettings = new YTAGReflectSettings();
    mInitModel = 0;
    tagIndex = 0L;
  }
  
  public static void cancel()
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.cancel] --- " + ProcessManager.mProcessState + " current: " + mCurrentTag);
    if ((ProcessManager.mProcessState != 0) && (!isCanceled(mCurrentTag)))
    {
      ProcessManager.cancel();
      noticeFailed(3, "user canceled", "YTAGReflectLiveCheckInterface.cancel() be called.", mCurrentTag);
    }
  }
  
  public static void clean()
  {
    mCanceledList = null;
  }
  
  public static void clearUploadRequester()
  {
    mUploadVideoRequester = null;
    mUploadVideoRequesterV2 = null;
    mUploadVideoRequesterV3 = null;
  }
  
  public static YTAGReflectSettings getAGSettings()
  {
    return mAGSettings;
  }
  
  public static Bitmap getBestImage(boolean paramBoolean)
  {
    int i = -1;
    if (paramBoolean) {
      i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate, 1);
    }
    return YTAGReflectLiveCheckJNIInterface.getInstance().FRGetBestImg(i);
  }
  
  public static int getLiveCheckType(Context paramContext, GetLiveStyleResult paramGetLiveStyleResult)
  {
    int i = 1;
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- start");
    if (paramGetLiveStyleResult == null) {}
    for (;;)
    {
      YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- finish. ret: " + i);
      return i;
      if (paramContext == null)
      {
        paramGetLiveStyleResult.onFailed(1, "Input context is null.", "You can try to input getActivity().getApplicationContext() and test again.");
        i = 2;
      }
      else
      {
        if (getLiveStyleResultHandler != null) {
          YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] repeated calls. this may cause the previous call lost callback.");
        }
        getLiveStyleResultHandler = paramGetLiveStyleResult;
        mOnGetValueCount = 0;
        i = SensorManagerWorker.getInstance().start(paramContext, new YTAGReflectLiveCheckInterface.1());
        if (i == 1)
        {
          YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] Can't find light sensor.");
          if (getLiveStyleResultHandler != null)
          {
            getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(-1.0F, mAppId), new LiveStyleResponse());
            getLiveStyleResultHandler = null;
          }
          i = 0;
        }
        else if (i != 0)
        {
          if (getLiveStyleResultHandler != null)
          {
            getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(SensorManagerWorker.getInstance().getLux(), mAppId), new LiveStyleResponse());
            getLiveStyleResultHandler = null;
          }
          i = 0;
        }
        else
        {
          mGetValueTimer = new YTAGReflectLiveCheckInterface.2(3000L, 3000L);
          mGetValueTimer.start();
          i = 0;
        }
      }
    }
  }
  
  public static int getProcessState()
  {
    return ProcessManager.mProcessState;
  }
  
  public static IYTReflectListener getReflectListener()
  {
    return mReflectListener;
  }
  
  private static long getTag()
  {
    tagIndex += 1L;
    return tagIndex;
  }
  
  public static int initModel(String paramString)
  {
    for (;;)
    {
      try
      {
        if (mInitModel > 0)
        {
          YTLogger.w("YoutuLightLiveCheck", "initModel repeated calls.");
          mInitModel += 1;
          return 0;
        }
        ProcessManager.initAll();
        if (mCanceledList == null) {
          mCanceledList = new ArrayList();
        }
        if (paramString == null) {
          mAppId = "";
        } else {
          mAppId = paramString;
        }
      }
      catch (Exception paramString)
      {
        YTLogger.w("YoutuLightLiveCheck", "initModel failed. message: " + paramString.getMessage());
        YTException.report(paramString);
        return 10;
      }
    }
  }
  
  public static boolean isCanceled(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1;
    if (mCanceledList == null)
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= mCanceledList.size()) {
        break;
      }
      if (((Long)mCanceledList.get(i)).longValue() == paramLong) {
        return true;
      }
      i += 1;
    }
  }
  
  public static void noticeFailed(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeFailed] resultCode: " + paramInt + " \r\nmessage: " + paramString1 + " \r\ntips: " + paramString2 + " tag: " + paramLong);
    if (isCanceled(paramLong)) {
      YTLogger.d("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeFailed] user canceled before notice failed. tag: " + paramLong);
    }
    for (;;)
    {
      return;
      if (mInitModel > 0)
      {
        ProcessManager.dataWorker().cleanup();
        ProcessManager.cameraWorker().cleanup();
      }
      while (mCheckResult == null)
      {
        YTLogger.i("YoutuLightLiveCheck", "Reflect noticeFailed() mCheckResult is null");
        return;
        YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice failed");
      }
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        mCheckResult.onFailed(paramInt, paramString1, paramString2);
        mCheckResult = null;
      }
      while (mCanceledList != null)
      {
        mCanceledList.add(new Long(mCurrentTag));
        return;
        new Handler(Looper.getMainLooper()).post(new YTAGReflectLiveCheckInterface.4(paramInt, paramString1, paramString2));
      }
    }
  }
  
  public static void noticeSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse, String paramString, long paramLong)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] ---isAlive: " + paramBoolean + " tag: " + paramLong);
    if (isCanceled(paramLong))
    {
      YTLogger.d("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] user canceled before notice success. tag: " + paramLong);
      return;
    }
    if (mInitModel > 0)
    {
      ProcessManager.dataWorker().cleanup();
      ProcessManager.cameraWorker().cleanup();
    }
    while (mCheckResult == null)
    {
      YTLogger.i("YoutuLightLiveCheck", "Reflect noticeSuccess() mCheckResult is null");
      return;
      YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice success");
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      mCheckResult.onSuccess(paramBoolean, paramLightDiffResponse, paramString);
      mCheckResult = null;
    }
    for (;;)
    {
      mCanceledList.add(new Long(mCurrentTag));
      return;
      new Handler(Looper.getMainLooper()).post(new YTAGReflectLiveCheckInterface.3(paramBoolean, paramLightDiffResponse, paramString));
    }
  }
  
  public static void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (ProcessManager.cameraWorker() != null) {
      ProcessManager.cameraWorker().onPreviewFrame(paramArrayOfByte, paramCamera);
    }
  }
  
  public static void releaseModel()
  {
    mInitModel -= 1;
    if (mInitModel <= 0)
    {
      mInitModel = 0;
      if (ProcessManager.mProcessState != 0)
      {
        YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.releaseModel] release model be called when processing. processState: " + ProcessManager.mProcessState);
        YTException.report(new Exception("\"[YTAGReflectLiveCheckInterface.releaseModel] release model be called when processing. processState: \" + ProcessManager.mProcessState"));
      }
      ProcessManager.clearAll();
      mReflectNotice = null;
    }
  }
  
  public static void setAGSettings(YTAGReflectSettings paramYTAGReflectSettings)
  {
    mAGSettings = paramYTAGReflectSettings;
  }
  
  public static void setRGBConfigRequest(RGBConfigRequester paramRGBConfigRequester)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setRGBConfigRequest] ---");
    mRgbConfigRequester = paramRGBConfigRequester;
  }
  
  public static void setReflectListener(IYTReflectListener paramIYTReflectListener)
  {
    mReflectListener = paramIYTReflectListener;
  }
  
  public static void setReflectNotice(YTReflectNotice paramYTReflectNotice)
  {
    mReflectNotice = paramYTReflectNotice;
  }
  
  public static void setSafetyLevel(int paramInt)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setSafetyLevel] --- level: " + paramInt);
    mAGSettings.safetylevel = paramInt;
  }
  
  public static void setUploadVideoRequester(UploadVideoRequester paramUploadVideoRequester)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setUploadVideoRequester] ---");
    clearUploadRequester();
    mUploadVideoRequester = paramUploadVideoRequester;
  }
  
  public static void setUploadVideoRequesterV2(UploadVideoRequesterV2 paramUploadVideoRequesterV2)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setUploadVideoRequesterV2] ---");
    clearUploadRequester();
    mUploadVideoRequesterV2 = paramUploadVideoRequesterV2;
  }
  
  public static void setUploadVideoRequesterV3(UploadVideoRequesterV3 paramUploadVideoRequesterV3)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setUploadVideoRequesterV3] ---");
    clearUploadRequester();
    mUploadVideoRequesterV3 = paramUploadVideoRequesterV3;
  }
  
  public static void start(Context paramContext, Camera paramCamera, int paramInt, YTReflectLayout paramYTReflectLayout, LightLiveCheckResult paramLightLiveCheckResult)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.start] ---");
    mCheckResult = paramLightLiveCheckResult;
    mReflectLayout = paramYTReflectLayout;
    ProcessManager.dataWorker().mCameraRotate = YTCameraSetting.getVideoRotate(paramContext, paramInt);
    mCurrentTag = getTag();
    if (mInitModel <= 0)
    {
      noticeFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.", mCurrentTag);
      return;
    }
    if (mRgbConfigRequester == null)
    {
      noticeFailed(4, "Not set rgbRequest.", "Call YTAGReflectLiveCheckInterface.setRGBConfigRequest() before.", mCurrentTag);
      return;
    }
    if ((mUploadVideoRequesterV3 == null) && (mUploadVideoRequesterV2 == null) && (mUploadVideoRequester == null))
    {
      noticeFailed(5, "Not set uploadRequest.", "Call YTAGReflectLiveCheckInterface.setUploadVideoRequesterV2() or setUploadVideoRequesterV3() before.", mCurrentTag);
      return;
    }
    ProcessManager.cameraWorker().setCamera(paramCamera);
    ProcessManager.start(mCurrentTag);
  }
  
  public static abstract interface GetLiveStyleResult
  {
    public abstract void onFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse);
  }
  
  public static abstract interface IYTReflectListener
  {
    public abstract void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter);
  }
  
  public static abstract interface LightLiveCheckResult
  {
    public static final int AUTH_FAILED = 1;
    public static final int FINISH_ERRORBASE = 300;
    public static final int INIT_ERRORBASE = 100;
    public static final int NOT_INIT_MODEL = 2;
    public static final int NOT_SET_RGBREQUEST = 4;
    public static final int NOT_SET_UPLOADREQUEST = 5;
    public static final int REFLECT_ERRORBASE = 200;
    public static final int SUCCESS = 0;
    public static final int USER_CANCEL = 3;
    
    public abstract void onFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse, String paramString);
  }
  
  public static abstract interface LightLiveProcessState
  {
    public static final int GET_RGBCONFIG = 1;
    public static final int HANGUP = 0;
    public static final int REFLECTING = 2;
    public static final int UPLOAD = 3;
  }
  
  public static abstract interface YTSAFETYLEVEL
  {
    public static final int SAFETY_HIGH = 2;
    public static final int SAFETY_LOW = 1;
    public static final int SAFETY_RECOMMEND = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface
 * JD-Core Version:    0.7.0.1
 */