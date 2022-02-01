package com.tencent.qqlive.module.videoreport.report;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Map;

public class PageReporter
  implements PageManager.IPageListener
{
  private long mPageInTime;
  
  private FinalData createPgInFinalData()
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("pgin");
    localFinalData.putAll(getCurPageReportInfo());
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("pgin", localFinalData.getEventParams());
    }
    return localFinalData;
  }
  
  private FinalData createPgOutFinalData()
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("pgout");
    localFinalData.put("lvtm", Long.valueOf(SystemClock.uptimeMillis() - this.mPageInTime));
    putPageClickFlag(localFinalData);
    localFinalData.putAll(getCurPageReportInfo());
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("pgout", localFinalData.getEventParams());
    }
    return localFinalData;
  }
  
  private Object getCurPage()
  {
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    if (localPageInfo == null) {
      return null;
    }
    return localPageInfo.getPage();
  }
  
  public static PageReporter getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private void init()
  {
    PageManager.getInstance().register(this);
  }
  
  private void initPageClickFlag(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    DataRWProxy.removeInnerParam(paramObject, "page_click_flag");
  }
  
  private void putPageClickFlag(FinalData paramFinalData)
  {
    if (paramFinalData == null) {}
    do
    {
      return;
      localObject = getCurPage();
    } while (localObject == null);
    if ("1".equals(DataRWProxy.getInnerParam(localObject, "page_click_flag"))) {}
    for (Object localObject = "1";; localObject = "0")
    {
      paramFinalData.put("clck_flag", localObject);
      return;
    }
  }
  
  @NonNull
  public Map<String, Object> getCurPageReportInfo()
  {
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    if (localPageInfo == null) {}
    for (Object localObject = null; localObject == null; localObject = localPageInfo.getPage()) {
      return new ArrayMap();
    }
    return PageUtils.getPageInfo(localPageInfo.getPage());
  }
  
  public void onPageIn(PageInfo paramPageInfo)
  {
    this.mPageInTime = SystemClock.uptimeMillis();
    initPageClickFlag(paramPageInfo.getPage());
    FinalDataTarget.handle(paramPageInfo.getPage(), createPgInFinalData());
  }
  
  public void onPageOut(PageInfo paramPageInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FinalDataTarget.handleInMainThread(paramPageInfo.getPage(), createPgOutFinalData());
      return;
    }
    FinalDataTarget.handle(paramPageInfo.getPage(), createPgOutFinalData());
  }
  
  public void onPageUpdate(PageInfo paramPageInfo) {}
  
  static class InstanceHolder
  {
    private static final PageReporter INSTANCE = new PageReporter(null);
    
    static
    {
      INSTANCE.init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.PageReporter
 * JD-Core Version:    0.7.0.1
 */