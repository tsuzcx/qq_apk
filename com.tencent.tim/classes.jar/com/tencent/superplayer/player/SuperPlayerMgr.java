package com.tencent.superplayer.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSubtitleDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.ISuperPlayerPool;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.framecheck.EmptyVideoFrameCheckHelper;
import com.tencent.superplayer.framecheck.FrameComparePipeLine.OnVideoFrameCheckListener;
import com.tencent.superplayer.framecheck.IVideoFrameCheckHelper;
import com.tencent.superplayer.framecheck.VideoFrameCheckHelper;
import com.tencent.superplayer.preload.PreloadPlayerInfo;
import com.tencent.superplayer.preload.PreloadPlayerMgr;
import com.tencent.superplayer.report.ISPReporter;
import com.tencent.superplayer.report.SPReportHelper;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;
import com.tencent.superplayer.view.SPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView.SurfaceObject;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SuperPlayerMgr
  implements ISuperPlayer, FrameComparePipeLine.OnVideoFrameCheckListener, SuperPlayerMgrInternal.SPlayerManagerInternalListener, ISPlayerVideoView.IVideoViewCallBack
{
  private static final String API_CALL_LOG_PREFIX = "api call : ";
  private static final String API_HANDLE_LOG_PREFIX = "api handle : ";
  private static final String FILENAME = "SuperPlayerMgr.java";
  private Context mContext;
  private int mEmergencyTime = 0;
  private int mEmergencyTimeForPrePlay = 0;
  private IVideoFrameCheckHelper mFrameCheckHelper = EmptyVideoFrameCheckHelper.getInstance();
  private HandlerThread mHandlerThread;
  private boolean mIsLoopback = false;
  private boolean mIsOutputMute = false;
  private boolean mIsSeeking = false;
  private SuperPlayerListenerMgr mListenerMgr;
  private Looper mLooper;
  private SuperPlayerState mPlayState;
  private SuperPlayerMgrInternal mPlayerMgrInternal;
  private String mPlayerTag;
  private SuperPlayerWrapper mPlayerWrapper;
  private ISPReporter mReporter = new SPReportHelper();
  private int mSafePlayTime = 0;
  private int mSafePlayTimeForPrePlay = 0;
  private int mSceneId;
  private SPlayerVideoView.SurfaceObject mSurfaceObjectForChange;
  private String mTAG;
  private List<TPOptionalParam> mTPOptionalParamList;
  private String mToken;
  private ISPlayerVideoView mVideoView;
  private int mXYaxis = 0;
  
  public SuperPlayerMgr(Context paramContext, int paramInt, ISPlayerVideoView paramISPlayerVideoView)
  {
    this.mSceneId = paramInt;
    this.mContext = paramContext.getApplicationContext();
    this.mVideoView = paramISPlayerVideoView;
    init();
  }
  
  private String getThreadName()
  {
    return "SuperPlayer-" + this.mPlayerTag + "-" + this.mSceneId;
  }
  
  private void handleOnCompletion()
  {
    this.mPlayState.changeStateAndNotify(7);
  }
  
  private void handleOnError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.mPlayState.changeStateAndNotify(9);
    this.mReporter.onError(paramInt1 + ":" + paramInt3, paramInt1 + ":" + paramInt3 + ":" + paramInt2 + ":" + paramString);
  }
  
  private void handleOnInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 207: 
    case 105: 
    case 112: 
    case 113: 
      do
      {
        do
        {
          do
          {
            return;
          } while (!(paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo));
          this.mReporter.onDownloadProgressUpdate((TPPlayerMsg.TPDownLoadProgressInfo)paramObject);
          return;
          this.mReporter.onFirstVideoFrameRendered();
          this.mFrameCheckHelper.onFirstFrameRendered();
          return;
        } while (this.mIsSeeking);
        this.mReporter.onVideoBufferStart();
        return;
      } while (this.mIsSeeking);
      this.mReporter.onVideoBufferEnd();
      return;
    case 208: 
      if (!(paramObject instanceof TPPlayerMsg.TPMediaCodecInfo)) {
        break;
      }
    }
    for (paramISuperPlayer = (TPPlayerMsg.TPMediaCodecInfo)paramObject; paramISuperPlayer != null; paramISuperPlayer = null)
    {
      this.mReporter.onCodecReuseInfo(paramISuperPlayer);
      return;
      this.mReporter.onVideoFrameCheckResult((int)paramLong1);
      return;
      if ((!(paramObject instanceof String)) || (TextUtils.isEmpty((String)paramObject))) {
        break;
      }
      this.mReporter.onQuicInfoUpdate((String)paramObject);
      return;
      if (!(paramObject instanceof String)) {
        break;
      }
      this.mReporter.onPcdnDownloadFailed((String)paramObject);
      return;
    }
  }
  
  private void handleOnSeekComplete()
  {
    this.mIsSeeking = false;
    this.mReporter.onSeekComplete();
  }
  
  private void handleOnVideoPrepared()
  {
    LogUtil.i(this.mTAG, "handleOnVideoPrepared():");
    this.mPlayState.changeStateAndNotify(4);
    ISPlayerVideoView localISPlayerVideoView = this.mVideoView;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.setFixedSize(getVideoWidth(), getVideoHeight());
    }
    this.mReporter.onPrepared();
  }
  
  private void init()
  {
    initTagAndToken();
    this.mPlayState = new SuperPlayerState(this.mPlayerTag);
    this.mHandlerThread = new HandlerThread(getThreadName());
    this.mHandlerThread.start();
    this.mLooper = this.mHandlerThread.getLooper();
    this.mPlayerMgrInternal = new SuperPlayerMgrInternal(this.mTAG, this.mLooper, this);
    this.mPlayerMgrInternal.setIsNeedBlockMessage(true);
    this.mListenerMgr = new SuperPlayerListenerMgr(this.mPlayerTag);
    if (this.mVideoView != null)
    {
      LogUtil.i(this.mTAG, "updatePlayerVideoView when init, mVideoView = " + this.mVideoView);
      LogUtil.d(this.mTAG, "日志过滤(View): 【" + this.mVideoView.getLogTag() + "】, updatePlayerVideoView when init");
      this.mVideoView.addViewCallBack(this);
    }
    this.mReporter.init(this, this.mSceneId);
    SuperPlayerSDKMgr.getPlayerPool().put(this);
  }
  
  private void initListenerForWrapper()
  {
    WrapperListenerAdapter localWrapperListenerAdapter = new WrapperListenerAdapter(new SuperPlayerListenerCallBack(this, this.mListenerMgr, this.mLooper));
    this.mPlayerWrapper.setOnVideoPreparedListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnCompletionListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnInfoListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnErrorListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnSeekCompleteListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnVideoSizeChangedListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnCaptureImageListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnDefinitionInfoListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnTVideoNetInfoUpdateListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnAudioFrameOutputListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnVideoFrameOutputListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnSubtitleDataListener(localWrapperListenerAdapter);
  }
  
  private void initTagAndToken()
  {
    this.mPlayerTag = CommonUtil.createPlayerTag();
    this.mTAG = (this.mPlayerTag + "-" + "SuperPlayerMgr.java");
    if ((SuperPlayerSDKMgr.getSdkOption() != null) && (SuperPlayerSDKMgr.getSdkOption().isAsyncInit)) {}
    for (this.mToken = (SystemClock.uptimeMillis() + "-" + hashCode());; this.mToken = TVKUtils.getMd5(SystemClock.uptimeMillis() + "-" + Math.random()))
    {
      if ((this.mToken != null) && (this.mToken.length() > 24)) {
        this.mToken = this.mToken.substring(8, 24);
      }
      LogUtil.d(this.mTAG, "initToken:" + this.mToken);
      return;
    }
  }
  
  private void onPlayerOpen(SuperPlayerOption paramSuperPlayerOption)
  {
    if (paramSuperPlayerOption.enableVideoFrameCheck) {
      if ((this.mFrameCheckHelper instanceof VideoFrameCheckHelper)) {
        this.mFrameCheckHelper.onPlayerReset();
      }
    }
    for (;;)
    {
      this.mFrameCheckHelper.setOnVideoFrameCheckListener(this);
      paramSuperPlayerOption = this.mVideoView;
      if ((paramSuperPlayerOption != null) && (paramSuperPlayerOption.isSurfaceReady()))
      {
        this.mPlayerWrapper.setSurface(paramSuperPlayerOption.getSurface());
        this.mFrameCheckHelper.updatePlayerVideoView(paramSuperPlayerOption);
      }
      return;
      this.mFrameCheckHelper = new VideoFrameCheckHelper();
      continue;
      this.mFrameCheckHelper = EmptyVideoFrameCheckHelper.getInstance();
    }
  }
  
  public void addExtReportData(String paramString1, String paramString2)
  {
    this.mReporter.addExtReportData(paramString1, paramString2);
  }
  
  public void addExtReportData(Map<String, String> paramMap)
  {
    this.mReporter.addExtReportData(paramMap);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mPlayerMgrInternal.addSubtitleSource(paramString1, paramString2, paramString3);
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
    throws IllegalStateException, IllegalArgumentException, IllegalAccessException
  {
    LogUtil.i(this.mTAG, "api call : captureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2);
    return this.mPlayerMgrInternal.captureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    throws IllegalStateException, IllegalArgumentException, IllegalAccessException
  {
    LogUtil.i(this.mTAG, "api call : captureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2 + ", requestedTimeMsToleranceBefore:" + paramInt3 + ", requestedTimeMsToleranceAfter:" + paramInt4 + ", requestedTimeLimit:" + paramInt5);
    return this.mPlayerMgrInternal.captureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mPlayerMgrInternal.deselectTrack(paramInt, paramLong);
  }
  
  public int getBufferPercent()
  {
    return this.mPlayerMgrInternal.getBufferPercent();
  }
  
  public int getCurrentPlayerState()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getCurrentPlayerState();
    }
    return 0;
  }
  
  public long getCurrentPositionMs()
  {
    return this.mPlayerMgrInternal.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    return this.mPlayerMgrInternal.getDurationMs();
  }
  
  public long getFileSizeBytes()
  {
    return this.mPlayerMgrInternal.getFileSizeBytes();
  }
  
  public String getFlowId()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getFlowId();
    }
    return null;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.mPlayerMgrInternal.getMediaInfo();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    return this.mPlayerMgrInternal.getProgramInfo();
  }
  
  public String getStreamDumpInfo()
  {
    LogUtil.i(this.mTAG, "api call : getStreamDumpInfo");
    return this.mPlayerMgrInternal.getStreamDumpInfo();
  }
  
  public String getToken()
  {
    return this.mToken;
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    return this.mPlayerMgrInternal.getTrackInfo();
  }
  
  public int getVideoHeight()
  {
    return this.mPlayerMgrInternal.getVideoHeight();
  }
  
  public int getVideoRotation()
  {
    return this.mPlayerMgrInternal.getVideoRotation();
  }
  
  public ISPlayerVideoView getVideoView()
  {
    return this.mVideoView;
  }
  
  public int getVideoWidth()
  {
    return this.mPlayerMgrInternal.getVideoWidth();
  }
  
  public void handleAddSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.addSubtitleSource(paramString1, paramString2, paramString3);
    }
  }
  
  public int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    LogUtil.i(this.mTAG, "api handle : handleCaptureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2);
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.captureImageInTime(paramLong, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    LogUtil.i(this.mTAG, "api handle : handleCaptureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2 + ", requestedTimeMsToleranceBefore:" + paramInt3 + ", requestedTimeMsToleranceAfter:" + paramInt4 + ", requestedTimeLimit:" + paramInt5);
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.captureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    return -1;
  }
  
  public void handleDeselectTrack(int paramInt, long paramLong)
  {
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.deselectTrack(paramInt, paramLong);
    }
  }
  
  public int handleGetBufferPercent()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getBufferPercent();
    }
    return 0;
  }
  
  public long handleGetCurrentPosition()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public long handleGetDuration()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getDurationMs();
    }
    return 0L;
  }
  
  public long handleGetFileSizeBytes()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getFileSizeBytes();
    }
    return 0L;
  }
  
  public MediaInfo handleGetMediaInfo()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getMediaInfo();
    }
    return null;
  }
  
  public TPProgramInfo[] handleGetProgramInfo()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getProgramInfo();
    }
    return null;
  }
  
  public String handleGetStreamDumpInfo()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getStreamDumpInfo();
    }
    return null;
  }
  
  public TPTrackInfo[] handleGetTrackInfo()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getTrackInfo();
    }
    return null;
  }
  
  public int handleGetVideoHeight()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getVideoHeight();
    }
    return 0;
  }
  
  public int handleGetVideoRotation()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getVideoRotation();
    }
    return 0;
  }
  
  public int handleGetVideoWidth()
  {
    if (this.mPlayerWrapper != null) {
      return this.mPlayerWrapper.getVideoWidth();
    }
    return 0;
  }
  
  public boolean handleIsBuffering()
  {
    return (this.mPlayerWrapper != null) && (this.mPlayerWrapper.isBuffering());
  }
  
  public void handleOpenMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    LogUtil.i(this.mTAG, "api handle : handleOpenMediaPlayer, playerVideoInfo:" + paramSuperPlayerVideoInfo + ", startPostionMilsec:" + paramLong);
    if (paramSuperPlayerOption == null) {
      paramSuperPlayerOption = SuperPlayerOption.obtain();
    }
    for (;;)
    {
      int i = 1;
      PreloadPlayerInfo localPreloadPlayerInfo = PreloadPlayerMgr.getInstance().getPlayerFromPool(this.mSceneId, paramSuperPlayerVideoInfo);
      ISPlayerVideoView localISPlayerVideoView = this.mVideoView;
      if (localPreloadPlayerInfo != null)
      {
        LogUtil.i(this.mTAG, "复用预加载播放器, PlayerTag = 【" + localPreloadPlayerInfo.player.getPlayerTag() + "】");
        this.mPlayerWrapper = localPreloadPlayerInfo.player;
        this.mPlayerWrapper.updatePlayerTag(this.mPlayerTag);
        if (localISPlayerVideoView != null) {
          localISPlayerVideoView.changeSurfaceObject(localPreloadPlayerInfo.videoView.getStoredSurfaceObject());
        }
      }
      for (;;)
      {
        initListenerForWrapper();
        this.mPlayerMgrInternal.setIsNeedBlockMessage(false);
        this.mPlayerWrapper.updateIsPreloadingStatus(false);
        this.mPlayerWrapper.setPlayerOptionalParamList(this.mTPOptionalParamList);
        this.mPlayerWrapper.setBusinessDownloadStrategy(this.mEmergencyTime, this.mSafePlayTime, this.mEmergencyTimeForPrePlay, this.mSafePlayTimeForPrePlay);
        if (i == 0)
        {
          onPlayerOpen(paramSuperPlayerOption);
          this.mPlayerWrapper.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, paramSuperPlayerOption);
        }
        return;
        this.mSurfaceObjectForChange = localPreloadPlayerInfo.videoView.getStoredSurfaceObject();
        continue;
        LogUtil.i(this.mTAG, "不复用预加载播放器");
        if (this.mPlayerWrapper == null) {
          this.mPlayerWrapper = new SuperPlayerWrapper(this.mContext, this.mSceneId, this.mPlayerTag, this.mLooper);
        }
        if ((localISPlayerVideoView != null) && (localISPlayerVideoView.isSurfaceReady()))
        {
          this.mPlayerWrapper.setSurface(localISPlayerVideoView.getSurface());
          this.mFrameCheckHelper.updatePlayerVideoView(localISPlayerVideoView);
        }
        i = 0;
      }
    }
  }
  
  public void handlePause()
  {
    LogUtil.i(this.mTAG, "api handle : handlePause:");
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.pause();
    }
  }
  
  public void handlePauseDownload()
  {
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.pauseDownload();
    }
  }
  
  public void handleRelease()
  {
    LogUtil.i(this.mTAG, "api handle : handleRelease:");
    this.mContext = null;
    if (this.mFrameCheckHelper != null) {
      this.mFrameCheckHelper.onPlayerRelease();
    }
    if (this.mListenerMgr != null) {
      this.mListenerMgr.release();
    }
    if (this.mVideoView != null) {
      this.mVideoView.removeViewCallBack(this);
    }
    if (this.mPlayerWrapper != null)
    {
      this.mPlayerWrapper.release();
      this.mPlayerWrapper = null;
    }
    if (this.mHandlerThread != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label110;
      }
      this.mHandlerThread.quitSafely();
    }
    for (;;)
    {
      this.mHandlerThread = null;
      return;
      label110:
      this.mHandlerThread.quit();
    }
  }
  
  public void handleReset()
  {
    LogUtil.i(this.mTAG, "api handle : handleReset:");
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.reset();
    }
    if (this.mFrameCheckHelper != null) {
      this.mFrameCheckHelper.onPlayerReset();
    }
  }
  
  public void handleResumeDownload()
  {
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.resumeDownload();
    }
  }
  
  public void handleSeekTo(int paramInt)
  {
    LogUtil.i(this.mTAG, "api handle : handleSeekTo, positionMilsec:" + paramInt);
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.seekTo(paramInt);
    }
  }
  
  public void handleSeekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.mTAG, "api handle : handleSeekToAccuratePos, positionMilsec:" + paramInt1 + ", mode:" + paramInt2);
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.seekTo(paramInt1, paramInt2);
    }
  }
  
  public void handleSelectProgram(int paramInt, long paramLong)
  {
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.selectProgram(paramInt, paramLong);
    }
  }
  
  public void handleSelectTrack(int paramInt, long paramLong)
  {
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.selectTrack(paramInt, paramLong);
    }
  }
  
  public void handleSetBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mPlayerWrapper != null) {}
    try
    {
      if (this.mPlayerWrapper != null) {
        this.mPlayerWrapper.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e(this.mTAG, localThrowable);
    }
  }
  
  public void handleSetLoopback(boolean paramBoolean)
  {
    LogUtil.i(this.mTAG, "api handle : handleSetLoopback, isLoopback:" + paramBoolean);
    this.mIsLoopback = paramBoolean;
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setLoopback(paramBoolean);
    }
  }
  
  public void handleSetLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    LogUtil.i(this.mTAG, "api handle : handleSetLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
  }
  
  public boolean handleSetOutputMute(boolean paramBoolean)
  {
    LogUtil.i(this.mTAG, "api handle : handleSetOutputMute, isMute:" + paramBoolean);
    this.mIsOutputMute = paramBoolean;
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setOutputMute(paramBoolean);
    }
    return true;
  }
  
  public void handleSetPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.mTAG, "api handle : handleSetPlaySpeedRatio, speedRatio:" + paramFloat);
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setPlaySpeedRatio(paramFloat);
    }
  }
  
  public void handleSetSurface(Surface paramSurface)
  {
    LogUtil.i(this.mTAG, "api handle : handleSetSurface");
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setSurface(paramSurface);
    }
  }
  
  public void handleStart()
  {
    LogUtil.i(this.mTAG, "api handle : handleStart:");
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.start();
    }
    if (this.mFrameCheckHelper != null) {
      this.mFrameCheckHelper.onPlayerStart();
    }
  }
  
  public void handleStop()
  {
    LogUtil.i(this.mTAG, "api handle : handleStop:");
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.stop();
    }
    if (this.mFrameCheckHelper != null) {
      this.mFrameCheckHelper.onPlayerStop();
    }
  }
  
  public void handleSwitchDefinition(String paramString, int paramInt)
  {
    LogUtil.i(this.mTAG, "api handle : handleSwitchDefinition, definition:" + paramString + ", mode:" + paramInt);
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.switchDefinition(paramString, paramInt);
    }
  }
  
  public void handleSwitchDefinitionForUrl(String paramString, int paramInt)
  {
    LogUtil.i(this.mTAG, "api handle : handleSwitchDefinition, url:" + paramString + ", mode:" + paramInt);
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.switchDefinitionForUrl(paramString, paramInt);
    }
  }
  
  public void handleUpdatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    LogUtil.i(this.mTAG, "api handle : handleUpdatePlayerVideoView");
    if (this.mPlayerWrapper != null)
    {
      if ((paramISPlayerVideoView != null) && (paramISPlayerVideoView.isSurfaceReady()))
      {
        this.mPlayerWrapper.setSurface(paramISPlayerVideoView.getSurface());
        this.mFrameCheckHelper.updatePlayerVideoView(paramISPlayerVideoView);
      }
    }
    else {
      return;
    }
    this.mPlayerWrapper.setSurface(null);
    this.mFrameCheckHelper.updatePlayerVideoView(null);
  }
  
  public boolean isBuffering()
  {
    return this.mPlayerMgrInternal.isBuffering();
  }
  
  public boolean isLoopBack()
  {
    return this.mIsLoopback;
  }
  
  public boolean isOutputMute()
  {
    return this.mIsOutputMute;
  }
  
  public boolean isPausing()
  {
    return this.mPlayState.getCurState() == 6;
  }
  
  public boolean isPlaying()
  {
    return this.mPlayState.getCurState() == 5;
  }
  
  public void onPrePlayViewShow()
  {
    this.mReporter.onPrePlayViewShow();
  }
  
  public void onSurfaceChanged(Object paramObject) {}
  
  public void onSurfaceCreated(Object paramObject)
  {
    ISPlayerVideoView localISPlayerVideoView = this.mVideoView;
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder().append("api handle : onSurfaceCreated, mPlayerWrapper=").append(this.mPlayerWrapper).append(", videoView=").append(localISPlayerVideoView).append(", surface=");
    if (localISPlayerVideoView != null) {}
    for (paramObject = localISPlayerVideoView.getSurface();; paramObject = null)
    {
      LogUtil.i(str, paramObject);
      if ((localISPlayerVideoView == null) || (localISPlayerVideoView.getSurface() == null) || (this.mPlayerWrapper == null)) {
        break;
      }
      this.mPlayerWrapper.setSurface(localISPlayerVideoView.getSurface());
      this.mFrameCheckHelper.updatePlayerVideoView(localISPlayerVideoView);
      LogUtil.i(this.mTAG, "onSurfaceCreated view created. mediaPlayer.setSurface:");
      return;
    }
    LogUtil.e(this.mTAG, "onSurfaceCreated view created. mVideoView.getViewSurface() = null");
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    LogUtil.i(this.mTAG, "api handle : onSurfaceDestroy");
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setSurface(null);
    }
  }
  
  public void onVideoFrameCheckResult(int paramInt)
  {
    this.mListenerMgr.onInfo(this, 209, paramInt, 0L, null);
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    LogUtil.i(this.mTAG, "api call : openMediaPlayer, videoInfo:" + paramSuperPlayerVideoInfo + ", startPositionMilsec:" + paramLong);
    if (this.mPlayState.getCurState() != 0)
    {
      LogUtil.e(this.mTAG, "api call : openMediaPlayer, failed, mPlayState.getCurState() =" + this.mPlayState.getCurState());
      return;
    }
    this.mPlayState.changeStateAndNotify(3);
    this.mReporter.onOpenMediaPlayer(paramSuperPlayerVideoInfo, paramLong, null);
    this.mPlayerMgrInternal.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, SuperPlayerOption.obtain());
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    LogUtil.i(this.mTAG, "api call : openMediaPlayer, videoInfo:" + paramSuperPlayerVideoInfo + ", startPositionMilsec:" + paramLong + ", playerOption:" + paramSuperPlayerOption);
    if (this.mPlayState.getCurState() != 0)
    {
      LogUtil.e(this.mTAG, "api call : openMediaPlayer, failed, mPlayState.getCurState() =" + this.mPlayState.getCurState());
      return;
    }
    this.mPlayState.changeStateAndNotify(3);
    this.mReporter.onOpenMediaPlayer(paramSuperPlayerVideoInfo, paramLong, paramSuperPlayerOption);
    this.mPlayerMgrInternal.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, paramSuperPlayerOption);
  }
  
  public void pause()
  {
    LogUtil.i(this.mTAG, "api call : pause");
    this.mPlayState.changeStateAndNotify(6);
    this.mPlayerMgrInternal.pause();
  }
  
  public void pauseDownload()
  {
    LogUtil.i(this.mTAG, "api call : pauseDownload");
    this.mPlayerMgrInternal.pauseDownload();
  }
  
  public void release()
  {
    LogUtil.i(this.mTAG, "api call : release");
    if (this.mPlayState.getCurState() == 10)
    {
      LogUtil.e(this.mTAG, "api call : release, failed, mPlayState.getCurState() == " + this.mPlayState.getCurState());
      return;
    }
    this.mPlayState.changeStateAndNotify(10);
    this.mReporter.onRelease();
    SuperPlayerSDKMgr.getPlayerPool().remove(this);
    this.mPlayerMgrInternal.release();
  }
  
  public void reset()
  {
    LogUtil.i(this.mTAG, "api call : reset");
    if (this.mPlayState.getCurState() == 0)
    {
      LogUtil.e(this.mTAG, "api call : reset, failed, mPlayState.getCurState() =" + this.mPlayState.getCurState());
      return;
    }
    this.mPlayState.changeStateAndNotify(0);
    this.mVideoView = null;
    this.mReporter.reset();
    this.mSurfaceObjectForChange = null;
    this.mTPOptionalParamList = null;
    this.mPlayerMgrInternal.reset();
    this.mPlayerMgrInternal.setIsNeedBlockMessage(true);
  }
  
  public void resumeDownload()
  {
    LogUtil.i(this.mTAG, "api call : resumeDownload");
    this.mPlayerMgrInternal.resumeDownload();
  }
  
  public void seekTo(int paramInt)
  {
    LogUtil.i(this.mTAG, "api call : seekTo, positionMilsec:" + paramInt);
    this.mIsSeeking = true;
    this.mReporter.onSeek(getCurrentPositionMs(), paramInt);
    this.mPlayerMgrInternal.seekTo(paramInt);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.mTAG, "api call : seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    this.mIsSeeking = true;
    this.mReporter.onSeek(getCurrentPositionMs(), paramInt1);
    this.mPlayerMgrInternal.seekTo(paramInt1, paramInt2);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mPlayerMgrInternal.selectProgram(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mPlayerMgrInternal.selectTrack(paramInt, paramLong);
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mEmergencyTime = paramInt1;
    this.mSafePlayTime = paramInt2;
    this.mEmergencyTimeForPrePlay = paramInt3;
    this.mSafePlayTimeForPrePlay = paramInt4;
    this.mPlayerMgrInternal.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + paramBoolean);
    this.mPlayerMgrInternal.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    this.mPlayerMgrInternal.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener paramOnAudioFrameOutputListener)
  {
    this.mListenerMgr.setOnAudioFrameOutputListener(paramOnAudioFrameOutputListener);
  }
  
  public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mListenerMgr.setOnCaptureImageListener(paramOnCaptureImageListener);
  }
  
  public void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mListenerMgr.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    this.mListenerMgr.setOnDefinitionInfoListener(paramOnDefinitionInfoListener);
  }
  
  public void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mListenerMgr.setOnErrorListener(paramOnErrorListener);
  }
  
  public void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mListenerMgr.setOnInfoListener(paramOnInfoListener);
  }
  
  public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mListenerMgr.setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener paramOnSubtitleDataListener)
  {
    this.mListenerMgr.setOnSubtitleDataListener(paramOnSubtitleDataListener);
  }
  
  public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener)
  {
    this.mListenerMgr.setOnTVideoNetVideoInfoListener(paramOnTVideoNetInfoListener);
  }
  
  public void setOnVideoFrameOutputListener(ISuperPlayer.OnVideoFrameOutputListener paramOnVideoFrameOutputListener)
  {
    this.mListenerMgr.setOnVideoOutputFrameListener(paramOnVideoFrameOutputListener);
  }
  
  public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    this.mListenerMgr.setOnVideoPreparedListener(paramOnVideoPreparedListener);
  }
  
  public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mListenerMgr.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    LogUtil.i(this.mTAG, "api call : setOutputMute:" + paramBoolean);
    this.mPlayerMgrInternal.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.mTAG, "api call : setPlaySpeedRatio");
    this.mPlayerMgrInternal.setPlaySpeedRatio(paramFloat);
  }
  
  public void setPlayerActive()
  {
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setPlayerActive();
    }
  }
  
  public void setPlayerOptionalParamList(List<TPOptionalParam> paramList)
  {
    this.mTPOptionalParamList = paramList;
  }
  
  public void setReportContentId(String paramString)
  {
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setReportContentId(paramString);
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    LogUtil.i(this.mTAG, "api call : setSurface");
    this.mPlayerMgrInternal.setSurface(paramSurface);
  }
  
  public void setXYaxis(int paramInt)
  {
    LogUtil.i(this.mTAG, "api call : setXYaxis, type=" + paramInt);
    this.mXYaxis = paramInt;
    if (this.mVideoView != null) {
      this.mVideoView.setXYaxis(paramInt);
    }
  }
  
  public void start()
  {
    LogUtil.i(this.mTAG, "api call : start");
    this.mPlayState.changeStateAndNotify(5);
    this.mReporter.onStart();
    this.mPlayerMgrInternal.start();
  }
  
  public void stop()
  {
    LogUtil.i(this.mTAG, "api call : stop");
    if ((this.mPlayState.getCurState() == 8) || (this.mPlayState.getCurState() == 0) || (this.mPlayState.getCurState() == 10))
    {
      LogUtil.e(this.mTAG, "api call : stop, failed, mPlayState.getCurState() == " + this.mPlayState.getCurState());
      return;
    }
    this.mPlayState.changeStateAndNotify(8);
    this.mReporter.onStop();
    this.mPlayerMgrInternal.stop();
  }
  
  public void switchDefinition(String paramString, int paramInt)
  {
    LogUtil.i(this.mTAG, "api call : switchDefinition, definition:" + paramString + ", mode:" + paramInt);
    this.mPlayerMgrInternal.switchDefinition(paramString, paramInt);
  }
  
  public void switchDefinitionForUrl(String paramString, int paramInt)
  {
    LogUtil.i(this.mTAG, "api call : switchDefinitionForUrl, url:" + paramString + ", mode:" + paramInt);
    this.mPlayerMgrInternal.switchDefinitionForUrl(paramString, paramInt);
  }
  
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder().append("api call : updatePlayerVideoView, mVideoView == videoView is ");
    if (this.mVideoView == paramISPlayerVideoView) {}
    for (boolean bool = true;; bool = false)
    {
      LogUtil.i(str, bool + ", videoView=" + paramISPlayerVideoView);
      if (paramISPlayerVideoView != null) {
        LogUtil.d(this.mTAG, "日志过滤(View): 【" + paramISPlayerVideoView.getLogTag() + "】, updatePlayerVideoView");
      }
      if (this.mVideoView != paramISPlayerVideoView) {
        break;
      }
      return;
    }
    if (this.mVideoView != null) {
      this.mVideoView.removeViewCallBack(null);
    }
    this.mVideoView = paramISPlayerVideoView;
    if (this.mVideoView != null)
    {
      this.mVideoView.addViewCallBack(this);
      this.mVideoView.setXYaxis(this.mXYaxis);
    }
    if (this.mSurfaceObjectForChange != null)
    {
      if (this.mVideoView != null) {
        this.mVideoView.changeSurfaceObject(this.mSurfaceObjectForChange);
      }
      this.mSurfaceObjectForChange = null;
      return;
    }
    this.mPlayerMgrInternal.updatePlayerVideoView(paramISPlayerVideoView);
  }
  
  static class WrapperListenerAdapter
    implements ListenerCombine.ISuperPlayerCombine
  {
    private SuperPlayerListenerCallBack mMgrCallBack;
    
    public WrapperListenerAdapter(SuperPlayerListenerCallBack paramSuperPlayerListenerCallBack)
    {
      this.mMgrCallBack = paramSuperPlayerListenerCallBack;
    }
    
    public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      this.mMgrCallBack.onAudioFrameOutput(paramTPAudioFrameBuffer);
    }
    
    public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
    {
      this.mMgrCallBack.onCaptureImageFailed(paramISuperPlayer, paramInt1, paramInt2);
    }
    
    public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
    {
      this.mMgrCallBack.onCaptureImageSucceed(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
    
    public void onCompletion(ISuperPlayer paramISuperPlayer)
    {
      if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
        ((SuperPlayerMgr)this.mMgrCallBack.getPlayer()).handleOnCompletion();
      }
      this.mMgrCallBack.onCompletion(paramISuperPlayer);
    }
    
    public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList)
    {
      this.mMgrCallBack.onDefinitionInfoUpdate(paramISuperPlayer, paramString, paramArrayList);
    }
    
    public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
        ((SuperPlayerMgr)this.mMgrCallBack.getPlayer()).handleOnError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
      }
      return this.mMgrCallBack.onError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    }
    
    public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
        ((SuperPlayerMgr)this.mMgrCallBack.getPlayer()).handleOnInfo(paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
      }
      return this.mMgrCallBack.onInfo(paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    }
    
    public void onSeekComplete(ISuperPlayer paramISuperPlayer)
    {
      if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
        ((SuperPlayerMgr)this.mMgrCallBack.getPlayer()).handleOnSeekComplete();
      }
      this.mMgrCallBack.onSeekComplete(paramISuperPlayer);
    }
    
    public void onSubtitleData(ISuperPlayer paramISuperPlayer, TPSubtitleData paramTPSubtitleData)
    {
      this.mMgrCallBack.onSubtitleData(paramISuperPlayer, paramTPSubtitleData);
    }
    
    public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
    {
      this.mMgrCallBack.onTVideoNetInfoUpdate(paramISuperPlayer, paramTVideoNetInfo);
    }
    
    public void onVideoFrameOutput(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      this.mMgrCallBack.onVideoFrameOutput(paramTPVideoFrameBuffer);
    }
    
    public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
    {
      if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
        ((SuperPlayerMgr)this.mMgrCallBack.getPlayer()).handleOnVideoPrepared();
      }
      this.mMgrCallBack.onVideoPrepared(paramISuperPlayer);
    }
    
    public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
    {
      this.mMgrCallBack.onVideoSizeChanged(paramISuperPlayer, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgr
 * JD-Core Version:    0.7.0.1
 */