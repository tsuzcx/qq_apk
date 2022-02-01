package com.tencent.token;

public class cl
{
  public short a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 2) && (paramArrayOfByte[(paramArrayOfByte.length - 1)] == 3)) {
      return cj.a(paramArrayOfByte, 20);
    }
    return -1;
  }
  
  public void a(cg paramcg)
  {
    paramcg.a = cj.b(paramcg.f, 0, 32);
  }
  
  public void a(ch paramch, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 2))
    {
      if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3) {
        return;
      }
      paramch.g = cj.b(paramArrayOfByte, 1);
      paramch.h = cj.a(paramArrayOfByte, 5);
      paramch.i = paramArrayOfByte[7];
      paramch.j = cj.a(paramArrayOfByte, 8);
      paramch.k = cj.a(paramArrayOfByte, 10);
      paramch.l = ((int)cj.b(paramArrayOfByte, 12));
      paramch.m = ((int)cj.b(paramArrayOfByte, 16));
      paramch.n = cj.a(paramArrayOfByte, 20);
      paramch.o = cj.a(paramArrayOfByte, 22);
      paramch.p = cj.a(paramArrayOfByte, 24);
      paramch.q = cj.a(paramArrayOfByte, 26);
      paramch.r = cj.b(paramArrayOfByte, 28, 64);
      paramch.b = ((int)cj.b(paramArrayOfByte, 92));
      paramch.c = cj.b(paramArrayOfByte, 96, 256);
      paramch.d = ((int)cj.b(paramArrayOfByte, 352));
      paramch.e = cj.a(paramArrayOfByte, 356);
      cj.a(paramch.t, 0, paramArrayOfByte, 358, paramch.t.length);
      int j = 358 + paramch.t.length;
      int k = paramArrayOfByte.length - 1 - paramch.s.length - j;
      int i = j;
      if (k > 0)
      {
        paramch.f = new byte[k];
        cj.a(paramch.f, 0, paramArrayOfByte, j, paramch.f.length);
        i = j + paramch.f.length;
      }
      cj.a(paramch.s, 0, paramArrayOfByte, i, paramch.s.length);
      i = paramch.s.length;
      return;
    }
  }
  
  public byte[] a(long paramLong, int paramInt)
  {
    ci localci = new ci();
    localci.a(paramLong, paramInt, (int)(System.currentTimeMillis() / 1000L), (short)1);
    return localci.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cl
 * JD-Core Version:    0.7.0.1
 */