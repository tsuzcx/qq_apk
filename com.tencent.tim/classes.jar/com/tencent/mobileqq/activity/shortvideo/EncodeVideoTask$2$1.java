package com.tencent.mobileqq.activity.shortvideo;

import aazc;
import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class EncodeVideoTask$2$1
  implements Runnable
{
  public EncodeVideoTask$2$1(aazc paramaazc, String paramString, PublishVideoEntry paramPublishVideoEntry) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_1
    //   7: bipush 249
    //   9: istore_2
    //   10: aload_0
    //   11: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$videoPath	Ljava/lang/String;
    //   14: iconst_0
    //   15: iconst_1
    //   16: invokestatic 37	auqv:r	(Ljava/lang/String;ZZ)V
    //   19: aload_0
    //   20: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   23: getfield 42	aazc:a	Laaza;
    //   26: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   29: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +21 -> 53
    //   35: aload_0
    //   36: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   39: getfield 42	aazc:a	Laaza;
    //   42: aload_0
    //   43: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:b	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   46: getfield 58	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   49: invokestatic 61	aaza:a	(Laaza;Ljava/lang/String;)Ljava/lang/String;
    //   52: pop
    //   53: aload_0
    //   54: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   57: getfield 42	aazc:a	Laaza;
    //   60: invokestatic 64	aaza:a	(Laaza;)Laaza$d;
    //   63: ifnull +327 -> 390
    //   66: aload_0
    //   67: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   70: getfield 42	aazc:a	Laaza;
    //   73: aload_0
    //   74: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   77: getfield 42	aazc:a	Laaza;
    //   80: invokestatic 64	aaza:a	(Laaza;)Laaza$d;
    //   83: getfield 69	aaza$d:beI	Ljava/lang/String;
    //   86: invokestatic 71	aaza:b	(Laaza;Ljava/lang/String;)Ljava/lang/String;
    //   89: pop
    //   90: aload_0
    //   91: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   94: getfield 42	aazc:a	Laaza;
    //   97: astore 7
    //   99: aload_0
    //   100: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   103: getfield 42	aazc:a	Laaza;
    //   106: invokestatic 64	aaza:a	(Laaza;)Laaza$d;
    //   109: getfield 75	aaza$d:cG	[B
    //   112: ifnonnull +260 -> 372
    //   115: aload_0
    //   116: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   119: getfield 42	aazc:a	Laaza;
    //   122: invokestatic 77	aaza:b	(Laaza;)Ljava/lang/String;
    //   125: invokestatic 83	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   128: astore 6
    //   130: aload 7
    //   132: aload 6
    //   134: invokestatic 86	aaza:a	(Laaza;[B)[B
    //   137: pop
    //   138: aload_0
    //   139: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   142: getfield 42	aazc:a	Laaza;
    //   145: aload_0
    //   146: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   149: getfield 42	aazc:a	Laaza;
    //   152: invokestatic 64	aaza:a	(Laaza;)Laaza$d;
    //   155: getfield 90	aaza$d:width	I
    //   158: invokestatic 93	aaza:a	(Laaza;I)I
    //   161: pop
    //   162: aload_0
    //   163: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   166: getfield 42	aazc:a	Laaza;
    //   169: aload_0
    //   170: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   173: getfield 42	aazc:a	Laaza;
    //   176: invokestatic 64	aaza:a	(Laaza;)Laaza$d;
    //   179: getfield 96	aaza$d:cmM	I
    //   182: invokestatic 98	aaza:b	(Laaza;I)I
    //   185: pop
    //   186: aload_0
    //   187: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   190: getfield 42	aazc:a	Laaza;
    //   193: aload_0
    //   194: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$videoPath	Ljava/lang/String;
    //   197: invokestatic 101	aaza:c	(Laaza;Ljava/lang/String;)Ljava/lang/String;
    //   200: pop
    //   201: aload_0
    //   202: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   205: getfield 42	aazc:a	Laaza;
    //   208: invokestatic 103	aaza:c	(Laaza;)Ljava/lang/String;
    //   211: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   214: ifne +981 -> 1195
    //   217: new 105	java/io/File
    //   220: dup
    //   221: aload_0
    //   222: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   225: getfield 42	aazc:a	Laaza;
    //   228: invokestatic 103	aaza:c	(Laaza;)Ljava/lang/String;
    //   231: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   234: astore 6
    //   236: iload_1
    //   237: istore_2
    //   238: aload 6
    //   240: invokevirtual 112	java/io/File:exists	()Z
    //   243: ifeq +85 -> 328
    //   246: new 114	java/io/FileInputStream
    //   249: dup
    //   250: aload_0
    //   251: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   254: getfield 42	aazc:a	Laaza;
    //   257: invokestatic 103	aaza:c	(Laaza;)Ljava/lang/String;
    //   260: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   263: astore 7
    //   265: aload 6
    //   267: invokevirtual 119	java/io/File:length	()J
    //   270: lstore 4
    //   272: aload_0
    //   273: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   276: getfield 42	aazc:a	Laaza;
    //   279: aload 7
    //   281: lload 4
    //   283: invokestatic 125	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   286: invokestatic 127	aaza:b	(Laaza;[B)[B
    //   289: pop
    //   290: aload_0
    //   291: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   294: getfield 42	aazc:a	Laaza;
    //   297: aload_0
    //   298: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   301: getfield 42	aazc:a	Laaza;
    //   304: invokestatic 130	aaza:b	(Laaza;)[B
    //   307: invokestatic 134	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   310: invokestatic 137	aaza:d	(Laaza;Ljava/lang/String;)Ljava/lang/String;
    //   313: pop
    //   314: iload_1
    //   315: istore_2
    //   316: aload 7
    //   318: ifnull +10 -> 328
    //   321: aload 7
    //   323: invokevirtual 140	java/io/FileInputStream:close	()V
    //   326: iload_1
    //   327: istore_2
    //   328: iload_2
    //   329: ifeq +872 -> 1201
    //   332: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq +28 -> 363
    //   338: ldc 147
    //   340: iconst_2
    //   341: new 149	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   348: ldc 152
    //   350: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload_2
    //   354: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   367: iload_2
    //   368: invokevirtual 171	aazc:onError	(I)V
    //   371: return
    //   372: aload_0
    //   373: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   376: getfield 42	aazc:a	Laaza;
    //   379: invokestatic 64	aaza:a	(Laaza;)Laaza$d;
    //   382: getfield 75	aaza$d:cG	[B
    //   385: astore 6
    //   387: goto -257 -> 130
    //   390: aload_0
    //   391: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   394: getfield 42	aazc:a	Laaza;
    //   397: aload_0
    //   398: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:b	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   401: getfield 174	com/tencent/biz/qqstory/database/PublishVideoEntry:videoWidth	I
    //   404: invokestatic 93	aaza:a	(Laaza;I)I
    //   407: pop
    //   408: aload_0
    //   409: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   412: getfield 42	aazc:a	Laaza;
    //   415: aload_0
    //   416: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:b	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   419: getfield 177	com/tencent/biz/qqstory/database/PublishVideoEntry:videoHeight	I
    //   422: invokestatic 98	aaza:b	(Laaza;I)I
    //   425: pop
    //   426: new 105	java/io/File
    //   429: dup
    //   430: aload_0
    //   431: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   434: getfield 42	aazc:a	Laaza;
    //   437: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   440: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   443: astore 8
    //   445: aload 8
    //   447: invokevirtual 112	java/io/File:exists	()Z
    //   450: ifeq +616 -> 1066
    //   453: new 114	java/io/FileInputStream
    //   456: dup
    //   457: aload_0
    //   458: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   461: getfield 42	aazc:a	Laaza;
    //   464: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   467: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   470: astore 7
    //   472: aload 7
    //   474: astore 6
    //   476: aload 8
    //   478: invokevirtual 119	java/io/File:length	()J
    //   481: lstore 4
    //   483: aload 7
    //   485: astore 6
    //   487: aload_0
    //   488: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   491: getfield 42	aazc:a	Laaza;
    //   494: aload 7
    //   496: lload 4
    //   498: invokestatic 125	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   501: invokestatic 86	aaza:a	(Laaza;[B)[B
    //   504: pop
    //   505: aload 7
    //   507: astore 6
    //   509: aload_0
    //   510: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   513: getfield 42	aazc:a	Laaza;
    //   516: aload_0
    //   517: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   520: getfield 42	aazc:a	Laaza;
    //   523: invokestatic 179	aaza:a	(Laaza;)[B
    //   526: invokestatic 134	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   529: invokestatic 71	aaza:b	(Laaza;Ljava/lang/String;)Ljava/lang/String;
    //   532: pop
    //   533: aload 7
    //   535: ifnull +8 -> 543
    //   538: aload 7
    //   540: invokevirtual 140	java/io/FileInputStream:close	()V
    //   543: aload_0
    //   544: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   547: getfield 42	aazc:a	Laaza;
    //   550: invokestatic 77	aaza:b	(Laaza;)Ljava/lang/String;
    //   553: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   556: ifeq +33 -> 589
    //   559: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   562: ifeq +11 -> 573
    //   565: ldc 147
    //   567: iconst_2
    //   568: ldc 181
    //   570: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: bipush 250
    //   575: istore_1
    //   576: goto -390 -> 186
    //   579: astore 6
    //   581: aload 6
    //   583: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   586: goto -43 -> 543
    //   589: aload_0
    //   590: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   593: getfield 42	aazc:a	Laaza;
    //   596: invokestatic 77	aaza:b	(Laaza;)Ljava/lang/String;
    //   599: ldc 189
    //   601: invokestatic 195	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: astore 6
    //   606: aload_0
    //   607: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   610: getfield 42	aazc:a	Laaza;
    //   613: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   616: aload 6
    //   618: invokestatic 201	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   621: ifeq +21 -> 642
    //   624: aload_0
    //   625: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   628: getfield 42	aazc:a	Laaza;
    //   631: aload 6
    //   633: invokestatic 61	aaza:a	(Laaza;Ljava/lang/String;)Ljava/lang/String;
    //   636: pop
    //   637: iconst_0
    //   638: istore_1
    //   639: goto -63 -> 576
    //   642: aload 6
    //   644: invokestatic 205	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   647: ifne +954 -> 1601
    //   650: iload_2
    //   651: istore_1
    //   652: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   655: ifeq -79 -> 576
    //   658: ldc 147
    //   660: iconst_2
    //   661: new 149	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   668: ldc 207
    //   670: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_0
    //   674: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   677: getfield 42	aazc:a	Laaza;
    //   680: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   683: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: ldc 209
    //   688: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload 6
    //   693: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: iload_2
    //   703: istore_1
    //   704: goto -128 -> 576
    //   707: astore 8
    //   709: aconst_null
    //   710: astore 7
    //   712: aload 7
    //   714: astore 6
    //   716: aload 8
    //   718: invokevirtual 210	java/io/FileNotFoundException:printStackTrace	()V
    //   721: aload 7
    //   723: ifnull +8 -> 731
    //   726: aload 7
    //   728: invokevirtual 140	java/io/FileInputStream:close	()V
    //   731: aload_0
    //   732: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   735: getfield 42	aazc:a	Laaza;
    //   738: invokestatic 77	aaza:b	(Laaza;)Ljava/lang/String;
    //   741: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   744: ifeq +33 -> 777
    //   747: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   750: ifeq +11 -> 761
    //   753: ldc 147
    //   755: iconst_2
    //   756: ldc 181
    //   758: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   761: bipush 250
    //   763: istore_1
    //   764: goto -188 -> 576
    //   767: astore 6
    //   769: aload 6
    //   771: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   774: goto -43 -> 731
    //   777: aload_0
    //   778: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   781: getfield 42	aazc:a	Laaza;
    //   784: invokestatic 77	aaza:b	(Laaza;)Ljava/lang/String;
    //   787: ldc 189
    //   789: invokestatic 195	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   792: astore 6
    //   794: aload_0
    //   795: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   798: getfield 42	aazc:a	Laaza;
    //   801: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   804: aload 6
    //   806: invokestatic 201	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   809: ifeq +21 -> 830
    //   812: aload_0
    //   813: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   816: getfield 42	aazc:a	Laaza;
    //   819: aload 6
    //   821: invokestatic 61	aaza:a	(Laaza;Ljava/lang/String;)Ljava/lang/String;
    //   824: pop
    //   825: iload_3
    //   826: istore_1
    //   827: goto -251 -> 576
    //   830: iload_3
    //   831: istore_1
    //   832: aload 6
    //   834: invokestatic 205	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   837: ifne -10 -> 827
    //   840: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +47 -> 890
    //   846: ldc 147
    //   848: iconst_2
    //   849: new 149	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   856: ldc 207
    //   858: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload_0
    //   862: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   865: getfield 42	aazc:a	Laaza;
    //   868: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   871: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: ldc 209
    //   876: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 6
    //   881: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   890: bipush 249
    //   892: istore_1
    //   893: goto -66 -> 827
    //   896: astore 7
    //   898: aconst_null
    //   899: astore 6
    //   901: aload 6
    //   903: ifnull +8 -> 911
    //   906: aload 6
    //   908: invokevirtual 140	java/io/FileInputStream:close	()V
    //   911: aload_0
    //   912: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   915: getfield 42	aazc:a	Laaza;
    //   918: invokestatic 77	aaza:b	(Laaza;)Ljava/lang/String;
    //   921: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   924: ifeq +30 -> 954
    //   927: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +11 -> 941
    //   933: ldc 147
    //   935: iconst_2
    //   936: ldc 181
    //   938: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   941: aload 7
    //   943: athrow
    //   944: astore 6
    //   946: aload 6
    //   948: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   951: goto -40 -> 911
    //   954: aload_0
    //   955: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   958: getfield 42	aazc:a	Laaza;
    //   961: invokestatic 77	aaza:b	(Laaza;)Ljava/lang/String;
    //   964: ldc 189
    //   966: invokestatic 195	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   969: astore 6
    //   971: aload_0
    //   972: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   975: getfield 42	aazc:a	Laaza;
    //   978: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   981: aload 6
    //   983: invokestatic 201	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   986: ifeq +19 -> 1005
    //   989: aload_0
    //   990: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   993: getfield 42	aazc:a	Laaza;
    //   996: aload 6
    //   998: invokestatic 61	aaza:a	(Laaza;Ljava/lang/String;)Ljava/lang/String;
    //   1001: pop
    //   1002: goto -61 -> 941
    //   1005: aload 6
    //   1007: invokestatic 205	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   1010: ifne -69 -> 941
    //   1013: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1016: ifeq -75 -> 941
    //   1019: ldc 147
    //   1021: iconst_2
    //   1022: new 149	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1029: ldc 207
    //   1031: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: aload_0
    //   1035: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1038: getfield 42	aazc:a	Laaza;
    //   1041: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   1044: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc 209
    //   1049: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload 6
    //   1054: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1063: goto -122 -> 941
    //   1066: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1069: ifeq +37 -> 1106
    //   1072: ldc 147
    //   1074: iconst_2
    //   1075: new 149	java/lang/StringBuilder
    //   1078: dup
    //   1079: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1082: ldc 212
    //   1084: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: aload_0
    //   1088: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1091: getfield 42	aazc:a	Laaza;
    //   1094: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   1097: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1106: bipush 248
    //   1108: istore_1
    //   1109: goto -923 -> 186
    //   1112: astore 6
    //   1114: aload 6
    //   1116: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1119: iload_1
    //   1120: istore_2
    //   1121: goto -793 -> 328
    //   1124: astore 7
    //   1126: aload 9
    //   1128: astore 6
    //   1130: aload 7
    //   1132: invokevirtual 210	java/io/FileNotFoundException:printStackTrace	()V
    //   1135: bipush 246
    //   1137: istore_1
    //   1138: iload_1
    //   1139: istore_2
    //   1140: aload 6
    //   1142: ifnull -814 -> 328
    //   1145: aload 6
    //   1147: invokevirtual 140	java/io/FileInputStream:close	()V
    //   1150: iload_1
    //   1151: istore_2
    //   1152: goto -824 -> 328
    //   1155: astore 6
    //   1157: aload 6
    //   1159: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1162: iload_1
    //   1163: istore_2
    //   1164: goto -836 -> 328
    //   1167: astore 6
    //   1169: aconst_null
    //   1170: astore 7
    //   1172: aload 7
    //   1174: ifnull +8 -> 1182
    //   1177: aload 7
    //   1179: invokevirtual 140	java/io/FileInputStream:close	()V
    //   1182: aload 6
    //   1184: athrow
    //   1185: astore 7
    //   1187: aload 7
    //   1189: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1192: goto -10 -> 1182
    //   1195: bipush 247
    //   1197: istore_2
    //   1198: goto -870 -> 328
    //   1201: aload_0
    //   1202: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1205: getfield 42	aazc:a	Laaza;
    //   1208: invokestatic 215	aaza:c	(Laaza;)Z
    //   1211: ifeq +57 -> 1268
    //   1214: aload_0
    //   1215: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:b	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1218: getfield 218	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1221: astore 6
    //   1223: aload_0
    //   1224: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1227: getfield 42	aazc:a	Laaza;
    //   1230: invokestatic 220	aaza:b	(Laaza;)Z
    //   1233: ifeq +25 -> 1258
    //   1236: new 105	java/io/File
    //   1239: dup
    //   1240: aload_0
    //   1241: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:b	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1244: getfield 218	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1247: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   1250: invokevirtual 224	java/io/File:getParentFile	()Ljava/io/File;
    //   1253: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1256: astore 6
    //   1258: aload 6
    //   1260: invokestatic 232	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:AS	(Ljava/lang/String;)V
    //   1263: aload 6
    //   1265: invokestatic 235	aqhq:cn	(Ljava/lang/String;)V
    //   1268: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1271: ifeq +182 -> 1453
    //   1274: ldc 147
    //   1276: iconst_2
    //   1277: new 149	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1284: ldc 237
    //   1286: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload_0
    //   1290: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1293: getfield 42	aazc:a	Laaza;
    //   1296: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   1299: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: ldc 239
    //   1304: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload_0
    //   1308: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1311: getfield 42	aazc:a	Laaza;
    //   1314: invokestatic 179	aaza:a	(Laaza;)[B
    //   1317: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1320: ldc 244
    //   1322: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: aload_0
    //   1326: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1329: getfield 42	aazc:a	Laaza;
    //   1332: invokestatic 77	aaza:b	(Laaza;)Ljava/lang/String;
    //   1335: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: ldc 246
    //   1340: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: aload_0
    //   1344: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1347: getfield 42	aazc:a	Laaza;
    //   1350: invokestatic 249	aaza:a	(Laaza;)I
    //   1353: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1356: ldc 251
    //   1358: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: aload_0
    //   1362: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1365: getfield 42	aazc:a	Laaza;
    //   1368: invokestatic 253	aaza:b	(Laaza;)I
    //   1371: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1374: ldc 255
    //   1376: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: aload_0
    //   1380: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1383: getfield 42	aazc:a	Laaza;
    //   1386: invokestatic 103	aaza:c	(Laaza;)Ljava/lang/String;
    //   1389: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: ldc_w 257
    //   1395: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: aload_0
    //   1399: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:b	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1402: getfield 261	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   1405: d2i
    //   1406: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1409: ldc_w 263
    //   1412: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: aload_0
    //   1416: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1419: getfield 42	aazc:a	Laaza;
    //   1422: invokestatic 130	aaza:b	(Laaza;)[B
    //   1425: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1428: ldc_w 265
    //   1431: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: aload_0
    //   1435: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1438: getfield 42	aazc:a	Laaza;
    //   1441: invokestatic 267	aaza:d	(Laaza;)Ljava/lang/String;
    //   1444: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1453: aload_0
    //   1454: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1457: getfield 42	aazc:a	Laaza;
    //   1460: invokestatic 270	aaza:a	(Laaza;)Laaza$c;
    //   1463: ifnull -1092 -> 371
    //   1466: aload_0
    //   1467: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1470: getfield 42	aazc:a	Laaza;
    //   1473: invokestatic 270	aaza:a	(Laaza;)Laaza$c;
    //   1476: aload_0
    //   1477: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1480: getfield 42	aazc:a	Laaza;
    //   1483: invokestatic 103	aaza:c	(Laaza;)Ljava/lang/String;
    //   1486: aload_0
    //   1487: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1490: getfield 42	aazc:a	Laaza;
    //   1493: invokestatic 130	aaza:b	(Laaza;)[B
    //   1496: aload_0
    //   1497: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1500: getfield 42	aazc:a	Laaza;
    //   1503: invokestatic 47	aaza:a	(Laaza;)Ljava/lang/String;
    //   1506: aload_0
    //   1507: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1510: getfield 42	aazc:a	Laaza;
    //   1513: invokestatic 249	aaza:a	(Laaza;)I
    //   1516: aload_0
    //   1517: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1520: getfield 42	aazc:a	Laaza;
    //   1523: invokestatic 253	aaza:b	(Laaza;)I
    //   1526: aload_0
    //   1527: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:a	Laazc;
    //   1530: getfield 42	aazc:a	Laaza;
    //   1533: invokestatic 179	aaza:a	(Laaza;)[B
    //   1536: aload_0
    //   1537: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:b	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1540: getfield 261	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   1543: d2i
    //   1544: invokeinterface 275 8 0
    //   1549: return
    //   1550: astore 6
    //   1552: aload 6
    //   1554: invokevirtual 276	java/lang/Exception:printStackTrace	()V
    //   1557: goto -289 -> 1268
    //   1560: astore 6
    //   1562: goto -390 -> 1172
    //   1565: astore 8
    //   1567: aload 6
    //   1569: astore 7
    //   1571: aload 8
    //   1573: astore 6
    //   1575: goto -403 -> 1172
    //   1578: astore 8
    //   1580: aload 7
    //   1582: astore 6
    //   1584: aload 8
    //   1586: astore 7
    //   1588: goto -458 -> 1130
    //   1591: astore 7
    //   1593: goto -692 -> 901
    //   1596: astore 8
    //   1598: goto -886 -> 712
    //   1601: iconst_0
    //   1602: istore_1
    //   1603: goto -1027 -> 576
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1606	0	this	1
    //   6	1597	1	i	int
    //   9	1189	2	j	int
    //   4	827	3	k	int
    //   270	227	4	l	long
    //   128	380	6	localObject1	Object
    //   579	3	6	localIOException1	java.io.IOException
    //   604	111	6	localObject2	Object
    //   767	3	6	localIOException2	java.io.IOException
    //   792	115	6	str1	String
    //   944	3	6	localIOException3	java.io.IOException
    //   969	84	6	str2	String
    //   1112	3	6	localIOException4	java.io.IOException
    //   1128	18	6	localObject3	Object
    //   1155	3	6	localIOException5	java.io.IOException
    //   1167	16	6	localObject4	Object
    //   1221	43	6	str3	String
    //   1550	3	6	localException	java.lang.Exception
    //   1560	8	6	localObject5	Object
    //   1573	10	6	localObject6	Object
    //   97	630	7	localObject7	Object
    //   896	46	7	localObject8	Object
    //   1124	7	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   1170	8	7	localObject9	Object
    //   1185	3	7	localIOException6	java.io.IOException
    //   1569	18	7	localObject10	Object
    //   1591	1	7	localObject11	Object
    //   443	34	8	localFile	java.io.File
    //   707	10	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   1565	7	8	localObject12	Object
    //   1578	7	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   1596	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   1	1126	9	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   538	543	579	java/io/IOException
    //   453	472	707	java/io/FileNotFoundException
    //   726	731	767	java/io/IOException
    //   453	472	896	finally
    //   906	911	944	java/io/IOException
    //   321	326	1112	java/io/IOException
    //   246	265	1124	java/io/FileNotFoundException
    //   1145	1150	1155	java/io/IOException
    //   246	265	1167	finally
    //   1177	1182	1185	java/io/IOException
    //   1201	1223	1550	java/lang/Exception
    //   1223	1258	1550	java/lang/Exception
    //   1258	1268	1550	java/lang/Exception
    //   265	314	1560	finally
    //   1130	1135	1565	finally
    //   265	314	1578	java/io/FileNotFoundException
    //   476	483	1591	finally
    //   487	505	1591	finally
    //   509	533	1591	finally
    //   716	721	1591	finally
    //   476	483	1596	java/io/FileNotFoundException
    //   487	505	1596	java/io/FileNotFoundException
    //   509	533	1596	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.1
 * JD-Core Version:    0.7.0.1
 */