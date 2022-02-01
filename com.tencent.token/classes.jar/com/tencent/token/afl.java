package com.tencent.token;

public final class afl
{
  public int a = -1;
  public int b = -1;
  public long c = -1L;
  public String d = "";
  public int e = -1;
  
  public afl(int paramInt1, int paramInt2, long paramLong, String paramString, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong;
    this.d = paramString;
    this.e = paramInt3;
  }
  
  public static afl a(int paramInt)
  {
    return new afl(paramInt, 100, -1L, "", -1);
  }
  
  public static afl b(int paramInt)
  {
    return new afl(paramInt, 200, -1L, "", -1);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(this.e);
    localStringBuilder.append("_");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afl
 * JD-Core Version:    0.7.0.1
 */