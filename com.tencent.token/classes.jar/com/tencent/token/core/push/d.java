package com.tencent.token.core.push;

import com.tencent.token.ck;

public class d
{
  public static int a(byte[] paramArrayOfByte, int paramInt, c paramc)
  {
    if (paramInt <= 42) {
      return -1;
    }
    if ((paramArrayOfByte[0] == 2) && (paramArrayOfByte[(paramInt - 1)] == 3))
    {
      paramc.a = ck.a(paramArrayOfByte, 1);
      if (paramc.a != paramInt) {
        return -3;
      }
      paramc.b = ck.a(paramArrayOfByte, 3);
      paramc.c = ck.b(paramArrayOfByte, 5);
      c.d = ck.b(paramArrayOfByte, 9);
      paramc.e = ck.a(paramArrayOfByte, 13);
      paramc.f = ck.a(paramArrayOfByte, 15);
      paramc.g = ck.a(paramArrayOfByte, 17);
      paramc.h = ck.b(paramArrayOfByte, 19);
      paramc.i = paramArrayOfByte[23];
      paramc.j = paramArrayOfByte[24];
      ck.b(paramArrayOfByte, 25, c.k, 16);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("socket parse msg head: totallen[");
      paramArrayOfByte.append(paramc.a);
      paramArrayOfByte.append("] msgtype[");
      paramArrayOfByte.append(paramc.b);
      paramArrayOfByte.append("] seq[");
      paramArrayOfByte.append(paramc.c);
      paramArrayOfByte.append("] traceID[");
      paramArrayOfByte.append(c.d);
      paramArrayOfByte.append("] version[");
      paramArrayOfByte.append(paramc.g);
      paramArrayOfByte.append("] echo[");
      paramArrayOfByte.append(c.k);
      paramArrayOfByte.append("]");
      com.tencent.token.global.g.a(paramArrayOfByte.toString());
      return 0;
    }
    return -2;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, e parame)
  {
    if (paramInt > 434) {
      return -4;
    }
    parame.n = ck.b(paramArrayOfByte, 41);
    paramInt = ck.a(paramArrayOfByte, 45);
    parame.o = new byte[paramInt];
    ck.b(paramArrayOfByte, 47, parame.o, paramInt);
    paramInt = 47 + paramInt;
    int i = ck.a(paramArrayOfByte, paramInt);
    parame.m = new byte[i];
    ck.b(paramArrayOfByte, paramInt + 2, parame.m, i);
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("socket parse exchange key: ret[");
    paramArrayOfByte.append(parame.n);
    paramArrayOfByte.append("] spKeyLen[");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append("] spKey[");
    paramArrayOfByte.append(new String(parame.m));
    paramArrayOfByte.append("]");
    com.tencent.token.global.g.a(paramArrayOfByte.toString());
    return (int)parame.n;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, g paramg)
  {
    if (paramInt > 1102) {
      return -4;
    }
    paramg.m = ck.a(paramArrayOfByte, 41);
    paramg.n = new byte[paramg.m];
    ck.b(paramArrayOfByte, 43, paramg.n, paramg.m);
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, h paramh)
  {
    if (paramInt > 434) {
      return -4;
    }
    paramh.m = ck.b(paramArrayOfByte, 41);
    paramh.n = ck.b(paramArrayOfByte, 45);
    paramInt = ck.a(paramArrayOfByte, 49);
    paramh.o = new byte[paramInt];
    ck.b(paramArrayOfByte, 51, paramh.o, paramInt);
    paramInt = 51 + paramInt;
    int i = ck.a(paramArrayOfByte, paramInt);
    paramh.p = new byte[i];
    ck.b(paramArrayOfByte, paramInt + 2, paramh.p, i);
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("socket parse client verify: ret[");
    paramArrayOfByte.append(paramh.m);
    paramArrayOfByte.append("] server_time[");
    paramArrayOfByte.append(paramh.n);
    paramArrayOfByte.append("] sig_len[");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append("] sig[");
    paramArrayOfByte.append(new String(paramh.p));
    paramArrayOfByte.append("]");
    com.tencent.token.global.g.a(paramArrayOfByte.toString());
    return (int)paramh.m;
  }
  
  public static byte[] a(byte paramByte)
  {
    c localc = new c((short)3, (byte)0, (byte)0);
    localc.l = new byte[5];
    localc.l[0] = ((byte)com.tencent.token.global.c.b());
    localc.l[1] = ((byte)com.tencent.token.global.c.c());
    ck.a(localc.l, 2, com.tencent.token.global.c.d());
    localc.l[4] = paramByte;
    return localc.a();
  }
  
  public static byte[] a(int paramInt, short paramShort, String paramString)
  {
    c localc = new c((short)203, (byte)0, (byte)0);
    localc.l = new byte[paramShort + 6];
    ck.a(localc.l, 0, paramInt);
    ck.a(localc.l, 4, paramShort);
    ck.a(localc.l, 6, paramString.getBytes(), paramShort);
    return localc.a();
  }
  
  public static byte[] a(String paramString)
  {
    c localc = new c((short)1, (byte)0, (byte)0);
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("socket make exchange key req pubkey: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", len:");
    localStringBuilder.append(paramString.length());
    com.tencent.token.global.g.a(localStringBuilder.toString());
    localc.l = new byte[i + 6];
    localc.l[0] = ((byte)com.tencent.token.global.c.b());
    localc.l[1] = ((byte)com.tencent.token.global.c.c());
    ck.a(localc.l, 2, com.tencent.token.global.c.d());
    ck.a(localc.l, 4, (short)paramString.length());
    ck.a(localc.l, 6, paramString.getBytes(), paramString.length());
    return localc.a();
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    c localc = new c((short)2, (byte)1, (byte)0);
    localc.l = new byte[paramArrayOfByte.length + 2];
    ck.a(localc.l, 0, (short)paramArrayOfByte.length);
    ck.a(localc.l, 2, paramArrayOfByte, paramArrayOfByte.length);
    return localc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.d
 * JD-Core Version:    0.7.0.1
 */