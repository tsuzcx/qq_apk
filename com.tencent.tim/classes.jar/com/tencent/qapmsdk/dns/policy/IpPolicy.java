package com.tencent.qapmsdk.dns.policy;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.dns.logic.DnsCacheManager;
import com.tencent.qapmsdk.dns.logic.LocalDnsManager;
import com.tencent.qapmsdk.dns.model.DnsCacheObj;
import com.tencent.qapmsdk.dns.model.IpCachedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class IpPolicy
{
  public static final IpPolicy EMPTY = new IpPolicyDefault(null);
  public static final IpPolicy PRIORITY = new IpPolicyPriority(null);
  public static final IpPolicy RANDOM = new IpPolicyRandom(null);
  private static final String TAG = "QAM_DNS_IpPolicy";
  private static IpPolicy sPolicy = RANDOM;
  
  @NonNull
  public static IpPolicy getPolicy()
  {
    return sPolicy;
  }
  
  public static void setIpPolicy(IpPolicy paramIpPolicy)
  {
    IpPolicy localIpPolicy = paramIpPolicy;
    if (paramIpPolicy == null) {
      localIpPolicy = EMPTY;
    }
    sPolicy = localIpPolicy;
  }
  
  public abstract List<String> sort(String paramString, List<String> paramList);
  
  static class IpPolicyDefault
    extends IpPolicy
  {
    public List<String> sort(String paramString, List<String> paramList)
    {
      return paramList;
    }
  }
  
  static class IpPolicyPriority
    extends IpPolicy
  {
    private static final int[] SPEED_SECTION = { 50, 150, 250, 350, 450, 550 };
    
    public List<String> sort(String paramString, List<String> paramList)
    {
      Object localObject1 = LocalDnsManager.getInstance().getIpList(paramString);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        localObject1 = RANDOM.sort(paramString, paramList);
      }
      do
      {
        do
        {
          do
          {
            return localObject1;
            SystemClock.elapsedRealtime();
            localObject2 = DnsCacheManager.getInstance().getDnsCache(paramString);
            localObject1 = paramList;
          } while (localObject2 == null);
          localObject2 = ((DnsCacheObj)localObject2).ipList;
          localObject1 = paramList;
        } while (localObject2 == null);
        localObject1 = paramList;
      } while (((CopyOnWriteArrayList)localObject2).size() == 0);
      ArrayList localArrayList = new ArrayList();
      localObject1 = SPEED_SECTION;
      int j = localObject1.length;
      int i = 0;
      int k;
      while (i < j)
      {
        k = localObject1[i];
        localArrayList.add(new ArrayList());
        i += 1;
      }
      localObject1 = null;
      double d1 = 1.7976931348623157E+308D;
      Iterator localIterator = ((CopyOnWriteArrayList)localObject2).iterator();
      Object localObject3;
      if (localIterator.hasNext())
      {
        localObject3 = (IpCachedItem)localIterator.next();
        j = 0;
        double d2 = d1;
        localObject2 = localObject1;
        if (((IpCachedItem)localObject3).avgElapse < d1)
        {
          d2 = ((IpCachedItem)localObject3).avgElapse;
          localObject2 = localObject3;
        }
        i = 0;
        for (;;)
        {
          d1 = d2;
          localObject1 = localObject2;
          if (i >= SPEED_SECTION.length) {
            break;
          }
          k = SPEED_SECTION[i];
          if ((((IpCachedItem)localObject3).avgElapse >= j) && (((IpCachedItem)localObject3).avgElapse < k))
          {
            ((List)localArrayList.get(i)).add(localObject3);
            d1 = d2;
            localObject1 = localObject2;
            break;
          }
          j += k;
          i += 1;
        }
      }
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (List)((Iterator)localObject2).next();
        i = ((List)localObject3).size();
        if (i > 0) {
          localObject1 = (IpCachedItem)((List)localObject3).get(new Random().nextInt(i));
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          j = paramList.indexOf(((IpCachedItem)localObject1).ip);
          paramString = new ArrayList();
          paramString.add(((IpCachedItem)localObject1).ip);
          i = 0;
          if (i < paramList.size())
          {
            if (i == j) {}
            for (;;)
            {
              i += 1;
              break;
              paramString.add(paramList.get(i));
            }
          }
          return paramString;
        }
        return RANDOM.sort(paramString, paramList);
      }
    }
  }
  
  static class IpPolicyRandom
    extends IpPolicy
  {
    public List<String> sort(String paramString, List<String> paramList)
    {
      if ((paramList == null) || (paramList.size() == 0)) {
        return paramList;
      }
      int j = new Random().nextInt(paramList.size());
      paramString = new ArrayList();
      paramString.add(paramList.get(j));
      int i = 0;
      if (i < paramList.size())
      {
        if (i == j) {}
        for (;;)
        {
          i += 1;
          break;
          paramString.add(paramList.get(i));
        }
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.policy.IpPolicy
 * JD-Core Version:    0.7.0.1
 */