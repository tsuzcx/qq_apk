package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.TextView;
import aoop;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.danmu.Barrage;
import com.tencent.mobileqq.mini.widget.media.danmu.BarrageView;
import com.tencent.oskplayer.OskPlayerConfig;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
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
  public static volatile boolean mIsInited;
  private static final String oskPlayerContentTypeList = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  private ViewGroup actionVg;
  public WeakReference<Activity> atyRef;
  public boolean autoPauseIfNavigate = true;
  public boolean autoPauseIfOpenNative = true;
  public boolean autoplay;
  private ImageView backIv;
  private ImageView barrageIv;
  public List<Barrage> barrages;
  private float brightness = 1.0F;
  private Bitmap cachedCaptureImage;
  private ImageView centerControlIv;
  private int componentLayoutScrollY;
  private View controlBar;
  private ImageView controlIv;
  public boolean customCache;
  private BarrageView danmuView;
  public String data;
  public int direction = -1;
  public boolean enableDanmu;
  public boolean enablePlayGesture;
  public boolean enableProgressGesture = true;
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean hasSetUp;
  private boolean hasShowDanmuBtnSet;
  public boolean hide;
  public boolean hideTimeDesc;
  public double initialTime;
  public boolean isBarrageOpen;
  private boolean isBufferStart;
  boolean isBusyInChangeScreen = false;
  private boolean isChangingProgress;
  public boolean isFullScreen;
  public boolean isLive;
  public boolean isMuted;
  public boolean isPageOnBackground;
  private boolean isPause;
  boolean isResetPath = false;
  public boolean isShowBasicControl = true;
  public boolean isShowControlBar = true;
  private int lastBufferProgress;
  private int lastNavBarVisibility = 8;
  public String lastPoster;
  long lastSmallScreenTime = -1L;
  private int lastTabBarVisibility = 8;
  private View loadingView;
  public boolean loop;
  private AudioManager mAudioManager;
  private Context mContext;
  private long mCurrPos;
  private WindowManager.LayoutParams mLayoutParams;
  public String mUrls;
  private VideoGestureLayout mVideoGestureLayout;
  private Window mWindow;
  private int maxVolume;
  private ImageView muteIv;
  public boolean muted;
  public boolean needEvent;
  private boolean needPauseOnLoad;
  private int newProgress;
  private TextView nowTimeTv;
  public String objectFit = "contain";
  private int oldProgress;
  private int oldVolume;
  private int originHeight;
  private int originWidth;
  public boolean pageGesture;
  public int parentId;
  public boolean pauseByUser;
  public String playBtnPosition;
  private ImageView play_status_img;
  private SeekBar playerSeekBar;
  public boolean playingBefore;
  private View playingPopView;
  public String poster;
  public JSONObject postionObj;
  private int rotation;
  private TextView seekTv;
  public JsRuntime serviceWebview;
  public boolean showCenterPlayBtn = true;
  public boolean showControlProgress;
  public boolean showDanmuBtn;
  public boolean showFullScreenBtn = true;
  public boolean showLiveBtn;
  public boolean showMuteBtn;
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
  public WebviewContainer webviewContainer;
  public int webviewId;
  private ImageView windowIv;
  
  public MiniAppVideoPlayer(@NonNull Context paramContext)
  {
    this(paramContext, null);
    setUpView(paramContext);
  }
  
  public MiniAppVideoPlayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
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
      QLog.d("MiniAppVideoPlayer", 1, "avoidLockScreen");
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
      this.serviceWebview.evaluateSubcribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void callBackFullScreenChange(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoId", this.videoId);
      localJSONObject.put("fullScreen", this.isFullScreen);
      if (paramBoolean) {
        localJSONObject.put("direction", "horizontal");
      }
      for (;;)
      {
        this.serviceWebview.evaluateSubcribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId);
        return;
        localJSONObject.put("direction", "vertical");
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void callbackVideoStateChange(String paramString) {}
  
  private void cancelAvoidLockScreen()
  {
    if ((this.atyRef != null) && (this.atyRef.get() != null))
    {
      ((Activity)this.atyRef.get()).getWindow().clearFlags(128);
      ((Activity)this.atyRef.get()).getWindow().addFlags(1);
      QLog.d("MiniAppVideoPlayer", 1, "cancelAvoidLockScreen");
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
  
  private void getCachedCaptureImage() {}
  
  private void hidePopCtrView()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    this.handler.sendMessageDelayed(localMessage, 500L);
  }
  
  public static void initOskOnce(Context paramContext)
  {
    if (!mIsInited)
    {
      OskPlayerConfig localOskPlayerConfig = new OskPlayerConfig();
      localOskPlayerConfig.setEnableHLSCache(true);
      localOskPlayerConfig.setDebugVersion(true);
      localOskPlayerConfig.setLogger(new DefaultLogger());
      localOskPlayerConfig.setCacheKeyGenerator(new DefaultCacheKeyGenerator());
      OskPlayerCore.init(paramContext.getApplicationContext(), localOskPlayerConfig);
      paramContext = PlayerConfig.g().getContentTypeList();
      if (paramContext == null) {
        break label126;
      }
    }
    for (;;)
    {
      try
      {
        paramContext.addAll(Arrays.asList(oskPlayerContentTypeList.split("|")));
        PlayerConfig.g().setContentTypeList(paramContext);
        mIsInited = true;
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("MiniAppVideoPlayer", 2, "initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:" + paramContext);
        continue;
      }
      label126:
      QLog.e("MiniAppVideoPlayer", 2, "getContentTypeList null");
    }
  }
  
  private void initPlayer(Context paramContext) {}
  
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
  
  private void pause() {}
  
  private void resetBarrageDrawable()
  {
    ImageView localImageView = this.barrageIv;
    if (this.isBarrageOpen) {}
    for (int i = 2130848564;; i = 2130848563)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void resetControlIvDrawable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.controlIv.setImageResource(2130848565);
      this.centerControlIv.setImageResource(2130848565);
      return;
    }
    this.controlIv.setImageResource(2130848567);
    this.centerControlIv.setImageResource(2130848567);
  }
  
  private void resetMuteImage() {}
  
  private void resetPlayingTime() {}
  
  private void resetWindowIvDrawable()
  {
    ImageView localImageView = this.windowIv;
    if (this.isFullScreen) {}
    for (int i = 2130849493;; i = 2130849495)
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
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aoop.TRANSPARENT;
    try
    {
      if (URLUtil.isNetworkUrl(this.poster)) {}
      for (localObject1 = URLDrawable.getDrawable(this.poster, (URLDrawable.URLDrawableOptions)localObject1);; localObject1 = URLDrawable.getFileDrawable(this.poster, (URLDrawable.URLDrawableOptions)localObject1))
      {
        if ((localObject1 != null) && (this.video_img != null))
        {
          this.video_img.setVisibility(0);
          this.video_img.setImageDrawable((Drawable)localObject1);
          this.video_img.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MiniAppVideoPlayer", 1, "initPlayer get poster drawable error.", localThrowable);
        Object localObject2 = null;
      }
    }
  }
  
  private void setProgressByPlayingTime() {}
  
  private void setUpView(Context paramContext)
  {
    if (this.hasSetUp) {
      return;
    }
    this.hasSetUp = true;
    setTag("MiniAppVideoPlayer");
    this.mContext = paramContext;
    this.view = LayoutInflater.from(paramContext).inflate(2131559603, null);
    this.video_container = ((VideoGestureRelativeLayout)this.view.findViewById(2131370307));
    this.video_container.setContentDescription("video_container");
    this.video_pop_container = ((FrameLayout)this.view.findViewById(2131381787));
    this.video_img = ((ImageView)this.view.findViewById(2131381716));
    this.play_status_img = ((ImageView)this.view.findViewById(2131373397));
    this.play_status_img.setOnClickListener(this);
    this.playingPopView = this.view.findViewById(2131381782);
    this.nowTimeTv = ((TextView)this.view.findViewById(2131381784));
    this.totalTimeTv = ((TextView)this.view.findViewById(2131381785));
    this.controlIv = ((ImageView)this.view.findViewById(2131381777));
    this.centerControlIv = ((ImageView)this.view.findViewById(2131381778));
    this.controlBar = this.view.findViewById(2131381774);
    this.windowIv = ((ImageView)this.view.findViewById(2131381780));
    this.playerSeekBar = ((SeekBar)this.view.findViewById(2131381773));
    this.loadingView = this.view.findViewById(2131381738);
    this.barrageIv = ((ImageView)this.view.findViewById(2131381776));
    this.seekTv = ((TextView)this.view.findViewById(2131381783));
    this.backIv = ((ImageView)this.view.findViewById(2131381775));
    this.titleTv = ((TextView)this.view.findViewById(2131381786));
    this.muteIv = ((ImageView)this.view.findViewById(2131381779));
    this.actionVg = ((FrameLayout)this.view.findViewById(2131381592));
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
      this.video_container.setVideoGestureListener(new MiniAppVideoPlayer.3(this));
      this.playerSeekBar.setOnSeekBarChangeListener(new MiniAppVideoPlayer.4(this));
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
  
  private void start() {}
  
  private void updateBufferProgress(boolean paramBoolean)
  {
    MiniAppVideoPlayer.6 local6 = new MiniAppVideoPlayer.6(this);
    if (!paramBoolean) {
      local6.run();
    }
    while ((!this.isBufferStart) && (this.lastBufferProgress == 0)) {
      return;
    }
    this.handler.postDelayed(local6, 20L);
  }
  
  private void updatePoster()
  {
    if ((this.poster != null) && (!this.poster.equals(this.lastPoster))) {
      setPoster();
    }
    this.lastPoster = this.poster;
  }
  
  public void changeState()
  {
    AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.5(this));
  }
  
  public void fullScreen() {}
  
  public long getCurrentPos()
  {
    return 0L;
  }
  
  public long getDuration()
  {
    return 0L;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void initSetting(JSONObject paramJSONObject) {}
  
  public void initVideoPlayerSettings(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppVideoPlayer", 2, "initLivePlayerSettings isFullScreen: " + this.isFullScreen);
    }
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
    return (paramInt1 == DisplayUtil.getRealHeight(getContext())) && (paramInt2 == ImmersiveUtils.getScreenWidth());
  }
  
  public boolean isPlaying()
  {
    return false;
  }
  
  public void onClick(View paramView) {}
  
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
  
  public void operate() {}
  
  public void play()
  {
    play(getCurrentPos());
  }
  
  public void play(long paramLong) {}
  
  public void playDanmu(String paramString, int paramInt) {}
  
  public void playRate() {}
  
  public void release() {}
  
  public boolean seekTo(int paramInt)
  {
    return false;
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
  
  public void setVideoPath(String paramString)
  {
    Log.i("MiniAppVideoPlayer", "setVideoPath: " + paramString);
    stop(false);
    if (this.showCenterPlayBtn)
    {
      this.play_status_img.setVisibility(0);
      this.playingPopView.setVisibility(8);
      this.handler.removeMessages(2002);
      if (!paramString.startsWith("wxfile")) {
        break label166;
      }
    }
    for (this.mUrls = MiniAppFileManager.getInstance().getAbsolutePath(paramString);; this.mUrls = paramString) {
      label166:
      do
      {
        if ((this.isResetPath) || (this.autoplay)) {
          this.handler.postDelayed(new MiniAppVideoPlayer.1(this), 100L);
        }
        this.isResetPath = true;
        this.rotation = 0;
        if (Build.VERSION.SDK_INT > 15) {
          ThreadManagerV2.excute(new MiniAppVideoPlayer.2(this), 128, null, true);
        }
        return;
        this.play_status_img.setVisibility(8);
        break;
      } while ((!paramString.startsWith("http")) && (!paramString.startsWith("https")));
    }
  }
  
  public void smallScreen() {}
  
  public void stop()
  {
    stop(true);
  }
  
  public void stop(boolean paramBoolean) {}
  
  public void updateVideoPlayerSetting(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppVideoPlayer", 2, "updateLivePlayerSetting isFullScreen: " + this.isFullScreen);
    }
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
        paramObservable = MiniAppVideoPlayer.this.webviewContainer.appBrandRuntime;
      } while ((paramObservable == null) || (!paramObservable.isPause));
      MiniAppVideoPlayer.this.smallScreen();
      MiniAppVideoPlayer.this.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer
 * JD-Core Version:    0.7.0.1
 */