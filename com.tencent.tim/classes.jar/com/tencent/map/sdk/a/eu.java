package com.tencent.map.sdk.a;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class eu
  extends fe
{
  private static final Reader c = new eu.1();
  private static final Object d = new Object();
  public final List<Object> a = new ArrayList();
  
  public eu(dt paramdt)
  {
    super(c);
    this.a.add(paramdt);
  }
  
  private Object p()
  {
    return this.a.remove(this.a.size() - 1);
  }
  
  public final void a()
    throws IOException
  {
    a(ff.a);
    dq localdq = (dq)g();
    this.a.add(localdq.iterator());
  }
  
  public final void a(ff paramff)
    throws IOException
  {
    if (f() != paramff) {
      throw new IllegalStateException("Expected " + paramff + " but was " + f());
    }
  }
  
  public final void b()
    throws IOException
  {
    a(ff.b);
    p();
    p();
  }
  
  public final void c()
    throws IOException
  {
    a(ff.c);
    dw localdw = (dw)g();
    this.a.add(localdw.a.entrySet().iterator());
  }
  
  public final void close()
    throws IOException
  {
    this.a.clear();
    this.a.add(d);
  }
  
  public final void d()
    throws IOException
  {
    a(ff.d);
    p();
    p();
  }
  
  public final boolean e()
    throws IOException
  {
    ff localff = f();
    return (localff != ff.d) && (localff != ff.b);
  }
  
  public final ff f()
    throws IOException
  {
    Object localObject;
    boolean bool;
    for (;;)
    {
      if (this.a.isEmpty()) {
        return ff.j;
      }
      localObject = g();
      if (!(localObject instanceof Iterator)) {
        break label105;
      }
      bool = this.a.get(this.a.size() - 2) instanceof dw;
      localObject = (Iterator)localObject;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      if (bool) {
        return ff.e;
      }
      this.a.add(((Iterator)localObject).next());
    }
    if (bool) {
      return ff.d;
    }
    return ff.b;
    label105:
    if ((localObject instanceof dw)) {
      return ff.c;
    }
    if ((localObject instanceof dq)) {
      return ff.a;
    }
    if ((localObject instanceof dy))
    {
      localObject = (dy)localObject;
      if ((((dy)localObject).a instanceof String)) {
        return ff.f;
      }
      if ((((dy)localObject).a instanceof Boolean)) {
        return ff.h;
      }
      if ((((dy)localObject).a instanceof Number)) {
        return ff.g;
      }
      throw new AssertionError();
    }
    if ((localObject instanceof dv)) {
      return ff.i;
    }
    if (localObject == d) {
      throw new IllegalStateException("JsonReader is closed");
    }
    throw new AssertionError();
  }
  
  public final Object g()
  {
    return this.a.get(this.a.size() - 1);
  }
  
  public final String h()
    throws IOException
  {
    a(ff.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)g()).next();
    this.a.add(localEntry.getValue());
    return (String)localEntry.getKey();
  }
  
  public final String i()
    throws IOException
  {
    ff localff = f();
    if ((localff != ff.f) && (localff != ff.g)) {
      throw new IllegalStateException("Expected " + ff.f + " but was " + localff);
    }
    return ((dy)p()).c();
  }
  
  public final boolean j()
    throws IOException
  {
    a(ff.h);
    return ((dy)p()).h();
  }
  
  public final void k()
    throws IOException
  {
    a(ff.i);
    p();
  }
  
  public final double l()
    throws IOException
  {
    ff localff = f();
    if ((localff != ff.g) && (localff != ff.f)) {
      throw new IllegalStateException("Expected " + ff.g + " but was " + localff);
    }
    double d1 = ((dy)g()).d();
    if ((!this.b) && ((Double.isNaN(d1)) || (Double.isInfinite(d1)))) {
      throw new NumberFormatException("JSON forbids NaN and infinities: ".concat(String.valueOf(d1)));
    }
    p();
    return d1;
  }
  
  public final long m()
    throws IOException
  {
    ff localff = f();
    if ((localff != ff.g) && (localff != ff.f)) {
      throw new IllegalStateException("Expected " + ff.g + " but was " + localff);
    }
    long l = ((dy)g()).f();
    p();
    return l;
  }
  
  public final int n()
    throws IOException
  {
    ff localff = f();
    if ((localff != ff.g) && (localff != ff.f)) {
      throw new IllegalStateException("Expected " + ff.g + " but was " + localff);
    }
    int i = ((dy)g()).g();
    p();
    return i;
  }
  
  public final void o()
    throws IOException
  {
    if (f() == ff.e)
    {
      h();
      return;
    }
    p();
  }
  
  public final String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.eu
 * JD-Core Version:    0.7.0.1
 */