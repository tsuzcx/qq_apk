package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;

public class AndroidXFragmentCollector
{
  private static final String TAG = "AndroidXFragmentCollect";
  
  public static FragmentCompat fragmentToFragmentCompat(Fragment paramFragment)
  {
    FragmentCompat localFragmentCompat = new FragmentCompat();
    localFragmentCompat.setActivity(paramFragment.getActivity());
    localFragmentCompat.setView(paramFragment.getView());
    return localFragmentCompat;
  }
  
  public static void onAndroidXFragmentViewCreated(Fragment paramFragment, View paramView)
  {
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onFragmentViewCreated: fragment = " + paramFragment.getClass().getName() + ", view = " + UIUtils.getViewInfo(paramView));
    }
    ViewContainerBinder.getInstance().bind(paramView, paramFragment);
  }
  
  public static void onDestroyView(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onDestroyView: fragment = " + paramFragment.getClass().getName());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentDestroyView(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onHiddenChanged(Fragment paramFragment, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onHiddenChanged: fragment = " + paramFragment.getClass().getName() + ", hidden = " + paramBoolean);
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
    }
    if (paramBoolean)
    {
      EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramFragment));
      return;
    }
    EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onPause(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onPause: fragment = " + paramFragment.getClass().getName());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onResume(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onResume: fragment = " + paramFragment.getClass().getName());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "setUserVisibleHint: fragment = " + paramFragment.getClass().getName() + ", isVisible = " + paramBoolean);
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
    }
    if (paramBoolean)
    {
      EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramFragment));
      return;
    }
    EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector
 * JD-Core Version:    0.7.0.1
 */