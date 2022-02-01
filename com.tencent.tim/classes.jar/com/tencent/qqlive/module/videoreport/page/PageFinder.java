package com.tencent.qqlive.module.videoreport.page;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.exposure.DetectionData;
import com.tencent.qqlive.module.videoreport.exposure.ExposureDetector;
import com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PageFinder
{
  private static final String TAG = "PageFinder";
  
  static PageInfo findExposurePage(View paramView)
  {
    SimpleTracer.begin("PagePageFinder.findExposurePage");
    if ((paramView == null) || (paramView.getRootView() == null)) {
      return null;
    }
    PageExposureCallback localPageExposureCallback = new PageExposureCallback(getPageViewAndParents(paramView.getRootView().getContext()), null);
    ExposureDetector.detect(paramView, false, null, localPageExposureCallback);
    SimpleTracer.end("PagePageFinder.findExposurePage");
    return localPageExposureCallback.targetPageInfo;
  }
  
  public static PageInfo findOwnerPage(View paramView)
  {
    while ((paramView instanceof View))
    {
      paramView = (View)paramView;
      PageInfo localPageInfo = findRelatedPage(paramView);
      if (localPageInfo != null) {
        return localPageInfo;
      }
      paramView = paramView.getParent();
    }
    return null;
  }
  
  public static PageInfo findRelatedPage(View paramView)
  {
    if (isPage(paramView)) {
      return new PageInfo(paramView, paramView);
    }
    Object localObject = ViewContainerBinder.getInstance().getBoundContainer(paramView);
    if (isPage(localObject)) {
      return new PageInfo(localObject, paramView);
    }
    return null;
  }
  
  private static Set<View> getPageViewAndParents(@NonNull Context paramContext)
  {
    paramContext = VideoReportInner.getInstance().getPageCache(paramContext);
    if (BaseUtils.isEmpty(paramContext)) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramContext.iterator();
    while (localIterator.hasNext())
    {
      paramContext = (View)localIterator.next();
      if (paramContext != null)
      {
        localHashSet.add(paramContext);
        for (paramContext = paramContext.getParent(); (paramContext instanceof View); paramContext = paramContext.getParent()) {
          localHashSet.add((View)paramContext);
        }
      }
    }
    return localHashSet;
  }
  
  public static boolean isIgnorePageInOutEvent(PageInfo paramPageInfo)
  {
    paramPageInfo = DataBinder.getDataEntity(paramPageInfo.getPage());
    if (paramPageInfo != null)
    {
      paramPageInfo = (Boolean)DataEntityOperator.getInnerParam(paramPageInfo, "page_report_ignore");
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageFinder", "isIgnorePageInOutEvent: ignoreReport=" + paramPageInfo);
      }
      return (paramPageInfo != null) && (paramPageInfo.booleanValue());
    }
    return false;
  }
  
  public static boolean isPage(Object paramObject)
  {
    if (paramObject == null) {}
    while (TextUtils.isEmpty(DataEntityOperator.getPageId(DataBinder.getDataEntity(paramObject)))) {
      return false;
    }
    return true;
  }
  
  static class PageExposureCallback
    implements IExposureDetectCallback<DetectionData>
  {
    Set<View> pageAndParentViewSet;
    PageInfo targetPageInfo;
    
    private PageExposureCallback(Set<View> paramSet)
    {
      this.pageAndParentViewSet = paramSet;
    }
    
    public final DetectionData createDetectionData()
    {
      return new DetectionData();
    }
    
    public boolean onEnter(View paramView, DetectionData paramDetectionData)
    {
      return (this.targetPageInfo == null) && (BaseUtils.contains(this.pageAndParentViewSet, paramView));
    }
    
    public void onExposed(View paramView, DetectionData paramDetectionData, double paramDouble)
    {
      double d = VideoReportInner.getInstance().getConfiguration().getPageExposureMinRate();
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageFinder", "onExposed: view = " + paramView + ", exposureRate = " + paramDouble + ", exposureMinRate = " + d);
      }
      if ((this.targetPageInfo != null) || (paramDouble < Math.max(d, 0.0D))) {}
      do
      {
        return;
        paramView = PageFinder.findRelatedPage(paramView);
      } while ((paramView == null) || (PageFinder.isIgnorePageInOutEvent(paramView)));
      this.targetPageInfo = paramView;
    }
    
    public void onLeave(View paramView, DetectionData paramDetectionData) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageFinder
 * JD-Core Version:    0.7.0.1
 */