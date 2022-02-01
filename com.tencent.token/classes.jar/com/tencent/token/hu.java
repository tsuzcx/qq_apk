package com.tencent.token;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class hu
{
  final ArrayList<fr> a = new ArrayList();
  fs b;
  boolean c;
  private long d = -1L;
  private Interpolator e;
  private final ft f = new ft()
  {
    private boolean b = false;
    private int c = 0;
    
    public final void a(View paramAnonymousView)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      if (hu.this.b != null) {
        hu.this.b.a(null);
      }
    }
    
    public final void b(View paramAnonymousView)
    {
      int i = this.c + 1;
      this.c = i;
      if (i == hu.this.a.size())
      {
        if (hu.this.b != null) {
          hu.this.b.b(null);
        }
        this.c = 0;
        this.b = false;
        hu.this.c = false;
      }
    }
  };
  
  public final hu a(Interpolator paramInterpolator)
  {
    if (!this.c) {
      this.e = paramInterpolator;
    }
    return this;
  }
  
  public final hu a(fr paramfr)
  {
    if (!this.c) {
      this.a.add(paramfr);
    }
    return this;
  }
  
  public final hu a(fr paramfr1, fr paramfr2)
  {
    this.a.add(paramfr1);
    paramfr2.b(paramfr1.a());
    this.a.add(paramfr2);
    return this;
  }
  
  public final hu a(fs paramfs)
  {
    if (!this.c) {
      this.b = paramfs;
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
      fr localfr = (fr)localIterator.next();
      long l = this.d;
      if (l >= 0L) {
        localfr.a(l);
      }
      Interpolator localInterpolator = this.e;
      if (localInterpolator != null) {
        localfr.a(localInterpolator);
      }
      if (this.b != null) {
        localfr.a(this.f);
      }
      localfr.c();
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
      ((fr)localIterator.next()).b();
    }
    this.c = false;
  }
  
  public final hu c()
  {
    if (!this.c) {
      this.d = 250L;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hu
 * JD-Core Version:    0.7.0.1
 */