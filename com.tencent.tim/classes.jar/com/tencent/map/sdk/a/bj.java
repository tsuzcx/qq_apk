package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class bj
{
  private static int d = 20;
  protected AtomicInteger a = new AtomicInteger(0);
  public AtomicInteger b = new AtomicInteger(0);
  public int c;
  private Handler e;
  private bp f;
  private AtomicInteger g = new AtomicInteger(0);
  private List<String> h = new ArrayList();
  private volatile boolean i = false;
  private volatile boolean j = false;
  private int k = 0;
  private long l = 0L;
  private AtomicInteger m = new AtomicInteger(0);
  private volatile boolean n = false;
  private bp.a o = new bm(this);
  private final Runnable p = new bn(this);
  private final Runnable q = new bo(this);
  
  public bj()
  {
    bq.a(ac.a());
    HandlerThread localHandlerThread = new HandlerThread("halley_" + ac.c() + "_" + "ReportAction", 10);
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
    this.f = new bk();
    b(true, false);
    this.c = a();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (;;)
    {
      try
      {
        b(false, true);
        if (!this.i) {
          break label49;
        }
        if (paramBoolean1) {
          this.j = true;
        }
        return;
      }
      finally {}
      b(false, false);
      continue;
      label49:
      if (!paramBoolean1) {
        this.g.set(0);
      }
      if ((this.l != 0L) && (SystemClock.elapsedRealtime() - this.l < this.k * 60 * 1000))
      {
        this.h.clear();
      }
      else
      {
        this.i = true;
        try
        {
          new d(paramBoolean1, paramBoolean2).a(true);
        }
        catch (Throwable localThrowable)
        {
          this.i = false;
        }
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      if (this.m.get() > 3) {
        this.m.set(0);
      }
    }
    do
    {
      return;
      ay.a().a(this.p, false, as.a("report_real_timer_interval", 1, 60, 5) * 1000);
      return;
      if (paramBoolean1)
      {
        ay.a().a(this.q, false, 10000L);
        return;
      }
    } while (this.n);
    ay.a().a(this.q, false, as.a("report_timer_interval", 30000, 600000, 300000));
  }
  
  public abstract int a();
  
  public abstract String b();
  
  public abstract class a
    implements Runnable
  {
    private a() {}
    
    public final void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (!bj.a(bj.this).postAtFrontOfQueue(this)) {
          bj.a(bj.this).post(this);
        }
        return;
      }
      bj.a(bj.this).post(this);
    }
  }
  
  public final class b
    extends bj.a
  {
    private String a;
    private boolean b;
    private boolean c;
    
    public b(String paramString)
    {
      super((byte)0);
      this.a = paramString;
      this.b = false;
      this.c = true;
    }
    
    public final void run()
    {
      bj.b(bj.this).decrementAndGet();
      if (TextUtils.isEmpty(this.a)) {}
      label125:
      do
      {
        int i;
        do
        {
          return;
          i = as.a("report_new_record_num", 1, 50, 10);
          if (this.b) {
            break label125;
          }
          if (bs.a(bj.this.b()).b(this.a) == -1L) {
            break;
          }
          if (bj.c(bj.this))
          {
            bj.a(bj.this, false);
            bj.b(bj.this, false);
          }
        } while (bj.d(bj.this).incrementAndGet() < i);
        bj.a(bj.this, this.b, this.c);
        return;
        bj.c();
        return;
        bj.e(bj.this).add(this.a);
        if (!this.c) {
          break;
        }
        if (bj.e(bj.this).size() >= i)
        {
          bj.f(bj.this).set(1);
          bj.a(bj.this, this.b, this.c);
          return;
        }
      } while (bj.f(bj.this).get() != 0);
      bj.f(bj.this).set(1);
      bj.b(bj.this, true);
      return;
      bj.a(bj.this, this.b, this.c);
    }
  }
  
  final class c
    extends bj.a
  {
    private bj.d a;
    
    public c(bj.d paramd)
    {
      super((byte)0);
      this.a = paramd;
    }
    
    public final void run()
    {
      bj.g(bj.this);
      bj.a(bj.this, SystemClock.elapsedRealtime());
      int j;
      int i;
      if (this.a.d)
      {
        if (bj.j(bj.this) > 0) {
          bj.k(bj.this);
        }
        bj.this.a.addAndGet(this.a.f);
        if (!this.a.b)
        {
          j = this.a.e.size();
          ArrayList localArrayList = new ArrayList();
          i = 0;
          while (i < j)
          {
            localArrayList.add(Long.valueOf(((bs.a)this.a.e.get(i)).a));
            i += 1;
          }
          bs.a(bj.this.b()).a(localArrayList);
          if (bj.l(bj.this))
          {
            bj.m(bj.this);
            bj.a(bj.this, true, this.a.c);
          }
        }
      }
      label363:
      label372:
      for (;;)
      {
        return;
        if (!this.a.a)
        {
          SystemClock.sleep(200L);
          bj.a(bj.this, this.a.b, this.a.c);
          return;
        }
        bj.a(bj.this, true);
        return;
        if (ao.i())
        {
          if (bj.j(bj.this) <= 0) {
            break label363;
          }
          i = as.a("report_interval_forbid_limit", 30, 1440, 60);
          if (bj.j(bj.this) < i) {
            bj.n(bj.this);
          }
        }
        for (;;)
        {
          if ((!this.a.c) || (!this.a.b)) {
            break label372;
          }
          j = this.a.e.size();
          i = 0;
          while (i < j)
          {
            bs.a(bj.this.b()).b(((bs.a)this.a.e.get(i)).b);
            i += 1;
          }
          break;
          bj.o(bj.this);
        }
      }
    }
  }
  
  final class d
    extends bj.a
  {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d = false;
    public List<bs.a> e;
    int f;
    private int g;
    
    public d(boolean paramBoolean1, boolean paramBoolean2)
    {
      super((byte)0);
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.g = 0;
    }
    
    public final void run()
    {
      Object localObject2 = null;
      Object localObject1 = null;
      int k = 0;
      this.a = false;
      bj.a(as.a("report_max_report_count", 10, 100, 20));
      if (this.b)
      {
        int m = bj.e(bj.this).size();
        if (m == 0) {}
        for (;;)
        {
          this.e = ((List)localObject1);
          if ((this.e != null) && (this.e.size() != 0)) {
            break;
          }
          bj.g(bj.this);
          return;
          localObject2 = new ArrayList();
          localObject1 = new ArrayList();
          i = 0;
          int j = 0;
          while ((i < m) && (j < bj.d()))
          {
            String str = (String)bj.e(bj.this).get(i);
            ((List)localObject1).add(new bs.a(0L, str));
            ((List)localObject2).add(str);
            j += 1;
            i += 1;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            bj.e(bj.this).remove(((List)localObject2).get(i));
            i += 1;
          }
          if (bj.e(bj.this).size() == 0) {
            this.a = true;
          }
        }
      }
      int i = as.a("report_clear_db_num", 1, 10000, 1000);
      if (bs.a(bj.this.b()).a(i)) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        this.e = ((List)localObject1);
        break;
        localObject1 = bs.a(bj.this.b()).b(bj.d() + 1);
        if (((List)localObject1).size() <= bj.d())
        {
          this.a = true;
          bj.a(bj.this, true);
        }
        else
        {
          ((List)localObject1).remove(((List)localObject1).size() - 1);
        }
      }
      localObject1 = new StringBuilder();
      i = k;
      while (i < this.e.size())
      {
        ((StringBuilder)localObject1).append(((bs.a)this.e.get(i)).b).append("\n");
        i += 1;
      }
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = localObject2;
      if (this.b)
      {
        localObject1 = localObject2;
        if (((String)localObject2).contains("client_report_time")) {
          localObject1 = ((String)localObject2).replace("client_report_time", dg.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        }
      }
      localObject1 = ((String)localObject1).getBytes();
      i = localObject1.length;
      this.f = i;
      localObject1 = as.a((byte[])localObject1);
      bj.b(localObject1.length);
      bj.i(bj.this).a((byte[])localObject1, i, this.b, this, bj.h(bj.this), this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.bj
 * JD-Core Version:    0.7.0.1
 */