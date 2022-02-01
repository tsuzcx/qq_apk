import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.6;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.8;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class tje
  implements abqq, Handler.Callback, View.OnClickListener
{
  private TextView Bp;
  private TextView Bq;
  private TextView Br;
  private long Er = 15L;
  private long Et;
  private abqr jdField_a_of_type_Abqr;
  private tir jdField_a_of_type_Tir;
  private tjc jdField_a_of_type_Tjc;
  private tje.a jdField_a_of_type_Tje$a;
  private tjl jdField_a_of_type_Tjl;
  private tjm jdField_a_of_type_Tjm;
  private tmn jdField_a_of_type_Tmn;
  private boolean aPk;
  private boolean aPl;
  private boolean aPm;
  private boolean aPn;
  private boolean aPo;
  private boolean aPp;
  private boolean aPq;
  private boolean aPr;
  private boolean aPs = true;
  private boolean aPt;
  private AudioManager audioManager;
  private auru b = new auru(Looper.getMainLooper(), this);
  public int bBX = 0;
  private int bBY;
  private LinearLayout fG;
  private LinearLayout fH;
  private RelativeLayout gh;
  private RelativeLayout gi;
  private boolean isFirst = true;
  private aqju m;
  private Context mContext;
  public boolean mIsMute = false;
  private boolean mIsPrepared;
  private View mRootView;
  private long mVideoDuration;
  private ImageView oX;
  private ImageView oY;
  private ImageView oZ;
  private ImageView pa;
  
  public tje(tjl paramtjl, tir paramtir, boolean paramBoolean)
  {
    this.jdField_a_of_type_Tjl = paramtjl;
    this.jdField_a_of_type_Tir = paramtir;
    this.aPt = paramBoolean;
    paramtjl = this.jdField_a_of_type_Tir.a();
    paramtjl.style = 0;
    if (paramtjl.screenOrientation == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.aPk = paramBoolean;
      int i = paramtjl.getVideoCountDown();
      this.Er = i;
      paramBoolean = this.jdField_a_of_type_Tir.b().exp_info.video_countdown_style.has();
      this.bBY = this.jdField_a_of_type_Tir.b().exp_info.video_countdown_style.get();
      tkw.d("GdtMvViewController", "GdtMvViewController: video_countdown = " + i + ", countDownStyle = " + this.bBY + ", video_countdown_style has = " + paramBoolean);
      return;
    }
  }
  
  private void RD()
  {
    if ((this.aPq) && (this.jdField_a_of_type_Abqr != null))
    {
      this.jdField_a_of_type_Abqr.resume();
      if (this.mIsMute) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      vu(bool);
      bDu();
      return;
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    tkt localtkt = (tkt)tjr.a().a(16);
    if (localtkt != null) {
      localtkt.b(paramGdtMotiveVideoPageData, paramString1, paramString2, paramString3);
    }
  }
  
  private void bDA()
  {
    tkw.i("GdtMvViewController", "[doPauseAction] mIsVideoPlayCompleted:" + this.aPn);
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Tir.a();
    vu(false);
    if ((!this.aPn) && (this.jdField_a_of_type_Abqr != null))
    {
      this.aPp = false;
      this.jdField_a_of_type_Abqr.pause();
      if ((this.jdField_a_of_type_Tmn != null) && (localGdtVideoData != null)) {
        this.jdField_a_of_type_Tmn.b(localGdtVideoData, this.jdField_a_of_type_Abqr.getCurrentPosition());
      }
    }
  }
  
  private void bDB()
  {
    if ((this.jdField_a_of_type_Abqr == null) || (this.gi == null)) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    this.gi.setVisibility(0);
    en(this.gi);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.gi.getLayoutParams();
    int k = this.jdField_a_of_type_Abqr.getVideoWidth();
    int n = this.jdField_a_of_type_Abqr.getVideoHeight();
    int i;
    if (this.aPk)
    {
      i = tls.af(this.mContext);
      label88:
      if (!this.aPk) {
        break label318;
      }
    }
    label318:
    for (int j = tls.ae(this.mContext);; j = tls.af(this.mContext))
    {
      tkw.i("GdtMvViewController", "[VIDEO_PREPARED] mVideoSize " + this.aPk + " vW-" + k + " vH-" + n);
      tkw.i("GdtMvViewController", "[VIDEO_PREPARED] mIsPortait " + this.aPk + " sW-" + i + " sH-" + j);
      if ((!this.aPk) || (localGdtMotiveVideoPageData.vSize == 585)) {
        break;
      }
      k = (int)(1.0F * i * n / k);
      j = (int)(j * 150.0F / 1334.0F);
      localLayoutParams.height = k;
      localLayoutParams.width = i;
      localLayoutParams.topMargin = j;
      tkw.i("GdtMvViewController", "[VIDEO_PREPARED] newHeight " + k + " newWidth-" + i + " newTop-" + j);
      return;
      i = tls.ae(this.mContext);
      break label88;
    }
  }
  
  private void bDC()
  {
    if (this.aPt)
    {
      onPause();
      onDestroy();
    }
  }
  
  private void bDD()
  {
    if (this.b != null) {
      this.b.post(new GdtMvViewController.8(this));
    }
  }
  
  private void bDs()
  {
    if (this.jdField_a_of_type_Tjc != null)
    {
      this.jdField_a_of_type_Tmn = new tmn(11);
      return;
    }
    tkw.e("GdtMvViewController", " initReports error");
  }
  
  private void bDt()
  {
    if (this.aPr)
    {
      tkw.e("GdtMvViewController", "refreshVoiceIconDrawable isSilentMode is true");
      this.mIsMute = true;
    }
    bDu();
  }
  
  private void bDu()
  {
    if (this.bBY == 0) {
      if (this.mIsMute) {
        this.oX.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838575));
      }
    }
    while (this.bBY != 1)
    {
      return;
      this.oX.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838576));
      return;
    }
    if (this.mIsMute)
    {
      this.oZ.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838575));
      this.oZ.setContentDescription(this.mRootView.getContext().getResources().getString(2131694271));
      return;
    }
    this.oZ.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838576));
    this.oZ.setContentDescription(this.mRootView.getContext().getResources().getString(2131694270));
  }
  
  private void bDv()
  {
    if (this.aPk)
    {
      if (this.bBY != 0) {
        break label57;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.gh.getLayoutParams();
      localLayoutParams.topMargin += 0;
      localLayoutParams = (RelativeLayout.LayoutParams)this.Bq.getLayoutParams();
      localLayoutParams.topMargin += 0;
    }
    label57:
    while (this.bBY != 1) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fH.getLayoutParams();
    localLayoutParams.topMargin += 0;
    localLayoutParams = (RelativeLayout.LayoutParams)this.fG.getLayoutParams();
    localLayoutParams.topMargin += 0;
  }
  
  private void bDw()
  {
    if (this.bBY == 0)
    {
      this.oX.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838575));
      return;
    }
    this.oZ.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838575));
    this.oZ.setContentDescription(this.mRootView.getContext().getResources().getString(2131694271));
  }
  
  private void bDx()
  {
    if (this.bBY == 0)
    {
      this.oX.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838576));
      return;
    }
    this.oZ.setImageDrawable(this.mRootView.getContext().getResources().getDrawable(2130838576));
    this.oZ.setContentDescription(this.mRootView.getContext().getResources().getString(2131694270));
  }
  
  private void bDy()
  {
    Object localObject = this.jdField_a_of_type_Tir.a();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.mRootView.getResources().getDrawable(2130851770);
    localURLDrawableOptions.mFailedDrawable = this.mRootView.getResources().getDrawable(2130851770);
    localObject = URLDrawable.getDrawable(((GdtMotiveVideoPageData)localObject).previewImgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(aqbn.m);
    ((URLDrawable)localObject).setTag(new int[] { 50 });
    this.oY.setImageDrawable((Drawable)localObject);
  }
  
  private void bDz()
  {
    try
    {
      allf.a(BaseApplication.getContext(), new tjj(this));
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
        if (this.aPk)
        {
          if (localGdtMotiveVideoPageData.vSize == 585)
          {
            this.mRootView = paramLayoutInflater.inflate(2131559394, paramViewGroup, false);
            if (this.mRootView != null) {
              break;
            }
            return null;
          }
          this.mRootView = paramLayoutInflater.inflate(2131559393, paramViewGroup, false);
          continue;
        }
        this.mRootView = paramLayoutInflater.inflate(2131559392, paramViewGroup, false);
      }
      catch (Exception paramLayoutInflater)
      {
        tkw.e("GdtMvViewController", " viewcontr initViews error", paramLayoutInflater);
        return null;
      }
    }
    this.jdField_a_of_type_Tjc = new tjc(this, this.mRootView, this.jdField_a_of_type_Tir);
    tls.eo(this.mRootView.findViewById(2131372394));
    this.jdField_a_of_type_Tjc.bDi();
    if (this.bBY == 0)
    {
      this.Bp = ((TextView)this.mRootView.findViewById(2131364682));
      this.Bq = ((TextView)this.mRootView.findViewById(2131362256));
      this.gh = ((RelativeLayout)this.mRootView.findViewById(2131364684));
      this.gh.setVisibility(0);
      bDv();
      this.oX = ((ImageView)this.mRootView.findViewById(2131363080));
      this.Bp.setOnClickListener(this);
      this.oX.setOnClickListener(this);
    }
    for (;;)
    {
      this.oY = ((ImageView)this.mRootView.findViewById(2131362137));
      this.gi = ((RelativeLayout)this.mRootView.findViewById(2131381712));
      this.gi.setOnClickListener(this);
      return this.mRootView;
      if (this.bBY == 1)
      {
        this.fG = ((LinearLayout)this.mRootView.findViewById(2131367920));
        this.Br = ((TextView)this.mRootView.findViewById(2131365471));
        this.fH = ((LinearLayout)this.mRootView.findViewById(2131367925));
        this.fH.setVisibility(0);
        bDv();
        this.oZ = ((ImageView)this.mRootView.findViewById(2131363081));
        this.pa = ((ImageView)this.mRootView.findViewById(2131364683));
        this.pa.setOnClickListener(this);
        this.oZ.setOnClickListener(this);
      }
    }
  }
  
  private void en(View paramView)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Tir.a();
    if ((this.isFirst) && (paramView != null))
    {
      this.isFirst = false;
      paramView.setTag(2131381958, localGdtVideoData.getAd());
      paramView.setTag(2131381957, new tjk(this));
      tkw.d("GdtMvViewController", "initExpoReport");
      tld.a().g(paramView);
    }
  }
  
  private void initDialog()
  {
    Context localContext = this.mRootView.getContext();
    if (this.mVideoDuration > this.Er * 1000L) {}
    for (String str = acfp.m(2131706908) + this.Er + acfp.m(2131706909);; str = acfp.m(2131706913))
    {
      this.m = aqha.a(localContext, 0, null, str, acfp.m(2131706915), acfp.m(2131706912), new tjg(this), new tjh(this));
      this.m.setOnKeyListener(new tji(this));
      return;
    }
  }
  
  private void initStyle()
  {
    if (this.jdField_a_of_type_Tjc != null) {
      this.jdField_a_of_type_Tjc.initStyle();
    }
  }
  
  private void initVideoView() {}
  
  private void k(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    tkw.d("GdtMvViewController", "setVoiceIconState volume =" + paramInt + " mVideoPlayer " + this.jdField_a_of_type_Abqr + " isFromVolumeChanged = " + paramBoolean2 + ", mIsMute = " + this.mIsMute + ", viewResumed = " + paramBoolean1 + ", mIsVideoPlayCompleted = " + this.aPn);
    if ((!paramBoolean1) || (this.jdField_a_of_type_Abqr == null)) {}
    do
    {
      return;
      if ((paramInt <= 0) || ((this.jdField_a_of_type_Abqr.YX()) && (!paramBoolean2))) {
        break;
      }
      this.mIsMute = false;
      bDx();
      this.jdField_a_of_type_Abqr.setMute(this.mIsMute);
    } while (this.aPn);
    if (!this.mIsMute) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      vu(paramBoolean1);
      return;
      this.mIsMute = true;
      bDw();
      break;
    }
  }
  
  private void registerListener()
  {
    if (this.audioManager != null) {
      if (this.audioManager.getRingerMode() == 2) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      this.aPr = bool;
      this.jdField_a_of_type_Tje$a = new tje.a(null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.mContext.registerReceiver(this.jdField_a_of_type_Tje$a, localIntentFilter);
      this.jdField_a_of_type_Tjm = new tjm(this.mContext);
      this.jdField_a_of_type_Tjm.registerReceiver();
      this.jdField_a_of_type_Tjm.a(new tjf(this));
      return;
    }
  }
  
  private void vu(boolean paramBoolean)
  {
    if (this.audioManager != null)
    {
      if (paramBoolean)
      {
        tkw.d("GdtMvViewController", "[requestSystemAudioFocus] gain is called!");
        this.audioManager.requestAudioFocus(null, 3, 2);
      }
    }
    else {
      return;
    }
    tkw.d("GdtMvViewController", "[requestSystemAudioFocus] release is called!");
    this.audioManager.abandonAudioFocus(null);
  }
  
  private void vv(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Tjc != null) && (paramBoolean)) {
      this.jdField_a_of_type_Tjc.bDj();
    }
  }
  
  private void zv(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.Et < 800L) {}
    while ((paramInt == this.bBX) || (this.jdField_a_of_type_Tjc == null)) {
      return;
    }
    this.bBX = paramInt;
    this.Et = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Tjc.zv(paramInt);
  }
  
  boolean Og()
  {
    return ((this.gh != null) && (this.gh.getVisibility() == 0)) || ((this.pa != null) && (this.pa.getVisibility() == 0));
  }
  
  boolean Oh()
  {
    return this.aPn;
  }
  
  public void P(long paramLong1, long paramLong2)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Tir.a();
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.b.post(new GdtMvViewController.6(this, paramLong1, paramLong2));
    }
    while (this.aPn) {
      return;
    }
    boolean bool;
    label60:
    long l3;
    label80:
    long l1;
    if (paramLong2 < this.Er * 1000L)
    {
      bool = true;
      this.aPo = bool;
      l3 = paramLong2 - paramLong1;
      if (!this.aPo) {
        break label269;
      }
      paramLong2 = paramLong1;
      long l2 = paramLong2 / 1000L + 1L;
      l1 = l2;
      if (l2 > this.Er) {
        l1 = this.Er;
      }
      if (paramLong2 <= 0L) {
        break label331;
      }
      if (this.bBY != 0) {
        break label284;
      }
      this.Bq.setText(acfp.m(2131706916) + l1 + "s");
      this.Bq.setVisibility(0);
    }
    for (;;)
    {
      if (paramLong2 <= 0L) {
        this.aPl = true;
      }
      if (l3 / 1000L == 2L) {
        vv(true);
      }
      if (paramLong1 / 1000L == 3L) {
        vv(false);
      }
      if ((this.aPp) || (this.jdField_a_of_type_Tmn == null) || (this.jdField_a_of_type_Abqr == null) || (localGdtVideoData == null)) {
        break;
      }
      this.aPp = true;
      this.jdField_a_of_type_Tmn.a(localGdtVideoData, this.jdField_a_of_type_Abqr.getCurrentPosition());
      return;
      bool = false;
      break label60;
      label269:
      paramLong2 = this.Er * 1000L - l3;
      break label80;
      label284:
      if (this.bBY == 1)
      {
        this.Br.setText(String.format(acfp.m(2131694269), new Object[] { Long.valueOf(l1) }));
        this.fG.setVisibility(0);
        continue;
        label331:
        if (this.bBY == 0)
        {
          this.Bq.setVisibility(4);
        }
        else if (this.bBY == 1)
        {
          this.Br.setText(acfp.m(2131694268));
          this.fG.setVisibility(0);
        }
      }
    }
  }
  
  public tjl a()
  {
    return this.jdField_a_of_type_Tjl;
  }
  
  public View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = c(paramLayoutInflater, paramViewGroup);
    if (paramLayoutInflater == null)
    {
      tkw.e("GdtMvViewController", "GdtMvViewController init:rootView==null error");
      return null;
    }
    this.mContext = paramLayoutInflater.getContext();
    tkw.d("GdtMvViewController", "GdtMvViewController: init = " + this.aPt + ", mContext = " + this.mContext);
    this.audioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    if (((this.mContext instanceof Activity)) && (!this.aPt)) {
      ((Activity)this.mContext).setVolumeControlStream(3);
    }
    registerListener();
    bDt();
    bDy();
    bDz();
    initStyle();
    initDialog();
    bDs();
    return paramLayoutInflater;
  }
  
  public void beforeFinish()
  {
    ut("");
  }
  
  long eg()
  {
    if (this.jdField_a_of_type_Abqr != null)
    {
      if (this.aPn) {
        return this.mVideoDuration;
      }
      return this.jdField_a_of_type_Abqr.getCurrentPosition();
    }
    return 0L;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        do
        {
          return false;
        } while (this.jdField_a_of_type_Abqr == null);
        bDB();
      } while (this.jdField_a_of_type_Abqr == null);
      paramMessage = this.jdField_a_of_type_Abqr;
      boolean bool1 = bool2;
      if (!this.mIsMute) {
        if (!this.aPr) {
          break label169;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        paramMessage.setMute(bool1);
        this.mVideoDuration = this.jdField_a_of_type_Abqr.getVideoDuration();
        tkw.d("GdtMvViewController", "[mDuration]" + this.mVideoDuration + ", mIsMute = " + this.mIsMute + ", isSilentMode = " + this.aPr);
        this.jdField_a_of_type_Tir.a().setDurationMillis(this.mVideoDuration);
        RD();
        return false;
      }
    case 2: 
      label169:
      tkw.i("GdtMvViewController", "[onVideoCompletion]");
      if (this.jdField_a_of_type_Abqr != null) {
        this.jdField_a_of_type_Abqr.a(this);
      }
      if (this.bBY == 0) {
        this.Bq.setVisibility(4);
      }
      for (;;)
      {
        vu(false);
        zv(1);
        return false;
        this.Br.setText(acfp.m(2131694268));
        this.fG.setVisibility(0);
      }
    }
    tkw.i("GdtMvViewController", "[VIDEO_SDK_INSTALLED] initVideoView");
    initVideoView();
    return false;
  }
  
  public boolean onBackEvent()
  {
    tkw.d("GdtMvViewController", "[onBackEvent] mHasWatchAds " + this.aPl);
    try
    {
      if (this.aPl) {
        return false;
      }
      if ((this.jdField_a_of_type_Abqr != null) && (!this.jdField_a_of_type_Abqr.isPaused()))
      {
        this.aPm = true;
        bDA();
      }
      if ((this.m != null) && (!this.m.isShowing()))
      {
        tkw.d("GdtMvViewController", "mVideoDuration " + this.mVideoDuration + " mShotSeconds " + this.Er);
        aqju localaqju = this.m;
        if (this.mVideoDuration > this.Er * 1000L) {}
        for (Object localObject = acfp.m(2131706910) + this.Er + acfp.m(2131706914);; localObject = acfp.m(2131706911))
        {
          localaqju.setMessage((CharSequence)localObject);
          this.m.show();
          localObject = this.m.getWindow();
          if (localObject == null) {
            break;
          }
          ((Window)localObject).getDecorView().setSystemUiVisibility(7942);
          break;
        }
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      tkw.e("GdtMvViewController", "show dialog err, errInfo->" + localThrowable.getMessage());
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        tkw.i("GdtMvViewController", " onClick close_ads");
        if (!onBackEvent()) {
          this.jdField_a_of_type_Tjl.finish();
        }
      }
    } while (this.jdField_a_of_type_Abqr == null);
    boolean bool2 = this.jdField_a_of_type_Abqr.YX();
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      label108:
      this.mIsMute = bool1;
      tkw.d("GdtMvViewController", "audioSwitch click is called isSilentMode = " + this.aPr + ", isMute = " + bool2);
      this.jdField_a_of_type_Abqr.setMute(this.mIsMute);
      if (!this.mIsMute) {
        break label189;
      }
    }
    label189:
    for (int i = 0;; i = 1)
    {
      k(i, true, false);
      break;
      bool1 = false;
      break label108;
    }
  }
  
  public void onCreate()
  {
    arlc.b(BaseApplicationImpl.getApplication().getApplicationContext(), false, 55);
  }
  
  public void onDestroy()
  {
    tkw.i("GdtMvViewController", "[onDestroy]");
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Tjm != null) {
      this.jdField_a_of_type_Tjm.unregisterReceiver();
    }
    if (this.jdField_a_of_type_Abqr != null)
    {
      this.jdField_a_of_type_Abqr.a(this);
      this.jdField_a_of_type_Abqr.release();
      this.jdField_a_of_type_Abqr = null;
    }
    if (this.jdField_a_of_type_Tjc != null)
    {
      this.jdField_a_of_type_Tjc.onDestroy();
      this.jdField_a_of_type_Tjc = null;
    }
    if (this.jdField_a_of_type_Tmn != null) {
      this.jdField_a_of_type_Tmn = null;
    }
    if ((this.mContext != null) && (this.jdField_a_of_type_Tje$a != null)) {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_Tje$a);
    }
    this.mContext = null;
    tld.a().bDG();
    arlc.b(BaseApplicationImpl.getApplication().getApplicationContext(), true, 55);
  }
  
  public void onPause()
  {
    this.aPq = false;
    bDA();
  }
  
  public void onResume()
  {
    this.aPq = true;
    tkw.i("GdtMvViewController", "[onResume]" + this.aPm + " mIsVideoPlayCompleted " + this.aPn);
    if ((!this.aPm) && (!this.aPn) && (this.mIsPrepared)) {
      RD();
    }
    if (this.jdField_a_of_type_Tjc != null) {
      this.jdField_a_of_type_Tjc.onResume();
    }
  }
  
  public void ut(String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Tir.a();
    tkw.d("GdtMvViewController", "GDT beforeFinish call stack:", new Throwable());
    Intent localIntent = new Intent();
    localIntent.putExtra("duration_time", this.mVideoDuration);
    localIntent.putExtra("elapsed_time", this.mVideoDuration);
    localIntent.putExtra("profitable_flag", this.aPl);
    localIntent.putExtra("is_end", this.aPn);
    if (this.aPn)
    {
      a(localGdtMotiveVideoPageData, String.valueOf(this.mVideoDuration), String.valueOf(this.mVideoDuration), String.valueOf(this.aPn));
      tkw.i("GdtMvViewController", "true[beforeFinish] " + this.mVideoDuration + " /" + this.mVideoDuration);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("arg_callback", paramString);
      }
      this.jdField_a_of_type_Tjl.setResult(-1, localIntent);
      bDC();
      return;
      if (this.jdField_a_of_type_Abqr != null)
      {
        localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Abqr.getCurrentPosition());
        a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Abqr.getCurrentPosition()), String.valueOf(this.mVideoDuration), String.valueOf(this.aPn));
        tkw.i("GdtMvViewController", this.aPl + "[beforeFinish] " + this.jdField_a_of_type_Abqr.getCurrentPosition() + " /" + this.mVideoDuration);
      }
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (tje.a(tje.this))
      {
        tje.b(tje.this, false);
        tkw.d("GdtMvViewController", "SilentModeReceiver first auto called! so skip!");
      }
      while ((tje.a(tje.this) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
        return;
      }
      int i = tje.a(tje.this).getRingerMode();
      int j = tje.a(tje.this).getStreamVolume(3);
      tkw.d("GdtMvViewController", "system context mode: " + i + ", streamVolume = " + j);
      switch (i)
      {
      default: 
        tje.c(tje.this, true);
        tje.this.mIsMute = true;
        tje.a(tje.this).setMute(true);
      }
      for (;;)
      {
        tje.a(tje.this, j, tje.b(tje.this), false);
        return;
        tje.c(tje.this, false);
        if (j > 0) {
          tje.this.mIsMute = false;
        }
        tje.a(tje.this).setMute(tje.this.mIsMute);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tje
 * JD-Core Version:    0.7.0.1
 */