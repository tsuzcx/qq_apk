package com.tencent.qapmsdk.impl.instrumentation;

import android.os.Looper;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.harvest.HarvestAdapter;
import com.tencent.qapmsdk.impl.harvest.MetricCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QAPMTraceEngine
  extends HarvestAdapter
{
  private static final String TAG = "QAPM_Impl_QAPMTraceEngine";
  private static List<MetricEventListener> metricEventListeners = new CopyOnWriteArrayList();
  
  public static void enterMethod(QAPMTraceUnit paramQAPMTraceUnit, String paramString, ArrayList<String> paramArrayList)
  {
    try
    {
      if (!shouldInvokeMethod(paramString)) {
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        notifyObserverEnterMethod(new QAPMTraceUnit(paramString, getSegmentType(paramArrayList).getValue()));
        return;
      }
    }
    catch (Throwable paramQAPMTraceUnit)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTraceEngine", "error happend in enterMethod:", paramQAPMTraceUnit);
      return;
    }
    notifyObserverAsyncEnterMethod(new QAPMTraceUnit(paramString, getSegmentType(paramArrayList).getValue()));
  }
  
  public static void enterMethod(String paramString, ArrayList<String> paramArrayList)
  {
    try
    {
      enterMethod(null, paramString, paramArrayList);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTraceEngine", "QAPMTraceEngine  enterMethod has an error :", paramString);
    }
  }
  
  public static void exitCustomApiMethod(String paramString)
  {
    try
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTraceEngine", "exitCustomApiMethod" });
      notifyObserverExitMethodCustom(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTraceEngine", "QAPMTraceEngine  exitCustomApiMethod has an error :", paramString);
    }
  }
  
  public static void exitMethod()
  {
    try
    {
      notifyObserverExitMethod();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTraceEngine", "QAPMTraceEngine  exitMethod has an error :", localThrowable);
    }
  }
  
  public static List<MetricEventListener> getMetricEventListeners()
  {
    return metricEventListeners;
  }
  
  public static TraceType.CategoryType getSegmentType(List<String> paramList)
  {
    TraceType.CategoryType localCategoryType = TraceType.CategoryType.OTHER;
    Object localObject = localCategoryType;
    if (paramList != null)
    {
      localObject = localCategoryType;
      if (paramList.size() == 3)
      {
        String str = (String)paramList.get(2);
        paramList = localCategoryType;
        if (str.equalsIgnoreCase(MetricCategory.IMAGE.getCategoryName())) {
          paramList = TraceType.CategoryType.IMAGE;
        }
        if (str.equalsIgnoreCase(MetricCategory.JSON.getCategoryName())) {
          paramList = TraceType.CategoryType.JSON;
        }
        if (str.equalsIgnoreCase(MetricCategory.NETWORK.getCategoryName())) {
          paramList = TraceType.CategoryType.NETWORK;
        }
        if (str.equalsIgnoreCase("DATABASE")) {
          paramList = TraceType.CategoryType.DATABASE;
        }
        localObject = paramList;
        if (str.equalsIgnoreCase(MetricCategory.CUSTOMEVENT.getCategoryName())) {
          localObject = TraceType.CategoryType.CUSTOMEVENT;
        }
      }
    }
    return localObject;
  }
  
  public static void notifyObserverAsyncEnterMethod(QAPMTraceUnit paramQAPMTraceUnit)
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((MetricEventListener)localIterator.next()).asyncEnterMethod(paramQAPMTraceUnit);
    }
  }
  
  public static void notifyObserverEnterMethod(QAPMTraceUnit paramQAPMTraceUnit)
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((MetricEventListener)localIterator.next()).enterMethod(paramQAPMTraceUnit);
    }
  }
  
  public static void notifyObserverExitMethod()
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((MetricEventListener)localIterator.next()).exitMethod();
    }
  }
  
  public static void notifyObserverExitMethodCustom(String paramString)
  {
    Iterator localIterator = metricEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((MetricEventListener)localIterator.next()).exitMethodCustom(paramString);
    }
  }
  
  public static void registerListener(MetricEventListener paramMetricEventListener)
  {
    if (paramMetricEventListener == null) {}
    while (metricEventListeners.contains(paramMetricEventListener)) {
      return;
    }
    metricEventListeners.add(paramMetricEventListener);
  }
  
  public static void removeListener(MetricEventListener paramMetricEventListener)
  {
    if (paramMetricEventListener == null) {
      return;
    }
    metricEventListeners.remove(paramMetricEventListener);
  }
  
  private static boolean shouldInvokeMethod(String paramString)
  {
    return (paramString != null) && (!paramString.endsWith("#onCreate"));
  }
  
  public static void startTracing(String paramString)
  {
    QAPMAppInstrumentation.activityCreateBeginIns(paramString);
  }
  
  public static void startTracingInFragment(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMTraceEngine
 * JD-Core Version:    0.7.0.1
 */