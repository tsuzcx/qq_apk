package com.tencent.mobileqq.gamecenter.media;

import abmt;
import ahsx;
import ahsy;
import ahty;
import ahtz;
import allf;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import aqiw;
import awot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.view.VideoLoadingImage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kwz;
import tbb;
import wja;

public class GameCenterVideoViewController
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  public static int daZ;
  private ImageView Aq;
  private FeedsItemData jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData;
  private a jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController$a;
  private VideoLoadingImage jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage;
  private long aaS;
  private boolean anS;
  private URLImageView bk;
  private URLImageView bl;
  private AtomicInteger bp = new AtomicInteger(0);
  private boolean cic;
  private boolean cid;
  private ISuperPlayer d;
  private int daY;
  private ViewGroup eg;
  private RelativeLayout kD;
  private RelativeLayout kE;
  private ViewGroup.LayoutParams l;
  private boolean mIsFullScreen;
  private boolean mIsMute;
  private boolean mNeedReport;
  private ViewGroup mParentView;
  private long mPlayTime;
  private TextView mProgressTime;
  private FrameLayout mRootView;
  private int mSrc;
  private Handler mUiHandler = new Handler(Looper.getMainLooper(), this);
  private FrameLayout mVideoContainer;
  private TextView mVideoDuration;
  private View mVideoView;
  private SeekBar r;
  private ImageView ue;
  
  public GameCenterVideoViewController(@NonNull Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public GameCenterVideoViewController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public GameCenterVideoViewController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void aav()
  {
    if (!allf.isSDKReady()) {
      allf.a(BaseApplication.getContext(), new ahsy(this));
    }
  }
  
  public static Activity b(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper)) {
      return b(((ContextWrapper)paramContext).getBaseContext());
    }
    return null;
  }
  
  private void dpL()
  {
    this.r.setProgress((int)this.d.getCurrentPositionMs());
    this.mProgressTime.setText(kwz.ba((int)this.d.getCurrentPositionMs() / 1000));
  }
  
  private void initView()
  {
    aav();
    this.mRootView = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131559380, this));
    this.mVideoContainer = ((FrameLayout)this.mRootView.findViewById(2131381636));
    this.kD = ((RelativeLayout)this.mRootView.findViewById(2131371170));
    this.bk = ((URLImageView)this.mRootView.findViewById(2131372700));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage = ((VideoLoadingImage)this.mRootView.findViewById(2131361810));
    this.mProgressTime = ((TextView)this.mRootView.findViewById(2131373694));
    this.mVideoDuration = ((TextView)this.mRootView.findViewById(2131366158));
    this.r = ((SeekBar)this.mRootView.findViewById(2131369275));
    this.ue = ((ImageView)this.mRootView.findViewById(2131381874));
    this.Aq = ((ImageView)this.mRootView.findViewById(2131367811));
    this.kE = ((RelativeLayout)this.mRootView.findViewById(2131372759));
    this.bl = ((URLImageView)this.mRootView.findViewById(2131365488));
    this.kE.setVisibility(8);
    this.mRootView.setOnClickListener(this);
    this.bk.setOnClickListener(this);
    this.r.setOnSeekBarChangeListener(this);
    this.ue.setOnClickListener(this);
    this.Aq.setOnClickListener(this);
  }
  
  public void aUp()
  {
    this.mUiHandler.removeMessages(9);
    this.mUiHandler.sendEmptyMessageDelayed(9, 300L);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController$a.al(false, this.daY);
  }
  
  public void aVf()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "enterFullScreen");
    this.mUiHandler.removeMessages(8);
    this.mUiHandler.sendEmptyMessageDelayed(8, 300L);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController$a.al(true, this.daY);
  }
  
  public View al()
  {
    com.tencent.qphone.base.util.QLog.i("GameCenterVideoViewController", 1, "[createVideoPlayer]");
    if (!allf.isSDKReady())
    {
      com.tencent.TMG.utils.QLog.w("GameCenterVideoViewController", 1, "sdk NOT installed.");
      return null;
    }
    ISPlayerVideoView localISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
    this.d = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 106, localISPlayerVideoView);
    if (this.d == null)
    {
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[createVideoView] create media player fail.");
      return null;
    }
    this.d.setOnCompletionListener(this);
    this.d.setOnVideoPreparedListener(this);
    this.d.setOnErrorListener(this);
    this.d.setOnSeekCompleteListener(this);
    return (View)localISPlayerVideoView;
  }
  
  public void dpM()
  {
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[updateControlPanle] " + this.bp.get());
    this.mUiHandler.removeMessages(4);
    this.mUiHandler.sendEmptyMessage(4);
  }
  
  public void dpN()
  {
    this.mUiHandler.removeMessages(13);
    this.mUiHandler.sendEmptyMessage(13);
  }
  
  public void dpO()
  {
    if ((aqiw.isNetworkAvailable(getContext())) && (aqiw.isWifiConnected(getContext())))
    {
      this.anS = true;
      arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      i = getHeight();
      localDisplayMetrics = getResources().getDisplayMetrics();
      if ((arrayOfInt[1] > wja.dp2px(50.0F, getResources())) && (arrayOfInt[1] + i < (i + localDisplayMetrics.heightPixels) / 2 + wja.dp2px(50.0F, getResources())) && (this.bp.get() == 0))
      {
        this.mUiHandler.removeMessages(13);
        this.mUiHandler.sendEmptyMessage(13);
        setMute(ahtz.cij);
      }
    }
    while (!com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      int[] arrayOfInt;
      int i;
      DisplayMetrics localDisplayMetrics;
      return;
    }
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 1, "[checkAndPlay] network err or not wifi,auto play failed.");
  }
  
  public void dpP()
  {
    this.mUiHandler.removeMessages(1);
    Message localMessage = Message.obtain(this.mUiHandler, 1);
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void dpQ()
  {
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[hideControlPanel] hide");
    this.mUiHandler.removeMessages(2);
    Message localMessage = Message.obtain(this.mUiHandler, 2);
    this.mUiHandler.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void dpR()
  {
    this.mNeedReport = true;
  }
  
  public void dpS()
  {
    this.cic = true;
    this.mUiHandler.sendEmptyMessage(12);
  }
  
  public void dpT()
  {
    this.cid = true;
    this.mUiHandler.sendEmptyMessage(11);
  }
  
  public long getCurrentPostion()
  {
    if (this.d == null) {
      return 0L;
    }
    return this.d.getCurrentPositionMs();
  }
  
  public long getDuration()
  {
    if (this.d == null) {
      return 0L;
    }
    return this.d.getDurationMs();
  }
  
  public boolean getOutputMute()
  {
    if (this.d != null) {
      return this.d.isOutputMute();
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    case 6: 
    default: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (this.bp.get() != 0)
              {
                this.kD.setVisibility(0);
                if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 1)
                {
                  this.mProgressTime.setVisibility(4);
                  this.r.setVisibility(4);
                  this.mVideoDuration.setVisibility(4);
                }
                if (this.cid) {
                  this.ue.setVisibility(0);
                }
                if (this.cic) {
                  this.Aq.setVisibility(0);
                }
              }
              this.bk.setVisibility(0);
              dpQ();
              return false;
            } while (this.bp.get() == 5);
            this.kD.setVisibility(8);
          } while (this.bp.get() == 0);
          this.bk.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
          return false;
          if (this.bp.get() == 3)
          {
            paramMessage = URLDrawable.URLDrawableOptions.obtain();
            paramMessage.mLoadingDrawable = getResources().getDrawable(2130844048);
            paramMessage.mFailedDrawable = getResources().getDrawable(2130844048);
            paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_stop@2x.png");
            this.bk.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
            this.bk.setImageDrawable(paramMessage);
            dpP();
            this.bl.setVisibility(8);
            return false;
          }
          if (this.bp.get() == 0)
          {
            paramMessage = URLDrawable.URLDrawableOptions.obtain();
            paramMessage.mLoadingDrawable = getResources().getDrawable(2130844049);
            paramMessage.mFailedDrawable = getResources().getDrawable(2130844049);
            paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", paramMessage);
            this.bk.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
            this.bk.setImageDrawable(paramMessage);
            this.bl.setVisibility(0);
            try
            {
              this.bl.setImageURL(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.coverImgUrl);
              this.kD.setVisibility(8);
              this.mProgressTime.setText(kwz.ba(0));
              paramMessage = kwz.ba(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoDuration);
              this.mVideoDuration.setText(paramMessage);
              return false;
            }
            catch (Exception paramMessage)
            {
              for (;;)
              {
                com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, paramMessage, new Object[0]);
              }
            }
          }
          if (this.bp.get() == 5)
          {
            paramMessage = URLDrawable.URLDrawableOptions.obtain();
            paramMessage.mLoadingDrawable = getResources().getDrawable(2130844048);
            paramMessage.mFailedDrawable = getResources().getDrawable(2130844048);
            paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", paramMessage);
            this.bk.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
            this.bk.setImageDrawable(paramMessage);
            return false;
          }
          paramMessage = URLDrawable.URLDrawableOptions.obtain();
          paramMessage.mLoadingDrawable = getResources().getDrawable(2130844049);
          paramMessage.mFailedDrawable = getResources().getDrawable(2130844049);
          paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", paramMessage);
          this.bk.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
          this.bk.setImageDrawable(paramMessage);
          return false;
          this.mUiHandler.sendEmptyMessageDelayed(5, 1000L);
          dpL();
          return false;
          this.kE.setVisibility(0);
          return false;
        } while (this.mIsFullScreen);
        if (this.mParentView == null)
        {
          this.mParentView = ((ViewGroup)getParent());
          this.eg = ((ViewGroup)b(getContext()).findViewById(16908290));
        }
        b(getContext()).getWindow().setFlags(1024, 1024);
        this.l = getLayoutParams();
        this.mParentView.removeView(this);
        paramMessage = new FrameLayout.LayoutParams(-1, -1);
        this.eg.addView(this, paramMessage);
        this.d.setXYaxis(2);
        this.Aq.setImageResource(2130842612);
        this.mIsFullScreen = true;
        return false;
      } while (!this.mIsFullScreen);
      this.eg.removeView(this);
      this.mParentView.addView(this, this.l);
      b(getContext()).getWindow().clearFlags(1024);
      this.d.setXYaxis(0);
      this.Aq.setImageResource(2130842613);
      this.mIsFullScreen = false;
      return false;
    case 10: 
      if (this.d.isOutputMute())
      {
        this.ue.setImageResource(2130843886);
        return false;
      }
      this.ue.setImageResource(2130843887);
      return false;
    case 12: 
      this.Aq.setVisibility(0);
      return false;
    case 11: 
      this.ue.setVisibility(0);
      return false;
    case 13: 
      if (this.bp.get() == 0)
      {
        if ((this.mNeedReport) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData != null))
        {
          paramMessage = new HashMap();
          tbb.b(paramMessage, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          paramMessage.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          paramMessage.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          paramMessage.put(Integer.valueOf(4), "20");
          paramMessage.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          paramMessage.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          tbb.a(abmt.getAppInterface(), "769", "205020", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", paramMessage);
        }
        ahsx.a().a(this);
        this.bk.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(0);
        play();
        return false;
      }
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[handleMessage] autoplay mCurrentStatus:" + this.bp.get());
      return false;
    }
    awot.a().abY(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId);
    return false;
  }
  
  public boolean isFullScreenMode()
  {
    return this.mIsFullScreen;
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      if (this.kD.getVisibility() != 0) {
        dpP();
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      HashMap localHashMap;
      if (this.bp.get() == 0)
      {
        if ((this.mNeedReport) && (!this.anS))
        {
          localHashMap = new HashMap();
          tbb.b(localHashMap, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          localHashMap.put(Integer.valueOf(4), "20");
          localHashMap.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          localHashMap.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          tbb.a(abmt.getAppInterface(), "769", "205023", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
        }
        ahsx.a().a(this);
        this.bk.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(0);
        play();
      }
      else if (this.bp.get() == 3)
      {
        if (this.mNeedReport)
        {
          localHashMap = new HashMap();
          tbb.b(localHashMap, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          localHashMap.put(Integer.valueOf(4), "20");
          localHashMap.put(Integer.valueOf(42), getCurrentPostion() + "");
          localHashMap.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          localHashMap.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          tbb.a(abmt.getAppInterface(), "769", "205034", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
        }
        pause();
      }
      else if (this.bp.get() == 5)
      {
        if (this.mNeedReport)
        {
          localHashMap = new HashMap();
          tbb.b(localHashMap, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          localHashMap.put(Integer.valueOf(4), "20");
          localHashMap.put(Integer.valueOf(42), getCurrentPostion() + "");
          localHashMap.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          localHashMap.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          tbb.a(abmt.getAppInterface(), "769", "205034", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
        }
        if ((this.mSrc == 2) && (daZ == 0))
        {
          this.mUiHandler.removeMessages(14);
          this.mUiHandler.sendEmptyMessageDelayed(14, ahty.dbc - this.mPlayTime);
        }
        start();
        continue;
        if (this.d != null)
        {
          if (!this.d.isOutputMute()) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            ahtz.cij = bool1;
            bool1 = bool2;
            if (!this.d.isOutputMute()) {
              bool1 = true;
            }
            setMute(bool1);
            break;
          }
          if (this.mIsFullScreen) {
            aUp();
          } else {
            aVf();
          }
        }
      }
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    setCurrentStatus(7);
    stop();
    release();
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    release();
    ThreadManagerV2.getUIHandlerV2().post(new GameCenterVideoViewController.2(this));
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[onError] " + paramInt1 + ", " + paramInt2 + ", " + paramInt3);
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    start();
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "onStopTrackingTouch(): progress=" + i);
    }
    if (this.d != null) {
      this.d.seekTo(i);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    ThreadManagerV2.getUIHandlerV2().post(new GameCenterVideoViewController.3(this));
  }
  
  public void pause()
  {
    this.mUiHandler.removeMessages(5);
    if ((this.mSrc == 2) && (daZ == 0)) {
      this.mUiHandler.removeMessages(14);
    }
    this.mPlayTime += System.currentTimeMillis() - this.aaS;
    if (this.d != null)
    {
      this.d.pause();
      setCurrentStatus(5);
      dpM();
    }
  }
  
  public void play()
  {
    if (this.bp.get() == 5)
    {
      start();
      if ((this.mSrc == 2) && (daZ == 0))
      {
        this.mUiHandler.removeMessages(14);
        this.mUiHandler.sendEmptyMessageDelayed(14, ahty.dbc - this.mPlayTime);
      }
      return;
    }
    if (!aqiw.isNetworkAvailable(getContext()))
    {
      ThreadManagerV2.getUIHandlerV2().post(new GameCenterVideoViewController.4(this));
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "commentReport network error, stop request.");
      setCurrentStatus(0);
      dpM();
      return;
    }
    SuperPlayerVideoInfo localSuperPlayerVideoInfo;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl)) {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 1)
      {
        localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(30301, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoVid);
        this.mVideoView = al();
        if (this.mVideoView != null) {
          this.mVideoContainer.addView(this.mVideoView, -1, -1);
        }
        if (this.d == null) {
          break label272;
        }
        setCurrentStatus(1);
        this.d.openMediaPlayer(getContext(), localSuperPlayerVideoInfo, 0L);
      }
    }
    for (;;)
    {
      setMute(this.mIsMute);
      return;
      localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(30301, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoVid);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 1)
      {
        localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl, 201, "");
        break;
      }
      localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl, 101, "");
      break;
      label272:
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[play] mVideoPlayer is null");
    }
  }
  
  public void release()
  {
    setCurrentStatus(0);
    if (this.d != null)
    {
      this.d.stop();
      this.d.release();
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[release] release video ok:" + this.d.toString());
    }
    this.mUiHandler.removeCallbacksAndMessages(null);
    dpM();
  }
  
  public void setBgTransparent()
  {
    this.mRootView.setBackgroundColor(0);
  }
  
  public void setCurrentStatus(int paramInt)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "[setCurrentStatus] status:" + paramInt + ", obj:" + this);
    }
    this.bp.set(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController$a.eM(paramInt, this.daY);
    }
  }
  
  public void setData(FeedsItemData paramFeedsItemData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData = paramFeedsItemData;
    this.mSrc = paramInt;
    dpM();
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
    if (this.d != null)
    {
      this.d.setOutputMute(paramBoolean);
      this.mUiHandler.removeMessages(10);
      this.mUiHandler.sendEmptyMessage(10);
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController$a.am(paramBoolean, this.daY);
      }
    }
  }
  
  public void setVideoId(int paramInt)
  {
    this.daY = paramInt;
  }
  
  public void setVideoStatusChangerListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController$a = parama;
  }
  
  public void start()
  {
    if (this.d != null)
    {
      this.d.start();
      setCurrentStatus(3);
      dpM();
      this.aaS = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 2) {
        this.mUiHandler.sendEmptyMessage(5);
      }
    }
  }
  
  public void stop()
  {
    if ((this.d != null) && (this.bp.get() != 0))
    {
      if ((this.anS) && (this.mNeedReport))
      {
        HashMap localHashMap = new HashMap();
        tbb.b(localHashMap, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
        localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
        localHashMap.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
        localHashMap.put(Integer.valueOf(4), "-1");
        localHashMap.put(Integer.valueOf(42), getCurrentPostion() + "");
        localHashMap.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
        localHashMap.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
        tbb.a(abmt.getAppInterface(), "769", "205026", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
      }
      this.d.stop();
      setCurrentStatus(0);
      dpM();
    }
  }
  
  public static abstract interface a
  {
    public abstract void al(boolean paramBoolean, int paramInt);
    
    public abstract void am(boolean paramBoolean, int paramInt);
    
    public abstract void eM(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
 * JD-Core Version:    0.7.0.1
 */