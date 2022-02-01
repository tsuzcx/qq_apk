package com.tencent.biz.pubaccount.readinjoy.view;

import acej;
import acep;
import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ankt;
import anlm;
import anpc;
import anwa;
import aqcx;
import aqfo;
import aqgz;
import aqha;
import aqiw;
import aqju;
import aqmj;
import auuw;
import auuw.a;
import awit;
import awiy;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.c;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.d;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment.a;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.BubblePopupWindow;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kbp;
import kct;
import kfv;
import kgw;
import klu;
import klx;
import kma;
import kng;
import knj;
import kqi;
import krz;
import kwz;
import kxm;
import kxm.b;
import lbz;
import lcc;
import lcd;
import lce;
import lci;
import lcm;
import lcm.k;
import lgj;
import lhn;
import lic;
import lii;
import lil;
import lke;
import mdp;
import mdu;
import mdz;
import meb;
import med;
import mef.b;
import meh;
import mek;
import meu;
import mfo;
import mfs;
import mix;
import mqq.app.Constants.LogoutReason;
import mqq.app.MainService;
import mqq.os.MqqHandler;
import mrv;
import msg;
import mua;
import muj;
import mye;
import mza;
import mzj;
import nce;
import nce.a;
import ncs;
import neq;
import nie;
import nif;
import nig;
import nih;
import nii;
import nij;
import nik;
import nil;
import nim;
import nin;
import nio;
import nip;
import niq;
import nir;
import nis;
import nit;
import niu;
import niv;
import niw;
import nix;
import njm;
import njn;
import nom;
import npa;
import nsf;
import nss;
import nst;
import nxq;
import oax;
import odd;
import odv;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tlo;
import tlo.a;
import wja;

public class ReadinjoyTabFrame
  extends acep
  implements ViewTreeObserver.OnGlobalLayoutListener, KandianMergeManager.c, KandianMergeManager.d, ReadInJoyBaseFragment.a, ReadInJoyUserInfoModule.a, ReadinjoySlidingIndicator.a, RecommendFeedsDiandianEntranceManager.a, mef.b
{
  public static int aYY = 0;
  public static boolean asp;
  private static boolean asq;
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private DuplicateEventLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout;
  private InitWebProcessRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable = new InitWebProcessRunnable();
  private ReadinjoyViewLayer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer;
  private ReadInJoyChannelViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
  private FrameFragment jdField_a_of_type_ComTencentMobileqqAppFrameFragment;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private kfv jdField_a_of_type_Kfv;
  private mek jdField_a_of_type_Mek;
  protected nom a;
  public int aIW;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> aT = new ConcurrentHashMap();
  private final int aYW = 1;
  private final int aYX = 0;
  private FrameLayout aq;
  private boolean arV;
  private boolean asr;
  private boolean ass;
  private SparseArray<Bundle> aw = new SparseArray();
  private ReadInJoyBaseFragment jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private ChannelCoverInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  private BubblePopupWindow jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow;
  private ClipDianDianTouchAreaLayout jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout;
  private ReadinjoySlidingIndicator jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private mua jdField_b_of_type_Mua;
  private String[] bE = new String[1];
  private ViewGroup bZ;
  private Handler bc = new nig(this);
  private ColorBandVideoEntranceButton c;
  public Runnable cS = new ReadinjoyTabFrame.16(this);
  private Runnable cv = new ReadinjoyTabFrame.1(this);
  private View.OnClickListener cy = new niq(this);
  private int[] dx = new int[1];
  private RelativeLayout fp;
  private ImageView gH;
  private View hY;
  private RedTouch i;
  private ImageView kC;
  private ImageView kD;
  private ImageView kE;
  private View kf;
  private long lastStartTime;
  private View mF;
  private FragmentManager mFragmentManager;
  private View mG;
  private View mH;
  private View mI;
  private lce mObserver = new nih(this);
  private View mRootView;
  private FrameLayout q;
  private TextView tm;
  private long xu;
  private long xv;
  private long xw;
  private long xx;
  private long xy;
  private long xz;
  
  public ReadinjoyTabFrame(FrameFragment paramFrameFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment = paramFrameFragment;
  }
  
  public static boolean Dx()
  {
    return asq;
  }
  
  private void V(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      VideoReport.addToDetectionWhitelist(a());
      kxm.P(this.app);
      if (paramInt == 5)
      {
        ae(true, false);
        localObject = (KandianMergeManager)this.app.getManager(162);
        ((KandianMergeManager)localObject).mU(false);
        if (awit.Vs()) {
          ((KandianMergeManager)localObject).aIH();
        }
        odv.l(this.app, false);
        lcm.a().a.nm(true);
        localObject = kxm.bf(0);
        if ((!"1".equals(localObject)) && (!"0".equals(localObject))) {
          break label232;
        }
        paramInt = meu.aQO;
        label109:
        meu.a().cQ(paramInt, 1);
      }
    }
    for (;;)
    {
      if (awit.aMG())
      {
        if (!paramBoolean) {
          break label261;
        }
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramInt = kxm.nR();
        int j = kxm.aMw;
        npa.a().a(this.app, l, paramInt, j);
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13(this, l, paramInt, j));
      }
      return;
      if (paramInt == 6)
      {
        kxm.aHY();
        break;
      }
      if (paramInt != 13) {
        break;
      }
      localObject = a().getIntent().getStringExtra("folder_status");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        kxm.pV(Integer.valueOf((String)localObject).intValue());
        break;
      }
      kxm.pV(-1);
      break;
      label232:
      if (paramInt == 13)
      {
        paramInt = meu.aQQ;
        break label109;
      }
      paramInt = meu.aQP;
      break label109;
      meu.a().aOS();
    }
    label261:
    npa.a().report();
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.14(this));
  }
  
  private int a(@NotNull Context paramContext, List<auuw.a> paramList)
  {
    int j = wja.dp2px(125.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 15.0F);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      auuw.a locala = (auuw.a)paramList.next();
      int k = (int)Math.ceil(localTextView.getPaint().measureText(locala.title)) + wja.dp2px(71.0F, paramContext.getResources());
      if (k <= j) {
        break label102;
      }
      j = k;
    }
    label102:
    for (;;)
    {
      break;
      return j;
    }
  }
  
  private auuw.a a(int paramInt, String paramString, Drawable paramDrawable)
  {
    auuw.a locala = new auuw.a();
    locala.id = paramInt;
    locala.title = paramString;
    locala.drawable = paramDrawable;
    return locala;
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    m(awit.x(this.app), localArrayList);
    if (localArrayList.size() == 0) {
      m(31, localArrayList);
    }
    auuw.a(paramActivity, localArrayList, new nin(this, paramActivity), new nip(this), a(paramActivity, localArrayList), false).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131299279) - paramActivity.getResources().getDimensionPixelSize(2131299275) + wja.dp2px(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131298584));
    aXI();
  }
  
  private void aR(String paramString, int paramInt)
  {
    int k = 1;
    kxm.b localb1 = new kxm.b();
    kxm.b localb2;
    if (mix.DK())
    {
      j = 1;
      localb2 = localb1.a("ugc_video_flag", Integer.valueOf(j));
      if (!mix.DJ()) {
        break label88;
      }
    }
    label88:
    for (int j = k;; j = 0)
    {
      localb2.a("ugc_column_flag", Integer.valueOf(j));
      if (paramInt != 0) {
        localb1.a("from", Integer.valueOf(paramInt));
      }
      kbp.bp(paramString, localb1.build());
      return;
      j = 0;
      break;
    }
  }
  
  private void aXA()
  {
    Object localObject1 = this.app.getApplication();
    int j = aqmj.getAppVersionCode((Context)localObject1);
    boolean bool1;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) {
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2;
      if (this.c != null) {
        if (this.c.getVisibility() == 0) {
          bool2 = true;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyTabFrame", 2, "initBubblePopWindow mEntranceLayout:" + bool1 + "   btnVisible:" + bool2);
        }
        if ((aqmj.b((Context)localObject1, this.app.getCurrentAccountUin(), j, "key_sp_is_first_show_waist_popwindow")) && (awit.Qi() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.c != null) && (this.c.getVisibility() == 0) && (this.c.getAnchorView() != null))
        {
          aqmj.d((Context)localObject1, this.app.getCurrentAccountUin(), j, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          j = aqcx.dip2px((Context)localObject1, 12.0F);
          int k = aqcx.dip2px((Context)localObject1, 9.0F);
          BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow((Context)localObject1);
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow = localBubblePopupWindow;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(j, k, j, k);
          localBubblePopupWindow.setContentView((View)localObject2);
          ((TextView)localObject2).setText(getResources().getString(2131718641));
          localBubblePopupWindow.setAnimationStyle(2131756487);
          localBubblePopupWindow.setBackgroundColor(-16777216);
          localBubblePopupWindow.setSoftInputMode(1);
          localBubblePopupWindow.setInputMethodMode(2);
          localBubblePopupWindow.p(localBubblePopupWindow.getMeasuredWidth() / 2 - aqcx.dip2px((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.c.getAnchorView().getLocationOnScreen((int[])localObject2);
          j = ankt.SCREEN_WIDTH;
          k = aqcx.dip2px((Context)localObject1, 15.0F);
          int m = localBubblePopupWindow.getMeasuredWidth();
          int n = localObject2[1];
          int i1 = localBubblePopupWindow.getMeasuredHeight();
          int i2 = localBubblePopupWindow.qm();
          int i3 = aqcx.dip2px((Context)localObject1, 5.0F);
          localBubblePopupWindow.b(this.c.getAnchorView(), 48, j - k - m, n - i1 - i2 - i3);
          this.bc.postDelayed(new ReadinjoyTabFrame.12(this), 3000L);
          kbp.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new nce.a(null, null, null, null).a().toJsonString(), false);
        }
        return;
        bool1 = false;
        break;
        bool2 = false;
        continue;
        bool2 = false;
      }
      bool1 = false;
    }
  }
  
  private void aXB()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow.dismiss();
    }
  }
  
  private void aXC()
  {
    if (ThemeUtil.isInNightMode(this.app))
    {
      if (this.kf == null) {
        this.kf = ((ViewStub)findViewById(2131376765)).inflate();
      }
      if (this.kf != null) {
        this.kf.setVisibility(0);
      }
      if (this.mH == null)
      {
        Object localObject = a();
        if (localObject != null)
        {
          localObject = ((BaseActivity)localObject).getLayoutInflater();
          if (localObject != null) {
            this.mH = ((LayoutInflater)localObject).inflate(2131560438, null);
          }
        }
      }
      if (this.mH != null)
      {
        if ((this.mH.getParent() == null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null)) {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.mH);
        }
        this.mH.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.kf != null) {
        this.kf.setVisibility(8);
      }
    } while (this.mH == null);
    this.mH.setVisibility(8);
  }
  
  private void aXD()
  {
    int j = 0;
    if (j < 1)
    {
      switch (j)
      {
      }
      for (;;)
      {
        j += 1;
        break;
        this.bE[j] = acfp.m(2131695158);
        this.dx[j] = 2131376769;
        continue;
        this.dx[j] = 2131376778;
        continue;
        this.dx[j] = 2131376793;
      }
    }
  }
  
  private void aXE()
  {
    if (a().findViewById(16908305) != null) {
      getResources().getDimensionPixelOffset(2131297695);
    }
  }
  
  private void aXG()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable.i(this);
    ThreadManager.executeOnSubThread(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable);
  }
  
  private void aXH()
  {
    if (!"2225164739".equals(this.app.getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new auuw.a();
    ((auuw.a)localObject).id = 0;
    ((auuw.a)localObject).iconId = 2130843381;
    localArrayList.add(localObject);
    localObject = new auuw.a();
    ((auuw.a)localObject).id = 1;
    ((auuw.a)localObject).iconId = 2130843381;
    localArrayList.add(localObject);
    localObject = new auuw.a();
    ((auuw.a)localObject).id = 2;
    ((auuw.a)localObject).titleSize = 14.0F;
    ((auuw.a)localObject).iconId = 2130843381;
    localArrayList.add(localObject);
    localObject = new auuw.a();
    ((auuw.a)localObject).id = 3;
    ((auuw.a)localObject).iconId = 2130843381;
    localArrayList.add(localObject);
    auuw.a locala = new auuw.a();
    locala.id = 4;
    if (!kxm.AR())
    {
      localObject = "打开预加载UI";
      locala.title = ((String)localObject);
      locala.iconId = 2130843381;
      localArrayList.add(locala);
      locala = new auuw.a();
      locala.id = 5;
      if (((Boolean)awit.f("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label317;
      }
    }
    label317:
    for (localObject = "打开动态频道feeds";; localObject = "取消动态频道feeds")
    {
      locala.title = ((String)localObject);
      locala.titleSize = 12.0F;
      locala.iconId = 2130843381;
      localArrayList.add(locala);
      localObject = new auuw.a();
      ((auuw.a)localObject).id = 6;
      ((auuw.a)localObject).titleSize = 12.0F;
      ((auuw.a)localObject).iconId = 2130843381;
      localArrayList.add(localObject);
      auuw.a(a(), localArrayList, new nim(this)).showAsDropDown(this.i);
      return;
      localObject = "取消预加载UI";
      break;
    }
  }
  
  private void aXI()
  {
    aR("0X800AC6C", 0);
  }
  
  private void aXJ()
  {
    aR("0X800AC6E", 2);
  }
  
  private void aXK()
  {
    aR("0X800AC6D", 3);
  }
  
  private void aXL()
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.c != null))
    {
      boolean bool = awit.U("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
      if (!bool) {
        break label86;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.c.setVisibility(0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("should video entrance when change account: ");
        if (!bool) {
          break label106;
        }
      }
    }
    label86:
    label106:
    for (String str = "true";; str = "false")
    {
      QLog.d("ReadInJoyTabFrame", 2, str);
      return;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
      this.c.setVisibility(8);
      break;
    }
  }
  
  private void aXM()
  {
    boolean bool = true;
    if ((NetConnInfoCenter.getServerTime() - aqmj.r(this.app.getApp(), this.app.getCurrentUin()) > klx.su) || (knj.a().zW()) || (MainService.isDebugVersion)) {
      ThreadManagerV2.excute(new ReadinjoyTabFrame.31(this), 128, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("previewMode: ").append(knj.a().zW()).append(" Aladdin: ").append(knj.zV()).append("   interval:");
    if (NetConnInfoCenter.getServerTime() - aqmj.r(this.app.getApp(), this.app.getCurrentUin()) > klx.su) {}
    for (;;)
    {
      QLog.i("ReadInJoyTabFrame", 2, bool);
      return;
      bool = false;
    }
  }
  
  private void aXO()
  {
    int j = 8;
    int m = 0;
    boolean bool = anwa.aze();
    if (bool == this.arV) {
      return;
    }
    this.arV = bool;
    int k;
    Object localObject;
    if (anwa.aze())
    {
      k = 0;
      if (this.hY != null) {
        this.hY.setVisibility(j);
      }
      if (this.bZ != null) {
        this.bZ.setVisibility(j);
      }
      if (this.fp != null) {
        this.fp.setVisibility(k);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
        if (this.arV) {
          break label200;
        }
        bool = true;
        label102:
        ((ReadInJoyChannelViewPager)localObject).setSlideLeftAndRight(bool);
      }
      if (this.kE != null)
      {
        localObject = this.kE;
        if (!kxm.AN()) {
          break label206;
        }
      }
    }
    label200:
    label206:
    for (j = m;; j = 4)
    {
      ((ImageView)localObject).setVisibility(j);
      this.kE.setOnClickListener(this.cy);
      if ((b() instanceof ReadInJoyRecommendFeedsFragment)) {
        aXL();
      }
      QLog.d("ReadInJoyTabFrame", 1, "updateStudyModelUI, isStudyMode= " + this.arV);
      return;
      k = 8;
      j = 0;
      break;
      bool = false;
      break label102;
    }
  }
  
  private void aXP()
  {
    boolean bool = this.i.aux();
    this.i.dGB();
    kgw.q(a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = kxm.v();
        localJSONObject.put("folder_status", kxm.aMw);
        if (!bool) {
          continue;
        }
        j = 2;
        localJSONObject.put("reddot", j);
        localJSONObject.put("kandian_mode", kxm.nR());
        localJSONObject.put("kandian_mode_new", kct.nd());
        localObject = (mfs)this.app.getManager(261);
        if ((((mfs)localObject).pg() != 1) || (TextUtils.isEmpty(((mfs)localObject).jM()))) {
          continue;
        }
        localObject = ((mfs)localObject).jM();
        localJSONObject.put("skin_id", localObject);
        localJSONObject.put("button_state", 0);
        kbp.a(this.app, "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
      }
      catch (Exception localException)
      {
        int j;
        Object localObject;
        localException.printStackTrace();
        continue;
      }
      odd.bU(null, "self_tab_cost");
      return;
      j = 1;
      continue;
      localObject = "0";
    }
  }
  
  private void aXQ()
  {
    lii locallii = lbz.a().a();
    if (locallii != null) {
      locallii.a(kxm.getLongAccountUin(), new nir(this));
    }
  }
  
  private void aXR()
  {
    awit.eDP();
    kxm.p().post(new ReadinjoyTabFrame.36(this));
    eP(2500L);
  }
  
  private void aXr()
  {
    aXL();
    aXz();
    RecommendFeedsDiandianEntranceManager.a().onAccountChange();
    if (this.jdField_b_of_type_Mua != null) {
      this.jdField_b_of_type_Mua.onAccountChange();
    }
  }
  
  private void aXs()
  {
    if (this.kC == null) {}
    for (;;)
    {
      return;
      boolean bool = mix.h(this.app);
      if (bool) {
        this.kC.setVisibility(0);
      }
      while ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
      {
        QLog.i("ReadInJoyTabFrame", 2, "[refreshDeliverButton] needShow = " + bool);
        return;
        this.kC.setVisibility(8);
      }
    }
  }
  
  private void aXt()
  {
    if ((RIJRedPacketManager.a().Dr()) && (Dx()) && (RIJRedPacketManager.a().Dt()))
    {
      this.aq.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.refresh();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.a(1, false, null);
      return;
    }
    this.aq.setVisibility(8);
  }
  
  private void aXv()
  {
    db(this.q);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.mFragmentManager);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_Nom);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_Kfv = new kfv(a(), this.bZ, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_Kfv.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout, this.c);
  }
  
  private void aXw()
  {
    aXx();
  }
  
  private void aXx()
  {
    if (awit.Vs()) {}
    while (!awit.aMH()) {
      try
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.h().clearAnimation();
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.h().setVisibility(0);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.e().setOnClickListener(new niw(this));
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
          QLog.d("ReadInJoyTabFrame", 1, "show channel entrance failed.");
        }
      }
    }
    try
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.h().clearAnimation();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.h().setVisibility(4);
      try
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.e().setOnClickListener(new nix(this));
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "set click listener failed.");
        return;
      }
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        localThrowable3.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "hide channel entrance failed.");
      }
    }
  }
  
  private void aXy()
  {
    BaseActivity localBaseActivity = a();
    this.c = new ColorBandVideoEntranceButton(localBaseActivity);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localBaseActivity);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131374354);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(2131297695);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    this.c.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.c.setOnVideoCoverClickListener(new nie(this));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.c);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.c, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.c.setVisibility(8);
    boolean bool = awit.U("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
    if (bool)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.c.setVisibility(0);
    }
    this.c.getViewTreeObserver().addOnGlobalLayoutListener(this);
    switch (awit.Qi())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_b_of_type_Mua = new mua(this.c, localBaseActivity);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "is show video entrance button: " + bool);
      }
      return;
      this.c.setDefaultDrawable(getResources().getDrawable(2130850265));
      continue;
      this.c.setDefaultDrawable(getResources().getDrawable(2130850233));
      continue;
      this.c.setDefaultDrawable(getResources().getDrawable(2130843619));
    }
  }
  
  private void aXz()
  {
    int j = RecommendFeedsDiandianEntranceManager.qF();
    if (this.c != null)
    {
      Drawable localDrawable = getResources().getDrawable(j);
      this.c.setDefaultDrawable(localDrawable);
      this.c.baG();
      this.c.setDataSource(null);
    }
  }
  
  private void ac(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.22(this, paramVideoInfo, (mfs)this.app.getManager(261)), 16, null, true);
  }
  
  private void ae(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = kxm.v();
    if (paramBoolean1) {}
    for (;;)
    {
      int j;
      int k;
      try
      {
        Object localObject1 = ((KandianMergeManager)this.app.getManager(162)).l();
        Object localObject3;
        long l2;
        if (localObject1 == null)
        {
          j = 1;
          localObject3 = kxm.b(this.app);
          String str2 = kxm.a.aeN;
          String str3 = kxm.ey(kxm.a.Wz);
          l2 = 0L;
          if (j == 1)
          {
            l1 = 0L;
            ((JSONObject)localObject2).put("costtime_type", l2);
            ((JSONObject)localObject2).put("tab_status", j);
            ((JSONObject)localObject2).put("strategy_id", localObject3);
            ((JSONObject)localObject2).put("costtime", l1);
            ((JSONObject)localObject2).put("algorithm_id", str2);
            if (j != 3) {
              break label934;
            }
            ((JSONObject)localObject2).put("reddot_num", ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get());
            break label934;
            ((JSONObject)localObject2).put("current_page", k);
            if (!aqiw.isWifiConnected(a())) {
              break label955;
            }
            k = 2;
            ((JSONObject)localObject2).put("network_type", k);
            ((JSONObject)localObject2).put("kandian_mode_new", kct.nd());
            if (kxm.aMC != 0) {
              break label961;
            }
            k = 0;
            ((JSONObject)localObject2).put("button_state", k);
            ((JSONObject)localObject2).put("os", 1);
            ((JSONObject)localObject2).put("version", kct.XU);
            if (kfv.a != null) {
              ((JSONObject)localObject2).put("channel_id", kfv.a.mChannelCoverId);
            }
            kxm.a(true, (JSONObject)localObject2);
            kbp.a(this.app, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, (String)localObject3, ((JSONObject)localObject2).toString(), false);
            if (localObject1 != null) {
              kxm.a(21, str3, (String)localObject3, str2, "", -1);
            }
            if (paramBoolean2)
            {
              odv.qx(false);
              localObject1 = (mfs)this.app.getManager(261);
              if ((((mfs)localObject1).pg() != 1) || (TextUtils.isEmpty(((mfs)localObject1).jM()))) {
                break label967;
              }
              localObject1 = ((mfs)localObject1).jM();
              localObject2 = (mfo)this.app.getManager(270);
              localObject2 = mfo.b(a(), 0);
              localObject3 = new kxm.b();
              localObject1 = ((kxm.b)localObject3).f().g().a((String)localObject1);
              if (j == 1) {
                break label974;
              }
              paramBoolean1 = true;
              localObject1 = ((kxm.b)localObject1).a(paramBoolean1);
              if (kxm.aMC != 0) {
                break label979;
              }
              paramBoolean1 = true;
              ((kxm.b)localObject1).b(paramBoolean1);
              localObject1 = b();
              if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).nh() == 0))
              {
                if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
                  break label984;
                }
                j = 1;
                ((kxm.b)localObject3).a("ad_page", j);
              }
              kbp.a(this.app, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, ((kxm.b)localObject3).build(), false);
            }
            if (aqiw.isWifiConnected(a())) {
              aXM();
            }
            if (!awit.Vs()) {
              break label926;
            }
            localObject1 = "recommend_tab_cost";
            odd.bU(null, (String)localObject1);
          }
        }
        else
        {
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 5) {
            break label944;
          }
          j = 3;
          continue;
        }
        if (kxm.a.vk == 0L)
        {
          l1 = NetConnInfoCenter.getServerTime() - kxm.a.vl;
          l2 = 1L;
          continue;
        }
        long l1 = NetConnInfoCenter.getServerTime() - kxm.a.vk;
        continue;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.ed(0))
        {
          j = 2;
          ((JSONObject)localObject2).put("reddot", j);
          ((JSONObject)localObject2).put("kandian_mode", kxm.nR());
          ((JSONObject)localObject2).put("kandian_mode_new", kct.nd());
          localObject1 = (mfs)this.app.getManager(261);
          if ((((mfs)localObject1).pg() != 1) || (TextUtils.isEmpty(((mfs)localObject1).jM()))) {
            break label882;
          }
          localObject1 = ((mfs)localObject1).jM();
          localObject3 = (mfo)this.app.getManager(270);
          localObject3 = mfo.b(a(), 0);
          ((JSONObject)localObject2).put("skin_id", localObject1);
          localObject1 = b();
          if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).nh() == 0))
          {
            if ((localObject3 == null) || (!((RefreshData)localObject3).isAD)) {
              break label997;
            }
            j = 1;
            ((JSONObject)localObject2).put("ad_page", j);
          }
          ((JSONObject)localObject2).put("button_state", 0);
        }
        switch (0)
        {
        default: 
          if (paramBoolean2) {
            break label889;
          }
          kbp.a(this.app, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 1, (String)localObject1, null, null, ((JSONObject)localObject2).toString(), false);
          continue;
          j = 1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      continue;
      label882:
      String str1 = "0";
      continue;
      label889:
      kbp.a(this.app, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, str1, null, null, ((JSONObject)localObject2).toString(), false);
      continue;
      label926:
      str1 = "video_tab_cost";
      continue;
      label934:
      if (!paramBoolean2)
      {
        k = 0;
        continue;
        label944:
        j = 2;
      }
      else
      {
        k = 1;
        continue;
        label955:
        k = 1;
        continue;
        label961:
        k = 1;
        continue;
        label967:
        str1 = "0";
        continue;
        label974:
        paramBoolean1 = false;
        continue;
        label979:
        paramBoolean1 = false;
        continue;
        label984:
        j = 0;
        continue;
        str1 = "";
        continue;
        label997:
        j = 0;
        continue;
        str1 = "1";
        continue;
        str1 = "2";
        continue;
        str1 = "3";
      }
    }
  }
  
  private void b(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    Object localObject = a();
    switch (paramInt)
    {
    default: 
      QLog.e("ReadInJoyTabFrame", 2, "showLocationChangedDialog invalid type = " + paramInt);
      return;
    case 1: 
      localObject = aqha.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((aqju)localObject).setPositiveButton("确认", new nii(this, paramPositionData));
      ((aqju)localObject).setNegativeButton("取消", new nij(this));
      ((aqju)localObject).setCanceledOnTouchOutside(true);
      ((aqju)localObject).show();
      return;
    }
    paramPositionData = neq.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new nik(this));
    paramPositionData.setNegativeButton("取消", new nil(this));
    paramPositionData.show();
  }
  
  private static void bR(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_kan_dian", true);
    kqi.f(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772306, 2130772079);
  }
  
  private void de(View paramView)
  {
    k = nst.bci;
    try
    {
      paramView = paramView.getTag();
      j = k;
      if (paramView != null) {
        j = Integer.parseInt(String.valueOf(paramView));
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        nss localnss;
        QLog.d("ReadInJoyTabFrame", 1, "parseInt error!");
        int j = k;
        continue;
        if ((localnss instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
        {
          String str = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localnss).jumpSchema;
          QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo jumpSchema " + str);
          paramView = str;
          if (TextUtils.isEmpty(str)) {
            paramView = RecommendFeedsDiandianEntranceManager.bC(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localnss).feedsType);
          }
          if (!TextUtils.isEmpty(paramView))
          {
            kxm.aJ(a(), paramView);
            this.c.setDataSource(null);
            this.c.baG();
          }
        }
        else
        {
          if ((localnss instanceof nst))
          {
            paramView = (nst)localnss;
            if (paramView.a == null) {
              kxm.aJ(a(), awit.GZ());
            }
            for (;;)
            {
              this.c.setDataSource(null);
              this.c.baG();
              RecommendFeedsDiandianEntranceManager.a().a(paramView, j, 0);
              break;
              muj.a(a(), paramView.a);
            }
          }
          ac(j());
          continue;
          k = RecommendFeedsDiandianEntranceManager.a().qE();
          if (this.c.aus)
          {
            RecommendFeedsDiandianEntranceManager.a().a(null, j, 0);
            kxm.aJ(a(), awit.GZ());
          }
          else if ((k == 2) || (k == 1))
          {
            ac(j());
          }
          else
          {
            kxm.aJ(a(), RecommendFeedsDiandianEntranceManager.bC(k));
          }
        }
      }
    }
    if ((this.c != null) && (this.c.a() != null))
    {
      localnss = this.c.a();
      if (((localnss instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localnss).a != null))
      {
        paramView = (VideoInfo.EntranceDownloadInfo)localnss;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        muj.a(a(), paramView.a);
        if (this.jdField_b_of_type_Mua != null)
        {
          mua.d(paramView);
          this.jdField_b_of_type_Mua.aSm();
        }
        if (kxm.AX()) {
          oT(2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
        }
        return;
      }
    }
  }
  
  private void eP(long paramLong)
  {
    kxm.p().postDelayed(new ReadinjoyTabFrame.35(this), paramLong);
  }
  
  private void initUI()
  {
    findViewById(2131380032).setBackgroundDrawable(null);
    this.jdField_a_of_type_Nom = new nom(a(), (ViewGroup)findViewById(2131380032));
    this.q = ((FrameLayout)findViewById(2131376705));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)findViewById(2131376722));
    this.bZ = ((ViewGroup)findViewById(2131376703));
    this.fp = ((RelativeLayout)findViewById(2131378896));
    this.kD = ((ImageView)findViewById(2131377340));
    this.kE = ((ImageView)findViewById(2131364628));
    this.hY = findViewById(2131379791);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)findViewById(2131378499));
    aXD();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.bE, this.dx);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.ass = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131379866));
    this.mG = findViewById(2131378734);
    this.gH = ((ImageView)findViewById(2131376782));
    this.kC = ((ImageView)findViewById(2131376781));
    label312:
    label320:
    Object localObject;
    if (kxm.AV())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.q != null) {
        this.q.setBackgroundColor(getResources().getColor(2131167654));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(getResources().getColor(2131167595));
      }
      if (!mix.h(this.app)) {
        break label649;
      }
      this.kC.setVisibility(0);
      if (kxm.nW() != 0) {
        break label661;
      }
      j = 1;
      localObject = findViewById(2131372044);
      if (j == 0) {
        break label666;
      }
    }
    label649:
    label661:
    label666:
    for (int j = 0;; j = 8)
    {
      ((View)localObject).setVisibility(j);
      this.mI = findViewById(2131376757);
      this.tm = ((TextView)findViewById(2131371998));
      j = wja.dp2px(3.0F, getResources());
      this.tm.setPadding(j, 0, j, 0);
      this.mI.setOnClickListener(new nif(this));
      this.aq = ((FrameLayout)findViewById(2131377009));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = ((RIJRedPacketProgressView)findViewById(2131377008));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.setOnClickListener(new nio(this));
      aXy();
      this.i = new RedTouch(a().getBaseContext(), findViewById(2131372542)).a(53).a();
      this.i.setOnClickListener(new nis(this));
      this.kD.setOnClickListener(new nit(this));
      this.kC.setOnClickListener(new niu(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.mG);
      onPostThemeChanged();
      aDh();
      aXw();
      aXv();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131365259);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      if ("2225164739".equals(this.app.getCurrentAccountUin())) {
        this.i.setOnLongClickListener(new niv(this));
      }
      aXu();
      this.jdField_a_of_type_Mek = new mek(new meh());
      return;
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
      break;
      this.kC.setVisibility(8);
      break label312;
      j = 0;
      break label320;
    }
  }
  
  private VideoInfo j()
  {
    boolean bool1 = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    int j = (int)(aqgz.hK() * 0.4D);
    int k = (int)(aqgz.hL() * 0.4D);
    Object localObject1 = new int[2];
    this.mRootView.getLocationOnScreen((int[])localObject1);
    int m = localObject1[0];
    int n = this.mRootView.getWidth();
    int i1 = localObject1[1];
    int i2 = this.mRootView.getHeight();
    localBundle.putInt("item_x", m + n - j);
    localBundle.putInt("item_y", i1 + i2 - k);
    localBundle.putInt("item_width", j);
    localBundle.putInt("item_height", k);
    if (this.c != null)
    {
      localBundle.putInt("item_image_width", this.c.getCoverWidth());
      localBundle.putInt("item_image_height", this.c.qT());
    }
    ReadInJoyBaseFragment localReadInJoyBaseFragment = b();
    Object localObject2 = null;
    localObject1 = localObject2;
    boolean bool2;
    if ((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment))
    {
      localObject1 = localObject2;
      if (this.jdField_b_of_type_Mua != null)
      {
        bool2 = this.jdField_b_of_type_Mua.o(localBundle);
        localObject1 = (VideoInfo)localBundle.getParcelable("VIDEO_OBJ");
        if (awit.Qi() != 1) {
          break label297;
        }
        localObject2 = mrv.a((VideoInfo)localObject1);
        if ((localObject2 == null) || (!(localObject2 instanceof ArticleInfo))) {
          break label271;
        }
        ReadInJoyListViewGroup.a(a(), null, (ArticleInfo)localObject2, 1004);
      }
    }
    return localObject1;
    label271:
    kgw.a(a(), 56, getResources().getString(2131720228), 3, 1004);
    return localObject1;
    label297:
    localObject2 = a();
    if (!bool2) {}
    for (;;)
    {
      muj.a((Activity)localObject2, localBundle, bool1, 11);
      tE(3);
      return localObject1;
      bool1 = false;
    }
  }
  
  private void kP()
  {
    SelectPositionModule localSelectPositionModule = lbz.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.aMA();
    }
  }
  
  private void m(int paramInt, List<auuw.a> paramList)
  {
    Drawable localDrawable;
    if ((paramInt & 0x1) != 0)
    {
      localDrawable = getResources().getDrawable(2130843671).mutate();
      if (ThemeUtil.isInNightMode(this.app)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
    }
    if ((paramInt & 0x2) != 0)
    {
      localDrawable = getResources().getDrawable(2130843672).mutate();
      if (ThemeUtil.isInNightMode(this.app)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
    }
    if (mix.DJ())
    {
      localDrawable = getResources().getDrawable(2130843862).mutate();
      if (ThemeUtil.isInNightMode(this.app)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(2, mix.Z(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (mix.DK())
    {
      localDrawable = getResources().getDrawable(2130843866).mutate();
      if (ThemeUtil.isInNightMode(this.app)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(3, mix.aa(BaseApplicationImpl.getContext()), localDrawable));
    }
  }
  
  private void tE(int paramInt)
  {
    if ((this.jdField_b_of_type_Mua != null) && (RecommendFeedsDiandianEntranceManager.a().FB())) {
      this.jdField_b_of_type_Mua.sA(paramInt);
    }
  }
  
  public void O(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showErrorRedPacketDialog");
    new meb((ViewGroup)a().getWindow().getDecorView(), BaseApplicationImpl.getContext().getString(2131718430), BaseApplicationImpl.getContext().getString(2131718561), paramInt1, paramInt2, null).show(false);
  }
  
  public void X(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("ReadInJoyTabFrame", 1, "haveWallet = " + paramBoolean1 + " hasOpen = " + paramBoolean2);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.mRootView = paramLayoutInflater.inflate(2131560406, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer = new ReadinjoyViewLayer(a().getBaseContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.mRootView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout = new DuplicateEventLayout(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout;
  }
  
  public RIJRedPacketProgressView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  }
  
  public void a(long paramLong, String paramString1, @Nullable mdp parammdp, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showOpenRedPacketDialog");
    ViewGroup localViewGroup = (ViewGroup)a().getWindow().getDecorView();
    if (parammdp == null) {}
    for (paramString1 = new mdz(localViewGroup, paramLong, paramString2, paramString1, paramInt1, paramInt2, paramInt3, null);; paramString1 = new med(localViewGroup, paramLong, paramString1, parammdp, paramString2, paramInt1, paramInt2, paramInt3, null))
    {
      paramString1.show(false);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    aDh();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showRedPacketDialog");
  }
  
  public void aDh()
  {
    SparseIntArray localSparseIntArray = ((KandianMergeManager)this.app.getManager(162)).b();
    int k = 0;
    if (k < localSparseIntArray.size())
    {
      int m = localSparseIntArray.keyAt(k);
      int n = localSparseIntArray.valueAt(k);
      int j;
      switch (m)
      {
      default: 
        j = -1;
      }
      for (;;)
      {
        Message localMessage = this.bc.obtainMessage(2);
        localMessage.arg1 = n;
        localMessage.arg2 = j;
        localMessage.obj = Integer.valueOf(m);
        this.bc.sendMessage(localMessage);
        k += 1;
        break;
        j = 2131376769;
        continue;
        j = 2131376793;
        continue;
        j = 2131376778;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.19(this));
  }
  
  public void aKu()
  {
    QLog.d("ReadInJoyTabFrame", 1, "dismissRedPacketDialog");
  }
  
  public void aKv()
  {
    QLog.d("ReadInJoyTabFrame", 1, "showOtherPopupView");
  }
  
  public void aXF()
  {
    ae(true, true);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = b();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.aIq();
    }
    if (awit.aMH()) {
      kbp.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", kct.d(null), false);
    }
  }
  
  public void aXN()
  {
    super.aXN();
  }
  
  public void aXu()
  {
    Object localObject = ((KandianMergeManager)this.app.getManager(162)).a();
    if (localObject != null)
    {
      int j = ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt;
      localObject = j + "";
      if (j > 99) {
        localObject = "99+";
      }
      this.tm.setText((CharSequence)localObject);
      this.tm.setVisibility(0);
      return;
    }
    this.tm.setVisibility(8);
  }
  
  public ReadInJoyBaseFragment b()
  {
    if (this.jdField_a_of_type_Kfv != null)
    {
      localObject = this.jdField_a_of_type_Kfv.a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).getActivity() == null))
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.xz, 0L, null, "", true);
      ThreadManager.getSubThreadHandler().postDelayed(new ReadinjoyTabFrame.10(this, (ReadInJoyBaseFragment)localObject), 1000L);
      return null;
    }
    return localObject;
  }
  
  public void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showErrorRedPacketDialog, wording = " + paramString1);
    new meb((ViewGroup)a().getWindow().getDecorView(), paramString1, paramString2, paramInt1, paramInt2, null).show(false);
  }
  
  public int c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return 0;
    }
    if (paramInt1 != paramInt2)
    {
      ae(false, false);
      return 0;
    }
    ae(false, true);
    return 0;
  }
  
  public void db(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.dh(paramView);
  }
  
  public long dk()
  {
    return this.xx;
  }
  
  public void f(MessageRecord paramMessageRecord)
  {
    aDh();
  }
  
  public void g(MessageRecord paramMessageRecord)
  {
    aDh();
  }
  
  public void g(nss paramnss)
  {
    if (this.c == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.c.setDataSource(paramnss);
    } while (this.c.getVisibility() != 0);
    if (paramnss != null) {
      this.c.i(paramnss);
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().tH(0);
      return;
      this.c.setNotMsg();
    }
  }
  
  public int getCurrentTab()
  {
    return 0;
  }
  
  public void h(nss paramnss)
  {
    if (this.c == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.c.setDataSource(paramnss);
    } while (this.c.getVisibility() != 0);
    if (paramnss != null) {
      this.c.i(paramnss);
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().tH(0);
      return;
      this.c.setNotMsg();
    }
  }
  
  public void np(boolean paramBoolean)
  {
    if (!paramBoolean) {
      aXB();
    }
  }
  
  public void oT(int paramInt)
  {
    this.aIW |= paramInt;
    QLog.d("ReadInJoyTabFrame", 2, "set operation flag : " + paramInt);
    if (paramInt != 1) {
      odv.uy(paramInt);
    }
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    Object localObject = (KandianMergeManager)this.app.getManager(162);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int j;
    if (kxm.nW() == 0)
    {
      j = 1;
      localObject = findViewById(2131372044);
      if (j == 0) {
        break label117;
      }
      j = 0;
      label50:
      ((View)localObject).setVisibility(j);
      aXu();
      ((mfs)this.app.getManager(261)).a(this.c);
      if (!mix.h(this.app)) {
        break label123;
      }
      this.kC.setVisibility(0);
    }
    for (;;)
    {
      aXr();
      kma.a(this.app).init();
      return;
      j = 0;
      break;
      label117:
      j = 8;
      break label50;
      label123:
      this.kC.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (b() != null) {
      b().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (paramIntent.getBooleanExtra("key_ugc_account_create", false)) {
        aXQ();
      }
    }
    else {
      return;
    }
    if (paramIntent.getBooleanExtra("key_ugc_account_edit", false))
    {
      aXR();
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "ugc account create or edit profile canceled !");
  }
  
  public boolean onBackPressed()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = b();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      mye localmye = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localmye != null) && (localmye.a() != null))
      {
        if (localmye.a().EV())
        {
          localmye.a().aUp();
          localmye.a().aUc();
          return true;
        }
        if (kng.a(localmye.a())) {
          localmye.a().aUc();
        }
      }
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localReadInJoyBaseFragment).onBackPressed())) {
      return true;
    }
    return super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources().getDisplayMetrics();
    float f2 = acej.aV() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramConfiguration.density / f1;
    QLog.d("ReadInJoyTabFrame", 1, "onConfigurationChanged densityNoScale : " + f1 + ", screenWidth : " + paramConfiguration.widthPixels);
    Utils.init(f1, paramConfiguration.widthPixels);
  }
  
  public void onCreate()
  {
    super.onCreate();
    lcc.a().aJB();
    Object localObject = a();
    if ((localObject instanceof SplashActivity)) {
      this.mFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        tlo.a().a((Context)localObject, new tlo.a());
      }
      initUI();
      aXG();
      localObject = (KandianMergeManager)this.app.getManager(162);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((mfs)this.app.getManager(261)).a(this.c);
      lcc.a().b(this.mObserver);
      kma.a(this.app).init();
      nxq.init();
      RIJRedPacketManager.a().aOH();
      this.jdField_a_of_type_Mek.a(this);
      return;
      if ((localObject instanceof FragmentActivity)) {
        this.mFragmentManager = ((FragmentActivity)localObject).getSupportFragmentManager();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((mfs)this.app.getManager(261)).b(this.c);
    lcc.a().c(this.mObserver);
    this.jdField_a_of_type_Nom.onDestroy();
    if (this.jdField_a_of_type_Kfv != null)
    {
      this.jdField_a_of_type_Kfv.onDestroy();
      this.jdField_a_of_type_Kfv = null;
    }
    if (this.jdField_b_of_type_Mua != null) {
      this.jdField_b_of_type_Mua.onDestroy();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.app.getManager(162);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    asq = false;
    krz.a().aGb();
    awiy.a().eDQ();
    KandianVideoUploadService.a(null);
    knj.a().agA = true;
    RecommendFeedsDiandianEntranceManager.a().b(this);
    meu.a().aOS();
    this.jdField_a_of_type_Mek.detachView();
    if (this.c != null) {
      this.c.onDestroy();
    }
  }
  
  public void onGlobalLayout()
  {
    this.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    aXA();
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoFailed, uin = ", paramString1, Character.valueOf('\n'), "errMsg = ", paramString2 });
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoSucceed uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo });
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    super.onLogout(paramLogoutReason);
    ((mfo)this.app.getManager(270)).b(0, "", -1L, 0);
    if (b() != null) {
      b().onLogout(paramLogoutReason);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.b() != this) {
      aXE();
    }
    asp = false;
    aXB();
    ApngImage.pauseByTag(8);
    lbz.aJt();
    this.jdField_a_of_type_Nom.onPause();
    if (this.c != null) {
      this.c.baP();
    }
    if (this.jdField_a_of_type_Kfv != null) {
      this.jdField_a_of_type_Kfv.onPause();
    }
  }
  
  public void onPostThemeChanged()
  {
    Drawable localDrawable = getResources().getDrawable(2130843761);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.gH.setImageResource(2130843681);
      this.kC.setImageResource(2130843678);
      this.hY.setBackgroundColor(-1);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.T(2131167165, 2131167166, 2131167164);
      localDrawable.setColorFilter(getResources().getColor(2131165381), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.mI).setImageDrawable(localDrawable);
    }
    for (;;)
    {
      aXC();
      pF(true);
      anlm.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      lcc.a().onThemeChanged();
      return;
      this.gH.setImageResource(2130851145);
      this.kC.setImageResource(2130840650);
      this.hY.setBackgroundResource(2130851105);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.T(2131167301, 2131167301, 2131167301);
      localDrawable.setColorFilter(getResources().getColor(2131167301), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.mI).setImageDrawable(localDrawable);
      E(this.mG, false);
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    if (b() != null) {
      b().a(this);
    }
    Object localObject = a().findViewById(16908305);
    if (localObject != null) {
      SlideActiveAnimController.di((View)localObject);
    }
    asp = true;
    ApngImage.playByTag(8);
    if ((this.c != null) && (this.c.getVisibility() == 0))
    {
      this.c.onResume();
      if (!paramBoolean) {
        break label297;
      }
      tE(1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = lbz.a().a();
        if (localObject != null) {
          ((lic)localObject).nB(false);
        }
        kxm.aIb();
      }
      this.jdField_a_of_type_Nom.onResume();
      if (this.c != null) {
        this.c.baQ();
      }
      localObject = a().getIntent();
      if (((Intent)localObject).hasExtra("arg_channel_cover_id"))
      {
        int j = ((Intent)localObject).getIntExtra("arg_channel_cover_id", 0);
        ((Intent)localObject).getIntExtra("launch_from", 5);
        if (this.jdField_a_of_type_Kfv != null) {
          this.jdField_a_of_type_Kfv.oF(j);
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      if (this.jdField_a_of_type_Kfv != null) {
        this.jdField_a_of_type_Kfv.onResume();
      }
      if (!this.asr)
      {
        kP();
        this.asr = true;
      }
      if (asq) {
        kxm.mP(true);
      }
      lbz.a().aJx();
      if (((Boolean)awit.f("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false))).booleanValue())
      {
        if (((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (!((Intent)localObject).getBooleanExtra("is_watch_word_share", false))) {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.qc(9);
        }
        awit.H("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false));
      }
      aXt();
      aXO();
      return;
      label297:
      if (this.jdField_b_of_type_Mua != null) {
        mua.c(this.c.a());
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.xw = System.currentTimeMillis();
    long l2 = this.xx;
    long l3 = this.xw;
    if (this.lastStartTime > 0L) {}
    for (long l1 = this.lastStartTime;; l1 = this.xv)
    {
      this.xx = (l3 - l1 + l2);
      mzj.a().z(false, "readInjoy onStop");
      return;
    }
  }
  
  public void pE(boolean paramBoolean)
  {
    try
    {
      aXx();
      if (this.jdField_a_of_type_Kfv != null) {
        this.jdField_a_of_type_Kfv.onAccountChanged();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "init ChannelEntry failed.");
      }
    }
  }
  
  public void pF(boolean paramBoolean)
  {
    int j = 9216;
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) && (paramBoolean))
    {
      if (ImmersiveUtils.eB())
      {
        ImmersiveUtils.a(a().getWindow(), true);
        if ((VersionUtils.isM()) && (aqfo.isMIUI())) {
          if (!paramBoolean) {
            break label72;
          }
        }
        for (;;)
        {
          a().getWindow().getDecorView().setSystemUiVisibility(j);
          this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
          return;
          label72:
          j = 1280;
        }
      }
      if ((VersionUtils.isM()) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        a().getWindow().getDecorView().setSystemUiVisibility(9216);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-16777216);
      return;
    }
    if ((ImmersiveUtils.eB()) && ((!VersionUtils.isM()) || (!aqfo.isMIUI()))) {
      ImmersiveUtils.a(a().getWindow(), false);
    }
    E(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
  }
  
  public void pG(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Kfv != null)
    {
      int k = 0;
      int j = k;
      if (!paramBoolean)
      {
        j = k;
        if (lhn.oC() != -1) {
          j = lhn.oC();
        }
      }
      this.jdField_a_of_type_Kfv.oF(j);
    }
  }
  
  public void pH(boolean paramBoolean)
  {
    if (paramBoolean) {
      oax.bcY();
    }
    for (;;)
    {
      asq = paramBoolean;
      pF(paramBoolean);
      anlm.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      int n = a().getIntent().getIntExtra("launch_from", 5);
      V(paramBoolean, n);
      long l1 = NetConnInfoCenter.getServerTime();
      long l2 = kxm.a.vk;
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.app.getManager(162);
      int j;
      Object localObject1;
      if ((paramBoolean) && ((localKandianMergeManager.Bw()) || (localKandianMergeManager.ol() > 0)))
      {
        j = 0;
        if (n == 6)
        {
          j = a().getIntent().getIntExtra("jump_activity_launch_channel_id", 0);
          localObject1 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject1).put("source", "304");
        ((JSONObject)localObject1).put("style", 0);
        kbp.a(null, "", "0X8009B94", "0X8009B94", 0, 0, "", "", "", ((JSONObject)localObject1).toString(), false);
        if ((j == 0) || (j == lhn.oC())) {
          pG(false);
        }
        QLog.d("ReadInJoyTabFrame", 1, "onTabChange, has red point, switch to main fragment,channeldId;" + j);
        ((klu)this.app.getManager(307)).aB(a());
        localObject1 = b();
        if (localObject1 != null)
        {
          if (paramBoolean)
          {
            kfv.cn(((ReadInJoyBaseFragment)localObject1).nh(), 0);
            ((ReadInJoyBaseFragment)localObject1).a(false, a(), null);
          }
        }
        else
        {
          if (!paramBoolean) {
            break label810;
          }
          lke.aML();
          this.xv = System.currentTimeMillis();
          this.xx = 0L;
          this.aIW = 0;
          odv.aHz();
          tF(n);
          awit.x(this.app);
          lci.aJO();
          ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.17(this));
          long l3 = System.currentTimeMillis() - this.xu;
          kxm.Q(this.app);
          if (!awit.aMH()) {
            break label790;
          }
          kxm.pY(6);
          mzj.a().aO(a());
          int m = 0;
          int k = 0;
          j = m;
          if (b() == null) {
            break label1160;
          }
          j = m;
          if ((b() instanceof ReadInJoyRecommendFeedsFragment)) {
            break label1160;
          }
          long l4 = awit.g(kxm.getAppRuntime());
          j = k;
          if (l3 >= l4)
          {
            j = k;
            if (this.xu != 0L)
            {
              this.ass = true;
              j = 1;
              lcc.a().aJJ();
              QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l3, ", timeLimit = ", Long.valueOf(l4) });
            }
          }
          if (!anwa.aze()) {
            break label1160;
          }
          j = 1;
          bool = true;
          if (j != 0) {
            pG(bool);
          }
          RecommendFeedsDiandianEntranceManager.a().aXU();
          if (njm.getAction() != 8) {
            njm.tJ(5);
          }
          njn.a().pM(false);
          if ((localKandianMergeManager.BD()) && (System.currentTimeMillis() - this.xy > 180000L))
          {
            msg.a().aN(this.app.getCurrentAccountUin(), 1);
            this.xy = System.currentTimeMillis();
          }
          j = 2;
          if ((n != 9) && (n != 6)) {
            break label797;
          }
          j = 5;
          odv.a(j, true, l1 - l2, kxm.a.aRV, this.aIW);
          ThreadManager.getFileThreadHandler().postDelayed(this.cv, 20000L);
          knj.a().pl(0);
          if (kxm.Bd()) {
            aXG();
          }
          lgj.updateConfig();
          if ((b() instanceof ReadInJoyRecommendFeedsFragment)) {
            lbz.a().a().aMx();
          }
          if ((anwa.aze()) && (kxm.AN())) {
            kxm.mF("0X800AF05");
          }
          if (this.jdField_a_of_type_Kfv != null) {
            this.jdField_a_of_type_Kfv.lS(paramBoolean);
          }
          if ((paramBoolean) && (!ZV())) {
            cIu();
          }
          aXt();
          QLog.d("Q.readinjoy.4tab", 2, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + n);
          aXO();
          return;
          oax.bcZ();
        }
      }
      catch (Exception localException)
      {
        label1160:
        for (;;)
        {
          boolean bool;
          continue;
          localException.aCc();
          continue;
          label790:
          kxm.pY(3);
          continue;
          label797:
          if (n == 13)
          {
            j = 6;
            continue;
            label810:
            VideoReport.traverseExposure();
            this.xu = System.currentTimeMillis();
            RecommendFeedsDiandianEntranceManager.a().eQ(this.xu);
            if (this.xx != 0L) {}
            Object localObject2;
            for (this.xx += this.xu - this.lastStartTime;; this.xx = (this.xu - this.xv))
            {
              j = 0;
              while (j < 1)
              {
                localObject2 = b();
                if (localObject2 != null) {
                  ((ReadInJoyBaseFragment)localObject2).aCe();
                }
                j += 1;
              }
            }
            localKandianMergeManager.aIQ();
            l1 = this.xu - this.xv;
            if (l1 > 0L) {
              ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.18(this, l1));
            }
            msg.aRK();
            msg.a().destroy();
            mzj.a().aP(a());
            mzj.a().z(false, "readInjoy doOnPause");
            j = 2;
            if ((n == 9) || (n == 6)) {
              j = 5;
            }
            for (;;)
            {
              odv.a(j, false, this.xv, kxm.a.aRV, this.aIW);
              a().getIntent().removeExtra("launch_from");
              localObject2 = (lcd)this.app.getManager(163);
              if ((localObject2 != null) && (((lcd)localObject2).b() != null))
              {
                localObject2 = ((lcd)localObject2).b().a();
                if (localObject2 != null) {
                  ((ReadInJoyUserInfoModule)localObject2).aMy();
                }
              }
              kxm.P(this.app);
              kxm.aHV();
              kwz.clearMemoryCache();
              if (VersionUtils.isM()) {
                a().getWindow().getDecorView().setSystemUiVisibility(1024);
              }
              anlm.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
              ThreadManager.getFileThreadHandler().removeCallbacks(this.cv);
              knj.a().pl(4);
              knj.a().mt(false);
              localKandianMergeManager.aIR();
              break;
              if (n == 13) {
                j = 6;
              }
            }
            bool = false;
          }
        }
      }
    }
  }
  
  public String setLastActivityName()
  {
    return acfp.m(2131695158);
  }
  
  public void tF(int paramInt)
  {
    if (paramInt == 13)
    {
      kxm.pX(6);
      Object localObject = a().getIntent().getExtras();
      if (ncs.q((Bundle)localObject))
      {
        localObject = ncs.a((Bundle)localObject);
        if (localObject != null)
        {
          this.c.setDataSource((nss)localObject);
          this.c.i((nss)localObject);
          this.c.postDelayed(new ReadinjoyTabFrame.32(this), 1000L);
        }
      }
    }
  }
  
  static class InitWebProcessRunnable
    implements Runnable
  {
    private long lastPreloadTime;
    private WeakReference<ReadinjoyTabFrame> mWeakReference;
    
    public void i(ReadinjoyTabFrame paramReadinjoyTabFrame)
    {
      this.mWeakReference = new WeakReference(paramReadinjoyTabFrame);
    }
    
    public void run()
    {
      if (WebProcessManager.aFS()) {}
      do
      {
        do
        {
          return;
        } while ((System.currentTimeMillis() - this.lastPreloadTime <= 1000L) || (this.mWeakReference == null) || (this.mWeakReference.get() == null));
        ReadinjoyTabFrame localReadinjoyTabFrame = (ReadinjoyTabFrame)this.mWeakReference.get();
        localWebProcessManager = (WebProcessManager)localReadinjoyTabFrame.app.getManager(13);
        if (localWebProcessManager != null)
        {
          i = kxm.nS();
          if (!kxm.AO()) {}
        }
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
          localHashMap.put("param_totalMem", String.valueOf(aqgz.getSystemTotalMemory()));
          localHashMap.put("param_availableMem", String.valueOf(aqgz.getSystemAvaialbeMemory()));
          localHashMap.put("param_cpuNum", String.valueOf(aqgz.getCpuNumber()));
          localHashMap.put("param_cpuFreq", String.valueOf(aqgz.getCpuFrequency()));
          localHashMap.put("param_preloadLevel", String.valueOf(i));
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.4tab", 2, "preloadToolProcessReport:" + localHashMap.toString());
          }
          anpc.a(localReadinjoyTabFrame.a()).collectPerformance(localReadinjoyTabFrame.app.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("Q.readinjoy.4tab", 2, "", localException);
            continue;
            if (i == 2) {
              localWebProcessManager.Yc(201);
            }
          }
        }
        if (i != 1) {
          break;
        }
        localWebProcessManager.Yc(200);
        this.lastPreloadTime = System.currentTimeMillis();
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.4tab", 2, "enter folder preload web process");
    }
  }
  
  public static abstract interface a
  {
    public abstract void dk(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */