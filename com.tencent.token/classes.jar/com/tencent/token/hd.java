package com.tencent.token;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class hd
{
  final ArrayList<fa> a = new ArrayList();
  fb b;
  boolean c;
  private long d = -1L;
  private Interpolator e;
  private final fc f = new fc()
  {
    private boolean b = false;
    private int c = 0;
    
    public final void a(View paramAnonymousView)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      if (hd.this.b != null) {
        hd.this.b.a(null);
      }
    }
    
    public final void b(View paramAnonymousView)
    {
      int i = this.c + 1;
      this.c = i;
      if (i == hd.this.a.size())
      {
        if (hd.this.b != null) {
          hd.this.b.b(null);
        }
        this.c = 0;
        this.b = false;
        hd.this.c = false;
      }
    }
  };
  
  public final hd a(Interpolator paramInterpolator)
  {
    if (!this.c) {
      this.e = paramInterpolator;
    }
    return this;
  }
  
  public final hd a(fa paramfa)
  {
    if (!this.c) {
      this.a.add(paramfa);
    }
    return this;
  }
  
  public final hd a(fa paramfa1, fa paramfa2)
  {
    this.a.add(paramfa1);
    paramfa2.b(paramfa1.a());
    this.a.add(paramfa2);
    return this;
  }
  
  public final hd a(fb paramfb)
  {
    if (!this.c) {
      this.b = paramfb;
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
      fa localfa = (fa)localIterator.next();
      long l = this.d;
      if (l >= 0L) {
        localfa.a(l);
      }
      Interpolator localInterpolator = this.e;
      if (localInterpolator != null) {
        localfa.a(localInterpolator);
      }
      if (this.b != null) {
        localfa.a(this.f);
      }
      localfa.c();
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
      ((fa)localIterator.next()).b();
    }
    this.c = false;
  }
  
  public final hd c()
  {
    if (!this.c) {
      this.d = 250L;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hd
 * JD-Core Version:    0.7.0.1
 */