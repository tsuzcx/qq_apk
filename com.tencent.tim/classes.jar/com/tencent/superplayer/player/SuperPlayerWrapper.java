package com.tencent.superplayer.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
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
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerMsg;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.utils.CodecReuseHelper;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.TVideoUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.api.report.TPLiveReportInfo;
import com.tencent.thumbplayer.api.report.TPVodReportInfo;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class SuperPlayerWrapper
  implements ISuperPlayer, ISuperPlayerState
{
  private static final String API_CALL_LOG_PREFIX = "api call : ";
  private static final String FILENAME = "SuperPlayerWrapper.java";
  private static final String LISTENER_CALL_LOG_PREFIX = "inner listener called : ";
  private AtomicInteger mCaptureId = new AtomicInteger();
  private Context mContext;
  private String mFlowId;
  private boolean mIsBuffering;
  private boolean mIsLoopback;
  private boolean mIsOutputMute;
  private boolean mIsSwitchingTVideoDefn;
  private SuperPlayerListenerCallBack mListenerCallback;
  private SuperPlayerListenerMgr mListenerMgr;
  private Looper mLooper;
  private MediaInfo mMediaInfo;
  private SuperPlayerState mPlayState;
  private SuperPlayerOption mPlayerOption = SuperPlayerOption.obtain();
  private String mPlayerTag;
  private TPDefaultReportInfo mReportInfo;
  private int mSceneId = -1;
  private long mSkipEndMilSec;
  private long mStartPositionMilSec;
  private Surface mSurface;
  private final AtomicInteger mSwitchDefnId = new AtomicInteger(1);
  private String mTAG;
  private List<TPOptionalParam> mTPOptionalParamList;
  private ITPPlayer mTPPlayer;
  private TPPlayerListenerAdapter mTPPlayerListenerAdapter;
  private int mTVdieoSwitchDefnMode;
  private VInfoGetter mVInfoGetter;
  private SuperPlayerVideoInfo mVideoInfo;
  
  public SuperPlayerWrapper(Context paramContext, int paramInt, String paramString, Looper paramLooper)
  {
    this.mPlayerTag = paramString;
    this.mTAG = (paramString + "-" + "SuperPlayerWrapper.java");
    this.mContext = paramContext.getApplicationContext();
    this.mSceneId = paramInt;
    this.mLooper = paramLooper;
    init();
  }
  
  private void init()
  {
    this.mTPPlayer = TPPlayerFactory.createTPPlayer(this.mContext, this.mLooper, this.mLooper);
    this.mPlayState = new SuperPlayerState(this.mPlayerTag);
    this.mListenerMgr = new SuperPlayerListenerMgr(this.mPlayerTag);
    this.mListenerCallback = new SuperPlayerListenerCallBack(this, this.mListenerMgr, this.mLooper);
    this.mTPPlayerListenerAdapter = new TPPlayerListenerAdapter(this.mListenerCallback);
    CommonUtil.initDataTransportDataFolder(CommonUtil.getDownloadProxyServiceType(this.mSceneId));
    this.mTPPlayer.getPlayerProxy().setProxyServiceType(CommonUtil.getDownloadProxyServiceType(this.mSceneId));
    this.mTPPlayer.setOnPreparedListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnCompletionListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnInfoListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnErrorListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnSeekCompleteListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnVideoSizeChangedListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnVideoFrameOutListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnAudioFrameOutputListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnSubtitleDataListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.addPlugin(new SuperPlayerWrapper.1(this));
    this.mVInfoGetter = new VInfoGetter(this.mContext, this.mLooper);
    this.mVInfoGetter.setListener(this.mTPPlayerListenerAdapter);
  }
  
  private void innerConfigPlayerOption(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramSuperPlayerOption.enableDownloadProxy != null) {
      bool1 = paramSuperPlayerOption.enableDownloadProxy.booleanValue();
    }
    for (;;)
    {
      if (!bool1) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(205, false));
      }
      this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(100, this.mStartPositionMilSec));
      if (this.mStartPositionMilSec > 0L) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(101, this.mPlayerOption.accurateSeekOnOpen));
      }
      this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(500, this.mSkipEndMilSec));
      if (this.mPlayerOption.enableVideoFrameOutput)
      {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(119, true));
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(203, 3L));
      }
      if (this.mPlayerOption.enableAudioFrameOutput)
      {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(120, true));
        setAudioOutputParmasInternal(this.mPlayerOption.audioFrameOutputOption);
      }
      paramSuperPlayerVideoInfo = this.mTPPlayer;
      TPOptionalParam localTPOptionalParam = new TPOptionalParam();
      if ((this.mPlayerOption.enableCodecReuse) && (CodecReuseHelper.get().isDeviceSupport())) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramSuperPlayerVideoInfo.setPlayerOptionalParam(localTPOptionalParam.buildBoolean(123, bool1));
        if (paramSuperPlayerOption.bufferPacketMinTotalDurationMs > 0L) {
          this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, paramSuperPlayerOption.bufferPacketMinTotalDurationMs));
        }
        if (paramSuperPlayerOption.preloadPacketDurationMs > 0L) {
          this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(103, paramSuperPlayerOption.preloadPacketDurationMs));
        }
        if (paramSuperPlayerOption.minBufferingPacketDurationMs > 0L) {
          this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(104, paramSuperPlayerOption.minBufferingPacketDurationMs));
        }
        if (this.mTPOptionalParamList == null) {
          break label496;
        }
        paramSuperPlayerVideoInfo = this.mTPOptionalParamList.iterator();
        while (paramSuperPlayerVideoInfo.hasNext())
        {
          paramSuperPlayerOption = (TPOptionalParam)paramSuperPlayerVideoInfo.next();
          this.mTPPlayer.setPlayerOptionalParam(paramSuperPlayerOption);
        }
        if ((paramSuperPlayerVideoInfo.getVideoSource() == 3) && (paramSuperPlayerVideoInfo.getFormat() == 201))
        {
          bool1 = false;
          break;
        }
        if ((paramSuperPlayerVideoInfo.getFormat() != 103) && (paramSuperPlayerVideoInfo.getFormat() != 202) && (paramSuperPlayerVideoInfo.getFormat() != 204)) {
          break label497;
        }
        bool1 = false;
        break;
      }
      label496:
      return;
      label497:
      bool1 = true;
    }
  }
  
  private void innerDoOpenMediaPlayer(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    boolean bool = false;
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder().append("api call : innerDoOpenMediaPlayer mSurface == null is ");
    if (this.mSurface == null) {
      bool = true;
    }
    LogUtil.i((String)localObject, bool);
    for (;;)
    {
      try
      {
        localObject = new TPVideoInfo.Builder();
        ((TPVideoInfo.Builder)localObject).fileId(CommonUtil.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo));
        ((TPVideoInfo.Builder)localObject).downloadParam(innerInitDownloadParamData(paramSuperPlayerVideoInfo, paramSuperPlayerOption));
        this.mTPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject).build());
        innerConfigPlayerOption(paramSuperPlayerVideoInfo, paramSuperPlayerOption);
        if (paramSuperPlayerOption.isPrePlay) {
          this.mTPPlayer.setIsActive(false);
        }
        if (paramSuperPlayerVideoInfo.getFormat() == 303)
        {
          this.mTPPlayer.setDataSource(TVideoUtil.createTPMediaAsset(paramSuperPlayerVideoInfo));
          if (this.mSurface != null) {
            this.mTPPlayer.setSurface(this.mSurface);
          }
          this.mTPPlayer.prepareAsync();
          return;
        }
        if (paramSuperPlayerVideoInfo.getMediaAssert() != null) {
          this.mTPPlayer.setDataSource(paramSuperPlayerVideoInfo.getMediaAssert());
        } else {
          this.mTPPlayer.setDataSource(paramSuperPlayerVideoInfo.getPlayUrl(), paramSuperPlayerOption.httpHeader);
        }
      }
      catch (IOException paramSuperPlayerVideoInfo)
      {
        LogUtil.e(this.mTAG, "handleOpenMediaPlayerByUrl:" + paramSuperPlayerVideoInfo.getMessage());
        return;
      }
    }
  }
  
  private boolean innerHandleInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 502: 
      if (!(paramObject instanceof TPPlayerMsg.TPMediaCodecInfo)) {
        break;
      }
    }
    for (paramObject = (TPPlayerMsg.TPMediaCodecInfo)paramObject; paramObject != null; paramObject = null)
    {
      LogUtil.i(this.mTAG, "innerHandleInfo mediaCodecInfo mediaType:" + paramObject.mediaType + ", infoType:" + paramObject.infoType + " ,msg:" + paramObject.msg);
      return false;
      this.mIsBuffering = true;
      return false;
      this.mIsBuffering = false;
      return false;
    }
  }
  
  private TPDownloadParamData innerInitDownloadParamData(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    Object localObject2 = paramSuperPlayerVideoInfo.getTPDownloadParamData();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new TPDownloadParamData();
    }
    ((TPDownloadParamData)localObject1).setDlType(parseDownloadType(paramSuperPlayerVideoInfo));
    ((TPDownloadParamData)localObject1).setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    localObject2 = new ArrayList();
    if (paramSuperPlayerVideoInfo.getPlayUrls() != null) {
      Collections.addAll((Collection)localObject2, paramSuperPlayerVideoInfo.getPlayUrls());
    }
    ((TPDownloadParamData)localObject1).setUrlCdnidList((ArrayList)localObject2, CommonUtil.createHttpHeaderForAllUrl(paramSuperPlayerVideoInfo));
    ((TPDownloadParamData)localObject1).setFileDuration(paramSuperPlayerVideoInfo.getVideoDurationMs());
    if (SuperPlayerSDKMgr.hasDeviceId()) {
      if (!paramSuperPlayerOption.superPlayerDownOption.enableP2P) {
        break label355;
      }
    }
    label355:
    for (int i = 1;; i = 0)
    {
      ((TPDownloadParamData)localObject1).setFp2p(i);
      ((TPDownloadParamData)localObject1).setFlowId(UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform());
      localObject2 = ((TPDownloadParamData)localObject1).getExtInfoMap();
      paramSuperPlayerVideoInfo = (SuperPlayerVideoInfo)localObject2;
      if (localObject2 == null) {
        paramSuperPlayerVideoInfo = new HashMap();
      }
      paramSuperPlayerVideoInfo.put("dl_param_quic_enable_mode", Integer.valueOf(paramSuperPlayerOption.superPlayerDownOption.quicEnableMode));
      paramSuperPlayerVideoInfo.put("dl_param_is_enable_quic_plaintext", Boolean.valueOf(paramSuperPlayerOption.superPlayerDownOption.enableQuicPlaintext));
      paramSuperPlayerVideoInfo.put("dl_param_is_enable_quic_connection_migration", Boolean.valueOf(paramSuperPlayerOption.superPlayerDownOption.enableQuicConnectionMigration));
      paramSuperPlayerVideoInfo.put("dl_param_quic_congestion_type", Integer.valueOf(paramSuperPlayerOption.superPlayerDownOption.quicCongestionType));
      paramSuperPlayerVideoInfo.put("dl_param_enable_teg_pcdn", Boolean.valueOf(paramSuperPlayerOption.superPlayerDownOption.enablePcdn));
      if ((paramSuperPlayerOption.bufferPacketMinTotalDurationMs > 0L) && (paramSuperPlayerOption.enableListenerPlayerBuffer)) {
        paramSuperPlayerVideoInfo.put("dl_param_player_buffer_total_duration", Long.valueOf(paramSuperPlayerOption.bufferPacketMinTotalDurationMs / 1000L));
      }
      paramSuperPlayerVideoInfo.put("dl_param_bandwidth_stats_enable", Boolean.valueOf(paramSuperPlayerOption.enableBandwidthStats));
      paramSuperPlayerVideoInfo.put("dl_param_bandwidth_stats_host", paramSuperPlayerOption.bandwidthReportHost);
      ((TPDownloadParamData)localObject1).setExtInfoMap(paramSuperPlayerVideoInfo);
      return localObject1;
    }
  }
  
  private void internalInitMediaInfo()
  {
    if ((this.mPlayState.getCurState() != 4) && (this.mPlayState.getCurState() != 5) && (this.mPlayState.getCurState() != 6)) {}
    do
    {
      do
      {
        return;
      } while ((this.mMediaInfo != null) || (this.mTPPlayer == null));
      localObject = this.mTPPlayer.getPropertyString(0);
    } while (localObject == null);
    Object localObject = MediaInfo.obtainMediaInfoFromString(this.mPlayerTag, (String)localObject);
    ((MediaInfo)localObject).setDurationMs(this.mTPPlayer.getDurationMs());
    ((MediaInfo)localObject).setVideoRotation((int)this.mTPPlayer.getPropertyLong(205));
    ((MediaInfo)localObject).setVideoFps((int)this.mTPPlayer.getPropertyLong(206));
    this.mMediaInfo = ((MediaInfo)localObject);
  }
  
  private void internalReset()
  {
    this.mMediaInfo = null;
    this.mIsLoopback = false;
    this.mIsOutputMute = false;
    this.mIsBuffering = false;
    this.mSkipEndMilSec = 0L;
    this.mStartPositionMilSec = 0L;
    this.mVideoInfo = null;
    this.mTPOptionalParamList = null;
    this.mPlayerOption = SuperPlayerOption.obtain();
  }
  
  private int parseDownloadType(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (paramSuperPlayerVideoInfo == null) {
      return 0;
    }
    switch (paramSuperPlayerVideoInfo.getFormat())
    {
    default: 
      return 0;
    case 101: 
    case 301: 
      return 1;
    case 201: 
    case 401: 
      return 5;
    case 102: 
    case 302: 
      return 3;
    case 104: 
    case 107: 
      return 10;
    case 202: 
    case 402: 
      return 12;
    }
    return 2;
  }
  
  private void setAudioOutputParmasInternal(SuperPlayerAudioInfo paramSuperPlayerAudioInfo)
  {
    if (paramSuperPlayerAudioInfo == null) {}
    int i;
    do
    {
      return;
      i = paramSuperPlayerAudioInfo.getAudioSampleRateHZ();
      if (i > 0) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(350, i));
      }
      i = paramSuperPlayerAudioInfo.getAuidoOutPutFormat();
      if (i >= 0) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(351, i));
      }
      long l = paramSuperPlayerAudioInfo.getAudioChannelLayout();
      if (l > 0L) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(352, l));
      }
      i = paramSuperPlayerAudioInfo.getAudioSampleFrameSize();
    } while (i <= 0);
    this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(353, i));
  }
  
  private void setReportInfo(int paramInt)
  {
    if (CommonUtil.isLiveFormat(paramInt)) {}
    for (this.mReportInfo = new TPLiveReportInfo();; this.mReportInfo = new TPVodReportInfo())
    {
      this.mReportInfo.scenesId = this.mSceneId;
      this.mTPPlayer.getReportManager().setReportInfoGetter(this.mReportInfo);
      return;
    }
  }
  
  public void addExtReportData(String paramString1, String paramString2) {}
  
  public void addExtReportData(Map<String, String> paramMap) {}
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mTPPlayer.addSubtitleSource(paramString1, paramString2, paramString3);
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    TPCaptureParams localTPCaptureParams = new TPCaptureParams();
    localTPCaptureParams.requestedTimeMs = paramLong;
    localTPCaptureParams.width = paramInt1;
    localTPCaptureParams.height = paramInt2;
    localTPCaptureParams.format = 37;
    localTPCaptureParams.requestedTimeMsToleranceBefore = 0L;
    localTPCaptureParams.requestedTimeMsToleranceAfter = 0L;
    paramInt1 = this.mCaptureId.incrementAndGet();
    this.mTPPlayerListenerAdapter.setCaptureListener(new WrapperIdCaptureListener(paramInt1));
    this.mTPPlayer.captureVideo(localTPCaptureParams, this.mTPPlayerListenerAdapter);
    return paramInt1;
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    TPCaptureParams localTPCaptureParams = new TPCaptureParams();
    localTPCaptureParams.requestedTimeMs = paramLong;
    localTPCaptureParams.width = paramInt1;
    localTPCaptureParams.height = paramInt2;
    localTPCaptureParams.format = 37;
    localTPCaptureParams.requestedTimeMsToleranceBefore = paramInt3;
    localTPCaptureParams.requestedTimeMsToleranceAfter = paramInt4;
    paramInt1 = this.mCaptureId.incrementAndGet();
    this.mTPPlayerListenerAdapter.setCaptureListener(new WrapperIdCaptureListener(paramInt1));
    this.mTPPlayer.captureVideo(localTPCaptureParams, this.mTPPlayerListenerAdapter);
    return paramInt1;
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mTPPlayer.deselectTrack(paramInt, paramLong);
  }
  
  public int getBufferPercent()
  {
    return this.mTPPlayer.getBufferPercent();
  }
  
  public int getCurrentPlayerState()
  {
    return this.mPlayState.getCurState();
  }
  
  public long getCurrentPositionMs()
  {
    return this.mTPPlayer.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    MediaInfo localMediaInfo = this.mMediaInfo;
    if ((localMediaInfo != null) && (localMediaInfo.getDurationMs() > 0L)) {
      return localMediaInfo.getDurationMs();
    }
    return this.mTPPlayer.getDurationMs();
  }
  
  public long getFileSizeBytes()
  {
    return this.mTPPlayer.getFileSizeBytes();
  }
  
  public String getFlowId()
  {
    return this.mFlowId;
  }
  
  public MediaInfo getMediaInfo()
  {
    internalInitMediaInfo();
    return this.mMediaInfo;
  }
  
  public String getPlayerTag()
  {
    return this.mPlayerTag;
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    return this.mTPPlayer.getProgramInfo();
  }
  
  public String getStreamDumpInfo()
  {
    internalInitMediaInfo();
    MediaInfo localMediaInfo = this.mMediaInfo;
    if (localMediaInfo != null) {
      return localMediaInfo.getMediaInfoStr();
    }
    return null;
  }
  
  public String getToken()
  {
    return null;
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    return this.mTPPlayer.getTrackInfo();
  }
  
  public int getVideoHeight()
  {
    MediaInfo localMediaInfo = this.mMediaInfo;
    if ((localMediaInfo != null) && (localMediaInfo.getVideoHeight() > 0)) {
      return localMediaInfo.getVideoHeight();
    }
    return this.mTPPlayer.getVideoHeight();
  }
  
  public int getVideoRotation()
  {
    internalInitMediaInfo();
    MediaInfo localMediaInfo = this.mMediaInfo;
    if (localMediaInfo != null) {
      return localMediaInfo.getVideoRotation();
    }
    return 0;
  }
  
  @Deprecated
  public ISPlayerVideoView getVideoView()
  {
    return null;
  }
  
  public int getVideoWidth()
  {
    MediaInfo localMediaInfo = this.mMediaInfo;
    if ((localMediaInfo != null) && (localMediaInfo.getVideoWidth() > 0)) {
      return localMediaInfo.getVideoWidth();
    }
    return this.mTPPlayer.getVideoWidth();
  }
  
  public boolean isBuffering()
  {
    return this.mIsBuffering;
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
  
  @Deprecated
  public void onPrePlayViewShow() {}
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, SuperPlayerOption.obtain());
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    this.mStartPositionMilSec = paramLong;
    this.mVideoInfo = paramSuperPlayerVideoInfo;
    this.mPlayerOption = paramSuperPlayerOption;
    switch (paramSuperPlayerVideoInfo.getVideoSource())
    {
    }
    for (;;)
    {
      setReportInfo(paramSuperPlayerVideoInfo.getFormat());
      return;
      this.mPlayState.changeStateAndNotify(1);
      this.mVInfoGetter.doGetVInfo(paramSuperPlayerVideoInfo);
      continue;
      this.mPlayState.changeStateAndNotify(2);
      innerDoOpenMediaPlayer(paramSuperPlayerVideoInfo, this.mPlayerOption);
    }
  }
  
  public void pause()
    throws IllegalStateException
  {
    LogUtil.i(this.mTAG, "api call : pause");
    this.mTPPlayer.pause();
    this.mPlayState.changeStateAndNotify(6);
  }
  
  public void pauseDownload()
  {
    this.mTPPlayer.pauseDownload();
  }
  
  public void release()
  {
    LogUtil.i(this.mTAG, "api call : release");
    internalReset();
    this.mContext = null;
    this.mSurface = null;
    this.mLooper = null;
    this.mTPPlayer.release();
    this.mListenerMgr.release();
    this.mVInfoGetter.setListener(null);
    this.mPlayState.changeStateAndNotify(10);
  }
  
  public void reset()
    throws IllegalStateException
  {
    LogUtil.i(this.mTAG, "api call : reset");
    internalReset();
    this.mTPPlayer.reset();
    this.mPlayState.changeStateAndNotify(0);
  }
  
  public void resumeDownload()
  {
    this.mTPPlayer.resumeDownload();
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    LogUtil.i(this.mTAG, "api call : seekTo, positionMs:" + paramInt);
    try
    {
      this.mTPPlayer.seekTo(paramInt);
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(this.mTAG, "api call : seekTo, positionMs:" + paramInt + ", error = " + localException.toString());
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.mTAG, "api call : seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    try
    {
      this.mTPPlayer.seekTo(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(this.mTAG, "api call : seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2 + ", error = " + localException.toString());
    }
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mTPPlayer.selectProgram(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mTPPlayer.selectTrack(paramInt, paramLong);
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mTPPlayer.setBusinessDownloadStrategy(CommonUtil.getDownloadProxyServiceType(this.mSceneId), paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + paramBoolean);
    this.mIsLoopback = paramBoolean;
    this.mTPPlayer.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    this.mIsLoopback = paramBoolean;
    this.mTPPlayer.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener paramOnAudioFrameOutputListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnAudioPcmOutputListener");
    this.mListenerMgr.setOnAudioFrameOutputListener(paramOnAudioFrameOutputListener);
  }
  
  public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mListenerMgr.setOnCaptureImageListener(paramOnCaptureImageListener);
  }
  
  public void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnCompletionListener");
    this.mListenerMgr.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    this.mListenerMgr.setOnDefinitionInfoListener(paramOnDefinitionInfoListener);
  }
  
  public void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnErrorListener");
    this.mListenerMgr.setOnErrorListener(paramOnErrorListener);
  }
  
  public void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnInfoListener");
    this.mListenerMgr.setOnInfoListener(paramOnInfoListener);
  }
  
  public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnSeekCompleteListener");
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
    LogUtil.i(this.mTAG, "api call : setOnVideoFrameOutListener");
    this.mListenerMgr.setOnVideoOutputFrameListener(paramOnVideoFrameOutputListener);
  }
  
  public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnPreparedListener");
    this.mListenerMgr.setOnVideoPreparedListener(paramOnVideoPreparedListener);
  }
  
  public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnVideoSizeChangedListener");
    this.mListenerMgr.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    LogUtil.i(this.mTAG, "api call : setOutputMute, isOutputMute:" + paramBoolean);
    this.mIsOutputMute = paramBoolean;
    this.mTPPlayer.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.mTAG, "api call : setPlaySpeedRatio, speedRatio:" + paramFloat);
    this.mTPPlayer.setPlaySpeedRatio(paramFloat);
  }
  
  public void setPlayerActive()
  {
    if ((this.mPlayerOption != null) && (this.mPlayerOption.isPrePlay)) {
      this.mTPPlayer.setIsActive(true);
    }
  }
  
  public void setPlayerOptionalParamList(List<TPOptionalParam> paramList)
  {
    this.mTPOptionalParamList = paramList;
  }
  
  public void setReportContentId(String paramString)
  {
    if (this.mReportInfo != null) {
      this.mReportInfo.vid = paramString;
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder().append("api call : setSurface, surface = ").append(paramSurface).append(", mSurface == surface is ");
    if (this.mSurface == paramSurface) {}
    for (boolean bool = true;; bool = false)
    {
      LogUtil.i(str, bool);
      this.mSurface = paramSurface;
      if (this.mTPPlayer != null) {
        this.mTPPlayer.setSurface(paramSurface);
      }
      return;
    }
  }
  
  @Deprecated
  public void setXYaxis(int paramInt) {}
  
  public void start()
    throws IllegalStateException
  {
    LogUtil.i(this.mTAG, "api call : start");
    if ((this.mPlayerOption != null) && (this.mPlayerOption.isPrePlay)) {
      this.mTPPlayer.setIsActive(true);
    }
    this.mTPPlayer.start();
    this.mPlayState.changeStateAndNotify(5);
  }
  
  public void stop()
    throws IllegalStateException
  {
    LogUtil.i(this.mTAG, "api call : stop");
    if (this.mPlayState.getCurState() == 8)
    {
      LogUtil.e(this.mTAG, "api call : stop, failed, mPlayState.getCurState() == ISuperPlayerState.STOPPED");
      return;
    }
    this.mTPPlayer.stop();
    this.mPlayState.changeStateAndNotify(8);
  }
  
  public void switchDefinition(String paramString, int paramInt)
  {
    if ((this.mVideoInfo == null) || (this.mVideoInfo.getVideoSource() != 1))
    {
      LogUtil.e(this.mTAG, "api call : switchDefinition error, videoInfo invalid");
      return;
    }
    if (this.mIsSwitchingTVideoDefn)
    {
      LogUtil.e(this.mTAG, "api call : switchDefinition error, is switching defn");
      return;
    }
    this.mIsSwitchingTVideoDefn = true;
    this.mTVdieoSwitchDefnMode = paramInt;
    this.mVideoInfo.setRequestDefinition(paramString);
    this.mVInfoGetter.doGetVInfo(this.mVideoInfo);
  }
  
  public void switchDefinitionForUrl(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mTPPlayer.switchDefinition(paramString, this.mSwitchDefnId.getAndIncrement(), null, paramInt);
    }
  }
  
  public void updateIsPreloadingStatus(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mListenerCallback.setIsBlockCallback(true);
      return;
    }
    this.mListenerCallback.setIsBlockCallback(false);
  }
  
  void updatePlayerTag(String paramString)
  {
    LogUtil.i(this.mTAG, "【Important】 updatePlayerTag from 【" + this.mPlayerTag + "】 to 【" + paramString + "】");
    this.mPlayerTag = paramString;
    this.mTAG = (paramString + "-" + "SuperPlayerWrapper.java");
    this.mPlayState.updatePlayerTag(this.mPlayerTag);
    this.mListenerMgr.updatePlayerTag(this.mPlayerTag);
  }
  
  @Deprecated
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView) {}
  
  class TPPlayerListenerAdapter
    implements ListenerCombine.ITPPlayerCombine
  {
    private SuperPlayerWrapper.WrapperIdCaptureListener mCaptureListener;
    private SuperPlayerListenerCallBack mWrapperCallback;
    
    TPPlayerListenerAdapter(SuperPlayerListenerCallBack paramSuperPlayerListenerCallBack)
    {
      this.mWrapperCallback = paramSuperPlayerListenerCallBack;
    }
    
    public void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      this.mWrapperCallback.onAudioFrameOutput(paramTPAudioFrameBuffer);
    }
    
    public void onCaptureVideoFailed(int paramInt)
    {
      if (this.mCaptureListener != null) {
        this.mCaptureListener.onCaptureVideoFailed(paramInt);
      }
    }
    
    public void onCaptureVideoSuccess(Bitmap paramBitmap)
    {
      if (this.mCaptureListener != null) {
        this.mCaptureListener.onCaptureVideoSuccess(paramBitmap);
      }
    }
    
    public void onCompletion(ITPPlayer paramITPPlayer)
    {
      LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onCompletion");
      SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(7);
      this.mWrapperCallback.onCompletion(SuperPlayerWrapper.this);
    }
    
    public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      LogUtil.e(SuperPlayerWrapper.this.mTAG, "inner listener called : onError, errorType:" + paramInt1 + ", errorCode:" + paramInt2 + ", arg1:" + paramLong1 + ", arg2:" + paramLong2);
      SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(9);
      this.mWrapperCallback.onError(SuperPlayerWrapper.this, 1, paramInt1, paramInt2, paramLong1 + ":" + paramLong2);
    }
    
    public void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt1, int paramInt2, String paramString)
    {
      LogUtil.e(SuperPlayerWrapper.this.mTAG, "inner listener called : onGetVInfoFailed:" + paramInt2 + "+" + paramString);
      if (SuperPlayerWrapper.this.mIsSwitchingTVideoDefn)
      {
        SuperPlayerWrapper.access$502(SuperPlayerWrapper.this, false);
        return;
      }
      if (this.mWrapperCallback != null) {
        this.mWrapperCallback.onError(SuperPlayerWrapper.this, 2, paramInt1, paramInt2, paramString);
      }
      SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(9);
    }
    
    public void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
    {
      LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onGetVInfoSuccess:" + paramSuperPlayerVideoInfo);
      SuperPlayerVideoInfo localSuperPlayerVideoInfo = SuperPlayerWrapper.this.mVideoInfo;
      if ((localSuperPlayerVideoInfo == null) || (paramSuperPlayerVideoInfo == null)) {}
      for (;;)
      {
        return;
        if ((SuperPlayerWrapper.this.mPlayState.getCurState() != 0) && (SuperPlayerWrapper.this.mPlayState.getCurState() != 10) && (SuperPlayerWrapper.this.mPlayState.getCurState() != 9))
        {
          if (SuperPlayerWrapper.this.mIsSwitchingTVideoDefn) {
            for (;;)
            {
              try
              {
                if (paramSuperPlayerVideoInfo.getFormat() != 303) {
                  continue;
                }
                paramSuperPlayerVideoInfo = TVideoUtil.createTPMediaAsset(paramSuperPlayerVideoInfo);
                if (paramSuperPlayerVideoInfo != null) {
                  SuperPlayerWrapper.this.mTPPlayer.switchDefinition(paramSuperPlayerVideoInfo, SuperPlayerWrapper.this.mSwitchDefnId.getAndIncrement(), null, SuperPlayerWrapper.this.mTVdieoSwitchDefnMode);
                }
              }
              catch (IllegalStateException paramSuperPlayerVideoInfo)
              {
                LogUtil.e(SuperPlayerWrapper.this.mTAG, "onGetVInfoSuccess switchDefinition error ", paramSuperPlayerVideoInfo);
                continue;
              }
              SuperPlayerWrapper.access$502(SuperPlayerWrapper.this, false);
              return;
              SuperPlayerWrapper.this.mTPPlayer.switchDefinition(paramSuperPlayerVideoInfo.getPlayUrl(), SuperPlayerWrapper.this.mSwitchDefnId.getAndIncrement(), null, SuperPlayerWrapper.this.mTVdieoSwitchDefnMode);
            }
          }
          if ((TextUtils.equals(paramSuperPlayerVideoInfo.getVid(), localSuperPlayerVideoInfo.getVid())) && (TextUtils.equals(paramSuperPlayerVideoInfo.getRequestDefinition(), localSuperPlayerVideoInfo.getRequestDefinition())))
          {
            if ((TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) && (paramSuperPlayerVideoInfo.getTVideoSectionList() == null)) {
              break label341;
            }
            SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(2);
            SuperPlayerWrapper.this.innerDoOpenMediaPlayer(paramSuperPlayerVideoInfo, SuperPlayerWrapper.this.mPlayerOption);
          }
          while ((this.mWrapperCallback != null) && (paramSuperPlayerVideoInfo.getTVideoNetInfo() != null))
          {
            this.mWrapperCallback.onDefinitionInfoUpdate(SuperPlayerWrapper.this, paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinitionStr(), paramSuperPlayerVideoInfo.getTVideoNetInfo().getDefinitionStrList());
            this.mWrapperCallback.onTVideoNetInfoUpdate(SuperPlayerWrapper.this, paramSuperPlayerVideoInfo.getTVideoNetInfo());
            return;
            label341:
            if (this.mWrapperCallback != null) {
              this.mWrapperCallback.onError(SuperPlayerWrapper.this, 2, 5000, 32000001, null);
            }
            SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(9);
          }
        }
      }
    }
    
    public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      if (SuperPlayerWrapper.this.innerHandleInfo(paramInt, paramLong1, paramLong2, paramObject)) {
        return;
      }
      paramInt = SuperPlayerMsg.convert(paramInt);
      LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onInfo, what:" + paramInt + ", arg1:" + paramLong1 + ", arg2:" + paramLong2 + ", extraObject:" + paramObject);
      this.mWrapperCallback.onInfo(SuperPlayerWrapper.this, paramInt, paramLong1, paramLong2, paramObject);
    }
    
    public void onPrepared(ITPPlayer paramITPPlayer)
    {
      LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onPrepared");
      SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(4);
      this.mWrapperCallback.onVideoPrepared(SuperPlayerWrapper.this);
    }
    
    public void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onSeekComplete");
      this.mWrapperCallback.onSeekComplete(SuperPlayerWrapper.this);
    }
    
    public void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
    {
      this.mWrapperCallback.onSubtitleData(SuperPlayerWrapper.this, paramTPSubtitleData);
    }
    
    public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      this.mWrapperCallback.onVideoFrameOutput(paramTPVideoFrameBuffer);
    }
    
    public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onVideoSizeChanged, width:" + paramLong1 + ", height:" + paramLong2);
      this.mWrapperCallback.onVideoSizeChanged(SuperPlayerWrapper.this, (int)paramLong1, (int)paramLong2);
    }
    
    void setCaptureListener(SuperPlayerWrapper.WrapperIdCaptureListener paramWrapperIdCaptureListener)
    {
      this.mCaptureListener = paramWrapperIdCaptureListener;
    }
  }
  
  class WrapperIdCaptureListener
    implements TPCaptureCallBack
  {
    private int mId;
    
    public WrapperIdCaptureListener(int paramInt)
    {
      this.mId = paramInt;
    }
    
    public void onCaptureVideoFailed(int paramInt)
    {
      LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onCaptureVideoFailed, id:" + this.mId + " errorCode:" + paramInt);
      SuperPlayerWrapper.this.mListenerMgr.onCaptureImageFailed(SuperPlayerWrapper.this, this.mId, paramInt);
    }
    
    public void onCaptureVideoSuccess(Bitmap paramBitmap)
    {
      LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onCaptureVideoSuccess id:" + this.mId);
      SuperPlayerWrapper.this.mListenerMgr.onCaptureImageSucceed(SuperPlayerWrapper.this, this.mId, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */