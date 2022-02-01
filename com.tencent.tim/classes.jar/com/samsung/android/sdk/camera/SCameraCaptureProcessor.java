package com.samsung.android.sdk.camera;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import com.samsung.android.sdk.camera.delegator.AbstractSemCamera;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.CaptureCallback;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.CaptureParameter;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.ProcessorParameter;
import com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_1;
import com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_2;
import com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessorDefault;
import com.samsung.android.sdk.camera.util.SsdkVersionCheck;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SCameraCaptureProcessor
{
  private static final String CAMERA_ID_REAR_WIDE = "2";
  public static final int IMAGE_FORMAT_JPEG = 256;
  public static final int IMAGE_FORMAT_NV21 = 17;
  public static final ProcessorParameter<Boolean> PARAMETER_ENABLE_FACE_BEAUTY = new ProcessorParameter("beauty_parameter");
  public static final ProcessorParameter<Integer> PARAMETER_IMAGE_FORMAT = new ProcessorParameter("image_format");
  private static final String TAG = SCameraCaptureProcessor.class.getSimpleName();
  private static SCameraCaptureProcessor mSCameraCaptureProcessor;
  private volatile boolean isSCameraProcessorInitialized = false;
  private CaptureCallback mAppCaptureCallback = null;
  private Handler mAppCaptureHandler;
  private CameraCaptureSession.CaptureCallback mAppPreviewCaptureCallback;
  private Context mContext;
  private List<ProcessorParameter> mParameterList;
  private PreviewCaptureCallback mPreviewCaptureCallback;
  private CaptureResult mPreviewCaptureResult;
  private AbstractSemCameraCaptureProcessor mSemCameraCaptureProcessor;
  private SemCaptureCallBack mSemCaptureCallBack;
  
  private void checkIsSCameraProcessorInitialized()
  {
    if (!this.isSCameraProcessorInitialized)
    {
      Log.i(TAG, "checkIsSCameraProcessorInitialized: sdk not initialized");
      throw new IllegalStateException("SCameraCaptureProcessor not initialized");
    }
  }
  
  public static SCameraCaptureProcessor getInstance()
  {
    try
    {
      if (mSCameraCaptureProcessor == null) {
        mSCameraCaptureProcessor = new SCameraCaptureProcessor();
      }
      SCameraCaptureProcessor localSCameraCaptureProcessor = mSCameraCaptureProcessor;
      return localSCameraCaptureProcessor;
    }
    finally {}
  }
  
  private AbstractSemCameraCaptureProcessor getSemCameraCaptureProcessor()
  {
    if ((this.mSemCameraCaptureProcessor != null) || (AbstractSemCamera.getSepPlatformVersion(this.mContext) >= 100100)) {}
    for (;;)
    {
      try
      {
        String str = AbstractSemCamera.getSEPClientVersion();
        Log.i(TAG, "getSemCameraCaptureProcessor semVersion : " + str);
        if (SsdkVersionCheck.compareVersion(str, "2.0.1") >= 0) {
          this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessor10_2();
        }
        Log.i(TAG, "getSemCameraCaptureProcessor  " + this.mSemCameraCaptureProcessor);
        return this.mSemCameraCaptureProcessor;
      }
      catch (Throwable localThrowable)
      {
        Log.i(TAG, "getSemCameraCaptureProcessor semVersion : SEP_VERSION_10_1 in caught Error:");
        this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessor10_1();
        continue;
      }
      this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessorDefault();
    }
  }
  
  private List<AbstractSemCameraCaptureProcessor.CaptureParameter> getSemParameters(List<CaptureParameter> paramList)
  {
    checkIsSCameraProcessorInitialized();
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CaptureParameter localCaptureParameter = (CaptureParameter)paramList.next();
      localArrayList.add(new AbstractSemCameraCaptureProcessor.CaptureParameter(localCaptureParameter.mKey, localCaptureParameter.mValue));
    }
    return localArrayList;
  }
  
  public CaptureRequest buildCaptureRequest(CaptureRequest.Builder paramBuilder)
  {
    try
    {
      Log.i(TAG, "buildCaptureRequest  : builder " + paramBuilder);
      checkIsSCameraProcessorInitialized();
      paramBuilder = getSemCameraCaptureProcessor().buildCaptureRequest(paramBuilder);
      return paramBuilder;
    }
    finally
    {
      paramBuilder = finally;
      throw paramBuilder;
    }
  }
  
  public void capture(CameraCaptureSession paramCameraCaptureSession, CaptureCallback paramCaptureCallback, Handler paramHandler, List<CaptureParameter> paramList)
  {
    try
    {
      checkIsSCameraProcessorInitialized();
      this.mAppCaptureCallback = paramCaptureCallback;
      getSemCameraCaptureProcessor().capture(paramCameraCaptureSession, this.mPreviewCaptureResult, this.mSemCaptureCallBack, paramHandler, getSemParameters(paramList));
      return;
    }
    finally
    {
      paramCameraCaptureSession = finally;
      throw paramCameraCaptureSession;
    }
  }
  
  public CameraCaptureSession.CaptureCallback createCaptureCallback(CameraCaptureSession.CaptureCallback paramCaptureCallback, Handler paramHandler)
  {
    try
    {
      Log.i(TAG, "createCaptureCallback");
      checkIsSCameraProcessorInitialized();
      this.mAppPreviewCaptureCallback = paramCaptureCallback;
      this.mAppCaptureHandler = paramHandler;
      paramCaptureCallback = this.mPreviewCaptureCallback;
      return paramCaptureCallback;
    }
    finally
    {
      paramCaptureCallback = finally;
      throw paramCaptureCallback;
    }
  }
  
  public SessionConfiguration createSessionConfiguration(List<OutputConfiguration> paramList, CameraCaptureSession.StateCallback paramStateCallback, Handler paramHandler)
  {
    try
    {
      checkIsSCameraProcessorInitialized();
      paramList = getSemCameraCaptureProcessor().createSessionConfiguration(paramList, paramStateCallback, paramHandler);
      return paramList;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public CameraDevice.StateCallback createStateCallback(CameraDevice.StateCallback paramStateCallback, Handler paramHandler)
  {
    try
    {
      checkIsSCameraProcessorInitialized();
      paramStateCallback = getSemCameraCaptureProcessor().createStateCallback(paramStateCallback, paramHandler);
      return paramStateCallback;
    }
    finally
    {
      paramStateCallback = finally;
      throw paramStateCallback;
    }
  }
  
  public void deinitialize()
  {
    try
    {
      Log.i(TAG, "deinitialize");
      checkIsSCameraProcessorInitialized();
      getSemCameraCaptureProcessor().deinitialize();
      this.mAppCaptureCallback = null;
      this.mAppCaptureHandler = null;
      this.mPreviewCaptureResult = null;
      this.mAppPreviewCaptureCallback = null;
      this.mSemCaptureCallBack = null;
      this.mPreviewCaptureCallback = null;
      this.mParameterList = null;
      this.isSCameraProcessorInitialized = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<ProcessorParameter> getAvailableParameters()
  {
    checkIsSCameraProcessorInitialized();
    Object localObject = getSemCameraCaptureProcessor().getAvailableParameters();
    if (this.mParameterList == null)
    {
      this.mParameterList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbstractSemCameraCaptureProcessor.ProcessorParameter localProcessorParameter = (AbstractSemCameraCaptureProcessor.ProcessorParameter)((Iterator)localObject).next();
        if (localProcessorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY) {
          this.mParameterList.add(PARAMETER_ENABLE_FACE_BEAUTY);
        } else if (localProcessorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT) {
          this.mParameterList.add(PARAMETER_IMAGE_FORMAT);
        }
      }
    }
    return Collections.unmodifiableList(this.mParameterList);
  }
  
  /* Error */
  public <T> T getProcessorParameter(ProcessorParameter<T> paramProcessorParameter)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getstatic 75	com/samsung/android/sdk/camera/SCameraCaptureProcessor:PARAMETER_ENABLE_FACE_BEAUTY	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor$ProcessorParameter;
    //   6: if_acmpne +18 -> 24
    //   9: aload_0
    //   10: invokespecial 217	com/samsung/android/sdk/camera/SCameraCaptureProcessor:getSemCameraCaptureProcessor	()Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor;
    //   13: getstatic 262	com/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor:PARAMETER_ENABLE_FACE_BEAUTY	Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor$ProcessorParameter;
    //   16: invokevirtual 275	com/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor:getProcessorParameter	(Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor$ProcessorParameter;)Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_1
    //   25: getstatic 79	com/samsung/android/sdk/camera/SCameraCaptureProcessor:PARAMETER_IMAGE_FORMAT	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor$ProcessorParameter;
    //   28: if_acmpne +17 -> 45
    //   31: aload_0
    //   32: invokespecial 217	com/samsung/android/sdk/camera/SCameraCaptureProcessor:getSemCameraCaptureProcessor	()Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor;
    //   35: getstatic 264	com/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor:PARAMETER_IMAGE_FORMAT	Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor$ProcessorParameter;
    //   38: invokevirtual 275	com/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor:getProcessorParameter	(Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor$ProcessorParameter;)Ljava/lang/Object;
    //   41: astore_1
    //   42: goto -22 -> 20
    //   45: aconst_null
    //   46: astore_1
    //   47: goto -27 -> 20
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	SCameraCaptureProcessor
    //   0	55	1	paramProcessorParameter	ProcessorParameter<T>
    // Exception table:
    //   from	to	target	type
    //   2	20	50	finally
    //   24	42	50	finally
  }
  
  public void initialize(Context paramContext, String paramString, Size paramSize)
    throws CameraAccessException
  {
    try
    {
      Log.i(TAG, "initialize: cameraId - " + paramString + ", pictureSize - " + paramSize);
      if (SCamera.getInstance().checkAvailability(paramContext) != 0) {
        throw new UnsupportedOperationException("CameraSdk not supported");
      }
    }
    finally {}
    try
    {
      String str = AbstractSemCamera.getSEPClientVersion();
      Log.i(TAG, "getSemCameraCaptureProcessor semVersion : " + str);
      if ((SsdkVersionCheck.compareVersion(str, "2.0.2") == 0) && (paramString.equals("2"))) {
        throw new IllegalArgumentException("cameraId unsupported by SDK");
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      this.mContext = paramContext;
      getSemCameraCaptureProcessor().initialize(paramContext, paramString, paramSize);
      this.mPreviewCaptureCallback = new PreviewCaptureCallback(null);
      this.mSemCaptureCallBack = new SemCaptureCallBack(null);
      this.isSCameraProcessorInitialized = true;
    }
  }
  
  public boolean isInitialized()
  {
    try
    {
      boolean bool = this.isSCameraProcessorInitialized;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public <T> void setProcessorParameter(ProcessorParameter<T> paramProcessorParameter, T paramT)
  {
    for (;;)
    {
      try
      {
        checkIsSCameraProcessorInitialized();
        if (paramProcessorParameter == PARAMETER_ENABLE_FACE_BEAUTY)
        {
          if ((paramT instanceof Boolean))
          {
            getSemCameraCaptureProcessor().setProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY, (Boolean)paramT);
            return;
          }
          throw new IllegalArgumentException("argument for PARAMETER_ENABLE_FACE_BEAUTY should be of type Boolean");
        }
      }
      finally {}
      if (paramProcessorParameter == PARAMETER_IMAGE_FORMAT)
      {
        if (!(paramT instanceof Integer)) {
          break;
        }
        getSemCameraCaptureProcessor().setProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT, (Integer)paramT);
      }
    }
    throw new IllegalArgumentException("argument for PARAMETER_IMAGE_FORMAT should be of type Integer");
  }
  
  public static abstract class CaptureCallback
  {
    public static final int ERROR_CAPTURE_FAILED = 1;
    public static final int ERROR_PROCESSING_FAILED = 2;
    
    public abstract void onError(int paramInt);
    
    public abstract void onPictureAvailable(ByteBuffer paramByteBuffer);
    
    public abstract void onShutter();
  }
  
  public static class CaptureParameter
  {
    private final CaptureRequest.Key mKey;
    private final Object mValue;
    
    public <T> CaptureParameter(CaptureRequest.Key<T> paramKey, T paramT)
    {
      this.mKey = paramKey;
      this.mValue = paramT;
    }
  }
  
  class PreviewCaptureCallback
    extends CameraCaptureSession.CaptureCallback
  {
    private PreviewCaptureCallback() {}
    
    public void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
    {
      Log.i(SCameraCaptureProcessor.TAG, "onCaptureBufferLost: frameNumber " + paramLong);
      synchronized (SCameraCaptureProcessor.this)
      {
        if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
          SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureBufferLost(paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong);
        }
        return;
      }
    }
    
    public void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      SCameraCaptureProcessor.access$402(SCameraCaptureProcessor.this, paramTotalCaptureResult);
      synchronized (SCameraCaptureProcessor.this)
      {
        if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
          SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureCompleted(paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult);
        }
        return;
      }
    }
    
    public void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
    {
      Log.i(SCameraCaptureProcessor.TAG, "onCaptureFailed: failure " + paramCaptureFailure.getReason() + "  mAppPreviewCaptureCallback: " + SCameraCaptureProcessor.this.mAppPreviewCaptureCallback);
      synchronized (SCameraCaptureProcessor.this)
      {
        if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
          SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureFailed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure);
        }
        return;
      }
    }
    
    public void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
    {
      synchronized (SCameraCaptureProcessor.this)
      {
        if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
          SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureProgressed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureResult);
        }
        return;
      }
    }
    
    public void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt)
    {
      Log.i(SCameraCaptureProcessor.TAG, "onCaptureSequenceAborted: sequenceId " + paramInt);
      synchronized (SCameraCaptureProcessor.this)
      {
        if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
          SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureSequenceAborted(paramCameraCaptureSession, paramInt);
        }
        return;
      }
    }
    
    public void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong)
    {
      synchronized (SCameraCaptureProcessor.this)
      {
        if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
          SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureSequenceCompleted(paramCameraCaptureSession, paramInt, paramLong);
        }
        return;
      }
    }
    
    public void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2)
    {
      synchronized (SCameraCaptureProcessor.this)
      {
        if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
          SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureStarted(paramCameraCaptureSession, paramCaptureRequest, paramLong1, paramLong2);
        }
        return;
      }
    }
  }
  
  public static final class ProcessorParameter<T>
  {
    private String mName;
    
    ProcessorParameter(String paramString)
    {
      this.mName = paramString;
    }
    
    public String getName()
    {
      return this.mName;
    }
  }
  
  class SemCaptureCallBack
    extends AbstractSemCameraCaptureProcessor.CaptureCallback
  {
    private SemCaptureCallBack() {}
    
    public void onError(int paramInt)
    {
      if (SCameraCaptureProcessor.this.mAppCaptureCallback != null) {
        SCameraCaptureProcessor.this.mAppCaptureCallback.onError(paramInt);
      }
    }
    
    public void onPictureAvailable(ByteBuffer paramByteBuffer)
    {
      if (SCameraCaptureProcessor.this.mAppCaptureCallback != null) {
        SCameraCaptureProcessor.this.mAppCaptureCallback.onPictureAvailable(paramByteBuffer);
      }
    }
    
    public void onShutter()
    {
      if (SCameraCaptureProcessor.this.mAppCaptureCallback != null) {
        SCameraCaptureProcessor.this.mAppCaptureCallback.onShutter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.camera.SCameraCaptureProcessor
 * JD-Core Version:    0.7.0.1
 */