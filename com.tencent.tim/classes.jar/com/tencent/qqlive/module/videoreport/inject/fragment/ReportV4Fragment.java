package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.support.v4.app.Fragment;

public class ReportV4Fragment
  extends Fragment
{
  public void onDestroyView()
  {
    super.onDestroyView();
    V4FragmentCollector.onDestroyView(this);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    V4FragmentCollector.onHiddenChanged(this, paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    V4FragmentCollector.onPause(this);
  }
  
  public void onResume()
  {
    super.onResume();
    V4FragmentCollector.onResume(this);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    V4FragmentCollector.setUserVisibleHint(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment
 * JD-Core Version:    0.7.0.1
 */