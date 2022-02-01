package com.tencent.beacon.event;

import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g
  implements com.tencent.beacon.a.a.d, Runnable
{
  private final String a;
  private final int b;
  private final com.tencent.beacon.event.a.a c;
  private final Set<Long> d = new HashSet();
  private final Set<Long> e = new HashSet();
  private final String f;
  private boolean g;
  private int h;
  private boolean i;
  private String j;
  
  public g(int paramInt, com.tencent.beacon.event.a.a parama, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = parama;
    this.g = paramBoolean;
    if (paramBoolean) {}
    for (parama = "t_r_e";; parama = "t_n_e")
    {
      this.a = parama;
      this.h = 48;
      this.f = ("[EventReport (" + this.a + ")]");
      return;
    }
  }
  
  private void a(List<EventBean> paramList, Set<Long> paramSet)
  {
    paramList = com.tencent.beacon.event.c.d.a(paramList, this.g);
    com.tencent.beacon.base.util.c.a(this.f, 2, "event request entity: %s", new Object[] { paramList.toString() });
    paramSet = new f(this, this.a, this.c, paramSet, this.j);
    com.tencent.beacon.base.net.c.c().b(paramList).a(paramSet);
  }
  
  private List<EventBean> b()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append((Long)localIterator.next()).append(",");
    }
    if (((StringBuilder)localObject).length() > 0) {}
    for (localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).lastIndexOf(","));; localObject = "") {
      return this.c.a(this.a, (String)localObject, this.h);
    }
  }
  
  private void c()
  {
    com.tencent.beacon.a.a.b.a().a(2, this);
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a(Set<Long> paramSet)
  {
    synchronized (this.d)
    {
      this.d.removeAll(paramSet);
      paramSet.clear();
      return;
    }
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    if (paramc.a == 2)
    {
      paramc = (Map)paramc.b.get("d_m");
      if (paramc != null)
      {
        if (!this.g) {
          break label61;
        }
        this.h = com.tencent.beacon.base.util.b.a((String)paramc.get("realtimeUploadNum"), this.h, 24, 100);
      }
    }
    return;
    label61:
    this.h = com.tencent.beacon.base.util.b.a((String)paramc.get("normalUploadNum"), this.h, 24, 100);
    com.tencent.beacon.base.util.c.a("normal uploadNum has changed to " + this.h, new Object[0]);
  }
  
  public void run()
  {
    if (!this.i)
    {
      c();
      this.i = true;
    }
    if ((!com.tencent.beacon.base.net.b.d.d()) || (com.tencent.beacon.base.net.c.c().d()))
    {
      com.tencent.beacon.a.b.a.a().a(this.b, false);
      return;
    }
    List localList;
    synchronized (this.d)
    {
      String str1 = this.f;
      com.tencent.beacon.base.util.c.a(str1, 0, "start read EventBean from DB.", new Object[0]);
      localList = b();
      if ((localList == null) || (localList.isEmpty()))
      {
        str1 = this.f;
        com.tencent.beacon.base.util.c.a(str1, 1, "EventBean List == null. Task end!", new Object[0]);
        com.tencent.beacon.a.b.a.a().a(this.b, false);
        return;
      }
    }
    Object localObject3 = new HashMap();
    Object localObject4 = localList.iterator();
    Object localObject2;
    Object localObject5;
    String str2;
    while (((Iterator)localObject4).hasNext())
    {
      localObject2 = (EventBean)((Iterator)localObject4).next();
      long l = ((EventBean)localObject2).getCid();
      this.d.add(Long.valueOf(l));
      this.e.add(Long.valueOf(l));
      localObject5 = ((EventBean)localObject2).getEventValue();
      if (localObject5 != null)
      {
        str2 = ((EventBean)localObject2).getAppKey();
        localObject2 = (String)((Map)localObject3).get(str2);
        if (localObject2 != null) {
          break label444;
        }
        localObject2 = new StringBuilder().append(str2);
        localObject2 = ": ";
      }
    }
    label444:
    for (;;)
    {
      localObject5 = (String)((Map)localObject5).get("A100");
      localObject2 = new StringBuilder().append((String)localObject2).append((String)localObject5);
      ((Map)localObject3).put(str2, ", ");
      break;
      localObject2 = new StringBuilder("--logID: \n");
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((StringBuilder)localObject2).append((String)((Map.Entry)((Iterator)localObject3).next()).getValue());
        ((StringBuilder)localObject4).append("\n");
      }
      this.j = ((StringBuilder)localObject2).toString();
      localObject2 = this.f;
      com.tencent.beacon.base.util.c.a((String)localObject2, 1, "send LogID: %s", new Object[] { this.j });
      a(localList, this.e);
      localList.clear();
      this.e.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.g
 * JD-Core Version:    0.7.0.1
 */