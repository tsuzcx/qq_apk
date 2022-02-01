package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;

public class V4FragmentCollector
{
  private static final String TAG = "V4FragmentCollector";
  
  public static FragmentCompat fragmentToFragmentCompat(Fragment paramFragment)
  {
    FragmentCompat localFragmentCompat = new FragmentCompat();
    localFragmentCompat.setActivity(paramFragment.getActivity());
    localFragmentCompat.setView(paramFragment.getView());
    return localFragmentCompat;
  }
  
  public static void onDestroyView(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("V4FragmentCollector", "onDestroyView: fragment = " + paramFragment.getClass().getName());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentDestroyView(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onHiddenChanged(Fragment paramFragment, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("V4FragmentCollector", "onHiddenChanged: fragment = " + paramFragment.getClass().getName() + ", hidden = " + paramBoolean);
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
      Log.i("V4FragmentCollector", "onPause: fragment = " + paramFragment.getClass().getName());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onResume(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("V4FragmentCollector", "onResume: fragment = " + paramFragment.getClass().getName());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onV4FragmentViewCreated(Fragment paramFragment, View paramView)
  {
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("V4FragmentCollector", "onFragmentViewCreated: fragment = " + paramFragment.getClass().getName() + ", view = " + UIUtils.getViewInfo(paramView));
    }
    ViewContainerBinder.getInstance().bind(paramView, paramFragment);
  }
  
  public static void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("V4FragmentCollector", "setUserVisibleHint: fragment = " + paramFragment.getClass().getName() + ", isVisible = " + paramBoolean);
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
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector
 * JD-Core Version:    0.7.0.1
 */