package com.tencent.token;

import com.tencent.halley.common.b;
import com.tencent.halley.downloader.c.d;

public final class ab
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
  
  public ab(d paramd, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.i = paramd;
    this.d = paramLong1;
    this.g = paramLong4;
    this.e = paramLong2;
    this.f = Math.max(paramLong2, paramLong3);
  }
  
  public ab(d paramd, String paramString)
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
      return this.g - this.f;
    }
    return paramLong - this.f;
  }
  
  public final l.a a(int paramInt, boolean paramBoolean)
  {
    long l1 = -1L;
    long l2 = this.g;
    if (paramInt > 0) {
      if (this.g == -1L) {
        l1 = this.f + paramInt;
      }
    }
    for (;;)
    {
      return new l.a(this.f, l1);
      if (paramInt < this.g - this.f) {
        l1 = this.f + paramInt;
      } else if (paramBoolean) {
        l1 = l2;
      }
    }
  }
  
  public final String a()
  {
    return this.b + j + this.c + j + this.d + j + this.e + j + this.g;
  }
  
  public final String toString()
  {
    return "[" + this.b + j + this.c + j + this.d + j + this.e + j + this.f + j + this.g + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ab
 * JD-Core Version:    0.7.0.1
 */