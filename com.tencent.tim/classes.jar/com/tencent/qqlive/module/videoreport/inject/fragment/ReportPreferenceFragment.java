package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.preference.PreferenceFragment;

public class ReportPreferenceFragment
  extends PreferenceFragment
{
  public void onDestroyView()
  {
    super.onDestroyView();
    FragmentCollector.onDestroyView(this);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    FragmentCollector.onHiddenChanged(this, paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    FragmentCollector.onPause(this);
  }
  
  public void onResume()
  {
    super.onResume();
    FragmentCollector.onResume(this);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    FragmentCollector.setUserVisibleHint(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.ReportPreferenceFragment
 * JD-Core Version:    0.7.0.1
 */