package com.tencent.qqlive.module.videoreport.report.element;

import android.graphics.Rect;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.exposure.DetectionData;
import com.tencent.qqlive.module.videoreport.exposure.ExposureDetector;
import com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.reportdata.PathDataUtils;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ElementExposureReporter
  implements PageManager.IPageListener, AppEventReporter.IAppEventListener
{
  private static final String TAG = "ElementExposureReporter";
  private final Map<Long, String> mExposedIds = new ArrayMap();
  private IExposureRecorder mExposureRecorder = IExposureRecorder.Factory.getInstance();
  private PageInfo mFrontPageInfo;
  private ListenerMgr<OnElementTraverseListener> mListenerMgr = new ListenerMgr();
  private PendingQueue mPendingQueue = new PendingQueue();
  private List<ExposureElementInfo> mPreExposedViewInfoList = new ArrayList();
  private final ListenerMgr.INotifyCallback<OnElementTraverseListener> mTraverseEndCallback = new ElementExposureReporter.1(this);
  
  private void clearPreExposedContent()
  {
    this.mPreExposedViewInfoList.clear();
    this.mExposedIds.clear();
  }
  
  private void detect(View paramView, Rect paramRect)
  {
    Rect localRect;
    if (this.mFrontPageInfo != null) {
      if (paramView == this.mFrontPageInfo.getPageView()) {
        localRect = null;
      }
    }
    for (;;)
    {
      ExposureDetector.detect(paramView, true, localRect, new ElementExposureCallBack(paramView, paramRect));
      return;
      localRect = paramRect;
      continue;
      localRect = paramRect;
    }
  }
  
  private void elementReport(PageInfo paramPageInfo)
  {
    SimpleTracer.begin("ElementExposureReporter.elementReport");
    View localView = paramPageInfo.getPageView();
    if (localView == null) {
      return;
    }
    Rect localRect2 = new Rect();
    Rect localRect1 = localRect2;
    if (!localView.getGlobalVisibleRect(localRect2)) {
      localRect1 = null;
    }
    this.mFrontPageInfo = paramPageInfo;
    run(localView.getRootView(), -VideoReportInner.getInstance().getConfiguration().getPageExposureMinTime(), localRect1);
    this.mListenerMgr.startNotify(this.mTraverseEndCallback);
    SimpleTracer.end("ElementExposureReporter.elementReport");
  }
  
  private boolean exposureNotReported(long paramLong)
  {
    return !this.mExposureRecorder.isExposed(paramLong);
  }
  
  private boolean exposureNotReported(View paramView)
  {
    return exposureNotReported(ReportUtils.calcElementUniqueId(paramView));
  }
  
  public static ElementExposureReporter getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private void init()
  {
    PageManager.getInstance().register(this);
    AppEventReporter.getInstance().register(this);
    this.mPendingQueue.setOnQueueListener(new ElementExposureReporter.2(this));
  }
  
  private boolean isViewNeedExposure(View paramView)
  {
    if (paramView == null) {}
    while ((!exposureNotReported(paramView)) || (!ReportHelper.isViewExposed(paramView))) {
      return false;
    }
    return true;
  }
  
  private void makeDirty(Set<Long> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.mExposureRecorder.getExposedRecords().keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if ((localLong != null) && (!paramSet.contains(localLong))) {
        localHashSet.add(localLong);
      }
    }
    this.mExposureRecorder.markUnexposed(localHashSet);
  }
  
  private void markUnexposed(PageInfo paramPageInfo)
  {
    if ((paramPageInfo == null) || (this.mExposureRecorder.getExposedRecords().size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mExposureRecorder.getExposedRecords().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localEntry != null)
      {
        localObject1 = localObject2;
        if (localEntry.getValue() != null) {
          localObject1 = ((IExposureRecorder.ExposureInfoWrapper)localEntry.getValue()).attachedPage.get();
        }
      }
      if ((localObject1 != null) && (localObject1.equals(paramPageInfo.getPage()))) {
        localArrayList.add(localEntry.getKey());
      }
    }
    this.mExposureRecorder.markUnexposed(localArrayList);
  }
  
  private void printDebug()
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      Object localObject1 = new HashMap(this.mExposedIds);
      Log.d("ElementExposureReporter", "run: new exposed view: count = " + this.mPreExposedViewInfoList.size());
      Object localObject2 = this.mPreExposedViewInfoList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ExposureElementInfo localExposureElementInfo = (ExposureElementInfo)((Iterator)localObject2).next();
        Log.d("ElementExposureReporter", "    identifier: " + localExposureElementInfo.getIdentifier() + ", uniqueId = " + localExposureElementInfo.getUniqueId());
        ((HashMap)localObject1).remove(Long.valueOf(localExposureElementInfo.getUniqueId()));
      }
      Log.d("ElementExposureReporter", "run: duplicate exposed view: count = " + ((HashMap)localObject1).size());
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Log.d("ElementExposureReporter", "    identifier: " + (String)((Map.Entry)localObject2).getValue() + ", uniqueId: " + ((Map.Entry)localObject2).getKey());
      }
      Log.d("ElementExposureReporter", "run: ---------------");
    }
  }
  
  private void run(View paramView, long paramLong, Rect paramRect)
  {
    clearPreExposedContent();
    detect(paramView, paramRect);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramView = new StringBuilder().append("run: delayDelta = ").append(paramLong).append(", ");
      if (this.mPreExposedViewInfoList != null) {
        break label108;
      }
    }
    label108:
    for (int i = 0;; i = this.mPreExposedViewInfoList.size())
    {
      Log.d("ElementExposureReporter", i + " exposed view found");
      printDebug();
      makeDirty(this.mExposedIds.keySet());
      this.mPendingQueue.enqueue(this.mPreExposedViewInfoList, paramLong);
      clearPreExposedContent();
      return;
    }
  }
  
  public void onAppIn() {}
  
  public void onAppOut(boolean paramBoolean)
  {
    this.mExposureRecorder.clearExposure();
  }
  
  public void onPageIn(PageInfo paramPageInfo)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ElementExposureReporter", "onPageIn: pageInfo = " + paramPageInfo);
    }
    elementReport(paramPageInfo);
  }
  
  public void onPageOut(PageInfo paramPageInfo, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ElementExposureReporter", "onPageOut: pageInfo = " + paramPageInfo);
    }
    markUnexposed(paramPageInfo);
  }
  
  public void onPageUpdate(PageInfo paramPageInfo)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ElementExposureReporter", "onPageUpdate: pageInfo = " + paramPageInfo);
    }
    elementReport(paramPageInfo);
  }
  
  public void registerTraverseListener(OnElementTraverseListener paramOnElementTraverseListener)
  {
    this.mListenerMgr.register(paramOnElementTraverseListener);
  }
  
  public void traverseExposure()
  {
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    if (localPageInfo != null) {
      elementReport(localPageInfo);
    }
  }
  
  class ElementExposureCallBack
    implements IExposureDetectCallback<ElementExposureReporter.ReportDetectionData>
  {
    private View mEntryView;
    private Rect mFrontPageArea;
    
    ElementExposureCallBack(View paramView, Rect paramRect)
    {
      this.mEntryView = paramView;
      this.mFrontPageArea = paramRect;
    }
    
    private PathData getPathData(ElementExposureReporter.ReportDetectionData paramReportDetectionData, View paramView, DataEntity paramDataEntity)
    {
      PathData localPathData = null;
      if (paramReportDetectionData.pathDatas.containsKey(paramView)) {
        return (PathData)paramReportDetectionData.pathDatas.get(paramView);
      }
      Object localObject = PageFinder.findRelatedPage(paramView);
      if (localObject != null)
      {
        localPathData = new PathData();
        localPathData.setPage(((PageInfo)localObject).getPage());
        if (PathDataUtils.canCollect(paramDataEntity)) {
          localPathData.addFirst(paramDataEntity);
        }
        paramReportDetectionData.pathDatas.put(paramView, localPathData);
        return localPathData;
      }
      localObject = ReportHelper.findPathParent(paramView, paramDataEntity);
      if (localObject == null)
      {
        paramReportDetectionData.pathDatas.put(paramView, null);
        return null;
      }
      localObject = getPathData(paramReportDetectionData, (View)localObject, DataBinder.getDataEntity(localObject));
      if (localObject != null)
      {
        localPathData = ((PathData)localObject).copy();
        localPathData.addFirst(paramDataEntity);
      }
      paramReportDetectionData.pathDatas.put(paramView, localPathData);
      return localPathData;
    }
    
    public ElementExposureReporter.ReportDetectionData createDetectionData()
    {
      return new ElementExposureReporter.ReportDetectionData();
    }
    
    public boolean onEnter(View paramView, ElementExposureReporter.ReportDetectionData paramReportDetectionData)
    {
      if ((PageFinder.findRelatedPage(paramView) != null) && (paramView != this.mEntryView))
      {
        ElementExposureReporter.this.detect(paramView, this.mFrontPageArea);
        return false;
      }
      paramView = (Boolean)DataRWProxy.getInnerParam(paramView, "element_detection_enable");
      if (paramView != null) {
        return paramView.booleanValue();
      }
      return true;
    }
    
    public void onExposed(View paramView, ElementExposureReporter.ReportDetectionData paramReportDetectionData, double paramDouble)
    {
      Object localObject2 = DataBinder.getDataEntity(paramView);
      if (!ReportHelper.reportExposure((DataEntity)localObject2)) {
        return;
      }
      Object localObject1 = DataRWProxy.getInnerParam(paramView, "element_identifier");
      if ((localObject1 instanceof String)) {}
      for (localObject1 = (String)localObject1;; localObject1 = null)
      {
        long l = ReportUtils.calcElementUniqueId(paramView);
        if (ElementExposureReporter.this.exposureNotReported(l))
        {
          localObject2 = getPathData(paramReportDetectionData, paramView, (DataEntity)localObject2);
          if (localObject2 != null)
          {
            paramReportDetectionData = new ExposureElementInfo();
            paramReportDetectionData.setView(paramView);
            paramReportDetectionData.setPage(((PathData)localObject2).getPage());
            paramReportDetectionData.setIdentifier((String)localObject1);
            paramReportDetectionData.setUniqueId(l);
            paramView = DataBuilderFactory.obtain().build((PathData)localObject2);
            if (paramView == null) {
              break;
            }
            paramView.setEventKey("imp");
            paramReportDetectionData.setFinalData(paramView);
            ElementExposureReporter.this.mPreExposedViewInfoList.add(paramReportDetectionData);
          }
        }
        ElementExposureReporter.this.mExposedIds.put(Long.valueOf(l), localObject1);
        return;
      }
    }
    
    public void onLeave(View paramView, ElementExposureReporter.ReportDetectionData paramReportDetectionData) {}
  }
  
  static class InstanceHolder
  {
    private static final ElementExposureReporter INSTANCE = new ElementExposureReporter(null);
    
    static
    {
      INSTANCE.init();
    }
  }
  
  static class ReportDetectionData
    extends DetectionData
  {
    final Map<View, PathData> pathDatas = new ArrayMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter
 * JD-Core Version:    0.7.0.1
 */