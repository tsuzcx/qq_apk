package com.tencent.qqlive.module.videoreport.report.scroll;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.traversal.OnViewTraverseListener;
import com.tencent.qqlive.module.videoreport.traversal.ViewTraverser;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

abstract class ScrollStateObserver
  extends RecyclerView.OnScrollListener
  implements AbsListView.OnScrollListener, OnViewTraverseListener
{
  private static final String TAG = "ScrollStateObserver";
  private final IEventListener mEventListener = new ScrollEventListener(null);
  private final Set<View> mScrollingViews = Collections.newSetFromMap(new WeakHashMap());
  private final WeakHashMap<ViewPager, ViewPager.OnPageChangeListener> mViewPagerListeners = new WeakHashMap();
  
  ScrollStateObserver()
  {
    EventCollector.getInstance().registerEventListener(this.mEventListener);
    ViewTraverser.getInstance().setListener(this);
  }
  
  private void updateScrollingView(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mScrollingViews.add(paramView);
      return;
    }
    this.mScrollingViews.remove(paramView);
  }
  
  public void inject(ViewPager paramViewPager)
  {
    if ((ViewPager.OnPageChangeListener)this.mViewPagerListeners.get(paramViewPager) == null)
    {
      PageChangeListenerImpl localPageChangeListenerImpl = new PageChangeListenerImpl(paramViewPager);
      this.mViewPagerListeners.put(paramViewPager, localPageChangeListenerImpl);
      paramViewPager.addOnPageChangeListener(localPageChangeListenerImpl);
    }
  }
  
  public void inject(RecyclerView paramRecyclerView)
  {
    paramRecyclerView.removeOnScrollListener(this);
    paramRecyclerView.addOnScrollListener(this);
  }
  
  public void inject(AbsListView paramAbsListView)
  {
    if (UIUtils.getListScrollListener(paramAbsListView) == null) {
      paramAbsListView.setOnScrollListener(this);
    }
  }
  
  boolean isScrolling()
  {
    return this.mScrollingViews.size() > 0;
  }
  
  protected abstract void onIdle(View paramView);
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ScrollStateObserver", "RecyclerView.onScrollStateChanged: newState = " + paramInt);
    }
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      updateScrollingView(paramRecyclerView, bool);
      if (paramInt == 0) {
        onIdle(paramRecyclerView);
      }
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ScrollStateObserver", "AbsListView.onScrollStateChanged: scrollState = " + paramInt);
    }
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      updateScrollingView(paramAbsListView, bool);
      if (paramInt == 0) {
        onIdle(paramAbsListView);
      }
      return;
    }
  }
  
  public void onViewVisited(View paramView)
  {
    if ((paramView instanceof AbsListView)) {
      inject((AbsListView)paramView);
    }
    do
    {
      return;
      if ((paramView instanceof RecyclerView))
      {
        inject((RecyclerView)paramView);
        return;
      }
    } while (!(paramView instanceof ViewPager));
    inject((ViewPager)paramView);
  }
  
  class PageChangeListenerImpl
    implements ViewPager.OnPageChangeListener
  {
    private WeakReference<ViewPager> mViewPagerRef;
    
    PageChangeListenerImpl(ViewPager paramViewPager)
    {
      this.mViewPagerRef = new WeakReference(paramViewPager);
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("ScrollStateObserver", "ViewPager.onPageScrollStateChanged: state = " + paramInt);
      }
      ViewPager localViewPager = (ViewPager)this.mViewPagerRef.get();
      if (localViewPager == null) {
        return;
      }
      ScrollStateObserver localScrollStateObserver = ScrollStateObserver.this;
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localScrollStateObserver.updateScrollingView(localViewPager, bool);
        if (paramInt != 0) {
          break;
        }
        ScrollStateObserver.this.onIdle(localViewPager);
        return;
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt) {}
  }
  
  class ScrollEventListener
    extends DefaultEventListener
  {
    private ScrollEventListener() {}
    
    public void onListScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("ScrollStateObserver", "onListScrollStateChanged: scrollState=" + paramInt);
      }
      ScrollStateObserver.this.onScrollStateChanged(paramAbsListView, paramInt);
    }
    
    public void onSetRecyclerViewAdapter(RecyclerView paramRecyclerView)
    {
      ScrollStateObserver.this.inject(paramRecyclerView);
    }
    
    public void onSetViewPagerAdapter(ViewPager paramViewPager)
    {
      ScrollStateObserver.this.inject(paramViewPager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollStateObserver
 * JD-Core Version:    0.7.0.1
 */