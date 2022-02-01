package com.tencent.token;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class hg
{
  final ArrayList<fd> a = new ArrayList();
  fe b;
  boolean c;
  private long d = -1L;
  private Interpolator e;
  private final ff f = new ff()
  {
    private boolean b = false;
    private int c = 0;
    
    public final void a(View paramAnonymousView)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      if (hg.this.b != null) {
        hg.this.b.a(null);
      }
    }
    
    public final void b(View paramAnonymousView)
    {
      int i = this.c + 1;
      this.c = i;
      if (i == hg.this.a.size())
      {
        if (hg.this.b != null) {
          hg.this.b.b(null);
        }
        this.c = 0;
        this.b = false;
        hg.this.c = false;
      }
    }
  };
  
  public final hg a(Interpolator paramInterpolator)
  {
    if (!this.c) {
      this.e = paramInterpolator;
    }
    return this;
  }
  
  public final hg a(fd paramfd)
  {
    if (!this.c) {
      this.a.add(paramfd);
    }
    return this;
  }
  
  public final hg a(fd paramfd1, fd paramfd2)
  {
    this.a.add(paramfd1);
    paramfd2.b(paramfd1.a());
    this.a.add(paramfd2);
    return this;
  }
  
  public final hg a(fe paramfe)
  {
    if (!this.c) {
      this.b = paramfe;
    }
    return this;
  }
  
  public final void a()
  {
    if (this.c) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      fd localfd = (fd)localIterator.next();
      long l = this.d;
      if (l >= 0L) {
        localfd.a(l);
      }
      Interpolator localInterpolator = this.e;
      if (localInterpolator != null) {
        localfd.a(localInterpolator);
      }
      if (this.b != null) {
        localfd.a(this.f);
      }
      localfd.c();
    }
    this.c = true;
  }
  
  public final void b()
  {
    if (!this.c) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((fd)localIterator.next()).b();
    }
    this.c = false;
  }
  
  public final hg c()
  {
    if (!this.c) {
      this.d = 250L;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hg
 * JD-Core Version:    0.7.0.1
 */