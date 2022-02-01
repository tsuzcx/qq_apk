package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import aeee;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import aqmr;
import ayxa;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.NetworkManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import muj;
import pem;
import rwv;
import ryx;
import shu;
import shv;
import shw;
import shx;
import shy;
import shz;
import sia;
import sib;
import sic;
import sid;
import sie;
import sif;
import sig;
import sih;
import sii;
import spp;
import sqn;

public class VideoPlayerView
  extends BaseVideoView
{
  private static boolean aLB;
  private static final HashMap<View, Integer> fJ = new HashMap();
  private static final SparseBooleanArray l = new SparseBooleanArray();
  private static float oh = 1.0F;
  private long CF;
  private long CG;
  private long CJ;
  private long CR;
  protected ProgressBar E;
  protected URLImageView Z;
  private SubscribeVideoDetailFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment;
  private VideoNextFeedsView jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
  private IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String aEi;
  private boolean aLA;
  private boolean aLC;
  private boolean aLD;
  private boolean aLE;
  private boolean aLF;
  private boolean aLq;
  private boolean aLr;
  private boolean aLs;
  private boolean aLt;
  private boolean aLu = true;
  private boolean aLv = true;
  private boolean aLw;
  private boolean aLx;
  private boolean aLy;
  private boolean aLz;
  private String aiX = "";
  private FollowTextView b;
  private final int bwN = 2;
  private final int bwO = 3;
  private int bwP;
  private int bwQ;
  private FollowTextView c;
  private int[] eB;
  private int[] eC = ayxa.getRealDisplay(getContext());
  private HashMap<String, Boolean> fK = new HashMap();
  private LinearLayout fk;
  private LinearLayout fl;
  private CertifiedAccountMeta.StFeed jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private SquareImageView jdField_i_of_type_ComTencentMobileqqWidgetSquareImageView;
  private SeekBar jdField_j_of_type_AndroidWidgetSeekBar;
  private SquareImageView jdField_j_of_type_ComTencentMobileqqWidgetSquareImageView;
  private int mCurrentState = 1;
  private ExtraTypeInfo mExtraTypeInfo;
  private ArrayList<View> nY = new ArrayList();
  protected ImageView oc;
  protected ImageView od;
  protected ImageView oe;
  protected ImageView of;
  private TextView oq;
  private View pO;
  private View pP;
  protected View pQ;
  private View pR;
  private View pS;
  private View pT;
  private View pU;
  private View pV;
  private View pW;
  private View pX;
  private View pY;
  protected TextView zM;
  protected TextView zN;
  private TextView zO;
  private TextView zP;
  
  public VideoPlayerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramInt1, paramInt2 });
    localObjectAnimator.setDuration(0L);
    localObjectAnimator.addListener(new shx(this, paramInt2, paramView, paramBoolean, paramInt1));
    localObjectAnimator.start();
  }
  
  private void aUp()
  {
    if ((getContext() instanceof Activity))
    {
      ((Activity)getContext()).setRequestedOrientation(1);
      if (this.oq != null) {
        this.oq.setMaxEms(12);
      }
    }
    k(this.eB);
    yu(0);
    uI(false);
    byM();
    if (this.mCurrentState == 10) {
      byF();
    }
    aeee.e(BaseApplicationImpl.getContext(), 2, true);
  }
  
  private void bxw()
  {
    long l1;
    Object localObject;
    if ((this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null) && (a() != null))
    {
      l1 = System.currentTimeMillis() - this.CG;
      localObject = new StringBuilder();
      if (l1 < a().getDurationMs()) {
        break label377;
      }
    }
    label377:
    for (int k = 1;; k = 0)
    {
      localObject = k + "";
      sqn.b(this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "play", 0, 0, new String[] { a().getDurationMs() + "", l1 + "", localObject, this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get() });
      if (qf() > 0)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("time_cost", Long.valueOf(ea()));
        ((HashMap)localObject).put("count", Integer.valueOf(qf()));
        ((HashMap)localObject).put("url", this.aEi);
        sqn.n("subscribe_account_video_play_extra_buffer", sqn.c((HashMap)localObject));
      }
      if (a() != null)
      {
        double d2 = a().getCurrentPositionMs();
        double d1 = a().getDurationMs();
        if ((d2 > 0.0D) && (d1 > 0.0D) && (d2 <= d1))
        {
          d2 /= d1;
          localObject = new HashMap();
          ((HashMap)localObject).put("rate", String.format("%.2f", new Object[] { Double.valueOf(d2 * 100.0D) }));
          ((HashMap)localObject).put("url", this.aEi);
          ((HashMap)localObject).put("attach_info", String.valueOf(d1));
          sqn.n("subscribe_account_video_play_complete_rate", sqn.c((HashMap)localObject));
        }
      }
      return;
    }
  }
  
  private void byA()
  {
    this.aEi = null;
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  private void byB()
  {
    setState(1);
    this.aLE = false;
    if ((this.pO != null) && (!this.aLy)) {
      this.pO.setVisibility(0);
    }
    if (this.pW != null) {
      this.pW.setVisibility(8);
    }
    if (this.pP != null)
    {
      if (this.od != null) {
        this.od.setImageResource(2130839159);
      }
      this.pP.setVisibility(0);
      uG(true);
    }
    if ((this.pS != null) && (this.pS.getVisibility() == 0)) {
      this.pS.setVisibility(8);
    }
    byG();
    getMainHandler().removeMessages(3);
  }
  
  private void byC()
  {
    if ((this.aLu) && (!this.aLv))
    {
      Iterator localIterator = fJ.keySet().iterator();
      while (localIterator.hasNext()) {
        n((View)localIterator.next(), 1, 0);
      }
      this.aLu = false;
    }
  }
  
  private void byD()
  {
    if (!this.aLu)
    {
      Iterator localIterator = fJ.keySet().iterator();
      while (localIterator.hasNext()) {
        n((View)localIterator.next(), 0, 1);
      }
      this.aLu = true;
      if ((this.pP != null) && (this.pP.getVisibility() == 8)) {
        this.pP.setVisibility(0);
      }
    }
  }
  
  private void byE()
  {
    this.pX = findViewById(2131367165);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView = ((VideoNextFeedsView)this.pX.findViewById(2131382054));
    this.pY = this.pX.findViewById(2131370742);
    this.fl = ((LinearLayout)this.pX.findViewById(2131367164));
    this.jdField_j_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.pX.findViewById(2131369758));
    this.fk = ((LinearLayout)this.pX.findViewById(2131370665));
    this.zP = ((TextView)this.pX.findViewById(2131380719));
    this.c = ((FollowTextView)this.pX.findViewById(2131367783));
    this.pQ = this.pX.findViewById(2131380896);
    shy localshy = new shy(this);
    this.pQ.setOnClickListener(localshy);
    this.pY.setOnClickListener(localshy);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnClickListener(new shz(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnCounterListener(new sia(this));
  }
  
  private void byF()
  {
    if (this.pO != null) {
      this.pO.setVisibility(8);
    }
    if (this.pX != null) {
      this.pX.setVisibility(0);
    }
    if ((this.pS != null) && (this.pS.getVisibility() == 0)) {
      this.pS.setVisibility(8);
    }
    Object localObject;
    int k;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getLayoutParams();
      if (isFullScreen())
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      if (this.fl != null)
      {
        localObject = this.fl;
        if (!isFullScreen()) {
          break label377;
        }
        k = 0;
        label124:
        ((LinearLayout)localObject).setVisibility(k);
      }
      if ((!isFullScreen()) || (this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
        break label414;
      }
      if (this.zP != null)
      {
        this.zP.setVisibility(0);
        this.zP.setText(this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get());
      }
      if (this.jdField_j_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
        ryx.b(this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get(), this.jdField_j_of_type_ComTencentMobileqqWidgetSquareImageView);
      }
      if (this.c != null)
      {
        this.c.setOnlyFollowMode(true);
        this.c.setFeedData(this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.c.setExtraTypeInfo(getExtraTypeInfo());
        this.c.setFollowStateChangeListener(new sib(this));
      }
      localObject = (RelativeLayout.LayoutParams)this.fl.getLayoutParams();
      if (this.fk != null)
      {
        if ((!(getContext() instanceof Activity)) || (((Activity)getContext()).getRequestedOrientation() != 0)) {
          break label383;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(2, this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getId());
        this.fk.setOrientation(0);
        ((LinearLayout.LayoutParams)this.c.getLayoutParams()).rightMargin = ImmersiveUtils.dpToPx(12.0F);
        this.c.requestLayout();
      }
      if (this.pY != null) {
        this.pY.setVisibility(8);
      }
    }
    label377:
    label383:
    while (this.pY == null) {
      for (;;)
      {
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
        break;
        k = 8;
        break label124;
        this.fk.setOrientation(1);
        ((LinearLayout.LayoutParams)this.c.getLayoutParams()).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 0);
      }
    }
    label414:
    this.pY.setVisibility(0);
  }
  
  private void byG()
  {
    if ((this.pX != null) && (this.pX.getVisibility() == 0)) {
      this.pX.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.hide();
    }
  }
  
  private void byH()
  {
    if (a() != null) {
      if (a().getRenderViewWidth() <= a().getRenderViewHeight()) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.aLD = bool;
      return;
    }
  }
  
  private void byI()
  {
    byH();
    int k = this.eC[0];
    if (getLayoutParams().width != -1) {
      k = getLayoutParams().width;
    }
    this.eB = new int[] { k, getLayoutParams().height };
    if (this.aLD)
    {
      if ((getContext() instanceof Activity)) {
        ((Activity)getContext()).setRequestedOrientation(0);
      }
      k(new int[] { this.eC[1], this.eC[0] });
    }
    for (;;)
    {
      yu(8);
      uI(true);
      byJ();
      aeee.e(BaseApplicationImpl.getContext(), 2, false);
      return;
      k(new int[] { this.eC[0], this.eC[1] });
    }
  }
  
  private void byJ()
  {
    if (this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if (this.oq != null) {
        this.oq.setVisibility(0);
      }
      byK();
    }
    if (this.oc != null) {
      this.oc.setImageResource(2130839154);
    }
  }
  
  private void byK()
  {
    if ((this.oq != null) && ((getContext() instanceof Activity))) {
      if (((Activity)getContext()).getRequestedOrientation() != 0) {
        break label42;
      }
    }
    label42:
    for (int k = 25;; k = 12)
    {
      this.oq.setMaxEms(k);
      return;
    }
  }
  
  private void byL()
  {
    int m = 0;
    label114:
    View localView;
    if (this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if ((this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.get() == 0) && (this.fK != null) && (this.fK.get(this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()) == null)) {
        break label233;
      }
      k = 1;
      if (this.b != null)
      {
        this.b.setOnlyFollowMode(true);
        this.b.setFeedData(this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.b.setExtraTypeInfo(getExtraTypeInfo());
      }
      if ((k != 0) || (this.aLE) || (!isFullScreen())) {
        break label238;
      }
      k = 1;
      if (this.pS != null)
      {
        if (k != 0)
        {
          this.aLE = true;
          if (this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
            sqn.c(this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "half_exp", 0, 0, new String[] { "", "", this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
          }
        }
        localView = this.pS;
        if (k == 0) {
          break label243;
        }
      }
    }
    label233:
    label238:
    label243:
    for (int k = m;; k = 8)
    {
      localView.setVisibility(k);
      getMainHandler().sendEmptyMessageDelayed(3, 5000L);
      return;
      k = 0;
      break;
      k = 0;
      break label114;
    }
  }
  
  private void byM()
  {
    if (this.oq != null) {
      this.oq.setVisibility(8);
    }
    if (this.oc != null) {
      this.oc.setImageResource(2130839156);
    }
    if (this.pS != null) {
      this.pS.setVisibility(8);
    }
  }
  
  private void byv()
  {
    if ((a() != null) && (this.od != null))
    {
      if (a().isPlaying()) {
        pause();
      }
    }
    else {
      return;
    }
    start();
  }
  
  private void byx()
  {
    if (this.aLu) {
      byC();
    }
    for (;;)
    {
      this.aLt = true;
      return;
      byD();
    }
  }
  
  private void byy()
  {
    this.pO = findViewById(2131377521);
    this.zM = ((TextView)this.pO.findViewById(2131381023));
    this.oq = ((TextView)this.pO.findViewById(2131380976));
    this.zN = ((TextView)this.pO.findViewById(2131381022));
    this.oc = ((ImageView)this.pO.findViewById(2131369764));
    this.pW = this.pO.findViewById(2131370638);
    this.pR = this.pO.findViewById(2131370754);
    this.pP = this.pO.findViewById(2131370765);
    this.od = ((ImageView)this.pO.findViewById(2131369954));
    this.oe = ((ImageView)this.pO.findViewById(2131369956));
    this.of = ((ImageView)this.pO.findViewById(2131369953));
    this.E = ((ProgressBar)this.pO.findViewById(2131369952));
    this.jdField_j_of_type_AndroidWidgetSeekBar = ((SeekBar)this.pO.findViewById(2131377919));
  }
  
  private void byz()
  {
    fJ.put(this.pO, Integer.valueOf(0));
    fJ.put(this.of, Integer.valueOf(0));
    fJ.put(this.od, Integer.valueOf(0));
    fJ.put(this.oe, Integer.valueOf(0));
    fJ.put(this.jdField_j_of_type_AndroidWidgetSeekBar, Integer.valueOf(0));
    fJ.put(this.oc, Integer.valueOf(0));
    l.put(this.pO.getId(), true);
    l.put(this.pU.getId(), true);
    l.put(this.pV.getId(), true);
  }
  
  private boolean fS(String paramString)
  {
    try
    {
      String[] arrayOfString = ((String)spp.a().getValue("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone")).split("\\|");
      int m = arrayOfString.length;
      int k = 0;
      while (k < m)
      {
        boolean bool = paramString.startsWith(arrayOfString[k]);
        if (bool) {
          return true;
        }
        k += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private void initView()
  {
    byy();
    byE();
    this.pU = findViewById(2131370740);
    this.pV = findViewById(2131370741);
    this.Z = ((URLImageView)findViewById(2131369950));
    setVideoCover(this.Z);
    this.pS = findViewById(2131367175);
    this.b = ((FollowTextView)findViewById(2131380717));
    this.jdField_i_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369839));
    this.pT = findViewById(2131382267);
    this.zO = ((TextView)findViewById(2131380759));
    byz();
    if (a() != null) {
      a().setXYaxis(2);
    }
    NetworkManager.registNetStatusListener(this);
  }
  
  private void k(int[] paramArrayOfInt)
  {
    getLayoutParams().width = paramArrayOfInt[0];
    getLayoutParams().height = paramArrayOfInt[1];
    setLayoutParams(getLayoutParams());
  }
  
  private void kJ()
  {
    this.pO.setOnTouchListener(new shu(this));
    this.zO.setOnClickListener(new sic(this));
    this.b.setFollowStateChangeListener(new sid(this));
    this.od.setOnClickListener(new sie(this));
    this.oc.setOnClickListener(new sif(this));
    this.pU.setOnClickListener(new sig(this));
    this.pV.setOnClickListener(new sih(this));
    rwv.a().a(this);
  }
  
  private void n(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, false);
  }
  
  private void setState(int paramInt)
  {
    this.mCurrentState = paramInt;
  }
  
  private void uF(boolean paramBoolean)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.f();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.p((CertifiedAccountMeta.StFeed)localObject);
        str = ((CertifiedAccountMeta.StFeed)localObject).poster.id.get();
        if (!paramBoolean) {
          break label85;
        }
      }
    }
    label85:
    for (Object localObject = "next_play";; localObject = "next_clk")
    {
      sqn.c(str, "auth_video", (String)localObject, 0, 0, new String[0]);
      if (this.Z != null)
      {
        this.Z.setBackgroundResource(0);
        this.Z.setVisibility(8);
      }
      return;
    }
  }
  
  private void uG(boolean paramBoolean)
  {
    int m = 8;
    Object localObject;
    if (this.E != null)
    {
      localObject = this.E;
      if (paramBoolean)
      {
        k = 0;
        ((ProgressBar)localObject).setVisibility(k);
      }
    }
    else if (this.od != null)
    {
      localObject = this.od;
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (int k = m;; k = 0)
    {
      ((ImageView)localObject).setVisibility(k);
      return;
      k = 8;
      break;
    }
  }
  
  private void uH(boolean paramBoolean)
  {
    if (!ayxa.isLiuHaiUseValid()) {}
    do
    {
      do
      {
        return;
        if ((!paramBoolean) || (this.aLD)) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.ah(true, this.bwQ);
        }
      } while (this.pO == null);
      this.pO.setPadding(0, this.bwQ, 0, 0);
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.ah(false, this.bwQ);
      }
    } while (this.pO == null);
    this.pO.setPadding(0, 0, 0, 0);
  }
  
  private void uI(boolean paramBoolean)
  {
    this.aLq = paramBoolean;
    View localView;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null))
    {
      localView = this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().getDecorView();
      if (!this.aLq) {
        break label126;
      }
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().setFlags(1024, 1024);
      ayxa.resetFullScreen(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
      muj.aM(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setUIState(paramBoolean, this.aLD);
      }
      uH(this.aLq);
      return;
      label126:
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(0, 10);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().clearFlags(1024);
      ayxa.closeFullScreen(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFD);
    }
  }
  
  private void yu(int paramInt)
  {
    if ((this.nY != null) && (this.nY.size() > 0))
    {
      Iterator localIterator = this.nY.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if (localView != null) {
          localView.setVisibility(paramInt);
        }
      }
    }
  }
  
  public void J(long paramLong1, long paramLong2) {}
  
  public void K(long paramLong1, long paramLong2) {}
  
  public boolean MJ()
  {
    if ((a() != null) && (a() != null))
    {
      if (isFullScreen()) {
        aUp();
      }
      ThreadManager.getUIHandler().postDelayed(new VideoPlayerView.8(this), 500L);
      return true;
    }
    QLog.d("VideoPlayerView", 4, "enterFloat to early, player is not init");
    return false;
  }
  
  public boolean MK()
  {
    return this.aLz;
  }
  
  public boolean ML()
  {
    return this.aLD;
  }
  
  public boolean Mo()
  {
    return true;
  }
  
  public void P(Object paramObject) {}
  
  public SeekBar a()
  {
    return this.jdField_j_of_type_AndroidWidgetSeekBar;
  }
  
  public void bjp() {}
  
  public void bxt()
  {
    super.bxt();
    sqn.n("subscribe_account_video_download", sqn.ay(sqn.a(0L, 0L, this.aEi, 0L)));
  }
  
  public void bxv()
  {
    super.bxv();
    if ((this.aLt) || (this.aLv))
    {
      this.bwP = 0;
      this.aLt = false;
    }
    if (this.bwP > 120)
    {
      getMainHandler().sendEmptyMessage(2);
      return;
    }
    this.bwP += 1;
  }
  
  public void byw()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener = FloatingScreenManager.getInstance().setFloatingVideoListener(new sii(this));
    FloatingScreenManager.getInstance().setFullScreenViewClickListener(new shv(this));
    FloatingScreenManager.getInstance().setWindowClickListener(0, new shw(this));
  }
  
  public void d(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void e(Context paramContext, View paramView)
  {
    initView();
    kJ();
  }
  
  public void ee(View paramView)
  {
    this.nY.add(paramView);
  }
  
  public void ef(View paramView)
  {
    fJ.put(paramView, Integer.valueOf(paramView.getVisibility()));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    localArrayList.add(CommentListShowStateEvent.class);
    localArrayList.add(SharePanelShowStateEvent.class);
    return localArrayList;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.mExtraTypeInfo;
  }
  
  public int getLayoutId()
  {
    return 2131558881;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label235:
    do
    {
      do
      {
        return false;
        if (this.aLr) {}
        for (int k = paramMessage.arg2 - paramMessage.arg1;; k = paramMessage.arg1)
        {
          int m = k / 1000 / 60;
          k = k / 1000 % 60;
          if ((a() != null) && (a().getCurrentPositionMs() > a().getDurationMs() / 2L) && (!this.aLE)) {
            byL();
          }
          if (this.aLz) {
            break label235;
          }
          if (this.zN != null) {
            this.zN.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) }));
          }
          if ((this.jdField_a_of_type_Pem == null) || (!((Boolean)paramMessage.obj).booleanValue())) {
            break;
          }
          this.jdField_a_of_type_Pem.w(String.format("%02d:%02d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) }), paramMessage.arg2, paramMessage.arg1);
          return false;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener == null) || (!((Boolean)paramMessage.obj).booleanValue()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoProgressUpdate(paramMessage.arg1);
      return false;
      byC();
      return false;
    } while (this.pS == null);
    this.pS.setVisibility(8);
    return false;
  }
  
  public boolean isFullScreen()
  {
    return this.aLq;
  }
  
  public boolean isPlaying()
  {
    return (a() != null) && (a().isPlaying());
  }
  
  public void l(int[] paramArrayOfInt)
  {
    this.eB = paramArrayOfInt;
    if (this.oq != null)
    {
      paramArrayOfInt = this.oq;
      if (this.eB[0] <= this.eB[1]) {
        break label41;
      }
    }
    label41:
    for (int k = 25;; k = 12)
    {
      paramArrayOfInt.setMaxEms(k);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.aLx = false;
  }
  
  public boolean onBackPressed()
  {
    if (this.aLq)
    {
      aUp();
      return true;
    }
    return false;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    getMainHandler().post(new VideoPlayerView.18(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.aLx = true;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.hide();
    }
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super.onError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    getMainHandler().post(new VideoPlayerView.19(this, paramInt1));
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    super.onInfo(paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    getMainHandler().post(new VideoPlayerView.20(this, paramInt));
    return false;
  }
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    if (!"wifi".equals(paramString2)) {
      getMainHandler().post(new VideoPlayerView.21(this));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FollowUpdateEvent)) {
      if (((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 0) {
        if (this.fK == null) {}
      }
    }
    do
    {
      this.fK.remove(((FollowUpdateEvent)paramSimpleBaseEvent).useId);
      for (;;)
      {
        if (this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
          this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
        }
        return;
        if (this.fK != null) {
          this.fK.put(((FollowUpdateEvent)paramSimpleBaseEvent).useId, Boolean.valueOf(true));
        }
      }
      if ((paramSimpleBaseEvent instanceof CommentListShowStateEvent))
      {
        this.aLF = ((CommentListShowStateEvent)paramSimpleBaseEvent).shown;
        return;
      }
    } while (!(paramSimpleBaseEvent instanceof SharePanelShowStateEvent));
    this.aLF = ((SharePanelShowStateEvent)paramSimpleBaseEvent).shown;
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStartTrackingTouch(paramSeekBar);
    this.aLv = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStopTrackingTouch(paramSeekBar);
    this.aLv = false;
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    super.onVideoPrepared(paramISuperPlayer);
    getMainHandler().post(new VideoPlayerView.17(this, paramISuperPlayer));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((isFullScreen()) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null)) {
      muj.aM(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
  }
  
  public void pause()
  {
    if (a() != null)
    {
      setState(7);
      super.pause();
      this.FD = true;
      this.CJ = System.currentTimeMillis();
      if (this.od != null) {
        this.od.setImageResource(2130839159);
      }
    }
  }
  
  public void release()
  {
    super.release();
    bxw();
    if (this.nY != null) {
      this.nY.clear();
    }
    if (l != null) {
      l.clear();
    }
    if (fJ != null) {
      fJ.clear();
    }
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public void resume()
  {
    super.start();
  }
  
  public void setCleanMode(boolean paramBoolean)
  {
    this.aLy = paramBoolean;
    View localView;
    if (this.pO != null)
    {
      localView = this.pO;
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int k = 8;; k = 0)
    {
      localView.setVisibility(k);
      return;
    }
  }
  
  public void setContinueFeeds(List<CertifiedAccountMeta.StFeed> paramList)
  {
    if ((paramList != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setData(paramList);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setHostFragment(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment = paramSubscribeVideoDetailFragment;
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity()).mSystemBarComp;
      this.bwQ = ayxa.getNotchInScreenHeight(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    if (a() != null) {
      a().setLoopback(paramBoolean);
    }
  }
  
  public void setNeedWifiTips(boolean paramBoolean)
  {
    this.aLw = paramBoolean;
  }
  
  public void setNextVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.of != null) {
      this.of.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    if (a() != null) {
      a().setOutputMute(paramBoolean);
    }
  }
  
  public void setPreviewVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.oe != null) {
      this.oe.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRevertProgress(boolean paramBoolean)
  {
    this.aLr = paramBoolean;
  }
  
  public void setVideoFeeds(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {}
    do
    {
      return;
      this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      setVideoPath(paramStFeed.video.fileId.get(), paramStFeed.video.playUrl.get());
      if (this.jdField_i_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
        ryx.b(paramStFeed.poster.icon.get(), this.jdField_i_of_type_ComTencentMobileqqWidgetSquareImageView);
      }
    } while (this.oq == null);
    this.oq.setText(this.jdField_i_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get());
  }
  
  public void setVideoPath(String paramString1, String paramString2)
  {
    byA();
    byB();
    sqn.bjt();
    String str = paramString1;
    Object localObject = paramString2;
    if (!aqmr.isEmpty(paramString2))
    {
      str = paramString1;
      localObject = paramString2;
      if (fS(paramString2))
      {
        localObject = Uri.parse(paramString2);
        paramString2 = paramString1;
        if (localObject != null)
        {
          ((Uri)localObject).getQueryParameter("playerformat");
          paramString2 = paramString1;
          if (aqmr.isEmpty(paramString1)) {
            paramString2 = ((Uri)localObject).getQueryParameter("vid");
          }
        }
        localObject = null;
        str = paramString2;
      }
    }
    if (localObject != null) {}
    for (this.aEi = ((String)localObject);; this.aEi = str)
    {
      byD();
      this.aLv = true;
      super.setVideoPath(str, (String)localObject, 0);
      this.CF = System.currentTimeMillis();
      sqn.n("subscribe_account_video_start_play", sqn.ay(sqn.a(0L, 0L, this.aEi, 0L)));
      sqn.n("subscribe_account_video_start_download", sqn.ay(sqn.a(0L, 0L, this.aEi, 0L)));
      this.CG = System.currentTimeMillis();
      return;
    }
  }
  
  public void setVideoViewCover(String paramString)
  {
    if (this.Z != null) {
      this.aiX = paramString;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130842802);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130842802);
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString != null) {
        this.Z.setImageDrawable(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setWifiAutoPlay(boolean paramBoolean)
  {
    this.aLs = paramBoolean;
  }
  
  public void start()
  {
    if (a() != null)
    {
      setState(5);
      if ((this.FD) && (this.CJ > 0L))
      {
        this.CG -= System.currentTimeMillis() - this.CJ;
        this.CJ = 0L;
      }
      this.FD = false;
      super.start();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoStart((int)a().getDurationMs());
      }
      if (this.od != null) {
        this.od.setImageResource(2130839158);
      }
    }
  }
  
  public void stop()
  {
    bxw();
    setState(8);
    super.stop();
  }
  
  public void uJ(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.oe != null)
    {
      localImageView = this.oe;
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int k = 2130839161;; k = 2130839160)
    {
      localImageView.setImageResource(k);
      return;
    }
  }
  
  public void uK(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.uM(paramBoolean);
    }
  }
  
  public void yg(int paramInt)
  {
    super.yg(paramInt);
    sqn.n("subscribe_account_video_download", sqn.ay(sqn.a(paramInt, 0L, this.aEi, 0L)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView
 * JD-Core Version:    0.7.0.1
 */