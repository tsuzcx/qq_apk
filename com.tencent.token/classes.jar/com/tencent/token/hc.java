package com.tencent.token;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class hc
{
  final ArrayList<ez> a = new ArrayList();
  fa b;
  boolean c;
  private long d = -1L;
  private Interpolator e;
  private final fb f = new fb()
  {
    private boolean b = false;
    private int c = 0;
    
    public final void a(View paramAnonymousView)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      if (hc.this.b != null) {
        hc.this.b.a(null);
      }
    }
    
    public final void b(View paramAnonymousView)
    {
      int i = this.c + 1;
      this.c = i;
      if (i == hc.this.a.size())
      {
        if (hc.this.b != null) {
          hc.this.b.b(null);
        }
        this.c = 0;
        this.b = false;
        hc.this.c = false;
      }
    }
  };
  
  public final hc a(Interpolator paramInterpolator)
  {
    if (!this.c) {
      this.e = paramInterpolator;
    }
    return this;
  }
  
  public final hc a(ez paramez)
  {
    if (!this.c) {
      this.a.add(paramez);
    }
    return this;
  }
  
  public final hc a(ez paramez1, ez paramez2)
  {
    this.a.add(paramez1);
    paramez2.b(paramez1.a());
    this.a.add(paramez2);
    return this;
  }
  
  public final hc a(fa paramfa)
  {
    if (!this.c) {
      this.b = paramfa;
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
      ez localez = (ez)localIterator.next();
      long l = this.d;
      if (l >= 0L) {
        localez.a(l);
      }
      Interpolator localInterpolator = this.e;
      if (localInterpolator != null) {
        localez.a(localInterpolator);
      }
      if (this.b != null) {
        localez.a(this.f);
      }
      localez.c();
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
      ((ez)localIterator.next()).b();
    }
    this.c = false;
  }
  
  public final hc c()
  {
    if (!this.c) {
      this.d = 250L;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hc
 * JD-Core Version:    0.7.0.1
 */