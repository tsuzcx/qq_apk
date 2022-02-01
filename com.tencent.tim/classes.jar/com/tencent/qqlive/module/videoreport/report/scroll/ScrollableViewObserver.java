package com.tencent.qqlive.module.videoreport.report.scroll;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageSwitchObserver;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class ScrollableViewObserver
  extends DefaultEventListener
{
  private static final String TAG = "ScrollableViewObserver";
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private PendingTask mPendingTask = new PendingTask(null);
  private ScrollableHelper mScrollableHelper = new ScrollableHelper(null);
  
  private ScrollableViewObserver()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  public static ScrollableViewObserver getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private void handleNotify(ViewGroup paramViewGroup)
  {
    if (!isIdle()) {
      return;
    }
    this.mHandler.removeCallbacks(this.mPendingTask);
    this.mPendingTask.setNotifyView(paramViewGroup);
    this.mHandler.post(this.mPendingTask);
  }
  
  private boolean isIdle()
  {
    return !this.mScrollableHelper.isScrolling();
  }
  
  public void onViewReused(ViewGroup paramViewGroup, View paramView, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("ScrollableViewObserver", "onViewReused: parent=" + paramViewGroup + ", view=" + paramView);
    }
    if (paramViewGroup == null)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        throw new UnsupportedClassVersionError("RecyclerView.ViewHolder 23 版本以下获取不到所对应RecyclerView对象，请升级RecyclerView版本");
      }
    }
    else {
      handleNotify(paramViewGroup);
    }
  }
  
  static class InstanceHolder
  {
    private static final ScrollableViewObserver INSTANCE = new ScrollableViewObserver(null);
  }
  
  static class PendingTask
    implements Runnable
  {
    private Set<View> mNotifyViewList = Collections.newSetFromMap(new WeakHashMap());
    
    private void setNotifyView(View paramView)
    {
      this.mNotifyViewList.add(paramView);
    }
    
    public void run()
    {
      if (this.mNotifyViewList.isEmpty()) {
        return;
      }
      Iterator localIterator = this.mNotifyViewList.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        PageSwitchObserver.getInstance().onPageViewVisible(localView);
      }
      this.mNotifyViewList.clear();
    }
  }
  
  static class ScrollableHelper
    extends ScrollStateObserver
  {
    protected void onIdle(View paramView)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("ScrollableViewObserver", "onIdle: source=" + paramView);
      }
      PageSwitchObserver.getInstance().onPageViewVisible(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewObserver
 * JD-Core Version:    0.7.0.1
 */