package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.adapter.TPPlaybackParams;
import com.tencent.thumbplayer.adapter.TPPlaybackParams.AudioTrackAttribute;
import com.tencent.thumbplayer.adapter.TPPlaybackParams.LoopbackAttribute;
import com.tencent.thumbplayer.adapter.TPPlaybackParams.SubtitleAttribute;
import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.adapter.TPPlayerDataSource;
import com.tencent.thumbplayer.adapter.TPPlayerStateStrategy;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnDetailInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPPlayerState;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.composition.TPMediaComposition;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrack;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrackClip;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TPSystemClipPlayer
  implements ITPPlayerBase
{
  private static final String TAG = "TPSystemClipPlayer";
  private boolean isPlayingClip;
  private boolean isSwitchingDef;
  private List<ITPMediaTrackClip> mClipList;
  private Context mContext;
  private int mCurrentClip = 0;
  private TPBaseLogger mLogger;
  private ITPPlayerBase mPlayerBase;
  private TPPlayerBaseCallback mPlayerCallback;
  private TPPlaybackParams mPlayerInitParams;
  private TPPlayerBaseListeners mPlayerListeners;
  private TPPlayerState mPlayerState;
  private TPPlayerStateStrategy mStateChecker;
  private LinkedList<Long> mSwitchingDefTagQueue;
  private TPLoggerContext mTPLoggerContext;
  private TPPlaybackInfo mTPPlaybackInfo;
  
  public TPSystemClipPlayer(Context paramContext, TPLoggerContext paramTPLoggerContext)
  {
    this.mTPLoggerContext = new TPLoggerContext(paramTPLoggerContext, "TPSystemClipPlayer");
    this.mLogger = new TPBaseLogger(this.mTPLoggerContext);
    this.mContext = paramContext;
    this.mPlayerState = new TPPlayerState();
    this.mPlayerInitParams = new TPPlaybackParams();
    this.mPlayerCallback = new TPPlayerBaseCallback(null);
    this.mPlayerListeners = new TPPlayerBaseListeners(this.mLogger.getTag());
    this.mStateChecker = new TPPlayerStateStrategy(this.mPlayerState);
    this.mClipList = new ArrayList();
  }
  
  private ITPPlayerBase createPlayerBase()
    throws IOException
  {
    TPSystemMediaPlayer localTPSystemMediaPlayer = new TPSystemMediaPlayer(this.mContext, this.mTPLoggerContext);
    if (this.mTPPlaybackInfo == null) {
      this.mTPPlaybackInfo = new TPPlaybackInfo();
    }
    setPlayerParamBeforePrepare(localTPSystemMediaPlayer);
    return localTPSystemMediaPlayer;
  }
  
  private List<ITPMediaTrackClip> getClipListWithAsset(ITPMediaAsset paramITPMediaAsset)
  {
    int i = 0;
    if ((!(paramITPMediaAsset instanceof TPMediaComposition)) && (!(paramITPMediaAsset instanceof TPMediaCompositionTrack)) && (!(paramITPMediaAsset instanceof TPMediaCompositionTrackClip))) {
      throw new IllegalStateException("system mediaPlayer : media asset is illegal source!");
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramITPMediaAsset instanceof TPMediaComposition))
    {
      paramITPMediaAsset = ((TPMediaComposition)paramITPMediaAsset).getAllAVTracks();
      if ((TPCommonUtils.isEmpty(paramITPMediaAsset)) || (paramITPMediaAsset.get(0) == null)) {
        throw new IllegalStateException("empty av tracks when set data source!");
      }
      paramITPMediaAsset = ((ITPMediaTrack)paramITPMediaAsset.get(0)).getAllTrackClips();
    }
    for (;;)
    {
      long l = 0L;
      while (i < paramITPMediaAsset.size())
      {
        ((ITPMediaTrackClip)paramITPMediaAsset.get(i)).setStartPositionMs(l);
        l += ((ITPMediaTrackClip)paramITPMediaAsset.get(i)).getOriginalDurationMs();
        i += 1;
      }
      if ((paramITPMediaAsset instanceof TPMediaCompositionTrack))
      {
        paramITPMediaAsset = ((TPMediaCompositionTrack)paramITPMediaAsset).getAllTrackClips();
      }
      else
      {
        localArrayList.add((ITPMediaTrackClip)paramITPMediaAsset);
        paramITPMediaAsset = localArrayList;
      }
    }
    return paramITPMediaAsset;
  }
  
  private ITPMediaTrackClip getCurrentClip()
  {
    return (ITPMediaTrackClip)this.mClipList.get(this.mCurrentClip);
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
    if (!this.mStateChecker.validStateCallback(2)) {
      return;
    }
    if (this.mCurrentClip >= this.mClipList.size() - 1)
    {
      this.mPlayerState.changeState(7);
      this.mPlayerListeners.onCompletion();
      return;
    }
    try
    {
      switchPlayer(this.mCurrentClip + 1, 0L);
      return;
    }
    catch (IOException localIOException)
    {
      this.mLogger.info("handleOnComplete:" + localIOException.toString());
    }
  }
  
  private void handleOnError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (!this.mStateChecker.validStateCallback(4)) {
      return;
    }
    this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  private void handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (!this.mStateChecker.validStateCallback(3)) {
      return;
    }
    this.mPlayerListeners.onInfo(paramInt, paramLong1, paramLong2, paramObject);
  }
  
  private void handleOnPrepared()
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.onInfo(152, this.mCurrentClip, 0L, null);
    }
    if (this.isPlayingClip)
    {
      start();
      if ((this.isSwitchingDef) && (this.mPlayerListeners != null) && (!TPCommonUtils.isEmpty(this.mSwitchingDefTagQueue)))
      {
        localLong = (Long)this.mSwitchingDefTagQueue.poll();
        if (localLong != null) {
          this.mPlayerListeners.onInfo(3, localLong.longValue(), 0L, null);
        }
        this.isSwitchingDef = false;
      }
    }
    while (!this.mStateChecker.validStateCallback(1))
    {
      Long localLong;
      return;
    }
    this.mPlayerState.changeState(4);
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.onPrepared();
    }
    setPlayerParamAfterPrepared(this.mPlayerBase);
  }
  
  private void handleOnSeekComplete()
  {
    if (!this.mStateChecker.validStateCallback(5)) {
      return;
    }
    if (this.mPlayerState.is(7)) {
      start();
    }
    this.mPlayerListeners.onSeekComplete();
  }
  
  private void handleOnSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
      return;
    }
    this.mPlayerListeners.onSubtitleData(paramTPSubtitleData);
  }
  
  private void handleOnVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
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
    if (!this.mStateChecker.validStateCallback(6)) {
      return;
    }
    this.mTPPlaybackInfo.setHeight(paramLong2);
    this.mTPPlaybackInfo.setWidth(paramLong1);
    this.mPlayerListeners.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  private void selectClipPlayer(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.mClipList.size())
      {
        long l;
        if ((((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs() <= paramInt) && (paramInt <= ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.mClipList.get(i)).getOriginalDurationMs())) {
          l = paramInt;
        }
        try
        {
          switchPlayer(i, l - ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs());
          i += 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.mLogger.info("selectClipPlayer:" + localIOException.toString());
          }
        }
      }
    }
  }
  
  private void setPlayerParamAfterPrepared(ITPPlayerBase paramITPPlayerBase)
  {
    TPTrackInfo[] arrayOfTPTrackInfo = getTrackInfo();
    if (arrayOfTPTrackInfo == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < arrayOfTPTrackInfo.length)
      {
        int j = arrayOfTPTrackInfo[i].getTrackType();
        TPTrackInfo localTPTrackInfo = this.mPlayerInitParams.getTrackInfoByType(j);
        if (arrayOfTPTrackInfo[i].equals(localTPTrackInfo)) {
          paramITPPlayerBase.selectTrack(i, -1L);
        }
        i += 1;
      }
    }
  }
  
  private void setPlayerParamBeforePrepare(ITPPlayerBase paramITPPlayerBase)
    throws IOException
  {
    if (1 == this.mPlayerInitParams.dataSource().getType()) {
      paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().fileDescriptor());
    }
    if (this.mPlayerInitParams.dataSource().getType() == 0) {
      paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().url(), this.mPlayerInitParams.dataSource().httpHeaders());
    }
    Iterator localIterator = this.mPlayerInitParams.optionalParams().iterator();
    while (localIterator.hasNext()) {
      paramITPPlayerBase.setPlayerOptionalParam((TPOptionalParam)localIterator.next());
    }
    localIterator = this.mPlayerInitParams.subtitleSources().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (TPPlaybackParams.SubtitleAttribute)localIterator.next();
      paramITPPlayerBase.addSubtitleSource(((TPPlaybackParams.SubtitleAttribute)localObject).url, ((TPPlaybackParams.SubtitleAttribute)localObject).mimeType, ((TPPlaybackParams.SubtitleAttribute)localObject).name);
    }
    localIterator = this.mPlayerInitParams.audioTrackSources().iterator();
    while (localIterator.hasNext())
    {
      localObject = (TPPlaybackParams.AudioTrackAttribute)localIterator.next();
      paramITPPlayerBase.addAudioTrackSource(((TPPlaybackParams.AudioTrackAttribute)localObject).url, ((TPPlaybackParams.AudioTrackAttribute)localObject).name, ((TPPlaybackParams.AudioTrackAttribute)localObject).audioTrackParams);
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
    if ((this.mPlayerInitParams.surface() instanceof SurfaceHolder)) {
      paramITPPlayerBase.setSurfaceHolder((SurfaceHolder)this.mPlayerInitParams.surface());
    }
    for (;;)
    {
      paramITPPlayerBase.setOnInfoListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnPreparedListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnCompletionListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnErrorListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnSeekCompleteListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnVideoSizeChangedListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnSubtitleDataListener(this.mPlayerCallback);
      return;
      if ((this.mPlayerInitParams.surface() instanceof Surface)) {
        paramITPPlayerBase.setSurface((Surface)this.mPlayerInitParams.surface());
      }
    }
  }
  
  private void switchPlayer(int paramInt, long paramLong)
    throws IOException
  {
    this.mLogger.debug("switchPlayer: clipNo:" + paramInt + "   startPostion:" + paramLong);
    if (this.mPlayerBase != null) {
      this.mPlayerBase.release();
    }
    this.isPlayingClip = true;
    this.mCurrentClip = paramInt;
    this.mPlayerInitParams.setDataSource(((ITPMediaTrackClip)this.mClipList.get(this.mCurrentClip)).getFilePath());
    this.mPlayerBase = createPlayerBase();
    if (this.mPlayerBase == null) {
      throw new RuntimeException("error , create player failed");
    }
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(100, paramLong);
    this.mPlayerBase.setPlayerOptionalParam(localTPOptionalParam);
    this.mPlayerBase.prepare();
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    this.mLogger.error("addAudioTrackSource not supported.");
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mLogger.error("addSubtitleSource not supported.");
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    if (this.mPlayerBase != null) {
      this.mPlayerBase.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
    }
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mLogger.error("deselectTrack not supported.");
  }
  
  public long getCurrentPositionMs()
  {
    long l = 0L;
    int i = 0;
    while ((i < this.mClipList.size()) && (i < this.mCurrentClip))
    {
      l += ((ITPMediaTrackClip)this.mClipList.get(i)).getOriginalDurationMs();
      i += 1;
    }
    if (!this.mStateChecker.validStateCall(12)) {
      return l;
    }
    return l + this.mPlayerBase.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    Iterator localIterator = this.mClipList.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((ITPMediaTrackClip)localIterator.next()).getOriginalDurationMs() + l) {}
    return l;
  }
  
  public int getNativePlayerId()
  {
    return 0;
  }
  
  public long getPlayableDurationMs()
  {
    if (!this.mStateChecker.validStateCall(15))
    {
      if (this.mTPPlaybackInfo != null) {
        return this.mTPPlaybackInfo.getPlayableDurationMs();
      }
      return 0L;
    }
    return this.mPlayerBase.getPlayableDurationMs();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    this.mLogger.error("getProgramInfo not supported.");
    return new TPProgramInfo[0];
  }
  
  public long getPropertyLong(int paramInt)
    throws IllegalStateException
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getPropertyLong(paramInt);
    }
    return -1L;
  }
  
  public String getPropertyString(int paramInt)
    throws IllegalStateException
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getPropertyString(paramInt);
    }
    return "";
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    this.mLogger.error("getTrackInfo not supported.");
    return new TPTrackInfo[0];
  }
  
  public int getVideoHeight()
  {
    if (this.mTPPlaybackInfo == null) {}
    do
    {
      return 0;
      if (this.mTPPlaybackInfo.getHeight() > 0L) {
        return (int)this.mTPPlaybackInfo.getHeight();
      }
    } while (!this.mStateChecker.validStateCall(13));
    this.mTPPlaybackInfo.setHeight(this.mPlayerBase.getVideoHeight());
    return (int)this.mTPPlaybackInfo.getHeight();
  }
  
  public int getVideoWidth()
  {
    if (this.mTPPlaybackInfo == null) {}
    do
    {
      return 0;
      if (this.mTPPlaybackInfo.getWidth() > 0L) {
        return (int)this.mTPPlaybackInfo.getWidth();
      }
    } while (!this.mStateChecker.validStateCall(13));
    this.mTPPlaybackInfo.setWidth(this.mPlayerBase.getVideoWidth());
    return (int)this.mTPPlaybackInfo.getWidth();
  }
  
  public void pause()
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(6)) {
      return;
    }
    if (this.mPlayerBase == null) {
      throw new IllegalStateException("error , pause , player is null");
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
      return;
    }
    if (!this.mPlayerInitParams.validDataSource()) {
      throw new IOException("error , prepare , data source invalid");
    }
    this.mPlayerBase = createPlayerBase();
    if (this.mPlayerBase == null) {
      throw new RuntimeException("error , create player failed");
    }
    this.mPlayerState.changeState(3);
    this.mPlayerBase.prepare();
  }
  
  public void prepareAsync()
    throws IllegalStateException, IOException
  {
    if (!this.mStateChecker.validStateCall(1)) {
      return;
    }
    if (!this.mPlayerInitParams.validDataSource()) {
      throw new IllegalStateException("error , prepare , state invalid , data source invalid");
    }
    this.mPlayerBase = createPlayerBase();
    if (this.mPlayerBase == null) {
      throw new RuntimeException("error , create player failed");
    }
    this.mPlayerState.changeState(3);
    this.mPlayerBase.prepareAsync();
  }
  
  public void release()
  {
    this.mLogger.info("release, current state:" + this.mPlayerState);
    if (this.mPlayerBase != null)
    {
      this.mPlayerBase.release();
      this.mPlayerBase = null;
    }
    this.mPlayerInitParams.reset();
    this.mPlayerListeners.clear();
    this.mPlayerState.changeState(11);
  }
  
  public void reset()
  {
    this.mLogger.info("reset, current state:" + this.mPlayerState);
    if (this.mPlayerBase != null) {
      this.mPlayerBase.reset();
    }
    this.mPlayerInitParams.reset();
    this.mPlayerListeners.clear();
    this.mPlayerState.changeState(1);
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(9)) {}
    do
    {
      return;
      if ((paramInt < getCurrentClip().getStartPositionMs()) || (paramInt > getCurrentClip().getStartPositionMs() + getCurrentClip().getOriginalDurationMs())) {
        break;
      }
    } while (this.mPlayerBase == null);
    this.mLogger.debug("seek to:" + paramInt);
    this.mPlayerBase.seekTo((int)(paramInt - getCurrentClip().getStartPositionMs()));
    return;
    selectClipPlayer(paramInt);
  }
  
  public void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(9)) {}
    do
    {
      return;
      if ((paramInt1 < getCurrentClip().getStartPositionMs()) || (paramInt1 > getCurrentClip().getStartPositionMs() + getCurrentClip().getOriginalDurationMs())) {
        break;
      }
    } while (this.mPlayerBase == null);
    this.mLogger.debug("seek to:" + paramInt1 + "/mode=" + paramInt2);
    this.mPlayerBase.seekTo((int)(paramInt1 - getCurrentClip().getStartPositionMs()), paramInt2);
    return;
    selectClipPlayer(paramInt1);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mLogger.error("selectProgram not supported.");
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mLogger.error("selectTrack not supported.");
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setAudioGainRatio(paramFloat);
    }
    this.mPlayerInitParams.setAudioGainRatio(paramFloat);
  }
  
  public void setAudioNormalizeVolumeParams(String paramString) {}
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mPlayerInitParams.setDataSource(paramParcelFileDescriptor);
    this.mPlayerState.changeState(2);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    paramITPMediaAsset = getClipListWithAsset(paramITPMediaAsset);
    try
    {
      this.mClipList = paramITPMediaAsset;
      this.mPlayerInitParams.setDataSource(((ITPMediaTrackClip)this.mClipList.get(this.mCurrentClip)).getFilePath());
      this.mPlayerState.changeState(2);
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      this.mLogger.printException(paramITPMediaAsset);
      throw new IllegalStateException("exception when system clip player set data source!");
    }
  }
  
  public void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    setDataSource(paramString, null);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mPlayerInitParams.setDataSource(paramString, paramMap);
    this.mPlayerState.changeState(2);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setLoopback(paramBoolean);
    }
    this.mPlayerInitParams.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    this.mPlayerInitParams.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
    throws IllegalStateException
  {
    throw new IllegalStateException("system Mediaplayer cannot support audio frame out");
  }
  
  public void setOnAudioProcessOutputListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
    throws IllegalStateException
  {
    throw new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
  }
  
  public void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mPlayerListeners.setOnCompletionListener(paramIOnCompletionListener);
  }
  
  public void setOnDetailInfoListener(ITPPlayerBaseListener.IOnDetailInfoListener paramIOnDetailInfoListener) {}
  
  public void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener)
  {
    this.mPlayerListeners.setOnErrorListener(paramIOnErrorListener);
  }
  
  public void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener)
  {
    this.mPlayerListeners.setOnInfoListener(paramIOnInfoListener);
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
  
  public void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener) {}
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
    throws IllegalStateException
  {
    throw new IllegalStateException("system Mediaplayer cannot support video frame out");
  }
  
  public void setOnVideoProcessOutputListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
    throws IllegalStateException
  {
    throw new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mPlayerListeners.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setOutputMute(paramBoolean);
    }
    this.mPlayerInitParams.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setPlaySpeedRatio(paramFloat);
    }
    this.mPlayerInitParams.setSpeedRatio(paramFloat);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("setPlayerOptionalParam , state invalid");
    }
    if (paramTPOptionalParam.getKey() == 100)
    {
      int j = (int)paramTPOptionalParam.getParamLong().value;
      this.mLogger.debug("start position:" + j);
      int i = 0;
      while (i < this.mClipList.size())
      {
        if ((((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs() <= j) && (j <= ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.mClipList.get(i)).getOriginalDurationMs()))
        {
          this.mCurrentClip = i;
          this.mPlayerInitParams.setDataSource(((ITPMediaTrackClip)this.mClipList.get(i)).getFilePath());
          paramTPOptionalParam.getParamLong().value = (j - ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs());
        }
        i += 1;
      }
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setPlayerOptionalParam(paramTPOptionalParam);
    }
    this.mPlayerInitParams.addOptionalParams(paramTPOptionalParam);
  }
  
  public void setSurface(Surface paramSurface)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(4)) {
      throw new IllegalStateException("setSurface , state invalid");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setSurface(paramSurface);
    }
    this.mPlayerInitParams.setSurface(paramSurface);
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(4)) {
      throw new IllegalStateException("setSurfaceHolder , state invalid");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setSurfaceHolder(paramSurfaceHolder);
    }
    this.mPlayerInitParams.setSurfaceHolder(paramSurfaceHolder);
  }
  
  public void start()
    throws IllegalStateException
  {
    if (!this.mStateChecker.validStateCall(5)) {
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
    if (!this.mStateChecker.validStateCall(7)) {
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
      throw new IllegalStateException("error , pause ,state invalid");
    }
    finally
    {
      this.mPlayerState.changeState(9);
    }
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException
  {
    paramITPMediaAsset = getClipListWithAsset(paramITPMediaAsset);
    if (TPCommonUtils.isEmpty(paramITPMediaAsset)) {
      throw new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
    }
    long l = getCurrentPositionMs();
    try
    {
      this.mClipList = paramITPMediaAsset;
      this.isSwitchingDef = true;
      if (TPCommonUtils.isEmpty(this.mSwitchingDefTagQueue)) {
        this.mSwitchingDefTagQueue = new LinkedList();
      }
      this.mSwitchingDefTagQueue.offer(Long.valueOf(paramLong));
      this.mLogger.info("try to switch definition with system clip player, current clipNo:" + this.mCurrentClip);
      selectClipPlayer((int)l);
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      this.mLogger.printException(paramITPMediaAsset);
      throw new IllegalStateException("exception when system clip player switch definition!");
    }
  }
  
  public void switchDefinition(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException
  {}
  
  public void switchDefinition(String paramString, Map<String, String> paramMap, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException
  {}
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this.mLogger.updateContext(new TPLoggerContext(paramTPLoggerContext, "TPSystemClipPlayer"));
    if ((this.mPlayerListeners != null) && (paramTPLoggerContext != null)) {
      this.mPlayerListeners.updateTag(this.mLogger.getTPLoggerContext().getTag());
    }
  }
  
  class TPPlayerBaseCallback
    implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnAudioProcessOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoProcessOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
  {
    private TPPlayerBaseCallback() {}
    
    public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      TPSystemClipPlayer.this.handleOnAudioFrameOut(paramTPAudioFrameBuffer);
    }
    
    public TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      return TPSystemClipPlayer.this.handleOnAudioProcessFrameOut(paramTPPostProcessFrameBuffer);
    }
    
    public void onCompletion()
    {
      TPSystemClipPlayer.this.handleOnComplete();
    }
    
    public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      TPSystemClipPlayer.this.handleOnError(paramInt1, paramInt2, paramLong1, paramLong2);
    }
    
    public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      TPSystemClipPlayer.this.handleOnInfo(paramInt, paramLong1, paramLong2, paramObject);
    }
    
    public void onPrepared()
    {
      TPSystemClipPlayer.this.handleOnPrepared();
    }
    
    public void onSeekComplete()
    {
      TPSystemClipPlayer.this.handleOnSeekComplete();
    }
    
    public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
    {
      TPSystemClipPlayer.this.handleOnSubtitleData(paramTPSubtitleData);
    }
    
    public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      TPSystemClipPlayer.this.handleOnVideoFrameOut(paramTPVideoFrameBuffer);
    }
    
    public TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      return TPSystemClipPlayer.this.handleOnVideoProcessFrameOut(paramTPPostProcessFrameBuffer);
    }
    
    public void onVideoSizeChanged(long paramLong1, long paramLong2)
    {
      TPSystemClipPlayer.this.handleOnVideoSizeChange(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemClipPlayer
 * JD-Core Version:    0.7.0.1
 */