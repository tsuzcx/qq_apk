package wf7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;

public class gm
  extends gl
{
  private Context mContext;
  private String so;
  private String sp;
  private String sq;
  private boolean sr = false;
  private long ss = 0L;
  private long st = 0L;
  private boolean su = false;
  
  public gm(Context paramContext)
  {
    this.mContext = paramContext;
    this.so = paramContext.getCacheDir().getAbsolutePath();
    this.sp = paramContext.getFilesDir().getAbsolutePath();
  }
  
  /* Error */
  private int a(String paramString, int paramInt, java.io.InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iload_2
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: sipush 8192
    //   12: newarray byte
    //   14: astore 14
    //   16: new 59	android/os/Bundle
    //   19: dup
    //   20: invokespecial 60	android/os/Bundle:<init>	()V
    //   23: astore 15
    //   25: new 39	java/io/File
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 67	java/io/File:exists	()Z
    //   38: ifne +16 -> 54
    //   41: aload_1
    //   42: invokevirtual 70	java/io/File:getParentFile	()Ljava/io/File;
    //   45: invokevirtual 73	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 76	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: new 78	java/io/FileOutputStream
    //   57: dup
    //   58: aload_1
    //   59: iconst_1
    //   60: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   63: astore 10
    //   65: aload_3
    //   66: astore_1
    //   67: iload 4
    //   69: ifeq +24 -> 93
    //   72: aload_3
    //   73: astore 12
    //   75: aload_3
    //   76: astore 13
    //   78: aload_3
    //   79: astore 11
    //   81: new 83	java/util/zip/InflaterInputStream
    //   84: dup
    //   85: aload_3
    //   86: invokespecial 86	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   89: astore_1
    //   90: goto +3 -> 93
    //   93: iload_2
    //   94: ifle +503 -> 597
    //   97: aload_1
    //   98: astore 12
    //   100: aload_1
    //   101: astore 13
    //   103: aload_1
    //   104: astore 11
    //   106: aload_0
    //   107: iload_2
    //   108: i2l
    //   109: aload_0
    //   110: getfield 25	wf7/gm:ss	J
    //   113: ladd
    //   114: putfield 27	wf7/gm:st	J
    //   117: aload_1
    //   118: astore 12
    //   120: aload_1
    //   121: astore 13
    //   123: aload_1
    //   124: astore 11
    //   126: aload_0
    //   127: getfield 25	wf7/gm:ss	J
    //   130: ldc2_w 87
    //   133: lmul
    //   134: aload_0
    //   135: getfield 27	wf7/gm:st	J
    //   138: ldiv
    //   139: l2i
    //   140: istore 5
    //   142: iconst_0
    //   143: istore 6
    //   145: goto +3 -> 148
    //   148: aload_1
    //   149: astore 12
    //   151: aload_1
    //   152: astore 13
    //   154: aload_1
    //   155: astore 11
    //   157: aload_1
    //   158: aload 14
    //   160: invokevirtual 94	java/io/InputStream:read	([B)I
    //   163: istore 8
    //   165: iload 8
    //   167: iconst_m1
    //   168: if_icmpeq +190 -> 358
    //   171: aload_1
    //   172: astore 12
    //   174: aload_1
    //   175: astore 13
    //   177: aload_1
    //   178: astore 11
    //   180: aload_0
    //   181: getfield 23	wf7/gm:sr	Z
    //   184: istore 4
    //   186: iload 4
    //   188: ifeq +20 -> 208
    //   191: aload_1
    //   192: ifnull +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 97	java/io/InputStream:close	()V
    //   199: aload 10
    //   201: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   204: sipush -5003
    //   207: ireturn
    //   208: aload_1
    //   209: astore 12
    //   211: aload_1
    //   212: astore 13
    //   214: aload_1
    //   215: astore 11
    //   217: aload 10
    //   219: aload 14
    //   221: iconst_0
    //   222: iload 8
    //   224: invokevirtual 102	java/io/FileOutputStream:write	([BII)V
    //   227: aload_1
    //   228: astore 12
    //   230: aload_1
    //   231: astore 13
    //   233: aload_1
    //   234: astore 11
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 25	wf7/gm:ss	J
    //   241: iload 8
    //   243: i2l
    //   244: ladd
    //   245: putfield 25	wf7/gm:ss	J
    //   248: iload 6
    //   250: iload 8
    //   252: iadd
    //   253: istore 8
    //   255: iload 8
    //   257: istore 6
    //   259: aload_1
    //   260: astore 12
    //   262: aload_1
    //   263: astore 13
    //   265: aload_1
    //   266: astore 11
    //   268: aload_0
    //   269: getfield 27	wf7/gm:st	J
    //   272: lconst_0
    //   273: lcmp
    //   274: ifle -126 -> 148
    //   277: aload_1
    //   278: astore 12
    //   280: aload_1
    //   281: astore 13
    //   283: aload_1
    //   284: astore 11
    //   286: aload_0
    //   287: getfield 25	wf7/gm:ss	J
    //   290: ldc2_w 87
    //   293: lmul
    //   294: aload_0
    //   295: getfield 27	wf7/gm:st	J
    //   298: ldiv
    //   299: l2i
    //   300: istore 9
    //   302: iload 8
    //   304: istore 6
    //   306: iload 9
    //   308: iload 5
    //   310: if_icmpeq -162 -> 148
    //   313: aload_1
    //   314: astore 12
    //   316: aload_1
    //   317: astore 13
    //   319: aload_1
    //   320: astore 11
    //   322: aload 15
    //   324: ldc 104
    //   326: iload 9
    //   328: invokevirtual 108	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   331: aload_1
    //   332: astore 12
    //   334: aload_1
    //   335: astore 13
    //   337: aload_1
    //   338: astore 11
    //   340: aload_0
    //   341: iconst_2
    //   342: aload 15
    //   344: invokevirtual 111	wf7/gm:a	(ILandroid/os/Bundle;)V
    //   347: iload 9
    //   349: istore 5
    //   351: iload 8
    //   353: istore 6
    //   355: goto -207 -> 148
    //   358: aload_1
    //   359: astore 12
    //   361: aload_1
    //   362: astore 13
    //   364: aload_1
    //   365: astore 11
    //   367: aload 10
    //   369: invokevirtual 114	java/io/FileOutputStream:flush	()V
    //   372: iload 7
    //   374: istore 5
    //   376: iload_2
    //   377: ifle +20 -> 397
    //   380: iload 6
    //   382: iload_2
    //   383: if_icmpne +10 -> 393
    //   386: iload 7
    //   388: istore 5
    //   390: goto +7 -> 397
    //   393: bipush 249
    //   395: istore 5
    //   397: iload 5
    //   399: istore_2
    //   400: aload 10
    //   402: astore_3
    //   403: aload_1
    //   404: ifnull +13 -> 417
    //   407: aload_1
    //   408: invokevirtual 97	java/io/InputStream:close	()V
    //   411: aload 10
    //   413: astore_3
    //   414: iload 5
    //   416: istore_2
    //   417: aload_3
    //   418: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   421: iload_2
    //   422: ireturn
    //   423: astore_1
    //   424: aconst_null
    //   425: astore 10
    //   427: aload_3
    //   428: ifnull +10 -> 438
    //   431: aload_3
    //   432: invokevirtual 97	java/io/InputStream:close	()V
    //   435: goto +3 -> 438
    //   438: aload 10
    //   440: ifnull +8 -> 448
    //   443: aload 10
    //   445: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   448: aload_1
    //   449: athrow
    //   450: aconst_null
    //   451: astore 10
    //   453: sipush -5000
    //   456: istore 5
    //   458: aload_3
    //   459: ifnull +10 -> 469
    //   462: aload_3
    //   463: invokevirtual 97	java/io/InputStream:close	()V
    //   466: goto +3 -> 469
    //   469: iload 5
    //   471: istore_2
    //   472: aload 10
    //   474: ifnull +48 -> 522
    //   477: iload 5
    //   479: istore_2
    //   480: aload 10
    //   482: astore_3
    //   483: goto -66 -> 417
    //   486: aconst_null
    //   487: astore 10
    //   489: sipush -5056
    //   492: istore 5
    //   494: aload_3
    //   495: ifnull +10 -> 505
    //   498: aload_3
    //   499: invokevirtual 97	java/io/InputStream:close	()V
    //   502: goto +3 -> 505
    //   505: iload 5
    //   507: istore_2
    //   508: aload 10
    //   510: ifnull +12 -> 522
    //   513: iload 5
    //   515: istore_2
    //   516: aload 10
    //   518: astore_3
    //   519: goto -102 -> 417
    //   522: iload_2
    //   523: ireturn
    //   524: astore_1
    //   525: goto -39 -> 486
    //   528: astore_1
    //   529: goto -79 -> 450
    //   532: astore_1
    //   533: goto +58 -> 591
    //   536: astore_1
    //   537: goto +48 -> 585
    //   540: astore_1
    //   541: goto -342 -> 199
    //   544: astore_1
    //   545: sipush -5003
    //   548: ireturn
    //   549: astore_1
    //   550: iload 5
    //   552: istore_2
    //   553: aload 10
    //   555: astore_3
    //   556: goto -139 -> 417
    //   559: astore_1
    //   560: iload_2
    //   561: ireturn
    //   562: astore_3
    //   563: goto -125 -> 438
    //   566: astore_3
    //   567: goto -119 -> 448
    //   570: astore_1
    //   571: goto -102 -> 469
    //   574: astore_1
    //   575: goto -70 -> 505
    //   578: astore_1
    //   579: aload 11
    //   581: astore_3
    //   582: goto -155 -> 427
    //   585: aload 13
    //   587: astore_3
    //   588: goto -135 -> 453
    //   591: aload 12
    //   593: astore_3
    //   594: goto -105 -> 489
    //   597: iconst_0
    //   598: istore 6
    //   600: iconst_0
    //   601: istore 5
    //   603: goto -455 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	gm
    //   0	606	1	paramString	String
    //   0	606	2	paramInt	int
    //   0	606	3	paramInputStream	java.io.InputStream
    //   0	606	4	paramBoolean	boolean
    //   140	462	5	i	int
    //   143	456	6	j	int
    //   1	386	7	k	int
    //   163	189	8	m	int
    //   300	48	9	n	int
    //   63	491	10	localFileOutputStream	java.io.FileOutputStream
    //   79	501	11	localObject1	Object
    //   73	519	12	localObject2	Object
    //   76	510	13	localObject3	Object
    //   14	206	14	arrayOfByte	byte[]
    //   23	320	15	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   25	54	423	finally
    //   54	65	423	finally
    //   25	54	524	java/io/IOException
    //   54	65	524	java/io/IOException
    //   25	54	528	java/lang/Exception
    //   54	65	528	java/lang/Exception
    //   81	90	532	java/io/IOException
    //   106	117	532	java/io/IOException
    //   126	142	532	java/io/IOException
    //   157	165	532	java/io/IOException
    //   180	186	532	java/io/IOException
    //   217	227	532	java/io/IOException
    //   236	248	532	java/io/IOException
    //   268	277	532	java/io/IOException
    //   286	302	532	java/io/IOException
    //   322	331	532	java/io/IOException
    //   340	347	532	java/io/IOException
    //   367	372	532	java/io/IOException
    //   81	90	536	java/lang/Exception
    //   106	117	536	java/lang/Exception
    //   126	142	536	java/lang/Exception
    //   157	165	536	java/lang/Exception
    //   180	186	536	java/lang/Exception
    //   217	227	536	java/lang/Exception
    //   236	248	536	java/lang/Exception
    //   268	277	536	java/lang/Exception
    //   286	302	536	java/lang/Exception
    //   322	331	536	java/lang/Exception
    //   340	347	536	java/lang/Exception
    //   367	372	536	java/lang/Exception
    //   195	199	540	java/lang/Exception
    //   199	204	544	java/lang/Exception
    //   407	411	549	java/lang/Exception
    //   417	421	559	java/lang/Exception
    //   431	435	562	java/lang/Exception
    //   443	448	566	java/lang/Exception
    //   462	466	570	java/lang/Exception
    //   498	502	574	java/lang/Exception
    //   81	90	578	finally
    //   106	117	578	finally
    //   126	142	578	finally
    //   157	165	578	finally
    //   180	186	578	finally
    //   217	227	578	finally
    //   236	248	578	finally
    //   268	277	578	finally
    //   286	302	578	finally
    //   322	331	578	finally
    //   340	347	578	finally
    //   367	372	578	finally
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 39	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 10
    //   10: new 39	java/io/File
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: sipush -7001
    //   22: istore 5
    //   24: aconst_null
    //   25: astore 6
    //   27: aconst_null
    //   28: astore 7
    //   30: aconst_null
    //   31: astore 8
    //   33: aconst_null
    //   34: astore 9
    //   36: aconst_null
    //   37: astore_1
    //   38: aload 10
    //   40: invokevirtual 67	java/io/File:exists	()Z
    //   43: ifeq +207 -> 250
    //   46: aload_0
    //   47: getfield 31	wf7/gm:mContext	Landroid/content/Context;
    //   50: invokevirtual 48	android/content/Context:getFilesDir	()Ljava/io/File;
    //   53: invokevirtual 43	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: aload_0
    //   57: getfield 50	wf7/gm:sp	Ljava/lang/String;
    //   60: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +38 -> 101
    //   66: aload_0
    //   67: getfield 31	wf7/gm:mContext	Landroid/content/Context;
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 125	wf7/gm:sq	Ljava/lang/String;
    //   75: astore_2
    //   76: getstatic 131	android/os/Build$VERSION:SDK_INT	I
    //   79: bipush 24
    //   81: if_icmplt +512 -> 593
    //   84: iconst_0
    //   85: istore 4
    //   87: goto +3 -> 90
    //   90: aload_1
    //   91: aload_2
    //   92: iload 4
    //   94: invokevirtual 135	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   97: astore_1
    //   98: goto +49 -> 147
    //   101: aload_2
    //   102: invokevirtual 67	java/io/File:exists	()Z
    //   105: ifeq +20 -> 125
    //   108: aload_2
    //   109: invokevirtual 138	java/io/File:delete	()Z
    //   112: pop
    //   113: new 78	java/io/FileOutputStream
    //   116: dup
    //   117: aload_2
    //   118: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_1
    //   122: goto +25 -> 147
    //   125: aload_2
    //   126: invokevirtual 70	java/io/File:getParentFile	()Ljava/io/File;
    //   129: invokevirtual 73	java/io/File:mkdirs	()Z
    //   132: pop
    //   133: aload_2
    //   134: invokevirtual 76	java/io/File:createNewFile	()Z
    //   137: pop
    //   138: new 78	java/io/FileOutputStream
    //   141: dup
    //   142: aload_2
    //   143: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   146: astore_1
    //   147: new 143	java/io/FileInputStream
    //   150: dup
    //   151: aload 10
    //   153: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   156: astore_2
    //   157: sipush 8192
    //   160: newarray byte
    //   162: astore 6
    //   164: aload_2
    //   165: aload 6
    //   167: invokevirtual 145	java/io/FileInputStream:read	([B)I
    //   170: istore 4
    //   172: iload 4
    //   174: iconst_m1
    //   175: if_icmpeq +15 -> 190
    //   178: aload_1
    //   179: aload 6
    //   181: iconst_0
    //   182: iload 4
    //   184: invokevirtual 102	java/io/FileOutputStream:write	([BII)V
    //   187: goto -23 -> 164
    //   190: aload_1
    //   191: invokevirtual 114	java/io/FileOutputStream:flush	()V
    //   194: iconst_0
    //   195: istore 5
    //   197: goto +55 -> 252
    //   200: astore 7
    //   202: aload_2
    //   203: astore 6
    //   205: aload_1
    //   206: astore_2
    //   207: aload 7
    //   209: astore_1
    //   210: goto +96 -> 306
    //   213: goto +142 -> 355
    //   216: goto +194 -> 410
    //   219: goto +246 -> 465
    //   222: astore 7
    //   224: aload_1
    //   225: astore_2
    //   226: aload 7
    //   228: astore_1
    //   229: goto +77 -> 306
    //   232: aload 7
    //   234: astore_2
    //   235: goto +120 -> 355
    //   238: aload 8
    //   240: astore_2
    //   241: goto +169 -> 410
    //   244: aload 9
    //   246: astore_2
    //   247: goto +218 -> 465
    //   250: aconst_null
    //   251: astore_2
    //   252: aload_2
    //   253: ifnull +10 -> 263
    //   256: aload_2
    //   257: invokevirtual 146	java/io/FileInputStream:close	()V
    //   260: goto +3 -> 263
    //   263: aload_1
    //   264: ifnull +10 -> 274
    //   267: aload_1
    //   268: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   271: goto +3 -> 274
    //   274: iload 5
    //   276: istore 4
    //   278: iload_3
    //   279: ifeq +231 -> 510
    //   282: iload 5
    //   284: istore 4
    //   286: aload 10
    //   288: invokevirtual 67	java/io/File:exists	()Z
    //   291: ifeq +219 -> 510
    //   294: aload 10
    //   296: invokevirtual 138	java/io/File:delete	()Z
    //   299: pop
    //   300: iload 5
    //   302: ireturn
    //   303: astore_1
    //   304: aconst_null
    //   305: astore_2
    //   306: aload 6
    //   308: ifnull +11 -> 319
    //   311: aload 6
    //   313: invokevirtual 146	java/io/FileInputStream:close	()V
    //   316: goto +3 -> 319
    //   319: aload_2
    //   320: ifnull +10 -> 330
    //   323: aload_2
    //   324: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   327: goto +3 -> 330
    //   330: iload_3
    //   331: ifeq +17 -> 348
    //   334: aload 10
    //   336: invokevirtual 67	java/io/File:exists	()Z
    //   339: ifeq +9 -> 348
    //   342: aload 10
    //   344: invokevirtual 138	java/io/File:delete	()Z
    //   347: pop
    //   348: aload_1
    //   349: athrow
    //   350: aconst_null
    //   351: astore_1
    //   352: aload 7
    //   354: astore_2
    //   355: sipush -7000
    //   358: istore 5
    //   360: aload_2
    //   361: ifnull +10 -> 371
    //   364: aload_2
    //   365: invokevirtual 146	java/io/FileInputStream:close	()V
    //   368: goto +3 -> 371
    //   371: aload_1
    //   372: ifnull +10 -> 382
    //   375: aload_1
    //   376: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   379: goto +3 -> 382
    //   382: iload 5
    //   384: istore 4
    //   386: iload_3
    //   387: ifeq +123 -> 510
    //   390: iload 5
    //   392: istore 4
    //   394: aload 10
    //   396: invokevirtual 67	java/io/File:exists	()Z
    //   399: ifeq +111 -> 510
    //   402: goto -108 -> 294
    //   405: aconst_null
    //   406: astore_1
    //   407: aload 8
    //   409: astore_2
    //   410: sipush -7056
    //   413: istore 5
    //   415: aload_2
    //   416: ifnull +10 -> 426
    //   419: aload_2
    //   420: invokevirtual 146	java/io/FileInputStream:close	()V
    //   423: goto +3 -> 426
    //   426: aload_1
    //   427: ifnull +10 -> 437
    //   430: aload_1
    //   431: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   434: goto +3 -> 437
    //   437: iload 5
    //   439: istore 4
    //   441: iload_3
    //   442: ifeq +68 -> 510
    //   445: iload 5
    //   447: istore 4
    //   449: aload 10
    //   451: invokevirtual 67	java/io/File:exists	()Z
    //   454: ifeq +56 -> 510
    //   457: goto -163 -> 294
    //   460: aconst_null
    //   461: astore_1
    //   462: aload 9
    //   464: astore_2
    //   465: aload_2
    //   466: ifnull +10 -> 476
    //   469: aload_2
    //   470: invokevirtual 146	java/io/FileInputStream:close	()V
    //   473: goto +3 -> 476
    //   476: aload_1
    //   477: ifnull +10 -> 487
    //   480: aload_1
    //   481: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   484: goto +3 -> 487
    //   487: iload 5
    //   489: istore 4
    //   491: iload_3
    //   492: ifeq +18 -> 510
    //   495: iload 5
    //   497: istore 4
    //   499: aload 10
    //   501: invokevirtual 67	java/io/File:exists	()Z
    //   504: ifeq +6 -> 510
    //   507: goto -213 -> 294
    //   510: iload 4
    //   512: ireturn
    //   513: astore_1
    //   514: goto -54 -> 460
    //   517: astore_1
    //   518: goto -113 -> 405
    //   521: astore_1
    //   522: goto -172 -> 350
    //   525: astore_2
    //   526: goto -282 -> 244
    //   529: astore_2
    //   530: goto -292 -> 238
    //   533: astore_2
    //   534: goto -302 -> 232
    //   537: astore 6
    //   539: goto -320 -> 219
    //   542: astore 6
    //   544: goto -328 -> 216
    //   547: astore 6
    //   549: goto -336 -> 213
    //   552: astore_2
    //   553: goto -290 -> 263
    //   556: astore_1
    //   557: goto -283 -> 274
    //   560: astore 6
    //   562: goto -243 -> 319
    //   565: astore_2
    //   566: goto -236 -> 330
    //   569: astore_2
    //   570: goto -199 -> 371
    //   573: astore_1
    //   574: goto -192 -> 382
    //   577: astore_2
    //   578: goto -152 -> 426
    //   581: astore_1
    //   582: goto -145 -> 437
    //   585: astore_2
    //   586: goto -110 -> 476
    //   589: astore_1
    //   590: goto -103 -> 487
    //   593: iconst_1
    //   594: istore 4
    //   596: goto -506 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	599	0	this	gm
    //   0	599	1	paramString1	String
    //   0	599	2	paramString2	String
    //   0	599	3	paramBoolean	boolean
    //   85	510	4	i	int
    //   22	474	5	j	int
    //   25	287	6	localObject1	Object
    //   537	1	6	localFileNotFoundException	java.io.FileNotFoundException
    //   542	1	6	localIOException	IOException
    //   547	1	6	localException1	java.lang.Exception
    //   560	1	6	localException2	java.lang.Exception
    //   28	1	7	localObject2	Object
    //   200	8	7	localObject3	Object
    //   222	131	7	localObject4	Object
    //   31	377	8	localObject5	Object
    //   34	429	9	localObject6	Object
    //   8	492	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   157	164	200	finally
    //   164	172	200	finally
    //   178	187	200	finally
    //   190	194	200	finally
    //   147	157	222	finally
    //   38	84	303	finally
    //   90	98	303	finally
    //   101	122	303	finally
    //   125	147	303	finally
    //   38	84	513	java/io/FileNotFoundException
    //   90	98	513	java/io/FileNotFoundException
    //   101	122	513	java/io/FileNotFoundException
    //   125	147	513	java/io/FileNotFoundException
    //   38	84	517	java/io/IOException
    //   90	98	517	java/io/IOException
    //   101	122	517	java/io/IOException
    //   125	147	517	java/io/IOException
    //   38	84	521	java/lang/Exception
    //   90	98	521	java/lang/Exception
    //   101	122	521	java/lang/Exception
    //   125	147	521	java/lang/Exception
    //   147	157	525	java/io/FileNotFoundException
    //   147	157	529	java/io/IOException
    //   147	157	533	java/lang/Exception
    //   157	164	537	java/io/FileNotFoundException
    //   164	172	537	java/io/FileNotFoundException
    //   178	187	537	java/io/FileNotFoundException
    //   190	194	537	java/io/FileNotFoundException
    //   157	164	542	java/io/IOException
    //   164	172	542	java/io/IOException
    //   178	187	542	java/io/IOException
    //   190	194	542	java/io/IOException
    //   157	164	547	java/lang/Exception
    //   164	172	547	java/lang/Exception
    //   178	187	547	java/lang/Exception
    //   190	194	547	java/lang/Exception
    //   256	260	552	java/lang/Exception
    //   267	271	556	java/lang/Exception
    //   311	316	560	java/lang/Exception
    //   323	327	565	java/lang/Exception
    //   364	368	569	java/lang/Exception
    //   375	379	573	java/lang/Exception
    //   419	423	577	java/lang/Exception
    //   430	434	581	java/lang/Exception
    //   469	473	585	java/lang/Exception
    //   480	484	589	java/lang/Exception
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean, gm.a parama, int paramInt)
  {
    label778:
    label808:
    label815:
    for (;;)
    {
      int k;
      int j;
      try
      {
        k = gp.x(this.mContext);
        if (k == 0) {
          return -52;
        }
        if (!TextUtils.isEmpty(paramString1)) {
          localObject1 = paramString1;
        } else {
          localObject1 = gk.h(paramString2, null);
        }
        if (this.sq == null) {
          this.sq = ((String)localObject1);
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(".tmp");
        Object localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.so);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.sp);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(this.sq);
        String str = ((StringBuilder)localObject1).toString();
        File localFile = new File((String)localObject2);
        boolean bool = localFile.exists();
        i = 0;
        j = 0;
        if (bool)
        {
          this.su = true;
          this.ss = localFile.length();
        }
        else
        {
          this.su = false;
          this.ss = 0L;
        }
        localObject1 = new URL(paramString2);
        Object localObject3;
        if (3 == k)
        {
          localObject3 = gp.y(this.mContext);
          k = gp.z(this.mContext);
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (k > 0)) {
            localObject1 = (HttpURLConnection)((URL)localObject1).openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved((String)localObject3, k)));
          } else {
            localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
          }
        }
        else
        {
          localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
        }
        if (dk.bJ() < 8) {
          System.setProperty("http.keepAlive", "false");
        }
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        ((HttpURLConnection)localObject1).setReadTimeout(30000);
        ((HttpURLConnection)localObject1).setConnectTimeout(15000);
        if (this.ss > 0L)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("bytes=");
          ((StringBuilder)localObject3).append(this.ss);
          ((StringBuilder)localObject3).append("-");
          ((HttpURLConnection)localObject1).setRequestProperty("RANGE", ((StringBuilder)localObject3).toString());
        }
        k = ((HttpURLConnection)localObject1).getResponseCode();
        if (k != 200)
        {
          if (k != 206) {
            break label778;
          }
          continue;
          if ((i != 0) && (paramInt <= 1))
          {
            paramString2 = ((HttpURLConnection)localObject1).getHeaderField("Location");
            if (TextUtils.isEmpty(paramString2)) {
              break label808;
            }
            i = a(paramString1, paramString2, paramBoolean, parama, paramInt + 1);
            break label815;
          }
          if ((k != 416) || (!localFile.delete()) || (paramInt > 1)) {
            break label808;
          }
          i = a(paramString1, paramString2, paramBoolean, parama, paramInt + 1);
          continue;
        }
        paramString1 = ((HttpURLConnection)localObject1).getInputStream();
        j = a((String)localObject2, ((HttpURLConnection)localObject1).getContentLength(), paramString1, paramBoolean);
        if (j != 0)
        {
          i = j;
          break label815;
        }
        if ((parama != null) && (!parama.O((String)localObject2)))
        {
          i = -7000;
        }
        else
        {
          j = a((String)localObject2, str, true);
          if (j != 0)
          {
            i = j;
            break label815;
          }
        }
        paramString1 = "";
      }
      catch (Throwable paramString1)
      {
        i = -999;
        paramString1 = paramString1.getMessage();
      }
      catch (IOException paramString1)
      {
        i = -7056;
        paramString1 = paramString1.getMessage();
      }
      catch (MalformedURLException paramString1)
      {
        i = -1053;
        paramString1 = paramString1.getMessage();
      }
      if ((i != 0) && (i != -7) && (paramInt == 0))
      {
        paramString2 = new Bundle();
        paramString2.putInt("key_errcode", i);
        paramString2.putString("key_errorMsg", paramString1);
        paramString2.putInt("key_downSize", (int)this.ss);
        long l = this.st;
        if (l > 0L)
        {
          paramString2.putInt("key_total", (int)l);
          paramString2.putInt("key_sdcardstatus", gk.i(this.st - this.ss));
        }
        paramString2.putByte("key_downType", (byte)this.su);
        a(1, paramString2);
      }
      return i;
      int i = j;
      if (k >= 300)
      {
        i = j;
        if (k <= 305)
        {
          i = 1;
          continue;
          i = k;
        }
      }
    }
  }
  
  public void M(String paramString)
  {
    this.sp = paramString;
  }
  
  public void N(String paramString)
  {
    this.sq = paramString;
  }
  
  public int a(String paramString1, String paramString2, boolean paramBoolean, gm.a parama)
  {
    this.ss = 0L;
    this.st = 0L;
    this.su = false;
    this.sr = false;
    return a(paramString1, paramString2, paramBoolean, parama, 0);
  }
  
  public String eX()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.sp);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.sq);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.gm
 * JD-Core Version:    0.7.0.1
 */