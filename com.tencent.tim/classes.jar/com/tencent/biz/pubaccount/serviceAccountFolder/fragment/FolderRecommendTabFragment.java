package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import aqfe;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedBaseHeaderView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import nyu;
import obt;
import rxq;
import rxt;
import ryh;
import rze;
import saf;
import sbf;
import sqn;

public class FolderRecommendTabFragment
  extends FolderBaseTabFragment
{
  private BlockContainer a;
  private boolean avA;
  private boolean avG;
  private int bdg = QzoneConfig.getInstance().getConfig("qqsubscribe", "RecommendBannerCheckDisplayInterval", 3);
  protected String mCurrentUin;
  protected ExtraTypeInfo mExtraTypeInfo;
  
  private boolean Gt()
  {
    long l = dp();
    return System.currentTimeMillis() / 1000L - l > this.bdg * 24 * 60 * 60;
  }
  
  public void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt)
  {
    if (paramInt == getCurrentIndex())
    {
      paramServiceAccountFolderActivityNew.L(false);
      if ((Gt()) && (!this.avG))
      {
        this.avG = true;
        sqn.a("auth_discover", "reco_exp", 0, 0, new String[0]);
      }
    }
  }
  
  protected void bcD()
  {
    this.a = ((BlockContainer)this.mRootView.findViewById(2131377248));
    this.a.setParentFragment(this);
    this.a.setLayoutManagerType(3, 2);
    this.a.setEnableLoadMore(true);
    if (Gt()) {
      this.a.a(new a(null));
    }
    sbf localsbf = new sbf(null);
    localsbf.ym(0);
    localsbf.setInNightMode(this.avA);
    localsbf.uv(false);
    this.a.a(localsbf);
    this.a.setExtraTypeInfo(this.mExtraTypeInfo);
    this.a.setEnableRefresh(true);
    this.a.start();
  }
  
  public void bcE()
  {
    long l = System.currentTimeMillis() / 1000L;
    aqfe.J(BaseApplicationImpl.getContext(), "subscribe_recommend_banner_unlike_timestamp_" + this.mCurrentUin, String.valueOf(l));
  }
  
  public long dp()
  {
    try
    {
      long l = Long.valueOf(aqfe.get(BaseApplicationImpl.getContext(), "subscribe_recommend_banner_unlike_timestamp_" + this.mCurrentUin)).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0L;
  }
  
  public int getCurrentIndex()
  {
    return bde;
  }
  
  protected void initViewData()
  {
    if (this.mRootView == null) {
      this.mRootView = LayoutInflater.from(getActivity()).inflate(2131558840, null);
    }
    this.mCurrentUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.avA = rze.Mp();
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      ExtraTypeInfo localExtraTypeInfo2 = (ExtraTypeInfo)getActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      ExtraTypeInfo localExtraTypeInfo1 = localExtraTypeInfo2;
      if (localExtraTypeInfo2 == null) {
        localExtraTypeInfo1 = new ExtraTypeInfo();
      }
      this.mExtraTypeInfo = new ExtraTypeInfo(7004, localExtraTypeInfo1.sourceType);
    }
    bcD();
    QLog.d(FolderBaseTabFragment.TAG, 4, "initViewData:" + getCurrentIndex());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mRootView == null) {
      this.mRootView = LayoutInflater.from(getActivity()).inflate(2131558840, null);
    }
    this.avA = rze.Mp();
    if (this.avA) {
      this.mRootView.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      QLog.d(FolderBaseTabFragment.TAG, 4, "onCreateView:" + getCurrentIndex());
      paramLayoutInflater = this.mRootView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.mRootView.setBackgroundColor(-1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public class FolderRecommendHeadItemView
    extends RelativeFeedBaseHeaderView
  {
    public FolderRecommendHeadItemView(Context paramContext)
    {
      super();
    }
    
    public void P(Object paramObject) {}
    
    public void dp(View paramView)
    {
      setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      addView(paramView);
    }
    
    public void e(Context paramContext, View paramView) {}
    
    public int getLayoutId()
    {
      return 0;
    }
  }
  
  public class a
    extends ryh
  {
    private FolderRecommendTabFragment.FolderRecommendHeadItemView jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
    private TopPanelViewNew jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew;
    private saf jdField_a_of_type_Saf;
    
    public a(Bundle paramBundle)
    {
      super();
    }
    
    public BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
    {
      return this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
    }
    
    public void loadData(rxt paramrxt)
    {
      if ((paramrxt.Mg()) && (obt.Gz()) && (this.jdField_a_of_type_Saf != null)) {
        this.jdField_a_of_type_Saf.start();
      }
    }
    
    public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
    {
      super.onDetachedFromRecyclerView(paramRecyclerView);
      if (this.jdField_a_of_type_Saf != null) {
        this.jdField_a_of_type_Saf.destroy();
      }
    }
    
    public void onInitBlock(Bundle paramBundle)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew = new TopPanelViewNew(getActivity());
      paramBundle = new FrameLayout.LayoutParams(-1, -2);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew.setLayoutParams(paramBundle);
      this.jdField_a_of_type_Saf = new saf(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew);
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = new FolderRecommendTabFragment.FolderRecommendHeadItemView(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment, getActivity());
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.dp(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew.setOnHideBtnClickListener(new nyu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment
 * JD-Core Version:    0.7.0.1
 */