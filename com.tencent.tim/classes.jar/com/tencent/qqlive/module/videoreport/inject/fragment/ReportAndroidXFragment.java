package com.tencent.qqlive.module.videoreport.inject.fragment;

import androidx.fragment.app.Fragment;

public class ReportAndroidXFragment
  extends Fragment
{
  public void onDestroyView()
  {
    super.onDestroyView();
    AndroidXFragmentCollector.onDestroyView(this);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    AndroidXFragmentCollector.onHiddenChanged(this, paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    AndroidXFragmentCollector.onPause(this);
  }
  
  public void onResume()
  {
    super.onResume();
    AndroidXFragmentCollector.onResume(this);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    AndroidXFragmentCollector.setUserVisibleHint(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment
 * JD-Core Version:    0.7.0.1
 */