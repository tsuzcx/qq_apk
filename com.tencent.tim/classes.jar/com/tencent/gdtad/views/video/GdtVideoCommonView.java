package com.tencent.gdtad.views.video;

import acfp;
import ahao;
import allf;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import aqbn;
import aqiw;
import com.tencent.ad.tangram.Ad;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import jzk;
import tjm;
import tll;
import tls;
import tmk;
import tml;
import tmm;
import tmn;
import wja;

public class GdtVideoCommonView
  extends RelativeLayout
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener
{
  private TextView Bs;
  private TextView Bt;
  private TextView Bu;
  private TextView Bv;
  private long Ex;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private a jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$a;
  private b jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$b;
  private c jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$c;
  private d jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$d;
  private GdtVideoData jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new tmm(this);
  private tjm jdField_a_of_type_Tjm;
  private tmn jdField_a_of_type_Tmn;
  private int aEt;
  private boolean aPA;
  private boolean aPB;
  private volatile boolean aPC;
  private boolean aPD;
  private boolean aPE;
  private boolean aPF;
  public boolean aPq;
  public boolean aPr;
  private boolean aPs = true;
  private boolean aPx;
  private boolean aPy;
  private boolean aPz;
  private AudioManager audioManager;
  private int bCb = 10000;
  private int bCc = -1;
  private int bCd;
  private int bCe;
  private int bCf;
  private int bCg;
  private int bCh;
  private int bCi;
  private int bCj = -16777216;
  private Button cL;
  private Button cM;
  private SeekBar jdField_d_of_type_AndroidWidgetSeekBar;
  private ISuperPlayer jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer;
  private Runnable dE = new GdtVideoCommonView.6(this);
  private Runnable dF = new GdtVideoCommonView.8(this);
  private LinearLayout fI;
  private RelativeLayout gj;
  public String index = "0";
  private boolean isVolumOpen = true;
  private long ix = -1L;
  private View jl;
  private SeekBar k;
  private Context mContext;
  private Handler mHandler;
  private boolean mIsFullScreen;
  private int mLastWidth;
  private View mLoadingView;
  private long mVideoDuration = -1L;
  private long mVideoSize;
  private ISPlayerVideoView mVideoView;
  private int netType = 0;
  private ArrayList<e> oC = new ArrayList();
  private ImageView pb;
  private ImageView pc;
  private ImageView pd;
  private ImageView pe;
  private ImageView pf;
  private Runnable progressTask = new GdtVideoCommonView.7(this);
  private View rc;
  private View rd;
  private View re;
  private View rf;
  
  public GdtVideoCommonView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131559384, this);
    bDH();
  }
  
  public GdtVideoCommonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131559384, this);
    bDH();
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) || (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer == null)) {
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "setStateOfMediaSound volume =" + paramInt + " viewReusmed " + paramBoolean1 + " isFromVolumeChanged " + paramBoolean2 + " isSilentMode = " + this.aPr + ", isVolumOpen = " + this.isVolumOpen + ", hasNotifyCompleted = " + this.aPF + "，isOutputMute = " + paramBoolean3);
    if (paramInt > 0) {
      if ((!paramBoolean3) || (paramBoolean2))
      {
        this.pf.setBackgroundResource(2130841146);
        this.isVolumOpen = true;
        if (AppSetting.enableTalkBack) {
          this.pf.setContentDescription(acfp.m(2131706920));
        }
      }
    }
    for (;;)
    {
      if ((this.aEt != 6) && (this.aEt != 8) && (this.aEt != 7)) {
        vu(this.isVolumOpen);
      }
      bDU();
      return;
      this.isVolumOpen = false;
      this.pf.setBackgroundResource(2130841145);
      continue;
      this.pf.setBackgroundResource(2130841145);
      this.isVolumOpen = false;
      if (AppSetting.enableTalkBack) {
        this.pf.setContentDescription(acfp.m(2131706926));
      }
    }
  }
  
  private void bDH()
  {
    if (aqiw.isWifiEnabled(this.mContext)) {
      this.netType = 1;
    }
    for (;;)
    {
      QLog.i("GdtVideoCommonView", 1, "netType " + this.netType);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)findViewById(2131367935));
      this.mLoadingView = findViewById(2131370820);
      this.jl = findViewById(2131366694);
      this.rf = findViewById(2131367939);
      this.fI = ((LinearLayout)findViewById(2131367931));
      this.pe = ((ImageView)findViewById(2131367929));
      this.pd = ((ImageView)findViewById(2131367930));
      this.Bv = ((TextView)findViewById(2131373666));
      this.jdField_d_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131377914));
      this.k = ((SeekBar)findViewById(2131377916));
      this.jdField_d_of_type_AndroidWidgetSeekBar.setMax(this.bCb);
      this.k.setMax(this.bCb);
      this.Bu = ((TextView)findViewById(2131380108));
      int i = tls.dp2px(5.0F, getResources());
      this.pf = ((ImageView)findViewById(2131367938));
      tls.i(this.pf, i, i, i, i);
      this.pb = ((ImageView)findViewById(2131367936));
      tls.i(this.pb, i, i, i, i);
      this.pb.setOnClickListener(this);
      this.gj = ((RelativeLayout)findViewById(2131364677));
      this.gj.setOnClickListener(this);
      this.rd = findViewById(2131367934);
      this.Bs = ((TextView)findViewById(2131367932));
      this.Bs.setOnClickListener(this);
      this.rc = findViewById(2131367933);
      this.rc.setOnClickListener(this);
      this.pe.setOnClickListener(this);
      this.rf.setOnClickListener(this);
      this.pf.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jl.setOnClickListener(this);
      this.pd.setOnClickListener(this);
      this.audioManager = ((AudioManager)getContext().getSystemService("audio"));
      ((Activity)this.mContext).setVolumeControlStream(3);
      this.jdField_a_of_type_Tjm = new tjm(this.mContext);
      this.jdField_a_of_type_Tjm.registerReceiver();
      this.jdField_a_of_type_Tjm.a(new tmk(this));
      AppNetConnInfo.registerConnectionChangeReceiver(this.mContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$a = new a(null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.mContext.registerReceiver(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$a, localIntentFilter);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$c = new c(null);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.mContext.registerReceiver(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$c, localIntentFilter);
      this.re = findViewById(2131362852);
      this.cL = ((Button)findViewById(2131367904));
      this.cM = ((Button)findViewById(2131367902));
      this.Bt = ((TextView)findViewById(2131367905));
      this.pc = ((ImageView)findViewById(2131367903));
      this.cL.setOnClickListener(this);
      this.cM.setOnClickListener(this);
      bDI();
      return;
      if (aqiw.isNetSupport(this.mContext)) {
        this.netType = 2;
      }
    }
  }
  
  private void bDJ()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || ((localObject instanceof QQAppInterface)) || (AppSetting.enableTalkBack)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = (AccessibilityManager)this.mContext.getSystemService("accessibility");
        bool1 = ((AccessibilityManager)localObject).isEnabled();
        boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          bool1 = true;
          AppSetting.enableTalkBack = bool1;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GdtVideoCommonView", 1, "initAppSettingInOntherProcess", localThrowable);
        return;
      }
      boolean bool1 = false;
    }
  }
  
  private void bDL()
  {
    if ((!isFullScreen()) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData != null) && (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop()) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getProductType() != 19))
    {
      this.mLoadingView.setVisibility(8);
      this.jl.setVisibility(8);
      this.pe.setVisibility(8);
      this.fI.setVisibility(4);
      this.pf.setVisibility(4);
      this.pd.setVisibility(8);
      bDS();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.re.setVisibility(0);
      bDM();
    }
    for (;;)
    {
      bDU();
      return;
      this.re.setVisibility(8);
      this.mLoadingView.setVisibility(8);
      this.jl.setVisibility(8);
      this.pe.setVisibility(8);
      this.pf.setVisibility(4);
      bDS();
      if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene() == 7) && (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null))
      {
        bDK();
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
        this.pd.setVisibility(0);
      }
    }
  }
  
  private void bDM()
  {
    if ((this.re.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData != null))
    {
      QLog.i("GdtVideoCommonView", 1, "updateDownloadBtnLable " + this.index);
      if (!(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd() instanceof GdtAd)) {
        break label104;
      }
    }
    label104:
    for (GdtAd localGdtAd = (GdtAd)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd(); localGdtAd == null; localGdtAd = null)
    {
      QLog.i("GdtVideoCommonView", 1, "updateDownloadBtnLable gdtAd == null " + this.index);
      return;
    }
    if (localGdtAd.isAppProductType())
    {
      String str = localGdtAd.getAppPackageName();
      if (jzk.C(this.mContext, str))
      {
        this.cM.setText(acfp.m(2131706924));
        return;
      }
      if (tll.J(this.mContext, localGdtAd.getAppPackageName()))
      {
        this.cM.setText(acfp.m(2131706917));
        return;
      }
      this.cM.setText(acfp.m(2131706921));
      return;
    }
    this.cM.setText(acfp.m(2131706927));
  }
  
  private void bDN()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData == null) || (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer == null))
    {
      QLog.i("GdtVideoCommonView", 1, "setVideoPlayByData failed");
      return;
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop()) {
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(true);
    }
    for (;;)
    {
      QLog.i("GdtVideoCommonView", 1, "setVideoPlayByData dataLoop=" + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop() + ",videoLoop = " + this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.isLoopBack());
      return;
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(false);
    }
  }
  
  private void bDO()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.mHandler.post(new GdtVideoCommonView.5(this));
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "doStartPlay " + this.index);
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer == null)
    {
      QLog.i("GdtVideoCommonView", 1, "doStartPlay return mVideoPlayer == null");
      return;
    }
    if (this.aPr)
    {
      QLog.i("GdtVideoCommonView", 1, "doStartPlay isSilentMode is true");
      this.isVolumOpen = false;
    }
    ISuperPlayer localISuperPlayer = this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer;
    int i;
    if (!this.isVolumOpen)
    {
      bool = true;
      localISuperPlayer.setOutputMute(bool);
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      this.aEt = 5;
      updateView();
      i = this.audioManager.getStreamVolume(3);
      if (this.isVolumOpen) {
        break label164;
      }
    }
    label164:
    for (boolean bool = true;; bool = false)
    {
      a(i, true, false, bool);
      return;
      bool = false;
      break;
    }
  }
  
  private void bDQ()
  {
    if (EF())
    {
      QLog.i("GdtVideoCommonView", 1, "pauseVideoInternal " + this.index);
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
      this.aEt = 6;
      this.mHandler.removeCallbacksAndMessages(null);
      updateView();
    }
    for (;;)
    {
      vu(false);
      return;
      QLog.i("GdtVideoCommonView", 1, "pauseVideoInternal return " + this.index);
    }
  }
  
  private void bDR()
  {
    QLog.i("GdtVideoCommonView", 1, "resumeVideByNet netType " + this.netType + " " + this.index);
    switch (this.netType)
    {
    default: 
      return;
    case 0: 
      ahao.OS(2131689700);
      this.aEt = 8;
      updateView();
      return;
    case 1: 
      bDO();
      return;
    }
    if (this.aPy)
    {
      bDO();
      return;
    }
    this.mHandler.removeCallbacks(this.dE);
    this.mHandler.postDelayed(this.dE, 500L);
  }
  
  private void bDS()
  {
    this.rd.setVisibility(8);
  }
  
  private void bDT()
  {
    this.aPq = true;
  }
  
  private void bDU()
  {
    if (this.aPE)
    {
      this.k.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.fI.setVisibility(8);
      this.pe.setVisibility(8);
      findViewById(2131370650).setVisibility(8);
      this.pf.setVisibility(8);
      this.pd.setVisibility(8);
    }
  }
  
  private void bDV()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new GdtVideoCommonView.10(this));
    }
  }
  
  private void bDW()
  {
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      QLog.i("GdtVideoCommonView", 1, "checkIsCompleted return mVideoPlayer == null");
    }
    long l;
    do
    {
      return;
      l = this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    } while ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop()) || (!this.aPq));
    if (Math.abs(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() - l) < 1000L) {
      if (!this.aPF) {
        bDX();
      }
    }
    for (this.aPF = true;; this.aPF = false)
    {
      this.mHandler.postDelayed(new GdtVideoCommonView.11(this), 300L);
      return;
    }
  }
  
  private void bDX()
  {
    Iterator localIterator = this.oC.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).i(this);
    }
    vu(false);
  }
  
  private void cX(Context paramContext)
  {
    this.aEt = 1;
    try
    {
      allf.a(BaseApplicationImpl.getApplication(), new tml(this, paramContext));
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private void cY(Context paramContext)
  {
    QLog.i("GdtVideoCommonView", 1, "initVideo " + this.index);
    this.aEt = 2;
    this.mVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
    if (this.mVideoView != null)
    {
      setBackgroundColor(this.bCj);
      if (!(this.mVideoView instanceof View)) {
        break label137;
      }
      paramContext = (View)this.mVideoView;
      paramContext.setBackgroundColor(this.bCj);
      paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      addView(paramContext, 0);
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 110, this.mVideoView);
      if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
        break;
      }
      QLog.i("GdtVideoCommonView", 1, "initVideo return mVideoPlayer == null");
      return;
      label137:
      QLog.i("GdtVideoCommonView", 1, "!mVideoView instanceof View)");
    }
    this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
    this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
    this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnTVideoNetInfoUpdateListener(this);
    this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    bDN();
    QLog.i("GdtVideoCommonView", 1, "initVideo isSilentMode = " + this.aPr + ", isVolumOpen = " + this.isVolumOpen);
    if (this.aPr) {
      this.isVolumOpen = false;
    }
    paramContext = this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer;
    int i;
    if (!this.isVolumOpen)
    {
      bool = true;
      paramContext.setOutputMute(bool);
      i = this.audioManager.getStreamVolume(3);
      if (this.isVolumOpen) {
        break label308;
      }
    }
    label308:
    for (boolean bool = true;; bool = false)
    {
      a(i, true, false, bool);
      fA(this.Ex);
      return;
      bool = false;
      break;
    }
  }
  
  private void ep(View paramView)
  {
    Iterator localIterator = this.oC.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).eq(paramView);
    }
  }
  
  private void fA(long paramLong)
  {
    QLog.i("GdtVideoCommonView", 1, "playVideo startElapsed -->" + paramLong + "|" + this.aEt + " " + this.index);
    String str;
    if ((this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (!this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()) && (this.aEt != 3))
    {
      this.aEt = 3;
      localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getTencent_video_id();
      str = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getUrl();
      QLog.i("GdtVideoCommonView", 1, "playVideo url=" + str + ",vid=" + (String)localObject);
      if (TextUtils.isEmpty(str)) {
        break label222;
      }
    }
    for (Object localObject = SuperPlayerFactory.createVideoInfoForUrl(str, 104, (String)localObject, null);; localObject = SuperPlayerFactory.createVideoInfoForTVideo((String)localObject))
    {
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.reset();
      bDN();
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(this.mContext, (SuperPlayerVideoInfo)localObject, paramLong);
      if (this.aEt != 8) {
        break;
      }
      QLog.i("GdtVideoCommonView", 1, "playVideo STATE_ERROR return -->" + paramLong);
      label222:
      do
      {
        return;
      } while (TextUtils.isEmpty((CharSequence)localObject));
    }
    updateView();
  }
  
  private void initSDK(Context paramContext)
  {
    if (allf.isSDKReady())
    {
      cY(paramContext);
      return;
    }
    cX(paramContext);
  }
  
  private void notifyError()
  {
    vu(false);
  }
  
  private void notifyStarted()
  {
    if (this.jdField_a_of_type_Tmn != null)
    {
      if (this.bCc <= 0) {
        break label74;
      }
      this.jdField_a_of_type_Tmn.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.bCc);
      this.bCc = -1;
    }
    for (;;)
    {
      bDW();
      Iterator localIterator = this.oC.iterator();
      while (localIterator.hasNext())
      {
        ((e)localIterator.next()).g(this);
        continue;
        label74:
        if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
          break label91;
        }
        QLog.i("GdtVideoCommonView", 1, "notifyStarted return mVideoPlayer == null");
      }
      return;
      label91:
      this.jdField_a_of_type_Tmn.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
    }
  }
  
  private void notifyStopped()
  {
    Iterator localIterator = this.oC.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).h(this);
    }
    vu(false);
  }
  
  private void vu(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.i("GdtVideoCommonView", 1, "[requestSystemAudioFocus] gain is called!");
      this.audioManager.requestAudioFocus(null, 3, 2);
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "[requestSystemAudioFocus] release is called!");
    this.audioManager.abandonAudioFocus(null);
  }
  
  private void vx(boolean paramBoolean)
  {
    QLog.i("GdtVideoCommonView", 1, "letsShowOff " + paramBoolean + " " + this.index + " mVideoState " + this.aEt);
    if (this.aEt != 5) {
      return;
    }
    this.mHandler.removeCallbacks(this.dF);
    if (paramBoolean)
    {
      this.k.setVisibility(4);
      this.fI.setVisibility(0);
      this.pe.setVisibility(0);
      this.mHandler.postDelayed(this.dF, 2000L);
    }
    for (;;)
    {
      bDU();
      return;
      this.k.setVisibility(0);
      this.fI.setVisibility(8);
      this.pe.setVisibility(8);
    }
  }
  
  public boolean EF()
  {
    return (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.aEt == 5);
  }
  
  public void a(e parame)
  {
    if (!this.oC.contains(parame)) {
      this.oC.add(parame);
    }
  }
  
  public void azR()
  {
    QLog.i("GdtVideoCommonView", 1, "releaseMediaPlayer");
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer = null;
    }
  }
  
  public void bDI()
  {
    bDJ();
    if (AppSetting.enableTalkBack)
    {
      this.pd.setContentDescription(acfp.m(2131706928));
      this.jdField_d_of_type_AndroidWidgetSeekBar.setContentDescription(acfp.m(2131706929));
    }
  }
  
  public void bDK()
  {
    this.aPz = false;
    this.aPy = true;
    bDT();
    if ((this.aEt == 6) || (this.aEt == 4))
    {
      l(2, this.aPq, false);
      return;
    }
    fA(this.Ex);
  }
  
  public void bDP()
  {
    this.aPz = true;
    bDQ();
  }
  
  public long getCurrentPosition()
  {
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      return 0L;
    }
    return this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
  }
  
  public boolean isFullScreen()
  {
    return this.mIsFullScreen;
  }
  
  public void l(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" doResumeVideo " + paramInt);
    localStringBuilder.append(" isViewResume " + paramBoolean1);
    localStringBuilder.append(" stopPlayByUser " + paramBoolean2);
    localStringBuilder.append(" mVideoState " + this.aEt + " " + this.index);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    if ((paramBoolean2) || (!paramBoolean1)) {
      return;
    }
    switch (this.aEt)
    {
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    default: 
      return;
    }
    bDR();
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.ix < 350L) {
      QLog.i("GdtVideoCommonView", 1, "onClick too fast not allowed  " + this.index);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.ix = l;
      label243:
      Activity localActivity;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364677: 
        QLog.i("GdtVideoCommonView", 1, "onClick  closeBtn exitFullScreen " + this.mIsFullScreen + " " + this.index);
        if (this.mIsFullScreen)
        {
          if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$d == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$d.aUp();
        }
        break;
      case 2131367939: 
        int i;
        if (this.pe.getVisibility() == 0)
        {
          i = 1;
          if (i != 0) {
            break label269;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          vx(bool);
          ep(paramView);
          break;
          i = 0;
          break label243;
        }
      case 2131367930: 
        QLog.i("GdtVideoCommonView", 1, "onClick  gdt_video_center_play mVideoState " + this.aEt + " " + this.index);
        bDK();
        break;
      case 2131367929: 
        QLog.i("GdtVideoCommonView", 1, "onClick  gdt_video_center_pause mVideoState " + this.aEt + " " + this.index);
        bDP();
        break;
      case 2131367938: 
        if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer == null)
        {
          QLog.i("GdtVideoCommonView", 1, "gdt_video_volume_switch click return mVideoPlayer == null");
        }
        else if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.isOutputMute())
        {
          this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(false);
          a(1, true, false, false);
        }
        else
        {
          this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(true);
          a(0, true, false, true);
        }
        break;
      case 2131366694: 
        fA(this.Ex);
        break;
      case 2131367936: 
        if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$d != null) {
          if (this.mIsFullScreen) {
            this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$d.aUp();
          } else {
            this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$d.aVf();
          }
        }
        break;
      case 2131367932: 
      case 2131367933: 
        bDK();
        continue;
        if (this.mContext != null)
        {
          localActivity = (Activity)this.mContext;
          localActivity.finish();
          localActivity.overridePendingTransition(17432576, 17432577);
        }
        break;
      case 2131367904: 
        QLog.i("GdtVideoCommonView", 1, "click playagain mVideoState " + this.aEt + " " + this.index);
        this.re.setVisibility(8);
        bDK();
        break;
      case 2131367902: 
        label269:
        QLog.i("GdtVideoCommonView", 1, "click download mVideoState " + this.aEt + " " + this.index);
        if ((this.mContext != null) && ((this.mContext instanceof Activity)))
        {
          localActivity = (Activity)this.mContext;
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.processId = 7;
          localParams.activity = new WeakReference(localActivity);
          localParams.ad = ((GdtAd)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd());
          localParams.reportForClick = false;
          localParams.aOV = true;
          GdtHandler.a(localParams);
        }
        break;
      }
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.aEt = 7;
    updateView();
    QLog.i("GdtVideoCommonView", 1, "onCompletion" + this.aEt);
  }
  
  public void onDestroy()
  {
    QLog.i("GdtVideoCommonView", 1, "onDestroy");
    azR();
    this.mHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Tjm != null) {
      this.jdField_a_of_type_Tjm.unregisterReceiver();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if ((this.mContext != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$a != null)) {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$a);
    }
    if ((this.mContext != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$c != null)) {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$c);
    }
    if (this.jdField_a_of_type_Tmn != null) {
      this.jdField_a_of_type_Tmn = null;
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.i("GdtVideoCommonView", 1, "onError errorType " + paramInt2 + " errorCode " + paramInt3 + " extraInfo " + paramString);
    this.aEt = 8;
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$b != null) && (!this.aPB))
    {
      this.aPB = true;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$b.vy(false);
    }
    Toast.makeText(this.mContext, acfp.m(2131706918), 0).show();
    updateView();
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.aPx = true;
      this.Bv.setText(tls.aQ(paramInt * this.mVideoDuration / this.bCb));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.i("GdtVideoCommonView", 1, "onStartTrackingTouch " + this.aEt);
    this.mHandler.removeCallbacksAndMessages(null);
    this.aPx = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch " + this.aEt);
    this.aPx = false;
    this.bCc = ((int)(paramSeekBar.getProgress() * this.mVideoDuration / this.bCb));
    bDT();
    if ((this.aEt < 4) || (this.aEt > 6)) {
      fA(this.bCc);
    }
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer == null)
      {
        QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch return mVideoPlayer == null");
      }
      else if ((this.aEt == 6) || (this.aEt == 5) || (this.aEt == 4))
      {
        if ((this.aEt == 4) || (this.aEt == 6)) {
          this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.start();
        }
        this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(this.bCc);
        this.aEt = 5;
        updateView();
      }
      else
      {
        QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch no answer " + this.aEt);
      }
    }
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    if (paramTVideoNetInfo == null)
    {
      QLog.i("GdtVideoCommonView", 1, "onTVideoNetInfoUpdate netInfo == null");
      return;
    }
    this.mVideoSize = paramTVideoNetInfo.getVideoSize();
    this.mHandler.removeCallbacks(this.dE);
    this.mHandler.post(this.dE);
    QLog.i("GdtVideoCommonView", 1, "onTVideoNetInfoUpdate size:" + this.mVideoSize + " hasShowTips " + this.aPD);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.i("GdtVideoCommonView", 1, "onVideoPrepared " + this.aEt + " isViewResume " + this.aPq + " " + this.index);
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$b != null) && (!this.aPB))
    {
      this.aPB = true;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$b.vy(true);
    }
    if ((this.mVideoDuration < 0L) && (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null))
    {
      this.mVideoDuration = this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() <= 0L) {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setDurationMillis(this.mVideoDuration);
      }
      if ((this.mVideoDuration < 1000L) && (!this.aPC))
      {
        this.aPC = true;
        QLog.i("GdtVideoCommonView", 1, "Video error for reason:<1s ");
      }
      this.mHandler.post(new GdtVideoCommonView.4(this));
    }
    switch (this.aEt)
    {
    }
    for (;;)
    {
      paramISuperPlayer = this.oC.iterator();
      while (paramISuperPlayer.hasNext()) {
        ((e)paramISuperPlayer.next()).f(this);
      }
      this.aEt = 4;
      l(3, this.aPq, this.aPz);
    }
  }
  
  public void pauseVideo()
  {
    QLog.i("GdtVideoCommonView", 1, "pauseVideo " + this.index);
    this.aPq = false;
    bDQ();
  }
  
  public void resumeVideo()
  {
    QLog.i("GdtVideoCommonView", 1, "resumeVideo " + this.index);
    bDT();
    l(1, this.aPq, this.aPz);
    if (this.mIsFullScreen) {
      ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(3846);
    }
    bDM();
  }
  
  public void setData(GdtVideoData paramGdtVideoData)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData = paramGdtVideoData;
    this.aPy = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isDirectPlay();
    this.bCj = paramGdtVideoData.getVideoDefaultBackgroundColor();
    this.aPE = paramGdtVideoData.isForceNotShowControllerView();
    this.Ex = paramGdtVideoData.getStartPositionMillis();
    this.isVolumOpen = paramGdtVideoData.isVolumOpen();
    boolean bool;
    if (this.audioManager.getRingerMode() != 2) {
      bool = true;
    }
    for (;;)
    {
      this.aPr = bool;
      initSDK(this.mContext);
      if (!TextUtils.isEmpty(paramGdtVideoData.getCoverUrl())) {}
      try
      {
        Object localObject1 = new URL(paramGdtVideoData.getCoverUrl());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setImage((URL)localObject1);
        Object localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_logo();
        localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getAd().getAdvertiser_corporate_image_name();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          Resources localResources = getResources();
          localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130846397);
          localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130846397);
          localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
          int i = wja.dp2px(55.0F, localResources);
          ((URLDrawable)localObject2).setTag(aqbn.d(i, i, tls.i(21, 750, tls.af(this.mContext))));
          ((URLDrawable)localObject2).setDecodeHandler(aqbn.d);
          this.pc.setImageDrawable((Drawable)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.Bt.setText((CharSequence)localObject1);
        }
        if (paramGdtVideoData.needReport()) {
          this.jdField_a_of_type_Tmn = new tmn(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene());
        }
        bDU();
        return;
        bool = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("GdtVideoCommonView", 1, "getCoverUrl", localException);
        }
      }
    }
  }
  
  public void setGdtVideoCloseIcon(int paramInt) {}
  
  public void setGdtVideoFcIcon(int paramInt)
  {
    this.pb.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setLoadListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$b = paramb;
  }
  
  public void setOnVideoFullScreen(d paramd)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$d = paramd;
  }
  
  public void setisFullScreen(boolean paramBoolean, int paramInt)
  {
    if (this.mIsFullScreen != paramBoolean)
    {
      this.mIsFullScreen = paramBoolean;
      if (!paramBoolean) {
        break label215;
      }
      localObject1 = (Activity)getContext();
      localObject2 = ((Activity)localObject1).getWindow();
      ((Window)localObject2).setFlags(1024, 1024);
      ((Activity)localObject1).setRequestedOrientation(0);
      localObject2 = ((Window)localObject2).getDecorView();
      this.bCe = ((View)localObject2).getSystemUiVisibility();
      ((View)localObject2).setSystemUiVisibility(3846);
      localObject2 = getLayoutParams();
      this.mLastWidth = ((ViewGroup.LayoutParams)localObject2).width;
      this.bCd = ((ViewGroup.LayoutParams)localObject2).height;
      localObject1 = tls.d((Activity)localObject1);
      int i = localObject1[0];
      ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
      ((ViewGroup.LayoutParams)localObject2).height = i;
      setLayoutParams((ViewGroup.LayoutParams)localObject2);
      setGdtVideoFcIcon(2130842612);
      setGdtVideoCloseIcon(paramInt);
      localObject1 = getParent();
      if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
      {
        localObject1 = (ViewGroup)localObject1;
        this.bCf = ((ViewGroup)localObject1).getPaddingTop();
        this.bCg = ((ViewGroup)localObject1).getPaddingBottom();
        this.bCh = ((ViewGroup)localObject1).getPaddingLeft();
        this.bCi = ((ViewGroup)localObject1).getPaddingRight();
        ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
      }
    }
    return;
    label215:
    Object localObject1 = (Activity)getContext();
    ((Activity)localObject1).getWindow().setFlags(1024, 8);
    ((Activity)localObject1).setRequestedOrientation(1);
    ((Activity)localObject1).getWindow().getDecorView().setSystemUiVisibility(this.bCe);
    localObject1 = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = this.mLastWidth;
    ((ViewGroup.LayoutParams)localObject1).height = this.bCd;
    Object localObject2 = getParent();
    if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
      ((ViewGroup)localObject2).setPadding(this.bCh, this.bCf, this.bCi, this.bCg);
    }
    setLayoutParams((ViewGroup.LayoutParams)localObject1);
    setGdtVideoFcIcon(2130842613);
    setGdtVideoCloseIcon(8);
  }
  
  public void updateView()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.mHandler.post(new GdtVideoCommonView.2(this));
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "updateView " + this.aEt + " " + this.index);
    if (AppSetting.enableTalkBack) {
      this.pe.setContentDescription(acfp.m(2131706922));
    }
    switch (this.aEt)
    {
    case 4: 
    default: 
      this.re.setVisibility(8);
      this.mLoadingView.setVisibility(8);
      this.jl.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.pd.setVisibility(8);
      this.pe.setVisibility(0);
      this.pf.setVisibility(4);
      bDS();
    case 3: 
    case 5: 
    case 8: 
    case 7: 
      for (;;)
      {
        bDU();
        return;
        this.re.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.jl.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
        this.pd.setVisibility(0);
        this.pe.setVisibility(8);
        this.pf.setVisibility(0);
        bDS();
        continue;
        this.re.setVisibility(8);
        this.aPz = false;
        this.mLoadingView.setVisibility(8);
        this.jl.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
        this.pd.setVisibility(8);
        this.pf.setVisibility(0);
        bDS();
        vx(false);
        this.mHandler.post(this.progressTask);
        notifyStarted();
        continue;
        this.re.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.jl.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
        this.pd.setVisibility(8);
        this.pe.setVisibility(8);
        this.pf.setVisibility(0);
        bDS();
        notifyError();
        continue;
        bDL();
        bDX();
      }
    }
    this.re.setVisibility(8);
    this.mLoadingView.setVisibility(8);
    this.jl.setVisibility(8);
    if (this.aPz) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
    }
    for (;;)
    {
      this.pe.setVisibility(8);
      this.k.setVisibility(4);
      this.fI.setVisibility(4);
      this.pf.setVisibility(4);
      this.pd.setVisibility(0);
      bDS();
      notifyStopped();
      break;
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      }
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      if (("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction())) && (paramIntent.hasExtra("state")))
      {
        i = paramIntent.getIntExtra("state", 0);
        if (i != 1) {
          break label43;
        }
        QLog.i("GdtVideoCommonView", 1, "ACTION_HEADSET_PLUG HEADSET on");
      }
      label43:
      do
      {
        do
        {
          return;
        } while (i != 0);
        QLog.i("GdtVideoCommonView", 1, "ACTION_HEADSET_PLUG HEADSET off " + GdtVideoCommonView.this.aPq);
      } while (!GdtVideoCommonView.this.aPq);
      GdtVideoCommonView.d(GdtVideoCommonView.this);
    }
  }
  
  public static abstract interface b
  {
    public abstract void vy(boolean paramBoolean);
  }
  
  class c
    extends BroadcastReceiver
  {
    private c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool2 = true;
      if (GdtVideoCommonView.d(GdtVideoCommonView.this))
      {
        GdtVideoCommonView.c(GdtVideoCommonView.this, false);
        QLog.i("GdtVideoCommonView", 1, "SilentModeReceiver first auto called! so skip!");
      }
      while ((GdtVideoCommonView.a(GdtVideoCommonView.this) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
        return;
      }
      int i = GdtVideoCommonView.a(GdtVideoCommonView.this).getRingerMode();
      int j = GdtVideoCommonView.a(GdtVideoCommonView.this).getStreamVolume(3);
      QLog.i("GdtVideoCommonView", 1, "system context mode: " + i);
      switch (i)
      {
      default: 
        GdtVideoCommonView.this.aPr = true;
        GdtVideoCommonView.d(GdtVideoCommonView.this, false);
        GdtVideoCommonView.a(GdtVideoCommonView.this).setOutputMute(true);
        bool1 = bool2;
        GdtVideoCommonView.a(GdtVideoCommonView.this, j, GdtVideoCommonView.this.aPq, false, bool1);
        return;
      }
      GdtVideoCommonView.this.aPr = false;
      if (j > 0) {
        GdtVideoCommonView.d(GdtVideoCommonView.this, true);
      }
      paramContext = GdtVideoCommonView.a(GdtVideoCommonView.this);
      if (!GdtVideoCommonView.e(GdtVideoCommonView.this)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        paramContext.setOutputMute(bool1);
        bool1 = bool2;
        if (!GdtVideoCommonView.e(GdtVideoCommonView.this)) {
          break;
        }
        bool1 = false;
        break;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void aUp();
    
    public abstract void aVf();
  }
  
  public static abstract interface e
  {
    public abstract void eq(View paramView);
    
    public abstract void f(GdtVideoCommonView paramGdtVideoCommonView);
    
    public abstract void g(GdtVideoCommonView paramGdtVideoCommonView);
    
    public abstract void h(GdtVideoCommonView paramGdtVideoCommonView);
    
    public abstract void i(GdtVideoCommonView paramGdtVideoCommonView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView
 * JD-Core Version:    0.7.0.1
 */