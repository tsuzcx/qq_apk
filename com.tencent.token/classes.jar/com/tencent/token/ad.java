package com.tencent.token;

import com.tencent.halley.common.c;
import com.tencent.halley.downloader.c.g;

public final class ad
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
  public g i;
  
  public ad(g paramg, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.i = paramg;
    this.d = paramLong1;
    this.g = paramLong4;
    this.e = paramLong2;
    this.f = Math.max(paramLong2, paramLong3);
  }
  
  public ad(g paramg, String paramString)
  {
    this.i = paramg;
    paramg = paramString.split(j);
    if ((paramg != null) && (paramg.length == 5))
    {
      this.b = Integer.valueOf(paramg[0]).intValue();
      this.c = Integer.valueOf(paramg[1]).intValue();
      this.d = Long.valueOf(paramg[2]).longValue();
      this.e = Long.valueOf(paramg[3]).longValue();
      this.f = this.e;
      this.g = Long.valueOf(paramg[4]).longValue();
      return;
    }
    c.c("DataSection", "new BDRange(String) pattern fail.");
    this.a = false;
  }
  
  public final long a(long paramLong)
  {
    if (this.g != -1L) {
      return this.g - this.f;
    }
    return paramLong - this.f;
  }
  
  public final j a(int paramInt, boolean paramBoolean)
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
      return new j(this.f, l1);
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
 * Qualified Name:     com.tencent.token.ad
 * JD-Core Version:    0.7.0.1
 */