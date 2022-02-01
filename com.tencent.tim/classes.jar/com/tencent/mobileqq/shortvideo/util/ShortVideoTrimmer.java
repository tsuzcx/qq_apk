package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import ankx;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoTrimmer
{
  public static int agR;
  private static boolean cHQ;
  public static AtomicBoolean dN = new AtomicBoolean(true);
  static Process f;
  static final Object lock = new Object();
  
  private static void GY(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoTrimmer", 2, paramString);
    }
    if (cHQ) {
      Log.d("ShortVideoTrimmer", paramString);
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString1, String paramString2, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, b paramb, angv.a parama, angv.c paramc)
  {
    // Byte code:
    //   0: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: new 6	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a
    //   8: dup
    //   9: invokespecial 70	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: iconst_1
    //   15: putfield 73	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:cHR	Z
    //   18: aload_3
    //   19: aload 6
    //   21: getfield 78	angv$c:rotation	I
    //   24: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: putfield 88	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:rotate	Ljava/lang/String;
    //   30: aload_3
    //   31: aload 6
    //   33: getfield 91	angv$c:width	I
    //   36: putfield 94	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:srcWidth	I
    //   39: aload_3
    //   40: aload 6
    //   42: getfield 97	angv$c:height	I
    //   45: putfield 100	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:srcHeight	I
    //   48: aload_3
    //   49: aload 6
    //   51: getfield 103	angv$c:duration	I
    //   54: i2l
    //   55: putfield 106	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:duration	J
    //   58: aload_3
    //   59: aload 5
    //   61: getfield 111	angv$a:dFA	I
    //   64: putfield 114	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:dJo	I
    //   67: aload_3
    //   68: aload 5
    //   70: getfield 117	angv$a:dFB	I
    //   73: putfield 120	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:dJp	I
    //   76: aload_3
    //   77: bipush 25
    //   79: putfield 123	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:dJq	I
    //   82: aload_3
    //   83: aload 5
    //   85: getfield 126	angv$a:alb	J
    //   88: putfield 129	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:alY	J
    //   91: aload_3
    //   92: aload 5
    //   94: getfield 132	angv$a:ala	J
    //   97: putfield 135	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:alZ	J
    //   100: aload_3
    //   101: getfield 73	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:cHR	Z
    //   104: ifne +10 -> 114
    //   107: ldc 137
    //   109: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   112: iconst_m1
    //   113: ireturn
    //   114: aload_1
    //   115: aload_2
    //   116: aload_3
    //   117: invokestatic 142	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a;)[Ljava/lang/String;
    //   120: astore 6
    //   122: aload 6
    //   124: ifnonnull +11 -> 135
    //   127: ldc 144
    //   129: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   132: bipush 254
    //   134: ireturn
    //   135: aload_0
    //   136: invokestatic 150	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   139: astore_0
    //   140: invokestatic 156	com/tencent/mobileqq/shortvideo/VideoEnvironment:zQ	()Ljava/lang/String;
    //   143: astore 15
    //   145: getstatic 51	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:cHQ	Z
    //   148: ifne +38 -> 186
    //   151: new 158	java/io/File
    //   154: dup
    //   155: new 160	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   162: aload_0
    //   163: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 15
    //   168: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: invokevirtual 173	java/io/File:exists	()Z
    //   180: ifne +6 -> 186
    //   183: bipush 253
    //   185: ireturn
    //   186: aconst_null
    //   187: astore_1
    //   188: aconst_null
    //   189: astore 5
    //   191: aconst_null
    //   192: astore_3
    //   193: new 175	java/lang/ProcessBuilder
    //   196: dup
    //   197: iconst_0
    //   198: anewarray 80	java/lang/String
    //   201: invokespecial 178	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   204: astore 14
    //   206: aload 14
    //   208: iconst_1
    //   209: invokevirtual 182	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   212: pop
    //   213: new 184	java/util/ArrayList
    //   216: dup
    //   217: invokespecial 185	java/util/ArrayList:<init>	()V
    //   220: astore 13
    //   222: aload 13
    //   224: new 160	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   231: aload_0
    //   232: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc 187
    //   237: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokeinterface 193 2 0
    //   248: pop
    //   249: new 160	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   256: ldc 195
    //   258: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 13
    //   263: iconst_0
    //   264: invokeinterface 199 2 0
    //   269: checkcast 80	java/lang/String
    //   272: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   281: aload 6
    //   283: arraylength
    //   284: istore 8
    //   286: iconst_0
    //   287: istore 7
    //   289: iload 7
    //   291: iload 8
    //   293: if_icmpge +25 -> 318
    //   296: aload 13
    //   298: aload 6
    //   300: iload 7
    //   302: aaload
    //   303: invokeinterface 193 2 0
    //   308: pop
    //   309: iload 7
    //   311: iconst_1
    //   312: iadd
    //   313: istore 7
    //   315: goto -26 -> 289
    //   318: aload 13
    //   320: new 160	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   327: aload_0
    //   328: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 15
    //   333: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokeinterface 193 2 0
    //   344: pop
    //   345: aload 14
    //   347: aload 13
    //   349: invokevirtual 203	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   352: pop
    //   353: new 160	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   360: ldc 205
    //   362: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 13
    //   367: aload 13
    //   369: invokeinterface 209 1 0
    //   374: iconst_1
    //   375: isub
    //   376: invokeinterface 199 2 0
    //   381: checkcast 80	java/lang/String
    //   384: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   393: aload 14
    //   395: invokevirtual 213	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   398: astore 14
    //   400: getstatic 27	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   403: astore_0
    //   404: aload_0
    //   405: monitorenter
    //   406: aload 14
    //   408: putstatic 215	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   411: aload_0
    //   412: monitorexit
    //   413: aload 4
    //   415: ifnull +13 -> 428
    //   418: aload 4
    //   420: getstatic 215	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   423: invokeinterface 218 2 0
    //   428: getstatic 34	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:dN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   431: invokevirtual 220	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   434: ifne +276 -> 710
    //   437: aload 4
    //   439: ifnull +10 -> 449
    //   442: aload 4
    //   444: invokeinterface 223 1 0
    //   449: aconst_null
    //   450: putstatic 215	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   453: aload 14
    //   455: invokevirtual 228	java/lang/Process:destroy	()V
    //   458: getstatic 34	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:dN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   461: iconst_1
    //   462: invokevirtual 231	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   465: iconst_0
    //   466: ifeq +11 -> 477
    //   469: new 233	java/lang/NullPointerException
    //   472: dup
    //   473: invokespecial 234	java/lang/NullPointerException:<init>	()V
    //   476: athrow
    //   477: iconst_0
    //   478: ifeq +11 -> 489
    //   481: new 233	java/lang/NullPointerException
    //   484: dup
    //   485: invokespecial 234	java/lang/NullPointerException:<init>	()V
    //   488: athrow
    //   489: iconst_0
    //   490: ifeq -378 -> 112
    //   493: new 233	java/lang/NullPointerException
    //   496: dup
    //   497: invokespecial 234	java/lang/NullPointerException:<init>	()V
    //   500: athrow
    //   501: astore_0
    //   502: iconst_m1
    //   503: ireturn
    //   504: astore 4
    //   506: aload_0
    //   507: monitorexit
    //   508: aload 4
    //   510: athrow
    //   511: astore 14
    //   513: aconst_null
    //   514: astore_0
    //   515: aconst_null
    //   516: astore_1
    //   517: aconst_null
    //   518: astore 4
    //   520: sipush -1001
    //   523: istore 8
    //   525: aload 4
    //   527: astore 6
    //   529: aload_1
    //   530: astore 5
    //   532: aload_0
    //   533: astore_3
    //   534: aload 14
    //   536: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   539: aload 4
    //   541: astore 6
    //   543: aload_1
    //   544: astore 5
    //   546: aload_0
    //   547: astore_3
    //   548: new 160	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   555: ldc 239
    //   557: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload 14
    //   562: invokevirtual 240	java/io/IOException:toString	()Ljava/lang/String;
    //   565: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   574: aload_0
    //   575: ifnull +7 -> 582
    //   578: aload_0
    //   579: invokevirtual 245	java/io/InputStream:close	()V
    //   582: aload_1
    //   583: ifnull +7 -> 590
    //   586: aload_1
    //   587: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   590: iload 8
    //   592: istore 7
    //   594: aload 4
    //   596: ifnull +12 -> 608
    //   599: aload 4
    //   601: invokevirtual 251	java/io/BufferedReader:close	()V
    //   604: iload 8
    //   606: istore 7
    //   608: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   611: lstore 9
    //   613: new 160	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   620: ldc 253
    //   622: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: lload 9
    //   627: lload 11
    //   629: lsub
    //   630: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   633: ldc_w 258
    //   636: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: iload 7
    //   641: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   644: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   650: iload 7
    //   652: ifeq +48 -> 700
    //   655: new 158	java/io/File
    //   658: dup
    //   659: aload_2
    //   660: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   663: astore_0
    //   664: aload_0
    //   665: invokevirtual 173	java/io/File:exists	()Z
    //   668: ifeq +32 -> 700
    //   671: aload_0
    //   672: invokevirtual 264	java/io/File:delete	()Z
    //   675: pop
    //   676: new 160	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   683: ldc_w 266
    //   686: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: iload 7
    //   691: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   700: getstatic 34	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:dN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   703: iconst_1
    //   704: invokevirtual 231	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   707: iload 7
    //   709: ireturn
    //   710: aload 14
    //   712: invokevirtual 270	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   715: astore_0
    //   716: new 247	java/io/InputStreamReader
    //   719: dup
    //   720: aload_0
    //   721: invokespecial 273	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   724: astore_1
    //   725: new 250	java/io/BufferedReader
    //   728: dup
    //   729: aload_1
    //   730: invokespecial 276	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   733: astore 13
    //   735: aload 13
    //   737: astore 6
    //   739: aload_1
    //   740: astore 5
    //   742: aload_0
    //   743: astore_3
    //   744: aload 14
    //   746: invokevirtual 279	java/lang/Process:waitFor	()I
    //   749: pop
    //   750: aload 13
    //   752: astore 6
    //   754: aload_1
    //   755: astore 5
    //   757: aload_0
    //   758: astore_3
    //   759: aload 14
    //   761: invokevirtual 282	java/lang/Process:exitValue	()I
    //   764: istore 8
    //   766: aload 13
    //   768: astore 6
    //   770: aload_1
    //   771: astore 5
    //   773: aload_0
    //   774: astore_3
    //   775: new 160	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   782: ldc_w 284
    //   785: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: iload 8
    //   790: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   793: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   799: aload 13
    //   801: astore 6
    //   803: aload_1
    //   804: astore 5
    //   806: aload_0
    //   807: astore_3
    //   808: aload 13
    //   810: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   813: astore 15
    //   815: aload 15
    //   817: ifnull +39 -> 856
    //   820: aload 13
    //   822: astore 6
    //   824: aload_1
    //   825: astore 5
    //   827: aload_0
    //   828: astore_3
    //   829: new 160	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   836: ldc_w 289
    //   839: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload 15
    //   844: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   853: goto -54 -> 799
    //   856: aload 13
    //   858: astore 6
    //   860: aload_1
    //   861: astore 5
    //   863: aload_0
    //   864: astore_3
    //   865: aload 14
    //   867: invokevirtual 228	java/lang/Process:destroy	()V
    //   870: aload 4
    //   872: ifnull +19 -> 891
    //   875: aload 13
    //   877: astore 6
    //   879: aload_1
    //   880: astore 5
    //   882: aload_0
    //   883: astore_3
    //   884: aload 4
    //   886: invokeinterface 292 1 0
    //   891: aload 13
    //   893: astore 6
    //   895: aload_1
    //   896: astore 5
    //   898: aload_0
    //   899: astore_3
    //   900: getstatic 27	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   903: astore 4
    //   905: aload 13
    //   907: astore 6
    //   909: aload_1
    //   910: astore 5
    //   912: aload_0
    //   913: astore_3
    //   914: aload 4
    //   916: monitorenter
    //   917: aconst_null
    //   918: putstatic 215	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   921: aload 4
    //   923: monitorexit
    //   924: aload 13
    //   926: astore 6
    //   928: aload_1
    //   929: astore 5
    //   931: aload_0
    //   932: astore_3
    //   933: ldc_w 294
    //   936: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   939: aload_0
    //   940: ifnull +7 -> 947
    //   943: aload_0
    //   944: invokevirtual 245	java/io/InputStream:close	()V
    //   947: aload_1
    //   948: ifnull +7 -> 955
    //   951: aload_1
    //   952: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   955: iload 8
    //   957: istore 7
    //   959: aload 13
    //   961: ifnull -353 -> 608
    //   964: aload 13
    //   966: invokevirtual 251	java/io/BufferedReader:close	()V
    //   969: iload 8
    //   971: istore 7
    //   973: goto -365 -> 608
    //   976: astore_0
    //   977: iload 8
    //   979: istore 7
    //   981: goto -373 -> 608
    //   984: astore 14
    //   986: aload 4
    //   988: monitorexit
    //   989: aload 13
    //   991: astore 6
    //   993: aload_1
    //   994: astore 5
    //   996: aload_0
    //   997: astore_3
    //   998: aload 14
    //   1000: athrow
    //   1001: astore_3
    //   1002: aload 13
    //   1004: astore 4
    //   1006: aload_3
    //   1007: astore 13
    //   1009: sipush -1002
    //   1012: istore 8
    //   1014: aload 4
    //   1016: astore 6
    //   1018: aload_1
    //   1019: astore 5
    //   1021: aload_0
    //   1022: astore_3
    //   1023: aload 13
    //   1025: invokevirtual 295	java/lang/InterruptedException:printStackTrace	()V
    //   1028: aload 4
    //   1030: astore 6
    //   1032: aload_1
    //   1033: astore 5
    //   1035: aload_0
    //   1036: astore_3
    //   1037: new 160	java/lang/StringBuilder
    //   1040: dup
    //   1041: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1044: ldc_w 297
    //   1047: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: aload 13
    //   1052: invokevirtual 298	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   1055: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1061: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   1064: aload_0
    //   1065: ifnull +7 -> 1072
    //   1068: aload_0
    //   1069: invokevirtual 245	java/io/InputStream:close	()V
    //   1072: aload_1
    //   1073: ifnull +7 -> 1080
    //   1076: aload_1
    //   1077: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   1080: iload 8
    //   1082: istore 7
    //   1084: aload 4
    //   1086: ifnull -478 -> 608
    //   1089: aload 4
    //   1091: invokevirtual 251	java/io/BufferedReader:close	()V
    //   1094: iload 8
    //   1096: istore 7
    //   1098: goto -490 -> 608
    //   1101: astore_0
    //   1102: iload 8
    //   1104: istore 7
    //   1106: goto -498 -> 608
    //   1109: astore 14
    //   1111: aconst_null
    //   1112: astore_0
    //   1113: aconst_null
    //   1114: astore_1
    //   1115: aconst_null
    //   1116: astore 4
    //   1118: sipush -1003
    //   1121: istore 8
    //   1123: aload 4
    //   1125: astore 6
    //   1127: aload_1
    //   1128: astore 5
    //   1130: aload_0
    //   1131: astore_3
    //   1132: aload 14
    //   1134: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   1137: aload 4
    //   1139: astore 6
    //   1141: aload_1
    //   1142: astore 5
    //   1144: aload_0
    //   1145: astore_3
    //   1146: new 160	java/lang/StringBuilder
    //   1149: dup
    //   1150: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1153: ldc_w 301
    //   1156: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: aload 14
    //   1161: invokevirtual 302	java/lang/Exception:toString	()Ljava/lang/String;
    //   1164: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1170: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   1173: aload_0
    //   1174: ifnull +7 -> 1181
    //   1177: aload_0
    //   1178: invokevirtual 245	java/io/InputStream:close	()V
    //   1181: aload_1
    //   1182: ifnull +7 -> 1189
    //   1185: aload_1
    //   1186: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   1189: iload 8
    //   1191: istore 7
    //   1193: aload 4
    //   1195: ifnull -587 -> 608
    //   1198: aload 4
    //   1200: invokevirtual 251	java/io/BufferedReader:close	()V
    //   1203: iload 8
    //   1205: istore 7
    //   1207: goto -599 -> 608
    //   1210: astore_0
    //   1211: iload 8
    //   1213: istore 7
    //   1215: goto -607 -> 608
    //   1218: astore_0
    //   1219: aload 5
    //   1221: astore_2
    //   1222: aload_1
    //   1223: ifnull +7 -> 1230
    //   1226: aload_1
    //   1227: invokevirtual 245	java/io/InputStream:close	()V
    //   1230: aload_2
    //   1231: ifnull +7 -> 1238
    //   1234: aload_2
    //   1235: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   1238: aload_3
    //   1239: ifnull +7 -> 1246
    //   1242: aload_3
    //   1243: invokevirtual 251	java/io/BufferedReader:close	()V
    //   1246: aload_0
    //   1247: athrow
    //   1248: astore_0
    //   1249: goto -549 -> 700
    //   1252: astore_1
    //   1253: goto -7 -> 1246
    //   1256: astore_2
    //   1257: aload_0
    //   1258: astore_1
    //   1259: aload_2
    //   1260: astore_0
    //   1261: aload 5
    //   1263: astore_2
    //   1264: goto -42 -> 1222
    //   1267: astore_2
    //   1268: aload_0
    //   1269: astore 4
    //   1271: aload_2
    //   1272: astore_0
    //   1273: aload_1
    //   1274: astore_2
    //   1275: aload 4
    //   1277: astore_1
    //   1278: goto -56 -> 1222
    //   1281: astore_0
    //   1282: aload 5
    //   1284: astore_2
    //   1285: aload_3
    //   1286: astore_1
    //   1287: aload 6
    //   1289: astore_3
    //   1290: goto -68 -> 1222
    //   1293: astore 14
    //   1295: aconst_null
    //   1296: astore_1
    //   1297: aconst_null
    //   1298: astore 4
    //   1300: goto -182 -> 1118
    //   1303: astore 14
    //   1305: aconst_null
    //   1306: astore 4
    //   1308: goto -190 -> 1118
    //   1311: astore 14
    //   1313: aload 13
    //   1315: astore 4
    //   1317: goto -199 -> 1118
    //   1320: astore 13
    //   1322: aconst_null
    //   1323: astore_0
    //   1324: aconst_null
    //   1325: astore_1
    //   1326: aconst_null
    //   1327: astore 4
    //   1329: goto -320 -> 1009
    //   1332: astore 13
    //   1334: aconst_null
    //   1335: astore_1
    //   1336: aconst_null
    //   1337: astore 4
    //   1339: goto -330 -> 1009
    //   1342: astore 13
    //   1344: aconst_null
    //   1345: astore 4
    //   1347: goto -338 -> 1009
    //   1350: astore_0
    //   1351: iload 8
    //   1353: istore 7
    //   1355: goto -747 -> 608
    //   1358: astore 14
    //   1360: aconst_null
    //   1361: astore_1
    //   1362: aconst_null
    //   1363: astore 4
    //   1365: goto -845 -> 520
    //   1368: astore 14
    //   1370: aconst_null
    //   1371: astore 4
    //   1373: goto -853 -> 520
    //   1376: astore 14
    //   1378: aload 13
    //   1380: astore 4
    //   1382: goto -862 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1385	0	paramContext	Context
    //   0	1385	1	paramString1	String
    //   0	1385	2	paramString2	String
    //   0	1385	3	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1385	4	paramb	b
    //   0	1385	5	parama	angv.a
    //   0	1385	6	paramc	angv.c
    //   287	1067	7	i	int
    //   284	1068	8	j	int
    //   611	15	9	l1	long
    //   3	625	11	l2	long
    //   220	1094	13	localObject1	Object
    //   1320	1	13	localInterruptedException1	java.lang.InterruptedException
    //   1332	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1342	37	13	localInterruptedException3	java.lang.InterruptedException
    //   204	250	14	localObject2	Object
    //   511	355	14	localIOException1	java.io.IOException
    //   984	15	14	localObject3	Object
    //   1109	51	14	localException1	Exception
    //   1293	1	14	localException2	Exception
    //   1303	1	14	localException3	Exception
    //   1311	1	14	localException4	Exception
    //   1358	1	14	localIOException2	java.io.IOException
    //   1368	1	14	localIOException3	java.io.IOException
    //   1376	1	14	localIOException4	java.io.IOException
    //   143	700	15	str	String
    // Exception table:
    //   from	to	target	type
    //   469	477	501	java/io/IOException
    //   481	489	501	java/io/IOException
    //   493	501	501	java/io/IOException
    //   406	413	504	finally
    //   506	508	504	finally
    //   193	286	511	java/io/IOException
    //   296	309	511	java/io/IOException
    //   318	406	511	java/io/IOException
    //   418	428	511	java/io/IOException
    //   428	437	511	java/io/IOException
    //   442	449	511	java/io/IOException
    //   449	465	511	java/io/IOException
    //   508	511	511	java/io/IOException
    //   710	716	511	java/io/IOException
    //   943	947	976	java/io/IOException
    //   951	955	976	java/io/IOException
    //   964	969	976	java/io/IOException
    //   917	924	984	finally
    //   986	989	984	finally
    //   744	750	1001	java/lang/InterruptedException
    //   759	766	1001	java/lang/InterruptedException
    //   775	799	1001	java/lang/InterruptedException
    //   808	815	1001	java/lang/InterruptedException
    //   829	853	1001	java/lang/InterruptedException
    //   865	870	1001	java/lang/InterruptedException
    //   884	891	1001	java/lang/InterruptedException
    //   900	905	1001	java/lang/InterruptedException
    //   914	917	1001	java/lang/InterruptedException
    //   933	939	1001	java/lang/InterruptedException
    //   998	1001	1001	java/lang/InterruptedException
    //   1068	1072	1101	java/io/IOException
    //   1076	1080	1101	java/io/IOException
    //   1089	1094	1101	java/io/IOException
    //   193	286	1109	java/lang/Exception
    //   296	309	1109	java/lang/Exception
    //   318	406	1109	java/lang/Exception
    //   418	428	1109	java/lang/Exception
    //   428	437	1109	java/lang/Exception
    //   442	449	1109	java/lang/Exception
    //   449	465	1109	java/lang/Exception
    //   508	511	1109	java/lang/Exception
    //   710	716	1109	java/lang/Exception
    //   1177	1181	1210	java/io/IOException
    //   1185	1189	1210	java/io/IOException
    //   1198	1203	1210	java/io/IOException
    //   193	286	1218	finally
    //   296	309	1218	finally
    //   318	406	1218	finally
    //   418	428	1218	finally
    //   428	437	1218	finally
    //   442	449	1218	finally
    //   449	465	1218	finally
    //   508	511	1218	finally
    //   710	716	1218	finally
    //   655	700	1248	java/lang/Exception
    //   1226	1230	1252	java/io/IOException
    //   1234	1238	1252	java/io/IOException
    //   1242	1246	1252	java/io/IOException
    //   716	725	1256	finally
    //   725	735	1267	finally
    //   534	539	1281	finally
    //   548	574	1281	finally
    //   744	750	1281	finally
    //   759	766	1281	finally
    //   775	799	1281	finally
    //   808	815	1281	finally
    //   829	853	1281	finally
    //   865	870	1281	finally
    //   884	891	1281	finally
    //   900	905	1281	finally
    //   914	917	1281	finally
    //   933	939	1281	finally
    //   998	1001	1281	finally
    //   1023	1028	1281	finally
    //   1037	1064	1281	finally
    //   1132	1137	1281	finally
    //   1146	1173	1281	finally
    //   716	725	1293	java/lang/Exception
    //   725	735	1303	java/lang/Exception
    //   744	750	1311	java/lang/Exception
    //   759	766	1311	java/lang/Exception
    //   775	799	1311	java/lang/Exception
    //   808	815	1311	java/lang/Exception
    //   829	853	1311	java/lang/Exception
    //   865	870	1311	java/lang/Exception
    //   884	891	1311	java/lang/Exception
    //   900	905	1311	java/lang/Exception
    //   914	917	1311	java/lang/Exception
    //   933	939	1311	java/lang/Exception
    //   998	1001	1311	java/lang/Exception
    //   193	286	1320	java/lang/InterruptedException
    //   296	309	1320	java/lang/InterruptedException
    //   318	406	1320	java/lang/InterruptedException
    //   418	428	1320	java/lang/InterruptedException
    //   428	437	1320	java/lang/InterruptedException
    //   442	449	1320	java/lang/InterruptedException
    //   449	465	1320	java/lang/InterruptedException
    //   508	511	1320	java/lang/InterruptedException
    //   710	716	1320	java/lang/InterruptedException
    //   716	725	1332	java/lang/InterruptedException
    //   725	735	1342	java/lang/InterruptedException
    //   578	582	1350	java/io/IOException
    //   586	590	1350	java/io/IOException
    //   599	604	1350	java/io/IOException
    //   716	725	1358	java/io/IOException
    //   725	735	1368	java/io/IOException
    //   744	750	1376	java/io/IOException
    //   759	766	1376	java/io/IOException
    //   775	799	1376	java/io/IOException
    //   808	815	1376	java/io/IOException
    //   829	853	1376	java/io/IOException
    //   865	870	1376	java/io/IOException
    //   884	891	1376	java/io/IOException
    //   900	905	1376	java/io/IOException
    //   914	917	1376	java/io/IOException
    //   933	939	1376	java/io/IOException
    //   998	1001	1376	java/io/IOException
  }
  
  public static a a(String paramString)
  {
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.lvcc.name(), "640|640|384|768|30");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 1)) {}
    }
    int j;
    File localFile;
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localObject[1]).intValue();
        j = i;
        if (i <= 0) {
          j = 640;
        }
        localObject = new a();
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          ((a)localObject).cHR = false;
          GY("[@] getCompressConfig : [!file.exists]");
        }
        paramString = o(paramString);
        if ((paramString != null) && (paramString.length == 5) && (paramString[0] == 0)) {
          break;
        }
        ((a)localObject).cHR = false;
        GY("[@] getCompressConfig : values=" + paramString);
        if (paramString != null) {
          GY("[@] getCompressConfig : values.length=" + paramString.length + " err=" + paramString[0]);
        }
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoTrimmer", 2, "getCompressConfig -> get DpcConfig Erro", localNumberFormatException);
        }
      }
      i = 0;
    }
    localNumberFormatException.rotate = fm(paramString[3]);
    localNumberFormatException.srcWidth = paramString[1];
    localNumberFormatException.srcHeight = paramString[2];
    int i = (int)(paramString[4] / 1000.0D + 0.5D);
    if (i == 0)
    {
      localNumberFormatException.cHR = false;
      GY("[@] getCompressConfig : [sec == 0 OR video duration < 0.5 sec]");
      return localNumberFormatException;
    }
    localNumberFormatException.duration = i;
    localNumberFormatException.alX = (localFile.length() / (i * 128));
    i = Math.max(paramString[1], paramString[2]);
    if (i <= j + 60)
    {
      if (localNumberFormatException.alX > 1688L)
      {
        localNumberFormatException.cHR = true;
        localNumberFormatException.dJq = 25;
        localNumberFormatException.dJo = paramString[1];
        localNumberFormatException.dJp = paramString[2];
        return localNumberFormatException;
      }
      localNumberFormatException.cHR = false;
      GY("[@] getCompressConfig : [kbps > CODE_RATE] judge Failure...");
      return localNumberFormatException;
    }
    localNumberFormatException.cHR = true;
    float f1 = j / i;
    localNumberFormatException.dJo = ((int)(paramString[1] * f1));
    localNumberFormatException.dJp = ((int)(f1 * paramString[2]));
    localNumberFormatException.dJq = 25;
    return localNumberFormatException;
  }
  
  public static Process a()
  {
    synchronized (lock)
    {
      Process localProcess = f;
      return localProcess;
    }
  }
  
  /* Error */
  private static boolean a(java.io.InputStream paramInputStream, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 390	java/io/FileOutputStream
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 391	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: iconst_0
    //   14: istore_3
    //   15: aload 7
    //   17: astore_2
    //   18: aload_0
    //   19: aload_1
    //   20: iload_3
    //   21: aload_1
    //   22: arraylength
    //   23: iload_3
    //   24: isub
    //   25: invokevirtual 395	java/io/InputStream:read	([BII)I
    //   28: istore 4
    //   30: iload 4
    //   32: iconst_m1
    //   33: if_icmpeq +39 -> 72
    //   36: iload_3
    //   37: iload 4
    //   39: iadd
    //   40: istore 4
    //   42: iload 4
    //   44: istore_3
    //   45: aload 7
    //   47: astore_2
    //   48: iload 4
    //   50: aload_1
    //   51: arraylength
    //   52: if_icmpne -37 -> 15
    //   55: aload 7
    //   57: astore_2
    //   58: aload 7
    //   60: aload_1
    //   61: iconst_0
    //   62: iload 4
    //   64: invokevirtual 399	java/io/FileOutputStream:write	([BII)V
    //   67: iconst_0
    //   68: istore_3
    //   69: goto -54 -> 15
    //   72: iload_3
    //   73: ifeq +14 -> 87
    //   76: aload 7
    //   78: astore_2
    //   79: aload 7
    //   81: aload_1
    //   82: iconst_0
    //   83: iload_3
    //   84: invokevirtual 399	java/io/FileOutputStream:write	([BII)V
    //   87: iconst_1
    //   88: istore 6
    //   90: iload 6
    //   92: istore 5
    //   94: aload 7
    //   96: ifnull +12 -> 108
    //   99: aload 7
    //   101: invokevirtual 400	java/io/FileOutputStream:close	()V
    //   104: iload 6
    //   106: istore 5
    //   108: iload 5
    //   110: ireturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: astore_2
    //   116: aload_1
    //   117: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull -13 -> 108
    //   124: aload_0
    //   125: invokevirtual 400	java/io/FileOutputStream:close	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 400	java/io/FileOutputStream:close	()V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_1
    //   150: goto -6 -> 144
    //   153: astore_0
    //   154: goto -18 -> 136
    //   157: astore_1
    //   158: aload 7
    //   160: astore_0
    //   161: goto -47 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramInputStream	java.io.InputStream
    //   0	164	1	paramArrayOfByte	byte[]
    //   0	164	2	paramString	String
    //   14	70	3	i	int
    //   28	35	4	j	int
    //   1	108	5	bool1	boolean
    //   88	17	6	bool2	boolean
    //   11	148	7	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	13	111	java/io/IOException
    //   124	128	130	java/io/IOException
    //   3	13	133	finally
    //   99	104	146	java/io/IOException
    //   140	144	149	java/io/IOException
    //   18	30	153	finally
    //   48	55	153	finally
    //   58	67	153	finally
    //   79	87	153	finally
    //   116	120	153	finally
    //   18	30	157	java/io/IOException
    //   48	55	157	java/io/IOException
    //   58	67	157	java/io/IOException
    //   79	87	157	java/io/IOException
  }
  
  private static String[] a(String paramString1, String paramString2, a parama)
  {
    String str1 = "1";
    if (getCpuCores() >= 2) {
      str1 = "2";
    }
    String str2 = parama.dJo + "x" + String.valueOf(parama.dJp);
    GY("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + parama.rotate, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(parama.dJq), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  public static boolean b(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool2 = c(paramContext, paramInt1, paramInt2);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (VideoEnvironment.d("AVCodec", paramContext) != 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private static String[] b(String paramString1, String paramString2, a parama)
  {
    String str1 = "1";
    if (getCpuCores() >= 2) {
      str1 = "2";
    }
    String str2 = parama.dJo + "x" + String.valueOf(parama.dJp);
    GY("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    String str3 = parama.alZ / 1024L + "k";
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + parama.rotate, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-bufsize", "800k", "-minrate", str3, "-maxrate", str3, "-b", str3, "-r", String.valueOf(parama.alY), "-bufsize", "800k", "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  private static boolean bD(String paramString1, String paramString2)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      return true;
      paramString1 = MD5.getFileMd5(paramString1);
      paramString2 = MD5.getFileMd5(paramString2);
      paramString1 = HexUtil.bytes2HexStr(paramString1);
      paramString2 = HexUtil.bytes2HexStr(paramString2);
      GY("[@] trimBinMd5Judge : pieMd5=" + paramString1 + "  outMd5=" + paramString2);
    } while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2)));
    return false;
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  private static boolean c(Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: invokestatic 150	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 10
    //   15: new 158	java/io/File
    //   18: dup
    //   19: aload 10
    //   21: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 9
    //   26: aload 9
    //   28: invokevirtual 173	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 9
    //   36: invokevirtual 541	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: iload_1
    //   41: ifeq +7 -> 48
    //   44: iload_2
    //   45: ifne +127 -> 172
    //   48: iconst_0
    //   49: putstatic 51	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:cHQ	Z
    //   52: getstatic 546	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 16
    //   57: if_icmplt +87 -> 144
    //   60: new 160	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   67: aload 10
    //   69: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 548
    //   75: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 9
    //   83: iconst_0
    //   84: istore_3
    //   85: new 160	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   92: aload 10
    //   94: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 187
    //   99: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore 10
    //   107: new 158	java/io/File
    //   110: dup
    //   111: aload 10
    //   113: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 173	java/io/File:exists	()Z
    //   119: ifeq +81 -> 200
    //   122: getstatic 51	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:cHQ	Z
    //   125: ifne +75 -> 200
    //   128: aload 9
    //   130: aload 10
    //   132: invokestatic 550	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:bD	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: ifeq +65 -> 200
    //   138: iconst_1
    //   139: istore 4
    //   141: iload 4
    //   143: ireturn
    //   144: new 160	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   151: aload 10
    //   153: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 552
    //   159: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 9
    //   167: iconst_0
    //   168: istore_3
    //   169: goto -84 -> 85
    //   172: iconst_1
    //   173: putstatic 51	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:cHQ	Z
    //   176: getstatic 546	android/os/Build$VERSION:SDK_INT	I
    //   179: bipush 16
    //   181: if_icmplt +11 -> 192
    //   184: iload_1
    //   185: istore_3
    //   186: aconst_null
    //   187: astore 9
    //   189: goto -104 -> 85
    //   192: iload_2
    //   193: istore_3
    //   194: aconst_null
    //   195: astore 9
    //   197: goto -112 -> 85
    //   200: iload_1
    //   201: ifeq +7 -> 208
    //   204: iload_2
    //   205: ifne +140 -> 345
    //   208: new 554	java/io/FileInputStream
    //   211: dup
    //   212: aload 9
    //   214: invokespecial 555	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   217: astore_0
    //   218: ldc_w 557
    //   221: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   224: aload_0
    //   225: astore 8
    //   227: aload_0
    //   228: astore 7
    //   230: aload_0
    //   231: sipush 8192
    //   234: newarray byte
    //   236: aload 10
    //   238: invokestatic 559	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   241: istore 6
    //   243: aload_0
    //   244: astore 8
    //   246: aload_0
    //   247: astore 7
    //   249: new 160	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 561
    //   259: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload 6
    //   264: invokevirtual 564	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   267: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   273: iload 6
    //   275: istore 4
    //   277: iload 6
    //   279: ifeq +55 -> 334
    //   282: aload_0
    //   283: astore 8
    //   285: aload_0
    //   286: astore 7
    //   288: new 158	java/io/File
    //   291: dup
    //   292: aload 10
    //   294: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   297: iconst_1
    //   298: iconst_1
    //   299: invokevirtual 568	java/io/File:setExecutable	(ZZ)Z
    //   302: istore 4
    //   304: aload_0
    //   305: astore 8
    //   307: aload_0
    //   308: astore 7
    //   310: new 160	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 570
    //   320: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iload 4
    //   325: invokevirtual 564	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   328: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   334: aload_0
    //   335: ifnull +7 -> 342
    //   338: aload_0
    //   339: invokevirtual 245	java/io/InputStream:close	()V
    //   342: iload 4
    //   344: ireturn
    //   345: aload_0
    //   346: invokevirtual 576	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   349: iload_3
    //   350: invokevirtual 582	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   353: astore_0
    //   354: aload_0
    //   355: astore 8
    //   357: aload_0
    //   358: astore 7
    //   360: ldc_w 584
    //   363: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   366: goto -142 -> 224
    //   369: astore_0
    //   370: aload 8
    //   372: astore 7
    //   374: aload_0
    //   375: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   378: aload 8
    //   380: astore 7
    //   382: new 160	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 586
    //   392: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_0
    //   396: invokevirtual 302	java/lang/Exception:toString	()Ljava/lang/String;
    //   399: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   408: iload 5
    //   410: istore 4
    //   412: aload 8
    //   414: ifnull -273 -> 141
    //   417: aload 8
    //   419: invokevirtual 245	java/io/InputStream:close	()V
    //   422: iconst_0
    //   423: ireturn
    //   424: astore_0
    //   425: aload_0
    //   426: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   429: iconst_0
    //   430: ireturn
    //   431: astore_0
    //   432: aload_0
    //   433: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   436: goto -94 -> 342
    //   439: astore_0
    //   440: aload 7
    //   442: ifnull +8 -> 450
    //   445: aload 7
    //   447: invokevirtual 245	java/io/InputStream:close	()V
    //   450: aload_0
    //   451: athrow
    //   452: astore 7
    //   454: aload 7
    //   456: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   459: goto -9 -> 450
    //   462: astore 8
    //   464: aload_0
    //   465: astore 7
    //   467: aload 8
    //   469: astore_0
    //   470: goto -30 -> 440
    //   473: astore 7
    //   475: aload_0
    //   476: astore 8
    //   478: aload 7
    //   480: astore_0
    //   481: goto -111 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	paramContext	Context
    //   0	484	1	paramInt1	int
    //   0	484	2	paramInt2	int
    //   84	266	3	i	int
    //   139	272	4	bool1	boolean
    //   7	402	5	bool2	boolean
    //   241	37	6	bool3	boolean
    //   1	445	7	localObject1	Object
    //   452	3	7	localIOException	java.io.IOException
    //   465	1	7	localContext1	Context
    //   473	6	7	localException	Exception
    //   4	414	8	localContext2	Context
    //   462	6	8	localObject2	Object
    //   476	1	8	localContext3	Context
    //   24	189	9	localObject3	Object
    //   13	280	10	str	String
    // Exception table:
    //   from	to	target	type
    //   208	218	369	java/lang/Exception
    //   230	243	369	java/lang/Exception
    //   249	273	369	java/lang/Exception
    //   288	304	369	java/lang/Exception
    //   310	334	369	java/lang/Exception
    //   345	354	369	java/lang/Exception
    //   360	366	369	java/lang/Exception
    //   417	422	424	java/io/IOException
    //   338	342	431	java/io/IOException
    //   208	218	439	finally
    //   230	243	439	finally
    //   249	273	439	finally
    //   288	304	439	finally
    //   310	334	439	finally
    //   345	354	439	finally
    //   360	366	439	finally
    //   374	378	439	finally
    //   382	408	439	finally
    //   445	450	452	java/io/IOException
    //   218	224	462	finally
    //   218	224	473	java/lang/Exception
  }
  
  /* Error */
  public static int f(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_1
    //   6: invokestatic 590	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a;
    //   9: astore 9
    //   11: aload 9
    //   13: getfield 73	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a:cHR	Z
    //   16: ifne +10 -> 26
    //   19: ldc 137
    //   21: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_1
    //   27: aload_2
    //   28: aload 9
    //   30: invokestatic 592	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$a;)[Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +11 -> 46
    //   38: ldc 144
    //   40: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   43: bipush 254
    //   45: ireturn
    //   46: aload_0
    //   47: invokestatic 150	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   50: astore 11
    //   52: invokestatic 156	com/tencent/mobileqq/shortvideo/VideoEnvironment:zQ	()Ljava/lang/String;
    //   55: astore 12
    //   57: getstatic 51	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:cHQ	Z
    //   60: ifne +39 -> 99
    //   63: new 158	java/io/File
    //   66: dup
    //   67: new 160	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   74: aload 11
    //   76: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 12
    //   81: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokevirtual 173	java/io/File:exists	()Z
    //   93: ifne +6 -> 99
    //   96: bipush 253
    //   98: ireturn
    //   99: aconst_null
    //   100: astore 9
    //   102: aconst_null
    //   103: astore 10
    //   105: new 175	java/lang/ProcessBuilder
    //   108: dup
    //   109: iconst_0
    //   110: anewarray 80	java/lang/String
    //   113: invokespecial 178	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   116: astore 13
    //   118: aload 13
    //   120: iconst_1
    //   121: invokevirtual 182	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   124: pop
    //   125: new 184	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 185	java/util/ArrayList:<init>	()V
    //   132: astore_0
    //   133: aload_0
    //   134: new 160	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   141: aload 11
    //   143: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 187
    //   148: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokeinterface 193 2 0
    //   159: pop
    //   160: new 160	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   167: ldc 195
    //   169: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: iconst_0
    //   174: invokeinterface 199 2 0
    //   179: checkcast 80	java/lang/String
    //   182: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   191: aload_1
    //   192: arraylength
    //   193: istore 4
    //   195: iconst_0
    //   196: istore_3
    //   197: iload_3
    //   198: iload 4
    //   200: if_icmpge +20 -> 220
    //   203: aload_0
    //   204: aload_1
    //   205: iload_3
    //   206: aaload
    //   207: invokeinterface 193 2 0
    //   212: pop
    //   213: iload_3
    //   214: iconst_1
    //   215: iadd
    //   216: istore_3
    //   217: goto -20 -> 197
    //   220: aload_0
    //   221: new 160	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   228: aload 11
    //   230: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 12
    //   235: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokeinterface 193 2 0
    //   246: pop
    //   247: aload 13
    //   249: aload_0
    //   250: invokevirtual 203	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   253: pop
    //   254: new 160	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   261: ldc 205
    //   263: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: aload_0
    //   268: invokeinterface 209 1 0
    //   273: iconst_1
    //   274: isub
    //   275: invokeinterface 199 2 0
    //   280: checkcast 80	java/lang/String
    //   283: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   292: aload 13
    //   294: invokevirtual 213	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   297: astore 13
    //   299: getstatic 27	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   302: astore_0
    //   303: aload_0
    //   304: monitorenter
    //   305: aload 13
    //   307: putstatic 215	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   310: aload_0
    //   311: monitorexit
    //   312: getstatic 34	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:dN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   315: invokevirtual 220	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   318: ifne +258 -> 576
    //   321: aconst_null
    //   322: putstatic 215	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   325: aload 13
    //   327: invokevirtual 228	java/lang/Process:destroy	()V
    //   330: getstatic 34	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:dN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   333: iconst_1
    //   334: invokevirtual 231	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   337: iconst_0
    //   338: ifeq +11 -> 349
    //   341: new 233	java/lang/NullPointerException
    //   344: dup
    //   345: invokespecial 234	java/lang/NullPointerException:<init>	()V
    //   348: athrow
    //   349: iconst_0
    //   350: ifeq +11 -> 361
    //   353: new 233	java/lang/NullPointerException
    //   356: dup
    //   357: invokespecial 234	java/lang/NullPointerException:<init>	()V
    //   360: athrow
    //   361: iconst_0
    //   362: ifeq -338 -> 24
    //   365: new 233	java/lang/NullPointerException
    //   368: dup
    //   369: invokespecial 234	java/lang/NullPointerException:<init>	()V
    //   372: athrow
    //   373: astore_0
    //   374: iconst_m1
    //   375: ireturn
    //   376: astore_1
    //   377: aload_0
    //   378: monitorexit
    //   379: aload_1
    //   380: athrow
    //   381: astore 13
    //   383: aconst_null
    //   384: astore_0
    //   385: aconst_null
    //   386: astore_1
    //   387: aconst_null
    //   388: astore 12
    //   390: sipush -1001
    //   393: istore 4
    //   395: aload 12
    //   397: astore 11
    //   399: aload_1
    //   400: astore 10
    //   402: aload_0
    //   403: astore 9
    //   405: aload 13
    //   407: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   410: aload 12
    //   412: astore 11
    //   414: aload_1
    //   415: astore 10
    //   417: aload_0
    //   418: astore 9
    //   420: new 160	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   427: ldc 239
    //   429: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 13
    //   434: invokevirtual 240	java/io/IOException:toString	()Ljava/lang/String;
    //   437: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   446: aload_0
    //   447: ifnull +7 -> 454
    //   450: aload_0
    //   451: invokevirtual 245	java/io/InputStream:close	()V
    //   454: aload_1
    //   455: ifnull +7 -> 462
    //   458: aload_1
    //   459: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   462: iload 4
    //   464: istore_3
    //   465: aload 12
    //   467: ifnull +11 -> 478
    //   470: aload 12
    //   472: invokevirtual 251	java/io/BufferedReader:close	()V
    //   475: iload 4
    //   477: istore_3
    //   478: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   481: lstore 7
    //   483: new 160	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   490: ldc 253
    //   492: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: lload 7
    //   497: lload 5
    //   499: lsub
    //   500: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   503: ldc_w 258
    //   506: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: iload_3
    //   510: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   519: iload_3
    //   520: ifeq +47 -> 567
    //   523: new 158	java/io/File
    //   526: dup
    //   527: aload_2
    //   528: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   531: astore_0
    //   532: aload_0
    //   533: invokevirtual 173	java/io/File:exists	()Z
    //   536: ifeq +31 -> 567
    //   539: aload_0
    //   540: invokevirtual 264	java/io/File:delete	()Z
    //   543: pop
    //   544: new 160	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 266
    //   554: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: iload_3
    //   558: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   561: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   567: getstatic 34	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:dN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   570: iconst_1
    //   571: invokevirtual 231	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   574: iload_3
    //   575: ireturn
    //   576: aload 13
    //   578: invokevirtual 270	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   581: astore_0
    //   582: new 247	java/io/InputStreamReader
    //   585: dup
    //   586: aload_0
    //   587: invokespecial 273	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   590: astore_1
    //   591: new 250	java/io/BufferedReader
    //   594: dup
    //   595: aload_1
    //   596: invokespecial 276	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   599: astore 12
    //   601: aload 12
    //   603: astore 11
    //   605: aload_1
    //   606: astore 10
    //   608: aload_0
    //   609: astore 9
    //   611: aload 13
    //   613: invokevirtual 279	java/lang/Process:waitFor	()I
    //   616: pop
    //   617: aload 12
    //   619: astore 11
    //   621: aload_1
    //   622: astore 10
    //   624: aload_0
    //   625: astore 9
    //   627: aload 13
    //   629: invokevirtual 282	java/lang/Process:exitValue	()I
    //   632: istore 4
    //   634: aload 12
    //   636: astore 11
    //   638: aload_1
    //   639: astore 10
    //   641: aload_0
    //   642: astore 9
    //   644: new 160	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   651: ldc_w 284
    //   654: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: iload 4
    //   659: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   662: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   668: aload 12
    //   670: astore 11
    //   672: aload_1
    //   673: astore 10
    //   675: aload_0
    //   676: astore 9
    //   678: aload 12
    //   680: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   683: astore 14
    //   685: aload 14
    //   687: ifnull +40 -> 727
    //   690: aload 12
    //   692: astore 11
    //   694: aload_1
    //   695: astore 10
    //   697: aload_0
    //   698: astore 9
    //   700: new 160	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   707: ldc_w 289
    //   710: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload 14
    //   715: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   724: goto -56 -> 668
    //   727: aload 12
    //   729: astore 11
    //   731: aload_1
    //   732: astore 10
    //   734: aload_0
    //   735: astore 9
    //   737: aload 13
    //   739: invokevirtual 228	java/lang/Process:destroy	()V
    //   742: aload 12
    //   744: astore 11
    //   746: aload_1
    //   747: astore 10
    //   749: aload_0
    //   750: astore 9
    //   752: getstatic 27	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   755: astore 13
    //   757: aload 12
    //   759: astore 11
    //   761: aload_1
    //   762: astore 10
    //   764: aload_0
    //   765: astore 9
    //   767: aload 13
    //   769: monitorenter
    //   770: aconst_null
    //   771: putstatic 215	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:f	Ljava/lang/Process;
    //   774: aload 13
    //   776: monitorexit
    //   777: aload 12
    //   779: astore 11
    //   781: aload_1
    //   782: astore 10
    //   784: aload_0
    //   785: astore 9
    //   787: ldc_w 294
    //   790: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   793: aload_0
    //   794: ifnull +7 -> 801
    //   797: aload_0
    //   798: invokevirtual 245	java/io/InputStream:close	()V
    //   801: aload_1
    //   802: ifnull +7 -> 809
    //   805: aload_1
    //   806: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   809: iload 4
    //   811: istore_3
    //   812: aload 12
    //   814: ifnull -336 -> 478
    //   817: aload 12
    //   819: invokevirtual 251	java/io/BufferedReader:close	()V
    //   822: iload 4
    //   824: istore_3
    //   825: goto -347 -> 478
    //   828: astore_0
    //   829: iload 4
    //   831: istore_3
    //   832: goto -354 -> 478
    //   835: astore 14
    //   837: aload 13
    //   839: monitorexit
    //   840: aload 12
    //   842: astore 11
    //   844: aload_1
    //   845: astore 10
    //   847: aload_0
    //   848: astore 9
    //   850: aload 14
    //   852: athrow
    //   853: astore 13
    //   855: sipush -1002
    //   858: istore 4
    //   860: aload 12
    //   862: astore 11
    //   864: aload_1
    //   865: astore 10
    //   867: aload_0
    //   868: astore 9
    //   870: aload 13
    //   872: invokevirtual 295	java/lang/InterruptedException:printStackTrace	()V
    //   875: aload 12
    //   877: astore 11
    //   879: aload_1
    //   880: astore 10
    //   882: aload_0
    //   883: astore 9
    //   885: new 160	java/lang/StringBuilder
    //   888: dup
    //   889: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   892: ldc_w 297
    //   895: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: aload 13
    //   900: invokevirtual 298	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   903: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   912: aload_0
    //   913: ifnull +7 -> 920
    //   916: aload_0
    //   917: invokevirtual 245	java/io/InputStream:close	()V
    //   920: aload_1
    //   921: ifnull +7 -> 928
    //   924: aload_1
    //   925: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   928: iload 4
    //   930: istore_3
    //   931: aload 12
    //   933: ifnull -455 -> 478
    //   936: aload 12
    //   938: invokevirtual 251	java/io/BufferedReader:close	()V
    //   941: iload 4
    //   943: istore_3
    //   944: goto -466 -> 478
    //   947: astore_0
    //   948: iload 4
    //   950: istore_3
    //   951: goto -473 -> 478
    //   954: astore 13
    //   956: aconst_null
    //   957: astore_0
    //   958: aconst_null
    //   959: astore_1
    //   960: aconst_null
    //   961: astore 12
    //   963: sipush -1003
    //   966: istore 4
    //   968: aload 12
    //   970: astore 11
    //   972: aload_1
    //   973: astore 10
    //   975: aload_0
    //   976: astore 9
    //   978: aload 13
    //   980: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   983: aload 12
    //   985: astore 11
    //   987: aload_1
    //   988: astore 10
    //   990: aload_0
    //   991: astore 9
    //   993: new 160	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1000: ldc_w 301
    //   1003: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: aload 13
    //   1008: invokevirtual 302	java/lang/Exception:toString	()Ljava/lang/String;
    //   1011: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   1020: aload_0
    //   1021: ifnull +7 -> 1028
    //   1024: aload_0
    //   1025: invokevirtual 245	java/io/InputStream:close	()V
    //   1028: aload_1
    //   1029: ifnull +7 -> 1036
    //   1032: aload_1
    //   1033: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   1036: iload 4
    //   1038: istore_3
    //   1039: aload 12
    //   1041: ifnull -563 -> 478
    //   1044: aload 12
    //   1046: invokevirtual 251	java/io/BufferedReader:close	()V
    //   1049: iload 4
    //   1051: istore_3
    //   1052: goto -574 -> 478
    //   1055: astore_0
    //   1056: iload 4
    //   1058: istore_3
    //   1059: goto -581 -> 478
    //   1062: astore_1
    //   1063: aconst_null
    //   1064: astore_0
    //   1065: aload 9
    //   1067: astore_2
    //   1068: aload_0
    //   1069: ifnull +7 -> 1076
    //   1072: aload_0
    //   1073: invokevirtual 245	java/io/InputStream:close	()V
    //   1076: aload_2
    //   1077: ifnull +7 -> 1084
    //   1080: aload_2
    //   1081: invokevirtual 248	java/io/InputStreamReader:close	()V
    //   1084: aload 10
    //   1086: ifnull +8 -> 1094
    //   1089: aload 10
    //   1091: invokevirtual 251	java/io/BufferedReader:close	()V
    //   1094: aload_1
    //   1095: athrow
    //   1096: astore_0
    //   1097: goto -530 -> 567
    //   1100: astore_0
    //   1101: goto -7 -> 1094
    //   1104: astore_1
    //   1105: aload 9
    //   1107: astore_2
    //   1108: goto -40 -> 1068
    //   1111: astore 9
    //   1113: aload_1
    //   1114: astore_2
    //   1115: aload 9
    //   1117: astore_1
    //   1118: goto -50 -> 1068
    //   1121: astore_1
    //   1122: aload 10
    //   1124: astore_2
    //   1125: aload 11
    //   1127: astore 10
    //   1129: aload 9
    //   1131: astore_0
    //   1132: goto -64 -> 1068
    //   1135: astore 13
    //   1137: aconst_null
    //   1138: astore_1
    //   1139: aconst_null
    //   1140: astore 12
    //   1142: goto -179 -> 963
    //   1145: astore 13
    //   1147: aconst_null
    //   1148: astore 12
    //   1150: goto -187 -> 963
    //   1153: astore 13
    //   1155: goto -192 -> 963
    //   1158: astore 13
    //   1160: aconst_null
    //   1161: astore_0
    //   1162: aconst_null
    //   1163: astore_1
    //   1164: aconst_null
    //   1165: astore 12
    //   1167: goto -312 -> 855
    //   1170: astore 13
    //   1172: aconst_null
    //   1173: astore_1
    //   1174: aconst_null
    //   1175: astore 12
    //   1177: goto -322 -> 855
    //   1180: astore 13
    //   1182: aconst_null
    //   1183: astore 12
    //   1185: goto -330 -> 855
    //   1188: astore_0
    //   1189: iload 4
    //   1191: istore_3
    //   1192: goto -714 -> 478
    //   1195: astore 13
    //   1197: aconst_null
    //   1198: astore_1
    //   1199: aconst_null
    //   1200: astore 12
    //   1202: goto -812 -> 390
    //   1205: astore 13
    //   1207: aconst_null
    //   1208: astore 12
    //   1210: goto -820 -> 390
    //   1213: astore 13
    //   1215: goto -825 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1218	0	paramContext	Context
    //   0	1218	1	paramString1	String
    //   0	1218	2	paramString2	String
    //   196	996	3	i	int
    //   193	997	4	j	int
    //   3	495	5	l1	long
    //   481	15	7	l2	long
    //   9	1097	9	localObject1	Object
    //   1111	19	9	localObject2	Object
    //   103	1025	10	localObject3	Object
    //   50	1076	11	localObject4	Object
    //   55	1154	12	localObject5	Object
    //   116	210	13	localObject6	Object
    //   381	357	13	localIOException1	java.io.IOException
    //   755	83	13	localObject7	Object
    //   853	46	13	localInterruptedException1	java.lang.InterruptedException
    //   954	53	13	localException1	Exception
    //   1135	1	13	localException2	Exception
    //   1145	1	13	localException3	Exception
    //   1153	1	13	localException4	Exception
    //   1158	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1170	1	13	localInterruptedException3	java.lang.InterruptedException
    //   1180	1	13	localInterruptedException4	java.lang.InterruptedException
    //   1195	1	13	localIOException2	java.io.IOException
    //   1205	1	13	localIOException3	java.io.IOException
    //   1213	1	13	localIOException4	java.io.IOException
    //   683	31	14	str	String
    //   835	16	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   341	349	373	java/io/IOException
    //   353	361	373	java/io/IOException
    //   365	373	373	java/io/IOException
    //   305	312	376	finally
    //   377	379	376	finally
    //   105	195	381	java/io/IOException
    //   203	213	381	java/io/IOException
    //   220	305	381	java/io/IOException
    //   312	337	381	java/io/IOException
    //   379	381	381	java/io/IOException
    //   576	582	381	java/io/IOException
    //   797	801	828	java/io/IOException
    //   805	809	828	java/io/IOException
    //   817	822	828	java/io/IOException
    //   770	777	835	finally
    //   837	840	835	finally
    //   611	617	853	java/lang/InterruptedException
    //   627	634	853	java/lang/InterruptedException
    //   644	668	853	java/lang/InterruptedException
    //   678	685	853	java/lang/InterruptedException
    //   700	724	853	java/lang/InterruptedException
    //   737	742	853	java/lang/InterruptedException
    //   752	757	853	java/lang/InterruptedException
    //   767	770	853	java/lang/InterruptedException
    //   787	793	853	java/lang/InterruptedException
    //   850	853	853	java/lang/InterruptedException
    //   916	920	947	java/io/IOException
    //   924	928	947	java/io/IOException
    //   936	941	947	java/io/IOException
    //   105	195	954	java/lang/Exception
    //   203	213	954	java/lang/Exception
    //   220	305	954	java/lang/Exception
    //   312	337	954	java/lang/Exception
    //   379	381	954	java/lang/Exception
    //   576	582	954	java/lang/Exception
    //   1024	1028	1055	java/io/IOException
    //   1032	1036	1055	java/io/IOException
    //   1044	1049	1055	java/io/IOException
    //   105	195	1062	finally
    //   203	213	1062	finally
    //   220	305	1062	finally
    //   312	337	1062	finally
    //   379	381	1062	finally
    //   576	582	1062	finally
    //   523	567	1096	java/lang/Exception
    //   1072	1076	1100	java/io/IOException
    //   1080	1084	1100	java/io/IOException
    //   1089	1094	1100	java/io/IOException
    //   582	591	1104	finally
    //   591	601	1111	finally
    //   405	410	1121	finally
    //   420	446	1121	finally
    //   611	617	1121	finally
    //   627	634	1121	finally
    //   644	668	1121	finally
    //   678	685	1121	finally
    //   700	724	1121	finally
    //   737	742	1121	finally
    //   752	757	1121	finally
    //   767	770	1121	finally
    //   787	793	1121	finally
    //   850	853	1121	finally
    //   870	875	1121	finally
    //   885	912	1121	finally
    //   978	983	1121	finally
    //   993	1020	1121	finally
    //   582	591	1135	java/lang/Exception
    //   591	601	1145	java/lang/Exception
    //   611	617	1153	java/lang/Exception
    //   627	634	1153	java/lang/Exception
    //   644	668	1153	java/lang/Exception
    //   678	685	1153	java/lang/Exception
    //   700	724	1153	java/lang/Exception
    //   737	742	1153	java/lang/Exception
    //   752	757	1153	java/lang/Exception
    //   767	770	1153	java/lang/Exception
    //   787	793	1153	java/lang/Exception
    //   850	853	1153	java/lang/Exception
    //   105	195	1158	java/lang/InterruptedException
    //   203	213	1158	java/lang/InterruptedException
    //   220	305	1158	java/lang/InterruptedException
    //   312	337	1158	java/lang/InterruptedException
    //   379	381	1158	java/lang/InterruptedException
    //   576	582	1158	java/lang/InterruptedException
    //   582	591	1170	java/lang/InterruptedException
    //   591	601	1180	java/lang/InterruptedException
    //   450	454	1188	java/io/IOException
    //   458	462	1188	java/io/IOException
    //   470	475	1188	java/io/IOException
    //   582	591	1195	java/io/IOException
    //   591	601	1205	java/io/IOException
    //   611	617	1213	java/io/IOException
    //   627	634	1213	java/io/IOException
    //   644	668	1213	java/io/IOException
    //   678	685	1213	java/io/IOException
    //   700	724	1213	java/io/IOException
    //   737	742	1213	java/io/IOException
    //   752	757	1213	java/io/IOException
    //   767	770	1213	java/io/IOException
    //   787	793	1213	java/io/IOException
    //   850	853	1213	java/io/IOException
  }
  
  public static String fm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0";
    case 0: 
      return "0";
    case 1: 
      return "90";
    case 2: 
      return "180";
    }
    return "270";
  }
  
  public static int getCpuCores()
  {
    if (agR == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new ankx());
      if (arrayOfFile == null) {
        return 1;
      }
      agR = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        agR = 1;
      }
    }
    return agR;
  }
  
  public static native String getRealProperties(String paramString);
  
  /* Error */
  @android.annotation.TargetApi(17)
  public static int[] o(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 546	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 17
    //   7: if_icmplt +130 -> 137
    //   10: new 616	android/media/MediaMetadataRetriever
    //   13: dup
    //   14: invokespecial 617	android/media/MediaMetadataRetriever:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokevirtual 620	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: bipush 18
    //   26: invokevirtual 623	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_3
    //   31: bipush 19
    //   33: invokevirtual 623	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_3
    //   39: bipush 24
    //   41: invokevirtual 623	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   44: astore 5
    //   46: aload_3
    //   47: bipush 9
    //   49: invokevirtual 623	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: astore 6
    //   54: iconst_5
    //   55: newarray int
    //   57: astore_0
    //   58: aload_0
    //   59: iconst_0
    //   60: iconst_0
    //   61: iastore
    //   62: aload_0
    //   63: iconst_1
    //   64: aload_2
    //   65: invokestatic 339	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   68: invokevirtual 342	java/lang/Integer:intValue	()I
    //   71: iastore
    //   72: aload_0
    //   73: iconst_2
    //   74: aload 4
    //   76: invokestatic 339	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   79: invokevirtual 342	java/lang/Integer:intValue	()I
    //   82: iastore
    //   83: aload_0
    //   84: iconst_3
    //   85: aload 5
    //   87: invokestatic 339	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   90: invokevirtual 342	java/lang/Integer:intValue	()I
    //   93: iastore
    //   94: aload_0
    //   95: iconst_4
    //   96: aload 6
    //   98: invokestatic 339	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   101: invokevirtual 342	java/lang/Integer:intValue	()I
    //   104: iastore
    //   105: aload_3
    //   106: invokevirtual 626	android/media/MediaMetadataRetriever:release	()V
    //   109: aload_0
    //   110: areturn
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc 45
    //   116: iconst_1
    //   117: ldc_w 628
    //   120: aload_2
    //   121: invokestatic 363	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_3
    //   125: invokevirtual 626	android/media/MediaMetadataRetriever:release	()V
    //   128: aload_0
    //   129: areturn
    //   130: astore_0
    //   131: aload_3
    //   132: invokevirtual 626	android/media/MediaMetadataRetriever:release	()V
    //   135: aload_0
    //   136: athrow
    //   137: aload_0
    //   138: invokestatic 630	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_0
    //   142: aload_0
    //   143: ifnull +79 -> 222
    //   146: aload_0
    //   147: ldc_w 632
    //   150: invokevirtual 334	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: astore_3
    //   154: aload_3
    //   155: ifnull +67 -> 222
    //   158: aload_3
    //   159: arraylength
    //   160: ifle +62 -> 222
    //   163: aload_3
    //   164: arraylength
    //   165: newarray int
    //   167: astore_2
    //   168: aload_2
    //   169: astore_0
    //   170: iload_1
    //   171: aload_3
    //   172: arraylength
    //   173: if_icmpge -64 -> 109
    //   176: aload_2
    //   177: iload_1
    //   178: aload_3
    //   179: iload_1
    //   180: aaload
    //   181: invokestatic 339	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   184: invokevirtual 342	java/lang/Integer:intValue	()I
    //   187: iastore
    //   188: iload_1
    //   189: iconst_1
    //   190: iadd
    //   191: istore_1
    //   192: goto -24 -> 168
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 633	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   200: ldc_w 635
    //   203: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   206: aconst_null
    //   207: astore_0
    //   208: goto -66 -> 142
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   216: ldc_w 637
    //   219: invokestatic 139	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:GY	(Ljava/lang/String;)V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_2
    //   225: goto -111 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramString	String
    //   1	191	1	i	int
    //   29	36	2	str1	String
    //   111	10	2	localException1	Exception
    //   167	10	2	arrayOfInt	int[]
    //   224	1	2	localException2	Exception
    //   17	162	3	localObject	Object
    //   36	39	4	str2	String
    //   44	42	5	str3	String
    //   52	45	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   18	58	111	java/lang/Exception
    //   18	58	130	finally
    //   62	105	130	finally
    //   114	124	130	finally
    //   137	142	195	java/lang/UnsatisfiedLinkError
    //   170	188	211	java/lang/Exception
    //   62	105	224	java/lang/Exception
  }
  
  public static class a
  {
    public long alW;
    public long alX;
    public long alY;
    public long alZ;
    public boolean cHR;
    public int dJo;
    public int dJp;
    public int dJq;
    public long duration;
    public String rotate;
    public int srcHeight;
    public int srcWidth;
  }
  
  public static abstract interface b
  {
    public abstract void b(Process paramProcess);
    
    public abstract void onDestroy();
    
    public abstract void onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */