package com.tencent.token;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class nl
{
  private static nl a;
  private nk b;
  private nm c = nn.a();
  
  private nl()
  {
    b();
  }
  
  public static nl a()
  {
    try
    {
      if (a == null) {
        a = new nl();
      }
      nl localnl = a;
      return localnl;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      String str = oa.a();
      li.a("AccessSchedulerStorageManager", "try updateCacheInfo...currentApn:".concat(String.valueOf(str)));
      if ((!TextUtils.isEmpty(str)) && (!str.equals("unknown")))
      {
        if ((this.b != null) && (this.b.a.equals(str)))
        {
          li.b("AccessSchedulerStorageManager", "same apn. no need update.");
          return;
        }
        this.b = this.c.a(str);
        if (this.b != null)
        {
          li.a("AccessSchedulerStorageManager", "cache succ for current apn:".concat(String.valueOf(str)));
          return;
        }
        li.c("AccessSchedulerStorageManager", "cache failed for apn:".concat(String.valueOf(str)));
        return;
      }
      li.c("AccessSchedulerStorageManager", "updateCacheInfo failed... get current apn from ApnInfo:".concat(String.valueOf(str)));
      return;
    }
    finally {}
  }
  
  public final nk.a a(String paramString)
  {
    try
    {
      b();
      if ((this.b != null) && (this.b.a.equals(oa.a())))
      {
        paramString = (nk.a)this.b.b.get(paramString);
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
  
  public final void a(nk paramnk)
  {
    try
    {
      li.b("AccessSchedulerStorageManager", "try updateAccessInfo...");
      if (paramnk == null)
      {
        li.c("AccessSchedulerStorageManager", "updateAccessInfo info==null");
        return;
      }
      this.b = paramnk;
      this.c.a(paramnk);
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
        li.b("AccessSchedulerStorageManager", "isNeedScheduler... ");
        b();
        if (this.b == null)
        {
          li.b("AccessSchedulerStorageManager", "no cache, need schedule...");
          return true;
        }
        Object localObject = this.b.b;
        if (localObject == null)
        {
          li.b("AccessSchedulerStorageManager", "DomainAccessInfo is null, need schedule...");
          return true;
        }
        if (((Map)localObject).size() < paramSet.size())
        {
          paramSet = new StringBuilder("DomainAccessInfo map not enough, need schedule...map.size:");
          paramSet.append(((Map)localObject).size());
          li.b("AccessSchedulerStorageManager", paramSet.toString());
          return true;
        }
        Iterator localIterator = paramSet.iterator();
        boolean bool = localIterator.hasNext();
        i = 0;
        if (bool)
        {
          paramSet = (String)localIterator.next();
          nk.a locala = (nk.a)((Map)localObject).get(paramSet);
          if (locala != null)
          {
            if (System.currentTimeMillis() - locala.d > no.a().b.e * 60 * 1000) {
              i = 1;
            }
          }
          else
          {
            localObject = new StringBuilder("domainInfo for domain:");
            ((StringBuilder)localObject).append(paramSet);
            ((StringBuilder)localObject).append(" is null or expired. need schedule...");
            li.b("AccessSchedulerStorageManager", ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.token.nl
 * JD-Core Version:    0.7.0.1
 */