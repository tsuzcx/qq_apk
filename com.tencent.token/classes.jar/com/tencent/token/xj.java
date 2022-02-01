package com.tencent.token;

public final class xj
{
  public static int a(byte[] paramArrayOfByte, int paramInt, xi paramxi)
  {
    if (paramInt <= 42) {
      return -1;
    }
    if ((paramArrayOfByte[0] == 2) && (paramArrayOfByte[(paramInt - 1)] == 3))
    {
      paramxi.a = tl.a(paramArrayOfByte, 1);
      if (paramxi.a != paramInt) {
        return -3;
      }
      paramxi.b = tl.a(paramArrayOfByte, 3);
      paramxi.c = tl.b(paramArrayOfByte, 5);
      xi.d = tl.b(paramArrayOfByte, 9);
      paramxi.e = tl.a(paramArrayOfByte, 13);
      paramxi.f = tl.a(paramArrayOfByte, 15);
      paramxi.g = tl.a(paramArrayOfByte, 17);
      paramxi.h = tl.b(paramArrayOfByte, 19);
      paramxi.i = paramArrayOfByte[23];
      paramxi.j = paramArrayOfByte[24];
      tl.b(paramArrayOfByte, 25, xi.k, 16);
      paramArrayOfByte = new StringBuilder("socket parse msg head: totallen[");
      paramArrayOfByte.append(paramxi.a);
      paramArrayOfByte.append("] msgtype[");
      paramArrayOfByte.append(paramxi.b);
      paramArrayOfByte.append("] seq[");
      paramArrayOfByte.append(paramxi.c);
      paramArrayOfByte.append("] traceID[");
      paramArrayOfByte.append(xi.d);
      paramArrayOfByte.append("] version[");
      paramArrayOfByte.append(paramxi.g);
      paramArrayOfByte.append("] echo[");
      paramArrayOfByte.append(xi.k);
      paramArrayOfByte.append("]");
      xv.a(paramArrayOfByte.toString());
      return 0;
    }
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xj
 * JD-Core Version:    0.7.0.1
 */