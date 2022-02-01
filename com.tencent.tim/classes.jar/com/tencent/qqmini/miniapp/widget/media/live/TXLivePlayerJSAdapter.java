package com.tencent.qqmini.miniapp.widget.media.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
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
  private boolean mAutoPlay = false;
  @Deprecated
  private boolean mBackgroundMute = true;
  private Context mContext;
  private boolean mDebug = false;
  private boolean mEnableRecvMessage = false;
  private boolean mInited = false;
  private float mMaxCache = 3.0F;
  private float mMinCache = 1.0F;
  private int mMode = 1;
  private boolean mMute = false;
  private boolean mMuteAudio = false;
  private boolean mMuteVideo = false;
  private boolean mNeedAudioVolumeNotify = false;
  private boolean mNeedEvent = false;
  private String mObjectFit = "contain";
  private String mOrientation = "vertical";
  private int mPlayType = 0;
  private String mPlayerUrl = "";
  private boolean mPlayingBeforeEnterBackground = false;
  private String mSoundMode = "speaker";
  private Surface mSurface;
  private Object txCloudVideoView;
  private Object txLivePlayConfig;
  private Object txLivePlayer;
  
  public TXLivePlayerJSAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.txLivePlayConfig = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePlayConfig", null, new Object[0]);
    this.txLivePlayer = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePlayer", JarReflectUtil.getParamsClass(new Class[] { Context.class }), new Object[] { this.mContext });
    txLivePlayer_enableHardwareDecode(Boolean.valueOf(true));
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setConfig", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { this.txLivePlayConfig });
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
      QMLog.e("TXLivePlayerJSAdapter", "bind InnerTXLivePlayListenerImpl failed, e" + paramContext.toString());
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
    if (QMLog.isColorLevel())
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
      QMLog.d("TXLivePlayerJSAdapter", paramString);
    }
  }
  
  private void safeRecycleBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      QMLog.d("TXLivePlayerJSAdapter", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
  }
  
  private void txCloudVideoView_disableLog(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.txCloudVideoView, "disableLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txCloudVideoView_showLog(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.txCloudVideoView, "showLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayConfig_setAutoAdjustCacheTime(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayConfig, "setAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayConfig_setCacheTime(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayConfig, "setCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void txLivePlayConfig_setMaxAutoAdjustCacheTime(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayConfig, "setMaxAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void txLivePlayConfig_setMinAutoAdjustCacheTime(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayConfig, "setMinAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void txLivePlay_snapshot(Object paramObject)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "snapshot", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_enableAudioVolumeEvaluation(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "enableAudioVolumeEvaluation", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_enableHardwareDecode(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "enableHardwareDecode", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private boolean txLivePlayer_isPlaying()
  {
    Object localObject = JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "isPlaying", false, null, new Object[0]);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  private void txLivePlayer_muteAudio(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "muteAudio", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayer_muteVideo(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "muteVideo", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void txLivePlayer_pause()
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "pause", false, null, new Object[0]);
  }
  
  private void txLivePlayer_resume()
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "resume", false, null, new Object[0]);
  }
  
  private void txLivePlayer_setAudioRoute(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setAudioRoute", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_setAudioVolumeEvaluationListener(Object paramObject)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setAudioVolumeEvaluationListener", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener") }), new Object[] { paramObject });
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
      JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setConfig", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { paramObject });
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
      JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setPlayListener", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePlayListener") }), new Object[] { paramObject });
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
      JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setPlayerView", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ui.TXCloudVideoView") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void txLivePlayer_setRenderMode(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setRenderMode", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_setRenderRotation(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setRenderRotation", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void txLivePlayer_setSurface(Surface paramSurface)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setSurface", false, JarReflectUtil.getParamsClass(new Class[] { Surface.class }), new Object[] { paramSurface });
  }
  
  private void txLivePlayer_setSurfaceSize(int paramInt1, int paramInt2)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "setSurfaceSize", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private void txLivePlayer_showDebugLog(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "showDebugLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private int txLivePlayer_startPlay(String paramString, int paramInt)
  {
    paramString = JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "startPlay", false, JarReflectUtil.getParamsClass(new Class[] { String.class, Integer.TYPE }), new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramString != null) {
      return ((Integer)paramString).intValue();
    }
    return -1;
  }
  
  private int txLivePlayer_stopPlay(Boolean paramBoolean)
  {
    paramBoolean = JarReflectUtil.callSpecifiedMethod(this.txLivePlayer, "stopPlay", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
    if (paramBoolean != null) {
      return ((Integer)paramBoolean).intValue();
    }
    return -1;
  }
  
  private void txPlayConfig_setEnableMessage(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.txLivePlayConfig, "setEnableMessage", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
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
    QMLog.d("TXLivePlayerJSAdapter", "enterBackground");
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
      QMLog.d("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
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
      QMLog.d("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
      txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    this.mInited = true;
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError initLivePlayer(Object paramObject, JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TXLivePlayerJSAdapter", "initLivePlayer: params = " + paramJSONObject.toString());
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
    QMLog.d("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + paramString + " params = " + str);
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
      QMLog.d("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + this.mPlayerUrl + " playUrl-new = " + str);
      txLivePlayer_stopPlay(Boolean.valueOf(true));
    }
    this.mPlayerUrl = str;
    int i = getPlayType(paramBundle);
    if ((i != this.mPlayType) && (txLivePlayer_isPlaying()))
    {
      QMLog.d("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + this.mPlayType + " playType-new = " + i);
      txLivePlayer_stopPlay(Boolean.valueOf(true));
    }
    this.mPlayType = i;
    this.mAutoPlay = paramBundle.getBoolean("autoplay", this.mAutoPlay);
    if (((this.mAutoPlay) || (bool)) && (this.mPlayerUrl != null) && (!this.mPlayerUrl.isEmpty()) && (!txLivePlayer_isPlaying()))
    {
      QMLog.d("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
      txLivePlayer_startPlay(this.mPlayerUrl, this.mPlayType);
    }
    return new TXJSAdapterError();
  }
  
  public TXJSAdapterError updateLivePlayer(JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TXLivePlayerJSAdapter", "updateLivePlayer: params = " + paramJSONObject.toString());
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
      QMLog.e("TXLivePlayerJSAdapter", "InnerAudioVolumeEvaluationListenerImpl invoke:" + paramMethod.getName());
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
    private boolean mNeedCompress = false;
    
    public InnerITXSnapshotListenerImpl() {}
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      QMLog.e("TXLivePlayerJSAdapter", "InnerITXSnapshotListenerImpl invoke:" + paramMethod.getName());
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
            break label181;
          }
          if (paramObject == null) {
            break label165;
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
        label165:
        TXLivePlayerJSAdapter.this.iTXSnapshotListener.onSnapshot(paramObject);
        continue;
        label181:
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
      QMLog.e("TXLivePlayerJSAdapter", "InnerTXLivePlayListenerImpl invoke:" + paramMethod.getName());
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
                break label261;
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
                QMLog.d("TXLivePlayerJSAdapter", "onPlayEvent: event = " + paramMethod + " message = " + paramObject);
              }
              catch (UnsupportedEncodingException paramObject)
              {
                paramObject.printStackTrace();
              }
              label261:
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
          if (QMLog.isColorLevel())
          {
            paramObject = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramObject.getString("CPU_USAGE"), "RES:" + paramObject.getInt("VIDEO_WIDTH") + "*" + paramObject.getInt("VIDEO_HEIGHT"), "SPD:" + paramObject.getInt("NET_SPEED") + "Kbps", "JIT:" + paramObject.getInt("NET_JITTER"), "FPS:" + paramObject.getInt("VIDEO_FPS"), "GOP:" + paramObject.getInt("VIDEO_GOP") + "s", "ARA:" + paramObject.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramObject.getInt("AUDIO_CACHE") + " | " + paramObject.getInt("VIDEO_CACHE") + "," + paramObject.getInt("V_SUM_CACHE_SIZE") + "," + paramObject.getInt("V_DEC_CACHE_SIZE") + " | " + paramObject.getInt("AV_RECV_INTERVAL") + "," + paramObject.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramObject.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramObject.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramObject.getInt("AUDIO_DROP") + "|" + paramObject.getInt("VIDEO_DROP"), "SVR:" + paramObject.getString("SERVER_IP"), "AUDIO:" + paramObject.getString("AUDIO_PLAY_INFO") });
            QMLog.d("TXLivePlayerJSAdapter", "onNetStatus:" + paramObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter
 * JD-Core Version:    0.7.0.1
 */