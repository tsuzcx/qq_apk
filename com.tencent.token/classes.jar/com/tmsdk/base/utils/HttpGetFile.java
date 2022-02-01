package com.tmsdk.base.utils;

import android.content.Context;
import btmsdkobf.bl;
import java.io.File;

public class HttpGetFile
  extends bl
{
  private String C = null;
  private String D = null;
  private String E = null;
  private String F = null;
  private int G = 0;
  private boolean H = false;
  private long I = 0L;
  private long J = 0L;
  private boolean K = false;
  private Context mContext;
  
  public HttpGetFile(Context paramContext)
  {
    this.mContext = paramContext;
    this.C = paramContext.getCacheDir().getAbsolutePath();
    this.D = paramContext.getFilesDir().getAbsolutePath();
  }
  
  /* Error */
  private int a(java.net.HttpURLConnection paramHttpURLConnection, android.os.Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 14
    //   15: aconst_null
    //   16: astore 15
    //   18: aconst_null
    //   19: astore 16
    //   21: aconst_null
    //   22: astore 11
    //   24: sipush 8192
    //   27: newarray byte
    //   29: astore 17
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 79	java/net/HttpURLConnection:getContentLength	()I
    //   36: i2l
    //   37: aload_0
    //   38: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   41: ladd
    //   42: putfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   45: aload_0
    //   46: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   49: ldc2_w 80
    //   52: lmul
    //   53: aload_0
    //   54: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   57: ldiv
    //   58: l2i
    //   59: istore 4
    //   61: new 53	java/io/File
    //   64: dup
    //   65: aload_0
    //   66: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   69: aload_0
    //   70: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   73: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: astore 8
    //   78: aload 8
    //   80: invokevirtual 88	java/io/File:exists	()Z
    //   83: ifne +18 -> 101
    //   86: aload 8
    //   88: invokevirtual 91	java/io/File:getParentFile	()Ljava/io/File;
    //   91: invokevirtual 94	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload 8
    //   97: invokevirtual 97	java/io/File:createNewFile	()Z
    //   100: pop
    //   101: new 99	java/io/FileOutputStream
    //   104: dup
    //   105: aload 8
    //   107: iconst_1
    //   108: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   111: astore 8
    //   113: iload_3
    //   114: ifeq +97 -> 211
    //   117: aload 16
    //   119: astore 10
    //   121: aload 8
    //   123: astore 9
    //   125: new 104	java/util/zip/InflaterInputStream
    //   128: dup
    //   129: aload_1
    //   130: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   133: invokespecial 111	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   136: astore 16
    //   138: aload 16
    //   140: astore 9
    //   142: iconst_0
    //   143: istore 5
    //   145: aload 9
    //   147: aload 17
    //   149: invokevirtual 117	java/io/InputStream:read	([B)I
    //   152: istore 7
    //   154: iload 7
    //   156: iconst_m1
    //   157: if_icmpeq +178 -> 335
    //   160: aload_0
    //   161: getfield 37	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   164: istore_3
    //   165: iload_3
    //   166: ifeq +96 -> 262
    //   169: aload 9
    //   171: ifnull +15 -> 186
    //   174: ldc 119
    //   176: ldc 121
    //   178: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 9
    //   183: invokevirtual 129	java/io/InputStream:close	()V
    //   186: aload 8
    //   188: ifnull +15 -> 203
    //   191: ldc 119
    //   193: ldc 131
    //   195: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload 8
    //   200: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   203: sipush -5003
    //   206: istore 5
    //   208: iload 5
    //   210: ireturn
    //   211: aload 16
    //   213: astore 10
    //   215: aload 8
    //   217: astore 9
    //   219: aload_1
    //   220: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   223: astore 16
    //   225: aload 16
    //   227: astore 9
    //   229: goto -87 -> 142
    //   232: astore_1
    //   233: ldc 119
    //   235: ldc 134
    //   237: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_1
    //   241: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   244: goto -58 -> 186
    //   247: astore_1
    //   248: ldc 119
    //   250: ldc 142
    //   252: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_1
    //   256: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   259: goto -56 -> 203
    //   262: aload_0
    //   263: aload_0
    //   264: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   267: iload 7
    //   269: i2l
    //   270: ladd
    //   271: putfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   274: aload_0
    //   275: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   278: ldc2_w 80
    //   281: lmul
    //   282: aload_0
    //   283: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   286: ldiv
    //   287: l2i
    //   288: istore 6
    //   290: iload 6
    //   292: iload 4
    //   294: if_icmpeq +655 -> 949
    //   297: aload_2
    //   298: ldc 144
    //   300: iload 6
    //   302: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   305: aload_0
    //   306: iconst_2
    //   307: aload_2
    //   308: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   311: iload 6
    //   313: istore 4
    //   315: aload 8
    //   317: aload 17
    //   319: iconst_0
    //   320: iload 7
    //   322: invokevirtual 157	java/io/FileOutputStream:write	([BII)V
    //   325: iload 5
    //   327: iload 7
    //   329: iadd
    //   330: istore 5
    //   332: goto -187 -> 145
    //   335: aload 8
    //   337: invokevirtual 160	java/io/FileOutputStream:flush	()V
    //   340: ldc 119
    //   342: new 162	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   349: ldc 165
    //   351: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   358: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   361: ldc 174
    //   363: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_0
    //   367: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   370: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: ldc 176
    //   375: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_1
    //   379: invokevirtual 79	java/net/HttpURLConnection:getContentLength	()I
    //   382: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_1
    //   392: invokevirtual 79	java/net/HttpURLConnection:getContentLength	()I
    //   395: istore 4
    //   397: iload 5
    //   399: iload 4
    //   401: if_icmpne +67 -> 468
    //   404: iconst_0
    //   405: istore 4
    //   407: iload 4
    //   409: istore 5
    //   411: aload 9
    //   413: ifnull +79 -> 492
    //   416: ldc 119
    //   418: ldc 121
    //   420: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload 9
    //   425: invokevirtual 129	java/io/InputStream:close	()V
    //   428: iload 4
    //   430: istore 5
    //   432: aload 8
    //   434: ifnull -226 -> 208
    //   437: ldc 119
    //   439: ldc 131
    //   441: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   444: aload 8
    //   446: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   449: iload 4
    //   451: ireturn
    //   452: astore_1
    //   453: ldc 119
    //   455: ldc 142
    //   457: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload_1
    //   461: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   464: sipush -7000
    //   467: ireturn
    //   468: bipush 249
    //   470: istore 4
    //   472: goto -65 -> 407
    //   475: astore_1
    //   476: sipush -7000
    //   479: istore 5
    //   481: ldc 119
    //   483: ldc 134
    //   485: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload_1
    //   489: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   492: iload 5
    //   494: istore 4
    //   496: goto -68 -> 428
    //   499: astore_2
    //   500: aload 9
    //   502: astore_1
    //   503: aload 11
    //   505: astore 10
    //   507: ldc 119
    //   509: ldc 184
    //   511: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload_2
    //   515: invokevirtual 185	java/io/FileNotFoundException:printStackTrace	()V
    //   518: new 187	btmsdkobf/bm
    //   521: dup
    //   522: sipush -7001
    //   525: aload_2
    //   526: invokevirtual 190	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   529: invokespecial 193	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   532: athrow
    //   533: astore_2
    //   534: aload_1
    //   535: astore 8
    //   537: aload_2
    //   538: astore_1
    //   539: aload 10
    //   541: ifnull +15 -> 556
    //   544: ldc 119
    //   546: ldc 121
    //   548: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload 10
    //   553: invokevirtual 129	java/io/InputStream:close	()V
    //   556: aload 8
    //   558: ifnull +15 -> 573
    //   561: ldc 119
    //   563: ldc 131
    //   565: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload 8
    //   570: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   573: aload_1
    //   574: athrow
    //   575: astore_1
    //   576: aconst_null
    //   577: astore 8
    //   579: aload 12
    //   581: astore_2
    //   582: aload_2
    //   583: astore 10
    //   585: aload 8
    //   587: astore 9
    //   589: ldc 119
    //   591: new 162	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   598: ldc 195
    //   600: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_1
    //   604: invokevirtual 196	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   607: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: aload_2
    //   617: astore 10
    //   619: aload 8
    //   621: astore 9
    //   623: aload_1
    //   624: invokevirtual 197	java/net/SocketException:printStackTrace	()V
    //   627: aload_2
    //   628: astore 10
    //   630: aload 8
    //   632: astore 9
    //   634: new 187	btmsdkobf/bm
    //   637: dup
    //   638: sipush -5054
    //   641: aload_1
    //   642: invokevirtual 196	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   645: invokespecial 193	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   648: athrow
    //   649: aload_2
    //   650: astore 10
    //   652: aload 8
    //   654: astore 9
    //   656: ldc 119
    //   658: new 162	java/lang/StringBuilder
    //   661: dup
    //   662: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   665: ldc 199
    //   667: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_1
    //   671: invokevirtual 200	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   674: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload_2
    //   684: astore 10
    //   686: aload 8
    //   688: astore 9
    //   690: aload_1
    //   691: invokevirtual 201	java/net/SocketTimeoutException:printStackTrace	()V
    //   694: aload_2
    //   695: astore 10
    //   697: aload 8
    //   699: astore 9
    //   701: new 187	btmsdkobf/bm
    //   704: dup
    //   705: sipush -5055
    //   708: aload_1
    //   709: invokevirtual 200	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   712: invokespecial 193	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   715: athrow
    //   716: aload_2
    //   717: astore 10
    //   719: aload 8
    //   721: astore 9
    //   723: ldc 119
    //   725: ldc 203
    //   727: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: aload_2
    //   731: astore 10
    //   733: aload 8
    //   735: astore 9
    //   737: aload_1
    //   738: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   741: aload_2
    //   742: astore 10
    //   744: aload 8
    //   746: astore 9
    //   748: new 187	btmsdkobf/bm
    //   751: dup
    //   752: sipush -5056
    //   755: aload_1
    //   756: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   759: invokespecial 193	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   762: athrow
    //   763: aload_2
    //   764: astore 10
    //   766: aload 8
    //   768: astore 9
    //   770: ldc 119
    //   772: aload_1
    //   773: invokevirtual 205	java/lang/Exception:toString	()Ljava/lang/String;
    //   776: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: aload_2
    //   780: astore 10
    //   782: aload 8
    //   784: astore 9
    //   786: ldc 119
    //   788: ldc 207
    //   790: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   793: aload_2
    //   794: astore 10
    //   796: aload 8
    //   798: astore 9
    //   800: aload_1
    //   801: invokevirtual 208	java/lang/Exception:printStackTrace	()V
    //   804: aload_2
    //   805: astore 10
    //   807: aload 8
    //   809: astore 9
    //   811: new 187	btmsdkobf/bm
    //   814: dup
    //   815: sipush -5000
    //   818: aload_1
    //   819: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   822: invokespecial 193	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   825: athrow
    //   826: astore_2
    //   827: ldc 119
    //   829: ldc 134
    //   831: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: aload_2
    //   835: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   838: goto -282 -> 556
    //   841: astore_2
    //   842: ldc 119
    //   844: ldc 142
    //   846: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   849: aload_2
    //   850: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   853: goto -280 -> 573
    //   856: astore_1
    //   857: aconst_null
    //   858: astore 8
    //   860: goto -321 -> 539
    //   863: astore_1
    //   864: aload 9
    //   866: astore 10
    //   868: goto -329 -> 539
    //   871: astore_1
    //   872: aload 15
    //   874: astore_2
    //   875: goto -112 -> 763
    //   878: astore_1
    //   879: aload 9
    //   881: astore_2
    //   882: goto -119 -> 763
    //   885: astore_1
    //   886: aload 14
    //   888: astore_2
    //   889: goto -173 -> 716
    //   892: astore_1
    //   893: aload 9
    //   895: astore_2
    //   896: goto -180 -> 716
    //   899: astore_1
    //   900: aload 13
    //   902: astore_2
    //   903: goto -254 -> 649
    //   906: astore_1
    //   907: aload 9
    //   909: astore_2
    //   910: goto -261 -> 649
    //   913: astore_1
    //   914: aload 12
    //   916: astore_2
    //   917: goto -335 -> 582
    //   920: astore_1
    //   921: aload 9
    //   923: astore_2
    //   924: goto -342 -> 582
    //   927: astore_2
    //   928: aload 8
    //   930: astore_1
    //   931: aload 11
    //   933: astore 10
    //   935: goto -428 -> 507
    //   938: astore_2
    //   939: aload 8
    //   941: astore_1
    //   942: aload 9
    //   944: astore 10
    //   946: goto -439 -> 507
    //   949: goto -634 -> 315
    //   952: astore_1
    //   953: aload 9
    //   955: astore 8
    //   957: goto -418 -> 539
    //   960: astore_1
    //   961: aconst_null
    //   962: astore 8
    //   964: aload 13
    //   966: astore_2
    //   967: goto -318 -> 649
    //   970: astore_1
    //   971: aconst_null
    //   972: astore 8
    //   974: aload 14
    //   976: astore_2
    //   977: goto -261 -> 716
    //   980: astore_1
    //   981: aconst_null
    //   982: astore 8
    //   984: aload 15
    //   986: astore_2
    //   987: goto -224 -> 763
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	990	0	this	HttpGetFile
    //   0	990	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	990	2	paramBundle	android.os.Bundle
    //   0	990	3	paramBoolean	boolean
    //   59	436	4	i	int
    //   143	350	5	j	int
    //   288	24	6	k	int
    //   152	178	7	m	int
    //   76	907	8	localObject1	Object
    //   1	953	9	localObject2	Object
    //   4	941	10	localObject3	Object
    //   22	910	11	localObject4	Object
    //   7	908	12	localObject5	Object
    //   10	955	13	localObject6	Object
    //   13	962	14	localObject7	Object
    //   16	969	15	localObject8	Object
    //   19	207	16	localObject9	Object
    //   29	289	17	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   181	186	232	java/io/IOException
    //   198	203	247	java/io/IOException
    //   444	449	452	java/io/IOException
    //   423	428	475	java/io/IOException
    //   31	101	499	java/io/FileNotFoundException
    //   101	113	499	java/io/FileNotFoundException
    //   507	533	533	finally
    //   31	101	575	java/net/SocketException
    //   101	113	575	java/net/SocketException
    //   551	556	826	java/io/IOException
    //   568	573	841	java/io/IOException
    //   31	101	856	finally
    //   101	113	856	finally
    //   145	154	863	finally
    //   160	165	863	finally
    //   262	290	863	finally
    //   297	311	863	finally
    //   315	325	863	finally
    //   335	397	863	finally
    //   125	138	871	java/lang/Exception
    //   219	225	871	java/lang/Exception
    //   145	154	878	java/lang/Exception
    //   160	165	878	java/lang/Exception
    //   262	290	878	java/lang/Exception
    //   297	311	878	java/lang/Exception
    //   315	325	878	java/lang/Exception
    //   335	397	878	java/lang/Exception
    //   125	138	885	java/io/IOException
    //   219	225	885	java/io/IOException
    //   145	154	892	java/io/IOException
    //   160	165	892	java/io/IOException
    //   262	290	892	java/io/IOException
    //   297	311	892	java/io/IOException
    //   315	325	892	java/io/IOException
    //   335	397	892	java/io/IOException
    //   125	138	899	java/net/SocketTimeoutException
    //   219	225	899	java/net/SocketTimeoutException
    //   145	154	906	java/net/SocketTimeoutException
    //   160	165	906	java/net/SocketTimeoutException
    //   262	290	906	java/net/SocketTimeoutException
    //   297	311	906	java/net/SocketTimeoutException
    //   315	325	906	java/net/SocketTimeoutException
    //   335	397	906	java/net/SocketTimeoutException
    //   125	138	913	java/net/SocketException
    //   219	225	913	java/net/SocketException
    //   145	154	920	java/net/SocketException
    //   160	165	920	java/net/SocketException
    //   262	290	920	java/net/SocketException
    //   297	311	920	java/net/SocketException
    //   315	325	920	java/net/SocketException
    //   335	397	920	java/net/SocketException
    //   125	138	927	java/io/FileNotFoundException
    //   219	225	927	java/io/FileNotFoundException
    //   145	154	938	java/io/FileNotFoundException
    //   160	165	938	java/io/FileNotFoundException
    //   262	290	938	java/io/FileNotFoundException
    //   297	311	938	java/io/FileNotFoundException
    //   315	325	938	java/io/FileNotFoundException
    //   335	397	938	java/io/FileNotFoundException
    //   125	138	952	finally
    //   219	225	952	finally
    //   589	616	952	finally
    //   623	627	952	finally
    //   634	649	952	finally
    //   656	683	952	finally
    //   690	694	952	finally
    //   701	716	952	finally
    //   723	730	952	finally
    //   737	741	952	finally
    //   748	763	952	finally
    //   770	779	952	finally
    //   786	793	952	finally
    //   800	804	952	finally
    //   811	826	952	finally
    //   31	101	960	java/net/SocketTimeoutException
    //   101	113	960	java/net/SocketTimeoutException
    //   31	101	970	java/io/IOException
    //   101	113	970	java/io/IOException
    //   31	101	980	java/lang/Exception
    //   101	113	980	java/lang/Exception
  }
  
  /* Error */
  private int a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 10
    //   5: aconst_null
    //   6: astore 12
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 13
    //   14: aconst_null
    //   15: astore 11
    //   17: ldc 212
    //   19: new 162	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   26: aload_0
    //   27: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   30: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: getstatic 215	java/io/File:separator	Ljava/lang/String;
    //   36: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   43: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: ldc 212
    //   54: new 162	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   61: aload_0
    //   62: getfield 29	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   65: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 215	java/io/File:separator	Ljava/lang/String;
    //   71: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   78: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: new 53	java/io/File
    //   90: dup
    //   91: aload_0
    //   92: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   95: aload_0
    //   96: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   99: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: astore 6
    //   104: aload 6
    //   106: invokevirtual 88	java/io/File:exists	()Z
    //   109: ifeq +384 -> 493
    //   112: aload_0
    //   113: getfield 35	com/tmsdk/base/utils/HttpGetFile:G	I
    //   116: iconst_1
    //   117: if_icmpne +194 -> 311
    //   120: aload_0
    //   121: getfield 45	com/tmsdk/base/utils/HttpGetFile:mContext	Landroid/content/Context;
    //   124: invokevirtual 60	android/content/Context:getFilesDir	()Ljava/io/File;
    //   127: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   130: aload_0
    //   131: getfield 29	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   134: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifeq +174 -> 311
    //   140: aload_0
    //   141: getfield 45	com/tmsdk/base/utils/HttpGetFile:mContext	Landroid/content/Context;
    //   144: aload_0
    //   145: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   148: aload_0
    //   149: getfield 35	com/tmsdk/base/utils/HttpGetFile:G	I
    //   152: invokevirtual 225	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   155: astore 5
    //   157: aload 6
    //   159: astore 9
    //   161: aload 7
    //   163: astore 10
    //   165: aload 5
    //   167: astore 8
    //   169: new 227	java/io/FileInputStream
    //   172: dup
    //   173: aload 6
    //   175: invokespecial 230	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   178: astore 7
    //   180: sipush 1024
    //   183: newarray byte
    //   185: astore 10
    //   187: aload 7
    //   189: aload 10
    //   191: invokevirtual 231	java/io/FileInputStream:read	([B)I
    //   194: istore 4
    //   196: iload_3
    //   197: istore_2
    //   198: aload 7
    //   200: astore 9
    //   202: aload 5
    //   204: astore 8
    //   206: iload 4
    //   208: iconst_m1
    //   209: if_icmpeq +294 -> 503
    //   212: aload 5
    //   214: aload 10
    //   216: iconst_0
    //   217: iload 4
    //   219: invokevirtual 157	java/io/FileOutputStream:write	([BII)V
    //   222: goto -35 -> 187
    //   225: astore 8
    //   227: aload 7
    //   229: astore 10
    //   231: aload 8
    //   233: astore 7
    //   235: ldc 119
    //   237: ldc 184
    //   239: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload 7
    //   244: invokevirtual 185	java/io/FileNotFoundException:printStackTrace	()V
    //   247: new 187	btmsdkobf/bm
    //   250: dup
    //   251: sipush -7001
    //   254: aload 7
    //   256: invokevirtual 190	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   259: invokespecial 193	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   262: athrow
    //   263: astore 7
    //   265: aload 10
    //   267: ifnull +8 -> 275
    //   270: aload 10
    //   272: invokevirtual 232	java/io/FileInputStream:close	()V
    //   275: aload 5
    //   277: ifnull +8 -> 285
    //   280: aload 5
    //   282: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   285: iload_1
    //   286: ifeq +22 -> 308
    //   289: aload 6
    //   291: ifnull +17 -> 308
    //   294: aload 6
    //   296: invokevirtual 88	java/io/File:exists	()Z
    //   299: ifeq +9 -> 308
    //   302: aload 6
    //   304: invokevirtual 235	java/io/File:delete	()Z
    //   307: pop
    //   308: aload 7
    //   310: athrow
    //   311: new 53	java/io/File
    //   314: dup
    //   315: new 162	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   322: aload_0
    //   323: getfield 29	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   326: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: getstatic 215	java/io/File:separator	Ljava/lang/String;
    //   332: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   339: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokespecial 238	java/io/File:<init>	(Ljava/lang/String;)V
    //   348: astore 5
    //   350: aload 5
    //   352: invokevirtual 88	java/io/File:exists	()Z
    //   355: ifeq +23 -> 378
    //   358: aload 5
    //   360: invokevirtual 235	java/io/File:delete	()Z
    //   363: pop
    //   364: new 99	java/io/FileOutputStream
    //   367: dup
    //   368: aload 5
    //   370: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   373: astore 5
    //   375: goto -218 -> 157
    //   378: aload 5
    //   380: invokevirtual 91	java/io/File:getParentFile	()Ljava/io/File;
    //   383: invokevirtual 94	java/io/File:mkdirs	()Z
    //   386: pop
    //   387: aload 5
    //   389: invokevirtual 97	java/io/File:createNewFile	()Z
    //   392: pop
    //   393: new 99	java/io/FileOutputStream
    //   396: dup
    //   397: aload 5
    //   399: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   402: astore 5
    //   404: goto -247 -> 157
    //   407: astore 7
    //   409: aconst_null
    //   410: astore 5
    //   412: aload 12
    //   414: astore 11
    //   416: aload 6
    //   418: astore 9
    //   420: aload 11
    //   422: astore 10
    //   424: aload 5
    //   426: astore 8
    //   428: ldc 119
    //   430: ldc 241
    //   432: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload 6
    //   437: astore 9
    //   439: aload 11
    //   441: astore 10
    //   443: aload 5
    //   445: astore 8
    //   447: aload 7
    //   449: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   452: aload 6
    //   454: astore 9
    //   456: aload 11
    //   458: astore 10
    //   460: aload 5
    //   462: astore 8
    //   464: new 187	btmsdkobf/bm
    //   467: dup
    //   468: sipush -7056
    //   471: aload 7
    //   473: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   476: invokespecial 193	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   479: athrow
    //   480: astore 7
    //   482: aload 9
    //   484: astore 6
    //   486: aload 8
    //   488: astore 5
    //   490: goto -225 -> 265
    //   493: aconst_null
    //   494: astore 8
    //   496: sipush -7001
    //   499: istore_2
    //   500: aconst_null
    //   501: astore 9
    //   503: iload_2
    //   504: istore_3
    //   505: aload 9
    //   507: ifnull +10 -> 517
    //   510: aload 9
    //   512: invokevirtual 232	java/io/FileInputStream:close	()V
    //   515: iload_2
    //   516: istore_3
    //   517: iload_3
    //   518: istore_2
    //   519: aload 8
    //   521: ifnull +10 -> 531
    //   524: aload 8
    //   526: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   529: iload_3
    //   530: istore_2
    //   531: iload_1
    //   532: ifeq +22 -> 554
    //   535: aload 6
    //   537: ifnull +17 -> 554
    //   540: aload 6
    //   542: invokevirtual 88	java/io/File:exists	()Z
    //   545: ifeq +9 -> 554
    //   548: aload 6
    //   550: invokevirtual 235	java/io/File:delete	()Z
    //   553: pop
    //   554: iload_2
    //   555: ireturn
    //   556: astore 5
    //   558: ldc 119
    //   560: ldc 243
    //   562: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: aload 5
    //   567: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   570: sipush -7000
    //   573: istore_3
    //   574: goto -57 -> 517
    //   577: astore 5
    //   579: ldc 119
    //   581: ldc 245
    //   583: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload 5
    //   588: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   591: sipush -7000
    //   594: istore_2
    //   595: goto -64 -> 531
    //   598: astore 7
    //   600: aconst_null
    //   601: astore 6
    //   603: aconst_null
    //   604: astore 5
    //   606: aload 13
    //   608: astore 11
    //   610: aload 6
    //   612: astore 9
    //   614: aload 11
    //   616: astore 10
    //   618: aload 5
    //   620: astore 8
    //   622: ldc 119
    //   624: ldc 247
    //   626: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload 6
    //   631: astore 9
    //   633: aload 11
    //   635: astore 10
    //   637: aload 5
    //   639: astore 8
    //   641: aload 7
    //   643: invokevirtual 208	java/lang/Exception:printStackTrace	()V
    //   646: aload 6
    //   648: astore 9
    //   650: aload 11
    //   652: astore 10
    //   654: aload 5
    //   656: astore 8
    //   658: new 187	btmsdkobf/bm
    //   661: dup
    //   662: sipush -7000
    //   665: aload 7
    //   667: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   670: invokespecial 193	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   673: athrow
    //   674: astore 8
    //   676: ldc 119
    //   678: ldc 243
    //   680: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload 8
    //   685: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   688: goto -413 -> 275
    //   691: astore 5
    //   693: ldc 119
    //   695: ldc 245
    //   697: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   700: aload 5
    //   702: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   705: goto -420 -> 285
    //   708: astore 7
    //   710: aconst_null
    //   711: astore 6
    //   713: aconst_null
    //   714: astore 5
    //   716: goto -451 -> 265
    //   719: astore 7
    //   721: aconst_null
    //   722: astore 5
    //   724: goto -459 -> 265
    //   727: astore 8
    //   729: aload 7
    //   731: astore 10
    //   733: aload 8
    //   735: astore 7
    //   737: goto -472 -> 265
    //   740: astore 7
    //   742: aconst_null
    //   743: astore 5
    //   745: aload 13
    //   747: astore 11
    //   749: goto -139 -> 610
    //   752: astore 7
    //   754: aload 13
    //   756: astore 11
    //   758: goto -148 -> 610
    //   761: astore 8
    //   763: aload 7
    //   765: astore 11
    //   767: aload 8
    //   769: astore 7
    //   771: goto -161 -> 610
    //   774: astore 7
    //   776: aconst_null
    //   777: astore 6
    //   779: aconst_null
    //   780: astore 5
    //   782: aload 12
    //   784: astore 11
    //   786: goto -370 -> 416
    //   789: astore 7
    //   791: aload 12
    //   793: astore 11
    //   795: goto -379 -> 416
    //   798: astore 8
    //   800: aload 7
    //   802: astore 11
    //   804: aload 8
    //   806: astore 7
    //   808: goto -392 -> 416
    //   811: astore 7
    //   813: aconst_null
    //   814: astore 6
    //   816: aconst_null
    //   817: astore 5
    //   819: aload 11
    //   821: astore 10
    //   823: goto -588 -> 235
    //   826: astore 7
    //   828: aload 11
    //   830: astore 10
    //   832: goto -597 -> 235
    //   835: astore 7
    //   837: aconst_null
    //   838: astore 5
    //   840: aload 11
    //   842: astore 10
    //   844: goto -609 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	847	0	this	HttpGetFile
    //   0	847	1	paramBoolean	boolean
    //   197	398	2	i	int
    //   1	573	3	j	int
    //   194	24	4	k	int
    //   155	334	5	localObject1	Object
    //   556	10	5	localIOException1	java.io.IOException
    //   577	10	5	localIOException2	java.io.IOException
    //   604	51	5	localObject2	Object
    //   691	10	5	localIOException3	java.io.IOException
    //   714	125	5	localObject3	Object
    //   102	713	6	localObject4	Object
    //   9	246	7	localObject5	Object
    //   263	46	7	localObject6	Object
    //   407	65	7	localIOException4	java.io.IOException
    //   480	1	7	localObject7	Object
    //   598	68	7	localException1	java.lang.Exception
    //   708	1	7	localObject8	Object
    //   719	11	7	localObject9	Object
    //   735	1	7	localObject10	Object
    //   740	1	7	localException2	java.lang.Exception
    //   752	12	7	localException3	java.lang.Exception
    //   769	1	7	localObject11	Object
    //   774	1	7	localIOException5	java.io.IOException
    //   789	12	7	localIOException6	java.io.IOException
    //   806	1	7	localObject12	Object
    //   811	1	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   826	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   835	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   167	38	8	localObject13	Object
    //   225	7	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   426	231	8	localObject14	Object
    //   674	10	8	localIOException7	java.io.IOException
    //   727	7	8	localObject15	Object
    //   761	7	8	localException4	java.lang.Exception
    //   798	7	8	localIOException8	java.io.IOException
    //   159	490	9	localObject16	Object
    //   3	840	10	localObject17	Object
    //   15	826	11	localObject18	Object
    //   6	786	12	localObject19	Object
    //   12	743	13	localObject20	Object
    // Exception table:
    //   from	to	target	type
    //   180	187	225	java/io/FileNotFoundException
    //   187	196	225	java/io/FileNotFoundException
    //   212	222	225	java/io/FileNotFoundException
    //   235	263	263	finally
    //   104	157	407	java/io/IOException
    //   311	375	407	java/io/IOException
    //   378	404	407	java/io/IOException
    //   169	180	480	finally
    //   428	435	480	finally
    //   447	452	480	finally
    //   464	480	480	finally
    //   622	629	480	finally
    //   641	646	480	finally
    //   658	674	480	finally
    //   510	515	556	java/io/IOException
    //   524	529	577	java/io/IOException
    //   87	104	598	java/lang/Exception
    //   270	275	674	java/io/IOException
    //   280	285	691	java/io/IOException
    //   87	104	708	finally
    //   104	157	719	finally
    //   311	375	719	finally
    //   378	404	719	finally
    //   180	187	727	finally
    //   187	196	727	finally
    //   212	222	727	finally
    //   104	157	740	java/lang/Exception
    //   311	375	740	java/lang/Exception
    //   378	404	740	java/lang/Exception
    //   169	180	752	java/lang/Exception
    //   180	187	761	java/lang/Exception
    //   187	196	761	java/lang/Exception
    //   212	222	761	java/lang/Exception
    //   87	104	774	java/io/IOException
    //   169	180	789	java/io/IOException
    //   180	187	798	java/io/IOException
    //   187	196	798	java/io/IOException
    //   212	222	798	java/io/IOException
    //   87	104	811	java/io/FileNotFoundException
    //   169	180	826	java/io/FileNotFoundException
    //   104	157	835	java/io/FileNotFoundException
    //   311	375	835	java/io/FileNotFoundException
    //   378	404	835	java/io/FileNotFoundException
  }
  
  public void cancelGet()
  {
    try
    {
      this.H = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int doGetFile(String paramString1, String paramString2, boolean paramBoolean, DataMd5Cheker paramDataMd5Cheker)
  {
    // Byte code:
    //   0: sipush -3000
    //   3: istore 7
    //   5: ldc 252
    //   7: astore 11
    //   9: new 146	android/os/Bundle
    //   12: dup
    //   13: invokespecial 253	android/os/Bundle:<init>	()V
    //   16: astore 12
    //   18: aload_0
    //   19: getfield 37	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   22: istore 9
    //   24: iload 9
    //   26: ifeq +118 -> 144
    //   29: aconst_null
    //   30: astore 10
    //   32: sipush -3003
    //   35: istore 5
    //   37: aload 10
    //   39: ifnull +8 -> 47
    //   42: aload 10
    //   44: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   47: iload 5
    //   49: istore 7
    //   51: iload 5
    //   53: ifeq +1746 -> 1799
    //   56: iload 5
    //   58: istore 7
    //   60: iload 5
    //   62: bipush 249
    //   64: if_icmpeq +1735 -> 1799
    //   67: aload 12
    //   69: ldc_w 258
    //   72: iload 5
    //   74: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   77: aload 12
    //   79: ldc_w 260
    //   82: ldc 252
    //   84: invokevirtual 263	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 12
    //   89: ldc_w 265
    //   92: aload_0
    //   93: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   96: l2i
    //   97: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   100: aload 12
    //   102: ldc_w 267
    //   105: aload_0
    //   106: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   109: l2i
    //   110: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   113: aload_0
    //   114: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   117: ifeq +627 -> 744
    //   120: iconst_1
    //   121: istore 6
    //   123: aload 12
    //   125: ldc_w 269
    //   128: iload 6
    //   130: i2b
    //   131: invokevirtual 273	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   134: aload_0
    //   135: iconst_1
    //   136: aload 12
    //   138: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   141: iload 5
    //   143: ireturn
    //   144: new 275	java/net/URL
    //   147: dup
    //   148: aload_2
    //   149: invokespecial 276	java/net/URL:<init>	(Ljava/lang/String;)V
    //   152: invokevirtual 280	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   155: checkcast 75	java/net/HttpURLConnection
    //   158: astore 10
    //   160: iload 7
    //   162: istore 5
    //   164: iload 7
    //   166: istore 6
    //   168: aload 10
    //   170: sipush 10000
    //   173: invokevirtual 284	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   176: iload 7
    //   178: istore 5
    //   180: iload 7
    //   182: istore 6
    //   184: aload 10
    //   186: sipush 20000
    //   189: invokevirtual 287	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   192: iload 7
    //   194: istore 5
    //   196: iload 7
    //   198: istore 6
    //   200: aload 10
    //   202: iconst_1
    //   203: invokevirtual 291	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   206: iload 7
    //   208: istore 5
    //   210: iload 7
    //   212: istore 6
    //   214: aload 10
    //   216: ldc_w 293
    //   219: invokevirtual 296	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   222: iload 7
    //   224: istore 5
    //   226: iload 7
    //   228: istore 6
    //   230: aload_1
    //   231: invokestatic 302	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifne +288 -> 522
    //   237: iload 7
    //   239: istore 5
    //   241: iload 7
    //   243: istore 6
    //   245: aload_0
    //   246: new 162	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   253: aload_1
    //   254: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 304
    //   260: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: putfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   269: iload 7
    //   271: istore 5
    //   273: iload 7
    //   275: istore 6
    //   277: ldc 119
    //   279: new 162	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 306
    //   289: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_0
    //   293: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   296: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: iload 7
    //   307: istore 5
    //   309: iload 7
    //   311: istore 6
    //   313: aload_0
    //   314: getfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   317: ifnonnull +16 -> 333
    //   320: iload 7
    //   322: istore 5
    //   324: iload 7
    //   326: istore 6
    //   328: aload_0
    //   329: aload_1
    //   330: putfield 33	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   333: iload 7
    //   335: istore 5
    //   337: iload 7
    //   339: istore 6
    //   341: new 53	java/io/File
    //   344: dup
    //   345: aload_0
    //   346: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   349: aload_0
    //   350: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   353: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: astore_1
    //   357: iload 7
    //   359: istore 5
    //   361: iload 7
    //   363: istore 6
    //   365: aload_1
    //   366: invokevirtual 88	java/io/File:exists	()Z
    //   369: ifeq +77 -> 446
    //   372: iload 7
    //   374: istore 5
    //   376: iload 7
    //   378: istore 6
    //   380: aload_0
    //   381: aload_1
    //   382: invokevirtual 310	java/io/File:length	()J
    //   385: putfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   388: iload 7
    //   390: istore 5
    //   392: iload 7
    //   394: istore 6
    //   396: aload 10
    //   398: ldc_w 312
    //   401: new 162	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 314
    //   411: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_0
    //   415: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   418: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   421: ldc_w 316
    //   424: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokevirtual 319	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: iload 7
    //   435: istore 5
    //   437: iload 7
    //   439: istore 6
    //   441: aload_0
    //   442: iconst_1
    //   443: putfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   446: iload 7
    //   448: istore 5
    //   450: iload 7
    //   452: istore 6
    //   454: aload 10
    //   456: invokevirtual 322	java/net/HttpURLConnection:getResponseCode	()I
    //   459: istore 8
    //   461: iload 7
    //   463: istore 5
    //   465: iload 7
    //   467: istore 6
    //   469: ldc 119
    //   471: new 162	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   478: ldc_w 324
    //   481: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: iload 8
    //   486: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   489: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 126	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: iload 8
    //   497: sipush 200
    //   500: if_icmpeq +39 -> 539
    //   503: iload 8
    //   505: sipush 206
    //   508: if_icmpeq +31 -> 539
    //   511: sipush -3000
    //   514: iload 8
    //   516: isub
    //   517: istore 5
    //   519: goto -482 -> 37
    //   522: iload 7
    //   524: istore 5
    //   526: iload 7
    //   528: istore 6
    //   530: aload_2
    //   531: aconst_null
    //   532: invokestatic 330	btmsdkobf/dz:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   535: astore_1
    //   536: goto -299 -> 237
    //   539: iload 7
    //   541: istore 5
    //   543: iload 7
    //   545: istore 6
    //   547: aload_0
    //   548: getfield 37	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   551: ifeq +11 -> 562
    //   554: sipush -3003
    //   557: istore 5
    //   559: goto -522 -> 37
    //   562: iload 7
    //   564: istore 5
    //   566: iload 7
    //   568: istore 6
    //   570: aload_0
    //   571: aload 10
    //   573: aload 12
    //   575: iload_3
    //   576: invokespecial 332	com/tmsdk/base/utils/HttpGetFile:a	(Ljava/net/HttpURLConnection;Landroid/os/Bundle;Z)I
    //   579: istore 7
    //   581: iload 7
    //   583: ifeq +17 -> 600
    //   586: iload 7
    //   588: bipush 249
    //   590: if_icmpne +1212 -> 1802
    //   593: iload 7
    //   595: istore 5
    //   597: goto -560 -> 37
    //   600: aload 4
    //   602: ifnull +109 -> 711
    //   605: iload 7
    //   607: istore 5
    //   609: iload 7
    //   611: istore 6
    //   613: aload 4
    //   615: new 162	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   622: aload_0
    //   623: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   626: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: getstatic 215	java/io/File:separator	Ljava/lang/String;
    //   632: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload_0
    //   636: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   639: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokeinterface 336 2 0
    //   650: ifne +61 -> 711
    //   653: sipush -7000
    //   656: istore 6
    //   658: iload 6
    //   660: istore 5
    //   662: new 53	java/io/File
    //   665: dup
    //   666: new 162	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   673: aload_0
    //   674: getfield 27	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   677: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: getstatic 215	java/io/File:separator	Ljava/lang/String;
    //   683: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_0
    //   687: getfield 31	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   690: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokespecial 238	java/io/File:<init>	(Ljava/lang/String;)V
    //   699: invokevirtual 235	java/io/File:delete	()Z
    //   702: pop
    //   703: sipush -7000
    //   706: istore 5
    //   708: goto -671 -> 37
    //   711: iload 7
    //   713: istore 5
    //   715: iload 7
    //   717: istore 6
    //   719: aload_0
    //   720: iconst_1
    //   721: invokespecial 338	com/tmsdk/base/utils/HttpGetFile:a	(Z)I
    //   724: istore 7
    //   726: iload 7
    //   728: ifeq +10 -> 738
    //   731: iload 7
    //   733: istore 5
    //   735: goto -698 -> 37
    //   738: iconst_0
    //   739: istore 5
    //   741: goto -704 -> 37
    //   744: iconst_0
    //   745: istore 6
    //   747: goto -624 -> 123
    //   750: astore 10
    //   752: aconst_null
    //   753: astore 4
    //   755: sipush -3054
    //   758: istore 6
    //   760: iload 6
    //   762: istore 5
    //   764: aload 4
    //   766: astore_2
    //   767: aload 11
    //   769: astore_1
    //   770: aload 10
    //   772: invokevirtual 196	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   775: astore 11
    //   777: iload 6
    //   779: istore 5
    //   781: aload 4
    //   783: astore_2
    //   784: aload 11
    //   786: astore_1
    //   787: ldc 119
    //   789: new 162	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   796: ldc 195
    //   798: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 10
    //   803: invokevirtual 196	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   806: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   815: iload 6
    //   817: istore 5
    //   819: aload 4
    //   821: astore_2
    //   822: aload 11
    //   824: astore_1
    //   825: aload 10
    //   827: invokevirtual 197	java/net/SocketException:printStackTrace	()V
    //   830: aload 4
    //   832: ifnull +8 -> 840
    //   835: aload 4
    //   837: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   840: aload 12
    //   842: ldc_w 258
    //   845: sipush -3054
    //   848: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   851: aload 12
    //   853: ldc_w 260
    //   856: aload 11
    //   858: invokevirtual 263	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   861: aload 12
    //   863: ldc_w 265
    //   866: aload_0
    //   867: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   870: l2i
    //   871: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   874: aload 12
    //   876: ldc_w 267
    //   879: aload_0
    //   880: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   883: l2i
    //   884: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   887: aload_0
    //   888: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   891: ifeq +28 -> 919
    //   894: iconst_1
    //   895: istore 5
    //   897: aload 12
    //   899: ldc_w 269
    //   902: iload 5
    //   904: i2b
    //   905: invokevirtual 273	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   908: aload_0
    //   909: iconst_1
    //   910: aload 12
    //   912: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   915: sipush -3054
    //   918: ireturn
    //   919: iconst_0
    //   920: istore 5
    //   922: goto -25 -> 897
    //   925: astore 10
    //   927: aconst_null
    //   928: astore 4
    //   930: sipush -3055
    //   933: istore 6
    //   935: iload 6
    //   937: istore 5
    //   939: aload 4
    //   941: astore_2
    //   942: aload 11
    //   944: astore_1
    //   945: aload 10
    //   947: invokevirtual 200	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   950: astore 11
    //   952: iload 6
    //   954: istore 5
    //   956: aload 4
    //   958: astore_2
    //   959: aload 11
    //   961: astore_1
    //   962: ldc 119
    //   964: new 162	java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   971: ldc 199
    //   973: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: aload 10
    //   978: invokevirtual 200	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   981: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   990: iload 6
    //   992: istore 5
    //   994: aload 4
    //   996: astore_2
    //   997: aload 11
    //   999: astore_1
    //   1000: aload 10
    //   1002: invokevirtual 201	java/net/SocketTimeoutException:printStackTrace	()V
    //   1005: aload 4
    //   1007: ifnull +8 -> 1015
    //   1010: aload 4
    //   1012: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   1015: aload 12
    //   1017: ldc_w 258
    //   1020: sipush -3055
    //   1023: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1026: aload 12
    //   1028: ldc_w 260
    //   1031: aload 11
    //   1033: invokevirtual 263	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1036: aload 12
    //   1038: ldc_w 265
    //   1041: aload_0
    //   1042: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1045: l2i
    //   1046: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1049: aload 12
    //   1051: ldc_w 267
    //   1054: aload_0
    //   1055: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1058: l2i
    //   1059: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1062: aload_0
    //   1063: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1066: ifeq +28 -> 1094
    //   1069: iconst_1
    //   1070: istore 5
    //   1072: aload 12
    //   1074: ldc_w 269
    //   1077: iload 5
    //   1079: i2b
    //   1080: invokevirtual 273	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1083: aload_0
    //   1084: iconst_1
    //   1085: aload 12
    //   1087: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1090: sipush -3055
    //   1093: ireturn
    //   1094: iconst_0
    //   1095: istore 5
    //   1097: goto -25 -> 1072
    //   1100: astore 10
    //   1102: aconst_null
    //   1103: astore 4
    //   1105: sipush -3056
    //   1108: istore 6
    //   1110: iload 6
    //   1112: istore 5
    //   1114: aload 4
    //   1116: astore_2
    //   1117: aload 11
    //   1119: astore_1
    //   1120: aload 10
    //   1122: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1125: astore 11
    //   1127: iload 6
    //   1129: istore 5
    //   1131: aload 4
    //   1133: astore_2
    //   1134: aload 11
    //   1136: astore_1
    //   1137: ldc 119
    //   1139: new 162	java/lang/StringBuilder
    //   1142: dup
    //   1143: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1146: ldc_w 340
    //   1149: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: aload 10
    //   1154: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1157: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1166: iload 6
    //   1168: istore 5
    //   1170: aload 4
    //   1172: astore_2
    //   1173: aload 11
    //   1175: astore_1
    //   1176: aload 10
    //   1178: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   1181: aload 4
    //   1183: ifnull +8 -> 1191
    //   1186: aload 4
    //   1188: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   1191: aload 12
    //   1193: ldc_w 258
    //   1196: sipush -3056
    //   1199: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1202: aload 12
    //   1204: ldc_w 260
    //   1207: aload 11
    //   1209: invokevirtual 263	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1212: aload 12
    //   1214: ldc_w 265
    //   1217: aload_0
    //   1218: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1221: l2i
    //   1222: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1225: aload 12
    //   1227: ldc_w 267
    //   1230: aload_0
    //   1231: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1234: l2i
    //   1235: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1238: aload_0
    //   1239: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1242: ifeq +28 -> 1270
    //   1245: iconst_1
    //   1246: istore 5
    //   1248: aload 12
    //   1250: ldc_w 269
    //   1253: iload 5
    //   1255: i2b
    //   1256: invokevirtual 273	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1259: aload_0
    //   1260: iconst_1
    //   1261: aload 12
    //   1263: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1266: sipush -3056
    //   1269: ireturn
    //   1270: iconst_0
    //   1271: istore 5
    //   1273: goto -25 -> 1248
    //   1276: astore 10
    //   1278: sipush -3000
    //   1281: istore 5
    //   1283: aconst_null
    //   1284: astore 4
    //   1286: aload 4
    //   1288: astore_2
    //   1289: aload 11
    //   1291: astore_1
    //   1292: aload 10
    //   1294: invokevirtual 342	btmsdkobf/bm:I	()I
    //   1297: istore 6
    //   1299: iload 6
    //   1301: istore 5
    //   1303: aload 4
    //   1305: astore_2
    //   1306: aload 11
    //   1308: astore_1
    //   1309: aload 10
    //   1311: invokevirtual 343	btmsdkobf/bm:getMessage	()Ljava/lang/String;
    //   1314: astore 10
    //   1316: aload 4
    //   1318: ifnull +8 -> 1326
    //   1321: aload 4
    //   1323: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   1326: iload 6
    //   1328: istore 7
    //   1330: iload 6
    //   1332: ifeq +467 -> 1799
    //   1335: iload 6
    //   1337: istore 7
    //   1339: iload 6
    //   1341: bipush 249
    //   1343: if_icmpeq +456 -> 1799
    //   1346: aload 12
    //   1348: ldc_w 258
    //   1351: iload 6
    //   1353: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1356: aload 12
    //   1358: ldc_w 260
    //   1361: aload 10
    //   1363: invokevirtual 263	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1366: aload 12
    //   1368: ldc_w 265
    //   1371: aload_0
    //   1372: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1375: l2i
    //   1376: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1379: aload 12
    //   1381: ldc_w 267
    //   1384: aload_0
    //   1385: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1388: l2i
    //   1389: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1392: aload_0
    //   1393: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1396: ifeq +27 -> 1423
    //   1399: iconst_1
    //   1400: istore 5
    //   1402: aload 12
    //   1404: ldc_w 269
    //   1407: iload 5
    //   1409: i2b
    //   1410: invokevirtual 273	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1413: aload_0
    //   1414: iconst_1
    //   1415: aload 12
    //   1417: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1420: iload 6
    //   1422: ireturn
    //   1423: iconst_0
    //   1424: istore 5
    //   1426: goto -24 -> 1402
    //   1429: astore 10
    //   1431: aconst_null
    //   1432: astore 4
    //   1434: sipush -3000
    //   1437: istore 6
    //   1439: iload 6
    //   1441: istore 5
    //   1443: aload 4
    //   1445: astore_2
    //   1446: aload 11
    //   1448: astore_1
    //   1449: aload 10
    //   1451: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1454: astore 11
    //   1456: iload 6
    //   1458: istore 5
    //   1460: aload 4
    //   1462: astore_2
    //   1463: aload 11
    //   1465: astore_1
    //   1466: ldc 119
    //   1468: new 162	java/lang/StringBuilder
    //   1471: dup
    //   1472: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1475: ldc_w 345
    //   1478: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: aload 10
    //   1483: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1486: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokestatic 137	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1495: iload 6
    //   1497: istore 5
    //   1499: aload 4
    //   1501: astore_2
    //   1502: aload 11
    //   1504: astore_1
    //   1505: aload 10
    //   1507: invokevirtual 208	java/lang/Exception:printStackTrace	()V
    //   1510: aload 4
    //   1512: ifnull +8 -> 1520
    //   1515: aload 4
    //   1517: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   1520: aload 12
    //   1522: ldc_w 258
    //   1525: sipush -3000
    //   1528: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1531: aload 12
    //   1533: ldc_w 260
    //   1536: aload 11
    //   1538: invokevirtual 263	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1541: aload 12
    //   1543: ldc_w 265
    //   1546: aload_0
    //   1547: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1550: l2i
    //   1551: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1554: aload 12
    //   1556: ldc_w 267
    //   1559: aload_0
    //   1560: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1563: l2i
    //   1564: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1567: aload_0
    //   1568: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1571: ifeq +28 -> 1599
    //   1574: iconst_1
    //   1575: istore 5
    //   1577: aload 12
    //   1579: ldc_w 269
    //   1582: iload 5
    //   1584: i2b
    //   1585: invokevirtual 273	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1588: aload_0
    //   1589: iconst_1
    //   1590: aload 12
    //   1592: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1595: sipush -3000
    //   1598: ireturn
    //   1599: iconst_0
    //   1600: istore 5
    //   1602: goto -25 -> 1577
    //   1605: astore_1
    //   1606: aconst_null
    //   1607: astore 10
    //   1609: sipush -3000
    //   1612: istore 5
    //   1614: ldc 252
    //   1616: astore_2
    //   1617: aload 10
    //   1619: ifnull +8 -> 1627
    //   1622: aload 10
    //   1624: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   1627: iload 5
    //   1629: ifeq +83 -> 1712
    //   1632: iload 5
    //   1634: bipush 249
    //   1636: if_icmpeq +76 -> 1712
    //   1639: aload 12
    //   1641: ldc_w 258
    //   1644: iload 5
    //   1646: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1649: aload 12
    //   1651: ldc_w 260
    //   1654: aload_2
    //   1655: invokevirtual 263	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1658: aload 12
    //   1660: ldc_w 265
    //   1663: aload_0
    //   1664: getfield 39	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1667: l2i
    //   1668: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1671: aload 12
    //   1673: ldc_w 267
    //   1676: aload_0
    //   1677: getfield 41	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1680: l2i
    //   1681: invokevirtual 150	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1684: aload_0
    //   1685: getfield 43	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1688: ifeq +26 -> 1714
    //   1691: iconst_1
    //   1692: istore 5
    //   1694: aload 12
    //   1696: ldc_w 269
    //   1699: iload 5
    //   1701: i2b
    //   1702: invokevirtual 273	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1705: aload_0
    //   1706: iconst_1
    //   1707: aload 12
    //   1709: invokevirtual 153	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1712: aload_1
    //   1713: athrow
    //   1714: iconst_0
    //   1715: istore 5
    //   1717: goto -23 -> 1694
    //   1720: astore_1
    //   1721: ldc 252
    //   1723: astore_2
    //   1724: goto -107 -> 1617
    //   1727: astore 4
    //   1729: aload_2
    //   1730: astore 10
    //   1732: aload_1
    //   1733: astore_2
    //   1734: aload 4
    //   1736: astore_1
    //   1737: goto -120 -> 1617
    //   1740: astore_1
    //   1741: aload 10
    //   1743: astore 4
    //   1745: aload_1
    //   1746: astore 10
    //   1748: goto -314 -> 1434
    //   1751: astore_1
    //   1752: iload 6
    //   1754: istore 5
    //   1756: aload 10
    //   1758: astore 4
    //   1760: aload_1
    //   1761: astore 10
    //   1763: goto -477 -> 1286
    //   1766: astore_1
    //   1767: aload 10
    //   1769: astore 4
    //   1771: aload_1
    //   1772: astore 10
    //   1774: goto -669 -> 1105
    //   1777: astore_1
    //   1778: aload 10
    //   1780: astore 4
    //   1782: aload_1
    //   1783: astore 10
    //   1785: goto -855 -> 930
    //   1788: astore_1
    //   1789: aload 10
    //   1791: astore 4
    //   1793: aload_1
    //   1794: astore 10
    //   1796: goto -1041 -> 755
    //   1799: iload 7
    //   1801: ireturn
    //   1802: iload 7
    //   1804: istore 5
    //   1806: goto -1769 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1809	0	this	HttpGetFile
    //   0	1809	1	paramString1	String
    //   0	1809	2	paramString2	String
    //   0	1809	3	paramBoolean	boolean
    //   0	1809	4	paramDataMd5Cheker	DataMd5Cheker
    //   35	1770	5	i	int
    //   121	1632	6	j	int
    //   3	1800	7	k	int
    //   459	58	8	m	int
    //   22	3	9	bool	boolean
    //   30	542	10	localHttpURLConnection	java.net.HttpURLConnection
    //   750	76	10	localSocketException	java.net.SocketException
    //   925	76	10	localSocketTimeoutException	java.net.SocketTimeoutException
    //   1100	77	10	localIOException	java.io.IOException
    //   1276	34	10	localbm	btmsdkobf.bm
    //   1314	48	10	str1	String
    //   1429	77	10	localException	java.lang.Exception
    //   1607	188	10	str2	String
    //   7	1530	11	str3	String
    //   16	1692	12	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   18	24	750	java/net/SocketException
    //   144	160	750	java/net/SocketException
    //   18	24	925	java/net/SocketTimeoutException
    //   144	160	925	java/net/SocketTimeoutException
    //   18	24	1100	java/io/IOException
    //   144	160	1100	java/io/IOException
    //   18	24	1276	btmsdkobf/bm
    //   144	160	1276	btmsdkobf/bm
    //   18	24	1429	java/lang/Exception
    //   144	160	1429	java/lang/Exception
    //   18	24	1605	finally
    //   144	160	1605	finally
    //   168	176	1720	finally
    //   184	192	1720	finally
    //   200	206	1720	finally
    //   214	222	1720	finally
    //   230	237	1720	finally
    //   245	269	1720	finally
    //   277	305	1720	finally
    //   313	320	1720	finally
    //   328	333	1720	finally
    //   341	357	1720	finally
    //   365	372	1720	finally
    //   380	388	1720	finally
    //   396	433	1720	finally
    //   441	446	1720	finally
    //   454	461	1720	finally
    //   469	495	1720	finally
    //   530	536	1720	finally
    //   547	554	1720	finally
    //   570	581	1720	finally
    //   613	653	1720	finally
    //   662	703	1720	finally
    //   719	726	1720	finally
    //   770	777	1727	finally
    //   787	815	1727	finally
    //   825	830	1727	finally
    //   945	952	1727	finally
    //   962	990	1727	finally
    //   1000	1005	1727	finally
    //   1120	1127	1727	finally
    //   1137	1166	1727	finally
    //   1176	1181	1727	finally
    //   1292	1299	1727	finally
    //   1309	1316	1727	finally
    //   1449	1456	1727	finally
    //   1466	1495	1727	finally
    //   1505	1510	1727	finally
    //   168	176	1740	java/lang/Exception
    //   184	192	1740	java/lang/Exception
    //   200	206	1740	java/lang/Exception
    //   214	222	1740	java/lang/Exception
    //   230	237	1740	java/lang/Exception
    //   245	269	1740	java/lang/Exception
    //   277	305	1740	java/lang/Exception
    //   313	320	1740	java/lang/Exception
    //   328	333	1740	java/lang/Exception
    //   341	357	1740	java/lang/Exception
    //   365	372	1740	java/lang/Exception
    //   380	388	1740	java/lang/Exception
    //   396	433	1740	java/lang/Exception
    //   441	446	1740	java/lang/Exception
    //   454	461	1740	java/lang/Exception
    //   469	495	1740	java/lang/Exception
    //   530	536	1740	java/lang/Exception
    //   547	554	1740	java/lang/Exception
    //   570	581	1740	java/lang/Exception
    //   613	653	1740	java/lang/Exception
    //   662	703	1740	java/lang/Exception
    //   719	726	1740	java/lang/Exception
    //   168	176	1751	btmsdkobf/bm
    //   184	192	1751	btmsdkobf/bm
    //   200	206	1751	btmsdkobf/bm
    //   214	222	1751	btmsdkobf/bm
    //   230	237	1751	btmsdkobf/bm
    //   245	269	1751	btmsdkobf/bm
    //   277	305	1751	btmsdkobf/bm
    //   313	320	1751	btmsdkobf/bm
    //   328	333	1751	btmsdkobf/bm
    //   341	357	1751	btmsdkobf/bm
    //   365	372	1751	btmsdkobf/bm
    //   380	388	1751	btmsdkobf/bm
    //   396	433	1751	btmsdkobf/bm
    //   441	446	1751	btmsdkobf/bm
    //   454	461	1751	btmsdkobf/bm
    //   469	495	1751	btmsdkobf/bm
    //   530	536	1751	btmsdkobf/bm
    //   547	554	1751	btmsdkobf/bm
    //   570	581	1751	btmsdkobf/bm
    //   613	653	1751	btmsdkobf/bm
    //   662	703	1751	btmsdkobf/bm
    //   719	726	1751	btmsdkobf/bm
    //   168	176	1766	java/io/IOException
    //   184	192	1766	java/io/IOException
    //   200	206	1766	java/io/IOException
    //   214	222	1766	java/io/IOException
    //   230	237	1766	java/io/IOException
    //   245	269	1766	java/io/IOException
    //   277	305	1766	java/io/IOException
    //   313	320	1766	java/io/IOException
    //   328	333	1766	java/io/IOException
    //   341	357	1766	java/io/IOException
    //   365	372	1766	java/io/IOException
    //   380	388	1766	java/io/IOException
    //   396	433	1766	java/io/IOException
    //   441	446	1766	java/io/IOException
    //   454	461	1766	java/io/IOException
    //   469	495	1766	java/io/IOException
    //   530	536	1766	java/io/IOException
    //   547	554	1766	java/io/IOException
    //   570	581	1766	java/io/IOException
    //   613	653	1766	java/io/IOException
    //   662	703	1766	java/io/IOException
    //   719	726	1766	java/io/IOException
    //   168	176	1777	java/net/SocketTimeoutException
    //   184	192	1777	java/net/SocketTimeoutException
    //   200	206	1777	java/net/SocketTimeoutException
    //   214	222	1777	java/net/SocketTimeoutException
    //   230	237	1777	java/net/SocketTimeoutException
    //   245	269	1777	java/net/SocketTimeoutException
    //   277	305	1777	java/net/SocketTimeoutException
    //   313	320	1777	java/net/SocketTimeoutException
    //   328	333	1777	java/net/SocketTimeoutException
    //   341	357	1777	java/net/SocketTimeoutException
    //   365	372	1777	java/net/SocketTimeoutException
    //   380	388	1777	java/net/SocketTimeoutException
    //   396	433	1777	java/net/SocketTimeoutException
    //   441	446	1777	java/net/SocketTimeoutException
    //   454	461	1777	java/net/SocketTimeoutException
    //   469	495	1777	java/net/SocketTimeoutException
    //   530	536	1777	java/net/SocketTimeoutException
    //   547	554	1777	java/net/SocketTimeoutException
    //   570	581	1777	java/net/SocketTimeoutException
    //   613	653	1777	java/net/SocketTimeoutException
    //   662	703	1777	java/net/SocketTimeoutException
    //   719	726	1777	java/net/SocketTimeoutException
    //   168	176	1788	java/net/SocketException
    //   184	192	1788	java/net/SocketException
    //   200	206	1788	java/net/SocketException
    //   214	222	1788	java/net/SocketException
    //   230	237	1788	java/net/SocketException
    //   245	269	1788	java/net/SocketException
    //   277	305	1788	java/net/SocketException
    //   313	320	1788	java/net/SocketException
    //   328	333	1788	java/net/SocketException
    //   341	357	1788	java/net/SocketException
    //   365	372	1788	java/net/SocketException
    //   380	388	1788	java/net/SocketException
    //   396	433	1788	java/net/SocketException
    //   441	446	1788	java/net/SocketException
    //   454	461	1788	java/net/SocketException
    //   469	495	1788	java/net/SocketException
    //   530	536	1788	java/net/SocketException
    //   547	554	1788	java/net/SocketException
    //   570	581	1788	java/net/SocketException
    //   613	653	1788	java/net/SocketException
    //   662	703	1788	java/net/SocketException
    //   719	726	1788	java/net/SocketException
  }
  
  public String getAbsoluteDownFileName()
  {
    return this.D + File.separator + this.F;
  }
  
  public boolean isCanceled()
  {
    try
    {
      boolean bool = this.H;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setFileMode(int paramInt)
  {
    this.G = paramInt;
  }
  
  public void setSaveName(String paramString)
  {
    this.F = paramString;
  }
  
  public void setSavePath(String paramString)
  {
    this.D = paramString;
  }
  
  public static abstract interface DataMd5Cheker
  {
    public abstract boolean isMatch(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.HttpGetFile
 * JD-Core Version:    0.7.0.1
 */