package com.tencent.token;

public final class mj
{
  public static String a = ",";
  public boolean b = true;
  public int c = -1;
  public int d = -1;
  public volatile long e;
  public volatile long f;
  public volatile long g;
  public volatile long h;
  public volatile boolean i = false;
  public mp j;
  
  public mj(mp parammp, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.j = parammp;
    this.e = paramLong1;
    this.h = paramLong4;
    this.f = paramLong2;
    this.g = Math.max(paramLong2, paramLong3);
  }
  
  public mj(mp parammp, String paramString)
  {
    this.j = parammp;
    parammp = paramString.split(a);
    if ((parammp != null) && (parammp.length == 5))
    {
      this.c = Integer.valueOf(parammp[0]).intValue();
      this.d = Integer.valueOf(parammp[1]).intValue();
      this.e = Long.valueOf(parammp[2]).longValue();
      this.f = Long.valueOf(parammp[3]).longValue();
      this.g = this.f;
      this.h = Long.valueOf(parammp[4]).longValue();
      return;
    }
    lo.c("DataSection", "new BDRange(String) pattern fail.");
    this.b = false;
  }
  
  public final long a(long paramLong)
  {
    if (this.h != -1L) {
      paramLong = this.h;
    }
    return paramLong - this.g;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append(a);
    localStringBuilder.append(this.d);
    localStringBuilder.append(a);
    localStringBuilder.append(this.e);
    localStringBuilder.append(a);
    localStringBuilder.append(this.f);
    localStringBuilder.append(a);
    localStringBuilder.append(this.g);
    localStringBuilder.append(a);
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.mj
 * JD-Core Version:    0.7.0.1
 */