package com.qzone.statistics;

import android.content.Context;
import com.qzone.download.NetworkManager;
import com.qzone.statistics.common.FixedLinkedList;
import com.qzone.utils.NetworkUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProxyStatistics
{
  private final Map<String, StatisticsUnit> mDominantUnitCache = new HashMap();
  private final Map<String, FixedLinkedList<StatisticsUnit>> mStatisticsCache = new HashMap();
  
  public static ProxyStatistics getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private void updateStatistics(List<StatisticsUnit> paramList, String paramString)
  {
    boolean bool2 = true;
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      int j;
      int k;
      int i;
      boolean bool1;
      synchronized (this.mDominantUnitCache)
      {
        StatisticsUnit localStatisticsUnit2 = (StatisticsUnit)this.mDominantUnitCache.get(paramString);
        StatisticsUnit localStatisticsUnit1 = localStatisticsUnit2;
        if (localStatisticsUnit2 == null)
        {
          localStatisticsUnit1 = new StatisticsUnit();
          this.mDominantUnitCache.put(paramString, localStatisticsUnit1);
        }
        j = 0;
        k = 0;
        i = 0;
        paramList = paramList.iterator();
        if (!paramList.hasNext())
        {
          if (j <= 0) {
            break;
          }
          if (k / j <= 0.5F) {
            break label215;
          }
          bool1 = true;
          localStatisticsUnit1.allowProxy = bool1;
          if (i / j <= 0.5F) {
            break label221;
          }
          bool1 = bool2;
          localStatisticsUnit1.apnProxy = bool1;
          return;
        }
      }
      paramString = (StatisticsUnit)paramList.next();
      if (paramString != null)
      {
        int n = j + 1;
        int m = k;
        if (paramString.allowProxy) {
          m = k + 1;
        }
        k = m;
        j = n;
        if (paramString.apnProxy)
        {
          i += 1;
          k = m;
          j = n;
          continue;
          label215:
          bool1 = false;
          continue;
          label221:
          bool1 = false;
        }
      }
    }
  }
  
  public boolean getAPNProxy()
  {
    String str = NetworkManager.getApnValue();
    StatisticsUnit localStatisticsUnit1;
    synchronized (this.mDominantUnitCache)
    {
      StatisticsUnit localStatisticsUnit2 = (StatisticsUnit)this.mDominantUnitCache.get(str);
      localStatisticsUnit1 = localStatisticsUnit2;
      if (localStatisticsUnit2 == null) {
        localStatisticsUnit1 = new StatisticsUnit();
      }
    }
  }
  
  public boolean getAllowProxy()
  {
    String str = NetworkManager.getApnValue();
    StatisticsUnit localStatisticsUnit1;
    synchronized (this.mDominantUnitCache)
    {
      StatisticsUnit localStatisticsUnit2 = (StatisticsUnit)this.mDominantUnitCache.get(str);
      localStatisticsUnit1 = localStatisticsUnit2;
      if (localStatisticsUnit2 == null) {
        localStatisticsUnit1 = new StatisticsUnit();
      }
    }
  }
  
  public void report(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!NetworkUtil.isViaMobile(paramContext)) {
      return;
    }
    StatisticsUnit localStatisticsUnit = new StatisticsUnit();
    localStatisticsUnit.allowProxy = paramBoolean1;
    localStatisticsUnit.apnProxy = paramBoolean2;
    synchronized (this.mStatisticsCache)
    {
      String str = NetworkManager.getApnValue();
      FixedLinkedList localFixedLinkedList = (FixedLinkedList)this.mStatisticsCache.get(str);
      paramContext = localFixedLinkedList;
      if (localFixedLinkedList == null)
      {
        paramContext = new FixedLinkedList(3, false);
        this.mStatisticsCache.put(str, paramContext);
      }
      paramContext.add(0, localStatisticsUnit);
      updateStatistics(paramContext, str);
      return;
    }
  }
  
  static class InstanceHolder
  {
    static final ProxyStatistics INSTANCE = new ProxyStatistics(null);
  }
  
  static class StatisticsUnit
  {
    public boolean allowProxy = false;
    public boolean apnProxy = false;
    
    public StatisticsUnit()
    {
      if (NetworkManager.isWap())
      {
        this.allowProxy = true;
        this.apnProxy = true;
        return;
      }
      this.allowProxy = false;
      this.apnProxy = false;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof StatisticsUnit))) {
          return false;
        }
        paramObject = (StatisticsUnit)paramObject;
      } while ((this.allowProxy == paramObject.allowProxy) && (this.apnProxy) && (paramObject.apnProxy));
      return false;
    }
    
    public int hashCode()
    {
      int j = 1;
      int i;
      if (this.allowProxy)
      {
        i = 1;
        if (!this.apnProxy) {
          break label34;
        }
      }
      for (;;)
      {
        return (i + 527) * 31 + j;
        i = 0;
        break;
        label34:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.statistics.ProxyStatistics
 * JD-Core Version:    0.7.0.1
 */