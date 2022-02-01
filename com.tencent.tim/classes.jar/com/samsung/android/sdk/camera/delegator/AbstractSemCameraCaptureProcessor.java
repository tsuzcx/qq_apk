package com.samsung.android.sdk.camera.delegator;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.util.Size;
import java.nio.ByteBuffer;
import java.util.List;

public abstract class AbstractSemCameraCaptureProcessor
{
  public static final ProcessorParameter<Boolean> PARAMETER_ENABLE_FACE_BEAUTY = new ProcessorParameter("beauty_parameter");
  public static final ProcessorParameter<Integer> PARAMETER_IMAGE_FORMAT = new ProcessorParameter("image_format");
  protected static final String TAG = AbstractSemCameraCaptureProcessor.class.getSimpleName();
  
  public abstract CaptureRequest buildCaptureRequest(CaptureRequest.Builder paramBuilder);
  
  public abstract void capture(CameraCaptureSession paramCameraCaptureSession, CaptureResult paramCaptureResult, CaptureCallback paramCaptureCallback, Handler paramHandler, List<CaptureParameter> paramList);
  
  public abstract SessionConfiguration createSessionConfiguration(List<OutputConfiguration> paramList, CameraCaptureSession.StateCallback paramStateCallback, Handler paramHandler);
  
  public abstract CameraDevice.StateCallback createStateCallback(CameraDevice.StateCallback paramStateCallback, Handler paramHandler);
  
  public abstract void deinitialize();
  
  public abstract List<ProcessorParameter> getAvailableParameters();
  
  public abstract <T> T getProcessorParameter(ProcessorParameter<T> paramProcessorParameter);
  
  public abstract void initialize(Context paramContext, String paramString, Size paramSize)
    throws CameraAccessException;
  
  public abstract <T> void setProcessorParameter(ProcessorParameter<T> paramProcessorParameter, T paramT);
  
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
    
    public CaptureRequest.Key getKey()
    {
      return this.mKey;
    }
    
    public Object getValue()
    {
      return this.mValue;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
 * JD-Core Version:    0.7.0.1
 */