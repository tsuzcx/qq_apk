package com.tencent.hlyyb.downloader.e.b;

import com.tencent.hlyyb.downloader.e.h;

public final class a
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
  public h i;
  
  public a(h paramh, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.i = paramh;
    this.d = paramLong1;
    this.g = paramLong4;
    this.e = paramLong2;
    this.f = Math.max(paramLong2, paramLong3);
  }
  
  public a(h paramh, String paramString)
  {
    this.i = paramh;
    paramh = paramString.split(j);
    if ((paramh != null) && (paramh.length == 5))
    {
      this.b = Integer.valueOf(paramh[0]).intValue();
      this.c = Integer.valueOf(paramh[1]).intValue();
      this.d = Long.valueOf(paramh[2]).longValue();
      this.e = Long.valueOf(paramh[3]).longValue();
      this.f = this.e;
      this.g = Long.valueOf(paramh[4]).longValue();
      return;
    }
    this.a = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.b.a
 * JD-Core Version:    0.7.0.1
 */