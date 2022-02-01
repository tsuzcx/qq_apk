package com.tencent.token;

public final class tn
{
  public static void a(tj paramtj, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 2))
    {
      if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3) {
        return;
      }
      paramtj.g = tl.b(paramArrayOfByte, 1);
      paramtj.h = tl.a(paramArrayOfByte, 5);
      paramtj.i = paramArrayOfByte[7];
      paramtj.j = tl.a(paramArrayOfByte, 8);
      paramtj.k = tl.a(paramArrayOfByte, 10);
      paramtj.l = ((int)tl.b(paramArrayOfByte, 12));
      paramtj.m = ((int)tl.b(paramArrayOfByte, 16));
      paramtj.n = tl.a(paramArrayOfByte, 20);
      paramtj.o = tl.a(paramArrayOfByte, 22);
      paramtj.p = tl.a(paramArrayOfByte, 24);
      paramtj.q = tl.a(paramArrayOfByte, 26);
      paramtj.r = tl.a(paramArrayOfByte, 28, 64);
      paramtj.b = ((int)tl.b(paramArrayOfByte, 92));
      paramtj.c = tl.a(paramArrayOfByte, 96, 256);
      paramtj.d = ((int)tl.b(paramArrayOfByte, 352));
      paramtj.e = tl.a(paramArrayOfByte, 356);
      tl.a(paramtj.t, 0, paramArrayOfByte, 358, paramtj.t.length);
      int j = paramtj.t.length + 358;
      int k = paramArrayOfByte.length - 1 - paramtj.s.length - j;
      int i = j;
      if (k > 0)
      {
        paramtj.f = new byte[k];
        tl.a(paramtj.f, 0, paramArrayOfByte, j, paramtj.f.length);
        i = j + paramtj.f.length;
      }
      tl.a(paramtj.s, 0, paramArrayOfByte, i, paramtj.s.length);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tn
 * JD-Core Version:    0.7.0.1
 */