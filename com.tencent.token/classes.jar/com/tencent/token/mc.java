package com.tencent.token;

public final class mc
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
  public mi j;
  
  public mc(mi parammi, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.j = parammi;
    this.e = paramLong1;
    this.h = paramLong4;
    this.f = paramLong2;
    this.g = Math.max(paramLong2, paramLong3);
  }
  
  public mc(mi parammi, String paramString)
  {
    this.j = parammi;
    parammi = paramString.split(a);
    if ((parammi != null) && (parammi.length == 5))
    {
      this.c = Integer.valueOf(parammi[0]).intValue();
      this.d = Integer.valueOf(parammi[1]).intValue();
      this.e = Long.valueOf(parammi[2]).longValue();
      this.f = Long.valueOf(parammi[3]).longValue();
      this.g = this.f;
      this.h = Long.valueOf(parammi[4]).longValue();
      return;
    }
    lh.c("DataSection", "new BDRange(String) pattern fail.");
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
 * Qualified Name:     com.tencent.token.mc
 * JD-Core Version:    0.7.0.1
 */