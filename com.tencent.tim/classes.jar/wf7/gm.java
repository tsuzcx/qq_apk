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
    //   0: iload_2
    //   1: ifne +7 -> 8
    //   4: iconst_0
    //   5: istore_2
    //   6: iload_2
    //   7: ireturn
    //   8: sipush 8192
    //   11: newarray byte
    //   13: astore 12
    //   15: new 61	android/os/Bundle
    //   18: dup
    //   19: invokespecial 62	android/os/Bundle:<init>	()V
    //   22: astore 13
    //   24: new 42	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 69	java/io/File:exists	()Z
    //   37: ifne +16 -> 53
    //   40: aload_1
    //   41: invokevirtual 72	java/io/File:getParentFile	()Ljava/io/File;
    //   44: invokevirtual 75	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload_1
    //   49: invokevirtual 78	java/io/File:createNewFile	()Z
    //   52: pop
    //   53: new 80	java/io/FileOutputStream
    //   56: dup
    //   57: aload_1
    //   58: iconst_1
    //   59: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   62: astore 8
    //   64: aload_3
    //   65: astore_1
    //   66: iload 4
    //   68: ifeq +21 -> 89
    //   71: aload_3
    //   72: astore 9
    //   74: aload_3
    //   75: astore 11
    //   77: aload_3
    //   78: astore 10
    //   80: new 85	java/util/zip/InflaterInputStream
    //   83: dup
    //   84: aload_3
    //   85: invokespecial 88	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   88: astore_1
    //   89: iconst_0
    //   90: istore 7
    //   92: iconst_0
    //   93: istore 5
    //   95: iload 7
    //   97: istore 6
    //   99: iload_2
    //   100: ifle +52 -> 152
    //   103: aload_1
    //   104: astore 9
    //   106: aload_1
    //   107: astore 11
    //   109: aload_1
    //   110: astore 10
    //   112: aload_0
    //   113: iload_2
    //   114: i2l
    //   115: aload_0
    //   116: getfield 28	wf7/gm:ss	J
    //   119: ladd
    //   120: putfield 30	wf7/gm:st	J
    //   123: aload_1
    //   124: astore 9
    //   126: aload_1
    //   127: astore 11
    //   129: aload_1
    //   130: astore 10
    //   132: aload_0
    //   133: getfield 28	wf7/gm:ss	J
    //   136: ldc2_w 89
    //   139: lmul
    //   140: aload_0
    //   141: getfield 30	wf7/gm:st	J
    //   144: ldiv
    //   145: l2i
    //   146: istore 5
    //   148: iload 7
    //   150: istore 6
    //   152: aload_1
    //   153: astore 9
    //   155: aload_1
    //   156: astore 11
    //   158: aload_1
    //   159: astore 10
    //   161: aload_1
    //   162: aload 12
    //   164: invokevirtual 96	java/io/InputStream:read	([B)I
    //   167: istore 7
    //   169: iload 7
    //   171: iconst_m1
    //   172: if_icmpeq +192 -> 364
    //   175: aload_1
    //   176: astore 9
    //   178: aload_1
    //   179: astore 11
    //   181: aload_1
    //   182: astore 10
    //   184: aload_0
    //   185: getfield 26	wf7/gm:sr	Z
    //   188: istore 4
    //   190: iload 4
    //   192: ifeq +34 -> 226
    //   195: sipush -5003
    //   198: istore_2
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 99	java/io/InputStream:close	()V
    //   207: aload 8
    //   209: ifnull -203 -> 6
    //   212: aload 8
    //   214: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   217: sipush -5003
    //   220: ireturn
    //   221: astore_1
    //   222: sipush -5003
    //   225: ireturn
    //   226: aload_1
    //   227: astore 9
    //   229: aload_1
    //   230: astore 11
    //   232: aload_1
    //   233: astore 10
    //   235: aload 8
    //   237: aload 12
    //   239: iconst_0
    //   240: iload 7
    //   242: invokevirtual 104	java/io/FileOutputStream:write	([BII)V
    //   245: aload_1
    //   246: astore 9
    //   248: aload_1
    //   249: astore 11
    //   251: aload_1
    //   252: astore 10
    //   254: aload_0
    //   255: aload_0
    //   256: getfield 28	wf7/gm:ss	J
    //   259: iload 7
    //   261: i2l
    //   262: ladd
    //   263: putfield 28	wf7/gm:ss	J
    //   266: iload 7
    //   268: iload 6
    //   270: iadd
    //   271: istore 6
    //   273: aload_1
    //   274: astore 9
    //   276: aload_1
    //   277: astore 11
    //   279: aload_1
    //   280: astore 10
    //   282: aload_0
    //   283: getfield 30	wf7/gm:st	J
    //   286: lconst_0
    //   287: lcmp
    //   288: ifle +286 -> 574
    //   291: aload_1
    //   292: astore 9
    //   294: aload_1
    //   295: astore 11
    //   297: aload_1
    //   298: astore 10
    //   300: aload_0
    //   301: getfield 28	wf7/gm:ss	J
    //   304: ldc2_w 89
    //   307: lmul
    //   308: aload_0
    //   309: getfield 30	wf7/gm:st	J
    //   312: ldiv
    //   313: l2i
    //   314: istore 7
    //   316: iload 7
    //   318: iload 5
    //   320: if_icmpeq +251 -> 571
    //   323: aload_1
    //   324: astore 9
    //   326: aload_1
    //   327: astore 11
    //   329: aload_1
    //   330: astore 10
    //   332: aload 13
    //   334: ldc 106
    //   336: iload 7
    //   338: invokevirtual 110	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   341: aload_1
    //   342: astore 9
    //   344: aload_1
    //   345: astore 11
    //   347: aload_1
    //   348: astore 10
    //   350: aload_0
    //   351: iconst_2
    //   352: aload 13
    //   354: invokevirtual 113	wf7/gm:a	(ILandroid/os/Bundle;)V
    //   357: iload 7
    //   359: istore 5
    //   361: goto +216 -> 577
    //   364: aload_1
    //   365: astore 9
    //   367: aload_1
    //   368: astore 11
    //   370: aload_1
    //   371: astore 10
    //   373: aload 8
    //   375: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   378: iload_2
    //   379: ifle +47 -> 426
    //   382: iload 6
    //   384: iload_2
    //   385: if_icmpne +34 -> 419
    //   388: iconst_0
    //   389: istore 5
    //   391: aload_1
    //   392: ifnull +7 -> 399
    //   395: aload_1
    //   396: invokevirtual 99	java/io/InputStream:close	()V
    //   399: iload 5
    //   401: istore_2
    //   402: aload 8
    //   404: ifnull -398 -> 6
    //   407: aload 8
    //   409: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   412: iload 5
    //   414: ireturn
    //   415: astore_1
    //   416: iload 5
    //   418: ireturn
    //   419: bipush 249
    //   421: istore 5
    //   423: goto -32 -> 391
    //   426: iconst_0
    //   427: istore 5
    //   429: goto -38 -> 391
    //   432: astore_1
    //   433: aconst_null
    //   434: astore_1
    //   435: sipush -5056
    //   438: istore_2
    //   439: aload_3
    //   440: ifnull +7 -> 447
    //   443: aload_3
    //   444: invokevirtual 99	java/io/InputStream:close	()V
    //   447: aload_1
    //   448: ifnull -442 -> 6
    //   451: aload_1
    //   452: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   455: sipush -5056
    //   458: ireturn
    //   459: astore_1
    //   460: sipush -5056
    //   463: ireturn
    //   464: astore_1
    //   465: aconst_null
    //   466: astore 8
    //   468: sipush -5000
    //   471: istore_2
    //   472: aload_3
    //   473: ifnull +7 -> 480
    //   476: aload_3
    //   477: invokevirtual 99	java/io/InputStream:close	()V
    //   480: aload 8
    //   482: ifnull -476 -> 6
    //   485: aload 8
    //   487: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   490: sipush -5000
    //   493: ireturn
    //   494: astore_1
    //   495: sipush -5000
    //   498: ireturn
    //   499: astore_1
    //   500: aconst_null
    //   501: astore 8
    //   503: aload_3
    //   504: ifnull +7 -> 511
    //   507: aload_3
    //   508: invokevirtual 99	java/io/InputStream:close	()V
    //   511: aload 8
    //   513: ifnull +8 -> 521
    //   516: aload 8
    //   518: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   521: aload_1
    //   522: athrow
    //   523: astore_1
    //   524: goto -317 -> 207
    //   527: astore_1
    //   528: goto -129 -> 399
    //   531: astore_3
    //   532: goto -85 -> 447
    //   535: astore_1
    //   536: goto -56 -> 480
    //   539: astore_3
    //   540: goto -29 -> 511
    //   543: astore_3
    //   544: goto -23 -> 521
    //   547: astore_1
    //   548: aload 9
    //   550: astore_3
    //   551: goto -48 -> 503
    //   554: astore_1
    //   555: aload 11
    //   557: astore_3
    //   558: goto -90 -> 468
    //   561: astore_1
    //   562: aload 8
    //   564: astore_1
    //   565: aload 10
    //   567: astore_3
    //   568: goto -133 -> 435
    //   571: goto +6 -> 577
    //   574: goto -422 -> 152
    //   577: goto -425 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	this	gm
    //   0	580	1	paramString	String
    //   0	580	2	paramInt	int
    //   0	580	3	paramInputStream	java.io.InputStream
    //   0	580	4	paramBoolean	boolean
    //   93	335	5	i	int
    //   97	289	6	j	int
    //   90	268	7	k	int
    //   62	501	8	localFileOutputStream	java.io.FileOutputStream
    //   72	477	9	localObject1	Object
    //   78	488	10	localObject2	Object
    //   75	481	11	localObject3	Object
    //   13	225	12	arrayOfByte	byte[]
    //   22	331	13	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   212	217	221	java/lang/Exception
    //   407	412	415	java/lang/Exception
    //   24	53	432	java/io/IOException
    //   53	64	432	java/io/IOException
    //   451	455	459	java/lang/Exception
    //   24	53	464	java/lang/Exception
    //   53	64	464	java/lang/Exception
    //   485	490	494	java/lang/Exception
    //   24	53	499	finally
    //   53	64	499	finally
    //   203	207	523	java/lang/Exception
    //   395	399	527	java/lang/Exception
    //   443	447	531	java/lang/Exception
    //   476	480	535	java/lang/Exception
    //   507	511	539	java/lang/Exception
    //   516	521	543	java/lang/Exception
    //   80	89	547	finally
    //   112	123	547	finally
    //   132	148	547	finally
    //   161	169	547	finally
    //   184	190	547	finally
    //   235	245	547	finally
    //   254	266	547	finally
    //   282	291	547	finally
    //   300	316	547	finally
    //   332	341	547	finally
    //   350	357	547	finally
    //   373	378	547	finally
    //   80	89	554	java/lang/Exception
    //   112	123	554	java/lang/Exception
    //   132	148	554	java/lang/Exception
    //   161	169	554	java/lang/Exception
    //   184	190	554	java/lang/Exception
    //   235	245	554	java/lang/Exception
    //   254	266	554	java/lang/Exception
    //   282	291	554	java/lang/Exception
    //   300	316	554	java/lang/Exception
    //   332	341	554	java/lang/Exception
    //   350	357	554	java/lang/Exception
    //   373	378	554	java/lang/Exception
    //   80	89	561	java/io/IOException
    //   112	123	561	java/io/IOException
    //   132	148	561	java/io/IOException
    //   161	169	561	java/io/IOException
    //   184	190	561	java/io/IOException
    //   235	245	561	java/io/IOException
    //   254	266	561	java/io/IOException
    //   282	291	561	java/io/IOException
    //   300	316	561	java/io/IOException
    //   332	341	561	java/io/IOException
    //   350	357	561	java/io/IOException
    //   373	378	561	java/io/IOException
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: sipush -7001
    //   15: istore 5
    //   17: new 42	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 10
    //   27: new 42	java/io/File
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload 10
    //   38: invokevirtual 69	java/io/File:exists	()Z
    //   41: ifeq +337 -> 378
    //   44: aload_0
    //   45: getfield 34	wf7/gm:mContext	Landroid/content/Context;
    //   48: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
    //   51: invokevirtual 46	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 53	wf7/gm:sp	Ljava/lang/String;
    //   58: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifeq +141 -> 202
    //   64: aload_0
    //   65: getfield 34	wf7/gm:mContext	Landroid/content/Context;
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 127	wf7/gm:sq	Ljava/lang/String;
    //   73: astore_2
    //   74: getstatic 133	android/os/Build$VERSION:SDK_INT	I
    //   77: bipush 24
    //   79: if_icmplt +117 -> 196
    //   82: iconst_0
    //   83: istore 4
    //   85: aload_1
    //   86: aload_2
    //   87: iload 4
    //   89: invokevirtual 137	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   92: astore_1
    //   93: new 139	java/io/FileInputStream
    //   96: dup
    //   97: aload 10
    //   99: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: astore_2
    //   103: sipush 8192
    //   106: newarray byte
    //   108: astore 6
    //   110: aload_2
    //   111: aload 6
    //   113: invokevirtual 143	java/io/FileInputStream:read	([B)I
    //   116: istore 4
    //   118: iload 4
    //   120: iconst_m1
    //   121: if_icmpeq +196 -> 317
    //   124: aload_1
    //   125: aload 6
    //   127: iconst_0
    //   128: iload 4
    //   130: invokevirtual 104	java/io/FileOutputStream:write	([BII)V
    //   133: goto -23 -> 110
    //   136: astore 6
    //   138: aload_2
    //   139: ifnull +7 -> 146
    //   142: aload_2
    //   143: invokevirtual 144	java/io/FileInputStream:close	()V
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   154: iload 5
    //   156: istore 4
    //   158: iload_3
    //   159: ifeq +34 -> 193
    //   162: iload 5
    //   164: istore 4
    //   166: aload 10
    //   168: ifnull +25 -> 193
    //   171: iload 5
    //   173: istore 4
    //   175: aload 10
    //   177: invokevirtual 69	java/io/File:exists	()Z
    //   180: ifeq +13 -> 193
    //   183: aload 10
    //   185: invokevirtual 147	java/io/File:delete	()Z
    //   188: pop
    //   189: iload 5
    //   191: istore 4
    //   193: iload 4
    //   195: ireturn
    //   196: iconst_1
    //   197: istore 4
    //   199: goto -114 -> 85
    //   202: aload_1
    //   203: invokevirtual 69	java/io/File:exists	()Z
    //   206: ifeq +20 -> 226
    //   209: aload_1
    //   210: invokevirtual 147	java/io/File:delete	()Z
    //   213: pop
    //   214: new 80	java/io/FileOutputStream
    //   217: dup
    //   218: aload_1
    //   219: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   222: astore_1
    //   223: goto -130 -> 93
    //   226: aload_1
    //   227: invokevirtual 72	java/io/File:getParentFile	()Ljava/io/File;
    //   230: invokevirtual 75	java/io/File:mkdirs	()Z
    //   233: pop
    //   234: aload_1
    //   235: invokevirtual 78	java/io/File:createNewFile	()Z
    //   238: pop
    //   239: new 80	java/io/FileOutputStream
    //   242: dup
    //   243: aload_1
    //   244: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   247: astore_1
    //   248: goto -155 -> 93
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_1
    //   254: aload 8
    //   256: astore_2
    //   257: sipush -7056
    //   260: istore 5
    //   262: aload_2
    //   263: ifnull +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 144	java/io/FileInputStream:close	()V
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   278: iload 5
    //   280: istore 4
    //   282: iload_3
    //   283: ifeq -90 -> 193
    //   286: iload 5
    //   288: istore 4
    //   290: aload 10
    //   292: ifnull -99 -> 193
    //   295: iload 5
    //   297: istore 4
    //   299: aload 10
    //   301: invokevirtual 69	java/io/File:exists	()Z
    //   304: ifeq -111 -> 193
    //   307: aload 10
    //   309: invokevirtual 147	java/io/File:delete	()Z
    //   312: pop
    //   313: sipush -7056
    //   316: ireturn
    //   317: aload_1
    //   318: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   321: iconst_0
    //   322: istore 5
    //   324: aload_2
    //   325: ifnull +7 -> 332
    //   328: aload_2
    //   329: invokevirtual 144	java/io/FileInputStream:close	()V
    //   332: aload_1
    //   333: ifnull +7 -> 340
    //   336: aload_1
    //   337: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   340: iload 5
    //   342: istore 4
    //   344: iload_3
    //   345: ifeq -152 -> 193
    //   348: iload 5
    //   350: istore 4
    //   352: aload 10
    //   354: ifnull -161 -> 193
    //   357: iload 5
    //   359: istore 4
    //   361: aload 10
    //   363: invokevirtual 69	java/io/File:exists	()Z
    //   366: ifeq -173 -> 193
    //   369: aload 10
    //   371: invokevirtual 147	java/io/File:delete	()Z
    //   374: pop
    //   375: iload 5
    //   377: ireturn
    //   378: aconst_null
    //   379: astore_2
    //   380: aconst_null
    //   381: astore_1
    //   382: goto -58 -> 324
    //   385: astore_1
    //   386: aconst_null
    //   387: astore_1
    //   388: aload 9
    //   390: astore_2
    //   391: sipush -7000
    //   394: istore 5
    //   396: aload_2
    //   397: ifnull +7 -> 404
    //   400: aload_2
    //   401: invokevirtual 144	java/io/FileInputStream:close	()V
    //   404: aload_1
    //   405: ifnull +7 -> 412
    //   408: aload_1
    //   409: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   412: iload 5
    //   414: istore 4
    //   416: iload_3
    //   417: ifeq -224 -> 193
    //   420: iload 5
    //   422: istore 4
    //   424: aload 10
    //   426: ifnull -233 -> 193
    //   429: iload 5
    //   431: istore 4
    //   433: aload 10
    //   435: invokevirtual 69	java/io/File:exists	()Z
    //   438: ifeq -245 -> 193
    //   441: aload 10
    //   443: invokevirtual 147	java/io/File:delete	()Z
    //   446: pop
    //   447: sipush -7000
    //   450: ireturn
    //   451: astore_2
    //   452: aconst_null
    //   453: astore_1
    //   454: aload 6
    //   456: ifnull +8 -> 464
    //   459: aload 6
    //   461: invokevirtual 144	java/io/FileInputStream:close	()V
    //   464: aload_1
    //   465: ifnull +7 -> 472
    //   468: aload_1
    //   469: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   472: iload_3
    //   473: ifeq +22 -> 495
    //   476: aload 10
    //   478: ifnull +17 -> 495
    //   481: aload 10
    //   483: invokevirtual 69	java/io/File:exists	()Z
    //   486: ifeq +9 -> 495
    //   489: aload 10
    //   491: invokevirtual 147	java/io/File:delete	()Z
    //   494: pop
    //   495: aload_2
    //   496: athrow
    //   497: astore_2
    //   498: goto -166 -> 332
    //   501: astore_1
    //   502: goto -162 -> 340
    //   505: astore_2
    //   506: goto -360 -> 146
    //   509: astore_1
    //   510: goto -356 -> 154
    //   513: astore_2
    //   514: goto -244 -> 270
    //   517: astore_1
    //   518: goto -240 -> 278
    //   521: astore_2
    //   522: goto -118 -> 404
    //   525: astore_1
    //   526: goto -114 -> 412
    //   529: astore 6
    //   531: goto -67 -> 464
    //   534: astore_1
    //   535: goto -63 -> 472
    //   538: astore_2
    //   539: goto -85 -> 454
    //   542: astore 7
    //   544: aload_2
    //   545: astore 6
    //   547: aload 7
    //   549: astore_2
    //   550: goto -96 -> 454
    //   553: astore_2
    //   554: aload 9
    //   556: astore_2
    //   557: goto -166 -> 391
    //   560: astore 6
    //   562: goto -171 -> 391
    //   565: astore_2
    //   566: aload 8
    //   568: astore_2
    //   569: goto -312 -> 257
    //   572: astore 6
    //   574: goto -317 -> 257
    //   577: astore_2
    //   578: aload 7
    //   580: astore_2
    //   581: goto -443 -> 138
    //   584: astore_1
    //   585: aconst_null
    //   586: astore_1
    //   587: aload 7
    //   589: astore_2
    //   590: goto -452 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	this	gm
    //   0	593	1	paramString1	String
    //   0	593	2	paramString2	String
    //   0	593	3	paramBoolean	boolean
    //   83	349	4	i	int
    //   15	415	5	j	int
    //   7	119	6	arrayOfByte	byte[]
    //   136	324	6	localFileNotFoundException	java.io.FileNotFoundException
    //   529	1	6	localException1	java.lang.Exception
    //   545	1	6	str	String
    //   560	1	6	localException2	java.lang.Exception
    //   572	1	6	localIOException	IOException
    //   10	1	7	localObject1	Object
    //   542	46	7	localObject2	Object
    //   1	566	8	localObject3	Object
    //   4	551	9	localObject4	Object
    //   25	465	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	110	136	java/io/FileNotFoundException
    //   110	118	136	java/io/FileNotFoundException
    //   124	133	136	java/io/FileNotFoundException
    //   317	321	136	java/io/FileNotFoundException
    //   36	82	251	java/io/IOException
    //   85	93	251	java/io/IOException
    //   202	223	251	java/io/IOException
    //   226	248	251	java/io/IOException
    //   36	82	385	java/lang/Exception
    //   85	93	385	java/lang/Exception
    //   202	223	385	java/lang/Exception
    //   226	248	385	java/lang/Exception
    //   36	82	451	finally
    //   85	93	451	finally
    //   202	223	451	finally
    //   226	248	451	finally
    //   328	332	497	java/lang/Exception
    //   336	340	501	java/lang/Exception
    //   142	146	505	java/lang/Exception
    //   150	154	509	java/lang/Exception
    //   266	270	513	java/lang/Exception
    //   274	278	517	java/lang/Exception
    //   400	404	521	java/lang/Exception
    //   408	412	525	java/lang/Exception
    //   459	464	529	java/lang/Exception
    //   468	472	534	java/lang/Exception
    //   93	103	538	finally
    //   103	110	542	finally
    //   110	118	542	finally
    //   124	133	542	finally
    //   317	321	542	finally
    //   93	103	553	java/lang/Exception
    //   103	110	560	java/lang/Exception
    //   110	118	560	java/lang/Exception
    //   124	133	560	java/lang/Exception
    //   317	321	560	java/lang/Exception
    //   93	103	565	java/io/IOException
    //   103	110	572	java/io/IOException
    //   110	118	572	java/io/IOException
    //   124	133	572	java/io/IOException
    //   317	321	572	java/io/IOException
    //   93	103	577	java/io/FileNotFoundException
    //   36	82	584	java/io/FileNotFoundException
    //   85	93	584	java/io/FileNotFoundException
    //   202	223	584	java/io/FileNotFoundException
    //   226	248	584	java/io/FileNotFoundException
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean, a parama, int paramInt)
  {
    for (;;)
    {
      try
      {
        i = gp.x(this.mContext);
        if (i == 0) {
          return -52;
        }
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject = paramString1;
        if (this.sq == null) {
          this.sq = ((String)localObject);
        }
        localObject = (String)localObject + ".tmp";
        str1 = this.so + File.separator + (String)localObject;
        str2 = this.sp + File.separator + this.sq;
        localFile = new File(str1);
        if (!localFile.exists()) {
          continue;
        }
        this.su = true;
        this.ss = localFile.length();
        localObject = new URL(paramString2);
        if (3 != i) {
          continue;
        }
        String str3 = gp.y(this.mContext);
        i = gp.z(this.mContext);
        if ((TextUtils.isEmpty(str3)) || (i <= 0)) {
          continue;
        }
        localObject = (HttpURLConnection)((URL)localObject).openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str3, i)));
      }
      catch (MalformedURLException paramString1)
      {
        String str1;
        String str2;
        File localFile;
        i = -1053;
        paramString1 = paramString1.getMessage();
        continue;
        Object localObject = (HttpURLConnection)((URL)localObject).openConnection();
        continue;
        localObject = (HttpURLConnection)((URL)localObject).openConnection();
        continue;
        if ((parama == null) || (parama.O(str1))) {
          continue;
        }
        i = -7000;
        continue;
        j = a(str1, str2, true);
        i = j;
        if (j != 0) {
          continue;
        }
        i = 0;
        continue;
        if ((i == 0) || (paramInt > 1)) {
          continue;
        }
        paramString2 = ((HttpURLConnection)localObject).getHeaderField("Location");
        i = j;
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        i = a(paramString1, paramString2, paramBoolean, parama, paramInt + 1);
        continue;
        i = j;
        if (j != 416) {
          continue;
        }
        i = j;
        if (!localFile.delete()) {
          continue;
        }
        i = j;
        if (paramInt > 1) {
          continue;
        }
        i = a(paramString1, paramString2, paramBoolean, parama, paramInt + 1);
        continue;
      }
      catch (IOException paramString1)
      {
        i = -7056;
        paramString1 = paramString1.getMessage();
        continue;
      }
      catch (Throwable paramString1)
      {
        int j;
        int i = -999;
        paramString1 = paramString1.getMessage();
        continue;
        paramInt = 0;
        continue;
        continue;
        if ((j < 300) || (j > 305)) {
          continue;
        }
        i = 1;
        continue;
        i = 0;
        continue;
      }
      if (dk.bJ() < 8) {
        System.setProperty("http.keepAlive", "false");
      }
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      ((HttpURLConnection)localObject).setReadTimeout(30000);
      ((HttpURLConnection)localObject).setConnectTimeout(15000);
      if (this.ss > 0L) {
        ((HttpURLConnection)localObject).setRequestProperty("RANGE", "bytes=" + this.ss + "-");
      }
      j = ((HttpURLConnection)localObject).getResponseCode();
      if ((j != 200) && (j != 206)) {
        continue;
      }
      paramString1 = ((HttpURLConnection)localObject).getInputStream();
      i = a(str1, ((HttpURLConnection)localObject).getContentLength(), paramString1, paramBoolean);
      if (i == 0) {
        continue;
      }
      paramString1 = "";
      if ((i != 0) && (i != -7) && (paramInt == 0))
      {
        paramString2 = new Bundle();
        paramString2.putInt("key_errcode", i);
        paramString2.putString("key_errorMsg", paramString1);
        paramString2.putInt("key_downSize", (int)this.ss);
        if (this.st > 0L)
        {
          paramString2.putInt("key_total", (int)this.st);
          paramString2.putInt("key_sdcardstatus", gk.i(this.st - this.ss));
        }
        if (!this.su) {
          continue;
        }
        paramInt = 1;
        paramString2.putByte("key_downType", (byte)paramInt);
        a(1, paramString2);
      }
      return i;
      localObject = gk.h(paramString2, null);
      continue;
      this.su = false;
      this.ss = 0L;
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
  
  public int a(String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    this.ss = 0L;
    this.st = 0L;
    this.su = false;
    this.sr = false;
    return a(paramString1, paramString2, paramBoolean, parama, 0);
  }
  
  public String eX()
  {
    return this.sp + File.separator + this.sq;
  }
  
  public static abstract interface a
  {
    public abstract boolean O(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.gm
 * JD-Core Version:    0.7.0.1
 */