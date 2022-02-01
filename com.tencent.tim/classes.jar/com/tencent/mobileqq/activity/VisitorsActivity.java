package com.tencent.mobileqq.activity;

import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import aalb;
import accn;
import acff;
import acfp;
import acgx;
import aclh;
import ahyo;
import ahyp;
import ahyq;
import ajqh;
import ajrs;
import ajrw;
import akjp;
import aklk;
import alem;
import alen;
import alhr;
import alht;
import amfh;
import amhj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqcx;
import aqdf;
import aqdf.a;
import aqep;
import aqhu;
import aqiw;
import aqmr;
import aqnc;
import aqnm;
import aqqj;
import aqrw;
import arjh;
import auuo;
import com.nineoldandroids.animation.ObjectAnimator;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.CardProfile.a;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.a;
import com.tencent.mobileqq.vas.ZanBannerView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.c;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import jqg;
import wfz;
import wga;
import wgb;
import wgc;
import wgd;
import wge;
import wgf;
import wgg;
import wgh;
import wgi;
import wgj;
import wgk;
import wgl;
import wgm;
import wgn;
import wgp;
import wgq;
import wgr;
import wgs;
import wgt;
import wgu;
import wja;

public class VisitorsActivity
  extends IphoneTitleBarActivity
  implements alht, View.OnClickListener, aqdf.a, auuo, PraiseManager.a, SwipListView.c
{
  public long HA = -1L;
  long HB = 0L;
  long HC = 0L;
  public long HD = 0L;
  public TextView He;
  TextView Hf;
  public TextView Hg;
  TextView Hh;
  public long Hz = -1L;
  String Rs;
  acgx jdField_a_of_type_Acgx;
  ahyq jdField_a_of_type_Ahyq;
  public ajrs a;
  akjp jdField_a_of_type_Akjp;
  public alhr a;
  private amhj jdField_a_of_type_Amhj;
  aqdf jdField_a_of_type_Aqdf;
  ObjectAnimator jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator;
  b jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$b;
  public d a;
  public CardHandler a;
  public NearbyZanAnimLayout a;
  ZanBannerView jdField_a_of_type_ComTencentMobileqqVasZanBannerView;
  TabBarView.a jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$a = new wgj(this);
  public ViewGroup aM;
  String aRU;
  public int aih = -1;
  ajrw jdField_b_of_type_Ajrw = new wgd(this);
  aklk jdField_b_of_type_Aklk = new wge(this);
  private amfh jdField_b_of_type_Amfh = new wgb(this);
  public d b;
  int bKH = -1;
  int bMQ;
  int bMR;
  int bMS;
  int bMT;
  public int bMU = 0;
  private int bMV;
  public boolean bbZ = false;
  boolean bca;
  public boolean bcb;
  boolean bcc = false;
  public boolean bcd = false;
  boolean bce = false;
  boolean bcf = true;
  public boolean bcg;
  SparseArray<Pair<Point, Boolean>> bq = new SparseArray();
  private AtomicBoolean bw = new AtomicBoolean(true);
  private AtomicBoolean bx = new AtomicBoolean(false);
  protected acff c;
  private aclh jdField_c_of_type_Aclh = new wgn(this);
  TabBarView jdField_c_of_type_ComTencentMobileqqWidgetTabBarView;
  accn cardObserver = new wgc(this);
  TabBarView d;
  Bitmap dk;
  public SwipListView e;
  public Runnable ee;
  private PullRefreshHeader g;
  HashMap<String, ImageView> gG = new HashMap();
  RelativeLayout hm;
  public volatile boolean init = false;
  int mFrom;
  public Handler mHandler = new wfz(this);
  public Random mRandom;
  public ViewGroup mRootView;
  int mScreenHeight;
  private int mScreenWidth;
  public int mWaveCount = 5;
  public AlphaAnimation o;
  public boolean ob = false;
  public AlphaAnimation p;
  public ArrayList<CardProfile> pV = new ArrayList();
  public ArrayList<CardProfile> pW = new ArrayList();
  public ImageView rF;
  public ImageView rG;
  public ImageView rH;
  public ImageView rI;
  public ImageView rJ;
  public ImageView rK;
  protected String toUin;
  View vS;
  View vT;
  View vU;
  public View vV;
  View vW;
  public View vX;
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, TextView paramTextView)
  {
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167366));
    VipOpenInfo localVipOpenInfo;
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label87;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130851502);
      paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167439));
    }
    label87:
    do
    {
      return;
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130851502);
        paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167439));
        return;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130851889);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167439));
  }
  
  private void a(CardProfile paramCardProfile)
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(String.valueOf(paramCardProfile.lEctID), 41);
    localAllInOne.nickname = paramCardProfile.strNick;
    localAllInOne.age = paramCardProfile.bAage;
    localAllInOne.gender = paramCardProfile.bSex;
    localAllInOne.faceId = paramCardProfile.wFace;
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, String.format("openProfileCard nickname=%s likeSource=%s", new Object[] { paramCardProfile.strNick, Long.valueOf(paramCardProfile.uSource) }));
    }
    if (this.jdField_c_of_type_Acff.isFriend(localAllInOne.uin))
    {
      localAllInOne.pa = 1;
      localAllInOne.Gz = 1L;
      ProfileActivity.a(this, localAllInOne, 1023);
      return;
    }
    if (paramCardProfile.uSource == 53L)
    {
      localAllInOne.pa = 96;
      ProfileActivity.a(this, localAllInOne, 1023);
      return;
    }
    if (this.aih == 0)
    {
      localAllInOne.bJa = 16;
      if ((paramCardProfile.uSource > 0L) && (paramCardProfile.uSource <= 48L)) {
        break label296;
      }
    }
    label296:
    for (localAllInOne.Gz = 6L;; localAllInOne.Gz = paramCardProfile.uSource)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("param_mode", 3);
      int i = getIntent().getIntExtra("frome_where", 6);
      Intent localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", localAllInOne);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("frome_where", i);
      localIntent.addFlags(268435456);
      startActivityForResult(localIntent, 1023);
      this.HC = paramCardProfile.lEctID;
      return;
      localAllInOne.bJa = 38;
      break;
    }
  }
  
  private Bitmap af()
  {
    if (this.dk == null) {
      this.dk = aqhu.aI();
    }
    return this.dk;
  }
  
  private void b(TextView paramTextView, int paramInt)
  {
    arjh localarjh = new arjh(getResources(), this.jdField_a_of_type_Amhj.i(paramInt, 200), false, false);
    if (this.bMV == 0) {
      this.bMV = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localarjh.setBounds(0, 0, this.bMV, this.bMV);
    paramTextView.setCompoundDrawables(localarjh, null, null, null);
  }
  
  private long ek()
  {
    return getActivity().getSharedPreferences("visitors_last_refresh_time", 0).getLong("visitors_last_refresh_time", 0L);
  }
  
  private long el()
  {
    return getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).getLong("favoritors_last_refresh_time", 0L);
  }
  
  private void fP(long paramLong)
  {
    getActivity().getSharedPreferences("visitors_last_refresh_time", 0).edit().putLong("visitors_last_refresh_time", paramLong).commit();
  }
  
  private void fQ(long paramLong)
  {
    getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).edit().putLong("favoritors_last_refresh_time", paramLong).commit();
  }
  
  private void initData()
  {
    this.jdField_a_of_type_Alhr = new alhr(this, this.mHandler, this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d = new d(this, this.app, this, 0, this.bca);
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d = new d(this, this.app, this, 1, this.bca);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init visitors");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.cV(this.pV);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init favorite");
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.cV(this.pW);
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.aRW = getString(2131696264);
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.aRW = getString(2131696222);
    startTitleProgress();
    this.aRU = getResources().getString(2131701536);
  }
  
  @TargetApi(11)
  private void initUI()
  {
    setRightButton(2131719875, this);
    Object localObject1 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
    this.aM = ((ViewGroup)findViewById(2131369269));
    this.aM.getViewTreeObserver().addOnGlobalLayoutListener(new wgp(this));
    this.e = ((SwipListView)findViewById(2131382052));
    this.e.setContentBackground(getResources().getDrawable(2130838900), false);
    this.g = ((PullRefreshHeader)getLayoutInflater().inflate(2131559847, this.e, false));
    this.e.setOverScrollHeader(this.g);
    this.e.setOverScrollListener(this);
    this.e.setSwipListListener(this);
    this.e.setDragEnable(true);
    this.e.setSelector(2131167595);
    this.e.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)findViewById(2131372253));
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.setEnabled(false);
    if (this.bca)
    {
      this.vg.setBackgroundResource(2131167695);
      localObject1 = getResources().getColorStateList(2131165412);
      this.leftView.setTextColor((ColorStateList)localObject1);
      this.leftView.setBackgroundResource(2130838937);
      this.rightViewText.setTextColor((ColorStateList)localObject1);
      this.rightViewText.setBackgroundDrawable(null);
      this.mRootView = ((ViewGroup)findViewById(2131370725));
      this.mRootView.setBackgroundResource(2131167695);
      this.bcc = this.jdField_a_of_type_Acgx.aaz();
      this.bMT = aqnm.dpToPx(46.0F);
      this.g.setArrowColor(1);
      this.Rs = getString(2131696213);
      this.centerView.setText("");
      this.mScreenHeight = aqnm.getScreenHeight();
      localObject1 = LayoutInflater.from(this).inflate(2131561412, null);
      this.vU = ((View)localObject1).findViewById(2131377489);
      this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView = ((ZanBannerView)((View)localObject1).findViewById(2131382427));
      ((View)localObject1).findViewById(2131377525).setOnClickListener(this);
      this.Hf = ((TextView)((View)localObject1).findViewById(2131380777));
      this.Hg = ((TextView)((View)localObject1).findViewById(2131380591));
      this.Hh = ((TextView)((View)localObject1).findViewById(2131380900));
      this.vV = ((View)localObject1).findViewById(2131369877);
      this.hm = ((RelativeLayout)((View)localObject1).findViewById(2131377505));
      int i = Math.round(aqnm.getScreenWidth() * 0.29F);
      Object localObject2 = (RelativeLayout.LayoutParams)this.Hf.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = i;
      this.Hf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.Hh.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = i;
      this.Hh.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.rF = ((ImageView)((View)localObject1).findViewById(2131369866));
      this.He = ((TextView)((View)localObject1).findViewById(2131369868));
      this.rG = ((ImageView)((View)localObject1).findViewById(2131369865));
      this.vU.setOnTouchListener(new wgq(this));
      this.rH = ((ImageView)((View)localObject1).findViewById(2131369796));
      this.rI = ((ImageView)((View)localObject1).findViewById(2131369797));
      this.rJ = ((ImageView)((View)localObject1).findViewById(2131369798));
      this.rK = ((ImageView)((View)localObject1).findViewById(2131369799));
      this.vW = ((View)localObject1).findViewById(2131377401);
      if ((this.bcc) && (VersionUtils.isHoneycomb())) {
        this.vW.setVisibility(0);
      }
      this.vX = ((View)localObject1).findViewById(2131369961);
      this.bMS = (-ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
      this.bMR = (aqnm.getScreenWidth() / 2);
      this.e.addHeaderView((View)localObject1);
      localObject2 = new wgr(this);
      this.o = new AlphaAnimation(0.0F, 1.0F);
      this.o.setDuration(300L);
      this.o.setInterpolator(this, 17432581);
      this.o.setAnimationListener((Animation.AnimationListener)localObject2);
      this.p = new AlphaAnimation(1.0F, 0.0F);
      this.p.setDuration(300L);
      this.p.setInterpolator(this, 17432581);
      this.p.setAnimationListener((Animation.AnimationListener)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$b = new b();
      this.e.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$b);
      this.d = ((TabBarView)((View)localObject1).findViewById(2131379121));
      this.d.a(0, getString(2131721877));
      this.d.a(1, getString(2131694718));
      this.d.setSelectedTab(0, false);
      this.d.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$a);
      bXV();
      localObject1 = this.jdField_a_of_type_Acgx.a();
      c(true, ((LikeRankingInfo)localObject1).likeCountOfToday, ((LikeRankingInfo)localObject1).rankingNum, ((LikeRankingInfo)localObject1).totalLikeCount);
    }
    this.e.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d);
    if (this.bca) {
      findViewById(2131377249).setVisibility(8);
    }
    for (this.jdField_c_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131367237));; this.jdField_c_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131377249)))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131721877));
      this.jdField_c_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131694718));
      this.jdField_c_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$a);
      this.jdField_c_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      ThreadManager.postImmediately(new VisitorsActivity.9(this), null, true);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(13, 1, 0));
      return;
    }
  }
  
  public void BT(int paramInt)
  {
    if (this.aih == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "[switchToTab] same tab return");
      }
      return;
    }
    if ((this.bca) && (QLog.isColorLevel())) {
      QLog.d("VisitorsActivity", 2, "[switchToTab]tab=" + paramInt + ", top1=" + this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$b.mLastTop + ", visible1=" + this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$b.bch);
    }
    this.aih = paramInt;
    if (paramInt == 0)
    {
      this.e.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d);
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
      ahyp.a(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
      this.mHandler.removeMessages(8);
      this.mHandler.sendEmptyMessage(8);
    }
    for (;;)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$b.mLastTop;
      this.e.setSelectionFromTop(0, -paramInt);
      if (!this.bca) {
        break;
      }
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetTabBarView.qt() != this.aih) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.aih, false);
      }
      if (this.d.qt() == this.aih) {
        break;
      }
      this.d.setSelectedTab(this.aih, false);
      return;
      if (paramInt == 1)
      {
        anot.c(this.app, "CliOper", "", "", "0X8004448", "0X8004448", 0, 0, "", "", "", "");
        this.e.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d);
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
        ahyp.a(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
        Collections.sort(this.pW, new CardProfile.a());
        this.mHandler.removeMessages(7);
        this.mHandler.sendEmptyMessage(7);
        if (VersionUtils.isOreo())
        {
          View localView = getCurrentFocus();
          if (localView != null) {
            localView.clearFocus();
          }
        }
        if (this.bcf)
        {
          this.bcf = false;
          startTitleProgress();
          if (!aqiw.isNetSupport(this))
          {
            this.mHandler.sendEmptyMessageDelayed(2, 1000L);
            return;
          }
          aq(true);
        }
      }
    }
  }
  
  public void BU(int paramInt)
  {
    if (isFinishing()) {
      QLog.d("VisitorsActivity", 1, "doPraiseMallEntryAnim isFinishing return");
    }
    do
    {
      do
      {
        return;
        if ((alem.O != null) && (!alem.O.isEmpty())) {
          break;
        }
      } while (paramInt <= 0);
      ThreadManager.executeOnFileThread(new VisitorsActivity.13(this));
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView == null);
    this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView.setInfoList(alem.O);
    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "banner_pageview", "", 1, 0, 0, "", "", "");
  }
  
  public void R(View paramView, int paramInt)
  {
    int i = paramView.getScrollX();
    if ((paramInt >= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d != null) && (this.bKH == paramInt)) {
      paramView.scrollTo(0, 0);
    }
    for (;;)
    {
      paramView.setTag(-3, Integer.valueOf(getResources().getDimensionPixelSize(2131298930)));
      return;
      if (i != 0) {
        paramView.scrollTo(0, 0);
      }
    }
  }
  
  int a(CardProfile paramCardProfile, String paramString)
  {
    boolean bool = ((acff)this.app.getManager(51)).isFriend(paramString);
    int i;
    switch (paramCardProfile.bMutualFriends)
    {
    default: 
      if ((!bool) && (paramCardProfile.bCloseNeighborVote == 1)) {
        i = 10;
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorsActivity", 2, String.format("getVoteLevel visibility=%d uin=%s isFrd=%b mutual=%d ", new Object[] { Integer.valueOf(i), paramString, Boolean.valueOf(bool), Byte.valueOf(paramCardProfile.bMutualFriends) }));
      }
      return i;
      if (paramCardProfile.bAvailableCnt > 0L)
      {
        i = 0;
      }
      else if (paramCardProfile.bTodayVotedCnt > 0L)
      {
        i = 2;
      }
      else
      {
        i = -1;
        continue;
        if (paramCardProfile.bCloseNeighborVote == 1)
        {
          i = 10;
        }
        else if (paramCardProfile.bAvailableCnt > 0L)
        {
          i = 0;
        }
        else if (paramCardProfile.bTodayVotedCnt > 0L)
        {
          i = 2;
        }
        else
        {
          i = -2;
          continue;
          if (paramCardProfile.bAvailableCnt > 0L) {
            i = 0;
          } else if (paramCardProfile.bTodayVotedCnt > 0L) {
            i = 2;
          } else {
            i = -3;
          }
        }
      }
    }
  }
  
  CharSequence a(CardProfile paramCardProfile, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    Object localObject2 = this.aRU;
    Object localObject1;
    if (paramCardProfile.type == 2)
    {
      localObject1 = acfp.m(2131716841);
      localObject2 = new SpannableString(String.format((String)localObject2, new Object[] { localObject1, Short.valueOf(paramCardProfile.bVoteCnt) }));
      if (paramCardProfile.dwLikeCustomId <= 0L) {
        break label297;
      }
      localObject1 = (PraiseManager)this.app.getManager(209);
      ((PraiseManager)localObject1).a(this);
      if (!paramBoolean) {
        break label278;
      }
      localObject1 = (alen)((PraiseManager)localObject1).o.get(Integer.valueOf((int)paramCardProfile.dwLikeCustomId));
      label113:
      if ((localObject1 == null) || (TextUtils.isEmpty(((alen)localObject1).text))) {
        break label302;
      }
      localObject2 = SpannableString.valueOf(TextUtils.concat(new CharSequence[] { ((alen)localObject1).text, localObject2 }));
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(((alen)localObject1).color), 0, ((alen)localObject1).text.length(), 33);
      if (((alen)localObject1).fQ == null) {
        break label308;
      }
      a(paramTextView, ((alen)localObject1).fQ, ((alen)localObject1).color);
    }
    label278:
    label297:
    label302:
    label308:
    for (i = 1;; i = 0)
    {
      paramTextView.setOnClickListener(new wga(this, paramCardProfile, (alen)localObject1, paramInt));
      paramTextView.setClickable(true);
      for (paramCardProfile = (CardProfile)localObject2;; paramCardProfile = (CardProfile)localObject2)
      {
        if (i == 0) {
          paramTextView.setCompoundDrawables(null, null, null, null);
        }
        return paramCardProfile;
        if (paramCardProfile.bSex == 1)
        {
          localObject1 = acfp.m(2131716842);
          break;
        }
        localObject1 = acfp.m(2131716844);
        break;
        localObject1 = ((PraiseManager)localObject1).a((int)paramCardProfile.dwLikeCustomId, true, "from_profile_card");
        break label113;
        paramTextView.setOnClickListener(null);
      }
    }
  }
  
  public void a(int paramInt1, alen paramalen, int paramInt2, String paramString)
  {
    paramInt2 = 0;
    if (paramInt1 == 0) {}
    label92:
    label103:
    CardProfile localCardProfile;
    label156:
    do
    {
      do
      {
        int i;
        do
        {
          return;
          paramString = (Pair)this.bq.get(paramInt1);
          if (paramString != null)
          {
            a(paramalen, ((Point)paramString.first).x, ((Point)paramString.first).y, ((Boolean)paramString.second).booleanValue(), false);
            this.bq.remove(paramInt1);
          }
          paramString = this.e;
          if (this.aih != 0) {
            break;
          }
          paramalen = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d;
          i = paramString.getFirstVisiblePosition();
        } while (paramalen == null);
        if (paramInt2 < paramalen.mList.size())
        {
          localCardProfile = paramalen.a(paramInt2);
          if (localCardProfile != null) {
            break label156;
          }
        }
        while (localCardProfile.dwLikeCustomId != paramInt1)
        {
          paramInt2 += 1;
          break label103;
          break;
          if (this.aih == 1)
          {
            paramalen = this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d;
            break label92;
          }
          paramalen = null;
          break label92;
        }
        paramalen = paramString.getChildAt(paramInt2 - i + paramString.getHeaderViewsCount());
      } while (paramalen == null);
      paramalen = (TextView)paramalen.findViewById(2131381025);
    } while (paramalen == null);
    a(localCardProfile, paramalen, true, paramInt2);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = this.g;
    if (this.aih == 0) {}
    for (long l = ek();; l = el())
    {
      paramView.Q(l);
      return;
    }
  }
  
  public void a(alen paramalen, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramalen != null) {
      if ((!paramBoolean1) && (paramalen.fS != null)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(paramalen, paramalen.fS, this.app, this.jdField_a_of_type_Ahyq.a(2, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.b), paramFloat1 - aqcx.dip2px(this, 20.0F), paramFloat2 - aqcx.dip2px(this, 20.0F), aqcx.dip2px(this, 75.0F), aqcx.dip2px(this, 65.0F));
      }
    }
    while (paramBoolean2)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(paramalen, paramalen.fR, paramFloat1, paramFloat2);
      return;
    }
    if (!paramBoolean1) {}
    for (int i = 2;; i = 1)
    {
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_Ahyq.a(i, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.b).ax(), this.app, this.jdField_a_of_type_Ahyq.a(i, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.b), paramFloat1 - aqcx.dip2px(this, 20.0F), paramFloat2 - aqcx.dip2px(this, 20.0F), aqcx.dip2px(this, 75.0F), aqcx.dip2px(this, 65.0F));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_Ahyq.a(i, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.b).ax(), paramFloat1, paramFloat2);
      return;
    }
  }
  
  public void a(alen paramalen, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.bcg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "doPraiseAnim, mIsPraiseAnimating=true");
      }
      return;
    }
    paramalen = this.mHandler.obtainMessage(11, paramInt2, paramInt3, new Object[] { Integer.valueOf(paramInt1), paramalen });
    this.mHandler.sendMessage(paramalen);
    this.bcg = true;
  }
  
  public void a(ImageView paramImageView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    PraiseManager localPraiseManager = (PraiseManager)this.app.getManager(209);
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationInWindow(arrayOfInt);
    float f1 = arrayOfInt[0] + paramImageView.getPaddingLeft();
    float f2 = arrayOfInt[1] - this.bMU + paramImageView.getPaddingTop();
    if ((paramBoolean2) && (localPraiseManager.o.get(Integer.valueOf(paramInt)) == null))
    {
      localPraiseManager.a(this);
      this.bq.put(paramInt, new Pair(new Point((int)f1, (int)f2), Boolean.valueOf(paramBoolean1)));
    }
    a(localPraiseManager.a(paramInt, paramBoolean2, "from_profile_card"), f1, f2, paramBoolean1, paramBoolean2);
  }
  
  void a(TextView paramTextView, Bitmap paramBitmap, int paramInt)
  {
    paramBitmap = jqg.d(new BitmapDrawable(getResources(), paramBitmap), paramInt);
    paramInt = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
    paramBitmap.setBounds(0, 0, paramInt, paramInt);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
    paramTextView.setCompoundDrawablePadding(5);
  }
  
  void a(String paramString, int paramInt, ImageView paramImageView)
  {
    if (this.jdField_c_of_type_Acff.isFriend(paramString))
    {
      localBitmap2 = this.jdField_a_of_type_Aqdf.b(1, paramString);
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        this.jdField_a_of_type_Aqdf.i(paramString, 1, false);
        localBitmap1 = af();
      }
      paramImageView.setImageBitmap(localBitmap1);
      return;
    }
    Bitmap localBitmap2 = this.jdField_a_of_type_Aqdf.a(32, paramString, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_Aqdf.a(paramString, 200, true, false);
      localBitmap1 = af();
    }
    paramImageView.setImageBitmap(localBitmap1);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Visitor", 2, "onViewCompleteVisableAndReleased");
    }
    if (!this.init)
    {
      if (this.aih == 0) {
        this.mHandler.sendEmptyMessage(1);
      }
      for (;;)
      {
        aL(0, acfp.m(2131716846));
        return true;
        this.mHandler.sendEmptyMessage(4);
      }
    }
    paramView = this.g;
    if (this.aih == 0) {}
    for (long l = ek();; l = el())
    {
      paramView.S(l);
      if (stopTitleProgress()) {
        break;
      }
      if (aqiw.isNetSupport(this)) {
        break label125;
      }
      this.mHandler.sendEmptyMessageDelayed(2, 1000L);
      return true;
    }
    label125:
    if (this.aih == 0)
    {
      ap(true);
      return true;
    }
    aq(true);
    return true;
  }
  
  public void aA(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof a))) {}
    do
    {
      return;
      if ((Thread.currentThread() != Looper.getMainLooper().getThread()) && (QLog.isColorLevel())) {
        QLog.i("VisitorsActivity", 2, "warning!!!!!! onRightBtnClick not in main thread");
      }
      if (this.aih == 0)
      {
        paramObject = (a)paramObject;
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.b(paramObject.position);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
        if (paramObject != null) {
          this.jdField_a_of_type_Alhr.aQ(paramObject.lEctID, 1);
        }
        anot.a(this.app, "dc00898", "", "", "0X8009702", "0X8009702", 0, 0, "", "", "", "");
        return;
      }
    } while (this.aih != 1);
    paramObject = (a)paramObject;
    paramObject = this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.b(paramObject.position);
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
    if (paramObject != null) {
      this.jdField_a_of_type_Alhr.aQ(paramObject.lEctID, 0);
    }
    anot.a(this.app, "dc00898", "", "", "0X8009703", "0X8009703", 0, 0, "", "", "", "");
  }
  
  public void aB(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (this.aih != 0) {
            break;
          }
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            anot.c(this.app, "CliOper", "", "", "0X800444A", "0X800444A", 0, 0, "", "", "", "");
            a((CardProfile)paramObject.data);
            return;
          }
        } while (!(paramObject instanceof c));
        loadMore();
        return;
      } while (this.aih != 1);
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        anot.c(this.app, "CliOper", "", "", "0X8004447", "0X8004447", 0, 0, "", "", "", "");
        a((CardProfile)paramObject.data);
        return;
      }
    } while (!(paramObject instanceof c));
    bXS();
  }
  
  public void aL(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).show(getTitleBarHeight());
    }
  }
  
  public void al(boolean paramBoolean)
  {
    Object localObject;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)this.mFlingHandler;
      if (((FlingGestureHandler)localObject).mTopLayout != null)
      {
        localObject = ((FlingGestureHandler)localObject).mTopLayout;
        if (paramBoolean) {
          break label49;
        }
      }
    }
    label49:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
      return;
    }
  }
  
  public void an(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.bca) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "updateRank todayVoteRank=" + paramInt1 + ", todayVoteRank=" + paramInt2 + ", totalVoteCount=" + paramInt3);
    }
    Message localMessage = this.mHandler.obtainMessage(10);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    Bundle localBundle = new Bundle();
    localBundle.putInt("totalVoteCount", paramInt3);
    localMessage.setData(localBundle);
    if (this.bce)
    {
      this.mHandler.sendMessageDelayed(localMessage, 200L);
      return;
    }
    this.mHandler.sendMessage(localMessage);
  }
  
  public boolean ap(boolean paramBoolean)
  {
    String str = this.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      this.ob = true;
      this.Hz = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.g(str, this.toUin, 0L, 30);
    }
    while (this.Hz <= -1L) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.g(str, this.toUin, this.Hz, 30);
    return true;
  }
  
  public boolean aq(boolean paramBoolean)
  {
    String str = this.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      this.bbZ = true;
      this.HA = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.f(str, this.toUin, 0L, 30);
    }
    while (this.HA <= -1L) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.f(str, this.toUin, this.HA, 30);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    paramView = this.g;
    if (this.aih == 0) {}
    for (long l = ek();; l = el())
    {
      paramView.R(l);
      return;
    }
  }
  
  void bXS()
  {
    if (!aqiw.isNetSupport(this))
    {
      aL(1, getString(2131696272));
      return;
    }
    aq(false);
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bci = true;
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
  }
  
  public void bXT()
  {
    this.ob = false;
    QQToast.a(this, 1, 2131720480, 0).show(getTitleBarHeight());
    yk(false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bci)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bci = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
    }
    if (this.bca) {
      this.vW.setVisibility(0);
    }
  }
  
  public void bXU()
  {
    this.bbZ = false;
    QQToast.a(this, 1, 2131720480, 0).show(getTitleBarHeight());
    yl(false);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bci)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bci = false;
      this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
    }
  }
  
  public void bXV()
  {
    RedTouchItem localRedTouchItem = this.jdField_a_of_type_Akjp.a(100601);
    if (this.jdField_a_of_type_Akjp.a(localRedTouchItem, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "updateRedPoint level:" + localRedTouchItem.passThroughLevel);
      }
      this.vV.setVisibility(0);
    }
  }
  
  public void bXW()
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.cV(this.pW);
      this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VisitorsActivity", 1, "updateFavData fail.", localException);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(ArrayList<CardProfile> paramArrayList, long paramLong)
  {
    this.pV.clear();
    this.pV.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onVisitorListOk");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.cV(this.pV);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onVisitorListOk");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bci = false;
    this.ob = false;
    if (paramLong == 0L) {
      yk(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
  }
  
  @TargetApi(11)
  public void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0) {
      this.Hf.setText(paramInt1 + "");
    }
    if (paramInt1 == 0)
    {
      this.Hh.setText(acfp.m(2131716845));
      this.Hh.setTextSize(1, 18.0F);
      this.Hh.setTypeface(this.Hh.getTypeface(), 1);
      localObject = (RelativeLayout.LayoutParams)this.Hh.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, aqnm.dpToPx(7.0F));
      if (!paramBoolean) {
        break label306;
      }
      if (paramInt3 > 0)
      {
        this.Hg.setText(paramInt3 + "");
        if (paramInt3 <= 9999) {
          break label293;
        }
        this.Hg.setTextSize(36.0F);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Acgx.aE(paramInt1, paramInt2, paramInt3);
      if ((!paramBoolean) && (!this.bcc)) {
        break label1490;
      }
      if ((!paramBoolean) || (!this.bcc)) {
        break label458;
      }
      return;
      if (paramInt2 <= 0) {
        break;
      }
      this.Hh.setText(String.valueOf(paramInt2));
      this.Hh.setTextSize(1, 30.0F);
      this.Hh.setTypeface(Typeface.MONOSPACE);
      this.Hh.setTypeface(this.Hh.getTypeface(), 0);
      localObject = (RelativeLayout.LayoutParams)this.Hh.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, aqnm.dpToPx(5.0F));
      break;
      label293:
      this.Hg.setTextSize(44.0F);
    }
    label306:
    Object localObject = this.jdField_a_of_type_Acgx.a();
    if ((paramInt3 >= 0) && (paramInt3 > ((LikeRankingInfo)localObject).totalLikeCount))
    {
      if (((LikeRankingInfo)localObject).totalLikeCount > 0) {}
      for (i = ((LikeRankingInfo)localObject).totalLikeCount;; i = 0)
      {
        localObject = new aqnc(Integer.valueOf(i), Integer.valueOf(paramInt3), new wgf(this));
        ((aqnc)localObject).setStartOffset(200L);
        ((aqnc)localObject).setDuration(1200L);
        this.Hg.startAnimation((Animation)localObject);
        break;
      }
    }
    if (((LikeRankingInfo)localObject).totalLikeCount > 0) {}
    for (int i = ((LikeRankingInfo)localObject).totalLikeCount;; i = 0)
    {
      this.Hg.setText(i + "");
      break;
    }
    for (;;)
    {
      try
      {
        label458:
        this.rH.setImageResource(2130846259);
        this.rI.setImageResource(2130846260);
        this.rJ.setImageResource(2130846261);
        this.rK.setImageResource(2130848045);
        paramInt1 = aqnm.dpToPx(1.0F);
        if (paramBoolean)
        {
          localObject = new TranslateAnimation(0, paramInt1 * -299 + this.bMR, 0, paramInt1 * -299 + this.bMR, 0, paramInt1 * 42 + this.bMS, 0, paramInt1 * 42 + this.bMS);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new wgg(this));
          this.rH.startAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label1267;
          }
          localObject = new TranslateAnimation(0, paramInt1 * -217 + this.bMR, 0, paramInt1 * -217 + this.bMR, 0, paramInt1 * 47 + this.bMS, 0, paramInt1 * 47 + this.bMS);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new wgh(this));
          this.rI.startAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label1342;
          }
          localObject = new TranslateAnimation(0, paramInt1 * -2 + this.bMR, 0, paramInt1 * -15 + this.bMR, 0, paramInt1 * 50 + this.bMS, 0, paramInt1 * 50 + this.bMS);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new wgi(this));
          this.rJ.startAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label1416;
          }
          localObject = new TranslateAnimation(0, paramInt1 * 74 + this.bMR, 0, paramInt1 * 74 + this.bMR, 0, paramInt1 * 34 + this.bMS, 0, paramInt1 * 34 + this.bMS);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new wgk(this));
          this.rK.startAnimation((Animation)localObject);
          if (paramBoolean) {
            break;
          }
          this.bcc = false;
          this.jdField_a_of_type_Acgx.hz(NetConnInfoCenter.getServerTimeMillis());
          localObject = new AnimationSet(true);
          ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 5.0F, 1.0F, 5.0F, 1, 0.5F, 1, 0.5F);
          localScaleAnimation.setDuration(1800L);
          ((AnimationSet)localObject).addAnimation(localScaleAnimation);
          AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 0.8F);
          localAlphaAnimation1.setDuration(400L);
          ((AnimationSet)localObject).addAnimation(localAlphaAnimation1);
          AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.8F, 0.0F);
          localAlphaAnimation2.setDuration(1400L);
          localAlphaAnimation2.setStartOffset(400L);
          ((AnimationSet)localObject).addAnimation(localAlphaAnimation2);
          ((AnimationSet)localObject).setFillAfter(true);
          ((AnimationSet)localObject).setFillEnabled(true);
          if (this.ee == null) {
            this.ee = new VisitorsActivity.21(this, localScaleAnimation, localAlphaAnimation1, localAlphaAnimation2, (AnimationSet)localObject);
          }
          ((AnimationSet)localObject).setAnimationListener(new wgl(this));
          this.mWaveCount = 5;
          this.vX.startAnimation((Animation)localObject);
          this.vW.setVisibility(0);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("VisitorsActivity", 1, "load img oom");
        return;
      }
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -493 + this.bMR, 0, paramInt1 * -299 + this.bMR, 0, paramInt1 * 174 + this.bMS, 0, paramInt1 * 42 + this.bMS);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(500L);
      continue;
      label1267:
      localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -520 + this.bMR, 0, paramInt1 * -217 + this.bMR, 0, paramInt1 * 239 + this.bMS, 0, paramInt1 * 47 + this.bMS);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(350L);
      continue;
      label1342:
      localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -160 + this.bMR, 0, paramInt1 * -15 + this.bMR, 0, paramInt1 * 138 + this.bMS, 0, paramInt1 * 50 + this.bMS);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(200L);
      continue;
      label1416:
      localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -180 + this.bMR, 0, paramInt1 * 74 + this.bMR, 0, paramInt1 * 148 + this.bMS, 0, paramInt1 * 34 + this.bMS);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(300L);
    }
    label1490:
    this.vW.setVisibility(0);
  }
  
  public void d(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.bKH = i;
      return;
    }
  }
  
  public void d(ImageView paramImageView, boolean paramBoolean)
  {
    int i = PraiseManager.f(this.app);
    if (i > 0)
    {
      a(paramImageView, i, paramBoolean, true);
      return;
    }
    paramImageView.setVisibility(0);
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationInWindow(arrayOfInt);
    if (!paramBoolean) {}
    for (i = 2;; i = 1)
    {
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_Ahyq.a(i, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.b).ax(), this.app, this.jdField_a_of_type_Ahyq.a(i, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.b), arrayOfInt[0] + paramImageView.getPaddingLeft() - aqcx.dip2px(this, 20.0F), arrayOfInt[1] - this.bMU + paramImageView.getPaddingTop() - aqcx.dip2px(this, 20.0F), aqcx.dip2px(this, 75.0F), aqcx.dip2px(this, 65.0F));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_Ahyq.a(i, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.b).ax(), arrayOfInt[0] + paramImageView.getPaddingLeft(), arrayOfInt[1] - this.bMU + paramImageView.getPaddingTop());
      return;
    }
  }
  
  public void d(ArrayList<CardProfile> paramArrayList, long paramLong)
  {
    this.pW.clear();
    this.pW.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onFavoriteListOk");
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.cV(this.pW);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onFavoriteListOk");
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bci = false;
    this.bbZ = false;
    if (paramLong == 0L) {
      yl(true);
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1023) {}
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt1 == 1028)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "VisitorsActivity->doOnActivityResult, resultCode=" + paramInt2);
        }
        this.jdField_a_of_type_Ajrs.o(0L, 0L, 511);
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(2));
    this.jdField_a_of_type_Ajrs = ((ajrs)this.app.getBusinessHandler(60));
    this.jdField_c_of_type_Acff = ((acff)this.app.getManager(51));
    addObserver(this.cardObserver);
    addObserver(this.jdField_c_of_type_Aclh);
    paramBundle = this.app.getCurrentAccountUin();
    Intent localIntent = getIntent();
    this.toUin = String.valueOf(localIntent.getLongExtra("toUin", 0L));
    this.jdField_a_of_type_Acgx = ((acgx)this.app.getManager(186));
    this.bca = localIntent.getBooleanExtra("extra_show_rank", false);
    this.mFrom = localIntent.getIntExtra("extra_from", -1);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "mShowRank=" + this.bca);
    }
    this.jdField_a_of_type_Ahyq = new ahyq(this);
    if (this.bca)
    {
      this.jdField_a_of_type_Akjp = ((akjp)this.app.getManager(160));
      this.app.registObserver(this.jdField_b_of_type_Aklk);
      if (this.mFrom == 1) {
        ThreadManager.post(new VisitorsActivity.3(this), 5, null, false);
      }
    }
    if ((this.toUin != null) && (!paramBundle.equals(this.toUin))) {}
    this.Hz = getIntent().getLongExtra("nextMidVoter", -1L);
    setContentView(2131563332);
    initData();
    initUI();
    this.app.addObserver(this.jdField_b_of_type_Ajrw);
    this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
    this.jdField_a_of_type_Aqdf.a(this);
    this.jdField_a_of_type_Amhj = ((amhj)this.app.getManager(15));
    this.jdField_a_of_type_Amhj.addListener(this.jdField_b_of_type_Amfh);
    this.jdField_a_of_type_Ajrs.o(0L, 0L, 511);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator != null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.removeAllListeners();
      this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.cancel();
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    super.doOnDestroy();
    this.mHandler.removeCallbacksAndMessages(null);
    removeObserver(this.cardObserver);
    this.jdField_a_of_type_Amhj.removeListener(this.jdField_b_of_type_Amfh);
    removeObserver(this.jdField_c_of_type_Aclh);
    this.app.removeObserver(this.jdField_b_of_type_Ajrw);
    if (this.bca) {
      this.app.unRegistObserver(this.jdField_b_of_type_Aklk);
    }
    ((PraiseManager)this.app.getManager(209)).b(this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ApngImage.pauseAll();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(14);
    this.bcb = this.jdField_a_of_type_Acgx.aay();
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "doOnResume mPartakeRank=" + this.bcb);
    }
    yj(this.bcb);
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.cHy();
    }
    if ((this.bca) && (this.mSystemBarComp != null))
    {
      int i = getResources().getColor(2131165409);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
  }
  
  public void doOnStop()
  {
    if (this.mHandler.hasMessages(6))
    {
      this.mHandler.removeMessages(6);
      this.jdField_a_of_type_Alhr.dFZ();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
    }
    super.doOnStop();
  }
  
  public void fR(long paramLong)
  {
    SwipListView localSwipListView = this.e;
    d locald;
    int j;
    int i;
    if (this.aih == 1)
    {
      locald = this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d;
      j = localSwipListView.getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = localSwipListView.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof a)))
        {
          localObject = (a)localObject;
          if (((((a)localObject).data instanceof CardProfile)) && (((CardProfile)((a)localObject).data).lEctID == paramLong)) {
            d.a(locald, ((a)localObject).data, (a)localObject);
          }
        }
      }
      else
      {
        return;
        locald = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d;
        break;
      }
      i += 1;
    }
  }
  
  public void hi() {}
  
  void loadMore()
  {
    if (!aqiw.isNetSupport(this))
    {
      aL(1, getString(2131696272));
      return;
    }
    ap(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bci = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bMW > 0)) {
      anot.c(this.app, "CliOper", "", "", "0X8004446", "0X8004446", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bMW), "", "", "");
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bMW > 0)) {
      anot.c(this.app, "CliOper", "", "", "0X8004449", "0X8004449", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.bMW), "", "", "");
    }
    this.app.reportClickEvent("dc00898", "0X8007612");
    if ((this.mFrom == 2) && (this.toUin != null) && (this.toUin.equalsIgnoreCase(this.app.getCurrentAccountUin())))
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.toUin, 0);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("single_top", true);
      ProfileActivity.a(getActivity(), localAllInOne, localBundle);
      overridePendingTransition(2130772000, 2130772001);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      this.app.reportClickEvent("dc00898", "0X8007613");
      startActivity(new Intent(this, LikeSettingActivity.class));
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131369959)
      {
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof CardProfile)))
        {
          localObject1 = (CardProfile)localObject1;
          if (this.jdField_a_of_type_Alhr.a((CardProfile)localObject1, (ImageView)paramView))
          {
            localObject1 = Integer.toString(((CardProfile)localObject1).type);
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", (String)localObject1, "");
            localObject2 = new aqrw(this);
            ((aqrw)localObject2).a(new wgm(this, (String)localObject1));
            ((aqrw)localObject2).show();
          }
        }
      }
      else
      {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131377489: 
          anot.a(this.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
          startActivity(new Intent(this, LikeRankingListActivity.class));
          this.vV.setVisibility(8);
          this.vX.clearAnimation();
          this.mWaveCount = 0;
          this.mHandler.removeCallbacks(this.ee);
        }
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView.Cv();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = aqqj.o(this, "praise", "");
    }
    for (;;)
    {
      localObject2 = new Intent(this, QQBrowserActivity.class);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "banner_click", "", 1, 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView.Cw(), "");
      VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 536870912L, (Intent)localObject2, false, -1);
      anot.a(this.app, "CliOper", "", "", "like_mall", "like_enter", 0, 0, "", "", "", "");
      break;
    }
  }
  
  public View onCreateCenterView()
  {
    super.onCreateCenterView();
    this.centerView.setText(2131721811);
    return this.centerView;
  }
  
  public View onCreateRightView()
  {
    super.onCreateRightView();
    this.rightViewText.setVisibility(8);
    return this.rightViewText;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    long l = SystemClock.uptimeMillis() - this.HD;
    this.mHandler.removeMessages(3);
    if ((paramInt1 == 0) || (l >= 800L))
    {
      this.HD = SystemClock.uptimeMillis();
      if (this.aih == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
      return;
    }
    this.mHandler.sendEmptyMessageDelayed(3, 800L - l);
  }
  
  public void yj(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.vU != null)
      {
        this.vU.setVisibility(0);
        if (TextUtils.isEmpty(this.centerView.getText().toString())) {
          break label48;
        }
        this.centerView.setText(2131696213);
      }
    }
    label48:
    do
    {
      do
      {
        return;
        this.centerView.setText("");
        return;
      } while (this.vU == null);
      this.vU.setVisibility(8);
    } while (this.centerView == null);
    this.centerView.setText(2131696213);
  }
  
  void yk(boolean paramBoolean)
  {
    fP(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.mHandler.sendEmptyMessageDelayed(1, 800L);
        this.g.tT(0);
      }
    }
    else {
      return;
    }
    aL(1, getString(2131720480));
    this.e.springBackOverScrollHeaderView();
  }
  
  void yl(boolean paramBoolean)
  {
    fQ(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.mHandler.sendEmptyMessageDelayed(4, 800L);
        this.g.tT(0);
      }
    }
    else {
      return;
    }
    aL(1, getString(2131720480));
    this.e.springBackOverScrollHeaderView();
  }
  
  public static class a
  {
    TextView Hi;
    TextView Hj;
    TextView Hk;
    public TextView Hl;
    TextView Hm;
    TextView Hn;
    SimpleTextView a;
    public int actionId;
    Object data;
    LinearLayout gP;
    TextView hL;
    ImageView nv;
    int position;
    ImageView rL;
    ImageView rM;
  }
  
  class b
    implements AbsListView.e
  {
    boolean bch = true;
    int mLastTop = 0;
    
    b() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "mLastTop=" + this.mLastTop + ",mHeaderVisible=" + this.bch + ",firstVi=" + paramInt1);
      }
      paramAbsListView = paramAbsListView.getChildAt(0);
      boolean bool;
      label246:
      Object localObject;
      CharSequence localCharSequence;
      if ((paramAbsListView != null) && (paramInt1 == 0))
      {
        paramInt1 = 0;
        if (VisitorsActivity.this.vU.getVisibility() == 0) {
          paramInt1 = 0 + VisitorsActivity.this.vU.getHeight();
        }
        paramInt1 = (int)(paramInt1 + VisitorsActivity.a(VisitorsActivity.this) * 77.0F);
        paramInt2 = paramInt1 - VisitorsActivity.this.bMT;
        paramInt3 = Math.abs(paramAbsListView.getTop());
        if (QLog.isColorLevel())
        {
          if (VisitorsActivity.this.c.getVisibility() != 8) {
            break label344;
          }
          bool = true;
          QLog.d("VisitorsActivity", 2, String.format("sumH=%d top=%d offset=%d tabBarShow=%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Boolean.valueOf(bool) }));
        }
        if ((paramInt3 <= this.mLastTop) || (paramInt3 < paramInt1) || (VisitorsActivity.this.c.getVisibility() != 8)) {
          break label350;
        }
        this.bch = false;
        VisitorsActivity.this.c.setVisibility(0);
        localObject = null;
        localCharSequence = VisitorsActivity.this.centerView.getText();
        if ((paramInt3 <= this.mLastTop) || (paramInt3 < paramInt2) || (!"".equals(localCharSequence))) {
          break label398;
        }
        paramAbsListView = VisitorsActivity.this.o;
      }
      for (;;)
      {
        if ((paramAbsListView != null) && (paramAbsListView != VisitorsActivity.this.centerView.getAnimation()))
        {
          paramAbsListView.reset();
          if (VisitorsActivity.this.bcb) {
            VisitorsActivity.this.centerView.startAnimation(paramAbsListView);
          }
        }
        this.mLastTop = paramInt3;
        return;
        label344:
        bool = false;
        break;
        label350:
        if ((paramInt3 >= this.mLastTop) || (paramInt3 > paramInt1) || (VisitorsActivity.this.c.getVisibility() != 0)) {
          break label246;
        }
        this.bch = true;
        VisitorsActivity.this.c.setVisibility(8);
        break label246;
        label398:
        paramAbsListView = localObject;
        if (paramInt3 < this.mLastTop)
        {
          paramAbsListView = localObject;
          if (paramInt3 <= paramInt2)
          {
            paramAbsListView = localObject;
            if (VisitorsActivity.this.Rs.equals(localCharSequence)) {
              paramAbsListView = VisitorsActivity.this.p;
            }
          }
        }
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if (VersionUtils.isOreo())
      {
        paramAbsListView = VisitorsActivity.this.getCurrentFocus();
        if (paramAbsListView != null) {
          paramAbsListView.clearFocus();
        }
      }
    }
  }
  
  static class c
  {
    ProgressBar K;
    TextView oM;
    ImageView rN;
  }
  
  public class d
    extends BaseAdapter
  {
    protected ajqh a;
    public alht a;
    int aDD;
    public String aRW;
    public int bMW;
    private int bMX;
    private int bMY;
    int bMZ;
    int bNa;
    int bNb;
    boolean bca;
    boolean bci;
    private boolean hasMore;
    LayoutInflater mInflater;
    List<CardProfile> mList = new ArrayList();
    private int tabType;
    
    public d(Context paramContext, QQAppInterface paramQQAppInterface, alht paramalht, int paramInt, boolean paramBoolean)
    {
      paramContext = VisitorsActivity.this.getResources();
      this.bMX = wja.dp2px(17.0F, paramContext);
      this.bMY = wja.dp2px(15.0F, paramContext);
      this.jdField_a_of_type_Alht = paramalht;
      this.tabType = paramInt;
      this.bca = paramBoolean;
      this.bMZ = wja.dp2px(38.0F, paramContext);
      this.bNa = wja.dp2px(86.0F, paramContext);
      this.aDD = wja.dp2px(60.0F, paramContext);
      this.jdField_a_of_type_Ajqh = ((ajqh)VisitorsActivity.this.app.getManager(207));
    }
    
    private void a(VisitorsActivity.a parama, CardProfile paramCardProfile)
    {
      TextView localTextView = parama.Hl;
      Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      if (parama.Hi.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, parama.Hi.getId());
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        int i = ((Integer)parama.rM.getTag(2131369959)).intValue();
        localObject = VisitorsActivity.this.a(paramCardProfile, parama.Hk, false, i);
        if (paramCardProfile.payVoteCount <= 0) {
          break label215;
        }
        parama.actionId = 0;
        parama.Hk.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
        if (this.tabType != 0) {
          break label206;
        }
      }
      label206:
      for (parama = acfp.m(2131716848);; parama = acfp.m(2131716849))
      {
        localTextView.setText(String.format("%s%d金豆", new Object[] { parama, Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
        localTextView.setVisibility(0);
        return;
        if (parama.Hj.getVisibility() == 0)
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(3, parama.Hj.getId());
          break;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(3, parama.hL.getId());
        break;
      }
      label215:
      parama.actionId = 0;
      localTextView.setVisibility(8);
      parama.Hk.setText((CharSequence)localObject);
    }
    
    private void a(VisitorsActivity.c paramc)
    {
      int j = 8;
      Object localObject = paramc.oM;
      if (this.bci)
      {
        i = 2131695458;
        ((TextView)localObject).setText(i);
        localObject = paramc.K;
        if (!this.bci) {
          break label72;
        }
        i = 0;
        label40:
        ((ProgressBar)localObject).setVisibility(i);
        paramc = paramc.rN;
        if (!this.bci) {
          break label78;
        }
      }
      label72:
      label78:
      for (int i = j;; i = 0)
      {
        paramc.setVisibility(i);
        return;
        i = 2131695992;
        break;
        i = 8;
        break label40;
      }
    }
    
    private void a(Object paramObject, VisitorsActivity.a parama)
    {
      if (paramObject == null) {
        return;
      }
      paramObject = (CardProfile)paramObject;
      String str = String.valueOf(paramObject.lEctID);
      parama.data = paramObject;
      Object localObject = aqmr.trim(String.valueOf(paramObject.strNick));
      parama.hL.setText((CharSequence)localObject);
      int i;
      if (paramObject.bAage > 0)
      {
        parama.Hi.setText(String.valueOf(paramObject.bAage));
        localObject = parama.Hi;
        if (paramObject.bSex != 1) {
          break label390;
        }
        i = 2130841201;
        label84:
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (paramObject.bSex != 1) {
          break label397;
        }
        parama.Hi.setBackgroundResource(2130846476);
        label111:
        if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12)) {
          break label410;
        }
        parama.Hj.setVisibility(8);
        label136:
        parama.rM.setTag(paramObject);
        i = VisitorsActivity.this.a(paramObject, str);
        if ((i != 0) && (i != 2)) {
          break label506;
        }
        parama.rM.setVisibility(0);
        if (paramObject.bTodayVotedCnt <= 0L) {
          break label493;
        }
        if (!this.jdField_a_of_type_Ajqh.ct(paramObject.lEctID)) {
          break label458;
        }
        if (paramObject.bAvailableCnt > 0L) {
          break label445;
        }
        parama.rM.setImageResource(2130843440);
        label214:
        parama.rM.setOnClickListener(VisitorsActivity.this);
        label225:
        a(parama, paramObject);
        if (TextUtils.isEmpty(paramObject.strTime)) {
          break label518;
        }
        parama.Hm.setText(paramObject.strTime);
        parama.Hm.setVisibility(0);
        label260:
        VisitorsActivity.a(paramObject.stVipInfo, parama.rL, parama.hL);
        if (!aalb.q(VisitorsActivity.this.app, str)) {
          break label530;
        }
        parama.Hn.setVisibility(0);
        label298:
        localObject = (RelativeLayout.LayoutParams)parama.Hl.getLayoutParams();
        if (parama.Hi.getVisibility() != 0) {
          break label542;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(3, parama.Hi.getId());
      }
      for (;;)
      {
        parama.Hl.setLayoutParams((ViewGroup.LayoutParams)localObject);
        VisitorsActivity.this.gG.put(str, parama.nv);
        VisitorsActivity.this.a(str, paramObject.wFace, parama.nv);
        return;
        parama.Hi.setText("");
        break;
        label390:
        i = 2130841206;
        break label84;
        label397:
        parama.Hi.setBackgroundResource(2130846485);
        break label111;
        label410:
        parama.Hj.setText(aqep.c(paramObject.bConstellation));
        parama.Hj.setBackgroundResource(2130846486);
        parama.Hj.setVisibility(0);
        break label136;
        label445:
        parama.rM.setImageResource(2130843442);
        break label214;
        label458:
        if (paramObject.bAvailableCnt <= 0L)
        {
          parama.rM.setImageResource(2130846782);
          break label214;
        }
        parama.rM.setImageResource(2130846792);
        break label214;
        label493:
        parama.rM.setImageResource(2130846779);
        break label214;
        label506:
        parama.rM.setVisibility(8);
        break label225;
        label518:
        parama.Hm.setVisibility(8);
        break label260;
        label530:
        parama.Hn.setVisibility(8);
        break label298;
        label542:
        if (parama.Hj.getVisibility() == 0) {
          ((RelativeLayout.LayoutParams)localObject).addRule(3, parama.Hj.getId());
        } else {
          ((RelativeLayout.LayoutParams)localObject).addRule(3, parama.gP.getId());
        }
      }
    }
    
    private View aO()
    {
      View localView = VisitorsActivity.this.getLayoutInflater().inflate(2131559672, null);
      VisitorsActivity.c localc = new VisitorsActivity.c();
      localc.oM = ((TextView)localView.findViewById(2131371975));
      localc.K = ((ProgressBar)localView.findViewById(2131377037));
      localc.rN = ((ImageView)localView.findViewById(2131370781));
      localView.setTag(localc);
      return localView;
    }
    
    private void bXX()
    {
      Rect localRect;
      if (VisitorsActivity.this.bMQ == 0)
      {
        localRect = new Rect();
        if ((VisitorsActivity.this.vU == null) || (VisitorsActivity.this.vU.getVisibility() != 0)) {
          break label141;
        }
      }
      label141:
      for (Object localObject = VisitorsActivity.this.vU;; localObject = VisitorsActivity.this.c)
      {
        ((View)localObject).getGlobalVisibleRect(localRect);
        int i = localRect.bottom;
        int j = VisitorsActivity.this.getResources().getDisplayMetrics().heightPixels;
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "init empty h " + VisitorsActivity.this.bMQ);
        }
        VisitorsActivity.this.bMQ = (j - i - wja.dp2px(75.0F, VisitorsActivity.this.getResources()));
        return;
      }
    }
    
    private View j(ViewGroup paramViewGroup)
    {
      paramViewGroup = VisitorsActivity.this.getLayoutInflater().inflate(2131559484, paramViewGroup, false);
      VisitorsActivity.a locala = new VisitorsActivity.a();
      locala.gP = ((LinearLayout)paramViewGroup.findViewById(2131380101));
      locala.nv = ((ImageView)paramViewGroup.findViewById(2131368698));
      locala.rL = ((ImageView)paramViewGroup.findViewById(2131382023));
      locala.hL = ((TextView)paramViewGroup.findViewById(2131379402));
      locala.Hj = ((TextView)paramViewGroup.findViewById(2131382392));
      locala.Hi = ((TextView)paramViewGroup.findViewById(2131370129));
      locala.Hk = ((TextView)paramViewGroup.findViewById(2131381025));
      locala.Hl = ((TextView)paramViewGroup.findViewById(2131365656));
      locala.Hm = ((TextView)paramViewGroup.findViewById(2131381028));
      locala.rM = ((ImageView)paramViewGroup.findViewById(2131369959));
      locala.Hn = ((TextView)paramViewGroup.findViewById(2131367695));
      locala.a = ((SimpleTextView)paramViewGroup.findViewById(2131363975));
      locala.a.setGravity(17);
      locala.a.setText(VisitorsActivity.this.getString(2131693962));
      locala.a.setTextSize(1, 16.0F);
      locala.a.setTextColor(-1);
      locala.a.setOnClickListener(new wgu(this, locala));
      paramViewGroup.findViewById(2131365322).getLayoutParams().width = VisitorsActivity.a(VisitorsActivity.this);
      paramViewGroup.setTag(locala);
      return paramViewGroup;
    }
    
    public CardProfile a(int paramInt)
    {
      if (paramInt < this.mList.size()) {
        return (CardProfile)this.mList.get(paramInt);
      }
      return null;
    }
    
    public CardProfile b(int paramInt)
    {
      if (paramInt < this.mList.size()) {
        return (CardProfile)this.mList.remove(paramInt);
      }
      return null;
    }
    
    public void cV(ArrayList<CardProfile> paramArrayList)
    {
      if ((paramArrayList == null) || (paramArrayList.size() < 1)) {
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet profiles empty:" + paramArrayList);
        }
      }
      int i;
      do
      {
        return;
        this.mList = paramArrayList;
        VisitorsActivity.this.bKH = -1;
        i = this.bNa * this.mList.size();
      } while (i >= VisitorsActivity.this.mScreenHeight);
      this.bNb = (VisitorsActivity.this.mScreenHeight - VisitorsActivity.this.getTitleBarHeight() - i);
    }
    
    public int getCount()
    {
      return this.mList.size() + 1;
    }
    
    public long getItemId(int paramInt)
    {
      if (paramInt > this.mList.size() - 1) {
        return -1L;
      }
      return ((CardProfile)this.mList.get(paramInt)).lEctID;
    }
    
    public int getItemViewType(int paramInt)
    {
      int j = 0;
      int i = j;
      if (paramInt > this.mList.size() - 1)
      {
        if (this.mList.size() != 0) {
          break label54;
        }
        if (this.tabType != 0) {
          break label42;
        }
        i = 3;
      }
      label42:
      do
      {
        return i;
        i = j;
      } while (this.tabType != 1);
      return 4;
      label54:
      if (this.hasMore) {
        return 1;
      }
      return 2;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      switch (getItemViewType(paramInt))
      {
      }
      for (;;)
      {
        paramView.setTag(-1, Integer.valueOf(paramInt));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        if (paramInt > this.bMW) {
          this.bMW = paramInt;
        }
        if (paramView != null)
        {
          localView = paramView;
          if ((paramView.getTag() instanceof VisitorsActivity.a)) {}
        }
        else
        {
          localView = j(paramViewGroup);
          localView.setOnClickListener(new wgs(this));
        }
        paramView = (VisitorsActivity.a)localView.getTag();
        paramView.rM.setTag(2131369959, Integer.valueOf(paramInt));
        paramView.position = paramInt;
        a(a(paramInt), paramView);
        VisitorsActivity.this.R(localView, paramInt);
        paramView = localView;
        continue;
        if (paramView != null)
        {
          localView = paramView;
          if ((paramView.getTag() instanceof VisitorsActivity.c)) {}
        }
        else
        {
          localView = aO();
          localView.setOnClickListener(new wgt(this));
        }
        a((VisitorsActivity.c)localView.getTag());
        paramView = localView;
        continue;
        if (this.mInflater == null) {
          this.mInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
        }
        paramView = this.mInflater.inflate(2131561497, null);
        if ((this.bca) && (this.bNb > this.aDD))
        {
          paramView.setMinimumHeight(this.bNb);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.bNb));
        }
        ((TextView)paramView.findViewById(2131365392)).setText(this.aRW);
        continue;
        if (VisitorsActivity.this.vS == null)
        {
          bXX();
          VisitorsActivity.this.vS = VisitorsActivity.this.getLayoutInflater().inflate(2131563331, null);
          VisitorsActivity.this.vS.setLayoutParams(new AbsListView.LayoutParams(-1, VisitorsActivity.this.bMQ));
        }
        View localView = VisitorsActivity.this.vS;
        TextView localTextView = (TextView)localView.findViewById(2131366433);
        LikeRankingInfo localLikeRankingInfo = VisitorsActivity.this.a.a();
        paramView = VisitorsActivity.this.getString(2131721815);
        if ((localLikeRankingInfo == null) || (localLikeRankingInfo.totalLikeCount <= 0)) {
          paramView = VisitorsActivity.this.getString(2131721814);
        }
        localTextView.setText(paramView);
        paramView = localView;
        continue;
        if (VisitorsActivity.this.vT == null)
        {
          bXX();
          VisitorsActivity.this.vT = VisitorsActivity.this.getLayoutInflater().inflate(2131561496, null);
          VisitorsActivity.this.vT.setLayoutParams(new AbsListView.LayoutParams(-1, VisitorsActivity.this.bMQ));
        }
        paramView = VisitorsActivity.this.vT;
      }
    }
    
    public int getViewTypeCount()
    {
      return 5;
    }
    
    public boolean hasStableIds()
    {
      return false;
    }
    
    public boolean isEnabled(int paramInt)
    {
      if (paramInt > this.mList.size() - 1) {
        return !this.bci;
      }
      return super.isEnabled(paramInt);
    }
    
    public void setHasMore(boolean paramBoolean)
    {
      this.hasMore = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity
 * JD-Core Version:    0.7.0.1
 */