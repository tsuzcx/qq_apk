package com.tencent.token;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.f;
import com.tencent.halley.common.g;
import com.tencent.halley.common.h;
import com.tencent.halley.downloader.c;
import com.tencent.halley.downloader.exceptions.DownloaderAddTaskException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

public final class x
  implements c, aa, p.a
{
  private static x a = null;
  private Vector b = new Vector();
  private z c = new z(this);
  
  private x()
  {
    p.a(this);
  }
  
  public static x a()
  {
    try
    {
      if (a == null) {
        a = new x();
      }
      x localx = a;
      return localx;
    }
    finally {}
  }
  
  private void a(com.tencent.halley.downloader.c.e parame, int paramInt)
  {
    int j = 1;
    if (parame == null) {
      return;
    }
    try
    {
      com.tencent.halley.common.b.b("TaskManager", "reportResult task:" + parame.c() + ", result:" + paramInt + ",costTime:" + parame.j + ",receivedLen:" + parame.f() + ",totalLen:" + parame.a_() + ",flow:" + parame.o);
      if (!k.e)
      {
        com.tencent.halley.common.b.c("TaskManager", "reportResult missed for EnableUserAction:" + k.e);
        return;
      }
    }
    catch (Throwable parame)
    {
      parame = parame;
      parame.printStackTrace();
      return;
    }
    finally {}
    HashMap localHashMap = new HashMap();
    localHashMap.put("B1", parame.n);
    localHashMap.put("B2", h.e());
    localHashMap.put("B3", h.f());
    localHashMap.put("B4", h.g());
    if (!TextUtils.isEmpty(k.a)) {
      localHashMap.put("B5", k.a);
    }
    localHashMap.put("B6", f.f());
    if (!TextUtils.isEmpty(parame.c)) {
      localHashMap.put("B7", parame.c);
    }
    if (!TextUtils.isEmpty(parame.d)) {
      localHashMap.put("B8", parame.d);
    }
    if (!TextUtils.isEmpty(k.b)) {
      localHashMap.put("B9", k.b);
    }
    if (!TextUtils.isEmpty(k.c)) {
      localHashMap.put("B10", k.c);
    }
    localHashMap.put("C11", com.tencent.halley.common.e.b());
    localHashMap.put("C12", com.tencent.halley.common.e.a());
    localHashMap.put("C13", parame.s());
    localHashMap.put("B14", parame.q());
    localHashMap.put("B15", parame.j);
    long l1 = System.currentTimeMillis();
    localHashMap.put("C16", parame.t);
    localHashMap.put("C17", l1);
    localHashMap.put("B18", parame.a);
    localHashMap.put("B19", parame.b);
    localHashMap.put("C20", h.b(parame.n()));
    localHashMap.put("C81", parame.F.toString());
    int i = parame.m();
    if (paramInt == 0) {
      i = 0;
    }
    localHashMap.put("B21", i);
    localHashMap.put("B22", paramInt);
    localHashMap.put("B23", parame.M());
    if (!TextUtils.isEmpty(parame.z)) {
      localHashMap.put("B24", parame.z);
    }
    localHashMap.put("B25", p.e());
    localHashMap.put("C26", parame.J());
    localHashMap.put("C27", parame.A);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parame.o())
    {
      i = 1;
      localHashMap.put("B28", i);
      boolean bool = parame.z();
      localStringBuilder = new StringBuilder();
      if (!bool) {
        break label1515;
      }
    }
    label1515:
    for (i = j;; i = 0)
    {
      localHashMap.put("B32", new String(i));
      localHashMap.put("B33", parame.H());
      localHashMap.put("B34", parame.G());
      localHashMap.put("C37", parame.K());
      if (paramInt != 0) {
        parame.v = SystemClock.elapsedRealtime();
      }
      long l2 = -1L;
      l1 = l2;
      if (parame.u > 0L)
      {
        l1 = l2;
        if (parame.v > parame.u) {
          l1 = parame.v - parame.u;
        }
      }
      localHashMap.put("B38", l1);
      localHashMap.put("B41", parame.f());
      localHashMap.put("B44", parame.o);
      localHashMap.put("B45", parame.p.getAndSet(0L));
      if (parame.x) {
        localHashMap.put("B46", "1");
      }
      if (paramInt == 0) {
        localHashMap.put("C48", parame.A());
      }
      localHashMap.put("B60", i());
      localHashMap.put("B66", parame.B());
      localHashMap.put("C73", parame.E());
      localHashMap.put("C72", parame.D());
      if (parame.C()) {
        localHashMap.put("C74", "1");
      }
      if ((paramInt == 0) && (parame.B > 0L)) {
        localHashMap.put("B77", parame.B);
      }
      localHashMap.put("C78", parame.L());
      localHashMap.put("C79", parame.I());
      if (!TextUtils.isEmpty(parame.y)) {
        localHashMap.put("C80", parame.y);
      }
      if (!TextUtils.isEmpty(parame.D))
      {
        localHashMap.put("C82", parame.D);
        localHashMap.put("B83", parame.E);
      }
      g.a("B_DLSDK_Result", true, 0L, 0L, localHashMap, true);
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
        com.tencent.halley.downloader.c.e locale = (com.tencent.halley.downloader.c.e)localIterator.next();
        if ((locale.t()) || (locale.u())) {
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
        ((com.tencent.halley.downloader.c.e)((Iterator)localObject).next()).a(paramInt, paramString);
      }
    }
  }
  
  public final void a(com.tencent.halley.downloader.b paramb) {}
  
  public final void a(com.tencent.halley.downloader.b paramb, boolean paramBoolean)
  {
    if (paramb == null) {
      return;
    }
    com.tencent.halley.common.b.b("TaskManager", "delete task:" + paramb.c());
    ((com.tencent.halley.downloader.c.e)paramb).a(paramBoolean);
    synchronized (this.b)
    {
      this.b.remove(paramb);
      a((com.tencent.halley.downloader.c.e)paramb, 3);
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
  
  public final void b(com.tencent.halley.downloader.b paramb)
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
  
  public final void c(com.tencent.halley.downloader.b paramb)
  {
    com.tencent.halley.common.b.a("TaskManager" + paramb, "onTaskDetectedMainloop task:" + paramb + ",detectLen:" + paramb.a_());
  }
  
  public final List d()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.halley.downloader.c.e locale = (com.tencent.halley.downloader.c.e)localIterator.next();
        if (locale.t()) {
          localLinkedList.add(locale);
        }
      }
    }
    return localList;
  }
  
  public final void d(com.tencent.halley.downloader.b paramb)
  {
    com.tencent.halley.common.b.a("TaskManager" + paramb, "onTaskReceivedMainloop task:" + paramb + ",detectLen:" + paramb.a_() + ",receivedLen:" + paramb.f() + ",percentage:" + paramb.g());
  }
  
  public final void e(com.tencent.halley.downloader.b paramb)
  {
    if (j()) {
      this.c.a();
    }
    for (;;)
    {
      com.tencent.halley.common.b.a("TaskManager" + paramb, "onTaskPausedMainloop task:" + paramb);
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
      com.tencent.halley.downloader.c.e locale = (com.tencent.halley.downloader.c.e)((Iterator)localObject).next();
      locale.a(i);
      if (!locale.e()) {
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
          com.tencent.halley.downloader.c.e locale = (com.tencent.halley.downloader.c.e)localIterator.next();
          if (locale.t()) {
            l = locale.F() + l;
          }
        }
        else
        {
          return l;
        }
      }
    }
  }
  
  public final void f(com.tencent.halley.downloader.b paramb)
  {
    if (j()) {
      this.c.a();
    }
    for (;;)
    {
      com.tencent.halley.common.b.a("TaskManager" + paramb, "onTaskFailedMainloop task:" + paramb + ",retCode:" + paramb.m() + ",failInfo:" + paramb.n());
      return;
      this.c.b();
    }
  }
  
  public final void g(com.tencent.halley.downloader.b paramb)
  {
    if (j()) {
      this.c.a();
    }
    for (;;)
    {
      com.tencent.halley.common.b.a("TaskManager" + paramb, "onTaskCompletedMainloop task:" + paramb);
      return;
      this.c.b();
    }
  }
  
  public final boolean g()
  {
    return f() > 4194304L;
  }
  
  public final void h(com.tencent.halley.downloader.b paramb) {}
  
  public final boolean h()
  {
    return f() < 2097152L;
  }
  
  public final void i(com.tencent.halley.downloader.b paramb) {}
  
  public final void j(com.tencent.halley.downloader.b paramb) {}
  
  public final void k(com.tencent.halley.downloader.b paramb)
  {
    a((com.tencent.halley.downloader.c.e)paramb, 2);
  }
  
  public final void l(com.tencent.halley.downloader.b paramb)
  {
    a((com.tencent.halley.downloader.c.e)paramb, 1);
  }
  
  public final void m(com.tencent.halley.downloader.b paramb)
  {
    a((com.tencent.halley.downloader.c.e)paramb, 0);
  }
  
  public final void n(com.tencent.halley.downloader.b arg1)
  {
    com.tencent.halley.downloader.c.e locale;
    Object localObject1;
    if ((??? == null) || (!(??? instanceof com.tencent.halley.downloader.c.e)))
    {
      ??? = "param task not illegal.";
      if (!"".equals(???)) {
        throw new DownloaderAddTaskException(???);
      }
    }
    else
    {
      locale = (com.tencent.halley.downloader.c.e)???;
      for (;;)
      {
        try
        {
          if (h.a(locale.i)) {
            locale.i = "";
          }
          if (!k.c(locale.i)) {
            break label290;
          }
          localObject1 = c().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label283;
          }
          ??? = (com.tencent.halley.downloader.b)((Iterator)localObject1).next();
          if (!locale.h.equalsIgnoreCase(???.h())) {
            continue;
          }
          String str = locale.i;
          if (((com.tencent.halley.downloader.c.e)???).r())
          {
            ??? = ???.i();
            if (!str.equalsIgnoreCase(???)) {
              continue;
            }
            ??? = "Can not add new task, another task exists with the same path:" + locale.h + "/" + locale.i;
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
        this.b.add(locale);
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
 * Qualified Name:     com.tencent.token.x
 * JD-Core Version:    0.7.0.1
 */