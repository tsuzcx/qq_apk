package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader.a;
import com.tencent.biz.pubaccount.readinjoy.view.widget.WordNavView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import kxm;
import lbz;
import lcc;
import len;
import leo;
import lhf;
import ljw;
import ljw.a;
import ljy;
import ljy.a;
import mkt;

public class ReadInJoySelectPositionFragment
  extends IphoneTitleBarFragment
  implements ReadInJoySelectPositionHeader.a, ljy.a
{
  private SelectPositionModule.PositionData jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
  private ReadInJoySelectPositionHeader jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader;
  private WordNavView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView;
  private ljw jdField_a_of_type_Ljw;
  private ljy jdField_a_of_type_Ljy;
  private ListView h;
  private List<ljw.a> mDataList;
  
  private void aC()
  {
    this.vg.changeBg(true);
    setTitle("城市");
    if (ThemeUtil.isInNightMode(kxm.getAppRuntime())) {
      View.inflate(getActivity(), 2131560438, this.titleRoot);
    }
  }
  
  private void aLd()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader = new ReadInJoySelectPositionHeader(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setSelectCityListener(this);
    this.h.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader);
  }
  
  private void initData()
  {
    Object localObject = lbz.a().a();
    if (localObject != null)
    {
      SelectPositionModule.PositionData localPositionData = ((SelectPositionModule)localObject).c();
      localObject = ((SelectPositionModule)localObject).b();
      if (localPositionData == null) {
        break label82;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(localPositionData);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setSelectedCity(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city);
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setGPSCity(((SelectPositionModule.PositionData)localObject).cityGPS);
      }
      this.jdField_a_of_type_Ljy = new ljy(this);
      this.jdField_a_of_type_Ljy.aMJ();
      return;
      label82:
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setSelectedCity(((SelectPositionModule.PositionData)localObject).city);
      }
    }
  }
  
  private void initUI()
  {
    if (this.mContentView != null)
    {
      this.h = ((ListView)this.mContentView.findViewById(2131364621));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView = ((WordNavView)this.mContentView.findViewById(2131369138));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView.setOnTouchingWordChangedListener(new len(this));
      this.jdField_a_of_type_Ljw = new ljw(getActivity());
      aLd();
      this.h.setAdapter(this.jdField_a_of_type_Ljw);
      this.h.setOnItemClickListener(new leo(this));
    }
  }
  
  private void nc(String paramString)
  {
    int i = 0;
    if (i < this.mDataList.size()) {
      if ((((ljw.a)this.mDataList.get(i)).type != 1) || (!((ljw.a)this.mDataList.get(i)).index.equals(paramString))) {}
    }
    for (;;)
    {
      this.h.setSelection(i + 1);
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    if (paramPositionData == null)
    {
      QLog.e("ReadInJoySelectPositionFragment", 2, "selectPosition positionData = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySelectPositionFragment", 2, "selectPosition positionData" + paramPositionData);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.cityCode == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.cityCode.equals(paramPositionData.cityCode)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(paramPositionData);
      SelectPositionModule localSelectPositionModule = lbz.a().a();
      if (localSelectPositionModule != null)
      {
        localSelectPositionModule.d(paramPositionData);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setSelectedCity(paramPositionData.city);
      }
      lbz.a().aq(41695, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city);
      paramPositionData = lbz.a().a();
      if (paramPositionData != null) {
        paramPositionData.re(41695);
      }
      lcc.a().oC(41695);
    }
    onBackEvent();
  }
  
  public void b(SelectPositionModule.PositionData paramPositionData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setGPSCity(paramPositionData.cityGPS);
    }
  }
  
  public void ci(List<ljw.a> paramList)
  {
    this.mDataList = paramList;
    this.jdField_a_of_type_Ljw.setData(this.mDataList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((ljw.a)paramList.get(i)).type == 1) {
        localArrayList.add(((ljw.a)paramList.get(i)).index);
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView.setIndexList(localArrayList);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    aC();
    initUI();
    initData();
  }
  
  public int getContentLayoutId()
  {
    return 2131560464;
  }
  
  public void onResume()
  {
    super.onResume();
    mkt.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelectPositionFragment
 * JD-Core Version:    0.7.0.1
 */