package com.tencent.token.core.push;

import com.tencent.token.dg;
import com.tencent.token.global.c;

public class i
{
  public static int a(byte[] paramArrayOfByte, int paramInt, h paramh)
  {
    if (paramInt <= 42) {
      return -1;
    }
    if ((paramArrayOfByte[0] != 2) || (paramArrayOfByte[(paramInt - 1)] != 3)) {
      return -2;
    }
    paramh.a = dg.a(paramArrayOfByte, 1);
    if (paramh.a != paramInt) {
      return -3;
    }
    paramh.b = dg.a(paramArrayOfByte, 3);
    paramh.c = dg.b(paramArrayOfByte, 5);
    h.d = dg.b(paramArrayOfByte, 9);
    paramh.e = dg.a(paramArrayOfByte, 13);
    paramh.f = dg.a(paramArrayOfByte, 15);
    paramh.g = dg.a(paramArrayOfByte, 17);
    paramh.h = dg.b(paramArrayOfByte, 19);
    paramh.i = paramArrayOfByte[23];
    paramh.j = paramArrayOfByte[24];
    dg.b(paramArrayOfByte, 25, h.k, 16);
    com.tencent.token.global.h.a("socket parse msg head: totallen[" + paramh.a + "] msgtype[" + paramh.b + "] seq[" + paramh.c + "] traceID[" + h.d + "] version[" + paramh.g + "] echo[" + h.k + "]");
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, l paraml)
  {
    if (paramInt > 434) {
      return -4;
    }
    paraml.n = dg.b(paramArrayOfByte, 41);
    paramInt = dg.a(paramArrayOfByte, 45);
    paraml.o = new byte[paramInt];
    dg.b(paramArrayOfByte, 47, paraml.o, paramInt);
    paramInt += 47;
    int i = dg.a(paramArrayOfByte, paramInt);
    paraml.m = new byte[i];
    dg.b(paramArrayOfByte, paramInt + 2, paraml.m, i);
    com.tencent.token.global.h.a("socket parse exchange key: ret[" + paraml.n + "] spKeyLen[" + i + "] spKey[" + new String(paraml.m) + "]");
    return (int)paraml.n;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, n paramn)
  {
    if (paramInt > 1102) {
      return -4;
    }
    paramn.m = dg.a(paramArrayOfByte, 41);
    paramn.n = new byte[paramn.m];
    dg.b(paramArrayOfByte, 43, paramn.n, paramn.m);
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, o paramo)
  {
    if (paramInt > 434) {
      return -4;
    }
    paramo.m = dg.b(paramArrayOfByte, 41);
    paramo.n = dg.b(paramArrayOfByte, 45);
    paramInt = dg.a(paramArrayOfByte, 49);
    paramo.o = new byte[paramInt];
    dg.b(paramArrayOfByte, 51, paramo.o, paramInt);
    paramInt += 51;
    int i = dg.a(paramArrayOfByte, paramInt);
    paramo.p = new byte[i];
    dg.b(paramArrayOfByte, paramInt + 2, paramo.p, i);
    com.tencent.token.global.h.a("socket parse client verify: ret[" + paramo.m + "] server_time[" + paramo.n + "] sig_len[" + i + "] sig[" + new String(paramo.p) + "]");
    return (int)paramo.m;
  }
  
  public static byte[] a(byte paramByte)
  {
    h localh = new h((short)3, (byte)0, (byte)0);
    localh.l = new byte[5];
    localh.l[0] = ((byte)c.b());
    localh.l[1] = ((byte)c.c());
    dg.a(localh.l, 2, c.d());
    localh.l[4] = paramByte;
    return localh.a();
  }
  
  public static byte[] a(int paramInt, short paramShort, String paramString)
  {
    h localh = new h((short)203, (byte)0, (byte)0);
    localh.l = new byte[paramShort + 6];
    dg.a(localh.l, 0, paramInt);
    dg.a(localh.l, 4, paramShort);
    dg.a(localh.l, 6, paramString.getBytes(), paramShort);
    return localh.a();
  }
  
  public static byte[] a(String paramString)
  {
    h localh = new h((short)1, (byte)0, (byte)0);
    int i = paramString.length();
    com.tencent.token.global.h.a("socket make exchange key req pubkey: " + paramString + ", len:" + paramString.length());
    localh.l = new byte[i + 6];
    localh.l[0] = ((byte)c.b());
    localh.l[1] = ((byte)c.c());
    dg.a(localh.l, 2, c.d());
    dg.a(localh.l, 4, (short)paramString.length());
    dg.a(localh.l, 6, paramString.getBytes(), paramString.length());
    return localh.a();
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    h localh = new h((short)2, (byte)1, (byte)0);
    localh.l = new byte[paramArrayOfByte.length + 2];
    dg.a(localh.l, 0, (short)paramArrayOfByte.length);
    dg.a(localh.l, 2, paramArrayOfByte, paramArrayOfByte.length);
    return localh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.i
 * JD-Core Version:    0.7.0.1
 */