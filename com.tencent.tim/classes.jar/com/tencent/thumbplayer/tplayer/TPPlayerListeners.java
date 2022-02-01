package com.tencent.thumbplayer.tplayer;

import android.text.TextUtils;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnDetailInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPPlayerListeners
  implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnDetailInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener
{
  private static final String TAG = "TPPlayerListenerS";
  private TPPlayerListenersEmptyImpl EMPTY_LISTENERS;
  private ITPPlayerListener.IOnAudioFrameOutputListener mOnAudioFrameOutListener;
  private ITPPlayerListener.IOnAudioProcessFrameOutputListener mOnAudioProcessFrameOutListener;
  private ITPPlayerListener.IOnCompletionListener mOnCompletionListener;
  private ITPPlayerListener.IOnDetailInfoListener mOnDetailInfoListener;
  private ITPPlayerListener.IOnErrorListener mOnErrorListener;
  private ITPPlayerListener.IOnInfoListener mOnInfoListener;
  private ITPPlayerListener.IOnStateChangeListener mOnPlayerStateChangeListener;
  private ITPPlayerListener.IOnPreparedListener mOnPreparedListener;
  private ITPPlayerListener.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ITPPlayerListener.IOnStopAsyncCompleteListener mOnStopAsyncCompleteListener;
  private ITPPlayerListener.IOnSubtitleDataListener mOnSubtitleDataListener;
  private ITPPlayerListener.IOnSubtitleFrameOutListener mOnSubtitleFrameOutListener;
  private ITPPlayerListener.IOnVideoFrameOutListener mOnVideoFrameOutListener;
  private ITPPlayerListener.IOnVideoProcessFrameOutputListener mOnVideoProcessFrameOutListener;
  private ITPPlayerListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private String mTag = "TPPlayerListenerS";
  
  TPPlayerListeners(String paramString)
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
    this.mOnSubtitleFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnVideoFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnAudioFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnVideoProcessFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnAudioProcessFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnPlayerStateChangeListener = this.EMPTY_LISTENERS;
    this.mOnStopAsyncCompleteListener = this.EMPTY_LISTENERS;
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
    this.mOnPlayerStateChangeListener = this.EMPTY_LISTENERS;
    this.mOnStopAsyncCompleteListener = this.EMPTY_LISTENERS;
    this.mOnDetailInfoListener = this.EMPTY_LISTENERS;
  }
  
  public void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.mOnAudioFrameOutListener.onAudioFrameOut(paramITPPlayer, paramTPAudioFrameBuffer);
  }
  
  public TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    return this.mOnAudioProcessFrameOutListener.onAudioProcessFrameOut(paramITPPlayer, paramTPPostProcessFrameBuffer);
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    this.mOnCompletionListener.onCompletion(paramITPPlayer);
  }
  
  public void onDetailInfo(ITPPlayer paramITPPlayer, TPPlayerDetailInfo paramTPPlayerDetailInfo)
  {
    this.mOnDetailInfoListener.onDetailInfo(paramITPPlayer, paramTPPlayerDetailInfo);
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.mOnErrorListener.onError(paramITPPlayer, paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    this.mOnInfoListener.onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    this.mOnPreparedListener.onPrepared(paramITPPlayer);
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    this.mOnSeekCompleteListener.onSeekComplete(paramITPPlayer);
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    this.mOnPlayerStateChangeListener.onStateChange(paramInt1, paramInt2);
  }
  
  public void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    this.mOnStopAsyncCompleteListener.onStopAsyncComplete(paramITPPlayer);
  }
  
  public void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
  {
    this.mOnSubtitleDataListener.onSubtitleData(paramITPPlayer, paramTPSubtitleData);
  }
  
  public void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    this.mOnSubtitleFrameOutListener.onSubtitleFrameOut(paramITPPlayer, paramTPSubtitleFrameBuffer);
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    this.mOnVideoFrameOutListener.onVideoFrameOut(paramITPPlayer, paramTPVideoFrameBuffer);
  }
  
  public TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    return this.mOnVideoProcessFrameOutListener.onVideoProcessFrameOut(paramITPPlayer, paramTPPostProcessFrameBuffer);
  }
  
  public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    this.mOnVideoSizeChangedListener.onVideoSizeChanged(paramITPPlayer, paramLong1, paramLong2);
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener)
  {
    Object localObject = paramIOnAudioFrameOutputListener;
    if (paramIOnAudioFrameOutputListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnAudioFrameOutListener = ((ITPPlayerListener.IOnAudioFrameOutputListener)localObject);
  }
  
  public void setOnAudioProcessOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener paramIOnAudioProcessFrameOutputListener)
  {
    Object localObject = paramIOnAudioProcessFrameOutputListener;
    if (paramIOnAudioProcessFrameOutputListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnAudioProcessFrameOutListener = ((ITPPlayerListener.IOnAudioProcessFrameOutputListener)localObject);
  }
  
  public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    Object localObject = paramIOnCompletionListener;
    if (paramIOnCompletionListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnCompletionListener = ((ITPPlayerListener.IOnCompletionListener)localObject);
  }
  
  public void setOnDetailInfoListener(ITPPlayerListener.IOnDetailInfoListener paramIOnDetailInfoListener)
  {
    Object localObject = paramIOnDetailInfoListener;
    if (paramIOnDetailInfoListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnDetailInfoListener = ((ITPPlayerListener.IOnDetailInfoListener)localObject);
  }
  
  public void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    Object localObject = paramIOnErrorListener;
    if (paramIOnErrorListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnErrorListener = ((ITPPlayerListener.IOnErrorListener)localObject);
  }
  
  public void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    Object localObject = paramIOnInfoListener;
    if (paramIOnInfoListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnInfoListener = ((ITPPlayerListener.IOnInfoListener)localObject);
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    Object localObject = paramIOnStateChangeListener;
    if (paramIOnStateChangeListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnPlayerStateChangeListener = ((ITPPlayerListener.IOnStateChangeListener)localObject);
  }
  
  public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    Object localObject = paramIOnPreparedListener;
    if (paramIOnPreparedListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnPreparedListener = ((ITPPlayerListener.IOnPreparedListener)localObject);
  }
  
  public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    Object localObject = paramIOnSeekCompleteListener;
    if (paramIOnSeekCompleteListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSeekCompleteListener = ((ITPPlayerListener.IOnSeekCompleteListener)localObject);
  }
  
  public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener)
  {
    Object localObject = paramIOnStopAsyncCompleteListener;
    if (paramIOnStopAsyncCompleteListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnStopAsyncCompleteListener = ((ITPPlayerListener.IOnStopAsyncCompleteListener)localObject);
  }
  
  public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    Object localObject = paramIOnSubtitleDataListener;
    if (paramIOnSubtitleDataListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSubtitleDataListener = ((ITPPlayerListener.IOnSubtitleDataListener)localObject);
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    Object localObject = paramIOnSubtitleFrameOutListener;
    if (paramIOnSubtitleFrameOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSubtitleFrameOutListener = ((ITPPlayerListener.IOnSubtitleFrameOutListener)localObject);
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    Object localObject = paramIOnVideoFrameOutListener;
    if (paramIOnVideoFrameOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoFrameOutListener = ((ITPPlayerListener.IOnVideoFrameOutListener)localObject);
  }
  
  public void setOnVideoProcessOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener paramIOnVideoProcessFrameOutputListener)
  {
    Object localObject = paramIOnVideoProcessFrameOutputListener;
    if (paramIOnVideoProcessFrameOutputListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoProcessFrameOutListener = ((ITPPlayerListener.IOnVideoProcessFrameOutputListener)localObject);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    Object localObject = paramIOnVideoSizeChangedListener;
    if (paramIOnVideoSizeChangedListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoSizeChangedListener = ((ITPPlayerListener.IOnVideoSizeChangedListener)localObject);
  }
  
  public void updateTag(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (this.mTag = "TPPlayerListenerS";; this.mTag = paramString)
    {
      if (this.EMPTY_LISTENERS != null) {
        TPPlayerListenersEmptyImpl.access$002(this.EMPTY_LISTENERS, paramString);
      }
      return;
    }
  }
  
  static class TPPlayerListenersEmptyImpl
    implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnDetailInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    private String mTag;
    
    public TPPlayerListenersEmptyImpl(String paramString)
    {
      this.mTag = paramString;
    }
    
    public void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onAudioFrameOut");
    }
    
    public TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
      return null;
    }
    
    public void onCompletion(ITPPlayer paramITPPlayer)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onCompletion");
    }
    
    public void onDetailInfo(ITPPlayer paramITPPlayer, TPPlayerDetailInfo paramTPPlayerDetailInfo)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onDetailInfo");
    }
    
    public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onError");
    }
    
    public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onInfo");
    }
    
    public void onPrepared(ITPPlayer paramITPPlayer)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onPrepared");
    }
    
    public void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onSeekComplete");
    }
    
    public void onStateChange(int paramInt1, int paramInt2)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onStateChange");
    }
    
    public void onStopAsyncComplete(ITPPlayer paramITPPlayer)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onStopAsyncComplete");
    }
    
    public void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onSubtitleData");
    }
    
    public void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onSubtitleFrameOut");
    }
    
    public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onVideoFrameOut");
    }
    
    public TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
      return null;
    }
    
    public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      TPLogUtil.i(this.mTag, " empty player listener , notify , onVideoSizeChanged");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayerListeners
 * JD-Core Version:    0.7.0.1
 */