package com.tencent.tencentmap.mapsdk.map;

import java.util.List;

final class m
{
  t.a a = new t.a()
  {
    public final void a()
    {
      if (m.a(m.this) == null) {}
      for (;;)
      {
        return;
        if ((m.a(m.this).b != null) && (m.a(m.this).b.a != null))
        {
          int j;
          synchronized (m.a(m.this).b.d)
          {
            j = m.a(m.this).b.a.size();
            if (j <= 0) {
              return;
            }
          }
          int i = 0;
          while ((i < j) && (m.a(m.this) != null) && (m.a(m.this).b != null) && (m.a(m.this).b.a != null))
          {
            synchronized (m.a(m.this).b.d)
            {
              if (m.a(m.this).b.a.size() != j)
              {
                m.this.a();
                return;
              }
            }
            i locali = (i)m.a(m.this).b.a.get(i);
            if ((locali != null) && (locali.m)) {
              locali.c();
            }
            i += 1;
          }
        }
      }
    }
  };
  t.a b = new t.a()
  {
    public final void a()
    {
      if (m.a(m.this) == null) {}
      for (;;)
      {
        return;
        if ((m.a(m.this).b != null) && (m.a(m.this).b.a != null))
        {
          if (m.a(m.this).b.b != null)
          {
            ??? = null;
            synchronized (m.a(m.this).b.e)
            {
              if (m.a(m.this).b.b.size() > 0) {
                ??? = (f)m.a(m.this).b.b.remove(0);
              }
              if ((??? == null) || (q.a != q.a.c) || (q.a((f)???))) {}
            }
          }
          int j;
          synchronized (m.a(m.this).b.e)
          {
            m.a(m.this).b.b.add(???);
            m.this.a(1);
            synchronized (m.a(m.this).b.d)
            {
              j = m.a(m.this).b.a.size();
              if (j > 0) {
                break label253;
              }
              return;
            }
            localObject2 = finally;
            throw localObject2;
          }
          label253:
          int i = 0;
          while (i < j)
          {
            synchronized (m.a(m.this).b.d)
            {
              if (m.a(m.this).b.a.size() != j)
              {
                m.this.a(1);
                return;
              }
            }
            i locali = (i)m.a(m.this).b.a.get(i);
            if (locali != null) {
              locali.g();
            }
            i += 1;
          }
        }
      }
    }
  };
  private t c = null;
  private t d = null;
  private n e;
  
  public m(n paramn)
  {
    this.e = paramn;
    this.c = new t(1, this.a);
    this.d = new t(2, this.b);
    this.c.a();
    this.d.a();
  }
  
  public final void a()
  {
    if (this.e.a.d == true) {
      return;
    }
    this.c.a(1);
  }
  
  public final void a(int paramInt)
  {
    if (this.e.a.d == true) {
      return;
    }
    this.d.a(paramInt);
  }
  
  public final void b()
  {
    this.d.b();
    this.c.c();
    this.b = null;
    this.a = null;
  }
  
  public final void c()
  {
    int j = this.e.b.a.size();
    int i = 0;
    while (i < j)
    {
      i locali = (i)this.e.b.a.get(i);
      if (locali != null) {
        locali.a();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.m
 * JD-Core Version:    0.7.0.1
 */