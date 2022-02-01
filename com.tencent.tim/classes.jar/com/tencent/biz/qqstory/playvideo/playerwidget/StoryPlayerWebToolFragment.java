package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import ram;

public class StoryPlayerWebToolFragment
  extends PublicBaseFragment
  implements StoryPlayerWebFragment.a
{
  private StoryPlayerWebFragment b;
  private View mRootView;
  
  public void bpu()
  {
    getActivity().finish();
  }
  
  public void bpv() {}
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity.setTheme(16973841);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mRootView = paramLayoutInflater.inflate(2131561935, null);
    paramViewGroup = getChildFragmentManager();
    paramLayoutInflater = getArguments().getString("url");
    paramViewGroup = paramViewGroup.beginTransaction();
    paramBundle = new Intent();
    paramBundle.putExtra("url", paramLayoutInflater);
    paramBundle.putExtra("isFullScreen", true);
    ram.b("StoryPlayerWebToolFragment", "initPromoteFragment() with url: %s", paramLayoutInflater);
    this.b = StoryPlayerWebFragment.a(paramBundle);
    this.b.a(this);
    paramViewGroup.replace(2131382152, this.b).commit();
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebToolFragment
 * JD-Core Version:    0.7.0.1
 */