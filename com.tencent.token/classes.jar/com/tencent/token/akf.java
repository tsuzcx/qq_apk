package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;

public final class akf
{
  long a = 0L;
  long b;
  final int c;
  final akd d;
  List<ajz> e;
  boolean f;
  final b g;
  final a h;
  final c i = new c();
  final c j = new c();
  ajy k = null;
  private final List<ajz> m;
  
  akf(int paramInt, akd paramakd, boolean paramBoolean1, boolean paramBoolean2, List<ajz> paramList)
  {
    if (paramakd != null)
    {
      if (paramList != null)
      {
        this.c = paramInt;
        this.d = paramakd;
        this.b = paramakd.m.b();
        this.g = new b(paramakd.l.b());
        this.h = new a();
        this.g.b = paramBoolean2;
        this.h.b = paramBoolean1;
        this.m = paramList;
        return;
      }
      throw new NullPointerException("requestHeaders == null");
    }
    throw new NullPointerException("connection == null");
  }
  
  private boolean d(ajy paramajy)
  {
    if ((!l) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.k != null) {
        return false;
      }
      if ((this.g.b) && (this.h.b)) {
        return false;
      }
      this.k = paramajy;
      notifyAll();
      this.d.b(this.c);
      return true;
    }
    finally {}
  }
  
  final void a(long paramLong)
  {
    this.b += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public final void a(ajy paramajy)
  {
    if (!d(paramajy)) {
      return;
    }
    this.d.b(this.c, paramajy);
  }
  
  public final boolean a()
  {
    try
    {
      ajy localajy = this.k;
      if (localajy != null) {
        return false;
      }
      if (((this.g.b) || (this.g.a)) && ((this.h.b) || (this.h.a)))
      {
        boolean bool = this.f;
        if (bool) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public final void b(ajy paramajy)
  {
    if (!d(paramajy)) {
      return;
    }
    this.d.a(this.c, paramajy);
  }
  
  public final boolean b()
  {
    int n;
    if ((this.c & 0x1) == 1) {
      n = 1;
    } else {
      n = 0;
    }
    return this.d.a == n;
  }
  
  public final List<ajz> c()
  {
    try
    {
      if (b())
      {
        this.i.b_();
        try
        {
          while ((this.e == null) && (this.k == null)) {
            h();
          }
          this.i.b();
          List localList = this.e;
          if (localList != null)
          {
            this.e = null;
            return localList;
          }
          throw new akk(this.k);
        }
        finally
        {
          this.i.b();
        }
      }
      throw new IllegalStateException("servers cannot read response headers");
    }
    finally {}
  }
  
  final void c(ajy paramajy)
  {
    try
    {
      if (this.k == null)
      {
        this.k = paramajy;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramajy = finally;
      throw paramajy;
    }
  }
  
  public final alo d()
  {
    try
    {
      if ((!this.f) && (!b())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
      return this.h;
    }
    finally {}
  }
  
  final void e()
  {
    if ((!l) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      this.g.b = true;
      boolean bool = a();
      notifyAll();
      if (!bool) {
        this.d.b(this.c);
      }
      return;
    }
    finally {}
  }
  
  final void f()
  {
    if ((!l) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        if ((this.g.b) || (!this.g.a)) {
          break label115;
        }
        if (this.h.b) {
          break label110;
        }
        if (!this.h.a) {
          break label115;
        }
      }
      finally {}
      boolean bool = a();
      if (n != 0)
      {
        a(ajy.f);
        return;
      }
      if (!bool) {
        this.d.b(this.c);
      }
      return;
      label110:
      int n = 1;
      continue;
      label115:
      n = 0;
    }
  }
  
  final void g()
  {
    if (!this.h.a)
    {
      if (!this.h.b)
      {
        ajy localajy = this.k;
        if (localajy == null) {
          return;
        }
        throw new akk(localajy);
      }
      throw new IOException("stream finished");
    }
    throw new IOException("stream closed");
  }
  
  final void h()
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      label5:
      break label5;
    }
    Thread.currentThread().interrupt();
    throw new InterruptedIOException();
  }
  
  final class a
    implements alo
  {
    boolean a;
    boolean b;
    private final akz e = new akz();
    
    a() {}
    
    private void a(boolean paramBoolean)
    {
      for (;;)
      {
        synchronized (akf.this)
        {
          akf.this.j.b_();
          try
          {
            if ((akf.this.b <= 0L) && (!this.b) && (!this.a) && (akf.this.k == null))
            {
              akf.this.h();
              continue;
            }
            akf.this.j.b();
            akf.this.g();
            long l = Math.min(akf.this.b, this.e.b);
            akf localakf = akf.this;
            localakf.b -= l;
            akf.this.j.b_();
            try
            {
              ??? = akf.this.d;
              int i = akf.this.c;
              if ((!paramBoolean) || (l != this.e.b)) {
                break label230;
              }
              paramBoolean = true;
              ((akd)???).a(i, paramBoolean, this.e, l);
              return;
            }
            finally
            {
              akf.this.j.b();
            }
            localObject4 = finally;
          }
          finally
          {
            akf.this.j.b();
          }
        }
        label230:
        paramBoolean = false;
      }
    }
    
    public final alq a()
    {
      return akf.this.j;
    }
    
    public final void a_(akz paramakz, long paramLong)
    {
      if ((!c) && (Thread.holdsLock(akf.this))) {
        throw new AssertionError();
      }
      this.e.a_(paramakz, paramLong);
      while (this.e.b >= 16384L) {
        a(false);
      }
    }
    
    public final void close()
    {
      if ((!c) && (Thread.holdsLock(akf.this))) {
        throw new AssertionError();
      }
      synchronized (akf.this)
      {
        if (this.a) {
          return;
        }
        if (!akf.this.h.b)
        {
          if (this.e.b > 0L) {
            while (this.e.b > 0L) {
              a(true);
            }
          }
          akf.this.d.a(akf.this.c, true, null, 0L);
        }
        synchronized (akf.this)
        {
          this.a = true;
          akf.this.d.p.b();
          akf.this.f();
          return;
        }
      }
    }
    
    public final void flush()
    {
      if ((!c) && (Thread.holdsLock(akf.this))) {
        throw new AssertionError();
      }
      synchronized (akf.this)
      {
        akf.this.g();
        while (this.e.b > 0L)
        {
          a(false);
          akf.this.d.p.b();
        }
        return;
      }
    }
  }
  
  final class b
    implements alp
  {
    boolean a;
    boolean b;
    private final akz e = new akz();
    private final akz f = new akz();
    private final long g;
    
    b(long paramLong)
    {
      this.g = paramLong;
    }
    
    private void a(long paramLong)
    {
      if ((!c) && (Thread.holdsLock(akf.this))) {
        throw new AssertionError();
      }
      akf.this.d.a(paramLong);
    }
    
    private void b()
    {
      akf.this.i.b_();
      try
      {
        while ((this.f.b == 0L) && (!this.b) && (!this.a) && (akf.this.k == null)) {
          akf.this.h();
        }
        return;
      }
      finally
      {
        akf.this.i.b();
      }
    }
    
    public final long a(akz paramakz, long paramLong)
    {
      if (paramLong >= 0L) {}
      for (;;)
      {
        synchronized (akf.this)
        {
          b();
          if (!this.a)
          {
            ajy localajy = akf.this.k;
            if (this.f.b <= 0L) {
              break label219;
            }
            paramLong = this.f.a(paramakz, Math.min(paramLong, this.f.b));
            paramakz = akf.this;
            paramakz.a += paramLong;
            if ((localajy == null) && (akf.this.a >= akf.this.d.l.b() / 2))
            {
              akf.this.d.a(akf.this.c, akf.this.a);
              akf.this.a = 0L;
            }
            if (paramLong != -1L)
            {
              a(paramLong);
              return paramLong;
            }
            if (localajy == null) {
              return -1L;
            }
            throw new akk(localajy);
          }
          throw new IOException("stream closed");
        }
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
        label219:
        paramLong = -1L;
      }
    }
    
    public final alq a()
    {
      return akf.this.i;
    }
    
    final void a(alb paramalb, long paramLong)
    {
      long l1 = paramLong;
      if (!c) {
        if (!Thread.holdsLock(akf.this)) {
          l1 = paramLong;
        } else {
          throw new AssertionError();
        }
      }
      if (l1 > 0L) {}
      for (;;)
      {
        synchronized (akf.this)
        {
          for (;;)
          {
            boolean bool = this.b;
            paramLong = this.f.b;
            long l2 = this.g;
            int j = 1;
            if (paramLong + l1 <= l2) {
              break label235;
            }
            i = 1;
            if (i != 0)
            {
              paramalb.g(l1);
              akf.this.b(ajy.d);
              return;
            }
            if (bool)
            {
              paramalb.g(l1);
              return;
            }
            paramLong = paramalb.a(this.e, l1);
            if (paramLong != -1L)
            {
              l1 -= paramLong;
              synchronized (akf.this)
              {
                if (this.f.b != 0L) {
                  break label241;
                }
                i = j;
                this.f.a(this.e);
                if (i != 0) {
                  akf.this.notifyAll();
                }
              }
            }
          }
          throw new EOFException();
        }
        return;
        label235:
        int i = 0;
        continue;
        label241:
        i = 0;
      }
    }
    
    public final void close()
    {
      synchronized (akf.this)
      {
        this.a = true;
        long l = this.f.b;
        this.f.p();
        akf.this.notifyAll();
        if (l > 0L) {
          a(l);
        }
        akf.this.f();
        return;
      }
    }
  }
  
  final class c
    extends akx
  {
    c() {}
    
    public final IOException a(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    public final void a()
    {
      akf.this.b(ajy.f);
    }
    
    public final void b()
    {
      if (!c_()) {
        return;
      }
      throw a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akf
 * JD-Core Version:    0.7.0.1
 */