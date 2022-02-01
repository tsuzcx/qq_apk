package com.tencent.ttpic.baseutils.fps;

import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BenchUtil
{
  private static final int COUNT = 10;
  public static boolean ENABLE_DEBUG = false;
  public static boolean ENABLE_LOG = false;
  public static boolean ENABLE_MEMINFO = false;
  public static boolean ENABLE_PERFORMANCE_RECORD = false;
  private static final String PREFIX = "[time]";
  public static String SHOWPREVIEW_BENCH_TAG;
  private static final String TAG = BenchUtil.class.getSimpleName();
  private static Map<String, Float> lastTimeMap;
  private static LoggerAgent sLogger;
  private static Map<String, Long> startTimeMap = new HashMap();
  private static Map<String, CopyOnWriteArrayList<Long>> totalTimeMap = new HashMap();
  
  static
  {
    lastTimeMap = new HashMap();
    sLogger = new LoggerAgent();
    ENABLE_DEBUG = true;
    ENABLE_LOG = false;
    ENABLE_PERFORMANCE_RECORD = false;
    SHOWPREVIEW_BENCH_TAG = "[showPreview]";
  }
  
  public static long benchEnd(String paramString)
  {
    if ((!ENABLE_LOG) || (TextUtils.isEmpty(paramString)) || (startTimeMap == null)) {
      return 0L;
    }
    Long localLong = (Long)startTimeMap.get(paramString);
    if (localLong == null) {
      return 0L;
    }
    if ((ENABLE_PERFORMANCE_RECORD) && (paramString.startsWith(SHOWPREVIEW_BENCH_TAG))) {
      GLES20.glFinish();
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList2 = (CopyOnWriteArrayList)totalTimeMap.get(paramString);
    CopyOnWriteArrayList localCopyOnWriteArrayList1 = localCopyOnWriteArrayList2;
    if (localCopyOnWriteArrayList2 == null)
    {
      localCopyOnWriteArrayList1 = new CopyOnWriteArrayList();
      totalTimeMap.put(paramString, localCopyOnWriteArrayList1);
    }
    long l = System.currentTimeMillis() - localLong.longValue();
    localCopyOnWriteArrayList1.add(Long.valueOf(l));
    int i = localCopyOnWriteArrayList1.size();
    if (i >= 10)
    {
      float f = (float)getTotalTime(localCopyOnWriteArrayList1) / i;
      Log.e(TAG, "[time]" + paramString + ": " + f + " ms");
      lastTimeMap.put(paramString, Float.valueOf(f));
      localCopyOnWriteArrayList1.clear();
    }
    return l;
  }
  
  public static void benchEnd(String paramString, int paramInt)
  {
    if (!ENABLE_LOG) {
      break label6;
    }
    label6:
    while ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)totalTimeMap.get(paramString);
    if (localCopyOnWriteArrayList == null)
    {
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      totalTimeMap.put(paramString, localCopyOnWriteArrayList);
    }
    for (;;)
    {
      localCopyOnWriteArrayList.add(Long.valueOf(System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue()));
      if (localCopyOnWriteArrayList.size() < 10) {
        break;
      }
      sLogger.d(TAG, "[time]" + paramString + ": " + getTotalTime(localCopyOnWriteArrayList) / (localCopyOnWriteArrayList.size() / paramInt) + "ms");
      localCopyOnWriteArrayList.clear();
      return;
    }
  }
  
  public static long benchEndFPS(String paramString)
  {
    if ((!ENABLE_DEBUG) || (TextUtils.isEmpty(paramString)) || (startTimeMap == null)) {
      return 0L;
    }
    Long localLong = (Long)startTimeMap.get(paramString);
    if (localLong == null) {
      return 0L;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList2 = (CopyOnWriteArrayList)totalTimeMap.get(paramString);
    CopyOnWriteArrayList localCopyOnWriteArrayList1 = localCopyOnWriteArrayList2;
    if (localCopyOnWriteArrayList2 == null)
    {
      localCopyOnWriteArrayList1 = new CopyOnWriteArrayList();
      totalTimeMap.put(paramString, localCopyOnWriteArrayList1);
    }
    long l1 = System.currentTimeMillis() - localLong.longValue();
    localCopyOnWriteArrayList1.add(Long.valueOf(l1));
    long l2 = getTotalTimeFPS(localCopyOnWriteArrayList1);
    int i = localCopyOnWriteArrayList1.size();
    if (i >= 10)
    {
      float f = (float)(l2 / i);
      LogUtils.d(TAG, "[time]" + paramString + ": " + f + "ms");
      lastTimeMap.put(paramString, Float.valueOf(f));
      localCopyOnWriteArrayList1.clear();
    }
    return l1;
  }
  
  public static long benchEndTotal(String paramString)
  {
    if (!ENABLE_LOG) {}
    while ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {
      return 0L;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)totalTimeMap.get(paramString);
    if (localCopyOnWriteArrayList == null)
    {
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      totalTimeMap.put(paramString, localCopyOnWriteArrayList);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue();
      localCopyOnWriteArrayList.add(Long.valueOf(l));
      return l;
    }
  }
  
  public static void benchStart(String paramString)
  {
    if (!ENABLE_LOG) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((ENABLE_PERFORMANCE_RECORD) && (paramString.startsWith(SHOWPREVIEW_BENCH_TAG))) {
      GLES20.glFinish();
    }
    startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void benchStartFPS(String paramString)
  {
    if (!ENABLE_DEBUG) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void calcFps()
  {
    benchEndFPS("bench_fps");
    benchStartFPS("bench_fps");
  }
  
  public static float elapsed(String paramString)
  {
    if (!lastTimeMap.containsKey(paramString)) {
      return 0.0F;
    }
    return ((Float)lastTimeMap.get(paramString)).floatValue();
  }
  
  public static void flush()
  {
    Iterator localIterator = totalTimeMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      sLogger.d(TAG, "[time]" + (String)localEntry.getKey() + ": " + getTotalTime((CopyOnWriteArrayList)localEntry.getValue()) + "ms");
    }
    totalTimeMap.clear();
  }
  
  public static String getBenchFps()
  {
    float f = elapsed("bench_fps");
    if (f != 0.0F) {
      return "" + Math.round(1000.0F / f);
    }
    return "";
  }
  
  public static String getLastBenchAverage()
  {
    if (!ENABLE_LOG) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    float f = elapsed("bench_fps");
    if (f != 0.0F) {
      localStringBuilder.append("fps : " + Math.round(1000.0F / f) + "\n");
    }
    localStringBuilder.append("frame elapsed : " + f + "\n");
    localStringBuilder.append("yuv2rgba : " + elapsed("mPreviewFilter") + "\n");
    localStringBuilder.append("beauty-filter : " + elapsed("mBeautyFilter") + "\n");
    localStringBuilder.append("filter : " + elapsed("mFilter") + "\n");
    localStringBuilder.append("arFilter : " + elapsed("arFilter") + "\n");
    localStringBuilder.append("gpu2cpu : " + elapsed("gpu2cpu") + "\n");
    localStringBuilder.append("doTrack : " + elapsed("doTrack") + "\n");
    localStringBuilder.append("faceDetect : " + elapsed("faceDetect") + "\n");
    localStringBuilder.append("beautyTransform : " + elapsed("mBeautyTransformList") + "\n");
    localStringBuilder.append("sticker : " + elapsed("updateAndRender") + "\n");
    localStringBuilder.append("flip : " + elapsed("mFlipFilter") + "\n");
    localStringBuilder.append("viewFilter : " + elapsed("mViewFilter") + "\n");
    localStringBuilder.append("onDrawFrame : " + elapsed("onDrawFrame") + "\n");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static long getTotalTime(CopyOnWriteArrayList<Long> paramCopyOnWriteArrayList)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 59	com/tencent/ttpic/baseutils/fps/BenchUtil:ENABLE_LOG	Z
    //   8: istore 5
    //   10: iload 5
    //   12: ifne +8 -> 20
    //   15: ldc 2
    //   17: monitorexit
    //   18: lload_1
    //   19: lreturn
    //   20: aload_0
    //   21: invokestatic 302	com/tencent/ttpic/baseutils/collection/CollectionUtils:isEmpty	(Ljava/util/Collection;)Z
    //   24: ifne -9 -> 15
    //   27: aload_0
    //   28: invokevirtual 303	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   31: astore_0
    //   32: lconst_0
    //   33: lstore_1
    //   34: aload_0
    //   35: invokeinterface 214 1 0
    //   40: ifeq +23 -> 63
    //   43: aload_0
    //   44: invokeinterface 218 1 0
    //   49: checkcast 85	java/lang/Long
    //   52: invokevirtual 112	java/lang/Long:longValue	()J
    //   55: lstore_3
    //   56: lload_1
    //   57: lload_3
    //   58: ladd
    //   59: lstore_1
    //   60: goto -26 -> 34
    //   63: goto -48 -> 15
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramCopyOnWriteArrayList	CopyOnWriteArrayList<Long>
    //   1	59	1	l1	long
    //   55	3	3	l2	long
    //   8	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	10	66	finally
    //   20	32	66	finally
    //   34	56	66	finally
  }
  
  private static long getTotalTimeFPS(List<Long> paramList)
  {
    if (!ENABLE_DEBUG) {}
    while (CollectionUtils.isEmpty(paramList)) {
      return 0L;
    }
    paramList = paramList.iterator();
    for (long l = 0L; paramList.hasNext(); l = ((Long)paramList.next()).longValue() + l) {}
    return l;
  }
  
  public static void init()
  {
    startTimeMap.clear();
    totalTimeMap.clear();
    lastTimeMap.clear();
  }
  
  public static void setEnableDebugLog(boolean paramBoolean1, boolean paramBoolean2)
  {
    ENABLE_DEBUG = paramBoolean1;
    ENABLE_LOG = paramBoolean2;
  }
  
  public static void setLoggerAgent(LoggerAgent paramLoggerAgent)
  {
    sLogger = paramLoggerAgent;
  }
  
  public static class LoggerAgent
  {
    public void d(String paramString1, String paramString2)
    {
      if (BenchUtil.ENABLE_LOG) {
        LogUtils.d(paramString1, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.fps.BenchUtil
 * JD-Core Version:    0.7.0.1
 */