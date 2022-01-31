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
    //   33: invokevirtual 76	java/net/HttpURLConnection:getContentLength	()I
    //   36: i2l
    //   37: aload_0
    //   38: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   41: ladd
    //   42: putfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   45: aload_0
    //   46: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   49: ldc2_w 77
    //   52: lmul
    //   53: aload_0
    //   54: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   57: ldiv
    //   58: l2i
    //   59: istore 4
    //   61: new 50	java/io/File
    //   64: dup
    //   65: aload_0
    //   66: getfield 24	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   69: aload_0
    //   70: getfield 28	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   73: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: astore 8
    //   78: aload 8
    //   80: invokevirtual 85	java/io/File:exists	()Z
    //   83: ifne +18 -> 101
    //   86: aload 8
    //   88: invokevirtual 88	java/io/File:getParentFile	()Ljava/io/File;
    //   91: invokevirtual 91	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload 8
    //   97: invokevirtual 94	java/io/File:createNewFile	()Z
    //   100: pop
    //   101: new 96	java/io/FileOutputStream
    //   104: dup
    //   105: aload 8
    //   107: iconst_1
    //   108: invokespecial 99	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   111: astore 8
    //   113: iload_3
    //   114: ifeq +97 -> 211
    //   117: aload 16
    //   119: astore 10
    //   121: aload 8
    //   123: astore 9
    //   125: new 101	java/util/zip/InflaterInputStream
    //   128: dup
    //   129: aload_1
    //   130: invokevirtual 105	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   133: invokespecial 108	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   136: astore 16
    //   138: aload 16
    //   140: astore 9
    //   142: iconst_0
    //   143: istore 5
    //   145: aload 9
    //   147: aload 17
    //   149: invokevirtual 114	java/io/InputStream:read	([B)I
    //   152: istore 7
    //   154: iload 7
    //   156: iconst_m1
    //   157: if_icmpeq +178 -> 335
    //   160: aload_0
    //   161: getfield 34	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   164: istore_3
    //   165: iload_3
    //   166: ifeq +96 -> 262
    //   169: aload 9
    //   171: ifnull +15 -> 186
    //   174: ldc 116
    //   176: ldc 118
    //   178: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 9
    //   183: invokevirtual 126	java/io/InputStream:close	()V
    //   186: aload 8
    //   188: ifnull +15 -> 203
    //   191: ldc 116
    //   193: ldc 128
    //   195: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload 8
    //   200: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   203: sipush -5003
    //   206: istore 5
    //   208: iload 5
    //   210: ireturn
    //   211: aload 16
    //   213: astore 10
    //   215: aload 8
    //   217: astore 9
    //   219: aload_1
    //   220: invokevirtual 105	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   223: astore 16
    //   225: aload 16
    //   227: astore 9
    //   229: goto -87 -> 142
    //   232: astore_1
    //   233: ldc 116
    //   235: ldc 131
    //   237: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_1
    //   241: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   244: goto -58 -> 186
    //   247: astore_1
    //   248: ldc 116
    //   250: ldc 139
    //   252: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_1
    //   256: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   259: goto -56 -> 203
    //   262: aload_0
    //   263: aload_0
    //   264: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   267: iload 7
    //   269: i2l
    //   270: ladd
    //   271: putfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   274: aload_0
    //   275: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   278: ldc2_w 77
    //   281: lmul
    //   282: aload_0
    //   283: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   286: ldiv
    //   287: l2i
    //   288: istore 6
    //   290: iload 6
    //   292: iload 4
    //   294: if_icmpeq +655 -> 949
    //   297: aload_2
    //   298: ldc 141
    //   300: iload 6
    //   302: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   305: aload_0
    //   306: iconst_2
    //   307: aload_2
    //   308: invokevirtual 150	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   311: iload 6
    //   313: istore 4
    //   315: aload 8
    //   317: aload 17
    //   319: iconst_0
    //   320: iload 7
    //   322: invokevirtual 154	java/io/FileOutputStream:write	([BII)V
    //   325: iload 5
    //   327: iload 7
    //   329: iadd
    //   330: istore 5
    //   332: goto -187 -> 145
    //   335: aload 8
    //   337: invokevirtual 157	java/io/FileOutputStream:flush	()V
    //   340: ldc 116
    //   342: new 159	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   349: ldc 162
    //   351: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   358: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   361: ldc 171
    //   363: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_0
    //   367: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   370: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: ldc 173
    //   375: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_1
    //   379: invokevirtual 76	java/net/HttpURLConnection:getContentLength	()I
    //   382: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_1
    //   392: invokevirtual 76	java/net/HttpURLConnection:getContentLength	()I
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
    //   416: ldc 116
    //   418: ldc 118
    //   420: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload 9
    //   425: invokevirtual 126	java/io/InputStream:close	()V
    //   428: iload 4
    //   430: istore 5
    //   432: aload 8
    //   434: ifnull -226 -> 208
    //   437: ldc 116
    //   439: ldc 128
    //   441: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   444: aload 8
    //   446: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   449: iload 4
    //   451: ireturn
    //   452: astore_1
    //   453: ldc 116
    //   455: ldc 139
    //   457: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload_1
    //   461: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   464: sipush -7000
    //   467: ireturn
    //   468: bipush 249
    //   470: istore 4
    //   472: goto -65 -> 407
    //   475: astore_1
    //   476: sipush -7000
    //   479: istore 5
    //   481: ldc 116
    //   483: ldc 131
    //   485: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload_1
    //   489: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   492: iload 5
    //   494: istore 4
    //   496: goto -68 -> 428
    //   499: astore_2
    //   500: aload 9
    //   502: astore_1
    //   503: aload 11
    //   505: astore 10
    //   507: ldc 116
    //   509: ldc 181
    //   511: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload_2
    //   515: invokevirtual 182	java/io/FileNotFoundException:printStackTrace	()V
    //   518: new 184	btmsdkobf/bm
    //   521: dup
    //   522: sipush -7001
    //   525: aload_2
    //   526: invokevirtual 187	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   529: invokespecial 190	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   532: athrow
    //   533: astore_2
    //   534: aload_1
    //   535: astore 8
    //   537: aload_2
    //   538: astore_1
    //   539: aload 10
    //   541: ifnull +15 -> 556
    //   544: ldc 116
    //   546: ldc 118
    //   548: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload 10
    //   553: invokevirtual 126	java/io/InputStream:close	()V
    //   556: aload 8
    //   558: ifnull +15 -> 573
    //   561: ldc 116
    //   563: ldc 128
    //   565: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload 8
    //   570: invokevirtual 129	java/io/FileOutputStream:close	()V
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
    //   589: ldc 116
    //   591: new 159	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   598: ldc 192
    //   600: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_1
    //   604: invokevirtual 193	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   607: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: aload_2
    //   617: astore 10
    //   619: aload 8
    //   621: astore 9
    //   623: aload_1
    //   624: invokevirtual 194	java/net/SocketException:printStackTrace	()V
    //   627: aload_2
    //   628: astore 10
    //   630: aload 8
    //   632: astore 9
    //   634: new 184	btmsdkobf/bm
    //   637: dup
    //   638: sipush -5054
    //   641: aload_1
    //   642: invokevirtual 193	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   645: invokespecial 190	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   648: athrow
    //   649: aload_2
    //   650: astore 10
    //   652: aload 8
    //   654: astore 9
    //   656: ldc 116
    //   658: new 159	java/lang/StringBuilder
    //   661: dup
    //   662: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   665: ldc 196
    //   667: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_1
    //   671: invokevirtual 197	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   674: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload_2
    //   684: astore 10
    //   686: aload 8
    //   688: astore 9
    //   690: aload_1
    //   691: invokevirtual 198	java/net/SocketTimeoutException:printStackTrace	()V
    //   694: aload_2
    //   695: astore 10
    //   697: aload 8
    //   699: astore 9
    //   701: new 184	btmsdkobf/bm
    //   704: dup
    //   705: sipush -5055
    //   708: aload_1
    //   709: invokevirtual 197	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   712: invokespecial 190	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   715: athrow
    //   716: aload_2
    //   717: astore 10
    //   719: aload 8
    //   721: astore 9
    //   723: ldc 116
    //   725: ldc 200
    //   727: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: aload_2
    //   731: astore 10
    //   733: aload 8
    //   735: astore 9
    //   737: aload_1
    //   738: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   741: aload_2
    //   742: astore 10
    //   744: aload 8
    //   746: astore 9
    //   748: new 184	btmsdkobf/bm
    //   751: dup
    //   752: sipush -5056
    //   755: aload_1
    //   756: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   759: invokespecial 190	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   762: athrow
    //   763: aload_2
    //   764: astore 10
    //   766: aload 8
    //   768: astore 9
    //   770: ldc 116
    //   772: aload_1
    //   773: invokevirtual 202	java/lang/Exception:toString	()Ljava/lang/String;
    //   776: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: aload_2
    //   780: astore 10
    //   782: aload 8
    //   784: astore 9
    //   786: ldc 116
    //   788: ldc 204
    //   790: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   793: aload_2
    //   794: astore 10
    //   796: aload 8
    //   798: astore 9
    //   800: aload_1
    //   801: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   804: aload_2
    //   805: astore 10
    //   807: aload 8
    //   809: astore 9
    //   811: new 184	btmsdkobf/bm
    //   814: dup
    //   815: sipush -5000
    //   818: aload_1
    //   819: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   822: invokespecial 190	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   825: athrow
    //   826: astore_2
    //   827: ldc 116
    //   829: ldc 131
    //   831: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: aload_2
    //   835: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   838: goto -282 -> 556
    //   841: astore_2
    //   842: ldc 116
    //   844: ldc 139
    //   846: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   849: aload_2
    //   850: invokevirtual 137	java/io/IOException:printStackTrace	()V
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
    //   17: ldc 209
    //   19: new 159	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   26: aload_0
    //   27: getfield 24	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   30: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: getstatic 212	java/io/File:separator	Ljava/lang/String;
    //   36: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 28	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   43: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: ldc 209
    //   54: new 159	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   61: aload_0
    //   62: getfield 26	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   65: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 212	java/io/File:separator	Ljava/lang/String;
    //   71: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: getfield 30	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   78: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: new 50	java/io/File
    //   90: dup
    //   91: aload_0
    //   92: getfield 24	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   95: aload_0
    //   96: getfield 28	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   99: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: astore 6
    //   104: aload 6
    //   106: invokevirtual 85	java/io/File:exists	()Z
    //   109: ifeq +384 -> 493
    //   112: aload_0
    //   113: getfield 32	com/tmsdk/base/utils/HttpGetFile:G	I
    //   116: iconst_1
    //   117: if_icmpne +194 -> 311
    //   120: aload_0
    //   121: getfield 42	com/tmsdk/base/utils/HttpGetFile:mContext	Landroid/content/Context;
    //   124: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   127: invokevirtual 54	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   130: aload_0
    //   131: getfield 26	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   134: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifeq +174 -> 311
    //   140: aload_0
    //   141: getfield 42	com/tmsdk/base/utils/HttpGetFile:mContext	Landroid/content/Context;
    //   144: aload_0
    //   145: getfield 30	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   148: aload_0
    //   149: getfield 32	com/tmsdk/base/utils/HttpGetFile:G	I
    //   152: invokevirtual 222	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   155: astore 5
    //   157: aload 6
    //   159: astore 9
    //   161: aload 7
    //   163: astore 10
    //   165: aload 5
    //   167: astore 8
    //   169: new 224	java/io/FileInputStream
    //   172: dup
    //   173: aload 6
    //   175: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   178: astore 7
    //   180: sipush 1024
    //   183: newarray byte
    //   185: astore 10
    //   187: aload 7
    //   189: aload 10
    //   191: invokevirtual 228	java/io/FileInputStream:read	([B)I
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
    //   219: invokevirtual 154	java/io/FileOutputStream:write	([BII)V
    //   222: goto -35 -> 187
    //   225: astore 8
    //   227: aload 7
    //   229: astore 10
    //   231: aload 8
    //   233: astore 7
    //   235: ldc 116
    //   237: ldc 181
    //   239: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload 7
    //   244: invokevirtual 182	java/io/FileNotFoundException:printStackTrace	()V
    //   247: new 184	btmsdkobf/bm
    //   250: dup
    //   251: sipush -7001
    //   254: aload 7
    //   256: invokevirtual 187	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   259: invokespecial 190	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   262: athrow
    //   263: astore 7
    //   265: aload 10
    //   267: ifnull +8 -> 275
    //   270: aload 10
    //   272: invokevirtual 229	java/io/FileInputStream:close	()V
    //   275: aload 5
    //   277: ifnull +8 -> 285
    //   280: aload 5
    //   282: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   285: iload_1
    //   286: ifeq +22 -> 308
    //   289: aload 6
    //   291: ifnull +17 -> 308
    //   294: aload 6
    //   296: invokevirtual 85	java/io/File:exists	()Z
    //   299: ifeq +9 -> 308
    //   302: aload 6
    //   304: invokevirtual 232	java/io/File:delete	()Z
    //   307: pop
    //   308: aload 7
    //   310: athrow
    //   311: new 50	java/io/File
    //   314: dup
    //   315: new 159	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   322: aload_0
    //   323: getfield 26	com/tmsdk/base/utils/HttpGetFile:D	Ljava/lang/String;
    //   326: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: getstatic 212	java/io/File:separator	Ljava/lang/String;
    //   332: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 30	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   339: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   348: astore 5
    //   350: aload 5
    //   352: invokevirtual 85	java/io/File:exists	()Z
    //   355: ifeq +23 -> 378
    //   358: aload 5
    //   360: invokevirtual 232	java/io/File:delete	()Z
    //   363: pop
    //   364: new 96	java/io/FileOutputStream
    //   367: dup
    //   368: aload 5
    //   370: invokespecial 236	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   373: astore 5
    //   375: goto -218 -> 157
    //   378: aload 5
    //   380: invokevirtual 88	java/io/File:getParentFile	()Ljava/io/File;
    //   383: invokevirtual 91	java/io/File:mkdirs	()Z
    //   386: pop
    //   387: aload 5
    //   389: invokevirtual 94	java/io/File:createNewFile	()Z
    //   392: pop
    //   393: new 96	java/io/FileOutputStream
    //   396: dup
    //   397: aload 5
    //   399: invokespecial 236	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
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
    //   428: ldc 116
    //   430: ldc 238
    //   432: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload 6
    //   437: astore 9
    //   439: aload 11
    //   441: astore 10
    //   443: aload 5
    //   445: astore 8
    //   447: aload 7
    //   449: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   452: aload 6
    //   454: astore 9
    //   456: aload 11
    //   458: astore 10
    //   460: aload 5
    //   462: astore 8
    //   464: new 184	btmsdkobf/bm
    //   467: dup
    //   468: sipush -7056
    //   471: aload 7
    //   473: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   476: invokespecial 190	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
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
    //   512: invokevirtual 229	java/io/FileInputStream:close	()V
    //   515: iload_2
    //   516: istore_3
    //   517: iload_3
    //   518: istore_2
    //   519: aload 8
    //   521: ifnull +10 -> 531
    //   524: aload 8
    //   526: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   529: iload_3
    //   530: istore_2
    //   531: iload_1
    //   532: ifeq +22 -> 554
    //   535: aload 6
    //   537: ifnull +17 -> 554
    //   540: aload 6
    //   542: invokevirtual 85	java/io/File:exists	()Z
    //   545: ifeq +9 -> 554
    //   548: aload 6
    //   550: invokevirtual 232	java/io/File:delete	()Z
    //   553: pop
    //   554: iload_2
    //   555: ireturn
    //   556: astore 5
    //   558: ldc 116
    //   560: ldc 240
    //   562: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: aload 5
    //   567: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   570: sipush -7000
    //   573: istore_3
    //   574: goto -57 -> 517
    //   577: astore 5
    //   579: ldc 116
    //   581: ldc 242
    //   583: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload 5
    //   588: invokevirtual 137	java/io/IOException:printStackTrace	()V
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
    //   622: ldc 116
    //   624: ldc 244
    //   626: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload 6
    //   631: astore 9
    //   633: aload 11
    //   635: astore 10
    //   637: aload 5
    //   639: astore 8
    //   641: aload 7
    //   643: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   646: aload 6
    //   648: astore 9
    //   650: aload 11
    //   652: astore 10
    //   654: aload 5
    //   656: astore 8
    //   658: new 184	btmsdkobf/bm
    //   661: dup
    //   662: sipush -7000
    //   665: aload 7
    //   667: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   670: invokespecial 190	btmsdkobf/bm:<init>	(ILjava/lang/String;)V
    //   673: athrow
    //   674: astore 8
    //   676: ldc 116
    //   678: ldc 240
    //   680: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload 8
    //   685: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   688: goto -413 -> 275
    //   691: astore 5
    //   693: ldc 116
    //   695: ldc 242
    //   697: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   700: aload 5
    //   702: invokevirtual 137	java/io/IOException:printStackTrace	()V
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
  public int doGetFile(String paramString1, String paramString2, boolean paramBoolean, HttpGetFile.DataMd5Cheker paramDataMd5Cheker)
  {
    // Byte code:
    //   0: sipush -3000
    //   3: istore 7
    //   5: ldc 249
    //   7: astore 11
    //   9: new 143	android/os/Bundle
    //   12: dup
    //   13: invokespecial 250	android/os/Bundle:<init>	()V
    //   16: astore 12
    //   18: aload_0
    //   19: getfield 34	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   22: istore 9
    //   24: iload 9
    //   26: ifeq +117 -> 143
    //   29: aconst_null
    //   30: astore 10
    //   32: sipush -3003
    //   35: istore 5
    //   37: aload 10
    //   39: ifnull +8 -> 47
    //   42: aload 10
    //   44: invokevirtual 253	java/net/HttpURLConnection:disconnect	()V
    //   47: iload 5
    //   49: istore 7
    //   51: iload 5
    //   53: ifeq +1739 -> 1792
    //   56: iload 5
    //   58: istore 7
    //   60: iload 5
    //   62: bipush 249
    //   64: if_icmpeq +1728 -> 1792
    //   67: aload 12
    //   69: ldc 255
    //   71: iload 5
    //   73: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   76: aload 12
    //   78: ldc_w 257
    //   81: ldc 249
    //   83: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload 12
    //   88: ldc_w 262
    //   91: aload_0
    //   92: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   95: l2i
    //   96: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   99: aload 12
    //   101: ldc_w 264
    //   104: aload_0
    //   105: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   108: l2i
    //   109: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   112: aload_0
    //   113: getfield 40	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   116: ifeq +627 -> 743
    //   119: iconst_1
    //   120: istore 6
    //   122: aload 12
    //   124: ldc_w 266
    //   127: iload 6
    //   129: i2b
    //   130: invokevirtual 270	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   133: aload_0
    //   134: iconst_1
    //   135: aload 12
    //   137: invokevirtual 150	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   140: iload 5
    //   142: ireturn
    //   143: new 272	java/net/URL
    //   146: dup
    //   147: aload_2
    //   148: invokespecial 273	java/net/URL:<init>	(Ljava/lang/String;)V
    //   151: invokevirtual 277	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   154: checkcast 72	java/net/HttpURLConnection
    //   157: astore 10
    //   159: iload 7
    //   161: istore 5
    //   163: iload 7
    //   165: istore 6
    //   167: aload 10
    //   169: sipush 10000
    //   172: invokevirtual 281	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   175: iload 7
    //   177: istore 5
    //   179: iload 7
    //   181: istore 6
    //   183: aload 10
    //   185: sipush 20000
    //   188: invokevirtual 284	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   191: iload 7
    //   193: istore 5
    //   195: iload 7
    //   197: istore 6
    //   199: aload 10
    //   201: iconst_1
    //   202: invokevirtual 288	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   205: iload 7
    //   207: istore 5
    //   209: iload 7
    //   211: istore 6
    //   213: aload 10
    //   215: ldc_w 290
    //   218: invokevirtual 293	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   221: iload 7
    //   223: istore 5
    //   225: iload 7
    //   227: istore 6
    //   229: aload_1
    //   230: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifne +288 -> 521
    //   236: iload 7
    //   238: istore 5
    //   240: iload 7
    //   242: istore 6
    //   244: aload_0
    //   245: new 159	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   252: aload_1
    //   253: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 301
    //   259: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: putfield 28	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   268: iload 7
    //   270: istore 5
    //   272: iload 7
    //   274: istore 6
    //   276: ldc 116
    //   278: new 159	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 303
    //   288: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_0
    //   292: getfield 28	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   295: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: iload 7
    //   306: istore 5
    //   308: iload 7
    //   310: istore 6
    //   312: aload_0
    //   313: getfield 30	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   316: ifnonnull +16 -> 332
    //   319: iload 7
    //   321: istore 5
    //   323: iload 7
    //   325: istore 6
    //   327: aload_0
    //   328: aload_1
    //   329: putfield 30	com/tmsdk/base/utils/HttpGetFile:F	Ljava/lang/String;
    //   332: iload 7
    //   334: istore 5
    //   336: iload 7
    //   338: istore 6
    //   340: new 50	java/io/File
    //   343: dup
    //   344: aload_0
    //   345: getfield 24	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   348: aload_0
    //   349: getfield 28	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   352: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: astore_1
    //   356: iload 7
    //   358: istore 5
    //   360: iload 7
    //   362: istore 6
    //   364: aload_1
    //   365: invokevirtual 85	java/io/File:exists	()Z
    //   368: ifeq +77 -> 445
    //   371: iload 7
    //   373: istore 5
    //   375: iload 7
    //   377: istore 6
    //   379: aload_0
    //   380: aload_1
    //   381: invokevirtual 307	java/io/File:length	()J
    //   384: putfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   387: iload 7
    //   389: istore 5
    //   391: iload 7
    //   393: istore 6
    //   395: aload 10
    //   397: ldc_w 309
    //   400: new 159	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 311
    //   410: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_0
    //   414: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   417: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   420: ldc_w 313
    //   423: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokevirtual 316	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: iload 7
    //   434: istore 5
    //   436: iload 7
    //   438: istore 6
    //   440: aload_0
    //   441: iconst_1
    //   442: putfield 40	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   445: iload 7
    //   447: istore 5
    //   449: iload 7
    //   451: istore 6
    //   453: aload 10
    //   455: invokevirtual 319	java/net/HttpURLConnection:getResponseCode	()I
    //   458: istore 8
    //   460: iload 7
    //   462: istore 5
    //   464: iload 7
    //   466: istore 6
    //   468: ldc 116
    //   470: new 159	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   477: ldc_w 321
    //   480: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: iload 8
    //   485: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 123	btmsdkobf/eg:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: iload 8
    //   496: sipush 200
    //   499: if_icmpeq +39 -> 538
    //   502: iload 8
    //   504: sipush 206
    //   507: if_icmpeq +31 -> 538
    //   510: sipush -3000
    //   513: iload 8
    //   515: isub
    //   516: istore 5
    //   518: goto -481 -> 37
    //   521: iload 7
    //   523: istore 5
    //   525: iload 7
    //   527: istore 6
    //   529: aload_2
    //   530: aconst_null
    //   531: invokestatic 327	btmsdkobf/dz:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   534: astore_1
    //   535: goto -299 -> 236
    //   538: iload 7
    //   540: istore 5
    //   542: iload 7
    //   544: istore 6
    //   546: aload_0
    //   547: getfield 34	com/tmsdk/base/utils/HttpGetFile:H	Z
    //   550: ifeq +11 -> 561
    //   553: sipush -3003
    //   556: istore 5
    //   558: goto -521 -> 37
    //   561: iload 7
    //   563: istore 5
    //   565: iload 7
    //   567: istore 6
    //   569: aload_0
    //   570: aload 10
    //   572: aload 12
    //   574: iload_3
    //   575: invokespecial 329	com/tmsdk/base/utils/HttpGetFile:a	(Ljava/net/HttpURLConnection;Landroid/os/Bundle;Z)I
    //   578: istore 7
    //   580: iload 7
    //   582: ifeq +17 -> 599
    //   585: iload 7
    //   587: bipush 249
    //   589: if_icmpne +1206 -> 1795
    //   592: iload 7
    //   594: istore 5
    //   596: goto -559 -> 37
    //   599: aload 4
    //   601: ifnull +109 -> 710
    //   604: iload 7
    //   606: istore 5
    //   608: iload 7
    //   610: istore 6
    //   612: aload 4
    //   614: new 159	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   621: aload_0
    //   622: getfield 24	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   625: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: getstatic 212	java/io/File:separator	Ljava/lang/String;
    //   631: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload_0
    //   635: getfield 28	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   638: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokeinterface 335 2 0
    //   649: ifne +61 -> 710
    //   652: sipush -7000
    //   655: istore 6
    //   657: iload 6
    //   659: istore 5
    //   661: new 50	java/io/File
    //   664: dup
    //   665: new 159	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   672: aload_0
    //   673: getfield 24	com/tmsdk/base/utils/HttpGetFile:C	Ljava/lang/String;
    //   676: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: getstatic 212	java/io/File:separator	Ljava/lang/String;
    //   682: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_0
    //   686: getfield 28	com/tmsdk/base/utils/HttpGetFile:E	Ljava/lang/String;
    //   689: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   698: invokevirtual 232	java/io/File:delete	()Z
    //   701: pop
    //   702: sipush -7000
    //   705: istore 5
    //   707: goto -670 -> 37
    //   710: iload 7
    //   712: istore 5
    //   714: iload 7
    //   716: istore 6
    //   718: aload_0
    //   719: iconst_1
    //   720: invokespecial 337	com/tmsdk/base/utils/HttpGetFile:a	(Z)I
    //   723: istore 7
    //   725: iload 7
    //   727: ifeq +10 -> 737
    //   730: iload 7
    //   732: istore 5
    //   734: goto -697 -> 37
    //   737: iconst_0
    //   738: istore 5
    //   740: goto -703 -> 37
    //   743: iconst_0
    //   744: istore 6
    //   746: goto -624 -> 122
    //   749: astore 10
    //   751: aconst_null
    //   752: astore 4
    //   754: sipush -3054
    //   757: istore 6
    //   759: iload 6
    //   761: istore 5
    //   763: aload 4
    //   765: astore_2
    //   766: aload 11
    //   768: astore_1
    //   769: aload 10
    //   771: invokevirtual 193	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   774: astore 11
    //   776: iload 6
    //   778: istore 5
    //   780: aload 4
    //   782: astore_2
    //   783: aload 11
    //   785: astore_1
    //   786: ldc 116
    //   788: new 159	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   795: ldc 192
    //   797: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: aload 10
    //   802: invokevirtual 193	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   805: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: iload 6
    //   816: istore 5
    //   818: aload 4
    //   820: astore_2
    //   821: aload 11
    //   823: astore_1
    //   824: aload 10
    //   826: invokevirtual 194	java/net/SocketException:printStackTrace	()V
    //   829: aload 4
    //   831: ifnull +8 -> 839
    //   834: aload 4
    //   836: invokevirtual 253	java/net/HttpURLConnection:disconnect	()V
    //   839: aload 12
    //   841: ldc 255
    //   843: sipush -3054
    //   846: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   849: aload 12
    //   851: ldc_w 257
    //   854: aload 11
    //   856: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   859: aload 12
    //   861: ldc_w 262
    //   864: aload_0
    //   865: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   868: l2i
    //   869: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   872: aload 12
    //   874: ldc_w 264
    //   877: aload_0
    //   878: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   881: l2i
    //   882: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   885: aload_0
    //   886: getfield 40	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   889: ifeq +28 -> 917
    //   892: iconst_1
    //   893: istore 5
    //   895: aload 12
    //   897: ldc_w 266
    //   900: iload 5
    //   902: i2b
    //   903: invokevirtual 270	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   906: aload_0
    //   907: iconst_1
    //   908: aload 12
    //   910: invokevirtual 150	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   913: sipush -3054
    //   916: ireturn
    //   917: iconst_0
    //   918: istore 5
    //   920: goto -25 -> 895
    //   923: astore 10
    //   925: aconst_null
    //   926: astore 4
    //   928: sipush -3055
    //   931: istore 6
    //   933: iload 6
    //   935: istore 5
    //   937: aload 4
    //   939: astore_2
    //   940: aload 11
    //   942: astore_1
    //   943: aload 10
    //   945: invokevirtual 197	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   948: astore 11
    //   950: iload 6
    //   952: istore 5
    //   954: aload 4
    //   956: astore_2
    //   957: aload 11
    //   959: astore_1
    //   960: ldc 116
    //   962: new 159	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   969: ldc 196
    //   971: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: aload 10
    //   976: invokevirtual 197	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   979: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   988: iload 6
    //   990: istore 5
    //   992: aload 4
    //   994: astore_2
    //   995: aload 11
    //   997: astore_1
    //   998: aload 10
    //   1000: invokevirtual 198	java/net/SocketTimeoutException:printStackTrace	()V
    //   1003: aload 4
    //   1005: ifnull +8 -> 1013
    //   1008: aload 4
    //   1010: invokevirtual 253	java/net/HttpURLConnection:disconnect	()V
    //   1013: aload 12
    //   1015: ldc 255
    //   1017: sipush -3055
    //   1020: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1023: aload 12
    //   1025: ldc_w 257
    //   1028: aload 11
    //   1030: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: aload 12
    //   1035: ldc_w 262
    //   1038: aload_0
    //   1039: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1042: l2i
    //   1043: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1046: aload 12
    //   1048: ldc_w 264
    //   1051: aload_0
    //   1052: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1055: l2i
    //   1056: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1059: aload_0
    //   1060: getfield 40	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1063: ifeq +28 -> 1091
    //   1066: iconst_1
    //   1067: istore 5
    //   1069: aload 12
    //   1071: ldc_w 266
    //   1074: iload 5
    //   1076: i2b
    //   1077: invokevirtual 270	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1080: aload_0
    //   1081: iconst_1
    //   1082: aload 12
    //   1084: invokevirtual 150	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1087: sipush -3055
    //   1090: ireturn
    //   1091: iconst_0
    //   1092: istore 5
    //   1094: goto -25 -> 1069
    //   1097: astore 10
    //   1099: aconst_null
    //   1100: astore 4
    //   1102: sipush -3056
    //   1105: istore 6
    //   1107: iload 6
    //   1109: istore 5
    //   1111: aload 4
    //   1113: astore_2
    //   1114: aload 11
    //   1116: astore_1
    //   1117: aload 10
    //   1119: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1122: astore 11
    //   1124: iload 6
    //   1126: istore 5
    //   1128: aload 4
    //   1130: astore_2
    //   1131: aload 11
    //   1133: astore_1
    //   1134: ldc 116
    //   1136: new 159	java/lang/StringBuilder
    //   1139: dup
    //   1140: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1143: ldc_w 339
    //   1146: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: aload 10
    //   1151: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1154: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1160: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1163: iload 6
    //   1165: istore 5
    //   1167: aload 4
    //   1169: astore_2
    //   1170: aload 11
    //   1172: astore_1
    //   1173: aload 10
    //   1175: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   1178: aload 4
    //   1180: ifnull +8 -> 1188
    //   1183: aload 4
    //   1185: invokevirtual 253	java/net/HttpURLConnection:disconnect	()V
    //   1188: aload 12
    //   1190: ldc 255
    //   1192: sipush -3056
    //   1195: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1198: aload 12
    //   1200: ldc_w 257
    //   1203: aload 11
    //   1205: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1208: aload 12
    //   1210: ldc_w 262
    //   1213: aload_0
    //   1214: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1217: l2i
    //   1218: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1221: aload 12
    //   1223: ldc_w 264
    //   1226: aload_0
    //   1227: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1230: l2i
    //   1231: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1234: aload_0
    //   1235: getfield 40	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1238: ifeq +28 -> 1266
    //   1241: iconst_1
    //   1242: istore 5
    //   1244: aload 12
    //   1246: ldc_w 266
    //   1249: iload 5
    //   1251: i2b
    //   1252: invokevirtual 270	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1255: aload_0
    //   1256: iconst_1
    //   1257: aload 12
    //   1259: invokevirtual 150	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1262: sipush -3056
    //   1265: ireturn
    //   1266: iconst_0
    //   1267: istore 5
    //   1269: goto -25 -> 1244
    //   1272: astore 10
    //   1274: sipush -3000
    //   1277: istore 5
    //   1279: aconst_null
    //   1280: astore 4
    //   1282: aload 4
    //   1284: astore_2
    //   1285: aload 11
    //   1287: astore_1
    //   1288: aload 10
    //   1290: invokevirtual 341	btmsdkobf/bm:I	()I
    //   1293: istore 6
    //   1295: iload 6
    //   1297: istore 5
    //   1299: aload 4
    //   1301: astore_2
    //   1302: aload 11
    //   1304: astore_1
    //   1305: aload 10
    //   1307: invokevirtual 342	btmsdkobf/bm:getMessage	()Ljava/lang/String;
    //   1310: astore 10
    //   1312: aload 4
    //   1314: ifnull +8 -> 1322
    //   1317: aload 4
    //   1319: invokevirtual 253	java/net/HttpURLConnection:disconnect	()V
    //   1322: iload 6
    //   1324: istore 7
    //   1326: iload 6
    //   1328: ifeq +464 -> 1792
    //   1331: iload 6
    //   1333: istore 7
    //   1335: iload 6
    //   1337: bipush 249
    //   1339: if_icmpeq +453 -> 1792
    //   1342: aload 12
    //   1344: ldc 255
    //   1346: iload 6
    //   1348: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1351: aload 12
    //   1353: ldc_w 257
    //   1356: aload 10
    //   1358: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1361: aload 12
    //   1363: ldc_w 262
    //   1366: aload_0
    //   1367: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1370: l2i
    //   1371: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1374: aload 12
    //   1376: ldc_w 264
    //   1379: aload_0
    //   1380: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1383: l2i
    //   1384: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1387: aload_0
    //   1388: getfield 40	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1391: ifeq +27 -> 1418
    //   1394: iconst_1
    //   1395: istore 5
    //   1397: aload 12
    //   1399: ldc_w 266
    //   1402: iload 5
    //   1404: i2b
    //   1405: invokevirtual 270	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1408: aload_0
    //   1409: iconst_1
    //   1410: aload 12
    //   1412: invokevirtual 150	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1415: iload 6
    //   1417: ireturn
    //   1418: iconst_0
    //   1419: istore 5
    //   1421: goto -24 -> 1397
    //   1424: astore 10
    //   1426: aconst_null
    //   1427: astore 4
    //   1429: sipush -3000
    //   1432: istore 6
    //   1434: iload 6
    //   1436: istore 5
    //   1438: aload 4
    //   1440: astore_2
    //   1441: aload 11
    //   1443: astore_1
    //   1444: aload 10
    //   1446: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1449: astore 11
    //   1451: iload 6
    //   1453: istore 5
    //   1455: aload 4
    //   1457: astore_2
    //   1458: aload 11
    //   1460: astore_1
    //   1461: ldc 116
    //   1463: new 159	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1470: ldc_w 344
    //   1473: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: aload 10
    //   1478: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1481: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1487: invokestatic 134	btmsdkobf/eg:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   1490: iload 6
    //   1492: istore 5
    //   1494: aload 4
    //   1496: astore_2
    //   1497: aload 11
    //   1499: astore_1
    //   1500: aload 10
    //   1502: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   1505: aload 4
    //   1507: ifnull +8 -> 1515
    //   1510: aload 4
    //   1512: invokevirtual 253	java/net/HttpURLConnection:disconnect	()V
    //   1515: aload 12
    //   1517: ldc 255
    //   1519: sipush -3000
    //   1522: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1525: aload 12
    //   1527: ldc_w 257
    //   1530: aload 11
    //   1532: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1535: aload 12
    //   1537: ldc_w 262
    //   1540: aload_0
    //   1541: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1544: l2i
    //   1545: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1548: aload 12
    //   1550: ldc_w 264
    //   1553: aload_0
    //   1554: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1557: l2i
    //   1558: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1561: aload_0
    //   1562: getfield 40	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1565: ifeq +28 -> 1593
    //   1568: iconst_1
    //   1569: istore 5
    //   1571: aload 12
    //   1573: ldc_w 266
    //   1576: iload 5
    //   1578: i2b
    //   1579: invokevirtual 270	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1582: aload_0
    //   1583: iconst_1
    //   1584: aload 12
    //   1586: invokevirtual 150	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1589: sipush -3000
    //   1592: ireturn
    //   1593: iconst_0
    //   1594: istore 5
    //   1596: goto -25 -> 1571
    //   1599: astore_1
    //   1600: aconst_null
    //   1601: astore 10
    //   1603: sipush -3000
    //   1606: istore 5
    //   1608: ldc 249
    //   1610: astore_2
    //   1611: aload 10
    //   1613: ifnull +8 -> 1621
    //   1616: aload 10
    //   1618: invokevirtual 253	java/net/HttpURLConnection:disconnect	()V
    //   1621: iload 5
    //   1623: ifeq +82 -> 1705
    //   1626: iload 5
    //   1628: bipush 249
    //   1630: if_icmpeq +75 -> 1705
    //   1633: aload 12
    //   1635: ldc 255
    //   1637: iload 5
    //   1639: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1642: aload 12
    //   1644: ldc_w 257
    //   1647: aload_2
    //   1648: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1651: aload 12
    //   1653: ldc_w 262
    //   1656: aload_0
    //   1657: getfield 36	com/tmsdk/base/utils/HttpGetFile:I	J
    //   1660: l2i
    //   1661: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1664: aload 12
    //   1666: ldc_w 264
    //   1669: aload_0
    //   1670: getfield 38	com/tmsdk/base/utils/HttpGetFile:J	J
    //   1673: l2i
    //   1674: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1677: aload_0
    //   1678: getfield 40	com/tmsdk/base/utils/HttpGetFile:K	Z
    //   1681: ifeq +26 -> 1707
    //   1684: iconst_1
    //   1685: istore 5
    //   1687: aload 12
    //   1689: ldc_w 266
    //   1692: iload 5
    //   1694: i2b
    //   1695: invokevirtual 270	android/os/Bundle:putByte	(Ljava/lang/String;B)V
    //   1698: aload_0
    //   1699: iconst_1
    //   1700: aload 12
    //   1702: invokevirtual 150	com/tmsdk/base/utils/HttpGetFile:a	(ILandroid/os/Bundle;)V
    //   1705: aload_1
    //   1706: athrow
    //   1707: iconst_0
    //   1708: istore 5
    //   1710: goto -23 -> 1687
    //   1713: astore_1
    //   1714: ldc 249
    //   1716: astore_2
    //   1717: goto -106 -> 1611
    //   1720: astore 4
    //   1722: aload_2
    //   1723: astore 10
    //   1725: aload_1
    //   1726: astore_2
    //   1727: aload 4
    //   1729: astore_1
    //   1730: goto -119 -> 1611
    //   1733: astore_1
    //   1734: aload 10
    //   1736: astore 4
    //   1738: aload_1
    //   1739: astore 10
    //   1741: goto -312 -> 1429
    //   1744: astore_1
    //   1745: iload 6
    //   1747: istore 5
    //   1749: aload 10
    //   1751: astore 4
    //   1753: aload_1
    //   1754: astore 10
    //   1756: goto -474 -> 1282
    //   1759: astore_1
    //   1760: aload 10
    //   1762: astore 4
    //   1764: aload_1
    //   1765: astore 10
    //   1767: goto -665 -> 1102
    //   1770: astore_1
    //   1771: aload 10
    //   1773: astore 4
    //   1775: aload_1
    //   1776: astore 10
    //   1778: goto -850 -> 928
    //   1781: astore_1
    //   1782: aload 10
    //   1784: astore 4
    //   1786: aload_1
    //   1787: astore 10
    //   1789: goto -1035 -> 754
    //   1792: iload 7
    //   1794: ireturn
    //   1795: iload 7
    //   1797: istore 5
    //   1799: goto -1762 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1802	0	this	HttpGetFile
    //   0	1802	1	paramString1	String
    //   0	1802	2	paramString2	String
    //   0	1802	3	paramBoolean	boolean
    //   0	1802	4	paramDataMd5Cheker	HttpGetFile.DataMd5Cheker
    //   35	1763	5	i	int
    //   120	1626	6	j	int
    //   3	1793	7	k	int
    //   458	58	8	m	int
    //   22	3	9	bool	boolean
    //   30	541	10	localHttpURLConnection	java.net.HttpURLConnection
    //   749	76	10	localSocketException	java.net.SocketException
    //   923	76	10	localSocketTimeoutException	java.net.SocketTimeoutException
    //   1097	77	10	localIOException	java.io.IOException
    //   1272	34	10	localbm	btmsdkobf.bm
    //   1310	47	10	str1	String
    //   1424	77	10	localException	java.lang.Exception
    //   1601	187	10	str2	String
    //   7	1524	11	str3	String
    //   16	1685	12	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   18	24	749	java/net/SocketException
    //   143	159	749	java/net/SocketException
    //   18	24	923	java/net/SocketTimeoutException
    //   143	159	923	java/net/SocketTimeoutException
    //   18	24	1097	java/io/IOException
    //   143	159	1097	java/io/IOException
    //   18	24	1272	btmsdkobf/bm
    //   143	159	1272	btmsdkobf/bm
    //   18	24	1424	java/lang/Exception
    //   143	159	1424	java/lang/Exception
    //   18	24	1599	finally
    //   143	159	1599	finally
    //   167	175	1713	finally
    //   183	191	1713	finally
    //   199	205	1713	finally
    //   213	221	1713	finally
    //   229	236	1713	finally
    //   244	268	1713	finally
    //   276	304	1713	finally
    //   312	319	1713	finally
    //   327	332	1713	finally
    //   340	356	1713	finally
    //   364	371	1713	finally
    //   379	387	1713	finally
    //   395	432	1713	finally
    //   440	445	1713	finally
    //   453	460	1713	finally
    //   468	494	1713	finally
    //   529	535	1713	finally
    //   546	553	1713	finally
    //   569	580	1713	finally
    //   612	652	1713	finally
    //   661	702	1713	finally
    //   718	725	1713	finally
    //   769	776	1720	finally
    //   786	814	1720	finally
    //   824	829	1720	finally
    //   943	950	1720	finally
    //   960	988	1720	finally
    //   998	1003	1720	finally
    //   1117	1124	1720	finally
    //   1134	1163	1720	finally
    //   1173	1178	1720	finally
    //   1288	1295	1720	finally
    //   1305	1312	1720	finally
    //   1444	1451	1720	finally
    //   1461	1490	1720	finally
    //   1500	1505	1720	finally
    //   167	175	1733	java/lang/Exception
    //   183	191	1733	java/lang/Exception
    //   199	205	1733	java/lang/Exception
    //   213	221	1733	java/lang/Exception
    //   229	236	1733	java/lang/Exception
    //   244	268	1733	java/lang/Exception
    //   276	304	1733	java/lang/Exception
    //   312	319	1733	java/lang/Exception
    //   327	332	1733	java/lang/Exception
    //   340	356	1733	java/lang/Exception
    //   364	371	1733	java/lang/Exception
    //   379	387	1733	java/lang/Exception
    //   395	432	1733	java/lang/Exception
    //   440	445	1733	java/lang/Exception
    //   453	460	1733	java/lang/Exception
    //   468	494	1733	java/lang/Exception
    //   529	535	1733	java/lang/Exception
    //   546	553	1733	java/lang/Exception
    //   569	580	1733	java/lang/Exception
    //   612	652	1733	java/lang/Exception
    //   661	702	1733	java/lang/Exception
    //   718	725	1733	java/lang/Exception
    //   167	175	1744	btmsdkobf/bm
    //   183	191	1744	btmsdkobf/bm
    //   199	205	1744	btmsdkobf/bm
    //   213	221	1744	btmsdkobf/bm
    //   229	236	1744	btmsdkobf/bm
    //   244	268	1744	btmsdkobf/bm
    //   276	304	1744	btmsdkobf/bm
    //   312	319	1744	btmsdkobf/bm
    //   327	332	1744	btmsdkobf/bm
    //   340	356	1744	btmsdkobf/bm
    //   364	371	1744	btmsdkobf/bm
    //   379	387	1744	btmsdkobf/bm
    //   395	432	1744	btmsdkobf/bm
    //   440	445	1744	btmsdkobf/bm
    //   453	460	1744	btmsdkobf/bm
    //   468	494	1744	btmsdkobf/bm
    //   529	535	1744	btmsdkobf/bm
    //   546	553	1744	btmsdkobf/bm
    //   569	580	1744	btmsdkobf/bm
    //   612	652	1744	btmsdkobf/bm
    //   661	702	1744	btmsdkobf/bm
    //   718	725	1744	btmsdkobf/bm
    //   167	175	1759	java/io/IOException
    //   183	191	1759	java/io/IOException
    //   199	205	1759	java/io/IOException
    //   213	221	1759	java/io/IOException
    //   229	236	1759	java/io/IOException
    //   244	268	1759	java/io/IOException
    //   276	304	1759	java/io/IOException
    //   312	319	1759	java/io/IOException
    //   327	332	1759	java/io/IOException
    //   340	356	1759	java/io/IOException
    //   364	371	1759	java/io/IOException
    //   379	387	1759	java/io/IOException
    //   395	432	1759	java/io/IOException
    //   440	445	1759	java/io/IOException
    //   453	460	1759	java/io/IOException
    //   468	494	1759	java/io/IOException
    //   529	535	1759	java/io/IOException
    //   546	553	1759	java/io/IOException
    //   569	580	1759	java/io/IOException
    //   612	652	1759	java/io/IOException
    //   661	702	1759	java/io/IOException
    //   718	725	1759	java/io/IOException
    //   167	175	1770	java/net/SocketTimeoutException
    //   183	191	1770	java/net/SocketTimeoutException
    //   199	205	1770	java/net/SocketTimeoutException
    //   213	221	1770	java/net/SocketTimeoutException
    //   229	236	1770	java/net/SocketTimeoutException
    //   244	268	1770	java/net/SocketTimeoutException
    //   276	304	1770	java/net/SocketTimeoutException
    //   312	319	1770	java/net/SocketTimeoutException
    //   327	332	1770	java/net/SocketTimeoutException
    //   340	356	1770	java/net/SocketTimeoutException
    //   364	371	1770	java/net/SocketTimeoutException
    //   379	387	1770	java/net/SocketTimeoutException
    //   395	432	1770	java/net/SocketTimeoutException
    //   440	445	1770	java/net/SocketTimeoutException
    //   453	460	1770	java/net/SocketTimeoutException
    //   468	494	1770	java/net/SocketTimeoutException
    //   529	535	1770	java/net/SocketTimeoutException
    //   546	553	1770	java/net/SocketTimeoutException
    //   569	580	1770	java/net/SocketTimeoutException
    //   612	652	1770	java/net/SocketTimeoutException
    //   661	702	1770	java/net/SocketTimeoutException
    //   718	725	1770	java/net/SocketTimeoutException
    //   167	175	1781	java/net/SocketException
    //   183	191	1781	java/net/SocketException
    //   199	205	1781	java/net/SocketException
    //   213	221	1781	java/net/SocketException
    //   229	236	1781	java/net/SocketException
    //   244	268	1781	java/net/SocketException
    //   276	304	1781	java/net/SocketException
    //   312	319	1781	java/net/SocketException
    //   327	332	1781	java/net/SocketException
    //   340	356	1781	java/net/SocketException
    //   364	371	1781	java/net/SocketException
    //   379	387	1781	java/net/SocketException
    //   395	432	1781	java/net/SocketException
    //   440	445	1781	java/net/SocketException
    //   453	460	1781	java/net/SocketException
    //   468	494	1781	java/net/SocketException
    //   529	535	1781	java/net/SocketException
    //   546	553	1781	java/net/SocketException
    //   569	580	1781	java/net/SocketException
    //   612	652	1781	java/net/SocketException
    //   661	702	1781	java/net/SocketException
    //   718	725	1781	java/net/SocketException
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.HttpGetFile
 * JD-Core Version:    0.7.0.1
 */