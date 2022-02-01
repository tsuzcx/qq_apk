package com.tencent.token;

import java.io.IOException;

public enum alh
{
  private final String g;
  
  private alh(String paramString)
  {
    this.g = paramString;
  }
  
  public static alh a(String paramString)
  {
    if (paramString.equals(a.g)) {
      return a;
    }
    if (paramString.equals(b.g)) {
      return b;
    }
    if (paramString.equals(e.g)) {
      return e;
    }
    if (paramString.equals(d.g)) {
      return d;
    }
    if (paramString.equals(c.g)) {
      return c;
    }
    if (paramString.equals(f.g)) {
      return f;
    }
    throw new IOException("Unexpected protocol: ".concat(String.valueOf(paramString)));
  }
  
  public final String toString()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alh
 * JD-Core Version:    0.7.0.1
 */