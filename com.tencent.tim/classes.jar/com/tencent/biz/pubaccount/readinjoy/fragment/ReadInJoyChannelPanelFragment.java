package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqfo;
import awit;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.e;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.NestedScrollView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.a;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.b;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.f;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.g;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelBottomBanner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.mobileqq.widget.AutoFitTextView.a;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import com.tencent.mobileqq.widget.SlideDownFrameLayout.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kbp;
import kgw;
import kqo;
import kwz;
import kxm;
import kxm.b;
import kyo;
import lbz;
import lcc;
import lcd;
import lce;
import ldm;
import ldn;
import ldp;
import ldq;
import ldr;
import lds;
import lhk;
import lhn;
import mgu;
import mgw;
import mhy;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import ntp;
import org.json.JSONException;
import wja;

public class ReadInJoyChannelPanelFragment
  extends PublicBaseFragment
  implements View.OnClickListener, SlideDownFrameLayout.a
{
  private boolean Ny;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a;
  private NestedScrollView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView;
  private ReadInJoyDynamicGridView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView;
  private ChannelBottomBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner;
  private SlideDownFrameLayout jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
  private lbz jdField_a_of_type_Lbz;
  private int aOc;
  private boolean ajA;
  private boolean ajB;
  private boolean ajC;
  private View ay;
  private LinearLayout dE;
  private LinearLayout dF;
  private RelativeLayout eW;
  private Map<Integer, TabChannelCoverInfo> ej;
  private List<mgw> hr;
  private View kf;
  private ArrayList<ReadInJoyStaticGridView> ky = new ArrayList(5);
  private int mCurrentIndex;
  private boolean mHasChanged;
  private View mMaskView;
  protected lce mObserver = new ldp(this);
  private TextView oZ;
  private TextView pa;
  private TextView pb;
  private TextView pc;
  
  public static void C(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "actionName = ", paramString1, "\n", "r5 = ", paramString2 });
    kbp.a(null, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
  
  public static int a(ChannelCoverInfo paramChannelCoverInfo)
  {
    if ((paramChannelCoverInfo != null) && (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelJumpUrl))) {
      return 2;
    }
    return 1;
  }
  
  public static int a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if ((paramTabChannelCoverInfo == null) || (paramTabChannelCoverInfo.redPoint == null))
    {
      if (paramTabChannelCoverInfo != null) {}
      for (paramTabChannelCoverInfo = paramTabChannelCoverInfo.toString();; paramTabChannelCoverInfo = "")
      {
        QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "getRedDotType, info is null or redPoint is null", paramTabChannelCoverInfo });
        return -1;
      }
    }
    QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "getRedDotType, info = ", paramTabChannelCoverInfo.toString() });
    if (paramTabChannelCoverInfo.redPoint.isShow)
    {
      long l = System.currentTimeMillis() / 1000L;
      if ((l >= paramTabChannelCoverInfo.redPoint.startTimestamp) && (l <= paramTabChannelCoverInfo.redPoint.endTimestamp)) {
        return paramTabChannelCoverInfo.redPoint.type;
      }
    }
    return -1;
  }
  
  public static void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    localTranslateAnimation.setDuration(300L);
    if (paramView != null) {
      paramView.startAnimation(localTranslateAnimation);
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, TextView paramTextView)
  {
    this.ej.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), paramTabChannelCoverInfo);
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo.redPoint.titleText)) {
      paramTextView.setText(paramTabChannelCoverInfo.redPoint.titleText);
    }
    if (paramTabChannelCoverInfo.redPoint.titleColor != 0) {
      paramTextView.setTextColor(paramTabChannelCoverInfo.redPoint.titleColor);
    }
    if (paramTabChannelCoverInfo.redPoint.wP != 0) {
      ((GradientDrawable)paramTextView.getBackground()).setColor(paramTabChannelCoverInfo.redPoint.wP);
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, ReadInJoyDynamicGridView.b paramb)
  {
    if (a(paramTabChannelCoverInfo) >= 0)
    {
      this.mHasChanged = true;
      paramTabChannelCoverInfo.redPoint.isShow = false;
      if (paramb != null) {
        paramb.notifyDataSetChanged();
      }
    }
  }
  
  private void a(mgu parammgu, int paramInt)
  {
    if (parammgu != null)
    {
      TabChannelCoverInfo localTabChannelCoverInfo = parammgu.f;
      if (localTabChannelCoverInfo != null) {
        ThreadManager.executeOnSubThread(new ReadInJoyChannelPanelFragment.7(this, localTabChannelCoverInfo, parammgu, paramInt));
      }
    }
  }
  
  private void a(mgw parammgw, int paramInt)
  {
    b localb = new b(getActivity(), 4, paramInt, (int)parammgw.id);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(getActivity()).inflate(dj(2131560277), this.dF, false);
    ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)localRelativeLayout.findViewById(2131376895);
    localReadInJoyStaticGridView.setExpendable(true);
    localReadInJoyStaticGridView.setEditModeEnabled(false);
    localReadInJoyStaticGridView.setAdapter(localb);
    localReadInJoyStaticGridView.setTag(Long.valueOf(parammgw.id));
    this.dF.addView(localRelativeLayout);
    ((TextView)localRelativeLayout.findViewById(2131376896)).setText(parammgw.name);
    ((TextView)localRelativeLayout.findViewById(2131376894)).setText(parammgw.text);
    parammgw = localRelativeLayout.findViewById(2131376893);
    localReadInJoyStaticGridView.getViewTreeObserver().addOnGlobalLayoutListener(new ldn(this, localReadInJoyStaticGridView, parammgw));
    this.ky.add(localReadInJoyStaticGridView);
  }
  
  private void aBi()
  {
    lhk locallhk = lbz.a().a();
    if (locallhk != null)
    {
      b(locallhk.a(2000000000));
      ThreadManager.getUIHandler().post(new ReadInJoyChannelPanelFragment.1(this, locallhk));
    }
  }
  
  private void aCM()
  {
    FragmentActivity localFragmentActivity;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localFragmentActivity = getActivity();
      localFragmentActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
      if (localFragmentActivity.mSystemBarComp == null) {
        localFragmentActivity.mSystemBarComp = new SystemBarCompact(localFragmentActivity, true, -1);
      }
      localFragmentActivity.mSystemBarComp.init();
      if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localFragmentActivity.mSystemBarComp.setStatusBarColor(0);
      }
    }
    else
    {
      return;
    }
    if (!aqfo.isFlyme())
    {
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
    localFragmentActivity.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  private void aCx()
  {
    this.jdField_a_of_type_Lbz = ((lcd)kxm.getAppRuntime().getManager(163)).b();
  }
  
  private void aKF()
  {
    this.ay.setOnClickListener(this);
    this.pb.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnItemLongClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnDropListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnDragListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a);
    Iterator localIterator = this.ky.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)localIterator.next();
      localReadInJoyStaticGridView.setOnItemClickListener((b)localReadInJoyStaticGridView.getAdapter());
    }
  }
  
  private void aKH()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[updateChannelInfoListToCacheDBAndServer] ");
    if (!this.mHasChanged)
    {
      QLog.d("ReadInJoyChannelPanelFragment", 1, "mHasChanged = false, do not need to update channel info list.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    mgw localmgw = new mgw(((mgw)this.hr.get(0)).id, ((mgw)this.hr.get(0)).name, ((mgw)this.hr.get(0)).text);
    localmgw.iK = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a.getItems();
    localArrayList.add(localmgw);
    int i = 1;
    while (i < this.hr.size())
    {
      localmgw = new mgw(((mgw)this.hr.get(i)).id, ((mgw)this.hr.get(i)).name, ((mgw)this.hr.get(i)).text);
      localmgw.iK = ((b)((ReadInJoyStaticGridView)this.ky.get(i - 1)).getAdapter()).getItems();
      localArrayList.add(localmgw);
      i += 1;
    }
    this.jdField_a_of_type_Lbz.c(localArrayList, 1, true);
    this.mHasChanged = false;
  }
  
  private void aKI()
  {
    if (this.ej == null) {
      return;
    }
    Iterator localIterator = this.ej.values().iterator();
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      if (a(localTabChannelCoverInfo) == 1)
      {
        localTabChannelCoverInfo.redPoint.isShow = false;
        this.jdField_a_of_type_Lbz.e(localTabChannelCoverInfo);
      }
    }
    this.jdField_a_of_type_Lbz.mZ(false);
  }
  
  private int b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int j = -1291845632;
    int i = j;
    if (paramTabChannelCoverInfo != null)
    {
      if (paramTabChannelCoverInfo.fonts_color == 0) {
        break label24;
      }
      i = paramTabChannelCoverInfo.fonts_color;
    }
    label24:
    do
    {
      return i;
      i = j;
    } while (!paramTabChannelCoverInfo.isCurrent);
    return -15550475;
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo, ReadInJoyDynamicGridView.b paramb)
  {
    if (a(paramTabChannelCoverInfo) == 0)
    {
      this.mHasChanged = true;
      paramTabChannelCoverInfo.redPoint.isShow = false;
      if (paramb != null) {
        paramb.notifyDataSetChanged();
      }
    }
  }
  
  private int c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int j = -1291845632;
    int i = j;
    if (paramTabChannelCoverInfo != null)
    {
      i = j;
      if (paramTabChannelCoverInfo.fonts_color != 0) {
        i = paramTabChannelCoverInfo.fonts_color;
      }
    }
    return i;
  }
  
  private int dj(int paramInt)
  {
    if (!kyo.Bg()) {
      return paramInt;
    }
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 2131560277: 
      return 2131560278;
    case 2131560279: 
      return 2131560280;
    case 2131560422: 
      return 2131560421;
    }
    return 2131560449;
  }
  
  private void f(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo != null)
    {
      lcc.a().aJJ();
      lcc.a().d(paramTabChannelCoverInfo);
      kqo.a("0X8007F02", paramTabChannelCoverInfo, kqo.aLl);
    }
  }
  
  private void g(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    this.mHasChanged = true;
    if (paramTabChannelCoverInfo != null) {
      paramTabChannelCoverInfo.reason = 2;
    }
  }
  
  private void initData()
  {
    this.mCurrentIndex = getActivity().getIntent().getIntExtra("currentIndex", 0);
    this.hr = this.jdField_a_of_type_Lbz.aC();
    this.ej = new HashMap();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void initUI()
  {
    this.dE = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131365382));
    this.eW = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364449));
    this.dF = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376915));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView = ((NestedScrollView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364448));
    this.ay = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364690);
    this.oZ = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131372154));
    this.pa = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131372152));
    this.pb = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131372150));
    this.pc = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131371937));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView = ((ReadInJoyDynamicGridView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131372153));
    this.mMaskView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131371173);
    this.aOc = wja.dp2px(8.0F, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.getResources());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner = new ChannelBottomBanner(getActivity());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(getActivity(), 18.0F);
      if (kyo.Bg()) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = aqcx.dip2px(getActivity(), 18.0F);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131371937);
      this.eW.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner, (ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.setOnSlideListener(this);
    this.dE.setOnTouchListener(new ldm(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a = new a(getActivity(), 4, TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setExpendable(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a);
    if (this.hr != null)
    {
      this.pa.setText(((mgw)this.hr.get(0)).text);
      int i = 1;
      while (i < this.hr.size())
      {
        a((mgw)this.hr.get(i), i);
        i += 1;
      }
    }
    this.eW.setClipChildren(false);
    onPostThemeChanged();
    Object localObject = ((ViewGroup)((FrameLayout)getActivity().findViewById(16908290)).getParent()).getChildAt(1);
    if (((localObject instanceof FrameLayout)) && (((View)localObject).getId() != 16908290)) {
      ((View)localObject).setVisibility(8);
    }
    this.dE.setAlpha(0.0F);
    this.dE.post(new ReadInJoyChannelPanelFragment.3(this));
  }
  
  private void qL(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a.notifyDataSetChanged();
    Iterator localIterator = this.ky.iterator();
    while (localIterator.hasNext()) {
      ((b)((ReadInJoyStaticGridView)localIterator.next()).getAdapter()).notifyDataSetChanged();
    }
    if (this.Ny)
    {
      this.pa.setText(2131718397);
      this.pb.setText(2131718358);
      if (this.ajC)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.tU(paramInt);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(8);
        this.pc.setVisibility(8);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.bap();
      break;
      this.pa.setText(((mgw)this.hr.get(0)).text);
      this.pb.setText(2131718359);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.bap();
      aKH();
      if (this.ajB) {
        this.pc.setVisibility(0);
      }
    } while (!this.ajA);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(0);
  }
  
  public boolean BU()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView.getScrollY() == 0;
  }
  
  public float[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    float[] arrayOfFloat = new float[2];
    if ((paramArrayOfInt1.length >= 2) && (paramArrayOfInt2.length >= 2))
    {
      arrayOfFloat[0] = (paramArrayOfInt1[0] - paramArrayOfInt2[0]);
      arrayOfFloat[1] = (paramArrayOfInt1[1] - paramArrayOfInt2[1]);
    }
    return arrayOfFloat;
  }
  
  public void aKG()
  {
    if (getActivity() != null)
    {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public View aj()
  {
    return this.dE;
  }
  
  public void b(TopBannerInfo paramTopBannerInfo)
  {
    if (paramTopBannerInfo == null)
    {
      this.ajA = false;
      this.ajB = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(8);
      this.pc.setVisibility(8);
      return;
    }
    if (paramTopBannerInfo.items.isEmpty())
    {
      this.ajA = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(8);
    }
    while (paramTopBannerInfo.moreChannelItem != null)
    {
      this.ajB = true;
      this.pc.setVisibility(0);
      this.pc.setText(paramTopBannerInfo.moreChannelItem.title);
      paramTopBannerInfo = paramTopBannerInfo.moreChannelItem.linkUrl;
      this.pc.setOnClickListener(new ldq(this, paramTopBannerInfo));
      return;
      this.ajA = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.a(null, paramTopBannerInfo);
    }
    this.ajB = false;
    this.pc.setVisibility(8);
  }
  
  public void c(float paramFloat, int paramInt)
  {
    lcc.a().c(paramFloat, paramInt);
    this.mMaskView.setAlpha(1.0F - paramFloat / paramInt);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.ejd();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364690: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.ejd();
      }
    }
    if (!this.Ny) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ny = bool;
      qL(-1);
      C("0X8009498", new kxm.b().c().build());
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aCx();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getActivity().setTheme(2131755342);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout = ((SlideDownFrameLayout)paramLayoutInflater.inflate(dj(2131560279), paramViewGroup, false));
    aCx();
    initData();
    initUI();
    aBi();
    aKF();
    lcc.a().b(this.mObserver);
    VideoReport.setPageId(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout, "8016");
    VideoReport.addToDetectionWhitelist(getActivity());
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.mObserver);
    super.onDestroy();
    aKI();
    this.jdField_a_of_type_Lbz = null;
  }
  
  public void onFinish()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[onFinish] ");
    super.onFinish();
    if (this.mHasChanged) {
      aKH();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.onPause();
    }
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isNowThemeIsNight(kxm.getAppRuntime(), false, null))
    {
      if (this.kf == null) {
        this.kf = ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376763)).inflate();
      }
      if (this.kf != null) {
        this.kf.setVisibility(0);
      }
    }
    while (this.kf == null) {
      return;
    }
    this.kf.setVisibility(8);
  }
  
  public void onResume()
  {
    super.onResume();
    aCM();
    lcc.a().b(this.mObserver);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.onResume();
    }
  }
  
  public class a
    extends ReadInJoyDynamicGridView.b<TabChannelCoverInfo>
    implements View.OnClickListener, ReadInJoyDynamicGridView.f, ReadInJoyDynamicGridView.g, AdapterView.c, AdapterView.d
  {
    public int aOe;
    private int aOf = -1;
    private int aOg;
    private int[] dg = new int[2];
    
    public a(Context paramContext, int paramInt1, int paramInt2)
    {
      super(paramInt1);
      this.aOg = paramInt2;
      aKJ();
    }
    
    private void a(int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
    {
      QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem, position = ", Integer.valueOf(paramInt), ", tabChannelCoverInfo = ", paramTabChannelCoverInfo.shortLogString() });
      if (paramInt < this.aOe) {
        QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "can not delete item, position = ", Integer.valueOf(paramInt), ", LOCK_COUNT = ", Integer.valueOf(this.aOe) });
      }
      do
      {
        return;
        ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, paramTabChannelCoverInfo);
        try
        {
          ReadInJoyChannelPanelFragment.C("0X800949C", new kxm.b().c().a(paramTabChannelCoverInfo.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramTabChannelCoverInfo)).build());
          if (ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).getChildAt(paramInt) == null)
          {
            QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem NPE, position = ", Integer.valueOf(paramInt), ", tabChannelCoverInfo = ", paramTabChannelCoverInfo.shortLogString() });
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
          ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).getChildAt(paramInt).getLocationOnScreen(this.dg);
        }
      } while (!ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).ag(paramInt, ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).getCount() - 1));
      ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.b(ReadInJoyChannelPanelFragment.this).findViewWithTag(Long.valueOf(paramTabChannelCoverInfo.sectionId));
      if (localReadInJoyStaticGridView == null) {
        localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).get(0);
      }
      for (paramTabChannelCoverInfo.channelConfigType = ((mgw)ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).get(1)).id;; paramTabChannelCoverInfo.channelConfigType = paramTabChannelCoverInfo.sectionId)
      {
        localReadInJoyStaticGridView.b(localReadInJoyStaticGridView.getAdapter().getCount() - 1, 0, paramTabChannelCoverInfo);
        paramTabChannelCoverInfo = new ldr(this, localReadInJoyStaticGridView);
        localReadInJoyStaticGridView.setTag(2131376702, paramTabChannelCoverInfo);
        localReadInJoyStaticGridView.getViewTreeObserver().addOnPreDrawListener(paramTabChannelCoverInfo);
        return;
      }
    }
    
    private void aKJ()
    {
      int m = 0;
      List localList = ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).aD();
      if ((localList == null) || (localList.size() == 0)) {
        QLog.d("ReadInJoyChannelPanelFragment", 2, "No channel Cache info.");
      }
      for (;;)
      {
        return;
        if ((ReadInJoyChannelPanelFragment.b(ReadInJoyChannelPanelFragment.this) >= 0) && (ReadInJoyChannelPanelFragment.b(ReadInJoyChannelPanelFragment.this) < localList.size())) {
          ((TabChannelCoverInfo)localList.get(ReadInJoyChannelPanelFragment.b(ReadInJoyChannelPanelFragment.this))).isCurrent = true;
        }
        int i = 0;
        Object localObject;
        if (i < localList.size())
        {
          localObject = (TabChannelCoverInfo)localList.get(i);
          if (localObject != null) {
            if (i != ReadInJoyChannelPanelFragment.b(ReadInJoyChannelPanelFragment.this)) {
              break label146;
            }
          }
          label146:
          for (boolean bool = true;; bool = false)
          {
            ((TabChannelCoverInfo)localObject).isCurrent = bool;
            i += 1;
            break;
          }
        }
        set(localList);
        i = 0;
        int k;
        for (int j = 0; i < localList.size(); j = k)
        {
          localObject = (TabChannelCoverInfo)localList.get(i);
          k = j;
          if (localObject != null)
          {
            if (((TabChannelCoverInfo)localObject).reason != 4) {
              break;
            }
            k = j + 1;
          }
          i += 1;
        }
        this.aOe = j;
        ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).setLockCount(this.aOe);
        i = m;
        while (i < localList.size())
        {
          localObject = new mhy();
          ((mgu)localObject).f = ((TabChannelCoverInfo)localList.get(i));
          ((mgu)localObject).aRE = i;
          ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, (mgu)localObject, this.aOg);
          i += 1;
        }
      }
    }
    
    public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onItemLongClick, position = ", Integer.valueOf(paramInt), ", id = ", Long.valueOf(paramLong) });
      ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, true);
      paramAdapterView = (TabChannelCoverInfo)getItem(paramInt);
      if (paramInt >= this.aOe)
      {
        this.aOf = paramInt;
        ReadInJoyChannelPanelFragment.b(ReadInJoyChannelPanelFragment.this, true);
        ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, paramAdapterView);
      }
      ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, paramInt);
      try
      {
        ReadInJoyChannelPanelFragment.C("0X800949A", new kxm.b().c().a(paramAdapterView.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramAdapterView)).build());
        return true;
      }
      catch (JSONException paramAdapterView)
      {
        paramAdapterView.printStackTrace();
      }
      return true;
    }
    
    public void aKK()
    {
      ReadInJoyChannelPanelFragment.b(ReadInJoyChannelPanelFragment.this, false);
      ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, -1);
    }
    
    public void aY(int paramInt1, int paramInt2)
    {
      TabChannelCoverInfo localTabChannelCoverInfo = null;
      if (this.aOf >= 0) {
        localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(this.aOf);
      }
      if (localTabChannelCoverInfo != null) {}
      try
      {
        ReadInJoyChannelPanelFragment.C("0X800949B", new kxm.b().c().a(localTabChannelCoverInfo.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(localTabChannelCoverInfo)).build());
        this.aOf = -1;
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject = (TabChannelCoverInfo)getItem(paramInt);
      a locala;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, 2131560422), null);
        locala = new a();
        locala.linearLayout = ((LinearLayout)paramView.findViewById(2131370498));
        locala.a = ((AutoFitTextView)paramView.findViewById(2131364446));
        locala.iI = ((ImageView)paramView.findViewById(2131377002));
        locala.pd = ((TextView)paramView.findViewById(2131377015));
        locala.iJ = ((ImageView)paramView.findViewById(2131365705));
        locala.iJ.setOnClickListener(this);
        locala.a.setOnGetMaxWidthCallback(locala);
        locala.b = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131369780));
        if (locala.b != null) {
          locala.b.setCorner(ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this));
        }
        paramView.setTag(locala);
      }
      for (;;)
      {
        paramView.setAlpha(1.0F);
        locala.a.setText(((TabChannelCoverInfo)localObject).mChannelCoverName);
        locala.a.setTextColor(ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, (TabChannelCoverInfo)localObject));
        ImageView localImageView = locala.iJ;
        int i;
        if (ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this))
        {
          i = 0;
          label239:
          localImageView.setVisibility(i);
          locala.iJ.setTag(localObject);
          locala.iJ.setTag(2131376759, Integer.valueOf(paramInt));
          if ((paramInt < this.aOe) && (ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this)))
          {
            paramView.setAlpha(0.5F);
            locala.iJ.setVisibility(8);
          }
          if (!ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this)) {
            break label413;
          }
          locala.iI.setVisibility(8);
          locala.pd.setVisibility(8);
          if ((locala.b == null) || (!kyo.Bg())) {}
        }
        try
        {
          localObject = new URL(((TabChannelCoverInfo)localObject).mChannelCoverIcon);
          kwz.a(locala.b, (URL)localObject, paramView.getContext());
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          locala = (a)paramView.getTag();
          continue;
          i = 8;
          break label239;
          label413:
          localImageView = locala.iI;
          if (ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) == 0) {}
          for (i = 0;; i = 8)
          {
            localImageView.setVisibility(i);
            if ((ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) != 1) || (((TabChannelCoverInfo)localObject).redPoint.vS > 0L)) {
              break label493;
            }
            locala.pd.setVisibility(0);
            ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, (TabChannelCoverInfo)localObject, locala.pd);
            break;
          }
          label493:
          locala.pd.setVisibility(8);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            QLog.e("ReadInJoyChannelPanelFragment", 1, "", localMalformedURLException);
          }
        }
      }
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        int i = ((Integer)paramView.getTag(2131376759)).intValue();
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramView.getTag();
        QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onClick, delete button position = ", Integer.valueOf(i) });
        a(i, localTabChannelCoverInfo);
      }
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      paramAdapterView = (TabChannelCoverInfo)getItem(paramInt);
      if (!ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this)) {
        try
        {
          ReadInJoyChannelPanelFragment.C("0X8009499", new kxm.b().c().a(paramAdapterView.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramAdapterView)).n(ReadInJoyChannelPanelFragment.a(paramAdapterView)).c((int)paramAdapterView.sectionId).b("style", 1).build());
          ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, paramAdapterView, this);
          ReadInJoyChannelPanelFragment.this.getActivity().finish();
          if (awit.aMY())
          {
            lbz.a().c(paramAdapterView.mChannelCoverId, 3, false, true);
            kxm.p().post(new ReadInJoyChannelPanelFragment.DynamicGridViewAdapter.1(this, paramAdapterView));
            return;
          }
        }
        catch (JSONException paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
            continue;
            lbz.a().cF(paramAdapterView.mChannelCoverId, 3);
          }
        }
      }
      a(paramInt, paramAdapterView);
      ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this);
    }
    
    public void qM(int paramInt) {}
    
    public class a
      implements AutoFitTextView.a
    {
      AutoFitTextView a;
      KanDianUrlRoundCornerImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
      ImageView iI;
      ImageView iJ;
      LinearLayout linearLayout;
      TextView pd;
      
      public a() {}
      
      public int oz()
      {
        return this.linearLayout.getWidth();
      }
    }
  }
  
  public class b
    extends ReadInJoyDynamicGridView.b<TabChannelCoverInfo>
    implements AdapterView.c
  {
    private int aOg;
    private ViewTreeObserver.OnPreDrawListener b;
    private int[] dg = new int[2];
    
    public b(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt1);
      this.aOg = paramInt3;
      qN(paramInt2);
    }
    
    private void a(TabChannelCoverInfo paramTabChannelCoverInfo, AdapterView<?> paramAdapterView, int paramInt)
    {
      ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, paramTabChannelCoverInfo);
      ((ReadInJoyStaticGridView)paramAdapterView).ag(paramInt, getCount() - 1);
      ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).aa(paramTabChannelCoverInfo);
      try
      {
        ReadInJoyChannelPanelFragment.C("0X800949D", new kxm.b().c().a(paramTabChannelCoverInfo.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramTabChannelCoverInfo)).n(ReadInJoyChannelPanelFragment.a(paramTabChannelCoverInfo)).c((int)paramTabChannelCoverInfo.sectionId).build());
        if (this.b == null) {
          this.b = new lds(this);
        }
        ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).getViewTreeObserver().addOnPreDrawListener(this.b);
        ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this);
        return;
      }
      catch (JSONException paramTabChannelCoverInfo)
      {
        for (;;)
        {
          paramTabChannelCoverInfo.printStackTrace();
        }
      }
    }
    
    private void qN(int paramInt)
    {
      int i = 0;
      List localList = ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this).t(paramInt);
      if ((localList == null) || (localList.size() == 0)) {
        QLog.d("ReadInJoyChannelPanelFragment", 2, "No channel Cache info.");
      }
      for (;;)
      {
        return;
        Object localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((TabChannelCoverInfo)((Iterator)localObject).next()).isCurrent = false;
        }
        set(localList);
        paramInt = i;
        while (paramInt < localList.size())
        {
          localObject = new mhy();
          ((mgu)localObject).f = ((TabChannelCoverInfo)localList.get(paramInt));
          ((mgu)localObject).aRE = paramInt;
          ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, (mgu)localObject, this.aOg);
          paramInt += 1;
        }
      }
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject = (TabChannelCoverInfo)getItem(paramInt);
      a locala;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, 2131560450), null);
        locala = new a();
        locala.linearLayout = ((LinearLayout)paramView.findViewById(2131370498));
        locala.a = ((AutoFitTextView)paramView.findViewById(2131364446));
        locala.iI = ((ImageView)paramView.findViewById(2131377002));
        locala.pd = ((TextView)paramView.findViewById(2131377015));
        locala.b = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131369780));
        if (locala.b != null) {
          locala.b.setCorner(ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this));
        }
        locala.a.setOnGetMaxWidthCallback(locala);
        paramView.setTag(locala);
      }
      for (;;)
      {
        locala.a.setText(((TabChannelCoverInfo)localObject).mChannelCoverName);
        locala.a.setTextColor(ReadInJoyChannelPanelFragment.b(ReadInJoyChannelPanelFragment.this, (TabChannelCoverInfo)localObject));
        label237:
        int i;
        if (ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this))
        {
          if (!kyo.Bg())
          {
            locala.a.setCompoundDrawablesWithIntrinsicBounds(2130843609, 0, 0, 0);
            locala.a.setCompoundDrawablePadding(wja.dp2px(4.0F, this.mContext.getResources()));
          }
          ImageView localImageView = locala.iI;
          if (ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) != 0) {
            break label392;
          }
          i = 0;
          label255:
          localImageView.setVisibility(i);
          if ((ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) != 1) || (((TabChannelCoverInfo)localObject).redPoint.vS > 0L)) {
            break label399;
          }
          locala.pd.setVisibility(0);
          ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this, (TabChannelCoverInfo)localObject, locala.pd);
          if ((locala.b == null) || (!kyo.Bg())) {}
        }
        try
        {
          localObject = new URL(((TabChannelCoverInfo)localObject).mChannelCoverIcon);
          kwz.a(locala.b, (URL)localObject, paramView.getContext());
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          locala = (a)paramView.getTag();
          continue;
          locala.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label237;
          label392:
          i = 8;
          break label255;
          label399:
          locala.pd.setVisibility(8);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            QLog.e("ReadInJoyChannelPanelFragment", 1, "", localMalformedURLException);
          }
        }
      }
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      paramAdapterView.getChildAt(paramInt).getLocationOnScreen(this.dg);
      paramView = (TabChannelCoverInfo)getItem(paramInt);
      ReadInJoyChannelPanelFragment.b(ReadInJoyChannelPanelFragment.this, paramView, this);
      if (!ReadInJoyChannelPanelFragment.a(ReadInJoyChannelPanelFragment.this)) {
        try
        {
          ReadInJoyChannelPanelFragment.C("0X8009499", new kxm.b().c().a(paramView.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramView)).n(ReadInJoyChannelPanelFragment.a(paramView)).c((int)paramView.sectionId).b("style", 1).build());
          if (lhn.dJ(paramView.mChannelCoverId))
          {
            a(paramView, paramAdapterView, paramInt);
            ReadInJoyChannelPanelFragment.this.getActivity().finish();
            lbz.a().cG(paramView.mChannelCoverId, 3);
            kxm.p().post(new ReadInJoyChannelPanelFragment.StaticGridViewAdapter.1(this, paramView));
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("ReadInJoyChannelPanelFragment", 1, "", localJSONException);
          }
          if (!TextUtils.isEmpty(paramView.mChannelJumpUrl)) {
            try
            {
              paramAdapterView = URLDecoder.decode(paramView.mChannelJumpUrl, "utf-8");
              ntp.b(ReadInJoyChannelPanelFragment.this.getActivity(), paramView.mChannelCoverName, paramAdapterView, null);
              return;
            }
            catch (Exception paramAdapterView)
            {
              paramAdapterView.printStackTrace();
              QLog.w("ReadInJoyChannelPanelFragment", 1, "gotoReadInJoyViolaChannel, v_url error->" + paramAdapterView.getMessage());
              return;
            }
          }
          if (paramView.mChannelType == 3)
          {
            kgw.b(ReadInJoyChannelPanelFragment.this.getActivity(), paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, -1);
            return;
          }
          kgw.a(ReadInJoyChannelPanelFragment.this.getActivity(), paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, -1);
          return;
        }
      }
      a(paramView, paramAdapterView, paramInt);
    }
    
    public class a
      implements AutoFitTextView.a
    {
      AutoFitTextView jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView;
      KanDianUrlRoundCornerImageView b;
      ImageView iI;
      LinearLayout linearLayout;
      TextView pd;
      
      public a() {}
      
      public int oz()
      {
        return this.linearLayout.getWidth() - aqcx.dip2px(ReadInJoyChannelPanelFragment.b.a(this.a), 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */