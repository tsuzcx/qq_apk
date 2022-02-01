package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.QAPMTraceUnit;
import com.tencent.qapmsdk.impl.instrumentation.TraceType.ContextType;

public class MonitorAdapter
{
  public QAPMMonitorThreadLocal qapmMonitorThreadLocal;
  public SectionHarve sectionHarve;
  public TraceType.ContextType traceType;
  
  protected MonitorAdapter(QAPMTraceUnit paramQAPMTraceUnit, long paramLong, TraceType.ContextType paramContextType)
  {
    this.sectionHarve = initSectionHarve(paramQAPMTraceUnit, paramLong, paramContextType);
    this.traceType = paramContextType;
    this.qapmMonitorThreadLocal = QAPMMonitorThreadLocal.getInstance();
  }
  
  public static SectionHarve initSectionHarve(QAPMTraceUnit paramQAPMTraceUnit, long paramLong, TraceType.ContextType paramContextType)
  {
    return new SectionHarve(paramQAPMTraceUnit, paramLong, paramContextType);
  }
  
  public static MonitorAdapter newOne(String paramString, long paramLong, TraceType.ContextType paramContextType)
  {
    return newOne(paramString, "", paramLong, paramContextType);
  }
  
  public static MonitorAdapter newOne(String paramString1, String paramString2, long paramLong, TraceType.ContextType paramContextType)
  {
    QAPMTraceUnit localQAPMTraceUnit = new QAPMTraceUnit();
    localQAPMTraceUnit.metricName = paramString1;
    localQAPMTraceUnit.subMetricName = paramString2;
    paramString1 = new MonitorAdapter(localQAPMTraceUnit, paramLong, paramContextType);
    paramString1.getQapmMonitorThreadLocal().push(localQAPMTraceUnit, Boolean.valueOf(true));
    return paramString1;
  }
  
  public void addMonitorUnit(QAPMTraceUnit paramQAPMTraceUnit)
  {
    this.qapmMonitorThreadLocal.push(paramQAPMTraceUnit, Boolean.valueOf(true));
  }
  
  public void deleteMonitorUnit(boolean paramBoolean)
  {
    try
    {
      if (this.qapmMonitorThreadLocal.threadQapmUnit() == null) {
        return;
      }
      this.qapmMonitorThreadLocal.pop(paramBoolean);
      return;
    }
    catch (Exception localException) {}
  }
  
  public SectionHarve finishMonitor()
  {
    if (this.sectionHarve == null) {
      return null;
    }
    return this.sectionHarve.exitTrace();
  }
  
  public QAPMMonitorThreadLocal getQapmMonitorThreadLocal()
  {
    return this.qapmMonitorThreadLocal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.MonitorAdapter
 * JD-Core Version:    0.7.0.1
 */