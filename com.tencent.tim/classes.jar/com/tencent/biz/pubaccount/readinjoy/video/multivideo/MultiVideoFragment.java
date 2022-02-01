package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aqcx;
import aqnm;
import ayxa;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView.a;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import kmh;
import kxm;
import kzc;
import mvh;
import mwl;
import nah;
import nah.a;
import nai;
import nan;
import nao;
import nap;
import nap.a;
import naq.a;
import naq.b;
import naq.d;
import nav;
import naw;
import ntp;

public class MultiVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, VideoFeedsRecyclerView.a, nah.a, naq.a
{
  private static final String TAG = MultiVideoFragment.class.getSimpleName();
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoFragment$a;
  private MultiVideoLoadingFooter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter;
  private mwl jdField_a_of_type_Mwl;
  private nah jdField_a_of_type_Nah;
  private kmh jdField_b_of_type_Kmh;
  private nai jdField_b_of_type_Nai;
  private naq.d jdField_b_of_type_Naq$d;
  private ViewGroup bK;
  private ViewGroup bW;
  private VideoFeedsRecyclerView c;
  private ImageView dr;
  private QQAppInterface mApp;
  private LinearLayoutManager mLayoutManager;
  private View mRootView;
  private TextView sF;
  
  private void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Mwl = new mwl(getActivity());
    this.mRootView = paramLayoutInflater.inflate(2131560412, paramViewGroup, false);
    this.bW = ((ViewGroup)this.mRootView.findViewById(2131365025));
    this.dr = ((ImageView)this.mRootView.findViewById(2131371280));
    this.sF = ((TextView)this.mRootView.findViewById(2131371301));
    this.bK = ((ViewGroup)this.mRootView.findViewById(2131371292));
    this.c = ((VideoFeedsRecyclerView)this.mRootView.findViewById(2131381801));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter = new MultiVideoLoadingFooter(getActivity());
    VideoFeedsAccessibilityHelper.b(this.c);
    this.c.setExtraFooterCount(1);
    this.c.addFooterView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter);
    int i = qo();
    this.c.setSnapOffset(i);
    this.c.setHeaderHeight(i);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoFragment$a = new a(null);
    this.c.addOnScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoFragment$a);
    this.mLayoutManager = new mvh(getActivity(), this.c, 1, false);
    this.c.setLayoutManager(this.mLayoutManager);
    this.jdField_a_of_type_Nah = new nah(this.c, this.jdField_b_of_type_Naq$d.bg(), getActivity(), this.mApp, this);
    this.c.setAdapter(this.jdField_a_of_type_Nah);
    this.c.setFlingVelocityIncrease(kzc.ob());
    if (this.c.getMinFlingVelocity() > 10000)
    {
      this.c.setFlingVelocityIncrease(0);
      this.c.setSnapOnFling(false);
      this.c.setSnapOnIdle(false);
    }
    for (;;)
    {
      this.sF.setText(kzc.jb());
      this.dr.setOnClickListener(this);
      if (ayxa.isLiuHaiUseValid()) {
        nap.a(getActivity(), this.bW);
      }
      nap.a(getActivity(), this.bK);
      this.jdField_b_of_type_Kmh = new kmh(getActivity(), this.jdField_a_of_type_Nah);
      return;
      if (this.c.getMinFlingVelocity() <= 0)
      {
        this.c.setFlingVelocityIncrease(0);
        this.c.setSnapOnFling(true);
        this.c.setSnapOnIdle(true);
      }
      else
      {
        this.c.setSnapOnIdle(false);
        this.c.setSnapOnFling(true);
      }
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent, String paramString)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    Bundle localBundle = nap.a(localIntent);
    paramIntent = paramString;
    if (localIntent.getExtras() != null)
    {
      paramIntent = paramString;
      if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
        paramIntent = paramString + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    ntp.a(paramContext, null, paramIntent, localBundle, true);
  }
  
  private void b(nai paramnai)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramnai instanceof nav)) {
      if (paramnai.i().k(getActivity())) {
        bool2 = false;
      }
    }
    for (;;)
    {
      this.c.setNeedDetectOrientation(getActivity(), bool2, bool1);
      return;
      bool1 = true;
      continue;
      bool2 = false;
      bool1 = true;
    }
  }
  
  public static void d(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (kzc.Bm())
    {
      Bundle localBundle = nap.a(localIntent);
      localBundle.putInt("requestCode", paramInt);
      String str = "https://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1&_ckey=rij_video_feeds_cache_key";
      paramIntent = str;
      if (localIntent.getExtras() != null)
      {
        paramIntent = str;
        if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
          paramIntent = "https://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1&_ckey=rij_video_feeds_cache_key" + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
        }
      }
      ntp.a(paramActivity, null, paramIntent, localBundle, true);
      return;
    }
    PublicTransFragmentActivity.startForResult(paramActivity, localIntent, MultiVideoFragment.class, paramInt);
  }
  
  private int qo()
  {
    return aqcx.dip2px(getActivity(), 44.0F) + ayxa.getNotchInScreenHeight(getActivity()) + aqnm.dip2px(10.0F);
  }
  
  public static void s(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (kzc.Bm())
    {
      Bundle localBundle = nap.a(localIntent);
      String str = "https://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1&_ckey=rij_video_feeds_cache_key";
      paramIntent = str;
      if (localIntent.getExtras() != null)
      {
        paramIntent = str;
        if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
          paramIntent = "https://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1&_ckey=rij_video_feeds_cache_key" + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
        }
      }
      ntp.a(paramContext, null, paramIntent, localBundle, true);
      return;
    }
    PublicTransFragmentActivity.start(paramContext, localIntent, MultiVideoFragment.class);
  }
  
  public void Jw()
  {
    this.c.EK();
  }
  
  public naq.b a(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.c.findViewHolderForLayoutPosition(this.c.getHeaderViewsCount() + paramInt);
    if ((localViewHolder instanceof naq.b)) {
      return (naq.b)localViewHolder;
    }
    return null;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(View paramView, int paramInt, FrameLayout.LayoutParams paramLayoutParams)
  {
    this.bW.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void a(nai paramnai)
  {
    paramnai.a(this.jdField_b_of_type_Naq$d, this, this.jdField_b_of_type_Naq$d.a(), this.jdField_b_of_type_Naq$d.a());
  }
  
  public void a(nai paramnai, VideoInfo paramVideoInfo, int paramInt)
  {
    this.jdField_b_of_type_Naq$d.a(paramnai);
  }
  
  public void a(nap.a<naq.b> parama)
  {
    nap.a(this.c, new nan(this, parama));
  }
  
  public void aRC()
  {
    this.c.setNeedDetectOrientation(getActivity(), false, false);
  }
  
  public void aRD()
  {
    b(this.jdField_b_of_type_Nai);
  }
  
  protected void aSO()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_b_of_type_Naq$d.a();
    Bundle localBundle = getArguments();
    long l = localVideoFeedsPlayManager.cV();
    Object localObject = localVideoFeedsPlayManager.e();
    if (this.jdField_b_of_type_Naq$d.f() == localObject)
    {
      localBundle.putInt("VIDEO_PLAY_STATUS", localVideoFeedsPlayManager.pX());
      localBundle.putLong("VIDEO_PLAY_POSITION", l);
    }
    for (;;)
    {
      if (localObject != null) {
        localBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject).Wz);
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      getActivity().overridePendingTransition(0, 2130772028);
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 2, "finishActivityWithResult() position=" + l + ", currentPlayStatus=" + localVideoFeedsPlayManager.pX());
      }
      return;
      localBundle.putInt("VIDEO_PLAY_STATUS", 0);
      localBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  public void aSa() {}
  
  public void aUp()
  {
    this.c.oH(false);
  }
  
  public void aVf()
  {
    this.c.ov(true);
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof nai)) {}
    for (this.jdField_b_of_type_Nai = ((nai)paramViewHolder);; this.jdField_b_of_type_Nai = null)
    {
      b(this.jdField_b_of_type_Nai);
      return;
    }
  }
  
  public long cX()
  {
    return this.c.cX();
  }
  
  public void dc(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Nah.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_b_of_type_Naq$d.onKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    if (VersionUtils.isIceScreamSandwich()) {
      paramActivity.getWindow().setFlags(16777216, 16777216);
    }
    try
    {
      paramActivity.requestWindowFeature(1);
      label25:
      paramActivity.getWindow().setFlags(1024, 1024);
      ayxa.initLiuHaiProperty(paramActivity);
      if (ayxa.isLiuHaiUseValid()) {
        ayxa.enableNotch(paramActivity);
      }
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_b_of_type_Naq$d.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_Naq$d.Q(true)) {
      return true;
    }
    aSO();
    return true;
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
      this.jdField_b_of_type_Naq$d.Q(false);
      aSO();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
    this.jdField_b_of_type_Naq$d = new naw(getActivity(), getArguments(), this);
    a(paramLayoutInflater, paramViewGroup);
    this.c.a(this);
    this.jdField_b_of_type_Naq$d.a(this.c, this.jdField_a_of_type_Nah, this.mRootView);
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_Naq$d != null) {
      this.jdField_b_of_type_Naq$d.doOnDestory();
    }
    if (this.jdField_b_of_type_Kmh != null) {
      this.jdField_b_of_type_Kmh.destroy();
    }
    if (this.c != null) {
      this.c.doOnDestory();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Naq$d.doOnPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_Naq$d.doOnResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void ox(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.bW.setBackgroundColor(-15921907);
      this.c.setNeedDetectOrientation(getActivity(), false, false);
      this.sF.setVisibility(8);
      this.dr.setVisibility(8);
      return;
    }
    this.bW.setBackgroundDrawable(null);
    b(this.jdField_b_of_type_Nai);
    this.sF.setVisibility(0);
    this.dr.setVisibility(0);
  }
  
  public void td(int paramInt)
  {
    this.jdField_a_of_type_Nah.tc(paramInt);
  }
  
  public void te(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter.te(paramInt);
  }
  
  public void tf(int paramInt)
  {
    this.c.dW(this.c.getHeaderViewsCount() + paramInt);
  }
  
  public class a
    extends RecyclerView.OnScrollListener
  {
    private int aVr = 0;
    
    private a() {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      if (paramInt == 0) {}
      nap.a(MultiVideoFragment.a(MultiVideoFragment.this), new nao(this, paramInt));
      this.aVr = paramInt;
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment
 * JD-Core Version:    0.7.0.1
 */