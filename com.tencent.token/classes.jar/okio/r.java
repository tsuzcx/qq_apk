package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class r
{
  public static final r c = new r()
  {
    public r a(long paramAnonymousLong)
    {
      return this;
    }
    
    public r a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
    {
      return this;
    }
    
    public void g() {}
  };
  private boolean a;
  private long b;
  private long d;
  
  public r a(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public r a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    this.d = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public long c_()
  {
    return this.d;
  }
  
  public long d()
  {
    if (!this.a) {
      throw new IllegalStateException("No deadline");
    }
    return this.b;
  }
  
  public boolean d_()
  {
    return this.a;
  }
  
  public r e_()
  {
    this.d = 0L;
    return this;
  }
  
  public r f()
  {
    this.a = false;
    return this;
  }
  
  public void g()
  {
    if (Thread.interrupted()) {
      throw new InterruptedIOException("thread interrupted");
    }
    if ((this.a) && (this.b - System.nanoTime() <= 0L)) {
      throw new InterruptedIOException("deadline reached");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.r
 * JD-Core Version:    0.7.0.1
 */