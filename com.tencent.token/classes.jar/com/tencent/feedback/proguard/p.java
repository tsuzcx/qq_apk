package com.tencent.feedback.proguard;

import com.tencent.feedback.common.e;
import java.io.Serializable;
import java.util.Locale;

public class p
  implements Serializable
{
  public final int a;
  public final long b;
  public final long c;
  public final long d;
  public final long e;
  public final long f;
  public final long g;
  private long h = -1L;
  
  public p(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    this.a = paramInt;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramLong3;
    this.e = paramLong4;
    this.f = paramLong5;
    this.g = paramLong6;
  }
  
  public final long a()
  {
    try
    {
      long l = this.h;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(long paramLong)
  {
    try
    {
      this.h = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    try
    {
      String str = String.format(Locale.US, "[tp:%d , st:%d ,counts:%d, wifi:%d , notWifi:%d , up:%d , dn:%d]", new Object[] { Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g) });
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.p
 * JD-Core Version:    0.7.0.1
 */