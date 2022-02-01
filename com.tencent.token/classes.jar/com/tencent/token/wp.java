package com.tencent.token;

public final class wp
{
  public static int a(byte[] paramArrayOfByte, int paramInt, wo paramwo)
  {
    if (paramInt <= 42) {
      return -1;
    }
    if ((paramArrayOfByte[0] == 2) && (paramArrayOfByte[(paramInt - 1)] == 3))
    {
      paramwo.a = sr.a(paramArrayOfByte, 1);
      if (paramwo.a != paramInt) {
        return -3;
      }
      paramwo.b = sr.a(paramArrayOfByte, 3);
      paramwo.c = sr.b(paramArrayOfByte, 5);
      wo.d = sr.b(paramArrayOfByte, 9);
      paramwo.e = sr.a(paramArrayOfByte, 13);
      paramwo.f = sr.a(paramArrayOfByte, 15);
      paramwo.g = sr.a(paramArrayOfByte, 17);
      paramwo.h = sr.b(paramArrayOfByte, 19);
      paramwo.i = paramArrayOfByte[23];
      paramwo.j = paramArrayOfByte[24];
      sr.b(paramArrayOfByte, 25, wo.k, 16);
      paramArrayOfByte = new StringBuilder("socket parse msg head: totallen[");
      paramArrayOfByte.append(paramwo.a);
      paramArrayOfByte.append("] msgtype[");
      paramArrayOfByte.append(paramwo.b);
      paramArrayOfByte.append("] seq[");
      paramArrayOfByte.append(paramwo.c);
      paramArrayOfByte.append("] traceID[");
      paramArrayOfByte.append(wo.d);
      paramArrayOfByte.append("] version[");
      paramArrayOfByte.append(paramwo.g);
      paramArrayOfByte.append("] echo[");
      paramArrayOfByte.append(wo.k);
      paramArrayOfByte.append("]");
      xa.a(paramArrayOfByte.toString());
      return 0;
    }
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wp
 * JD-Core Version:    0.7.0.1
 */