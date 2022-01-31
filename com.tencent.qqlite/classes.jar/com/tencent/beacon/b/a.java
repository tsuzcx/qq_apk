package com.tencent.beacon.b;

import android.content.Context;
import com.tencent.beacon.a.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;

public class a
{
  private static a f;
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  private a(Context paramContext)
  {
    g.a(paramContext);
    this.c = g.e(paramContext);
    this.d = g.c(paramContext);
    this.e = g.d(paramContext);
    try
    {
      paramContext = com.tencent.beacon.a.a.b(paramContext, "QIMEI_DENGTA", "");
      if ((paramContext != null) && (!"".equals(paramContext))) {
        this.a = paramContext;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  /* Error */
  public static long a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: iload_1
    //   5: ifgt +7 -> 12
    //   8: ldc2_w 77
    //   11: lreturn
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 6
    //   18: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   21: lstore_2
    //   22: new 86	java/net/InetSocketAddress
    //   25: dup
    //   26: aload_0
    //   27: iload_1
    //   28: invokespecial 89	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   31: astore 7
    //   33: new 91	java/net/Socket
    //   36: dup
    //   37: invokespecial 92	java/net/Socket:<init>	()V
    //   40: astore 5
    //   42: aload 5
    //   44: aload 7
    //   46: sipush 30000
    //   49: invokevirtual 96	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   52: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   55: lload_2
    //   56: lsub
    //   57: lstore_2
    //   58: new 98	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 100
    //   64: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: lload_2
    //   68: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: iconst_0
    //   75: anewarray 4	java/lang/Object
    //   78: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload 5
    //   83: invokevirtual 118	java/net/Socket:close	()V
    //   86: lload_2
    //   87: lreturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   93: aload_0
    //   94: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: lload_2
    //   105: lreturn
    //   106: astore 4
    //   108: aload 6
    //   110: astore 5
    //   112: aload 4
    //   114: astore 6
    //   116: aload 5
    //   118: astore 4
    //   120: aload 6
    //   122: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload 5
    //   134: astore 4
    //   136: new 98	java/lang/StringBuilder
    //   139: dup
    //   140: ldc 129
    //   142: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: aload_0
    //   146: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 134
    //   151: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: iload_1
    //   155: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 139	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload 5
    //   170: ifnull +8 -> 178
    //   173: aload 5
    //   175: invokevirtual 118	java/net/Socket:close	()V
    //   178: ldc2_w 77
    //   181: lreturn
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   187: aload_0
    //   188: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   191: iconst_0
    //   192: anewarray 4	java/lang/Object
    //   195: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: ldc2_w 77
    //   201: lreturn
    //   202: astore_0
    //   203: aload 4
    //   205: ifnull +8 -> 213
    //   208: aload 4
    //   210: invokevirtual 118	java/net/Socket:close	()V
    //   213: aload_0
    //   214: athrow
    //   215: astore 4
    //   217: aload 4
    //   219: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   222: aload 4
    //   224: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   227: iconst_0
    //   228: anewarray 4	java/lang/Object
    //   231: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: goto -21 -> 213
    //   237: astore_0
    //   238: aload 5
    //   240: astore 4
    //   242: goto -39 -> 203
    //   245: astore 6
    //   247: goto -131 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramString	String
    //   0	250	1	paramInt	int
    //   21	84	2	l	long
    //   13	1	4	localObject1	Object
    //   106	7	4	localThrowable1	Throwable
    //   118	91	4	localObject2	Object
    //   215	8	4	localIOException	java.io.IOException
    //   240	1	4	localObject3	Object
    //   40	199	5	localObject4	Object
    //   16	105	6	localThrowable2	Throwable
    //   245	1	6	localThrowable3	Throwable
    //   31	14	7	localInetSocketAddress	java.net.InetSocketAddress
    // Exception table:
    //   from	to	target	type
    //   81	86	88	java/io/IOException
    //   33	42	106	java/lang/Throwable
    //   173	178	182	java/io/IOException
    //   33	42	202	finally
    //   120	132	202	finally
    //   136	168	202	finally
    //   208	213	215	java/io/IOException
    //   42	81	237	finally
    //   42	81	245	java/lang/Throwable
  }
  
  /* Error */
  public static b a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: ldc 25
    //   7: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 9	com/tencent/beacon/b/a$b
    //   18: dup
    //   19: invokespecial 141	com/tencent/beacon/b/a$b:<init>	()V
    //   22: astore 28
    //   24: aconst_null
    //   25: astore 26
    //   27: aconst_null
    //   28: astore 25
    //   30: aconst_null
    //   31: astore 22
    //   33: aconst_null
    //   34: astore 21
    //   36: aconst_null
    //   37: astore 24
    //   39: aconst_null
    //   40: astore 23
    //   42: aload 23
    //   44: astore 19
    //   46: aload 21
    //   48: astore 17
    //   50: aload 25
    //   52: astore 15
    //   54: aload 24
    //   56: astore 18
    //   58: aload 22
    //   60: astore 16
    //   62: aload 26
    //   64: astore 14
    //   66: new 143	java/net/URL
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 144	java/net/URL:<init>	(Ljava/lang/String;)V
    //   74: astore 29
    //   76: aconst_null
    //   77: astore 27
    //   79: aload 23
    //   81: astore 19
    //   83: aload 21
    //   85: astore 17
    //   87: aload 25
    //   89: astore 15
    //   91: aload 24
    //   93: astore 18
    //   95: aload 22
    //   97: astore 16
    //   99: aload 26
    //   101: astore 14
    //   103: invokestatic 149	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   106: astore 20
    //   108: aload 23
    //   110: astore 19
    //   112: aload 21
    //   114: astore 17
    //   116: aload 25
    //   118: astore 15
    //   120: aload 24
    //   122: astore 18
    //   124: aload 22
    //   126: astore 16
    //   128: aload 26
    //   130: astore 14
    //   132: invokestatic 153	android/net/Proxy:getDefaultPort	()I
    //   135: istore_3
    //   136: aload 20
    //   138: ifnull +44 -> 182
    //   141: aload 23
    //   143: astore 19
    //   145: aload 21
    //   147: astore 17
    //   149: aload 25
    //   151: astore 15
    //   153: aload 24
    //   155: astore 18
    //   157: aload 22
    //   159: astore 16
    //   161: aload 26
    //   163: astore 14
    //   165: aload 20
    //   167: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   170: invokevirtual 159	java/lang/String:length	()I
    //   173: ifeq +9 -> 182
    //   176: iload_3
    //   177: istore_2
    //   178: iload_3
    //   179: ifgt +1538 -> 1717
    //   182: aload 23
    //   184: astore 19
    //   186: aload 21
    //   188: astore 17
    //   190: aload 25
    //   192: astore 15
    //   194: aload 24
    //   196: astore 18
    //   198: aload 22
    //   200: astore 16
    //   202: aload 26
    //   204: astore 14
    //   206: ldc 161
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: aload_1
    //   216: ifnull +1754 -> 1970
    //   219: aload 23
    //   221: astore 19
    //   223: aload 21
    //   225: astore 17
    //   227: aload 25
    //   229: astore 15
    //   231: aload 24
    //   233: astore 18
    //   235: aload 22
    //   237: astore 16
    //   239: aload 26
    //   241: astore 14
    //   243: aload_1
    //   244: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   247: invokevirtual 159	java/lang/String:length	()I
    //   250: ifgt +831 -> 1081
    //   253: goto +1717 -> 1970
    //   256: aload_0
    //   257: ifnonnull +1618 -> 1875
    //   260: aload 23
    //   262: astore 19
    //   264: aload 21
    //   266: astore 17
    //   268: aload 25
    //   270: astore 15
    //   272: aload 24
    //   274: astore 18
    //   276: aload 22
    //   278: astore 16
    //   280: aload 26
    //   282: astore 14
    //   284: aload 29
    //   286: invokevirtual 165	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   289: checkcast 167	java/net/HttpURLConnection
    //   292: astore_0
    //   293: aload 23
    //   295: astore 19
    //   297: aload 21
    //   299: astore 17
    //   301: aload_0
    //   302: astore 15
    //   304: aload 24
    //   306: astore 18
    //   308: aload 22
    //   310: astore 16
    //   312: aload_0
    //   313: astore 14
    //   315: aload_0
    //   316: iconst_1
    //   317: invokevirtual 171	java/net/HttpURLConnection:setDoInput	(Z)V
    //   320: aload 23
    //   322: astore 19
    //   324: aload 21
    //   326: astore 17
    //   328: aload_0
    //   329: astore 15
    //   331: aload 24
    //   333: astore 18
    //   335: aload 22
    //   337: astore 16
    //   339: aload_0
    //   340: astore 14
    //   342: aload_0
    //   343: iconst_1
    //   344: invokevirtual 174	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   347: aload 23
    //   349: astore 19
    //   351: aload 21
    //   353: astore 17
    //   355: aload_0
    //   356: astore 15
    //   358: aload 24
    //   360: astore 18
    //   362: aload 22
    //   364: astore 16
    //   366: aload_0
    //   367: astore 14
    //   369: aload_0
    //   370: sipush 30000
    //   373: invokevirtual 178	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   376: aload 23
    //   378: astore 19
    //   380: aload 21
    //   382: astore 17
    //   384: aload_0
    //   385: astore 15
    //   387: aload 24
    //   389: astore 18
    //   391: aload 22
    //   393: astore 16
    //   395: aload_0
    //   396: astore 14
    //   398: aload_0
    //   399: sipush 30000
    //   402: invokevirtual 181	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   405: aload 23
    //   407: astore 19
    //   409: aload 21
    //   411: astore 17
    //   413: aload_0
    //   414: astore 15
    //   416: aload 24
    //   418: astore 18
    //   420: aload 22
    //   422: astore 16
    //   424: aload_0
    //   425: astore 14
    //   427: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   430: lstore 4
    //   432: aload 23
    //   434: astore 19
    //   436: aload 21
    //   438: astore 17
    //   440: aload_0
    //   441: astore 15
    //   443: aload 24
    //   445: astore 18
    //   447: aload 22
    //   449: astore 16
    //   451: aload_0
    //   452: astore 14
    //   454: aload_0
    //   455: invokevirtual 183	java/net/HttpURLConnection:connect	()V
    //   458: aload 23
    //   460: astore 19
    //   462: aload 21
    //   464: astore 17
    //   466: aload_0
    //   467: astore 15
    //   469: aload 24
    //   471: astore 18
    //   473: aload 22
    //   475: astore 16
    //   477: aload_0
    //   478: astore 14
    //   480: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   483: lstore 6
    //   485: aload 23
    //   487: astore 19
    //   489: aload 21
    //   491: astore 17
    //   493: aload_0
    //   494: astore 15
    //   496: aload 24
    //   498: astore 18
    //   500: aload 22
    //   502: astore 16
    //   504: aload_0
    //   505: astore 14
    //   507: aload_0
    //   508: invokevirtual 187	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   511: astore_1
    //   512: aload_1
    //   513: astore 19
    //   515: aload 21
    //   517: astore 17
    //   519: aload_0
    //   520: astore 15
    //   522: aload_1
    //   523: astore 18
    //   525: aload 22
    //   527: astore 16
    //   529: aload_0
    //   530: astore 14
    //   532: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   535: lstore 8
    //   537: aload_1
    //   538: astore 19
    //   540: aload 21
    //   542: astore 17
    //   544: aload_0
    //   545: astore 15
    //   547: aload_1
    //   548: astore 18
    //   550: aload 22
    //   552: astore 16
    //   554: aload_0
    //   555: astore 14
    //   557: aload_0
    //   558: invokevirtual 191	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   561: astore 20
    //   563: aload_1
    //   564: astore 19
    //   566: aload 20
    //   568: astore 17
    //   570: aload_0
    //   571: astore 15
    //   573: aload_1
    //   574: astore 18
    //   576: aload 20
    //   578: astore 16
    //   580: aload_0
    //   581: astore 14
    //   583: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   586: lstore 10
    //   588: aload_1
    //   589: astore 19
    //   591: aload 20
    //   593: astore 17
    //   595: aload_0
    //   596: astore 15
    //   598: aload_1
    //   599: astore 18
    //   601: aload 20
    //   603: astore 16
    //   605: aload_0
    //   606: astore 14
    //   608: aload 20
    //   610: invokevirtual 196	java/io/InputStream:read	()I
    //   613: iconst_m1
    //   614: if_icmpne -26 -> 588
    //   617: aload_1
    //   618: astore 19
    //   620: aload 20
    //   622: astore 17
    //   624: aload_0
    //   625: astore 15
    //   627: aload_1
    //   628: astore 18
    //   630: aload 20
    //   632: astore 16
    //   634: aload_0
    //   635: astore 14
    //   637: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   640: lstore 12
    //   642: aload_1
    //   643: astore 19
    //   645: aload 20
    //   647: astore 17
    //   649: aload_0
    //   650: astore 15
    //   652: aload_1
    //   653: astore 18
    //   655: aload 20
    //   657: astore 16
    //   659: aload_0
    //   660: astore 14
    //   662: aload 28
    //   664: ldc2_w 77
    //   667: putfield 199	com/tencent/beacon/b/a$b:a	J
    //   670: aload_1
    //   671: astore 19
    //   673: aload 20
    //   675: astore 17
    //   677: aload_0
    //   678: astore 15
    //   680: aload_1
    //   681: astore 18
    //   683: aload 20
    //   685: astore 16
    //   687: aload_0
    //   688: astore 14
    //   690: aload 28
    //   692: ldc 25
    //   694: putfield 201	com/tencent/beacon/b/a$b:f	Ljava/lang/String;
    //   697: aload_1
    //   698: astore 19
    //   700: aload 20
    //   702: astore 17
    //   704: aload_0
    //   705: astore 15
    //   707: aload_1
    //   708: astore 18
    //   710: aload 20
    //   712: astore 16
    //   714: aload_0
    //   715: astore 14
    //   717: aload 28
    //   719: lload 6
    //   721: lload 4
    //   723: lsub
    //   724: putfield 203	com/tencent/beacon/b/a$b:b	J
    //   727: aload_1
    //   728: astore 19
    //   730: aload 20
    //   732: astore 17
    //   734: aload_0
    //   735: astore 15
    //   737: aload_1
    //   738: astore 18
    //   740: aload 20
    //   742: astore 16
    //   744: aload_0
    //   745: astore 14
    //   747: aload 28
    //   749: lload 8
    //   751: lload 6
    //   753: lsub
    //   754: putfield 205	com/tencent/beacon/b/a$b:c	J
    //   757: aload_1
    //   758: astore 19
    //   760: aload 20
    //   762: astore 17
    //   764: aload_0
    //   765: astore 15
    //   767: aload_1
    //   768: astore 18
    //   770: aload 20
    //   772: astore 16
    //   774: aload_0
    //   775: astore 14
    //   777: aload 28
    //   779: lload 10
    //   781: lload 8
    //   783: lsub
    //   784: putfield 207	com/tencent/beacon/b/a$b:d	J
    //   787: aload_1
    //   788: astore 19
    //   790: aload 20
    //   792: astore 17
    //   794: aload_0
    //   795: astore 15
    //   797: aload_1
    //   798: astore 18
    //   800: aload 20
    //   802: astore 16
    //   804: aload_0
    //   805: astore 14
    //   807: aload 28
    //   809: lload 12
    //   811: lload 10
    //   813: lsub
    //   814: putfield 209	com/tencent/beacon/b/a$b:e	J
    //   817: aload_1
    //   818: astore 19
    //   820: aload 20
    //   822: astore 17
    //   824: aload_0
    //   825: astore 15
    //   827: aload_1
    //   828: astore 18
    //   830: aload 20
    //   832: astore 16
    //   834: aload_0
    //   835: astore 14
    //   837: new 98	java/lang/StringBuilder
    //   840: dup
    //   841: ldc 211
    //   843: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   846: aload 28
    //   848: getfield 199	com/tencent/beacon/b/a$b:a	J
    //   851: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   854: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: iconst_0
    //   858: anewarray 4	java/lang/Object
    //   861: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   864: aload_1
    //   865: astore 19
    //   867: aload 20
    //   869: astore 17
    //   871: aload_0
    //   872: astore 15
    //   874: aload_1
    //   875: astore 18
    //   877: aload 20
    //   879: astore 16
    //   881: aload_0
    //   882: astore 14
    //   884: new 98	java/lang/StringBuilder
    //   887: dup
    //   888: ldc 213
    //   890: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   893: aload 28
    //   895: getfield 203	com/tencent/beacon/b/a$b:b	J
    //   898: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   901: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: iconst_0
    //   905: anewarray 4	java/lang/Object
    //   908: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   911: aload_1
    //   912: astore 19
    //   914: aload 20
    //   916: astore 17
    //   918: aload_0
    //   919: astore 15
    //   921: aload_1
    //   922: astore 18
    //   924: aload 20
    //   926: astore 16
    //   928: aload_0
    //   929: astore 14
    //   931: new 98	java/lang/StringBuilder
    //   934: dup
    //   935: ldc 215
    //   937: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   940: aload 28
    //   942: getfield 205	com/tencent/beacon/b/a$b:c	J
    //   945: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   948: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: iconst_0
    //   952: anewarray 4	java/lang/Object
    //   955: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   958: aload_1
    //   959: astore 19
    //   961: aload 20
    //   963: astore 17
    //   965: aload_0
    //   966: astore 15
    //   968: aload_1
    //   969: astore 18
    //   971: aload 20
    //   973: astore 16
    //   975: aload_0
    //   976: astore 14
    //   978: new 98	java/lang/StringBuilder
    //   981: dup
    //   982: ldc 217
    //   984: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   987: aload 28
    //   989: getfield 207	com/tencent/beacon/b/a$b:d	J
    //   992: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   995: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: iconst_0
    //   999: anewarray 4	java/lang/Object
    //   1002: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1005: aload_1
    //   1006: astore 19
    //   1008: aload 20
    //   1010: astore 17
    //   1012: aload_0
    //   1013: astore 15
    //   1015: aload_1
    //   1016: astore 18
    //   1018: aload 20
    //   1020: astore 16
    //   1022: aload_0
    //   1023: astore 14
    //   1025: new 98	java/lang/StringBuilder
    //   1028: dup
    //   1029: ldc 219
    //   1031: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1034: aload 28
    //   1036: getfield 209	com/tencent/beacon/b/a$b:e	J
    //   1039: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: iconst_0
    //   1046: anewarray 4	java/lang/Object
    //   1049: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1052: aload_1
    //   1053: ifnull +7 -> 1060
    //   1056: aload_1
    //   1057: invokevirtual 222	java/io/OutputStream:close	()V
    //   1060: aload 20
    //   1062: ifnull +8 -> 1070
    //   1065: aload 20
    //   1067: invokevirtual 223	java/io/InputStream:close	()V
    //   1070: aload_0
    //   1071: ifnull +7 -> 1078
    //   1074: aload_0
    //   1075: invokevirtual 226	java/net/HttpURLConnection:disconnect	()V
    //   1078: aload 28
    //   1080: areturn
    //   1081: aload 23
    //   1083: astore 19
    //   1085: aload 21
    //   1087: astore 17
    //   1089: aload 25
    //   1091: astore 15
    //   1093: aload 24
    //   1095: astore 18
    //   1097: aload 22
    //   1099: astore 16
    //   1101: aload 26
    //   1103: astore 14
    //   1105: new 6	com/tencent/beacon/b/a$a
    //   1108: dup
    //   1109: invokespecial 227	com/tencent/beacon/b/a$a:<init>	()V
    //   1112: astore 20
    //   1114: aload 23
    //   1116: astore 19
    //   1118: aload 21
    //   1120: astore 17
    //   1122: aload 25
    //   1124: astore 15
    //   1126: aload 24
    //   1128: astore 18
    //   1130: aload 22
    //   1132: astore 16
    //   1134: aload 26
    //   1136: astore 14
    //   1138: aload_1
    //   1139: invokevirtual 230	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1142: astore 30
    //   1144: aload 23
    //   1146: astore 19
    //   1148: aload 21
    //   1150: astore 17
    //   1152: aload 25
    //   1154: astore 15
    //   1156: aload 24
    //   1158: astore 18
    //   1160: aload 22
    //   1162: astore 16
    //   1164: aload 26
    //   1166: astore 14
    //   1168: aload 30
    //   1170: ldc 232
    //   1172: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1175: ifeq +177 -> 1352
    //   1178: aload 23
    //   1180: astore 19
    //   1182: aload 21
    //   1184: astore 17
    //   1186: aload 25
    //   1188: astore 15
    //   1190: aload 24
    //   1192: astore 18
    //   1194: aload 22
    //   1196: astore 16
    //   1198: aload 26
    //   1200: astore 14
    //   1202: ldc 238
    //   1204: iconst_0
    //   1205: anewarray 4	java/lang/Object
    //   1208: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1211: aload 23
    //   1213: astore 19
    //   1215: aload 21
    //   1217: astore 17
    //   1219: aload 25
    //   1221: astore 15
    //   1223: aload 24
    //   1225: astore 18
    //   1227: aload 22
    //   1229: astore 16
    //   1231: aload 26
    //   1233: astore 14
    //   1235: aload 20
    //   1237: ldc 240
    //   1239: putfield 241	com/tencent/beacon/b/a$a:a	Ljava/lang/String;
    //   1242: aload 23
    //   1244: astore 19
    //   1246: aload 21
    //   1248: astore 17
    //   1250: aload 25
    //   1252: astore 15
    //   1254: aload 24
    //   1256: astore 18
    //   1258: aload 22
    //   1260: astore 16
    //   1262: aload 26
    //   1264: astore 14
    //   1266: aload 20
    //   1268: bipush 80
    //   1270: putfield 244	com/tencent/beacon/b/a$a:b	I
    //   1273: aload 20
    //   1275: astore_0
    //   1276: goto +696 -> 1972
    //   1279: astore_0
    //   1280: aload 19
    //   1282: astore 18
    //   1284: aload 17
    //   1286: astore 16
    //   1288: aload 15
    //   1290: astore 14
    //   1292: aload_0
    //   1293: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   1296: aload 19
    //   1298: astore 18
    //   1300: aload 17
    //   1302: astore 16
    //   1304: aload 15
    //   1306: astore 14
    //   1308: aload_0
    //   1309: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1312: iconst_0
    //   1313: anewarray 4	java/lang/Object
    //   1316: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1319: aload 19
    //   1321: ifnull +8 -> 1329
    //   1324: aload 19
    //   1326: invokevirtual 222	java/io/OutputStream:close	()V
    //   1329: aload 17
    //   1331: ifnull +8 -> 1339
    //   1334: aload 17
    //   1336: invokevirtual 223	java/io/InputStream:close	()V
    //   1339: aload 15
    //   1341: ifnull -263 -> 1078
    //   1344: aload 15
    //   1346: invokevirtual 226	java/net/HttpURLConnection:disconnect	()V
    //   1349: goto -271 -> 1078
    //   1352: aload 23
    //   1354: astore 19
    //   1356: aload 21
    //   1358: astore 17
    //   1360: aload 25
    //   1362: astore 15
    //   1364: aload 24
    //   1366: astore 18
    //   1368: aload 22
    //   1370: astore 16
    //   1372: aload 26
    //   1374: astore 14
    //   1376: aload 30
    //   1378: ldc 247
    //   1380: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1383: ifeq +137 -> 1520
    //   1386: aload 23
    //   1388: astore 19
    //   1390: aload 21
    //   1392: astore 17
    //   1394: aload 25
    //   1396: astore 15
    //   1398: aload 24
    //   1400: astore 18
    //   1402: aload 22
    //   1404: astore 16
    //   1406: aload 26
    //   1408: astore 14
    //   1410: ldc 249
    //   1412: iconst_0
    //   1413: anewarray 4	java/lang/Object
    //   1416: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1419: aload 23
    //   1421: astore 19
    //   1423: aload 21
    //   1425: astore 17
    //   1427: aload 25
    //   1429: astore 15
    //   1431: aload 24
    //   1433: astore 18
    //   1435: aload 22
    //   1437: astore 16
    //   1439: aload 26
    //   1441: astore 14
    //   1443: aload 20
    //   1445: ldc 251
    //   1447: putfield 241	com/tencent/beacon/b/a$a:a	Ljava/lang/String;
    //   1450: aload 23
    //   1452: astore 19
    //   1454: aload 21
    //   1456: astore 17
    //   1458: aload 25
    //   1460: astore 15
    //   1462: aload 24
    //   1464: astore 18
    //   1466: aload 22
    //   1468: astore 16
    //   1470: aload 26
    //   1472: astore 14
    //   1474: aload 20
    //   1476: bipush 80
    //   1478: putfield 244	com/tencent/beacon/b/a$a:b	I
    //   1481: aload 20
    //   1483: astore_0
    //   1484: goto +488 -> 1972
    //   1487: astore_0
    //   1488: aload 18
    //   1490: ifnull +8 -> 1498
    //   1493: aload 18
    //   1495: invokevirtual 222	java/io/OutputStream:close	()V
    //   1498: aload 16
    //   1500: ifnull +8 -> 1508
    //   1503: aload 16
    //   1505: invokevirtual 223	java/io/InputStream:close	()V
    //   1508: aload 14
    //   1510: ifnull +8 -> 1518
    //   1513: aload 14
    //   1515: invokevirtual 226	java/net/HttpURLConnection:disconnect	()V
    //   1518: aload_0
    //   1519: athrow
    //   1520: aload 23
    //   1522: astore 19
    //   1524: aload 21
    //   1526: astore 17
    //   1528: aload 25
    //   1530: astore 15
    //   1532: aload 24
    //   1534: astore 18
    //   1536: aload 22
    //   1538: astore 16
    //   1540: aload 26
    //   1542: astore 14
    //   1544: aload 20
    //   1546: astore_0
    //   1547: aload 30
    //   1549: ldc 253
    //   1551: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1554: ifeq +418 -> 1972
    //   1557: aload 23
    //   1559: astore 19
    //   1561: aload 21
    //   1563: astore 17
    //   1565: aload 25
    //   1567: astore 15
    //   1569: aload 24
    //   1571: astore 18
    //   1573: aload 22
    //   1575: astore 16
    //   1577: aload 26
    //   1579: astore 14
    //   1581: ldc 255
    //   1583: iconst_0
    //   1584: anewarray 4	java/lang/Object
    //   1587: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1590: aload 23
    //   1592: astore 19
    //   1594: aload 21
    //   1596: astore 17
    //   1598: aload 25
    //   1600: astore 15
    //   1602: aload 24
    //   1604: astore 18
    //   1606: aload 22
    //   1608: astore 16
    //   1610: aload 26
    //   1612: astore 14
    //   1614: aload 20
    //   1616: ldc 251
    //   1618: putfield 241	com/tencent/beacon/b/a$a:a	Ljava/lang/String;
    //   1621: aload 23
    //   1623: astore 19
    //   1625: aload 21
    //   1627: astore 17
    //   1629: aload 25
    //   1631: astore 15
    //   1633: aload 24
    //   1635: astore 18
    //   1637: aload 22
    //   1639: astore 16
    //   1641: aload 26
    //   1643: astore 14
    //   1645: aload 20
    //   1647: bipush 80
    //   1649: putfield 244	com/tencent/beacon/b/a$a:b	I
    //   1652: aload 20
    //   1654: astore_0
    //   1655: goto +317 -> 1972
    //   1658: aload 23
    //   1660: astore 19
    //   1662: aload 21
    //   1664: astore 17
    //   1666: aload 25
    //   1668: astore 15
    //   1670: aload 24
    //   1672: astore 18
    //   1674: aload 22
    //   1676: astore 16
    //   1678: aload 26
    //   1680: astore 14
    //   1682: aload_0
    //   1683: getfield 241	com/tencent/beacon/b/a$a:a	Ljava/lang/String;
    //   1686: astore 20
    //   1688: aload 23
    //   1690: astore 19
    //   1692: aload 21
    //   1694: astore 17
    //   1696: aload 25
    //   1698: astore 15
    //   1700: aload 24
    //   1702: astore 18
    //   1704: aload 22
    //   1706: astore 16
    //   1708: aload 26
    //   1710: astore 14
    //   1712: aload_0
    //   1713: getfield 244	com/tencent/beacon/b/a$a:b	I
    //   1716: istore_2
    //   1717: aload 27
    //   1719: astore_0
    //   1720: aload 20
    //   1722: ifnull -1466 -> 256
    //   1725: aload 27
    //   1727: astore_0
    //   1728: aload 23
    //   1730: astore 19
    //   1732: aload 21
    //   1734: astore 17
    //   1736: aload 25
    //   1738: astore 15
    //   1740: aload 24
    //   1742: astore 18
    //   1744: aload 22
    //   1746: astore 16
    //   1748: aload 26
    //   1750: astore 14
    //   1752: aload 20
    //   1754: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   1757: invokevirtual 159	java/lang/String:length	()I
    //   1760: ifle -1504 -> 256
    //   1763: aload 23
    //   1765: astore 19
    //   1767: aload 21
    //   1769: astore 17
    //   1771: aload 25
    //   1773: astore 15
    //   1775: aload 24
    //   1777: astore 18
    //   1779: aload 22
    //   1781: astore 16
    //   1783: aload 26
    //   1785: astore 14
    //   1787: new 86	java/net/InetSocketAddress
    //   1790: dup
    //   1791: aload 20
    //   1793: iload_2
    //   1794: invokespecial 89	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   1797: astore_0
    //   1798: aload 23
    //   1800: astore 19
    //   1802: aload 21
    //   1804: astore 17
    //   1806: aload 25
    //   1808: astore 15
    //   1810: aload 24
    //   1812: astore 18
    //   1814: aload 22
    //   1816: astore 16
    //   1818: aload 26
    //   1820: astore 14
    //   1822: new 98	java/lang/StringBuilder
    //   1825: dup
    //   1826: ldc_w 257
    //   1829: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1832: aload_1
    //   1833: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: ldc_w 259
    //   1839: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: aload 20
    //   1844: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: ldc 134
    //   1849: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1852: iload_2
    //   1853: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1856: ldc_w 261
    //   1859: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1865: iconst_0
    //   1866: anewarray 4	java/lang/Object
    //   1869: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1872: goto -1616 -> 256
    //   1875: aload 23
    //   1877: astore 19
    //   1879: aload 21
    //   1881: astore 17
    //   1883: aload 25
    //   1885: astore 15
    //   1887: aload 24
    //   1889: astore 18
    //   1891: aload 22
    //   1893: astore 16
    //   1895: aload 26
    //   1897: astore 14
    //   1899: aload 29
    //   1901: new 263	java/net/Proxy
    //   1904: dup
    //   1905: getstatic 269	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   1908: aload_0
    //   1909: invokespecial 272	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   1912: invokevirtual 275	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   1915: checkcast 167	java/net/HttpURLConnection
    //   1918: astore_0
    //   1919: goto -1626 -> 293
    //   1922: astore_1
    //   1923: aload_1
    //   1924: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   1927: goto -867 -> 1060
    //   1930: astore_1
    //   1931: aload_1
    //   1932: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   1935: goto -865 -> 1070
    //   1938: astore_0
    //   1939: aload_0
    //   1940: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   1943: goto -614 -> 1329
    //   1946: astore_0
    //   1947: aload_0
    //   1948: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   1951: goto -612 -> 1339
    //   1954: astore_1
    //   1955: aload_1
    //   1956: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   1959: goto -461 -> 1498
    //   1962: astore_1
    //   1963: aload_1
    //   1964: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   1967: goto -459 -> 1508
    //   1970: aconst_null
    //   1971: astore_0
    //   1972: aload_0
    //   1973: ifnonnull -315 -> 1658
    //   1976: aconst_null
    //   1977: astore_0
    //   1978: goto -1722 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1981	0	paramString1	String
    //   0	1981	1	paramString2	String
    //   177	1676	2	i	int
    //   135	44	3	j	int
    //   430	292	4	l1	long
    //   483	269	6	l2	long
    //   535	247	8	l3	long
    //   586	226	10	l4	long
    //   640	170	12	l5	long
    //   64	1834	14	localObject1	Object
    //   52	1834	15	localObject2	Object
    //   60	1834	16	localObject3	Object
    //   48	1834	17	localObject4	Object
    //   56	1834	18	localObject5	Object
    //   44	1834	19	localObject6	Object
    //   106	1737	20	localObject7	Object
    //   34	1846	21	localObject8	Object
    //   31	1861	22	localObject9	Object
    //   40	1836	23	localObject10	Object
    //   37	1851	24	localObject11	Object
    //   28	1856	25	localObject12	Object
    //   25	1871	26	localObject13	Object
    //   77	1649	27	localObject14	Object
    //   22	1057	28	localb	b
    //   74	1826	29	localURL	java.net.URL
    //   1142	406	30	str	String
    // Exception table:
    //   from	to	target	type
    //   66	76	1279	java/lang/Throwable
    //   103	108	1279	java/lang/Throwable
    //   132	136	1279	java/lang/Throwable
    //   165	176	1279	java/lang/Throwable
    //   206	215	1279	java/lang/Throwable
    //   243	253	1279	java/lang/Throwable
    //   284	293	1279	java/lang/Throwable
    //   315	320	1279	java/lang/Throwable
    //   342	347	1279	java/lang/Throwable
    //   369	376	1279	java/lang/Throwable
    //   398	405	1279	java/lang/Throwable
    //   427	432	1279	java/lang/Throwable
    //   454	458	1279	java/lang/Throwable
    //   480	485	1279	java/lang/Throwable
    //   507	512	1279	java/lang/Throwable
    //   532	537	1279	java/lang/Throwable
    //   557	563	1279	java/lang/Throwable
    //   583	588	1279	java/lang/Throwable
    //   608	617	1279	java/lang/Throwable
    //   637	642	1279	java/lang/Throwable
    //   662	670	1279	java/lang/Throwable
    //   690	697	1279	java/lang/Throwable
    //   717	727	1279	java/lang/Throwable
    //   747	757	1279	java/lang/Throwable
    //   777	787	1279	java/lang/Throwable
    //   807	817	1279	java/lang/Throwable
    //   837	864	1279	java/lang/Throwable
    //   884	911	1279	java/lang/Throwable
    //   931	958	1279	java/lang/Throwable
    //   978	1005	1279	java/lang/Throwable
    //   1025	1052	1279	java/lang/Throwable
    //   1105	1114	1279	java/lang/Throwable
    //   1138	1144	1279	java/lang/Throwable
    //   1168	1178	1279	java/lang/Throwable
    //   1202	1211	1279	java/lang/Throwable
    //   1235	1242	1279	java/lang/Throwable
    //   1266	1273	1279	java/lang/Throwable
    //   1376	1386	1279	java/lang/Throwable
    //   1410	1419	1279	java/lang/Throwable
    //   1443	1450	1279	java/lang/Throwable
    //   1474	1481	1279	java/lang/Throwable
    //   1547	1557	1279	java/lang/Throwable
    //   1581	1590	1279	java/lang/Throwable
    //   1614	1621	1279	java/lang/Throwable
    //   1645	1652	1279	java/lang/Throwable
    //   1682	1688	1279	java/lang/Throwable
    //   1712	1717	1279	java/lang/Throwable
    //   1752	1763	1279	java/lang/Throwable
    //   1787	1798	1279	java/lang/Throwable
    //   1822	1872	1279	java/lang/Throwable
    //   1899	1919	1279	java/lang/Throwable
    //   66	76	1487	finally
    //   103	108	1487	finally
    //   132	136	1487	finally
    //   165	176	1487	finally
    //   206	215	1487	finally
    //   243	253	1487	finally
    //   284	293	1487	finally
    //   315	320	1487	finally
    //   342	347	1487	finally
    //   369	376	1487	finally
    //   398	405	1487	finally
    //   427	432	1487	finally
    //   454	458	1487	finally
    //   480	485	1487	finally
    //   507	512	1487	finally
    //   532	537	1487	finally
    //   557	563	1487	finally
    //   583	588	1487	finally
    //   608	617	1487	finally
    //   637	642	1487	finally
    //   662	670	1487	finally
    //   690	697	1487	finally
    //   717	727	1487	finally
    //   747	757	1487	finally
    //   777	787	1487	finally
    //   807	817	1487	finally
    //   837	864	1487	finally
    //   884	911	1487	finally
    //   931	958	1487	finally
    //   978	1005	1487	finally
    //   1025	1052	1487	finally
    //   1105	1114	1487	finally
    //   1138	1144	1487	finally
    //   1168	1178	1487	finally
    //   1202	1211	1487	finally
    //   1235	1242	1487	finally
    //   1266	1273	1487	finally
    //   1292	1296	1487	finally
    //   1308	1319	1487	finally
    //   1376	1386	1487	finally
    //   1410	1419	1487	finally
    //   1443	1450	1487	finally
    //   1474	1481	1487	finally
    //   1547	1557	1487	finally
    //   1581	1590	1487	finally
    //   1614	1621	1487	finally
    //   1645	1652	1487	finally
    //   1682	1688	1487	finally
    //   1712	1717	1487	finally
    //   1752	1763	1487	finally
    //   1787	1798	1487	finally
    //   1822	1872	1487	finally
    //   1899	1919	1487	finally
    //   1056	1060	1922	java/io/IOException
    //   1065	1070	1930	java/io/IOException
    //   1324	1329	1938	java/io/IOException
    //   1334	1339	1946	java/io/IOException
    //   1493	1498	1954	java/io/IOException
    //   1503	1508	1962	java/io/IOException
  }
  
  /* Error */
  public static b a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: ifnull +38 -> 42
    //   7: aload_0
    //   8: ldc 25
    //   10: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +29 -> 42
    //   16: aload_1
    //   17: ifnull +25 -> 42
    //   20: aload_1
    //   21: ldc 25
    //   23: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +16 -> 42
    //   29: aload_2
    //   30: ifnull +12 -> 42
    //   33: aload_2
    //   34: ldc 25
    //   36: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +7 -> 46
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: areturn
    //   46: new 9	com/tencent/beacon/b/a$b
    //   49: dup
    //   50: invokespecial 141	com/tencent/beacon/b/a$b:<init>	()V
    //   53: astore 11
    //   55: new 98	java/lang/StringBuilder
    //   58: dup
    //   59: ldc_w 278
    //   62: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore_2
    //   77: new 143	java/net/URL
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 144	java/net/URL:<init>	(Ljava/lang/String;)V
    //   85: astore 9
    //   87: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   90: lstore 5
    //   92: aload_1
    //   93: invokestatic 284	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   96: astore_2
    //   97: aload 11
    //   99: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   102: lload 5
    //   104: lsub
    //   105: putfield 199	com/tencent/beacon/b/a$b:a	J
    //   108: new 98	java/lang/StringBuilder
    //   111: dup
    //   112: ldc_w 286
    //   115: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   118: aload 11
    //   120: getfield 199	com/tencent/beacon/b/a$b:a	J
    //   123: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   126: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: iconst_0
    //   130: anewarray 4	java/lang/Object
    //   133: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: new 288	java/lang/StringBuffer
    //   139: dup
    //   140: invokespecial 289	java/lang/StringBuffer:<init>	()V
    //   143: astore 7
    //   145: aload_2
    //   146: invokevirtual 293	java/net/InetAddress:getAddress	()[B
    //   149: astore_2
    //   150: iconst_0
    //   151: istore_3
    //   152: iload_3
    //   153: aload_2
    //   154: arraylength
    //   155: if_icmpge +166 -> 321
    //   158: new 98	java/lang/StringBuilder
    //   161: dup
    //   162: ldc_w 295
    //   165: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: astore 10
    //   170: aload_2
    //   171: iload_3
    //   172: baload
    //   173: ifge +140 -> 313
    //   176: aload_2
    //   177: iload_3
    //   178: baload
    //   179: sipush 256
    //   182: iadd
    //   183: istore 4
    //   185: aload 7
    //   187: aload 10
    //   189: iload 4
    //   191: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokevirtual 298	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   200: pop
    //   201: iload_3
    //   202: iconst_1
    //   203: iadd
    //   204: istore_3
    //   205: goto -53 -> 152
    //   208: aload 11
    //   210: ldc2_w 77
    //   213: putfield 199	com/tencent/beacon/b/a$b:a	J
    //   216: goto -108 -> 108
    //   219: astore_2
    //   220: aconst_null
    //   221: astore_1
    //   222: aconst_null
    //   223: astore 7
    //   225: aconst_null
    //   226: astore_0
    //   227: aload_0
    //   228: astore 10
    //   230: aload_1
    //   231: astore 9
    //   233: aload 7
    //   235: astore 8
    //   237: aload_2
    //   238: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   241: aload_0
    //   242: astore 10
    //   244: aload_1
    //   245: astore 9
    //   247: aload 7
    //   249: astore 8
    //   251: aload_2
    //   252: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload_1
    //   263: ifnull +7 -> 270
    //   266: aload_1
    //   267: invokevirtual 222	java/io/OutputStream:close	()V
    //   270: aload_0
    //   271: ifnull +7 -> 278
    //   274: aload_0
    //   275: invokevirtual 223	java/io/InputStream:close	()V
    //   278: aload 11
    //   280: astore_0
    //   281: aload 7
    //   283: ifnull -239 -> 44
    //   286: aload 7
    //   288: invokevirtual 118	java/net/Socket:close	()V
    //   291: aload 11
    //   293: areturn
    //   294: astore_0
    //   295: aload_0
    //   296: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   299: aload_0
    //   300: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   303: iconst_0
    //   304: anewarray 4	java/lang/Object
    //   307: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: aload 11
    //   312: areturn
    //   313: aload_2
    //   314: iload_3
    //   315: baload
    //   316: istore 4
    //   318: goto -133 -> 185
    //   321: aload 11
    //   323: aload 7
    //   325: iconst_1
    //   326: invokevirtual 302	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   329: putfield 201	com/tencent/beacon/b/a$b:f	Ljava/lang/String;
    //   332: aload 7
    //   334: iconst_0
    //   335: invokevirtual 305	java/lang/StringBuffer:setLength	(I)V
    //   338: aload_0
    //   339: ldc 134
    //   341: invokevirtual 309	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   344: astore_0
    //   345: new 86	java/net/InetSocketAddress
    //   348: dup
    //   349: aload_0
    //   350: iconst_0
    //   351: aaload
    //   352: aload_0
    //   353: iconst_1
    //   354: aaload
    //   355: invokestatic 315	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   358: invokespecial 89	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   361: astore_0
    //   362: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   365: lstore 5
    //   367: new 91	java/net/Socket
    //   370: dup
    //   371: invokespecial 92	java/net/Socket:<init>	()V
    //   374: astore 7
    //   376: aload 7
    //   378: aload_0
    //   379: sipush 30000
    //   382: invokevirtual 96	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   385: aload 11
    //   387: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   390: lload 5
    //   392: lsub
    //   393: putfield 203	com/tencent/beacon/b/a$b:b	J
    //   396: new 98	java/lang/StringBuilder
    //   399: dup
    //   400: ldc_w 317
    //   403: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   406: aload 11
    //   408: getfield 203	com/tencent/beacon/b/a$b:b	J
    //   411: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   414: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: iconst_0
    //   418: anewarray 4	java/lang/Object
    //   421: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   424: new 98	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   431: aload 9
    //   433: invokevirtual 321	java/net/URL:getPath	()Ljava/lang/String;
    //   436: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: astore_2
    //   440: aload 9
    //   442: invokevirtual 324	java/net/URL:getQuery	()Ljava/lang/String;
    //   445: ifnull +451 -> 896
    //   448: new 98	java/lang/StringBuilder
    //   451: dup
    //   452: ldc_w 326
    //   455: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload 9
    //   460: invokevirtual 324	java/net/URL:getQuery	()Ljava/lang/String;
    //   463: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: astore_0
    //   470: aload_2
    //   471: aload_0
    //   472: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: astore_0
    //   479: new 98	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 328
    //   486: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload_0
    //   490: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc_w 330
    //   496: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_1
    //   500: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 332
    //   506: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: astore_2
    //   513: ldc_w 334
    //   516: new 98	java/lang/StringBuilder
    //   519: dup
    //   520: ldc_w 336
    //   523: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   526: aload_2
    //   527: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 341	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   536: pop
    //   537: aload 7
    //   539: invokevirtual 342	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   542: astore_1
    //   543: aload 7
    //   545: invokevirtual 343	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   548: astore_0
    //   549: aload_0
    //   550: astore 10
    //   552: aload_1
    //   553: astore 9
    //   555: aload 7
    //   557: astore 8
    //   559: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   562: lstore 5
    //   564: aload_0
    //   565: astore 10
    //   567: aload_1
    //   568: astore 9
    //   570: aload 7
    //   572: astore 8
    //   574: aload_1
    //   575: aload_2
    //   576: ldc_w 345
    //   579: invokevirtual 349	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   582: invokevirtual 353	java/io/OutputStream:write	([B)V
    //   585: aload_0
    //   586: astore 10
    //   588: aload_1
    //   589: astore 9
    //   591: aload 7
    //   593: astore 8
    //   595: aload_1
    //   596: invokevirtual 356	java/io/OutputStream:flush	()V
    //   599: aload_0
    //   600: astore 10
    //   602: aload_1
    //   603: astore 9
    //   605: aload 7
    //   607: astore 8
    //   609: aload 11
    //   611: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   614: lload 5
    //   616: lsub
    //   617: putfield 205	com/tencent/beacon/b/a$b:c	J
    //   620: aload_0
    //   621: astore 10
    //   623: aload_1
    //   624: astore 9
    //   626: aload 7
    //   628: astore 8
    //   630: new 98	java/lang/StringBuilder
    //   633: dup
    //   634: ldc_w 358
    //   637: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   640: aload 11
    //   642: getfield 205	com/tencent/beacon/b/a$b:c	J
    //   645: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   648: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: iconst_0
    //   652: anewarray 4	java/lang/Object
    //   655: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   658: aload_0
    //   659: astore 10
    //   661: aload_1
    //   662: astore 9
    //   664: aload 7
    //   666: astore 8
    //   668: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   671: lstore 5
    //   673: aload_0
    //   674: astore 10
    //   676: aload_1
    //   677: astore 9
    //   679: aload 7
    //   681: astore 8
    //   683: aload_0
    //   684: invokevirtual 196	java/io/InputStream:read	()I
    //   687: pop
    //   688: aload_0
    //   689: astore 10
    //   691: aload_1
    //   692: astore 9
    //   694: aload 7
    //   696: astore 8
    //   698: aload 11
    //   700: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   703: lload 5
    //   705: lsub
    //   706: putfield 207	com/tencent/beacon/b/a$b:d	J
    //   709: aload_0
    //   710: astore 10
    //   712: aload_1
    //   713: astore 9
    //   715: aload 7
    //   717: astore 8
    //   719: new 98	java/lang/StringBuilder
    //   722: dup
    //   723: ldc_w 360
    //   726: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   729: aload 11
    //   731: getfield 207	com/tencent/beacon/b/a$b:d	J
    //   734: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   737: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: iconst_0
    //   741: anewarray 4	java/lang/Object
    //   744: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   747: aload_0
    //   748: astore 10
    //   750: aload_1
    //   751: astore 9
    //   753: aload 7
    //   755: astore 8
    //   757: sipush 500
    //   760: newarray byte
    //   762: astore_2
    //   763: aload_0
    //   764: astore 10
    //   766: aload_1
    //   767: astore 9
    //   769: aload 7
    //   771: astore 8
    //   773: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   776: lstore 5
    //   778: aload_0
    //   779: astore 10
    //   781: aload_1
    //   782: astore 9
    //   784: aload 7
    //   786: astore 8
    //   788: aload_0
    //   789: aload_2
    //   790: invokevirtual 363	java/io/InputStream:read	([B)I
    //   793: pop
    //   794: aload_0
    //   795: astore 10
    //   797: aload_1
    //   798: astore 9
    //   800: aload 7
    //   802: astore 8
    //   804: aload 11
    //   806: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   809: lload 5
    //   811: lsub
    //   812: putfield 209	com/tencent/beacon/b/a$b:e	J
    //   815: aload_0
    //   816: astore 10
    //   818: aload_1
    //   819: astore 9
    //   821: aload 7
    //   823: astore 8
    //   825: new 98	java/lang/StringBuilder
    //   828: dup
    //   829: ldc_w 365
    //   832: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   835: aload 11
    //   837: getfield 209	com/tencent/beacon/b/a$b:e	J
    //   840: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   843: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: iconst_0
    //   847: anewarray 4	java/lang/Object
    //   850: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   853: aload_1
    //   854: ifnull +7 -> 861
    //   857: aload_1
    //   858: invokevirtual 222	java/io/OutputStream:close	()V
    //   861: aload_0
    //   862: ifnull +7 -> 869
    //   865: aload_0
    //   866: invokevirtual 223	java/io/InputStream:close	()V
    //   869: aload 7
    //   871: invokevirtual 118	java/net/Socket:close	()V
    //   874: aload 11
    //   876: areturn
    //   877: astore_0
    //   878: aload_0
    //   879: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   882: aload_0
    //   883: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   886: iconst_0
    //   887: anewarray 4	java/lang/Object
    //   890: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   893: aload 11
    //   895: areturn
    //   896: ldc 25
    //   898: astore_0
    //   899: goto -429 -> 470
    //   902: astore_1
    //   903: aload_1
    //   904: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   907: goto -46 -> 861
    //   910: astore_0
    //   911: aload_0
    //   912: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   915: goto -46 -> 869
    //   918: astore_1
    //   919: aload_1
    //   920: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   923: goto -653 -> 270
    //   926: astore_0
    //   927: aload_0
    //   928: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   931: goto -653 -> 278
    //   934: astore_0
    //   935: aconst_null
    //   936: astore_1
    //   937: aconst_null
    //   938: astore 7
    //   940: aload 8
    //   942: astore_2
    //   943: aload_1
    //   944: ifnull +7 -> 951
    //   947: aload_1
    //   948: invokevirtual 222	java/io/OutputStream:close	()V
    //   951: aload_2
    //   952: ifnull +7 -> 959
    //   955: aload_2
    //   956: invokevirtual 223	java/io/InputStream:close	()V
    //   959: aload 7
    //   961: ifnull +8 -> 969
    //   964: aload 7
    //   966: invokevirtual 118	java/net/Socket:close	()V
    //   969: aload_0
    //   970: athrow
    //   971: astore_1
    //   972: aload_1
    //   973: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   976: goto -25 -> 951
    //   979: astore_1
    //   980: aload_1
    //   981: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   984: goto -25 -> 959
    //   987: astore_1
    //   988: aload_1
    //   989: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   992: aload_1
    //   993: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   996: iconst_0
    //   997: anewarray 4	java/lang/Object
    //   1000: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1003: goto -34 -> 969
    //   1006: astore_0
    //   1007: aconst_null
    //   1008: astore_1
    //   1009: aload 8
    //   1011: astore_2
    //   1012: goto -69 -> 943
    //   1015: astore_0
    //   1016: aload 8
    //   1018: astore_2
    //   1019: goto -76 -> 943
    //   1022: astore_0
    //   1023: aload 10
    //   1025: astore_2
    //   1026: aload 9
    //   1028: astore_1
    //   1029: aload 8
    //   1031: astore 7
    //   1033: goto -90 -> 943
    //   1036: astore_2
    //   1037: aconst_null
    //   1038: astore_1
    //   1039: aconst_null
    //   1040: astore_0
    //   1041: goto -814 -> 227
    //   1044: astore_2
    //   1045: aconst_null
    //   1046: astore_0
    //   1047: goto -820 -> 227
    //   1050: astore_2
    //   1051: goto -824 -> 227
    //   1054: astore 7
    //   1056: goto -848 -> 208
    //   1059: astore_2
    //   1060: aconst_null
    //   1061: astore_2
    //   1062: goto -854 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1065	0	paramString1	String
    //   0	1065	1	paramString2	String
    //   0	1065	2	paramString3	String
    //   151	164	3	i	int
    //   183	134	4	j	int
    //   90	720	5	l	long
    //   143	889	7	localObject1	Object
    //   1054	1	7	localException	Exception
    //   1	1029	8	localObject2	Object
    //   85	942	9	localObject3	Object
    //   168	856	10	localObject4	Object
    //   53	841	11	localb	b
    // Exception table:
    //   from	to	target	type
    //   77	92	219	java/lang/Throwable
    //   92	97	219	java/lang/Throwable
    //   97	108	219	java/lang/Throwable
    //   108	150	219	java/lang/Throwable
    //   152	170	219	java/lang/Throwable
    //   185	201	219	java/lang/Throwable
    //   208	216	219	java/lang/Throwable
    //   321	376	219	java/lang/Throwable
    //   286	291	294	java/io/IOException
    //   869	874	877	java/io/IOException
    //   857	861	902	java/io/IOException
    //   865	869	910	java/io/IOException
    //   266	270	918	java/io/IOException
    //   274	278	926	java/io/IOException
    //   77	92	934	finally
    //   92	97	934	finally
    //   97	108	934	finally
    //   108	150	934	finally
    //   152	170	934	finally
    //   185	201	934	finally
    //   208	216	934	finally
    //   321	376	934	finally
    //   947	951	971	java/io/IOException
    //   955	959	979	java/io/IOException
    //   964	969	987	java/io/IOException
    //   376	470	1006	finally
    //   470	543	1006	finally
    //   543	549	1015	finally
    //   237	241	1022	finally
    //   251	262	1022	finally
    //   559	564	1022	finally
    //   574	585	1022	finally
    //   595	599	1022	finally
    //   609	620	1022	finally
    //   630	658	1022	finally
    //   668	673	1022	finally
    //   683	688	1022	finally
    //   698	709	1022	finally
    //   719	747	1022	finally
    //   757	763	1022	finally
    //   773	778	1022	finally
    //   788	794	1022	finally
    //   804	815	1022	finally
    //   825	853	1022	finally
    //   376	470	1036	java/lang/Throwable
    //   470	543	1036	java/lang/Throwable
    //   543	549	1044	java/lang/Throwable
    //   559	564	1050	java/lang/Throwable
    //   574	585	1050	java/lang/Throwable
    //   595	599	1050	java/lang/Throwable
    //   609	620	1050	java/lang/Throwable
    //   630	658	1050	java/lang/Throwable
    //   668	673	1050	java/lang/Throwable
    //   683	688	1050	java/lang/Throwable
    //   698	709	1050	java/lang/Throwable
    //   719	747	1050	java/lang/Throwable
    //   757	763	1050	java/lang/Throwable
    //   773	778	1050	java/lang/Throwable
    //   788	794	1050	java/lang/Throwable
    //   804	815	1050	java/lang/Throwable
    //   825	853	1050	java/lang/Throwable
    //   97	108	1054	java/lang/Exception
    //   92	97	1059	java/lang/Exception
  }
  
  /* Error */
  public static b a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: ifnull +12 -> 16
    //   7: aload_0
    //   8: ldc 25
    //   10: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +7 -> 20
    //   16: aconst_null
    //   17: astore_0
    //   18: aload_0
    //   19: areturn
    //   20: new 9	com/tencent/beacon/b/a$b
    //   23: dup
    //   24: invokespecial 141	com/tencent/beacon/b/a$b:<init>	()V
    //   27: astore 12
    //   29: new 143	java/net/URL
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 144	java/net/URL:<init>	(Ljava/lang/String;)V
    //   37: astore 9
    //   39: aload 9
    //   41: invokevirtual 369	java/net/URL:getHost	()Ljava/lang/String;
    //   44: astore 6
    //   46: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   49: lstore 4
    //   51: aload 6
    //   53: invokestatic 284	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   56: astore 8
    //   58: aload 12
    //   60: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   63: lload 4
    //   65: lsub
    //   66: putfield 199	com/tencent/beacon/b/a$b:a	J
    //   69: new 98	java/lang/StringBuilder
    //   72: dup
    //   73: ldc_w 371
    //   76: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload 12
    //   81: getfield 199	com/tencent/beacon/b/a$b:a	J
    //   84: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: new 288	java/lang/StringBuffer
    //   100: dup
    //   101: invokespecial 289	java/lang/StringBuffer:<init>	()V
    //   104: astore_0
    //   105: aload 8
    //   107: invokevirtual 293	java/net/InetAddress:getAddress	()[B
    //   110: astore 10
    //   112: iconst_0
    //   113: istore_2
    //   114: iload_2
    //   115: aload 10
    //   117: arraylength
    //   118: if_icmpge +52 -> 170
    //   121: new 98	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 295
    //   128: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: astore 11
    //   133: aload 10
    //   135: iload_2
    //   136: baload
    //   137: ifge +927 -> 1064
    //   140: aload 10
    //   142: iload_2
    //   143: baload
    //   144: sipush 256
    //   147: iadd
    //   148: istore_3
    //   149: aload_0
    //   150: aload 11
    //   152: iload_3
    //   153: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokevirtual 298	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   162: pop
    //   163: iload_2
    //   164: iconst_1
    //   165: iadd
    //   166: istore_2
    //   167: goto -53 -> 114
    //   170: aload 12
    //   172: aload_0
    //   173: iconst_1
    //   174: invokevirtual 302	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   177: putfield 201	com/tencent/beacon/b/a$b:f	Ljava/lang/String;
    //   180: aload_0
    //   181: iconst_0
    //   182: invokevirtual 305	java/lang/StringBuffer:setLength	(I)V
    //   185: aload 12
    //   187: astore_0
    //   188: iload_1
    //   189: ifne -171 -> 18
    //   192: aload 9
    //   194: invokevirtual 374	java/net/URL:getPort	()I
    //   197: istore_2
    //   198: iload_2
    //   199: iflt +585 -> 784
    //   202: new 86	java/net/InetSocketAddress
    //   205: dup
    //   206: aload 8
    //   208: iload_2
    //   209: invokespecial 377	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
    //   212: astore_0
    //   213: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   216: lstore 4
    //   218: new 91	java/net/Socket
    //   221: dup
    //   222: invokespecial 92	java/net/Socket:<init>	()V
    //   225: astore 8
    //   227: aload 8
    //   229: aload_0
    //   230: sipush 30000
    //   233: invokevirtual 96	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   236: aload 12
    //   238: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   241: lload 4
    //   243: lsub
    //   244: putfield 203	com/tencent/beacon/b/a$b:b	J
    //   247: new 98	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 317
    //   254: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload 12
    //   259: getfield 203	com/tencent/beacon/b/a$b:b	J
    //   262: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: iconst_0
    //   269: anewarray 4	java/lang/Object
    //   272: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: new 98	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   282: aload 9
    //   284: invokevirtual 321	java/net/URL:getPath	()Ljava/lang/String;
    //   287: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: astore 10
    //   292: aload 9
    //   294: invokevirtual 324	java/net/URL:getQuery	()Ljava/lang/String;
    //   297: ifnull +493 -> 790
    //   300: new 98	java/lang/StringBuilder
    //   303: dup
    //   304: ldc_w 326
    //   307: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   310: aload 9
    //   312: invokevirtual 324	java/net/URL:getQuery	()Ljava/lang/String;
    //   315: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: astore_0
    //   322: aload 10
    //   324: aload_0
    //   325: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: astore_0
    //   332: new 98	java/lang/StringBuilder
    //   335: dup
    //   336: ldc_w 328
    //   339: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: aload_0
    //   343: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc_w 330
    //   349: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload 6
    //   354: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc_w 332
    //   360: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: astore 13
    //   368: aload 8
    //   370: invokevirtual 342	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   373: astore 6
    //   375: aload 8
    //   377: invokevirtual 343	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   380: astore_0
    //   381: aload_0
    //   382: astore 11
    //   384: aload 6
    //   386: astore 10
    //   388: aload 8
    //   390: astore 9
    //   392: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   395: lstore 4
    //   397: aload_0
    //   398: astore 11
    //   400: aload 6
    //   402: astore 10
    //   404: aload 8
    //   406: astore 9
    //   408: aload 6
    //   410: aload 13
    //   412: ldc_w 345
    //   415: invokevirtual 349	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   418: invokevirtual 353	java/io/OutputStream:write	([B)V
    //   421: aload_0
    //   422: astore 11
    //   424: aload 6
    //   426: astore 10
    //   428: aload 8
    //   430: astore 9
    //   432: aload 6
    //   434: invokevirtual 356	java/io/OutputStream:flush	()V
    //   437: aload_0
    //   438: astore 11
    //   440: aload 6
    //   442: astore 10
    //   444: aload 8
    //   446: astore 9
    //   448: aload 12
    //   450: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   453: lload 4
    //   455: lsub
    //   456: putfield 205	com/tencent/beacon/b/a$b:c	J
    //   459: aload_0
    //   460: astore 11
    //   462: aload 6
    //   464: astore 10
    //   466: aload 8
    //   468: astore 9
    //   470: new 98	java/lang/StringBuilder
    //   473: dup
    //   474: ldc_w 358
    //   477: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   480: aload 12
    //   482: getfield 205	com/tencent/beacon/b/a$b:c	J
    //   485: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   488: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: iconst_0
    //   492: anewarray 4	java/lang/Object
    //   495: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   498: aload_0
    //   499: astore 11
    //   501: aload 6
    //   503: astore 10
    //   505: aload 8
    //   507: astore 9
    //   509: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   512: lstore 4
    //   514: aload_0
    //   515: astore 11
    //   517: aload 6
    //   519: astore 10
    //   521: aload 8
    //   523: astore 9
    //   525: aload_0
    //   526: invokevirtual 196	java/io/InputStream:read	()I
    //   529: pop
    //   530: aload_0
    //   531: astore 11
    //   533: aload 6
    //   535: astore 10
    //   537: aload 8
    //   539: astore 9
    //   541: aload 12
    //   543: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   546: lload 4
    //   548: lsub
    //   549: putfield 207	com/tencent/beacon/b/a$b:d	J
    //   552: aload_0
    //   553: astore 11
    //   555: aload 6
    //   557: astore 10
    //   559: aload 8
    //   561: astore 9
    //   563: new 98	java/lang/StringBuilder
    //   566: dup
    //   567: ldc_w 360
    //   570: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   573: aload 12
    //   575: getfield 207	com/tencent/beacon/b/a$b:d	J
    //   578: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   581: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: iconst_0
    //   585: anewarray 4	java/lang/Object
    //   588: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: aload_0
    //   592: astore 11
    //   594: aload 6
    //   596: astore 10
    //   598: aload 8
    //   600: astore 9
    //   602: sipush 500
    //   605: newarray byte
    //   607: astore 7
    //   609: aload_0
    //   610: astore 11
    //   612: aload 6
    //   614: astore 10
    //   616: aload 8
    //   618: astore 9
    //   620: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   623: lstore 4
    //   625: aload_0
    //   626: astore 11
    //   628: aload 6
    //   630: astore 10
    //   632: aload 8
    //   634: astore 9
    //   636: aload_0
    //   637: aload 7
    //   639: invokevirtual 363	java/io/InputStream:read	([B)I
    //   642: istore_2
    //   643: aload_0
    //   644: astore 11
    //   646: aload 6
    //   648: astore 10
    //   650: aload 8
    //   652: astore 9
    //   654: aload 12
    //   656: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   659: lload 4
    //   661: lsub
    //   662: putfield 209	com/tencent/beacon/b/a$b:e	J
    //   665: aload_0
    //   666: astore 11
    //   668: aload 6
    //   670: astore 10
    //   672: aload 8
    //   674: astore 9
    //   676: new 98	java/lang/StringBuilder
    //   679: dup
    //   680: ldc_w 365
    //   683: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   686: aload 12
    //   688: getfield 209	com/tencent/beacon/b/a$b:e	J
    //   691: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   694: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: iconst_0
    //   698: anewarray 4	java/lang/Object
    //   701: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   704: aload_0
    //   705: astore 11
    //   707: aload 6
    //   709: astore 10
    //   711: aload 8
    //   713: astore 9
    //   715: new 98	java/lang/StringBuilder
    //   718: dup
    //   719: ldc_w 379
    //   722: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   725: iload_2
    //   726: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: iconst_0
    //   733: anewarray 4	java/lang/Object
    //   736: invokestatic 115	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   739: aload 6
    //   741: ifnull +8 -> 749
    //   744: aload 6
    //   746: invokevirtual 222	java/io/OutputStream:close	()V
    //   749: aload_0
    //   750: ifnull +7 -> 757
    //   753: aload_0
    //   754: invokevirtual 223	java/io/InputStream:close	()V
    //   757: aload 8
    //   759: invokevirtual 118	java/net/Socket:close	()V
    //   762: aload 12
    //   764: areturn
    //   765: astore_0
    //   766: aload_0
    //   767: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   770: aload_0
    //   771: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   774: iconst_0
    //   775: anewarray 4	java/lang/Object
    //   778: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   781: aload 12
    //   783: areturn
    //   784: bipush 80
    //   786: istore_2
    //   787: goto -585 -> 202
    //   790: ldc 25
    //   792: astore_0
    //   793: goto -471 -> 322
    //   796: astore 6
    //   798: aload 6
    //   800: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   803: goto -54 -> 749
    //   806: astore_0
    //   807: aload_0
    //   808: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   811: goto -54 -> 757
    //   814: astore 7
    //   816: aconst_null
    //   817: astore 6
    //   819: aconst_null
    //   820: astore 8
    //   822: aconst_null
    //   823: astore_0
    //   824: aload_0
    //   825: astore 11
    //   827: aload 6
    //   829: astore 10
    //   831: aload 8
    //   833: astore 9
    //   835: aload 7
    //   837: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   840: aload_0
    //   841: astore 11
    //   843: aload 6
    //   845: astore 10
    //   847: aload 8
    //   849: astore 9
    //   851: aload 7
    //   853: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   856: iconst_0
    //   857: anewarray 4	java/lang/Object
    //   860: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   863: aload 6
    //   865: ifnull +8 -> 873
    //   868: aload 6
    //   870: invokevirtual 222	java/io/OutputStream:close	()V
    //   873: aload_0
    //   874: ifnull +7 -> 881
    //   877: aload_0
    //   878: invokevirtual 223	java/io/InputStream:close	()V
    //   881: aload 12
    //   883: astore_0
    //   884: aload 8
    //   886: ifnull -868 -> 18
    //   889: aload 8
    //   891: invokevirtual 118	java/net/Socket:close	()V
    //   894: aload 12
    //   896: areturn
    //   897: astore_0
    //   898: aload_0
    //   899: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   902: aload_0
    //   903: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   906: iconst_0
    //   907: anewarray 4	java/lang/Object
    //   910: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: aload 12
    //   915: areturn
    //   916: astore 6
    //   918: aload 6
    //   920: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   923: goto -50 -> 873
    //   926: astore_0
    //   927: aload_0
    //   928: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   931: goto -50 -> 881
    //   934: astore_0
    //   935: aconst_null
    //   936: astore 6
    //   938: aconst_null
    //   939: astore 8
    //   941: aload 6
    //   943: ifnull +8 -> 951
    //   946: aload 6
    //   948: invokevirtual 222	java/io/OutputStream:close	()V
    //   951: aload 7
    //   953: ifnull +8 -> 961
    //   956: aload 7
    //   958: invokevirtual 223	java/io/InputStream:close	()V
    //   961: aload 8
    //   963: ifnull +8 -> 971
    //   966: aload 8
    //   968: invokevirtual 118	java/net/Socket:close	()V
    //   971: aload_0
    //   972: athrow
    //   973: astore 6
    //   975: aload 6
    //   977: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   980: goto -29 -> 951
    //   983: astore 6
    //   985: aload 6
    //   987: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   990: goto -29 -> 961
    //   993: astore 6
    //   995: aload 6
    //   997: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   1000: aload 6
    //   1002: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1005: iconst_0
    //   1006: anewarray 4	java/lang/Object
    //   1009: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1012: goto -41 -> 971
    //   1015: astore_0
    //   1016: aconst_null
    //   1017: astore 6
    //   1019: goto -78 -> 941
    //   1022: astore_0
    //   1023: goto -82 -> 941
    //   1026: astore_0
    //   1027: aload 11
    //   1029: astore 7
    //   1031: aload 10
    //   1033: astore 6
    //   1035: aload 9
    //   1037: astore 8
    //   1039: goto -98 -> 941
    //   1042: astore 7
    //   1044: aconst_null
    //   1045: astore 6
    //   1047: aconst_null
    //   1048: astore_0
    //   1049: goto -225 -> 824
    //   1052: astore 7
    //   1054: aconst_null
    //   1055: astore_0
    //   1056: goto -232 -> 824
    //   1059: astore 7
    //   1061: goto -237 -> 824
    //   1064: aload 10
    //   1066: iload_2
    //   1067: baload
    //   1068: istore_3
    //   1069: goto -920 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1072	0	paramString	String
    //   0	1072	1	paramBoolean	boolean
    //   113	954	2	i	int
    //   148	921	3	j	int
    //   49	611	4	l	long
    //   44	701	6	localObject1	Object
    //   796	3	6	localIOException1	java.io.IOException
    //   817	52	6	localObject2	Object
    //   916	3	6	localIOException2	java.io.IOException
    //   936	11	6	localObject3	Object
    //   973	3	6	localIOException3	java.io.IOException
    //   983	3	6	localIOException4	java.io.IOException
    //   993	8	6	localIOException5	java.io.IOException
    //   1017	29	6	localObject4	Object
    //   1	637	7	arrayOfByte	byte[]
    //   814	143	7	localThrowable1	Throwable
    //   1029	1	7	localObject5	Object
    //   1042	1	7	localThrowable2	Throwable
    //   1052	1	7	localThrowable3	Throwable
    //   1059	1	7	localThrowable4	Throwable
    //   56	982	8	localObject6	Object
    //   37	999	9	localObject7	Object
    //   110	955	10	localObject8	Object
    //   131	897	11	localObject9	Object
    //   27	887	12	localb	b
    //   366	45	13	str	String
    // Exception table:
    //   from	to	target	type
    //   757	762	765	java/io/IOException
    //   744	749	796	java/io/IOException
    //   753	757	806	java/io/IOException
    //   29	112	814	java/lang/Throwable
    //   114	133	814	java/lang/Throwable
    //   149	163	814	java/lang/Throwable
    //   170	185	814	java/lang/Throwable
    //   192	198	814	java/lang/Throwable
    //   202	227	814	java/lang/Throwable
    //   889	894	897	java/io/IOException
    //   868	873	916	java/io/IOException
    //   877	881	926	java/io/IOException
    //   29	112	934	finally
    //   114	133	934	finally
    //   149	163	934	finally
    //   170	185	934	finally
    //   192	198	934	finally
    //   202	227	934	finally
    //   946	951	973	java/io/IOException
    //   956	961	983	java/io/IOException
    //   966	971	993	java/io/IOException
    //   227	322	1015	finally
    //   322	375	1015	finally
    //   375	381	1022	finally
    //   392	397	1026	finally
    //   408	421	1026	finally
    //   432	437	1026	finally
    //   448	459	1026	finally
    //   470	498	1026	finally
    //   509	514	1026	finally
    //   525	530	1026	finally
    //   541	552	1026	finally
    //   563	591	1026	finally
    //   602	609	1026	finally
    //   620	625	1026	finally
    //   636	643	1026	finally
    //   654	665	1026	finally
    //   676	704	1026	finally
    //   715	739	1026	finally
    //   835	840	1026	finally
    //   851	863	1026	finally
    //   227	322	1042	java/lang/Throwable
    //   322	375	1042	java/lang/Throwable
    //   375	381	1052	java/lang/Throwable
    //   392	397	1059	java/lang/Throwable
    //   408	421	1059	java/lang/Throwable
    //   432	437	1059	java/lang/Throwable
    //   448	459	1059	java/lang/Throwable
    //   470	498	1059	java/lang/Throwable
    //   509	514	1059	java/lang/Throwable
    //   525	530	1059	java/lang/Throwable
    //   541	552	1059	java/lang/Throwable
    //   563	591	1059	java/lang/Throwable
    //   602	609	1059	java/lang/Throwable
    //   620	625	1059	java/lang/Throwable
    //   636	643	1059	java/lang/Throwable
    //   654	665	1059	java/lang/Throwable
    //   676	704	1059	java/lang/Throwable
    //   715	739	1059	java/lang/Throwable
  }
  
  public static a a(Context paramContext)
  {
    if (f == null) {
      f = new a(paramContext);
    }
    return f;
  }
  
  /* Error */
  public static com.tencent.beacon.c.a.b a(int paramInt1, com.tencent.beacon.a.e parame, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 387
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 139	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_1
    //   11: ifnonnull +15 -> 26
    //   14: ldc_w 389
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aconst_null
    //   25: areturn
    //   26: new 391	com/tencent/beacon/c/a/b
    //   29: dup
    //   30: invokespecial 392	com/tencent/beacon/c/a/b:<init>	()V
    //   33: astore 5
    //   35: aload_1
    //   36: monitorenter
    //   37: aload 5
    //   39: aload_1
    //   40: invokevirtual 394	com/tencent/beacon/a/e:a	()Ljava/lang/String;
    //   43: putfield 397	com/tencent/beacon/c/a/b:j	Ljava/lang/String;
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 399	com/tencent/beacon/a/e:b	()Ljava/lang/String;
    //   52: putfield 402	com/tencent/beacon/c/a/b:k	Ljava/lang/String;
    //   55: aload 5
    //   57: aload_1
    //   58: invokevirtual 405	com/tencent/beacon/a/e:c	()B
    //   61: putfield 408	com/tencent/beacon/c/a/b:a	B
    //   64: aload 5
    //   66: aload_1
    //   67: invokevirtual 410	com/tencent/beacon/a/e:j	()Ljava/lang/String;
    //   70: putfield 411	com/tencent/beacon/c/a/b:b	Ljava/lang/String;
    //   73: aload 5
    //   75: aload_1
    //   76: invokevirtual 413	com/tencent/beacon/a/e:d	()Ljava/lang/String;
    //   79: putfield 414	com/tencent/beacon/c/a/b:c	Ljava/lang/String;
    //   82: aload 5
    //   84: aload_1
    //   85: invokevirtual 416	com/tencent/beacon/a/e:e	()Ljava/lang/String;
    //   88: putfield 417	com/tencent/beacon/c/a/b:d	Ljava/lang/String;
    //   91: aload 5
    //   93: aload_1
    //   94: invokevirtual 419	com/tencent/beacon/a/e:f	()Ljava/lang/String;
    //   97: putfield 420	com/tencent/beacon/c/a/b:e	Ljava/lang/String;
    //   100: aload 5
    //   102: ldc 25
    //   104: putfield 423	com/tencent/beacon/c/a/b:l	Ljava/lang/String;
    //   107: iload_0
    //   108: bipush 100
    //   110: if_icmpne +359 -> 469
    //   113: new 425	java/util/HashMap
    //   116: dup
    //   117: invokespecial 426	java/util/HashMap:<init>	()V
    //   120: astore 6
    //   122: aload 6
    //   124: ldc_w 428
    //   127: new 98	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   134: invokestatic 433	com/tencent/beacon/event/UserAction:getUserID	()Ljava/lang/String;
    //   137: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokeinterface 439 3 0
    //   148: pop
    //   149: aload 6
    //   151: ldc_w 441
    //   154: new 98	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   161: aload_1
    //   162: invokevirtual 45	com/tencent/beacon/a/e:i	()Ljava/lang/String;
    //   165: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokeinterface 439 3 0
    //   176: pop
    //   177: aload_1
    //   178: invokevirtual 444	com/tencent/beacon/a/e:l	()Landroid/content/Context;
    //   181: invokestatic 449	com/tencent/beacon/event/d:a	(Landroid/content/Context;)Lcom/tencent/beacon/event/d;
    //   184: astore 7
    //   186: aload 6
    //   188: ldc_w 451
    //   191: new 98	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   198: aload 7
    //   200: invokevirtual 452	com/tencent/beacon/event/d:b	()Ljava/lang/String;
    //   203: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokeinterface 439 3 0
    //   214: pop
    //   215: aload 6
    //   217: ldc_w 454
    //   220: new 98	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   227: aload 7
    //   229: invokevirtual 455	com/tencent/beacon/event/d:a	()Ljava/lang/String;
    //   232: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokeinterface 439 3 0
    //   243: pop
    //   244: aload 6
    //   246: ldc_w 457
    //   249: new 98	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   256: aload 7
    //   258: invokevirtual 459	com/tencent/beacon/event/d:c	()Ljava/lang/String;
    //   261: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokeinterface 439 3 0
    //   272: pop
    //   273: new 98	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   280: astore 8
    //   282: aload_1
    //   283: invokevirtual 444	com/tencent/beacon/a/e:l	()Landroid/content/Context;
    //   286: astore 9
    //   288: getstatic 382	com/tencent/beacon/b/a:f	Lcom/tencent/beacon/b/a;
    //   291: ifnonnull +15 -> 306
    //   294: new 2	com/tencent/beacon/b/a
    //   297: dup
    //   298: aload 9
    //   300: invokespecial 384	com/tencent/beacon/b/a:<init>	(Landroid/content/Context;)V
    //   303: putstatic 382	com/tencent/beacon/b/a:f	Lcom/tencent/beacon/b/a;
    //   306: aload 6
    //   308: ldc_w 461
    //   311: aload 8
    //   313: getstatic 382	com/tencent/beacon/b/a:f	Lcom/tencent/beacon/b/a;
    //   316: invokevirtual 462	com/tencent/beacon/b/a:a	()Ljava/lang/String;
    //   319: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokeinterface 439 3 0
    //   330: pop
    //   331: aload 6
    //   333: ldc_w 464
    //   336: new 98	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   343: aload 7
    //   345: invokevirtual 465	com/tencent/beacon/event/d:d	()Ljava/lang/String;
    //   348: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokeinterface 439 3 0
    //   359: pop
    //   360: aload_1
    //   361: invokevirtual 444	com/tencent/beacon/a/e:l	()Landroid/content/Context;
    //   364: invokestatic 50	com/tencent/beacon/a/g:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/g;
    //   367: pop
    //   368: aload 6
    //   370: ldc_w 467
    //   373: aload_1
    //   374: invokevirtual 444	com/tencent/beacon/a/e:l	()Landroid/content/Context;
    //   377: invokestatic 469	com/tencent/beacon/a/g:k	(Landroid/content/Context;)Ljava/lang/String;
    //   380: invokeinterface 439 3 0
    //   385: pop
    //   386: aload_1
    //   387: invokevirtual 444	com/tencent/beacon/a/e:l	()Landroid/content/Context;
    //   390: invokestatic 473	com/tencent/beacon/a/a:g	(Landroid/content/Context;)Z
    //   393: ifeq +120 -> 513
    //   396: aload 6
    //   398: ldc_w 475
    //   401: ldc_w 477
    //   404: invokeinterface 439 3 0
    //   409: pop
    //   410: aload 6
    //   412: ldc_w 479
    //   415: aload_1
    //   416: invokevirtual 444	com/tencent/beacon/a/e:l	()Landroid/content/Context;
    //   419: invokestatic 481	com/tencent/beacon/a/a:i	(Landroid/content/Context;)Ljava/lang/String;
    //   422: invokeinterface 439 3 0
    //   427: pop
    //   428: aload 6
    //   430: ldc_w 483
    //   433: new 98	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   440: aload_1
    //   441: invokevirtual 444	com/tencent/beacon/a/e:l	()Landroid/content/Context;
    //   444: invokestatic 487	com/tencent/beacon/a/a:h	(Landroid/content/Context;)I
    //   447: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokeinterface 439 3 0
    //   458: pop
    //   459: aload 5
    //   461: aload 6
    //   463: invokestatic 490	com/tencent/beacon/a/g:a	(Ljava/util/Map;)Ljava/lang/String;
    //   466: putfield 423	com/tencent/beacon/c/a/b:l	Ljava/lang/String;
    //   469: aload_1
    //   470: monitorexit
    //   471: aload 5
    //   473: iload_0
    //   474: putfield 492	com/tencent/beacon/c/a/b:f	I
    //   477: aload 5
    //   479: iload 4
    //   481: i2b
    //   482: putfield 494	com/tencent/beacon/c/a/b:h	B
    //   485: aload 5
    //   487: iload_3
    //   488: i2b
    //   489: putfield 496	com/tencent/beacon/c/a/b:i	B
    //   492: aload_2
    //   493: astore_1
    //   494: aload_2
    //   495: ifnonnull +9 -> 504
    //   498: ldc 25
    //   500: invokevirtual 498	java/lang/String:getBytes	()[B
    //   503: astore_1
    //   504: aload 5
    //   506: aload_1
    //   507: putfield 501	com/tencent/beacon/c/a/b:g	[B
    //   510: aload 5
    //   512: areturn
    //   513: aload 6
    //   515: ldc_w 475
    //   518: ldc_w 502
    //   521: invokeinterface 439 3 0
    //   526: pop
    //   527: goto -117 -> 410
    //   530: astore_2
    //   531: aload_1
    //   532: monitorexit
    //   533: aload_2
    //   534: athrow
    //   535: astore_1
    //   536: aload_1
    //   537: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   540: aconst_null
    //   541: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	542	0	paramInt1	int
    //   0	542	1	parame	com.tencent.beacon.a.e
    //   0	542	2	paramArrayOfByte	byte[]
    //   0	542	3	paramInt2	int
    //   0	542	4	paramInt3	int
    //   33	478	5	localb	com.tencent.beacon.c.a.b
    //   120	394	6	localHashMap	java.util.HashMap
    //   184	160	7	locald	com.tencent.beacon.event.d
    //   280	32	8	localStringBuilder	java.lang.StringBuilder
    //   286	13	9	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   37	107	530	finally
    //   113	306	530	finally
    //   306	410	530	finally
    //   410	469	530	finally
    //   469	471	530	finally
    //   513	527	530	finally
    //   26	37	535	java/lang/Throwable
    //   471	492	535	java/lang/Throwable
    //   498	504	535	java/lang/Throwable
    //   504	510	535	java/lang/Throwable
    //   531	535	535	java/lang/Throwable
  }
  
  /* Error */
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 505
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 139	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +8 -> 19
    //   14: aload_0
    //   15: arraylength
    //   16: ifge +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 507	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 509	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: astore_3
    //   30: new 511	java/io/ObjectInputStream
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 514	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_1
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 518	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 519	java/io/ObjectInputStream:close	()V
    //   50: aload_3
    //   51: invokevirtual 520	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: areturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   61: aload_2
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 519	java/io/ObjectInputStream:close	()V
    //   101: aload_3
    //   102: invokevirtual 520	java/io/ByteArrayInputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   119: goto -18 -> 101
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 519	java/io/ObjectInputStream:close	()V
    //   133: aload_3
    //   134: invokevirtual 520	java/io/ByteArrayInputStream:close	()V
    //   137: aload_1
    //   138: athrow
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   144: goto -11 -> 133
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   152: goto -15 -> 137
    //   155: astore_1
    //   156: goto -31 -> 125
    //   159: astore_2
    //   160: goto -86 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramArrayOfByte	byte[]
    //   38	60	1	localObjectInputStream	java.io.ObjectInputStream
    //   122	16	1	localObject1	Object
    //   155	1	1	localObject2	Object
    //   45	17	2	localObject3	Object
    //   71	12	2	localThrowable1	Throwable
    //   159	1	2	localThrowable2	Throwable
    //   29	105	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   50	54	56	java/io/IOException
    //   46	50	63	java/io/IOException
    //   30	39	71	java/lang/Throwable
    //   101	105	107	java/io/IOException
    //   97	101	114	java/io/IOException
    //   30	39	122	finally
    //   129	133	139	java/io/IOException
    //   133	137	147	java/io/IOException
    //   41	46	155	finally
    //   76	80	155	finally
    //   82	93	155	finally
    //   41	46	159	java/lang/Throwable
  }
  
  /* Error */
  public static ArrayList<String> a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 523	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 524	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 530	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: aload_0
    //   15: invokevirtual 534	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   18: astore_0
    //   19: new 536	java/io/BufferedReader
    //   22: dup
    //   23: new 538	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 541	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   31: invokespecial 542	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 545	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 548	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +44 -> 88
    //   47: aload 4
    //   49: aload_2
    //   50: invokevirtual 551	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: goto -16 -> 38
    //   57: astore 4
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 552	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 552	java/io/BufferedReader:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: new 536	java/io/BufferedReader
    //   91: dup
    //   92: new 538	java/io/InputStreamReader
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 555	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   100: invokespecial 542	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   103: invokespecial 545	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   106: astore_0
    //   107: aload_0
    //   108: astore_3
    //   109: aload_1
    //   110: astore_2
    //   111: aload_0
    //   112: invokevirtual 548	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +23 -> 142
    //   122: aload_0
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: aload 4
    //   128: aload 5
    //   130: invokevirtual 551	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: goto -27 -> 107
    //   137: astore 4
    //   139: goto -78 -> 61
    //   142: aload_1
    //   143: invokevirtual 552	java/io/BufferedReader:close	()V
    //   146: aload_0
    //   147: invokevirtual 552	java/io/BufferedReader:close	()V
    //   150: aload 4
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   158: aload 4
    //   160: areturn
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   166: goto -20 -> 146
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   174: goto -96 -> 78
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   182: goto -96 -> 86
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 552	java/io/BufferedReader:close	()V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 552	java/io/BufferedReader:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   211: goto -15 -> 196
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   219: goto -15 -> 204
    //   222: astore_0
    //   223: goto -35 -> 188
    //   226: astore_0
    //   227: aload_2
    //   228: astore_1
    //   229: goto -41 -> 188
    //   232: astore 4
    //   234: aconst_null
    //   235: astore_0
    //   236: aconst_null
    //   237: astore_1
    //   238: goto -177 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramArrayOfString	String[]
    //   37	106	1	localBufferedReader	java.io.BufferedReader
    //   161	2	1	localIOException1	java.io.IOException
    //   169	2	1	localIOException2	java.io.IOException
    //   187	6	1	localObject1	Object
    //   206	2	1	localIOException3	java.io.IOException
    //   214	2	1	localIOException4	java.io.IOException
    //   228	10	1	localObject2	Object
    //   42	186	2	localObject3	Object
    //   1	200	3	arrayOfString	String[]
    //   9	39	4	localArrayList	ArrayList
    //   57	70	4	localThrowable1	Throwable
    //   137	22	4	localThrowable2	Throwable
    //   232	1	4	localThrowable3	Throwable
    //   115	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   38	43	57	java/lang/Throwable
    //   47	54	57	java/lang/Throwable
    //   88	107	57	java/lang/Throwable
    //   111	117	137	java/lang/Throwable
    //   126	134	137	java/lang/Throwable
    //   146	150	153	java/io/IOException
    //   142	146	161	java/io/IOException
    //   74	78	169	java/io/IOException
    //   82	86	177	java/io/IOException
    //   11	38	185	finally
    //   192	196	206	java/io/IOException
    //   200	204	214	java/io/IOException
    //   38	43	222	finally
    //   47	54	222	finally
    //   88	107	222	finally
    //   65	70	226	finally
    //   111	117	226	finally
    //   126	134	226	finally
    //   11	38	232	java/lang/Throwable
  }
  
  public static HashSet<String> a(ArrayList<String> paramArrayList)
  {
    int i = paramArrayList.size();
    if ((paramArrayList != null) && (i > 0))
    {
      HashSet localHashSet = new HashSet(i);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localHashSet.add((String)paramArrayList.next());
      }
      return localHashSet;
    }
    return null;
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 583
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 139	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +13 -> 24
    //   14: ldc_w 585
    //   17: aload_0
    //   18: invokevirtual 590	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   21: ifne +15 -> 36
    //   24: ldc_w 592
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 594	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 596	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: invokespecial 597	java/io/ByteArrayOutputStream:<init>	()V
    //   43: astore 4
    //   45: new 599	java/io/ObjectOutputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 602	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: invokevirtual 606	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 607	java/io/ObjectOutputStream:flush	()V
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: invokevirtual 610	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 611	java/io/ObjectOutputStream:close	()V
    //   80: aload 4
    //   82: invokevirtual 612	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   92: aload_0
    //   93: areturn
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   99: goto -19 -> 80
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore_1
    //   107: aload_3
    //   108: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   111: aload_0
    //   112: astore_1
    //   113: aload_3
    //   114: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 126	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 611	java/io/ObjectOutputStream:close	()V
    //   132: aload 4
    //   134: invokevirtual 612	java/io/ByteArrayOutputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   151: goto -19 -> 132
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 611	java/io/ObjectOutputStream:close	()V
    //   165: aload 4
    //   167: invokevirtual 612	java/io/ByteArrayOutputStream:close	()V
    //   170: aload_0
    //   171: athrow
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   177: goto -12 -> 165
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   185: goto -15 -> 170
    //   188: astore_0
    //   189: goto -32 -> 157
    //   192: astore_3
    //   193: aload_2
    //   194: astore_0
    //   195: goto -90 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramObject	Object
    //   56	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   87	2	1	localIOException1	java.io.IOException
    //   94	2	1	localIOException2	java.io.IOException
    //   106	56	1	localObject	Object
    //   172	2	1	localIOException3	java.io.IOException
    //   180	2	1	localIOException4	java.io.IOException
    //   54	140	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   102	12	3	localThrowable1	Throwable
    //   192	1	3	localThrowable2	Throwable
    //   43	123	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   80	85	87	java/io/IOException
    //   76	80	94	java/io/IOException
    //   45	55	102	java/lang/Throwable
    //   132	137	139	java/io/IOException
    //   128	132	146	java/io/IOException
    //   45	55	154	finally
    //   161	165	172	java/io/IOException
    //   165	170	180	java/io/IOException
    //   57	62	188	finally
    //   64	68	188	finally
    //   70	76	188	finally
    //   107	111	188	finally
    //   113	124	188	finally
    //   57	62	192	java/lang/Throwable
    //   64	68	192	java/lang/Throwable
    //   70	76	192	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    com.tencent.beacon.d.a.b("zp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = g.a(paramInt, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.beacon.d.a.d("err zp : %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(a(paramArrayOfByte, paramInt1), paramInt2, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    com.tencent.beacon.d.a.b("enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    try
    {
      paramArrayOfByte = g.b(paramInt, paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.beacon.d.a.d("err enD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static Long[] a(LinkedHashMap<Long, Long> paramLinkedHashMap, long paramLong)
  {
    if ((paramLinkedHashMap == null) || (paramLinkedHashMap.size() <= 0) || (paramLong <= 0L)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramLinkedHashMap.keySet().iterator();
    long l1 = 0L;
    if ((localIterator.hasNext()) && (l1 < paramLong))
    {
      long l2 = ((Long)localIterator.next()).longValue();
      long l3 = ((Long)paramLinkedHashMap.get(Long.valueOf(l2))).longValue();
      if (l1 + l3 > paramLong) {
        break label140;
      }
      localArrayList.add(Long.valueOf(l2));
      l1 += l3;
    }
    label140:
    for (;;)
    {
      break;
      if (localArrayList.size() > 0) {
        return (Long[])localArrayList.toArray(new Long[1]);
      }
      return null;
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    com.tencent.beacon.d.a.b("unzp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = g.b(paramInt, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.beacon.d.a.d("err unzp}" + paramArrayOfByte.toString(), new Object[0]);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = b(b(paramArrayOfByte, paramInt2, paramString), paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    try
    {
      paramArrayOfByte = g.a(paramInt, paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.beacon.d.a.d("err unD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static long f()
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
      long l = localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date())).getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  public static String g()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public String a()
  {
    if ((this.a == null) || ("".equals(this.a))) {
      return this.b;
    }
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  static final class a
  {
    public String a = "";
    public int b = -1;
  }
  
  public static final class b
  {
    public long a = -1L;
    public long b = -1L;
    public long c = -1L;
    public long d = -1L;
    public long e = -1L;
    public String f = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.b.a
 * JD-Core Version:    0.7.0.1
 */