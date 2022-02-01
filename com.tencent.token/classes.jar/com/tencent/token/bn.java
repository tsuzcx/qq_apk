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
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_2
    //   7: iload 4
    //   9: ifne +307 -> 316
    //   12: aload_1
    //   13: ifnull +312 -> 325
    //   16: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   19: aload_1
    //   20: getfield 74	com/tencent/token/bo:i	J
    //   23: lsub
    //   24: aload_1
    //   25: getfield 75	com/tencent/token/bo:j	I
    //   28: i2l
    //   29: lcmp
    //   30: ifge +295 -> 325
    //   33: iconst_0
    //   34: istore_3
    //   35: goto +3 -> 38
    //   38: iload_3
    //   39: ifne +277 -> 316
    //   42: iload_2
    //   43: iconst_5
    //   44: if_icmpge +272 -> 316
    //   47: iload_2
    //   48: iconst_1
    //   49: iadd
    //   50: istore_3
    //   51: aload_0
    //   52: invokespecial 78	com/tencent/token/bn:c	()Z
    //   55: istore 5
    //   57: iload 5
    //   59: ifeq +244 -> 303
    //   62: new 80	java/lang/StringBuilder
    //   65: dup
    //   66: ldc 82
    //   68: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: astore 6
    //   73: aload 6
    //   75: aload_1
    //   76: invokevirtual 88	com/tencent/token/bo:j	()I
    //   79: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 6
    //   85: ldc 94
    //   87: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 6
    //   93: aload_0
    //   94: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   97: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 104
    //   103: aload 6
    //   105: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 113	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_1
    //   112: invokevirtual 116	com/tencent/token/bo:k	()[B
    //   115: astore 6
    //   117: aload_0
    //   118: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   121: aload 6
    //   123: iconst_0
    //   124: aload 6
    //   126: arraylength
    //   127: invokevirtual 124	java/io/OutputStream:write	([BII)V
    //   130: aload_0
    //   131: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   134: invokevirtual 127	java/io/OutputStream:flush	()V
    //   137: aload_0
    //   138: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   141: putfield 46	com/tencent/token/bn:k	J
    //   144: new 80	java/lang/StringBuilder
    //   147: dup
    //   148: ldc 129
    //   150: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: astore 7
    //   155: aload 7
    //   157: aload 6
    //   159: arraylength
    //   160: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 104
    //   166: aload 7
    //   168: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 131	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: iconst_1
    //   175: istore 4
    //   177: iload_3
    //   178: istore_2
    //   179: goto -172 -> 7
    //   182: astore 6
    //   184: goto +77 -> 261
    //   187: astore 6
    //   189: ldc 104
    //   191: aload 6
    //   193: invokestatic 134	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_1
    //   197: bipush 251
    //   199: putfield 60	com/tencent/token/bo:b	I
    //   202: aload_1
    //   203: aload 6
    //   205: invokestatic 139	com/tencent/token/bq:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   208: putfield 63	com/tencent/token/bo:c	Ljava/lang/String;
    //   211: iload_3
    //   212: istore_2
    //   213: iload 4
    //   215: ifne -208 -> 7
    //   218: aload_0
    //   219: aload_1
    //   220: getfield 60	com/tencent/token/bo:b	I
    //   223: invokespecial 141	com/tencent/token/bn:a	(I)V
    //   226: aload_0
    //   227: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   230: invokevirtual 144	java/io/OutputStream:close	()V
    //   233: aload_0
    //   234: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   237: invokevirtual 147	java/net/Socket:close	()V
    //   240: aload_0
    //   241: invokespecial 149	com/tencent/token/bn:e	()V
    //   244: iload_3
    //   245: istore_2
    //   246: goto -239 -> 7
    //   249: astore 6
    //   251: aload 6
    //   253: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   256: iload_3
    //   257: istore_2
    //   258: goto -251 -> 7
    //   261: iload 4
    //   263: ifne +37 -> 300
    //   266: aload_0
    //   267: aload_1
    //   268: getfield 60	com/tencent/token/bo:b	I
    //   271: invokespecial 141	com/tencent/token/bn:a	(I)V
    //   274: aload_0
    //   275: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   278: invokevirtual 144	java/io/OutputStream:close	()V
    //   281: aload_0
    //   282: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   285: invokevirtual 147	java/net/Socket:close	()V
    //   288: aload_0
    //   289: invokespecial 149	com/tencent/token/bn:e	()V
    //   292: goto +8 -> 300
    //   295: astore_1
    //   296: aload_1
    //   297: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   300: aload 6
    //   302: athrow
    //   303: aload_0
    //   304: invokespecial 149	com/tencent/token/bn:e	()V
    //   307: iload_3
    //   308: istore_2
    //   309: goto -302 -> 7
    //   312: aload_0
    //   313: monitorexit
    //   314: aload_1
    //   315: athrow
    //   316: aload_0
    //   317: monitorexit
    //   318: iload 4
    //   320: ireturn
    //   321: astore_1
    //   322: goto -10 -> 312
    //   325: iconst_1
    //   326: istore_3
    //   327: goto -289 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	bn
    //   0	330	1	parambo	bo
    //   6	303	2	n	int
    //   34	293	3	i1	int
    //   3	316	4	bool1	boolean
    //   55	3	5	bool2	boolean
    //   71	87	6	localObject1	Object
    //   182	1	6	localObject2	Object
    //   187	17	6	localException1	Exception
    //   249	52	6	localException2	Exception
    //   153	14	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   62	174	182	finally
    //   189	211	182	finally
    //   62	174	187	java/lang/Exception
    //   218	244	249	java/lang/Exception
    //   266	292	295	java/lang/Exception
    //   16	33	321	finally
    //   51	57	321	finally
    //   218	244	321	finally
    //   251	256	321	finally
    //   266	292	321	finally
    //   296	300	321	finally
    //   300	303	321	finally
    //   303	307	321	finally
  }
  
  private void b()
  {
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
          ((StringBuilder)localObject1).append(this.c);
          b.b("WupTaskController", ((StringBuilder)localObject1).toString());
          Object localObject3 = new byte[4];
          n = 0;
          i1 = n;
          if (n < 4)
          {
            b.a("WupTaskController", "try read packet size: 4 bytes");
            i2 = this.h.read((byte[])localObject3, n, 4 - n);
            if (i2 <= 0) {
              break label563;
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
            n = h.a((byte[])localObject3, 0);
            if ((n > 4) && (n <= 524288))
            {
              localObject1 = new byte[n];
              System.arraycopy(localObject3, 0, localObject1, 0, 4);
              long l2 = System.currentTimeMillis();
              if (i1 < n)
              {
                i2 = n - i1;
                localObject3 = new StringBuilder("try read:");
                ((StringBuilder)localObject3).append(i2);
                b.a("WupTaskController", ((StringBuilder)localObject3).toString());
                i2 = this.h.read((byte[])localObject1, i1, i2);
                localObject3 = new StringBuilder("read ret:");
                ((StringBuilder)localObject3).append(i2);
                b.a("WupTaskController", ((StringBuilder)localObject3).toString());
                if (i2 <= 0) {
                  break label573;
                }
                i1 += i2;
                continue;
              }
              if (i1 != n)
              {
                localObject3 = new StringBuilder("read fail. readLen:");
                ((StringBuilder)localObject3).append(i1);
                ((StringBuilder)localObject3).append(",packSize:");
                ((StringBuilder)localObject3).append(n);
                b.c("WupTaskController", ((StringBuilder)localObject3).toString());
                localObject3 = new StringBuilder("readLen != packSize,rspBuff:");
                ((StringBuilder)localObject3).append(h.a((byte[])localObject1));
                a(-6, ((StringBuilder)localObject3).toString());
                return;
              }
              this.m = ((int)(System.currentTimeMillis() - l2));
              localObject3 = new StringBuilder("doSendReceive: read finish,readLen=");
              ((StringBuilder)localObject3).append(i1);
              b.b("WupTaskController", ((StringBuilder)localObject3).toString());
              localObject3 = new d();
              try
              {
                ((d)localObject3).a((byte[])localObject1);
                if (this.e != null)
                {
                  this.e.a = ((d)localObject3);
                  this.e.b = 0;
                  this.m = ((int)(System.currentTimeMillis() - l1));
                  this.e.f = this.l;
                  this.e.d = this.j;
                  this.e.g = this.m;
                }
                return;
              }
              catch (Exception localException1)
              {
                a(-8, bq.a(localException1));
                return;
              }
            }
            localStringBuilder = new StringBuilder("packSizeFail:");
            localStringBuilder.append(n);
            a(-6, localStringBuilder.toString());
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder("readLen fail:");
          localStringBuilder.append(i1);
          a(-6, localStringBuilder.toString());
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          b.a("WupTaskController", localException2);
          a(-7, bq.a(localException2));
          return;
        }
        int i1 = n;
      }
      finally {}
      label563:
      if (i2 != -1)
      {
        continue;
        label573:
        if (i2 == -1) {}
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
    //   8: ifnull +26 -> 34
    //   11: aload_0
    //   12: getfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   15: invokevirtual 216	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   23: goto +11 -> 34
    //   26: astore_1
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   32: aload_1
    //   33: athrow
    //   34: aload_0
    //   35: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +26 -> 66
    //   43: aload_0
    //   44: getfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   47: invokevirtual 144	java/io/OutputStream:close	()V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   55: goto +11 -> 66
    //   58: astore_1
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   64: aload_1
    //   65: athrow
    //   66: aload_0
    //   67: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +26 -> 98
    //   75: aload_0
    //   76: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   79: invokevirtual 147	java/net/Socket:close	()V
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   87: goto +11 -> 98
    //   90: astore_1
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   96: aload_1
    //   97: athrow
    //   98: invokestatic 220	com/tencent/token/bk:a	()V
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
    //   0	121	0	this	bn
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
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 104
    //   4: ldc 222
    //   6: invokestatic 184	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 224	com/tencent/token/bm
    //   12: dup
    //   13: invokespecial 225	com/tencent/token/bm:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   22: getfield 75	com/tencent/token/bo:j	I
    //   25: ifle +22 -> 47
    //   28: aload_0
    //   29: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   32: getfield 75	com/tencent/token/bo:j	I
    //   35: istore_1
    //   36: aload 7
    //   38: iload_1
    //   39: invokeinterface 228 2 0
    //   44: goto +16 -> 60
    //   47: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   50: getfield 236	com/tencent/token/bd:b	Lcom/tencent/token/bg;
    //   53: getfield 240	com/tencent/token/bg:a	I
    //   56: istore_1
    //   57: goto -21 -> 36
    //   60: aload 7
    //   62: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   65: getfield 236	com/tencent/token/bd:b	Lcom/tencent/token/bg;
    //   68: getfield 241	com/tencent/token/bg:d	I
    //   71: invokeinterface 243 2 0
    //   76: getstatic 248	com/tencent/token/bf:a	[I
    //   79: astore 8
    //   81: aload 7
    //   83: ldc 250
    //   85: invokeinterface 252 2 0
    //   90: aload 7
    //   92: aload 8
    //   94: invokeinterface 255 2 0
    //   99: invokestatic 260	com/tencent/token/ba:a	()Lcom/tencent/token/ba;
    //   102: ldc 250
    //   104: invokevirtual 263	com/tencent/token/ba:a	(Ljava/lang/String;)Lcom/tencent/token/az$a;
    //   107: astore 8
    //   109: aload 8
    //   111: ifnull +32 -> 143
    //   114: new 265	java/util/ArrayList
    //   117: dup
    //   118: invokespecial 266	java/util/ArrayList:<init>	()V
    //   121: astore 9
    //   123: aload 9
    //   125: aload 8
    //   127: invokevirtual 271	com/tencent/token/az$a:c	()Ljava/util/List;
    //   130: invokevirtual 275	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   133: pop
    //   134: aload 7
    //   136: aload 9
    //   138: invokeinterface 278 2 0
    //   143: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   146: getfield 281	com/tencent/token/bd:a	Lcom/tencent/token/bf;
    //   149: getfield 283	com/tencent/token/bf:b	J
    //   152: lstore_2
    //   153: iconst_1
    //   154: istore 6
    //   156: lload_2
    //   157: lconst_0
    //   158: lcmp
    //   159: ifgt +6 -> 165
    //   162: goto +36 -> 198
    //   165: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   168: lstore 4
    //   170: lload_2
    //   171: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   174: getfield 236	com/tencent/token/bd:b	Lcom/tencent/token/bg;
    //   177: getfield 285	com/tencent/token/bg:e	I
    //   180: bipush 60
    //   182: imul
    //   183: sipush 1000
    //   186: imul
    //   187: i2l
    //   188: ladd
    //   189: lload 4
    //   191: lcmp
    //   192: ifge +505 -> 697
    //   195: goto +3 -> 198
    //   198: aload 7
    //   200: invokestatic 233	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   203: getfield 281	com/tencent/token/bd:a	Lcom/tencent/token/bf;
    //   206: invokevirtual 288	com/tencent/token/bf:c	()Ljava/util/ArrayList;
    //   209: iload 6
    //   211: invokeinterface 291 3 0
    //   216: aload_0
    //   217: iconst_0
    //   218: putfield 42	com/tencent/token/bn:j	I
    //   221: aload 7
    //   223: invokeinterface 292 1 0
    //   228: aload_0
    //   229: aload 7
    //   231: invokeinterface 294 1 0
    //   236: putfield 40	com/tencent/token/bn:i	I
    //   239: aload_0
    //   240: aload 7
    //   242: invokeinterface 296 1 0
    //   247: putfield 42	com/tencent/token/bn:j	I
    //   250: aload_0
    //   251: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   254: aload_0
    //   255: getfield 40	com/tencent/token/bn:i	I
    //   258: putfield 297	com/tencent/token/bo:e	I
    //   261: aload_0
    //   262: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   265: aload_0
    //   266: getfield 42	com/tencent/token/bn:j	I
    //   269: putfield 203	com/tencent/token/bo:d	I
    //   272: aload 7
    //   274: invokeinterface 299 1 0
    //   279: ifne +342 -> 621
    //   282: aload_0
    //   283: aload 7
    //   285: invokeinterface 302 1 0
    //   290: putfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   293: aload_0
    //   294: aload 7
    //   296: invokeinterface 305 1 0
    //   301: putfield 307	com/tencent/token/bn:f	Lcom/tencent/token/ay;
    //   304: aload_0
    //   305: getfield 57	com/tencent/token/bn:e	Lcom/tencent/token/bo;
    //   308: aload_0
    //   309: getfield 307	com/tencent/token/bn:f	Lcom/tencent/token/ay;
    //   312: putfield 309	com/tencent/token/bo:h	Lcom/tencent/token/ay;
    //   315: new 80	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 311
    //   322: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: astore 7
    //   327: aload 7
    //   329: aload_0
    //   330: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   333: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 7
    //   339: ldc_w 313
    //   342: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 7
    //   348: aload_0
    //   349: getfield 307	com/tencent/token/bn:f	Lcom/tencent/token/ay;
    //   352: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: ldc 104
    //   358: aload 7
    //   360: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 184	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   370: ifnull +171 -> 541
    //   373: aload_0
    //   374: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   377: invokevirtual 212	java/net/Socket:isConnected	()Z
    //   380: ifeq +161 -> 541
    //   383: aload_0
    //   384: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   387: invokevirtual 215	java/net/Socket:isClosed	()Z
    //   390: istore 6
    //   392: iload 6
    //   394: ifne +147 -> 541
    //   397: aload_0
    //   398: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   401: aload_0
    //   402: getfield 36	com/tencent/token/bn:b	I
    //   405: invokevirtual 316	java/net/Socket:setSoTimeout	(I)V
    //   408: aload_0
    //   409: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   412: ldc 170
    //   414: invokevirtual 319	java/net/Socket:setReceiveBufferSize	(I)V
    //   417: aload_0
    //   418: aload_0
    //   419: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   422: invokevirtual 323	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   425: putfield 118	com/tencent/token/bn:g	Ljava/io/OutputStream;
    //   428: aload_0
    //   429: aload_0
    //   430: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   433: invokevirtual 327	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   436: putfield 158	com/tencent/token/bn:h	Ljava/io/InputStream;
    //   439: new 80	java/lang/StringBuilder
    //   442: dup
    //   443: ldc_w 329
    //   446: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: astore 7
    //   451: aload 7
    //   453: aload_0
    //   454: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   457: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: ldc 104
    //   463: aload 7
    //   465: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 113	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto +216 -> 687
    //   474: astore 7
    //   476: goto +62 -> 538
    //   479: astore 7
    //   481: aload 7
    //   483: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   486: new 80	java/lang/StringBuilder
    //   489: dup
    //   490: ldc_w 331
    //   493: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: astore 8
    //   498: aload 8
    //   500: aload_0
    //   501: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   504: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: ldc 104
    //   510: aload 8
    //   512: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: aload 7
    //   517: invokestatic 334	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   520: aload_0
    //   521: bipush 253
    //   523: aload 7
    //   525: invokestatic 139	com/tencent/token/bq:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   528: invokespecial 55	com/tencent/token/bn:a	(ILjava/lang/String;)V
    //   531: aload_0
    //   532: invokespecial 336	com/tencent/token/bn:d	()V
    //   535: aload_0
    //   536: monitorexit
    //   537: return
    //   538: aload 7
    //   540: athrow
    //   541: aload_0
    //   542: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   545: ifnonnull +15 -> 560
    //   548: aload_0
    //   549: bipush 253
    //   551: ldc_w 338
    //   554: invokespecial 55	com/tencent/token/bn:a	(ILjava/lang/String;)V
    //   557: aload_0
    //   558: monitorexit
    //   559: return
    //   560: new 80	java/lang/StringBuilder
    //   563: dup
    //   564: ldc_w 340
    //   567: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   570: astore 7
    //   572: aload 7
    //   574: aload_0
    //   575: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   578: invokevirtual 212	java/net/Socket:isConnected	()Z
    //   581: invokevirtual 343	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 7
    //   587: ldc_w 345
    //   590: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 7
    //   596: aload_0
    //   597: getfield 99	com/tencent/token/bn:c	Ljava/net/Socket;
    //   600: invokevirtual 215	java/net/Socket:isClosed	()Z
    //   603: invokevirtual 343	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload_0
    //   608: bipush 253
    //   610: aload 7
    //   612: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokespecial 55	com/tencent/token/bn:a	(ILjava/lang/String;)V
    //   618: aload_0
    //   619: monitorexit
    //   620: return
    //   621: invokestatic 349	com/tencent/token/bp:f	()Z
    //   624: ifeq +57 -> 681
    //   627: invokestatic 353	com/tencent/halley/common/d:a	()Z
    //   630: ifeq +42 -> 672
    //   633: new 80	java/lang/StringBuilder
    //   636: dup
    //   637: ldc_w 355
    //   640: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   643: astore 8
    //   645: aload 8
    //   647: aload 7
    //   649: invokeinterface 299 1 0
    //   654: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload_0
    //   659: bipush 253
    //   661: aload 8
    //   663: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokespecial 55	com/tencent/token/bn:a	(ILjava/lang/String;)V
    //   669: aload_0
    //   670: monitorexit
    //   671: return
    //   672: aload_0
    //   673: bipush 240
    //   675: invokespecial 141	com/tencent/token/bn:a	(I)V
    //   678: aload_0
    //   679: monitorexit
    //   680: return
    //   681: aload_0
    //   682: bipush 252
    //   684: invokespecial 141	com/tencent/token/bn:a	(I)V
    //   687: aload_0
    //   688: monitorexit
    //   689: return
    //   690: astore 7
    //   692: aload_0
    //   693: monitorexit
    //   694: aload 7
    //   696: athrow
    //   697: iconst_0
    //   698: istore 6
    //   700: goto -502 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	703	0	this	bn
    //   35	22	1	n	int
    //   152	19	2	l1	long
    //   168	22	4	l2	long
    //   154	545	6	bool	boolean
    //   16	448	7	localObject1	Object
    //   474	1	7	localObject2	Object
    //   479	60	7	localException	Exception
    //   570	78	7	localStringBuilder	StringBuilder
    //   690	5	7	localObject3	Object
    //   79	583	8	localObject4	Object
    //   121	16	9	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   397	471	474	finally
    //   481	535	474	finally
    //   397	471	479	java/lang/Exception
    //   2	36	690	finally
    //   36	44	690	finally
    //   47	57	690	finally
    //   60	109	690	finally
    //   114	143	690	finally
    //   143	153	690	finally
    //   165	195	690	finally
    //   198	392	690	finally
    //   538	541	690	finally
    //   541	557	690	finally
    //   560	618	690	finally
    //   621	669	690	finally
    //   672	678	690	finally
    //   681	687	690	finally
  }
  
  public final void a(bo parambo, int paramInt)
  {
    if (parambo == null) {
      return;
    }
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
      }
      return;
    }
    catch (Exception parambo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bn
 * JD-Core Version:    0.7.0.1
 */