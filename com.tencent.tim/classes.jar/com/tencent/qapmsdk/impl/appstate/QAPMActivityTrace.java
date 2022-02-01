package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.util.TraceUtil;

public class QAPMActivityTrace
  extends CommonActivityTrace
{
  private String activityName;
  
  public void onResumeEnterMethod(String paramString)
  {
    super.onResumeEnterMethod(paramString);
    this.activityName = paramString;
  }
  
  public SectionHarve onResumeExitMethod()
  {
    Object localObject;
    if (!TraceUtil.canInstrumentMonitor) {
      localObject = null;
    }
    SectionHarve localSectionHarve;
    do
    {
      return localObject;
      localSectionHarve = super.onResumeExitMethod();
      localObject = localSectionHarve;
    } while (localSectionHarve == null);
    localSectionHarve.readyToReport(this.eventListener.getQapmMonitorThreadLocal());
    return localSectionHarve;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.QAPMActivityTrace
 * JD-Core Version:    0.7.0.1
 */