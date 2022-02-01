package com.tencent.mobileqq.fragment;

import ahpb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import arib;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class BaseFragment
  extends ReportV4Fragment
{
  protected ahpb a;
  protected arib a;
  public IphoneTitleBarActivity b;
  protected boolean isCreate;
  protected boolean isResume;
  protected View rootView;
  protected int tabID;
  protected boolean zw;
  
  public BaseFragment()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Fragment", 2, "new BaseFragment:" + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void ckW()
  {
    doK();
    onHiddenChanged(false);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onPageSelected() " + getClass().getSimpleName());
    }
  }
  
  public void doJ() {}
  
  public void doK()
  {
    if ((getActivity() instanceof NearbyActivity)) {
      ((NearbyActivity)getActivity()).a(this.jdField_a_of_type_Ahpb);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onActivityCreated() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("NBase", 2, "onActivityResult() BaseFragment");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onAttach() " + getClass().getSimpleName() + " " + hashCode());
    }
    if (this.jdField_a_of_type_Ahpb == null) {
      this.jdField_a_of_type_Ahpb = new ahpb(this);
    }
    this.b = ((IphoneTitleBarActivity)getActivity());
    this.zw = true;
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onCreate() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onCreateView() " + getClass().getSimpleName() + " " + hashCode());
    }
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onDestroy() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.isCreate = false;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onDestroyView() " + getClass().getSimpleName() + " " + hashCode());
    }
    if (this.jdField_a_of_type_Arib != null) {
      this.jdField_a_of_type_Arib.dismiss();
    }
    if (this.rootView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.rootView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.rootView);
      }
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.zw = false;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onDetach() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onHiddenChanged() " + getClass().getSimpleName() + " " + hashCode() + " hidden=" + paramBoolean);
    }
    if (paramBoolean)
    {
      onPause();
      return;
    }
    onResume();
  }
  
  public void onPause()
  {
    super.onPause();
    this.isResume = false;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onPause() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.isResume = true;
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onResume() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onStart() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("Fragment", 2, "onStop() " + getClass().getSimpleName() + " " + hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BaseFragment
 * JD-Core Version:    0.7.0.1
 */