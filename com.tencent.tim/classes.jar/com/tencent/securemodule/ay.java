package com.tencent.securemodule;

import android.content.Context;
import java.io.File;

public class ay
{
  /* Error */
  private static int a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 12	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 20	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: iconst_m1
    //   17: ireturn
    //   18: new 22	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_1
    //   30: invokevirtual 29	java/io/FileInputStream:read	()I
    //   33: pop
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: iconst_4
    //   38: newarray byte
    //   40: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: bipush 16
    //   48: newarray byte
    //   50: astore 4
    //   52: aload_1
    //   53: astore_0
    //   54: aload_1
    //   55: aload 4
    //   57: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   60: bipush 16
    //   62: if_icmpne +124 -> 186
    //   65: aload_1
    //   66: astore_0
    //   67: new 34	java/io/ByteArrayOutputStream
    //   70: dup
    //   71: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   74: astore 5
    //   76: aload_1
    //   77: astore_0
    //   78: sipush 1024
    //   81: newarray byte
    //   83: astore 6
    //   85: aload_1
    //   86: astore_0
    //   87: aload_1
    //   88: aload 6
    //   90: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   93: istore_2
    //   94: iload_2
    //   95: iconst_m1
    //   96: if_icmpeq +39 -> 135
    //   99: aload_1
    //   100: astore_0
    //   101: aload 5
    //   103: aload 6
    //   105: iconst_0
    //   106: iload_2
    //   107: invokevirtual 41	java/io/ByteArrayOutputStream:write	([BII)V
    //   110: goto -25 -> 85
    //   113: astore 4
    //   115: aload_1
    //   116: astore_0
    //   117: aload 4
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 47	java/io/FileInputStream:close	()V
    //   132: bipush 254
    //   134: ireturn
    //   135: aload_1
    //   136: astore_0
    //   137: aload 5
    //   139: invokevirtual 51	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: invokestatic 57	com/tencent/securemodule/ax:b	([B)[B
    //   145: astore 6
    //   147: aload_1
    //   148: astore_0
    //   149: aload 5
    //   151: invokevirtual 58	java/io/ByteArrayOutputStream:close	()V
    //   154: aload_1
    //   155: astore_0
    //   156: aload 6
    //   158: aload 4
    //   160: invokestatic 64	java/util/Arrays:equals	([B[B)Z
    //   163: istore_3
    //   164: iload_3
    //   165: ifeq +21 -> 186
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 47	java/io/FileInputStream:close	()V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   183: goto -7 -> 176
    //   186: aload_1
    //   187: ifnull -55 -> 132
    //   190: aload_1
    //   191: invokevirtual 47	java/io/FileInputStream:close	()V
    //   194: goto -62 -> 132
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   202: goto -70 -> 132
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   210: goto -78 -> 132
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_1
    //   217: aload_1
    //   218: astore_0
    //   219: aload 4
    //   221: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   224: aload_1
    //   225: ifnull -93 -> 132
    //   228: aload_1
    //   229: invokevirtual 47	java/io/FileInputStream:close	()V
    //   232: goto -100 -> 132
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   240: goto -108 -> 132
    //   243: astore_1
    //   244: aconst_null
    //   245: astore_0
    //   246: aload_0
    //   247: ifnull +7 -> 254
    //   250: aload_0
    //   251: invokevirtual 47	java/io/FileInputStream:close	()V
    //   254: aload_1
    //   255: athrow
    //   256: astore_0
    //   257: aload_0
    //   258: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   261: goto -7 -> 254
    //   264: astore_1
    //   265: goto -19 -> 246
    //   268: astore_1
    //   269: goto -23 -> 246
    //   272: astore 4
    //   274: goto -57 -> 217
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_0
    //   280: goto -160 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramContext	Context
    //   0	283	1	paramString	String
    //   93	14	2	i	int
    //   163	2	3	bool	boolean
    //   50	6	4	arrayOfByte1	byte[]
    //   113	46	4	localIOException	java.io.IOException
    //   213	7	4	localException1	java.lang.Exception
    //   272	1	4	localException2	java.lang.Exception
    //   74	76	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   83	74	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   29	34	113	java/io/IOException
    //   36	44	113	java/io/IOException
    //   46	52	113	java/io/IOException
    //   54	65	113	java/io/IOException
    //   67	76	113	java/io/IOException
    //   78	85	113	java/io/IOException
    //   87	94	113	java/io/IOException
    //   101	110	113	java/io/IOException
    //   137	147	113	java/io/IOException
    //   149	154	113	java/io/IOException
    //   156	164	113	java/io/IOException
    //   172	176	178	java/io/IOException
    //   190	194	197	java/io/IOException
    //   128	132	205	java/io/IOException
    //   18	27	213	java/lang/Exception
    //   228	232	235	java/io/IOException
    //   18	27	243	finally
    //   250	254	256	java/io/IOException
    //   29	34	264	finally
    //   36	44	264	finally
    //   46	52	264	finally
    //   54	65	264	finally
    //   67	76	264	finally
    //   78	85	264	finally
    //   87	94	264	finally
    //   101	110	264	finally
    //   137	147	264	finally
    //   149	154	264	finally
    //   156	164	264	finally
    //   219	224	264	finally
    //   120	124	268	finally
    //   29	34	272	java/lang/Exception
    //   36	44	272	java/lang/Exception
    //   46	52	272	java/lang/Exception
    //   54	65	272	java/lang/Exception
    //   67	76	272	java/lang/Exception
    //   78	85	272	java/lang/Exception
    //   87	94	272	java/lang/Exception
    //   101	110	272	java/lang/Exception
    //   137	147	272	java/lang/Exception
    //   149	154	272	java/lang/Exception
    //   156	164	272	java/lang/Exception
    //   18	27	277	java/io/IOException
  }
  
  public static int a(Context paramContext, String paramString, boolean paramBoolean)
  {
    ae localae = new ae(paramContext);
    localae.a(paramContext.getCacheDir().getAbsolutePath());
    localae.b("qqsecure.info");
    localae.a(null);
    while (localae.a(paramString, false) == -7) {}
    paramString = paramContext.getCacheDir().getAbsolutePath() + "/qqsecure.info";
    int i = a(paramContext, paramString);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = b(paramContext, paramString);
      i = j;
    } while (j != 0);
    if (paramBoolean) {
      new Thread(new az()).start();
    }
    return 0;
  }
  
  /* Error */
  private static int b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 9
    //   17: aconst_null
    //   18: astore 4
    //   20: new 12	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore 10
    //   30: aload 10
    //   32: invokevirtual 20	java/io/File:exists	()Z
    //   35: ifne +5 -> 40
    //   38: iconst_m1
    //   39: ireturn
    //   40: new 22	java/io/FileInputStream
    //   43: dup
    //   44: aload 10
    //   46: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: astore_1
    //   50: aload 7
    //   52: astore_3
    //   53: aload_1
    //   54: astore 4
    //   56: aload 8
    //   58: astore 5
    //   60: aload 9
    //   62: astore 6
    //   64: new 12	java/io/File
    //   67: dup
    //   68: new 96	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   75: aload_0
    //   76: invokevirtual 126	android/content/Context:getFilesDir	()Ljava/io/File;
    //   79: invokevirtual 82	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   82: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 128
    //   87: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 130
    //   92: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 132
    //   97: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore_0
    //   107: aload 7
    //   109: astore_3
    //   110: aload_1
    //   111: astore 4
    //   113: aload 8
    //   115: astore 5
    //   117: aload 9
    //   119: astore 6
    //   121: aload_0
    //   122: invokevirtual 20	java/io/File:exists	()Z
    //   125: ifeq +158 -> 283
    //   128: aload 7
    //   130: astore_3
    //   131: aload_1
    //   132: astore 4
    //   134: aload 8
    //   136: astore 5
    //   138: aload 9
    //   140: astore 6
    //   142: aload_0
    //   143: invokevirtual 135	java/io/File:delete	()Z
    //   146: pop
    //   147: aload 7
    //   149: astore_3
    //   150: aload_1
    //   151: astore 4
    //   153: aload 8
    //   155: astore 5
    //   157: aload 9
    //   159: astore 6
    //   161: new 137	java/io/FileOutputStream
    //   164: dup
    //   165: aload_0
    //   166: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   169: astore_0
    //   170: aload_0
    //   171: astore_3
    //   172: aload_1
    //   173: astore 4
    //   175: aload_0
    //   176: astore 5
    //   178: aload_0
    //   179: astore 6
    //   181: aload_1
    //   182: bipush 21
    //   184: newarray byte
    //   186: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   189: pop
    //   190: aload_0
    //   191: astore_3
    //   192: aload_1
    //   193: astore 4
    //   195: aload_0
    //   196: astore 5
    //   198: aload_0
    //   199: astore 6
    //   201: sipush 1024
    //   204: newarray byte
    //   206: astore 7
    //   208: aload_0
    //   209: astore_3
    //   210: aload_1
    //   211: astore 4
    //   213: aload_0
    //   214: astore 5
    //   216: aload_0
    //   217: astore 6
    //   219: aload_1
    //   220: aload 7
    //   222: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   225: istore_2
    //   226: iload_2
    //   227: iconst_m1
    //   228: if_icmpeq +122 -> 350
    //   231: aload_0
    //   232: astore_3
    //   233: aload_1
    //   234: astore 4
    //   236: aload_0
    //   237: astore 5
    //   239: aload_0
    //   240: astore 6
    //   242: aload_0
    //   243: aload 7
    //   245: iconst_0
    //   246: iload_2
    //   247: invokevirtual 139	java/io/FileOutputStream:write	([BII)V
    //   250: goto -42 -> 208
    //   253: astore_3
    //   254: aload_3
    //   255: invokevirtual 140	java/io/FileNotFoundException:printStackTrace	()V
    //   258: aload_1
    //   259: ifnull +7 -> 266
    //   262: aload_1
    //   263: invokevirtual 47	java/io/FileInputStream:close	()V
    //   266: aload_0
    //   267: ifnull +7 -> 274
    //   270: aload_0
    //   271: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   274: aload 10
    //   276: invokevirtual 135	java/io/File:delete	()Z
    //   279: pop
    //   280: bipush 254
    //   282: ireturn
    //   283: aload 7
    //   285: astore_3
    //   286: aload_1
    //   287: astore 4
    //   289: aload 8
    //   291: astore 5
    //   293: aload 9
    //   295: astore 6
    //   297: aload_0
    //   298: invokevirtual 144	java/io/File:getParentFile	()Ljava/io/File;
    //   301: invokevirtual 147	java/io/File:mkdirs	()Z
    //   304: pop
    //   305: aload 7
    //   307: astore_3
    //   308: aload_1
    //   309: astore 4
    //   311: aload 8
    //   313: astore 5
    //   315: aload 9
    //   317: astore 6
    //   319: aload_0
    //   320: invokevirtual 150	java/io/File:createNewFile	()Z
    //   323: pop
    //   324: aload 7
    //   326: astore_3
    //   327: aload_1
    //   328: astore 4
    //   330: aload 8
    //   332: astore 5
    //   334: aload 9
    //   336: astore 6
    //   338: new 137	java/io/FileOutputStream
    //   341: dup
    //   342: aload_0
    //   343: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   346: astore_0
    //   347: goto -177 -> 170
    //   350: aload_1
    //   351: ifnull +7 -> 358
    //   354: aload_1
    //   355: invokevirtual 47	java/io/FileInputStream:close	()V
    //   358: aload_0
    //   359: ifnull +7 -> 366
    //   362: aload_0
    //   363: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   366: aload 10
    //   368: invokevirtual 135	java/io/File:delete	()Z
    //   371: pop
    //   372: iconst_0
    //   373: ireturn
    //   374: astore_1
    //   375: aload_1
    //   376: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   379: goto -21 -> 358
    //   382: astore_0
    //   383: aload_0
    //   384: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   387: goto -21 -> 366
    //   390: astore_1
    //   391: aload_1
    //   392: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   395: goto -129 -> 266
    //   398: astore_0
    //   399: aload_0
    //   400: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   403: goto -129 -> 274
    //   406: astore_0
    //   407: aconst_null
    //   408: astore_1
    //   409: aload 6
    //   411: astore_3
    //   412: aload_1
    //   413: astore 4
    //   415: aload_0
    //   416: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   419: aload_1
    //   420: ifnull +7 -> 427
    //   423: aload_1
    //   424: invokevirtual 47	java/io/FileInputStream:close	()V
    //   427: aload 6
    //   429: ifnull +8 -> 437
    //   432: aload 6
    //   434: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   437: aload 10
    //   439: invokevirtual 135	java/io/File:delete	()Z
    //   442: pop
    //   443: bipush 254
    //   445: ireturn
    //   446: astore_0
    //   447: aload_0
    //   448: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   451: goto -24 -> 427
    //   454: astore_0
    //   455: aload_0
    //   456: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   459: goto -22 -> 437
    //   462: astore_0
    //   463: aconst_null
    //   464: astore_1
    //   465: aload 5
    //   467: astore_3
    //   468: aload_1
    //   469: astore 4
    //   471: aload_0
    //   472: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   475: aload_1
    //   476: ifnull +7 -> 483
    //   479: aload_1
    //   480: invokevirtual 47	java/io/FileInputStream:close	()V
    //   483: aload 5
    //   485: ifnull +8 -> 493
    //   488: aload 5
    //   490: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   493: aload 10
    //   495: invokevirtual 135	java/io/File:delete	()Z
    //   498: pop
    //   499: bipush 254
    //   501: ireturn
    //   502: astore_0
    //   503: aload_0
    //   504: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   507: goto -24 -> 483
    //   510: astore_0
    //   511: aload_0
    //   512: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   515: goto -22 -> 493
    //   518: astore_0
    //   519: aconst_null
    //   520: astore 4
    //   522: aload 4
    //   524: ifnull +8 -> 532
    //   527: aload 4
    //   529: invokevirtual 47	java/io/FileInputStream:close	()V
    //   532: aload_3
    //   533: ifnull +7 -> 540
    //   536: aload_3
    //   537: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   540: aload 10
    //   542: invokevirtual 135	java/io/File:delete	()Z
    //   545: pop
    //   546: aload_0
    //   547: athrow
    //   548: astore_1
    //   549: aload_1
    //   550: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   553: goto -21 -> 532
    //   556: astore_1
    //   557: aload_1
    //   558: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   561: goto -21 -> 540
    //   564: astore_0
    //   565: goto -43 -> 522
    //   568: astore 4
    //   570: aload_0
    //   571: astore_3
    //   572: aload 4
    //   574: astore_0
    //   575: aload_1
    //   576: astore 4
    //   578: goto -56 -> 522
    //   581: astore_0
    //   582: goto -117 -> 465
    //   585: astore_0
    //   586: goto -177 -> 409
    //   589: astore_3
    //   590: aconst_null
    //   591: astore_0
    //   592: aload 4
    //   594: astore_1
    //   595: goto -341 -> 254
    //   598: astore_3
    //   599: aconst_null
    //   600: astore_0
    //   601: goto -347 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	paramContext	Context
    //   0	604	1	paramString	String
    //   225	22	2	i	int
    //   7	226	3	localObject1	Object
    //   253	2	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   285	287	3	localObject2	Object
    //   589	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   598	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   18	510	4	str1	String
    //   568	5	4	localObject3	Object
    //   576	17	4	str2	String
    //   4	485	5	localObject4	Object
    //   1	432	6	localObject5	Object
    //   9	316	7	arrayOfByte	byte[]
    //   12	319	8	localObject6	Object
    //   15	320	9	localObject7	Object
    //   28	513	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   181	190	253	java/io/FileNotFoundException
    //   201	208	253	java/io/FileNotFoundException
    //   219	226	253	java/io/FileNotFoundException
    //   242	250	253	java/io/FileNotFoundException
    //   354	358	374	java/io/IOException
    //   362	366	382	java/io/IOException
    //   262	266	390	java/io/IOException
    //   270	274	398	java/io/IOException
    //   40	50	406	java/io/IOException
    //   423	427	446	java/io/IOException
    //   432	437	454	java/io/IOException
    //   40	50	462	java/lang/Exception
    //   479	483	502	java/io/IOException
    //   488	493	510	java/io/IOException
    //   40	50	518	finally
    //   527	532	548	java/io/IOException
    //   536	540	556	java/io/IOException
    //   64	107	564	finally
    //   121	128	564	finally
    //   142	147	564	finally
    //   161	170	564	finally
    //   181	190	564	finally
    //   201	208	564	finally
    //   219	226	564	finally
    //   242	250	564	finally
    //   297	305	564	finally
    //   319	324	564	finally
    //   338	347	564	finally
    //   415	419	564	finally
    //   471	475	564	finally
    //   254	258	568	finally
    //   64	107	581	java/lang/Exception
    //   121	128	581	java/lang/Exception
    //   142	147	581	java/lang/Exception
    //   161	170	581	java/lang/Exception
    //   181	190	581	java/lang/Exception
    //   201	208	581	java/lang/Exception
    //   219	226	581	java/lang/Exception
    //   242	250	581	java/lang/Exception
    //   297	305	581	java/lang/Exception
    //   319	324	581	java/lang/Exception
    //   338	347	581	java/lang/Exception
    //   64	107	585	java/io/IOException
    //   121	128	585	java/io/IOException
    //   142	147	585	java/io/IOException
    //   161	170	585	java/io/IOException
    //   181	190	585	java/io/IOException
    //   201	208	585	java/io/IOException
    //   219	226	585	java/io/IOException
    //   242	250	585	java/io/IOException
    //   297	305	585	java/io/IOException
    //   319	324	585	java/io/IOException
    //   338	347	585	java/io/IOException
    //   40	50	589	java/io/FileNotFoundException
    //   64	107	598	java/io/FileNotFoundException
    //   121	128	598	java/io/FileNotFoundException
    //   142	147	598	java/io/FileNotFoundException
    //   161	170	598	java/io/FileNotFoundException
    //   297	305	598	java/io/FileNotFoundException
    //   319	324	598	java/io/FileNotFoundException
    //   338	347	598	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.securemodule.ay
 * JD-Core Version:    0.7.0.1
 */