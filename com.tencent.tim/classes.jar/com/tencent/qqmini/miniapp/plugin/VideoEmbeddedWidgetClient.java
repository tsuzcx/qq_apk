package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.State;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.StateTransfer;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.miniapp.util.TextureRender.VideoTextureRenderer;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoEmbeddedWidgetClient
  extends StateMachine
  implements Handler.Callback, StateMachine.OnStateChangeListener, IExtendedEmbeddedWidgetClient
{
  private static final int DEFAULT_INTERVAL_TIME = 400;
  private static final int EVENT_INIT_SUCC = 1;
  private static final int EVENT_MEDIAPLAYER_PREPARED = 5;
  private static final int EVENT_VIDEOSURFACE_SUCC = 3;
  private static final int EVENT_X5SURFACE_SUCC = 2;
  public static final int MSG_IS_HLS = 1003;
  public static final int MSG_TIME_UPDATE = 1001;
  public static final int MSG_VIDEO_SURFACE_CREATED = 1002;
  private static final String TAG = "miniapp-embedded";
  private static final float[] rateSupportArray = { 0.5F, 0.8F, 1.0F, 1.25F, 1.5F, 2.0F };
  private boolean autoPauseIfNavigate = true;
  private boolean autoPauseIfOpenNative = true;
  private boolean autoplay = false;
  private IJsService callBackWebview;
  private String cueFilePath = "";
  private IJsService curAppBrandRuntime;
  private int curPageWebviewId;
  private String data = "";
  private String filePath = "";
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean hasCompleted = false;
  private boolean hasPlayClicked = false;
  private boolean hasPrepared = false;
  private boolean hasStoped = false;
  private int height = -1;
  private boolean hide = false;
  private int initialTime = 0;
  private volatile Boolean isHls = null;
  private boolean isOnPageBackGrond = false;
  private boolean isPaused = false;
  private boolean loop = false;
  private Map<String, String> mAttributes;
  private IMediaPlayer mMediaPlayer;
  private IMediaPlayerUtil mMediaPlayerUtil;
  private IMiniAppContext mMiniAppContext;
  private Surface mSurface = null;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  private Surface mediaPlaySurface;
  private boolean muted = false;
  private boolean needEvent = true;
  private String objectFit = "contain";
  private boolean pauseByNavigate = false;
  private boolean pauseByOpenNative = false;
  private VideoTextureRenderer renderer;
  private StateMachine.State stateCanPlay = new StateMachine.State(this, Integer.valueOf(5));
  private StateMachine.State stateInited = new StateMachine.State(this, Integer.valueOf(2));
  private StateMachine.State stateInitial = new StateMachine.State(this, Integer.valueOf(1));
  private StateMachine.State stateVideoSurfaceCreated = new StateMachine.State(this, Integer.valueOf(4));
  private StateMachine.State stateX5SurfaceCreated = new StateMachine.State(this, Integer.valueOf(3));
  private int videoHeight = -1;
  private SurfaceTexture videoTexture;
  private int videoWidth = -1;
  private int viewId = -1;
  private int width = -1;
  
  public VideoEmbeddedWidgetClient(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.mTagName = paramString;
    this.mAttributes = paramMap;
    this.mWidget = paramIEmbeddedWidget;
    initStateConfig();
    initMediaPlayer();
    addStateChangeListener(this);
    sendEvent(Integer.valueOf(1));
  }
  
  private void initMediaPlayer()
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    this.mMediaPlayer = localChannelProxy.getMediaPlayer();
    this.mMediaPlayerUtil = localChannelProxy.getMediaPlayerUtil();
    this.mMediaPlayer.setOnCompletionListener(new VideoEmbeddedWidgetClient.1(this));
    this.mMediaPlayer.setOnPreparedListener(new VideoEmbeddedWidgetClient.2(this));
    this.mMediaPlayer.setOnInfoListener(new VideoEmbeddedWidgetClient.3(this));
    this.mMediaPlayer.setOnBufferingUpdateListener(new VideoEmbeddedWidgetClient.4(this));
    this.mMediaPlayer.setOnVideoSizeChangedListener(new VideoEmbeddedWidgetClient.5(this));
    this.mMediaPlayer.setOnLoopStartListener(new VideoEmbeddedWidgetClient.6(this));
  }
  
  private void initStateConfig()
  {
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateInitial).next(this.stateInited).registEvent(Integer.valueOf(1)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateInited).next(this.stateX5SurfaceCreated).registEvent(Integer.valueOf(2)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateX5SurfaceCreated).next(this.stateVideoSurfaceCreated).registEvent(Integer.valueOf(3)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateVideoSurfaceCreated).next(this.stateCanPlay).registEvent(Integer.valueOf(5)));
    setCurrState(this.stateInitial);
  }
  
  private void sendTimingMsg(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1001;
    this.handler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void updateMediaPlayer()
  {
    if (this.mMediaPlayer != null)
    {
      if (!this.muted) {
        break label116;
      }
      this.mMediaPlayer.setVolume(0.0F, 0.0F);
    }
    for (;;)
    {
      this.mMediaPlayer.setLooping(this.loop);
      if (this.initialTime > 0)
      {
        QMLog.d("miniapp-embedded", "before seekTo " + this.initialTime);
        this.mMediaPlayer.seekTo(this.initialTime);
        QMLog.d("miniapp-embedded", "after seekTo " + this.initialTime);
      }
      return;
      label116:
      this.mMediaPlayer.setVolume(1.0F, 1.0F);
    }
  }
  
  public void handleInsertXWebVideo(JSONObject paramJSONObject, IJsService paramIJsService1, IJsService paramIJsService2)
  {
    this.callBackWebview = paramIJsService1;
    this.curAppBrandRuntime = paramIJsService2;
    if ((paramIJsService1 instanceof BrandPageWebview)) {
      this.curPageWebviewId = ((BrandPageWebview)paramIJsService1).getWebViewId();
    }
    for (;;)
    {
      if (paramJSONObject != null)
      {
        QMLog.d("miniapp-embedded", "handleInsertXWebVideo : " + paramJSONObject.toString());
        if (paramJSONObject.has("position"))
        {
          paramIJsService1 = paramJSONObject.optJSONObject("position");
          this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService1.optInt("width", -1) + 0.5F));
          float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
          this.height = ((int)(paramIJsService1.optInt("height", -1) * f + 0.5F));
        }
        this.viewId = paramJSONObject.optInt("viewId", -1);
        this.needEvent = paramJSONObject.optBoolean("needEvent", true);
        this.hide = paramJSONObject.optBoolean("hide", false);
        this.objectFit = paramJSONObject.optString("objectFit", "contain");
        this.autoplay = paramJSONObject.optBoolean("autoplay", false);
        this.muted = paramJSONObject.optBoolean("muted", false);
        this.loop = paramJSONObject.optBoolean("loop", false);
        this.initialTime = paramJSONObject.optInt("initialTime", 0);
        this.autoPauseIfNavigate = paramJSONObject.optBoolean("autoPauseIfNavigate", true);
        this.autoPauseIfOpenNative = paramJSONObject.optBoolean("autoPauseIfOpenNative", true);
        this.data = paramJSONObject.optString("data");
      }
      if (this.renderer != null) {
        this.renderer.setSurfaceSize(this.width, this.height);
      }
      return;
      QMLog.e("miniapp-embedded", "cant get webviewId from " + paramIJsService1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l2 = 0L;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.isHls != null) && (this.isHls.booleanValue()))
      {
        QMLog.d("miniapp-embedded", "hls, do not send onXWebVideoTimeUpdate.");
      }
      else
      {
        long l3 = System.currentTimeMillis();
        if ((this.mMediaPlayer != null) && (this.callBackWebview != null) && (!this.hasCompleted)) {}
        for (;;)
        {
          try
          {
            l1 = this.mMediaPlayer.getDuration();
            if (l1 <= 0L) {
              continue;
            }
            l1 /= 1000L;
            paramMessage = new JSONObject();
            paramMessage.put("data", this.data);
            paramMessage.put("position", this.mMediaPlayer.getCurrentPosition() / 1000.0D);
            if ((this.isHls == null) || (!this.isHls.booleanValue())) {
              continue;
            }
            l1 = l2;
            paramMessage.put("duration", l1);
            paramMessage.put("videoPlayerId", this.viewId);
            this.curAppBrandRuntime.evaluateSubscribeJS("onXWebVideoTimeUpdate", paramMessage.toString(), this.curPageWebviewId);
            this.callBackWebview.evaluateSubscribeJS("onXWebVideoTimeUpdate", paramMessage.toString(), this.curPageWebviewId);
          }
          catch (Throwable paramMessage)
          {
            long l1;
            QMLog.e("miniapp-embedded", "VIDEO_EVENT_TIME_UPDATE error.", paramMessage);
            continue;
          }
          if (this.isPaused) {
            break;
          }
          sendTimingMsg(400L + l3 - System.currentTimeMillis());
          break;
          l1 = 0L;
        }
        if (this.renderer != null)
        {
          this.videoTexture = this.renderer.getVideoTexture();
          if (this.videoTexture != null) {
            sendEvent(Integer.valueOf(3));
          } else {
            QMLog.e("miniapp-embedded", "MSG_VIDEO_SURFACE_CREATED videoTexture is null!");
          }
        }
        else
        {
          QMLog.e("miniapp-embedded", "MSG_VIDEO_SURFACE_CREATED renderer is null!");
          continue;
          QMLog.d("miniapp-embedded", "MSG_IS_HLS");
          ThreadManager.getSubThreadHandler().post(new VideoEmbeddedWidgetClient.7(this));
        }
      }
    }
  }
  
  public void handleOperateXWebVideo(IMiniAppContext paramIMiniAppContext, JSONObject paramJSONObject)
  {
    QMLog.d("miniapp-embedded", "handleOperateXWebVideo : " + paramJSONObject.toString());
    this.mMiniAppContext = paramIMiniAppContext;
    int i = paramJSONObject.optInt("viewId", -1);
    String str;
    if ((i == this.viewId) && (paramJSONObject.has("type")))
    {
      str = paramJSONObject.optString("type");
      if (!"play".equals(str)) {
        break label626;
      }
      this.isPaused = false;
      if (((this.hasCompleted) || (this.hasStoped)) && (this.mMediaPlayer != null))
      {
        this.mMediaPlayer.reset();
        this.hasPrepared = false;
        this.hasCompleted = false;
        this.hasStoped = false;
      }
    }
    try
    {
      if ((!this.filePath.startsWith("http")) && (!this.filePath.startsWith("https"))) {
        break label429;
      }
      paramIMiniAppContext = this.mMediaPlayerUtil.getUrl(((MiniAppFileManager)paramIMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath));
      QMLog.d("miniapp-embedded", "handleOperateXWebVideo playUrl : " + paramIMiniAppContext);
      this.mMediaPlayer.setDataSource(paramIMiniAppContext);
      this.handler.sendEmptyMessage(1003);
      setCurrState(this.stateVideoSurfaceCreated);
      this.mMediaPlayer.prepareAsync();
      this.mMediaPlayer.setSurface(this.mediaPlaySurface);
    }
    catch (Throwable paramIMiniAppContext)
    {
      for (;;)
      {
        QMLog.e("miniapp-embedded", "handleOperateXWebVideo  play error.", paramIMiniAppContext);
        continue;
        QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 1");
      }
    }
    if (this.hasPrepared) {
      if (this.mMediaPlayer == null) {}
    }
    label429:
    label626:
    do
    {
      float f;
      for (;;)
      {
        try
        {
          if (this.renderer != null) {
            this.renderer.resumeRender();
          }
          if (!this.isOnPageBackGrond)
          {
            this.isPaused = false;
            this.mMediaPlayer.start();
            sendTimingMsg(400L);
          }
        }
        catch (Throwable paramIMiniAppContext)
        {
          QMLog.e("miniapp-embedded", "start error.", paramIMiniAppContext);
          continue;
        }
        try
        {
          paramIMiniAppContext = new JSONObject();
          paramIMiniAppContext.put("data", this.data);
          paramIMiniAppContext.put("videoPlayerId", i);
          paramIMiniAppContext.put("timeStamp", System.currentTimeMillis());
          this.curAppBrandRuntime.evaluateSubscribeJS("onXWebVideoPlay", paramIMiniAppContext.toString(), this.curPageWebviewId);
          this.callBackWebview.evaluateSubscribeJS("onXWebVideoPlay", paramIMiniAppContext.toString(), this.curPageWebviewId);
          QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + paramIMiniAppContext.toString());
          return;
        }
        catch (Throwable paramIMiniAppContext)
        {
          QMLog.e("miniapp-embedded", "VIDEO_EVENT_PLAY error.", paramIMiniAppContext);
          return;
        }
        paramIMiniAppContext = ((MiniAppFileManager)paramIMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath);
        break;
        this.hasPlayClicked = true;
        try
        {
          paramIMiniAppContext = new JSONObject();
          paramIMiniAppContext.put("data", this.data);
          paramIMiniAppContext.put("videoPlayerId", i);
          paramIMiniAppContext.put("timeStamp", System.currentTimeMillis());
          this.curAppBrandRuntime.evaluateSubscribeJS("onXWebVideoPlay", paramIMiniAppContext.toString(), this.curPageWebviewId);
          this.callBackWebview.evaluateSubscribeJS("onXWebVideoPlay", paramIMiniAppContext.toString(), this.curPageWebviewId);
          QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + paramIMiniAppContext.toString());
          return;
        }
        catch (Throwable paramIMiniAppContext)
        {
          QMLog.e("miniapp-embedded", "VIDEO_EVENT_PLAY error.", paramIMiniAppContext);
          return;
        }
        if ("pause".equals(str))
        {
          if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()))
          {
            this.isPaused = true;
            QMLog.e("miniapp-embedded", "pause isPaused true");
            for (;;)
            {
              try
              {
                if (this.renderer != null) {
                  this.renderer.pauseRender();
                }
                this.mMediaPlayer.pause();
              }
              catch (Throwable paramIMiniAppContext)
              {
                QMLog.e("miniapp-embedded", "pause error.", paramIMiniAppContext);
                continue;
              }
              try
              {
                paramIMiniAppContext = new JSONObject();
                paramIMiniAppContext.put("data", this.data);
                paramIMiniAppContext.put("videoPlayerId", i);
                paramIMiniAppContext.put("timeStamp", System.currentTimeMillis());
                this.curAppBrandRuntime.evaluateSubscribeJS("onXWebVideoPause", paramIMiniAppContext.toString(), this.curPageWebviewId);
                this.callBackWebview.evaluateSubscribeJS("onXWebVideoPause", paramIMiniAppContext.toString(), this.curPageWebviewId);
                QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + paramIMiniAppContext.toString());
                return;
              }
              catch (Throwable paramIMiniAppContext)
              {
                QMLog.e("miniapp-embedded", "VIDEO_EVENT_PAUSE error.", paramIMiniAppContext);
                return;
              }
            }
          }
        }
        else if ("seek".equals(str))
        {
          if (this.mMediaPlayer != null) {
            try
            {
              paramIMiniAppContext = paramJSONObject.optString("data");
              if (TextUtils.isEmpty(paramIMiniAppContext)) {
                continue;
              }
              paramIMiniAppContext = new JSONArray(paramIMiniAppContext);
              if (paramIMiniAppContext.length() != 1) {
                continue;
              }
              long l = (paramIMiniAppContext.getDouble(0) * 1000.0D);
              this.mMediaPlayer.seekTo(l);
              return;
            }
            catch (Throwable paramIMiniAppContext)
            {
              QMLog.e("miniapp-embedded", "seek error.", paramIMiniAppContext);
              return;
            }
          }
        }
        else
        {
          if ((!"playbackRate".equals(str)) || (TextUtils.isEmpty(this.data))) {
            break label1041;
          }
          if (this.mMediaPlayer != null) {
            try
            {
              paramIMiniAppContext = paramJSONObject.optString("data");
              if (!TextUtils.isEmpty(paramIMiniAppContext))
              {
                paramIMiniAppContext = new JSONArray(paramIMiniAppContext);
                if (paramIMiniAppContext.length() == 1)
                {
                  f = Float.parseFloat(paramIMiniAppContext.optString(0, "1.0"));
                  if (Arrays.binarySearch(rateSupportArray, f) >= 0)
                  {
                    this.mMediaPlayer.setRate(f);
                    return;
                  }
                }
              }
            }
            catch (Throwable paramIMiniAppContext)
            {
              QMLog.e("miniapp-embedded", "playbackRate error.", paramIMiniAppContext);
              return;
            }
          }
        }
      }
      QMLog.e("miniapp-embedded", "playbackRate error." + f);
      return;
    } while ((!"stop".equals(str)) || (this.mMediaPlayer == null));
    label1041:
    this.isPaused = true;
    this.hasStoped = true;
    QMLog.e("miniapp-embedded", "pause isPaused true");
    if (this.renderer != null) {
      this.renderer.pauseRender();
    }
    this.mMediaPlayer.stop();
  }
  
  public void handleUpdateXWebVideo(IMiniAppContext paramIMiniAppContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      QMLog.d("miniapp-embedded", "handleUpdateXWebVideo : " + paramJSONObject.toString());
      this.mMiniAppContext = paramIMiniAppContext;
      if (paramJSONObject.optInt("viewId", -1) == this.viewId)
      {
        this.needEvent = paramJSONObject.optBoolean("needEvent", this.needEvent);
        this.hide = paramJSONObject.optBoolean("hide", this.hide);
        this.objectFit = paramJSONObject.optString("objectFit", this.objectFit);
        this.autoplay = paramJSONObject.optBoolean("autoplay", this.autoplay);
        this.muted = paramJSONObject.optBoolean("muted", this.muted);
        this.loop = paramJSONObject.optBoolean("loop", this.loop);
        this.initialTime = paramJSONObject.optInt("initialTime", this.initialTime);
        this.autoPauseIfNavigate = paramJSONObject.optBoolean("autoPauseIfNavigate", this.autoPauseIfNavigate);
        this.autoPauseIfOpenNative = paramJSONObject.optBoolean("autoPauseIfOpenNative", this.autoPauseIfOpenNative);
        if (paramJSONObject.has("filePath")) {
          this.filePath = paramJSONObject.optString("filePath");
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!this.cueFilePath.equals(this.filePath))
        {
          this.cueFilePath = this.filePath;
          if (!TextUtils.isEmpty(this.cueFilePath)) {
            setCurrState(this.stateVideoSurfaceCreated);
          }
          this.isPaused = false;
          this.hasPrepared = false;
          this.hasCompleted = false;
          if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.stop();
          }
          this.mMediaPlayer.reset();
          if ((!this.filePath.startsWith("http")) && (!this.filePath.startsWith("https"))) {
            continue;
          }
          paramIMiniAppContext = this.mMediaPlayerUtil.getUrl(((MiniAppFileManager)paramIMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath));
          QMLog.d("miniapp-embedded", "handleUpdateXWebVideo playUrl : " + paramIMiniAppContext);
          this.mMediaPlayer.setDataSource(paramIMiniAppContext);
          this.handler.sendEmptyMessage(1003);
          this.mMediaPlayer.prepareAsync();
        }
      }
      catch (Throwable paramIMiniAppContext)
      {
        float f;
        QMLog.e("miniapp-embedded", "handleUpdateXWebVideo  play error.", paramIMiniAppContext);
        continue;
        QMLog.e("miniapp-embedded", "handleUpdateXWebVideo renderer is null!");
        continue;
        this.mMediaPlayer.setVolume(1.0F, 1.0F);
        continue;
      }
      if (paramJSONObject.has("position"))
      {
        paramIMiniAppContext = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIMiniAppContext.optInt("width", -1) + 0.5F));
        f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
        this.height = ((int)(paramIMiniAppContext.optInt("height", -1) * f + 0.5F));
        if (this.renderer == null) {
          continue;
        }
        this.renderer.setSurfaceSize(this.width, this.height);
        this.renderer.setVideoSize(this.videoWidth, this.videoHeight, this.objectFit);
      }
      if (this.mMediaPlayer != null)
      {
        if (!this.muted) {
          continue;
        }
        this.mMediaPlayer.setVolume(0.0F, 0.0F);
        this.mMediaPlayer.setLooping(this.loop);
      }
      return;
      paramIMiniAppContext = ((MiniAppFileManager)paramIMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath);
    }
  }
  
  public void nativeDestroy()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.nativeDestroy " + this);
    this.isPaused = true;
    try
    {
      if (this.renderer != null)
      {
        this.renderer.pauseRender();
        this.renderer.onPause();
        this.renderer = null;
      }
      if (this.videoTexture != null)
      {
        this.videoTexture.release();
        this.videoTexture = null;
      }
      if (this.mediaPlaySurface != null)
      {
        this.mediaPlaySurface.release();
        this.mediaPlaySurface = null;
      }
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
      }
      return;
    }
    finally {}
  }
  
  public void nativePause()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.nativePause " + this);
    this.isOnPageBackGrond = true;
    if ((this.mMediaPlayer != null) && (this.autoPauseIfOpenNative)) {
      this.pauseByOpenNative = true;
    }
    try
    {
      if (this.renderer != null) {
        this.renderer.pauseRender();
      }
      this.mMediaPlayer.pause();
      this.isPaused = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "nativePause mMediaPlayer.pause() error.", localThrowable);
    }
  }
  
  public void nativeResume()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.nativeResume " + this);
    this.isOnPageBackGrond = false;
    if ((this.mMediaPlayer != null) && (this.pauseByOpenNative))
    {
      this.pauseByOpenNative = false;
      try
      {
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
        QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
        if (!this.isOnPageBackGrond)
        {
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendTimingMsg(400L);
          return;
        }
        QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 3");
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "nativeResume mMediaPlayer.start() error.", localThrowable);
      }
    }
  }
  
  public void onActive()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onActive");
  }
  
  public void onDeactive()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onDeactive");
  }
  
  public void onDestroy()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onDestroy");
    this.isPaused = true;
    try
    {
      if (this.renderer != null)
      {
        this.renderer.pauseRender();
        this.renderer.onPause();
        this.renderer = null;
      }
      if (this.videoTexture != null)
      {
        this.videoTexture.release();
        this.videoTexture = null;
      }
      if (this.mediaPlaySurface != null)
      {
        this.mediaPlaySurface.release();
        this.mediaPlaySurface = null;
      }
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
      }
      return;
    }
    finally {}
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onRectChanged, rect:" + paramRect.toString() + "； size : " + (paramRect.right - paramRect.left) + "," + (paramRect.bottom - paramRect.top));
  }
  
  public void onRequestRedraw()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onStateChanged()
  {
    QMLog.i("miniapp-embedded", "onStateChanged : " + getCurrState() + "; videoTexture : " + this.videoTexture);
    if (this.isOnPageBackGrond) {
      break label48;
    }
    for (;;)
    {
      label48:
      return;
      if ((getCurrState() != this.stateCanPlay) || (this.videoTexture == null)) {
        continue;
      }
      QMLog.d("miniapp-embedded", "stateCanPlay!!!!");
      this.mediaPlaySurface = new Surface(this.videoTexture);
      this.mMediaPlayer.setSurface(this.mediaPlaySurface);
      if (this.renderer != null)
      {
        if ((this.width >= 0) && (this.height >= 0)) {
          this.renderer.setSurfaceSize(this.width, this.height);
        }
        if ((this.videoWidth >= 0) && (this.videoHeight >= 0)) {
          this.renderer.setVideoSize(this.videoWidth, this.videoHeight, this.objectFit);
        }
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
      }
      if (((!this.autoplay) && (!this.hasPlayClicked)) || (this.mMediaPlayer == null)) {
        break;
      }
      try
      {
        if (!this.isOnPageBackGrond)
        {
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendTimingMsg(400L);
          updateMediaPlayer();
          if (this.callBackWebview == null) {
            continue;
          }
          if (!this.autoplay) {
            if (this.hasPlayClicked) {
              break label378;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("data", this.data);
            localJSONObject.put("videoPlayerId", this.viewId);
            localJSONObject.put("timeStamp", System.currentTimeMillis());
            this.curAppBrandRuntime.evaluateSubscribeJS("onXWebVideoPlay", localJSONObject.toString(), this.curPageWebviewId);
            this.callBackWebview.evaluateSubscribeJS("onXWebVideoPlay", localJSONObject.toString(), this.curPageWebviewId);
            QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + localJSONObject.toString());
            label378:
            if (this.mMediaPlayer == null) {
              break;
            }
            try
            {
              l1 = this.mMediaPlayer.getDuration();
              if (l1 <= 0L) {
                break label624;
              }
              l1 /= 1000L;
              localJSONObject = new JSONObject();
              localJSONObject.put("data", this.data);
              localJSONObject.put("position", this.mMediaPlayer.getCurrentPosition() / 1000.0D);
              long l2 = l1;
              if (this.isHls != null)
              {
                l2 = l1;
                if (this.isHls.booleanValue()) {
                  l2 = 0L;
                }
              }
              localJSONObject.put("duration", l2);
              localJSONObject.put("videoPlayerId", this.viewId);
              this.curAppBrandRuntime.evaluateSubscribeJS("onXWebVideoTimeUpdate", localJSONObject.toString(), this.curPageWebviewId);
              this.callBackWebview.evaluateSubscribeJS("onXWebVideoTimeUpdate", localJSONObject.toString(), this.curPageWebviewId);
              QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoTimeUpdateo nStateChanged = " + localJSONObject.toString());
              return;
            }
            catch (Throwable localThrowable1)
            {
              QMLog.e("miniapp-embedded", "VIDEO_EVENT_TIME_UPDATE error.", localThrowable1);
              return;
            }
            QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 4");
          }
          localThrowable2 = localThrowable2;
          QMLog.e("miniapp-embedded", "mMediaPlayer.start() error.", localThrowable2);
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            QMLog.e("miniapp-embedded", "VIDEO_EVENT_PLAY error.", localThrowable3);
            continue;
            label624:
            long l1 = 0L;
          }
        }
      }
    }
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded", "onSurfaceCreated: " + paramSurface);
    if ((paramSurface == null) || (!paramSurface.isValid()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSurfaceCreated isValid() : ");
      if (paramSurface != null) {}
      for (paramSurface = Boolean.valueOf(paramSurface.isValid());; paramSurface = null)
      {
        QMLog.e("miniapp-embedded", paramSurface);
        return;
      }
    }
    this.mSurface = paramSurface;
    this.renderer = new VideoTextureRenderer(AppLoaderFactory.g().getContext(), this.mSurface, this.width, this.height, this.handler);
    sendEvent(Integer.valueOf(2));
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onSurfaceDestroyed");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onTouchEvent, rect:" + paramMotionEvent.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onVisibilityChanged ： " + paramBoolean);
  }
  
  public void webViewDestory()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewDestory " + this);
    this.isPaused = true;
    try
    {
      if (this.renderer != null)
      {
        this.renderer.pauseRender();
        this.renderer.onPause();
        this.renderer = null;
      }
      if (this.videoTexture != null)
      {
        this.videoTexture.release();
        this.videoTexture = null;
      }
      if (this.mediaPlaySurface != null)
      {
        this.mediaPlaySurface.release();
        this.mediaPlaySurface = null;
      }
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
      }
      return;
    }
    finally {}
  }
  
  public void webViewPause()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewPause " + this);
    this.isOnPageBackGrond = true;
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()) && (this.autoPauseIfNavigate)) {
      this.pauseByNavigate = true;
    }
    try
    {
      if (this.renderer != null) {
        this.renderer.pauseRender();
      }
      this.mMediaPlayer.pause();
      this.isPaused = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "webviewPause mMediaPlayer.pause() error.", localThrowable);
    }
  }
  
  public void webViewResume()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewResume " + this);
    this.isOnPageBackGrond = false;
    if ((this.mMediaPlayer != null) && (this.pauseByNavigate))
    {
      this.pauseByNavigate = false;
      try
      {
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
        QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
        if (!this.isOnPageBackGrond)
        {
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendTimingMsg(400L);
          return;
        }
        QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 2");
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "webviewResume mMediaPlayer.start() error.", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */