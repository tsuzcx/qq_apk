package com.tencent.token;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class of
{
  private static of a;
  private oe b;
  private og c = oh.a();
  
  private of()
  {
    b();
  }
  
  public static of a()
  {
    try
    {
      if (a == null) {
        a = new of();
      }
      of localof = a;
      return localof;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      String str = ou.a();
      mc.a("AccessSchedulerStorageManager", "try updateCacheInfo...currentApn:".concat(String.valueOf(str)));
      if ((!TextUtils.isEmpty(str)) && (!str.equals("unknown")))
      {
        if ((this.b != null) && (this.b.a.equals(str)))
        {
          mc.b("AccessSchedulerStorageManager", "same apn. no need update.");
          return;
        }
        this.b = this.c.a(str);
        if (this.b != null)
        {
          mc.a("AccessSchedulerStorageManager", "cache succ for current apn:".concat(String.valueOf(str)));
          return;
        }
        mc.c("AccessSchedulerStorageManager", "cache failed for apn:".concat(String.valueOf(str)));
        return;
      }
      mc.c("AccessSchedulerStorageManager", "updateCacheInfo failed... get current apn from ApnInfo:".concat(String.valueOf(str)));
      return;
    }
    finally {}
  }
  
  public final oe.a a(String paramString)
  {
    try
    {
      b();
      if ((this.b != null) && (this.b.a.equals(ou.a())))
      {
        paramString = (oe.a)this.b.b.get(paramString);
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
  
  public final void a(oe paramoe)
  {
    try
    {
      mc.b("AccessSchedulerStorageManager", "try updateAccessInfo...");
      if (paramoe == null)
      {
        mc.c("AccessSchedulerStorageManager", "updateAccessInfo info==null");
        return;
      }
      this.b = paramoe;
      this.c.a(paramoe);
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
        mc.b("AccessSchedulerStorageManager", "isNeedScheduler... ");
        b();
        if (this.b == null)
        {
          mc.b("AccessSchedulerStorageManager", "no cache, need schedule...");
          return true;
        }
        Object localObject = this.b.b;
        if (localObject == null)
        {
          mc.b("AccessSchedulerStorageManager", "DomainAccessInfo is null, need schedule...");
          return true;
        }
        if (((Map)localObject).size() < paramSet.size())
        {
          paramSet = new StringBuilder("DomainAccessInfo map not enough, need schedule...map.size:");
          paramSet.append(((Map)localObject).size());
          mc.b("AccessSchedulerStorageManager", paramSet.toString());
          return true;
        }
        Iterator localIterator = paramSet.iterator();
        boolean bool = localIterator.hasNext();
        i = 0;
        if (bool)
        {
          paramSet = (String)localIterator.next();
          oe.a locala = (oe.a)((Map)localObject).get(paramSet);
          if (locala != null)
          {
            if (System.currentTimeMillis() - locala.d > oi.a().b.e * 60 * 1000) {
              i = 1;
            }
          }
          else
          {
            localObject = new StringBuilder("domainInfo for domain:");
            ((StringBuilder)localObject).append(paramSet);
            ((StringBuilder)localObject).append(" is null or expired. need schedule...");
            mc.b("AccessSchedulerStorageManager", ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.token.of
 * JD-Core Version:    0.7.0.1
 */