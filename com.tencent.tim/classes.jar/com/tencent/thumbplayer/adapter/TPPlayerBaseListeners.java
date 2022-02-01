package com.tencent.thumbplayer.adapter;

import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnDetailInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnStateChangeListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCommonEnum.TPErrorType;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPPlayerBaseListeners
  implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnAudioProcessOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnDetailInfoListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnStateChangeListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnSubtitleFrameOutListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoProcessOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
{
  private static final String TAG = "TPPlayerListenerS";
  private TPPlayerListenersEmptyImpl EMPTY_LISTENERS;
  private ITPPlayerBaseListener.IOnAudioPcmOutListener mOnAudioFrameOutListener;
  private ITPPlayerBaseListener.IOnAudioProcessOutListener mOnAudioProcessFrameOutListener;
  private ITPPlayerBaseListener.IOnCompletionListener mOnCompletionListener;
  private ITPPlayerBaseListener.IOnDetailInfoListener mOnDetailInfoListener;
  private ITPPlayerBaseListener.IOnErrorListener mOnErrorListener;
  private ITPPlayerBaseListener.IOnInfoListener mOnInfoListener;
  private ITPPlayerBaseListener.IOnPreparedListener mOnPreparedListener;
  private ITPPlayerBaseListener.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ITPPlayerBaseListener.IOnStateChangeListener mOnStateChangeListener;
  private ITPPlayerBaseListener.IOnSubtitleDataListener mOnSubtitleDataListener;
  private ITPPlayerBaseListener.IOnSubtitleFrameOutListener mOnSubtitleFrameOutListener;
  private ITPPlayerBaseListener.IOnVideoFrameOutListener mOnVideoFrameOutListener;
  private ITPPlayerBaseListener.IOnVideoProcessOutListener mOnVideoProcessFrameOutListener;
  private ITPPlayerBaseListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private String mTag = "TPPlayerListenerS";
  
  public TPPlayerBaseListeners(String paramString)
  {
    updateTag(paramString);
    this.EMPTY_LISTENERS = new TPPlayerListenersEmptyImpl(this.mTag);
    this.mOnPreparedListener = this.EMPTY_LISTENERS;
    this.mOnCompletionListener = this.EMPTY_LISTENERS;
    this.mOnInfoListener = this.EMPTY_LISTENERS;
    this.mOnErrorListener = this.EMPTY_LISTENERS;
    this.mOnSeekCompleteListener = this.EMPTY_LISTENERS;
    this.mOnVideoSizeChangedListener = this.EMPTY_LISTENERS;
    this.mOnSubtitleDataListener = this.EMPTY_LISTENERS;
    this.mOnVideoFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnAudioFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnSubtitleFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnVideoProcessFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnAudioProcessFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnStateChangeListener = this.EMPTY_LISTENERS;
    this.mOnDetailInfoListener = this.EMPTY_LISTENERS;
  }
  
  public void clear()
  {
    this.mOnPreparedListener = this.EMPTY_LISTENERS;
    this.mOnCompletionListener = this.EMPTY_LISTENERS;
    this.mOnInfoListener = this.EMPTY_LISTENERS;
    this.mOnErrorListener = this.EMPTY_LISTENERS;
    this.mOnSeekCompleteListener = this.EMPTY_LISTENERS;
    this.mOnVideoSizeChangedListener = this.EMPTY_LISTENERS;
    this.mOnSubtitleDataListener = this.EMPTY_LISTENERS;
    this.mOnVideoFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnAudioFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnSubtitleFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnStateChangeListener = this.EMPTY_LISTENERS;
    this.mOnVideoProcessFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnAudioProcessFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnDetailInfoListener = this.EMPTY_LISTENERS;
  }
  
  public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.mOnAudioFrameOutListener.onAudioPcmOut(paramTPAudioFrameBuffer);
  }
  
  public TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    return this.mOnAudioProcessFrameOutListener.onAudioProcessFrameOut(paramTPPostProcessFrameBuffer);
  }
  
  public void onCompletion()
  {
    this.mOnCompletionListener.onCompletion();
  }
  
  public void onDetailInfo(TPPlayerDetailInfo paramTPPlayerDetailInfo)
  {
    this.mOnDetailInfoListener.onDetailInfo(paramTPPlayerDetailInfo);
  }
  
  public void onError(@TPCommonEnum.TPErrorType int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.mOnErrorListener.onError(paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    this.mOnInfoListener.onInfo(paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared()
  {
    this.mOnPreparedListener.onPrepared();
  }
  
  public void onSeekComplete()
  {
    this.mOnSeekCompleteListener.onSeekComplete();
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    this.mOnStateChangeListener.onStateChange(paramInt1, paramInt2);
  }
  
  public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    this.mOnSubtitleDataListener.onSubtitleData(paramTPSubtitleData);
  }
  
  public void onSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    this.mOnSubtitleFrameOutListener.onSubtitleFrameOut(paramTPSubtitleFrameBuffer);
  }
  
  public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    this.mOnVideoFrameOutListener.onVideoFrameOut(paramTPVideoFrameBuffer);
  }
  
  public TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    return this.mOnVideoProcessFrameOutListener.onVideoProcessFrameOut(paramTPPostProcessFrameBuffer);
  }
  
  public void onVideoSizeChanged(long paramLong1, long paramLong2)
  {
    this.mOnVideoSizeChangedListener.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  public void setOnAudioPcmOutListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
  {
    Object localObject = paramIOnAudioPcmOutListener;
    if (paramIOnAudioPcmOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnAudioFrameOutListener = ((ITPPlayerBaseListener.IOnAudioPcmOutListener)localObject);
  }
  
  public void setOnAudioProcessFrameListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
  {
    Object localObject = paramIOnAudioProcessOutListener;
    if (paramIOnAudioProcessOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnAudioProcessFrameOutListener = ((ITPPlayerBaseListener.IOnAudioProcessOutListener)localObject);
  }
  
  public void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener)
  {
    Object localObject = paramIOnCompletionListener;
    if (paramIOnCompletionListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnCompletionListener = ((ITPPlayerBaseListener.IOnCompletionListener)localObject);
  }
  
  public void setOnDetailInfoListener(ITPPlayerBaseListener.IOnDetailInfoListener paramIOnDetailInfoListener)
  {
    Object localObject = paramIOnDetailInfoListener;
    if (paramIOnDetailInfoListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnDetailInfoListener = ((ITPPlayerBaseListener.IOnDetailInfoListener)localObject);
  }
  
  public void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener)
  {
    Object localObject = paramIOnErrorListener;
    if (paramIOnErrorListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnErrorListener = ((ITPPlayerBaseListener.IOnErrorListener)localObject);
  }
  
  public void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener)
  {
    Object localObject = paramIOnInfoListener;
    if (paramIOnInfoListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnInfoListener = ((ITPPlayerBaseListener.IOnInfoListener)localObject);
  }
  
  public void setOnPreparedListener(ITPPlayerBaseListener.IOnPreparedListener paramIOnPreparedListener)
  {
    Object localObject = paramIOnPreparedListener;
    if (paramIOnPreparedListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnPreparedListener = ((ITPPlayerBaseListener.IOnPreparedListener)localObject);
  }
  
  public void setOnSeekCompleteListener(ITPPlayerBaseListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    Object localObject = paramIOnSeekCompleteListener;
    if (paramIOnSeekCompleteListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSeekCompleteListener = ((ITPPlayerBaseListener.IOnSeekCompleteListener)localObject);
  }
  
  public void setOnStateChangeListener(ITPPlayerBaseListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    Object localObject = paramIOnStateChangeListener;
    if (paramIOnStateChangeListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnStateChangeListener = ((ITPPlayerBaseListener.IOnStateChangeListener)localObject);
  }
  
  public void setOnSubtitleDataListener(ITPPlayerBaseListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    Object localObject = paramIOnSubtitleDataListener;
    if (paramIOnSubtitleDataListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSubtitleDataListener = ((ITPPlayerBaseListener.IOnSubtitleDataListener)localObject);
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    Object localObject = paramIOnSubtitleFrameOutListener;
    if (paramIOnSubtitleFrameOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSubtitleFrameOutListener = ((ITPPlayerBaseListener.IOnSubtitleFrameOutListener)localObject);
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    Object localObject = paramIOnVideoFrameOutListener;
    if (paramIOnVideoFrameOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoFrameOutListener = ((ITPPlayerBaseListener.IOnVideoFrameOutListener)localObject);
  }
  
  public void setOnVideoProcessFrameListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
  {
    Object localObject = paramIOnVideoProcessOutListener;
    if (paramIOnVideoProcessOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoProcessFrameOutListener = ((ITPPlayerBaseListener.IOnVideoProcessOutListener)localObject);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    Object localObject = paramIOnVideoSizeChangedListener;
    if (paramIOnVideoSizeChangedListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoSizeChangedListener = ((ITPPlayerBaseListener.IOnVideoSizeChangedListener)localObject);
  }
  
  public void updateTag(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (this.mTag = "TPPlayerListenerS";; this.mTag = paramString)
    {
      if (this.EMPTY_LISTENERS != null) {
        TPPlayerListenersEmptyImpl.access$002(this.EMPTY_LISTENERS, this.mTag);
      }
      return;
    }
  }
  
  static class TPPlayerListenersEmptyImpl
    implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnAudioProcessOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnDetailInfoListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnStateChangeListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnSubtitleFrameOutListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoProcessOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
  {
    private String mTag;
    
    public TPPlayerListenersEmptyImpl(String paramString)
    {
      this.mTag = paramString;
    }
    
    public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onAudioFrameOut");
    }
    
    public TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onAudioProcessFrameOut");
      return null;
    }
    
    public void onCompletion()
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onCompletion");
    }
    
    public void onDetailInfo(TPPlayerDetailInfo paramTPPlayerDetailInfo)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onDetailInfo");
    }
    
    public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onError");
    }
    
    public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onInfo");
    }
    
    public void onPrepared()
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onPrepared");
    }
    
    public void onSeekComplete()
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onSeekComplete");
    }
    
    public void onStateChange(int paramInt1, int paramInt2)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onStateChange");
    }
    
    public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onSubtitleData");
    }
    
    public void onSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , TPSubtitleFrameBuffer");
    }
    
    public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onVideoFrameOut");
    }
    
    public TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onVideoProcessFrameOut");
      return null;
    }
    
    public void onVideoSizeChanged(long paramLong1, long paramLong2)
    {
      TPLogUtil.i(this.mTag, " empty base listener , notify , onVideoSizeChanged");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerBaseListeners
 * JD-Core Version:    0.7.0.1
 */