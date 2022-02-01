package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;

public final class ake
{
  long a = 0L;
  long b;
  final int c;
  final akc d;
  List<ajy> e;
  boolean f;
  final b g;
  final a h;
  final c i = new c();
  final c j = new c();
  ajx k = null;
  private final List<ajy> m;
  
  ake(int paramInt, akc paramakc, boolean paramBoolean1, boolean paramBoolean2, List<ajy> paramList)
  {
    if (paramakc != null)
    {
      if (paramList != null)
      {
        this.c = paramInt;
        this.d = paramakc;
        this.b = paramakc.m.b();
        this.g = new b(paramakc.l.b());
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
  
  private boolean d(ajx paramajx)
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
      this.k = paramajx;
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
  
  public final void a(ajx paramajx)
  {
    if (!d(paramajx)) {
      return;
    }
    this.d.b(this.c, paramajx);
  }
  
  public final boolean a()
  {
    try
    {
      ajx localajx = this.k;
      if (localajx != null) {
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
  
  public final void b(ajx paramajx)
  {
    if (!d(paramajx)) {
      return;
    }
    this.d.a(this.c, paramajx);
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
  
  public final List<ajy> c()
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
          throw new akj(this.k);
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
  
  final void c(ajx paramajx)
  {
    try
    {
      if (this.k == null)
      {
        this.k = paramajx;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramajx = finally;
      throw paramajx;
    }
  }
  
  public final aln d()
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
        a(ajx.f);
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
        ajx localajx = this.k;
        if (localajx == null) {
          return;
        }
        throw new akj(localajx);
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
    implements aln
  {
    boolean a;
    boolean b;
    private final aky e = new aky();
    
    a() {}
    
    private void a(boolean paramBoolean)
    {
      for (;;)
      {
        synchronized (ake.this)
        {
          ake.this.j.b_();
          try
          {
            if ((ake.this.b <= 0L) && (!this.b) && (!this.a) && (ake.this.k == null))
            {
              ake.this.h();
              continue;
            }
            ake.this.j.b();
            ake.this.g();
            long l = Math.min(ake.this.b, this.e.b);
            ake localake = ake.this;
            localake.b -= l;
            ake.this.j.b_();
            try
            {
              ??? = ake.this.d;
              int i = ake.this.c;
              if ((!paramBoolean) || (l != this.e.b)) {
                break label230;
              }
              paramBoolean = true;
              ((akc)???).a(i, paramBoolean, this.e, l);
              return;
            }
            finally
            {
              ake.this.j.b();
            }
            localObject4 = finally;
          }
          finally
          {
            ake.this.j.b();
          }
        }
        label230:
        paramBoolean = false;
      }
    }
    
    public final alp a()
    {
      return ake.this.j;
    }
    
    public final void a_(aky paramaky, long paramLong)
    {
      if ((!c) && (Thread.holdsLock(ake.this))) {
        throw new AssertionError();
      }
      this.e.a_(paramaky, paramLong);
      while (this.e.b >= 16384L) {
        a(false);
      }
    }
    
    public final void close()
    {
      if ((!c) && (Thread.holdsLock(ake.this))) {
        throw new AssertionError();
      }
      synchronized (ake.this)
      {
        if (this.a) {
          return;
        }
        if (!ake.this.h.b)
        {
          if (this.e.b > 0L) {
            while (this.e.b > 0L) {
              a(true);
            }
          }
          ake.this.d.a(ake.this.c, true, null, 0L);
        }
        synchronized (ake.this)
        {
          this.a = true;
          ake.this.d.p.b();
          ake.this.f();
          return;
        }
      }
    }
    
    public final void flush()
    {
      if ((!c) && (Thread.holdsLock(ake.this))) {
        throw new AssertionError();
      }
      synchronized (ake.this)
      {
        ake.this.g();
        while (this.e.b > 0L)
        {
          a(false);
          ake.this.d.p.b();
        }
        return;
      }
    }
  }
  
  final class b
    implements alo
  {
    boolean a;
    boolean b;
    private final aky e = new aky();
    private final aky f = new aky();
    private final long g;
    
    b(long paramLong)
    {
      this.g = paramLong;
    }
    
    private void a(long paramLong)
    {
      if ((!c) && (Thread.holdsLock(ake.this))) {
        throw new AssertionError();
      }
      ake.this.d.a(paramLong);
    }
    
    private void b()
    {
      ake.this.i.b_();
      try
      {
        while ((this.f.b == 0L) && (!this.b) && (!this.a) && (ake.this.k == null)) {
          ake.this.h();
        }
        return;
      }
      finally
      {
        ake.this.i.b();
      }
    }
    
    public final long a(aky paramaky, long paramLong)
    {
      if (paramLong >= 0L) {}
      for (;;)
      {
        synchronized (ake.this)
        {
          b();
          if (!this.a)
          {
            ajx localajx = ake.this.k;
            if (this.f.b <= 0L) {
              break label219;
            }
            paramLong = this.f.a(paramaky, Math.min(paramLong, this.f.b));
            paramaky = ake.this;
            paramaky.a += paramLong;
            if ((localajx == null) && (ake.this.a >= ake.this.d.l.b() / 2))
            {
              ake.this.d.a(ake.this.c, ake.this.a);
              ake.this.a = 0L;
            }
            if (paramLong != -1L)
            {
              a(paramLong);
              return paramLong;
            }
            if (localajx == null) {
              return -1L;
            }
            throw new akj(localajx);
          }
          throw new IOException("stream closed");
        }
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
        label219:
        paramLong = -1L;
      }
    }
    
    public final alp a()
    {
      return ake.this.i;
    }
    
    final void a(ala paramala, long paramLong)
    {
      long l1 = paramLong;
      if (!c) {
        if (!Thread.holdsLock(ake.this)) {
          l1 = paramLong;
        } else {
          throw new AssertionError();
        }
      }
      if (l1 > 0L) {}
      for (;;)
      {
        synchronized (ake.this)
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
              paramala.g(l1);
              ake.this.b(ajx.d);
              return;
            }
            if (bool)
            {
              paramala.g(l1);
              return;
            }
            paramLong = paramala.a(this.e, l1);
            if (paramLong != -1L)
            {
              l1 -= paramLong;
              synchronized (ake.this)
              {
                if (this.f.b != 0L) {
                  break label241;
                }
                i = j;
                this.f.a(this.e);
                if (i != 0) {
                  ake.this.notifyAll();
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
      synchronized (ake.this)
      {
        this.a = true;
        long l = this.f.b;
        this.f.p();
        ake.this.notifyAll();
        if (l > 0L) {
          a(l);
        }
        ake.this.f();
        return;
      }
    }
  }
  
  final class c
    extends akw
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
      ake.this.b(ajx.f);
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
 * Qualified Name:     com.tencent.token.ake
 * JD-Core Version:    0.7.0.1
 */