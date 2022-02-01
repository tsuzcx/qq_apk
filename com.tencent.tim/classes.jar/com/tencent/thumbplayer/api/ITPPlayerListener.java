package com.tencent.thumbplayer.api;

public class ITPPlayerListener
{
  public static abstract interface IOnAudioFrameOutputListener
  {
    public abstract void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer);
  }
  
  public static abstract interface IOnAudioProcessFrameOutputListener
  {
    public abstract TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer);
  }
  
  public static abstract interface IOnCompletionListener
  {
    public abstract void onCompletion(ITPPlayer paramITPPlayer);
  }
  
  public static abstract interface IOnDetailInfoListener
  {
    public abstract void onDetailInfo(ITPPlayer paramITPPlayer, TPPlayerDetailInfo paramTPPlayerDetailInfo);
  }
  
  public static abstract interface IOnErrorListener
  {
    public abstract void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  }
  
  public static abstract interface IOnInfoListener
  {
    public abstract void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject);
  }
  
  public static abstract interface IOnPreparedListener
  {
    public abstract void onPrepared(ITPPlayer paramITPPlayer);
  }
  
  public static abstract interface IOnSeekCompleteListener
  {
    public abstract void onSeekComplete(ITPPlayer paramITPPlayer);
  }
  
  public static abstract interface IOnStateChangeListener
  {
    public abstract void onStateChange(int paramInt1, int paramInt2);
  }
  
  public static abstract interface IOnStopAsyncCompleteListener
  {
    public abstract void onStopAsyncComplete(ITPPlayer paramITPPlayer);
  }
  
  public static abstract interface IOnSubtitleDataListener
  {
    public abstract void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData);
  }
  
  public static abstract interface IOnSubtitleFrameOutListener
  {
    public abstract void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer);
  }
  
  public static abstract interface IOnVideoFrameOutListener
  {
    public abstract void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer);
  }
  
  public static abstract interface IOnVideoProcessFrameOutputListener
  {
    public abstract TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer);
  }
  
  public static abstract interface IOnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.ITPPlayerListener
 * JD-Core Version:    0.7.0.1
 */