package com.tencent.map.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public final class om
{
  public static File a;
  private static final oy b = new oy();
  
  public static File a(File paramFile, String paramString)
  {
    if ((paramFile == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramFile = new File(paramFile, paramString);
    paramFile.mkdirs();
    return paramFile;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        String str = paramContext.getPackageName();
        if ((str != null) && (str.length() != 0))
        {
          paramContext = str;
          if (str.length() <= 255) {
            continue;
          }
          paramContext = str.substring(0, 254);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
    }
    return "";
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: invokevirtual 66	java/io/File:exists	()Z
    //   11: ifeq +8 -> 19
    //   14: iload_1
    //   15: iconst_m1
    //   16: if_icmpne +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 68	java/io/BufferedReader
    //   24: dup
    //   25: new 70	java/io/FileReader
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 73	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   33: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: iconst_0
    //   38: istore_2
    //   39: aload_3
    //   40: astore_0
    //   41: aload_3
    //   42: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore 4
    //   47: aload 4
    //   49: ifnull +22 -> 71
    //   52: iload_2
    //   53: iload_1
    //   54: if_icmpne +10 -> 64
    //   57: aload_3
    //   58: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   61: aload 4
    //   63: areturn
    //   64: iload_2
    //   65: iconst_1
    //   66: iadd
    //   67: istore_2
    //   68: goto -29 -> 39
    //   71: aload_3
    //   72: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   75: aconst_null
    //   76: areturn
    //   77: astore 4
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_3
    //   82: astore_0
    //   83: aload 4
    //   85: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   88: aload_3
    //   89: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   92: goto -17 -> 75
    //   95: astore 4
    //   97: aconst_null
    //   98: astore_3
    //   99: aload_3
    //   100: astore_0
    //   101: aload 4
    //   103: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   106: aload_3
    //   107: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   110: goto -35 -> 75
    //   113: astore_0
    //   114: aload 4
    //   116: astore_3
    //   117: aload_3
    //   118: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   121: aload_0
    //   122: athrow
    //   123: astore 4
    //   125: aload_0
    //   126: astore_3
    //   127: aload 4
    //   129: astore_0
    //   130: goto -13 -> 117
    //   133: astore 4
    //   135: goto -36 -> 99
    //   138: astore 4
    //   140: goto -59 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramFile	File
    //   0	143	1	paramInt	int
    //   38	30	2	i	int
    //   36	91	3	localObject1	Object
    //   1	61	4	str	String
    //   77	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   95	20	4	localIOException1	IOException
    //   123	5	4	localObject2	Object
    //   133	1	4	localIOException2	IOException
    //   138	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   21	37	77	java/io/FileNotFoundException
    //   21	37	95	java/io/IOException
    //   21	37	113	finally
    //   41	47	123	finally
    //   83	88	123	finally
    //   101	106	123	finally
    //   41	47	133	java/io/IOException
    //   41	47	138	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void a(File paramFile, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: invokevirtual 66	java/io/File:exists	()Z
    //   11: ifeq +8 -> 19
    //   14: iload_1
    //   15: iconst_m1
    //   16: if_icmpne +4 -> 20
    //   19: return
    //   20: new 89	java/io/RandomAccessFile
    //   23: dup
    //   24: aload_0
    //   25: ldc 91
    //   27: invokespecial 92	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore 8
    //   32: aload_0
    //   33: ifnull +538 -> 571
    //   36: aload_0
    //   37: invokevirtual 96	java/io/File:getParentFile	()Ljava/io/File;
    //   40: new 98	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   47: getstatic 17	com/tencent/map/sdk/a/om:b	Lcom/tencent/map/sdk/a/oy;
    //   50: new 98	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   57: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   60: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 115	com/tencent/map/sdk/a/oy:a	(Ljava/lang/String;)Ljava/lang/String;
    //   69: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 120
    //   74: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 122	com/tencent/map/sdk/a/om:b	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   83: astore_0
    //   84: new 89	java/io/RandomAccessFile
    //   87: dup
    //   88: aload_0
    //   89: ldc 91
    //   91: invokespecial 92	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: astore 9
    //   96: iconst_0
    //   97: istore_3
    //   98: lconst_0
    //   99: lstore 4
    //   101: aload_0
    //   102: astore 12
    //   104: aload 9
    //   106: astore 11
    //   108: aload 8
    //   110: astore 10
    //   112: aload 8
    //   114: invokevirtual 123	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   117: astore 13
    //   119: aload 13
    //   121: ifnull +115 -> 236
    //   124: iload_3
    //   125: iload_1
    //   126: if_icmpne +32 -> 158
    //   129: aload_0
    //   130: astore 12
    //   132: aload 9
    //   134: astore 11
    //   136: aload 8
    //   138: astore 10
    //   140: aload 8
    //   142: invokevirtual 126	java/io/RandomAccessFile:getFilePointer	()J
    //   145: ldc 128
    //   147: invokevirtual 132	java/lang/String:getBytes	()[B
    //   150: arraylength
    //   151: i2l
    //   152: lsub
    //   153: lstore 6
    //   155: goto +405 -> 560
    //   158: lload 4
    //   160: lstore 6
    //   162: iload_3
    //   163: iload_1
    //   164: if_icmple +396 -> 560
    //   167: aload_0
    //   168: astore 12
    //   170: aload 9
    //   172: astore 11
    //   174: aload 8
    //   176: astore 10
    //   178: aload 9
    //   180: aload 13
    //   182: ldc 134
    //   184: invokevirtual 137	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   187: invokevirtual 141	java/io/RandomAccessFile:write	([B)V
    //   190: lload 4
    //   192: lstore 6
    //   194: goto +366 -> 560
    //   197: astore 11
    //   199: aload_0
    //   200: astore 10
    //   202: aload 9
    //   204: astore_0
    //   205: aload 8
    //   207: astore_2
    //   208: aload 10
    //   210: astore 8
    //   212: aload 11
    //   214: astore 9
    //   216: aload 9
    //   218: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   221: aload_2
    //   222: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   225: aload_0
    //   226: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   229: aload 8
    //   231: invokestatic 144	com/tencent/map/sdk/a/om:b	(Ljava/io/File;)Z
    //   234: pop
    //   235: return
    //   236: aload_0
    //   237: astore 12
    //   239: aload 9
    //   241: astore 11
    //   243: aload 8
    //   245: astore 10
    //   247: aload 8
    //   249: lload 4
    //   251: invokevirtual 148	java/io/RandomAccessFile:seek	(J)V
    //   254: aload_0
    //   255: astore 12
    //   257: aload 9
    //   259: astore 11
    //   261: aload 8
    //   263: astore 10
    //   265: aload 8
    //   267: new 98	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   274: aload_2
    //   275: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 128
    //   280: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokevirtual 132	java/lang/String:getBytes	()[B
    //   289: invokevirtual 141	java/io/RandomAccessFile:write	([B)V
    //   292: aload_0
    //   293: astore 12
    //   295: aload 9
    //   297: astore 11
    //   299: aload 8
    //   301: astore 10
    //   303: aload 9
    //   305: lconst_0
    //   306: invokevirtual 148	java/io/RandomAccessFile:seek	(J)V
    //   309: aload_0
    //   310: astore 12
    //   312: aload 9
    //   314: astore 11
    //   316: aload 8
    //   318: astore 10
    //   320: aload 9
    //   322: invokevirtual 123	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   325: astore_2
    //   326: aload_2
    //   327: ifnull +67 -> 394
    //   330: aload_0
    //   331: astore 12
    //   333: aload 9
    //   335: astore 11
    //   337: aload 8
    //   339: astore 10
    //   341: aload 8
    //   343: aload_2
    //   344: ldc 134
    //   346: invokevirtual 137	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   349: invokevirtual 141	java/io/RandomAccessFile:write	([B)V
    //   352: goto -43 -> 309
    //   355: astore 10
    //   357: aload 9
    //   359: astore_2
    //   360: aload 10
    //   362: astore 9
    //   364: aload_0
    //   365: astore 12
    //   367: aload_2
    //   368: astore 11
    //   370: aload 8
    //   372: astore 10
    //   374: aload 9
    //   376: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   379: aload 8
    //   381: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   384: aload_2
    //   385: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   388: aload_0
    //   389: invokestatic 144	com/tencent/map/sdk/a/om:b	(Ljava/io/File;)Z
    //   392: pop
    //   393: return
    //   394: aload 8
    //   396: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   399: aload 9
    //   401: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   404: aload_0
    //   405: invokestatic 144	com/tencent/map/sdk/a/om:b	(Ljava/io/File;)Z
    //   408: pop
    //   409: return
    //   410: astore_2
    //   411: aconst_null
    //   412: astore_0
    //   413: aconst_null
    //   414: astore 9
    //   416: aconst_null
    //   417: astore 8
    //   419: aload 8
    //   421: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   424: aload 9
    //   426: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   429: aload_0
    //   430: invokestatic 144	com/tencent/map/sdk/a/om:b	(Ljava/io/File;)Z
    //   433: pop
    //   434: aload_2
    //   435: athrow
    //   436: astore_2
    //   437: aconst_null
    //   438: astore_0
    //   439: aconst_null
    //   440: astore 9
    //   442: goto -23 -> 419
    //   445: astore_2
    //   446: aconst_null
    //   447: astore 9
    //   449: goto -30 -> 419
    //   452: astore_2
    //   453: aload 12
    //   455: astore_0
    //   456: aload 11
    //   458: astore 9
    //   460: aload 10
    //   462: astore 8
    //   464: goto -45 -> 419
    //   467: astore 11
    //   469: aload_2
    //   470: astore 10
    //   472: aload_0
    //   473: astore 9
    //   475: aload 8
    //   477: astore_0
    //   478: aload 11
    //   480: astore_2
    //   481: aload 10
    //   483: astore 8
    //   485: goto -66 -> 419
    //   488: astore 9
    //   490: aconst_null
    //   491: astore_0
    //   492: aconst_null
    //   493: astore_2
    //   494: aconst_null
    //   495: astore 8
    //   497: goto -133 -> 364
    //   500: astore 9
    //   502: aconst_null
    //   503: astore_0
    //   504: aconst_null
    //   505: astore_2
    //   506: goto -142 -> 364
    //   509: astore 9
    //   511: aconst_null
    //   512: astore_2
    //   513: goto -149 -> 364
    //   516: astore 9
    //   518: aconst_null
    //   519: astore_0
    //   520: aconst_null
    //   521: astore_2
    //   522: aload 10
    //   524: astore 8
    //   526: goto -310 -> 216
    //   529: astore 9
    //   531: aconst_null
    //   532: astore_0
    //   533: aload 8
    //   535: astore_2
    //   536: aload 10
    //   538: astore 8
    //   540: goto -324 -> 216
    //   543: astore 9
    //   545: aload 8
    //   547: astore_2
    //   548: aconst_null
    //   549: astore 10
    //   551: aload_0
    //   552: astore 8
    //   554: aload 10
    //   556: astore_0
    //   557: goto -341 -> 216
    //   560: iload_3
    //   561: iconst_1
    //   562: iadd
    //   563: istore_3
    //   564: lload 6
    //   566: lstore 4
    //   568: goto -467 -> 101
    //   571: aconst_null
    //   572: astore_0
    //   573: goto -489 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	paramFile	File
    //   0	576	1	paramInt	int
    //   0	576	2	paramString	String
    //   97	467	3	i	int
    //   99	468	4	l1	long
    //   153	412	6	l2	long
    //   30	523	8	localObject1	Object
    //   94	380	9	localObject2	Object
    //   488	1	9	localIOException1	IOException
    //   500	1	9	localIOException2	IOException
    //   509	1	9	localIOException3	IOException
    //   516	1	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   529	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   543	1	9	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	339	10	localObject3	Object
    //   355	6	10	localIOException4	IOException
    //   372	183	10	localObject4	Object
    //   106	67	11	localObject5	Object
    //   197	16	11	localFileNotFoundException4	java.io.FileNotFoundException
    //   241	216	11	localObject6	Object
    //   467	12	11	localObject7	Object
    //   102	352	12	localFile	File
    //   117	64	13	str	String
    // Exception table:
    //   from	to	target	type
    //   112	119	197	java/io/FileNotFoundException
    //   140	155	197	java/io/FileNotFoundException
    //   178	190	197	java/io/FileNotFoundException
    //   247	254	197	java/io/FileNotFoundException
    //   265	292	197	java/io/FileNotFoundException
    //   303	309	197	java/io/FileNotFoundException
    //   320	326	197	java/io/FileNotFoundException
    //   341	352	197	java/io/FileNotFoundException
    //   112	119	355	java/io/IOException
    //   140	155	355	java/io/IOException
    //   178	190	355	java/io/IOException
    //   247	254	355	java/io/IOException
    //   265	292	355	java/io/IOException
    //   303	309	355	java/io/IOException
    //   320	326	355	java/io/IOException
    //   341	352	355	java/io/IOException
    //   20	32	410	finally
    //   36	84	436	finally
    //   84	96	445	finally
    //   112	119	452	finally
    //   140	155	452	finally
    //   178	190	452	finally
    //   247	254	452	finally
    //   265	292	452	finally
    //   303	309	452	finally
    //   320	326	452	finally
    //   341	352	452	finally
    //   374	379	452	finally
    //   216	221	467	finally
    //   20	32	488	java/io/IOException
    //   36	84	500	java/io/IOException
    //   84	96	509	java/io/IOException
    //   20	32	516	java/io/FileNotFoundException
    //   36	84	529	java/io/FileNotFoundException
    //   84	96	543	java/io/FileNotFoundException
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile == null) {}
    File localFile;
    do
    {
      return false;
      if (paramFile.exists()) {
        return true;
      }
      localFile = paramFile.getParentFile();
    } while ((localFile == null) || ((!localFile.exists()) && (!localFile.mkdirs())));
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static boolean a(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokestatic 154	com/tencent/map/sdk/a/om:a	(Ljava/io/File;)Z
    //   10: ifeq -6 -> 4
    //   13: aconst_null
    //   14: astore_2
    //   15: aconst_null
    //   16: astore_3
    //   17: new 156	java/io/FileOutputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: astore_0
    //   26: aload_0
    //   27: astore_2
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 158	java/io/FileOutputStream:write	([B)V
    //   33: aload_0
    //   34: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   37: iconst_1
    //   38: ireturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   44: iconst_1
    //   45: ireturn
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_0
    //   50: astore_2
    //   51: aload_1
    //   52: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   55: aload_0
    //   56: ifnull -52 -> 4
    //   59: aload_0
    //   60: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_1
    //   73: aload_3
    //   74: astore_0
    //   75: aload_0
    //   76: astore_2
    //   77: aload_1
    //   78: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   81: aload_0
    //   82: ifnull -78 -> 4
    //   85: aload_0
    //   86: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   96: iconst_0
    //   97: ireturn
    //   98: astore_0
    //   99: aload_2
    //   100: ifnull +7 -> 107
    //   103: aload_2
    //   104: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   107: aload_0
    //   108: athrow
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   114: goto -7 -> 107
    //   117: astore_0
    //   118: goto -19 -> 99
    //   121: astore_1
    //   122: goto -47 -> 75
    //   125: astore_1
    //   126: goto -77 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramFile	File
    //   0	129	1	paramArrayOfByte	byte[]
    //   14	90	2	localFile	File
    //   16	58	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	37	39	java/io/IOException
    //   17	26	46	java/io/FileNotFoundException
    //   59	63	65	java/io/IOException
    //   17	26	72	java/io/IOException
    //   85	89	91	java/io/IOException
    //   17	26	98	finally
    //   77	81	98	finally
    //   103	107	109	java/io/IOException
    //   28	33	117	finally
    //   51	55	117	finally
    //   28	33	121	java/io/IOException
    //   28	33	125	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString)
  {
    return a(new File(paramString));
  }
  
  public static File b(File paramFile, String paramString)
  {
    if ((paramFile == null) || (TextUtils.isEmpty(paramString))) {
      paramFile = null;
    }
    for (;;)
    {
      return paramFile;
      int i = paramString.lastIndexOf(File.separator);
      File localFile = paramFile;
      String str = paramString;
      if (i != -1)
      {
        str = paramString.substring(i + 1);
        localFile = new File(paramFile, paramString.substring(0, i));
      }
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        or.b("FileUtil create file failed with mkdirs failed:" + localFile.getAbsolutePath());
        return null;
      }
      paramString = new File(localFile, str);
      paramFile = paramString;
      try
      {
        if (!paramString.exists())
        {
          paramFile = paramString;
          if (!paramString.createNewFile())
          {
            or.b("FileUtil create file failed:" + paramString.getAbsolutePath());
            return paramString;
          }
        }
      }
      catch (IOException paramFile)
      {
        or.b("FileUtil create file failed.", paramFile);
      }
    }
    return paramString;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null)
    {
      paramString = "";
      return paramString;
    }
    String str = paramString.trim();
    paramString = str;
    if (str.contains("../")) {}
    for (paramString = str.replaceAll("\\.\\./", "");; paramString = paramString.substring(1))
    {
      str = paramString;
      if (!paramString.startsWith(File.separator)) {
        break;
      }
    }
    for (;;)
    {
      paramString = str;
      if (!str.endsWith(File.separator)) {
        break;
      }
      str = str.substring(0, str.length() - 1);
    }
  }
  
  public static boolean b(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.exists())
      {
        Stack localStack = new Stack();
        localStack.push(paramFile);
        bool1 = false;
        while (!localStack.isEmpty())
        {
          paramFile = (File)localStack.peek();
          if (paramFile.isFile())
          {
            bool1 = paramFile.delete();
            localStack.pop();
          }
          else if (paramFile.isDirectory())
          {
            File[] arrayOfFile = paramFile.listFiles();
            if (arrayOfFile.length == 0)
            {
              bool1 = paramFile.delete();
              localStack.pop();
            }
            else
            {
              int j = arrayOfFile.length;
              int i = 0;
              while (i < j)
              {
                localStack.push(arrayOfFile[i]);
                i += 1;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  /* Error */
  public static void c(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 66	java/io/File:exists	()Z
    //   8: ifne +4 -> 12
    //   11: return
    //   12: new 89	java/io/RandomAccessFile
    //   15: dup
    //   16: aload_0
    //   17: ldc 91
    //   19: invokespecial 92	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore_0
    //   25: aload_2
    //   26: aload_2
    //   27: invokevirtual 245	java/io/RandomAccessFile:length	()J
    //   30: invokevirtual 148	java/io/RandomAccessFile:seek	(J)V
    //   33: aload_2
    //   34: astore_0
    //   35: aload_2
    //   36: new 98	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   43: aload_1
    //   44: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 128
    //   49: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokevirtual 132	java/lang/String:getBytes	()[B
    //   58: invokevirtual 141	java/io/RandomAccessFile:write	([B)V
    //   61: aload_2
    //   62: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   65: return
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_2
    //   70: astore_0
    //   71: aload_1
    //   72: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   75: aload_2
    //   76: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   79: return
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_0
    //   85: aload_1
    //   86: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   89: aload_2
    //   90: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   93: return
    //   94: astore_1
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: goto -7 -> 97
    //   107: astore_1
    //   108: goto -25 -> 83
    //   111: astore_1
    //   112: goto -43 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramFile	File
    //   0	115	1	paramString	String
    //   22	68	2	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   12	23	66	java/io/FileNotFoundException
    //   12	23	80	java/io/IOException
    //   12	23	94	finally
    //   25	33	103	finally
    //   35	61	103	finally
    //   71	75	103	finally
    //   85	89	103	finally
    //   25	33	107	java/io/IOException
    //   35	61	107	java/io/IOException
    //   25	33	111	java/io/FileNotFoundException
    //   35	61	111	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] c(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 66	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 248	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 249	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_0
    //   22: new 251	java/io/ByteArrayOutputStream
    //   25: dup
    //   26: invokespecial 252	java/io/ByteArrayOutputStream:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: astore_3
    //   34: aload_0
    //   35: astore_2
    //   36: sipush 1024
    //   39: newarray byte
    //   41: astore 5
    //   43: aload 4
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: aload_0
    //   49: aload 5
    //   51: invokevirtual 256	java/io/FileInputStream:read	([B)I
    //   54: istore_1
    //   55: iload_1
    //   56: iconst_m1
    //   57: if_icmpeq +64 -> 121
    //   60: aload 4
    //   62: astore_3
    //   63: aload_0
    //   64: astore_2
    //   65: aload 4
    //   67: aload 5
    //   69: iconst_0
    //   70: iload_1
    //   71: invokevirtual 259	java/io/ByteArrayOutputStream:write	([BII)V
    //   74: goto -31 -> 43
    //   77: astore 5
    //   79: aload 4
    //   81: astore_3
    //   82: aload_0
    //   83: astore_2
    //   84: aload 5
    //   86: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   89: aload 4
    //   91: ifnull +13 -> 104
    //   94: aload 4
    //   96: invokevirtual 262	java/io/ByteArrayOutputStream:flush	()V
    //   99: aload 4
    //   101: invokevirtual 263	java/io/ByteArrayOutputStream:close	()V
    //   104: aload_0
    //   105: ifnull -94 -> 11
    //   108: aload_0
    //   109: invokevirtual 264	java/io/FileInputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   119: aconst_null
    //   120: areturn
    //   121: aload 4
    //   123: astore_3
    //   124: aload_0
    //   125: astore_2
    //   126: aload 4
    //   128: invokevirtual 267	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   131: astore 5
    //   133: aload 4
    //   135: invokevirtual 262	java/io/ByteArrayOutputStream:flush	()V
    //   138: aload 4
    //   140: invokevirtual 263	java/io/ByteArrayOutputStream:close	()V
    //   143: aload_0
    //   144: invokevirtual 264	java/io/FileInputStream:close	()V
    //   147: aload 5
    //   149: areturn
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   155: aload 5
    //   157: areturn
    //   158: astore_2
    //   159: aload_2
    //   160: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   163: goto -20 -> 143
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   171: goto -67 -> 104
    //   174: astore 5
    //   176: aconst_null
    //   177: astore 4
    //   179: aconst_null
    //   180: astore_0
    //   181: aload 4
    //   183: astore_3
    //   184: aload_0
    //   185: astore_2
    //   186: aload 5
    //   188: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   191: aload 4
    //   193: ifnull +13 -> 206
    //   196: aload 4
    //   198: invokevirtual 262	java/io/ByteArrayOutputStream:flush	()V
    //   201: aload 4
    //   203: invokevirtual 263	java/io/ByteArrayOutputStream:close	()V
    //   206: aload_0
    //   207: ifnull -196 -> 11
    //   210: aload_0
    //   211: invokevirtual 264	java/io/FileInputStream:close	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   221: aconst_null
    //   222: areturn
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   228: goto -22 -> 206
    //   231: astore 4
    //   233: aconst_null
    //   234: astore_3
    //   235: aconst_null
    //   236: astore_0
    //   237: aload_3
    //   238: ifnull +11 -> 249
    //   241: aload_3
    //   242: invokevirtual 262	java/io/ByteArrayOutputStream:flush	()V
    //   245: aload_3
    //   246: invokevirtual 263	java/io/ByteArrayOutputStream:close	()V
    //   249: aload_0
    //   250: ifnull +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 264	java/io/FileInputStream:close	()V
    //   257: aload 4
    //   259: athrow
    //   260: astore_2
    //   261: aload_2
    //   262: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   265: goto -16 -> 249
    //   268: astore_0
    //   269: aload_0
    //   270: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   273: goto -16 -> 257
    //   276: astore 4
    //   278: aconst_null
    //   279: astore_3
    //   280: goto -43 -> 237
    //   283: astore 4
    //   285: aload_2
    //   286: astore_0
    //   287: goto -50 -> 237
    //   290: astore 5
    //   292: aconst_null
    //   293: astore 4
    //   295: goto -114 -> 181
    //   298: astore 5
    //   300: goto -119 -> 181
    //   303: astore 5
    //   305: aconst_null
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_0
    //   310: goto -231 -> 79
    //   313: astore 5
    //   315: aconst_null
    //   316: astore 4
    //   318: goto -239 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramFile	File
    //   54	17	1	i	int
    //   35	91	2	localFile1	File
    //   158	2	2	localIOException1	IOException
    //   166	2	2	localIOException2	IOException
    //   185	1	2	localFile2	File
    //   223	2	2	localIOException3	IOException
    //   260	26	2	localIOException4	IOException
    //   33	247	3	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   29	173	4	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   231	27	4	localObject1	Object
    //   276	1	4	localObject2	Object
    //   283	1	4	localObject3	Object
    //   293	24	4	localObject4	Object
    //   41	27	5	arrayOfByte1	byte[]
    //   77	8	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   131	25	5	arrayOfByte2	byte[]
    //   174	13	5	localIOException5	IOException
    //   290	1	5	localIOException6	IOException
    //   298	1	5	localIOException7	IOException
    //   303	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   313	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   36	43	77	java/io/FileNotFoundException
    //   48	55	77	java/io/FileNotFoundException
    //   65	74	77	java/io/FileNotFoundException
    //   126	133	77	java/io/FileNotFoundException
    //   108	112	114	java/io/IOException
    //   143	147	150	java/io/IOException
    //   133	143	158	java/io/IOException
    //   94	104	166	java/io/IOException
    //   13	22	174	java/io/IOException
    //   210	214	216	java/io/IOException
    //   196	206	223	java/io/IOException
    //   13	22	231	finally
    //   241	249	260	java/io/IOException
    //   253	257	268	java/io/IOException
    //   22	31	276	finally
    //   36	43	283	finally
    //   48	55	283	finally
    //   65	74	283	finally
    //   84	89	283	finally
    //   126	133	283	finally
    //   186	191	283	finally
    //   22	31	290	java/io/IOException
    //   36	43	298	java/io/IOException
    //   48	55	298	java/io/IOException
    //   65	74	298	java/io/IOException
    //   126	133	298	java/io/IOException
    //   13	22	303	java/io/FileNotFoundException
    //   22	31	313	java/io/FileNotFoundException
  }
  
  /* Error */
  public static int d(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 66	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: iconst_m1
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: new 68	java/io/BufferedReader
    //   22: dup
    //   23: new 70	java/io/FileReader
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 73	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   31: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_0
    //   35: iconst_0
    //   36: istore_2
    //   37: aload_0
    //   38: astore 4
    //   40: aload_0
    //   41: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull +30 -> 78
    //   51: aload_0
    //   52: astore 4
    //   54: aload 5
    //   56: aload_1
    //   57: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   60: istore_3
    //   61: iload_3
    //   62: ifeq +9 -> 71
    //   65: aload_0
    //   66: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   69: iload_2
    //   70: ireturn
    //   71: iload_2
    //   72: iconst_1
    //   73: iadd
    //   74: istore_2
    //   75: goto -38 -> 37
    //   78: aload_0
    //   79: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   82: iconst_m1
    //   83: ireturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: astore 4
    //   90: aload_1
    //   91: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   94: aload_0
    //   95: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   98: goto -16 -> 82
    //   101: astore_1
    //   102: aload 5
    //   104: astore_0
    //   105: aload_0
    //   106: astore 4
    //   108: aload_1
    //   109: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   112: aload_0
    //   113: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   116: goto -34 -> 82
    //   119: astore_0
    //   120: aload 4
    //   122: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: goto -8 -> 120
    //   131: astore_1
    //   132: goto -27 -> 105
    //   135: astore_1
    //   136: goto -49 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramFile	File
    //   0	139	1	paramString	String
    //   36	39	2	i	int
    //   60	2	3	bool	boolean
    //   14	107	4	localFile	File
    //   17	86	5	str	String
    // Exception table:
    //   from	to	target	type
    //   19	35	84	java/io/FileNotFoundException
    //   19	35	101	java/io/IOException
    //   19	35	119	finally
    //   108	112	119	finally
    //   40	46	127	finally
    //   54	61	127	finally
    //   90	94	127	finally
    //   40	46	131	java/io/IOException
    //   54	61	131	java/io/IOException
    //   40	46	135	java/io/FileNotFoundException
    //   54	61	135	java/io/FileNotFoundException
  }
  
  /* Error */
  public static java.util.List<String> d(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 66	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 68	java/io/BufferedReader
    //   16: dup
    //   17: new 70	java/io/FileReader
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 73	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   25: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: new 272	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 273	java/util/ArrayList:<init>	()V
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +29 -> 76
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: aload_3
    //   54: invokeinterface 279 2 0
    //   59: pop
    //   60: goto -21 -> 39
    //   63: astore_2
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   70: aload_1
    //   71: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   74: aconst_null
    //   75: areturn
    //   76: aload_1
    //   77: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   80: aload_2
    //   81: areturn
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: astore_0
    //   87: aload_2
    //   88: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   91: aload_1
    //   92: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   95: goto -21 -> 74
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_0
    //   102: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   105: aload_1
    //   106: athrow
    //   107: astore_1
    //   108: goto -7 -> 101
    //   111: astore_2
    //   112: goto -27 -> 85
    //   115: astore_2
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -54 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramFile	File
    //   28	64	1	localBufferedReader	java.io.BufferedReader
    //   98	8	1	localObject1	Object
    //   107	1	1	localObject2	Object
    //   117	1	1	localObject3	Object
    //   38	15	2	localArrayList	java.util.ArrayList
    //   63	18	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   82	6	2	localIOException1	IOException
    //   111	1	2	localIOException2	IOException
    //   115	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   45	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   31	39	63	java/io/FileNotFoundException
    //   41	46	63	java/io/FileNotFoundException
    //   52	60	63	java/io/FileNotFoundException
    //   13	29	82	java/io/IOException
    //   13	29	98	finally
    //   31	39	107	finally
    //   41	46	107	finally
    //   52	60	107	finally
    //   66	70	107	finally
    //   87	91	107	finally
    //   31	39	111	java/io/IOException
    //   41	46	111	java/io/IOException
    //   52	60	111	java/io/IOException
    //   13	29	115	java/io/FileNotFoundException
  }
  
  public static long e(File paramFile)
  {
    long l1 = 0L;
    if ((paramFile == null) || (!paramFile.exists())) {
      return 0L;
    }
    long l2;
    if (paramFile.isDirectory())
    {
      localObject = paramFile.listFiles();
      l2 = l1;
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          l2 = e(localObject[i]);
          i += 1;
          l1 = l2 + l1;
        }
      }
    }
    else
    {
      l2 = paramFile.length();
    }
    Object localObject = new File(paramFile.getAbsolutePath() + System.currentTimeMillis());
    paramFile.renameTo((File)localObject);
    ((File)localObject).delete();
    return l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.om
 * JD-Core Version:    0.7.0.1
 */