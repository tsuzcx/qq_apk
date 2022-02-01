package com.tencent.thumbplayer.richmedia;

import android.content.Context;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeatureData;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaRequestExtraInfo;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaInnerProcessorCallback;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessor;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeature;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaProcessor;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaRequestExtraInfo;
import com.tencent.thumbplayer.richmedia.plugins.TPRichMediaSynchronizerReportPlugin;
import com.tencent.thumbplayer.tplayer.plugins.TPPluginManager;

public class TPRichMediaSynchronizer
  implements ITPInnerRichMediaSynchronizer
{
  private TPRichMediaInnerProcessCallback mInnerProcessCallback;
  private ITPNativeRichMediaProcessor mNativeRichMediaProcessor;
  private TPRichMediaProcessCallback mProcessCallback;
  private TPPluginManager mTPPluginManager;
  
  public TPRichMediaSynchronizer(Context paramContext)
    throws UnsupportedOperationException
  {
    this.mNativeRichMediaProcessor = new TPNativeRichMediaProcessor(paramContext);
    this.mInnerProcessCallback = new TPRichMediaInnerProcessCallback();
    this.mNativeRichMediaProcessor.setInnerProcessorCallback(this.mInnerProcessCallback);
    this.mProcessCallback = new TPRichMediaProcessCallback();
    this.mNativeRichMediaProcessor.setProcessorCallback(this.mProcessCallback);
    this.mTPPluginManager = new TPPluginManager();
    this.mTPPluginManager.addPlugin(new TPRichMediaSynchronizerReportPlugin());
  }
  
  private void pushEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.mTPPluginManager.onEvent(paramInt1, paramInt2, paramInt3, paramString, paramObject);
  }
  
  public void deselectFeatureAsync(int paramInt)
    throws IllegalStateException, IllegalArgumentException
  {
    this.mNativeRichMediaProcessor.deselectFeatureAsync(paramInt);
    pushEvent(304, paramInt, 0, null, null);
  }
  
  protected void finalize()
    throws Throwable
  {
    this.mNativeRichMediaProcessor.setInnerProcessorCallback(null);
    this.mNativeRichMediaProcessor.setProcessorCallback(null);
    this.mNativeRichMediaProcessor.release();
    this.mProcessCallback.setSynchronizerListener(null);
    this.mInnerProcessCallback.setInnerSynchronizerListener(null);
    super.finalize();
  }
  
  public TPRichMediaFeatureData getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt)
    throws IllegalStateException, IllegalArgumentException
  {
    return new TPRichMediaFeatureData(this.mNativeRichMediaProcessor.getCurrentPositionMsFeatureData(paramLong, paramArrayOfInt));
  }
  
  public TPRichMediaFeature[] getFeatures()
    throws IllegalStateException
  {
    int i = 0;
    TPNativeRichMediaFeature[] arrayOfTPNativeRichMediaFeature = this.mNativeRichMediaProcessor.getFeatures();
    if (arrayOfTPNativeRichMediaFeature == null) {
      return new TPRichMediaFeature[0];
    }
    TPRichMediaFeature[] arrayOfTPRichMediaFeature = new TPRichMediaFeature[arrayOfTPNativeRichMediaFeature.length];
    for (;;)
    {
      if ((i >= arrayOfTPNativeRichMediaFeature.length) || (arrayOfTPNativeRichMediaFeature[i] == null)) {
        return arrayOfTPRichMediaFeature;
      }
      arrayOfTPRichMediaFeature[i] = new TPRichMediaFeature(arrayOfTPNativeRichMediaFeature[i]);
      i += 1;
    }
  }
  
  public void prepareAsync()
    throws IllegalStateException
  {
    this.mNativeRichMediaProcessor.prepareAsync();
    pushEvent(300, 0, 0, null, null);
  }
  
  public void release()
  {
    this.mNativeRichMediaProcessor.setInnerProcessorCallback(null);
    this.mNativeRichMediaProcessor.setProcessorCallback(null);
    this.mNativeRichMediaProcessor.release();
    this.mProcessCallback.setSynchronizerListener(null);
    this.mInnerProcessCallback.setInnerSynchronizerListener(null);
    pushEvent(307, 0, 0, null, null);
    this.mTPPluginManager.release();
  }
  
  public void reset()
    throws IllegalStateException
  {
    this.mNativeRichMediaProcessor.reset();
    pushEvent(306, 0, 0, null, null);
  }
  
  public void seek(long paramLong)
    throws IllegalStateException, IllegalArgumentException
  {
    this.mNativeRichMediaProcessor.seek(paramLong);
  }
  
  public void selectFeatureAsync(int paramInt, TPRichMediaRequestExtraInfo paramTPRichMediaRequestExtraInfo)
    throws IllegalStateException, IllegalArgumentException
  {
    TPNativeRichMediaRequestExtraInfo localTPNativeRichMediaRequestExtraInfo = new TPNativeRichMediaRequestExtraInfo();
    localTPNativeRichMediaRequestExtraInfo.setActOnOptional(paramTPRichMediaRequestExtraInfo.getActOnOption());
    this.mNativeRichMediaProcessor.selectFeatureAsync(paramInt, localTPNativeRichMediaRequestExtraInfo);
    pushEvent(302, paramInt, 0, null, null);
  }
  
  public void setInnerListener(ITPInnerRichMediaSynchronizer.ITPRichMediaInnerSynchronizerListener paramITPRichMediaInnerSynchronizerListener)
  {
    this.mInnerProcessCallback.setInnerSynchronizerListener(paramITPRichMediaInnerSynchronizerListener);
  }
  
  public void setListener(ITPRichMediaSynchronizerListener paramITPRichMediaSynchronizerListener)
  {
    this.mProcessCallback.setSynchronizerListener(paramITPRichMediaSynchronizerListener);
  }
  
  public void setPlaybackRate(float paramFloat)
    throws IllegalStateException, IllegalArgumentException
  {
    this.mNativeRichMediaProcessor.setPlaybackRate(paramFloat);
  }
  
  public void setRichMediaSource(String paramString)
    throws IllegalStateException, IllegalArgumentException
  {
    this.mNativeRichMediaProcessor.setRichMediaSource(paramString);
    pushEvent(309, 0, 0, paramString, null);
  }
  
  class TPRichMediaInnerProcessCallback
    implements ITPNativeRichMediaInnerProcessorCallback
  {
    private ITPInnerRichMediaSynchronizer.ITPRichMediaInnerSynchronizerListener mInnerSynchronizerListener;
    
    TPRichMediaInnerProcessCallback() {}
    
    public long onGetCurrentPositionMs(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor)
    {
      paramITPNativeRichMediaProcessor = this.mInnerSynchronizerListener;
      if (paramITPNativeRichMediaProcessor != null)
      {
        long l = paramITPNativeRichMediaProcessor.onGetCurrentPositionMs(TPRichMediaSynchronizer.this);
        TPRichMediaSynchronizer.this.pushEvent(311, (int)l, 0, null, null);
        return l;
      }
      return -1L;
    }
    
    public void setInnerSynchronizerListener(ITPInnerRichMediaSynchronizer.ITPRichMediaInnerSynchronizerListener paramITPRichMediaInnerSynchronizerListener)
    {
      this.mInnerSynchronizerListener = paramITPRichMediaInnerSynchronizerListener;
    }
  }
  
  class TPRichMediaProcessCallback
    implements ITPNativeRichMediaProcessorCallback
  {
    private ITPRichMediaSynchronizerListener mSynchronizerListener;
    
    TPRichMediaProcessCallback() {}
    
    public void onDeselectFeatureSuccess(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt)
    {
      TPRichMediaSynchronizer.this.pushEvent(305, paramInt, 0, null, null);
      paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
      if (paramITPNativeRichMediaProcessor != null) {
        paramITPNativeRichMediaProcessor.onDeselectFeatureSuccess(TPRichMediaSynchronizer.this, paramInt);
      }
    }
    
    public void onRichMediaError(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt)
    {
      TPRichMediaSynchronizer.this.pushEvent(308, paramInt, 0, null, null);
      paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
      if (paramITPNativeRichMediaProcessor != null) {
        paramITPNativeRichMediaProcessor.onRichMediaError(TPRichMediaSynchronizer.this, paramInt);
      }
    }
    
    public void onRichMediaFeatureData(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt, TPNativeRichMediaFeatureData paramTPNativeRichMediaFeatureData)
    {
      paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
      if (paramITPNativeRichMediaProcessor != null) {
        paramITPNativeRichMediaProcessor.onRichMediaFeatureData(TPRichMediaSynchronizer.this, paramInt, new TPRichMediaFeatureData(paramTPNativeRichMediaFeatureData));
      }
    }
    
    public void onRichMediaFeatureFailure(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt1, int paramInt2)
    {
      TPRichMediaSynchronizer.this.pushEvent(310, paramInt1, paramInt2, null, null);
      paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
      if (paramITPNativeRichMediaProcessor != null) {
        paramITPNativeRichMediaProcessor.onRichMediaFeatureFailure(TPRichMediaSynchronizer.this, paramInt1, paramInt2);
      }
    }
    
    public void onRichMediaInfo(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt, long paramLong1, long paramLong2, long paramLong3, Object paramObject)
    {
      paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
      if (paramITPNativeRichMediaProcessor != null) {
        paramITPNativeRichMediaProcessor.onRichMediaInfo(TPRichMediaSynchronizer.this, paramInt, paramLong1, paramLong2, paramLong3, paramObject);
      }
    }
    
    public void onRichMediaPrepared(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor)
    {
      paramITPNativeRichMediaProcessor = TPRichMediaSynchronizer.this.getFeatures();
      TPRichMediaSynchronizer.this.pushEvent(301, 0, 0, null, paramITPNativeRichMediaProcessor);
      paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
      if (paramITPNativeRichMediaProcessor != null) {
        paramITPNativeRichMediaProcessor.onRichMediaPrepared(TPRichMediaSynchronizer.this);
      }
    }
    
    public void onSelectFeatureSuccess(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt)
    {
      TPRichMediaSynchronizer.this.pushEvent(303, paramInt, 0, null, null);
      paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
      if (paramITPNativeRichMediaProcessor != null) {
        paramITPNativeRichMediaProcessor.onSelectFeatureSuccess(TPRichMediaSynchronizer.this, paramInt);
      }
    }
    
    public void setSynchronizerListener(ITPRichMediaSynchronizerListener paramITPRichMediaSynchronizerListener)
    {
      this.mSynchronizerListener = paramITPRichMediaSynchronizerListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.richmedia.TPRichMediaSynchronizer
 * JD-Core Version:    0.7.0.1
 */