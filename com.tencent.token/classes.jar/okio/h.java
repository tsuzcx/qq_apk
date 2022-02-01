package okio;

import java.util.concurrent.TimeUnit;

public class h
  extends r
{
  private r a;
  
  public h(r paramr)
  {
    if (paramr == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramr;
  }
  
  public final h a(r paramr)
  {
    if (paramr == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramr;
    return this;
  }
  
  public final r a()
  {
    return this.a;
  }
  
  public r a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public r a(long paramLong, TimeUnit paramTimeUnit)
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
  
  public r e_()
  {
    return this.a.e_();
  }
  
  public r f()
  {
    return this.a.f();
  }
  
  public void g()
  {
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.h
 * JD-Core Version:    0.7.0.1
 */