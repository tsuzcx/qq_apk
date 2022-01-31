package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class z
{
  public static final z c = new aa();
  private boolean a;
  private long b;
  private long d;
  
  public z a(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public z a(long paramLong, TimeUnit paramTimeUnit)
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
  
  public z e_()
  {
    this.d = 0L;
    return this;
  }
  
  public z f()
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
 * Qualified Name:     okio.z
 * JD-Core Version:    0.7.0.1
 */