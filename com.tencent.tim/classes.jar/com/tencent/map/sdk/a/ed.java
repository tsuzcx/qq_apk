package com.tencent.map.sdk.a;

import java.io.IOException;

public final class ed<T>
  extends ee<T>
{
  private final ea<T> a;
  private final ds<T> b;
  private final dn c;
  private final fd<T> d;
  private final ef e;
  private ee<T> f;
  
  private ed(ea<T> paramea, ds<T> paramds, dn paramdn, fd<T> paramfd, ef paramef)
  {
    this.a = paramea;
    this.b = paramds;
    this.c = paramdn;
    this.d = paramfd;
    this.e = paramef;
  }
  
  private ee<T> a()
  {
    ee localee = this.f;
    if (localee != null) {
      return localee;
    }
    localee = this.c.a(this.e, this.d);
    this.f = localee;
    return localee;
  }
  
  public static ef a(fd<?> paramfd, Object paramObject)
  {
    return new a(paramObject, paramfd, false, (byte)0);
  }
  
  public final T a(fe paramfe)
    throws IOException
  {
    if (this.b == null) {
      return a().a(paramfe);
    }
    paramfe = ep.a(paramfe);
    if ((paramfe instanceof dv)) {
      return null;
    }
    return this.b.a(paramfe, this.d.b, this.c.a);
  }
  
  public final void a(fg paramfg, T paramT)
    throws IOException
  {
    if (this.a == null)
    {
      a().a(paramfg, paramT);
      return;
    }
    if (paramT == null)
    {
      paramfg.e();
      return;
    }
    ep.a(this.a.a(paramT), paramfg);
  }
  
  static final class a
    implements ef
  {
    private final fd<?> a;
    private final boolean b;
    private final Class<?> c;
    private final ea<?> d;
    private final ds<?> e;
    
    private a(Object paramObject, fd<?> paramfd, boolean paramBoolean)
    {
      ea localea;
      if ((paramObject instanceof ea))
      {
        localea = (ea)paramObject;
        this.d = localea;
        if (!(paramObject instanceof ds)) {
          break label84;
        }
        paramObject = (ds)paramObject;
        label35:
        this.e = paramObject;
        if ((this.d == null) && (this.e == null)) {
          break label89;
        }
      }
      label84:
      label89:
      for (boolean bool = true;; bool = false)
      {
        eg.a(bool);
        this.a = paramfd;
        this.b = paramBoolean;
        this.c = null;
        return;
        localea = null;
        break;
        paramObject = null;
        break label35;
      }
    }
    
    public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
    {
      boolean bool;
      if (this.a != null) {
        if ((this.a.equals(paramfd)) || ((this.b) && (this.a.b == paramfd.a))) {
          bool = true;
        }
      }
      while (bool)
      {
        return new ed(this.d, this.e, paramdn, paramfd, this, (byte)0);
        bool = false;
        continue;
        bool = this.c.isAssignableFrom(paramfd.a);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ed
 * JD-Core Version:    0.7.0.1
 */