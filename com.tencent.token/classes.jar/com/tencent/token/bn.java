package com.tencent.token;

import com.tencent.halley.common.b;
import com.tencent.halley.common.b.d;
import com.tencent.halley.common.h;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class bn
{
  private static bn a = new bn();
  private int b = 20000;
  private Socket c;
  private int d = -1;
  private bo e;
  private ay f;
  private OutputStream g;
  private InputStream h;
  private int i = -1;
  private int j = -1;
  private long k = -1L;
  private int l = -1;
  private int m = -1;
  
  public static bn a()
  {
    try
    {
      bn localbn = a;
      return localbn;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      a(paramInt, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    try
    {
      if ((paramInt != this.d) && (this.e != null))
      {
        this.e.b = paramInt;
        if (paramString != null) {
          this.e.c = paramString;
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(bo parambo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iconst_0
    //   5: istore 4
    //   7: iload 4
    //   9: ifne +287 -> 296
    //   12: aload_1
    //   13: ifnull +146 -> 159
    //   16: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   19: aload_1
    //   20: getfield 74	com/tencent/token/bo:i	J
    //   23: lsub
    //   24: aload_1
    //   25: getfield 75	com/tencent/token/bo:j	I
    //   28: i2l
    //   29: lcmp
    //   30: ifge +129 -> 159
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +260 -> 296
    //   39: iload_2
    //   40: iconst_5
    //   41: if_icmpge +255 -> 296
    //   44: iload_2
    //   45: iconst_1
    //   46: iadd
    //   47: istore_3
    //   48: aload_0
    //   49: invokespecial 78	com/tencent/token/bn:c	()Z
    //   52: istore 5
    //   54: iload 5
    //   56: ifeq +231 -> 287
    //   59: ldc 80
    //   61: new 82	java/lang/StringBuilder
    //   64: dup
    //   65: ldc 84
    //   67: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload_1
    //   71: invokevirtual 90	com/tencent/token/bo:j	()I
    //   74: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc 96
    //   79: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   86: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 113	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 116	com/tencent/token/bo:k	()[B
    //   99: astore 6
    //   101: aload_0
    //   102: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   105: aload 6
    //   107: iconst_0
    //   108: aload 6
    //   110: arraylength
    //   111: invokevirtual 124	java/io/OutputStream:write	([BII)V
    //   114: aload_0
    //   115: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   118: invokevirtual 127	java/io/OutputStream:flush	()V
    //   121: aload_0
    //   122: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   125: putfield 46	com/tencent/token/bn:k	J
    //   128: ldc 80
    //   130: new 82	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 129
    //   136: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload 6
    //   141: arraylength
    //   142: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 131	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: iconst_1
    //   152: istore 4
    //   154: iload_3
    //   155: istore_2
    //   156: goto -149 -> 7
    //   159: iconst_1
    //   160: istore_3
    //   161: goto -126 -> 35
    //   164: astore 6
    //   166: ldc 80
    //   168: aload 6
    //   170: invokestatic 134	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_1
    //   174: bipush 251
    //   176: putfield 60	com/tencent/token/bo:b	I
    //   179: aload_1
    //   180: aload 6
    //   182: invokestatic 139	com/tencent/token/bq:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   185: putfield 63	com/tencent/token/bo:c	Ljava/lang/String;
    //   188: iload_3
    //   189: istore_2
    //   190: iload 4
    //   192: ifne -185 -> 7
    //   195: aload_0
    //   196: aload_1
    //   197: getfield 60	com/tencent/token/bo:b	I
    //   200: invokespecial 141	com/tencent/token/bn:a	(I)V
    //   203: aload_0
    //   204: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   207: invokevirtual 144	java/io/OutputStream:close	()V
    //   210: aload_0
    //   211: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   214: invokevirtual 147	java/net/Socket:close	()V
    //   217: aload_0
    //   218: invokespecial 149	com/tencent/token/bn:e	()V
    //   221: iload_3
    //   222: istore_2
    //   223: goto -216 -> 7
    //   226: astore 6
    //   228: aload 6
    //   230: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   233: iload_3
    //   234: istore_2
    //   235: goto -228 -> 7
    //   238: astore_1
    //   239: aload_0
    //   240: monitorexit
    //   241: aload_1
    //   242: athrow
    //   243: astore 6
    //   245: iload 4
    //   247: ifne +29 -> 276
    //   250: aload_0
    //   251: aload_1
    //   252: getfield 60	com/tencent/token/bo:b	I
    //   255: invokespecial 141	com/tencent/token/bn:a	(I)V
    //   258: aload_0
    //   259: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   262: invokevirtual 144	java/io/OutputStream:close	()V
    //   265: aload_0
    //   266: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   269: invokevirtual 147	java/net/Socket:close	()V
    //   272: aload_0
    //   273: invokespecial 149	com/tencent/token/bn:e	()V
    //   276: aload 6
    //   278: athrow
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   284: goto -8 -> 276
    //   287: aload_0
    //   288: invokespecial 149	com/tencent/token/bn:e	()V
    //   291: iload_3
    //   292: istore_2
    //   293: goto -286 -> 7
    //   296: aload_0
    //   297: monitorexit
    //   298: iload 4
    //   300: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	bn
    //   0	301	1	parambo	bo
    //   3	290	2	n	int
    //   34	258	3	i1	int
    //   5	294	4	bool1	boolean
    //   52	3	5	bool2	boolean
    //   99	41	6	arrayOfByte	byte[]
    //   164	17	6	localException1	Exception
    //   226	3	6	localException2	Exception
    //   243	34	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   59	151	164	java/lang/Exception
    //   195	221	226	java/lang/Exception
    //   16	33	238	finally
    //   48	54	238	finally
    //   195	221	238	finally
    //   228	233	238	finally
    //   250	276	238	finally
    //   276	279	238	finally
    //   280	284	238	finally
    //   287	291	238	finally
    //   59	151	243	finally
    //   166	188	243	finally
    //   250	276	279	java/lang/Exception
  }
  
  private void b()
  {
    int n = 0;
    long l1;
    Object localObject2;
    int i1;
    int i2;
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
        try
        {
          b.b("WupTaskController", "doReadData: try read data...sk:" + this.c);
          localObject2 = new byte[4];
          i1 = n;
          if (n < 4)
          {
            b.a("WupTaskController", "try read packet size: 4 bytes");
            i2 = this.h.read((byte[])localObject2, n, 4 - n);
            if (i2 <= 0) {
              continue;
            }
            this.l = ((int)(System.currentTimeMillis() - this.k));
            i1 = n + i2;
            n = i1;
            if (i1 != 4) {
              continue;
            }
          }
          if (i1 != 4) {
            continue;
          }
          n = h.a((byte[])localObject2, 0);
          if ((n > 4) && (n <= 524288)) {
            break;
          }
          a(-6, "packSizeFail:" + n);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          b.a("WupTaskController", localException1);
          a(-7, bq.a(localException1));
          continue;
        }
        return;
      }
      finally {}
      i1 = n;
      if (i2 != -1)
      {
        continue;
        a(-6, "readLen fail:" + i1);
      }
    }
    byte[] arrayOfByte = new byte[n];
    System.arraycopy(localObject2, 0, arrayOfByte, 0, 4);
    long l2 = System.currentTimeMillis();
    label232:
    while (i1 < n)
    {
      i2 = n - i1;
      b.a("WupTaskController", "try read:" + i2);
      i2 = this.h.read(arrayOfByte, i1, i2);
      b.a("WupTaskController", "read ret:" + i2);
      if (i2 <= 0) {
        break label505;
      }
      i1 += i2;
    }
    for (;;)
    {
      for (;;)
      {
        if (i1 != n)
        {
          b.c("WupTaskController", "read fail. readLen:" + i1 + ",packSize:" + n);
          a(-6, "readLen != packSize,rspBuff:" + h.a(arrayOfByte));
          break;
        }
        this.m = ((int)(System.currentTimeMillis() - l2));
        b.b("WupTaskController", "doSendReceive: read finish,readLen=" + i1);
        localObject2 = new d();
        try
        {
          ((d)localObject2).a(arrayOfByte);
          if (this.e == null) {
            break;
          }
          this.e.a = ((d)localObject2);
          this.e.b = 0;
          this.m = ((int)(System.currentTimeMillis() - l1));
          this.e.f = this.l;
          this.e.d = this.j;
          this.e.g = this.m;
        }
        catch (Exception localException2)
        {
          a(-8, bq.a(localException2));
        }
      }
      break;
      label505:
      if (i2 != -1) {
        break label232;
      }
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.c != null)
      {
        bool1 = bool2;
        if (this.c.isConnected())
        {
          bool1 = bool2;
          if (!this.c.isClosed())
          {
            OutputStream localOutputStream = this.g;
            bool1 = bool2;
            if (localOutputStream != null) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   15: invokevirtual 216	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   23: aload_0
    //   24: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +15 -> 44
    //   32: aload_0
    //   33: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   36: invokevirtual 144	java/io/OutputStream:close	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   44: aload_0
    //   45: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +15 -> 65
    //   53: aload_0
    //   54: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   57: invokevirtual 147	java/net/Socket:close	()V
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   65: invokestatic 220	com/tencent/token/bk:a	()V
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   77: goto -54 -> 23
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   99: goto -55 -> 44
    //   102: astore_1
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   116: goto -51 -> 65
    //   119: astore_1
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	bn
    //   6	44	1	localObject1	Object
    //   71	1	1	localException1	Exception
    //   80	4	1	localObject2	Object
    //   85	7	1	localObject3	Object
    //   93	1	1	localException2	Exception
    //   102	7	1	localObject4	Object
    //   110	1	1	localException3	Exception
    //   119	7	1	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	18	71	java/lang/Exception
    //   2	7	80	finally
    //   18	23	80	finally
    //   23	28	80	finally
    //   39	44	80	finally
    //   44	49	80	finally
    //   60	65	80	finally
    //   65	68	80	finally
    //   72	77	80	finally
    //   86	93	80	finally
    //   94	99	80	finally
    //   103	110	80	finally
    //   111	116	80	finally
    //   120	127	80	finally
    //   11	18	85	finally
    //   32	39	93	java/lang/Exception
    //   32	39	102	finally
    //   53	60	110	java/lang/Exception
    //   53	60	119	finally
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 80
    //   6: ldc 222
    //   8: invokestatic 188	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: new 224	com/tencent/token/bm
    //   14: dup
    //   15: invokespecial 225	com/tencent/token/bm:<init>	()V
    //   18: astore 7
    //   20: aload_0
    //   21: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   24: getfield 75	com/tencent/token/bo:j	I
    //   27: ifle +369 -> 396
    //   30: aload 7
    //   32: aload_0
    //   33: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   36: getfield 75	com/tencent/token/bo:j	I
    //   39: invokeinterface 228 2 0
    //   44: aload 7
    //   46: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   49: getfield 236	com/tencent/token/bd:b	Lcom/tencent/token/bg;
    //   52: getfield 239	com/tencent/token/bg:d	I
    //   55: invokeinterface 241 2 0
    //   60: getstatic 246	com/tencent/token/bf:a	[I
    //   63: astore 8
    //   65: aload 7
    //   67: ldc 248
    //   69: invokeinterface 250 2 0
    //   74: aload 7
    //   76: aload 8
    //   78: invokeinterface 253 2 0
    //   83: invokestatic 258	com/tencent/token/ba:a	()Lcom/tencent/token/ba;
    //   86: ldc 248
    //   88: invokevirtual 261	com/tencent/token/ba:a	(Ljava/lang/String;)Lcom/tencent/token/az$a;
    //   91: astore 8
    //   93: aload 8
    //   95: ifnull +32 -> 127
    //   98: new 263	java/util/ArrayList
    //   101: dup
    //   102: invokespecial 264	java/util/ArrayList:<init>	()V
    //   105: astore 9
    //   107: aload 9
    //   109: aload 8
    //   111: invokevirtual 269	com/tencent/token/az$a:c	()Ljava/util/List;
    //   114: invokevirtual 273	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   117: pop
    //   118: aload 7
    //   120: aload 9
    //   122: invokeinterface 276 2 0
    //   127: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   130: getfield 279	com/tencent/token/bd:a	Lcom/tencent/token/bf;
    //   133: getfield 281	com/tencent/token/bf:b	J
    //   136: lstore_3
    //   137: lload_3
    //   138: lconst_0
    //   139: lcmp
    //   140: ifgt +282 -> 422
    //   143: aload 7
    //   145: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   148: getfield 279	com/tencent/token/bd:a	Lcom/tencent/token/bf;
    //   151: invokevirtual 284	com/tencent/token/bf:c	()Ljava/util/ArrayList;
    //   154: iload_2
    //   155: invokeinterface 287 3 0
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 42	com/tencent/token/bn:j	I
    //   165: aload 7
    //   167: invokeinterface 288 1 0
    //   172: aload_0
    //   173: aload 7
    //   175: invokeinterface 290 1 0
    //   180: putfield 40	com/tencent/token/bn:i	I
    //   183: aload_0
    //   184: aload 7
    //   186: invokeinterface 292 1 0
    //   191: putfield 42	com/tencent/token/bn:j	I
    //   194: aload_0
    //   195: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   198: aload_0
    //   199: getfield 40	com/tencent/token/bn:i	I
    //   202: putfield 294	com/tencent/token/bo:e	I
    //   205: aload_0
    //   206: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   209: aload_0
    //   210: getfield 42	com/tencent/token/bn:j	I
    //   213: putfield 207	com/tencent/token/bo:d	I
    //   216: aload 7
    //   218: invokeinterface 296 1 0
    //   223: ifne +360 -> 583
    //   226: aload_0
    //   227: aload 7
    //   229: invokeinterface 299 1 0
    //   234: putfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   237: aload_0
    //   238: aload 7
    //   240: invokeinterface 302 1 0
    //   245: putfield 304	com/tencent/token/bn:f	Lcom/tencent/token/ay;
    //   248: aload_0
    //   249: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   252: aload_0
    //   253: getfield 304	com/tencent/token/bn:f	Lcom/tencent/token/ay;
    //   256: putfield 306	com/tencent/token/bo:h	Lcom/tencent/token/ay;
    //   259: ldc 80
    //   261: new 82	java/lang/StringBuilder
    //   264: dup
    //   265: ldc_w 308
    //   268: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   271: aload_0
    //   272: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   275: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: ldc_w 310
    //   281: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_0
    //   285: getfield 304	com/tencent/token/bn:f	Lcom/tencent/token/ay;
    //   288: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 188	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_0
    //   298: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   301: ifnull +215 -> 516
    //   304: aload_0
    //   305: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   308: invokevirtual 212	java/net/Socket:isConnected	()Z
    //   311: ifeq +205 -> 516
    //   314: aload_0
    //   315: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   318: invokevirtual 215	java/net/Socket:isClosed	()Z
    //   321: istore_2
    //   322: iload_2
    //   323: ifne +193 -> 516
    //   326: aload_0
    //   327: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   330: aload_0
    //   331: getfield 36	com/tencent/token/bn:b	I
    //   334: invokevirtual 313	java/net/Socket:setSoTimeout	(I)V
    //   337: aload_0
    //   338: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   341: ldc 170
    //   343: invokevirtual 316	java/net/Socket:setReceiveBufferSize	(I)V
    //   346: aload_0
    //   347: aload_0
    //   348: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   351: invokevirtual 320	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   354: putfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   357: aload_0
    //   358: aload_0
    //   359: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   362: invokevirtual 324	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   365: putfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   368: ldc 80
    //   370: new 82	java/lang/StringBuilder
    //   373: dup
    //   374: ldc_w 326
    //   377: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: aload_0
    //   381: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   384: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 113	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload_0
    //   394: monitorexit
    //   395: return
    //   396: aload 7
    //   398: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   401: getfield 236	com/tencent/token/bd:b	Lcom/tencent/token/bg;
    //   404: getfield 328	com/tencent/token/bg:a	I
    //   407: invokeinterface 228 2 0
    //   412: goto -368 -> 44
    //   415: astore 7
    //   417: aload_0
    //   418: monitorexit
    //   419: aload 7
    //   421: athrow
    //   422: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   425: lstore 5
    //   427: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   430: getfield 236	com/tencent/token/bd:b	Lcom/tencent/token/bg;
    //   433: getfield 329	com/tencent/token/bg:e	I
    //   436: istore_1
    //   437: lload_3
    //   438: iload_1
    //   439: bipush 60
    //   441: imul
    //   442: sipush 1000
    //   445: imul
    //   446: i2l
    //   447: ladd
    //   448: lload 5
    //   450: lcmp
    //   451: iflt -308 -> 143
    //   454: iconst_0
    //   455: istore_2
    //   456: goto -313 -> 143
    //   459: astore 7
    //   461: aload 7
    //   463: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   466: ldc 80
    //   468: new 82	java/lang/StringBuilder
    //   471: dup
    //   472: ldc_w 331
    //   475: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   478: aload_0
    //   479: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   482: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: aload 7
    //   490: invokestatic 334	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   493: aload_0
    //   494: bipush 253
    //   496: aload 7
    //   498: invokestatic 139	com/tencent/token/bq:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   501: invokespecial 55	com/tencent/token/bn:a	(ILjava/lang/String;)V
    //   504: aload_0
    //   505: invokespecial 336	com/tencent/token/bn:d	()V
    //   508: goto -115 -> 393
    //   511: astore 7
    //   513: aload 7
    //   515: athrow
    //   516: aload_0
    //   517: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   520: ifnonnull +15 -> 535
    //   523: aload_0
    //   524: bipush 253
    //   526: ldc_w 338
    //   529: invokespecial 55	com/tencent/token/bn:a	(ILjava/lang/String;)V
    //   532: goto -139 -> 393
    //   535: aload_0
    //   536: bipush 253
    //   538: new 82	java/lang/StringBuilder
    //   541: dup
    //   542: ldc_w 340
    //   545: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   548: aload_0
    //   549: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   552: invokevirtual 212	java/net/Socket:isConnected	()Z
    //   555: invokevirtual 343	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   558: ldc_w 345
    //   561: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_0
    //   565: getfield 101	com/tencent/token/bn:c	Ljava/net/Socket;
    //   568: invokevirtual 215	java/net/Socket:isClosed	()Z
    //   571: invokevirtual 343	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   574: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokespecial 55	com/tencent/token/bn:a	(ILjava/lang/String;)V
    //   580: goto -187 -> 393
    //   583: invokestatic 349	com/tencent/token/bp:f	()Z
    //   586: ifeq +50 -> 636
    //   589: invokestatic 353	com/tencent/halley/common/d:a	()Z
    //   592: ifeq +35 -> 627
    //   595: aload_0
    //   596: bipush 253
    //   598: new 82	java/lang/StringBuilder
    //   601: dup
    //   602: ldc_w 355
    //   605: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   608: aload 7
    //   610: invokeinterface 296 1 0
    //   615: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokespecial 55	com/tencent/token/bn:a	(ILjava/lang/String;)V
    //   624: goto -231 -> 393
    //   627: aload_0
    //   628: bipush 240
    //   630: invokespecial 141	com/tencent/token/bn:a	(I)V
    //   633: goto -240 -> 393
    //   636: aload_0
    //   637: bipush 252
    //   639: invokespecial 141	com/tencent/token/bn:a	(I)V
    //   642: goto -249 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	bn
    //   436	6	1	n	int
    //   1	455	2	bool	boolean
    //   136	302	3	l1	long
    //   425	24	5	l2	long
    //   18	379	7	localbm	bm
    //   415	5	7	localObject1	Object
    //   459	38	7	localException	Exception
    //   511	98	7	localObject2	Object
    //   63	47	8	localObject3	Object
    //   105	16	9	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   4	44	415	finally
    //   44	93	415	finally
    //   98	127	415	finally
    //   127	137	415	finally
    //   143	322	415	finally
    //   396	412	415	finally
    //   422	437	415	finally
    //   513	516	415	finally
    //   516	532	415	finally
    //   535	580	415	finally
    //   583	624	415	finally
    //   627	633	415	finally
    //   636	642	415	finally
    //   326	393	459	java/lang/Exception
    //   326	393	511	finally
    //   461	508	511	finally
  }
  
  public final void a(bo parambo, int paramInt)
  {
    if (parambo == null) {}
    for (;;)
    {
      return;
      try
      {
        this.e = parambo;
        this.e.i = System.currentTimeMillis();
        this.e.j = (paramInt * 1000);
        e();
        if (c())
        {
          a(parambo);
          b();
          d();
          return;
        }
      }
      catch (Exception parambo) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bn
 * JD-Core Version:    0.7.0.1
 */