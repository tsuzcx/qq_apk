package com.tencent.token;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class nr
{
  private static nr a;
  private nq b;
  private ns c = nt.a();
  
  private nr()
  {
    b();
  }
  
  public static nr a()
  {
    try
    {
      if (a == null) {
        a = new nr();
      }
      nr localnr = a;
      return localnr;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      String str = og.a();
      lo.a("AccessSchedulerStorageManager", "try updateCacheInfo...currentApn:".concat(String.valueOf(str)));
      if ((!TextUtils.isEmpty(str)) && (!str.equals("unknown")))
      {
        if ((this.b != null) && (this.b.a.equals(str)))
        {
          lo.b("AccessSchedulerStorageManager", "same apn. no need update.");
          return;
        }
        this.b = this.c.a(str);
        if (this.b != null)
        {
          lo.a("AccessSchedulerStorageManager", "cache succ for current apn:".concat(String.valueOf(str)));
          return;
        }
        lo.c("AccessSchedulerStorageManager", "cache failed for apn:".concat(String.valueOf(str)));
        return;
      }
      lo.c("AccessSchedulerStorageManager", "updateCacheInfo failed... get current apn from ApnInfo:".concat(String.valueOf(str)));
      return;
    }
    finally {}
  }
  
  public final nq.a a(String paramString)
  {
    try
    {
      b();
      if ((this.b != null) && (this.b.a.equals(og.a())))
      {
        paramString = (nq.a)this.b.b.get(paramString);
        return paramString;
      }
      return null;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(nq paramnq)
  {
    try
    {
      lo.b("AccessSchedulerStorageManager", "try updateAccessInfo...");
      if (paramnq == null)
      {
        lo.c("AccessSchedulerStorageManager", "updateAccessInfo info==null");
        return;
      }
      this.b = paramnq;
      this.c.a(paramnq);
      return;
    }
    finally {}
  }
  
  public final boolean a(Set paramSet)
  {
    for (;;)
    {
      int i;
      try
      {
        lo.b("AccessSchedulerStorageManager", "isNeedScheduler... ");
        b();
        if (this.b == null)
        {
          lo.b("AccessSchedulerStorageManager", "no cache, need schedule...");
          return true;
        }
        Object localObject = this.b.b;
        if (localObject == null)
        {
          lo.b("AccessSchedulerStorageManager", "DomainAccessInfo is null, need schedule...");
          return true;
        }
        if (((Map)localObject).size() < paramSet.size())
        {
          paramSet = new StringBuilder("DomainAccessInfo map not enough, need schedule...map.size:");
          paramSet.append(((Map)localObject).size());
          lo.b("AccessSchedulerStorageManager", paramSet.toString());
          return true;
        }
        Iterator localIterator = paramSet.iterator();
        boolean bool = localIterator.hasNext();
        i = 0;
        if (bool)
        {
          paramSet = (String)localIterator.next();
          nq.a locala = (nq.a)((Map)localObject).get(paramSet);
          if (locala != null)
          {
            if (System.currentTimeMillis() - locala.d > nu.a().b.e * 60 * 1000) {
              i = 1;
            }
          }
          else
          {
            localObject = new StringBuilder("domainInfo for domain:");
            ((StringBuilder)localObject).append(paramSet);
            ((StringBuilder)localObject).append(" is null or expired. need schedule...");
            lo.b("AccessSchedulerStorageManager", ((StringBuilder)localObject).toString());
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      finally {}
      if (i == 0) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nr
 * JD-Core Version:    0.7.0.1
 */