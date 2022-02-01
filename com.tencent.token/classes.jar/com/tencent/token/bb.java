package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.common.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bb
{
  private static bb a;
  private ba b;
  private bc c = bd.a();
  
  private bb()
  {
    a(false);
  }
  
  public static bb a()
  {
    try
    {
      if (a == null) {
        a = new bb();
      }
      bb localbb = a;
      return localbb;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      String str = bq.a();
      StringBuilder localStringBuilder = new StringBuilder("try updateCacheInfo...currentApn:");
      localStringBuilder.append(str);
      b.a("AccessSchedulerStorageManager", localStringBuilder.toString());
      if ((!TextUtils.isEmpty(str)) && (!str.equals("unknown")))
      {
        if ((this.b != null) && (this.b.b().equals(str)))
        {
          b.b("AccessSchedulerStorageManager", "same apn. no need update.");
          return;
        }
        this.b = this.c.a(str);
        if (this.b != null)
        {
          localStringBuilder = new StringBuilder("cache succ for current apn:");
          localStringBuilder.append(str);
          b.a("AccessSchedulerStorageManager", localStringBuilder.toString());
          return;
        }
        localStringBuilder = new StringBuilder("cache failed for apn:");
        localStringBuilder.append(str);
        b.c("AccessSchedulerStorageManager", localStringBuilder.toString());
        return;
      }
      localStringBuilder = new StringBuilder("updateCacheInfo failed... get current apn from ApnInfo:");
      localStringBuilder.append(str);
      b.c("AccessSchedulerStorageManager", localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public final ba.a a(String paramString)
  {
    try
    {
      a(false);
      if ((this.b != null) && (this.b.b().equals(bq.a())))
      {
        paramString = this.b.a(paramString);
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
  
  public final void a(ba paramba)
  {
    try
    {
      b.b("AccessSchedulerStorageManager", "try updateAccessInfo...");
      if (paramba == null)
      {
        b.c("AccessSchedulerStorageManager", "updateAccessInfo info==null");
        return;
      }
      this.b = paramba;
      this.c.a(paramba);
      return;
    }
    finally {}
  }
  
  public final boolean a(Set paramSet)
  {
    try
    {
      b.b("AccessSchedulerStorageManager", "isNeedScheduler... ");
      a(false);
      if (this.b == null)
      {
        b.b("AccessSchedulerStorageManager", "no cache, need schedule...");
        return true;
      }
      Object localObject = this.b.a();
      if (localObject == null)
      {
        b.b("AccessSchedulerStorageManager", "DomainAccessInfo is null, need schedule...");
        return true;
      }
      if (((Map)localObject).size() < paramSet.size())
      {
        paramSet = new StringBuilder("DomainAccessInfo map not enough, need schedule...map.size:");
        paramSet.append(((Map)localObject).size());
        b.b("AccessSchedulerStorageManager", paramSet.toString());
        return true;
      }
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        paramSet = (String)localIterator.next();
        ba.a locala = (ba.a)((Map)localObject).get(paramSet);
        if ((locala == null) || (locala.f()))
        {
          localObject = new StringBuilder("domainInfo for domain:");
          ((StringBuilder)localObject).append(paramSet);
          ((StringBuilder)localObject).append(" is null or expired. need schedule...");
          b.b("AccessSchedulerStorageManager", ((StringBuilder)localObject).toString());
          return true;
        }
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bb
 * JD-Core Version:    0.7.0.1
 */