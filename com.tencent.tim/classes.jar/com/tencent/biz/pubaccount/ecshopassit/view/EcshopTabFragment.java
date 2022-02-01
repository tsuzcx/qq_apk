package com.tencent.biz.pubaccount.ecshopassit.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import aqmr;
import aqyx;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import kee;
import ket;
import keu;
import kev;

public class EcshopTabFragment
  extends PublicBaseFragment
{
  private static final String TAG = EcshopTabFragment.class.getSimpleName();
  private EcshopWebview a;
  public ket a;
  public int aIp;
  public String mUrl;
  
  private void bV(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview = kev.a().a(paramView.getContext(), this.mUrl);
    paramView = (FrameLayout)paramView.findViewById(2131365366);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview);
    }
    paramView.addView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview);
    this.jdField_a_of_type_Ket = new keu(this, getActivity(), getActivity(), kee.getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview, this.mUrl);
    this.jdField_a_of_type_Ket.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new aqyx(this.jdField_a_of_type_Ket).a(null, kee.getAppInterface(), null);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.setDrawingCacheEnabled(true);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview != null) && (!aqmr.isEmpty(this.mUrl))) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.loadUrl(this.mUrl);
    }
  }
  
  public boolean a(EcshopTabFragment paramEcshopTabFragment)
  {
    if (paramEcshopTabFragment == null) {}
    while ((!this.mUrl.equals(paramEcshopTabFragment.mUrl)) || (this.aIp != paramEcshopTabFragment.aIp)) {
      return false;
    }
    return true;
  }
  
  public void an(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "【setData】");
    }
    this.aIp = paramInt;
    this.mUrl = paramString;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131562094, paramViewGroup, false);
    bV(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopTabFragment
 * JD-Core Version:    0.7.0.1
 */