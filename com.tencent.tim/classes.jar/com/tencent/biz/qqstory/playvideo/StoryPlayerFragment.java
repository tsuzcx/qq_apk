package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import qfv;
import qfx;
import qfy;
import qfz;
import qfz.b;

public class StoryPlayerFragment
  extends ReportV4Fragment
  implements qfz.b
{
  public AnimationParam a;
  protected qfz a;
  private boolean aDh;
  private int blY;
  
  public void finish()
  {
    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
  }
  
  @NonNull
  public Context getContext()
  {
    return getActivity();
  }
  
  @NonNull
  public View getRootView()
  {
    return getView();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Qfz.a(paramBundle, getArguments());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Qfz.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_Qfz = new qfz();
    this.jdField_a_of_type_Qfz.a(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam = ((AnimationParam)getArguments().getParcelable("AnimationParam"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561926, paramViewGroup, false);
    paramViewGroup = getActivity();
    this.blY = paramViewGroup.getWindow().getAttributes().flags;
    if ((this.blY & 0x400) != 1024) {
      getActivity().getWindow().setFlags(1024, 1024);
    }
    if (paramViewGroup.mSystemBarComp != null)
    {
      this.aDh = paramViewGroup.mSystemBarComp.isStatusBarVisible;
      if (paramViewGroup.mSystemBarComp.isStatusBarVisible) {
        paramViewGroup.mSystemBarComp.setgetStatusBarVisible(false, 0);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null) {
      paramLayoutInflater.getViewTreeObserver().addOnPreDrawListener(new qfv(this, paramLayoutInflater));
    }
    paramLayoutInflater.setOnTouchListener(new qfx(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Qfz.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    FragmentActivity localFragmentActivity = getActivity();
    localFragmentActivity.getWindow().setFlags(this.blY, -1);
    if (localFragmentActivity.mSystemBarComp != null) {
      localFragmentActivity.mSystemBarComp.setgetStatusBarVisible(this.aDh, 0);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Qfz.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Qfz.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Qfz.onStart();
    getView().setFocusableInTouchMode(true);
    getView().requestFocus();
    getView().setOnKeyListener(new qfy(this));
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Qfz.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerFragment
 * JD-Core Version:    0.7.0.1
 */