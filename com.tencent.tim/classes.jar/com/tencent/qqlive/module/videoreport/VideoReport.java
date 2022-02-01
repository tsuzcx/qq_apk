package com.tencent.qqlive.module.videoreport;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import java.util.List;
import java.util.Map;

public class VideoReport
{
  public static void addReporter(IReporter paramIReporter)
  {
    VideoReportInner.getInstance().addReporter(paramIReporter);
  }
  
  public static void addToDetectionBlacklist(Activity paramActivity)
  {
    VideoReportInner.getInstance().addToDetectionBlacklist(paramActivity);
  }
  
  public static void addToDetectionWhitelist(Activity paramActivity)
  {
    VideoReportInner.getInstance().addToDetectionWhitelist(paramActivity);
  }
  
  public static void clearElementExposure(View paramView, boolean paramBoolean)
  {
    VideoReportInner.getInstance().clearElementExposure(paramView, paramBoolean);
  }
  
  public static void clearPublicParams()
  {
    VideoReportInner.getInstance().clearPublicParams();
  }
  
  public static void doAppOutReport()
  {
    VideoReportInner.getInstance().doAppOutReport();
  }
  
  public static PageInfo findOwnerPage(View paramView)
  {
    return VideoReportInner.getInstance().findOwnerPage(paramView);
  }
  
  public static ReportPolicy getElementReportPolicy(Object paramObject)
  {
    return VideoReportInner.getInstance().getElementReportPolicy(paramObject);
  }
  
  public static void ignorePageInOutEvent(Object paramObject, boolean paramBoolean)
  {
    VideoReportInner.getInstance().ignorePageInOutEvent(paramObject, paramBoolean);
  }
  
  public static boolean isDebugMode()
  {
    return VideoReportInner.getInstance().isDebugMode();
  }
  
  public static void notifyViewDetach(View paramView1, View paramView2)
  {
    VideoReportInner.getInstance().notifyViewDetach(paramView1, paramView2);
  }
  
  @Nullable
  public static Map<String, Object> pageInfoForView(View paramView)
  {
    return VideoReportInner.getInstance().pageInfoForView(paramView);
  }
  
  @Nullable
  public static Map<String, Object> paramsForView(View paramView)
  {
    return VideoReportInner.getInstance().paramsForView(paramView);
  }
  
  public static void registerEventDynamicParams(IEventDynamicParams paramIEventDynamicParams)
  {
    VideoReportInner.getInstance().registerEventDynamicParams(paramIEventDynamicParams);
  }
  
  public static void registerSessionChangeListener(ISessionChangeListener paramISessionChangeListener)
  {
    VideoReportInner.getInstance().registerSessionChangeListener(paramISessionChangeListener);
  }
  
  @Deprecated
  public static void removeAllElementParams(Object paramObject)
  {
    VideoReportInner.getInstance().removeAllElementParams(paramObject);
  }
  
  @Deprecated
  public static void removeAllPageParams(Object paramObject)
  {
    VideoReportInner.getInstance().removeAllPageParams(paramObject);
  }
  
  public static void removeElementParam(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().removeElementParam(paramObject, paramString);
  }
  
  public static void removePageParam(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().removePageParam(paramObject, paramString);
  }
  
  public static void removePublicParam(String paramString)
  {
    VideoReportInner.getInstance().removePublicParam(paramString);
  }
  
  public static void reportEvent(String paramString, Object paramObject, Map<String, ?> paramMap)
  {
    VideoReportInner.getInstance().reportEvent(paramString, paramObject, paramMap);
  }
  
  public static void reportEvent(String paramString, Map<String, ?> paramMap)
  {
    VideoReportInner.getInstance().reportEvent(paramString, paramMap);
  }
  
  public static void resetElementParams(Object paramObject)
  {
    VideoReportInner.getInstance().resetElementParams(paramObject);
  }
  
  public static void resetPageParams(Object paramObject)
  {
    VideoReportInner.getInstance().resetPageParams(paramObject);
  }
  
  public static void resetPageStats()
  {
    VideoReportInner.getInstance().resetPageStats();
  }
  
  public static void setClickReportInterval(View paramView, long paramLong)
  {
    VideoReportInner.getInstance().setClickReportInterval(paramView, paramLong);
  }
  
  public static void setDataCollectEnable(boolean paramBoolean)
  {
    VideoReportInner.getInstance().setDataCollectEnable(paramBoolean);
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    VideoReportInner.getInstance().setDebugMode(paramBoolean);
  }
  
  public static void setDetectionMode(@DetectionMode int paramInt)
  {
    VideoReportInner.getInstance().setDetectionMode(paramInt);
  }
  
  public static void setElementExposureDetectionEnabled(View paramView, boolean paramBoolean)
  {
    VideoReportInner.getInstance().setElementExposureDetectionEnabled(paramView, paramBoolean);
  }
  
  public static void setElementExposureMinRate(Object paramObject, double paramDouble)
  {
    VideoReportInner.getInstance().setElementExposureMinRate(paramObject, paramDouble);
  }
  
  public static void setElementExposureMinTime(Object paramObject, long paramLong)
  {
    VideoReportInner.getInstance().setElementExposureMinTime(paramObject, paramLong);
  }
  
  public static void setElementId(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().setElementId(paramObject, paramString);
  }
  
  public static void setElementParam(Object paramObject1, String paramString, Object paramObject2)
  {
    VideoReportInner.getInstance().setElementParam(paramObject1, paramString, paramObject2);
  }
  
  public static void setElementParams(Object paramObject, Map<String, ?> paramMap)
  {
    VideoReportInner.getInstance().setElementParams(paramObject, paramMap);
  }
  
  public static void setElementReportPolicy(Object paramObject, ReportPolicy paramReportPolicy)
  {
    VideoReportInner.getInstance().setElementReportPolicy(paramObject, paramReportPolicy);
  }
  
  public static void setElementReuseIdentifier(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().setElementReuseIdentifier(paramObject, paramString);
  }
  
  public static void setEventAdditionalReport(IAdditionalReportListener paramIAdditionalReportListener)
  {
    VideoReportInner.getInstance().setEventAdditionalReport(paramIAdditionalReportListener);
  }
  
  public static void setLogicParent(View paramView1, View paramView2)
  {
    VideoReportInner.getInstance().setLogicParent(paramView1, paramView2);
  }
  
  public static void setPageContentId(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().setPageContentId(paramObject, paramString);
  }
  
  public static void setPageId(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().setPageId(paramObject, paramString);
  }
  
  public static void setPageParams(Object paramObject, PageParams paramPageParams)
  {
    VideoReportInner.getInstance().setPageParams(paramObject, paramPageParams);
  }
  
  public static void setPageParams(Object paramObject1, String paramString, Object paramObject2)
  {
    VideoReportInner.getInstance().setPageParams(paramObject1, paramString, paramObject2);
  }
  
  public static void setPublicParam(String paramString, Object paramObject)
  {
    VideoReportInner.getInstance().setPublicParam(paramString, paramObject);
  }
  
  public static void startNewSession(SessionChangeReason paramSessionChangeReason)
  {
    VideoReportInner.getInstance().startNewSession(paramSessionChangeReason);
  }
  
  public static void startWithComponent(Application paramApplication, IVideoReportComponent paramIVideoReportComponent)
  {
    VideoReportInner.getInstance().startWithComponent(paramApplication, paramIVideoReportComponent);
  }
  
  public static void startWithConfiguration(Application paramApplication, Configuration paramConfiguration)
  {
    VideoReportInner.getInstance().startWithConfiguration(paramApplication, paramConfiguration);
  }
  
  public static void traverseExposure()
  {
    VideoReportInner.getInstance().traverseExposure();
  }
  
  public static void traversePage(View paramView)
  {
    VideoReportInner.getInstance().traversePage(paramView);
  }
  
  public static void triggerClickInCurrentPage(Map<String, Object> paramMap)
  {
    VideoReportInner.getInstance().triggerClickInCurrentPage(paramMap);
  }
  
  public static void triggerEventInCurrentPage(String paramString, Map<String, Object> paramMap)
  {
    VideoReportInner.getInstance().triggerEventInCurrentPage(paramString, paramMap);
  }
  
  public static void triggerExposureInCurrentPage(List<Map<String, Object>> paramList)
  {
    VideoReportInner.getInstance().triggerExposureInCurrentPage(paramList);
  }
  
  @Nullable
  public static Map<String, Object> viewTreeParamsForView(View paramView)
  {
    return VideoReportInner.getInstance().viewTreeParamsForView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.VideoReport
 * JD-Core Version:    0.7.0.1
 */