package com.tencent.tmassistantsdk.downloadservice.a;

import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class c
  implements com.tencent.tmassistantsdk.downloadservice.k
{
  private ArrayList a = new ArrayList();
  private a b = null;
  
  public c(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.addAll(paramArrayList);
    }
  }
  
  private ArrayList b(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb.b.equals(paramString)) {
            localArrayList.add(localb);
          }
        }
        paramString = localArrayList;
      }
      finally {}
    }
  }
  
  private b c(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      try
      {
        Iterator localIterator = this.a.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            b localb = (b)localIterator.next();
            if ((localb.a != null) && (localb.a.equals(paramString1)))
            {
              boolean bool = localb.b.equals(paramString2);
              if (bool)
              {
                paramString1 = localb;
                break;
              }
            }
          }
        }
        paramString1 = null;
      }
      finally {}
    }
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb.b.equals(paramString)) {
            localArrayList.add(localb);
          }
        }
        if (localArrayList.size() <= 0) {
          continue;
        }
      }
      finally {}
      this.a.removeAll(localArrayList);
    }
  }
  
  public final int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map paramMap)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return 3;
    }
    com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1);
    if (c(paramString1, paramString2) != null)
    {
      com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",taskItem is null");
      return com.tencent.tmassistantsdk.downloadservice.a.a().a(paramString2, paramInt, paramString3, paramString4, paramMap);
    }
    Object localObject = b(paramString2);
    b localb1 = new b(paramString1, paramString2);
    localb1.c = 1;
    this.a.add(localb1);
    com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",add newTask");
    localObject = ((ArrayList)localObject).iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      b localb2 = (b)((Iterator)localObject).next();
      if (localb2.c == 2)
      {
        j = 1;
      }
      else
      {
        if (localb2.c != 1) {
          break label339;
        }
        i = 1;
      }
    }
    label339:
    for (;;)
    {
      break;
      if ((j == 1) || (i == 1))
      {
        if (j == 1) {
          localb1.c = 2;
        }
        for (;;)
        {
          if (this.b != null) {
            this.b.a(paramString1, paramString2, localb1.c, 0, null);
          }
          com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",newTask is downloading");
          return 0;
          if (i == 1) {
            localb1.c = 1;
          }
        }
      }
      com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",start newTask download");
      return com.tencent.tmassistantsdk.downloadservice.a.a().a(paramString2, paramInt, paramString3, paramString4, paramMap);
    }
  }
  
  public final TMAssistantDownloadTaskInfo a(String paramString)
  {
    Object localObject1 = com.tencent.tmassistantsdk.downloadservice.a.a().c(paramString);
    if (localObject1 != null) {
      return new TMAssistantDownloadTaskInfo(((d)localObject1).b, com.tencent.tmassistantsdk.e.b.a(((d)localObject1).k), ((d)localObject1).i, ((d)localObject1).j, ((d)localObject1).b(), ((d)localObject1).a);
    }
    Object localObject2;
    if (com.tencent.tmassistantsdk.downloadservice.c.b(paramString, "application/vnd.android.package-archive"))
    {
      localObject2 = com.tencent.tmassistantsdk.downloadservice.c.a(paramString, "application/vnd.android.package-archive");
      localObject1 = com.tencent.tmassistantsdk.e.b.a((String)localObject2);
      localObject2 = new com.tencent.tmassistantsdk.e.b((String)localObject2, (String)localObject2);
      return new TMAssistantDownloadTaskInfo(paramString, (String)localObject1, 4, ((com.tencent.tmassistantsdk.e.b)localObject2).b(), ((com.tencent.tmassistantsdk.e.b)localObject2).b(), "application/vnd.android.package-archive");
    }
    if (com.tencent.tmassistantsdk.downloadservice.c.b(paramString, "application/tm.android.apkdiff"))
    {
      localObject2 = com.tencent.tmassistantsdk.downloadservice.c.a(paramString, "application/tm.android.apkdiff");
      localObject1 = com.tencent.tmassistantsdk.e.b.a((String)localObject2);
      localObject2 = new com.tencent.tmassistantsdk.e.b((String)localObject2, (String)localObject2);
      return new TMAssistantDownloadTaskInfo(paramString, (String)localObject1, 4, ((com.tencent.tmassistantsdk.e.b)localObject2).b(), ((com.tencent.tmassistantsdk.e.b)localObject2).b(), "application/tm.android.apkdiff");
    }
    c(paramString);
    return null;
  }
  
  public final void a(a parama)
  {
    this.b = parama;
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      Object localObject = b(paramString1);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          b localb = (b)((Iterator)localObject).next();
          com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "OnDownloadStateChanged,clientKey:" + localb.a + ",state:" + paramInt1 + ",errorcode:" + paramInt2 + ",url:" + paramString1.hashCode());
          localb.c = paramInt1;
          this.b.a(localb.a, paramString1, paramInt1, paramInt2, paramString2);
        }
      }
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.b == null) {}
    do
    {
      return;
      localObject = b(paramString);
    } while ((localObject == null) || (((ArrayList)localObject).size() <= 0));
    long l = System.currentTimeMillis();
    Object localObject = ((ArrayList)localObject).iterator();
    label40:
    label253:
    for (;;)
    {
      b localb;
      int i;
      if (((Iterator)localObject).hasNext())
      {
        localb = (b)((Iterator)localObject).next();
        if (paramLong1 != paramLong2) {
          break label158;
        }
        localb.d = paramLong1;
        localb.e = l;
        i = 1;
      }
      for (;;)
      {
        if (i != 1) {
          break label253;
        }
        com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "OnDownloadProgressChanged,clientKey:" + localb.a + ",receivedLen:" + paramLong1 + ",url:" + paramString.hashCode());
        this.b.a(localb.a, paramString, paramLong1, paramLong2);
        break label40;
        break;
        if ((l - localb.e >= 1000L) && (paramLong1 != localb.d))
        {
          localb.d = paramLong1;
          localb.e = l;
          i = 1;
        }
        else if ((paramLong2 > 0L) && (((float)paramLong1 - (float)localb.d) / (float)paramLong2 > 0.009999999776482582D))
        {
          localb.d = paramLong1;
          localb.e = l;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "pauseDownload,clientKey:" + paramString1);
    b localb = c(paramString1, paramString2);
    if (localb != null)
    {
      localb.c = 3;
      this.a.remove(localb);
      com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "pauseDownload,clientKey:" + paramString1 + ",remove taskItem");
      ArrayList localArrayList = b(paramString2);
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "pauseDownload,clientKey:" + paramString1 + ",taskItem is the only on pauseAll");
        com.tencent.tmassistantsdk.downloadservice.a.a().a(paramString2);
        com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "pauseDownload end,clientKey:" + paramString1 + ",taskItem is the only on pauseAll");
      }
      if (this.b != null) {
        this.b.a(paramString1, paramString2, localb.c, 0, null);
      }
    }
    for (;;)
    {
      com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "pauseDownload end,clientKey:" + paramString1);
      return;
      com.tencent.tmassistantsdk.f.k.d("ServiceDownloadTaskManager", "pauseDownload,clientKey:" + paramString1 + ",taskItem is null");
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1);
    Object localObject = c(paramString1, paramString2);
    if (localObject != null)
    {
      this.a.remove(localObject);
      com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1 + ",remove taskItem");
    }
    for (;;)
    {
      localObject = b(paramString2);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
        break;
      }
      com.tencent.tmassistantsdk.f.k.b("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1 + ",taskItem is the only on cancelAll");
      com.tencent.tmassistantsdk.downloadservice.a.a().b(paramString2);
      return;
      com.tencent.tmassistantsdk.f.k.d("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1 + ",taskItem is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.a.c
 * JD-Core Version:    0.7.0.1
 */