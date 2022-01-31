package com.tencent.token.core.push;

import com.tencent.token.ag;
import com.tencent.token.ap;
import com.tencent.token.fu;
import com.tencent.token.global.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import oicq.wlogin_sdk.tools.MD5;

public final class a
{
  static a a = null;
  private static int v = 0;
  private static String[] y = null;
  private static int[] z = null;
  private int A = 10;
  private int B = 300000;
  private int C = 300000;
  private int D = 0;
  private final int[] E = { 1000, 5000, 10000, 20000, 30000, 60000, 90000, 120000, 180000, 300000 };
  private final int F = 3000;
  private final int G = 3000;
  public final byte b = 0;
  public final byte c = 1;
  byte[] d = null;
  private final long e = 2L;
  private final fu f = new fu("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private fu g = new fu("-1");
  private byte[] h;
  private String i = "";
  private final int j = 0;
  private final int k = 1;
  private final int l = 101;
  private final int m = 102;
  private final int n = 103;
  private final int o = 104;
  private final int p = 105;
  private final int q = 106;
  private final int r = 107;
  private final int s = 108;
  private final int t = 109;
  private Socket u = null;
  private long w;
  private long x;
  
  private int a(InputStream paramInputStream, boolean paramBoolean)
  {
    int i2;
    if ((paramInputStream == null) || (this.u == null))
    {
      v = 5;
      h();
      i2 = -2;
      return i2;
    }
    byte[] arrayOfByte;
    int i3;
    Object localObject;
    int i1;
    try
    {
      this.u.setSoTimeout(3000);
      if (paramBoolean) {
        paramInputStream.skip(paramInputStream.available());
      }
      arrayOfByte = new byte[5];
      paramInputStream.read(arrayOfByte);
      i3 = (short)(((arrayOfByte[1] & 0xFF) << 8) + ((arrayOfByte[2] & 0xFF) << 0));
      if (i3 <= 42)
      {
        e.c("socket rsp msg len not correct: " + i3);
        return -1;
      }
      i2 = (short)(((arrayOfByte[3] & 0xFF) << 8) + ((arrayOfByte[4] & 0xFF) << 0));
      localObject = new byte[i3];
      i1 = 0;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      e.c("socket decodeInputSream failed" + paramInputStream.toString());
      v = 5;
      h();
      return -2;
      paramInputStream = new i();
      i2 = d.a((byte[])localObject, i3, paramInputStream);
      i1 = i2;
      if (i2 != 0) {
        break label1184;
      }
      if (i3 <= 434) {
        break label386;
      }
      i2 = -4;
      i1 = i2;
      if (i2 != 0) {
        break label1184;
      }
      paramInputStream = new fu(new String(paramInputStream.m), 16);
      paramInputStream = com.tencent.token.utils.encrypt.b.a(this.g, paramInputStream, this.f);
      if (paramInputStream != null) {
        break label577;
      }
      for (paramInputStream = null;; paramInputStream = MD5.toMD5Byte(ap.a(paramInputStream.a())))
      {
        this.h = paramInputStream;
        i1 = i2;
        if (this.h != null) {
          break label1184;
        }
        i1 = 1;
        break label1184;
        paramInputStream.n = ap.a((byte[])localObject, 41);
        i1 = (short)(((localObject[45] & 0xFF) << 8) + ((localObject[46] & 0xFF) << 0));
        paramInputStream.o = new byte[i1];
        System.arraycopy(localObject, 47, paramInputStream.o, 0, i1);
        i1 += 47;
        i2 = (short)(((localObject[i1] & 0xFF) << 8) + ((localObject[(i1 + 1)] & 0xFF) << 0));
        paramInputStream.m = new byte[i2];
        System.arraycopy(localObject, i1 + 2, paramInputStream.m, 0, i2);
        e.a("socket parse exchange key: ret[" + paramInputStream.n + "]" + " spKeyLen[" + i2 + "]" + " spKey[" + new String(paramInputStream.m) + "]");
        i2 = (int)paramInputStream.n;
        break;
      }
      paramInputStream = new l();
      i2 = d.a((byte[])localObject, i3, paramInputStream);
      i1 = i2;
      if (i2 != 0) {
        break label1184;
      }
      if (i3 <= 434) {
        break label748;
      }
      i2 = -4;
      if ((i2 == 0) || (paramInputStream.n <= 0L)) {
        break label678;
      }
      l1 = System.currentTimeMillis();
      l2 = paramInputStream.n;
      localObject = ag.c();
      ((ag)localObject).a(l2 * 1000L - l1);
      ((ag)localObject).i();
      i1 = i2;
      if (i2 != 0) {
        break label1184;
      }
      this.i = new String(paramInputStream.p);
      i1 = i2;
      break label1184;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      e.c("socket decodeInputSream failed" + paramInputStream.toString());
      v = 5;
      h();
      return -2;
    }
    paramInputStream.read((byte[])localObject, 5, i3 - 5);
    e.a("socket pkg type: " + i2);
    switch (i2)
    {
    }
    for (;;)
    {
      h();
      v = 7;
      return i1;
      for (;;)
      {
        label386:
        label577:
        long l1;
        long l2;
        label678:
        label748:
        paramInputStream.m = ap.a((byte[])localObject, 41);
        paramInputStream.n = ap.a((byte[])localObject, 45);
        i1 = (short)(((localObject[49] & 0xFF) << 8) + ((localObject[50] & 0xFF) << 0));
        paramInputStream.o = new byte[i1];
        System.arraycopy(localObject, 51, paramInputStream.o, 0, i1);
        i1 += 51;
        i2 = (short)(((localObject[i1] & 0xFF) << 8) + ((localObject[(i1 + 1)] & 0xFF) << 0));
        paramInputStream.p = new byte[i2];
        System.arraycopy(localObject, i1 + 2, paramInputStream.p, 0, i2);
        e.a("socket parse client verify: ret[" + paramInputStream.m + "]" + " server_time[" + paramInputStream.n + "]" + " sig_len[" + i2 + "]" + " sig[" + new String(paramInputStream.p) + "]");
        i2 = (int)paramInputStream.m;
      }
      paramInputStream = new k();
      i2 = d.a((byte[])localObject, i3, paramInputStream);
      i1 = i2;
      if (i2 == 0)
      {
        if (i3 > 1102) {}
        for (i2 = -4;; i2 = 0)
        {
          i1 = i2;
          if (i2 != 0) {
            break label1184;
          }
          this.d = a(paramInputStream.n);
          if (this.d == null) {
            this.d = a(paramInputStream.n);
          }
          i1 = i2;
          if (this.d != null) {
            break label1184;
          }
          break;
          paramInputStream.m = ((short)(((localObject[41] & 0xFF) << 8) + ((localObject[42] & 0xFF) << 0)));
          paramInputStream.n = new byte[paramInputStream.m];
          System.arraycopy(localObject, 43, paramInputStream.n, 0, paramInputStream.m);
        }
        v = 5;
        h();
        return i1;
        h();
        v = 6;
        this.x = System.currentTimeMillis();
        return i1;
        h();
        v = 8;
        return i1;
        while (i1 < 5)
        {
          localObject[i1] = arrayOfByte[i1];
          i1 += 1;
        }
        i1 = 101;
      }
      label1184:
      i2 = i1;
      if (i1 == 0) {
        break;
      }
      switch (i1)
      {
      }
    }
  }
  
  public static a a()
  {
    if (a == null)
    {
      a = new a();
      v = 0;
    }
    return a;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new com.tencent.token.utils.encrypt.a().a(paramArrayOfByte, this.h);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      e.c(paramArrayOfByte.toString());
    }
    return null;
  }
  
  public static void b()
  {
    a = null;
  }
  
  private void e()
  {
    if (this.u == null)
    {
      v = 5;
      h();
    }
    for (;;)
    {
      return;
      this.g = com.tencent.token.utils.encrypt.b.a();
      Object localObject1 = com.tencent.token.utils.encrypt.b.a(this.g, this.f);
      if ((this.g == null) || (localObject1 == null) || (((String)localObject1).length() == 0))
      {
        h();
        v = 6;
        this.x = System.currentTimeMillis();
        return;
      }
      Object localObject2 = new c((short)1, (byte)0);
      int i1 = ((String)localObject1).length();
      e.a("socket make exchange key req pubkey: " + (String)localObject1 + ", len:" + ((String)localObject1).length());
      ((c)localObject2).l = new byte[i1 + 6];
      ((c)localObject2).l[0] = 4;
      ((c)localObject2).l[1] = 2;
      Object localObject3 = ((c)localObject2).l;
      i1 = com.tencent.token.global.b.b();
      localObject3[2] = ((byte)(i1 >> 8));
      localObject3[3] = ((byte)i1);
      localObject3 = ((c)localObject2).l;
      i1 = (short)((String)localObject1).length();
      localObject3[4] = ((byte)(i1 >> 8));
      localObject3[5] = ((byte)i1);
      localObject3 = ((c)localObject2).l;
      System.arraycopy(((String)localObject1).getBytes(), 0, localObject3, 6, ((String)localObject1).length());
      localObject1 = ((c)localObject2).a();
      try
      {
        localObject2 = this.u.getOutputStream();
        localObject3 = this.u.getInputStream();
        ((OutputStream)localObject2).write((byte[])localObject1);
        ((OutputStream)localObject2).flush();
        e.a("socket available: " + ((InputStream)localObject3).available());
        i1 = a((InputStream)localObject3, false);
        if (i1 == 0)
        {
          v = 3;
          f();
          return;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        e.c("socket exchange key failed" + localIOException.toString());
        v = 5;
        h();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        e.c("socket exchange key failed" + localException.toString());
        v = 5;
        h();
      }
    }
  }
  
  private void f()
  {
    if (this.u == null)
    {
      v = 5;
      h();
    }
    for (;;)
    {
      return;
      Object localObject2 = ag.c();
      ((ag)localObject2).m();
      long l1 = ((ag)localObject2).k();
      Object localObject1 = ag.b();
      localObject2 = ((ag)localObject2).o();
      Object localObject3 = new byte[((String)localObject2).length() + 10 + 2 + ((String)localObject1).length() + 2 + this.i.length()];
      localObject3[0] = ((byte)(int)(l1 >> 56));
      localObject3[1] = ((byte)(int)(l1 >> 48));
      localObject3[2] = ((byte)(int)(l1 >> 40));
      localObject3[3] = ((byte)(int)(l1 >> 32));
      localObject3[4] = ((byte)(int)(l1 >> 24));
      localObject3[5] = ((byte)(int)(l1 >> 16));
      localObject3[6] = ((byte)(int)(l1 >> 8));
      localObject3[7] = ((byte)(int)l1);
      int i1 = (short)((String)localObject2).length();
      localObject3[8] = ((byte)(i1 >> 8));
      localObject3[9] = ((byte)i1);
      System.arraycopy(((String)localObject2).getBytes(), 0, localObject3, 10, ((String)localObject2).length());
      i1 = ((String)localObject2).length() + 10;
      int i2 = (short)((String)localObject1).length();
      localObject3[i1] = ((byte)(i2 >> 8));
      localObject3[(i1 + 1)] = ((byte)i2);
      i1 += 2;
      System.arraycopy(((String)localObject1).getBytes(), 0, localObject3, i1, ((String)localObject1).length());
      i1 += ((String)localObject1).length();
      i2 = (short)this.i.length();
      localObject3[i1] = ((byte)(i2 >> 8));
      localObject3[(i1 + 1)] = ((byte)i2);
      System.arraycopy(this.i.getBytes(), 0, localObject3, i1 + 2, this.i.length());
      localObject1 = new com.tencent.token.utils.encrypt.a().b((byte[])localObject3, this.h);
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        e.c("encrypt data failed");
        localObject2 = null;
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new com.tencent.token.utils.encrypt.a().b((byte[])localObject3, this.h);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          e.c("encrypt data failed");
          localObject1 = null;
        }
      }
      if (localObject1 == null)
      {
        h();
        v = 7;
        return;
      }
      localObject2 = new c((short)2, (byte)1);
      ((c)localObject2).l = new byte[localObject1.length + 2];
      localObject3 = ((c)localObject2).l;
      i1 = (short)localObject1.length;
      localObject3[0] = ((byte)(i1 >> 8));
      localObject3[1] = ((byte)i1);
      System.arraycopy(localObject1, 0, ((c)localObject2).l, 2, localObject1.length);
      localObject1 = ((c)localObject2).a();
      try
      {
        localObject2 = this.u.getOutputStream();
        localObject3 = this.u.getInputStream();
        ((OutputStream)localObject2).write((byte[])localObject1);
        ((OutputStream)localObject2).flush();
        e.a("socket available: " + ((InputStream)localObject3).available());
        i1 = a((InputStream)localObject3, true);
        if (i1 == 0)
        {
          v = 4;
          return;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        e.c("socket client verify failed" + localIOException.toString());
        v = 5;
        h();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        e.c("socket client verify failed" + localException.toString());
        v = 5;
        h();
      }
    }
  }
  
  /* Error */
  private j g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/tencent/token/core/push/a:u	Ljava/net/Socket;
    //   4: ifnonnull +13 -> 17
    //   7: iconst_5
    //   8: putstatic 52	com/tencent/token/core/push/a:v	I
    //   11: aload_0
    //   12: invokespecial 140	com/tencent/token/core/push/a:h	()V
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 114	com/tencent/token/core/push/a:d	[B
    //   22: aload_0
    //   23: getfield 112	com/tencent/token/core/push/a:u	Ljava/net/Socket;
    //   26: invokevirtual 344	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 112	com/tencent/token/core/push/a:u	Ljava/net/Socket;
    //   35: invokevirtual 348	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   38: astore 6
    //   40: invokestatic 260	java/lang/System:currentTimeMillis	()J
    //   43: lstore_3
    //   44: lload_3
    //   45: aload_0
    //   46: getfield 381	com/tencent/token/core/push/a:w	J
    //   49: lsub
    //   50: aload_0
    //   51: getfield 119	com/tencent/token/core/push/a:B	I
    //   54: i2l
    //   55: lcmp
    //   56: iflt +115 -> 171
    //   59: new 162	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 383
    //   69: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_3
    //   73: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 187	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: lload_3
    //   84: putfield 381	com/tencent/token/core/push/a:w	J
    //   87: new 320	com/tencent/token/core/push/c
    //   90: dup
    //   91: iconst_3
    //   92: iconst_0
    //   93: invokespecial 323	com/tencent/token/core/push/c:<init>	(SB)V
    //   96: astore 7
    //   98: aload 7
    //   100: iconst_5
    //   101: newarray byte
    //   103: putfield 329	com/tencent/token/core/push/c:l	[B
    //   106: aload 7
    //   108: getfield 329	com/tencent/token/core/push/c:l	[B
    //   111: iconst_0
    //   112: iconst_4
    //   113: bastore
    //   114: aload 7
    //   116: getfield 329	com/tencent/token/core/push/c:l	[B
    //   119: iconst_1
    //   120: iconst_2
    //   121: bastore
    //   122: aload 7
    //   124: getfield 329	com/tencent/token/core/push/c:l	[B
    //   127: astore 8
    //   129: invokestatic 334	com/tencent/token/global/b:b	()S
    //   132: istore_1
    //   133: aload 8
    //   135: iconst_2
    //   136: iload_1
    //   137: bipush 8
    //   139: ishr
    //   140: i2b
    //   141: bastore
    //   142: aload 8
    //   144: iconst_3
    //   145: iload_1
    //   146: i2b
    //   147: bastore
    //   148: aload 7
    //   150: getfield 329	com/tencent/token/core/push/c:l	[B
    //   153: iconst_4
    //   154: iconst_0
    //   155: bastore
    //   156: aload 5
    //   158: aload 7
    //   160: invokevirtual 340	com/tencent/token/core/push/c:a	()[B
    //   163: invokevirtual 353	java/io/OutputStream:write	([B)V
    //   166: aload 5
    //   168: invokevirtual 356	java/io/OutputStream:flush	()V
    //   171: aload 6
    //   173: invokevirtual 152	java/io/InputStream:available	()I
    //   176: ifle +13 -> 189
    //   179: aload_0
    //   180: aload 6
    //   182: iconst_0
    //   183: invokespecial 360	com/tencent/token/core/push/a:a	(Ljava/io/InputStream;Z)I
    //   186: ifne -171 -> 15
    //   189: aload_0
    //   190: getfield 114	com/tencent/token/core/push/a:d	[B
    //   193: ifnull -178 -> 15
    //   196: new 162	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 385
    //   206: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: getfield 114	com/tencent/token/core/push/a:d	[B
    //   213: arraylength
    //   214: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 187	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   223: new 387	com/tencent/token/core/push/j
    //   226: dup
    //   227: invokespecial 388	com/tencent/token/core/push/j:<init>	()V
    //   230: astore 6
    //   232: aload_0
    //   233: getfield 114	com/tencent/token/core/push/a:d	[B
    //   236: astore 7
    //   238: aload 6
    //   240: aload 7
    //   242: iconst_4
    //   243: baload
    //   244: i2l
    //   245: ldc2_w 389
    //   248: land
    //   249: bipush 56
    //   251: lshl
    //   252: aload 7
    //   254: iconst_5
    //   255: baload
    //   256: i2l
    //   257: ldc2_w 389
    //   260: land
    //   261: bipush 48
    //   263: lshl
    //   264: ladd
    //   265: aload 7
    //   267: bipush 6
    //   269: baload
    //   270: i2l
    //   271: ldc2_w 389
    //   274: land
    //   275: bipush 40
    //   277: lshl
    //   278: ladd
    //   279: aload 7
    //   281: bipush 7
    //   283: baload
    //   284: i2l
    //   285: ldc2_w 389
    //   288: land
    //   289: bipush 32
    //   291: lshl
    //   292: ladd
    //   293: aload 7
    //   295: iconst_0
    //   296: baload
    //   297: i2l
    //   298: ldc2_w 389
    //   301: land
    //   302: bipush 24
    //   304: lshl
    //   305: ladd
    //   306: aload 7
    //   308: iconst_1
    //   309: baload
    //   310: i2l
    //   311: ldc2_w 389
    //   314: land
    //   315: bipush 16
    //   317: lshl
    //   318: ladd
    //   319: aload 7
    //   321: iconst_2
    //   322: baload
    //   323: i2l
    //   324: ldc2_w 389
    //   327: land
    //   328: bipush 8
    //   330: lshl
    //   331: ladd
    //   332: aload 7
    //   334: iconst_3
    //   335: baload
    //   336: i2l
    //   337: ldc2_w 389
    //   340: land
    //   341: ladd
    //   342: putfield 392	com/tencent/token/core/push/j:a	J
    //   345: aload_0
    //   346: getfield 114	com/tencent/token/core/push/a:d	[B
    //   349: astore 7
    //   351: aload 7
    //   353: bipush 8
    //   355: baload
    //   356: istore_1
    //   357: aload 7
    //   359: bipush 9
    //   361: baload
    //   362: sipush 255
    //   365: iand
    //   366: iconst_0
    //   367: ishl
    //   368: iload_1
    //   369: sipush 255
    //   372: iand
    //   373: bipush 8
    //   375: ishl
    //   376: iadd
    //   377: i2s
    //   378: istore_1
    //   379: aload 6
    //   381: iload_1
    //   382: newarray byte
    //   384: putfield 394	com/tencent/token/core/push/j:b	[B
    //   387: aload_0
    //   388: getfield 114	com/tencent/token/core/push/a:d	[B
    //   391: bipush 10
    //   393: aload 6
    //   395: getfield 394	com/tencent/token/core/push/j:b	[B
    //   398: iconst_0
    //   399: iload_1
    //   400: invokestatic 230	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   403: iload_1
    //   404: bipush 10
    //   406: iadd
    //   407: istore_1
    //   408: aload 6
    //   410: aload_0
    //   411: getfield 114	com/tencent/token/core/push/a:d	[B
    //   414: iload_1
    //   415: invokestatic 220	com/tencent/token/ap:a	([BI)J
    //   418: putfield 396	com/tencent/token/core/push/j:c	J
    //   421: iload_1
    //   422: iconst_4
    //   423: iadd
    //   424: istore_1
    //   425: aload 6
    //   427: aload_0
    //   428: getfield 114	com/tencent/token/core/push/a:d	[B
    //   431: iload_1
    //   432: baload
    //   433: putfield 398	com/tencent/token/core/push/j:d	B
    //   436: iload_1
    //   437: iconst_1
    //   438: iadd
    //   439: istore_1
    //   440: aload 6
    //   442: aload_0
    //   443: getfield 114	com/tencent/token/core/push/a:d	[B
    //   446: iload_1
    //   447: baload
    //   448: putfield 400	com/tencent/token/core/push/j:e	B
    //   451: iload_1
    //   452: iconst_1
    //   453: iadd
    //   454: istore_1
    //   455: aload 6
    //   457: aload_0
    //   458: getfield 114	com/tencent/token/core/push/a:d	[B
    //   461: iload_1
    //   462: invokestatic 220	com/tencent/token/ap:a	([BI)J
    //   465: putfield 402	com/tencent/token/core/push/j:f	J
    //   468: iload_1
    //   469: iconst_4
    //   470: iadd
    //   471: istore_1
    //   472: aload_0
    //   473: getfield 114	com/tencent/token/core/push/a:d	[B
    //   476: astore 7
    //   478: aload 7
    //   480: iload_1
    //   481: baload
    //   482: istore_2
    //   483: aload 7
    //   485: iload_1
    //   486: iconst_1
    //   487: iadd
    //   488: baload
    //   489: sipush 255
    //   492: iand
    //   493: iconst_0
    //   494: ishl
    //   495: iload_2
    //   496: sipush 255
    //   499: iand
    //   500: bipush 8
    //   502: ishl
    //   503: iadd
    //   504: i2s
    //   505: istore_2
    //   506: iload_1
    //   507: iconst_2
    //   508: iadd
    //   509: istore_1
    //   510: aload 6
    //   512: iload_2
    //   513: newarray byte
    //   515: putfield 404	com/tencent/token/core/push/j:g	[B
    //   518: aload_0
    //   519: getfield 114	com/tencent/token/core/push/a:d	[B
    //   522: iload_1
    //   523: aload 6
    //   525: getfield 404	com/tencent/token/core/push/j:g	[B
    //   528: iconst_0
    //   529: iload_2
    //   530: invokestatic 230	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   533: iload_1
    //   534: iload_2
    //   535: iadd
    //   536: istore_1
    //   537: aload_0
    //   538: getfield 114	com/tencent/token/core/push/a:d	[B
    //   541: astore 7
    //   543: aload 7
    //   545: iload_1
    //   546: baload
    //   547: istore_2
    //   548: aload 7
    //   550: iload_1
    //   551: iconst_1
    //   552: iadd
    //   553: baload
    //   554: sipush 255
    //   557: iand
    //   558: iconst_0
    //   559: ishl
    //   560: iload_2
    //   561: sipush 255
    //   564: iand
    //   565: bipush 8
    //   567: ishl
    //   568: iadd
    //   569: i2s
    //   570: istore_2
    //   571: aload 6
    //   573: iload_2
    //   574: newarray byte
    //   576: putfield 405	com/tencent/token/core/push/j:h	[B
    //   579: aload_0
    //   580: getfield 114	com/tencent/token/core/push/a:d	[B
    //   583: iload_1
    //   584: iconst_2
    //   585: iadd
    //   586: aload 6
    //   588: getfield 405	com/tencent/token/core/push/j:h	[B
    //   591: iconst_0
    //   592: iload_2
    //   593: invokestatic 230	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   596: new 162	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   603: ldc_w 407
    //   606: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload 6
    //   611: getfield 402	com/tencent/token/core/push/j:f	J
    //   614: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   617: ldc_w 409
    //   620: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload 6
    //   625: getfield 396	com/tencent/token/core/push/j:c	J
    //   628: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   631: ldc_w 411
    //   634: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: new 203	java/lang/String
    //   640: dup
    //   641: aload 6
    //   643: getfield 394	com/tencent/token/core/push/j:b	[B
    //   646: invokespecial 208	java/lang/String:<init>	([B)V
    //   649: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: ldc_w 413
    //   655: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload 6
    //   660: getfield 398	com/tencent/token/core/push/j:d	B
    //   663: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   666: ldc_w 415
    //   669: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload 6
    //   674: getfield 400	com/tencent/token/core/push/j:e	B
    //   677: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   680: ldc_w 417
    //   683: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: new 203	java/lang/String
    //   689: dup
    //   690: aload 6
    //   692: getfield 404	com/tencent/token/core/push/j:g	[B
    //   695: invokespecial 208	java/lang/String:<init>	([B)V
    //   698: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: ldc_w 419
    //   704: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: new 203	java/lang/String
    //   710: dup
    //   711: aload 6
    //   713: getfield 405	com/tencent/token/core/push/j:h	[B
    //   716: invokespecial 208	java/lang/String:<init>	([B)V
    //   719: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokestatic 187	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   728: new 320	com/tencent/token/core/push/c
    //   731: dup
    //   732: sipush 203
    //   735: iconst_0
    //   736: invokespecial 323	com/tencent/token/core/push/c:<init>	(SB)V
    //   739: astore 7
    //   741: aload 7
    //   743: bipush 6
    //   745: newarray byte
    //   747: putfield 329	com/tencent/token/core/push/c:l	[B
    //   750: aload 7
    //   752: getfield 329	com/tencent/token/core/push/c:l	[B
    //   755: iconst_0
    //   756: lconst_0
    //   757: invokestatic 422	com/tencent/token/ap:a	([BIJ)V
    //   760: aload 7
    //   762: getfield 329	com/tencent/token/core/push/c:l	[B
    //   765: astore 8
    //   767: aload 8
    //   769: iconst_4
    //   770: iconst_0
    //   771: bastore
    //   772: aload 8
    //   774: iconst_5
    //   775: iconst_0
    //   776: bastore
    //   777: aload 7
    //   779: getfield 329	com/tencent/token/core/push/c:l	[B
    //   782: astore 8
    //   784: ldc 82
    //   786: invokevirtual 338	java/lang/String:getBytes	()[B
    //   789: iconst_0
    //   790: aload 8
    //   792: bipush 6
    //   794: iconst_0
    //   795: invokestatic 230	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   798: aload 7
    //   800: invokevirtual 340	com/tencent/token/core/push/c:a	()[B
    //   803: astore 7
    //   805: aload 5
    //   807: aload 7
    //   809: invokevirtual 353	java/io/OutputStream:write	([B)V
    //   812: aload 5
    //   814: invokevirtual 356	java/io/OutputStream:flush	()V
    //   817: aload 6
    //   819: areturn
    //   820: astore 5
    //   822: aload 5
    //   824: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   827: goto -10 -> 817
    //   830: astore 5
    //   832: aload 5
    //   834: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   837: new 162	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   844: ldc_w 424
    //   847: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload 5
    //   852: invokevirtual 193	java/io/IOException:toString	()Ljava/lang/String;
    //   855: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   861: invokestatic 180	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   864: iconst_5
    //   865: putstatic 52	com/tencent/token/core/push/a:v	I
    //   868: aload_0
    //   869: invokespecial 140	com/tencent/token/core/push/a:h	()V
    //   872: aconst_null
    //   873: areturn
    //   874: astore 5
    //   876: aload 5
    //   878: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   881: goto -64 -> 817
    //   884: astore 5
    //   886: aload 5
    //   888: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   891: new 162	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   898: ldc_w 426
    //   901: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload 5
    //   906: invokevirtual 276	java/lang/Exception:toString	()Ljava/lang/String;
    //   909: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: invokestatic 180	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   918: iconst_5
    //   919: putstatic 52	com/tencent/token/core/push/a:v	I
    //   922: aload_0
    //   923: invokespecial 140	com/tencent/token/core/push/a:h	()V
    //   926: aconst_null
    //   927: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	928	0	this	a
    //   132	454	1	i1	int
    //   482	111	2	i2	int
    //   43	41	3	l1	long
    //   29	784	5	localOutputStream	OutputStream
    //   820	3	5	localIOException1	IOException
    //   830	21	5	localIOException2	IOException
    //   874	3	5	localException1	Exception
    //   884	21	5	localException2	Exception
    //   38	780	6	localObject1	Object
    //   96	712	7	localObject2	Object
    //   127	664	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   805	817	820	java/io/IOException
    //   22	133	830	java/io/IOException
    //   148	171	830	java/io/IOException
    //   171	189	830	java/io/IOException
    //   189	351	830	java/io/IOException
    //   379	403	830	java/io/IOException
    //   408	421	830	java/io/IOException
    //   425	436	830	java/io/IOException
    //   440	451	830	java/io/IOException
    //   455	468	830	java/io/IOException
    //   472	478	830	java/io/IOException
    //   510	533	830	java/io/IOException
    //   537	543	830	java/io/IOException
    //   571	767	830	java/io/IOException
    //   777	805	830	java/io/IOException
    //   822	827	830	java/io/IOException
    //   876	881	830	java/io/IOException
    //   805	817	874	java/lang/Exception
    //   22	133	884	java/lang/Exception
    //   148	171	884	java/lang/Exception
    //   171	189	884	java/lang/Exception
    //   189	351	884	java/lang/Exception
    //   379	403	884	java/lang/Exception
    //   408	421	884	java/lang/Exception
    //   425	436	884	java/lang/Exception
    //   440	451	884	java/lang/Exception
    //   455	468	884	java/lang/Exception
    //   472	478	884	java/lang/Exception
    //   510	533	884	java/lang/Exception
    //   537	543	884	java/lang/Exception
    //   571	767	884	java/lang/Exception
    //   777	805	884	java/lang/Exception
    //   822	827	884	java/lang/Exception
    //   876	881	884	java/lang/Exception
  }
  
  private void h()
  {
    if (this.u == null) {
      return;
    }
    try
    {
      this.u.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      e.c("socket close connection failed" + localIOException.toString());
      return;
    }
    catch (Exception localException)
    {
      e.c("socket close connection failed" + localException.toString());
      localException.printStackTrace();
    }
  }
  
  public final void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      v = paramInt;
      return;
      h();
      v = paramInt;
      return;
    } while (v != 8);
    v = 1;
  }
  
  public final void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    y = new String[paramArrayOfString.length];
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      y[i1] = paramArrayOfString[i1];
      e.a("socket server ip[" + i1 + "]=" + y[i1]);
      i1 += 1;
    }
    z = new int[paramArrayOfInt.length];
    i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      z[i1] = paramArrayOfInt[i1];
      e.a("socket server port[" + i1 + "]=" + z[i1]);
      i1 += 1;
    }
    this.A = paramInt1;
    this.C = paramInt2;
    this.B = paramInt3;
    e.a("socket reconn params reconn_count: " + this.A + ", reconn_time_interval: " + this.C + ", heart_break_time: " + this.B);
    this.D = 0;
  }
  
  public final j c()
  {
    Object localObject4 = null;
    Object localObject1 = localObject4;
    switch (v)
    {
    case 4: 
    default: 
    case 7: 
    case 8: 
    case 0: 
    case 1: 
    case 5: 
    case 2: 
    case 3: 
      for (;;)
      {
        localObject1 = localObject4;
        if (4 == v) {
          localObject1 = g();
        }
        return localObject1;
        new b(this).a(new String[] { "" });
        continue;
        h();
        if ((y == null) || (z == null) || (y.length == 0) || (z.length == 0))
        {
          v = 0;
        }
        else if (this.D >= this.A)
        {
          v = 0;
          this.D = 0;
        }
        else
        {
          try
          {
            i1 = this.D % y.length;
            e.a("socket connect server ok [" + y[i1] + ", " + z[i1] + "]");
            this.w = 0L;
            this.u = new Socket();
            localObject1 = new InetSocketAddress(y[i1], z[i1]);
            this.u.connect((SocketAddress)localObject1, 3000);
            this.u.setKeepAlive(true);
            e.a("socket connect server ok [" + y[i1] + ", " + z[i1] + "]");
            this.D += 1;
            v = 2;
            e();
            continue;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            e.c(localException.toString());
            h();
            v = 6;
            this.x = System.currentTimeMillis();
            this.D += 1;
            continue;
          }
          finally
          {
            this.D += 1;
          }
          e();
          continue;
          f();
        }
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.x;
    if (this.D < this.E.length) {}
    for (int i1 = this.E[this.D];; i1 = this.E[(this.E.length - 1)])
    {
      Object localObject3 = localObject4;
      if (l1 - l2 <= i1) {
        break;
      }
      v = 1;
      return null;
    }
  }
  
  public final void d()
  {
    v = 5;
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.a
 * JD-Core Version:    0.7.0.1
 */