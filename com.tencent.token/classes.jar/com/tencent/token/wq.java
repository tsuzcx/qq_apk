package com.tencent.token;

public final class wq
{
  public static int a(byte[] paramArrayOfByte, int paramInt, wp paramwp)
  {
    if (paramInt <= 42) {
      return -1;
    }
    if ((paramArrayOfByte[0] == 2) && (paramArrayOfByte[(paramInt - 1)] == 3))
    {
      paramwp.a = ss.a(paramArrayOfByte, 1);
      if (paramwp.a != paramInt) {
        return -3;
      }
      paramwp.b = ss.a(paramArrayOfByte, 3);
      paramwp.c = ss.b(paramArrayOfByte, 5);
      wp.d = ss.b(paramArrayOfByte, 9);
      paramwp.e = ss.a(paramArrayOfByte, 13);
      paramwp.f = ss.a(paramArrayOfByte, 15);
      paramwp.g = ss.a(paramArrayOfByte, 17);
      paramwp.h = ss.b(paramArrayOfByte, 19);
      paramwp.i = paramArrayOfByte[23];
      paramwp.j = paramArrayOfByte[24];
      ss.b(paramArrayOfByte, 25, wp.k, 16);
      paramArrayOfByte = new StringBuilder("socket parse msg head: totallen[");
      paramArrayOfByte.append(paramwp.a);
      paramArrayOfByte.append("] msgtype[");
      paramArrayOfByte.append(paramwp.b);
      paramArrayOfByte.append("] seq[");
      paramArrayOfByte.append(paramwp.c);
      paramArrayOfByte.append("] traceID[");
      paramArrayOfByte.append(wp.d);
      paramArrayOfByte.append("] version[");
      paramArrayOfByte.append(paramwp.g);
      paramArrayOfByte.append("] echo[");
      paramArrayOfByte.append(wp.k);
      paramArrayOfByte.append("]");
      xb.a(paramArrayOfByte.toString());
      return 0;
    }
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wq
 * JD-Core Version:    0.7.0.1
 */