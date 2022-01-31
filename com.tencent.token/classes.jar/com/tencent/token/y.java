package com.tencent.token;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.g;
import com.tencent.halley.common.i;
import com.tencent.halley.common.j;
import com.tencent.halley.downloader.b;
import com.tencent.halley.downloader.exceptions.DownloaderAddTaskException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

public final class y
  implements com.tencent.halley.downloader.c, ac, p
{
  private static y a = null;
  private Vector b = new Vector();
  private ab c = new ab(this);
  
  private y()
  {
    o.a(this);
  }
  
  public static y a()
  {
    try
    {
      if (a == null) {
        a = new y();
      }
      y localy = a;
      return localy;
    }
    finally {}
  }
  
  private void a(com.tencent.halley.downloader.c.h paramh, int paramInt)
  {
    int j = 1;
    if (paramh == null) {
      return;
    }
    try
    {
      com.tencent.halley.common.c.b("TaskManager", "reportResult task:" + paramh.c() + ", result:" + paramInt + ",costTime:" + paramh.j + ",receivedLen:" + paramh.f() + ",totalLen:" + paramh.a_() + ",flow:" + paramh.o);
      if (!h.e)
      {
        com.tencent.halley.common.c.c("TaskManager", "reportResult missed for EnableUserAction:" + h.e);
        return;
      }
    }
    catch (Throwable paramh)
    {
      paramh = paramh;
      paramh.printStackTrace();
      return;
    }
    finally {}
    HashMap localHashMap = new HashMap();
    localHashMap.put("B1", paramh.n);
    localHashMap.put("B2", j.e());
    localHashMap.put("B3", j.f());
    localHashMap.put("B4", j.g());
    if (!TextUtils.isEmpty(h.a)) {
      localHashMap.put("B5", h.a);
    }
    localHashMap.put("B6", com.tencent.halley.common.h.f());
    if (!TextUtils.isEmpty(paramh.c)) {
      localHashMap.put("B7", paramh.c);
    }
    if (!TextUtils.isEmpty(paramh.d)) {
      localHashMap.put("B8", paramh.d);
    }
    if (!TextUtils.isEmpty(h.b)) {
      localHashMap.put("B9", h.b);
    }
    if (!TextUtils.isEmpty(h.c)) {
      localHashMap.put("B10", h.c);
    }
    localHashMap.put("C11", g.b());
    localHashMap.put("C12", g.a());
    localHashMap.put("C13", paramh.s());
    localHashMap.put("B14", paramh.q());
    localHashMap.put("B15", paramh.j);
    long l1 = System.currentTimeMillis();
    localHashMap.put("C16", paramh.t);
    localHashMap.put("C17", l1);
    localHashMap.put("B18", paramh.a);
    localHashMap.put("B19", paramh.b);
    localHashMap.put("C20", j.b(paramh.n()));
    localHashMap.put("C81", paramh.F.toString());
    int i = paramh.m();
    if (paramInt == 0) {
      i = 0;
    }
    localHashMap.put("B21", i);
    localHashMap.put("B22", paramInt);
    localHashMap.put("B23", paramh.M());
    if (!TextUtils.isEmpty(paramh.z)) {
      localHashMap.put("B24", paramh.z);
    }
    localHashMap.put("B25", o.e());
    localHashMap.put("C26", paramh.J());
    localHashMap.put("C27", paramh.A);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramh.o())
    {
      i = 1;
      localHashMap.put("B28", i);
      boolean bool = paramh.z();
      localStringBuilder = new StringBuilder();
      if (!bool) {
        break label1515;
      }
    }
    label1515:
    for (i = j;; i = 0)
    {
      localHashMap.put("B32", new String(i));
      localHashMap.put("B33", paramh.H());
      localHashMap.put("B34", paramh.G());
      localHashMap.put("C37", paramh.K());
      if (paramInt != 0) {
        paramh.v = SystemClock.elapsedRealtime();
      }
      long l2 = -1L;
      l1 = l2;
      if (paramh.u > 0L)
      {
        l1 = l2;
        if (paramh.v > paramh.u) {
          l1 = paramh.v - paramh.u;
        }
      }
      localHashMap.put("B38", l1);
      localHashMap.put("B41", paramh.f());
      localHashMap.put("B44", paramh.o);
      localHashMap.put("B45", paramh.p.getAndSet(0L));
      if (paramh.x) {
        localHashMap.put("B46", "1");
      }
      if (paramInt == 0) {
        localHashMap.put("C48", paramh.A());
      }
      localHashMap.put("B60", i());
      localHashMap.put("B66", paramh.B());
      localHashMap.put("C73", paramh.E());
      localHashMap.put("C72", paramh.D());
      if (paramh.C()) {
        localHashMap.put("C74", "1");
      }
      if ((paramInt == 0) && (paramh.B > 0L)) {
        localHashMap.put("B77", paramh.B);
      }
      localHashMap.put("C78", paramh.L());
      localHashMap.put("C79", paramh.I());
      if (!TextUtils.isEmpty(paramh.y)) {
        localHashMap.put("C80", paramh.y);
      }
      if (!TextUtils.isEmpty(paramh.D))
      {
        localHashMap.put("C82", paramh.D);
        localHashMap.put("B83", paramh.E);
      }
      i.a("B_DLSDK_Result", true, 0L, 0L, localHashMap, true);
      return;
      i = 0;
      break;
    }
  }
  
  private int i()
  {
    synchronized (this.b)
    {
      int i = this.b.size();
      return i + 0;
    }
  }
  
  private boolean j()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.halley.downloader.c.h localh = (com.tencent.halley.downloader.c.h)localIterator.next();
        if ((localh.t()) || (localh.u())) {
          return true;
        }
      }
      return false;
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    Object localObject = d();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.halley.downloader.c.h)((Iterator)localObject).next()).a(paramInt, paramString);
      }
    }
  }
  
  public final void a(b paramb) {}
  
  public final void a(b paramb, boolean paramBoolean)
  {
    if (paramb == null) {
      return;
    }
    com.tencent.halley.common.c.b("TaskManager", "delete task:" + paramb.c());
    ((com.tencent.halley.downloader.c.h)paramb).a(paramBoolean);
    synchronized (this.b)
    {
      this.b.remove(paramb);
      a((com.tencent.halley.downloader.c.h)paramb, 3);
      if (j())
      {
        this.c.a();
        return;
      }
    }
    this.c.b();
  }
  
  public final void b()
  {
    if (this.c != null) {
      this.c.c();
    }
  }
  
  public final void b(b paramb)
  {
    if (j())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final List c()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.b)
    {
      localLinkedList.addAll(this.b);
      return localLinkedList;
    }
  }
  
  public final void c(b paramb)
  {
    com.tencent.halley.common.c.a("TaskManager" + paramb, "onTaskDetectedMainloop task:" + paramb + ",detectLen:" + paramb.a_());
  }
  
  public final List d()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.halley.downloader.c.h localh = (com.tencent.halley.downloader.c.h)localIterator.next();
        if (localh.t()) {
          localLinkedList.add(localh);
        }
      }
    }
    return localList;
  }
  
  public final void d(b paramb)
  {
    com.tencent.halley.common.c.a("TaskManager" + paramb, "onTaskReceivedMainloop task:" + paramb + ",detectLen:" + paramb.a_() + ",receivedLen:" + paramb.f() + ",percentage:" + paramb.g());
  }
  
  public final void e(b paramb)
  {
    if (j()) {
      this.c.a();
    }
    for (;;)
    {
      com.tencent.halley.common.c.a("TaskManager" + paramb, "onTaskPausedMainloop task:" + paramb);
      return;
      this.c.b();
    }
  }
  
  public final boolean e()
  {
    Object localObject = d();
    int i = ((List)localObject).size();
    localObject = ((List)localObject).iterator();
    boolean bool = false;
    if (((Iterator)localObject).hasNext())
    {
      com.tencent.halley.downloader.c.h localh = (com.tencent.halley.downloader.c.h)((Iterator)localObject).next();
      localh.a(i);
      if (!localh.e()) {
        break label65;
      }
      bool = true;
    }
    label65:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public final long f()
  {
    long l = 0L;
    for (;;)
    {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          com.tencent.halley.downloader.c.h localh = (com.tencent.halley.downloader.c.h)localIterator.next();
          if (localh.t()) {
            l = localh.F() + l;
          }
        }
        else
        {
          return l;
        }
      }
    }
  }
  
  public final void f(b paramb)
  {
    if (j()) {
      this.c.a();
    }
    for (;;)
    {
      com.tencent.halley.common.c.a("TaskManager" + paramb, "onTaskFailedMainloop task:" + paramb + ",retCode:" + paramb.m() + ",failInfo:" + paramb.n());
      return;
      this.c.b();
    }
  }
  
  public final void g(b paramb)
  {
    if (j()) {
      this.c.a();
    }
    for (;;)
    {
      com.tencent.halley.common.c.a("TaskManager" + paramb, "onTaskCompletedMainloop task:" + paramb);
      return;
      this.c.b();
    }
  }
  
  public final boolean g()
  {
    return f() > 4194304L;
  }
  
  public final void h(b paramb) {}
  
  public final boolean h()
  {
    return f() < 2097152L;
  }
  
  public final void i(b paramb) {}
  
  public final void j(b paramb) {}
  
  public final void k(b paramb)
  {
    a((com.tencent.halley.downloader.c.h)paramb, 2);
  }
  
  public final void l(b paramb)
  {
    a((com.tencent.halley.downloader.c.h)paramb, 1);
  }
  
  public final void m(b paramb)
  {
    a((com.tencent.halley.downloader.c.h)paramb, 0);
  }
  
  public final void n(b arg1)
  {
    com.tencent.halley.downloader.c.h localh;
    Object localObject1;
    if ((??? == null) || (!(??? instanceof com.tencent.halley.downloader.c.h)))
    {
      ??? = "param task not illegal.";
      if (!"".equals(???)) {
        throw new DownloaderAddTaskException(???);
      }
    }
    else
    {
      localh = (com.tencent.halley.downloader.c.h)???;
      for (;;)
      {
        try
        {
          if (j.a(localh.i)) {
            localh.i = "";
          }
          if (!h.c(localh.i)) {
            break label290;
          }
          localObject1 = c().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label283;
          }
          ??? = (b)((Iterator)localObject1).next();
          if (!localh.h.equalsIgnoreCase(???.h())) {
            continue;
          }
          String str = localh.i;
          if (((com.tencent.halley.downloader.c.h)???).r())
          {
            ??? = ???.i();
            if (!str.equalsIgnoreCase(???)) {
              continue;
            }
            ??? = "Can not add new task, another task exists with the same path:" + localh.h + "/" + localh.i;
            localObject1 = ???;
            if ("".equals(???)) {
              break label211;
            }
            break;
          }
        }
        finally {}
        ??? = ???.j();
      }
    }
    for (;;)
    {
      label211:
      synchronized (this.b)
      {
        this.b.add(localh);
      }
      return;
      label283:
      ??? = "";
      break;
      label290:
      ??? = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.y
 * JD-Core Version:    0.7.0.1
 */