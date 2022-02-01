package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.c;
import okio.p;
import okio.q;
import okio.r;

public final class g
{
  long a = 0L;
  long b;
  final int c;
  final e d;
  final a e;
  final c f = new c();
  final c g = new c();
  ErrorCode h = null;
  private final List<a> j;
  private List<a> k;
  private boolean l;
  private final b m;
  
  g(int paramInt, e parame, boolean paramBoolean1, boolean paramBoolean2, List<a> paramList)
  {
    if (parame != null)
    {
      if (paramList != null)
      {
        this.c = paramInt;
        this.d = parame;
        this.b = parame.l.d();
        this.m = new b(parame.k.d());
        this.e = new a();
        this.m.b = paramBoolean2;
        this.e.b = paramBoolean1;
        this.j = paramList;
        return;
      }
      throw new NullPointerException("requestHeaders == null");
    }
    throw new NullPointerException("connection == null");
  }
  
  private boolean d(ErrorCode paramErrorCode)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.h != null) {
        return false;
      }
      if ((this.m.b) && (this.e.b)) {
        return false;
      }
      this.h = paramErrorCode;
      notifyAll();
      this.d.b(this.c);
      return true;
    }
    finally {}
  }
  
  public int a()
  {
    return this.c;
  }
  
  void a(long paramLong)
  {
    this.b += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  void a(List<a> paramList)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    boolean bool = true;
    try
    {
      this.l = true;
      if (this.k == null)
      {
        this.k = paramList;
        bool = b();
        notifyAll();
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(this.k);
        localArrayList.add(null);
        localArrayList.addAll(paramList);
        this.k = localArrayList;
      }
      if (!bool) {
        this.d.b(this.c);
      }
      return;
    }
    finally {}
  }
  
  public void a(ErrorCode paramErrorCode)
  {
    if (!d(paramErrorCode)) {
      return;
    }
    this.d.b(this.c, paramErrorCode);
  }
  
  void a(okio.e parame, int paramInt)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    this.m.a(parame, paramInt);
  }
  
  public void b(ErrorCode paramErrorCode)
  {
    if (!d(paramErrorCode)) {
      return;
    }
    this.d.a(this.c, paramErrorCode);
  }
  
  public boolean b()
  {
    try
    {
      ErrorCode localErrorCode = this.h;
      if (localErrorCode != null) {
        return false;
      }
      if (((this.m.b) || (this.m.a)) && ((this.e.b) || (this.e.a)))
      {
        boolean bool = this.l;
        if (bool) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  void c(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.h == null)
      {
        this.h = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public boolean c()
  {
    int n;
    if ((this.c & 0x1) == 1) {
      n = 1;
    } else {
      n = 0;
    }
    return this.d.a == n;
  }
  
  public List<a> d()
  {
    try
    {
      if (c())
      {
        this.f.c();
        try
        {
          while ((this.k == null) && (this.h == null)) {
            l();
          }
          this.f.b();
          List localList = this.k;
          if (localList != null)
          {
            this.k = null;
            return localList;
          }
          throw new StreamResetException(this.h);
        }
        finally
        {
          this.f.b();
        }
      }
      throw new IllegalStateException("servers cannot read response headers");
    }
    finally {}
  }
  
  public r e()
  {
    return this.f;
  }
  
  public r f()
  {
    return this.g;
  }
  
  public q g()
  {
    return this.m;
  }
  
  public p h()
  {
    try
    {
      if ((!this.l) && (!c())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
      return this.e;
    }
    finally {}
  }
  
  void i()
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      this.m.b = true;
      boolean bool = b();
      notifyAll();
      if (!bool) {
        this.d.b(this.c);
      }
      return;
    }
    finally {}
  }
  
  void j()
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        if ((this.m.b) || (!this.m.a)) {
          break label115;
        }
        if (this.e.b) {
          break label110;
        }
        if (!this.e.a) {
          break label115;
        }
      }
      finally {}
      boolean bool = b();
      if (n != 0)
      {
        a(ErrorCode.CANCEL);
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
  
  void k()
  {
    if (!this.e.a)
    {
      if (!this.e.b)
      {
        ErrorCode localErrorCode = this.h;
        if (localErrorCode == null) {
          return;
        }
        throw new StreamResetException(localErrorCode);
      }
      throw new IOException("stream finished");
    }
    throw new IOException("stream closed");
  }
  
  void l()
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
    implements p
  {
    boolean a;
    boolean b;
    private final c e = new c();
    
    a() {}
    
    private void a(boolean paramBoolean)
    {
      for (;;)
      {
        synchronized (g.this)
        {
          g.this.g.c();
          try
          {
            if ((g.this.b <= 0L) && (!this.b) && (!this.a) && (g.this.h == null))
            {
              g.this.l();
              continue;
            }
            g.this.g.b();
            g.this.k();
            long l = Math.min(g.this.b, this.e.b());
            g localg = g.this;
            localg.b -= l;
            g.this.g.c();
            try
            {
              ??? = g.this.d;
              int i = g.this.c;
              if ((!paramBoolean) || (l != this.e.b())) {
                break label230;
              }
              paramBoolean = true;
              ((e)???).a(i, paramBoolean, this.e, l);
              return;
            }
            finally
            {
              g.this.g.b();
            }
            localObject4 = finally;
          }
          finally
          {
            g.this.g.b();
          }
        }
        label230:
        paramBoolean = false;
      }
    }
    
    public r a()
    {
      return g.this.g;
    }
    
    public void a_(c paramc, long paramLong)
    {
      if ((!c) && (Thread.holdsLock(g.this))) {
        throw new AssertionError();
      }
      this.e.a_(paramc, paramLong);
      while (this.e.b() >= 16384L) {
        a(false);
      }
    }
    
    public void close()
    {
      if ((!c) && (Thread.holdsLock(g.this))) {
        throw new AssertionError();
      }
      synchronized (g.this)
      {
        if (this.a) {
          return;
        }
        if (!g.this.e.b)
        {
          if (this.e.b() > 0L) {
            while (this.e.b() > 0L) {
              a(true);
            }
          }
          g.this.d.a(g.this.c, true, null, 0L);
        }
        synchronized (g.this)
        {
          this.a = true;
          g.this.d.b();
          g.this.j();
          return;
        }
      }
    }
    
    public void flush()
    {
      if ((!c) && (Thread.holdsLock(g.this))) {
        throw new AssertionError();
      }
      synchronized (g.this)
      {
        g.this.k();
        while (this.e.b() > 0L)
        {
          a(false);
          g.this.d.b();
        }
        return;
      }
    }
  }
  
  private final class b
    implements q
  {
    boolean a;
    boolean b;
    private final c e = new c();
    private final c f = new c();
    private final long g;
    
    b(long paramLong)
    {
      this.g = paramLong;
    }
    
    private void a(long paramLong)
    {
      if ((!c) && (Thread.holdsLock(g.this))) {
        throw new AssertionError();
      }
      g.this.d.a(paramLong);
    }
    
    private void b()
    {
      g.this.f.c();
      try
      {
        while ((this.f.b() == 0L) && (!this.b) && (!this.a) && (g.this.h == null)) {
          g.this.l();
        }
        return;
      }
      finally
      {
        g.this.f.b();
      }
    }
    
    public long a(c paramc, long paramLong)
    {
      if (paramLong >= 0L) {}
      for (;;)
      {
        synchronized (g.this)
        {
          b();
          if (!this.a)
          {
            ErrorCode localErrorCode = g.this.h;
            if (this.f.b() <= 0L) {
              break label235;
            }
            paramLong = this.f.a(paramc, Math.min(paramLong, this.f.b()));
            paramc = g.this;
            paramc.a += paramLong;
            if ((localErrorCode == null) && (g.this.a >= g.this.d.k.d() / 2))
            {
              g.this.d.a(g.this.c, g.this.a);
              g.this.a = 0L;
            }
            if (paramLong != -1L)
            {
              a(paramLong);
              return paramLong;
            }
            if (localErrorCode == null) {
              return -1L;
            }
            throw new StreamResetException(localErrorCode);
          }
          throw new IOException("stream closed");
        }
        paramc = new StringBuilder();
        paramc.append("byteCount < 0: ");
        paramc.append(paramLong);
        throw new IllegalArgumentException(paramc.toString());
        label235:
        paramLong = -1L;
      }
    }
    
    public r a()
    {
      return g.this.f;
    }
    
    void a(okio.e parame, long paramLong)
    {
      long l1 = paramLong;
      if (!c) {
        if (!Thread.holdsLock(g.this)) {
          l1 = paramLong;
        } else {
          throw new AssertionError();
        }
      }
      if (l1 > 0L) {}
      for (;;)
      {
        synchronized (g.this)
        {
          for (;;)
          {
            boolean bool = this.b;
            paramLong = this.f.b();
            long l2 = this.g;
            int j = 1;
            if (paramLong + l1 <= l2) {
              break label235;
            }
            i = 1;
            if (i != 0)
            {
              parame.h(l1);
              g.this.b(ErrorCode.FLOW_CONTROL_ERROR);
              return;
            }
            if (bool)
            {
              parame.h(l1);
              return;
            }
            paramLong = parame.a(this.e, l1);
            if (paramLong != -1L)
            {
              l1 -= paramLong;
              synchronized (g.this)
              {
                if (this.f.b() != 0L) {
                  break label241;
                }
                i = j;
                this.f.a(this.e);
                if (i != 0) {
                  g.this.notifyAll();
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
    
    public void close()
    {
      synchronized (g.this)
      {
        this.a = true;
        long l = this.f.b();
        this.f.r();
        g.this.notifyAll();
        if (l > 0L) {
          a(l);
        }
        g.this.j();
        return;
      }
    }
  }
  
  class c
    extends okio.a
  {
    c() {}
    
    protected IOException a(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected void a()
    {
      g.this.b(ErrorCode.CANCEL);
    }
    
    public void b()
    {
      if (!b_()) {
        return;
      }
      throw a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.g
 * JD-Core Version:    0.7.0.1
 */