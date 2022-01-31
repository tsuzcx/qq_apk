package com.tencent.component.network.utils.a.b;

import java.util.concurrent.TimeUnit;

public abstract class e<T, C>
{
  private final String a;
  private final T b;
  private final C c;
  private final long d;
  private final long e;
  private long f;
  private long g;
  private volatile Object h;
  
  public e(String paramString, T paramT, C paramC, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (paramC == null) {
      throw new IllegalArgumentException("Connection may not be null");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit may not be null");
    }
    this.a = paramString;
    this.b = paramT;
    this.c = paramC;
    this.d = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (this.e = (this.d + paramTimeUnit.toMillis(paramLong));; this.e = 9223372036854775807L)
    {
      this.g = this.e;
      return;
    }
  }
  
  public final void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit == null) {
      try
      {
        throw new IllegalArgumentException("Time unit may not be null");
      }
      finally {}
    }
    this.f = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (paramLong = this.f + paramTimeUnit.toMillis(paramLong);; paramLong = 9223372036854775807L)
    {
      this.g = Math.min(paramLong, this.e);
      return;
    }
  }
  
  public final void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/tencent/component/network/utils/a/b/e:g	J
    //   6: lstore_3
    //   7: lload_1
    //   8: lload_3
    //   9: lcmp
    //   10: iflt +11 -> 21
    //   13: iconst_1
    //   14: istore 5
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 5
    //   20: ireturn
    //   21: iconst_0
    //   22: istore 5
    //   24: goto -8 -> 16
    //   27: astore 6
    //   29: aload_0
    //   30: monitorexit
    //   31: aload 6
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	e
    //   0	34	1	paramLong	long
    //   6	3	3	l	long
    //   14	9	5	bool	boolean
    //   27	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
  }
  
  public abstract boolean d();
  
  public abstract void e();
  
  public final T f()
  {
    return this.b;
  }
  
  public final C g()
  {
    return this.c;
  }
  
  public final Object h()
  {
    return this.h;
  }
  
  public final long i()
  {
    try
    {
      long l = this.f;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][route:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][state:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.b.e
 * JD-Core Version:    0.7.0.1
 */