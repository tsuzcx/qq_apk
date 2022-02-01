package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;

public final class amz
{
  long a = 0L;
  long b;
  final int c;
  final amx d;
  List<amt> e;
  boolean f;
  final b g;
  final a h;
  final c i = new c();
  final c j = new c();
  ams k = null;
  private final List<amt> m;
  
  amz(int paramInt, amx paramamx, boolean paramBoolean1, boolean paramBoolean2, List<amt> paramList)
  {
    if (paramamx != null)
    {
      if (paramList != null)
      {
        this.c = paramInt;
        this.d = paramamx;
        this.b = paramamx.m.b();
        this.g = new b(paramamx.l.b());
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
  
  private boolean d(ams paramams)
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
      this.k = paramams;
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
  
  public final void a(ams paramams)
  {
    if (!d(paramams)) {
      return;
    }
    this.d.b(this.c, paramams);
  }
  
  public final boolean a()
  {
    try
    {
      ams localams = this.k;
      if (localams != null) {
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
  
  public final void b(ams paramams)
  {
    if (!d(paramams)) {
      return;
    }
    this.d.a(this.c, paramams);
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
  
  public final List<amt> c()
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
          throw new ane(this.k);
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
  
  final void c(ams paramams)
  {
    try
    {
      if (this.k == null)
      {
        this.k = paramams;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramams = finally;
      throw paramams;
    }
  }
  
  public final aoi d()
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
        a(ams.f);
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
        ams localams = this.k;
        if (localams == null) {
          return;
        }
        throw new ane(localams);
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
    implements aoi
  {
    boolean a;
    boolean b;
    private final ant e = new ant();
    
    a() {}
    
    private void a(boolean paramBoolean)
    {
      for (;;)
      {
        synchronized (amz.this)
        {
          amz.this.j.c_();
          try
          {
            if ((amz.this.b <= 0L) && (!this.b) && (!this.a) && (amz.this.k == null))
            {
              amz.this.h();
              continue;
            }
            amz.this.j.b();
            amz.this.g();
            long l = Math.min(amz.this.b, this.e.b);
            amz localamz = amz.this;
            localamz.b -= l;
            amz.this.j.c_();
            try
            {
              ??? = amz.this.d;
              int i = amz.this.c;
              if ((!paramBoolean) || (l != this.e.b)) {
                break label230;
              }
              paramBoolean = true;
              ((amx)???).a(i, paramBoolean, this.e, l);
              return;
            }
            finally
            {
              amz.this.j.b();
            }
            localObject4 = finally;
          }
          finally
          {
            amz.this.j.b();
          }
        }
        label230:
        paramBoolean = false;
      }
    }
    
    public final aok a()
    {
      return amz.this.j;
    }
    
    public final void a_(ant paramant, long paramLong)
    {
      if ((!c) && (Thread.holdsLock(amz.this))) {
        throw new AssertionError();
      }
      this.e.a_(paramant, paramLong);
      while (this.e.b >= 16384L) {
        a(false);
      }
    }
    
    public final void close()
    {
      if ((!c) && (Thread.holdsLock(amz.this))) {
        throw new AssertionError();
      }
      synchronized (amz.this)
      {
        if (this.a) {
          return;
        }
        if (!amz.this.h.b)
        {
          if (this.e.b > 0L) {
            while (this.e.b > 0L) {
              a(true);
            }
          }
          amz.this.d.a(amz.this.c, true, null, 0L);
        }
        synchronized (amz.this)
        {
          this.a = true;
          amz.this.d.p.b();
          amz.this.f();
          return;
        }
      }
    }
    
    public final void flush()
    {
      if ((!c) && (Thread.holdsLock(amz.this))) {
        throw new AssertionError();
      }
      synchronized (amz.this)
      {
        amz.this.g();
        while (this.e.b > 0L)
        {
          a(false);
          amz.this.d.p.b();
        }
        return;
      }
    }
  }
  
  final class b
    implements aoj
  {
    boolean a;
    boolean b;
    private final ant e = new ant();
    private final ant f = new ant();
    private final long g;
    
    b(long paramLong)
    {
      this.g = paramLong;
    }
    
    private void a(long paramLong)
    {
      if ((!c) && (Thread.holdsLock(amz.this))) {
        throw new AssertionError();
      }
      amz.this.d.a(paramLong);
    }
    
    private void b()
    {
      amz.this.i.c_();
      try
      {
        while ((this.f.b == 0L) && (!this.b) && (!this.a) && (amz.this.k == null)) {
          amz.this.h();
        }
        return;
      }
      finally
      {
        amz.this.i.b();
      }
    }
    
    public final long a(ant paramant, long paramLong)
    {
      if (paramLong >= 0L) {}
      for (;;)
      {
        synchronized (amz.this)
        {
          b();
          if (!this.a)
          {
            ams localams = amz.this.k;
            if (this.f.b <= 0L) {
              break label219;
            }
            paramLong = this.f.a(paramant, Math.min(paramLong, this.f.b));
            paramant = amz.this;
            paramant.a += paramLong;
            if ((localams == null) && (amz.this.a >= amz.this.d.l.b() / 2))
            {
              amz.this.d.a(amz.this.c, amz.this.a);
              amz.this.a = 0L;
            }
            if (paramLong != -1L)
            {
              a(paramLong);
              return paramLong;
            }
            if (localams == null) {
              return -1L;
            }
            throw new ane(localams);
          }
          throw new IOException("stream closed");
        }
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
        label219:
        paramLong = -1L;
      }
    }
    
    public final aok a()
    {
      return amz.this.i;
    }
    
    final void a(anv paramanv, long paramLong)
    {
      long l1 = paramLong;
      if (!c) {
        if (!Thread.holdsLock(amz.this)) {
          l1 = paramLong;
        } else {
          throw new AssertionError();
        }
      }
      if (l1 > 0L) {}
      for (;;)
      {
        synchronized (amz.this)
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
              paramanv.g(l1);
              amz.this.b(ams.d);
              return;
            }
            if (bool)
            {
              paramanv.g(l1);
              return;
            }
            paramLong = paramanv.a(this.e, l1);
            if (paramLong != -1L)
            {
              l1 -= paramLong;
              synchronized (amz.this)
              {
                if (this.f.b != 0L) {
                  break label241;
                }
                i = j;
                this.f.a(this.e);
                if (i != 0) {
                  amz.this.notifyAll();
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
      synchronized (amz.this)
      {
        this.a = true;
        long l = this.f.b;
        this.f.p();
        amz.this.notifyAll();
        if (l > 0L) {
          a(l);
        }
        amz.this.f();
        return;
      }
    }
  }
  
  final class c
    extends anr
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
      amz.this.b(ams.f);
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
 * Qualified Name:     com.tencent.token.amz
 * JD-Core Version:    0.7.0.1
 */