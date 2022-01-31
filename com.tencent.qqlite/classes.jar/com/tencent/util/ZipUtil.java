package com.tencent.util;

public class ZipUtil
{
  public static final int a = 4096;
  
  /* Error */
  public static void a(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: new 19	java/io/File
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 26	java/io/File:listFiles	()[Ljava/io/File;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +29 -> 57
    //   31: aload 6
    //   33: arraylength
    //   34: istore 4
    //   36: iload_3
    //   37: iload 4
    //   39: if_icmpge +18 -> 57
    //   42: aload 6
    //   44: iload_3
    //   45: aaload
    //   46: invokevirtual 30	java/io/File:delete	()Z
    //   49: pop
    //   50: iload_3
    //   51: iconst_1
    //   52: iadd
    //   53: istore_3
    //   54: goto -18 -> 36
    //   57: new 32	java/util/zip/ZipInputStream
    //   60: dup
    //   61: new 34	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokevirtual 40	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   69: aload_1
    //   70: invokevirtual 46	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   73: invokespecial 49	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: invokespecial 50	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: astore 7
    //   81: aconst_null
    //   82: astore_0
    //   83: aload 7
    //   85: invokevirtual 54	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +293 -> 383
    //   93: sipush 4096
    //   96: newarray byte
    //   98: astore 6
    //   100: aload_1
    //   101: invokevirtual 60	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   104: astore_1
    //   105: new 19	java/io/File
    //   108: dup
    //   109: new 62	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   116: aload_2
    //   117: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   130: astore_1
    //   131: new 19	java/io/File
    //   134: dup
    //   135: aload_1
    //   136: invokevirtual 73	java/io/File:getParent	()Ljava/lang/String;
    //   139: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore 5
    //   144: aload 5
    //   146: invokevirtual 76	java/io/File:exists	()Z
    //   149: ifne +9 -> 158
    //   152: aload 5
    //   154: invokevirtual 79	java/io/File:mkdirs	()Z
    //   157: pop
    //   158: new 81	java/io/FileOutputStream
    //   161: dup
    //   162: aload_1
    //   163: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   166: astore_1
    //   167: new 86	java/io/BufferedOutputStream
    //   170: dup
    //   171: aload_1
    //   172: sipush 4096
    //   175: invokespecial 89	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   178: astore 5
    //   180: aload 7
    //   182: aload 6
    //   184: iconst_0
    //   185: sipush 4096
    //   188: invokevirtual 93	java/util/zip/ZipInputStream:read	([BII)I
    //   191: istore_3
    //   192: iload_3
    //   193: iconst_m1
    //   194: if_icmpeq +55 -> 249
    //   197: aload 5
    //   199: aload 6
    //   201: iconst_0
    //   202: iload_3
    //   203: invokevirtual 97	java/io/BufferedOutputStream:write	([BII)V
    //   206: goto -26 -> 180
    //   209: astore_0
    //   210: aload 5
    //   212: astore_0
    //   213: aload_0
    //   214: ifnull +11 -> 225
    //   217: aload_0
    //   218: invokevirtual 100	java/io/BufferedOutputStream:flush	()V
    //   221: aload_0
    //   222: invokevirtual 103	java/io/BufferedOutputStream:close	()V
    //   225: aload_0
    //   226: astore 6
    //   228: aload_1
    //   229: ifnull +14 -> 243
    //   232: aload_1
    //   233: invokevirtual 104	java/io/FileOutputStream:flush	()V
    //   236: aload_1
    //   237: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   240: aload_0
    //   241: astore 6
    //   243: aload 6
    //   245: astore_0
    //   246: goto -163 -> 83
    //   249: aload 5
    //   251: ifnull +13 -> 264
    //   254: aload 5
    //   256: invokevirtual 100	java/io/BufferedOutputStream:flush	()V
    //   259: aload 5
    //   261: invokevirtual 103	java/io/BufferedOutputStream:close	()V
    //   264: aload 5
    //   266: astore 6
    //   268: aload_1
    //   269: ifnull -26 -> 243
    //   272: aload_1
    //   273: invokevirtual 104	java/io/FileOutputStream:flush	()V
    //   276: aload_1
    //   277: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   280: aload 5
    //   282: astore 6
    //   284: goto -41 -> 243
    //   287: astore_0
    //   288: aload_0
    //   289: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   292: aload 5
    //   294: astore 6
    //   296: goto -53 -> 243
    //   299: astore_0
    //   300: aload 7
    //   302: ifnull -290 -> 12
    //   305: aload 7
    //   307: invokevirtual 109	java/util/zip/ZipInputStream:close	()V
    //   310: return
    //   311: astore_0
    //   312: aload_0
    //   313: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   316: return
    //   317: astore_1
    //   318: aload_1
    //   319: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   322: aload_0
    //   323: astore 6
    //   325: goto -82 -> 243
    //   328: astore_0
    //   329: aload 7
    //   331: ifnull +8 -> 339
    //   334: aload 7
    //   336: invokevirtual 109	java/util/zip/ZipInputStream:close	()V
    //   339: aload_0
    //   340: athrow
    //   341: astore_0
    //   342: aload_1
    //   343: astore_2
    //   344: aload_0
    //   345: astore_1
    //   346: aload 5
    //   348: ifnull +13 -> 361
    //   351: aload 5
    //   353: invokevirtual 100	java/io/BufferedOutputStream:flush	()V
    //   356: aload 5
    //   358: invokevirtual 103	java/io/BufferedOutputStream:close	()V
    //   361: aload_2
    //   362: ifnull +11 -> 373
    //   365: aload_2
    //   366: invokevirtual 104	java/io/FileOutputStream:flush	()V
    //   369: aload_2
    //   370: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   373: aload_1
    //   374: athrow
    //   375: astore_0
    //   376: aload_0
    //   377: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   380: goto -7 -> 373
    //   383: aload 7
    //   385: ifnull -373 -> 12
    //   388: aload 7
    //   390: invokevirtual 109	java/util/zip/ZipInputStream:close	()V
    //   393: return
    //   394: astore_0
    //   395: aload_0
    //   396: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   399: return
    //   400: astore_1
    //   401: aload_1
    //   402: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   405: goto -66 -> 339
    //   408: astore_0
    //   409: aconst_null
    //   410: astore 7
    //   412: goto -83 -> 329
    //   415: astore_0
    //   416: aload 5
    //   418: astore 7
    //   420: goto -120 -> 300
    //   423: astore_1
    //   424: aload 8
    //   426: astore_2
    //   427: aload_0
    //   428: astore 5
    //   430: goto -84 -> 346
    //   433: astore 5
    //   435: aload_1
    //   436: astore_2
    //   437: aload 5
    //   439: astore_1
    //   440: aload_0
    //   441: astore 5
    //   443: goto -97 -> 346
    //   446: astore_1
    //   447: aconst_null
    //   448: astore_1
    //   449: goto -236 -> 213
    //   452: astore 5
    //   454: goto -241 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	paramContext	android.content.Context
    //   0	457	1	paramString1	java.lang.String
    //   0	457	2	paramString2	java.lang.String
    //   7	196	3	i	int
    //   34	6	4	j	int
    //   4	425	5	localObject1	Object
    //   433	5	5	localObject2	Object
    //   441	1	5	localContext	android.content.Context
    //   452	1	5	localException	java.lang.Exception
    //   24	300	6	localObject3	Object
    //   79	340	7	localObject4	Object
    //   1	424	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   180	192	209	java/lang/Exception
    //   197	206	209	java/lang/Exception
    //   254	264	287	java/io/IOException
    //   272	280	287	java/io/IOException
    //   83	89	299	java/lang/Exception
    //   217	225	299	java/lang/Exception
    //   232	240	299	java/lang/Exception
    //   254	264	299	java/lang/Exception
    //   272	280	299	java/lang/Exception
    //   288	292	299	java/lang/Exception
    //   318	322	299	java/lang/Exception
    //   351	361	299	java/lang/Exception
    //   365	373	299	java/lang/Exception
    //   373	375	299	java/lang/Exception
    //   376	380	299	java/lang/Exception
    //   305	310	311	java/io/IOException
    //   217	225	317	java/io/IOException
    //   232	240	317	java/io/IOException
    //   83	89	328	finally
    //   217	225	328	finally
    //   232	240	328	finally
    //   254	264	328	finally
    //   272	280	328	finally
    //   288	292	328	finally
    //   318	322	328	finally
    //   351	361	328	finally
    //   365	373	328	finally
    //   373	375	328	finally
    //   376	380	328	finally
    //   180	192	341	finally
    //   197	206	341	finally
    //   351	361	375	java/io/IOException
    //   365	373	375	java/io/IOException
    //   388	393	394	java/io/IOException
    //   334	339	400	java/io/IOException
    //   13	26	408	finally
    //   31	36	408	finally
    //   42	50	408	finally
    //   57	81	408	finally
    //   13	26	415	java/lang/Exception
    //   31	36	415	java/lang/Exception
    //   42	50	415	java/lang/Exception
    //   57	81	415	java/lang/Exception
    //   93	158	423	finally
    //   158	167	423	finally
    //   167	180	433	finally
    //   93	158	446	java/lang/Exception
    //   158	167	446	java/lang/Exception
    //   167	180	452	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.util.ZipUtil
 * JD-Core Version:    0.7.0.1
 */