package com.tencent.token;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class nk
{
  private static nk a;
  private nj b;
  private nl c = nm.a();
  
  private nk()
  {
    b();
  }
  
  public static nk a()
  {
    try
    {
      if (a == null) {
        a = new nk();
      }
      nk localnk = a;
      return localnk;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      String str = nz.a();
      lh.a("AccessSchedulerStorageManager", "try updateCacheInfo...currentApn:".concat(String.valueOf(str)));
      if ((!TextUtils.isEmpty(str)) && (!str.equals("unknown")))
      {
        if ((this.b != null) && (this.b.a.equals(str)))
        {
          lh.b("AccessSchedulerStorageManager", "same apn. no need update.");
          return;
        }
        this.b = this.c.a(str);
        if (this.b != null)
        {
          lh.a("AccessSchedulerStorageManager", "cache succ for current apn:".concat(String.valueOf(str)));
          return;
        }
        lh.c("AccessSchedulerStorageManager", "cache failed for apn:".concat(String.valueOf(str)));
        return;
      }
      lh.c("AccessSchedulerStorageManager", "updateCacheInfo failed... get current apn from ApnInfo:".concat(String.valueOf(str)));
      return;
    }
    finally {}
  }
  
  public final nj.a a(String paramString)
  {
    try
    {
      b();
      if ((this.b != null) && (this.b.a.equals(nz.a())))
      {
        paramString = (nj.a)this.b.b.get(paramString);
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
  
  public final void a(nj paramnj)
  {
    try
    {
      lh.b("AccessSchedulerStorageManager", "try updateAccessInfo...");
      if (paramnj == null)
      {
        lh.c("AccessSchedulerStorageManager", "updateAccessInfo info==null");
        return;
      }
      this.b = paramnj;
      this.c.a(paramnj);
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
        lh.b("AccessSchedulerStorageManager", "isNeedScheduler... ");
        b();
        if (this.b == null)
        {
          lh.b("AccessSchedulerStorageManager", "no cache, need schedule...");
          return true;
        }
        Object localObject = this.b.b;
        if (localObject == null)
        {
          lh.b("AccessSchedulerStorageManager", "DomainAccessInfo is null, need schedule...");
          return true;
        }
        if (((Map)localObject).size() < paramSet.size())
        {
          paramSet = new StringBuilder("DomainAccessInfo map not enough, need schedule...map.size:");
          paramSet.append(((Map)localObject).size());
          lh.b("AccessSchedulerStorageManager", paramSet.toString());
          return true;
        }
        Iterator localIterator = paramSet.iterator();
        boolean bool = localIterator.hasNext();
        i = 0;
        if (bool)
        {
          paramSet = (String)localIterator.next();
          nj.a locala = (nj.a)((Map)localObject).get(paramSet);
          if (locala != null)
          {
            if (System.currentTimeMillis() - locala.d > nn.a().b.e * 60 * 1000) {
              i = 1;
            }
          }
          else
          {
            localObject = new StringBuilder("domainInfo for domain:");
            ((StringBuilder)localObject).append(paramSet);
            ((StringBuilder)localObject).append(" is null or expired. need schedule...");
            lh.b("AccessSchedulerStorageManager", ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.token.nk
 * JD-Core Version:    0.7.0.1
 */