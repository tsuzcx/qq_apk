package com.tencent.turingfd.sdk.base;

public class bo
{
  public String a;
  public int b;
  
  public bo(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public static bo a(int paramInt)
  {
    return new bo("", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bo
 * JD-Core Version:    0.7.0.1
 */