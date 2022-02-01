package com.tencent.token;

public class ck
{
  public short a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2) || (paramArrayOfByte[0] != 2) || (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3)) {
      return -1;
    }
    return ci.a(paramArrayOfByte, 20);
  }
  
  public void a(cf paramcf)
  {
    paramcf.a = ci.b(paramcf.f, 0, 32);
  }
  
  public void a(cg paramcg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2) || (paramArrayOfByte[0] != 2) || (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3)) {
      return;
    }
    paramcg.g = ci.b(paramArrayOfByte, 1);
    paramcg.h = ci.a(paramArrayOfByte, 5);
    paramcg.i = paramArrayOfByte[7];
    paramcg.j = ci.a(paramArrayOfByte, 8);
    paramcg.k = ci.a(paramArrayOfByte, 10);
    paramcg.l = ((int)ci.b(paramArrayOfByte, 12));
    paramcg.m = ((int)ci.b(paramArrayOfByte, 16));
    paramcg.n = ci.a(paramArrayOfByte, 20);
    paramcg.o = ci.a(paramArrayOfByte, 22);
    paramcg.p = ci.a(paramArrayOfByte, 24);
    paramcg.q = ci.a(paramArrayOfByte, 26);
    paramcg.r = ci.b(paramArrayOfByte, 28, 64);
    paramcg.b = ((int)ci.b(paramArrayOfByte, 92));
    paramcg.c = ci.b(paramArrayOfByte, 96, 256);
    paramcg.d = ((int)ci.b(paramArrayOfByte, 352));
    paramcg.e = ci.a(paramArrayOfByte, 356);
    ci.a(paramcg.t, 0, paramArrayOfByte, 358, paramcg.t.length);
    int j = paramcg.t.length + 358;
    int k = paramArrayOfByte.length - 1 - paramcg.s.length - j;
    int i = j;
    if (k > 0)
    {
      paramcg.f = new byte[k];
      ci.a(paramcg.f, 0, paramArrayOfByte, j, paramcg.f.length);
      i = j + paramcg.f.length;
    }
    ci.a(paramcg.s, 0, paramArrayOfByte, i, paramcg.s.length);
    i = paramcg.s.length;
  }
  
  public byte[] a(long paramLong, int paramInt)
  {
    ch localch = new ch();
    localch.a(paramLong, paramInt, (int)(System.currentTimeMillis() / 1000L), (short)1);
    return localch.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ck
 * JD-Core Version:    0.7.0.1
 */