package com.tencent.qmsp.sdk.g.e;

public class e
{
  public int a;
  public long b;
  public String c;
  
  public e(String paramString, int paramInt)
  {
    this.c = paramString;
    this.a = paramInt;
    this.b = (System.currentTimeMillis() + 86400000L);
  }
  
  public String toString()
  {
    return "ValueData{value='" + this.c + '\'' + ", code=" + this.a + ", expired=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.e.e
 * JD-Core Version:    0.7.0.1
 */