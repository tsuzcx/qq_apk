package com.tencent.token;

import java.util.Hashtable;

public class fa
{
  Hashtable a = new Hashtable();
  public String b = "";
  long c = 0L;
  long d = 0L;
  final boolean e;
  private final String f;
  private String g = "GET";
  private int h = 0;
  private final fb i;
  private final byte[] j;
  
  public fa(String paramString, byte[] paramArrayOfByte, fb paramfb, boolean paramBoolean)
  {
    this.f = paramString;
    this.i = paramfb;
    if (paramArrayOfByte == null)
    {
      this.j = null;
    }
    else
    {
      this.j = new byte[paramArrayOfByte.length];
      paramString = this.j;
      System.arraycopy(paramArrayOfByte, 0, paramString, 0, paramString.length);
    }
    this.e = paramBoolean;
  }
  
  public String a()
  {
    return this.f;
  }
  
  void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public fb b()
  {
    return this.i;
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte1 = this.j;
    if (arrayOfByte1 == null) {
      return null;
    }
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
    return arrayOfByte2;
  }
  
  public int d()
  {
    return this.h;
  }
  
  public String e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fa
 * JD-Core Version:    0.7.0.1
 */