package com.tencent.mobileqq.mini.widget.media.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Surface;
import awcj;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class TXLivePlayerJSAdapter
{
  public static final String CLASS_NAME_ITX_AUDIO_VOLUME_EVALUATION_LISTENER = "com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener";
  public static final String CLASS_NAME_ITX_LIVEPLAY_LISTENER = "com.tencent.rtmp.ITXLivePlayListener";
  public static final String CLASS_NAME_ITX_SNAPSHOT_LISTENER = "com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener";
  public static final String CLASS_NAME_TX_CLOUD_VIDEO_VIEW = "com.tencent.rtmp.ui.TXCloudVideoView";
  public static final String CLASS_NAME_TX_LIVEPLAY = "com.tencent.rtmp.WXLivePlayer";
  public static final String CLASS_NAME_TX_LIVEPLAY_CONFIG = "com.tencent.rtmp.WXLivePlayConfig";
  public static final String EVT_DESCRIPTION = "EVT_MSG";
  public static final String EVT_GET_MSG = "EVT_GET_MSG";
  public static final String NET_STATUS_AUDIO_BITRATE = "AUDIO_BITRATE";
  public static final String NET_STATUS_AUDIO_CACHE = "AUDIO_CACHE";
  public static final String NET_STATUS_AUDIO_CACHE_THRESHOLD = "AUDIO_CACHE_THRESHOLD";
  public static final String NET_STATUS_AUDIO_DROP = "AUDIO_DROP";
  public static final String NET_STATUS_AUDIO_INFO = "AUDIO_PLAY_INFO";
  public static final String NET_STATUS_AV_PLAY_INTERVAL = "AV_PLAY_INTERVAL";
  public static final String NET_STATUS_AV_RECV_INTERVAL = "AV_RECV_INTERVAL";
  public static final String NET_STATUS_CPU_USAGE = "CPU_USAGE";
  public static final String NET_STATUS_NET_JITTER = "NET_JITTER";
  public static final String NET_STATUS_NET_SPEED = "NET_SPEED";
  public static final String NET_STATUS_SERVER_IP = "SERVER_IP";
  public static final String NET_STATUS_VIDEO_BITRATE = "VIDEO_BITRATE";
  public static final String NET_STATUS_VIDEO_CACHE = "VIDEO_CACHE";
  public static final String NET_STATUS_VIDEO_DROP = "VIDEO_DROP";
  public static final String NET_STATUS_VIDEO_FPS = "VIDEO_FPS";
  public static final String NET_STATUS_VIDEO_GOP = "VIDEO_GOP";
  public static final String NET_STATUS_VIDEO_HEIGHT = "VIDEO_HEIGHT";
  public static final String NET_STATUS_VIDEO_WIDTH = "VIDEO_WIDTH";
  public static final String NET_STATUS_V_DEC_CACHE_SIZE = "V_DEC_CACHE_SIZE";
  public static final String NET_STATUS_V_SUM_CACHE_SIZE = "V_SUM_CACHE_SIZE";
  public static final int PLAY_ERR_NET_DISCONNECT = -2301;
  public static final int PLAY_EVT_GET_MESSAGE = 2012;
  public static final int PLAY_EVT_PLAY_END = 2006;
  private static final String TAG = "TXLivePlayerJSAdapter";
  public static final int TX_LIVEPLAY_PLAY_TYPE_LIVE_FLV = 1;
  public static final int TX_LIVEPLAY_PLAY_TYPE_LIVE_RTMP = 0;
  public static final int TX_LIVEPLAY_PLAY_TYPE_LIVE_RTMP_ACC = 5;
  public static final int TX_LIVEPLAY_PLAY_TYPE_LOCAL_VIDEO = 6;
  public static final int TX_LIVEPLAY_PLAY_TYPE_VOD_FLV = 2;
  public static final int TX_LIVEPLAY_PLAY_TYPE_VOD_HLS = 3;
  public static final int TX_LIVEPLAY_PLAY_TYPE_VOD_MP4 = 4;
  public static final int VIDEO_ANGLE_HOME_DOWN = 1;
  private ISnapshotOuterListener iTXSnapshotListener;
  private IPlayOuterListener iWXLivePlayerOuterListener;
  private ITXAudioVolumeEvaluationOuterListener itxAudioVolumeEvaluationOuterListener;
  private boolean mAutoPauseIfNavigate = true;
  private boolean mAutoPauseIfOpenNative = true;
  private boolean mAutoPlay;
  @Deprecated
  private boolean mBackgroundMute = true;
  private Context mContext;
  private boolean mDebug;
  private boolean mEnableRecvMessage;
  private boolean mInited;
  private float mMaxCache = 3.0F;
  private float mMinCache = 1.0F;
  private int mMode = 1;
  private boolean mMute;
  private boolean mMuteAudio;
  private boolean mMuteVideo;
  private boolean mNeedAudioVolumeNotify;
  private boolean mNeedEvent;
  private String mObjectFit = "contain";
  private String mOrientation = "vertical";
  private int mPlayType;
  private String mPlayerUrl = "";
  private boolean mPlayingBeforeEnterBackground;
  private String mSoundMode = "speaker";
  private Surface mSurface;
  private Object txCloudVideoView;
  private Object txLivePlayConfig;
  private Object txLivePlayer;
  
  public TXLivePlayerJSAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.txLivePlayConfig = awcj.creatSpecifiedObject("com.tencent.rtmp.WXLivePlayConfig", null, new Object[0]);
    this.txLivePlayer = awcj.creatSpecifiedObject("com.tencent.rtmp.WXLivePlayer", awcj.getParamsClass(new Class[] { Context.class }), new Object[] { this.mContext });
    txLivePlayer_enableHardwareDecode(Boolean.valueOf(true));
    try
    {
      awcj.callSpecifiedMethod(this.txLivePlayer, "setConfig", false, awcj.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { this.txLivePlayConfig });
      paramContext = Class.forName("com.tencent.rtmp.ITXLivePlayListener");
      Object localObject = new InnerTXLivePlayListenerImpl();
      txLivePlayer_setPlayListener(Proxy.newProxyInstance(TXLivePlayerJSAdapter.class.getClassLoader(), new Class[] { paramContext }, (InvocationHandler)localObject));
      paramContext = Class.forName("com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener");
      localObject = new InnerAudioVolumeEvaluationListenerImpl();
      txLivePlayer_setAudioVolumeEvaluationListener(Proxy.newProxyInstance(TXLivePlayerJSAdapter.class.getClassLoader(), new Class[] { paramContext }, (InvocationHandler)localObject));
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      QLog.e("TXLivePlayerJSAdapter", 1, "bind InnerTXLivePlayListenerImpl failed, e" + paramContext.toString());
    }
  }
  
  private int getPlayType(Bundle paramBundle)
  {
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.mPlayerUrl == null) {}
      while ((this.mPlayerUrl == null) || ((!this.mPlayerUrl.startsWith("http://")) && (!this.mPlayerUrl.startsWith("https://"))) || (!this.mPlayerUrl.contains(".flv"))) {
        return 0;
      }
      return 1;
    }
    return 5;
  }
  
  private void parseAndApplyParams(Bundle paramBundle, boolean paramBoolean)
  {
    int i = 0;
    boolean bool = this.mMuteAudio;
    String str;
    if (paramBundle.keySet().contains("muteAudio"))
    {
      bool = paramBundle.getBoolean("muteAudio");
      if ((paramBoolean) || (bool != this.mMuteAudio)) {
        txLivePlayer_muteAudio(Boolean.valueOf(bool));
      }
      this.mMuteAudio = bool;
      bool = paramBundle.getBoolean("muteVideo", this.mMuteVideo);
      if ((paramBoolean) || (bool != this.mMuteVideo)) {
        txLivePlayer_muteVideo(Boolean.valueOf(bool));
      }
      this.mMuteVideo = bool;
      str = paramBundle.getString("orientation", this.mOrientation);
      if ((paramBoolean) || (!str.equalsIgnoreCase(this.mOrientation)))
      {
        if (!str.equalsIgnoreCase("horizontal")) {
          break label492;
        }
        txLivePlayer_setRenderRotation(270);
      }
      label148:
      this.mOrientation = str;
      str = paramBundle.getString("objectFit", this.mObjectFit);
      if ((paramBoolean) || (!str.equalsIgnoreCase(this.mObjectFit)))
      {
        if (!str.equalsIgnoreCase("fillCrop")) {
          break label510;
        }
        txLivePlayer_setRenderMode(0);
      }
      label199:
      this.mObjectFit = str;
      if (paramBundle.keySet().contains("soundMode"))
      {
        this.mSoundMode = paramBundle.getString("soundMode", this.mSoundMode);
        if (!this.mSoundMode.equalsIgnoreCase("speaker")) {
          break label528;
        }
        txLivePlayer_setAudioRoute(0);
      }
    }
    for (;;)
    {
      this.mMinCache = paramBundle.getFloat("minCache", this.mMinCache);
      this.mMaxCache = paramBundle.getFloat("maxCache", this.mMaxCache);
      txLivePlayConfig_setAutoAdjustCacheTime(Boolean.valueOf(true));
      txLivePlayConfig_setCacheTime(this.mMinCache);
      txLivePlayConfig_setMinAutoAdjustCacheTime(this.mMinCache);
      txLivePlayConfig_setMaxAutoAdjustCacheTime(this.mMaxCache);
      this.mEnableRecvMessage = paramBundle.getBoolean("enableRecvMessage", this.mEnableRecvMessage);
      txPlayConfig_setEnableMessage(Boolean.valueOf(this.mEnableRecvMessage));
      txLivePlayer_setConfig(this.txLivePlayConfig);
      this.mNeedEvent = paramBundle.getBoolean("needEvent", this.mNeedEvent);
      this.mAutoPauseIfNavigate = paramBundle.getBoolean("autoPauseIfNavigate", this.mAutoPauseIfNavigate);
      this.mAutoPauseIfOpenNative = paramBundle.getBoolean("autoPauseIfOpenNative", this.mAutoPauseIfOpenNative);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.mNeedAudioVolumeNotify);
      if (paramBoolean != this.mNeedAudioVolumeNotify)
      {
        if (paramBoolean) {
          i = 300;
        }
        txLivePlayer_enableAudioVolumeEvaluation(i);
      }
      this.mNeedAudioVolumeNotify = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.mDebug);
      if (paramBoolean != this.mDebug) {
        txLivePlayer_showDebugLog(Boolean.valueOf(paramBoolean));
      }
      this.mDebug = paramBoolean;
      return;
      if (!paramBundle.keySet().contains("muted")) {
        break;
      }
      bool = paramBundle.getBoolean("muted");
      break;
      label492:
      if (!str.equalsIgnoreCase("vertical")) {
        break label148;
      }
      txLivePlayer_setRenderRotation(0);
      break label148;
      label510:
      if (!str.equalsIgnoreCase("contain")) {
        break label199;
      }
      txLivePlayer_setRenderMode(1);
      break label199;
      label528:
      if (this.mSoundMode.equalsIgnoreCase("ear")) {
        txLivePlayer_setAudioRoute(1);
      }
    }
  }
  
  private void printJSParams(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str.equalsIgnoreCase("playUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("objectFit")) || (str.equalsIgnoreCase("soundMode"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
        } else if ((str.equalsIgnoreCase("mode")) || (str.equalsIgnoreCase("playType"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
        } else if ((str.equalsIgnoreCase("minCache")) || (str.equalsIgnoreCase("maxCache"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
        } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autoplay")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("muteAudio")) || (str.equalsIgnoreCase("muteVideo")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needAudioVolume")) || (str.equalsIgnoreCase("enableRecvMessage")) || (str.equalsIgnoreCase("debug"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
        }
      }
      QLog.d("TXLivePlayerJSAdapter", 2, paramString);
    }
  }
  
  private void safeRecycleBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
  }
  
  private void txCloudVideoView_disableLog(Boolean paramBoolean)
  {
    awcj.callSpecifiedMethod(this.txCloudVideoView, "disableLog", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txCloudVideoView_showLog(Boolean paramBoolean)
  {
    awcj.callSpecifiedMethod(this.txCloudVideoView, "showLog", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayConfig_setAutoAdjustCacheTime(Boolean paramBoolean)
  {
    awcj.callSpecifiedMethod(this.txLivePlayConfig, "setAutoAdjustCacheTime", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayConfig_setCacheTime(float paramFloat)
  {
    awcj.callSpecifiedMethod(this.txLivePlayConfig, "setCacheTime", false, awcj.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void txLivePlayConfig_setMaxAutoAdjustCacheTime(float paramFloat)
  {
    awcj.callSpecifiedMethod(this.txLivePlayConfig, "setMaxAutoAdjustCacheTime", false, awcj.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void txLivePlayConfig_setMinAutoAdjustCacheTime(float paramFloat)
  {
    awcj.callSpecifiedMethod(this.txLivePlayConfig, "setMinAutoAdjustCacheTime", false, awcj.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void txLivePlay_snapshot(Object paramObject)
  {
    try
    {
      awcj.callSpecifiedMethod(this.txLivePlayer, "snapshot", false, awcj.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_enableAudioVolumeEvaluation(int paramInt)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "enableAudioVolumeEvaluation", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_enableHardwareDecode(Boolean paramBoolean)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "enableHardwareDecode", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private boolean txLivePlayer_isPlaying()
  {
    Object localObject = awcj.callSpecifiedMethod(this.txLivePlayer, "isPlaying", false, null, new Object[0]);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  private void txLivePlayer_muteAudio(Boolean paramBoolean)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "muteAudio", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayer_muteVideo(Boolean paramBoolean)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "muteVideo", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayer_pause()
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "pause", false, null, new Object[0]);
  }
  
  private void txLivePlayer_resume()
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "resume", false, null, new Object[0]);
  }
  
  private void txLivePlayer_setAudioRoute(int paramInt)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "setAudioRoute", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_setAudioVolumeEvaluationListener(Object paramObject)
  {
    try
    {
      awcj.callSpecifiedMethod(this.txLivePlayer, "setAudioVolumeEvaluationListener", false, awcj.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_setConfig(Object paramObject)
  {
    try
    {
      awcj.callSpecifiedMethod(this.txLivePlayer, "setConfig", false, awcj.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_setPlayListener(Object paramObject)
  {
    try
    {
      awcj.callSpecifiedMethod(this.txLivePlayer, "setPlayListener", false, awcj.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePlayListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_setPlayerView(Object paramObject)
  {
    try
    {
      awcj.callSpecifiedMethod(this.txLivePlayer, "setPlayerView", false, awcj.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ui.TXCloudVideoView") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_setRenderMode(int paramInt)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "setRenderMode", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_setRenderRotation(int paramInt)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "setRenderRotation", false, awcj.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_setSurface(Surface paramSurface)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "setSurface", false, awcj.getParamsClass(new Class[] { Surface.class }), new Object[] { paramSurface });
  }
  
  private void txLivePlayer_setSurfaceSize(int paramInt1, int paramInt2)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "setSurfaceSize", false, awcj.getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private void txLivePlayer_showDebugLog(Boolean paramBoolean)
  {
    awcj.callSpecifiedMethod(this.txLivePlayer, "showDebugLog", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private int txLivePlayer_startPlay(String paramString, int paramInt)
  {
    paramString = awcj.callSpecifiedMethod(this.txLivePlayer, "startPlay", false, awcj.getParamsClass(new Class[] { String.class, Integer.TYPE }), new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramString != null) {
      return ((Integer)paramString).intValue();
    }
    return -1;
  }
  
  private int txLivePlayer_stopPlay(Boolean paramBoolean)
  {
    paramBoolean = awcj.callSpecifiedMethod(this.txLivePlayer, "stopPlay", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
    if (paramBoolean != null) {
      return ((Integer)paramBoolean).intValue();
    }
    return -1;
  }
  
  private void txPlayConfig_setEnableMessage(Boolean paramBoolean)
  {
    awcj.callSpecifiedMethod(this.txLivePlayConfig, "setEnableMessage", false, awcj.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public Bundle createBundleFromJsonObject(JSONObject paramJSONObject)
  {
    int j = 0;
    Bundle localBundle = new Bundle();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "playUrl";
    arrayOfString[1] = "orientation";
    arrayOfString[2] = "objectFit";
    arrayOfString[3] = "soundMode";
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      if (paramJSONObject.has(str)) {
        localBundle.putString(str, paramJSONObject.optString(str));
      }
      i += 1;
    }
    arrayOfString = new String[10];
    arrayOfString[0] = "muted";
    arrayOfString[1] = "muteAudio";
    arrayOfString[2] = "muteVideo";
    arrayOfString[3] = "autoplay";
    arrayOfString[4] = "enableRecvMessage";
    arrayOfString[5] = "needAudioVolume";
    arrayOfString[6] = "needEvent";
    arrayOfString[7] = "autoPauseIfNavigate";
    arrayOfString[8] = "autoPauseIfOpenNative";
    arrayOfString[9] = "debug";
    k = arrayOfString.length;
    i = 0;
    while (i < k)
    {
      str = arrayOfString[i];
      if (paramJSONObject.has(str)) {
        localBundle.putBoolean(str, paramJSONObject.optBoolean(str));
      }
      i += 1;
    }
    arrayOfString = new String[2];
    arrayOfString[0] = "minCache";
    arrayOfString[1] = "maxCache";
    k = arrayOfString.length;
    i = 0;
    while (i < k)
    {
      str = arrayOfString[i];
      if (paramJSONObject.has(str)) {
        localBundle.putFloat(str, (float)paramJSONObject.optDouble(str));
      }
      i += 1;
    }
    arrayOfString = new String[1];
    arrayOfString[0] = "mode";
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      if (paramJSONObject.has(str)) {
        localBundle.putInt(str, paramJSONObject.optInt(str));
      }
      i += 1;
    }
    return localBundle;
  }
  
  public TXJSAdapterError enterBackground(int paramInt)
  {
    QLog.d("TXLivePlayerJSAdapter", 4, "enterBackground");
    if (((paramInt == 2) && (!this.mAutoPauseIfOpenNative)) || ((paramInt == 1) && (!this.mAutoPauseIfNavigate)))
    {
      this.mPlayingBeforeEnterBackground = false;
      return new TXJSAdapterError();
    }
    this.mPlayingBeforeEnterBackground = txLivePlayer_isPlaying();
    if (this.mPlayingBeforeEnterBackground)
    {
      if ((this.mNeedEvent) && (this.iWXLivePlayerOuterListener != null)) {
        this.iWXLivePlayerOuterListener.onPlayEvent(6000, new Bundle());
      }
      return operateLivePlayer("pause", null);
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError enterForeground()
  {
    if (this.mPlayingBeforeEnterBackground) {
      return operateLivePlayer("resume", null);
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initEmbeddedLivePlayer(JSONObject paramJSONObject)
  {
    paramJSONObject = createBundleFromJsonObject(paramJSONObject);
    if (paramJSONObject == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    printJSParams("initLivePlayer", paramJSONObject);
    this.txCloudVideoView = null;
    txLivePlayer_setPlayerView(null);
    this.mPlayerUrl = paramJSONObject.getString("playUrl", this.mPlayerUrl);
    this.mPlayType = getPlayType(paramJSONObject);
    parseAndApplyParams(paramJSONObject, true);
    this.mAutoPlay = paramJSONObject.getBoolean("autoplay", this.mAutoPlay);
    if ((this.mAutoPlay) && (this.mPlayerUrl != null) && (!this.mPlayerUrl.isEmpty()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "initLivePlayer: startPlay");
      txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    this.mInited = true;
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initLivePlayer(Object paramObject, Bundle paramBundle)
  {
    if ((paramObject == null) || (paramBundle == null)) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    printJSParams("initLivePlayer", paramBundle);
    this.txCloudVideoView = paramObject;
    txCloudVideoView_disableLog(Boolean.valueOf(false));
    txLivePlayer_setPlayerView(paramObject);
    this.mPlayerUrl = paramBundle.getString("playUrl", this.mPlayerUrl);
    this.mPlayType = getPlayType(paramBundle);
    parseAndApplyParams(paramBundle, true);
    this.mAutoPlay = paramBundle.getBoolean("autoplay", this.mAutoPlay);
    if ((this.mAutoPlay) && (this.mPlayerUrl != null) && (!this.mPlayerUrl.isEmpty()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "initLivePlayer: startPlay");
      txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    this.mInited = true;
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initLivePlayer(Object paramObject, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TXLivePlayerJSAdapter", 2, "initLivePlayer: params = " + paramJSONObject.toString());
    }
    return initLivePlayer(paramObject, createBundleFromJsonObject(paramJSONObject));
  }
  
  public boolean isMute()
  {
    return this.mMute;
  }
  
  public boolean isPlaying()
  {
    return txLivePlayer_isPlaying();
  }
  
  public TXJSAdapterError operateLivePlayer(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    QLog.d("TXLivePlayerJSAdapter", 2, "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePlayer");
    }
    if (paramString.equalsIgnoreCase("play")) {
      txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    for (;;)
    {
      return new TXJSAdapterError();
      if (paramString.equalsIgnoreCase("stop"))
      {
        txLivePlayer_stopPlay(Boolean.valueOf(true));
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        txLivePlayer_pause();
      }
      else
      {
        if (!paramString.equalsIgnoreCase("resume")) {
          break;
        }
        txLivePlayer_resume();
      }
    }
    if (paramString.equalsIgnoreCase("mute"))
    {
      if (!this.mMute) {}
      for (boolean bool = true;; bool = false)
      {
        this.mMute = bool;
        txLivePlayer_muteAudio(Boolean.valueOf(this.mMute));
        break;
      }
    }
    return new TXJSAdapterError(-4, "invalid operate command");
  }
  
  public void setItxAudioVolumeEvaluationOuterListener(ITXAudioVolumeEvaluationOuterListener paramITXAudioVolumeEvaluationOuterListener)
  {
    this.itxAudioVolumeEvaluationOuterListener = paramITXAudioVolumeEvaluationOuterListener;
  }
  
  public void setPlayListener(IPlayOuterListener paramIPlayOuterListener)
  {
    this.iWXLivePlayerOuterListener = paramIPlayOuterListener;
  }
  
  public void setSnapshotListener(ISnapshotOuterListener paramISnapshotOuterListener)
  {
    this.iTXSnapshotListener = paramISnapshotOuterListener;
  }
  
  public TXJSAdapterError setSurface(Surface paramSurface)
  {
    this.mSurface = paramSurface;
    txLivePlayer_setSurface(paramSurface);
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError setSurfaceSize(int paramInt1, int paramInt2)
  {
    txLivePlayer_setSurfaceSize(paramInt1, paramInt2);
    return new TXJSAdapterError();
  }
  
  public void takePhoto(boolean paramBoolean)
  {
    if (this.txLivePlayer != null) {}
    try
    {
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener");
      InnerITXSnapshotListenerImpl localInnerITXSnapshotListenerImpl = new InnerITXSnapshotListenerImpl();
      localInnerITXSnapshotListenerImpl.setNeedCompress(paramBoolean);
      txLivePlay_snapshot(Proxy.newProxyInstance(TXLivePlayerJSAdapter.class.getClassLoader(), new Class[] { localClass }, localInnerITXSnapshotListenerImpl));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
  
  public TXJSAdapterError uninitLivePlayer()
  {
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePlayer");
    }
    txLivePlayer_stopPlay(Boolean.valueOf(true));
    txLivePlayer_setPlayListener(null);
    this.mInited = false;
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError updateLivePlayer(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new TXJSAdapterError(-1, "invalid params");
    }
    if (!this.mInited) {
      return new TXJSAdapterError(-3, "uninited livePlayer");
    }
    printJSParams("updateLivePlayer", paramBundle);
    parseAndApplyParams(paramBundle, false);
    boolean bool = txLivePlayer_isPlaying();
    String str = paramBundle.getString("playUrl", this.mPlayerUrl);
    if ((str != null) && (!str.isEmpty()) && (this.mPlayerUrl != null) && (!this.mPlayerUrl.equalsIgnoreCase(str)) && (txLivePlayer_isPlaying()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "updateLivePlayer: stopPlay playUrl-old = " + this.mPlayerUrl + " playUrl-new = " + str);
      txLivePlayer_stopPlay(Boolean.valueOf(true));
    }
    this.mPlayerUrl = str;
    int i = getPlayType(paramBundle);
    if ((i != this.mPlayType) && (txLivePlayer_isPlaying()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "updateLivePlayer: stopPlay  playType-old = " + this.mPlayType + " playType-new = " + i);
      txLivePlayer_stopPlay(Boolean.valueOf(true));
    }
    this.mPlayType = i;
    this.mAutoPlay = paramBundle.getBoolean("autoplay", this.mAutoPlay);
    if (((this.mAutoPlay) || (bool)) && (this.mPlayerUrl != null) && (!this.mPlayerUrl.isEmpty()) && (!txLivePlayer_isPlaying()))
    {
      QLog.d("TXLivePlayerJSAdapter", 4, "updateLivePlayer: startPlay");
      txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError updateLivePlayer(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TXLivePlayerJSAdapter", 2, "updateLivePlayer: params = " + paramJSONObject.toString());
    }
    return updateLivePlayer(createBundleFromJsonObject(paramJSONObject));
  }
  
  public static abstract interface IPlayOuterListener
  {
    public abstract void onNetStatus(Bundle paramBundle);
    
    public abstract void onPlayEvent(int paramInt, Bundle paramBundle);
  }
  
  public static abstract interface ISnapshotOuterListener
  {
    public abstract void onSnapshot(Bitmap paramBitmap);
  }
  
  public static abstract interface ITXAudioVolumeEvaluationOuterListener
  {
    public abstract void onAudioVolumeEvaluationNotify(int paramInt);
  }
  
  public class InnerAudioVolumeEvaluationListenerImpl
    implements InvocationHandler
  {
    public InnerAudioVolumeEvaluationListenerImpl() {}
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      QLog.e("TXLivePlayerJSAdapter", 1, "InnerAudioVolumeEvaluationListenerImpl invoke:" + paramMethod.getName());
      if (Object.class.equals(paramMethod.getDeclaringClass())) {
        try
        {
          paramObject = paramMethod.invoke(this, paramArrayOfObject);
          return paramObject;
        }
        catch (Throwable paramObject)
        {
          paramObject.printStackTrace();
          return null;
        }
      }
      if (("onAudioVolumeEvaluationNotify".equals(paramMethod.getName())) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Integer)))
      {
        int i = ((Integer)paramArrayOfObject[0]).intValue();
        if (TXLivePlayerJSAdapter.this.itxAudioVolumeEvaluationOuterListener != null) {
          TXLivePlayerJSAdapter.this.itxAudioVolumeEvaluationOuterListener.onAudioVolumeEvaluationNotify(i);
        }
      }
      return null;
    }
  }
  
  public class InnerITXSnapshotListenerImpl
    implements InvocationHandler
  {
    private boolean mNeedCompress;
    
    public InnerITXSnapshotListenerImpl() {}
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      QLog.e("TXLivePlayerJSAdapter", 1, "InnerITXSnapshotListenerImpl invoke:" + paramMethod.getName());
      if (Object.class.equals(paramMethod.getDeclaringClass())) {
        try
        {
          paramObject = paramMethod.invoke(this, paramArrayOfObject);
          return paramObject;
        }
        catch (Throwable paramObject)
        {
          paramObject.printStackTrace();
          return null;
        }
      }
      if (("onSnapshot".equals(paramMethod.getName())) && (paramArrayOfObject.length == 1))
      {
        paramObject = (Bitmap)paramArrayOfObject[0];
        if (TXLivePlayerJSAdapter.this.iTXSnapshotListener != null)
        {
          if (!this.mNeedCompress) {
            break label182;
          }
          if (paramObject == null) {
            break label166;
          }
          int i = paramObject.getWidth();
          int j = paramObject.getHeight();
          paramMethod = new Matrix();
          paramMethod.setScale(0.5F, 0.5F);
          paramMethod = Bitmap.createBitmap(paramObject, 0, 0, i, j, paramMethod, false);
          TXLivePlayerJSAdapter.this.iTXSnapshotListener.onSnapshot(paramMethod);
          TXLivePlayerJSAdapter.this.safeRecycleBitmap(paramObject);
        }
      }
      for (;;)
      {
        return null;
        label166:
        TXLivePlayerJSAdapter.this.iTXSnapshotListener.onSnapshot(paramObject);
        continue;
        label182:
        TXLivePlayerJSAdapter.this.iTXSnapshotListener.onSnapshot(paramObject);
      }
    }
    
    public void setNeedCompress(boolean paramBoolean)
    {
      this.mNeedCompress = paramBoolean;
    }
  }
  
  public class InnerTXLivePlayListenerImpl
    implements InvocationHandler
  {
    public InnerTXLivePlayListenerImpl() {}
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      QLog.e("TXLivePlayerJSAdapter", 1, "InnerTXLivePlayListenerImpl invoke:" + paramMethod.getName());
      if (Object.class.equals(paramMethod.getDeclaringClass())) {
        try
        {
          paramObject = paramMethod.invoke(this, paramArrayOfObject);
          return paramObject;
        }
        catch (Throwable paramObject)
        {
          paramObject.printStackTrace();
        }
      }
      for (;;)
      {
        return null;
        if ("onPlayEvent".equals(paramMethod.getName()))
        {
          if (paramArrayOfObject.length == 2)
          {
            paramMethod = (Integer)paramArrayOfObject[0];
            paramArrayOfObject = (Bundle)paramArrayOfObject[1];
            if ((paramMethod.equals(Integer.valueOf(2006))) || (paramMethod.equals(Integer.valueOf(-2301)))) {
              TXLivePlayerJSAdapter.this.operateLivePlayer("stop", null);
            }
            if ((paramMethod.intValue() == 2012) && (paramArrayOfObject != null))
            {
              paramObject = paramArrayOfObject.getByteArray("EVT_GET_MSG");
              if ((paramObject == null) || (paramObject.length <= 0)) {
                break label263;
              }
            }
            for (;;)
            {
              try
              {
                paramObject = new String(paramObject, "UTF-8");
                paramArrayOfObject.putString("EVT_MSG", paramObject);
                if ((TXLivePlayerJSAdapter.this.mNeedEvent) && (TXLivePlayerJSAdapter.this.iWXLivePlayerOuterListener != null)) {
                  TXLivePlayerJSAdapter.this.iWXLivePlayerOuterListener.onPlayEvent(paramMethod.intValue(), paramArrayOfObject);
                }
                if (paramArrayOfObject == null) {
                  break;
                }
                paramObject = paramArrayOfObject.getString("EVT_MSG");
                QLog.d("TXLivePlayerJSAdapter", 2, "onPlayEvent: event = " + paramMethod + " message = " + paramObject);
              }
              catch (UnsupportedEncodingException paramObject)
              {
                paramObject.printStackTrace();
              }
              label263:
              paramObject = "";
            }
          }
        }
        else if (("onNetStatus".equals(paramMethod.getName())) && (paramArrayOfObject.length == 1))
        {
          paramObject = (Bundle)paramArrayOfObject[0];
          if (TXLivePlayerJSAdapter.this.iWXLivePlayerOuterListener != null) {
            TXLivePlayerJSAdapter.this.iWXLivePlayerOuterListener.onNetStatus(paramObject);
          }
          if (QLog.isColorLevel())
          {
            paramObject = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramObject.getString("CPU_USAGE"), "RES:" + paramObject.getInt("VIDEO_WIDTH") + "*" + paramObject.getInt("VIDEO_HEIGHT"), "SPD:" + paramObject.getInt("NET_SPEED") + "Kbps", "JIT:" + paramObject.getInt("NET_JITTER"), "FPS:" + paramObject.getInt("VIDEO_FPS"), "GOP:" + paramObject.getInt("VIDEO_GOP") + "s", "ARA:" + paramObject.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramObject.getInt("AUDIO_CACHE") + " | " + paramObject.getInt("VIDEO_CACHE") + "," + paramObject.getInt("V_SUM_CACHE_SIZE") + "," + paramObject.getInt("V_DEC_CACHE_SIZE") + " | " + paramObject.getInt("AV_RECV_INTERVAL") + "," + paramObject.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramObject.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramObject.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramObject.getInt("AUDIO_DROP") + "|" + paramObject.getInt("VIDEO_DROP"), "SVR:" + paramObject.getString("SERVER_IP"), "AUDIO:" + paramObject.getString("AUDIO_PLAY_INFO") });
            QLog.d("TXLivePlayerJSAdapter", 2, "onNetStatus:" + paramObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter
 * JD-Core Version:    0.7.0.1
 */