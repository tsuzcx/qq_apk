package com.tencent.token;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public final class ab
  implements Cloneable
{
  public String a;
  public long b = -1L;
  public long c = -1L;
  public int d = -1;
  public byte[] e;
  public int f = -1;
  public long g = -1L;
  public int h = -1;
  public int i = -1;
  public byte[] j;
  
  public ab(byte[] paramArrayOfByte, InputStream paramInputStream)
  {
    aa.a(paramInputStream, paramArrayOfByte, 0, 46);
    paramArrayOfByte = new z(paramArrayOfByte, ByteOrder.LITTLE_ENDIAN);
    paramArrayOfByte.a();
    paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.b();
    this.d = paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.a();
    this.b = (paramArrayOfByte.a() & 0xFFFFFFFF);
    this.c = (paramArrayOfByte.a() & 0xFFFFFFFF);
    this.f = paramArrayOfByte.b();
    this.h = paramArrayOfByte.b();
    this.i = paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.a();
    this.g = (paramArrayOfByte.a() & 0xFFFFFFFF);
    this.j = new byte[this.f];
    paramArrayOfByte = this.j;
    aa.a(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = this.j;
    this.a = new String(paramArrayOfByte, 0, paramArrayOfByte.length, StandardCharsets.UTF_8);
    int k = this.i;
    if (k > 0)
    {
      paramArrayOfByte = new byte[k];
      aa.a(paramInputStream, paramArrayOfByte, 0, k);
      new String(paramArrayOfByte, 0, k, StandardCharsets.UTF_8);
    }
    k = this.h;
    if (k > 0)
    {
      this.e = new byte[k];
      aa.a(paramInputStream, this.e, 0, k);
    }
  }
  
  public final String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ab
 * JD-Core Version:    0.7.0.1
 */