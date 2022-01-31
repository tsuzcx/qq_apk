package com.tencent.token.core.push;

import com.tencent.token.ap;
import com.tencent.token.global.e;

public final class d
{
  public static int a(byte[] paramArrayOfByte, int paramInt, c paramc)
  {
    if (paramInt <= 42) {
      return -1;
    }
    if ((paramArrayOfByte[0] != 2) || (paramArrayOfByte[(paramInt - 1)] != 3)) {
      return -2;
    }
    paramc.a = ((short)(((paramArrayOfByte[1] & 0xFF) << 8) + ((paramArrayOfByte[2] & 0xFF) << 0)));
    if (paramc.a != paramInt) {
      return -3;
    }
    paramc.b = ((short)(((paramArrayOfByte[3] & 0xFF) << 8) + ((paramArrayOfByte[4] & 0xFF) << 0)));
    paramc.c = ap.a(paramArrayOfByte, 5);
    c.d = ap.a(paramArrayOfByte, 9);
    paramc.e = ((short)(((paramArrayOfByte[13] & 0xFF) << 8) + ((paramArrayOfByte[14] & 0xFF) << 0)));
    paramc.f = ((short)(((paramArrayOfByte[15] & 0xFF) << 8) + ((paramArrayOfByte[16] & 0xFF) << 0)));
    paramc.g = ((short)(((paramArrayOfByte[17] & 0xFF) << 8) + ((paramArrayOfByte[18] & 0xFF) << 0)));
    paramc.h = ap.a(paramArrayOfByte, 19);
    paramc.i = paramArrayOfByte[23];
    paramc.j = paramArrayOfByte[24];
    System.arraycopy(paramArrayOfByte, 25, c.k, 0, 16);
    e.a("socket parse msg head: totallen[" + paramc.a + "]" + " msgtype[" + paramc.b + "]" + " seq[" + paramc.c + "]" + " traceID[" + c.d + "]" + " version[" + paramc.g + "]" + " echo[" + c.k + "]");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.d
 * JD-Core Version:    0.7.0.1
 */