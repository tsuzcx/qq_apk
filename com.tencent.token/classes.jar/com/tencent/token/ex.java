package com.tencent.token;

import java.util.Hashtable;

public class ex
{
  Hashtable a = new Hashtable();
  public String b = "";
  long c = 0L;
  long d = 0L;
  final boolean e;
  private final String f;
  private String g = "GET";
  private int h = 0;
  private final ey i;
  private final byte[] j;
  
  public ex(String paramString, byte[] paramArrayOfByte, ey paramey, boolean paramBoolean)
  {
    this.f = paramString;
    this.i = paramey;
    if (paramArrayOfByte == null) {
      this.j = null;
    }
    for (;;)
    {
      this.e = paramBoolean;
      return;
      this.j = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.j, 0, this.j.length);
    }
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
  
  public ey b()
  {
    return this.i;
  }
  
  public byte[] c()
  {
    if (this.j == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[this.j.length];
    System.arraycopy(this.j, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
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
 * Qualified Name:     com.tencent.token.ex
 * JD-Core Version:    0.7.0.1
 */