package com.tencent.mobileqq.troop.data;

import apaz.b;
import apba;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoUploadTask
  implements Runnable
{
  private static String aYR;
  private static String aYS;
  public apba a;
  protected apaz.b b;
  protected AtomicBoolean bN;
  protected String fT;
  protected long mOffset;
  protected String mUin;
  
  public boolean aAQ()
  {
    return this.bN.get();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: aload_0
    //   6: getfield 23	com/tencent/mobileqq/troop/data/VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: iconst_0
    //   10: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   13: aload_0
    //   14: getfield 49	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Lapaz$b;
    //   17: ifnonnull +26 -> 43
    //   20: aload_0
    //   21: getfield 23	com/tencent/mobileqq/troop/data/VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: iconst_1
    //   25: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   28: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc 56
    //   36: iconst_2
    //   37: ldc 58
    //   39: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: aload_0
    //   44: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   47: ifnull +23 -> 70
    //   50: aload_0
    //   51: getfield 66	com/tencent/mobileqq/troop/data/VideoUploadTask:mUin	Ljava/lang/String;
    //   54: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +13 -> 70
    //   60: aload_0
    //   61: getfield 74	com/tencent/mobileqq/troop/data/VideoUploadTask:fT	Ljava/lang/String;
    //   64: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +96 -> 163
    //   70: aload_0
    //   71: getfield 23	com/tencent/mobileqq/troop/data/VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   78: aload_0
    //   79: getfield 49	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Lapaz$b;
    //   82: ldc2_w 75
    //   85: invokeinterface 82 3 0
    //   90: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq -51 -> 42
    //   96: aload_0
    //   97: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   100: ifnonnull +39 -> 139
    //   103: ldc 84
    //   105: astore 13
    //   107: ldc 56
    //   109: iconst_2
    //   110: new 86	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   117: ldc 91
    //   119: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 13
    //   124: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 97
    //   129: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: return
    //   139: aload_0
    //   140: getfield 66	com/tencent/mobileqq/troop/data/VideoUploadTask:mUin	Ljava/lang/String;
    //   143: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifeq +10 -> 156
    //   149: ldc 103
    //   151: astore 13
    //   153: goto -46 -> 107
    //   156: ldc 105
    //   158: astore 13
    //   160: goto -53 -> 107
    //   163: aload_0
    //   164: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   167: getfield 110	apba:mVideoPath	Ljava/lang/String;
    //   170: astore 14
    //   172: new 112	android/os/Bundle
    //   175: dup
    //   176: invokespecial 113	android/os/Bundle:<init>	()V
    //   179: astore 13
    //   181: aload 13
    //   183: ldc 115
    //   185: getstatic 117	com/tencent/mobileqq/troop/data/VideoUploadTask:aYR	Ljava/lang/String;
    //   188: invokevirtual 121	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 13
    //   193: ldc 123
    //   195: aload 14
    //   197: invokevirtual 121	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 13
    //   202: ldc 125
    //   204: getstatic 127	com/tencent/mobileqq/troop/data/VideoUploadTask:aYS	Ljava/lang/String;
    //   207: invokevirtual 121	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 13
    //   212: ldc 129
    //   214: aload_0
    //   215: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   218: getfield 132	apba:mTitle	Ljava/lang/String;
    //   221: invokevirtual 121	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 13
    //   226: ldc 134
    //   228: aload_0
    //   229: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   232: getfield 137	apba:mVid	Ljava/lang/String;
    //   235: invokevirtual 121	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload 13
    //   240: ldc 139
    //   242: aload_0
    //   243: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   246: getfield 143	apba:mGroupType	I
    //   249: invokevirtual 147	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   252: invokestatic 153	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   255: invokestatic 159	jqc:ak	(Landroid/content/Context;)Z
    //   258: ifeq +872 -> 1130
    //   261: aload_0
    //   262: getfield 23	com/tencent/mobileqq/troop/data/VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   265: invokevirtual 28	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   268: ifne +862 -> 1130
    //   271: aload_0
    //   272: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   275: getfield 143	apba:mGroupType	I
    //   278: iconst_3
    //   279: if_icmpne +210 -> 489
    //   282: aload_0
    //   283: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   286: getfield 162	apba:a	Lapaz$a;
    //   289: ifnull +107 -> 396
    //   292: aload_0
    //   293: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   296: getfield 162	apba:a	Lapaz$a;
    //   299: getfield 166	apaz$a:vid	Ljava/lang/String;
    //   302: ifnull +94 -> 396
    //   305: aload_0
    //   306: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   309: getfield 162	apba:a	Lapaz$a;
    //   312: astore 13
    //   314: aload 13
    //   316: ifnull +793 -> 1109
    //   319: ldc 168
    //   321: aload 13
    //   323: getfield 171	apaz$a:cnL	Ljava/lang/String;
    //   326: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   329: ifeq +178 -> 507
    //   332: iconst_1
    //   333: istore_1
    //   334: aload_0
    //   335: getfield 23	com/tencent/mobileqq/troop/data/VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_0
    //   339: iconst_1
    //   340: invokevirtual 181	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   343: ifeq -301 -> 42
    //   346: iload_1
    //   347: ifeq +670 -> 1017
    //   350: aload_0
    //   351: getfield 49	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Lapaz$b;
    //   354: invokeinterface 184 1 0
    //   359: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -320 -> 42
    //   365: ldc 56
    //   367: iconst_2
    //   368: new 86	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   375: ldc 186
    //   377: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   383: lload 11
    //   385: lsub
    //   386: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: return
    //   396: aload 13
    //   398: aload_0
    //   399: getfield 66	com/tencent/mobileqq/troop/data/VideoUploadTask:mUin	Ljava/lang/String;
    //   402: aload_0
    //   403: getfield 74	com/tencent/mobileqq/troop/data/VideoUploadTask:fT	Ljava/lang/String;
    //   406: invokestatic 194	aptt:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lapaz$a;
    //   409: astore 13
    //   411: aload 13
    //   413: ifnull +714 -> 1127
    //   416: aload_0
    //   417: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   420: aload 13
    //   422: getfield 166	apaz$a:vid	Ljava/lang/String;
    //   425: putfield 137	apba:mVid	Ljava/lang/String;
    //   428: new 196	java/io/File
    //   431: dup
    //   432: aload_0
    //   433: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   436: getfield 110	apba:mVideoPath	Ljava/lang/String;
    //   439: invokespecial 199	java/io/File:<init>	(Ljava/lang/String;)V
    //   442: astore 15
    //   444: aload 15
    //   446: invokevirtual 202	java/io/File:exists	()Z
    //   449: ifeq +15 -> 464
    //   452: aload_0
    //   453: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   456: aload 15
    //   458: invokevirtual 205	java/io/File:length	()J
    //   461: putfield 208	apba:mSize	J
    //   464: aload_0
    //   465: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   468: aload_0
    //   469: getfield 64	com/tencent/mobileqq/troop/data/VideoUploadTask:a	Lapba;
    //   472: getfield 110	apba:mVideoPath	Ljava/lang/String;
    //   475: invokestatic 214	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   478: ldc2_w 215
    //   481: ldiv
    //   482: l2i
    //   483: putfield 219	apba:mVideoDuration	I
    //   486: goto -172 -> 314
    //   489: aload 13
    //   491: aload_0
    //   492: getfield 66	com/tencent/mobileqq/troop/data/VideoUploadTask:mUin	Ljava/lang/String;
    //   495: aload_0
    //   496: getfield 74	com/tencent/mobileqq/troop/data/VideoUploadTask:fT	Ljava/lang/String;
    //   499: invokestatic 222	apaz:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lapaz$a;
    //   502: astore 13
    //   504: goto -190 -> 314
    //   507: aload 13
    //   509: getfield 166	apaz$a:vid	Ljava/lang/String;
    //   512: ifnull +597 -> 1109
    //   515: aload 13
    //   517: getfield 225	apaz$a:cnJ	Ljava/lang/String;
    //   520: invokestatic 231	aqhs:hexStr2Bytes	(Ljava/lang/String;)[B
    //   523: astore 15
    //   525: aload 14
    //   527: invokestatic 236	ahav:x	(Ljava/lang/String;)[B
    //   530: astore 16
    //   532: aload 14
    //   534: invokestatic 241	aqhq:getFileSizes	(Ljava/lang/String;)J
    //   537: lstore 5
    //   539: lload 5
    //   541: ldc2_w 242
    //   544: lcmp
    //   545: ifle +249 -> 794
    //   548: ldc2_w 242
    //   551: lstore_3
    //   552: new 86	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   559: ldc 245
    //   561: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload 13
    //   566: getfield 248	apaz$a:cnH	Ljava/lang/String;
    //   569: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: ldc 250
    //   574: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 13
    //   579: getfield 253	apaz$a:cnI	Ljava/lang/String;
    //   582: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: ldc 255
    //   587: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: astore 17
    //   595: aload_0
    //   596: getfield 49	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Lapaz$b;
    //   599: invokeinterface 258 1 0
    //   604: new 260	java/io/RandomAccessFile
    //   607: dup
    //   608: aload 14
    //   610: ldc_w 262
    //   613: invokespecial 264	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: astore 14
    //   618: lconst_0
    //   619: lstore 9
    //   621: lload_3
    //   622: lstore 7
    //   624: lload 9
    //   626: lstore_3
    //   627: lload 7
    //   629: lload_3
    //   630: lsub
    //   631: l2i
    //   632: istore_1
    //   633: aload 14
    //   635: astore 13
    //   637: invokestatic 153	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   640: invokestatic 159	jqc:ak	(Landroid/content/Context;)Z
    //   643: ifeq +257 -> 900
    //   646: aload 14
    //   648: astore 13
    //   650: aload_0
    //   651: getfield 23	com/tencent/mobileqq/troop/data/VideoUploadTask:bN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   654: invokevirtual 28	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   657: ifne +243 -> 900
    //   660: aload 14
    //   662: astore 13
    //   664: aload 15
    //   666: aload 16
    //   668: aload 17
    //   670: lload 5
    //   672: aload 14
    //   674: lload_3
    //   675: iload_1
    //   676: invokestatic 267	apaz:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   679: lstore 7
    //   681: aload 14
    //   683: astore 13
    //   685: aload_0
    //   686: lload 7
    //   688: putfield 269	com/tencent/mobileqq/troop/data/VideoUploadTask:mOffset	J
    //   691: lload 7
    //   693: ldc2_w 75
    //   696: lcmp
    //   697: ifeq +103 -> 800
    //   700: aload 14
    //   702: astore 13
    //   704: aload_0
    //   705: invokevirtual 271	com/tencent/mobileqq/troop/data/VideoUploadTask:aAQ	()Z
    //   708: ifne +18 -> 726
    //   711: aload 14
    //   713: astore 13
    //   715: aload_0
    //   716: getfield 49	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Lapaz$b;
    //   719: lload 7
    //   721: invokeinterface 274 3 0
    //   726: ldc2_w 242
    //   729: lload 7
    //   731: ladd
    //   732: lload 5
    //   734: lcmp
    //   735: ifle +155 -> 890
    //   738: lload 5
    //   740: lstore_3
    //   741: lload 7
    //   743: lload 5
    //   745: lcmp
    //   746: iflt +368 -> 1114
    //   749: iconst_1
    //   750: istore_2
    //   751: iload_2
    //   752: istore_1
    //   753: aload 14
    //   755: ifnull -421 -> 334
    //   758: aload 14
    //   760: invokevirtual 277	java/io/RandomAccessFile:close	()V
    //   763: iload_2
    //   764: istore_1
    //   765: goto -431 -> 334
    //   768: astore 13
    //   770: iload_2
    //   771: istore_1
    //   772: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   775: ifeq -441 -> 334
    //   778: ldc 56
    //   780: iconst_2
    //   781: aload 13
    //   783: invokestatic 281	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   786: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: iload_2
    //   790: istore_1
    //   791: goto -457 -> 334
    //   794: lload 5
    //   796: lstore_3
    //   797: goto -245 -> 552
    //   800: aload 14
    //   802: astore 13
    //   804: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   807: ifeq -58 -> 749
    //   810: aload 14
    //   812: astore 13
    //   814: ldc 56
    //   816: iconst_2
    //   817: new 86	java/lang/StringBuilder
    //   820: dup
    //   821: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   824: ldc_w 283
    //   827: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   833: lload 11
    //   835: lsub
    //   836: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   839: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: goto -96 -> 749
    //   848: astore 15
    //   850: aload 14
    //   852: astore 13
    //   854: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   857: ifeq +18 -> 875
    //   860: aload 14
    //   862: astore 13
    //   864: ldc 56
    //   866: iconst_2
    //   867: aload 15
    //   869: invokestatic 281	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   872: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: aload 14
    //   877: ifnull +232 -> 1109
    //   880: aload 14
    //   882: invokevirtual 277	java/io/RandomAccessFile:close	()V
    //   885: iconst_0
    //   886: istore_1
    //   887: goto -553 -> 334
    //   890: ldc2_w 242
    //   893: lload 7
    //   895: ladd
    //   896: lstore_3
    //   897: goto -156 -> 741
    //   900: aload 14
    //   902: astore 13
    //   904: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   907: ifeq -158 -> 749
    //   910: aload 14
    //   912: astore 13
    //   914: ldc 56
    //   916: iconst_2
    //   917: new 86	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   924: ldc_w 285
    //   927: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   933: lload 11
    //   935: lsub
    //   936: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   939: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   942: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   945: goto -196 -> 749
    //   948: astore 15
    //   950: aload 13
    //   952: astore 14
    //   954: aload 15
    //   956: astore 13
    //   958: aload 14
    //   960: ifnull +8 -> 968
    //   963: aload 14
    //   965: invokevirtual 277	java/io/RandomAccessFile:close	()V
    //   968: aload 13
    //   970: athrow
    //   971: astore 13
    //   973: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   976: ifeq +14 -> 990
    //   979: ldc 56
    //   981: iconst_2
    //   982: aload 13
    //   984: invokestatic 281	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   987: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   990: iconst_0
    //   991: istore_1
    //   992: goto -658 -> 334
    //   995: astore 14
    //   997: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1000: ifeq -32 -> 968
    //   1003: ldc 56
    //   1005: iconst_2
    //   1006: aload 14
    //   1008: invokestatic 281	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1011: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1014: goto -46 -> 968
    //   1017: invokestatic 153	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1020: invokestatic 159	jqc:ak	(Landroid/content/Context;)Z
    //   1023: ifne +9 -> 1032
    //   1026: ldc2_w 286
    //   1029: invokestatic 292	java/lang/Thread:sleep	(J)V
    //   1032: aload_0
    //   1033: getfield 49	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Lapaz$b;
    //   1036: aload_0
    //   1037: getfield 269	com/tencent/mobileqq/troop/data/VideoUploadTask:mOffset	J
    //   1040: invokeinterface 82 3 0
    //   1045: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1048: ifeq -1006 -> 42
    //   1051: ldc 56
    //   1053: iconst_2
    //   1054: new 86	java/lang/StringBuilder
    //   1057: dup
    //   1058: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1061: ldc_w 294
    //   1064: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   1070: lload 11
    //   1072: lsub
    //   1073: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1076: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1082: return
    //   1083: astore 13
    //   1085: aload 13
    //   1087: invokevirtual 297	java/lang/InterruptedException:printStackTrace	()V
    //   1090: goto -58 -> 1032
    //   1093: astore 13
    //   1095: aconst_null
    //   1096: astore 14
    //   1098: goto -140 -> 958
    //   1101: astore 15
    //   1103: aconst_null
    //   1104: astore 14
    //   1106: goto -256 -> 850
    //   1109: iconst_0
    //   1110: istore_1
    //   1111: goto -777 -> 334
    //   1114: lload_3
    //   1115: lstore 9
    //   1117: lload 7
    //   1119: lstore_3
    //   1120: lload 9
    //   1122: lstore 7
    //   1124: goto -497 -> 627
    //   1127: goto -813 -> 314
    //   1130: aconst_null
    //   1131: astore 13
    //   1133: goto -819 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1136	0	this	VideoUploadTask
    //   333	778	1	i	int
    //   750	40	2	j	int
    //   551	569	3	l1	long
    //   537	258	5	l2	long
    //   622	501	7	l3	long
    //   619	502	9	l4	long
    //   3	1068	11	l5	long
    //   105	609	13	localObject1	Object
    //   768	14	13	localIOException1	java.io.IOException
    //   802	167	13	localObject2	Object
    //   971	12	13	localIOException2	java.io.IOException
    //   1083	3	13	localInterruptedException	java.lang.InterruptedException
    //   1093	1	13	localObject3	Object
    //   1131	1	13	localObject4	Object
    //   170	794	14	localObject5	Object
    //   995	12	14	localIOException3	java.io.IOException
    //   1096	9	14	localObject6	Object
    //   442	223	15	localObject7	Object
    //   848	20	15	localException1	java.lang.Exception
    //   948	7	15	localObject8	Object
    //   1101	1	15	localException2	java.lang.Exception
    //   530	137	16	arrayOfByte	byte[]
    //   593	76	17	str	String
    // Exception table:
    //   from	to	target	type
    //   758	763	768	java/io/IOException
    //   637	646	848	java/lang/Exception
    //   650	660	848	java/lang/Exception
    //   664	681	848	java/lang/Exception
    //   685	691	848	java/lang/Exception
    //   704	711	848	java/lang/Exception
    //   715	726	848	java/lang/Exception
    //   804	810	848	java/lang/Exception
    //   814	845	848	java/lang/Exception
    //   904	910	848	java/lang/Exception
    //   914	945	848	java/lang/Exception
    //   637	646	948	finally
    //   650	660	948	finally
    //   664	681	948	finally
    //   685	691	948	finally
    //   704	711	948	finally
    //   715	726	948	finally
    //   804	810	948	finally
    //   814	845	948	finally
    //   854	860	948	finally
    //   864	875	948	finally
    //   904	910	948	finally
    //   914	945	948	finally
    //   880	885	971	java/io/IOException
    //   963	968	995	java/io/IOException
    //   1026	1032	1083	java/lang/InterruptedException
    //   595	618	1093	finally
    //   595	618	1101	java/lang/Exception
  }
  
  public void stop()
  {
    this.bN.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */