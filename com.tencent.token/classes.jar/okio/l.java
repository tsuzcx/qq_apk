package okio;

import java.util.concurrent.TimeUnit;

public class l
  extends z
{
  private z a;
  
  public l(z paramz)
  {
    if (paramz == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramz;
  }
  
  public final l a(z paramz)
  {
    if (paramz == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramz;
    return this;
  }
  
  public final z a()
  {
    return this.a;
  }
  
  public z a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public z a(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.a(paramLong, paramTimeUnit);
  }
  
  public long c_()
  {
    return this.a.c_();
  }
  
  public long d()
  {
    return this.a.d();
  }
  
  public boolean d_()
  {
    return this.a.d_();
  }
  
  public z e_()
  {
    return this.a.e_();
  }
  
  public z f()
  {
    return this.a.f();
  }
  
  public void g()
  {
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.l
 * JD-Core Version:    0.7.0.1
 */