package com.tencent.mobileqq.flutter.container;

import ahfi;
import ahfj;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class QFlutterContainerFragment
  extends PublicBaseFragment
  implements ahfi
{
  private ahfj a;
  
  public FragmentManager a()
  {
    return getChildFragmentManager();
  }
  
  public Bundle d()
  {
    return getArguments();
  }
  
  public Activity getHostActivity()
  {
    return getActivity();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new ahfj(this);
    this.a.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.a != null) {}
    for (paramLayoutInflater = this.a.onCreateView();; paramLayoutInflater = null)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.a != null) {
      this.a.onPostThemeChanged();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.dng();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */