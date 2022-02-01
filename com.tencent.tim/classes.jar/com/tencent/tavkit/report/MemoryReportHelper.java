package com.tencent.tavkit.report;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class MemoryReportHelper
{
  public static final int MIN_TICK_INTERVAL_MS = 1000;
  private static final String TAG = "MemoryReportHelper";
  private static long lastTickTime;
  private Map<String, Consumer> consumerHashMap = new HashMap();
  @Nullable
  private Context context;
  
  @NotNull
  public static String appendKeys(Collection<String> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  @NotNull
  public static String appendReportKey(Collection<?> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if ((localObject instanceof IReportable)) {
        localArrayList.add(((IReportable)localObject).getReportKey());
      }
    }
    return appendKeys(localArrayList);
  }
  
  public static MemoryReportHelper getInstance()
  {
    return Instance.INSTANCE;
  }
  
  public static boolean isInIntervalTime()
  {
    long l = System.currentTimeMillis();
    if (l - lastTickTime < 1000L) {
      return true;
    }
    lastTickTime = l;
    return false;
  }
  
  public void clear()
  {
    this.consumerHashMap.clear();
  }
  
  public Map<String, Long> getAvgMBValues()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.consumerHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      Consumer localConsumer = (Consumer)localIterator.next();
      if (localConsumer != null) {
        localHashMap.put(localConsumer.key, Long.valueOf(localConsumer.getAvgMB()));
      }
    }
    return localHashMap;
  }
  
  public Map<String, Long> getMaxMBValues()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.consumerHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      Consumer localConsumer = (Consumer)localIterator.next();
      if (localConsumer != null) {
        localHashMap.put(localConsumer.key, Long.valueOf(localConsumer.getMaxM()));
      }
    }
    return localHashMap;
  }
  
  @RequiresApi(api=5)
  public int getPidMemorySize(int paramInt, Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
    paramContext[0].getTotalSharedDirty();
    return paramContext[0].getTotalPss();
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void tick(String paramString)
  {
    if (this.context == null) {
      return;
    }
    tick(paramString, getPidMemorySize(Process.myPid(), this.context) / 1024);
  }
  
  public void tick(String paramString, long paramLong)
  {
    Consumer localConsumer2 = (Consumer)this.consumerHashMap.get(paramString);
    Consumer localConsumer1 = localConsumer2;
    if (localConsumer2 == null)
    {
      localConsumer1 = new Consumer(paramString);
      this.consumerHashMap.put(localConsumer1.key, localConsumer1);
    }
    localConsumer1.tick(paramLong);
    Log.d("MemoryReportHelper", "tick() called with: key = [" + paramString + "], MB = [" + paramLong + "]");
  }
  
  static class Consumer
  {
    private long count = 0L;
    private final String key;
    private long maxM = 0L;
    private long totalM = 0L;
    
    public Consumer(String paramString)
    {
      this.key = paramString;
    }
    
    private long getAvgMB()
    {
      if (this.count == 0L) {
        return 0L;
      }
      return this.totalM / this.count;
    }
    
    private void tick(long paramLong)
    {
      this.totalM += paramLong;
      this.count += 1L;
      if (paramLong > this.maxM) {
        this.maxM = paramLong;
      }
    }
    
    public long getMaxM()
    {
      return this.maxM;
    }
  }
  
  static class Instance
  {
    private static final MemoryReportHelper INSTANCE = new MemoryReportHelper(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.report.MemoryReportHelper
 * JD-Core Version:    0.7.0.1
 */