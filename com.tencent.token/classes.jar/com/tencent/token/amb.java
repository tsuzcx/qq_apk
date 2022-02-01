package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;

public final class amb
{
  long a = 0L;
  long b;
  final int c;
  final alz d;
  List<alv> e;
  boolean f;
  final b g;
  final a h;
  final c i = new c();
  final c j = new c();
  alu k = null;
  private final List<alv> m;
  
  amb(int paramInt, alz paramalz, boolean paramBoolean1, boolean paramBoolean2, List<alv> paramList)
  {
    if (paramalz != null)
    {
      if (paramList != null)
      {
        this.c = paramInt;
        this.d = paramalz;
        this.b = paramalz.m.b();
        this.g = new b(paramalz.l.b());
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
  
  private boolean d(alu paramalu)
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
      this.k = paramalu;
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
  
  public final void a(alu paramalu)
  {
    if (!d(paramalu)) {
      return;
    }
    this.d.b(this.c, paramalu);
  }
  
  public final boolean a()
  {
    try
    {
      alu localalu = this.k;
      if (localalu != null) {
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
  
  public final void b(alu paramalu)
  {
    if (!d(paramalu)) {
      return;
    }
    this.d.a(this.c, paramalu);
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
  
  public final List<alv> c()
  {
    try
    {
      if (b())
      {
        this.i.c_();
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
          throw new amg(this.k);
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
  
  final void c(alu paramalu)
  {
    try
    {
      if (this.k == null)
      {
        this.k = paramalu;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramalu = finally;
      throw paramalu;
    }
  }
  
  public final ank d()
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
        a(alu.f);
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
        alu localalu = this.k;
        if (localalu == null) {
          return;
        }
        throw new amg(localalu);
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
    implements ank
  {
    boolean a;
    boolean b;
    private final amv e = new amv();
    
    a() {}
    
    private void a(boolean paramBoolean)
    {
      for (;;)
      {
        synchronized (amb.this)
        {
          amb.this.j.c_();
          try
          {
            if ((amb.this.b <= 0L) && (!this.b) && (!this.a) && (amb.this.k == null))
            {
              amb.this.h();
              continue;
            }
            amb.this.j.b();
            amb.this.g();
            long l = Math.min(amb.this.b, this.e.b);
            amb localamb = amb.this;
            localamb.b -= l;
            amb.this.j.c_();
            try
            {
              ??? = amb.this.d;
              int i = amb.this.c;
              if ((!paramBoolean) || (l != this.e.b)) {
                break label230;
              }
              paramBoolean = true;
              ((alz)???).a(i, paramBoolean, this.e, l);
              return;
            }
            finally
            {
              amb.this.j.b();
            }
            localObject4 = finally;
          }
          finally
          {
            amb.this.j.b();
          }
        }
        label230:
        paramBoolean = false;
      }
    }
    
    public final anm a()
    {
      return amb.this.j;
    }
    
    public final void a_(amv paramamv, long paramLong)
    {
      if ((!c) && (Thread.holdsLock(amb.this))) {
        throw new AssertionError();
      }
      this.e.a_(paramamv, paramLong);
      while (this.e.b >= 16384L) {
        a(false);
      }
    }
    
    public final void close()
    {
      if ((!c) && (Thread.holdsLock(amb.this))) {
        throw new AssertionError();
      }
      synchronized (amb.this)
      {
        if (this.a) {
          return;
        }
        if (!amb.this.h.b)
        {
          if (this.e.b > 0L) {
            while (this.e.b > 0L) {
              a(true);
            }
          }
          amb.this.d.a(amb.this.c, true, null, 0L);
        }
        synchronized (amb.this)
        {
          this.a = true;
          amb.this.d.p.b();
          amb.this.f();
          return;
        }
      }
    }
    
    public final void flush()
    {
      if ((!c) && (Thread.holdsLock(amb.this))) {
        throw new AssertionError();
      }
      synchronized (amb.this)
      {
        amb.this.g();
        while (this.e.b > 0L)
        {
          a(false);
          amb.this.d.p.b();
        }
        return;
      }
    }
  }
  
  final class b
    implements anl
  {
    boolean a;
    boolean b;
    private final amv e = new amv();
    private final amv f = new amv();
    private final long g;
    
    b(long paramLong)
    {
      this.g = paramLong;
    }
    
    private void a(long paramLong)
    {
      if ((!c) && (Thread.holdsLock(amb.this))) {
        throw new AssertionError();
      }
      amb.this.d.a(paramLong);
    }
    
    private void b()
    {
      amb.this.i.c_();
      try
      {
        while ((this.f.b == 0L) && (!this.b) && (!this.a) && (amb.this.k == null)) {
          amb.this.h();
        }
        return;
      }
      finally
      {
        amb.this.i.b();
      }
    }
    
    public final long a(amv paramamv, long paramLong)
    {
      if (paramLong >= 0L) {}
      for (;;)
      {
        synchronized (amb.this)
        {
          b();
          if (!this.a)
          {
            alu localalu = amb.this.k;
            if (this.f.b <= 0L) {
              break label219;
            }
            paramLong = this.f.a(paramamv, Math.min(paramLong, this.f.b));
            paramamv = amb.this;
            paramamv.a += paramLong;
            if ((localalu == null) && (amb.this.a >= amb.this.d.l.b() / 2))
            {
              amb.this.d.a(amb.this.c, amb.this.a);
              amb.this.a = 0L;
            }
            if (paramLong != -1L)
            {
              a(paramLong);
              return paramLong;
            }
            if (localalu == null) {
              return -1L;
            }
            throw new amg(localalu);
          }
          throw new IOException("stream closed");
        }
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
        label219:
        paramLong = -1L;
      }
    }
    
    public final anm a()
    {
      return amb.this.i;
    }
    
    final void a(amx paramamx, long paramLong)
    {
      long l1 = paramLong;
      if (!c) {
        if (!Thread.holdsLock(amb.this)) {
          l1 = paramLong;
        } else {
          throw new AssertionError();
        }
      }
      if (l1 > 0L) {}
      for (;;)
      {
        synchronized (amb.this)
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
              paramamx.g(l1);
              amb.this.b(alu.d);
              return;
            }
            if (bool)
            {
              paramamx.g(l1);
              return;
            }
            paramLong = paramamx.a(this.e, l1);
            if (paramLong != -1L)
            {
              l1 -= paramLong;
              synchronized (amb.this)
              {
                if (this.f.b != 0L) {
                  break label241;
                }
                i = j;
                this.f.a(this.e);
                if (i != 0) {
                  amb.this.notifyAll();
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
      synchronized (amb.this)
      {
        this.a = true;
        long l = this.f.b;
        this.f.p();
        amb.this.notifyAll();
        if (l > 0L) {
          a(l);
        }
        amb.this.f();
        return;
      }
    }
  }
  
  final class c
    extends amt
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
      amb.this.b(alu.f);
    }
    
    public final void b()
    {
      if (!d_()) {
        return;
      }
      throw a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amb
 * JD-Core Version:    0.7.0.1
 */