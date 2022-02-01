package com.tencent.qqlive.module.videoreport.trace;

import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Tracer
{
  private static final String TAG = "VRTracer";
  private static Map<String, TraceData> sDataMap = new ArrayMap();
  
  public static void begin(String paramString)
  {
    long l = System.nanoTime();
    fetchData(paramString).lastBeginNano = l;
  }
  
  public static void clear()
  {
    sDataMap.clear();
  }
  
  public static long end(String paramString)
  {
    long l = System.nanoTime();
    paramString = fetchData(paramString);
    if (paramString.lastBeginNano == -1L) {
      return -1L;
    }
    paramString.count += 1;
    l -= paramString.lastBeginNano;
    paramString.totalNano += l;
    paramString.lastBeginNano = -1L;
    return l;
  }
  
  private static TraceData fetchData(String paramString)
  {
    TraceData localTraceData2 = (TraceData)sDataMap.get(paramString);
    TraceData localTraceData1 = localTraceData2;
    if (localTraceData2 == null)
    {
      localTraceData1 = new TraceData(null);
      sDataMap.put(paramString, localTraceData1);
    }
    return localTraceData1;
  }
  
  public static void trace()
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      Log.d("VRTracer", "begin trace output:");
      Iterator localIterator = sDataMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        TraceData localTraceData = (TraceData)localEntry.getValue();
        if (localTraceData.count != 0) {
          Log.d("VRTracer", "    " + (String)localEntry.getKey() + ": average = " + localTraceData.totalNano / localTraceData.count / 1000L + " us, total = " + localTraceData.totalNano / 1000L + " us, count = " + localTraceData.count);
        } else {
          Log.d("VRTracer", "    no data found");
        }
      }
    }
  }
  
  static class TraceData
  {
    int count = 0;
    long lastBeginNano = -1L;
    long totalNano = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.trace.Tracer
 * JD-Core Version:    0.7.0.1
 */