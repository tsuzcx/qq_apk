package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import auwn;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView.a;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSBlockDialogDismissEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import oev;
import ogd;
import ogm;
import ohl;
import ohy;
import oiv;
import oix;
import okd;
import okg;
import oni;
import onk;
import oog;
import ooz;
import opn;
import opv;
import oqa;
import oqb;
import oqd;
import oqf;
import oqi.a;
import oqi.b;
import oqk;
import oql;
import oqp;
import oqr;
import oqs;
import orc;
import org.jetbrains.annotations.NotNull;
import osf;
import osv;

public class WSVerticalPageFragment
  extends WSBaseFragment<oqi.b, oqi.a>
  implements VideoFeedsRecyclerView.a, oix, opv, oqi.b
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private ogm<Object> jdField_a_of_type_Ogm;
  private String aqb;
  public FrameLayout aw;
  private boolean axZ;
  private boolean aya;
  private okg b;
  private int bfJ;
  private VideoFeedsRecyclerView jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private oev jdField_c_of_type_Oev;
  public ohl c;
  private oqb jdField_c_of_type_Oqb;
  private List<oqr> lh;
  private String mFrom;
  private SystemBarCompact mSystemBarComp;
  private ProgressBar u;
  private long yH;
  
  @NotNull
  private static Intent a(String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_from", paramString1);
    localBundle.putString("key_play_scene", paramString2);
    if ((paramList != null) && (paramList.size() > 0)) {
      localBundle.putSerializable("key_feed_list", new ArrayList(paramList));
    }
    localBundle.putInt("key_feed_position", paramInt);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  @NotNull
  private ogm<Object> a()
  {
    if (TextUtils.equals(this.mFrom, "vertical_layer_collection")) {
      return new oqd(getActivity(), this);
    }
    return new oqf(getActivity(), this);
  }
  
  private void a(int paramInt, auwn paramauwn)
  {
    if ((paramauwn instanceof osf))
    {
      paramauwn = (oqr)((osf)paramauwn).be;
      if ((paramauwn != null) && ((paramauwn.B() instanceof stSimpleMetaFeed)))
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramauwn.B();
        osv.a(this.mFrom, this.aqb, paramInt, localstSimpleMetaFeed);
        osv.a(this.mFrom, this.aqb, localstSimpleMetaFeed);
        osv.b(this.mFrom, this.aqb, localstSimpleMetaFeed);
        oqs.a(paramauwn);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt1, int paramInt2)
  {
    ooz.d("WSVerticalPageFragment", "startForResult() needScrollToPosition:" + paramInt1);
    PublicFragmentActivity.b.startForResult(paramActivity, a(paramString1, paramString2, paramList, paramInt1), PublicFragmentActivity.class, WSVerticalPageFragment.class, paramInt2);
    aZ(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramList, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt, boolean paramBoolean)
  {
    ooz.d("WSVerticalPageFragment", "start() needScrollToPosition:" + paramInt);
    paramString1 = a(paramString1, paramString2, paramList, paramInt);
    if (paramBoolean) {
      paramString1.setFlags(67108864);
    }
    PublicFragmentActivity.b.start(paramContext, paramString1, PublicFragmentActivity.class, WSVerticalPageFragment.class);
    if ((paramContext instanceof Activity)) {
      aZ((Activity)paramContext);
    }
  }
  
  private void aPG()
  {
    if (getArguments() != null)
    {
      this.aqb = getArguments().getString("key_play_scene");
      this.lh = ((oqi.a)this.jdField_a_of_type_Oeu).d((ArrayList)getArguments().getSerializable("key_feed_list"));
      WSPublicAccReport.getInstance().reportEnterVerticalVideo(this.lh, 1, true, -1);
      this.bfJ = ((oqi.a)this.jdField_a_of_type_Oeu).dJ(getArguments().getInt("key_feed_position"));
    }
  }
  
  private int aW(String paramString)
  {
    if ((TextUtils.equals(paramString, "recommend_tab")) || (TextUtils.equals(paramString, "aio_new_msg")) || (TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest")) || (TextUtils.equals(paramString, "vertical_layer_collection"))) {
      return 1;
    }
    if (TextUtils.equals(paramString, "follow_tab")) {
      return 0;
    }
    return -1;
  }
  
  private static void aZ(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772261, 2130772260);
  }
  
  private void bdZ()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(opn.getQQAppInterface());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.setLoopback(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.oE(false);
  }
  
  private void bgi()
  {
    if (this.jdField_c_of_type_Ohl == null)
    {
      ooz.i("weishi-comment", "initCommentPresenter create!!!");
      this.jdField_c_of_type_Ohl = new ohl(this, aW(this.mFrom));
      this.jdField_c_of_type_Ohl.a(this);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      this.jdField_c_of_type_Ohl.b(localViewStub);
      this.aw.addView(localViewStub);
      return;
    }
    ooz.i("weishi-comment", "initCommentPresenter 复用~~~~~~,pageIndex:" + this.jdField_c_of_type_Ohl.Ib);
  }
  
  private void bgj()
  {
    oqa localoqa = new oqa(getActivity(), this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(localoqa);
    this.jdField_c_of_type_Oqb = new oqb(getActivity(), this);
    this.jdField_c_of_type_Oqb.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_c_of_type_Oqb);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    if ((this.lh != null) && (this.lh.size() > 0)) {
      this.jdField_c_of_type_Oqb.D(this.lh);
    }
    for (;;)
    {
      localoqa.scrollToPosition(this.bfJ);
      return;
      showLoading(false);
    }
  }
  
  private void bgk()
  {
    if (TextUtils.equals(this.mFrom, "aio_new_msg"))
    {
      if ((!oni.isUserClick) && (!this.aya)) {
        break label53;
      }
      WSPublicAccReport.getInstance().closePublicAccReport(1);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Ohl != null)
      {
        this.jdField_c_of_type_Ohl.onRecycle();
        this.jdField_c_of_type_Ohl = null;
      }
      return;
      label53:
      WSPublicAccReport.getInstance().closePublicAccReport(2);
    }
  }
  
  private void bgl()
  {
    if (TextUtils.equals("mini_app_personal_main", this.mFrom)) {
      opn.pQ("homepage_main");
    }
    while (!TextUtils.equals("mini_app_personal_guest", this.mFrom)) {
      return;
    }
    opn.pQ("homepage_guest");
  }
  
  private boolean ew(int paramInt)
  {
    List localList = this.jdField_c_of_type_Oqb.be();
    ooz.d("WSVerticalPageFragment", "onCenterViewChanged currentPosition:" + paramInt + ", dataList.size:" + localList.size());
    if ((paramInt != 1) && (localList.size() - paramInt < ((oqi.a)this.jdField_a_of_type_Oeu).rN()))
    {
      ooz.d("WSVerticalPageFragment", "onPreLoadMore");
      return true;
    }
    return false;
  }
  
  private void initData()
  {
    ((oqi.a)this.jdField_a_of_type_Oeu).initData();
    ak(false, true);
  }
  
  private void initEvent()
  {
    oiv.a().a(this);
  }
  
  private void initUI(View paramView)
  {
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131381545);
    this.jdField_a_of_type_Ogm = a();
    this.jdField_a_of_type_Ogm.initLayout(localViewStub);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)paramView.findViewById(2131382344));
    this.aw = ((FrameLayout)paramView.findViewById(2131367152));
    this.u = ((ProgressBar)paramView.findViewById(2131381553));
    bdZ();
    bgj();
  }
  
  @NotNull
  private String lN()
  {
    if (TextUtils.equals(this.mFrom, "vertical_layer_collection")) {
      return "second_fullscreen_videoPlay";
    }
    return "fullscreen_videoPlay";
  }
  
  public boolean GG()
  {
    return true;
  }
  
  public void Jw()
  {
    VideoFeedsRecyclerView localVideoFeedsRecyclerView = a();
    if ((localVideoFeedsRecyclerView != null) && (!localVideoFeedsRecyclerView.EK())) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(), false);
    }
  }
  
  public VideoFeedsRecyclerView a()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public okg a()
  {
    return this.b;
  }
  
  public oqb a()
  {
    return this.jdField_c_of_type_Oqb;
  }
  
  @NonNull
  public oqi.a a()
  {
    return oqk.a(this.mFrom, this);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSUserAuthEvent)) && (TextUtils.equals(this.mFrom, "aio_new_msg")))
    {
      ogd.aV(getActivity(), "fullscreen_videoPlay");
      return;
    }
    if (((paramWSSimpleBaseEvent instanceof WSBlockDialogDismissEvent)) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.doOnResume();
      return;
    }
    ((oqi.a)this.jdField_a_of_type_Oeu).a(paramWSSimpleBaseEvent);
  }
  
  public void aSa()
  {
    ooz.d("WSVerticalPageFragment", "onLoadMore");
  }
  
  public void ac(Object paramObject)
  {
    if (this.jdField_a_of_type_Ogm != null) {
      this.jdField_a_of_type_Ogm.setData(paramObject);
    }
  }
  
  public void ak(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((oqi.a)this.jdField_a_of_type_Oeu).c(paramBoolean1, paramBoolean2, this.mFrom);
  }
  
  public void bdX()
  {
    super.bdX();
    opn.pQ("fullscreen_videoPlay");
  }
  
  public void bgh()
  {
    if (this.jdField_c_of_type_Oev == null) {
      this.jdField_c_of_type_Oev = new oev(getActivity());
    }
    if (!this.axZ)
    {
      this.axZ = true;
      this.jdField_c_of_type_Oev.a(ohy.a().a());
      this.jdField_c_of_type_Oev.cp(getActivity());
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.doOnPause();
      }
    }
  }
  
  public List<oqr> bq()
  {
    return this.lh;
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    ooz.d("WSVerticalPageFragment", "onCenterViewChanged: " + paramViewHolder);
    if ((paramViewHolder instanceof orc))
    {
      paramViewHolder = (orc)paramViewHolder;
      int i = paramViewHolder.getLayoutPosition() - 1;
      this.jdField_c_of_type_Oqb.b(paramViewHolder, i);
      ((oqi.a)this.jdField_a_of_type_Oeu).b(paramViewHolder, i);
      paramViewHolder.onPageSelected(i);
      if (ew(i + 1)) {
        ak(false, false);
      }
      a(i, paramViewHolder);
      if (i > 0) {
        this.aya = true;
      }
    }
  }
  
  public void dy(View paramView)
  {
    if (this.b != null) {
      this.b.dw(paramView);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    localArrayList.add(WSBlockDialogDismissEvent.class);
    return localArrayList;
  }
  
  public String getFrom()
  {
    return this.mFrom;
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    this.b = new okg();
    return this.b.a();
  }
  
  public String getPlayScene()
  {
    return this.aqb;
  }
  
  public void hideLoading()
  {
    this.u.setVisibility(8);
  }
  
  public boolean onBackEvent()
  {
    ((oqi.a)this.jdField_a_of_type_Oeu).bgg();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.yH = System.currentTimeMillis();
    ooz.i("weishi-beacon", "进入播放页的时间：" + this.yH);
    if (getArguments() != null) {
      this.mFrom = getArguments().getString("key_from");
    }
    super.onCreate(paramBundle);
    this.mSystemBarComp = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    aPG();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560202, paramViewGroup, false);
    ooz.i("weishi-comment", "onCreateView before initUI~~~~~~~~~~~");
    initUI(paramLayoutInflater);
    initData();
    ooz.i("weishi-comment", "onCreateView after initData~~~~~~~~~~~");
    bgi();
    initEvent();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((oqi.a)this.jdField_a_of_type_Oeu).destroy();
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null)
    {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.doOnDestory();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = null;
    }
    this.jdField_c_of_type_Oqb = null;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    bgl();
    oiv.a().b(this);
    okd.a().release();
    oqp.a().reset();
    ohy.a().pA("global_key_video_layer");
    bgk();
  }
  
  public void onPause()
  {
    super.onPause();
    ((oqi.a)this.jdField_a_of_type_Oeu).doOnPause();
    WSPublicAccReport.getInstance().reportPageVisitExit(lN());
  }
  
  public void onResume()
  {
    super.onResume();
    ((oqi.a)this.jdField_a_of_type_Oeu).doOnResume();
    com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.awK = false;
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setStatusBarVisible(2, 0);
    }
    if (this.yH > 0L)
    {
      long l = System.currentTimeMillis() - this.yH;
      this.yH = 0L;
      ooz.i("weishi-beacon", "播放页初始化耗时：" + l);
      onk.a().a(true, l, "fullscreen_videoPlay", oql.fC(this.mFrom));
    }
    WSPublicAccReport.getInstance().reportPageVisitEnter(lN());
  }
  
  public void qU(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ogm instanceof oqf)) {
      ((oqf)this.jdField_a_of_type_Ogm).qU(paramBoolean);
    }
  }
  
  public void qV(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ogm instanceof oqf)) {
      ((oqf)this.jdField_a_of_type_Ogm).a(paramBoolean, this.b);
    }
  }
  
  public int rO()
  {
    return this.bfJ;
  }
  
  public void setData(List<oqr> paramList)
  {
    this.jdField_c_of_type_Oqb.dx(paramList);
  }
  
  public void showLoading(boolean paramBoolean)
  {
    this.u.setVisibility(0);
  }
  
  public void u(int paramInt, Intent paramIntent)
  {
    getActivity().setResult(paramInt, paramIntent);
  }
  
  public void uR(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.oE(true);
    }
  }
  
  public void uS(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.oE(false);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.isCompleted()) {
        Jw();
      }
    }
  }
  
  public void uT(int paramInt)
  {
    if ((this.jdField_a_of_type_Ogm instanceof oqd)) {
      ((oqd)this.jdField_a_of_type_Ogm).uT(paramInt);
    }
  }
  
  public void uU(int paramInt)
  {
    oog.a(this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment
 * JD-Core Version:    0.7.0.1
 */