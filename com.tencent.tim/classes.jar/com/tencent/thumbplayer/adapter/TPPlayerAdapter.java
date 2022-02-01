package com.tencent.thumbplayer.adapter;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
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
import com.tencent.thumbplayer.adapter.player.TPPlayerBaseFactory;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.adapter.strategy.ITPStrategy;
import com.tencent.thumbplayer.adapter.strategy.TPStrategyFactory;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPlayerState;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TPPlayerAdapter
  implements ITPPlayerAdapter, ITPPlayerBaseListener.IOnStateChangeListener
{
  private static final String TAG = "TPPlayerAdapter";
  private Context mContext;
  private boolean mIsRetrying;
  private TPBaseLogger mLogger;
  private ITPPlayerBase mPlayerBase;
  private TPPlayerBaseCallback mPlayerCallback;
  private TPPlaybackParams mPlayerInitParams;
  private TPPlayerBaseListeners mPlayerListeners;
  private TPPlayerState mPlayerState;
  private int mPlayerType;
  private ITPInnerRichMediaSynchronizer mRichMediaProcessor;
  private TPPlayerStateStrategy mStateChecker;
  private TPLoggerContext mTPLoggerContext;
  private TPPlaybackInfo mTPPlaybackInfo;
  private ITPStrategy mTpStrategy;
  
  public TPPlayerAdapter(Context paramContext, @NonNull TPLoggerContext paramTPLoggerContext)
  {
    this.mTPLoggerContext = new TPLoggerContext(paramTPLoggerContext, "TPPlayerAdapter");
    this.mLogger = new TPBaseLogger(this.mTPLoggerContext);
    this.mContext = paramContext;
    this.mPlayerState = new TPPlayerState();
    this.mPlayerState.setOnPlayerStateChangeListener(this);
    this.mPlayerInitParams = new TPPlaybackParams();
    this.mPlayerCallback = new TPPlayerBaseCallback(null);
    this.mPlayerListeners = new TPPlayerBaseListeners(this.mTPLoggerContext.getTag());
    this.mStateChecker = new TPPlayerStateStrategy(this.mPlayerState);
    this.mTPPlaybackInfo = new TPPlaybackInfo();
  }
  
  private void backupVideoInfo()
  {
    if (isThumbPlayer())
    {
      this.mTPPlaybackInfo = TPPlaybackInfo.parseInfo(getPropertyString(0));
      this.mTPPlaybackInfo.setVideoLevel((int)this.mPlayerBase.getPropertyLong(204));
      this.mTPPlaybackInfo.setVideoProfile((int)this.mPlayerBase.getPropertyLong(203));
      this.mTPPlaybackInfo.setAudioProfile((int)this.mPlayerBase.getPropertyLong(102));
      this.mTPPlaybackInfo.setVideoCodedId((int)this.mPlayerBase.getPropertyLong(201));
    }
    if (this.mTPPlaybackInfo == null) {
      this.mTPPlaybackInfo = new TPPlaybackInfo();
    }
    this.mTPPlaybackInfo.setDurationMs(this.mPlayerBase.getDurationMs());
    TPOptionalParam localTPOptionalParam = this.mPlayerInitParams.getOptionalParam(100);
    if (localTPOptionalParam != null) {
      this.mTPPlaybackInfo.setCurrentPositionMs(localTPOptionalParam.getParamLong().value);
    }
  }
  
  private ITPPlayerBase createPlayerBase(int paramInt, TPLoggerContext paramTPLoggerContext)
    throws IOException
  {
    if (paramInt == 1) {}
    try
    {
      this.mLogger.info("to create androidPlayer");
      paramTPLoggerContext = TPPlayerBaseFactory.createSystemMediaPlayer(this.mContext, this.mPlayerInitParams.supportClip(), paramTPLoggerContext);
      while (paramTPLoggerContext == null)
      {
        this.mLogger.info("play is null!");
        return null;
        if (paramInt == 2)
        {
          this.mLogger.info("to create thumbPlayer");
          paramTPLoggerContext = TPPlayerBaseFactory.createThumbPlayer(this.mContext, paramTPLoggerContext);
        }
        else if (paramInt == 3)
        {
          this.mLogger.info("to create thumbPlayer software dec");
          paramTPLoggerContext = TPPlayerBaseFactory.createThumbPlayer(this.mContext, paramTPLoggerContext);
        }
        else
        {
          this.mLogger.info("to create no Player");
          paramTPLoggerContext = null;
        }
      }
    }
    catch (Exception paramTPLoggerContext)
    {
      for (;;)
      {
        this.mLogger.info("to create Player," + paramTPLoggerContext.toString());
        paramTPLoggerContext = null;
      }
      this.mPlayerType = paramInt;
      setPlayerParamBeforePrepare(paramTPLoggerContext);
    }
    return paramTPLoggerContext;
  }
  
  private ITPStrategy createPlayerStrategy(TPPlaybackParams paramTPPlaybackParams)
  {
    try
    {
      paramTPPlaybackParams = new TPStrategyConfig(paramTPPlaybackParams);
      return TPStrategyFactory.createStrategy(paramTPPlaybackParams);
    }
    catch (IllegalArgumentException paramTPPlaybackParams)
    {
      for (;;)
      {
        paramTPPlaybackParams = new TPStrategyConfig(null);
      }
    }
  }
  
  private void handleOnAudioFrameOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
      return;
    }
    this.mPlayerListeners.onAudioPcmOut(paramTPAudioFrameBuffer);
  }
  
  private TPPostProcessFrameBuffer handleOnAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
      return null;
    }
    return this.mPlayerListeners.onAudioProcessFrameOut(paramTPPostProcessFrameBuffer);
  }
  
  private void handleOnComplete()
  {
    if (!this.mStateChecker.validStateCallback(2))
    {
      this.mLogger.info("handleOnComplete, invalid state");
      return;
    }
    this.mPlayerState.changeState(7);
    this.mPlayerListeners.onCompletion();
  }
  
  private void handleOnDetailInfo(TPPlayerDetailInfo paramTPPlayerDetailInfo)
  {
    this.mPlayerListeners.onDetailInfo(paramTPPlayerDetailInfo);
  }
  
  private void handleOnError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (!this.mStateChecker.validStateCallback(4)) {
      return;
    }
    int i = this.mTpStrategy.strategyForRetry(this.mTPPlaybackInfo, new TPStrategyContext(this.mPlayerType, paramInt1, paramInt2, this.mTPPlaybackInfo.getDefinition()));
    if (i == 0)
    {
      this.mPlayerState.changeState(10);
      this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
      return;
    }
    try
    {
      switchPlayer(i);
      return;
    }
    catch (IOException localIOException)
    {
      this.mLogger.printException(localIOException);
      this.mPlayerState.changeState(10);
      this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.mLogger.printException(localIllegalStateException);
      this.mPlayerState.changeState(10);
      this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
    }
  }
  
  private void handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (this.mIsRetrying)
    {
      this.mLogger.info("handleOnInfo, mIsRetrying");
      return;
    }
    if ((paramInt == 152) && (this.mTPPlaybackInfo != null)) {
      this.mTPPlaybackInfo.setCurrentPlayClipNo((int)paramLong1 + 1);
    }
    this.mPlayerListeners.onInfo(paramInt, paramLong1, paramLong2, paramObject);
  }
  
  private void handleOnPrepared()
  {
    this.mPlayerListeners.onInfo(1000, this.mPlayerType, 0L, null);
    if (this.mIsRetrying)
    {
      if (this.mPlayerState.innerPlayState() != 3) {
        this.mLogger.warn("handleOnPrepared, invalid state, mIsRetrying.");
      }
    }
    else if (!this.mStateChecker.validStateCallback(1))
    {
      this.mLogger.info("handleOnPrepared, invalid state");
      return;
    }
    backupVideoInfo();
    setPlayerParamAfterPrepared(this.mPlayerBase);
    if (this.mIsRetrying)
    {
      this.mIsRetrying = false;
      this.mLogger.info("handleOnPrepared, mIsRetrying, recoverState, state:" + this.mPlayerState.state());
      int i = this.mPlayerState.state();
      this.mPlayerState.changeState(4);
      if (this.mPlayerState.lastState() == 3) {
        this.mPlayerListeners.onPrepared();
      }
      this.mPlayerListeners.onInfo(1014, 0L, 0L, null);
      recoverPlayer(i);
      return;
    }
    this.mPlayerState.setInnerPlayStateState(4);
    this.mPlayerState.changeState(4);
    this.mPlayerListeners.onPrepared();
  }
  
  private void handleOnSeekComplete()
  {
    if (!this.mStateChecker.validStateCallback(5)) {
      return;
    }
    this.mPlayerListeners.onSeekComplete();
  }
  
  private void handleOnSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    if (!this.mStateChecker.validStateCallback(7))
    {
      this.mLogger.info("handleOnSubtitleData, invalid state");
      return;
    }
    this.mPlayerListeners.onSubtitleData(paramTPSubtitleData);
  }
  
  private void handleOnSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7))
    {
      this.mLogger.info("handleOnSubtitleFrameOut, invalid state");
      return;
    }
    this.mPlayerListeners.onSubtitleFrameOut(paramTPSubtitleFrameBuffer);
  }
  
  private void handleOnVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7))
    {
      this.mLogger.info("handleOnVideoFrameOut, invalid state");
      return;
    }
    this.mPlayerListeners.onVideoFrameOut(paramTPVideoFrameBuffer);
  }
  
  private TPPostProcessFrameBuffer handleOnVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
      return null;
    }
    return this.mPlayerListeners.onVideoProcessFrameOut(paramTPPostProcessFrameBuffer);
  }
  
  private void handleOnVideoSizeChange(long paramLong1, long paramLong2)
  {
    if (!this.mStateChecker.validStateCallback(6))
    {
      this.mLogger.info("handleOnVideoSizeChange, invalid state");
      return;
    }
    this.mTPPlaybackInfo.setHeight(paramLong2);
    this.mTPPlaybackInfo.setWidth(paramLong1);
    this.mPlayerListeners.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  private boolean isThumbPlayer()
  {
    return (this.mPlayerType == 2) || (this.mPlayerType == 3);
  }
  
  private void recoverPlayer(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    default: 
      return;
    }
    try
    {
      this.mPlayerBase.start();
      this.mPlayerState.changeState(5);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.mLogger.printException(localIllegalStateException);
    }
  }
  
  private int selectPlayer()
  {
    if (this.mTpStrategy == null) {
      this.mTpStrategy = createPlayerStrategy(this.mPlayerInitParams);
    }
    return this.mTpStrategy.strategyForOpen(this.mTPPlaybackInfo);
  }
  
  private void setPlayerParamAfterPrepared(ITPPlayerBase paramITPPlayerBase)
  {
    TPProgramInfo[] arrayOfTPProgramInfo = getProgramInfo();
    TPProgramInfo localTPProgramInfo;
    int i;
    if (arrayOfTPProgramInfo != null)
    {
      localTPProgramInfo = this.mPlayerInitParams.getSelectProgramInfo();
      if (localTPProgramInfo != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < arrayOfTPProgramInfo.length)
      {
        if ((!TextUtils.isEmpty(localTPProgramInfo.url)) && (arrayOfTPProgramInfo[i] != null) && (localTPProgramInfo.url.equals(arrayOfTPProgramInfo[i].url))) {
          paramITPPlayerBase.selectProgram(i, -1L);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  private void setPlayerParamBeforePrepare(ITPPlayerBase paramITPPlayerBase)
    throws IOException
  {
    paramITPPlayerBase.setOnInfoListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnPreparedListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnCompletionListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnErrorListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnSeekCompleteListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnVideoSizeChangedListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnSubtitleDataListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnSubtitleFrameOutListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnDetailInfoListener(this.mPlayerCallback);
    if (isThumbPlayer())
    {
      paramITPPlayerBase.setOnVideoFrameOutListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnAudioPcmOutputListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnVideoProcessOutputListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnAudioProcessOutputListener(this.mPlayerCallback);
    }
    if (1 == this.mPlayerInitParams.dataSource().getType()) {
      paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().fileDescriptor());
    }
    for (;;)
    {
      localObject1 = this.mPlayerInitParams.optionalParams().iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramITPPlayerBase.setPlayerOptionalParam((TPOptionalParam)((Iterator)localObject1).next());
      }
      if (3 == this.mPlayerInitParams.dataSource().getType())
      {
        if (this.mPlayerType == 2) {
          paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().getTpUrlDataSource().getSelfPlayerUrl(), this.mPlayerInitParams.dataSource().httpHeaders());
        } else if (this.mPlayerType == 1) {
          paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().getTpUrlDataSource().getSystemPlayerUrl(), this.mPlayerInitParams.dataSource().httpHeaders());
        }
      }
      else if (2 == this.mPlayerInitParams.dataSource().getType()) {
        paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().mediaAsset());
      }
    }
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < this.mPlayerInitParams.getTrackInfos().size())
    {
      localObject1 = (TPTrackInfo)this.mPlayerInitParams.getTrackInfos().get(i);
      if (((TPTrackInfo)localObject1).trackType == 3)
      {
        localObject2 = this.mPlayerInitParams.subtitleSources().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TPPlaybackParams.SubtitleAttribute)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((TPPlaybackParams.SubtitleAttribute)localObject3).name)) && (((TPPlaybackParams.SubtitleAttribute)localObject3).name.equals(((TPTrackInfo)localObject1).name)))
          {
            paramITPPlayerBase.addSubtitleSource(((TPPlaybackParams.SubtitleAttribute)localObject3).url, ((TPPlaybackParams.SubtitleAttribute)localObject3).mimeType, ((TPPlaybackParams.SubtitleAttribute)localObject3).name);
            label455:
            break label485;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((TPTrackInfo)localObject1).trackType == 2)
        {
          localObject2 = this.mPlayerInitParams.audioTrackSources().iterator();
          label485:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (TPPlaybackParams.AudioTrackAttribute)((Iterator)localObject2).next();
            if ((TextUtils.isEmpty(((TPPlaybackParams.AudioTrackAttribute)localObject3).name)) || (!((TPPlaybackParams.AudioTrackAttribute)localObject3).name.equals(((TPTrackInfo)localObject1).name))) {
              break label455;
            }
            paramITPPlayerBase.addAudioTrackSource(((TPPlaybackParams.AudioTrackAttribute)localObject3).url, ((TPPlaybackParams.AudioTrackAttribute)localObject3).name, ((TPPlaybackParams.AudioTrackAttribute)localObject3).audioTrackParams);
          }
        }
      }
    }
    Object localObject1 = this.mPlayerInitParams.getSelectTrackAttributes().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TPPlaybackParams.SelectTrackAttribute)((Iterator)localObject1).next();
      if (((TPPlaybackParams.SelectTrackAttribute)localObject2).trackInfo.isSelected)
      {
        localObject3 = paramITPPlayerBase.getTrackInfo();
        if (localObject3 == null)
        {
          this.mLogger.error("playerTrackInfoList is null.");
        }
        else
        {
          i = 0;
          while (i < localObject3.length)
          {
            if (((TPPlaybackParams.SelectTrackAttribute)localObject2).trackInfo.name.equals(localObject3[i].name)) {
              paramITPPlayerBase.selectTrack(i, ((TPPlaybackParams.SelectTrackAttribute)localObject2).opaque);
            }
            i += 1;
          }
        }
      }
    }
    if (this.mPlayerInitParams.loopback() != null) {
      paramITPPlayerBase.setLoopback(this.mPlayerInitParams.loopback().isLoopback, this.mPlayerInitParams.loopback().startPositionMs, this.mPlayerInitParams.loopback().endPositionMs);
    }
    paramITPPlayerBase.setOutputMute(this.mPlayerInitParams.outputMute());
    if (this.mPlayerInitParams.audioGainRatio() != 0.0F) {
      paramITPPlayerBase.setAudioGainRatio(this.mPlayerInitParams.audioGainRatio());
    }
    if (this.mPlayerInitParams.speedRatio() != 0.0F) {
      paramITPPlayerBase.setPlaySpeedRatio(this.mPlayerInitParams.speedRatio());
    }
    if (!"".equals(this.mPlayerInitParams.audioNormalizeVolumeParams())) {
      paramITPPlayerBase.setAudioNormalizeVolumeParams(this.mPlayerInitParams.audioNormalizeVolumeParams());
    }
    if ((this.mPlayerInitParams.surface() instanceof SurfaceHolder)) {
      paramITPPlayerBase.setSurfaceHolder((SurfaceHolder)this.mPlayerInitParams.surface());
    }
    for (;;)
    {
      paramITPPlayerBase.setPlayerOptionalParam(new TPOptionalParam().buildQueueInt(204, this.mTpStrategy.strategyForDec()));
      return;
      if ((this.mPlayerInitParams.surface() instanceof Surface)) {
        paramITPPlayerBase.setSurface((Surface)this.mPlayerInitParams.surface());
      }
    }
  }
  
  private void switchPlayer(int paramInt)
    throws IOException, IllegalStateException
  {
    this.mPlayerListeners.onInfo(1013, paramInt, 0L, null);
    this.mPlayerState.setLastState(this.mPlayerState.state());
    if (this.mPlayerBase != null)
    {
      long l = this.mPlayerBase.getCurrentPositionMs();
      this.mLogger.info("switchPlayer, current position:" + l);
      this.mTPPlaybackInfo.setCurrentPositionMs(l);
      this.mTPPlaybackInfo.setPlayableDurationMs(this.mPlayerBase.getPlayableDurationMs());
      this.mPlayerBase.reset();
      this.mPlayerBase.release();
    }
    this.mPlayerBase = createPlayerBase(paramInt, this.mTPLoggerContext);
    if (this.mPlayerBase == null) {
      throw new RuntimeException("error , create player failed");
    }
    this.mIsRetrying = true;
    this.mLogger.info("switch player to type:" + this.mPlayerType);
    if (this.mTPPlaybackInfo != null)
    {
      TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(100, this.mTPPlaybackInfo.getCurrentPositionMs());
      this.mPlayerBase.setPlayerOptionalParam(localTPOptionalParam);
    }
    this.mPlayerState.setInnerPlayStateState(3);
    this.mPlayerBase.prepareAsync();
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error : addAudioTrackSource , state invalid");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.addAudioTrackSource(paramString1, paramString2, paramList);
    }
    this.mPlayerInitParams.addAudioTrackSource(paramString1, paramString2, paramList);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error : addSubtitleSource , state invalid");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.addSubtitleSource(paramString1, paramString2, paramString3);
    }
    this.mPlayerInitParams.addSubtitleSource(paramString1, paramString2, paramString3);
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    if (this.mPlayerBase != null)
    {
      this.mPlayerBase.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      return;
    }
    throw new IllegalStateException("error , no player for capture :" + this.mPlayerState);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error : deselectTrack , state invalid");
    }
    TPTrackInfo[] arrayOfTPTrackInfo = getTrackInfo();
    if (arrayOfTPTrackInfo == null)
    {
      this.mLogger.error("fatal err, tpTrackInfos is null");
      return;
    }
    if ((paramInt < 0) || (paramInt > arrayOfTPTrackInfo.length - 1)) {
      throw new IllegalArgumentException("error : track not found");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.deselectTrack(paramInt, paramLong);
    }
    this.mPlayerInitParams.setDeselectTrackInfo(paramInt, paramLong, arrayOfTPTrackInfo[paramInt]);
  }
  
  public int getCurrentPlayClipNo()
  {
    if (this.mTPPlaybackInfo != null) {
      return this.mTPPlaybackInfo.getCurrentPlayClipNo();
    }
    return 0;
  }
  
  public long getCurrentPositionMs()
  {
    long l1 = 0L;
    if (!this.mStateChecker.validStateCall(12)) {
      if (this.mTPPlaybackInfo != null) {
        l1 = this.mTPPlaybackInfo.getCurrentPositionMs();
      }
    }
    long l2;
    do
    {
      return l1;
      if (this.mPlayerBase == null)
      {
        this.mLogger.warn("getCurrentPositionMs, mPlayerBase = null, return 0!");
        return 0L;
      }
      l2 = this.mPlayerBase.getCurrentPositionMs();
      l1 = l2;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setCurrentPositionMs(l2);
    return l2;
  }
  
  public int getCurrentState()
  {
    return this.mPlayerState.state();
  }
  
  public long getDurationMs()
  {
    long l1 = 0L;
    if ((this.mTPPlaybackInfo != null) && (this.mTPPlaybackInfo.getDurationMs() > 0L)) {
      l1 = this.mTPPlaybackInfo.getDurationMs();
    }
    long l2;
    do
    {
      do
      {
        return l1;
      } while (!this.mStateChecker.validStateCall(11));
      if (this.mPlayerBase == null)
      {
        this.mLogger.warn("getDurationMs, mPlayerBase = null, return 0!");
        return 0L;
      }
      l2 = this.mPlayerBase.getDurationMs();
      l1 = l2;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setDurationMs(l2);
    return l2;
  }
  
  public int getNativePlayerId()
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getNativePlayerId();
    }
    return 0;
  }
  
  public long getPlayableDurationMs()
  {
    long l1 = 0L;
    if (!this.mStateChecker.validStateCall(12)) {}
    long l2;
    do
    {
      return l1;
      if (this.mPlayerBase == null)
      {
        this.mLogger.warn("getBufferedDurationMs, mPlayerBase = null, return 0!");
        return 0L;
      }
      l2 = this.mPlayerBase.getPlayableDurationMs();
      l1 = l2;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setPlayableDurationMs(l2);
    return l2;
  }
  
  public TPPlaybackInfo getPlaybackInfo()
  {
    return this.mTPPlaybackInfo;
  }
  
  public int getPlayerType()
  {
    return this.mPlayerType;
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    if ((this.mPlayerBase != null) && (this.mPlayerBase.getProgramInfo() != null)) {
      return this.mPlayerBase.getProgramInfo();
    }
    return new TPProgramInfo[0];
  }
  
  public long getPropertyLong(int paramInt)
    throws IllegalStateException
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getPropertyLong(paramInt);
    }
    this.mLogger.warn("getPropertyLong, mPlayerBase = null, return !");
    return -1L;
  }
  
  public String getPropertyString(int paramInt)
    throws IllegalStateException
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getPropertyString(paramInt);
    }
    this.mLogger.warn("getPropertyString, mPlayerBase = null, return !");
    return "";
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getTrackInfo();
    }
    return (TPTrackInfo[])this.mPlayerInitParams.getTrackInfos().toArray(new TPTrackInfo[0]);
  }
  
  public int getVideoHeight()
  {
    int i;
    if ((this.mTPPlaybackInfo != null) && (this.mTPPlaybackInfo.getHeight() > 0L)) {
      i = (int)this.mTPPlaybackInfo.getHeight();
    }
    int j;
    do
    {
      return i;
      if (!this.mStateChecker.validStateCall(13))
      {
        this.mLogger.warn("getVideoHeight, state error!");
        return 0;
      }
      if (this.mPlayerBase == null)
      {
        this.mLogger.warn("getVideoHeight, mPlayerBase = null, return 0!");
        return 0;
      }
      j = this.mPlayerBase.getVideoHeight();
      i = j;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setHeight(j);
    return j;
  }
  
  public int getVideoWidth()
  {
    int i;
    if ((this.mTPPlaybackInfo != null) && (this.mTPPlaybackInfo.getWidth() > 0L)) {
      i = (int)this.mTPPlaybackInfo.getWidth();
    }
    int j;
    do
    {
      return i;
      if (!this.mStateChecker.validStateCall(13))
      {
        this.mLogger.warn("getVideoWidth, state error!");
        return 0;
      }
      if (this.mPlayerBase == null)
      {
        this.mLogger.warn("getVideoWidth, mPlayerBase = null, return 0!");
        return 0;
      }
      j = this.mPlayerBase.getVideoWidth();
      i = j;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setWidth(j);
    return j;
  }
  
  public boolean isPlaying()
  {
    return (this.mPlayerState != null) && (this.mPlayerState.state() == 5);
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    this.mPlayerListeners.onStateChange(paramInt1, paramInt2);
  }
  
  public void pause()
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(6))
    {
      TPLogUtil.e("TPPlayerAdapter", "error , pause , state invalid , current state :" + this.mPlayerState + ", return");
      return;
    }
    if (this.mPlayerBase == null) {
      throw new IllegalStateException("error , pause , player is null");
    }
    if (this.mIsRetrying)
    {
      this.mPlayerState.changeState(6);
      return;
    }
    try
    {
      this.mPlayerBase.pause();
      this.mPlayerState.changeState(6);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IllegalStateException("error , pause ,state invalid");
    }
  }
  
  public void prepare()
    throws IllegalStateException, IOException
  {
    if (!this.mStateChecker.validStateCall(1)) {
      throw new IllegalStateException("error , prepare , state invalid , current state :" + this.mPlayerState);
    }
    if (!this.mPlayerInitParams.validDataSource()) {
      throw new IOException("error , prepare , data source invalid");
    }
    this.mPlayerBase = createPlayerBase(selectPlayer(), this.mTPLoggerContext);
    if (this.mPlayerBase == null) {
      throw new RuntimeException("error , create player failed");
    }
    this.mPlayerState.setInnerPlayStateState(3);
    this.mPlayerState.changeState(3);
    this.mPlayerBase.prepare();
  }
  
  public void prepareAsync()
    throws IllegalStateException, IOException
  {
    if (!this.mStateChecker.validStateCall(1)) {
      throw new IllegalStateException("error , prepare , state invalid , current state :" + this.mPlayerState);
    }
    if (!this.mPlayerInitParams.validDataSource()) {
      throw new IllegalStateException("error , prepare , state invalid , data source invalid");
    }
    this.mPlayerBase = createPlayerBase(selectPlayer(), this.mTPLoggerContext);
    if (this.mPlayerBase == null) {
      throw new RuntimeException("error , create player failed");
    }
    this.mPlayerState.setInnerPlayStateState(3);
    this.mPlayerState.changeState(3);
    this.mPlayerBase.prepareAsync();
  }
  
  public void release()
  {
    this.mLogger.info("release, current state :" + this.mPlayerState);
    if (this.mPlayerBase != null)
    {
      this.mPlayerBase.release();
      this.mPlayerBase = null;
    }
    this.mPlayerInitParams.reset();
    this.mPlayerListeners.clear();
    this.mTpStrategy = null;
    this.mIsRetrying = false;
    this.mPlayerState.changeState(11);
  }
  
  public void reset()
  {
    this.mLogger.info("reset, current state :" + this.mPlayerState);
    if (this.mPlayerBase != null)
    {
      this.mPlayerBase.reset();
      this.mPlayerBase.release();
      this.mPlayerBase = null;
    }
    this.mPlayerInitParams.reset();
    this.mTPPlaybackInfo.clear();
    this.mTpStrategy = null;
    this.mIsRetrying = false;
    this.mPlayerState.changeState(1);
    this.mPlayerState.setLastState(1);
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(9)) {
      TPLogUtil.e("TPPlayerAdapter", "error , seek to , state invalid , current state :" + this.mPlayerState + ", return");
    }
    ITPInnerRichMediaSynchronizer localITPInnerRichMediaSynchronizer;
    do
    {
      return;
      if (this.mPlayerBase == null) {
        break;
      }
      if (this.mPlayerState.state() == 7) {
        this.mPlayerState.changeState(5);
      }
      this.mPlayerBase.seekTo(paramInt);
      localITPInnerRichMediaSynchronizer = this.mRichMediaProcessor;
    } while (localITPInnerRichMediaSynchronizer == null);
    long l = paramInt;
    try
    {
      localITPInnerRichMediaSynchronizer.seek(l);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.warn("seekTo, rich media processor seek err.");
      return;
    }
    this.mLogger.warn("seekTo, mPlayerBase = null!");
  }
  
  public void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(9)) {
      TPLogUtil.e("TPPlayerAdapter", "error , seek to , state invalid , current state :" + this.mPlayerState + ", return");
    }
    ITPInnerRichMediaSynchronizer localITPInnerRichMediaSynchronizer;
    do
    {
      return;
      if (this.mPlayerBase == null) {
        break;
      }
      if (this.mPlayerState.state() == 7) {
        this.mPlayerState.changeState(5);
      }
      this.mPlayerBase.seekTo(paramInt1, paramInt2);
      localITPInnerRichMediaSynchronizer = this.mRichMediaProcessor;
    } while (localITPInnerRichMediaSynchronizer == null);
    long l = paramInt1;
    try
    {
      localITPInnerRichMediaSynchronizer.seek(l);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.warn("seekTo, rich media processor seek err.");
      return;
    }
    this.mLogger.warn("seekTo, mPlayerBase = null!");
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    if (!this.mStateChecker.validStateCall(18)) {
      throw new IllegalStateException("error : selectProgram , state invalid");
    }
    TPProgramInfo[] arrayOfTPProgramInfo2 = getProgramInfo();
    TPProgramInfo[] arrayOfTPProgramInfo1 = arrayOfTPProgramInfo2;
    if (arrayOfTPProgramInfo2 == null) {
      arrayOfTPProgramInfo1 = new TPProgramInfo[0];
    }
    if ((paramInt < 0) || (paramInt > arrayOfTPProgramInfo1.length - 1)) {
      throw new IllegalArgumentException("error : program index not found");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.selectProgram(paramInt, paramLong);
    }
    this.mPlayerInitParams.setSelectProgramInfo(arrayOfTPProgramInfo1[paramInt]);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error : selectTrack , state invalid");
    }
    TPTrackInfo[] arrayOfTPTrackInfo = getTrackInfo();
    if (arrayOfTPTrackInfo == null)
    {
      this.mLogger.error("fatal err, tpTrackInfos is null");
      return;
    }
    if ((paramInt < 0) || (paramInt > arrayOfTPTrackInfo.length - 1)) {
      throw new IllegalArgumentException("error : track not found");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.selectTrack(paramInt, paramLong);
    }
    this.mPlayerInitParams.addSelectedTrackInfo(paramInt, paramLong, arrayOfTPTrackInfo[paramInt]);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setAudioGainRatio(paramFloat);
    }
    for (;;)
    {
      this.mPlayerInitParams.setAudioGainRatio(paramFloat);
      return;
      this.mLogger.info("setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setAudioNormalizeVolumeParams , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setAudioNormalizeVolumeParams(paramString);
    }
    for (;;)
    {
      this.mPlayerInitParams.setAudioNormalizeVolumeParams(paramString);
      return;
      this.mLogger.info("setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(2))
    {
      TPLogUtil.e("TPPlayerAdapter", "error , setDataSource , state invalid , current state :" + this.mPlayerState + ", return");
      return;
    }
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("error : setDataSource , pfd invalid");
    }
    this.mPlayerInitParams.setDataSource(paramParcelFileDescriptor);
    this.mPlayerState.changeState(2);
  }
  
  public void setDataSource(TPUrlDataSource paramTPUrlDataSource)
  {
    setDataSource(paramTPUrlDataSource, null);
  }
  
  public void setDataSource(TPUrlDataSource paramTPUrlDataSource, Map<String, String> paramMap)
  {
    if (!this.mStateChecker.validStateCall(2))
    {
      TPLogUtil.e("TPPlayerAdapter", "error , setDataSource , state invalid , current state :" + this.mPlayerState + ", return");
      return;
    }
    if (paramTPUrlDataSource == null) {
      throw new IllegalArgumentException("error : setDataSource , data source invalid");
    }
    this.mPlayerInitParams.setDataSource(paramTPUrlDataSource, paramMap);
    this.mPlayerState.changeState(2);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(2))
    {
      TPLogUtil.e("TPPlayerAdapter", "error , setDataSource , state invalid , current state :" + this.mPlayerState + ", return");
      return;
    }
    if (paramITPMediaAsset == null) {
      throw new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
    }
    this.mPlayerInitParams.setDataSource(paramITPMediaAsset);
    this.mPlayerState.changeState(2);
  }
  
  public void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {}
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {}
  
  public void setLoopback(boolean paramBoolean)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setLoopback , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setLoopback(paramBoolean);
    }
    for (;;)
    {
      this.mPlayerInitParams.setLoopback(paramBoolean);
      return;
      this.mLogger.info("setLoopback, mPlayerBase = null!");
    }
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setLoopback , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    for (;;)
    {
      this.mPlayerInitParams.setLoopback(paramBoolean, paramLong1, paramLong2);
      return;
      this.mLogger.info("setLoopback, mPlayerBase = null!");
    }
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
    throws IllegalStateException
  {
    this.mPlayerListeners.setOnAudioPcmOutListener(paramIOnAudioPcmOutListener);
  }
  
  public void setOnAudioProcessOutputListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
    throws IllegalStateException
  {
    this.mPlayerListeners.setOnAudioProcessFrameListener(paramIOnAudioProcessOutListener);
  }
  
  public void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mPlayerListeners.setOnCompletionListener(paramIOnCompletionListener);
  }
  
  public void setOnDetailInfoListener(ITPPlayerBaseListener.IOnDetailInfoListener paramIOnDetailInfoListener)
  {
    this.mPlayerListeners.setOnDetailInfoListener(paramIOnDetailInfoListener);
  }
  
  public void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener)
  {
    this.mPlayerListeners.setOnErrorListener(paramIOnErrorListener);
  }
  
  public void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener)
  {
    this.mPlayerListeners.setOnInfoListener(paramIOnInfoListener);
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerBaseListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    this.mPlayerListeners.setOnStateChangeListener(paramIOnStateChangeListener);
  }
  
  public void setOnPreparedListener(ITPPlayerBaseListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.mPlayerListeners.setOnPreparedListener(paramIOnPreparedListener);
  }
  
  public void setOnSeekCompleteListener(ITPPlayerBaseListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.mPlayerListeners.setOnSeekCompleteListener(paramIOnSeekCompleteListener);
  }
  
  public void setOnSubtitleDataListener(ITPPlayerBaseListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    this.mPlayerListeners.setOnSubtitleDataListener(paramIOnSubtitleDataListener);
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    this.mPlayerListeners.setOnSubtitleFrameOutListener(paramIOnSubtitleFrameOutListener);
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
    throws IllegalStateException
  {
    this.mPlayerListeners.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
  }
  
  public void setOnVideoProcessOutputListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
    throws IllegalStateException
  {
    this.mPlayerListeners.setOnVideoProcessFrameListener(paramIOnVideoProcessOutListener);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mPlayerListeners.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setOutputMute(paramBoolean);
    }
    for (;;)
    {
      this.mPlayerInitParams.setOutputMute(paramBoolean);
      return;
      this.mLogger.info("setOutputMute, mPlayerBase = null!");
    }
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setPlaySpeedRatio(paramFloat);
    }
    for (;;)
    {
      this.mPlayerInitParams.setSpeedRatio(paramFloat);
      ITPInnerRichMediaSynchronizer localITPInnerRichMediaSynchronizer = this.mRichMediaProcessor;
      if (localITPInnerRichMediaSynchronizer != null) {}
      try
      {
        localITPInnerRichMediaSynchronizer.setPlaybackRate(paramFloat);
        return;
      }
      catch (Exception localException)
      {
        this.mLogger.warn("setPlaySpeedRatio, rich media processor setPlaySpeedRatio err.");
      }
      this.mLogger.info("setPlaySpeedRatio, mPlayerBase = null!");
    }
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("setPlayerOptionalParam , state invalid");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setPlayerOptionalParam(paramTPOptionalParam);
    }
    this.mPlayerInitParams.addOptionalParams(paramTPOptionalParam);
  }
  
  public void setRichMediaSynchronizer(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer)
  {
    if (paramITPRichMediaSynchronizer == null)
    {
      paramITPRichMediaSynchronizer = this.mRichMediaProcessor;
      if (paramITPRichMediaSynchronizer != null) {
        paramITPRichMediaSynchronizer.setInnerListener(null);
      }
      this.mRichMediaProcessor = null;
    }
    while (!(paramITPRichMediaSynchronizer instanceof ITPInnerRichMediaSynchronizer)) {
      return;
    }
    this.mRichMediaProcessor = ((ITPInnerRichMediaSynchronizer)paramITPRichMediaSynchronizer);
    this.mRichMediaProcessor.setInnerListener(new TPPlayerAdapter.1(this));
  }
  
  public void setSurface(Surface paramSurface)
    throws IllegalStateException
  {
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setSurface(paramSurface);
    }
    this.mPlayerInitParams.setSurface(paramSurface);
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
    throws IllegalStateException
  {
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setSurfaceHolder(paramSurfaceHolder);
    }
    this.mPlayerInitParams.setSurfaceHolder(paramSurfaceHolder);
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (!this.mStateChecker.validStateCall(2)) {
      this.mLogger.error("setVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.mTPPlaybackInfo.setHeight(paramTPVideoInfo.getHeight());
      this.mTPPlaybackInfo.setWidth(paramTPVideoInfo.getWidth());
      this.mTPPlaybackInfo.setDefinition(paramTPVideoInfo.getDefinition());
      this.mTPPlaybackInfo.setVideoCodedId(paramTPVideoInfo.getVideoCodecId());
    }
  }
  
  public void start()
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(5))
    {
      TPLogUtil.e("TPPlayerAdapter", "error , start , state invalid , current state :" + this.mPlayerState + ", return");
      return;
    }
    if (this.mPlayerBase == null) {
      throw new IllegalStateException("error , start , player is null");
    }
    try
    {
      this.mPlayerBase.start();
      this.mPlayerState.changeState(5);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IllegalStateException("error , start ,state invalid");
    }
  }
  
  public void stop()
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(7))
    {
      TPLogUtil.e("TPPlayerAdapter", "error , stop , state invalid , current state :" + this.mPlayerState + ", return");
      return;
    }
    if (this.mPlayerBase == null) {
      throw new IllegalStateException("error , stop , player is null");
    }
    try
    {
      this.mPlayerState.changeState(8);
      this.mPlayerBase.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IllegalStateException("error , stop ,state invalid");
    }
    finally
    {
      this.mPlayerState.changeState(9);
    }
  }
  
  public void switchDefinition(TPUrlDataSource paramTPUrlDataSource, int paramInt, long paramLong)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(17)) {
      throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.mPlayerState);
    }
    this.mPlayerInitParams.setDataSource(paramTPUrlDataSource, null);
    if (this.mPlayerBase != null)
    {
      String str = "";
      if (this.mPlayerType == 2) {
        str = paramTPUrlDataSource.getSelfPlayerUrl();
      }
      for (;;)
      {
        this.mPlayerBase.switchDefinition(str, paramInt, paramLong);
        return;
        if (this.mPlayerType == 1) {
          str = paramTPUrlDataSource.getSystemPlayerUrl();
        }
      }
    }
    this.mLogger.warn("switchDefinition, mPlayerBase = null!");
  }
  
  public void switchDefinition(TPUrlDataSource paramTPUrlDataSource, Map<String, String> paramMap, int paramInt, long paramLong)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(17)) {
      throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.mPlayerState);
    }
    this.mPlayerInitParams.setDataSource(paramTPUrlDataSource, paramMap);
    if (this.mPlayerBase != null)
    {
      String str = "";
      if (this.mPlayerType == 2) {
        str = paramTPUrlDataSource.getSelfPlayerUrl();
      }
      for (;;)
      {
        this.mPlayerBase.switchDefinition(str, paramMap, paramInt, paramLong);
        return;
        if (this.mPlayerType == 1) {
          str = paramTPUrlDataSource.getSystemPlayerUrl();
        }
      }
    }
    this.mLogger.warn("switchDefinition, mPlayerBase = null!");
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(17)) {
      throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.mPlayerState);
    }
    this.mPlayerInitParams.setDataSource(paramITPMediaAsset);
    if (this.mPlayerBase != null)
    {
      this.mPlayerBase.switchDefinition(paramITPMediaAsset, paramInt, paramLong);
      return;
    }
    this.mLogger.warn("switchDefinition, mPlayerBase = null!");
  }
  
  public void switchDefinition(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException
  {}
  
  public void switchDefinition(String paramString, Map<String, String> paramMap, int paramInt, long paramLong)
    throws IllegalStateException
  {}
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this.mTPLoggerContext.update(paramTPLoggerContext, "TPPlayerAdapter");
    this.mLogger.updateContext(this.mTPLoggerContext);
    this.mPlayerListeners.updateTag(this.mTPLoggerContext.getTag());
    if (this.mPlayerBase != null) {
      this.mPlayerBase.updateLoggerContext(this.mTPLoggerContext);
    }
  }
  
  public void updateVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      this.mLogger.error("updateVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.mTPPlaybackInfo.setHeight(paramTPVideoInfo.getHeight());
      this.mTPPlaybackInfo.setWidth(paramTPVideoInfo.getWidth());
      this.mTPPlaybackInfo.setDefinition(paramTPVideoInfo.getDefinition());
      this.mTPPlaybackInfo.setVideoCodedId(paramTPVideoInfo.getVideoCodecId());
    }
  }
  
  class TPPlayerBaseCallback
    implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnAudioProcessOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnDetailInfoListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnSubtitleFrameOutListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoProcessOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
  {
    private TPPlayerBaseCallback() {}
    
    public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      TPPlayerAdapter.this.handleOnAudioFrameOut(paramTPAudioFrameBuffer);
    }
    
    public TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      return TPPlayerAdapter.this.handleOnAudioProcessFrameOut(paramTPPostProcessFrameBuffer);
    }
    
    public void onCompletion()
    {
      TPPlayerAdapter.this.handleOnComplete();
    }
    
    public void onDetailInfo(TPPlayerDetailInfo paramTPPlayerDetailInfo)
    {
      TPPlayerAdapter.this.handleOnDetailInfo(paramTPPlayerDetailInfo);
    }
    
    public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      TPPlayerAdapter.this.handleOnError(paramInt1, paramInt2, paramLong1, paramLong2);
    }
    
    public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      TPPlayerAdapter.this.handleOnInfo(paramInt, paramLong1, paramLong2, paramObject);
    }
    
    public void onPrepared()
    {
      TPPlayerAdapter.this.handleOnPrepared();
    }
    
    public void onSeekComplete()
    {
      TPPlayerAdapter.this.handleOnSeekComplete();
    }
    
    public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
    {
      TPPlayerAdapter.this.handleOnSubtitleData(paramTPSubtitleData);
    }
    
    public void onSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      TPPlayerAdapter.this.handleOnSubtitleFrameOut(paramTPSubtitleFrameBuffer);
    }
    
    public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      TPPlayerAdapter.this.handleOnVideoFrameOut(paramTPVideoFrameBuffer);
    }
    
    public TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      return TPPlayerAdapter.this.handleOnVideoProcessFrameOut(paramTPPostProcessFrameBuffer);
    }
    
    public void onVideoSizeChanged(long paramLong1, long paramLong2)
    {
      TPPlayerAdapter.this.handleOnVideoSizeChange(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerAdapter
 * JD-Core Version:    0.7.0.1
 */