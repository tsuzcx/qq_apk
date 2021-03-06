package com.tencent.thumbplayer.adapter.player;

import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.log.TPLoggerContext;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface ITPPlayerBase
{
  public abstract void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList);
  
  public abstract void addSubtitleSource(String paramString1, String paramString2, String paramString3);
  
  public abstract void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack);
  
  public abstract void deselectTrack(int paramInt, long paramLong);
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDurationMs();
  
  public abstract int getNativePlayerId();
  
  public abstract long getPlayableDurationMs();
  
  public abstract TPProgramInfo[] getProgramInfo();
  
  public abstract long getPropertyLong(int paramInt)
    throws IllegalStateException;
  
  public abstract String getPropertyString(int paramInt)
    throws IllegalStateException;
  
  public abstract TPTrackInfo[] getTrackInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void pause()
    throws IllegalStateException;
  
  public abstract void prepare()
    throws IllegalStateException, IOException;
  
  public abstract void prepareAsync()
    throws IllegalStateException, IOException;
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt)
    throws IllegalStateException;
  
  public abstract void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
    throws IllegalStateException;
  
  public abstract void selectProgram(int paramInt, long paramLong);
  
  public abstract void selectTrack(int paramInt, long paramLong);
  
  public abstract void setAudioGainRatio(float paramFloat);
  
  public abstract void setAudioNormalizeVolumeParams(String paramString);
  
  public abstract void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setDataSource(ITPMediaAsset paramITPMediaAsset)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setDataSource(String paramString, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
    throws IllegalStateException;
  
  public abstract void setOnAudioProcessOutputListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
    throws IllegalStateException;
  
  public abstract void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener);
  
  public abstract void setOnDetailInfoListener(ITPPlayerBaseListener.IOnDetailInfoListener paramIOnDetailInfoListener);
  
  public abstract void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener);
  
  public abstract void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener);
  
  public abstract void setOnPreparedListener(ITPPlayerBaseListener.IOnPreparedListener paramIOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(ITPPlayerBaseListener.IOnSeekCompleteListener paramIOnSeekCompleteListener);
  
  public abstract void setOnSubtitleDataListener(ITPPlayerBaseListener.IOnSubtitleDataListener paramIOnSubtitleDataListener);
  
  public abstract void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener);
  
  public abstract void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
    throws IllegalStateException;
  
  public abstract void setOnVideoProcessOutputListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
    throws IllegalStateException;
  
  public abstract void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam);
  
  public abstract void setSurface(Surface paramSurface)
    throws IllegalStateException;
  
  public abstract void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
    throws IllegalStateException;
  
  public abstract void start()
    throws IllegalStateException;
  
  public abstract void stop()
    throws IllegalStateException;
  
  public abstract void switchDefinition(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException;
  
  public abstract void switchDefinition(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException;
  
  public abstract void switchDefinition(String paramString, Map<String, String> paramMap, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException;
  
  public abstract void updateLoggerContext(TPLoggerContext paramTPLoggerContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.ITPPlayerBase
 * JD-Core Version:    0.7.0.1
 */