package com.tencent.token;

public class di
{
  public short a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2) || (paramArrayOfByte[0] != 2) || (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3)) {
      return -1;
    }
    return dg.a(paramArrayOfByte, 20);
  }
  
  public void a(dd paramdd)
  {
    paramdd.a = dg.b(paramdd.f, 0, 32);
  }
  
  public void a(de paramde, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2) || (paramArrayOfByte[0] != 2) || (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3)) {
      return;
    }
    paramde.g = dg.b(paramArrayOfByte, 1);
    paramde.h = dg.a(paramArrayOfByte, 5);
    paramde.i = paramArrayOfByte[7];
    paramde.j = dg.a(paramArrayOfByte, 8);
    paramde.k = dg.a(paramArrayOfByte, 10);
    paramde.l = ((int)dg.b(paramArrayOfByte, 12));
    paramde.m = ((int)dg.b(paramArrayOfByte, 16));
    paramde.n = dg.a(paramArrayOfByte, 20);
    paramde.o = dg.a(paramArrayOfByte, 22);
    paramde.p = dg.a(paramArrayOfByte, 24);
    paramde.q = dg.a(paramArrayOfByte, 26);
    paramde.r = dg.b(paramArrayOfByte, 28, 64);
    paramde.b = ((int)dg.b(paramArrayOfByte, 92));
    paramde.c = dg.b(paramArrayOfByte, 96, 256);
    paramde.d = ((int)dg.b(paramArrayOfByte, 352));
    paramde.e = dg.a(paramArrayOfByte, 356);
    dg.a(paramde.t, 0, paramArrayOfByte, 358, paramde.t.length);
    int j = paramde.t.length + 358;
    int k = paramArrayOfByte.length - 1 - paramde.s.length - j;
    int i = j;
    if (k > 0)
    {
      paramde.f = new byte[k];
      dg.a(paramde.f, 0, paramArrayOfByte, j, paramde.f.length);
      i = j + paramde.f.length;
    }
    dg.a(paramde.s, 0, paramArrayOfByte, i, paramde.s.length);
    i = paramde.s.length;
  }
  
  public byte[] a(long paramLong, int paramInt)
  {
    df localdf = new df();
    localdf.a(paramLong, paramInt, (int)(System.currentTimeMillis() / 1000L), (short)1);
    return localdf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.di
 * JD-Core Version:    0.7.0.1
 */