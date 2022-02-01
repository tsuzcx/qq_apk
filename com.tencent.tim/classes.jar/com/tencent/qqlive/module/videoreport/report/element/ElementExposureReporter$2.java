package com.tencent.qqlive.module.videoreport.report.element;

import android.view.View;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;

class ElementExposureReporter$2
  implements PendingQueue.OnQueueListener
{
  ElementExposureReporter$2(ElementExposureReporter paramElementExposureReporter) {}
  
  public void onDequeue(ExposureElementInfo paramExposureElementInfo)
  {
    View localView = paramExposureElementInfo.getView();
    if (ElementExposureReporter.access$100(this.this$0, localView))
    {
      ElementExposureReporter.access$200(this.this$0).markExposed(paramExposureElementInfo);
      IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
      if ((localIEventDynamicParams != null) && (paramExposureElementInfo.getFinalData() != null)) {
        localIEventDynamicParams.setEventDynamicParams("imp", paramExposureElementInfo.getFinalData().getEventParams());
      }
      FinalDataTarget.handle(localView, paramExposureElementInfo.getFinalData());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter.2
 * JD-Core Version:    0.7.0.1
 */