package okhttp3;

import java.util.concurrent.TimeUnit;

public final class f
{
  boolean a;
  boolean b;
  int c = -1;
  int d = -1;
  int e = -1;
  boolean f;
  boolean g;
  boolean h;
  
  public f a()
  {
    this.a = true;
    return this;
  }
  
  public f a(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxStale < 0: " + paramInt);
    }
    long l = paramTimeUnit.toSeconds(paramInt);
    if (l > 2147483647L) {}
    for (paramInt = 2147483647;; paramInt = (int)l)
    {
      this.d = paramInt;
      return this;
    }
  }
  
  public f b()
  {
    this.f = true;
    return this;
  }
  
  public e c()
  {
    return new e(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.f
 * JD-Core Version:    0.7.0.1
 */