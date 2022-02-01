package com.tencent.token.core.push;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.token.cc;
import com.tencent.token.cj;
import com.tencent.token.cq;
import com.tencent.token.dq;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.encrypt.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class b
{
  private static String[] A = null;
  private static int[] B = null;
  static b a = null;
  private static int x = 0;
  private int C = 10;
  private int D = 300000;
  private int E = 300000;
  private int F = 0;
  private final int[] G = { 1000, 10000, 30000, 90000, 180000, 300000 };
  private final int H = 3000;
  private final int I = 3000;
  public final byte b = 0;
  public final byte c = 1;
  byte[] d = null;
  HandlerThread e;
  Handler f;
  private final long g = 2L;
  private final dq h = new dq("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private dq i = new dq("-1");
  private byte[] j;
  private String k = "";
  private final int l = 0;
  private final int m = 1;
  private final int n = 101;
  private final int o = 102;
  private final int p = 103;
  private final int q = 104;
  private final int r = 105;
  private final int s = 106;
  private final int t = 107;
  private final int u = 108;
  private final int v = 109;
  private Socket w = null;
  private long y;
  private long z;
  
  private int a(InputStream paramInputStream, boolean paramBoolean)
  {
    int i2;
    if ((paramInputStream == null) || (this.w == null))
    {
      d();
      i2 = -2;
      return i2;
    }
    byte[] arrayOfByte;
    int i3;
    Object localObject;
    int i1;
    try
    {
      this.w.setSoTimeout(3000);
      if (paramBoolean) {
        paramInputStream.skip(paramInputStream.available());
      }
      arrayOfByte = new byte[5];
      paramInputStream.read(arrayOfByte);
      i3 = cj.a(arrayOfByte, 1);
      if (i3 <= 42)
      {
        com.tencent.token.global.g.c("socket rsp msg len not correct: " + i3);
        return -1;
      }
      i2 = cj.a(arrayOfByte, 3);
      localObject = new byte[i3];
      i1 = 0;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        paramInputStream.printStackTrace();
        com.tencent.token.global.g.c("socket decodeInputSream failed" + paramInputStream.toString());
        d();
        return -2;
        paramInputStream = new e();
        i2 = d.a((byte[])localObject, i3, paramInputStream);
        i1 = i2;
        if (i2 == 0)
        {
          i2 = d.a((byte[])localObject, i3, paramInputStream);
          i1 = i2;
          if (i2 == 0)
          {
            paramInputStream = new dq(new String(paramInputStream.m), 16);
            this.j = com.tencent.token.utils.encrypt.b.a(this.i, paramInputStream, this.h);
            i1 = i2;
            if (this.j == null)
            {
              i1 = 1;
              continue;
              paramInputStream = new h();
              i2 = d.a((byte[])localObject, i3, paramInputStream);
              i1 = i2;
              if (i2 == 0)
              {
                i2 = d.a((byte[])localObject, i3, paramInputStream);
                if ((i2 != 0) && (paramInputStream.n > 0L))
                {
                  l1 = System.currentTimeMillis();
                  l2 = paramInputStream.n;
                  localObject = cc.c();
                  ((cc)localObject).a(l2 * 1000L - l1);
                  ((cc)localObject).i();
                }
                i1 = i2;
                if (i2 == 0)
                {
                  this.k = new String(paramInputStream.p);
                  i1 = i2;
                }
              }
            }
          }
        }
      }
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      com.tencent.token.global.g.c("socket decodeInputSream failed" + paramInputStream.toString());
      d();
      return -2;
    }
    paramInputStream.read((byte[])localObject, 5, i3 - 5);
    com.tencent.token.global.g.a("socket pkg type: " + i2);
    switch (i2)
    {
    }
    for (;;)
    {
      i2 = i1;
      if (i1 == 0) {
        break;
      }
      c(i1);
      return i1;
      long l1;
      long l2;
      paramInputStream = new g();
      i2 = d.a((byte[])localObject, i3, paramInputStream);
      i1 = i2;
      if (i2 == 0)
      {
        i2 = d.a((byte[])localObject, i3, paramInputStream);
        i1 = i2;
        if (i2 == 0)
        {
          this.d = b(paramInputStream.n);
          if (this.d == null) {
            this.d = b(paramInputStream.n);
          }
          paramInputStream = this.d;
          i1 = i2;
          if (paramInputStream == null)
          {
            i1 = 101;
            continue;
            while (i1 < 5)
            {
              localObject[i1] = arrayOfByte[i1];
              i1 += 1;
            }
            i1 = 101;
          }
        }
      }
    }
  }
  
  public static b a()
  {
    if (a == null)
    {
      a = new b();
      x = 0;
    }
    return a;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new a().b(paramArrayOfByte, this.j);
    paramArrayOfByte = arrayOfByte;
    if (arrayOfByte == null)
    {
      com.tencent.token.global.g.c("encrypt data failed");
      paramArrayOfByte = null;
    }
    return paramArrayOfByte;
  }
  
  private f b(final Handler paramHandler)
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   4: invokestatic 33	com/tencent/token/core/push/b:c	(Lcom/tencent/token/core/push/b;)Ljava/net/Socket;
          //   7: ifnonnull +11 -> 18
          //   10: aload_0
          //   11: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   14: invokevirtual 36	com/tencent/token/core/push/b:d	()V
          //   17: return
          //   18: aload_0
          //   19: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   22: aconst_null
          //   23: putfield 39	com/tencent/token/core/push/b:d	[B
          //   26: aload_0
          //   27: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   30: invokestatic 33	com/tencent/token/core/push/b:c	(Lcom/tencent/token/core/push/b;)Ljava/net/Socket;
          //   33: invokevirtual 45	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
          //   36: astore 6
          //   38: aload_0
          //   39: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   42: invokestatic 33	com/tencent/token/core/push/b:c	(Lcom/tencent/token/core/push/b;)Ljava/net/Socket;
          //   45: invokevirtual 49	java/net/Socket:getInputStream	()Ljava/io/InputStream;
          //   48: astore 5
          //   50: invokestatic 55	java/lang/System:currentTimeMillis	()J
          //   53: lstore_3
          //   54: lload_3
          //   55: aload_0
          //   56: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   59: invokestatic 59	com/tencent/token/core/push/b:j	(Lcom/tencent/token/core/push/b;)J
          //   62: lsub
          //   63: aload_0
          //   64: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   67: invokestatic 63	com/tencent/token/core/push/b:k	(Lcom/tencent/token/core/push/b;)I
          //   70: i2l
          //   71: lcmp
          //   72: iflt +48 -> 120
          //   75: new 65	java/lang/StringBuilder
          //   78: dup
          //   79: invokespecial 66	java/lang/StringBuilder:<init>	()V
          //   82: ldc 68
          //   84: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   87: lload_3
          //   88: invokevirtual 75	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   91: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   94: invokestatic 84	com/tencent/token/global/g:a	(Ljava/lang/String;)V
          //   97: aload_0
          //   98: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   101: lload_3
          //   102: invokestatic 87	com/tencent/token/core/push/b:b	(Lcom/tencent/token/core/push/b;J)J
          //   105: pop2
          //   106: aload 6
          //   108: iconst_0
          //   109: invokestatic 92	com/tencent/token/core/push/d:a	(B)[B
          //   112: invokevirtual 98	java/io/OutputStream:write	([B)V
          //   115: aload 6
          //   117: invokevirtual 101	java/io/OutputStream:flush	()V
          //   120: aload 5
          //   122: invokevirtual 107	java/io/InputStream:available	()I
          //   125: ifle +16 -> 141
          //   128: aload_0
          //   129: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   132: aload 5
          //   134: iconst_0
          //   135: invokestatic 110	com/tencent/token/core/push/b:a	(Lcom/tencent/token/core/push/b;Ljava/io/InputStream;Z)I
          //   138: ifne -121 -> 17
          //   141: aload_0
          //   142: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   145: getfield 39	com/tencent/token/core/push/b:d	[B
          //   148: ifnull -131 -> 17
          //   151: new 65	java/lang/StringBuilder
          //   154: dup
          //   155: invokespecial 66	java/lang/StringBuilder:<init>	()V
          //   158: ldc 112
          //   160: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   163: aload_0
          //   164: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   167: getfield 39	com/tencent/token/core/push/b:d	[B
          //   170: arraylength
          //   171: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   174: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   177: invokestatic 84	com/tencent/token/global/g:a	(Ljava/lang/String;)V
          //   180: new 117	com/tencent/token/core/push/f
          //   183: dup
          //   184: invokespecial 118	com/tencent/token/core/push/f:<init>	()V
          //   187: astore 5
          //   189: aload 5
          //   191: aload_0
          //   192: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   195: getfield 39	com/tencent/token/core/push/b:d	[B
          //   198: iconst_0
          //   199: invokestatic 123	com/tencent/token/cj:c	([BI)J
          //   202: putfield 126	com/tencent/token/core/push/f:a	J
          //   205: aload_0
          //   206: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   209: getfield 39	com/tencent/token/core/push/b:d	[B
          //   212: bipush 8
          //   214: invokestatic 129	com/tencent/token/cj:a	([BI)S
          //   217: istore_1
          //   218: aload 5
          //   220: iload_1
          //   221: newarray byte
          //   223: putfield 131	com/tencent/token/core/push/f:b	[B
          //   226: aload_0
          //   227: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   230: getfield 39	com/tencent/token/core/push/b:d	[B
          //   233: bipush 10
          //   235: aload 5
          //   237: getfield 131	com/tencent/token/core/push/f:b	[B
          //   240: iload_1
          //   241: invokestatic 134	com/tencent/token/cj:b	([BI[BI)V
          //   244: iload_1
          //   245: bipush 10
          //   247: iadd
          //   248: istore_1
          //   249: aload 5
          //   251: aload_0
          //   252: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   255: getfield 39	com/tencent/token/core/push/b:d	[B
          //   258: iload_1
          //   259: invokestatic 136	com/tencent/token/cj:b	([BI)J
          //   262: putfield 138	com/tencent/token/core/push/f:c	J
          //   265: iload_1
          //   266: iconst_4
          //   267: iadd
          //   268: istore_1
          //   269: aload 5
          //   271: aload_0
          //   272: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   275: getfield 39	com/tencent/token/core/push/b:d	[B
          //   278: iload_1
          //   279: baload
          //   280: putfield 141	com/tencent/token/core/push/f:d	B
          //   283: iload_1
          //   284: iconst_1
          //   285: iadd
          //   286: istore_1
          //   287: aload 5
          //   289: aload_0
          //   290: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   293: getfield 39	com/tencent/token/core/push/b:d	[B
          //   296: iload_1
          //   297: baload
          //   298: putfield 144	com/tencent/token/core/push/f:e	B
          //   301: iload_1
          //   302: iconst_1
          //   303: iadd
          //   304: istore_1
          //   305: aload 5
          //   307: aload_0
          //   308: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   311: getfield 39	com/tencent/token/core/push/b:d	[B
          //   314: iload_1
          //   315: invokestatic 136	com/tencent/token/cj:b	([BI)J
          //   318: putfield 147	com/tencent/token/core/push/f:f	J
          //   321: iload_1
          //   322: iconst_4
          //   323: iadd
          //   324: istore_2
          //   325: aload_0
          //   326: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   329: getfield 39	com/tencent/token/core/push/b:d	[B
          //   332: iload_2
          //   333: invokestatic 129	com/tencent/token/cj:a	([BI)S
          //   336: istore_1
          //   337: iload_2
          //   338: iconst_2
          //   339: iadd
          //   340: istore_2
          //   341: aload 5
          //   343: iload_1
          //   344: newarray byte
          //   346: putfield 150	com/tencent/token/core/push/f:g	[B
          //   349: aload_0
          //   350: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   353: getfield 39	com/tencent/token/core/push/b:d	[B
          //   356: iload_2
          //   357: aload 5
          //   359: getfield 150	com/tencent/token/core/push/f:g	[B
          //   362: iload_1
          //   363: invokestatic 134	com/tencent/token/cj:b	([BI[BI)V
          //   366: iload_2
          //   367: iload_1
          //   368: iadd
          //   369: istore_1
          //   370: aload_0
          //   371: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   374: getfield 39	com/tencent/token/core/push/b:d	[B
          //   377: iload_1
          //   378: invokestatic 129	com/tencent/token/cj:a	([BI)S
          //   381: istore_2
          //   382: aload 5
          //   384: iload_2
          //   385: newarray byte
          //   387: putfield 153	com/tencent/token/core/push/f:h	[B
          //   390: aload_0
          //   391: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   394: getfield 39	com/tencent/token/core/push/b:d	[B
          //   397: iload_1
          //   398: iconst_2
          //   399: iadd
          //   400: aload 5
          //   402: getfield 153	com/tencent/token/core/push/f:h	[B
          //   405: iload_2
          //   406: invokestatic 134	com/tencent/token/cj:b	([BI[BI)V
          //   409: new 65	java/lang/StringBuilder
          //   412: dup
          //   413: invokespecial 66	java/lang/StringBuilder:<init>	()V
          //   416: ldc 155
          //   418: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   421: aload 5
          //   423: getfield 147	com/tencent/token/core/push/f:f	J
          //   426: invokevirtual 75	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   429: ldc 157
          //   431: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   434: aload 5
          //   436: getfield 138	com/tencent/token/core/push/f:c	J
          //   439: invokevirtual 75	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   442: ldc 159
          //   444: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   447: new 161	java/lang/String
          //   450: dup
          //   451: aload 5
          //   453: getfield 131	com/tencent/token/core/push/f:b	[B
          //   456: invokespecial 163	java/lang/String:<init>	([B)V
          //   459: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   462: ldc 165
          //   464: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   467: aload 5
          //   469: getfield 141	com/tencent/token/core/push/f:d	B
          //   472: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   475: ldc 167
          //   477: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   480: aload 5
          //   482: getfield 144	com/tencent/token/core/push/f:e	B
          //   485: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   488: ldc 169
          //   490: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   493: new 161	java/lang/String
          //   496: dup
          //   497: aload 5
          //   499: getfield 150	com/tencent/token/core/push/f:g	[B
          //   502: invokespecial 163	java/lang/String:<init>	([B)V
          //   505: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   508: ldc 171
          //   510: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   513: new 161	java/lang/String
          //   516: dup
          //   517: aload 5
          //   519: getfield 153	com/tencent/token/core/push/f:h	[B
          //   522: invokespecial 163	java/lang/String:<init>	([B)V
          //   525: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   528: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   531: invokestatic 84	com/tencent/token/global/g:a	(Ljava/lang/String;)V
          //   534: iconst_0
          //   535: iconst_0
          //   536: ldc 173
          //   538: invokestatic 176	com/tencent/token/core/push/d:a	(ISLjava/lang/String;)[B
          //   541: astore 7
          //   543: aload 6
          //   545: aload 7
          //   547: invokevirtual 98	java/io/OutputStream:write	([B)V
          //   550: aload 6
          //   552: invokevirtual 101	java/io/OutputStream:flush	()V
          //   555: aload_0
          //   556: getfield 20	com/tencent/token/core/push/b$5:a	Landroid/os/Handler;
          //   559: ifnull -542 -> 17
          //   562: new 178	android/os/Message
          //   565: dup
          //   566: invokespecial 179	android/os/Message:<init>	()V
          //   569: astore 6
          //   571: aload 6
          //   573: sipush 4014
          //   576: putfield 183	android/os/Message:what	I
          //   579: aload 6
          //   581: aload 5
          //   583: putfield 187	android/os/Message:obj	Ljava/lang/Object;
          //   586: aload_0
          //   587: getfield 20	com/tencent/token/core/push/b$5:a	Landroid/os/Handler;
          //   590: aload 6
          //   592: invokevirtual 193	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
          //   595: pop
          //   596: return
          //   597: astore 5
          //   599: aload 5
          //   601: invokevirtual 196	java/io/IOException:printStackTrace	()V
          //   604: new 65	java/lang/StringBuilder
          //   607: dup
          //   608: invokespecial 66	java/lang/StringBuilder:<init>	()V
          //   611: ldc 198
          //   613: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   616: aload 5
          //   618: invokevirtual 199	java/io/IOException:toString	()Ljava/lang/String;
          //   621: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   624: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   627: invokestatic 201	com/tencent/token/global/g:c	(Ljava/lang/String;)V
          //   630: aload_0
          //   631: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   634: invokevirtual 36	com/tencent/token/core/push/b:d	()V
          //   637: return
          //   638: astore 6
          //   640: aload 6
          //   642: invokevirtual 196	java/io/IOException:printStackTrace	()V
          //   645: goto -90 -> 555
          //   648: astore 5
          //   650: aload 5
          //   652: invokevirtual 202	java/lang/Exception:printStackTrace	()V
          //   655: new 65	java/lang/StringBuilder
          //   658: dup
          //   659: invokespecial 66	java/lang/StringBuilder:<init>	()V
          //   662: ldc 204
          //   664: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   667: aload 5
          //   669: invokevirtual 205	java/lang/Exception:toString	()Ljava/lang/String;
          //   672: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   675: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   678: invokestatic 201	com/tencent/token/global/g:c	(Ljava/lang/String;)V
          //   681: aload_0
          //   682: getfield 18	com/tencent/token/core/push/b$5:b	Lcom/tencent/token/core/push/b;
          //   685: invokevirtual 36	com/tencent/token/core/push/b:d	()V
          //   688: return
          //   689: astore 6
          //   691: aload 6
          //   693: invokevirtual 202	java/lang/Exception:printStackTrace	()V
          //   696: goto -141 -> 555
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	699	0	this	5
          //   217	183	1	i	int
          //   324	82	2	j	int
          //   53	49	3	l	long
          //   48	534	5	localObject1	Object
          //   597	20	5	localIOException1	IOException
          //   648	20	5	localException1	Exception
          //   36	555	6	localObject2	Object
          //   638	3	6	localIOException2	IOException
          //   689	3	6	localException2	Exception
          //   541	5	7	arrayOfByte	byte[]
          // Exception table:
          //   from	to	target	type
          //   26	120	597	java/io/IOException
          //   120	141	597	java/io/IOException
          //   141	244	597	java/io/IOException
          //   249	265	597	java/io/IOException
          //   269	283	597	java/io/IOException
          //   287	301	597	java/io/IOException
          //   305	321	597	java/io/IOException
          //   325	337	597	java/io/IOException
          //   341	366	597	java/io/IOException
          //   370	543	597	java/io/IOException
          //   555	596	597	java/io/IOException
          //   640	645	597	java/io/IOException
          //   691	696	597	java/io/IOException
          //   543	555	638	java/io/IOException
          //   26	120	648	java/lang/Exception
          //   120	141	648	java/lang/Exception
          //   141	244	648	java/lang/Exception
          //   249	265	648	java/lang/Exception
          //   269	283	648	java/lang/Exception
          //   287	301	648	java/lang/Exception
          //   305	321	648	java/lang/Exception
          //   325	337	648	java/lang/Exception
          //   341	366	648	java/lang/Exception
          //   370	543	648	java/lang/Exception
          //   555	596	648	java/lang/Exception
          //   640	645	648	java/lang/Exception
          //   691	696	648	java/lang/Exception
          //   543	555	689	java/lang/Exception
        }
      });
      return null;
    }
    catch (Exception paramHandler)
    {
      return null;
    }
    catch (Error paramHandler) {}
    return null;
  }
  
  public static void b()
  {
    a = null;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new a().a(paramArrayOfByte, this.j);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.token.global.g.c(paramArrayOfByte.toString());
    }
    return null;
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      c();
      x = 7;
      return;
    case 109: 
      d();
      return;
    case 1: 
    case 103: 
      c();
      x = 6;
      this.z = System.currentTimeMillis();
      return;
    }
    c();
    x = 8;
  }
  
  private void g()
  {
    try
    {
      new UserTask()
      {
        public com.tencent.token.global.e a(String... paramAnonymousVarArgs)
        {
          return cq.a().b();
        }
        
        public void a(com.tencent.token.global.e paramAnonymouse)
        {
          if (paramAnonymouse.b())
          {
            b.b(1);
            return;
          }
          com.tencent.token.global.g.c("socket get config failed");
          b.b(6);
          b.a(b.this, System.currentTimeMillis());
        }
      }.c(new String[] { "" });
      return;
    }
    catch (Exception localException) {}catch (Error localError) {}
  }
  
  private void h()
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new Runnable()
      {
        public void run()
        {
          b.this.c();
          if ((b.e() == null) || (b.f() == null) || (b.e().length == 0) || (b.f().length == 0))
          {
            b.b(0);
            return;
          }
          if (b.a(b.this) >= b.b(b.this))
          {
            b.b(0);
            b.a(b.this, 0);
            return;
          }
          com.tencent.token.global.g.a("pushservice connect....");
          try
          {
            int i = b.a(b.this) % b.e().length;
            com.tencent.token.global.g.a("socket connect server ok [" + b.e()[i] + ", " + b.f()[i] + "]");
            b.b(b.this, 0L);
            b.a(b.this, new Socket());
            InetSocketAddress localInetSocketAddress = new InetSocketAddress(b.e()[i], b.f()[i]);
            b.c(b.this).connect(localInetSocketAddress, 3000);
            b.c(b.this).setKeepAlive(true);
            com.tencent.token.global.g.a("socket connect server ok [" + b.e()[i] + ", " + b.f()[i] + "]");
            b.d(b.this);
            b.b(2);
            b.e(b.this);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            com.tencent.token.global.g.c(localException.toString());
            b.this.c();
            b.b(6);
            b.a(b.this, System.currentTimeMillis());
            return;
          }
          finally
          {
            b.d(b.this);
          }
        }
      });
      return;
    }
    catch (Exception localException) {}catch (Error localError) {}
  }
  
  private void i()
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new Runnable()
      {
        public void run()
        {
          if (b.c(b.this) == null) {
            b.this.d();
          }
          for (;;)
          {
            return;
            b.a(b.this, com.tencent.token.utils.encrypt.b.a());
            Object localObject = com.tencent.token.utils.encrypt.b.a(b.f(b.this), 2L, b.g(b.this));
            if ((b.f(b.this) == null) || (localObject == null) || (((String)localObject).length() == 0))
            {
              b.this.c();
              b.b(6);
              b.a(b.this, System.currentTimeMillis());
              return;
            }
            localObject = d.a((String)localObject);
            try
            {
              OutputStream localOutputStream = b.c(b.this).getOutputStream();
              InputStream localInputStream = b.c(b.this).getInputStream();
              localOutputStream.write((byte[])localObject);
              localOutputStream.flush();
              com.tencent.token.global.g.a("socket available: " + localInputStream.available());
              int i = b.a(b.this, localInputStream, false);
              if (i == 0)
              {
                b.b(3);
                b.h(b.this);
                return;
              }
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
              com.tencent.token.global.g.c("socket exchange key failed" + localIOException.toString());
              b.this.d();
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              com.tencent.token.global.g.c("socket exchange key failed" + localException.toString());
              b.this.d();
            }
          }
        }
      });
      return;
    }
    catch (Exception localException) {}catch (Error localError) {}
  }
  
  private void j()
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new Runnable()
      {
        public void run()
        {
          if (b.c(b.this) == null) {
            b.this.d();
          }
          for (;;)
          {
            return;
            Object localObject2 = cc.c();
            ((cc)localObject2).m();
            long l = ((cc)localObject2).k();
            Object localObject1 = cc.b();
            localObject2 = ((cc)localObject2).o();
            Object localObject3 = new byte[((String)localObject2).length() + 10 + 2 + ((String)localObject1).length() + 2 + b.i(b.this).length()];
            cj.b((byte[])localObject3, 0, l);
            cj.a((byte[])localObject3, 8, (short)((String)localObject2).length());
            cj.a((byte[])localObject3, 10, ((String)localObject2).getBytes(), ((String)localObject2).length());
            int i = ((String)localObject2).length() + 10;
            cj.a((byte[])localObject3, i, (short)((String)localObject1).length());
            i += 2;
            cj.a((byte[])localObject3, i, ((String)localObject1).getBytes(), ((String)localObject1).length());
            i += ((String)localObject1).length();
            cj.a((byte[])localObject3, i, (short)b.i(b.this).length());
            cj.a((byte[])localObject3, i + 2, b.i(b.this).getBytes(), b.i(b.this).length());
            localObject2 = b.a(b.this, (byte[])localObject3);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = b.a(b.this, (byte[])localObject3);
            }
            if (localObject1 == null)
            {
              b.this.c();
              b.b(7);
              return;
            }
            localObject1 = d.a((byte[])localObject1);
            try
            {
              localObject2 = b.c(b.this).getOutputStream();
              localObject3 = b.c(b.this).getInputStream();
              ((OutputStream)localObject2).write((byte[])localObject1);
              ((OutputStream)localObject2).flush();
              com.tencent.token.global.g.a("socket available: " + ((InputStream)localObject3).available());
              i = b.a(b.this, (InputStream)localObject3, true);
              if (i == 0)
              {
                b.b(4);
                return;
              }
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
              com.tencent.token.global.g.c("socket client verify failed" + localIOException.toString());
              b.this.d();
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              com.tencent.token.global.g.c("socket client verify failed" + localException.toString());
              b.this.d();
            }
          }
        }
      });
      return;
    }
    catch (Exception localException) {}catch (Error localError) {}
  }
  
  private int k()
  {
    if (this.F < this.G.length) {
      return this.G[this.F];
    }
    return this.G[(this.G.length - 1)];
  }
  
  public f a(Handler paramHandler)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (x)
    {
    case 4: 
    default: 
      localObject1 = localObject2;
      if (4 == x) {
        localObject1 = b(paramHandler);
      }
      break;
    }
    do
    {
      return localObject1;
      g();
      break;
      h();
      break;
      i();
      break;
      j();
      break;
      localObject1 = localObject2;
    } while (System.currentTimeMillis() - this.z <= k());
    x = 1;
    return null;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      x = paramInt;
      return;
      c();
      x = paramInt;
      return;
    } while (x != 8);
    x = 1;
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    A = new String[paramArrayOfString.length];
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      A[i1] = paramArrayOfString[i1];
      com.tencent.token.global.g.a("socket server ip[" + i1 + "]=" + A[i1]);
      i1 += 1;
    }
    B = new int[paramArrayOfInt.length];
    i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      B[i1] = paramArrayOfInt[i1];
      com.tencent.token.global.g.a("socket server port[" + i1 + "]=" + B[i1]);
      i1 += 1;
    }
    this.C = paramInt1;
    this.E = paramInt2;
    this.D = paramInt3;
    com.tencent.token.global.g.a("socket reconn params reconn_count: " + this.C + ", reconn_time_interval: " + this.E + ", heart_break_time: " + this.D);
    this.F = 0;
  }
  
  public void c()
  {
    if (this.w == null) {
      return;
    }
    try
    {
      this.w.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      com.tencent.token.global.g.c("socket close connection failed" + localIOException.toString());
      return;
    }
    catch (Exception localException)
    {
      com.tencent.token.global.g.c("socket close connection failed" + localException.toString());
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    x = 5;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.b
 * JD-Core Version:    0.7.0.1
 */