package com.tencent.qapmsdk.memory.leakdetect;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentManager.FragmentLifecycleCallbacks;
import android.support.annotation.RequiresApi;

class AndroidOFragmentWatcher
{
  @RequiresApi(26)
  private FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks = new AndroidOFragmentWatcher.1(this);
  
  @RequiresApi(26)
  void registerCallbacks(Activity paramActivity)
  {
    paramActivity.getFragmentManager().registerFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.AndroidOFragmentWatcher
 * JD-Core Version:    0.7.0.1
 */