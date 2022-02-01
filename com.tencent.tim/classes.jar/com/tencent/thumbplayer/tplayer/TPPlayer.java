package com.tencent.thumbplayer.tplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.adapter.ITPPlayerAdapter;
import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.adapter.TPPlayerAdapter;
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
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnDetailInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.ITPSurface;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaDrmInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.datatransport.ITPPlayManager;
import com.tencent.thumbplayer.datatransport.TPPlayManagerImpl;
import com.tencent.thumbplayer.datatransport.resourceloader.ITPAssetResourceLoader;
import com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoader;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginManager;
import com.tencent.thumbplayer.tplayer.plugins.TPPluginManager;
import com.tencent.thumbplayer.tplayer.plugins.report.TPLogPlugin;
import com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager;
import com.tencent.thumbplayer.tplayer.plugins.report.TPReportPlugin;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPHashMapBuilder;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPThreadAnnotations.ThreadSwitch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class TPPlayer
  implements ITPPlayer
{
  private static String LOG_API_CALL_PREFIX = "api call:";
  private static final int MSG_INDEX = 256;
  private static final int MSG_ON_AUDIOPCMOUT = 267;
  private static final int MSG_ON_COMPLETION = 260;
  private static final int MSG_ON_ERROR = 262;
  private static final int MSG_ON_INFO = 261;
  private static final int MSG_ON_PLAYER_STATE_CHANGE = 277;
  private static final int MSG_ON_PREPARED = 257;
  private static final int MSG_ON_PROXY_ALL_DOWNLOAD_FINISH = 271;
  private static final int MSG_ON_PROXY_CDN_URL_EXPIRED = 275;
  private static final int MSG_ON_PROXY_DOWN_LOAD_STATUS_UPDATE = 272;
  private static final int MSG_ON_PROXY_NO_MORE_DATA = 276;
  private static final int MSG_ON_PROXY_PCDN_FAILED = 282;
  private static final int MSG_ON_PROXY_PLAYERROR = 268;
  private static final int MSG_ON_PROXY_PLAY_CDN_INFO_UPDATE = 270;
  private static final int MSG_ON_PROXY_PLAY_CDN_URL_UPDATE = 269;
  private static final int MSG_ON_PROXY_PROGRESS_UPDATE = 274;
  private static final int MSG_ON_PROXY_PROTOCOL_UPDATE = 273;
  private static final int MSG_ON_PROXY_QUIC_STATUS_UPDATE = 281;
  private static final int MSG_ON_PROXY_SWITCH_DEFINITION = 278;
  private static final int MSG_ON_SEEK_COMPLETE = 263;
  private static final int MSG_ON_STOP_ASYNC_COMPLETE = 280;
  private static final int MSG_ON_SUBTITLE_DATA = 265;
  private static final int MSG_ON_SUBTITLE_FRAME_BUFFER = 279;
  private static final int MSG_ON_VIDEOFRAMEOUT = 266;
  private static final int MSG_ON_VIDEO_SIZE_CHANGE = 264;
  private static AtomicInteger sLifeCycleId = new AtomicInteger(1000);
  private static int sPlayId = 0;
  private String TAG = "TPPlayer";
  private ITPAssetResourceLoader mAssetResourceLoader;
  private Context mContext;
  private long mCurrentDownloadSizeByte;
  private long mDownloadPlayableDurationMs;
  private String mFlowId;
  private HandlerThread mHandlerThread;
  private TPBaseLogger mLogger;
  private ITPPlayManager mPlayProxyManager;
  private AtomicInteger mPlayTaskId = new AtomicInteger(1000);
  private ITPPlayerAdapter mPlayerAdapter;
  private TPPlayerListeners mPlayerListeners;
  private int mProxyStatus = -1;
  private TPReportManager mReportManager;
  private ITPPluginManager mTPPluginManager;
  private Looper mThreadLooper;
  private long mTotalFileSizeByte;
  private EventHandler mTransformCallbackHandler;
  private String mUrl = null;
  private boolean mUseProxy = true;
  private boolean mUsingDefaultLogContext = false;
  private ArrayList<String> proxyTrackUrls;
  
  public TPPlayer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPPlayer(Context paramContext, Looper paramLooper)
  {
    this(paramContext, paramLooper, null);
  }
  
  public TPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2)
  {
    this(paramContext, paramLooper1, paramLooper2, null);
  }
  
  public TPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2, TPLoggerContext paramTPLoggerContext)
  {
    sPlayId += 1;
    TPLoggerContext localTPLoggerContext;
    InnerPlayerListener localInnerPlayerListener;
    if (paramTPLoggerContext != null)
    {
      localTPLoggerContext = new TPLoggerContext(paramTPLoggerContext, this.TAG);
      this.mLogger = new TPBaseLogger(localTPLoggerContext);
      this.mLogger.info("create TPPlayer");
      this.mContext = paramContext.getApplicationContext();
      this.mTPPluginManager = new TPPluginManager();
      if (paramLooper1 != null)
      {
        paramTPLoggerContext = paramLooper1;
        if (paramLooper1 != Looper.getMainLooper()) {}
      }
      else
      {
        this.mHandlerThread = new HandlerThread("TP-workthread");
        this.mHandlerThread.start();
        paramTPLoggerContext = this.mHandlerThread.getLooper();
      }
      this.mReportManager = new TPReportManager(this.mContext, paramTPLoggerContext);
      this.mTPPluginManager.addPlugin(this.mReportManager);
      pushEvent(100, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
      localInnerPlayerListener = new InnerPlayerListener();
      this.mPlayerListeners = new TPPlayerListeners(this.mLogger.getTag());
      this.mPlayerAdapter = new TPPlayerAdapter(this.mContext, localTPLoggerContext);
      this.mPlayerAdapter.setOnPreparedListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnCompletionListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnInfoListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnVideoSizeChangedListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnErrorListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnSeekCompleteListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnVideoSizeChangedListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnSubtitleDataListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnSubtitleFrameOutListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnAudioPcmOutputListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnVideoFrameOutListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnVideoProcessOutputListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnAudioProcessOutputListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnPlayerStateChangeListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnDetailInfoListener(localInnerPlayerListener);
      if (paramTPLoggerContext != null)
      {
        paramLooper1 = paramTPLoggerContext;
        if (paramTPLoggerContext != Looper.getMainLooper()) {}
      }
      else
      {
        this.mHandlerThread = new HandlerThread("TP-workthread");
        this.mHandlerThread.start();
        paramLooper1 = this.mHandlerThread.getLooper();
      }
      this.mThreadLooper = paramLooper1;
      if (paramLooper2 != null) {
        break label695;
      }
      if (Looper.myLooper() != null) {
        break label679;
      }
      this.mTransformCallbackHandler = new EventHandler(this, this.mThreadLooper);
    }
    for (;;)
    {
      pushEvent(101, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
      this.mPlayProxyManager = new TPPlayManagerImpl(paramContext, this.mThreadLooper);
      this.mPlayProxyManager.setPlayListener(localInnerPlayerListener);
      this.mTPPluginManager.addPlugin(new TPReportPlugin());
      this.mTPPluginManager.addPlugin(new TPLogPlugin());
      this.proxyTrackUrls = new ArrayList();
      return;
      localTPLoggerContext = new TPLoggerContext("ThumbPlayer", String.valueOf(sLifeCycleId.incrementAndGet()), String.valueOf(this.mPlayTaskId.incrementAndGet()), this.TAG);
      this.mUsingDefaultLogContext = true;
      break;
      label679:
      this.mTransformCallbackHandler = new EventHandler(this);
      continue;
      label695:
      this.mTransformCallbackHandler = new EventHandler(this, paramLooper2);
    }
  }
  
  private void handleAudioTrackProxy(Object paramObject)
  {
    if (!(paramObject instanceof TPPlayerMsg.TPAudioTrackInfo)) {
      return;
    }
    if (!isUseProxyEnable())
    {
      this.mLogger.info("handleAudioTrackProxy, proxy not enable and use orinal url");
      return;
    }
    paramObject = (TPPlayerMsg.TPAudioTrackInfo)paramObject;
    String str = this.mPlayProxyManager.startDownLoadTrackUrl(2, paramObject.audioTrackUrl, null);
    this.proxyTrackUrls.add(str);
    paramObject.proxyUrl = str;
  }
  
  private void handleOnError(int paramInt1, int paramInt2)
  {
    pushEvent(108, paramInt1, paramInt2, "", new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(3)).put("code", paramInt1 + "." + paramInt2).build());
    this.mPlayProxyManager.setProxyPlayState(3);
    this.mPlayProxyManager.pauseDownload();
  }
  
  private void handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (paramInt == 200)
    {
      this.mPlayProxyManager.setProxyPlayState(4);
      pushEvent(114, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("format", Integer.valueOf(0)).put("ptime", Long.valueOf(getCurrentPositionMs())).put("url", this.mUrl).build());
      return;
    }
    if (paramInt == 201)
    {
      setProxyStatePlayingOrPause();
      pushEvent(115, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
      return;
    }
    if (paramInt == 3) {
      if (!(paramObject instanceof Long)) {
        break label538;
      }
    }
    label538:
    for (paramLong1 = ((Long)paramObject).longValue();; paramLong1 = -1L)
    {
      this.mLogger.info("switch definition finish defId:" + paramLong1);
      if (paramLong1 > 0L) {
        this.mPlayProxyManager.playerSwitchDefComplete(paramLong1);
      }
      pushEvent(121, 0, 0, null, new TPHashMapBuilder().put("switch", paramLong1 + "").build());
      return;
      if (paramInt == 106)
      {
        pushEvent(105, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
        return;
      }
      if (paramInt == 501)
      {
        pushEvent(117, 0, 0, null, paramObject);
        return;
      }
      if (paramInt == 107)
      {
        pushEvent(119, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
        return;
      }
      if (paramInt == 4)
      {
        pushEvent(123, 0, 0, null, new TPHashMapBuilder().put("opaque", paramObject).put("etime", Long.valueOf(System.currentTimeMillis())).put("code", paramLong1 + "." + paramLong2).build());
        return;
      }
      if (paramInt == 101)
      {
        pushEvent(124, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
        return;
      }
      if ((paramInt != 505) || (!(paramObject instanceof TPPlayerMsg.TPMediaDrmInfo))) {
        break;
      }
      paramObject = (TPPlayerMsg.TPMediaDrmInfo)paramObject;
      this.mLogger.info("TPMediaDrmInfo secureDecoder:" + paramObject.supportSecureDecoder + " secureDecrypt:" + paramObject.supportSecureDecrypt + " componentName:" + paramObject.componentName + " drmType:" + paramObject.drmType);
      return;
    }
  }
  
  private void handlePlayerCallback(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    EventHandler localEventHandler = this.mTransformCallbackHandler;
    if (localEventHandler != null)
    {
      Message localMessage = localEventHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      localEventHandler.sendMessage(localMessage);
    }
  }
  
  private void handlePlayerCallbackDelay(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    if (this.mTransformCallbackHandler != null)
    {
      Message localMessage = this.mTransformCallbackHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.mTransformCallbackHandler.removeMessages(paramInt1);
      this.mTransformCallbackHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  private void handleSelectAudioTrack(Object paramObject)
  {
    if (!(paramObject instanceof TPPlayerMsg.TPAudioTrackInfo)) {
      return;
    }
    if (!isUseProxyEnable())
    {
      this.mLogger.error("handleSelectAudioTrack, proxy is not enable");
      return;
    }
    paramObject = (TPPlayerMsg.TPAudioTrackInfo)paramObject;
    this.mLogger.info("handleSelectAudioTrack, audioTrack url:" + paramObject.audioTrackUrl);
    if (!TextUtils.isEmpty(paramObject.audioTrackUrl)) {
      try
      {
        this.mPlayProxyManager.startDemuxer(paramObject.audioTrackUrl, paramObject.keyId);
        return;
      }
      catch (Exception paramObject)
      {
        this.mLogger.printException(paramObject);
        return;
      }
    }
    try
    {
      this.mPlayProxyManager.stopDemuxer();
      return;
    }
    catch (Exception paramObject)
    {
      this.mLogger.printException(paramObject);
    }
  }
  
  private void internalStop()
  {
    this.mPlayerAdapter.stop();
    pushEvent(107, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(1)).build());
    this.mPlayProxyManager.setProxyPlayState(5);
    this.mPlayProxyManager.pauseDownload();
    this.mDownloadPlayableDurationMs = -1L;
    this.mCurrentDownloadSizeByte = -1L;
    this.mTotalFileSizeByte = -1L;
  }
  
  private boolean isUseProxyEnable()
  {
    this.mLogger.info("isUseProxyEnable, mPlayProxyManager.isEnable()=" + this.mPlayProxyManager.isEnable() + " TPPlayerConfig.isUseP2P()=" + TPPlayerConfig.isUseP2P() + " mUseProxy=" + this.mUseProxy);
    return (this.mPlayProxyManager.isEnable()) && (TPPlayerConfig.isUseP2P()) && (this.mUseProxy);
  }
  
  private void notifyIsUseProxyInfo()
  {
    TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams = new TPThreadSwitchCommons.TPSwitchCommonParams();
    if (isUseProxyEnable()) {}
    for (long l = 1L;; l = 0L)
    {
      localTPSwitchCommonParams.arg1 = l;
      handlePlayerCallback(261, 1009, 0, localTPSwitchCommonParams);
      return;
    }
  }
  
  private void pushEvent(int paramInt)
  {
    pushEvent(paramInt, 0, 0, "", null);
  }
  
  private void pushEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    try
    {
      if (this.mTPPluginManager != null) {
        this.mTPPluginManager.onEvent(paramInt1, paramInt2, paramInt3, paramString, paramObject);
      }
      return;
    }
    catch (Exception paramString)
    {
      this.mLogger.printException(paramString);
    }
  }
  
  private void removePlayerCallback(int paramInt)
  {
    if (this.mTransformCallbackHandler != null) {
      this.mTransformCallbackHandler.removeMessages(paramInt);
    }
  }
  
  private void setProxyStatePlayingOrPause()
  {
    if (this.mPlayerAdapter.isPlaying()) {}
    for (int i = 0;; i = 5)
    {
      this.mPlayProxyManager.setProxyPlayState(i);
      return;
    }
  }
  
  private boolean validCallSwitchDef()
  {
    int i = this.mPlayerAdapter.getCurrentState();
    return (i == 4) || (i == 5) || (i == 6) || (i == 7);
  }
  
  private boolean validStateCall(int paramInt)
  {
    int i = this.mPlayerAdapter.getCurrentState();
    if (paramInt == 2)
    {
      if (i != 1) {}
    }
    else {
      while ((paramInt != 17) || (i == 4) || (i == 5) || (i == 6) || (i == 7)) {
        return true;
      }
    }
    return false;
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void addAudioTrackSource(String paramString1, String paramString2)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2);
    addAudioTrackSource(paramString1, paramString2, null);
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2 + ", downloadParamData:" + paramTPDownloadParamData);
    if ((TextUtils.isEmpty(paramString2)) || (!TPCommonUtils.isUrl(paramString1)))
    {
      this.mLogger.error("handleAddAudioSource, illegal argument.");
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      TPOptionalParam localTPOptionalParam = new TPOptionalParam();
      if (paramTPDownloadParamData != null) {
        localTPOptionalParam.buildString(6, paramTPDownloadParamData.getAudioTrackKeyId());
      }
      localArrayList.add(localTPOptionalParam);
      this.mPlayerAdapter.addAudioTrackSource(paramString1, paramString2, localArrayList);
      return;
    }
    catch (Exception paramString1)
    {
      this.mLogger.printException(paramString1);
    }
  }
  
  public ITPPluginManager addPlugin(ITPPluginBase paramITPPluginBase)
  {
    if (this.mTPPluginManager != null) {
      this.mTPPluginManager.addPlugin(paramITPPluginBase);
    }
    return null;
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true)
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "addSubtitleSource, url:" + paramString1 + ", mimeType:" + paramString2 + ", name:" + paramString3);
    addSubtitleSource(paramString1, paramString2, paramString3, null);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true)
  public void addSubtitleSource(@NonNull String paramString1, String paramString2, @NonNull String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "addSubtitleSource, url:" + paramString1 + ", name:" + paramString3 + ", downloadParamData:" + paramTPDownloadParamData);
    try
    {
      long l = System.currentTimeMillis();
      if ((isUseProxyEnable()) && (TPCommonUtils.isUrl(paramString1)))
      {
        paramTPDownloadParamData = this.mPlayProxyManager.startDownLoadTrackUrl(3, paramString1, paramTPDownloadParamData);
        this.proxyTrackUrls.add(paramTPDownloadParamData);
        this.mPlayerAdapter.addSubtitleSource(paramTPDownloadParamData, paramString2, paramString3);
      }
      for (;;)
      {
        pushEvent(118, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(l)).put("etime", Long.valueOf(System.currentTimeMillis())).put("url", paramString1).put("name", paramString3).build());
        return;
        this.mPlayerAdapter.addSubtitleSource(paramString1, paramString2, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      this.mLogger.printException(paramString1);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "captureVideo, params:" + paramTPCaptureParams + ", captureCallBack:" + paramTPCaptureCallBack);
    try
    {
      this.mPlayerAdapter.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      return;
    }
    catch (Exception paramTPCaptureParams)
    {
      this.mLogger.printException(paramTPCaptureParams);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "deselectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    try
    {
      this.mPlayerAdapter.deselectTrack(paramInt, paramLong);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener, Looper paramLooper)
  {
    if (paramITPAssetResourceLoaderListener != null)
    {
      this.mPlayProxyManager.setIsUseResourceLoader(true);
      if (this.mAssetResourceLoader != null)
      {
        this.mAssetResourceLoader.release();
        this.mAssetResourceLoader = null;
      }
      this.mAssetResourceLoader = new TPAssetResourceLoader(this.mContext, paramLooper);
      this.mAssetResourceLoader.setTPAssetResourceLoaderListener(paramITPAssetResourceLoaderListener);
      this.mAssetResourceLoader.fillInContentInformation();
      return;
    }
    this.mPlayProxyManager.setIsUseResourceLoader(false);
  }
  
  public int getBufferPercent()
  {
    if (this.mPlayerAdapter.getDurationMs() == 0L) {
      return 0;
    }
    return (int)(100.0F * (float)(this.mPlayerAdapter.getPlayableDurationMs() - this.mPlayerAdapter.getCurrentPositionMs()) / (float)this.mPlayerAdapter.getDurationMs());
  }
  
  public long getCurrentPositionMs()
  {
    return this.mPlayerAdapter.getCurrentPositionMs();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public int getCurrentState()
  {
    return this.mPlayerAdapter.getCurrentState();
  }
  
  public long getDurationMs()
  {
    return this.mPlayerAdapter.getDurationMs();
  }
  
  public long getFileSizeBytes()
  {
    return this.mTotalFileSizeByte;
  }
  
  public Looper getLooper()
  {
    return this.mThreadLooper;
  }
  
  public long getPlayableDurationMs()
  {
    if (isUseProxyEnable())
    {
      if ((this.mCurrentDownloadSizeByte > 0L) && (this.mTotalFileSizeByte > 0L)) {
        return (this.mCurrentDownloadSizeByte * 1.0D / this.mTotalFileSizeByte * this.mPlayerAdapter.getDurationMs());
      }
      return this.mDownloadPlayableDurationMs;
    }
    return this.mPlayerAdapter.getPlayableDurationMs();
  }
  
  public ITPPlayerProxy getPlayerProxy()
  {
    return this.mPlayProxyManager;
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public int getPlayerType()
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "getPlayerType");
    return this.mPlayerAdapter.getPlayerType();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public TPProgramInfo[] getProgramInfo()
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "getProgramInfo");
    return this.mPlayerAdapter.getProgramInfo();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public long getPropertyLong(int paramInt)
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "getPropertyLong, paramId:" + paramInt);
    return this.mPlayerAdapter.getPropertyLong(paramInt);
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public String getPropertyString(int paramInt)
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "getPropertyString, paramId:" + paramInt);
    return this.mPlayerAdapter.getPropertyString(paramInt);
  }
  
  public ITPBusinessReportManager getReportManager()
  {
    return this.mReportManager;
  }
  
  public String getTag()
  {
    return this.mLogger.getTag();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public TPTrackInfo[] getTrackInfo()
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "getTrackInfo");
    return this.mPlayerAdapter.getTrackInfo();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public int getVideoHeight()
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "getVideoHeight");
    return this.mPlayerAdapter.getVideoHeight();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public int getVideoWidth()
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "getVideoWidth");
    return this.mPlayerAdapter.getVideoWidth();
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void pause()
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "pause");
    this.mPlayerAdapter.pause();
    try
    {
      pushEvent(106, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
      this.mPlayProxyManager.setProxyPlayState(5);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void pauseDownload()
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "pauseDownload");
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 0L);
    try
    {
      this.mPlayerAdapter.setPlayerOptionalParam(localTPOptionalParam);
      this.mPlayProxyManager.pauseDownload();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mLogger.printException(localException);
      }
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void prepareAsync()
    throws IllegalStateException, IOException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "prepareAsync");
    try
    {
      this.mPlayProxyManager.resumeDownload();
      this.mPlayerAdapter.prepareAsync();
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(this.mFlowId)) {
            this.mFlowId = (UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform());
          }
          pushEvent(102, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("url", this.mUrl).put("p2p", Boolean.valueOf(isUseProxyEnable())).put("flowid", this.mFlowId).build());
          pushEvent(501, this.mPlayerAdapter.getNativePlayerId(), 0, null, null);
          notifyIsUseProxyInfo();
          return;
        }
        catch (Exception localException)
        {
          this.mLogger.printException(localException);
        }
        localRuntimeException = localRuntimeException;
        this.mLogger.printException(localRuntimeException);
      }
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public void release()
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "release");
    this.mPlayerAdapter.release();
    pushEvent(112, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(1)).build());
    if (this.mTransformCallbackHandler != null)
    {
      this.mTransformCallbackHandler.removeCallbacksAndMessages(null);
      this.mTransformCallbackHandler = null;
    }
    this.mPlayerListeners.clear();
    this.mPlayProxyManager.release();
    this.proxyTrackUrls.clear();
    if (this.mAssetResourceLoader != null)
    {
      this.mAssetResourceLoader.release();
      this.mAssetResourceLoader = null;
    }
    this.mDownloadPlayableDurationMs = -1L;
    this.mCurrentDownloadSizeByte = -1L;
    this.mTotalFileSizeByte = -1L;
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    this.mTPPluginManager.release();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public void reset()
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "reset");
    if (this.mUsingDefaultLogContext)
    {
      this.mLogger.updateTaskId(String.valueOf(this.mPlayTaskId.incrementAndGet()));
      this.mPlayerAdapter.updateLoggerContext(this.mLogger.getTPLoggerContext());
      this.mPlayerListeners.updateTag(this.mLogger.getTPLoggerContext().getTag());
    }
    this.mPlayerAdapter.reset();
    pushEvent(113, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(1)).build());
    this.mPlayProxyManager.stopDownload();
    this.mProxyStatus = -1;
    this.proxyTrackUrls.clear();
    if (this.mAssetResourceLoader != null) {
      this.mAssetResourceLoader.reset();
    }
    if (this.mTransformCallbackHandler != null) {
      this.mTransformCallbackHandler.removeCallbacksAndMessages(null);
    }
    this.mDownloadPlayableDurationMs = -1L;
    this.mCurrentDownloadSizeByte = -1L;
    this.mTotalFileSizeByte = -1L;
    this.mFlowId = null;
    this.mUseProxy = true;
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void resumeDownload()
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "resumeDownload");
    this.mPlayProxyManager.resumeDownload();
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 1L);
    try
    {
      this.mPlayerAdapter.setPlayerOptionalParam(localTPOptionalParam);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "seekTo, positionMs:" + paramInt);
    this.mPlayerAdapter.seekTo(paramInt);
    this.mPlayProxyManager.setProxyPlayState(1);
    pushEvent(109, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("format", Integer.valueOf(0)).put("pstime", Long.valueOf(getCurrentPositionMs())).build());
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void seekTo(int paramInt1, int paramInt2)
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    if (paramInt2 > 0) {
      this.mPlayerAdapter.seekTo(paramInt1, paramInt2);
    }
    for (;;)
    {
      this.mPlayProxyManager.setProxyPlayState(1);
      pushEvent(109, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("format", Integer.valueOf(0)).put("pstime", Long.valueOf(getCurrentPositionMs())).build());
      return;
      this.mPlayerAdapter.seekTo(paramInt1);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "selectProgram, programIndex:" + paramInt + ", opaque:" + paramLong);
    try
    {
      this.mPlayerAdapter.selectProgram(paramInt, paramLong);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "selectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    try
    {
      TPTrackInfo[] arrayOfTPTrackInfo = this.mPlayerAdapter.getTrackInfo();
      if ((arrayOfTPTrackInfo != null) && (arrayOfTPTrackInfo.length > paramInt)) {
        pushEvent(122, 0, 0, null, new TPHashMapBuilder().put("opaque", Long.valueOf(paramLong)).put("tracktype", Integer.valueOf(arrayOfTPTrackInfo[paramInt].getTrackType())).put("name", arrayOfTPTrackInfo[paramInt].getName()).put("stime", Long.valueOf(System.currentTimeMillis())).build());
      }
      this.mPlayerAdapter.selectTrack(paramInt, paramLong);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(removeRepeat=true)
  public void setAudioGainRatio(float paramFloat)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "setAudioGainRatio, gainRatio:" + paramFloat);
    try
    {
      this.mPlayerAdapter.setAudioGainRatio(paramFloat);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(removeRepeat=true)
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "setAudioNormalizeVolumeParams, audioNormalizeVolumeParams:" + paramString);
    try
    {
      this.mPlayerAdapter.setAudioNormalizeVolumeParams(paramString);
      return;
    }
    catch (Exception paramString)
    {
      this.mLogger.printException(paramString);
    }
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mPlayProxyManager.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
    throws IllegalArgumentException, IllegalStateException
  {
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("error : setDataSource , param is null");
    }
    if (this.mPlayerAdapter.getCurrentState() != 1) {
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    this.mLogger.info(LOG_API_CALL_PREFIX + "setDataSource, ParcelFileDescriptor");
    try
    {
      this.mPlayerAdapter.setDataSource(paramParcelFileDescriptor);
      return;
    }
    catch (IOException paramParcelFileDescriptor)
    {
      this.mLogger.printException(paramParcelFileDescriptor);
      return;
    }
    catch (SecurityException paramParcelFileDescriptor)
    {
      this.mLogger.printException(paramParcelFileDescriptor);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
    throws IllegalArgumentException, IllegalStateException
  {
    if (paramITPMediaAsset == null) {
      throw new IllegalArgumentException("error : setDataSource , param is null");
    }
    if (((paramITPMediaAsset instanceof ITPMediaDRMAsset)) && ((TextUtils.isEmpty(paramITPMediaAsset.getUrl())) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties() == null) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties().isEmpty()))) {
      throw new IllegalArgumentException("error : setDataSource , drm asset url is null or drm property is null");
    }
    if (this.mPlayerAdapter.getCurrentState() != 1) {
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    this.mLogger.info(LOG_API_CALL_PREFIX + "setDataSource, ITPMediaAsset");
    ITPMediaAsset localITPMediaAsset;
    if (paramITPMediaAsset != null) {
      localITPMediaAsset = paramITPMediaAsset;
    }
    try
    {
      if (isUseProxyEnable()) {
        localITPMediaAsset = this.mPlayProxyManager.startDownloadPlayByAsset(paramITPMediaAsset);
      }
      if (localITPMediaAsset != null)
      {
        this.mLogger.info("handleSetDataSource mediaAsset=" + localITPMediaAsset.getUrl());
        this.mPlayerAdapter.setDataSource(localITPMediaAsset);
      }
      return;
    }
    catch (IOException paramITPMediaAsset)
    {
      this.mLogger.printException(paramITPMediaAsset);
      return;
    }
    catch (SecurityException paramITPMediaAsset)
    {
      this.mLogger.printException(paramITPMediaAsset);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setDataSource(String paramString)
    throws IllegalArgumentException, IllegalStateException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("error : setDataSource , param is invalid");
    }
    if (this.mPlayerAdapter.getCurrentState() != 1) {
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    this.mLogger.info(LOG_API_CALL_PREFIX + "setDataSource, url:" + paramString);
    TPUrlDataSource localTPUrlDataSource;
    if (!TextUtils.isEmpty(paramString))
    {
      this.mUrl = paramString;
      localTPUrlDataSource = new TPUrlDataSource(paramString);
      this.mLogger.info("handleSetDataSource originalUrl=" + paramString);
    }
    try
    {
      if (isUseProxyEnable())
      {
        localTPUrlDataSource = this.mPlayProxyManager.startDownloadPlay(paramString, null);
        this.mLogger.info("handleSetDataSource selfPlayerUrl=" + localTPUrlDataSource.getSelfPlayerUrl());
        this.mLogger.info("handleSetDataSource systemPlayerUrl=" + localTPUrlDataSource.getSystemPlayerUrl());
      }
      this.mPlayerAdapter.setDataSource(localTPUrlDataSource);
      return;
    }
    catch (Exception paramString)
    {
      this.mLogger.printException(paramString);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setDataSource(String paramString, Map<String, String> paramMap)
    throws IllegalArgumentException, IllegalStateException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("error : setDataSource , param is invalid");
    }
    if (this.mPlayerAdapter.getCurrentState() != 1) {
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    this.mLogger.info(LOG_API_CALL_PREFIX + "setDataSource, url:" + paramString + ", httpHeader:" + paramMap);
    TPUrlDataSource localTPUrlDataSource;
    if (!TextUtils.isEmpty(paramString))
    {
      this.mUrl = paramString;
      localTPUrlDataSource = new TPUrlDataSource(paramString);
      this.mLogger.info("handleSetDataSource originalUrl=" + paramString);
    }
    try
    {
      if (isUseProxyEnable())
      {
        localTPUrlDataSource = this.mPlayProxyManager.startDownloadPlay(paramString, paramMap);
        this.mLogger.info("handleSetDataSource selfPlayerUrl=" + localTPUrlDataSource.getSelfPlayerUrl());
        this.mLogger.info("handleSetDataSource systemPlayerUrl=" + localTPUrlDataSource.getSystemPlayerUrl());
      }
      this.mPlayerAdapter.setDataSource(localTPUrlDataSource, paramMap);
      return;
    }
    catch (Exception paramString)
    {
      this.mLogger.printException(paramString);
    }
  }
  
  public void setIsActive(boolean paramBoolean)
  {
    this.mPlayProxyManager.setIsActive(paramBoolean);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void setLoopback(boolean paramBoolean)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "setLoopback, isLoopback:" + paramBoolean);
    try
    {
      this.mPlayerAdapter.setLoopback(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    try
    {
      this.mPlayerAdapter.setLoopback(paramBoolean, paramLong1, paramLong2);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  public void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnAudioPcmOutputListener(paramIOnAudioFrameOutputListener);
    }
  }
  
  public void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener paramIOnAudioProcessFrameOutputListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnAudioProcessOutputListener(paramIOnAudioProcessFrameOutputListener);
    }
  }
  
  public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnCompletionListener(paramIOnCompletionListener);
    }
  }
  
  public void setOnDetailInfoListener(ITPPlayerListener.IOnDetailInfoListener paramIOnDetailInfoListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnDetailInfoListener(paramIOnDetailInfoListener);
    }
  }
  
  public void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnErrorListener(paramIOnErrorListener);
    }
  }
  
  public void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnInfoListener(paramIOnInfoListener);
    }
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnPlayerStateChangeListener(paramIOnStateChangeListener);
    }
  }
  
  public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnPreparedListener(paramIOnPreparedListener);
    }
  }
  
  public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnSeekCompleteListener(paramIOnSeekCompleteListener);
    }
  }
  
  public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnStopAsyncCompleteListener(paramIOnStopAsyncCompleteListener);
    }
  }
  
  public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnSubtitleDataListener(paramIOnSubtitleDataListener);
    }
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnSubtitleFrameOutListener(paramIOnSubtitleFrameOutListener);
    }
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
    }
  }
  
  public void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener paramIOnVideoProcessFrameOutputListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnVideoProcessOutputListener(paramIOnVideoProcessFrameOutputListener);
    }
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(removeRepeat=true)
  public void setOutputMute(boolean paramBoolean)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "setOutputMute, isOutputMute:" + paramBoolean);
    try
    {
      this.mPlayerAdapter.setOutputMute(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(removeRepeat=true)
  public void setPlaySpeedRatio(float paramFloat)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "setPlaySpeedRatio, speedRatio:" + paramFloat);
    try
    {
      this.mPlayerAdapter.setPlaySpeedRatio(paramFloat);
      pushEvent(116, 0, 0, null, new TPHashMapBuilder().put("scene", Float.valueOf(paramFloat)).build());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mLogger.printException(localException);
      }
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true)
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 205))
    {
      this.mUseProxy = paramTPOptionalParam.getParamBoolean().value;
      this.mLogger.info("setPlayerOptionalParam, use p2p proxy, OPTION_ID_BEFORE_BOOLEAN_USE_PROXY=" + this.mUseProxy);
      return;
    }
    this.mPlayProxyManager.setPlayerOptionalParam(paramTPOptionalParam);
    try
    {
      this.mPlayerAdapter.setPlayerOptionalParam(paramTPOptionalParam);
      return;
    }
    catch (Exception paramTPOptionalParam)
    {
      this.mLogger.printException(paramTPOptionalParam);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setRichMediaSynchronizer(@Nullable ITPRichMediaSynchronizer paramITPRichMediaSynchronizer)
  {
    this.mPlayerAdapter.setRichMediaSynchronizer(paramITPRichMediaSynchronizer);
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setSurface(Surface paramSurface)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "setSurface, surface:" + paramSurface);
    try
    {
      this.mPlayerAdapter.setSurface(paramSurface);
      return;
    }
    catch (Exception paramSurface)
    {
      this.mLogger.printException(paramSurface);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "setSurfaceHolder, SurfaceHolder:" + paramSurfaceHolder);
    try
    {
      this.mPlayerAdapter.setSurfaceHolder(paramSurfaceHolder);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      this.mLogger.printException(paramSurfaceHolder);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setTPSurface(ITPSurface paramITPSurface)
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "setTPSurface, tpSurface:" + paramITPSurface);
    try
    {
      if ((paramITPSurface instanceof TPSurface)) {
        this.mPlayerAdapter.setSurface(((TPSurface)paramITPSurface).getSurface());
      }
      return;
    }
    catch (Exception paramITPSurface)
    {
      this.mLogger.printException(paramITPSurface);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true)
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (paramTPVideoInfo != null) {}
    try
    {
      this.mPlayProxyManager.setVideoInfo(paramTPVideoInfo);
      this.mPlayerAdapter.setVideoInfo(paramTPVideoInfo);
      if ((paramTPVideoInfo.getDownloadPraramList() != null) && (paramTPVideoInfo.getDownloadPraramList().size() > 0)) {
        this.mFlowId = ((TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0)).getFlowId();
      }
      return;
    }
    catch (Exception paramTPVideoInfo)
    {
      this.mLogger.printException(paramTPVideoInfo);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void start()
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "start");
    this.mPlayerAdapter.start();
    try
    {
      pushEvent(104, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
      this.mPlayProxyManager.setProxyPlayState(0);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public void stop()
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "stop");
    internalStop();
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void stopAsync()
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "stopAsync");
    internalStop();
    handlePlayerCallback(280, 0, 0, null);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo);
    switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, 0);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
    throws IllegalStateException
  {
    if (!validCallSwitchDef()) {
      throw new IllegalStateException("error : switchDefinition , state invalid");
    }
    this.mLogger.info(LOG_API_CALL_PREFIX + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo + ", mode:" + paramInt);
    ITPMediaAsset localITPMediaAsset = paramITPMediaAsset;
    if (isUseProxyEnable()) {
      localITPMediaAsset = this.mPlayProxyManager.startSwitchDefTaskByAsset(paramITPMediaAsset, paramLong, paramTPVideoInfo);
    }
    if (localITPMediaAsset != null)
    {
      this.mLogger.info("handleSwitchDef, proxyMediaAsset:" + localITPMediaAsset + ", defID:" + paramLong);
      this.mPlayerAdapter.updateVideoInfo(paramTPVideoInfo);
      this.mPlayerAdapter.switchDefinition(localITPMediaAsset, 0, paramLong);
      pushEvent(120, 0, 0, null, new TPHashMapBuilder().put("switch", paramLong + "").build());
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo)
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong);
    switchDefinition(paramString, paramLong, paramTPVideoInfo, 0);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
    throws IllegalStateException
  {
    if (!validCallSwitchDef()) {
      throw new IllegalStateException("error : switchDefinition , state invalid");
    }
    this.mLogger.info(LOG_API_CALL_PREFIX + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong + ", mode:" + paramInt);
    TPUrlDataSource localTPUrlDataSource = new TPUrlDataSource(paramString);
    if (isUseProxyEnable())
    {
      localTPUrlDataSource = this.mPlayProxyManager.startSwitchDefTask(paramLong, paramString, paramTPVideoInfo, null);
      this.mLogger.info("switchDefinition selfPlayerUrl=" + localTPUrlDataSource.getSelfPlayerUrl());
      this.mLogger.info("switchDefinition systemPlayerUrl=" + localTPUrlDataSource.getSystemPlayerUrl());
    }
    this.mLogger.info("switchDefinition, proxyUrl:" + paramString + ", defID:" + paramLong);
    this.mPlayerAdapter.updateVideoInfo(paramTPVideoInfo);
    this.mPlayerAdapter.switchDefinition(localTPUrlDataSource, paramInt, paramLong);
    pushEvent(120, 0, 0, null, new TPHashMapBuilder().put("switch", paramLong + "").build());
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, Map<String, String> paramMap)
    throws IllegalStateException
  {
    this.mLogger.info(LOG_API_CALL_PREFIX + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo + ", httpHeader:" + paramMap);
    switchDefinition(paramString, paramLong, paramTPVideoInfo, paramMap, 0);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, Map<String, String> paramMap, int paramInt)
    throws IllegalStateException
  {
    if (!validCallSwitchDef()) {
      throw new IllegalStateException("error : switchDefinition , state invalid");
    }
    this.mLogger.info(LOG_API_CALL_PREFIX + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong + ", httpHeader:" + paramMap + ", mode:" + paramInt);
    TPUrlDataSource localTPUrlDataSource = new TPUrlDataSource(paramString);
    if (isUseProxyEnable())
    {
      localTPUrlDataSource = this.mPlayProxyManager.startSwitchDefTask(paramLong, paramString, paramTPVideoInfo, paramMap);
      this.mLogger.info("switchDefinition selfPlayerUrl=" + localTPUrlDataSource.getSelfPlayerUrl());
      this.mLogger.info("switchDefinition systemPlayerUrl=" + localTPUrlDataSource.getSystemPlayerUrl());
    }
    this.mLogger.info("switchDefinition, proxyUrl:" + paramString + ", defID:" + paramLong + ", httpHeader:" + paramMap);
    this.mPlayerAdapter.updateVideoInfo(paramTPVideoInfo);
    this.mPlayerAdapter.switchDefinition(localTPUrlDataSource, paramMap, paramInt, paramLong);
    pushEvent(120, 0, 0, null, new TPHashMapBuilder().put("switch", paramLong + "").build());
  }
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    if (paramTPLoggerContext != null)
    {
      this.mUsingDefaultLogContext = false;
      this.mLogger.updateContext(new TPLoggerContext(paramTPLoggerContext, this.TAG));
      this.mPlayerAdapter.updateLoggerContext(this.mLogger.getTPLoggerContext());
      this.mPlayerListeners.updateTag(this.mLogger.getTPLoggerContext().getTag());
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  class EventHandler
    extends Handler
  {
    private TPPlayer mPlayer;
    
    EventHandler(TPPlayer paramTPPlayer)
    {
      this.mPlayer = paramTPPlayer;
    }
    
    EventHandler(TPPlayer paramTPPlayer, Looper paramLooper)
    {
      super();
      this.mPlayer = paramTPPlayer;
    }
    
    public void handleMessage(Message paramMessage)
    {
      TPPlayer.this.mLogger.debug("mTransformHandler msg : " + paramMessage.what);
      TPPlayerListeners localTPPlayerListeners = TPPlayer.this.mPlayerListeners;
      if (localTPPlayerListeners == null) {}
      do
      {
        TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams;
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            case 258: 
            case 259: 
            default: 
              return;
            case 257: 
              TPPlayer.this.mLogger.info("onPrepared");
              localTPPlayerListeners.onPrepared(this.mPlayer);
              return;
            case 260: 
              localTPPlayerListeners.onCompletion(this.mPlayer);
              return;
            case 261: 
              localTPSwitchCommonParams = (TPThreadSwitchCommons.TPSwitchCommonParams)paramMessage.obj;
              if ((localTPSwitchCommonParams != null) && (!TPPlayer.this.mPlayProxyManager.hasWaitDefTask()))
              {
                localTPPlayerListeners.onInfo(this.mPlayer, paramMessage.arg1, localTPSwitchCommonParams.arg1, localTPSwitchCommonParams.arg2, localTPSwitchCommonParams.extraObject);
                return;
              }
              break;
            }
          } while (localTPSwitchCommonParams == null);
          localTPPlayerListeners.onInfo(this.mPlayer, paramMessage.arg1, localTPSwitchCommonParams.arg1, localTPSwitchCommonParams.arg2, localTPSwitchCommonParams.extraObject);
          return;
          localTPSwitchCommonParams = (TPThreadSwitchCommons.TPSwitchCommonParams)paramMessage.obj;
        } while (localTPSwitchCommonParams == null);
        localTPPlayerListeners.onError(this.mPlayer, paramMessage.arg1, paramMessage.arg2, localTPSwitchCommonParams.arg1, localTPSwitchCommonParams.arg2);
        return;
        localTPPlayerListeners.onSeekComplete(this.mPlayer);
        return;
        paramMessage = (TPThreadSwitchCommons.TPSwitchCommonParams)paramMessage.obj;
      } while (paramMessage == null);
      localTPPlayerListeners.onVideoSizeChanged(this.mPlayer, paramMessage.arg1, paramMessage.arg2);
      return;
      localTPPlayerListeners.onSubtitleData(this.mPlayer, (TPSubtitleData)paramMessage.obj);
      return;
      localTPPlayerListeners.onSubtitleFrameOut(this.mPlayer, (TPSubtitleFrameBuffer)paramMessage.obj);
      return;
      localTPPlayerListeners.onVideoFrameOut(this.mPlayer, (TPVideoFrameBuffer)paramMessage.obj);
      return;
      localTPPlayerListeners.onAudioFrameOut(this.mPlayer, (TPAudioFrameBuffer)paramMessage.obj);
      return;
      localTPPlayerListeners.onError(this.mPlayer, paramMessage.arg1, paramMessage.arg2, 0L, 0L);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 1002, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 1003, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 1001, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 1004, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 2100, 0L, 0L, paramMessage.obj);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 1005, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 1006, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 1007, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 1008, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      return;
      if (TPPlayer.this.mPlayerAdapter != null) {
        TPPlayer.this.mPlayerAdapter.setPlayerOptionalParam(new TPOptionalParam().buildLong(8000, paramMessage.arg1));
      }
      localTPPlayerListeners.onInfo(this.mPlayer, 1010, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      return;
      localTPPlayerListeners.onStateChange(paramMessage.arg1, paramMessage.arg2);
      return;
      localTPPlayerListeners.onStopAsyncComplete(this.mPlayer);
      return;
      localTPPlayerListeners.onInfo(this.mPlayer, 2101, 0L, 0L, paramMessage.obj);
    }
  }
  
  class InnerPlayerListener
    implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnAudioProcessOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnDetailInfoListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnStateChangeListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnSubtitleFrameOutListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoProcessOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener, ITPPlayListener
  {
    InnerPlayerListener() {}
    
    public long getAdvRemainTime()
    {
      ITPPlayerProxyListener localITPPlayerProxyListener = TPPlayer.this.mPlayProxyManager.getTPPlayerProxyListener();
      if (localITPPlayerProxyListener != null) {
        return localITPPlayerProxyListener.getAdvRemainTimeMs();
      }
      return -1L;
    }
    
    public String getContentType(int paramInt, String paramString)
    {
      if (TPPlayer.this.mAssetResourceLoader == null)
      {
        TPPlayer.this.mLogger.error("mAssetResourceLoader not set");
        return "";
      }
      return TPPlayer.this.mAssetResourceLoader.getContentType(paramInt, paramString);
    }
    
    public int getCurrentPlayClipNo()
    {
      ITPPlayerAdapter localITPPlayerAdapter = TPPlayer.this.mPlayerAdapter;
      if (localITPPlayerAdapter != null) {
        return localITPPlayerAdapter.getCurrentPlayClipNo();
      }
      return 0;
    }
    
    public long getCurrentPosition()
    {
      return TPPlayer.this.getCurrentPositionMs();
    }
    
    public String getDataFilePath(int paramInt, String paramString)
    {
      if (TPPlayer.this.mAssetResourceLoader == null)
      {
        TPPlayer.this.mLogger.error("mAssetResourceLoader not set");
        return "";
      }
      return TPPlayer.this.mAssetResourceLoader.getDataFilePath(paramInt, paramString);
    }
    
    public long getDataTotalSize(int paramInt, String paramString)
    {
      if (TPPlayer.this.mAssetResourceLoader == null)
      {
        TPPlayer.this.mLogger.error("mAssetResourceLoader not set");
        return -1L;
      }
      return TPPlayer.this.mAssetResourceLoader.getDataTotalSize(paramInt, paramString);
    }
    
    public Object getPlayInfo(long paramLong)
    {
      return null;
    }
    
    public Object getPlayInfo(String paramString)
    {
      return null;
    }
    
    public long getPlayerBufferLength()
    {
      ITPPlayerAdapter localITPPlayerAdapter = TPPlayer.this.mPlayerAdapter;
      if (localITPPlayerAdapter != null) {
        return localITPPlayerAdapter.getPlayableDurationMs() - TPPlayer.this.mPlayerAdapter.getCurrentPositionMs();
      }
      return 0L;
    }
    
    public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      TPPlayerListeners localTPPlayerListeners = TPPlayer.this.mPlayerListeners;
      if (localTPPlayerListeners != null) {
        localTPPlayerListeners.onAudioFrameOut(TPPlayer.this, paramTPAudioFrameBuffer);
      }
    }
    
    public TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      TPPlayerListeners localTPPlayerListeners = TPPlayer.this.mPlayerListeners;
      if (localTPPlayerListeners != null) {
        return localTPPlayerListeners.onAudioProcessFrameOut(TPPlayer.this, paramTPPostProcessFrameBuffer);
      }
      return null;
    }
    
    public void onCompletion()
    {
      TPPlayer.this.pushEvent(111, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(0)).build());
      TPPlayer.this.handlePlayerCallback(260, 0, 0, null);
    }
    
    public void onDetailInfo(TPPlayerDetailInfo paramTPPlayerDetailInfo)
    {
      TPPlayerListeners localTPPlayerListeners = TPPlayer.this.mPlayerListeners;
      if (localTPPlayerListeners != null) {
        localTPPlayerListeners.onDetailInfo(TPPlayer.this, paramTPPlayerDetailInfo);
      }
    }
    
    public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      TPPlayer.this.mLogger.info("onDownloadCdnUrlExpired");
      TPPlayer.this.handlePlayerCallback(275, 0, 0, paramMap);
    }
    
    public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      TPPlayer.this.mLogger.info("onDownloadCdnUrlInfoUpdate, url:" + paramString1 + ", cdnIp:" + paramString2 + ", uip:" + paramString3 + ", errorCodeStr:" + paramString4);
      paramString4 = new TPPlayerMsg.TPCDNURLInfo();
      paramString4.url = paramString1;
      paramString4.cdnIp = paramString2;
      paramString4.uIp = paramString3;
      TPPlayer.this.pushEvent(201, 0, 0, null, new TPHashMapBuilder().put("url", paramString1).put("cdnip", paramString2).put("cdnuip", paramString3).build());
      TPPlayer.this.handlePlayerCallback(270, 0, 0, paramString4);
    }
    
    public void onDownloadCdnUrlUpdate(String paramString)
    {
      TPPlayer.this.mLogger.info("onDownloadCdnUrlUpdate, url:" + paramString);
      TPPlayer.this.handlePlayerCallback(269, 0, 0, paramString);
    }
    
    public void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      TPPlayer.this.mLogger.info("onDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
      TPPlayer.this.handleOnError(paramInt1, paramInt2);
      TPPlayer.this.handlePlayerCallback(268, paramInt1, paramInt2, paramString);
    }
    
    public void onDownloadFinish()
    {
      TPPlayer.this.mLogger.info("onDownloadFinish");
      TPPlayer.this.handlePlayerCallback(271, 0, 0, Integer.valueOf(0));
    }
    
    public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      TPPlayer.this.mLogger.info("onDownloadProgressUpdate");
      TPPlayer.access$1102(TPPlayer.this, paramInt1);
      TPPlayer.access$1202(TPPlayer.this, paramLong1);
      TPPlayer.access$1302(TPPlayer.this, paramLong2);
      TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
      localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
      localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
      localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
      localTPDownLoadProgressInfo.totalFileSize = paramLong2;
      localTPDownLoadProgressInfo.extraInfo = paramString;
      TPPlayer.this.pushEvent(200, 0, 0, null, new TPHashMapBuilder().put("speed", Integer.valueOf(paramInt2)).put("spanId", paramString).build());
      TPPlayer.this.handlePlayerCallback(274, 0, 0, localTPDownLoadProgressInfo);
    }
    
    public void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      TPPlayer.this.mLogger.info("onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
      TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
      localTPProtocolInfo.protocolVersion = paramString2;
      localTPProtocolInfo.protocolName = paramString1;
      TPPlayer.this.pushEvent(202, 0, 0, null, new TPHashMapBuilder().put("proto", paramString1).put("protover", paramString2).build());
      TPPlayer.this.handlePlayerCallback(273, 0, 0, localTPProtocolInfo);
    }
    
    public void onDownloadStatusUpdate(int paramInt)
    {
      if (paramInt != TPPlayer.this.mProxyStatus)
      {
        TPPlayer.this.mLogger.info("onDownloadStatusUpdate, status:" + paramInt);
        TPPlayer.access$1402(TPPlayer.this, paramInt);
      }
      TPPlayer.this.handlePlayerCallback(272, paramInt, 0, null);
    }
    
    public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      Object localObject = TPPlayer.this.mPlayProxyManager.getPlayErrorCodeStr();
      TPPlayer.this.mLogger.info("onError playerErrorCodeStr=" + (String)localObject);
      j = paramInt1;
      i = paramInt2;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        i = Integer.parseInt((String)localObject);
        j = 4000;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TPPlayer.this.mLogger.printException(localException);
          j = paramInt1;
          i = paramInt2;
        }
      }
      TPPlayer.this.handleOnError(j, i);
      TPPlayer.this.mLogger.info("onError errorTypeReal=" + j + ", errorCodeReal=" + i);
      localObject = new TPThreadSwitchCommons.TPSwitchCommonParams();
      ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject).arg1 = paramLong1;
      ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject).arg2 = paramLong2;
      TPPlayer.this.handlePlayerCallback(262, j, i, localObject);
    }
    
    public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      TPPlayer.this.handleOnInfo(paramInt, paramLong1, paramLong2, paramObject);
      if (paramInt == 1011)
      {
        TPPlayer.this.handleSelectAudioTrack(paramObject);
        return;
      }
      if (paramInt == 1012)
      {
        TPPlayer.this.handleAudioTrackProxy(paramObject);
        return;
      }
      TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams = new TPThreadSwitchCommons.TPSwitchCommonParams();
      localTPSwitchCommonParams.arg1 = paramLong1;
      localTPSwitchCommonParams.arg2 = paramLong2;
      localTPSwitchCommonParams.extraObject = paramObject;
      TPPlayer.this.handlePlayerCallback(261, paramInt, 0, localTPSwitchCommonParams);
    }
    
    public void onPcdnDownloadFailed(String paramString)
    {
      TPPlayer.this.mLogger.info("onPcdnDownloadFailed: " + paramString);
      TPPlayer.this.handlePlayerCallback(282, 0, 0, paramString);
    }
    
    public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        TPPlayer.this.mLogger.info("onDownloadNoMoreData");
        TPPlayer.this.handlePlayerCallback(276, 0, 0, paramObject1);
        return null;
      }
      if (!(paramObject3 instanceof Integer))
      {
        TPPlayer.this.mLogger.info("MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err ext3.");
        return null;
      }
      paramObject1 = (Integer)paramObject3;
      TPPlayer.this.handlePlayerCallback(278, paramObject1.intValue(), 0, null);
      return null;
    }
    
    public void onPrepared()
    {
      TPPlayer.this.mPlayProxyManager.setProxyPlayState(0);
      Object localObject1 = TPPlayer.this.mPlayerAdapter.getPlaybackInfo();
      String str = ((TPPlaybackInfo)localObject1).getWidth() + "*" + ((TPPlaybackInfo)localObject1).getHeight();
      Object localObject2 = TPPlayer.this.mPlayerAdapter.getTrackInfo();
      int i;
      if (localObject2 != null)
      {
        int m = localObject2.length;
        int j = 0;
        int k;
        for (i = 0; j < m; i = k)
        {
          k = i;
          if (localObject2[j].trackType == 2) {
            k = i + 1;
          }
          j += 1;
        }
      }
      for (;;)
      {
        localObject2 = TPPlayer.this;
        localObject1 = new TPHashMapBuilder().put("playertype", Integer.valueOf(TPPlayer.this.mPlayerAdapter.getPlayerType())).put("definition", str).put("rate", Long.valueOf(((TPPlaybackInfo)localObject1).getVideoBitRate() / 8000L)).put("duration", Long.valueOf(((TPPlaybackInfo)localObject1).getDurationMs())).put("fmt", ((TPPlaybackInfo)localObject1).getContainerFormat()).put("etime", Long.valueOf(System.currentTimeMillis()));
        if (i > 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((TPPlayer)localObject2).pushEvent(103, 0, 0, null, ((TPHashMapBuilder)localObject1).put("multitrack", Boolean.valueOf(bool)).build());
          TPPlayer.this.handlePlayerCallback(257, 0, 0, null);
          return;
        }
        i = 0;
      }
    }
    
    public void onQuicDownloadStatusUpdate(String paramString)
    {
      TPLogUtil.i(TPPlayer.this.TAG, "onQuicDownloadStatusUpdate, info:" + paramString);
      TPPlayer.this.handlePlayerCallback(281, 0, 0, paramString);
    }
    
    public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      if (TPPlayer.this.mAssetResourceLoader == null)
      {
        TPPlayer.this.mLogger.error("mAssetResourceLoader not set");
        return -1;
      }
      return TPPlayer.this.mAssetResourceLoader.onReadData(paramInt, paramString, paramLong1, paramLong2);
    }
    
    public void onSeekComplete()
    {
      TPPlayer.this.setProxyStatePlayingOrPause();
      TPPlayer.this.pushEvent(110, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("petime", Long.valueOf(TPPlayer.this.getCurrentPositionMs())).build());
      TPPlayer.this.handlePlayerCallback(263, 0, 0, null);
    }
    
    public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      if (TPPlayer.this.mAssetResourceLoader == null)
      {
        TPPlayer.this.mLogger.error("mAssetResourceLoader not set");
        return -1;
      }
      return TPPlayer.this.mAssetResourceLoader.onStartReadData(paramInt, paramString, paramLong1, paramLong2);
    }
    
    public void onStateChange(int paramInt1, int paramInt2)
    {
      TPPlayer.this.handlePlayerCallback(277, paramInt1, paramInt2, null);
    }
    
    public int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      if (TPPlayer.this.mAssetResourceLoader == null)
      {
        TPPlayer.this.mLogger.error("mAssetResourceLoader not set");
        return -1;
      }
      return TPPlayer.this.mAssetResourceLoader.onStopReadData(paramInt1, paramString, paramInt2);
    }
    
    public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
    {
      TPPlayer.this.handlePlayerCallback(265, 0, 0, paramTPSubtitleData);
    }
    
    public void onSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      TPPlayer.this.handlePlayerCallback(279, 0, 0, paramTPSubtitleFrameBuffer);
    }
    
    public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      TPPlayerListeners localTPPlayerListeners = TPPlayer.this.mPlayerListeners;
      if (localTPPlayerListeners != null) {
        localTPPlayerListeners.onVideoFrameOut(TPPlayer.this, paramTPVideoFrameBuffer);
      }
    }
    
    public TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      TPPlayerListeners localTPPlayerListeners = TPPlayer.this.mPlayerListeners;
      if (localTPPlayerListeners != null) {
        return localTPPlayerListeners.onVideoProcessFrameOut(TPPlayer.this, paramTPPostProcessFrameBuffer);
      }
      return null;
    }
    
    public void onVideoSizeChanged(long paramLong1, long paramLong2)
    {
      TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams = new TPThreadSwitchCommons.TPSwitchCommonParams();
      localTPSwitchCommonParams.arg1 = paramLong1;
      localTPSwitchCommonParams.arg2 = paramLong2;
      TPPlayer.this.handlePlayerCallback(264, 0, 0, localTPSwitchCommonParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayer
 * JD-Core Version:    0.7.0.1
 */