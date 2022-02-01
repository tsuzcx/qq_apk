package com.tencent.thumbplayer.core.richmedia;

import android.content.Context;
import com.tencent.thumbplayer.core.common.TPFieldCalledByNative;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;

public class TPNativeRichMediaProcessor
  implements ITPNativeRichMediaProcessor
{
  @TPFieldCalledByNative
  private long mNativeContext = 0L;
  
  public TPNativeRichMediaProcessor(Context paramContext)
    throws UnsupportedOperationException
  {
    TPNativeLibraryLoader.loadLibIfNeeded(paramContext.getApplicationContext());
    try
    {
      _nativeSetup();
      return;
    }
    catch (Throwable paramContext)
    {
      TPNativeLog.printLog(4, "Failed to create native rich media:" + paramContext.getMessage());
      throw new UnsupportedOperationException("Failed to create rich media");
    }
  }
  
  private native int _deselectFeatureAsync(int paramInt);
  
  private native int _getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt, TPNativeRichMediaFeatureData paramTPNativeRichMediaFeatureData);
  
  private native TPNativeRichMediaFeature[] _getFeatures();
  
  private native void _nativeSetup();
  
  private native int _prepareAsync();
  
  private native void _release();
  
  private native int _reset();
  
  private native int _seek(long paramLong);
  
  private native int _selectFeatureAsync(int paramInt, TPNativeRichMediaRequestExtraInfo paramTPNativeRichMediaRequestExtraInfo);
  
  private native void _setInnerProcessorCallback(ITPNativeRichMediaInnerProcessorCallback paramITPNativeRichMediaInnerProcessorCallback);
  
  private native int _setPlaybackRate(float paramFloat);
  
  private native void _setProcessorCallback(ITPNativeRichMediaProcessorCallback paramITPNativeRichMediaProcessorCallback);
  
  private native int _setRichMediaSource(String paramString);
  
  public void deselectFeatureAsync(int paramInt)
    throws IllegalStateException, IllegalArgumentException
  {
    try
    {
      paramInt = _deselectFeatureAsync(paramInt);
      if (paramInt == 0) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      return;
    }
    if (paramInt == 1000012) {
      throw new IllegalArgumentException();
    }
    throw new IllegalStateException("deSelectAsync:" + paramInt);
  }
  
  public TPNativeRichMediaFeatureData getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt)
    throws IllegalStateException, IllegalArgumentException
  {
    TPNativeRichMediaFeatureData localTPNativeRichMediaFeatureData = new TPNativeRichMediaFeatureData();
    int i;
    try
    {
      i = _getCurrentPositionMsFeatureData(paramLong, paramArrayOfInt, localTPNativeRichMediaFeatureData);
      if (i == 0) {
        return localTPNativeRichMediaFeatureData;
      }
    }
    catch (Throwable paramArrayOfInt)
    {
      TPNativeLog.printLog(4, paramArrayOfInt.getMessage());
      return null;
    }
    if (i == 1000012) {
      throw new IllegalArgumentException();
    }
    throw new IllegalStateException("getCurrentTimeContent:" + i);
  }
  
  public TPNativeRichMediaFeature[] getFeatures()
    throws IllegalStateException
  {
    try
    {
      TPNativeRichMediaFeature[] arrayOfTPNativeRichMediaFeature = _getFeatures();
      return arrayOfTPNativeRichMediaFeature;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return new TPNativeRichMediaFeature[0];
  }
  
  public void prepareAsync()
    throws IllegalStateException
  {
    int i;
    try
    {
      i = _prepareAsync();
      if (i == 0) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      return;
    }
    throw new IllegalStateException("prepareAsync:" + i);
  }
  
  public void release()
  {
    try
    {
      _release();
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public void reset()
    throws IllegalStateException
  {
    int i;
    try
    {
      i = _reset();
      if (i == 0) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      return;
    }
    throw new IllegalStateException("reset:" + i);
  }
  
  public void seek(long paramLong)
    throws IllegalStateException, IllegalArgumentException
  {
    int i;
    try
    {
      i = _seek(paramLong);
      if (i == 0) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      return;
    }
    if (i == 1000012) {
      throw new IllegalArgumentException();
    }
    throw new IllegalStateException("seek:" + i);
  }
  
  public void selectFeatureAsync(int paramInt, TPNativeRichMediaRequestExtraInfo paramTPNativeRichMediaRequestExtraInfo)
    throws IllegalStateException, IllegalArgumentException
  {
    try
    {
      paramInt = _selectFeatureAsync(paramInt, paramTPNativeRichMediaRequestExtraInfo);
      if (paramInt == 0) {
        return;
      }
    }
    catch (Throwable paramTPNativeRichMediaRequestExtraInfo)
    {
      TPNativeLog.printLog(4, paramTPNativeRichMediaRequestExtraInfo.getMessage());
      return;
    }
    if (paramInt == 1000012) {
      throw new IllegalArgumentException();
    }
    throw new IllegalStateException("selectAsync:" + paramInt);
  }
  
  public void setInnerProcessorCallback(ITPNativeRichMediaInnerProcessorCallback paramITPNativeRichMediaInnerProcessorCallback)
  {
    try
    {
      _setInnerProcessorCallback(paramITPNativeRichMediaInnerProcessorCallback);
      return;
    }
    catch (Throwable paramITPNativeRichMediaInnerProcessorCallback)
    {
      TPNativeLog.printLog(4, paramITPNativeRichMediaInnerProcessorCallback.getMessage());
    }
  }
  
  public void setPlaybackRate(float paramFloat)
    throws IllegalStateException, IllegalArgumentException
  {
    int i;
    try
    {
      i = _setPlaybackRate(paramFloat);
      if (i == 0) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      return;
    }
    if (i == 1000012) {
      throw new IllegalArgumentException();
    }
    throw new IllegalStateException("setPlaybackRate:" + i);
  }
  
  public void setProcessorCallback(ITPNativeRichMediaProcessorCallback paramITPNativeRichMediaProcessorCallback)
  {
    try
    {
      _setProcessorCallback(paramITPNativeRichMediaProcessorCallback);
      return;
    }
    catch (Throwable paramITPNativeRichMediaProcessorCallback)
    {
      TPNativeLog.printLog(4, paramITPNativeRichMediaProcessorCallback.getMessage());
    }
  }
  
  public void setRichMediaSource(String paramString)
    throws IllegalStateException, IllegalArgumentException
  {
    int i;
    try
    {
      i = _setRichMediaSource(paramString);
      if (i == 0) {
        return;
      }
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      return;
    }
    if (i == 1000012) {
      throw new IllegalArgumentException();
    }
    throw new IllegalStateException("setRichMediaSource:" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaProcessor
 * JD-Core Version:    0.7.0.1
 */