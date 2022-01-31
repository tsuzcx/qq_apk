package com.tencent.turingfd.sdk.base;

public class al
{
  public int a;
  public int b;
  public int c;
  public String d = "";
  public int e;
  
  public al(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString1;
    this.c = paramInt3;
    this.e = paramInt4;
  }
  
  public String toString()
  {
    String str1 = String.format("% 6d", new Object[] { Integer.valueOf(this.a) });
    String str2 = String.format("% 6d", new Object[] { Integer.valueOf(this.b) });
    String str3 = String.format("% 6d", new Object[] { Integer.valueOf(this.c) });
    return "" + str1 + "    " + str2 + "    " + str3 + "    " + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.al
 * JD-Core Version:    0.7.0.1
 */