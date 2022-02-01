package com.tencent.superplayer.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract interface ISuperPlayer
{
  public abstract void addExtReportData(String paramString1, String paramString2);
  
  public abstract void addExtReportData(Map<String, String> paramMap);
  
  public abstract void addSubtitleSource(String paramString1, String paramString2, String paramString3);
  
  public abstract int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
    throws IllegalStateException, IllegalArgumentException, IllegalAccessException;
  
  public abstract int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    throws IllegalStateException, IllegalArgumentException, IllegalAccessException;
  
  public abstract void deselectTrack(int paramInt, long paramLong);
  
  public abstract int getBufferPercent();
  
  public abstract int getCurrentPlayerState();
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDurationMs();
  
  public abstract long getFileSizeBytes();
  
  public abstract MediaInfo getMediaInfo();
  
  public abstract TPProgramInfo[] getProgramInfo();
  
  public abstract String getStreamDumpInfo();
  
  public abstract String getToken();
  
  public abstract TPTrackInfo[] getTrackInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoRotation();
  
  public abstract ISPlayerVideoView getVideoView();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isBuffering();
  
  public abstract boolean isLoopBack();
  
  public abstract boolean isOutputMute();
  
  public abstract boolean isPausing();
  
  public abstract boolean isPlaying();
  
  public abstract void onPrePlayViewShow();
  
  public abstract void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong);
  
  public abstract void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption);
  
  public abstract void pause();
  
  public abstract void pauseDownload();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void resumeDownload();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void seekTo(int paramInt1, int paramInt2);
  
  public abstract void selectProgram(int paramInt, long paramLong);
  
  public abstract void selectTrack(int paramInt, long paramLong);
  
  public abstract void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void setOnAudioFrameOutputListener(OnAudioFrameOutputListener paramOnAudioFrameOutputListener);
  
  public abstract void setOnCaptureImageListener(OnCaptureImageListener paramOnCaptureImageListener);
  
  public abstract void setOnCompletionListener(OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnDefinitionInfoListener(OnDefinitionInfoListener paramOnDefinitionInfoListener);
  
  public abstract void setOnErrorListener(OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(OnInfoListener paramOnInfoListener);
  
  public abstract void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnSubtitleDataListener(OnSubtitleDataListener paramOnSubtitleDataListener);
  
  public abstract void setOnTVideoNetInfoUpdateListener(OnTVideoNetInfoListener paramOnTVideoNetInfoListener);
  
  public abstract void setOnVideoFrameOutputListener(OnVideoFrameOutputListener paramOnVideoFrameOutputListener);
  
  public abstract void setOnVideoPreparedListener(OnVideoPreparedListener paramOnVideoPreparedListener);
  
  public abstract void setOnVideoSizeChangedListener(OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setPlayerActive();
  
  public abstract void setPlayerOptionalParamList(List<TPOptionalParam> paramList);
  
  public abstract void setReportContentId(String paramString);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setXYaxis(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void switchDefinition(String paramString, int paramInt);
  
  public abstract void switchDefinitionForUrl(String paramString, int paramInt);
  
  public abstract void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView);
  
  public static abstract interface OnAudioFrameOutputListener
  {
    public abstract void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer);
  }
  
  public static abstract interface OnCaptureImageListener
  {
    public abstract void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2);
    
    public abstract void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(ISuperPlayer paramISuperPlayer);
  }
  
  public static abstract interface OnDefinitionInfoListener
  {
    public abstract void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString);
  }
  
  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(ISuperPlayer paramISuperPlayer);
  }
  
  public static abstract interface OnSubtitleDataListener
  {
    public abstract void onSubtitleData(ISuperPlayer paramISuperPlayer, TPSubtitleData paramTPSubtitleData);
  }
  
  public static abstract interface OnTVideoNetInfoListener
  {
    public abstract void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo);
  }
  
  public static abstract interface OnVideoFrameOutputListener
  {
    public abstract void onVideoFrameOutput(TPVideoFrameBuffer paramTPVideoFrameBuffer);
  }
  
  public static abstract interface OnVideoPreparedListener
  {
    public abstract void onVideoPrepared(ISuperPlayer paramISuperPlayer);
  }
  
  public static abstract interface OnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.ISuperPlayer
 * JD-Core Version:    0.7.0.1
 */