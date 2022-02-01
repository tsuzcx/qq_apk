package com.app.hubert.guide.lifecycle;

import android.support.v4.app.Fragment;
import com.app.hubert.guide.util.LogUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public class V4ListenerFragment
  extends ReportV4Fragment
{
  FragmentLifecycle mFragmentLifecycle;
  
  public void onDestroy()
  {
    super.onDestroy();
    LogUtil.d("onDestroy: ");
    if (this.mFragmentLifecycle != null) {
      this.mFragmentLifecycle.onDestroy();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.mFragmentLifecycle != null) {
      this.mFragmentLifecycle.onDestroyView();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    LogUtil.d("onStart: ");
    if (this.mFragmentLifecycle != null) {
      this.mFragmentLifecycle.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.mFragmentLifecycle != null) {
      this.mFragmentLifecycle.onStop();
    }
  }
  
  public void setFragmentLifecycle(FragmentLifecycle paramFragmentLifecycle)
  {
    this.mFragmentLifecycle = paramFragmentLifecycle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.app.hubert.guide.lifecycle.V4ListenerFragment
 * JD-Core Version:    0.7.0.1
 */