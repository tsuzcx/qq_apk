package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout;
import com.tencent.qqmini.sdk.widget.media.danmu.Barrage;
import com.tencent.qqmini.sdk.widget.media.danmu.BarrageView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppVideoPlayer
  extends FrameLayout
  implements MediaPlayer.OnPreparedListener, Handler.Callback, View.OnClickListener
{
  private static final int MSG_WHAT_HIDE = 2003;
  private static final int MSG_WHAT_PLAYING = 2002;
  public static final String NOTIFY_STATUS_RESET = "resetPlayer";
  public static final String NOTIFY_STATUS_RESUME = "resumePlayer";
  private static final String TAG = "MiniAppVideoPlayer";
  private static final String TVK_TAG = "MiniAppVideoPlayer_TVK_IMediaPlayer";
  private static final String VIDEO_STATE_ENDED = "ended";
  private static final String VIDEO_STATE_ERROR = "error";
  private static final String VIDEO_STATE_EXIT_FULL_SCREEN = "exitFullScreen";
  private static final String VIDEO_STATE_PAUSE = "pause";
  private static final String VIDEO_STATE_PLAY = "play";
  private static final String VIDEO_STATE_REQUEST_FULL_SCREEN = "requestFullScreen";
  private static final String VIDEO_STATE_TIME_UPDATE = "timeUpdate";
  private static final String VIDEO_STATE_WAITTING = "waiting";
  public static final String VIEW_TAG = "MiniAppVideoPlayer";
  public static volatile boolean mIsInited = false;
  private static final String oskPlayerContentTypeList = WnsConfig.getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  private ViewGroup actionVg;
  public WeakReference<Activity> atyRef;
  public boolean autoPauseIfNavigate = true;
  public boolean autoPauseIfOpenNative = true;
  public boolean autoplay = false;
  private ImageView backIv;
  private ImageView barrageIv;
  public List<Barrage> barrages;
  private float brightness = 1.0F;
  private Bitmap cachedCaptureImage;
  private ImageView centerControlIv;
  private int componentLayoutScrollY = 0;
  private View controlBar;
  private ImageView controlIv;
  public boolean customCache;
  private BarrageView danmuView;
  public String data;
  public int direction = -1;
  public boolean enableDanmu = false;
  public boolean enablePlayGesture;
  public boolean enableProgressGesture = true;
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean hasSetUp = false;
  private boolean hasShowDanmuBtnSet;
  public boolean hide;
  public double initialTime = 0.0D;
  public boolean isBarrageOpen;
  private boolean isBufferStart = false;
  boolean isBusyInChangeScreen = false;
  private boolean isChangingProgress;
  public boolean isFullScreen;
  public boolean isLive = false;
  public boolean isMuted = false;
  public boolean isPageOnBackground = false;
  private boolean isPause;
  boolean isResetPath = false;
  public boolean isShowBasicControl = true;
  public boolean isShowControlBar = true;
  private int lastBufferProgress = 0;
  private int lastNavBarVisibility = 8;
  public String lastPoster;
  long lastSmallScreenTime = -1L;
  private int lastTabBarVisibility = 8;
  private View loadingView;
  public boolean loop = false;
  private AudioManager mAudioManager;
  private Context mContext;
  private long mCurrPos;
  private WindowManager.LayoutParams mLayoutParams;
  public WeakReference<IMiniAppContext> mMiniAppContext;
  public String mUrls;
  private VideoGestureLayout mVideoGestureLayout;
  private AbsVideoPlayer mVideoPlayer = null;
  private View mVideoView = null;
  private Window mWindow;
  private int maxVolume = 0;
  private ImageView muteIv;
  public boolean muted = false;
  public boolean needEvent;
  private boolean needPauseOnLoad;
  private int newProgress = 0;
  private TextView nowTimeTv;
  public String objectFit = "contain";
  private int oldProgress = 0;
  private int oldVolume = 0;
  private int originHeight;
  private int originWidth;
  public boolean pageGesture = false;
  public IJsService pageWebview;
  public int parentId;
  public boolean pauseByUser = false;
  public String playBtnPosition;
  private ImageView play_status_img;
  private SeekBar playerSeekBar;
  public boolean playingBefore = false;
  private View playingPopView;
  public String poster;
  public JSONObject postionObj;
  private int rotation;
  private TextView seekTv;
  public boolean showCenterPlayBtn = true;
  public boolean showControlProgress;
  public boolean showDanmuBtn = false;
  public boolean showFullScreenBtn = true;
  public boolean showLiveBtn;
  public boolean showMuteBtn = false;
  public boolean showPlayBtn = true;
  public boolean showProgress = true;
  private ViewGroup.LayoutParams smallLayoutParams;
  public String title;
  private TextView titleTv;
  private TextView totalTimeTv;
  private View vdView;
  public int videoHeight = 150;
  public long videoId;
  public VideoPlayerStatusObserver videoPlayerStatusObserver;
  public int videoWidth = 300;
  public int videoX;
  public int videoY;
  private VideoGestureRelativeLayout video_container;
  private ImageView video_img;
  private FrameLayout video_pop_container;
  private View view;
  public int webviewId;
  private ImageView windowIv;
  
  public MiniAppVideoPlayer(Context paramContext)
  {
    this(paramContext, null);
    setUpView(paramContext);
  }
  
  public MiniAppVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setUpView(paramContext);
  }
  
  private void avoidLockScreen()
  {
    if ((this.atyRef != null) && (this.atyRef.get() != null))
    {
      ((Activity)this.atyRef.get()).getWindow().addFlags(128);
      ((Activity)this.atyRef.get()).getWindow().clearFlags(1);
      QMLog.d("MiniAppVideoPlayer", "avoidLockScreen");
    }
  }
  
  private void callBackFullScreenChange()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoId", this.videoId);
      localJSONObject.put("fullScreen", this.isFullScreen);
      if (this.mMiniAppContext != null) {}
      for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();; localIMiniAppContext = null)
      {
        if (localIMiniAppContext != null) {
          localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId));
        }
        this.pageWebview.evaluateSubscribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void callBackFullScreenChange(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", this.data);
        localJSONObject.put("videoId", this.videoId);
        localJSONObject.put("fullScreen", this.isFullScreen);
        if (paramBoolean)
        {
          localJSONObject.put("direction", "horizontal");
          if (this.mMiniAppContext != null)
          {
            IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();
            if (localIMiniAppContext != null) {
              localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId));
            }
            this.pageWebview.evaluateSubscribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId);
          }
        }
        else
        {
          localJSONObject.put("direction", "vertical");
          continue;
        }
        Object localObject = null;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
  }
  
  private void callbackVideoStateChange(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoPlayerId", this.videoId);
      localJSONObject.put("state", paramString);
      if ("timeUpdate".equals(paramString))
      {
        localJSONObject.put("position", this.mVideoPlayer.getCurrentPostion() / 1000.0D);
        localJSONObject.put("duration", this.mVideoPlayer.getDuration() / 1000.0D);
      }
      if (this.mMiniAppContext != null) {}
      for (paramString = (IMiniAppContext)this.mMiniAppContext.get();; paramString = null)
      {
        if (paramString != null) {
          paramString.performAction(ServiceSubscribeEvent.obtain("onVideoStateChange", localJSONObject.toString(), this.webviewId));
        }
        this.pageWebview.evaluateSubscribeJS("onVideoStateChange", localJSONObject.toString(), this.webviewId);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("MiniAppVideoPlayer", "callbackVideoStateChange error.", paramString);
    }
  }
  
  private void cancelAvoidLockScreen()
  {
    if ((this.atyRef != null) && (this.atyRef.get() != null))
    {
      ((Activity)this.atyRef.get()).getWindow().clearFlags(128);
      ((Activity)this.atyRef.get()).getWindow().addFlags(1);
      QMLog.d("MiniAppVideoPlayer", "cancelAvoidLockScreen");
    }
  }
  
  private void enterFullScreenMode(Activity paramActivity)
  {
    int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label64;
      }
      i |= 0x800;
    }
    for (;;)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
      return;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i = 1798;
      break;
      label64:
      i |= 0x1;
    }
  }
  
  public static int getAndSelectVideoTrackIndex(MediaExtractor paramMediaExtractor)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        int i = 0;
        while (i < paramMediaExtractor.getTrackCount())
        {
          QMLog.d("VideoJsPlugin", "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
          if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
          {
            paramMediaExtractor.selectTrack(i);
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  private int getBrightness()
  {
    if (this.atyRef != null)
    {
      Activity localActivity = (Activity)this.atyRef.get();
      if (localActivity != null) {
        return Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness", 255);
      }
    }
    return 255;
  }
  
  private void getCachedCaptureImage()
  {
    if ((this.cachedCaptureImage != null) && (!this.cachedCaptureImage.isRecycled()))
    {
      this.cachedCaptureImage.recycle();
      this.cachedCaptureImage = null;
    }
    if ((this.cachedCaptureImage == null) || (this.cachedCaptureImage.isRecycled())) {
      getHandler().postDelayed(new MiniAppVideoPlayer.17(this), 1000L);
    }
  }
  
  private void hidePopCtrView()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    this.handler.sendMessageDelayed(localMessage, 500L);
  }
  
  public static void initOskOnce(Context paramContext) {}
  
  private void initPlayer(Context paramContext)
  {
    i = 0;
    if (this.mVideoPlayer == null)
    {
      paramContext = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (paramContext == null) {
        break label43;
      }
      paramContext = paramContext.getVideoPlayer();
      this.mVideoPlayer = paramContext;
      if (this.mVideoPlayer != null) {
        break label48;
      }
    }
    label43:
    label48:
    do
    {
      return;
      paramContext = null;
      break;
      this.mVideoView = this.mVideoPlayer.createVideoView(this.mContext);
    } while (this.mVideoView == null);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.vdView = this.mVideoView;
    this.vdView.setLayoutParams(paramContext);
    this.vdView.setVisibility(0);
    this.mVideoPlayer.setXYaxis(0);
    if (!this.autoplay)
    {
      if (StringUtil.isEmpty(this.poster)) {
        break label508;
      }
      setPoster();
    }
    for (;;)
    {
      try
      {
        if (this.isShowBasicControl)
        {
          paramContext = new Properties();
          if (this.enableDanmu)
          {
            this.danmuView = new BarrageView(this.mContext, null);
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            addView(this.danmuView, localLayoutParams);
            this.danmuView.setBarrages(this.barrages);
          }
          if (this.customCache) {
            paramContext.put("mHaveCacheDownload", "true");
          }
        }
      }
      catch (Exception paramContext)
      {
        label508:
        paramContext.printStackTrace();
        continue;
        this.play_status_img.setVisibility(8);
        continue;
        boolean bool = false;
        continue;
        i = 1;
        continue;
      }
      this.mVideoPlayer.setOnControllerClickListener(new MiniAppVideoPlayer.6(this));
      this.mVideoPlayer.setOnVideoPreparedListener(new MiniAppVideoPlayer.7(this));
      this.mVideoPlayer.setOnCompletionListener(new MiniAppVideoPlayer.8(this));
      this.mVideoPlayer.setLoopback(this.loop);
      this.mVideoPlayer.setOnErrorListener(new MiniAppVideoPlayer.9(this));
      this.mVideoPlayer.setOnInfoListener(new MiniAppVideoPlayer.10(this));
      this.mVideoPlayer.setOnSeekCompleteListener(new MiniAppVideoPlayer.11(this));
      if (!this.showCenterPlayBtn) {
        continue;
      }
      this.play_status_img.setVisibility(0);
      this.video_container.removeAllViews();
      this.video_container.addView(this.vdView);
      this.video_container.setBackgroundColor(-16777216);
      paramContext = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, 100.0F), DisplayUtil.dip2px(this.mContext, 100.0F));
      paramContext.gravity = 17;
      this.video_container.addView(this.mVideoGestureLayout, paramContext);
      if ((this.mCurrPos > 0L) && (isWifiConnect()))
      {
        QMLog.d("MiniAppVideoPlayer", "play current pos is: " + this.mCurrPos);
        play(this.mCurrPos);
        if (this.isPause) {
          continue;
        }
        bool = true;
        resetControlIvDrawable(bool);
        this.needPauseOnLoad = this.isPause;
      }
      paramContext = this.mVideoPlayer;
      if (!this.objectFit.equals("contain")) {
        continue;
      }
      paramContext.setXYaxis(i);
      return;
      if (!StringUtil.isEmpty(this.mUrls)) {
        MediaUtils.getImageForVideo(this.mMiniAppContext, this.mUrls, new MiniAppVideoPlayer.5(this));
      }
    }
  }
  
  private List<Barrage> parseDanmuList(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return this.barrages;
    }
    if (this.barrages == null) {
      this.barrages = new LinkedList();
    }
    for (;;)
    {
      int j = paramJSONArray.length();
      if (j > 0)
      {
        int i = 0;
        label38:
        if (i < j) {
          try
          {
            this.barrages.add(Barrage.parseJson(paramJSONArray.getJSONObject(i)));
            i += 1;
            break label38;
            this.barrages.clear();
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    if (this.danmuView != null) {
      this.danmuView.setBarrages(this.barrages);
    }
    return this.barrages;
  }
  
  private static String parseTimeString(long paramLong)
  {
    long l2 = paramLong / 1000L;
    long l1 = l2;
    if (paramLong % 1000L != 0L) {
      l1 = l2 + 1L;
    }
    int i = (int)(l1 % 60L);
    paramLong = l1 / 60L;
    return parseTwoBitNumString(paramLong) + ":" + parseTwoBitNumString(i);
  }
  
  private static String parseTwoBitNumString(long paramLong)
  {
    if (paramLong == 0L) {
      return "00";
    }
    if (paramLong < 10L) {
      return "0" + paramLong;
    }
    return Long.toString(paramLong);
  }
  
  private void pause()
  {
    QMLog.d("MiniAppVideoPlayer", "pause");
    if (this.mVideoPlayer == null) {}
    do
    {
      return;
      this.playingBefore = false;
    } while (!this.mVideoPlayer.isPlaying());
    cancelAvoidLockScreen();
    this.mVideoPlayer.pause();
    this.isPause = true;
    if (!this.pageWebview.getClass().getName().equals("AppBrandService"))
    {
      callbackVideoStateChange("pause");
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoId", this.videoId);
        localJSONObject.put("data", this.data);
        if (this.mMiniAppContext != null)
        {
          IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();
          if (localIMiniAppContext != null) {
            localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPause", localJSONObject.toString(), this.webviewId));
          }
          this.pageWebview.evaluateSubscribeJS("onVideoPause", localJSONObject.toString(), this.webviewId);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      Object localObject = null;
    }
  }
  
  private void resetBarrageDrawable()
  {
    ImageView localImageView = this.barrageIv;
    if (this.isBarrageOpen) {}
    for (int i = R.drawable.mini_sdk_player_barrage_open;; i = R.drawable.mini_sdk_player_barrage_close)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void resetControlIvDrawable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.controlIv.setImageResource(R.drawable.mini_sdk_player_pause);
      this.centerControlIv.setImageResource(R.drawable.mini_sdk_player_pause);
      return;
    }
    this.controlIv.setImageResource(R.drawable.mini_sdk_player_resume);
    this.centerControlIv.setImageResource(R.drawable.mini_sdk_player_resume);
  }
  
  private void resetMuteImage()
  {
    if (!this.showMuteBtn) {
      this.muteIv.setVisibility(8);
    }
    while (this.mVideoPlayer == null) {
      return;
    }
    ImageView localImageView = this.muteIv;
    if (this.mVideoPlayer.getOutputMute()) {}
    for (int i = R.drawable.mini_sdk_video_mute;; i = R.drawable.mini_sdk_video_unmute)
    {
      localImageView.setImageResource(i);
      this.muteIv.setVisibility(0);
      return;
    }
  }
  
  private void resetPlayingTime()
  {
    if (this.mVideoPlayer == null) {
      return;
    }
    this.nowTimeTv.setText(parseTimeString(this.mVideoPlayer.getCurrentPostion()));
  }
  
  private void resetWindowIvDrawable()
  {
    ImageView localImageView = this.windowIv;
    if (this.isFullScreen) {}
    for (int i = R.drawable.mini_sdk_player_shrink_back;; i = R.drawable.mini_sdk_player_stretch_back)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void sendTimingMsg(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2002;
    this.handler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void setPoster()
  {
    Drawable localDrawable = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.mContext, this.poster, 0, 0, null);
    if ((localDrawable != null) && (this.video_img != null))
    {
      this.video_img.setVisibility(0);
      this.video_img.setImageDrawable(localDrawable);
      this.video_img.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  private void setProgressByPlayingTime()
  {
    if (this.mVideoPlayer == null) {
      return;
    }
    long l2 = this.mVideoPlayer.getDuration();
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    this.playerSeekBar.setProgress((int)(this.mVideoPlayer.getCurrentPostion() * this.playerSeekBar.getMax() / l1));
  }
  
  private void setUpView(Context paramContext)
  {
    if (this.hasSetUp) {
      return;
    }
    this.hasSetUp = true;
    setTag("MiniAppVideoPlayer");
    this.mContext = paramContext;
    this.view = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_player_view, null);
    this.video_container = ((VideoGestureRelativeLayout)this.view.findViewById(R.id.layout_videolayout));
    this.video_container.setContentDescription("video_container");
    this.video_pop_container = ((FrameLayout)this.view.findViewById(R.id.video_pop_container));
    this.video_img = ((ImageView)this.view.findViewById(R.id.video_img));
    this.play_status_img = ((ImageView)this.view.findViewById(R.id.play_status_img));
    this.play_status_img.setOnClickListener(this);
    this.playingPopView = this.view.findViewById(R.id.video_playing_pop_container);
    this.nowTimeTv = ((TextView)this.view.findViewById(R.id.video_playing_tv_time_now));
    this.totalTimeTv = ((TextView)this.view.findViewById(R.id.video_playing_tv_time_total));
    this.controlIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_control));
    this.centerControlIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_control_center));
    this.controlBar = this.view.findViewById(R.id.video_playing_control_bar);
    this.windowIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_window));
    this.playerSeekBar = ((SeekBar)this.view.findViewById(R.id.video_playing_bar));
    this.loadingView = this.view.findViewById(R.id.video_loading_container);
    this.barrageIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_barrage));
    this.seekTv = ((TextView)this.view.findViewById(R.id.video_playing_tv_seek));
    this.backIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_back_fullscreen));
    this.titleTv = ((TextView)this.view.findViewById(R.id.video_playing_tv_title));
    this.muteIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_mute));
    this.actionVg = ((FrameLayout)this.view.findViewById(R.id.video_action_container));
    paramContext = this.barrageIv;
    if (this.showDanmuBtn) {}
    for (int i = 0;; i = 4)
    {
      paramContext.setVisibility(i);
      if (Build.VERSION.SDK_INT > 15) {
        this.playerSeekBar.getThumb().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      this.controlIv.setOnClickListener(this);
      this.centerControlIv.setOnClickListener(this);
      this.windowIv.setOnClickListener(this);
      this.barrageIv.setOnClickListener(this);
      this.backIv.setOnClickListener(this);
      this.muteIv.setOnClickListener(this);
      this.videoPlayerStatusObserver = new VideoPlayerStatusObserver();
      this.mVideoGestureLayout = new VideoGestureLayout(this.mContext);
      this.mVideoGestureLayout.setContentDescription("VideoGestureLayout");
      this.video_container.setVideoGestureListener(new MiniAppVideoPlayer.2(this));
      this.playerSeekBar.setOnSeekBarChangeListener(new MiniAppVideoPlayer.3(this));
      addView(this.view);
      return;
    }
  }
  
  private void showPopCtrView()
  {
    showPopCtrViewWithoutHideAfter();
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    this.handler.sendMessageDelayed(localMessage, 5000L);
  }
  
  private void showPopCtrViewWithoutHideAfter()
  {
    int i = 0;
    if (this.isShowBasicControl)
    {
      this.playingPopView.setVisibility(0);
      View localView = this.controlBar;
      if (this.isShowControlBar) {
        localView.setVisibility(i);
      }
    }
    for (;;)
    {
      this.handler.removeMessages(2003);
      return;
      i = 8;
      break;
      this.playingPopView.setVisibility(4);
    }
  }
  
  private void start()
  {
    QMLog.d("MiniAppVideoPlayer", "start");
    avoidLockScreen();
    if ((this.mVideoPlayer != null) && (this.mVideoPlayer.getCurrentPostion() > 0L)) {
      this.mVideoPlayer.start();
    }
    for (;;)
    {
      this.isPause = false;
      return;
      play((this.initialTime * 1000.0D));
    }
  }
  
  private void updateBufferProgress(boolean paramBoolean)
  {
    MiniAppVideoPlayer.16 local16 = new MiniAppVideoPlayer.16(this);
    if (!paramBoolean) {
      local16.run();
    }
    while ((!this.isBufferStart) && (this.lastBufferProgress == 0)) {
      return;
    }
    this.handler.postDelayed(local16, 20L);
  }
  
  private void updatePoster()
  {
    if ((this.poster != null) && (!this.poster.equals(this.lastPoster))) {
      setPoster();
    }
    this.lastPoster = this.poster;
  }
  
  public void captureImage(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    int i = 0;
    if (this.mVideoPlayer == null)
    {
      QMLog.e("MiniAppVideoPlayer", "captureImage video player is null");
      if (paramOnCaptureImageListener != null) {
        paramOnCaptureImageListener.onCaptureImageFailed(null);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (this.mVideoPlayer.isPlaying()) {
            break label126;
          }
          if ((this.cachedCaptureImage == null) || (this.cachedCaptureImage.isRecycled())) {
            break label115;
          }
          if (paramOnCaptureImageListener != null)
          {
            paramOnCaptureImageListener.onCaptureImageSucceed(this.mVideoPlayer, this.cachedCaptureImage);
            return;
          }
        }
        catch (Exception localException1)
        {
          QMLog.e("MiniAppVideoPlayer", "captureImage video player fail!,e" + localException1);
        }
      }
    } while (paramOnCaptureImageListener == null);
    paramOnCaptureImageListener.onCaptureImageFailed(null);
    return;
    label115:
    paramOnCaptureImageListener.onCaptureImageFailed(this.mVideoPlayer);
    return;
    label126:
    int j;
    if (this.view != null)
    {
      j = this.view.getWidth();
      i = this.view.getHeight();
    }
    for (;;)
    {
      this.mVideoPlayer.setOnCaptureImageListener(new MiniAppVideoPlayer.18(this, paramOnCaptureImageListener));
      try
      {
        this.mVideoPlayer.captureImageInTime(j, i);
        return;
      }
      catch (Exception localException2)
      {
        QMLog.e("MiniAppVideoPlayer", "captureImage ", localException2);
        return;
      }
      j = 0;
    }
  }
  
  public void changeState()
  {
    ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.4(this));
  }
  
  public void fullScreen()
  {
    this.handler.post(new MiniAppVideoPlayer.14(this));
  }
  
  public long getCurrentPos()
  {
    if (this.mVideoPlayer == null) {
      return 0L;
    }
    return this.mVideoPlayer.getCurrentPostion();
  }
  
  public long getDuration()
  {
    if (this.mVideoPlayer == null) {
      return 0L;
    }
    return this.mVideoPlayer.getDuration();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 2002: 
      long l = System.currentTimeMillis();
      if ((this.mVideoPlayer != null) && (this.mVideoPlayer.isPlaying()))
      {
        resetPlayingTime();
        if (this.danmuView != null) {
          this.danmuView.updateTime(this.mVideoPlayer.getCurrentPostion());
        }
        if (!this.isChangingProgress) {
          setProgressByPlayingTime();
        }
        if (this.pageWebview.getClass().getName().equals("com.tencent.qqmini.minigame.GameJsService")) {
          callbackVideoStateChange("timeUpdate");
        }
      }
      else
      {
        if (!this.isPause) {
          sendTimingMsg(l + 200L - System.currentTimeMillis());
        }
        return true;
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", this.data);
          localJSONObject.put("position", this.mVideoPlayer.getCurrentPostion() / 1000.0D);
          localJSONObject.put("duration", this.mVideoPlayer.getDuration() / 1000.0D);
          localJSONObject.put("videoId", this.videoId);
          if (this.mMiniAppContext == null) {
            break label316;
          }
          paramMessage = (IMiniAppContext)this.mMiniAppContext.get();
          if (paramMessage != null) {
            paramMessage.performAction(ServiceSubscribeEvent.obtain("onVideoTimeUpdate", localJSONObject.toString(), this.webviewId));
          }
          this.pageWebview.evaluateSubscribeJS("onVideoTimeUpdate", localJSONObject.toString(), this.webviewId);
          QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoTimeUpdate = " + localJSONObject.toString());
        }
        catch (JSONException paramMessage)
        {
          paramMessage.printStackTrace();
        }
        break;
        label316:
        paramMessage = null;
      }
    }
    this.playingPopView.setVisibility(4);
    return true;
  }
  
  public void initSetting(JSONObject paramJSONObject)
  {
    int j = 0;
    QMLog.i("MiniAppVideoPlayer", "initSetting: " + paramJSONObject.toString());
    this.needEvent = paramJSONObject.optBoolean("needEvent", this.needEvent);
    this.hide = paramJSONObject.optBoolean("hide", this.hide);
    this.enableDanmu = paramJSONObject.optBoolean("enableDanmu", this.enableDanmu);
    if (!this.hasShowDanmuBtnSet)
    {
      this.showDanmuBtn = paramJSONObject.optBoolean("showDanmuBtn", this.showDanmuBtn);
      this.loop = paramJSONObject.optBoolean("loop", this.loop);
      QMLog.i("MiniAppVideoPlayer", "initSetting: set dan mu btn " + this.enableDanmu);
      this.hasShowDanmuBtnSet = true;
      this.enablePlayGesture = paramJSONObject.optBoolean("enablePlayGesture", this.enablePlayGesture);
      this.direction = paramJSONObject.optInt("direction", this.direction);
      this.isShowBasicControl = paramJSONObject.optBoolean("showBasicControls", this.isShowBasicControl);
      this.isShowControlBar = paramJSONObject.optBoolean("controls", this.isShowControlBar);
      this.playBtnPosition = paramJSONObject.optString("playBtnPosition", this.playBtnPosition);
      this.showProgress = paramJSONObject.optBoolean("showProgress", this.showProgress);
      this.showMuteBtn = paramJSONObject.optBoolean("showMuteBtn", this.showMuteBtn);
      this.title = paramJSONObject.optString("title", this.title);
      this.autoPauseIfNavigate = paramJSONObject.optBoolean("autoPauseIfNavigate", this.autoPauseIfNavigate);
      this.autoPauseIfOpenNative = paramJSONObject.optBoolean("autoPauseIfOpenNative", this.autoPauseIfOpenNative);
    }
    if (paramJSONObject.has("muted")) {}
    try
    {
      this.muted = paramJSONObject.getBoolean("muted");
      this.showCenterPlayBtn = paramJSONObject.optBoolean("showCenterPlayBtn", this.showCenterPlayBtn);
      Object localObject = paramJSONObject.optString("objectFit", this.objectFit);
      if (!this.objectFit.equals(localObject))
      {
        if ("contain".equals(localObject))
        {
          if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setXYaxis(0);
          }
          this.objectFit = ((String)localObject);
        }
      }
      else
      {
        this.autoplay = paramJSONObject.optBoolean("autoplay", this.autoplay);
        this.barrages = parseDanmuList((JSONArray)paramJSONObject.opt("danmuList"));
        this.isLive = paramJSONObject.optBoolean("isLive", this.isLive);
        this.isMuted = paramJSONObject.optBoolean("isMuted", this.isMuted);
        this.pageGesture = paramJSONObject.optBoolean("pageGesture", this.pageGesture);
        this.initialTime = paramJSONObject.optDouble("initialTime", this.initialTime);
        this.parentId = paramJSONObject.optInt("parentId", this.parentId);
        this.customCache = paramJSONObject.optBoolean("customCache", this.customCache);
        this.showProgress = paramJSONObject.optBoolean("showProgress", this.showProgress);
        this.showControlProgress = paramJSONObject.optBoolean("showControlProgress", this.showControlProgress);
        this.showLiveBtn = paramJSONObject.optBoolean("showLiveBtn", this.showLiveBtn);
        this.showPlayBtn = paramJSONObject.optBoolean("showPlayBtn", this.showPlayBtn);
        this.showFullScreenBtn = paramJSONObject.optBoolean("showFullScreenBtn", this.showFullScreenBtn);
        this.enableProgressGesture = paramJSONObject.optBoolean("enableProgressGesture", this.enableProgressGesture);
        if (!this.isFullScreen)
        {
          localObject = paramJSONObject.optJSONObject("position");
          if (localObject == null) {
            break label1043;
          }
          this.videoX = ((JSONObject)localObject).optInt("left", this.videoX);
          this.videoY = ((JSONObject)localObject).optInt("top", this.videoY);
          this.videoWidth = ((JSONObject)localObject).optInt("width", this.videoWidth);
          this.videoHeight = ((JSONObject)localObject).optInt("height", this.videoHeight);
        }
        if (StringUtil.isEmpty(this.poster)) {
          this.poster = paramJSONObject.optString("poster", this.poster);
        }
        if (this.mVideoPlayer != null)
        {
          this.mCurrPos = this.mVideoPlayer.getCurrentPostion();
          if (this.mVideoPlayer.getOutputMute() != this.muted)
          {
            Log.i("MiniAppVideoPlayer", "initSetting: set mute " + this.muted);
            this.mVideoPlayer.setOutputMute(this.muted);
          }
        }
        if (this.barrageIv != null)
        {
          paramJSONObject = this.barrageIv;
          if (!this.showDanmuBtn) {
            break label1106;
          }
          i = 0;
          paramJSONObject.setVisibility(i);
        }
        if (!"center".equals(this.playBtnPosition)) {
          break label1117;
        }
        paramJSONObject = this.centerControlIv;
        if (!this.showCenterPlayBtn) {
          break label1111;
        }
        i = j;
        paramJSONObject.setVisibility(i);
        this.controlIv.setVisibility(8);
        if (!TextUtils.isEmpty(this.title)) {
          this.titleTv.setText(this.title);
        }
        resetMuteImage();
        if (!this.isFullScreen)
        {
          if ((this.mMiniAppContext == null) || (this.mMiniAppContext.get() == null) || (!((IMiniAppContext)this.mMiniAppContext.get()).isMiniGame())) {
            break label1137;
          }
          paramJSONObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, this.videoWidth), DisplayUtil.dip2px(this.mContext, this.videoHeight));
          paramJSONObject.leftMargin = DisplayUtil.dip2px(this.mContext, this.videoX);
          paramJSONObject.topMargin = DisplayUtil.dip2px(this.mContext, this.videoY);
          ((CoverVideoView)getParent()).setLayoutParams(paramJSONObject);
        }
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i;
        QMLog.w("MiniAppVideoPlayer", "initSetting: ", localJSONException);
        continue;
        if ("fill".equals(localJSONException))
        {
          if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setXYaxis(1);
          }
          this.objectFit = localJSONException;
          continue;
          label1043:
          this.videoX = paramJSONObject.optInt("x", this.videoX);
          this.videoY = paramJSONObject.optInt("y", this.videoY);
          this.videoWidth = paramJSONObject.optInt("width", this.videoWidth);
          this.videoHeight = paramJSONObject.optInt("height", this.videoHeight);
          continue;
          label1106:
          i = 4;
          continue;
          label1111:
          i = 8;
          continue;
          label1117:
          this.centerControlIv.setVisibility(8);
          this.controlIv.setVisibility(0);
        }
      }
      label1137:
      paramJSONObject = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, this.videoWidth), DisplayUtil.dip2px(this.mContext, this.videoHeight));
      paramJSONObject.leftMargin = DisplayUtil.dip2px(this.mContext, this.videoX);
      paramJSONObject.topMargin = DisplayUtil.dip2px(this.mContext, this.videoY);
      ((CoverVideoView)getParent()).setLayoutParams(paramJSONObject);
    }
  }
  
  public void initVideoPlayerSettings(JSONObject paramJSONObject)
  {
    QMLog.d("MiniAppVideoPlayer", "initLivePlayerSettings isFullScreen: " + this.isFullScreen);
    initOskOnce(this.mContext);
    initSetting(paramJSONObject);
    initPlayer(this.mContext);
    updatePoster();
  }
  
  public boolean isFullScreen()
  {
    return this.isFullScreen;
  }
  
  boolean isFullScreenSize(int paramInt1, int paramInt2)
  {
    return (paramInt1 == DisplayUtil.getRealHeight(getContext())) && (paramInt2 == DisplayUtil.getScreenWidth(getContext()));
  }
  
  public boolean isPlaying()
  {
    return (this.mVideoPlayer != null) && (this.mVideoPlayer.isPlaying());
  }
  
  public boolean isWifiConnect()
  {
    return ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (this.mVideoPlayer == null) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView.getId() != R.id.play_status_img) {
          break;
        }
        if (this.play_status_img.getVisibility() == 0) {
          play(getCurrentPos());
        }
      }
      if ((paramView.getId() == this.controlIv.getId()) || (paramView.getId() == this.centerControlIv.getId()))
      {
        operate();
        if (this.mVideoPlayer.isPlaying()) {
          showPopCtrView();
        }
        for (;;)
        {
          resetControlIvDrawable(this.mVideoPlayer.isPlaying());
          break;
          showPopCtrViewWithoutHideAfter();
        }
      }
      if ((paramView.getId() == this.windowIv.getId()) || (paramView.getId() == this.backIv.getId()))
      {
        showPopCtrView();
        if (this.isFullScreen) {
          smallScreen();
        }
        for (;;)
        {
          resetWindowIvDrawable();
          break;
          fullScreen();
        }
      }
      if (paramView.getId() == this.barrageIv.getId())
      {
        showPopCtrView();
        if (this.isBarrageOpen)
        {
          this.danmuView.setVisibility(4);
          this.isBarrageOpen = false;
        }
        for (;;)
        {
          resetBarrageDrawable();
          break;
          if (this.danmuView != null)
          {
            this.danmuView.setVisibility(0);
            this.isBarrageOpen = true;
          }
        }
      }
    } while (paramView.getId() != this.muteIv.getId());
    AbsVideoPlayer localAbsVideoPlayer = this.mVideoPlayer;
    if (!this.mVideoPlayer.getOutputMute()) {}
    for (;;)
    {
      localAbsVideoPlayer.setOutputMute(bool);
      resetMuteImage();
      break;
      bool = false;
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.isFullScreen) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void operate()
  {
    QMLog.d("MiniAppVideoPlayer", "operate");
    if (this.mVideoPlayer == null) {
      return;
    }
    if (this.mVideoPlayer.isPlaying())
    {
      this.pauseByUser = true;
      pause();
      return;
    }
    this.pauseByUser = false;
    start();
    if (!this.pageWebview.getClass().getName().equals("AppBrandService"))
    {
      callbackVideoStateChange("play");
      sendTimingMsg(200L);
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoId", this.videoId);
        localJSONObject.put("data", this.data);
        if (this.mMiniAppContext == null) {
          break label212;
        }
        IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();
        if (localIMiniAppContext != null) {
          localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPlay", localJSONObject.toString(), this.webviewId));
        }
        this.pageWebview.evaluateSubscribeJS("onVideoPlay", localJSONObject.toString(), this.webviewId);
        QMLog.d("MiniAppVideoPlayer", "operate start evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      break;
      label212:
      Object localObject = null;
    }
  }
  
  public void play()
  {
    play(getCurrentPos());
  }
  
  public void play(long paramLong)
  {
    if (this.mVideoPlayer == null) {}
    do
    {
      return;
      Log.i("MiniAppVideoPlayer", "play: " + paramLong + " /" + this.mVideoPlayer.getDuration(), new Throwable());
    } while (StringUtil.isEmpty(this.mUrls));
    this.isBufferStart = true;
    updateBufferProgress(false);
    avoidLockScreen();
    this.loadingView.setVisibility(0);
    this.playingBefore = true;
    this.mVideoPlayer.stop();
    if (this.enableDanmu) {
      this.mVideoPlayer.startPlayDanmu();
    }
    this.mVideoPlayer.openMediaPlayerByUrl(getContext(), this.mUrls, paramLong);
    this.play_status_img.setVisibility(8);
    if (!this.pageWebview.getClass().getName().equals("AppBrandService"))
    {
      callbackVideoStateChange("play");
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", this.data);
        if (this.mMiniAppContext != null)
        {
          IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();
          if (localIMiniAppContext != null) {
            localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPlay", localJSONObject.toString(), this.webviewId));
          }
          this.pageWebview.evaluateSubscribeJS("onVideoPlay", localJSONObject.toString(), this.webviewId);
          QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      Object localObject = null;
    }
  }
  
  public void playDanmu(String paramString, int paramInt)
  {
    if ((this.mVideoPlayer != null) && (this.danmuView != null)) {
      this.danmuView.showBarrageNextTime(new Barrage(paramString, paramInt, 0L));
    }
  }
  
  public void playRate() {}
  
  public void release()
  {
    if (this.danmuView != null) {
      this.danmuView.destroy();
    }
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.release();
    }
    this.hasSetUp = false;
    ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.13(this));
    ScreenOffOnListener.getInstance().unRegistListener();
    this.handler.removeMessages(2002);
  }
  
  public boolean seekTo(int paramInt)
  {
    if (this.mVideoPlayer == null) {
      return false;
    }
    if (paramInt < 0)
    {
      this.mVideoPlayer.seekTo(0);
      return true;
    }
    long l = this.mVideoPlayer.getDuration();
    if ((l > 0L) && (paramInt > l))
    {
      this.mVideoPlayer.seekTo((int)l);
      return true;
    }
    this.initialTime = (paramInt / 1000.0D);
    if (l > 0L) {
      this.mVideoPlayer.seekTo(paramInt);
    }
    return true;
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.atyRef = paramWeakReference;
    if (paramWeakReference != null)
    {
      paramWeakReference = (Activity)paramWeakReference.get();
      this.mAudioManager = ((AudioManager)paramWeakReference.getSystemService("audio"));
      if (this.mAudioManager != null) {
        this.maxVolume = this.mAudioManager.getStreamMaxVolume(3);
      }
      this.mWindow = paramWeakReference.getWindow();
      if (this.mWindow != null)
      {
        this.mLayoutParams = this.mWindow.getAttributes();
        if (this.mLayoutParams != null) {
          this.brightness = this.mLayoutParams.screenBrightness;
        }
      }
    }
  }
  
  /* Error */
  public void setVideoPath(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 28
    //   5: new 701	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 702	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 1645
    //   15: invokevirtual 708	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: invokevirtual 708	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 726	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 1439	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: iconst_0
    //   31: invokevirtual 1647	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:stop	(Z)V
    //   34: aload_0
    //   35: getfield 267	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:showCenterPlayBtn	Z
    //   38: ifeq +245 -> 283
    //   41: aload_0
    //   42: getfield 455	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:play_status_img	Landroid/widget/ImageView;
    //   45: iconst_0
    //   46: invokevirtual 903	android/widget/ImageView:setVisibility	(I)V
    //   49: aload_0
    //   50: getfield 337	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:playingPopView	Landroid/view/View;
    //   53: bipush 8
    //   55: invokevirtual 817	android/view/View:setVisibility	(I)V
    //   58: aload_0
    //   59: getfield 233	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:handler	Landroid/os/Handler;
    //   62: sipush 2002
    //   65: invokevirtual 1229	android/os/Handler:removeMessages	(I)V
    //   68: aload_1
    //   69: ldc_w 1649
    //   72: invokevirtual 732	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   75: ifeq +230 -> 305
    //   78: aload_0
    //   79: getfield 596	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:mMiniAppContext	Ljava/lang/ref/WeakReference;
    //   82: ifnull +213 -> 295
    //   85: aload_0
    //   86: getfield 596	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:mMiniAppContext	Ljava/lang/ref/WeakReference;
    //   89: invokevirtual 546	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   92: checkcast 598	com/tencent/qqmini/sdk/launcher/core/IMiniAppContext
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +203 -> 300
    //   100: aload_3
    //   101: ldc_w 1651
    //   104: invokeinterface 1654 2 0
    //   109: checkcast 1651	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   112: aload_1
    //   113: invokevirtual 1657	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_1
    //   117: aload_0
    //   118: aload_1
    //   119: putfield 940	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:mUrls	Ljava/lang/String;
    //   122: aload_0
    //   123: getfield 289	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:isResetPath	Z
    //   126: ifne +10 -> 136
    //   129: aload_0
    //   130: getfield 251	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:autoplay	Z
    //   133: ifeq +22 -> 155
    //   136: aload_0
    //   137: getfield 233	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:handler	Landroid/os/Handler;
    //   140: new 1659	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer$1
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 1660	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer$1:<init>	(Lcom/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer;)V
    //   148: ldc2_w 1661
    //   151: invokevirtual 770	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   154: pop
    //   155: aload_0
    //   156: iconst_1
    //   157: putfield 289	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:isResetPath	Z
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 492	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:rotation	I
    //   165: getstatic 685	android/os/Build$VERSION:SDK_INT	I
    //   168: bipush 15
    //   170: if_icmple +112 -> 282
    //   173: new 1664	java/io/FileInputStream
    //   176: dup
    //   177: aload_0
    //   178: getfield 940	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:mUrls	Ljava/lang/String;
    //   181: invokespecial 1666	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   184: astore_3
    //   185: new 694	android/media/MediaExtractor
    //   188: dup
    //   189: invokespecial 1667	android/media/MediaExtractor:<init>	()V
    //   192: astore 5
    //   194: aload 5
    //   196: aload_3
    //   197: invokevirtual 1671	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   200: invokevirtual 1675	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   203: aload 5
    //   205: invokestatic 1677	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   208: istore_2
    //   209: iload_2
    //   210: iconst_m1
    //   211: if_icmple +53 -> 264
    //   214: aload 5
    //   216: iload_2
    //   217: invokevirtual 717	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   220: astore_1
    //   221: aload_1
    //   222: ldc_w 1679
    //   225: invokevirtual 1682	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   228: ifeq +14 -> 242
    //   231: aload_0
    //   232: aload_1
    //   233: ldc_w 1679
    //   236: invokevirtual 1686	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   239: putfield 492	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:rotation	I
    //   242: aload_0
    //   243: aload_1
    //   244: ldc_w 1429
    //   247: invokevirtual 1686	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   250: putfield 486	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:originWidth	I
    //   253: aload_0
    //   254: aload_1
    //   255: ldc_w 1431
    //   258: invokevirtual 1686	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   261: putfield 489	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:originHeight	I
    //   264: aload_3
    //   265: ifnull +7 -> 272
    //   268: aload_3
    //   269: invokevirtual 1689	java/io/FileInputStream:close	()V
    //   272: aload 5
    //   274: ifnull +8 -> 282
    //   277: aload 5
    //   279: invokevirtual 1690	android/media/MediaExtractor:release	()V
    //   282: return
    //   283: aload_0
    //   284: getfield 455	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:play_status_img	Landroid/widget/ImageView;
    //   287: bipush 8
    //   289: invokevirtual 903	android/widget/ImageView:setVisibility	(I)V
    //   292: goto -243 -> 49
    //   295: aconst_null
    //   296: astore_3
    //   297: goto -201 -> 96
    //   300: aconst_null
    //   301: astore_1
    //   302: goto -185 -> 117
    //   305: aload_1
    //   306: ldc_w 1692
    //   309: invokevirtual 732	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   312: ifne +13 -> 325
    //   315: aload_1
    //   316: ldc_w 1694
    //   319: invokevirtual 732	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   322: ifeq -200 -> 122
    //   325: aload_0
    //   326: aload_1
    //   327: putfield 940	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:mUrls	Ljava/lang/String;
    //   330: goto -208 -> 122
    //   333: astore 5
    //   335: aconst_null
    //   336: astore_3
    //   337: aload 4
    //   339: astore_1
    //   340: aload 5
    //   342: astore 4
    //   344: ldc 28
    //   346: ldc_w 1645
    //   349: aload 4
    //   351: invokestatic 1696	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   354: pop
    //   355: aload_1
    //   356: ifnull +7 -> 363
    //   359: aload_1
    //   360: invokevirtual 1689	java/io/FileInputStream:close	()V
    //   363: aload_3
    //   364: ifnull -82 -> 282
    //   367: aload_3
    //   368: invokevirtual 1690	android/media/MediaExtractor:release	()V
    //   371: return
    //   372: astore_1
    //   373: aconst_null
    //   374: astore 4
    //   376: aconst_null
    //   377: astore_3
    //   378: aload 4
    //   380: ifnull +8 -> 388
    //   383: aload 4
    //   385: invokevirtual 1689	java/io/FileInputStream:close	()V
    //   388: aload_3
    //   389: ifnull +7 -> 396
    //   392: aload_3
    //   393: invokevirtual 1690	android/media/MediaExtractor:release	()V
    //   396: aload_1
    //   397: athrow
    //   398: astore_1
    //   399: goto -127 -> 272
    //   402: astore_1
    //   403: goto -40 -> 363
    //   406: astore 4
    //   408: goto -20 -> 388
    //   411: astore_1
    //   412: aconst_null
    //   413: astore 5
    //   415: aload_3
    //   416: astore 4
    //   418: aload 5
    //   420: astore_3
    //   421: goto -43 -> 378
    //   424: astore_1
    //   425: aload_3
    //   426: astore 4
    //   428: aload 5
    //   430: astore_3
    //   431: goto -53 -> 378
    //   434: astore 5
    //   436: aload_1
    //   437: astore 4
    //   439: aload 5
    //   441: astore_1
    //   442: goto -64 -> 378
    //   445: astore 4
    //   447: aconst_null
    //   448: astore 5
    //   450: aload_3
    //   451: astore_1
    //   452: aload 5
    //   454: astore_3
    //   455: goto -111 -> 344
    //   458: astore 4
    //   460: aload_3
    //   461: astore_1
    //   462: aload 5
    //   464: astore_3
    //   465: goto -121 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	MiniAppVideoPlayer
    //   0	468	1	paramString	String
    //   208	9	2	i	int
    //   95	370	3	localObject1	Object
    //   1	383	4	localObject2	Object
    //   406	1	4	localIOException	java.io.IOException
    //   416	22	4	localObject3	Object
    //   445	1	4	localThrowable1	Throwable
    //   458	1	4	localThrowable2	Throwable
    //   192	86	5	localMediaExtractor	MediaExtractor
    //   333	8	5	localThrowable3	Throwable
    //   413	16	5	localObject4	Object
    //   434	6	5	localObject5	Object
    //   448	15	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   173	185	333	java/lang/Throwable
    //   173	185	372	finally
    //   268	272	398	java/io/IOException
    //   359	363	402	java/io/IOException
    //   383	388	406	java/io/IOException
    //   185	194	411	finally
    //   194	209	424	finally
    //   214	242	424	finally
    //   242	264	424	finally
    //   344	355	434	finally
    //   185	194	445	java/lang/Throwable
    //   194	209	458	java/lang/Throwable
    //   214	242	458	java/lang/Throwable
    //   242	264	458	java/lang/Throwable
  }
  
  public void smallScreen()
  {
    this.handler.post(new MiniAppVideoPlayer.15(this));
  }
  
  public void stop()
  {
    stop(true);
  }
  
  public void stop(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.isFullScreen)) {
      smallScreen();
    }
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.stop();
    }
    ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.12(this));
  }
  
  public void updateVideoPlayerSetting(JSONObject paramJSONObject)
  {
    QMLog.d("MiniAppVideoPlayer", "updateLivePlayerSetting isFullScreen: " + this.isFullScreen);
    initSetting(paramJSONObject);
    updatePoster();
  }
  
  public class VideoPlayerStatusObserver
    implements Observer
  {
    public VideoPlayerStatusObserver() {}
    
    public void update(Observable paramObservable, Object paramObject)
    {
      if (!(paramObject instanceof String)) {}
      do
      {
        return;
        if (("resetPlayer".equals((String)paramObject)) && (MiniAppVideoPlayer.this.autoPauseIfNavigate))
        {
          MiniAppVideoPlayer.this.smallScreen();
          MiniAppVideoPlayer.this.stop();
          return;
        }
      } while (!"resumePlayer".equals((String)paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer
 * JD-Core Version:    0.7.0.1
 */