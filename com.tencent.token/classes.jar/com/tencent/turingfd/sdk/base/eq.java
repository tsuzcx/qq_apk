package com.tencent.turingfd.sdk.base;

public class eq
{
  public String a;
  public int b;
  public long c;
  
  public eq(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = (System.currentTimeMillis() + 86400000L);
  }
  
  public String toString()
  {
    return "ValueData{value='" + this.a + '\'' + ", code=" + this.b + ", expired=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.eq
 * JD-Core Version:    0.7.0.1
 */