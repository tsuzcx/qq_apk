package com.tencent.token;

public final class agh
{
  public int a = -1;
  public int b = -1;
  public long c = -1L;
  public String d = "";
  public int e = -1;
  public int f = -1;
  
  public agh(int paramInt1, int paramInt2, long paramLong, String paramString, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong;
    this.d = paramString;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  public static agh a(int paramInt)
  {
    return new agh(paramInt, 100, -1L, "", -1, -2);
  }
  
  public static agh a(int paramInt1, int paramInt2)
  {
    return new agh(paramInt1, 200, -1L, "", -1, paramInt2);
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
    localStringBuilder.append("_");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agh
 * JD-Core Version:    0.7.0.1
 */