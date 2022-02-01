package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import awit;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;
import kfv;
import kgc;
import ldx;
import mqq.app.Constants.LogoutReason;

public abstract class ReadInJoyFragmentWithSubChannel<C extends ChannelClassificationListView.b>
  extends ReadInJoyBaseFragment
{
  a a;
  public ChannelClassificationListView<C> a;
  public kgc a;
  public boolean ajE;
  
  protected boolean BX()
  {
    return false;
  }
  
  public void C(View paramView, int paramInt) {}
  
  protected abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<C> paramChannelClassificationListView);
  
  public abstract a a();
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_Kgc != null) {
      this.jdField_a_of_type_Kgc.aBY();
    }
  }
  
  public void aCc()
  {
    super.aCc();
    this.ajy = false;
    if (this.jdField_a_of_type_Kgc != null) {
      this.jdField_a_of_type_Kgc.aCc();
    }
  }
  
  public void aIp()
  {
    super.aIp();
    if (this.jdField_a_of_type_Kgc != null) {
      this.jdField_a_of_type_Kgc.lP(true);
    }
  }
  
  public void aIq()
  {
    if (this.jdField_a_of_type_Kgc != null) {
      this.jdField_a_of_type_Kgc.lP(true);
    }
  }
  
  protected void aKY() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Kgc != null) {
      this.jdField_a_of_type_Kgc.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    aKY();
    super.onCreate(paramBundle);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (awit.H(getActivity().getAppRuntime()) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ajE = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyFragmentWithSubChannel", 2, "92 showSub = " + this.ajE);
      }
      if ((!BX()) && (this.ajE))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView = new ChannelClassificationListView(getActivity());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setOnItemClickListener(new ldx(this));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentWithSubChannel$a = a();
      this.jdField_a_of_type_Kgc = new kgc(nh(), 0, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentWithSubChannel$a);
      paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, paramBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView);
      this.jdField_a_of_type_Kgc.onCreate();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null) {
        this.jdField_a_of_type_Kgc.aCy();
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Kgc.onDestroy();
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    super.onLogout(paramLogoutReason);
    if ((awit.aMG()) && (this.jdField_a_of_type_Kgc != null)) {
      this.jdField_a_of_type_Kgc.onLogout(paramLogoutReason);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Kgc != null) {
      this.jdField_a_of_type_Kgc.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Kgc.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((getActivity().isFinishing()) && (this.jdField_a_of_type_Kgc != null)) {
      this.jdField_a_of_type_Kgc.aBZ();
    }
  }
  
  public void qc(int paramInt)
  {
    super.qc(paramInt);
    if (this.jdField_a_of_type_Kgc != null)
    {
      this.jdField_a_of_type_Kgc.O(true, 0);
      return;
    }
    kfv.oK(nh());
  }
  
  public static abstract interface a<DataType>
  {
    public abstract boolean BY();
    
    public abstract List<DataType> aG();
    
    public abstract void aGI();
    
    public abstract void cg(List<DataType> paramList);
    
    public abstract void ch(List<ChannelCoverInfo> paramList);
    
    public abstract void d(DataType paramDataType, int paramInt);
    
    public abstract boolean e(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract DataType h(int paramInt);
    
    public abstract void notifyDataChange();
    
    public abstract void refreshData();
    
    public abstract void setData(List<DataType> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentWithSubChannel
 * JD-Core Version:    0.7.0.1
 */