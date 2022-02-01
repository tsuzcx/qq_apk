package com.tencent.token;

public final class su
{
  public static void a(sq paramsq, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 2))
    {
      if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3) {
        return;
      }
      paramsq.g = ss.b(paramArrayOfByte, 1);
      paramsq.h = ss.a(paramArrayOfByte, 5);
      paramsq.i = paramArrayOfByte[7];
      paramsq.j = ss.a(paramArrayOfByte, 8);
      paramsq.k = ss.a(paramArrayOfByte, 10);
      paramsq.l = ((int)ss.b(paramArrayOfByte, 12));
      paramsq.m = ((int)ss.b(paramArrayOfByte, 16));
      paramsq.n = ss.a(paramArrayOfByte, 20);
      paramsq.o = ss.a(paramArrayOfByte, 22);
      paramsq.p = ss.a(paramArrayOfByte, 24);
      paramsq.q = ss.a(paramArrayOfByte, 26);
      paramsq.r = ss.a(paramArrayOfByte, 28, 64);
      paramsq.b = ((int)ss.b(paramArrayOfByte, 92));
      paramsq.c = ss.a(paramArrayOfByte, 96, 256);
      paramsq.d = ((int)ss.b(paramArrayOfByte, 352));
      paramsq.e = ss.a(paramArrayOfByte, 356);
      ss.a(paramsq.t, 0, paramArrayOfByte, 358, paramsq.t.length);
      int j = paramsq.t.length + 358;
      int k = paramArrayOfByte.length - 1 - paramsq.s.length - j;
      int i = j;
      if (k > 0)
      {
        paramsq.f = new byte[k];
        ss.a(paramsq.f, 0, paramArrayOfByte, j, paramsq.f.length);
        i = j + paramsq.f.length;
      }
      ss.a(paramsq.s, 0, paramArrayOfByte, i, paramsq.s.length);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.su
 * JD-Core Version:    0.7.0.1
 */