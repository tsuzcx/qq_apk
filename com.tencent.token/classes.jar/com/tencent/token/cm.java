package com.tencent.token;

public class cm
{
  public short a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 2) && (paramArrayOfByte[(paramArrayOfByte.length - 1)] == 3)) {
      return ck.a(paramArrayOfByte, 20);
    }
    return -1;
  }
  
  public void a(ch paramch)
  {
    paramch.a = ck.b(paramch.f, 0, 32);
  }
  
  public void a(ci paramci, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 2))
    {
      if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3) {
        return;
      }
      paramci.g = ck.b(paramArrayOfByte, 1);
      paramci.h = ck.a(paramArrayOfByte, 5);
      paramci.i = paramArrayOfByte[7];
      paramci.j = ck.a(paramArrayOfByte, 8);
      paramci.k = ck.a(paramArrayOfByte, 10);
      paramci.l = ((int)ck.b(paramArrayOfByte, 12));
      paramci.m = ((int)ck.b(paramArrayOfByte, 16));
      paramci.n = ck.a(paramArrayOfByte, 20);
      paramci.o = ck.a(paramArrayOfByte, 22);
      paramci.p = ck.a(paramArrayOfByte, 24);
      paramci.q = ck.a(paramArrayOfByte, 26);
      paramci.r = ck.b(paramArrayOfByte, 28, 64);
      paramci.b = ((int)ck.b(paramArrayOfByte, 92));
      paramci.c = ck.b(paramArrayOfByte, 96, 256);
      paramci.d = ((int)ck.b(paramArrayOfByte, 352));
      paramci.e = ck.a(paramArrayOfByte, 356);
      ck.a(paramci.t, 0, paramArrayOfByte, 358, paramci.t.length);
      int j = 358 + paramci.t.length;
      int k = paramArrayOfByte.length - 1 - paramci.s.length - j;
      int i = j;
      if (k > 0)
      {
        paramci.f = new byte[k];
        ck.a(paramci.f, 0, paramArrayOfByte, j, paramci.f.length);
        i = j + paramci.f.length;
      }
      ck.a(paramci.s, 0, paramArrayOfByte, i, paramci.s.length);
      i = paramci.s.length;
      return;
    }
  }
  
  public byte[] a(long paramLong, int paramInt)
  {
    cj localcj = new cj();
    localcj.a(paramLong, paramInt, (int)(System.currentTimeMillis() / 1000L), (short)1);
    return localcj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cm
 * JD-Core Version:    0.7.0.1
 */