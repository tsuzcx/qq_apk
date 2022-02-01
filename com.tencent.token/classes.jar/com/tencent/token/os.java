package com.tencent.token;

import com.tencent.halley.common.b.e;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;

public final class os
{
  private static os b = new os();
  ot a;
  private int c = 20000;
  private Socket d;
  private int e = -1;
  private od f;
  private OutputStream g;
  private InputStream h;
  private int i = -1;
  private int j = -1;
  private long k = -1L;
  private int l = -1;
  private int m = -1;
  
  public static os a()
  {
    try
    {
      os localos = b;
      return localos;
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
      if ((paramInt != this.e) && (this.a != null))
      {
        this.a.e = paramInt;
        if (paramString != null) {
          this.a.f = paramString;
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  final boolean a(ot paramot)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_2
    //   7: iload 4
    //   9: ifne +304 -> 313
    //   12: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   15: aload_1
    //   16: getfield 74	com/tencent/token/ot:l	J
    //   19: lsub
    //   20: aload_1
    //   21: getfield 75	com/tencent/token/ot:m	I
    //   24: i2l
    //   25: lcmp
    //   26: ifge +292 -> 318
    //   29: iconst_0
    //   30: istore_3
    //   31: goto +3 -> 34
    //   34: iload_3
    //   35: ifne +278 -> 313
    //   38: iload_2
    //   39: iconst_5
    //   40: if_icmpge +273 -> 313
    //   43: iload_2
    //   44: iconst_1
    //   45: iadd
    //   46: istore_3
    //   47: aload_0
    //   48: invokevirtual 78	com/tencent/token/os:c	()Z
    //   51: istore 5
    //   53: iload 5
    //   55: ifeq +244 -> 299
    //   58: new 80	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 82
    //   64: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload 6
    //   71: aload_1
    //   72: getfield 87	com/tencent/token/ot:d	I
    //   75: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 6
    //   81: ldc 93
    //   83: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 6
    //   89: aload_0
    //   90: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   93: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: ldc 103
    //   99: aload 6
    //   101: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 112	com/tencent/token/mc:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_1
    //   108: getfield 115	com/tencent/token/ot:b	[B
    //   111: astore 6
    //   113: aload_0
    //   114: getfield 117	com/tencent/token/os:g	Ljava/io/OutputStream;
    //   117: aload 6
    //   119: iconst_0
    //   120: aload 6
    //   122: arraylength
    //   123: invokevirtual 123	java/io/OutputStream:write	([BII)V
    //   126: aload_0
    //   127: getfield 117	com/tencent/token/os:g	Ljava/io/OutputStream;
    //   130: invokevirtual 126	java/io/OutputStream:flush	()V
    //   133: aload_0
    //   134: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   137: putfield 46	com/tencent/token/os:k	J
    //   140: new 80	java/lang/StringBuilder
    //   143: dup
    //   144: ldc 128
    //   146: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: astore 7
    //   151: aload 7
    //   153: aload 6
    //   155: arraylength
    //   156: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: ldc 103
    //   162: aload 7
    //   164: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 130	com/tencent/token/mc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: iconst_1
    //   171: istore 4
    //   173: iload_3
    //   174: istore_2
    //   175: goto -168 -> 7
    //   178: astore 6
    //   180: goto +77 -> 257
    //   183: astore 6
    //   185: ldc 103
    //   187: aload 6
    //   189: invokestatic 133	com/tencent/token/mc:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   192: aload_1
    //   193: bipush 251
    //   195: putfield 60	com/tencent/token/ot:e	I
    //   198: aload_1
    //   199: aload 6
    //   201: invokestatic 138	com/tencent/token/ov:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   204: putfield 63	com/tencent/token/ot:f	Ljava/lang/String;
    //   207: iload_3
    //   208: istore_2
    //   209: iload 4
    //   211: ifne -204 -> 7
    //   214: aload_0
    //   215: aload_1
    //   216: getfield 60	com/tencent/token/ot:e	I
    //   219: invokespecial 140	com/tencent/token/os:a	(I)V
    //   222: aload_0
    //   223: getfield 117	com/tencent/token/os:g	Ljava/io/OutputStream;
    //   226: invokevirtual 143	java/io/OutputStream:close	()V
    //   229: aload_0
    //   230: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   233: invokevirtual 146	java/net/Socket:close	()V
    //   236: aload_0
    //   237: invokevirtual 148	com/tencent/token/os:e	()V
    //   240: iload_3
    //   241: istore_2
    //   242: goto -235 -> 7
    //   245: astore 6
    //   247: aload 6
    //   249: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   252: iload_3
    //   253: istore_2
    //   254: goto -247 -> 7
    //   257: iload 4
    //   259: ifne +37 -> 296
    //   262: aload_0
    //   263: aload_1
    //   264: getfield 60	com/tencent/token/ot:e	I
    //   267: invokespecial 140	com/tencent/token/os:a	(I)V
    //   270: aload_0
    //   271: getfield 117	com/tencent/token/os:g	Ljava/io/OutputStream;
    //   274: invokevirtual 143	java/io/OutputStream:close	()V
    //   277: aload_0
    //   278: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   281: invokevirtual 146	java/net/Socket:close	()V
    //   284: aload_0
    //   285: invokevirtual 148	com/tencent/token/os:e	()V
    //   288: goto +8 -> 296
    //   291: astore_1
    //   292: aload_1
    //   293: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   296: aload 6
    //   298: athrow
    //   299: aload_0
    //   300: invokevirtual 148	com/tencent/token/os:e	()V
    //   303: iload_3
    //   304: istore_2
    //   305: goto -298 -> 7
    //   308: astore_1
    //   309: aload_0
    //   310: monitorexit
    //   311: aload_1
    //   312: athrow
    //   313: aload_0
    //   314: monitorexit
    //   315: iload 4
    //   317: ireturn
    //   318: iconst_1
    //   319: istore_3
    //   320: goto -286 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	os
    //   0	323	1	paramot	ot
    //   6	299	2	n	int
    //   30	290	3	i1	int
    //   3	313	4	bool1	boolean
    //   51	3	5	bool2	boolean
    //   67	87	6	localObject1	Object
    //   178	1	6	localObject2	Object
    //   183	17	6	localException1	Exception
    //   245	52	6	localException2	Exception
    //   149	14	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   58	170	178	finally
    //   185	207	178	finally
    //   58	170	183	java/lang/Exception
    //   214	240	245	java/lang/Exception
    //   262	288	291	java/lang/Exception
    //   12	29	308	finally
    //   47	53	308	finally
    //   214	240	308	finally
    //   247	252	308	finally
    //   262	288	308	finally
    //   292	296	308	finally
    //   296	299	308	finally
    //   299	303	308	finally
  }
  
  final void b()
  {
    label648:
    for (;;)
    {
      int i2;
      try
      {
        long l1 = System.currentTimeMillis();
        int n;
        try
        {
          Object localObject1 = new StringBuilder("doReadData: try read data...sk:");
          ((StringBuilder)localObject1).append(this.d);
          mc.b("WupTaskController", ((StringBuilder)localObject1).toString());
          localObject1 = new byte[4];
          n = 0;
          i1 = n;
          if (n < 4)
          {
            mc.a("WupTaskController", "try read packet size: 4 bytes");
            i2 = this.h.read((byte[])localObject1, n, 4 - n);
            if (i2 <= 0) {
              break label638;
            }
            this.l = ((int)(System.currentTimeMillis() - this.k));
            i1 = n + i2;
            n = i1;
            if (i1 != 4) {
              continue;
            }
          }
          if (i1 == 4)
          {
            n = ml.a((byte[])localObject1);
            if ((n > 4) && (n <= 524288))
            {
              Object localObject3 = new byte[n];
              System.arraycopy(localObject1, 0, localObject3, 0, 4);
              long l2 = System.currentTimeMillis();
              if (i1 < n)
              {
                i2 = n - i1;
                mc.a("WupTaskController", "try read:".concat(String.valueOf(i2)));
                i2 = this.h.read((byte[])localObject3, i1, i2);
                mc.a("WupTaskController", "read ret:".concat(String.valueOf(i2)));
                if (i2 <= 0) {
                  break label648;
                }
                i1 += i2;
                continue;
              }
              if (i1 != n)
              {
                localObject1 = new StringBuilder("read fail. readLen:");
                ((StringBuilder)localObject1).append(i1);
                ((StringBuilder)localObject1).append(",packSize:");
                ((StringBuilder)localObject1).append(n);
                mc.c("WupTaskController", ((StringBuilder)localObject1).toString());
                localObject1 = new StringBuilder("readLen != packSize,rspBuff:");
                ((StringBuilder)localObject1).append(ml.b((byte[])localObject3));
                a(-6, ((StringBuilder)localObject1).toString());
                return;
              }
              this.m = ((int)(System.currentTimeMillis() - l2));
              mc.b("WupTaskController", "doSendReceive: read finish,readLen=".concat(String.valueOf(i1)));
              localObject1 = new mf();
              try
              {
                n = localObject3.length;
                if (n >= 4) {
                  try
                  {
                    localObject3 = new md((byte[])localObject3, (byte)0);
                    ((md)localObject3).b = ((mf)localObject1).b;
                    ((mf)localObject1).c.a((md)localObject3);
                    localObject3 = new md(((mf)localObject1).c.e);
                    ((md)localObject3).b = ((mf)localObject1).b;
                    if (mf.d == null)
                    {
                      localHashMap = new HashMap();
                      mf.d = localHashMap;
                      localHashMap.put("", new byte[0]);
                    }
                    HashMap localHashMap = mf.d;
                    ((mf)localObject1).a = ((HashMap)((md)localObject3).a(new HashMap(), localHashMap, 0, false));
                    if (this.a != null)
                    {
                      this.a.c = ((mf)localObject1);
                      this.a.e = 0;
                      this.m = ((int)(System.currentTimeMillis() - l1));
                      this.a.i = this.l;
                      this.a.g = this.j;
                      this.a.j = this.m;
                    }
                    return;
                  }
                  catch (Exception localException1)
                  {
                    throw new RuntimeException(localException1);
                  }
                }
                throw new IllegalArgumentException("decode package must include size head");
              }
              catch (Exception localException2)
              {
                a(-8, ov.a(localException2));
                return;
              }
            }
            a(-6, "packSizeFail:".concat(String.valueOf(n)));
            return;
          }
          a(-6, "readLen fail:".concat(String.valueOf(i1)));
          return;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          mc.a("WupTaskController", localException3);
          a(-7, ov.a(localException3));
          return;
        }
        int i1 = n;
      }
      finally {}
      label638:
      if (i2 != -1)
      {
        continue;
        if (i2 != -1) {}
      }
    }
  }
  
  final boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.d != null)
      {
        bool1 = bool2;
        if (this.d.isConnected())
        {
          bool1 = bool2;
          if (!this.d.isClosed())
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
  final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 157	com/tencent/token/os:h	Ljava/io/InputStream;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +26 -> 34
    //   11: aload_0
    //   12: getfield 157	com/tencent/token/os:h	Ljava/io/InputStream;
    //   15: invokevirtual 269	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 157	com/tencent/token/os:h	Ljava/io/InputStream;
    //   23: goto +11 -> 34
    //   26: astore_1
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 157	com/tencent/token/os:h	Ljava/io/InputStream;
    //   32: aload_1
    //   33: athrow
    //   34: aload_0
    //   35: getfield 117	com/tencent/token/os:g	Ljava/io/OutputStream;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +26 -> 66
    //   43: aload_0
    //   44: getfield 117	com/tencent/token/os:g	Ljava/io/OutputStream;
    //   47: invokevirtual 143	java/io/OutputStream:close	()V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 117	com/tencent/token/os:g	Ljava/io/OutputStream;
    //   55: goto +11 -> 66
    //   58: astore_1
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 117	com/tencent/token/os:g	Ljava/io/OutputStream;
    //   64: aload_1
    //   65: athrow
    //   66: aload_0
    //   67: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +26 -> 98
    //   75: aload_0
    //   76: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   79: invokevirtual 146	java/net/Socket:close	()V
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   87: goto +11 -> 98
    //   90: astore_1
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   96: aload_1
    //   97: athrow
    //   98: invokestatic 273	com/tencent/token/op:a	()V
    //   101: aload_0
    //   102: monitorexit
    //   103: return
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: goto -92 -> 18
    //   113: astore_1
    //   114: goto -64 -> 50
    //   117: astore_1
    //   118: goto -36 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	os
    //   6	2	1	localInputStream	InputStream
    //   26	7	1	localObject1	Object
    //   38	2	1	localOutputStream	OutputStream
    //   58	7	1	localObject2	Object
    //   70	2	1	localSocket	Socket
    //   90	7	1	localObject3	Object
    //   104	4	1	localObject4	Object
    //   109	1	1	localException1	Exception
    //   113	1	1	localException2	Exception
    //   117	1	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   11	18	26	finally
    //   43	50	58	finally
    //   75	82	90	finally
    //   2	7	104	finally
    //   18	23	104	finally
    //   27	34	104	finally
    //   34	39	104	finally
    //   50	55	104	finally
    //   59	66	104	finally
    //   66	71	104	finally
    //   82	87	104	finally
    //   91	98	104	finally
    //   98	101	104	finally
    //   11	18	109	java/lang/Exception
    //   43	50	113	java/lang/Exception
    //   75	82	117	java/lang/Exception
  }
  
  /* Error */
  final void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 103
    //   4: ldc_w 275
    //   7: invokestatic 193	com/tencent/token/mc:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: new 277	com/tencent/token/or
    //   13: dup
    //   14: invokespecial 278	com/tencent/token/or:<init>	()V
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 57	com/tencent/token/os:a	Lcom/tencent/token/ot;
    //   22: getfield 75	com/tencent/token/ot:m	I
    //   25: ifle +21 -> 46
    //   28: aload_0
    //   29: getfield 57	com/tencent/token/os:a	Lcom/tencent/token/ot;
    //   32: getfield 75	com/tencent/token/ot:m	I
    //   35: istore_1
    //   36: aload_3
    //   37: iload_1
    //   38: invokeinterface 281 2 0
    //   43: goto +16 -> 59
    //   46: invokestatic 286	com/tencent/token/oi:a	()Lcom/tencent/token/oi;
    //   49: getfield 289	com/tencent/token/oi:b	Lcom/tencent/token/ol;
    //   52: getfield 293	com/tencent/token/ol:a	I
    //   55: istore_1
    //   56: goto -20 -> 36
    //   59: aload_3
    //   60: invokestatic 286	com/tencent/token/oi:a	()Lcom/tencent/token/oi;
    //   63: getfield 289	com/tencent/token/oi:b	Lcom/tencent/token/ol;
    //   66: getfield 294	com/tencent/token/ol:d	I
    //   69: invokeinterface 296 2 0
    //   74: getstatic 301	com/tencent/token/ok:a	[I
    //   77: astore 4
    //   79: aload_3
    //   80: ldc_w 303
    //   83: invokeinterface 305 2 0
    //   88: aload_3
    //   89: aload 4
    //   91: invokeinterface 308 2 0
    //   96: invokestatic 313	com/tencent/token/of:a	()Lcom/tencent/token/of;
    //   99: ldc_w 303
    //   102: invokevirtual 316	com/tencent/token/of:a	(Ljava/lang/String;)Lcom/tencent/token/oe$a;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +31 -> 140
    //   112: new 318	java/util/ArrayList
    //   115: dup
    //   116: invokespecial 319	java/util/ArrayList:<init>	()V
    //   119: astore 5
    //   121: aload 5
    //   123: aload 4
    //   125: getfield 324	com/tencent/token/oe$a:c	Ljava/util/List;
    //   128: invokevirtual 328	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   131: pop
    //   132: aload_3
    //   133: aload 5
    //   135: invokeinterface 331 2 0
    //   140: invokestatic 286	com/tencent/token/oi:a	()Lcom/tencent/token/oi;
    //   143: getfield 334	com/tencent/token/oi:a	Lcom/tencent/token/ok;
    //   146: getfield 336	com/tencent/token/ok:b	J
    //   149: lconst_0
    //   150: lcmp
    //   151: ifle +11 -> 162
    //   154: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   157: pop2
    //   158: invokestatic 286	com/tencent/token/oi:a	()Lcom/tencent/token/oi;
    //   161: pop
    //   162: aload_3
    //   163: invokestatic 286	com/tencent/token/oi:a	()Lcom/tencent/token/oi;
    //   166: getfield 334	com/tencent/token/oi:a	Lcom/tencent/token/ok;
    //   169: invokevirtual 339	com/tencent/token/ok:c	()Ljava/util/ArrayList;
    //   172: invokeinterface 341 2 0
    //   177: aload_0
    //   178: iconst_0
    //   179: putfield 42	com/tencent/token/os:j	I
    //   182: aload_3
    //   183: invokeinterface 342 1 0
    //   188: aload_0
    //   189: aload_3
    //   190: invokeinterface 345 1 0
    //   195: putfield 40	com/tencent/token/os:i	I
    //   198: aload_0
    //   199: aload_3
    //   200: invokeinterface 347 1 0
    //   205: putfield 42	com/tencent/token/os:j	I
    //   208: aload_0
    //   209: getfield 57	com/tencent/token/os:a	Lcom/tencent/token/ot;
    //   212: aload_0
    //   213: getfield 40	com/tencent/token/os:i	I
    //   216: putfield 349	com/tencent/token/ot:h	I
    //   219: aload_0
    //   220: getfield 57	com/tencent/token/os:a	Lcom/tencent/token/ot;
    //   223: aload_0
    //   224: getfield 42	com/tencent/token/os:j	I
    //   227: putfield 247	com/tencent/token/ot:g	I
    //   230: aload_3
    //   231: invokeinterface 351 1 0
    //   236: ifne +319 -> 555
    //   239: aload_0
    //   240: aload_3
    //   241: invokeinterface 354 1 0
    //   246: putfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   249: aload_0
    //   250: aload_3
    //   251: invokeinterface 357 1 0
    //   256: putfield 359	com/tencent/token/os:f	Lcom/tencent/token/od;
    //   259: aload_0
    //   260: getfield 57	com/tencent/token/os:a	Lcom/tencent/token/ot;
    //   263: aload_0
    //   264: getfield 359	com/tencent/token/os:f	Lcom/tencent/token/od;
    //   267: putfield 361	com/tencent/token/ot:k	Lcom/tencent/token/od;
    //   270: new 80	java/lang/StringBuilder
    //   273: dup
    //   274: ldc_w 363
    //   277: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   280: astore_3
    //   281: aload_3
    //   282: aload_0
    //   283: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   286: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_3
    //   291: ldc_w 365
    //   294: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_3
    //   299: aload_0
    //   300: getfield 359	com/tencent/token/os:f	Lcom/tencent/token/od;
    //   303: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: ldc 103
    //   309: aload_3
    //   310: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 193	com/tencent/token/mc:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   320: ifnull +160 -> 480
    //   323: aload_0
    //   324: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   327: invokevirtual 265	java/net/Socket:isConnected	()Z
    //   330: ifeq +150 -> 480
    //   333: aload_0
    //   334: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   337: invokevirtual 268	java/net/Socket:isClosed	()Z
    //   340: istore_2
    //   341: iload_2
    //   342: ifne +138 -> 480
    //   345: aload_0
    //   346: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   349: aload_0
    //   350: getfield 36	com/tencent/token/os:c	I
    //   353: invokevirtual 368	java/net/Socket:setSoTimeout	(I)V
    //   356: aload_0
    //   357: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   360: ldc 169
    //   362: invokevirtual 371	java/net/Socket:setReceiveBufferSize	(I)V
    //   365: aload_0
    //   366: aload_0
    //   367: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   370: invokevirtual 375	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   373: putfield 117	com/tencent/token/os:g	Ljava/io/OutputStream;
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   381: invokevirtual 379	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   384: putfield 157	com/tencent/token/os:h	Ljava/io/InputStream;
    //   387: new 80	java/lang/StringBuilder
    //   390: dup
    //   391: ldc_w 381
    //   394: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   397: astore_3
    //   398: aload_3
    //   399: aload_0
    //   400: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   403: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: ldc 103
    //   409: aload_3
    //   410: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 112	com/tencent/token/mc:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload_0
    //   417: monitorexit
    //   418: return
    //   419: astore_3
    //   420: goto +58 -> 478
    //   423: astore_3
    //   424: aload_3
    //   425: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   428: new 80	java/lang/StringBuilder
    //   431: dup
    //   432: ldc_w 383
    //   435: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   438: astore 4
    //   440: aload 4
    //   442: aload_0
    //   443: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   446: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: ldc 103
    //   452: aload 4
    //   454: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: aload_3
    //   458: invokestatic 386	com/tencent/token/mc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   461: aload_0
    //   462: bipush 253
    //   464: aload_3
    //   465: invokestatic 138	com/tencent/token/ov:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   468: invokespecial 55	com/tencent/token/os:a	(ILjava/lang/String;)V
    //   471: aload_0
    //   472: invokevirtual 388	com/tencent/token/os:d	()V
    //   475: aload_0
    //   476: monitorexit
    //   477: return
    //   478: aload_3
    //   479: athrow
    //   480: aload_0
    //   481: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   484: ifnonnull +15 -> 499
    //   487: aload_0
    //   488: bipush 253
    //   490: ldc_w 390
    //   493: invokespecial 55	com/tencent/token/os:a	(ILjava/lang/String;)V
    //   496: aload_0
    //   497: monitorexit
    //   498: return
    //   499: new 80	java/lang/StringBuilder
    //   502: dup
    //   503: ldc_w 392
    //   506: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   509: astore_3
    //   510: aload_3
    //   511: aload_0
    //   512: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   515: invokevirtual 265	java/net/Socket:isConnected	()Z
    //   518: invokevirtual 395	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload_3
    //   523: ldc_w 397
    //   526: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_3
    //   531: aload_0
    //   532: getfield 98	com/tencent/token/os:d	Ljava/net/Socket;
    //   535: invokevirtual 268	java/net/Socket:isClosed	()Z
    //   538: invokevirtual 395	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_0
    //   543: bipush 253
    //   545: aload_3
    //   546: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokespecial 55	com/tencent/token/os:a	(ILjava/lang/String;)V
    //   552: aload_0
    //   553: monitorexit
    //   554: return
    //   555: invokestatic 401	com/tencent/token/ou:f	()Z
    //   558: ifeq +56 -> 614
    //   561: invokestatic 405	com/tencent/token/mh:a	()Z
    //   564: ifeq +41 -> 605
    //   567: new 80	java/lang/StringBuilder
    //   570: dup
    //   571: ldc_w 407
    //   574: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   577: astore 4
    //   579: aload 4
    //   581: aload_3
    //   582: invokeinterface 351 1 0
    //   587: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_0
    //   592: bipush 253
    //   594: aload 4
    //   596: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokespecial 55	com/tencent/token/os:a	(ILjava/lang/String;)V
    //   602: aload_0
    //   603: monitorexit
    //   604: return
    //   605: aload_0
    //   606: bipush 240
    //   608: invokespecial 140	com/tencent/token/os:a	(I)V
    //   611: aload_0
    //   612: monitorexit
    //   613: return
    //   614: aload_0
    //   615: bipush 252
    //   617: invokespecial 140	com/tencent/token/os:a	(I)V
    //   620: aload_0
    //   621: monitorexit
    //   622: return
    //   623: astore_3
    //   624: aload_0
    //   625: monitorexit
    //   626: aload_3
    //   627: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	os
    //   35	21	1	n	int
    //   340	2	2	bool	boolean
    //   17	393	3	localObject1	Object
    //   419	1	3	localObject2	Object
    //   423	56	3	localException	Exception
    //   509	73	3	localStringBuilder	StringBuilder
    //   623	4	3	localObject3	Object
    //   77	518	4	localObject4	Object
    //   119	15	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   345	416	419	finally
    //   424	475	419	finally
    //   345	416	423	java/lang/Exception
    //   2	36	623	finally
    //   36	43	623	finally
    //   46	56	623	finally
    //   59	107	623	finally
    //   112	140	623	finally
    //   140	162	623	finally
    //   162	341	623	finally
    //   478	480	623	finally
    //   480	496	623	finally
    //   499	552	623	finally
    //   555	602	623	finally
    //   605	611	623	finally
    //   614	620	623	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.os
 * JD-Core Version:    0.7.0.1
 */