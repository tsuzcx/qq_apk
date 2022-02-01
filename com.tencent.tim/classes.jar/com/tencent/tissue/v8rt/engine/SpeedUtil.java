package com.tencent.tissue.v8rt.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SpeedUtil
{
  public static final SpeedUtil DEFAULT = new SpeedUtil("default");
  public final String TAG = "SpdUtl";
  private final Map<String, ReportPoint> mPoints = new LinkedHashMap();
  private final String name;
  
  public SpeedUtil(String paramString)
  {
    this.name = paramString;
  }
  
  public void clear()
  {
    try
    {
      this.mPoints.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void event(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/tissue/v8rt/engine/SpeedUtil:mPoints	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 49 2 0
    //   12: checkcast 6	com/tencent/tissue/v8rt/engine/SpeedUtil$ReportPoint
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +38 -> 55
    //   20: new 6	com/tencent/tissue/v8rt/engine/SpeedUtil$ReportPoint
    //   23: dup
    //   24: invokespecial 50	com/tencent/tissue/v8rt/engine/SpeedUtil$ReportPoint:<init>	()V
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 37	com/tencent/tissue/v8rt/engine/SpeedUtil:mPoints	Ljava/util/Map;
    //   32: aload_1
    //   33: aload_2
    //   34: invokeinterface 54 3 0
    //   39: pop
    //   40: aload_2
    //   41: aload_1
    //   42: putfield 56	com/tencent/tissue/v8rt/engine/SpeedUtil$ReportPoint:event	Ljava/lang/String;
    //   45: aload_2
    //   46: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   49: putfield 66	com/tencent/tissue/v8rt/engine/SpeedUtil$ReportPoint:startTs	J
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: ldc 30
    //   57: new 68	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   64: ldc 71
    //   66: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 77
    //   75: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 87	com/tencent/tissue/v8rt/engine/Logger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   84: pop
    //   85: goto -45 -> 40
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	SpeedUtil
    //   0	93	1	paramString	String
    //   15	31	2	localReportPoint	ReportPoint
    // Exception table:
    //   from	to	target	type
    //   2	16	88	finally
    //   20	40	88	finally
    //   40	52	88	finally
    //   55	85	88	finally
  }
  
  public void report(String... paramVarArgs)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new ArrayList();
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label299;
        }
        paramVarArgs = Arrays.asList(paramVarArgs);
        Iterator localIterator = this.mPoints.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label116;
        }
        ReportPoint localReportPoint = (ReportPoint)((Map.Entry)localIterator.next()).getValue();
        if (paramVarArgs != null)
        {
          if (!paramVarArgs.contains(localReportPoint.event)) {
            continue;
          }
          ((ArrayList)localObject).add(localReportPoint);
          continue;
        }
        ((ArrayList)localObject).add(localReportPoint);
      }
      finally {}
      continue;
      label116:
      Collections.sort((List)localObject);
      paramVarArgs = ((ArrayList)localObject).iterator();
      long l2 = -1L;
      long l3;
      for (long l1 = -1L; paramVarArgs.hasNext(); l1 = l3)
      {
        localObject = (ReportPoint)paramVarArgs.next();
        l3 = l1;
        if (l1 == -1L) {
          l3 = ((ReportPoint)localObject).startTs;
        }
        l1 = l2;
        if (l2 == -1L) {
          l1 = ((ReportPoint)localObject).startTs;
        }
        Logger.d("SpdUtl", ((ReportPoint)localObject).event + "->" + ((ReportPoint)localObject).startTs + ",diff=" + (((ReportPoint)localObject).startTs - l3));
        l3 = ((ReportPoint)localObject).startTs;
        l2 = l1;
      }
      Logger.d("SpdUtl", this.name + " total:" + (l1 - l2));
      return;
      label299:
      paramVarArgs = null;
    }
  }
  
  public static class ReportPoint
    implements Comparable<ReportPoint>
  {
    String event = "";
    long startTs = 0L;
    
    public int compareTo(ReportPoint paramReportPoint)
    {
      long l = this.startTs - paramReportPoint.startTs;
      if (l < 0L) {
        return -1;
      }
      if (l > 0L) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.SpeedUtil
 * JD-Core Version:    0.7.0.1
 */