package com.tencent.mobileqq.apollo.debug.page;

import abkj;
import abkq;
import abmt;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import aqcx;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogPagerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.List;

public class CmGameDebugLogFragment
  extends CmGameDebugBaseFragment
  implements View.OnClickListener
{
  TextView PI;
  TextView PJ;
  TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private CmGameDebugLogPagerAdapter jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter;
  private List<abkq> wl = new ArrayList();
  
  private abkq a(int paramInt)
  {
    int i = 0;
    while (i < this.wl.size())
    {
      abkq localabkq = (abkq)this.wl.get(i);
      if (localabkq.zC() == paramInt) {
        return localabkq;
      }
      i += 1;
    }
    return null;
  }
  
  private void ckj()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < abkj.dv.length)
    {
      abkq localabkq = a(getActivity(), i);
      this.wl.add(localabkq);
      localArrayList.add(abkj.dv[i]);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter = new CmGameDebugLogPagerAdapter(this.wl, localArrayList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter);
  }
  
  public void Hr(int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      while (paramInt < this.wl.size())
      {
        ((abkq)this.wl.get(paramInt)).DK(true);
        paramInt += 1;
      }
    }
    abkq localabkq = a(paramInt);
    if (localabkq != null) {
      localabkq.DK(false);
    }
    localabkq = a(0);
    if (localabkq != null) {
      localabkq.DK(false);
    }
  }
  
  public abkq a(Context paramContext, int paramInt)
  {
    return new abkq(paramContext, paramInt);
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
      abkj localabkj = abmt.a();
      if (localabkj != null)
      {
        localabkj.DJ(true);
        continue;
        cCB();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559001, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramLayoutInflater.findViewById(2131364827));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramLayoutInflater.findViewById(2131364828));
    this.PI = ((TextView)paramLayoutInflater.findViewById(2131364823));
    this.PJ = ((TextView)paramLayoutInflater.findViewById(2131364824));
    this.PI.setOnClickListener(this);
    this.PJ.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(-16777216, -16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(aqcx.dip2px(BaseApplicationImpl.getApplication(), 1.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorColor(Color.parseColor("#6090e3"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    ckj();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.wl.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.page.CmGameDebugLogFragment
 * JD-Core Version:    0.7.0.1
 */