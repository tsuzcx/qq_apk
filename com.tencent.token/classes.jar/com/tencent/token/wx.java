package com.tencent.token;

public final class wx
{
  public static int a(byte[] paramArrayOfByte, int paramInt, ww paramww)
  {
    if (paramInt <= 42) {
      return -1;
    }
    if ((paramArrayOfByte[0] == 2) && (paramArrayOfByte[(paramInt - 1)] == 3))
    {
      paramww.a = sz.a(paramArrayOfByte, 1);
      if (paramww.a != paramInt) {
        return -3;
      }
      paramww.b = sz.a(paramArrayOfByte, 3);
      paramww.c = sz.b(paramArrayOfByte, 5);
      ww.d = sz.b(paramArrayOfByte, 9);
      paramww.e = sz.a(paramArrayOfByte, 13);
      paramww.f = sz.a(paramArrayOfByte, 15);
      paramww.g = sz.a(paramArrayOfByte, 17);
      paramww.h = sz.b(paramArrayOfByte, 19);
      paramww.i = paramArrayOfByte[23];
      paramww.j = paramArrayOfByte[24];
      sz.b(paramArrayOfByte, 25, ww.k, 16);
      paramArrayOfByte = new StringBuilder("socket parse msg head: totallen[");
      paramArrayOfByte.append(paramww.a);
      paramArrayOfByte.append("] msgtype[");
      paramArrayOfByte.append(paramww.b);
      paramArrayOfByte.append("] seq[");
      paramArrayOfByte.append(paramww.c);
      paramArrayOfByte.append("] traceID[");
      paramArrayOfByte.append(ww.d);
      paramArrayOfByte.append("] version[");
      paramArrayOfByte.append(paramww.g);
      paramArrayOfByte.append("] echo[");
      paramArrayOfByte.append(ww.k);
      paramArrayOfByte.append("]");
      xj.a(paramArrayOfByte.toString());
      return 0;
    }
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wx
 * JD-Core Version:    0.7.0.1
 */