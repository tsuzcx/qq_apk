package com.tencent.util;

public class ZipUtil
{
  public static final int a = 4096;
  
  /* Error */
  public static void a(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 6
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
    //   24: astore 7
    //   26: aload 7
    //   28: ifnull +29 -> 57
    //   31: aload 7
    //   33: arraylength
    //   34: istore 4
    //   36: iload_3
    //   37: iload 4
    //   39: if_icmpge +18 -> 57
    //   42: aload 7
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
    //   79: astore 8
    //   81: aconst_null
    //   82: astore_0
    //   83: aload 8
    //   85: invokevirtual 54	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +342 -> 432
    //   93: sipush 4096
    //   96: newarray byte
    //   98: astore 7
    //   100: aload_1
    //   101: invokevirtual 60	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +16 -> 122
    //   109: aload_1
    //   110: ldc 62
    //   112: invokevirtual 68	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   115: istore 5
    //   117: iload 5
    //   119: ifeq +53 -> 172
    //   122: aload_0
    //   123: ifnull +11 -> 134
    //   126: aload_0
    //   127: invokevirtual 73	java/io/BufferedOutputStream:flush	()V
    //   130: aload_0
    //   131: invokevirtual 76	java/io/BufferedOutputStream:close	()V
    //   134: iconst_0
    //   135: ifeq -52 -> 83
    //   138: new 78	java/lang/NullPointerException
    //   141: dup
    //   142: invokespecial 79	java/lang/NullPointerException:<init>	()V
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   151: goto -68 -> 83
    //   154: astore_0
    //   155: aload 8
    //   157: ifnull -145 -> 12
    //   160: aload 8
    //   162: invokevirtual 83	java/util/zip/ZipInputStream:close	()V
    //   165: return
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   171: return
    //   172: new 19	java/io/File
    //   175: dup
    //   176: new 85	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   183: aload_2
    //   184: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_1
    //   188: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: astore 6
    //   199: new 19	java/io/File
    //   202: dup
    //   203: aload 6
    //   205: invokevirtual 96	java/io/File:getParent	()Ljava/lang/String;
    //   208: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 99	java/io/File:exists	()Z
    //   216: ifne +8 -> 224
    //   219: aload_1
    //   220: invokevirtual 102	java/io/File:mkdirs	()Z
    //   223: pop
    //   224: new 104	java/io/FileOutputStream
    //   227: dup
    //   228: aload 6
    //   230: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   233: astore_1
    //   234: new 70	java/io/BufferedOutputStream
    //   237: dup
    //   238: aload_1
    //   239: sipush 4096
    //   242: invokespecial 110	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   245: astore 6
    //   247: aload 8
    //   249: aload 7
    //   251: iconst_0
    //   252: sipush 4096
    //   255: invokevirtual 114	java/util/zip/ZipInputStream:read	([BII)I
    //   258: istore_3
    //   259: iload_3
    //   260: iconst_m1
    //   261: if_icmpeq +55 -> 316
    //   264: aload 6
    //   266: aload 7
    //   268: iconst_0
    //   269: iload_3
    //   270: invokevirtual 118	java/io/BufferedOutputStream:write	([BII)V
    //   273: goto -26 -> 247
    //   276: astore_0
    //   277: aload 6
    //   279: astore_0
    //   280: aload_0
    //   281: ifnull +11 -> 292
    //   284: aload_0
    //   285: invokevirtual 73	java/io/BufferedOutputStream:flush	()V
    //   288: aload_0
    //   289: invokevirtual 76	java/io/BufferedOutputStream:close	()V
    //   292: aload_0
    //   293: astore 7
    //   295: aload_1
    //   296: ifnull +14 -> 310
    //   299: aload_1
    //   300: invokevirtual 119	java/io/FileOutputStream:flush	()V
    //   303: aload_1
    //   304: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   307: aload_0
    //   308: astore 7
    //   310: aload 7
    //   312: astore_0
    //   313: goto -230 -> 83
    //   316: aload 6
    //   318: ifnull +13 -> 331
    //   321: aload 6
    //   323: invokevirtual 73	java/io/BufferedOutputStream:flush	()V
    //   326: aload 6
    //   328: invokevirtual 76	java/io/BufferedOutputStream:close	()V
    //   331: aload 6
    //   333: astore 7
    //   335: aload_1
    //   336: ifnull -26 -> 310
    //   339: aload_1
    //   340: invokevirtual 119	java/io/FileOutputStream:flush	()V
    //   343: aload_1
    //   344: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   347: aload 6
    //   349: astore 7
    //   351: goto -41 -> 310
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   359: aload 6
    //   361: astore 7
    //   363: goto -53 -> 310
    //   366: astore_0
    //   367: aload 8
    //   369: ifnull +8 -> 377
    //   372: aload 8
    //   374: invokevirtual 83	java/util/zip/ZipInputStream:close	()V
    //   377: aload_0
    //   378: athrow
    //   379: astore_1
    //   380: aload_1
    //   381: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   384: aload_0
    //   385: astore 7
    //   387: goto -77 -> 310
    //   390: astore_0
    //   391: aload_1
    //   392: astore_2
    //   393: aload_0
    //   394: astore_1
    //   395: aload 6
    //   397: ifnull +13 -> 410
    //   400: aload 6
    //   402: invokevirtual 73	java/io/BufferedOutputStream:flush	()V
    //   405: aload 6
    //   407: invokevirtual 76	java/io/BufferedOutputStream:close	()V
    //   410: aload_2
    //   411: ifnull +11 -> 422
    //   414: aload_2
    //   415: invokevirtual 119	java/io/FileOutputStream:flush	()V
    //   418: aload_2
    //   419: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   422: aload_1
    //   423: athrow
    //   424: astore_0
    //   425: aload_0
    //   426: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   429: goto -7 -> 422
    //   432: aload 8
    //   434: ifnull -422 -> 12
    //   437: aload 8
    //   439: invokevirtual 83	java/util/zip/ZipInputStream:close	()V
    //   442: return
    //   443: astore_0
    //   444: aload_0
    //   445: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   448: return
    //   449: astore_1
    //   450: aload_1
    //   451: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   454: goto -77 -> 377
    //   457: astore_0
    //   458: aconst_null
    //   459: astore 8
    //   461: goto -94 -> 367
    //   464: astore_0
    //   465: aload 6
    //   467: astore 8
    //   469: goto -314 -> 155
    //   472: astore_1
    //   473: aload 9
    //   475: astore_2
    //   476: aload_0
    //   477: astore 6
    //   479: goto -84 -> 395
    //   482: astore 6
    //   484: aload_1
    //   485: astore_2
    //   486: aload 6
    //   488: astore_1
    //   489: aload_0
    //   490: astore 6
    //   492: goto -97 -> 395
    //   495: astore_1
    //   496: aconst_null
    //   497: astore_1
    //   498: goto -218 -> 280
    //   501: astore 6
    //   503: goto -223 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramContext	android.content.Context
    //   0	506	1	paramString1	java.lang.String
    //   0	506	2	paramString2	java.lang.String
    //   7	263	3	i	int
    //   34	6	4	j	int
    //   115	3	5	bool	boolean
    //   4	474	6	localObject1	Object
    //   482	5	6	localObject2	Object
    //   490	1	6	localContext	android.content.Context
    //   501	1	6	localException	java.lang.Exception
    //   24	362	7	localObject3	Object
    //   79	389	8	localObject4	Object
    //   1	473	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   126	134	146	java/io/IOException
    //   138	146	146	java/io/IOException
    //   83	89	154	java/lang/Exception
    //   126	134	154	java/lang/Exception
    //   138	146	154	java/lang/Exception
    //   147	151	154	java/lang/Exception
    //   284	292	154	java/lang/Exception
    //   299	307	154	java/lang/Exception
    //   321	331	154	java/lang/Exception
    //   339	347	154	java/lang/Exception
    //   355	359	154	java/lang/Exception
    //   380	384	154	java/lang/Exception
    //   400	410	154	java/lang/Exception
    //   414	422	154	java/lang/Exception
    //   422	424	154	java/lang/Exception
    //   425	429	154	java/lang/Exception
    //   160	165	166	java/io/IOException
    //   247	259	276	java/lang/Exception
    //   264	273	276	java/lang/Exception
    //   321	331	354	java/io/IOException
    //   339	347	354	java/io/IOException
    //   83	89	366	finally
    //   126	134	366	finally
    //   138	146	366	finally
    //   147	151	366	finally
    //   284	292	366	finally
    //   299	307	366	finally
    //   321	331	366	finally
    //   339	347	366	finally
    //   355	359	366	finally
    //   380	384	366	finally
    //   400	410	366	finally
    //   414	422	366	finally
    //   422	424	366	finally
    //   425	429	366	finally
    //   284	292	379	java/io/IOException
    //   299	307	379	java/io/IOException
    //   247	259	390	finally
    //   264	273	390	finally
    //   400	410	424	java/io/IOException
    //   414	422	424	java/io/IOException
    //   437	442	443	java/io/IOException
    //   372	377	449	java/io/IOException
    //   13	26	457	finally
    //   31	36	457	finally
    //   42	50	457	finally
    //   57	81	457	finally
    //   13	26	464	java/lang/Exception
    //   31	36	464	java/lang/Exception
    //   42	50	464	java/lang/Exception
    //   57	81	464	java/lang/Exception
    //   93	105	472	finally
    //   109	117	472	finally
    //   172	224	472	finally
    //   224	234	472	finally
    //   234	247	482	finally
    //   93	105	495	java/lang/Exception
    //   109	117	495	java/lang/Exception
    //   172	224	495	java/lang/Exception
    //   224	234	495	java/lang/Exception
    //   234	247	501	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.util.ZipUtil
 * JD-Core Version:    0.7.0.1
 */