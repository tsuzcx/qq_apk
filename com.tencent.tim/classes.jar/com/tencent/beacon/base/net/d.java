package com.tencent.beacon.base.net;

public final class d
{
  public String a;
  public String b;
  public int c;
  public String d;
  public Throwable e;
  
  public d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = paramString3;
  }
  
  public d(String paramString1, String paramString2, int paramInt, String paramString3, Throwable paramThrowable)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = paramString3;
    this.e = paramThrowable;
  }
  
  public String toString()
  {
    return "NetFailure{requestType='" + this.a + '\'' + ", attaCode='" + this.b + '\'' + ", responseCode=" + this.c + ", msg='" + this.d + '\'' + ", exception=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.d
 * JD-Core Version:    0.7.0.1
 */