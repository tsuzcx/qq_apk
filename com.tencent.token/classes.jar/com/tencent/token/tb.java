package com.tencent.token;

public final class tb
{
  public static void a(sx paramsx, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 2))
    {
      if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3) {
        return;
      }
      paramsx.g = sz.b(paramArrayOfByte, 1);
      paramsx.h = sz.a(paramArrayOfByte, 5);
      paramsx.i = paramArrayOfByte[7];
      paramsx.j = sz.a(paramArrayOfByte, 8);
      paramsx.k = sz.a(paramArrayOfByte, 10);
      paramsx.l = ((int)sz.b(paramArrayOfByte, 12));
      paramsx.m = ((int)sz.b(paramArrayOfByte, 16));
      paramsx.n = sz.a(paramArrayOfByte, 20);
      paramsx.o = sz.a(paramArrayOfByte, 22);
      paramsx.p = sz.a(paramArrayOfByte, 24);
      paramsx.q = sz.a(paramArrayOfByte, 26);
      paramsx.r = sz.a(paramArrayOfByte, 28, 64);
      paramsx.b = ((int)sz.b(paramArrayOfByte, 92));
      paramsx.c = sz.a(paramArrayOfByte, 96, 256);
      paramsx.d = ((int)sz.b(paramArrayOfByte, 352));
      paramsx.e = sz.a(paramArrayOfByte, 356);
      sz.a(paramsx.t, 0, paramArrayOfByte, 358, paramsx.t.length);
      int j = paramsx.t.length + 358;
      int k = paramArrayOfByte.length - 1 - paramsx.s.length - j;
      int i = j;
      if (k > 0)
      {
        paramsx.f = new byte[k];
        sz.a(paramsx.f, 0, paramArrayOfByte, j, paramsx.f.length);
        i = j + paramsx.f.length;
      }
      sz.a(paramsx.s, 0, paramArrayOfByte, i, paramsx.s.length);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tb
 * JD-Core Version:    0.7.0.1
 */