package com.tencent.token;

public final class st
{
  public static void a(sp paramsp, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 2))
    {
      if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3) {
        return;
      }
      paramsp.g = sr.b(paramArrayOfByte, 1);
      paramsp.h = sr.a(paramArrayOfByte, 5);
      paramsp.i = paramArrayOfByte[7];
      paramsp.j = sr.a(paramArrayOfByte, 8);
      paramsp.k = sr.a(paramArrayOfByte, 10);
      paramsp.l = ((int)sr.b(paramArrayOfByte, 12));
      paramsp.m = ((int)sr.b(paramArrayOfByte, 16));
      paramsp.n = sr.a(paramArrayOfByte, 20);
      paramsp.o = sr.a(paramArrayOfByte, 22);
      paramsp.p = sr.a(paramArrayOfByte, 24);
      paramsp.q = sr.a(paramArrayOfByte, 26);
      paramsp.r = sr.a(paramArrayOfByte, 28, 64);
      paramsp.b = ((int)sr.b(paramArrayOfByte, 92));
      paramsp.c = sr.a(paramArrayOfByte, 96, 256);
      paramsp.d = ((int)sr.b(paramArrayOfByte, 352));
      paramsp.e = sr.a(paramArrayOfByte, 356);
      sr.a(paramsp.t, 0, paramArrayOfByte, 358, paramsp.t.length);
      int j = paramsp.t.length + 358;
      int k = paramArrayOfByte.length - 1 - paramsp.s.length - j;
      int i = j;
      if (k > 0)
      {
        paramsp.f = new byte[k];
        sr.a(paramsp.f, 0, paramArrayOfByte, j, paramsp.f.length);
        i = j + paramsp.f.length;
      }
      sr.a(paramsp.s, 0, paramArrayOfByte, i, paramsp.s.length);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.st
 * JD-Core Version:    0.7.0.1
 */