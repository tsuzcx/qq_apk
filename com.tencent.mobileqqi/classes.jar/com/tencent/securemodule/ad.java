package com.tencent.securemodule;

import android.content.Context;
import com.tencent.securemodule.ui.TransparentActivity.a;
import java.io.File;

public final class ad
{
  public ad() {}
  
  public ad(TransparentActivity.a parama) {}
  
  /* Error */
  private static int a(Context paramContext, String paramString)
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
    //   20: new 23	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore 10
    //   30: aload 10
    //   32: invokevirtual 30	java/io/File:exists	()Z
    //   35: ifne +5 -> 40
    //   38: iconst_m1
    //   39: ireturn
    //   40: new 32	java/io/FileInputStream
    //   43: dup
    //   44: aload 10
    //   46: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: astore_1
    //   50: aload 7
    //   52: astore_3
    //   53: aload_1
    //   54: astore 4
    //   56: aload 8
    //   58: astore 5
    //   60: aload 9
    //   62: astore 6
    //   64: new 23	java/io/File
    //   67: dup
    //   68: new 37	java/lang/StringBuilder
    //   71: dup
    //   72: aload_0
    //   73: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   76: invokevirtual 47	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: ldc 56
    //   87: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 62
    //   92: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 64
    //   97: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
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
    //   122: invokevirtual 30	java/io/File:exists	()Z
    //   125: ifeq +122 -> 247
    //   128: aload 7
    //   130: astore_3
    //   131: aload_1
    //   132: astore 4
    //   134: aload 8
    //   136: astore 5
    //   138: aload 9
    //   140: astore 6
    //   142: aload_0
    //   143: invokevirtual 70	java/io/File:delete	()Z
    //   146: pop
    //   147: aload 7
    //   149: astore_3
    //   150: aload_1
    //   151: astore 4
    //   153: aload 8
    //   155: astore 5
    //   157: aload 9
    //   159: astore 6
    //   161: new 72	java/io/FileOutputStream
    //   164: dup
    //   165: aload_0
    //   166: invokespecial 73	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
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
    //   186: invokevirtual 77	java/io/FileInputStream:read	([B)I
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
    //   222: invokevirtual 77	java/io/FileInputStream:read	([B)I
    //   225: istore_2
    //   226: iload_2
    //   227: iconst_m1
    //   228: if_icmpne +86 -> 314
    //   231: aload_1
    //   232: invokevirtual 80	java/io/FileInputStream:close	()V
    //   235: aload_0
    //   236: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   239: aload 10
    //   241: invokevirtual 70	java/io/File:delete	()Z
    //   244: pop
    //   245: iconst_0
    //   246: ireturn
    //   247: aload 7
    //   249: astore_3
    //   250: aload_1
    //   251: astore 4
    //   253: aload 8
    //   255: astore 5
    //   257: aload 9
    //   259: astore 6
    //   261: aload_0
    //   262: invokevirtual 84	java/io/File:getParentFile	()Ljava/io/File;
    //   265: invokevirtual 87	java/io/File:mkdirs	()Z
    //   268: pop
    //   269: aload 7
    //   271: astore_3
    //   272: aload_1
    //   273: astore 4
    //   275: aload 8
    //   277: astore 5
    //   279: aload 9
    //   281: astore 6
    //   283: aload_0
    //   284: invokevirtual 90	java/io/File:createNewFile	()Z
    //   287: pop
    //   288: aload 7
    //   290: astore_3
    //   291: aload_1
    //   292: astore 4
    //   294: aload 8
    //   296: astore 5
    //   298: aload 9
    //   300: astore 6
    //   302: new 72	java/io/FileOutputStream
    //   305: dup
    //   306: aload_0
    //   307: invokespecial 73	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   310: astore_0
    //   311: goto -141 -> 170
    //   314: aload_0
    //   315: astore_3
    //   316: aload_1
    //   317: astore 4
    //   319: aload_0
    //   320: astore 5
    //   322: aload_0
    //   323: astore 6
    //   325: aload_0
    //   326: aload 7
    //   328: iconst_0
    //   329: iload_2
    //   330: invokevirtual 94	java/io/FileOutputStream:write	([BII)V
    //   333: goto -125 -> 208
    //   336: astore_3
    //   337: aload_3
    //   338: invokevirtual 97	java/io/FileNotFoundException:printStackTrace	()V
    //   341: aload_1
    //   342: ifnull +7 -> 349
    //   345: aload_1
    //   346: invokevirtual 80	java/io/FileInputStream:close	()V
    //   349: aload_0
    //   350: ifnull +7 -> 357
    //   353: aload_0
    //   354: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   357: aload 10
    //   359: invokevirtual 70	java/io/File:delete	()Z
    //   362: pop
    //   363: bipush 254
    //   365: ireturn
    //   366: astore_1
    //   367: aload_1
    //   368: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   371: goto -22 -> 349
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   379: goto -22 -> 357
    //   382: astore_0
    //   383: aconst_null
    //   384: astore_1
    //   385: aload 6
    //   387: astore_3
    //   388: aload_1
    //   389: astore 4
    //   391: aload_0
    //   392: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   395: aload_1
    //   396: ifnull +7 -> 403
    //   399: aload_1
    //   400: invokevirtual 80	java/io/FileInputStream:close	()V
    //   403: aload 6
    //   405: ifnull +8 -> 413
    //   408: aload 6
    //   410: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   413: aload 10
    //   415: invokevirtual 70	java/io/File:delete	()Z
    //   418: pop
    //   419: bipush 254
    //   421: ireturn
    //   422: astore_0
    //   423: aload_0
    //   424: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   427: goto -24 -> 403
    //   430: astore_0
    //   431: aload_0
    //   432: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   435: goto -22 -> 413
    //   438: astore_0
    //   439: aconst_null
    //   440: astore_1
    //   441: aload 5
    //   443: astore_3
    //   444: aload_1
    //   445: astore 4
    //   447: aload_0
    //   448: invokevirtual 99	java/lang/Exception:printStackTrace	()V
    //   451: aload_1
    //   452: ifnull +7 -> 459
    //   455: aload_1
    //   456: invokevirtual 80	java/io/FileInputStream:close	()V
    //   459: aload 5
    //   461: ifnull +8 -> 469
    //   464: aload 5
    //   466: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   469: aload 10
    //   471: invokevirtual 70	java/io/File:delete	()Z
    //   474: pop
    //   475: bipush 254
    //   477: ireturn
    //   478: astore_0
    //   479: aload_0
    //   480: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   483: goto -24 -> 459
    //   486: astore_0
    //   487: aload_0
    //   488: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   491: goto -22 -> 469
    //   494: astore_0
    //   495: aconst_null
    //   496: astore 4
    //   498: aload 4
    //   500: ifnull +8 -> 508
    //   503: aload 4
    //   505: invokevirtual 80	java/io/FileInputStream:close	()V
    //   508: aload_3
    //   509: ifnull +7 -> 516
    //   512: aload_3
    //   513: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   516: aload 10
    //   518: invokevirtual 70	java/io/File:delete	()Z
    //   521: pop
    //   522: aload_0
    //   523: athrow
    //   524: astore_1
    //   525: aload_1
    //   526: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   529: goto -21 -> 508
    //   532: astore_1
    //   533: aload_1
    //   534: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   537: goto -21 -> 516
    //   540: astore_1
    //   541: aload_1
    //   542: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   545: goto -310 -> 235
    //   548: astore_0
    //   549: aload_0
    //   550: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   553: goto -314 -> 239
    //   556: astore_0
    //   557: goto -59 -> 498
    //   560: astore 4
    //   562: aload_0
    //   563: astore_3
    //   564: aload 4
    //   566: astore_0
    //   567: aload_1
    //   568: astore 4
    //   570: goto -72 -> 498
    //   573: astore_0
    //   574: goto -133 -> 441
    //   577: astore_0
    //   578: goto -193 -> 385
    //   581: astore_3
    //   582: aconst_null
    //   583: astore_0
    //   584: aload 4
    //   586: astore_1
    //   587: goto -250 -> 337
    //   590: astore_3
    //   591: aconst_null
    //   592: astore_0
    //   593: goto -256 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	paramContext	Context
    //   0	596	1	paramString	String
    //   225	105	2	i	int
    //   7	309	3	localObject1	Object
    //   336	2	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   387	177	3	localObject2	Object
    //   581	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   590	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   18	486	4	str1	String
    //   560	5	4	localObject3	Object
    //   568	17	4	str2	String
    //   4	461	5	localObject4	Object
    //   1	408	6	localObject5	Object
    //   9	318	7	arrayOfByte	byte[]
    //   12	283	8	localObject6	Object
    //   15	284	9	localObject7	Object
    //   28	489	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   181	190	336	java/io/FileNotFoundException
    //   201	208	336	java/io/FileNotFoundException
    //   219	226	336	java/io/FileNotFoundException
    //   325	333	336	java/io/FileNotFoundException
    //   345	349	366	java/io/IOException
    //   353	357	374	java/io/IOException
    //   40	50	382	java/io/IOException
    //   399	403	422	java/io/IOException
    //   408	413	430	java/io/IOException
    //   40	50	438	java/lang/Exception
    //   455	459	478	java/io/IOException
    //   464	469	486	java/io/IOException
    //   40	50	494	finally
    //   503	508	524	java/io/IOException
    //   512	516	532	java/io/IOException
    //   231	235	540	java/io/IOException
    //   235	239	548	java/io/IOException
    //   64	107	556	finally
    //   121	128	556	finally
    //   142	147	556	finally
    //   161	170	556	finally
    //   181	190	556	finally
    //   201	208	556	finally
    //   219	226	556	finally
    //   261	269	556	finally
    //   283	288	556	finally
    //   302	311	556	finally
    //   325	333	556	finally
    //   391	395	556	finally
    //   447	451	556	finally
    //   337	341	560	finally
    //   64	107	573	java/lang/Exception
    //   121	128	573	java/lang/Exception
    //   142	147	573	java/lang/Exception
    //   161	170	573	java/lang/Exception
    //   181	190	573	java/lang/Exception
    //   201	208	573	java/lang/Exception
    //   219	226	573	java/lang/Exception
    //   261	269	573	java/lang/Exception
    //   283	288	573	java/lang/Exception
    //   302	311	573	java/lang/Exception
    //   325	333	573	java/lang/Exception
    //   64	107	577	java/io/IOException
    //   121	128	577	java/io/IOException
    //   142	147	577	java/io/IOException
    //   161	170	577	java/io/IOException
    //   181	190	577	java/io/IOException
    //   201	208	577	java/io/IOException
    //   219	226	577	java/io/IOException
    //   261	269	577	java/io/IOException
    //   283	288	577	java/io/IOException
    //   302	311	577	java/io/IOException
    //   325	333	577	java/io/IOException
    //   40	50	581	java/io/FileNotFoundException
    //   64	107	590	java/io/FileNotFoundException
    //   121	128	590	java/io/FileNotFoundException
    //   142	147	590	java/io/FileNotFoundException
    //   161	170	590	java/io/FileNotFoundException
    //   261	269	590	java/io/FileNotFoundException
    //   283	288	590	java/io/FileNotFoundException
    //   302	311	590	java/io/FileNotFoundException
  }
  
  public static int a(Context paramContext, String paramString, boolean paramBoolean)
  {
    z localz = new z(paramContext);
    localz.f = paramContext.getCacheDir().getAbsolutePath();
    localz.g = "qqsecure.info";
    localz.e = null;
    while (localz.a(paramString) == -7) {}
    paramString = paramContext.getCacheDir().getAbsolutePath() + "/qqsecure.info";
    int i = a(paramString);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = a(paramContext, paramString);
      i = j;
    } while (j != 0);
    if (paramBoolean) {
      new Thread(new ao()).start();
    }
    return 0;
  }
  
  /* Error */
  private static int a(String paramString)
  {
    // Byte code:
    //   0: new 23	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 30	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: iconst_m1
    //   17: ireturn
    //   18: new 32	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_3
    //   27: aload_3
    //   28: astore_0
    //   29: aload_3
    //   30: invokevirtual 145	java/io/FileInputStream:read	()I
    //   33: pop
    //   34: aload_3
    //   35: astore_0
    //   36: aload_3
    //   37: iconst_4
    //   38: newarray byte
    //   40: invokevirtual 77	java/io/FileInputStream:read	([B)I
    //   43: pop
    //   44: aload_3
    //   45: astore_0
    //   46: bipush 16
    //   48: newarray byte
    //   50: astore 4
    //   52: aload_3
    //   53: astore_0
    //   54: aload_3
    //   55: aload 4
    //   57: invokevirtual 77	java/io/FileInputStream:read	([B)I
    //   60: bipush 16
    //   62: if_icmpne +179 -> 241
    //   65: aload_3
    //   66: astore_0
    //   67: new 147	java/io/ByteArrayOutputStream
    //   70: dup
    //   71: invokespecial 148	java/io/ByteArrayOutputStream:<init>	()V
    //   74: astore 5
    //   76: aload_3
    //   77: astore_0
    //   78: sipush 1024
    //   81: newarray byte
    //   83: astore 6
    //   85: aload_3
    //   86: astore_0
    //   87: aload_3
    //   88: aload 6
    //   90: invokevirtual 77	java/io/FileInputStream:read	([B)I
    //   93: istore_1
    //   94: iload_1
    //   95: iconst_m1
    //   96: if_icmpne +42 -> 138
    //   99: aload_3
    //   100: astore_0
    //   101: aload 5
    //   103: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   106: invokestatic 158	com/tencent/securemodule/ac$a:b	([B)[B
    //   109: astore 6
    //   111: aload_3
    //   112: astore_0
    //   113: aload 5
    //   115: invokevirtual 159	java/io/ByteArrayOutputStream:close	()V
    //   118: aload_3
    //   119: astore_0
    //   120: aload 6
    //   122: aload 4
    //   124: invokestatic 165	java/util/Arrays:equals	([B[B)Z
    //   127: istore_2
    //   128: iload_2
    //   129: ifeq +112 -> 241
    //   132: aload_3
    //   133: invokevirtual 80	java/io/FileInputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: aload_3
    //   139: astore_0
    //   140: aload 5
    //   142: aload 6
    //   144: iconst_0
    //   145: iload_1
    //   146: invokevirtual 166	java/io/ByteArrayOutputStream:write	([BII)V
    //   149: goto -64 -> 85
    //   152: astore 4
    //   154: aload_3
    //   155: astore_0
    //   156: aload 4
    //   158: astore_3
    //   159: aload_3
    //   160: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   163: aload_0
    //   164: ifnull +7 -> 171
    //   167: aload_0
    //   168: invokevirtual 80	java/io/FileInputStream:close	()V
    //   171: bipush 254
    //   173: ireturn
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   179: goto -43 -> 136
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   187: goto -16 -> 171
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: astore_0
    //   196: aload 4
    //   198: invokevirtual 99	java/lang/Exception:printStackTrace	()V
    //   201: aload_3
    //   202: ifnull -31 -> 171
    //   205: aload_3
    //   206: invokevirtual 80	java/io/FileInputStream:close	()V
    //   209: goto -38 -> 171
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   217: goto -46 -> 171
    //   220: astore_3
    //   221: aconst_null
    //   222: astore_0
    //   223: aload_0
    //   224: ifnull +7 -> 231
    //   227: aload_0
    //   228: invokevirtual 80	java/io/FileInputStream:close	()V
    //   231: aload_3
    //   232: athrow
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   238: goto -7 -> 231
    //   241: aload_3
    //   242: invokevirtual 80	java/io/FileInputStream:close	()V
    //   245: goto -74 -> 171
    //   248: astore_0
    //   249: aload_0
    //   250: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   253: goto -82 -> 171
    //   256: astore_3
    //   257: goto -34 -> 223
    //   260: astore_3
    //   261: goto -38 -> 223
    //   264: astore 4
    //   266: goto -72 -> 194
    //   269: astore_3
    //   270: aconst_null
    //   271: astore_0
    //   272: goto -113 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramString	String
    //   93	53	1	i	int
    //   127	2	2	bool	boolean
    //   26	180	3	localObject1	Object
    //   220	22	3	localObject2	Object
    //   256	1	3	localObject3	Object
    //   260	1	3	localObject4	Object
    //   269	1	3	localIOException1	java.io.IOException
    //   50	73	4	arrayOfByte1	byte[]
    //   152	5	4	localIOException2	java.io.IOException
    //   190	7	4	localException1	java.lang.Exception
    //   264	1	4	localException2	java.lang.Exception
    //   74	67	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   83	60	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   29	34	152	java/io/IOException
    //   36	44	152	java/io/IOException
    //   46	52	152	java/io/IOException
    //   54	65	152	java/io/IOException
    //   67	76	152	java/io/IOException
    //   78	85	152	java/io/IOException
    //   87	94	152	java/io/IOException
    //   101	111	152	java/io/IOException
    //   113	118	152	java/io/IOException
    //   120	128	152	java/io/IOException
    //   140	149	152	java/io/IOException
    //   132	136	174	java/io/IOException
    //   167	171	182	java/io/IOException
    //   18	27	190	java/lang/Exception
    //   205	209	212	java/io/IOException
    //   18	27	220	finally
    //   227	231	233	java/io/IOException
    //   241	245	248	java/io/IOException
    //   29	34	256	finally
    //   36	44	256	finally
    //   46	52	256	finally
    //   54	65	256	finally
    //   67	76	256	finally
    //   78	85	256	finally
    //   87	94	256	finally
    //   101	111	256	finally
    //   113	118	256	finally
    //   120	128	256	finally
    //   140	149	256	finally
    //   196	201	256	finally
    //   159	163	260	finally
    //   29	34	264	java/lang/Exception
    //   36	44	264	java/lang/Exception
    //   46	52	264	java/lang/Exception
    //   54	65	264	java/lang/Exception
    //   67	76	264	java/lang/Exception
    //   78	85	264	java/lang/Exception
    //   87	94	264	java/lang/Exception
    //   101	111	264	java/lang/Exception
    //   113	118	264	java/lang/Exception
    //   120	128	264	java/lang/Exception
    //   140	149	264	java/lang/Exception
    //   18	27	269	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.ad
 * JD-Core Version:    0.7.0.1
 */