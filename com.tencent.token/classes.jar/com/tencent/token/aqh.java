package com.tencent.token;

import java.util.List;

public final class aqh
{
  final List<apx> a;
  final double b;
  private final char c;
  private final String d;
  private final String e;
  
  public static int a(char paramChar, String paramString1, String paramString2)
  {
    return ((paramChar + '\000') * 31 + paramString1.hashCode()) * 31 + paramString2.hashCode();
  }
  
  public final int hashCode()
  {
    return a(this.c, this.e, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqh
 * JD-Core Version:    0.7.0.1
 */