package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class NearbyMsgFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public NearbyActivity b;
  
  public void ckW()
  {
    super.ckW();
    this.mHandler.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onPageSelected， startMsgBoxListActivity");
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onActivityCreated");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
      this.jdField_b_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
    }
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onAttach");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onCreate");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onCreateView: lastIdx=" + this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ);
    }
    if (this.rootView == null)
    {
      this.rootView = paramLayoutInflater.inflate(2131561451, paramViewGroup, false);
      if ((this.a != null) && (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ == this.a.tabIndex))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityNearbyActivity.xF(false);
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyMsgFragment", 2, "onCreateView, startMsgBoxListActivity");
        }
      }
    }
    paramLayoutInflater = this.rootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onDestroy");
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onDestroyView");
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onHiddenChanged, hidden=" + paramBoolean);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onPause");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyMsgFragment", 2, "onResume");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyMsgFragment
 * JD-Core Version:    0.7.0.1
 */