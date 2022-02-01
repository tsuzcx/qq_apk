package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;

class AppEventReporter$2
  implements Runnable
{
  AppEventReporter$2(AppEventReporter paramAppEventReporter) {}
  
  public void run()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "appInDataSender: 前台上报");
    }
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("appin");
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("appin", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(null, localFinalData);
    AppEventReporter.access$300(this.this$0).startNotify(new AppEventReporter.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.2
 * JD-Core Version:    0.7.0.1
 */