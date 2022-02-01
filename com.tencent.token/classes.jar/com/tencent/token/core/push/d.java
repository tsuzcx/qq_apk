package com.tencent.token.core.push;

import com.tencent.token.cj;

public class d
{
  public static int a(byte[] paramArrayOfByte, int paramInt, c paramc)
  {
    if (paramInt <= 42) {
      return -1;
    }
    if ((paramArrayOfByte[0] != 2) || (paramArrayOfByte[(paramInt - 1)] != 3)) {
      return -2;
    }
    paramc.a = cj.a(paramArrayOfByte, 1);
    if (paramc.a != paramInt) {
      return -3;
    }
    paramc.b = cj.a(paramArrayOfByte, 3);
    paramc.c = cj.b(paramArrayOfByte, 5);
    c.d = cj.b(paramArrayOfByte, 9);
    paramc.e = cj.a(paramArrayOfByte, 13);
    paramc.f = cj.a(paramArrayOfByte, 15);
    paramc.g = cj.a(paramArrayOfByte, 17);
    paramc.h = cj.b(paramArrayOfByte, 19);
    paramc.i = paramArrayOfByte[23];
    paramc.j = paramArrayOfByte[24];
    cj.b(paramArrayOfByte, 25, c.k, 16);
    com.tencent.token.global.g.a("socket parse msg head: totallen[" + paramc.a + "] msgtype[" + paramc.b + "] seq[" + paramc.c + "] traceID[" + c.d + "] version[" + paramc.g + "] echo[" + c.k + "]");
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, e parame)
  {
    if (paramInt > 434) {
      return -4;
    }
    parame.n = cj.b(paramArrayOfByte, 41);
    paramInt = cj.a(paramArrayOfByte, 45);
    parame.o = new byte[paramInt];
    cj.b(paramArrayOfByte, 47, parame.o, paramInt);
    paramInt += 47;
    int i = cj.a(paramArrayOfByte, paramInt);
    parame.m = new byte[i];
    cj.b(paramArrayOfByte, paramInt + 2, parame.m, i);
    com.tencent.token.global.g.a("socket parse exchange key: ret[" + parame.n + "] spKeyLen[" + i + "] spKey[" + new String(parame.m) + "]");
    return (int)parame.n;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, g paramg)
  {
    if (paramInt > 1102) {
      return -4;
    }
    paramg.m = cj.a(paramArrayOfByte, 41);
    paramg.n = new byte[paramg.m];
    cj.b(paramArrayOfByte, 43, paramg.n, paramg.m);
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, h paramh)
  {
    if (paramInt > 434) {
      return -4;
    }
    paramh.m = cj.b(paramArrayOfByte, 41);
    paramh.n = cj.b(paramArrayOfByte, 45);
    paramInt = cj.a(paramArrayOfByte, 49);
    paramh.o = new byte[paramInt];
    cj.b(paramArrayOfByte, 51, paramh.o, paramInt);
    paramInt += 51;
    int i = cj.a(paramArrayOfByte, paramInt);
    paramh.p = new byte[i];
    cj.b(paramArrayOfByte, paramInt + 2, paramh.p, i);
    com.tencent.token.global.g.a("socket parse client verify: ret[" + paramh.m + "] server_time[" + paramh.n + "] sig_len[" + i + "] sig[" + new String(paramh.p) + "]");
    return (int)paramh.m;
  }
  
  public static byte[] a(byte paramByte)
  {
    c localc = new c((short)3, (byte)0, (byte)0);
    localc.l = new byte[5];
    localc.l[0] = ((byte)com.tencent.token.global.c.b());
    localc.l[1] = ((byte)com.tencent.token.global.c.c());
    cj.a(localc.l, 2, com.tencent.token.global.c.d());
    localc.l[4] = paramByte;
    return localc.a();
  }
  
  public static byte[] a(int paramInt, short paramShort, String paramString)
  {
    c localc = new c((short)203, (byte)0, (byte)0);
    localc.l = new byte[paramShort + 6];
    cj.a(localc.l, 0, paramInt);
    cj.a(localc.l, 4, paramShort);
    cj.a(localc.l, 6, paramString.getBytes(), paramShort);
    return localc.a();
  }
  
  public static byte[] a(String paramString)
  {
    c localc = new c((short)1, (byte)0, (byte)0);
    int i = paramString.length();
    com.tencent.token.global.g.a("socket make exchange key req pubkey: " + paramString + ", len:" + paramString.length());
    localc.l = new byte[i + 6];
    localc.l[0] = ((byte)com.tencent.token.global.c.b());
    localc.l[1] = ((byte)com.tencent.token.global.c.c());
    cj.a(localc.l, 2, com.tencent.token.global.c.d());
    cj.a(localc.l, 4, (short)paramString.length());
    cj.a(localc.l, 6, paramString.getBytes(), paramString.length());
    return localc.a();
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    c localc = new c((short)2, (byte)1, (byte)0);
    localc.l = new byte[paramArrayOfByte.length + 2];
    cj.a(localc.l, 0, (short)paramArrayOfByte.length);
    cj.a(localc.l, 2, paramArrayOfByte, paramArrayOfByte.length);
    return localc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.d
 * JD-Core Version:    0.7.0.1
 */