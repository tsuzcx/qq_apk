package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.TextView;
import aqcx;
import aqiw;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout.a;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.viola.core.ViolaInstance;
import java.util.HashMap;
import msx;
import muj;
import nbr;
import nwn;
import nwn.a;
import nwq;
import nwt;
import nwu;

public class ViolaVideoView
  extends FrameLayout
  implements View.OnClickListener, VideoFeedsGestureLayout.a, VideoPlayManager.d, nwn
{
  private static HashMap<Integer, Drawable> em = new HashMap();
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager;
  private nwn.a jdField_a_of_type_Nwn$a;
  private int aWr;
  private boolean aoL;
  private boolean aqb = true;
  private boolean avg;
  private int bcP;
  private ViewGroup be;
  private ViewGroup bg;
  private ViewGroup bh;
  private ViewGroup bj;
  private ViewGroup bk;
  private msx c;
  private ViewGroup ce;
  private SeekBar d;
  private HashMap<Integer, Drawable> ez = new HashMap();
  private ColorDrawable f;
  private ImageView jO;
  private ImageView jQ;
  private boolean mIsSeeking;
  private Handler mUIHandler = new a(null);
  private View nc;
  private View nd;
  private TextView ps;
  private TextView rD;
  private TextView rF;
  private TextView rG;
  private TextView rH;
  private TextView tL;
  private long wT;
  private URLImageView x;
  
  public ViolaVideoView(@NonNull Activity paramActivity)
  {
    super(paramActivity);
    setTag("ViolaVideoView");
    this.ce = new FrameLayout(paramActivity);
    addView(this.ce, -1, -1);
    this.x = new URLImageView(paramActivity);
    this.x.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.x, -1, -1);
    this.nc = LayoutInflater.from(paramActivity).inflate(2131560545, this, false);
    addView(this.nc);
    b(this.nc, paramActivity);
    this.f = new ColorDrawable(paramActivity.getResources().getColor(2131165381));
    this.x.setImageDrawable(this.f);
    paramActivity.getWindow().setFlags(16777216, 16777216);
  }
  
  private boolean C(View paramView)
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() != null) && (paramView.getTag() == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a());
  }
  
  private boolean a(VideoPlayManager.c paramc)
  {
    if (!aqiw.isMobileNetWork(getContext())) {}
    while ((paramc == null) || (paramc.b == null)) {
      return false;
    }
    return true;
  }
  
  private void aA(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.Gl()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "innerChangePlayButton() what = " + paramInt);
    }
    this.aqb = false;
    this.mUIHandler.obtainMessage(paramInt, paramString).sendToTarget();
  }
  
  private void aD(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "innerChangePlayButtonFromOpen() what = " + paramInt);
    }
    this.aqb = false;
    this.mUIHandler.obtainMessage(paramInt, paramString).sendToTarget();
  }
  
  private void b(View paramView, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131367963));
    this.jO = ((ImageView)paramView.findViewById(2131373379));
    this.be = ((ViewGroup)paramView.findViewById(2131381641));
    this.d = ((SeekBar)paramView.findViewById(2131377920));
    this.rD = ((TextView)paramView.findViewById(2131365556));
    this.rF = ((TextView)paramView.findViewById(2131380115));
    this.bg = ((ViewGroup)paramView.findViewById(2131373380));
    this.tL = ((TextView)paramView.findViewById(2131366511));
    this.bj = ((ViewGroup)paramView.findViewById(2131363651));
    this.bk = ((ViewGroup)paramView.findViewById(2131367807));
    this.jQ = ((ImageView)paramView.findViewById(2131367808));
    this.ps = ((TextView)paramView.findViewById(2131372701));
    this.rG = ((TextView)paramView.findViewById(2131367063));
    this.bh = ((ViewGroup)paramView.findViewById(2131367806));
    this.nd = paramView.findViewById(2131364690);
    this.rH = ((TextView)paramView.findViewById(2131367809));
    this.jO.setBackgroundDrawable(null);
    this.jO.setOnClickListener(this);
    this.ps.setOnClickListener(this);
    bbO();
    this.bk.setOnClickListener(this);
    this.nd.setOnClickListener(this);
    this.rH.getPaint().setFakeBoldText(true);
    this.c = new msx(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.c);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(new nwt(this));
  }
  
  private void b(nwq paramnwq)
  {
    if (paramnwq.ry <= 0L) {}
    paramnwq = this.rG;
    paramnwq.setText("");
    muj.H(paramnwq, 0);
    this.mUIHandler.postDelayed(new ViolaVideoView.11(this, paramnwq), 1000L);
  }
  
  private boolean b(VideoPlayManager.c paramc)
  {
    return (paramc != null) && (paramc.b != null) && (!paramc.autoPlay) && (aqiw.isMobileNetWork(getContext())) && (paramc.b.ry >= 0L);
  }
  
  private void bbM()
  {
    if (!this.aoL) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() == null);
      this.aoL = false;
    } while (getParent() == null);
    VVideoView localVVideoView = (VVideoView)getParent();
    bbF();
    localVVideoView.un(1);
    bbG();
    ul(1);
  }
  
  private void bbN()
  {
    if (this.aoL) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() == null);
      this.aoL = true;
    } while (getParent() == null);
    VVideoView localVVideoView = (VVideoView)getParent();
    bbF();
    localVVideoView.sP(0);
    bbG();
    ai(0, false);
  }
  
  private void bbO()
  {
    this.d.setOnSeekBarChangeListener(new nwu(this));
  }
  
  private void cY(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.Gl()) {
      return;
    }
    muj.m(this.x, paramInt1, paramInt2);
  }
  
  private void dW(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.be.getVisibility() == 8)
      {
        if (this.jdField_a_of_type_Nwn$a != null) {
          this.jdField_a_of_type_Nwn$a.qi(paramBoolean);
        }
        muj.H(this.be, 0);
      }
      if (this.bg.getVisibility() == 8) {
        muj.H(this.bg, 0);
      }
      return;
    }
    if (this.be.getVisibility() == 0)
    {
      if (this.jdField_a_of_type_Nwn$a != null) {
        this.jdField_a_of_type_Nwn$a.qi(paramBoolean);
      }
      muj.H(this.be, 8);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.isPlaying()) && (this.bg.getVisibility() == 0)) {
      muj.H(this.bg, 8);
    }
    this.tL.setVisibility(8);
  }
  
  private static Drawable f(Context paramContext, int paramInt)
  {
    if (em == null) {}
    do
    {
      return null;
      if (em.containsKey(Integer.valueOf(paramInt))) {
        return (Drawable)em.get(Integer.valueOf(paramInt));
      }
      try
      {
        paramContext = paramContext.getResources().getDrawable(paramInt);
        em.put(Integer.valueOf(paramInt), paramContext);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("ViolaVideoView", 2, "innerGetDrawableFromCache() OutOfMemoryError e=" + paramContext.getMessage());
    return null;
  }
  
  private Drawable k(int paramInt)
  {
    if (this.ez.containsKey(Integer.valueOf(paramInt))) {
      return (Drawable)this.ez.get(Integer.valueOf(paramInt));
    }
    try
    {
      Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
      this.ez.put(Integer.valueOf(paramInt), localDrawable);
      return localDrawable;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaVideoView", 2, "innerGetDrawableFromCache() OutOfMemoryError e=" + localOutOfMemoryError.getMessage());
      }
    }
    return null;
  }
  
  private void qk(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.d.setClickable(true);
      this.d.setEnabled(true);
      this.d.setSelected(true);
      this.d.setFocusable(true);
      return;
    }
    this.d.setClickable(false);
    this.d.setEnabled(false);
    this.d.setSelected(false);
    this.d.setFocusable(false);
  }
  
  private void uo(int paramInt)
  {
    ((ViewGroup.MarginLayoutParams)this.bj.getLayoutParams()).bottomMargin = paramInt;
    this.bj.requestLayout();
  }
  
  public void G(View paramView, int paramInt)
  {
    if (!C(paramView)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      dW(true);
      return;
    }
    dW(false);
  }
  
  public void a(VideoPlayManager.c paramc)
  {
    onSizeChanged(paramc.width, paramc.height);
    a(paramc.b);
    if (b(paramc)) {
      c(paramc.b);
    }
    dW(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.ti(paramc.bcN);
    if (paramc.bcO != -1) {
      uo(paramc.bcO);
    }
    setFullScreenDisable(paramc.avd);
    qk(paramc.ave);
    this.mUIHandler.removeMessages(0);
    this.mUIHandler.sendEmptyMessageDelayed(0, 3000L);
    this.jO.setTag(paramc);
    this.bk.setTag(paramc);
    this.nd.setTag(paramc);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(paramc);
    this.ps.setTag(paramc);
    setFullScreenTitle(paramc.b.title);
  }
  
  public void a(VideoPlayManager.c paramc, int paramInt)
  {
    aA(2, null);
  }
  
  public void a(VideoPlayManager.c paramc, int paramInt1, int paramInt2, String paramString)
  {
    this.mUIHandler.post(new ViolaVideoView.9(this, paramString));
  }
  
  public void a(VideoPlayManager.c paramc, long paramLong)
  {
    float f1 = 100.0F;
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.getDuration();
    if (!this.mIsSeeking)
    {
      if (l != 0L) {
        break label53;
      }
      this.d.setProgress(0);
    }
    label53:
    while (paramLong == 0L)
    {
      if (l > 0L) {
        muj.a(this.rF, l);
      }
      return;
    }
    int i = (int)(100L * paramLong / l);
    float f2 = Math.round(100000.0F / (float)l);
    if (i + f2 > 100.0F) {}
    for (;;)
    {
      this.d.setProgress((int)f1);
      muj.a(this.rD, paramLong);
      break;
      f1 = i + f2;
    }
  }
  
  public void a(VideoPlayManager.c paramc, boolean paramBoolean)
  {
    this.mUIHandler.removeMessages(1);
    if (paramBoolean)
    {
      this.aqb = true;
      this.mUIHandler.sendEmptyMessageDelayed(1, 1200L);
      return;
    }
    aD(2, null);
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager = paramVideoPlayManager;
  }
  
  public void a(nwq paramnwq)
  {
    int j = 0;
    if (!TextUtils.isEmpty(paramnwq.coverUrl))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      if (localLayoutParams.width > 0) {}
      for (int i = localLayoutParams.width;; i = 0)
      {
        localURLDrawableOptions.mRequestWidth = i;
        i = j;
        if (localLayoutParams.height > 0) {
          i = localLayoutParams.height;
        }
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = this.f;
        localURLDrawableOptions.mFailedDrawable = this.f;
        paramnwq = URLDrawable.getDrawable(paramnwq.coverUrl, localURLDrawableOptions);
        this.x.setImageDrawable(paramnwq);
        return;
      }
    }
    this.x.setImageDrawable(null);
  }
  
  public void aTi()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.Gl()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.getCurrentState();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "handlePlayButtonClick() status()=" + i);
    }
    VideoPlayManager.c localc = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    switch (i)
    {
    default: 
      return;
    case 0: 
    case 7: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(localc);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.f(localc);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(localc);
      return;
    case 3: 
    case 4: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.pause(1);
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.restart(1);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.pause(1);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.start();
  }
  
  public void aTn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "changeFullScreenStatus: mIsShowingFull=" + this.aoL);
    }
    if (this.aoL)
    {
      bbM();
      return;
    }
    bbN();
  }
  
  public void ai(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "deal enterFullScreen: ");
    }
    this.aoL = true;
    setControlType(this.bcP);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(true);
    if (!paramBoolean)
    {
      if (paramInt != 0) {
        break label204;
      }
      ((Activity)getContext()).setRequestedOrientation(0);
    }
    for (;;)
    {
      if (getParent() != null)
      {
        Object localObject = (VVideoView)getParent();
        Activity localActivity = (Activity)getContext();
        this.aWr = localActivity.getWindow().getDecorView().getSystemUiVisibility();
        muj.aM(localActivity);
        if ((((VVideoView)localObject).a() != null) && (((VVideoView)localObject).a().getInstance() != null) && (((VVideoView)localObject).a().getInstance().getFragment() != null))
        {
          localObject = (ViolaLazyFragment)((VVideoView)localObject).a().getInstance().getFragment();
          if (localObject != null)
          {
            ((ViolaLazyFragment)localObject).hideTitleBar();
            ((ViolaLazyFragment)localObject).aYe();
          }
        }
        localObject = getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = -1;
        ((ViewGroup.LayoutParams)localObject).width = -1;
      }
      if (paramBoolean) {
        this.bh.setPadding(0, 40, 0, 0);
      }
      if (this.jdField_a_of_type_Nwn$a != null) {
        this.jdField_a_of_type_Nwn$a.qj(true);
      }
      return;
      label204:
      ((Activity)getContext()).setRequestedOrientation(8);
    }
  }
  
  public void b(VideoPlayManager.c paramc, int paramInt)
  {
    this.mUIHandler.post(new ViolaVideoView.4(this));
  }
  
  public void bbF()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.doCacheSurfaceTexture();
    }
  }
  
  public void bbG()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.doRecoverSurfaceTexture();
    }
  }
  
  protected void c(nwq paramnwq)
  {
    paramnwq = muj.ax(paramnwq.ry);
    this.jO.setVisibility(8);
    Drawable localDrawable = getContext().getResources().getDrawable(2130843983);
    this.ps.setText(paramnwq);
    this.ps.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.ps.setCompoundDrawablePadding(aqcx.dip2px(getContext(), 6.0F));
    this.ps.setVisibility(0);
  }
  
  public void cS(View paramView) {}
  
  public void cb(View paramView)
  {
    if (!C(paramView)) {
      return;
    }
    if (this.be.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      dW(bool);
      return;
    }
  }
  
  public void g(VideoPlayManager.c paramc) {}
  
  public void h(VideoPlayManager.c paramc)
  {
    this.mUIHandler.post(new ViolaVideoView.2(this, paramc));
  }
  
  public void i(VideoPlayManager.c paramc)
  {
    this.mUIHandler.post(new ViolaVideoView.3(this));
  }
  
  public boolean isFullScreen()
  {
    return this.aoL;
  }
  
  public void j(VideoPlayManager.c paramc)
  {
    this.mUIHandler.post(new ViolaVideoView.5(this));
  }
  
  public void k(VideoPlayManager.c paramc)
  {
    this.mUIHandler.post(new ViolaVideoView.6(this));
  }
  
  public void l(View paramView, int paramInt1, int paramInt2) {}
  
  public void l(VideoPlayManager.c paramc)
  {
    this.mUIHandler.post(new ViolaVideoView.7(this));
  }
  
  public void m(VideoPlayManager.c paramc)
  {
    this.mUIHandler.post(new ViolaVideoView.8(this));
  }
  
  public ViewGroup n()
  {
    return this.ce;
  }
  
  public void onClick(View paramView)
  {
    if (!C(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364690: 
        aTn();
        break;
      case 2131373379: 
        aTi();
        break;
      case 2131372701: 
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.isPause()) {
          muj.a(this.be, 8, 200);
        }
        aTi();
        break;
      case 2131367807: 
        aTn();
      }
    }
  }
  
  public void onDestory()
  {
    if (this.c != null)
    {
      this.c.doOnDestory();
      this.c = null;
    }
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeMessages(0);
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    onDestory();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.wT = System.currentTimeMillis();
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "onSizeChanged: width=" + paramInt1 + ",height=" + paramInt2);
    }
  }
  
  public void setControlType(int paramInt)
  {
    int j = 8;
    int i = 0;
    this.bcP = paramInt;
    ImageView localImageView;
    switch (this.bcP)
    {
    default: 
      localObject = this.bh;
      paramInt = j;
      if (this.aoL) {
        paramInt = 0;
      }
      ((ViewGroup)localObject).setVisibility(paramInt);
      this.nc.setVisibility(0);
      localImageView = this.jQ;
      if (!this.aoL) {
        break;
      }
    }
    for (Object localObject = f(getContext(), 2130842612);; localObject = f(getContext(), 2130842613))
    {
      localImageView.setBackgroundDrawable((Drawable)localObject);
      return;
      this.nc.setVisibility(8);
      return;
      localObject = this.nc;
      if (this.aoL)
      {
        paramInt = 0;
        ((View)localObject).setVisibility(paramInt);
        localObject = this.bh;
        if (!this.aoL) {
          break label191;
        }
        paramInt = i;
        label146:
        ((ViewGroup)localObject).setVisibility(paramInt);
        localImageView = this.jQ;
        if (!this.aoL) {
          break label197;
        }
      }
      label191:
      label197:
      for (localObject = f(getContext(), 2130842612);; localObject = f(getContext(), 2130842613))
      {
        localImageView.setBackgroundDrawable((Drawable)localObject);
        return;
        paramInt = 8;
        break;
        paramInt = 8;
        break label146;
      }
    }
  }
  
  public void setEndWithLastFrame(boolean paramBoolean)
  {
    this.avg = paramBoolean;
  }
  
  public void setEventListener(nwn.a parama)
  {
    this.jdField_a_of_type_Nwn$a = parama;
  }
  
  public void setFullScreenDisable(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.bk;
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void setFullScreenTitle(String paramString)
  {
    this.rH.setText(paramString);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  public void ul(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "deal exitFullScreen: ");
    }
    this.aoL = false;
    setControlType(this.bcP);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(false);
    if (paramInt == 1) {
      ((Activity)getContext()).setRequestedOrientation(1);
    }
    for (;;)
    {
      ((Activity)getContext()).setRequestedOrientation(1);
      if (getParent() != null)
      {
        Object localObject = (VVideoView)getParent();
        ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(this.aWr);
        if ((((VVideoView)localObject).a() != null) && (((VVideoView)localObject).a().getInstance() != null) && (((VVideoView)localObject).a().getInstance().getFragment() != null))
        {
          localObject = (ViolaLazyFragment)((VVideoView)localObject).a().getInstance().getFragment();
          if (localObject != null)
          {
            ((ViolaLazyFragment)localObject).showTitleBar();
            ((ViolaLazyFragment)localObject).bch();
          }
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        localLayoutParams.height = ((VideoPlayManager.c)localObject).height;
        localLayoutParams.width = ((VideoPlayManager.c)localObject).width;
      }
      this.bh.setPadding(0, 0, 0, 0);
      if (this.jdField_a_of_type_Nwn$a != null) {
        this.jdField_a_of_type_Nwn$a.qj(false);
      }
      return;
      ((Activity)getContext()).setRequestedOrientation(9);
    }
  }
  
  class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          ViolaVideoView.a(ViolaVideoView.this).sendEmptyMessageDelayed(0, 3000L);
                          long l = ViolaVideoView.a(ViolaVideoView.this);
                          l = 3000L - (System.currentTimeMillis() - l);
                          if (l > 0L)
                          {
                            ViolaVideoView.a(ViolaVideoView.this).removeMessages(0);
                            ViolaVideoView.a(ViolaVideoView.this).sendEmptyMessageDelayed(0, l);
                            return;
                          }
                        } while (!ViolaVideoView.a(ViolaVideoView.this).isPlaying());
                        ViolaVideoView.a(ViolaVideoView.this, false);
                        return;
                        if (QLog.isColorLevel()) {
                          QLog.d("ViolaVideoView", 2, "mUiHandler.postDelayed() innerChangePlayButton(MSG_SHOW_LOADING_BTN) mIsNeedShowLoading = " + ViolaVideoView.a(ViolaVideoView.this));
                        }
                      } while (!ViolaVideoView.a(ViolaVideoView.this));
                      ViolaVideoView.a(ViolaVideoView.this, 3, null);
                      return;
                    } while (ViolaVideoView.a(ViolaVideoView.this).a() == null);
                    ViolaVideoView.a(ViolaVideoView.this).setBackgroundDrawable(ViolaVideoView.a(ViolaVideoView.this, 2130844047));
                    ViolaVideoView.a(ViolaVideoView.this).clearAnimation();
                    paramMessage = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
                    paramMessage.setDuration(500L);
                    paramMessage.setRepeatCount(-1);
                    paramMessage.setRepeatMode(1);
                    paramMessage.setStartTime(-1L);
                    paramMessage.setInterpolator(new LinearInterpolator());
                    ViolaVideoView.a(ViolaVideoView.this).startAnimation(paramMessage);
                    ViolaVideoView.b(ViolaVideoView.this).setVisibility(0);
                    ViolaVideoView.b(ViolaVideoView.this).setText("");
                    return;
                  } while (ViolaVideoView.a(ViolaVideoView.this).a() == null);
                  ViolaVideoView.a(ViolaVideoView.this).clearAnimation();
                  ViolaVideoView.a(ViolaVideoView.this).setBackgroundDrawable(ViolaVideoView.a(ViolaVideoView.this, 2130844049));
                  ViolaVideoView.b(ViolaVideoView.this).setVisibility(0);
                  ViolaVideoView.b(ViolaVideoView.this).setText("");
                  return;
                } while (ViolaVideoView.a(ViolaVideoView.this).a() == null);
                ViolaVideoView.a(ViolaVideoView.this).clearAnimation();
                ViolaVideoView.a(ViolaVideoView.this).setBackgroundDrawable(ViolaVideoView.a(ViolaVideoView.this, 2130844049));
                ViolaVideoView.b(ViolaVideoView.this).setVisibility(8);
                ViolaVideoView.b(ViolaVideoView.this).setText("");
                return;
              } while (ViolaVideoView.a(ViolaVideoView.this).a() == null);
              ViolaVideoView.a(ViolaVideoView.this).clearAnimation();
              ViolaVideoView.a(ViolaVideoView.this).setBackgroundDrawable(ViolaVideoView.a(ViolaVideoView.this, 2130844049));
              ViolaVideoView.b(ViolaVideoView.this).setVisibility(0);
              ViolaVideoView.b(ViolaVideoView.this).setText("");
              return;
            } while (ViolaVideoView.a(ViolaVideoView.this).a() == null);
            ViolaVideoView.a(ViolaVideoView.this).clearAnimation();
            ViolaVideoView.a(ViolaVideoView.this).setBackgroundDrawable(ViolaVideoView.a(ViolaVideoView.this, 2130844048));
            ViolaVideoView.b(ViolaVideoView.this).setText("");
            return;
          } while (ViolaVideoView.a(ViolaVideoView.this).a() == null);
          ViolaVideoView.a(ViolaVideoView.this).clearAnimation();
          ViolaVideoView.a(ViolaVideoView.this).setBackgroundDrawable(ViolaVideoView.a(ViolaVideoView.this, 2130844048));
          ViolaVideoView.b(ViolaVideoView.this).setVisibility(8);
          ViolaVideoView.b(ViolaVideoView.this).setText("");
        } while ((ViolaVideoView.c(ViolaVideoView.this).getVisibility() != 0) || (!aqiw.isMobileNetWork(ViolaVideoView.this.getContext())));
        ViolaVideoView.a(ViolaVideoView.this).setVisibility(0);
        ViolaVideoView.c(ViolaVideoView.this).setVisibility(8);
        return;
      } while (ViolaVideoView.a(ViolaVideoView.this).a() == null);
      ViolaVideoView.a(ViolaVideoView.this).clearAnimation();
      ViolaVideoView.a(ViolaVideoView.this).setBackgroundDrawable(ViolaVideoView.a(ViolaVideoView.this, 2130849491));
      ViolaVideoView.b(ViolaVideoView.this).setVisibility(0);
      ViolaVideoView.b(ViolaVideoView.this).setVisibility(0);
      TextView localTextView = ViolaVideoView.b(ViolaVideoView.this);
      if (paramMessage.obj != null) {}
      for (paramMessage = paramMessage.obj.toString();; paramMessage = "")
      {
        localTextView.setText(paramMessage);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.ViolaVideoView
 * JD-Core Version:    0.7.0.1
 */