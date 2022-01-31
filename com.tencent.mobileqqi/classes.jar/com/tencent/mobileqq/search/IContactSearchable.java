package com.tencent.mobileqq.search;

import android.graphics.drawable.Drawable;

public abstract class IContactSearchable
  implements ISearchable
{
  public static final long a = 47244640256L;
  public static final long b = 42949672960L;
  public static final long c = 38654705664L;
  public static final long d = 34359738368L;
  public static final long e = 30064771072L;
  public static final long f = 25769803776L;
  public static final long g = 21474836480L;
  public static final long h = 17179869184L;
  public static final long i = 12884901888L;
  public static final long j = 8589934592L;
  public static final long k = 4294967296L;
  public static final long l = 1125899906842624L;
  public static final long m = 562949953421312L;
  public static final long n = 281474976710656L;
  public static final long o = 9007199254740992L;
  public static final long p = 4503599627370496L;
  public static final long q = 144115188075855872L;
  public static final long r = 72057594037927936L;
  public static final long s = 0L;
  public static final long t = 65536L;
  public static final long u = 131072L;
  protected long v;
  protected long w;
  
  public abstract int a();
  
  public long a()
  {
    return this.v;
  }
  
  public abstract Drawable a();
  
  public abstract Object a();
  
  public abstract String a();
  
  public void a(long paramLong)
  {
    this.v = paramLong;
  }
  
  public abstract int b();
  
  public abstract String b();
  
  public abstract String c();
  
  public abstract String d();
  
  public boolean equals(Object paramObject)
  {
    return d().equals(((IContactSearchable)paramObject).d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.IContactSearchable
 * JD-Core Version:    0.7.0.1
 */