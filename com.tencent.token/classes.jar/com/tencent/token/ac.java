package com.tencent.token;

import com.tencent.halley.common.b;
import com.tencent.halley.downloader.c.d;

public final class ac
{
  private static String j = ",";
  public boolean a = true;
  public int b = -1;
  public int c = -1;
  public volatile long d;
  public volatile long e;
  public volatile long f;
  public volatile long g;
  public volatile boolean h = false;
  public d i;
  
  public ac(d paramd, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.i = paramd;
    this.d = paramLong1;
    this.g = paramLong4;
    this.e = paramLong2;
    this.f = Math.max(paramLong2, paramLong3);
  }
  
  public ac(d paramd, String paramString)
  {
    this.i = paramd;
    paramd = paramString.split(j);
    if ((paramd != null) && (paramd.length == 5))
    {
      this.b = Integer.valueOf(paramd[0]).intValue();
      this.c = Integer.valueOf(paramd[1]).intValue();
      this.d = Long.valueOf(paramd[2]).longValue();
      this.e = Long.valueOf(paramd[3]).longValue();
      this.f = this.e;
      this.g = Long.valueOf(paramd[4]).longValue();
      return;
    }
    b.c("DataSection", "new BDRange(String) pattern fail.");
    this.a = false;
  }
  
  public final long a(long paramLong)
  {
    if (this.g != -1L) {
      paramLong = this.g;
    }
    return paramLong - this.f;
  }
  
  public final m.a a(int paramInt, boolean paramBoolean)
  {
    long l2 = this.g;
    long l1 = l2;
    if (paramInt > 0) {
      if (this.g == -1L)
      {
        l1 = this.f + paramInt;
      }
      else
      {
        l1 = paramInt;
        if (l1 < this.g - this.f)
        {
          l1 = this.f + l1;
        }
        else
        {
          l1 = l2;
          if (!paramBoolean) {
            l1 = -1L;
          }
        }
      }
    }
    return new m.a(this.f, l1);
  }
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(j);
    localStringBuilder.append(this.c);
    localStringBuilder.append(j);
    localStringBuilder.append(this.d);
    localStringBuilder.append(j);
    localStringBuilder.append(this.e);
    localStringBuilder.append(j);
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append(this.b);
    localStringBuilder.append(j);
    localStringBuilder.append(this.c);
    localStringBuilder.append(j);
    localStringBuilder.append(this.d);
    localStringBuilder.append(j);
    localStringBuilder.append(this.e);
    localStringBuilder.append(j);
    localStringBuilder.append(this.f);
    localStringBuilder.append(j);
    localStringBuilder.append(this.g);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ac
 * JD-Core Version:    0.7.0.1
 */