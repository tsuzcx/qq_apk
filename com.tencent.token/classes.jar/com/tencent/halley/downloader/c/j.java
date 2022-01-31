package com.tencent.halley.downloader.c;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.halley.common.c;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.c.d.a;
import com.tencent.halley.downloader.c.d.a.a;
import com.tencent.token.ad;
import com.tencent.token.ae;
import com.tencent.token.af;
import com.tencent.token.o;

final class j
  implements ae
{
  af a;
  af b;
  
  private j(h paramh) {}
  
  private boolean a(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (h.a(this.c).a())
    {
      String str = h.b(this.c).c();
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          bool1 = bool2;
          if (!str.equals(paramString)) {
            bool1 = true;
          }
        }
      }
      Log.d("DownloadTest", "savedLM:" + str + ",newLM:" + paramString + ",fail:" + bool1);
    }
    return bool1;
  }
  
  public final com.tencent.halley.common.g a(af paramaf, a parama, String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramaf != null) {}
    for (;;)
    {
      int i;
      label55:
      com.tencent.halley.common.g localg;
      try
      {
        if (paramaf != this.a)
        {
          if (paramaf == this.b)
          {
            break label829;
            if ((i == 0) || (paramaf.a()) || (paramLong <= 0L))
            {
              paramaf = new com.tencent.halley.common.g(4, "");
              return paramaf;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          localg = new com.tencent.halley.common.g(0, "");
          if (h.b(this.c) != null)
          {
            g localg1 = h.b(this.c);
            if (paramaf.a.i == localg1)
            {
              i = 1;
              break label835;
            }
          }
          else
          {
            localg.a = 2;
            localg.b = "not the same divider";
            c.c("TaskImpl", "onValidResponse... fail...not self section:" + paramaf.a);
            paramaf = localg;
            continue;
          }
          i = 0;
        }
      }
      finally {}
      label649:
      label796:
      label829:
      label835:
      while (i != 0)
      {
        if (this.c.g == -1L) {
          if ((this.c.f != -1L) && (paramLong != this.c.f))
          {
            localg.a = -10;
            localg.b = ("knownSize:" + this.c.f + ",rspLength:" + paramLong);
            if (localg.a == 0)
            {
              if ((!h.c(this.c)) && (!h.a(this.c, paramLong))) {
                this.c.a(false, this.c.r, this.c.s, DownloaderTaskStatus.FAILED);
              }
              h.d(this.c).a(b.a.c);
            }
          }
        }
        for (;;)
        {
          paramaf = localg;
          if (localg.a != 0) {
            break;
          }
          paramaf = localg;
          if (TextUtils.isEmpty(paramString1)) {
            break;
          }
          if ((parama.b != a.a.b) && (parama.b != a.a.a)) {
            break label796;
          }
          h.a(this.c).a(o.a, paramString1);
          paramaf = localg;
          break;
          this.c.g = paramLong;
          this.c.k = paramBoolean;
          this.c.l = paramString4;
          this.c.m = paramString5;
          if (paramaf.b != null) {
            this.c.A = paramaf.b.c;
          }
          if (!this.c.k)
          {
            h.a(this.c, new g(""));
            paramaf.a = h.b(this.c).a();
          }
          for (;;)
          {
            h.b(this.c).a = paramLong;
            h.b(this.c).a(paramString2);
            h.b(this.c).b(paramString3);
            if ((paramaf.a.c != -1) || (paramaf.a.b != -1)) {
              break;
            }
            h.b(this.c).a(paramaf.a);
            break;
            if (h.b(this.c).a > 0L)
            {
              i = 0;
              if (h.b(this.c).a != this.c.g) {
                i = 1;
              }
              for (;;)
              {
                if (i == 0) {
                  break label649;
                }
                h.a(this.c, new g(""));
                localg.a = 3;
                localg.b = "can not resume from cfg, start over now";
                break;
                if (a(paramString3)) {
                  i = 1;
                }
              }
            }
          }
          if (paramLong != this.c.g)
          {
            localg.a = -43;
            localg.b = ("detectLength:" + this.c.g + ",rspLength:" + paramLong);
          }
          else if (!this.c.k)
          {
            localg.a = 1;
            localg.b = "not support range";
          }
          else if (a(paramString3))
          {
            localg.a = -68;
            localg.b = ("detected VerifyProperty:" + h.b(this.c).c() + ",rsp VerifyProperty:" + paramString3);
          }
        }
        paramaf = localg;
        if (parama.b != a.a.g) {
          break label55;
        }
        h.a(this.c).b(o.a, paramString1);
        paramaf = localg;
        break label55;
        i = 1;
        break;
      }
    }
  }
  
  public final ad a(af paramaf)
  {
    int i;
    if ((paramaf != null) && ((paramaf == this.a) || (paramaf == this.b)))
    {
      i = 1;
      if (i != 0) {
        break label33;
      }
    }
    label33:
    while (!this.c.k)
    {
      return null;
      i = 0;
      break;
    }
    return h.b(this.c).a();
  }
  
  public final boolean a()
  {
    return this.c.g != -1L;
  }
  
  /* Error */
  public final boolean a(af arg1, long paramLong, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_1
    //   4: ifnull +29 -> 33
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 85	com/tencent/halley/downloader/c/j:a	Lcom/tencent/token/af;
    //   12: if_acmpeq +11 -> 23
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 87	com/tencent/halley/downloader/c/j:b	Lcom/tencent/token/af;
    //   20: if_acmpne +13 -> 33
    //   23: iconst_1
    //   24: istore 7
    //   26: iload 7
    //   28: ifne +11 -> 39
    //   31: iconst_0
    //   32: ireturn
    //   33: iconst_0
    //   34: istore 7
    //   36: goto -10 -> 26
    //   39: iload 5
    //   41: ifle +31 -> 72
    //   44: aload_0
    //   45: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   48: getfield 255	com/tencent/halley/downloader/c/h:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   51: iload 5
    //   53: i2l
    //   54: invokevirtual 261	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   57: pop2
    //   58: aload_0
    //   59: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   62: getfield 264	com/tencent/halley/downloader/c/h:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   65: iload 5
    //   67: i2l
    //   68: invokevirtual 261	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   71: pop2
    //   72: aload_0
    //   73: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   76: invokestatic 36	com/tencent/halley/downloader/c/h:b	(Lcom/tencent/halley/downloader/c/h;)Lcom/tencent/halley/downloader/c/g;
    //   79: ifnull +32 -> 111
    //   82: aload_0
    //   83: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   86: invokestatic 36	com/tencent/halley/downloader/c/h:b	(Lcom/tencent/halley/downloader/c/h;)Lcom/tencent/halley/downloader/c/g;
    //   89: astore 9
    //   91: aload_1
    //   92: getfield 100	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   95: getfield 106	com/tencent/token/ad:i	Lcom/tencent/halley/downloader/c/g;
    //   98: aload 9
    //   100: if_acmpne +13 -> 113
    //   103: iconst_1
    //   104: istore 7
    //   106: iload 7
    //   108: ifne +11 -> 119
    //   111: iconst_0
    //   112: ireturn
    //   113: iconst_0
    //   114: istore 7
    //   116: goto -10 -> 106
    //   119: iload 6
    //   121: ifeq +148 -> 269
    //   124: aload_0
    //   125: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   128: iconst_0
    //   129: putfield 267	com/tencent/halley/downloader/c/h:w	I
    //   132: ldc 55
    //   134: new 57	java/lang/StringBuilder
    //   137: dup
    //   138: ldc_w 269
    //   141: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: aload_1
    //   145: invokevirtual 271	com/tencent/token/af:b	()Z
    //   148: invokevirtual 73	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   151: ldc_w 273
    //   154: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: getfield 100	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   161: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 274	com/tencent/halley/common/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_1
    //   171: getfield 100	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   174: getfield 226	com/tencent/token/ad:b	I
    //   177: iconst_m1
    //   178: if_icmpne +91 -> 269
    //   181: aload_0
    //   182: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   185: invokestatic 36	com/tencent/halley/downloader/c/h:b	(Lcom/tencent/halley/downloader/c/h;)Lcom/tencent/halley/downloader/c/g;
    //   188: aload_1
    //   189: getfield 100	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   192: invokevirtual 229	com/tencent/halley/downloader/c/g:a	(Lcom/tencent/token/ad;)Z
    //   195: istore 6
    //   197: ldc 55
    //   199: new 57	java/lang/StringBuilder
    //   202: dup
    //   203: ldc_w 269
    //   206: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: aload_1
    //   210: invokevirtual 271	com/tencent/token/af:b	()Z
    //   213: invokevirtual 73	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   216: ldc_w 276
    //   219: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: getfield 100	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   226: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: ldc_w 278
    //   232: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: iload 6
    //   237: invokevirtual 73	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   240: ldc_w 280
    //   243: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   250: invokestatic 36	com/tencent/halley/downloader/c/h:b	(Lcom/tencent/halley/downloader/c/h;)Lcom/tencent/halley/downloader/c/g;
    //   253: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 126	com/tencent/halley/common/c:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: iload 6
    //   264: ifne +5 -> 269
    //   267: iconst_0
    //   268: ireturn
    //   269: iload 5
    //   271: ifle +205 -> 476
    //   274: aload_0
    //   275: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   278: invokevirtual 283	com/tencent/halley/downloader/c/h:x	()Z
    //   281: ifne +195 -> 476
    //   284: aload_0
    //   285: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   288: invokestatic 287	com/tencent/halley/downloader/c/h:e	(Lcom/tencent/halley/downloader/c/h;)Lcom/tencent/token/z;
    //   291: aload_1
    //   292: getfield 100	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   295: getfield 226	com/tencent/token/ad:b	I
    //   298: lload_2
    //   299: aload 4
    //   301: iload 5
    //   303: i2l
    //   304: invokevirtual 292	com/tencent/token/z:a	(IJ[BJ)V
    //   307: aload_1
    //   308: getfield 100	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   311: astore_1
    //   312: aload_1
    //   313: aload_1
    //   314: getfield 293	com/tencent/token/ad:f	J
    //   317: iload 5
    //   319: i2l
    //   320: ladd
    //   321: putfield 293	com/tencent/token/ad:f	J
    //   324: aload_0
    //   325: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   328: invokestatic 36	com/tencent/halley/downloader/c/h:b	(Lcom/tencent/halley/downloader/c/h;)Lcom/tencent/halley/downloader/c/g;
    //   331: astore_1
    //   332: aload_1
    //   333: invokevirtual 296	com/tencent/halley/downloader/c/g:f	()J
    //   336: lstore_2
    //   337: iload 8
    //   339: istore 5
    //   341: lload_2
    //   342: lconst_0
    //   343: lcmp
    //   344: ifle +19 -> 363
    //   347: iload 8
    //   349: istore 5
    //   351: lload_2
    //   352: aload_1
    //   353: getfield 219	com/tencent/halley/downloader/c/g:a	J
    //   356: lcmp
    //   357: ifne +6 -> 363
    //   360: iconst_1
    //   361: istore 5
    //   363: iload 5
    //   365: ifeq +19 -> 384
    //   368: aload_0
    //   369: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   372: invokestatic 299	com/tencent/halley/downloader/c/h:f	(Lcom/tencent/halley/downloader/c/h;)Lcom/tencent/halley/downloader/c/a;
    //   375: invokevirtual 303	com/tencent/halley/downloader/c/a:b	()V
    //   378: invokestatic 308	com/tencent/token/y:a	()Lcom/tencent/token/y;
    //   381: invokevirtual 309	com/tencent/token/y:b	()V
    //   384: invokestatic 308	com/tencent/token/y:a	()Lcom/tencent/token/y;
    //   387: invokevirtual 311	com/tencent/token/y:g	()Z
    //   390: ifeq +86 -> 476
    //   393: aload_0
    //   394: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   397: iconst_1
    //   398: invokestatic 314	com/tencent/halley/downloader/c/h:a	(Lcom/tencent/halley/downloader/c/h;Z)Z
    //   401: pop
    //   402: invokestatic 308	com/tencent/token/y:a	()Lcom/tencent/token/y;
    //   405: invokevirtual 309	com/tencent/token/y:b	()V
    //   408: ldc 116
    //   410: new 57	java/lang/StringBuilder
    //   413: dup
    //   414: ldc_w 316
    //   417: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   420: aload_0
    //   421: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   424: getfield 319	com/tencent/halley/downloader/c/h:n	Ljava/lang/String;
    //   427: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 321
    //   433: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 126	com/tencent/halley/common/c:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload_0
    //   443: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   446: iconst_1
    //   447: invokestatic 323	com/tencent/halley/downloader/c/h:b	(Lcom/tencent/halley/downloader/c/h;Z)Z
    //   450: pop
    //   451: aload_0
    //   452: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   455: invokestatic 326	com/tencent/halley/downloader/c/h:g	(Lcom/tencent/halley/downloader/c/h;)Ljava/lang/Object;
    //   458: astore_1
    //   459: aload_1
    //   460: monitorenter
    //   461: aload_0
    //   462: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   465: invokestatic 326	com/tencent/halley/downloader/c/h:g	(Lcom/tencent/halley/downloader/c/h;)Ljava/lang/Object;
    //   468: ldc2_w 327
    //   471: invokevirtual 332	java/lang/Object:wait	(J)V
    //   474: aload_1
    //   475: monitorexit
    //   476: iconst_1
    //   477: ireturn
    //   478: astore_1
    //   479: aload_1
    //   480: invokevirtual 335	java/lang/OutOfMemoryError:printStackTrace	()V
    //   483: aload_0
    //   484: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   487: iconst_0
    //   488: bipush 237
    //   490: new 57	java/lang/StringBuilder
    //   493: dup
    //   494: ldc_w 337
    //   497: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   500: iload 5
    //   502: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: ldc_w 342
    //   508: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokestatic 308	com/tencent/token/y:a	()Lcom/tencent/token/y;
    //   514: invokevirtual 343	com/tencent/token/y:f	()J
    //   517: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   520: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: getstatic 160	com/tencent/halley/downloader/DownloaderTaskStatus:FAILED	Lcom/tencent/halley/downloader/DownloaderTaskStatus;
    //   526: invokevirtual 163	com/tencent/halley/downloader/c/h:a	(ZILjava/lang/String;Lcom/tencent/halley/downloader/DownloaderTaskStatus;)V
    //   529: iconst_0
    //   530: ireturn
    //   531: astore 4
    //   533: aload_1
    //   534: monitorexit
    //   535: aload 4
    //   537: athrow
    //   538: astore_1
    //   539: goto -63 -> 476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	542	0	this	j
    //   0	542	2	paramLong	long
    //   0	542	4	paramArrayOfByte	byte[]
    //   0	542	5	paramInt	int
    //   0	542	6	paramBoolean	boolean
    //   24	91	7	i	int
    //   1	347	8	j	int
    //   89	10	9	localg	g
    // Exception table:
    //   from	to	target	type
    //   284	307	478	java/lang/OutOfMemoryError
    //   461	476	531	finally
    //   442	461	538	java/lang/Exception
    //   533	538	538	java/lang/Exception
  }
  
  /* Error */
  public final com.tencent.halley.common.g b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 92	com/tencent/halley/common/g
    //   5: dup
    //   6: iconst_0
    //   7: ldc 94
    //   9: invokespecial 97	com/tencent/halley/common/g:<init>	(ILjava/lang/String;)V
    //   12: astore_1
    //   13: aload_0
    //   14: new 89	com/tencent/token/af
    //   17: dup
    //   18: aload_0
    //   19: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   22: invokestatic 28	com/tencent/halley/downloader/c/h:a	(Lcom/tencent/halley/downloader/c/h;)Lcom/tencent/halley/downloader/c/d/b;
    //   25: iconst_1
    //   26: aload_0
    //   27: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   30: getfield 135	com/tencent/halley/downloader/c/h:f	J
    //   33: aload_0
    //   34: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   42: getfield 347	com/tencent/halley/downloader/c/h:e	Ljava/util/Map;
    //   45: aload_0
    //   46: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   49: getfield 350	com/tencent/halley/downloader/c/h:C	Z
    //   52: invokespecial 353	com/tencent/token/af:<init>	(Lcom/tencent/halley/downloader/c/d/b;ZJLcom/tencent/token/u;Lcom/tencent/token/ae;Ljava/util/Map;Z)V
    //   55: putfield 85	com/tencent/halley/downloader/c/j:a	Lcom/tencent/token/af;
    //   58: invokestatic 358	com/tencent/token/ao:a	()Lcom/tencent/token/an;
    //   61: aload_0
    //   62: getfield 85	com/tencent/halley/downloader/c/j:a	Lcom/tencent/token/af;
    //   65: invokeinterface 363 2 0
    //   70: pop
    //   71: aload_1
    //   72: getfield 109	com/tencent/halley/common/g:a	I
    //   75: ifne +71 -> 146
    //   78: aload_0
    //   79: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   82: invokevirtual 366	com/tencent/halley/downloader/c/h:z	()Z
    //   85: ifne +61 -> 146
    //   88: aload_0
    //   89: new 89	com/tencent/token/af
    //   92: dup
    //   93: aload_0
    //   94: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   97: invokestatic 28	com/tencent/halley/downloader/c/h:a	(Lcom/tencent/halley/downloader/c/h;)Lcom/tencent/halley/downloader/c/d/b;
    //   100: iconst_0
    //   101: aload_0
    //   102: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   105: getfield 135	com/tencent/halley/downloader/c/h:f	J
    //   108: aload_0
    //   109: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   117: getfield 347	com/tencent/halley/downloader/c/h:e	Ljava/util/Map;
    //   120: aload_0
    //   121: getfield 15	com/tencent/halley/downloader/c/j:c	Lcom/tencent/halley/downloader/c/h;
    //   124: getfield 350	com/tencent/halley/downloader/c/h:C	Z
    //   127: invokespecial 353	com/tencent/token/af:<init>	(Lcom/tencent/halley/downloader/c/d/b;ZJLcom/tencent/token/u;Lcom/tencent/token/ae;Ljava/util/Map;Z)V
    //   130: putfield 87	com/tencent/halley/downloader/c/j:b	Lcom/tencent/token/af;
    //   133: invokestatic 358	com/tencent/token/ao:a	()Lcom/tencent/token/an;
    //   136: aload_0
    //   137: getfield 87	com/tencent/halley/downloader/c/j:b	Lcom/tencent/token/af;
    //   140: invokeinterface 368 2 0
    //   145: pop
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: areturn
    //   150: astore_2
    //   151: aload_0
    //   152: aconst_null
    //   153: putfield 85	com/tencent/halley/downloader/c/j:a	Lcom/tencent/token/af;
    //   156: aload_1
    //   157: bipush 189
    //   159: putfield 109	com/tencent/halley/common/g:a	I
    //   162: aload_2
    //   163: invokevirtual 369	java/lang/Exception:printStackTrace	()V
    //   166: goto -95 -> 71
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    //   174: astore_2
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 87	com/tencent/halley/downloader/c/j:b	Lcom/tencent/token/af;
    //   180: goto -34 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	j
    //   12	145	1	localg	com.tencent.halley.common.g
    //   169	4	1	localObject	Object
    //   150	13	2	localException1	java.lang.Exception
    //   174	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   58	71	150	java/lang/Exception
    //   2	58	169	finally
    //   58	71	169	finally
    //   71	133	169	finally
    //   133	146	169	finally
    //   151	166	169	finally
    //   175	180	169	finally
    //   133	146	174	java/lang/Exception
  }
  
  public final void b(af paramaf)
  {
    int i;
    if ((paramaf != null) && ((paramaf == this.a) || (paramaf == this.b)))
    {
      i = 1;
      if (i != 0) {
        break label32;
      }
    }
    label32:
    while (paramaf.a == null)
    {
      return;
      i = 0;
      break;
    }
    h.b(this.c);
    paramaf.a.h = false;
  }
  
  public final void c(af paramaf)
  {
    int j = 1;
    if ((paramaf != null) && ((paramaf == this.a) || (paramaf == this.b))) {}
    for (int i = 1; i == 0; i = 0) {
      return;
    }
    for (;;)
    {
      synchronized (h.h(this.c))
      {
        if ((this.a != null) && (!this.a.f()))
        {
          i = 0;
          if (i == 0) {
            break;
          }
          c.c("TaskImpl", "All Transports Finished, task:" + this.c.b());
          if (h.i(this.c)) {
            break;
          }
          ??? = h.b(this.c);
          long l = ((g)???).f();
          if ((l <= 0L) || (l != ((g)???).a)) {
            break label280;
          }
          i = j;
          if (i != 0) {
            break;
          }
          this.c.r = paramaf.c();
          this.c.s = paramaf.d();
          if (this.c.r == 0)
          {
            this.c.r = -69;
            this.c.s = ("readLen:" + h.b(this.c).f());
          }
          h.d(this.c).a(DownloaderTaskStatus.FAILED);
          return;
        }
        if ((!this.c.C) || (this.b == null)) {
          break label285;
        }
        boolean bool = this.b.f();
        if (bool) {
          break label285;
        }
        i = 0;
      }
      label280:
      i = 0;
      continue;
      label285:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.j
 * JD-Core Version:    0.7.0.1
 */