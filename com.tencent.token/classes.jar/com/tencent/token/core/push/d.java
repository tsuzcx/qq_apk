package com.tencent.token.core.push;

import com.tencent.token.ci;

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
    paramc.a = ci.a(paramArrayOfByte, 1);
    if (paramc.a != paramInt) {
      return -3;
    }
    paramc.b = ci.a(paramArrayOfByte, 3);
    paramc.c = ci.b(paramArrayOfByte, 5);
    c.d = ci.b(paramArrayOfByte, 9);
    paramc.e = ci.a(paramArrayOfByte, 13);
    paramc.f = ci.a(paramArrayOfByte, 15);
    paramc.g = ci.a(paramArrayOfByte, 17);
    paramc.h = ci.b(paramArrayOfByte, 19);
    paramc.i = paramArrayOfByte[23];
    paramc.j = paramArrayOfByte[24];
    ci.b(paramArrayOfByte, 25, c.k, 16);
    com.tencent.token.global.g.a("socket parse msg head: totallen[" + paramc.a + "] msgtype[" + paramc.b + "] seq[" + paramc.c + "] traceID[" + c.d + "] version[" + paramc.g + "] echo[" + c.k + "]");
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, e parame)
  {
    if (paramInt > 434) {
      return -4;
    }
    parame.n = ci.b(paramArrayOfByte, 41);
    paramInt = ci.a(paramArrayOfByte, 45);
    parame.o = new byte[paramInt];
    ci.b(paramArrayOfByte, 47, parame.o, paramInt);
    paramInt += 47;
    int i = ci.a(paramArrayOfByte, paramInt);
    parame.m = new byte[i];
    ci.b(paramArrayOfByte, paramInt + 2, parame.m, i);
    com.tencent.token.global.g.a("socket parse exchange key: ret[" + parame.n + "] spKeyLen[" + i + "] spKey[" + new String(parame.m) + "]");
    return (int)parame.n;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, g paramg)
  {
    if (paramInt > 1102) {
      return -4;
    }
    paramg.m = ci.a(paramArrayOfByte, 41);
    paramg.n = new byte[paramg.m];
    ci.b(paramArrayOfByte, 43, paramg.n, paramg.m);
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, h paramh)
  {
    if (paramInt > 434) {
      return -4;
    }
    paramh.m = ci.b(paramArrayOfByte, 41);
    paramh.n = ci.b(paramArrayOfByte, 45);
    paramInt = ci.a(paramArrayOfByte, 49);
    paramh.o = new byte[paramInt];
    ci.b(paramArrayOfByte, 51, paramh.o, paramInt);
    paramInt += 51;
    int i = ci.a(paramArrayOfByte, paramInt);
    paramh.p = new byte[i];
    ci.b(paramArrayOfByte, paramInt + 2, paramh.p, i);
    com.tencent.token.global.g.a("socket parse client verify: ret[" + paramh.m + "] server_time[" + paramh.n + "] sig_len[" + i + "] sig[" + new String(paramh.p) + "]");
    return (int)paramh.m;
  }
  
  public static byte[] a(byte paramByte)
  {
    c localc = new c((short)3, (byte)0, (byte)0);
    localc.l = new byte[5];
    localc.l[0] = ((byte)com.tencent.token.global.c.b());
    localc.l[1] = ((byte)com.tencent.token.global.c.c());
    ci.a(localc.l, 2, com.tencent.token.global.c.d());
    localc.l[4] = paramByte;
    return localc.a();
  }
  
  public static byte[] a(int paramInt, short paramShort, String paramString)
  {
    c localc = new c((short)203, (byte)0, (byte)0);
    localc.l = new byte[paramShort + 6];
    ci.a(localc.l, 0, paramInt);
    ci.a(localc.l, 4, paramShort);
    ci.a(localc.l, 6, paramString.getBytes(), paramShort);
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
    ci.a(localc.l, 2, com.tencent.token.global.c.d());
    ci.a(localc.l, 4, (short)paramString.length());
    ci.a(localc.l, 6, paramString.getBytes(), paramString.length());
    return localc.a();
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    c localc = new c((short)2, (byte)1, (byte)0);
    localc.l = new byte[paramArrayOfByte.length + 2];
    ci.a(localc.l, 0, (short)paramArrayOfByte.length);
    ci.a(localc.l, 2, paramArrayOfByte, paramArrayOfByte.length);
    return localc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.d
 * JD-Core Version:    0.7.0.1
 */