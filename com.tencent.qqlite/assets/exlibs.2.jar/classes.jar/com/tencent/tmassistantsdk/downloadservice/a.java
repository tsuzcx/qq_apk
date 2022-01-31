package com.tencent.tmassistantsdk.downloadservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements l
{
  private static a a = null;
  private ConcurrentHashMap b = new ConcurrentHashMap();
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public static void a(k paramk)
  {
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call AddDownloadListener, dl: " + paramk);
    e.a().a(paramk);
  }
  
  public static void b(k paramk)
  {
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call RemoveDownloadListener, dl: " + paramk);
    e.a().b(paramk);
  }
  
  public final int a(String paramString1, int paramInt, String paramString2, String paramString3, Map paramMap)
  {
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call startDownload, url: " + paramString1 + "priority: " + paramInt);
    if (!c.c())
    {
      com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call startDownload, return errCode: 1");
      return 1;
    }
    if ((!c.b().equalsIgnoreCase("wifi")) && (f.a().b()))
    {
      com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call startDownload, return errCode: 2");
      return 2;
    }
    if (!c.f(paramString1))
    {
      com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call startDownload, return errCode: 3");
      return 3;
    }
    if (c.b(paramString1, paramString2))
    {
      com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call startDownload, return errCode: 4");
      return 4;
    }
    Object localObject1 = (d)this.b.get(paramString1);
    Object localObject2;
    if (localObject1 == null)
    {
      com.tencent.tmassistantsdk.e.a.a();
      localObject1 = com.tencent.tmassistantsdk.e.a.b(paramString1);
      if (localObject1 == null)
      {
        localObject2 = new d(paramString1, paramInt, paramString2);
        localObject1 = localObject2;
        if (((d)localObject2).a.equals("resource/tm.android.unknown"))
        {
          ((d)localObject2).k = paramString3;
          localObject1 = localObject2;
        }
        this.b.put(paramString1, localObject1);
      }
    }
    for (;;)
    {
      ((d)localObject1).a((HashMap)paramMap);
      if (((d)localObject1).a.equals("application/tm.android.apkdiff")) {}
      for (boolean bool = c.b(paramString1, ((d)localObject1).a);; bool = c.g(((d)localObject1).k))
      {
        localObject2 = localObject1;
        if (((d)localObject1).c())
        {
          localObject2 = localObject1;
          if (!bool)
          {
            this.b.remove(paramString1);
            com.tencent.tmassistantsdk.e.a.a();
            com.tencent.tmassistantsdk.e.a.a(paramString1);
            localObject2 = new d(paramString1, paramInt, paramString2);
            if (((d)localObject2).a.equals("resource/tm.android.unknown")) {
              ((d)localObject2).k = paramString3;
            }
            ((d)localObject2).a((HashMap)paramMap);
            this.b.put(paramString1, localObject2);
          }
        }
        paramInt = ((d)localObject2).d();
        com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call startDownload, return errCode: " + paramInt);
        return paramInt;
        if (((d)localObject1).a.equals("application/tm.android.apkdiff")) {}
        for (bool = c.b(paramString1, ((d)localObject1).a); bool; bool = c.g(((d)localObject1).k))
        {
          com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call startDownload, return errCode: 4");
          return 4;
        }
        break;
      }
    }
  }
  
  public final void a(String paramString)
  {
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call pauseDownload, url: " + paramString);
    paramString = (d)this.b.get(paramString);
    if (paramString != null)
    {
      com.tencent.tmassistantsdk.f.k.b("_DownloadInfo", "DownloadInfo::pauseDownload url: " + paramString.b);
      h.a().a(paramString.h);
      paramString.a(3);
    }
  }
  
  public final void b()
  {
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "Start to load DownloadInfo list.");
    this.b.clear();
    com.tencent.tmassistantsdk.e.a.a();
    Object localObject = com.tencent.tmassistantsdk.e.a.b();
    if (localObject != null)
    {
      com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "The size of downloadinfo_list: " + ((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      label125:
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "---------------load download info---------------");
        locald.a("ApkDownloadManager");
        this.b.put(locald.b, locald);
        if (locald.i > 3) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label125;
          }
          locald.a(3);
          break;
        }
      }
    }
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "Add NetworkChangedObserver to NetworkMonitorReceiver");
    NetworkMonitorReceiver.a().a(this);
  }
  
  public final void b(String paramString)
  {
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call cancelDownload, url: " + paramString);
    paramString = (d)this.b.remove(paramString);
    if (paramString != null)
    {
      com.tencent.tmassistantsdk.f.k.b("_DownloadInfo", "DownloadInfo::stopDownload url: " + paramString.b);
      h.a().a(paramString.h);
      paramString.a(6);
    }
  }
  
  public final d c(String paramString)
  {
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "call queryDownloadInfo, url: " + paramString);
    Object localObject2 = (d)this.b.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.tmassistantsdk.e.a.a();
      localObject1 = com.tencent.tmassistantsdk.e.a.b(paramString);
    }
    boolean bool = false;
    if (localObject1 != null) {
      if (!((d)localObject1).a.equals("application/tm.android.apkdiff")) {
        break label125;
      }
    }
    label125:
    for (bool = c.b(paramString, ((d)localObject1).a);; bool = c.g(((d)localObject1).k))
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((d)localObject1).c())
        {
          localObject2 = localObject1;
          if (!bool)
          {
            this.b.remove(paramString);
            com.tencent.tmassistantsdk.e.a.a();
            com.tencent.tmassistantsdk.e.a.a(paramString);
            localObject2 = null;
          }
        }
      }
      return localObject2;
    }
  }
  
  public final void c()
  {
    NetworkMonitorReceiver.a().b(this);
    ArrayList localArrayList = new ArrayList();
    if (!this.b.isEmpty())
    {
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)this.b.get(localIterator.next());
        if (locald.i == 2) {
          a(locald.b);
        }
        localArrayList.add(locald);
      }
    }
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "Start to save DownloadInfo list.");
    com.tencent.tmassistantsdk.e.a.a();
    com.tencent.tmassistantsdk.e.a.a(localArrayList);
  }
  
  public final Boolean d()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      if (((d)this.b.get(localIterator.next())).i > 3) {}
      for (int i = 1; i == 0; i = 0) {
        return Boolean.valueOf(false);
      }
    }
    return Boolean.valueOf(true);
  }
  
  public final void e()
  {
    com.tencent.tmassistantsdk.f.k.b("ApkDownloadManager", "onNetworkChanged");
    if ((c.c()) && (f.a().d()))
    {
      String str = c.b();
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)this.b.get(localIterator.next());
        f.a();
        if ((f.a(locald.o, str)) && ((locald.n == 601) || (locald.n == 602) || (locald.n == 605)) && (System.currentTimeMillis() - locald.p < 120000L)) {
          locald.d();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.a
 * JD-Core Version:    0.7.0.1
 */