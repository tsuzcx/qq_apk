package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import aqcx;
import aqfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import mix;
import mqi;
import mqj;

public class SelectVideoTabFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static String KEY_BUNDLE = "KEY_BUNDLE";
  private static final int[] dp = { 2131718431, 2131718440 };
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private PublicBaseFragment jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment;
  private int aHc;
  private Activity activity;
  private TabLayoutCompat jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private ImmersiveTitleBar2 d;
  private ImageView ju;
  private ArrayList<PublicBaseFragment> lk = new ArrayList();
  
  private void Qm()
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment = SelectVideoFragment.a(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = ViolaFragment.a(mix.kb() + this.aHc, getResources().getString(2131718440), null, true);
    this.lk.add(this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment);
    this.lk.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment);
  }
  
  private void aPK()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(new mqj(this));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(aqcx.dip2px(getActivity(), 2.0F));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorColor(Color.parseColor("#262626"));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingLeft(aqcx.dip2px(getActivity(), 32.0F));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingRight(aqcx.dip2px(getActivity(), 32.0F));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingBottom(aqcx.dip2px(getActivity(), 0.0F));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(Color.parseColor("#737373"), Color.parseColor("#262626"));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextSize(aqcx.sp2px(getActivity(), 16.0F));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat, false);
  }
  
  private void aQs()
  {
    if ((VersionUtils.isM()) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.d.setBackgroundColor(-1);
    }
  }
  
  private void aRu()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      localObject = (ColumnInfo)((Bundle)localObject).getParcelable("key_column_info");
      if (localObject == null) {
        break label34;
      }
    }
    label34:
    for (int i = ((ColumnInfo)localObject).columnID;; i = 0)
    {
      this.aHc = i;
      return;
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.activity = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364690) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(this.activity, 2131560468, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.d = ((ImmersiveTitleBar2)paramView.findViewById(2131379866));
    this.ju = ((ImageView)paramView.findViewById(2131364690));
    this.ju.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131377955));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131377952));
    aRu();
    Qm();
    aPK();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setScrollable(false);
    paramView = getActivity().getSupportFragmentManager();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(new mqi(this, paramView));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(0);
    aQs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab.SelectVideoTabFragment
 * JD-Core Version:    0.7.0.1
 */