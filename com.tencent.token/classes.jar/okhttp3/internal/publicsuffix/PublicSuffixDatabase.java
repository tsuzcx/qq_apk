package okhttp3.internal.publicsuffix;

import com.tencent.token.alr;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase
{
  private static final byte[] a = { 42 };
  private static final String[] b = new String[0];
  private static final String[] c = { "*" };
  private static final PublicSuffixDatabase d = new PublicSuffixDatabase();
  private final AtomicBoolean e = new AtomicBoolean(false);
  private final CountDownLatch f = new CountDownLatch(1);
  private byte[] g;
  private byte[] h;
  
  private static String a(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, int paramInt)
  {
    int j = paramArrayOfByte.length;
    int k = 0;
    while (k < j)
    {
      int i = (k + j) / 2;
      while ((i >= 0) && (paramArrayOfByte[i] != 10)) {
        i -= 1;
      }
      int i6 = i + 1;
      i = 1;
      int i7;
      for (;;)
      {
        i7 = i6 + i;
        if (paramArrayOfByte[i7] == 10) {
          break;
        }
        i += 1;
      }
      int i8 = i7 - i6;
      int m = paramInt;
      int i1 = 0;
      i = 0;
      int n = 0;
      int i9;
      int i4;
      int i5;
      for (;;)
      {
        if (i1 != 0)
        {
          i1 = 0;
          i2 = 46;
        }
        else
        {
          i2 = paramArrayOfByte1[m][i] & 0xFF;
        }
        i9 = i2 - (paramArrayOfByte[(i6 + n)] & 0xFF);
        i4 = i;
        i5 = n;
        if (i9 != 0) {
          break;
        }
        int i2 = n + 1;
        int i3 = i + 1;
        i4 = i3;
        i5 = i2;
        if (i2 == i8) {
          break;
        }
        i = i3;
        n = i2;
        if (paramArrayOfByte1[m].length == i3)
        {
          i4 = i3;
          i5 = i2;
          if (m == paramArrayOfByte1.length - 1) {
            break;
          }
          m += 1;
          i1 = 1;
          i = -1;
          n = i2;
        }
      }
      if (i9 < 0)
      {
        j = i6 - 1;
      }
      else if (i9 > 0)
      {
        k = i7 + 1;
      }
      else
      {
        n = i8 - i5;
        i = paramArrayOfByte1[m].length - i4;
        for (;;)
        {
          m += 1;
          if (m >= paramArrayOfByte1.length) {
            break;
          }
          i += paramArrayOfByte1[m].length;
        }
        if (i < n) {
          j = i6 - 1;
        } else if (i > n) {
          k = i7 + 1;
        } else {
          return new String(paramArrayOfByte, i6, i8, alr.e);
        }
      }
    }
    return null;
  }
  
  public static PublicSuffixDatabase a()
  {
    return d;
  }
  
  /* Error */
  private String[] a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	okhttp3/internal/publicsuffix/PublicSuffixDatabase:e	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 71	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: istore 4
    //   9: iconst_0
    //   10: istore_3
    //   11: iload 4
    //   13: ifne +190 -> 203
    //   16: aload_0
    //   17: getfield 43	okhttp3/internal/publicsuffix/PublicSuffixDatabase:e	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   20: iconst_0
    //   21: iconst_1
    //   22: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   25: ifeq +178 -> 203
    //   28: iconst_0
    //   29: istore_2
    //   30: ldc 2
    //   32: ldc 77
    //   34: invokevirtual 83	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore 5
    //   39: aload 5
    //   41: ifnull +108 -> 149
    //   44: new 85	com/tencent/token/aoa
    //   47: dup
    //   48: aload 5
    //   50: invokestatic 90	com/tencent/token/aoc:a	(Ljava/io/InputStream;)Lcom/tencent/token/aoj;
    //   53: invokespecial 93	com/tencent/token/aoa:<init>	(Lcom/tencent/token/aoj;)V
    //   56: invokestatic 96	com/tencent/token/aoc:a	(Lcom/tencent/token/aoj;)Lcom/tencent/token/anv;
    //   59: astore 5
    //   61: aload 5
    //   63: invokeinterface 101 1 0
    //   68: newarray byte
    //   70: astore 6
    //   72: aload 5
    //   74: aload 6
    //   76: invokeinterface 104 2 0
    //   81: aload 5
    //   83: invokeinterface 101 1 0
    //   88: newarray byte
    //   90: astore 7
    //   92: aload 5
    //   94: aload 7
    //   96: invokeinterface 104 2 0
    //   101: aload 5
    //   103: invokestatic 107	com/tencent/token/alr:a	(Ljava/io/Closeable;)V
    //   106: aload_0
    //   107: monitorenter
    //   108: aload_0
    //   109: aload 6
    //   111: putfield 109	okhttp3/internal/publicsuffix/PublicSuffixDatabase:g	[B
    //   114: aload_0
    //   115: aload 7
    //   117: putfield 111	okhttp3/internal/publicsuffix/PublicSuffixDatabase:h	[B
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_0
    //   123: getfield 50	okhttp3/internal/publicsuffix/PublicSuffixDatabase:f	Ljava/util/concurrent/CountDownLatch;
    //   126: invokevirtual 114	java/util/concurrent/CountDownLatch:countDown	()V
    //   129: goto +20 -> 149
    //   132: astore 5
    //   134: aload_0
    //   135: monitorexit
    //   136: aload 5
    //   138: athrow
    //   139: astore 6
    //   141: aload 5
    //   143: invokestatic 107	com/tencent/token/alr:a	(Ljava/io/Closeable;)V
    //   146: aload 6
    //   148: athrow
    //   149: iload_2
    //   150: ifeq +69 -> 219
    //   153: invokestatic 120	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   156: invokevirtual 123	java/lang/Thread:interrupt	()V
    //   159: goto +60 -> 219
    //   162: astore_1
    //   163: goto +23 -> 186
    //   166: astore 5
    //   168: invokestatic 128	com/tencent/token/anl:c	()Lcom/tencent/token/anl;
    //   171: iconst_5
    //   172: ldc 130
    //   174: aload 5
    //   176: invokevirtual 133	com/tencent/token/anl:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: iload_2
    //   180: ifeq +39 -> 219
    //   183: goto -30 -> 153
    //   186: iload_2
    //   187: ifeq +9 -> 196
    //   190: invokestatic 120	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   193: invokevirtual 123	java/lang/Thread:interrupt	()V
    //   196: aload_1
    //   197: athrow
    //   198: iconst_1
    //   199: istore_2
    //   200: goto -170 -> 30
    //   203: aload_0
    //   204: getfield 50	okhttp3/internal/publicsuffix/PublicSuffixDatabase:f	Ljava/util/concurrent/CountDownLatch;
    //   207: invokevirtual 136	java/util/concurrent/CountDownLatch:await	()V
    //   210: goto +9 -> 219
    //   213: invokestatic 120	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   216: invokevirtual 123	java/lang/Thread:interrupt	()V
    //   219: aload_0
    //   220: monitorenter
    //   221: aload_0
    //   222: getfield 109	okhttp3/internal/publicsuffix/PublicSuffixDatabase:g	[B
    //   225: ifnull +274 -> 499
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: arraylength
    //   232: anewarray 137	[B
    //   235: astore 7
    //   237: iconst_0
    //   238: istore_2
    //   239: iload_2
    //   240: aload_1
    //   241: arraylength
    //   242: if_icmpge +23 -> 265
    //   245: aload 7
    //   247: iload_2
    //   248: aload_1
    //   249: iload_2
    //   250: aaload
    //   251: getstatic 56	com/tencent/token/alr:e	Ljava/nio/charset/Charset;
    //   254: invokevirtual 141	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   257: aastore
    //   258: iload_2
    //   259: iconst_1
    //   260: iadd
    //   261: istore_2
    //   262: goto -23 -> 239
    //   265: iconst_0
    //   266: istore_2
    //   267: iload_2
    //   268: aload 7
    //   270: arraylength
    //   271: if_icmpge +28 -> 299
    //   274: aload_0
    //   275: getfield 109	okhttp3/internal/publicsuffix/PublicSuffixDatabase:g	[B
    //   278: aload 7
    //   280: iload_2
    //   281: invokestatic 143	okhttp3/internal/publicsuffix/PublicSuffixDatabase:a	([B[[BI)Ljava/lang/String;
    //   284: astore_1
    //   285: aload_1
    //   286: ifnull +6 -> 292
    //   289: goto +12 -> 301
    //   292: iload_2
    //   293: iconst_1
    //   294: iadd
    //   295: istore_2
    //   296: goto -29 -> 267
    //   299: aconst_null
    //   300: astore_1
    //   301: aload 7
    //   303: arraylength
    //   304: iconst_1
    //   305: if_icmple +58 -> 363
    //   308: aload 7
    //   310: invokevirtual 149	[[B:clone	()Ljava/lang/Object;
    //   313: checkcast 145	[[B
    //   316: astore 6
    //   318: iconst_0
    //   319: istore_2
    //   320: iload_2
    //   321: aload 6
    //   323: arraylength
    //   324: iconst_1
    //   325: isub
    //   326: if_icmpge +37 -> 363
    //   329: aload 6
    //   331: iload_2
    //   332: getstatic 21	okhttp3/internal/publicsuffix/PublicSuffixDatabase:a	[B
    //   335: aastore
    //   336: aload_0
    //   337: getfield 109	okhttp3/internal/publicsuffix/PublicSuffixDatabase:g	[B
    //   340: aload 6
    //   342: iload_2
    //   343: invokestatic 143	okhttp3/internal/publicsuffix/PublicSuffixDatabase:a	([B[[BI)Ljava/lang/String;
    //   346: astore 5
    //   348: aload 5
    //   350: ifnull +6 -> 356
    //   353: goto +13 -> 366
    //   356: iload_2
    //   357: iconst_1
    //   358: iadd
    //   359: istore_2
    //   360: goto -40 -> 320
    //   363: aconst_null
    //   364: astore 5
    //   366: aload 5
    //   368: ifnull +41 -> 409
    //   371: iload_3
    //   372: istore_2
    //   373: iload_2
    //   374: aload 7
    //   376: arraylength
    //   377: iconst_1
    //   378: isub
    //   379: if_icmpge +30 -> 409
    //   382: aload_0
    //   383: getfield 111	okhttp3/internal/publicsuffix/PublicSuffixDatabase:h	[B
    //   386: aload 7
    //   388: iload_2
    //   389: invokestatic 143	okhttp3/internal/publicsuffix/PublicSuffixDatabase:a	([B[[BI)Ljava/lang/String;
    //   392: astore 6
    //   394: aload 6
    //   396: ifnull +6 -> 402
    //   399: goto +13 -> 412
    //   402: iload_2
    //   403: iconst_1
    //   404: iadd
    //   405: istore_2
    //   406: goto -33 -> 373
    //   409: aconst_null
    //   410: astore 6
    //   412: aload 6
    //   414: ifnull +19 -> 433
    //   417: ldc 151
    //   419: aload 6
    //   421: invokestatic 155	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   424: invokevirtual 159	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   427: ldc 161
    //   429: invokevirtual 165	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   432: areturn
    //   433: aload_1
    //   434: ifnonnull +12 -> 446
    //   437: aload 5
    //   439: ifnonnull +7 -> 446
    //   442: getstatic 29	okhttp3/internal/publicsuffix/PublicSuffixDatabase:c	[Ljava/lang/String;
    //   445: areturn
    //   446: aload_1
    //   447: ifnull +13 -> 460
    //   450: aload_1
    //   451: ldc 161
    //   453: invokevirtual 165	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   456: astore_1
    //   457: goto +7 -> 464
    //   460: getstatic 25	okhttp3/internal/publicsuffix/PublicSuffixDatabase:b	[Ljava/lang/String;
    //   463: astore_1
    //   464: aload 5
    //   466: ifnull +15 -> 481
    //   469: aload 5
    //   471: ldc 161
    //   473: invokevirtual 165	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   476: astore 5
    //   478: goto +8 -> 486
    //   481: getstatic 25	okhttp3/internal/publicsuffix/PublicSuffixDatabase:b	[Ljava/lang/String;
    //   484: astore 5
    //   486: aload_1
    //   487: arraylength
    //   488: aload 5
    //   490: arraylength
    //   491: if_icmple +5 -> 496
    //   494: aload_1
    //   495: areturn
    //   496: aload 5
    //   498: areturn
    //   499: new 167	java/lang/IllegalStateException
    //   502: dup
    //   503: ldc 169
    //   505: invokespecial 172	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   508: athrow
    //   509: astore_1
    //   510: aload_0
    //   511: monitorexit
    //   512: aload_1
    //   513: athrow
    //   514: astore 5
    //   516: goto -318 -> 198
    //   519: astore 5
    //   521: goto -308 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	PublicSuffixDatabase
    //   0	524	1	paramArrayOfString	String[]
    //   29	377	2	i	int
    //   10	362	3	j	int
    //   7	5	4	bool	boolean
    //   37	65	5	localObject1	Object
    //   132	10	5	localCloseable	java.io.Closeable
    //   166	9	5	localIOException	java.io.IOException
    //   346	151	5	localObject2	Object
    //   514	1	5	localInterruptedIOException	java.io.InterruptedIOException
    //   519	1	5	localInterruptedException	java.lang.InterruptedException
    //   70	40	6	arrayOfByte	byte[]
    //   139	8	6	localObject3	Object
    //   316	104	6	localObject4	Object
    //   90	297	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   108	122	132	finally
    //   134	136	132	finally
    //   61	101	139	finally
    //   30	39	162	finally
    //   44	61	162	finally
    //   101	108	162	finally
    //   122	129	162	finally
    //   136	139	162	finally
    //   141	149	162	finally
    //   168	179	162	finally
    //   30	39	166	java/io/IOException
    //   44	61	166	java/io/IOException
    //   101	108	166	java/io/IOException
    //   122	129	166	java/io/IOException
    //   136	139	166	java/io/IOException
    //   141	149	166	java/io/IOException
    //   221	230	509	finally
    //   499	509	509	finally
    //   510	512	509	finally
    //   30	39	514	java/io/InterruptedIOException
    //   44	61	514	java/io/InterruptedIOException
    //   101	108	514	java/io/InterruptedIOException
    //   122	129	514	java/io/InterruptedIOException
    //   136	139	514	java/io/InterruptedIOException
    //   141	149	514	java/io/InterruptedIOException
    //   203	210	519	java/lang/InterruptedException
  }
  
  public final String a(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = IDN.toUnicode(paramString).split("\\.");
      String[] arrayOfString = a((String[])localObject);
      if ((localObject.length == arrayOfString.length) && (arrayOfString[0].charAt(0) != '!')) {
        return null;
      }
      int i;
      if (arrayOfString[0].charAt(0) == '!') {
        i = localObject.length - arrayOfString.length;
      } else {
        i = localObject.length - (arrayOfString.length + 1);
      }
      localObject = new StringBuilder();
      paramString = paramString.split("\\.");
      while (i < paramString.length)
      {
        ((StringBuilder)localObject).append(paramString[i]);
        ((StringBuilder)localObject).append('.');
        i += 1;
      }
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
      return ((StringBuilder)localObject).toString();
    }
    throw new NullPointerException("domain == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.publicsuffix.PublicSuffixDatabase
 * JD-Core Version:    0.7.0.1
 */