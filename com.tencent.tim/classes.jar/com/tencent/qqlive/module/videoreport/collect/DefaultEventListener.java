package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;

public class DefaultEventListener
  implements IEventListener
{
  public void onActivityCreate(Activity paramActivity) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPause(Activity paramActivity) {}
  
  public void onActivityResume(Activity paramActivity) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onDialogClick(DialogInterface paramDialogInterface, int paramInt) {}
  
  public void onDialogHide(Activity paramActivity, Dialog paramDialog) {}
  
  public void onDialogShow(Activity paramActivity, Dialog paramDialog) {}
  
  public void onFragmentDestroyView(FragmentCompat paramFragmentCompat) {}
  
  public void onFragmentPause(FragmentCompat paramFragmentCompat) {}
  
  public void onFragmentResume(FragmentCompat paramFragmentCompat) {}
  
  public void onListScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onRecyclerViewScrollPosition(RecyclerView paramRecyclerView) {}
  
  public void onSetRecyclerViewAdapter(RecyclerView paramRecyclerView) {}
  
  public void onSetViewPagerAdapter(ViewPager paramViewPager) {}
  
  public void onViewClick(View paramView) {}
  
  public void onViewReused(ViewGroup paramViewGroup, View paramView, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.DefaultEventListener
 * JD-Core Version:    0.7.0.1
 */