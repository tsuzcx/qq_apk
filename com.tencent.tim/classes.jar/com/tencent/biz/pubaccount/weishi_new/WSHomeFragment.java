package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stNewsRedDot;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stSimpleMetaPerson;
import acfp;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqda;
import aqda.a;
import aqdj;
import aqfo;
import aqnm;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.d;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import ofh;
import ofi;
import ofj;
import ofk;
import ofl;
import ofm;
import ofn;
import ofo;
import ofq;
import ogd;
import ogj;
import ohy;
import oie;
import oiv;
import oix;
import olw;
import omh;
import oni;
import oox;
import ooz;
import opn;
import osw;
import osx;
import rpw;

public class WSHomeFragment
  extends WSBaseFragment<omh, olw>
  implements View.OnClickListener, oix, omh
{
  public static int mCurrentPageIndex;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private a jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$a;
  private b jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$b;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private WSTabLayout.b jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout$b;
  private WSTabLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout;
  private osw jdField_a_of_type_Osw;
  private osx jdField_a_of_type_Osx;
  private boolean awP;
  private boolean awQ;
  private boolean awR;
  private WSTabLayout.b b;
  private List<Fragment> bU;
  private RelativeLayout fD;
  private ImageView ivBack;
  private View kf;
  private ImageView lp;
  private ImageView lq;
  private ImageView lr;
  private Context mContext;
  private MqqHandler mMainHandler = ThreadManager.getUIHandler();
  private Runnable mRefreshRunnable = new WSHomeFragment.1(this);
  private View mRootView;
  private SystemBarCompact mSystemBarComp;
  private View np;
  private TextView uf;
  private TextView ug;
  private TextView uh;
  
  private boolean S(boolean paramBoolean)
  {
    int i = 9216;
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isFlyme()) && (!aqfo.isMIUI())) {
      if (paramBoolean) {
        getActivity().getWindow().getDecorView().setSystemUiVisibility(i);
      }
    }
    do
    {
      return paramBoolean;
      i = 1280;
      break;
      if (!ImmersiveUtils.eB()) {
        break label110;
      }
      ImmersiveUtils.a(getActivity().getWindow(), paramBoolean);
    } while ((Build.VERSION.SDK_INT < 23) || (!aqfo.isMIUI()));
    if (paramBoolean) {}
    for (;;)
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(i);
      return paramBoolean;
      i = 1280;
    }
    label110:
    return false;
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    Object localObject;
    if (paramstSimpleMetaPerson != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof aqdj))) {
        ((aqdj)localObject).cancel();
      }
      opn.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
      return;
    }
    paramstSimpleMetaPerson = getActivity();
    if ((paramstSimpleMetaPerson != null) && (getActivity().app != null))
    {
      localObject = getActivity().app.getCurrentAccountUin();
      Drawable localDrawable = aqdj.g(1, 1);
      paramstSimpleMetaPerson = aqdj.a(paramstSimpleMetaPerson.app, 1, (String)localObject, 1, localDrawable, localDrawable, null);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof aqdj))) {
        ((aqdj)localObject).cancel();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(paramstSimpleMetaPerson);
      return;
    }
    opn.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, null);
  }
  
  private void b(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp == null) {
      return;
    }
    this.awQ = true;
    if (!rpw.isWeishiInstalled(this.mContext))
    {
      d(paramstPublisherRsp);
      return;
    }
    c(paramstPublisherRsp);
  }
  
  private void bec()
  {
    WSPublicAccReport.getInstance().reportAvatarViewClick(mCurrentPageIndex);
    beh();
    List localList = ((olw)b()).bp();
    if ((localList != null) && (localList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Osx = osx.a(getActivity(), bool, new ofk(this), new ofl(this));
      this.jdField_a_of_type_Osx.showAsDropDown(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getWidth() / 2 - aqnm.dip2px(152.0F) / 2 - aqnm.dip2px(7.0F), aqnm.dip2px(9.0F));
      this.lr.setVisibility(8);
      return;
    }
  }
  
  private void bed()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131721929));
    ((List)localObject).add(getString(2131721930));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.setTabContentClickListener(new ofm(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.x((List)localObject, mCurrentPageIndex);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(0);
    TabLayoutCompat.d locald = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(1);
    if ((localObject != null) && (locald != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout$b = ((WSTabLayout.b)((TabLayoutCompat.d)localObject).getTag());
      this.b = ((WSTabLayout.b)locald.getTag());
    }
  }
  
  private void bee()
  {
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      ooz.i("weishi-815", "is night mode");
      qz(true);
      if (this.kf == null) {
        this.kf = ((ViewStub)this.mRootView.findViewById(2131382338)).inflate();
      }
      if (this.kf != null) {
        this.kf.setVisibility(0);
      }
      this.fD.setBackgroundColor(-16777216);
      this.lp.setImageResource(2130851143);
      this.ivBack.setImageResource(2130844011);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout$b != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout$b.uY(-1);
      }
      if (this.b != null) {
        this.b.uY(-1);
      }
    }
    do
    {
      return;
      ooz.i("weishi-815", "is day mode");
      qz(false);
    } while (this.kf == null);
    this.kf.setVisibility(8);
  }
  
  private void bef()
  {
    beh();
    oie.a().release();
    beg();
    opn.axW = false;
    ohy.a().pA("global_key_recommend");
  }
  
  private void beg()
  {
    int j = 3;
    int i;
    if ((oni.bft == 1) || (oni.bfu == 1) || (this.awQ) || (oni.isUserClick)) {
      i = 1;
    }
    for (;;)
    {
      WSPublicAccReport.getInstance().closePublicAccReport(i);
      oni.bft = 0;
      oni.bfu = 0;
      return;
      if ((oni.bft == 2) || (oni.bfu == 2))
      {
        i = 2;
      }
      else
      {
        i = j;
        if (oni.bft != 3)
        {
          i = j;
          if (oni.bfu != 3) {
            i = 0;
          }
        }
      }
    }
  }
  
  private void beh()
  {
    if (this.jdField_a_of_type_Osw != null)
    {
      this.jdField_a_of_type_Osw.bgT();
      this.jdField_a_of_type_Osw = null;
    }
    if ((this.jdField_a_of_type_Osx != null) && (this.jdField_a_of_type_Osx.isShowing()))
    {
      this.jdField_a_of_type_Osx.dismiss();
      this.jdField_a_of_type_Osx = null;
    }
  }
  
  private void bej()
  {
    ((olw)b()).dA(null);
    this.lr.setVisibility(8);
  }
  
  private void c(stPublisherRsp paramstPublisherRsp)
  {
    ofq localofq = new ofq(getActivity());
    localofq.e(paramstPublisherRsp);
    localofq.uD(mCurrentPageIndex);
    localofq.show();
    o("gzh_click", "publish", 1000006);
  }
  
  public static void c(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 1) {}
    }
    else
    {
      i = 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_home_to_index", i);
    Intent localIntent = new Intent(paramContext, PublicFragmentActivity.class);
    localIntent.putExtra("key_home_bundle", localBundle);
    if (paramBoolean) {
      localIntent.setFlags(67108864);
    }
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicFragmentActivity.class, WSHomeFragment.class);
  }
  
  private void ca(ArrayList<stNotificationRedDot> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      WSPublicAccReport.getInstance().reportMessageBubblePopupExposure(mCurrentPageIndex);
      this.jdField_a_of_type_Osw = new osw(getActivity(), new ofh(this));
      this.jdField_a_of_type_Osw.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramArrayList);
      this.lr.setVisibility(0);
    }
    do
    {
      return;
      this.lr.setVisibility(8);
    } while (this.jdField_a_of_type_Osw == null);
    this.jdField_a_of_type_Osw.bgT();
  }
  
  public static void cq(Context paramContext)
  {
    c(paramContext, 1, false);
  }
  
  private void d(stPublisherRsp paramstPublisherRsp)
  {
    switch (paramstPublisherRsp.noInstallAction)
    {
    default: 
      c(paramstPublisherRsp);
      return;
    case 2: 
      ogj.a(this.mContext, paramstPublisherRsp.miniAppSchema, new ofo(this));
      o("gzh_click", "publish", 1000007);
      return;
    }
    ogj.aM(this.mContext, paramstPublisherRsp.h5Url);
    o("gzh_click", "publish", 1000004);
  }
  
  private void initData()
  {
    oiv.a().a(this);
    ((olw)b()).bfL();
    ((olw)b()).bfM();
  }
  
  private void initView()
  {
    mCurrentPageIndex = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)this.mRootView.findViewById(2131382354));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout = ((WSTabLayout)this.mRootView.findViewById(2131382345));
    this.ivBack = ((ImageView)this.mRootView.findViewById(2131382331));
    this.lp = ((ImageView)this.mRootView.findViewById(2131382332));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.mRootView.findViewById(2131382340));
    this.lr = ((ImageView)this.mRootView.findViewById(2131382335));
    this.fD = ((RelativeLayout)this.mRootView.findViewById(2131382343));
    Object localObject = (LinearLayout.LayoutParams)this.fD.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    this.fD.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.ivBack.setOnClickListener(this);
    this.lp.setOnClickListener(this);
    if (this.bU == null) {
      this.bU = new ArrayList();
    }
    this.bU.clear();
    this.bU.add(new WSFollowFragment());
    this.bU.add(new WSRecommendFragment());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$b = new b(getChildFragmentManager(), this.bU);
    localObject = null;
    if (getArguments() != null) {
      localObject = getArguments().getBundle("key_home_bundle");
    }
    if (localObject != null) {
      mCurrentPageIndex = ((Bundle)localObject).getInt("key_home_to_index");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$b);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setOffscreenPageLimit(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(mCurrentPageIndex);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.addOnPageChangeListener(new ofi(this));
    bed();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(new ofj(this));
  }
  
  private void o(String paramString1, String paramString2, int paramInt)
  {
    if (mCurrentPageIndex == 0) {}
    for (String str = "focus";; str = "feeds")
    {
      WSPublicAccReport.getInstance().reportPublisher(paramString1, str, paramString2, paramInt);
      return;
    }
  }
  
  private void qz(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setStatusBarColor(0);
      S(false);
      return;
    }
    if (S(true))
    {
      setStatusBarColor(-1);
      return;
    }
    setStatusBarColor(-2368549);
  }
  
  private void setStatusBarColor(int paramInt)
  {
    if (this.mSystemBarComp == null)
    {
      this.mSystemBarComp = new SystemBarCompact(getActivity(), true, -1);
      this.mSystemBarComp.init();
    }
    this.mSystemBarComp.setStatusBarColor(paramInt);
  }
  
  private void uB(int paramInt)
  {
    if (mCurrentPageIndex == 0) {
      paramInt = 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout$b != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout$b.uX(paramInt);
    }
  }
  
  private void updateFPSText(double paramDouble)
  {
    if (this.ug != null)
    {
      String str = acfp.m(2131708398) + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.ug.setText(str);
    }
  }
  
  @NonNull
  public olw a()
  {
    return new olw();
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp.enable)
    {
      this.awR = true;
      if (this.np == null) {
        this.np = ((ViewStub)this.mRootView.findViewById(2131382356)).inflate();
      }
      if (this.np != null)
      {
        this.uf = ((TextView)this.np.findViewById(2131382205));
        this.lq = ((ImageView)this.np.findViewById(2131382203));
        this.lq.setOnClickListener(new ofn(this, paramstPublisherRsp));
        if (!paramstPublisherRsp.newUser) {
          break label171;
        }
        this.uf.setVisibility(0);
        this.uf.setText(paramstPublisherRsp.newsUserText);
        ThreadManager.getUIHandler().postDelayed(new WSHomeFragment.8(this), 3000L);
        o("gzh_exposure", "publish_copywriting", 0);
      }
      for (;;)
      {
        this.np.setVisibility(0);
        o("gzh_exposure", "publish", 0);
        return;
        label171:
        this.uf.setVisibility(8);
      }
    }
    this.awR = false;
  }
  
  public void a(stRedDotRsp paramstRedDotRsp)
  {
    stNewsRedDot localstNewsRedDot = paramstRedDotRsp.newsReddot;
    a(paramstRedDotRsp.user);
    if (localstNewsRedDot == null) {}
    for (int i = 0;; i = localstNewsRedDot.newsCount)
    {
      uB(i);
      ca(paramstRedDotRsp.notificationReddot);
      return;
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSCommentShowEvent)) && (this.awR) && (this.np != null)) {
      if (((WSCommentShowEvent)paramWSSimpleBaseEvent).isShowingCommentView) {
        this.np.setVisibility(8);
      }
    }
    while (!(paramWSSimpleBaseEvent instanceof WSUserAuthEvent))
    {
      return;
      this.np.setVisibility(0);
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    if (mCurrentPageIndex == 0) {}
    for (paramWSSimpleBaseEvent = "focus";; paramWSSimpleBaseEvent = "feeds")
    {
      ogd.aV(localFragmentActivity, paramWSSimpleBaseEvent);
      return;
    }
  }
  
  public void bei()
  {
    a(null);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSCommentShowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    return localArrayList;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$b != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$b.getItem(mCurrentPageIndex) != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$b.getItem(mCurrentPageIndex).onActivityResult(paramInt1, paramInt2, paramIntent);
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
      getActivity().finish();
      continue;
      WSPublicAccReport.getInstance().reportPublicAccDetailClick();
      Intent localIntent = new Intent(getActivity(), AccountDetailActivity.class);
      localIntent.putExtra("uin", String.valueOf(2062433139L));
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("source", 119);
      startActivity(localIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = getActivity();
    oox.a().init();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mRootView = ((ViewGroup)paramLayoutInflater.inflate(2131560199, paramViewGroup, false));
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    oox.a().release();
    oiv.a().b(this);
    ohy.a().beV();
    aqda.a().b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$a);
    if (this.mMainHandler != null)
    {
      this.mMainHandler.removeCallbacks(this.mRefreshRunnable);
      this.mMainHandler = null;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    bef();
  }
  
  public void onResume()
  {
    super.onResume();
    bee();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    initView();
    initData();
  }
  
  public void startRefreshMonitorUi()
  {
    if (this.mMainHandler != null) {
      this.mMainHandler.postDelayed(this.mRefreshRunnable, 2000L);
    }
  }
  
  class a
    implements aqda.a
  {
    public void onInfo(long paramLong, double paramDouble)
    {
      WSHomeFragment.a(this.this$0, paramDouble);
    }
  }
  
  class b
    extends FragmentPagerAdapter
  {
    private List<Fragment> bU;
    
    public b(List<Fragment> paramList)
    {
      super();
      Object localObject;
      this.bU = localObject;
    }
    
    public int getCount()
    {
      if (this.bU == null) {
        return 0;
      }
      return this.bU.size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)this.bU.get(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment
 * JD-Core Version:    0.7.0.1
 */