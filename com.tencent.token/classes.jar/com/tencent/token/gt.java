package com.tencent.token;

import java.util.Hashtable;

public final class gt
{
  Hashtable a = new Hashtable();
  public String b = "";
  long c = 0L;
  long d = 0L;
  final boolean e;
  private final String f;
  private String g = "GET";
  private int h = 0;
  private final gu i;
  private final byte[] j;
  
  public gt(String paramString, byte[] paramArrayOfByte, gu paramgu)
  {
    this.f = paramString;
    this.i = paramgu;
    if (paramArrayOfByte == null) {
      this.j = null;
    }
    for (;;)
    {
      this.e = true;
      return;
      this.j = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.j, 0, this.j.length);
    }
  }
  
  public final String a()
  {
    return this.f;
  }
  
  final void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.g = paramString;
  }
  
  public final gu b()
  {
    return this.i;
  }
  
  public final byte[] c()
  {
    if (this.j == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[this.j.length];
    System.arraycopy(this.j, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public final int d()
  {
    return this.h;
  }
  
  public final String e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gt
 * JD-Core Version:    0.7.0.1
 */