package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.adapter.player.ITPCapture;
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
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapAudioDecoderType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapErrorType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapMsgInfo;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapPropertyId;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSeekMode;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSwitchDefMode;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapVideoDecoderType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeErrorType;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeMsgInfo;
import com.tencent.thumbplayer.api.TPCommonEnum.TPOptionalId;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamFloat;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamObject;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueInt;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueString;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamString;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.caputure.TPThumbCapture;
import com.tencent.thumbplayer.core.common.TPDetailInfo;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaDrmInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoSeiInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.core.player.TPNativePlayerProgramInfo;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.log.TPLoggerContext;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public class TPThumbPlayer
  implements ITPPlayerBase
{
  private static final int EVENT_MSG_ASYNC_CALL = 1;
  private static final int EVENT_MSG_ON_DETAIL_INFO = 5;
  private static final int EVENT_MSG_ON_ERROR = 4;
  private static final int EVENT_MSG_ON_INFO_LONG = 2;
  private static final int EVENT_MSG_ON_INFO_OBJECT = 3;
  private static final String TAG = "TPThumbPlayer";
  private EventHandler mEventHandler;
  private ITPCapture mImageGenerator;
  private TPBaseLogger mLogger;
  private ITPNativePlayerAudioFrameCallback mNativeAudioFrameCallback = new TPThumbPlayer.2(this);
  private TPNativePlayerInitConfig mNativeInitConfig;
  private ITPNativePlayerMessageCallback mNativeMessageCallback = new TPThumbPlayer.1(this);
  private ITPNativePlayerPostProcessFrameCallback mNativePostProcessFrameCallback = new TPThumbPlayer.5(this);
  private ITPNativePlayerSubtitleFrameCallback mNativeSubtitleFrameCallback = new TPThumbPlayer.4(this);
  private ITPNativePlayerVideoFrameCallback mNativeVideoFrameCallback = new TPThumbPlayer.3(this);
  private TPNativePlayer mPlayer;
  private TPPlayerBaseListeners mPlayerListenerReps;
  private TPSubtitleData mSubtitleData = new TPSubtitleData();
  
  public TPThumbPlayer(Context paramContext, TPLoggerContext paramTPLoggerContext)
    throws UnsupportedOperationException
  {
    this.mLogger = new TPBaseLogger(paramTPLoggerContext, "TPThumbPlayer");
    this.mPlayer = new TPNativePlayer(paramContext);
    this.mPlayer.setMessageCallback(this.mNativeMessageCallback);
    this.mPlayer.setAudioFrameCallback(this.mNativeAudioFrameCallback);
    this.mPlayer.setVideoFrameCallback(this.mNativeVideoFrameCallback);
    this.mPlayer.setSubtitleFrameCallback(this.mNativeSubtitleFrameCallback);
    this.mPlayer.setPostProcessFrameCallback(this.mNativePostProcessFrameCallback);
    this.mNativeInitConfig = new TPNativePlayerInitConfig();
    this.mPlayerListenerReps = new TPPlayerBaseListeners(this.mLogger.getTag());
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.mEventHandler = new EventHandler(paramContext, this);
      return;
    }
    paramContext = Looper.getMainLooper();
    if (paramContext != null)
    {
      this.mEventHandler = new EventHandler(paramContext, this);
      return;
    }
    this.mEventHandler = null;
  }
  
  private void handleCommonASyncCallResult(OnASyncCallResultInfo paramOnASyncCallResultInfo)
  {
    this.mPlayerListenerReps.onInfo(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, paramOnASyncCallResultInfo.callType), paramOnASyncCallResultInfo.errorType, paramOnASyncCallResultInfo.errorCode, Long.valueOf(paramOnASyncCallResultInfo.opaque));
  }
  
  private void handleOnComplete()
  {
    this.mPlayerListenerReps.onCompletion();
  }
  
  private void handleOnInfoLongNoConvertToListener(@TPCommonEnum.NativeErrorType int paramInt, OnInfoLongInfo paramOnInfoLongInfo)
  {
    int i = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, paramInt);
    if (i < 0)
    {
      this.mLogger.warn("msgType:" + paramInt + ", cannot convert to thumbPlayer Info");
      return;
    }
    long l1 = paramOnInfoLongInfo.lParam1;
    long l2 = paramOnInfoLongInfo.lParam2;
    switch (i)
    {
    default: 
      this.mLogger.warn("unhandled thumbPlayerInfo=" + i);
    }
    for (;;)
    {
      this.mPlayerListenerReps.onInfo(i, l1, l2, null);
      return;
      l1 = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapVideoDecoderType.class, (int)paramOnInfoLongInfo.lParam1);
      continue;
      l1 = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapAudioDecoderType.class, (int)paramOnInfoLongInfo.lParam1);
    }
  }
  
  private void handleOnInfoObjectNoConvertToListener(@TPCommonEnum.NativeMsgInfo int paramInt, OnInfoObjectInfo paramOnInfoObjectInfo)
  {
    int i = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, paramInt);
    if (i < 0)
    {
      this.mLogger.warn("msgType:" + paramInt + ", cannot convert to thumbPlayer Info");
      return;
    }
    Object localObject2 = paramOnInfoObjectInfo.objParam;
    Object localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      this.mPlayerListenerReps.onInfo(i, 0L, 0L, localObject1);
      return;
      localObject1 = localObject2;
      if (paramOnInfoObjectInfo.objParam != null)
      {
        localObject1 = TPThumbPlayerUtils.convert2TPVideoCropInfo((ITPNativePlayerMessageCallback.VideoCropInfo)paramOnInfoObjectInfo.objParam);
        continue;
        localObject1 = localObject2;
        if (paramOnInfoObjectInfo.objParam != null)
        {
          localObject1 = TPThumbPlayerUtils.convert2TPMediaCodecInfo((ITPNativePlayerMessageCallback.MediaCodecInfo)paramOnInfoObjectInfo.objParam);
          continue;
          localObject1 = localObject2;
          if (paramOnInfoObjectInfo.objParam != null)
          {
            localObject1 = TPThumbPlayerUtils.convert2TPVideoSeiInfo((ITPNativePlayerMessageCallback.VideoSeiInfo)paramOnInfoObjectInfo.objParam);
            continue;
            localObject1 = localObject2;
            if (paramOnInfoObjectInfo.objParam != null) {
              localObject1 = TPThumbPlayerUtils.convert2TPMediaDrmInfo((ITPNativePlayerMessageCallback.MediaDrmInfo)paramOnInfoObjectInfo.objParam);
            }
          }
        }
      }
    }
  }
  
  private void handleOnPrepared()
  {
    this.mPlayerListenerReps.onPrepared();
  }
  
  private void handleOnSeekComplete()
  {
    this.mPlayerListenerReps.onSeekComplete();
  }
  
  private void handleOnVideoSizeChanged(long paramLong1, long paramLong2)
  {
    this.mPlayerListenerReps.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  private TPProgramInfo programInfoConvert(TPNativePlayerProgramInfo paramTPNativePlayerProgramInfo)
  {
    if (paramTPNativePlayerProgramInfo != null)
    {
      TPProgramInfo localTPProgramInfo = new TPProgramInfo();
      localTPProgramInfo.url = paramTPNativePlayerProgramInfo.url;
      localTPProgramInfo.bandwidth = paramTPNativePlayerProgramInfo.bandwidth;
      localTPProgramInfo.resolution = paramTPNativePlayerProgramInfo.resolution;
      localTPProgramInfo.programId = paramTPNativePlayerProgramInfo.programId;
      localTPProgramInfo.actived = paramTPNativePlayerProgramInfo.actived;
      return localTPProgramInfo;
    }
    return null;
  }
  
  private void setPlayerInitConfigWithParamBoolean(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamBoolean paramOptionalParamBoolean)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localOptionIdMapping.isIllegal())
    {
      this.mLogger.error("player optionalIdMapping boolean is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getOptionalIDType())
    {
    default: 
      this.mLogger.error("optionID type:" + localOptionIdMapping.getOptionalIDType() + " is not implement");
      return;
    }
    this.mNativeInitConfig.setBool(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamBoolean.value);
  }
  
  private void setPlayerInitConfigWithParamFloat(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamFloat paramOptionalParamFloat)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localOptionIdMapping.isIllegal())
    {
      this.mLogger.error("player optionalIdMapping float is invalid, not found in array, id: " + paramInt);
      return;
    }
    if (7 != localOptionIdMapping.getOptionalIDType())
    {
      this.mLogger.error("optionID:" + localOptionIdMapping.getNativePlayerOptionalID() + " is not float");
      return;
    }
    this.mNativeInitConfig.setFloat(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamFloat.value);
  }
  
  private void setPlayerInitConfigWithParamLong(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamLong paramOptionalParamLong)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localOptionIdMapping.isIllegal())
    {
      this.mLogger.error("player optionalIdMapping long is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getOptionalIDType())
    {
    case 2: 
    default: 
      this.mLogger.error("optionID type:" + localOptionIdMapping.getOptionalIDType() + " is not implement");
      return;
    case 1: 
      this.mNativeInitConfig.setLong(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamLong.value);
      return;
    case 4: 
      this.mNativeInitConfig.setInt(localOptionIdMapping.getNativePlayerOptionalID(), (int)paramOptionalParamLong.value);
      return;
    }
    TPNativePlayerInitConfig localTPNativePlayerInitConfig = this.mNativeInitConfig;
    paramInt = localOptionIdMapping.getNativePlayerOptionalID();
    if (paramOptionalParamLong.value > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localTPNativePlayerInitConfig.setBool(paramInt, bool);
      return;
    }
  }
  
  private void setPlayerInitConfigWithParamQueueInt(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueInt paramOptionalParamQueueInt)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localOptionIdMapping.isIllegal()) {
      this.mLogger.error("player optionalIdMapping queue_int is invalid, not found in array, id: " + paramInt);
    }
    for (;;)
    {
      return;
      if ((paramOptionalParamQueueInt.queueValue == null) || (paramOptionalParamQueueInt.queueValue.length == 0))
      {
        this.mLogger.error("queueint params is empty in" + paramInt);
        return;
      }
      switch (localOptionIdMapping.getOptionalIDType())
      {
      default: 
        this.mLogger.error("optionID type:" + localOptionIdMapping.getOptionalIDType() + " is not implement");
        return;
      }
      paramInt = 0;
      while (paramInt < paramOptionalParamQueueInt.queueValue.length)
      {
        this.mNativeInitConfig.addQueueInt(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamQueueInt.queueValue[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  private void setPlayerInitConfigWithParamQueueString(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueString paramOptionalParamQueueString)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localOptionIdMapping.isIllegal()) {
      this.mLogger.error("player optionalIdMapping queue_string is invalid, not found in array, id: " + paramInt);
    }
    for (;;)
    {
      return;
      if ((paramOptionalParamQueueString.queueValue == null) || (paramOptionalParamQueueString.queueValue.length == 0))
      {
        this.mLogger.error("queue String params is empty in" + paramInt);
        return;
      }
      switch (localOptionIdMapping.getOptionalIDType())
      {
      default: 
        this.mLogger.error("optionID type:" + localOptionIdMapping.getOptionalIDType() + " is not implement");
        return;
      }
      paramInt = 0;
      while (paramInt < paramOptionalParamQueueString.queueValue.length)
      {
        this.mNativeInitConfig.addQueueString(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamQueueString.queueValue[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  private void setPlayerInitConfigWithParamString(int paramInt, TPOptionalParam.OptionalParamString paramOptionalParamString)
  {
    this.mLogger.error("init string param type is not implement coz native init config no string setting");
  }
  
  private void setPlayerOptionWithParamBoolean(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamBoolean paramOptionalParamBoolean)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localOptionIdMapping.isIllegal())
    {
      this.mLogger.error("player optionalIdMapping string is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getOptionalIDType())
    {
    default: 
      this.mLogger.error("optionID type:" + localOptionIdMapping.getOptionalIDType() + " is not implement");
      return;
    }
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    paramInt = localOptionIdMapping.getNativePlayerOptionalID();
    if (paramOptionalParamBoolean.value) {}
    for (long l = 1L;; l = 0L)
    {
      localTPNativePlayer.setOptionLong(paramInt, l, 0L);
      return;
    }
  }
  
  private void setPlayerOptionWithParamLong(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamLong paramOptionalParamLong)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localOptionIdMapping.isIllegal())
    {
      this.mLogger.error("player optionalIdMapping long is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getOptionalIDType())
    {
    case 2: 
    default: 
      this.mLogger.error("optionID type:" + localOptionIdMapping.getOptionalIDType() + " is not implement");
      return;
    }
    this.mPlayer.setOptionLong(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamLong.value, paramOptionalParamLong.param1);
  }
  
  private void setPlayerOptionWithParamObject(int paramInt, TPOptionalParam.OptionalParamObject paramOptionalParamObject)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localOptionIdMapping == null)
    {
      this.mLogger.error("player optionaIdMapping object is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getNativePlayerOptionalID())
    {
    default: 
      this.mLogger.error("optionID type:" + localOptionIdMapping.getOptionalIDType() + " is not implement");
      return;
    }
    paramOptionalParamObject = TPThumbPlayerUtils.convert2TPNativeSubtitleRenderParams((TPSubtitleRenderModel)paramOptionalParamObject.objectValue);
    this.mPlayer.setOptionObject(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamObject);
  }
  
  private void setPlayerOptionWithParamString(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamString paramOptionalParamString)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localOptionIdMapping.isIllegal())
    {
      this.mLogger.error("player optionalIdMapping string is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getOptionalIDType())
    {
    default: 
      this.mLogger.error("optionID type:" + localOptionIdMapping.getOptionalIDType() + " is not implement");
      return;
    }
    this.mPlayer.setOptionObject(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamString.value);
  }
  
  private void throwExceptionIfPlayerReleased()
    throws IllegalStateException
  {
    if (this.mPlayer == null) {
      throw new IllegalStateException("player has release");
    }
  }
  
  private TPTrackInfo trackInfoConvert(TPMediaTrackInfo paramTPMediaTrackInfo)
  {
    TPTrackInfo localTPTrackInfo = new TPTrackInfo();
    localTPTrackInfo.name = paramTPMediaTrackInfo.trackName;
    localTPTrackInfo.trackType = paramTPMediaTrackInfo.trackType;
    localTPTrackInfo.isExclusive = paramTPMediaTrackInfo.isExclusive;
    localTPTrackInfo.isSelected = paramTPMediaTrackInfo.isSelected;
    localTPTrackInfo.isInternal = paramTPMediaTrackInfo.isInternal;
    return localTPTrackInfo;
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    this.mLogger.info("addAudioTrackSource");
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    paramList = new TPPlayerMsg.TPAudioTrackInfo();
    paramList.audioTrackUrl = paramString1;
    paramString1 = this.mPlayerListenerReps;
    if (paramString1 != null) {
      paramString1.onInfo(1012, 0L, 0L, paramList);
    }
    if (TextUtils.isEmpty(paramList.proxyUrl))
    {
      this.mPlayer.addAudioTrackSource(paramList.audioTrackUrl, paramString2);
      return;
    }
    this.mPlayer.addAudioTrackSource(paramList.proxyUrl, paramString2);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mLogger.info("addSubtitleSource");
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    this.mPlayer.addSubtitleTrackSource(paramString1, paramString3);
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    this.mLogger.info("captureVideo, params" + paramTPCaptureParams);
    if (this.mImageGenerator != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      this.mImageGenerator.generateImageAsyncAtTime(paramTPCaptureParams.requestedTimeMs, localTPImageGeneratorParams, paramTPCaptureCallBack);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mLogger.info("selectTrack");
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    this.mPlayer.deselectTrackAsync(paramInt, paramLong);
  }
  
  public long getCurrentPositionMs()
  {
    if (this.mPlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0L;
    }
    return this.mPlayer.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    if (this.mPlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0L;
    }
    return this.mPlayer.getDurationMs();
  }
  
  public int getNativePlayerId()
  {
    if (this.mPlayer != null) {
      return this.mPlayer.getNativePlayerId();
    }
    return 0;
  }
  
  public long getPlayableDurationMs()
  {
    if (this.mPlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0L;
    }
    return this.mPlayer.getBufferedDurationMs() + this.mPlayer.getCurrentPositionMs();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    this.mLogger.info("getProgramInfo");
    if (this.mPlayer == null) {
      this.mLogger.info("player has released, return 0");
    }
    TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo;
    do
    {
      return null;
      arrayOfTPNativePlayerProgramInfo = this.mPlayer.getProgramInfo();
    } while ((arrayOfTPNativePlayerProgramInfo == null) || (arrayOfTPNativePlayerProgramInfo.length < 1));
    TPProgramInfo[] arrayOfTPProgramInfo = new TPProgramInfo[arrayOfTPNativePlayerProgramInfo.length];
    int i = 0;
    while (i < arrayOfTPNativePlayerProgramInfo.length)
    {
      arrayOfTPProgramInfo[i] = programInfoConvert(arrayOfTPNativePlayerProgramInfo[i]);
      i += 1;
    }
    return arrayOfTPProgramInfo;
  }
  
  public long getPropertyLong(int paramInt)
    throws IllegalStateException
  {
    this.mLogger.info("getPropertyLong:" + paramInt);
    throwExceptionIfPlayerReleased();
    paramInt = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapPropertyId.class, paramInt);
    if (paramInt < 0)
    {
      this.mLogger.warn("paramId not found, return -1");
      return -1L;
    }
    return this.mPlayer.getPropertyLong(paramInt);
  }
  
  public String getPropertyString(int paramInt)
    throws IllegalStateException
  {
    this.mLogger.info("getPropertyString:" + paramInt);
    throwExceptionIfPlayerReleased();
    int i;
    try
    {
      i = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapPropertyId.class, paramInt);
      if (i < 0)
      {
        this.mLogger.warn("getPropertyString, tpToNativeValue(TPNativeKeyMap.MapPropertyId.class," + paramInt + "), return" + i);
        return "";
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.mLogger.warn("paramId not found, return");
      return "";
    }
    return this.mPlayer.getPropertyString(i);
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    this.mLogger.info("getTrackInfo");
    if (this.mPlayer == null) {
      this.mLogger.info("player has released, return 0");
    }
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo;
    do
    {
      return null;
      arrayOfTPMediaTrackInfo = this.mPlayer.getTrackInfo();
    } while ((arrayOfTPMediaTrackInfo == null) || (arrayOfTPMediaTrackInfo.length < 1));
    TPTrackInfo[] arrayOfTPTrackInfo = new TPTrackInfo[arrayOfTPMediaTrackInfo.length];
    int i = 0;
    while (i < arrayOfTPMediaTrackInfo.length)
    {
      arrayOfTPTrackInfo[i] = trackInfoConvert(arrayOfTPMediaTrackInfo[i]);
      i += 1;
    }
    return arrayOfTPTrackInfo;
  }
  
  public int getVideoHeight()
  {
    this.mLogger.info("getVideoHeight");
    if (this.mPlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0;
    }
    return this.mPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    this.mLogger.info("getVideoWidth");
    if (this.mPlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0;
    }
    return this.mPlayer.getVideoWidth();
  }
  
  public void pause()
    throws IllegalStateException
  {
    this.mLogger.info("pause");
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.pause() != 0) {
      throw new IllegalStateException("pause failed!!");
    }
  }
  
  public void prepare()
    throws IllegalStateException, IOException
  {
    this.mLogger.info("prepare");
    throwExceptionIfPlayerReleased();
    this.mPlayer.setInitConfig(this.mNativeInitConfig);
    if (this.mPlayer.prepare() != 0) {
      throw new IllegalStateException("prepare failed!!");
    }
  }
  
  public void prepareAsync()
    throws IllegalStateException
  {
    this.mLogger.info("prepareAsync");
    throwExceptionIfPlayerReleased();
    this.mPlayer.setInitConfig(this.mNativeInitConfig);
    if (this.mPlayer.prepareAsync() != 0) {
      throw new IllegalStateException("prepareAsync failed!!");
    }
  }
  
  public void release()
  {
    this.mLogger.info("release");
    if (this.mPlayer != null)
    {
      this.mPlayer.release();
      this.mPlayer = null;
    }
    if (this.mImageGenerator != null)
    {
      this.mImageGenerator.release();
      this.mImageGenerator = null;
    }
    if (this.mEventHandler != null)
    {
      this.mEventHandler.removeCallbacksAndMessages(null);
      this.mEventHandler = null;
    }
  }
  
  public void reset()
  {
    this.mLogger.info("reset");
    if (this.mPlayer == null)
    {
      this.mLogger.warn("reset, player has released.");
      return;
    }
    this.mLogger.info("reset before");
    this.mPlayer.reset();
    if (this.mEventHandler != null) {
      this.mEventHandler.removeCallbacksAndMessages(null);
    }
    this.mLogger.info("reset after");
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    this.mLogger.info("seekTo:" + paramInt);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.seekToAsync(paramInt, 1, 0L) != 0) {
      throw new IllegalStateException("seek to position:" + paramInt + " failed!!");
    }
  }
  
  public void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    this.mLogger.info("seekTo:" + paramInt1 + " mode:" + paramInt2);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.seekToAsync(paramInt1, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSeekMode.class, paramInt2), 0L) != 0) {
      throw new IllegalStateException("seek to position:" + paramInt1 + " failed!!");
    }
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mLogger.info("selectProgram, programIndex:" + paramInt);
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    this.mPlayer.selectProgramAsync(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mLogger.info("selectTrack");
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    this.mPlayer.selectTrackAsync(paramInt, paramLong);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    this.mLogger.info("setAudioGainRatio:" + paramFloat);
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    this.mPlayer.setAudioVolume(paramFloat);
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    this.mLogger.info("setAudioNormalizeVolumeParams:" + paramString);
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    this.mPlayer.setAudioNormalizeVolumeParams(paramString);
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    if (paramParcelFileDescriptor == null) {
      throw new IllegalStateException("setDataSource url pfd is null!!");
    }
    int i = paramParcelFileDescriptor.detachFd();
    paramParcelFileDescriptor.close();
    this.mLogger.info("setDataSource: " + paramParcelFileDescriptor + ", fd:" + i);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(i) != 0) {
      throw new IllegalStateException("setDataSource url pfd failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(i);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mLogger.info("setDataSource: " + paramITPMediaAsset);
    throwExceptionIfPlayerReleased();
    if (paramITPMediaAsset == null) {
      throw new IllegalStateException("media asset is null!");
    }
    paramITPMediaAsset = paramITPMediaAsset.getUrl();
    if (this.mPlayer.setDataSource(paramITPMediaAsset) != 0) {
      throw new IllegalStateException("setDataSource mediaAsset failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramITPMediaAsset);
  }
  
  public void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mLogger.info("setDataSource: " + paramString);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramString) != 0) {
      throw new IllegalStateException("setDataSource url failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mLogger.info("setDataSource: " + paramString);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramString, paramMap) != 0) {
      throw new IllegalStateException("setDataSource url and header failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    this.mLogger.info("setLoopback:" + paramBoolean);
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    this.mPlayer.setLoopback(paramBoolean, 0L, -1L);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
    throws IllegalStateException
  {
    this.mLogger.info("setLoopback:" + paramBoolean + " loopStartPositionMs:" + paramLong1 + " loopEndPositionMs:" + paramLong2);
    if (this.mPlayer == null) {
      this.mLogger.warn("player has released, return");
    }
    while (this.mPlayer.setLoopback(paramBoolean, paramLong1, paramLong2) == 0) {
      return;
    }
    throw new IllegalStateException("set loopback failed!!");
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
    throws IllegalStateException
  {
    this.mPlayerListenerReps.setOnAudioPcmOutListener(paramIOnAudioPcmOutListener);
  }
  
  public void setOnAudioProcessOutputListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
    throws IllegalStateException
  {
    this.mPlayerListenerReps.setOnAudioProcessFrameListener(paramIOnAudioProcessOutListener);
  }
  
  public void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mPlayerListenerReps.setOnCompletionListener(paramIOnCompletionListener);
  }
  
  public void setOnDetailInfoListener(ITPPlayerBaseListener.IOnDetailInfoListener paramIOnDetailInfoListener)
  {
    this.mPlayerListenerReps.setOnDetailInfoListener(paramIOnDetailInfoListener);
  }
  
  public void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener)
  {
    this.mPlayerListenerReps.setOnErrorListener(paramIOnErrorListener);
  }
  
  public void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener)
  {
    this.mPlayerListenerReps.setOnInfoListener(paramIOnInfoListener);
  }
  
  public void setOnPreparedListener(ITPPlayerBaseListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.mPlayerListenerReps.setOnPreparedListener(paramIOnPreparedListener);
  }
  
  public void setOnSeekCompleteListener(ITPPlayerBaseListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.mPlayerListenerReps.setOnSeekCompleteListener(paramIOnSeekCompleteListener);
  }
  
  public void setOnSubtitleDataListener(ITPPlayerBaseListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    this.mPlayerListenerReps.setOnSubtitleDataListener(paramIOnSubtitleDataListener);
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    this.mPlayerListenerReps.setOnSubtitleFrameOutListener(paramIOnSubtitleFrameOutListener);
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
    throws IllegalStateException
  {
    this.mPlayerListenerReps.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
  }
  
  public void setOnVideoProcessOutputListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
    throws IllegalStateException
  {
    this.mPlayerListenerReps.setOnVideoProcessFrameListener(paramIOnVideoProcessOutListener);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mPlayerListenerReps.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    this.mLogger.info("setOutputMute:" + paramBoolean);
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    this.mPlayer.setAudioMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    this.mLogger.info("setPlaySpeedRatio:" + paramFloat);
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    this.mPlayer.setPlaybackRate(paramFloat);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    this.mLogger.info("setPlayerOptionalParam:" + paramTPOptionalParam);
    if (this.mPlayer == null) {
      this.mLogger.warn("player has released, return");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramTPOptionalParam.getParamType() == 1)
            {
              if (paramTPOptionalParam.getKey() < 500)
              {
                setPlayerInitConfigWithParamBoolean(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamBoolean());
                return;
              }
              setPlayerOptionWithParamBoolean(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamBoolean());
              return;
            }
            if (paramTPOptionalParam.getParamType() == 2)
            {
              if (paramTPOptionalParam.getKey() < 500)
              {
                setPlayerInitConfigWithParamLong(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamLong());
                return;
              }
              setPlayerOptionWithParamLong(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamLong());
              return;
            }
            if (paramTPOptionalParam.getParamType() != 6) {
              break;
            }
          } while (paramTPOptionalParam.getKey() >= 500);
          setPlayerInitConfigWithParamFloat(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamFloat());
          return;
          if (paramTPOptionalParam.getParamType() == 3)
          {
            if (paramTPOptionalParam.getKey() < 500)
            {
              setPlayerInitConfigWithParamString(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamString());
              return;
            }
            setPlayerOptionWithParamString(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamString());
            return;
          }
          if (paramTPOptionalParam.getParamType() != 4) {
            break;
          }
        } while (paramTPOptionalParam.getKey() >= 500);
        setPlayerInitConfigWithParamQueueInt(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueInt());
        return;
        if (paramTPOptionalParam.getParamType() != 5) {
          break;
        }
      } while (paramTPOptionalParam.getKey() >= 500);
      setPlayerInitConfigWithParamQueueString(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueString());
      return;
      if (paramTPOptionalParam.getParamType() != 7) {
        break;
      }
    } while (paramTPOptionalParam.getKey() < 500);
    setPlayerOptionWithParamObject(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamObject());
    return;
    this.mLogger.warn("optionalParam param type is unknown, return");
  }
  
  public void setSurface(Surface paramSurface)
    throws IllegalStateException
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder().append("setSurface, surface is null ? : ");
    boolean bool;
    if (paramSurface == null)
    {
      bool = true;
      localTPBaseLogger.info(bool);
      if (this.mPlayer != null) {
        break label62;
      }
      this.mLogger.warn("player has released, return");
    }
    label62:
    while (this.mPlayer.setVideoSurface(paramSurface) == 0)
    {
      return;
      bool = false;
      break;
    }
    throw new IllegalStateException("setSurface failed!!");
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
    throws IllegalStateException
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder().append("SurfaceHolder, surfaceHolder is null ? : ");
    boolean bool;
    if (paramSurfaceHolder == null)
    {
      bool = true;
      localTPBaseLogger.info(bool);
      if (this.mPlayer != null) {
        break label62;
      }
      this.mLogger.warn("player has released, return");
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label62:
      if ((paramSurfaceHolder != null) && (paramSurfaceHolder.getSurface() == null))
      {
        this.mLogger.error("SurfaceHolder，err.");
        return;
      }
      if (paramSurfaceHolder == null) {}
      for (paramSurfaceHolder = null; this.mPlayer.setVideoSurface(paramSurfaceHolder) != 0; paramSurfaceHolder = paramSurfaceHolder.getSurface()) {
        throw new IllegalStateException("setSurface failed!!");
      }
    }
  }
  
  public void start()
    throws IllegalStateException
  {
    this.mLogger.info("start");
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.start() != 0) {
      throw new IllegalStateException("start failed!!");
    }
  }
  
  public void stop()
    throws IllegalStateException
  {
    this.mLogger.info("stop");
    throwExceptionIfPlayerReleased();
    this.mLogger.info("stop before");
    int i = this.mPlayer.stop();
    this.mLogger.info("stop after");
    if (i != 0) {
      throw new IllegalStateException("stop failed!!");
    }
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException
  {
    this.mLogger.info("switchDefinition mediaAsset:" + paramITPMediaAsset + " opaque:" + paramLong);
    throwExceptionIfPlayerReleased();
    if (paramITPMediaAsset != null)
    {
      paramInt = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, paramInt);
      if (this.mPlayer.switchDefinitionAsync(paramITPMediaAsset.getUrl(), paramInt, paramLong) != 0) {
        throw new IllegalStateException("switchDefinition in invalid state");
      }
      this.mImageGenerator = new TPThumbCapture(paramITPMediaAsset.getUrl());
    }
  }
  
  public void switchDefinition(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException
  {
    this.mLogger.info("switchDefinition url:" + paramString + " opaque:" + paramLong);
    throwExceptionIfPlayerReleased();
    paramInt = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, paramInt);
    if (this.mPlayer.switchDefinitionAsync(paramString, paramInt, paramLong) != 0) {
      throw new IllegalStateException("switchDefinition in invalid state");
    }
    if (this.mImageGenerator != null)
    {
      this.mImageGenerator.release();
      this.mImageGenerator = null;
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
  
  public void switchDefinition(String paramString, Map<String, String> paramMap, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
    throws IllegalStateException
  {
    this.mLogger.info("switchDefinition url:" + paramString + "httpHeader:" + paramMap + " opaque:" + paramLong);
    throwExceptionIfPlayerReleased();
    paramInt = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, paramInt);
    if (this.mPlayer.switchDefinitionAsync(paramString, paramMap, paramInt, paramLong) != 0) {
      throw new IllegalStateException("switchDefinition in invalid state");
    }
    if (this.mImageGenerator != null)
    {
      this.mImageGenerator.release();
      this.mImageGenerator = null;
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this.mLogger.updateContext(new TPLoggerContext(paramTPLoggerContext, "TPThumbPlayer"));
    if (paramTPLoggerContext != null) {
      this.mPlayerListenerReps.updateTag(this.mLogger.getTPLoggerContext().getTag());
    }
  }
  
  class EventHandler
    extends Handler
  {
    private WeakReference<TPThumbPlayer> mWeakRef;
    
    public EventHandler(Looper paramLooper, TPThumbPlayer paramTPThumbPlayer)
    {
      super();
      this.mWeakRef = new WeakReference(paramTPThumbPlayer);
    }
    
    private void handleOnAsyncCallResult(TPThumbPlayer.OnASyncCallResultInfo paramOnASyncCallResultInfo)
    {
      switch (paramOnASyncCallResultInfo.callType)
      {
      default: 
        TPThumbPlayer.this.handleCommonASyncCallResult(paramOnASyncCallResultInfo);
        return;
      case 1: 
        TPThumbPlayer.this.handleOnPrepared();
        return;
      }
      TPThumbPlayer.this.handleOnSeekComplete();
    }
    
    private void handleOnDetailInfo(TPDetailInfo paramTPDetailInfo)
    {
      paramTPDetailInfo = TPThumbPlayerUtils.convert2TPPlayerDetailInfo(paramTPDetailInfo);
      TPThumbPlayer.this.mPlayerListenerReps.onDetailInfo(paramTPDetailInfo);
    }
    
    private void handleOnError(@TPCommonEnum.NativeErrorType int paramInt1, int paramInt2)
    {
      TPThumbPlayer.this.mPlayerListenerReps.onError(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapErrorType.class, paramInt1), paramInt2, 0L, 0L);
    }
    
    private void handleOnInfoLong(TPThumbPlayer.OnInfoLongInfo paramOnInfoLongInfo)
    {
      switch (paramOnInfoLongInfo.infoType)
      {
      default: 
        TPThumbPlayer.this.handleOnInfoLongNoConvertToListener(paramOnInfoLongInfo.infoType, paramOnInfoLongInfo);
        return;
      case 250: 
        TPThumbPlayer.this.handleOnVideoSizeChanged(paramOnInfoLongInfo.lParam1, paramOnInfoLongInfo.lParam2);
        return;
      }
      TPThumbPlayer.this.handleOnComplete();
    }
    
    private void handleOnInfoObject(TPThumbPlayer.OnInfoObjectInfo paramOnInfoObjectInfo)
    {
      switch (paramOnInfoObjectInfo.infoType)
      {
      default: 
        TPThumbPlayer.this.handleOnInfoObjectNoConvertToListener(paramOnInfoObjectInfo.infoType, paramOnInfoObjectInfo);
      }
      do
      {
        return;
      } while (!(paramOnInfoObjectInfo.objParam instanceof String));
      TPThumbPlayer.this.mSubtitleData.subtitleData = ((String)paramOnInfoObjectInfo.objParam);
      TPThumbPlayer.this.mPlayerListenerReps.onSubtitleData(TPThumbPlayer.this.mSubtitleData);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((TPThumbPlayer)this.mWeakRef.get() == null)
      {
        TPThumbPlayer.this.mLogger.error("mWeakRef is null");
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        TPThumbPlayer.this.mLogger.warn("message :" + paramMessage.what + "  not recognition");
        return;
      case 1: 
        handleOnAsyncCallResult((TPThumbPlayer.OnASyncCallResultInfo)paramMessage.obj);
        return;
      case 2: 
        handleOnInfoLong((TPThumbPlayer.OnInfoLongInfo)paramMessage.obj);
        return;
      case 3: 
        handleOnInfoObject((TPThumbPlayer.OnInfoObjectInfo)paramMessage.obj);
        return;
      case 4: 
        paramMessage = (TPThumbPlayer.OnErrorInfo)paramMessage.obj;
        handleOnError(paramMessage.msgType, paramMessage.errorCode);
        return;
      }
      handleOnDetailInfo((TPDetailInfo)paramMessage.obj);
    }
  }
  
  public static class OnASyncCallResultInfo
  {
    @TPCommonEnum.NativeMsgInfo
    int callType;
    int errorCode;
    int errorType;
    long opaque;
  }
  
  public static class OnErrorInfo
  {
    int errorCode;
    int msgType;
  }
  
  public static class OnInfoLongInfo
  {
    int infoType;
    long lParam1;
    long lParam2;
  }
  
  public static class OnInfoObjectInfo
  {
    int infoType;
    Object objParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer
 * JD-Core Version:    0.7.0.1
 */