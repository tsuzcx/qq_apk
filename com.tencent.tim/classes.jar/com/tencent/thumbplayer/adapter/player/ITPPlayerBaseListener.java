package com.tencent.thumbplayer.adapter.player;

import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCommonEnum.TPErrorType;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

public class ITPPlayerBaseListener
{
  public static abstract interface IOnAudioPcmOutListener
  {
    public abstract void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer);
  }
  
  public static abstract interface IOnAudioProcessOutListener
  {
    public abstract TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer);
  }
  
  public static abstract interface IOnCompletionListener
  {
    public abstract void onCompletion();
  }
  
  public static abstract interface IOnDetailInfoListener
  {
    public abstract void onDetailInfo(TPPlayerDetailInfo paramTPPlayerDetailInfo);
  }
  
  public static abstract interface IOnErrorListener
  {
    public abstract void onError(@TPCommonEnum.TPErrorType int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  }
  
  public static abstract interface IOnInfoListener
  {
    public abstract void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject);
  }
  
  public static abstract interface IOnPreparedListener
  {
    public abstract void onPrepared();
  }
  
  public static abstract interface IOnSeekCompleteListener
  {
    public abstract void onSeekComplete();
  }
  
  public static abstract interface IOnStateChangeListener
  {
    public abstract void onStateChange(int paramInt1, int paramInt2);
  }
  
  public static abstract interface IOnSubtitleDataListener
  {
    public abstract void onSubtitleData(TPSubtitleData paramTPSubtitleData);
  }
  
  public static abstract interface IOnSubtitleFrameOutListener
  {
    public abstract void onSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer);
  }
  
  public static abstract interface IOnVideoFrameOutListener
  {
    public abstract void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer);
  }
  
  public static abstract interface IOnVideoProcessOutListener
  {
    public abstract TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer);
  }
  
  public static abstract interface IOnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener
 * JD-Core Version:    0.7.0.1
 */