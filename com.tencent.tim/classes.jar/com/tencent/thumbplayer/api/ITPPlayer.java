package com.tencent.thumbplayer.api;

import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSeekMode;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSwitchDefMode;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginManager;
import java.io.IOException;
import java.util.Map;

public abstract interface ITPPlayer
{
  public static final String TP_MIMETYPE_TEXT_SUBRIP = "text/x-subrip";
  public static final String TP_MIMETYPE_TEXT_VTT = "text/vtt";
  public static final int TP_PLAYER_LOOPBACK_ENDPOSITION_DEFAULT = -1;
  public static final int TP_PLAYER_LOOPBACK_STARTPOSITION_DEFAULT = 0;
  @TPNativeKeyMap.MapSeekMode(3)
  public static final int TP_PLAYER_SEEK_MODE_ACCURATE_POSITION = 3;
  @TPNativeKeyMap.MapSeekMode(1)
  public static final int TP_PLAYER_SEEK_MODE_FREVIOUS_KFRAME = 1;
  @TPNativeKeyMap.MapSeekMode(4)
  public static final int TP_PLAYER_SEEK_MODE_NEXT_CLIP = 4;
  @TPNativeKeyMap.MapSeekMode(2)
  public static final int TP_PLAYER_SEEK_MODE_NEXT_KFRAME = 2;
  @TPNativeKeyMap.MapSwitchDefMode(3)
  public static final int TP_PLAYER_SWITCH_DEF_AFTER_ALL_RESOURCE_CONSUME = 3;
  @TPNativeKeyMap.MapSwitchDefMode(0)
  public static final int TP_PLAYER_SWITCH_DEF_DEFAULT = 0;
  @TPNativeKeyMap.MapSwitchDefMode(2)
  public static final int TP_PLAYER_SWITCH_DEF_FAST_WITH_KEEP_NO_BUFFERING = 2;
  @TPNativeKeyMap.MapSwitchDefMode(1)
  public static final int TP_PLAYER_SWITCH_DEF_IMMEDIATELY = 1;
  
  public abstract void addAudioTrackSource(String paramString1, String paramString2);
  
  public abstract void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData);
  
  public abstract ITPPluginManager addPlugin(ITPPluginBase paramITPPluginBase);
  
  public abstract void addSubtitleSource(@NonNull String paramString1, String paramString2, @NonNull String paramString3);
  
  public abstract void addSubtitleSource(@NonNull String paramString1, String paramString2, @NonNull String paramString3, TPDownloadParamData paramTPDownloadParamData);
  
  public abstract void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack);
  
  public abstract void deselectTrack(int paramInt, long paramLong);
  
  public abstract void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener, Looper paramLooper);
  
  public abstract int getBufferPercent();
  
  public abstract long getCurrentPositionMs();
  
  public abstract int getCurrentState();
  
  public abstract long getDurationMs();
  
  public abstract long getFileSizeBytes();
  
  public abstract long getPlayableDurationMs();
  
  public abstract ITPPlayerProxy getPlayerProxy();
  
  public abstract int getPlayerType();
  
  public abstract TPProgramInfo[] getProgramInfo();
  
  public abstract long getPropertyLong(int paramInt)
    throws IllegalStateException;
  
  public abstract String getPropertyString(int paramInt)
    throws IllegalStateException;
  
  public abstract ITPBusinessReportManager getReportManager();
  
  public abstract TPTrackInfo[] getTrackInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void pause()
    throws IllegalStateException;
  
  public abstract void pauseDownload();
  
  public abstract void prepareAsync()
    throws IllegalStateException, IOException;
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void resumeDownload();
  
  public abstract void seekTo(int paramInt)
    throws IllegalStateException;
  
  public abstract void seekTo(int paramInt1, int paramInt2)
    throws IllegalStateException;
  
  public abstract void selectProgram(int paramInt, long paramLong);
  
  public abstract void selectTrack(int paramInt, long paramLong);
  
  public abstract void setAudioGainRatio(float paramFloat);
  
  public abstract void setAudioNormalizeVolumeParams(String paramString);
  
  public abstract void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
    throws IllegalArgumentException, IllegalStateException;
  
  public abstract void setDataSource(ITPMediaAsset paramITPMediaAsset)
    throws IllegalArgumentException, IllegalStateException;
  
  public abstract void setDataSource(String paramString)
    throws IllegalArgumentException, IllegalStateException;
  
  public abstract void setDataSource(String paramString, Map<String, String> paramMap)
    throws IllegalArgumentException, IllegalStateException;
  
  public abstract void setIsActive(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener);
  
  public abstract void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener paramIOnAudioProcessFrameOutputListener);
  
  public abstract void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener);
  
  public abstract void setOnDetailInfoListener(ITPPlayerListener.IOnDetailInfoListener paramIOnDetailInfoListener);
  
  public abstract void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener);
  
  public abstract void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener);
  
  public abstract void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener);
  
  public abstract void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener);
  
  public abstract void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener);
  
  public abstract void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener);
  
  public abstract void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener);
  
  public abstract void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener);
  
  public abstract void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener paramIOnVideoProcessFrameOutputListener);
  
  public abstract void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam);
  
  public abstract void setRichMediaSynchronizer(@Nullable ITPRichMediaSynchronizer paramITPRichMediaSynchronizer);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setSurfaceHolder(SurfaceHolder paramSurfaceHolder);
  
  public abstract void setTPSurface(ITPSurface paramITPSurface);
  
  public abstract void setVideoInfo(TPVideoInfo paramTPVideoInfo);
  
  public abstract void start()
    throws IllegalStateException;
  
  public abstract void stop()
    throws IllegalStateException;
  
  public abstract void stopAsync()
    throws IllegalStateException;
  
  public abstract void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
    throws IllegalStateException;
  
  public abstract void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
    throws IllegalStateException;
  
  public abstract void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo)
    throws IllegalStateException;
  
  public abstract void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
    throws IllegalStateException;
  
  public abstract void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, Map<String, String> paramMap)
    throws IllegalStateException;
  
  public abstract void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, Map<String, String> paramMap, int paramInt)
    throws IllegalStateException;
  
  public abstract void updateLoggerContext(TPLoggerContext paramTPLoggerContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.ITPPlayer
 * JD-Core Version:    0.7.0.1
 */