package com.tencent.mobileqq.activity.aio.doodle;

import amjb;
import android.graphics.Rect;
import android.text.TextUtils;
import aqhq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import wrb;
import wre;
import wro;
import wrq;
import wru;
import wru.a;
import wrv;
import wrv.a;
import wrx;
import wrx.a;
import wsa;

public class LoadDataJob
  implements Runnable
{
  private static final String aUa = amjb.yR() + "pclcache" + File.separator;
  private int bRs;
  final int bRt = 3;
  public String mFile;
  private int mHeight;
  private WeakReference<a> mListenerRef;
  private int mWidth;
  
  public LoadDataJob(String paramString, int paramInt1, int paramInt2, a parama)
  {
    this.mFile = paramString;
    this.mListenerRef = new WeakReference(parama);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  /* Error */
  private List<wsa> a(String paramString, a parama)
  {
    // Byte code:
    //   0: new 91	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 92	java/util/ArrayList:<init>	()V
    //   7: astore 14
    //   9: aload_1
    //   10: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +6 -> 19
    //   16: aload 14
    //   18: areturn
    //   19: iconst_1
    //   20: istore 5
    //   22: iconst_1
    //   23: istore 7
    //   25: iconst_0
    //   26: istore 6
    //   28: new 100	java/util/HashMap
    //   31: dup
    //   32: invokespecial 101	java/util/HashMap:<init>	()V
    //   35: astore 15
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   42: new 103	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 106	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 8
    //   54: invokevirtual 110	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   57: lconst_0
    //   58: ldc2_w 111
    //   61: iconst_1
    //   62: invokevirtual 118	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   65: astore 9
    //   67: aload 9
    //   69: ifnull +2035 -> 2104
    //   72: new 120	java/io/BufferedInputStream
    //   75: dup
    //   76: aload 8
    //   78: invokespecial 123	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore 10
    //   83: aload 9
    //   85: astore 11
    //   87: aload 10
    //   89: astore 12
    //   91: aload 8
    //   93: astore 13
    //   95: iload 7
    //   97: istore 5
    //   99: iconst_4
    //   100: newarray byte
    //   102: astore 16
    //   104: iconst_0
    //   105: istore_3
    //   106: aload 9
    //   108: astore 11
    //   110: aload 10
    //   112: astore 12
    //   114: aload 8
    //   116: astore 13
    //   118: iload 7
    //   120: istore 5
    //   122: aload 10
    //   124: aload 16
    //   126: invokevirtual 129	java/io/InputStream:read	([B)I
    //   129: iconst_4
    //   130: if_icmpne +1947 -> 2077
    //   133: aload 9
    //   135: astore 11
    //   137: aload 10
    //   139: astore 12
    //   141: aload 8
    //   143: astore 13
    //   145: iload 7
    //   147: istore 5
    //   149: aload 16
    //   151: iconst_0
    //   152: invokestatic 135	wre:bytesToInt	([BI)I
    //   155: istore 4
    //   157: iload 4
    //   159: ifle +10 -> 169
    //   162: iload 4
    //   164: ldc 136
    //   166: if_icmplt +319 -> 485
    //   169: aload 9
    //   171: astore 11
    //   173: aload 10
    //   175: astore 12
    //   177: aload 8
    //   179: astore 13
    //   181: iload 7
    //   183: istore 5
    //   185: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +45 -> 233
    //   191: aload 9
    //   193: astore 11
    //   195: aload 10
    //   197: astore 12
    //   199: aload 8
    //   201: astore 13
    //   203: iload 7
    //   205: istore 5
    //   207: ldc 144
    //   209: iconst_2
    //   210: new 33	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   217: ldc 146
    //   219: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload 4
    //   224: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: iconst_0
    //   234: istore 5
    //   236: aload 10
    //   238: astore_2
    //   239: iconst_0
    //   240: istore 6
    //   242: aload 14
    //   244: monitorenter
    //   245: aload_0
    //   246: aload_0
    //   247: getfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   250: iconst_1
    //   251: isub
    //   252: putfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   255: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +66 -> 324
    //   261: ldc 144
    //   263: iconst_2
    //   264: new 33	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   271: ldc 155
    //   273: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: getfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   280: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: ldc 157
    //   285: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 14
    //   290: invokeinterface 163 1 0
    //   295: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: ldc 165
    //   300: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload 6
    //   305: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   308: ldc 170
    //   310: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 5
    //   315: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   318: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_0
    //   325: getfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   328: istore_3
    //   329: aload 14
    //   331: invokeinterface 163 1 0
    //   336: istore 4
    //   338: iload_3
    //   339: iload 4
    //   341: if_icmple +16 -> 357
    //   344: iload 6
    //   346: ifeq +11 -> 357
    //   349: aload 14
    //   351: ldc2_w 174
    //   354: invokevirtual 179	java/lang/Object:wait	(J)V
    //   357: aload 14
    //   359: invokeinterface 163 1 0
    //   364: ifle +16 -> 380
    //   367: aload 14
    //   369: new 14	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$b
    //   372: dup
    //   373: aload_0
    //   374: invokespecial 182	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$b:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;)V
    //   377: invokestatic 188	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   380: aload 14
    //   382: monitorexit
    //   383: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +11 -> 397
    //   389: ldc 144
    //   391: iconst_2
    //   392: ldc 190
    //   394: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload 9
    //   399: ifnull +8 -> 407
    //   402: aload 9
    //   404: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   407: aload 8
    //   409: ifnull +8 -> 417
    //   412: aload 8
    //   414: invokevirtual 198	java/io/FileInputStream:close	()V
    //   417: aload_2
    //   418: ifnull +7 -> 425
    //   421: aload_2
    //   422: invokevirtual 199	java/io/InputStream:close	()V
    //   425: iload 5
    //   427: istore 7
    //   429: iload 6
    //   431: ifne +33 -> 464
    //   434: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +11 -> 448
    //   440: ldc 144
    //   442: iconst_2
    //   443: ldc 201
    //   445: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: aload_1
    //   449: invokestatic 207	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   452: pop
    //   453: aload 14
    //   455: invokeinterface 210 1 0
    //   460: iload 5
    //   462: istore 7
    //   464: iload 7
    //   466: ifeq +1435 -> 1901
    //   469: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   472: ifeq +11 -> 483
    //   475: ldc 144
    //   477: iconst_2
    //   478: ldc 212
    //   480: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: aconst_null
    //   484: areturn
    //   485: aload 9
    //   487: astore 11
    //   489: aload 10
    //   491: astore 12
    //   493: aload 8
    //   495: astore 13
    //   497: iload 7
    //   499: istore 5
    //   501: iload 4
    //   503: newarray byte
    //   505: astore 17
    //   507: aload 9
    //   509: astore 11
    //   511: aload 10
    //   513: astore 12
    //   515: aload 8
    //   517: astore 13
    //   519: iload 7
    //   521: istore 5
    //   523: aload 10
    //   525: aload 17
    //   527: iconst_0
    //   528: iload 4
    //   530: invokevirtual 215	java/io/InputStream:read	([BII)I
    //   533: iload 4
    //   535: if_icmpeq +70 -> 605
    //   538: aload 9
    //   540: astore 11
    //   542: aload 10
    //   544: astore 12
    //   546: aload 8
    //   548: astore 13
    //   550: iload 7
    //   552: istore 5
    //   554: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +1558 -> 2115
    //   560: aload 9
    //   562: astore 11
    //   564: aload 10
    //   566: astore 12
    //   568: aload 8
    //   570: astore 13
    //   572: iload 7
    //   574: istore 5
    //   576: ldc 144
    //   578: iconst_2
    //   579: new 33	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   586: ldc 217
    //   588: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload 4
    //   593: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: goto +1513 -> 2115
    //   605: aload 9
    //   607: astore 11
    //   609: aload 10
    //   611: astore 12
    //   613: aload 8
    //   615: astore 13
    //   617: iload 7
    //   619: istore 5
    //   621: new 8	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob
    //   624: dup
    //   625: aload_0
    //   626: iload_3
    //   627: aload 17
    //   629: new 219	wrs
    //   632: dup
    //   633: aload_0
    //   634: aload 15
    //   636: aload 14
    //   638: invokespecial 222	wrs:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;Ljava/util/Map;Ljava/util/List;)V
    //   641: invokespecial 225	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;I[BLcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob$c;)V
    //   644: astore 17
    //   646: aload 9
    //   648: astore 11
    //   650: aload 10
    //   652: astore 12
    //   654: aload 8
    //   656: astore 13
    //   658: iload 7
    //   660: istore 5
    //   662: aload 15
    //   664: monitorenter
    //   665: aload 15
    //   667: invokeinterface 228 1 0
    //   672: istore 4
    //   674: iload 4
    //   676: iconst_3
    //   677: if_icmple +48 -> 725
    //   680: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq +34 -> 717
    //   686: ldc 144
    //   688: iconst_2
    //   689: new 33	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   696: ldc 230
    //   698: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload 15
    //   703: invokeinterface 228 1 0
    //   708: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   711: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   717: aload 15
    //   719: ldc2_w 231
    //   722: invokevirtual 179	java/lang/Object:wait	(J)V
    //   725: aload 15
    //   727: monitorexit
    //   728: aload 9
    //   730: astore 11
    //   732: aload 10
    //   734: astore 12
    //   736: aload 8
    //   738: astore 13
    //   740: iload 7
    //   742: istore 5
    //   744: aload_2
    //   745: aload_0
    //   746: getfield 65	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:mFile	Ljava/lang/String;
    //   749: invokeinterface 235 2 0
    //   754: ifne +681 -> 1435
    //   757: aload 9
    //   759: astore 11
    //   761: aload 10
    //   763: astore 12
    //   765: aload 8
    //   767: astore 13
    //   769: iload 7
    //   771: istore 5
    //   773: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   776: ifeq +27 -> 803
    //   779: aload 9
    //   781: astore 11
    //   783: aload 10
    //   785: astore 12
    //   787: aload 8
    //   789: astore 13
    //   791: iload 7
    //   793: istore 5
    //   795: ldc 144
    //   797: iconst_2
    //   798: ldc 237
    //   800: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   803: iconst_0
    //   804: istore_3
    //   805: aload 9
    //   807: astore 11
    //   809: aload 10
    //   811: astore 12
    //   813: aload 8
    //   815: astore 13
    //   817: iload 7
    //   819: istore 5
    //   821: aload 15
    //   823: monitorenter
    //   824: aload 15
    //   826: invokeinterface 241 1 0
    //   831: invokeinterface 247 1 0
    //   836: astore_2
    //   837: aload_2
    //   838: invokeinterface 252 1 0
    //   843: ifeq +203 -> 1046
    //   846: aload_2
    //   847: invokeinterface 256 1 0
    //   852: checkcast 8	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob
    //   855: bipush 16
    //   857: invokestatic 262	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   860: istore 5
    //   862: iload 5
    //   864: ifeq +1237 -> 2101
    //   867: iload_3
    //   868: iconst_1
    //   869: iadd
    //   870: istore_3
    //   871: goto -34 -> 837
    //   874: astore 11
    //   876: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   879: ifeq -154 -> 725
    //   882: ldc 144
    //   884: iconst_2
    //   885: new 33	java/lang/StringBuilder
    //   888: dup
    //   889: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   892: ldc_w 264
    //   895: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: aload 11
    //   900: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   903: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   909: goto -184 -> 725
    //   912: astore_2
    //   913: aload 15
    //   915: monitorexit
    //   916: aload 9
    //   918: astore 11
    //   920: aload 10
    //   922: astore 12
    //   924: aload 8
    //   926: astore 13
    //   928: iload 7
    //   930: istore 5
    //   932: aload_2
    //   933: athrow
    //   934: astore 11
    //   936: iconst_0
    //   937: istore 5
    //   939: aload 9
    //   941: astore_2
    //   942: aload 11
    //   944: astore 9
    //   946: iconst_0
    //   947: istore 6
    //   949: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq +33 -> 985
    //   955: ldc 144
    //   957: iconst_2
    //   958: new 33	java/lang/StringBuilder
    //   961: dup
    //   962: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   965: ldc_w 269
    //   968: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: aload 9
    //   973: invokevirtual 270	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   976: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: aload_2
    //   986: ifnull +7 -> 993
    //   989: aload_2
    //   990: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   993: aload 8
    //   995: ifnull +8 -> 1003
    //   998: aload 8
    //   1000: invokevirtual 198	java/io/FileInputStream:close	()V
    //   1003: aload 10
    //   1005: ifnull +8 -> 1013
    //   1008: aload 10
    //   1010: invokevirtual 199	java/io/InputStream:close	()V
    //   1013: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1016: ifeq +11 -> 1027
    //   1019: ldc 144
    //   1021: iconst_2
    //   1022: ldc 201
    //   1024: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1027: aload_1
    //   1028: invokestatic 207	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   1031: pop
    //   1032: aload 14
    //   1034: invokeinterface 210 1 0
    //   1039: iload 5
    //   1041: istore 7
    //   1043: goto -579 -> 464
    //   1046: aload 15
    //   1048: invokeinterface 271 1 0
    //   1053: aload 15
    //   1055: monitorexit
    //   1056: aload 9
    //   1058: astore 11
    //   1060: aload 10
    //   1062: astore 12
    //   1064: aload 8
    //   1066: astore 13
    //   1068: iload 7
    //   1070: istore 5
    //   1072: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1075: ifeq +45 -> 1120
    //   1078: aload 9
    //   1080: astore 11
    //   1082: aload 10
    //   1084: astore 12
    //   1086: aload 8
    //   1088: astore 13
    //   1090: iload 7
    //   1092: istore 5
    //   1094: ldc 144
    //   1096: iconst_2
    //   1097: new 33	java/lang/StringBuilder
    //   1100: dup
    //   1101: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1104: ldc_w 273
    //   1107: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: iload_3
    //   1111: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1120: iload_3
    //   1121: ifle +968 -> 2089
    //   1124: aload 9
    //   1126: astore 11
    //   1128: aload 10
    //   1130: astore 12
    //   1132: aload 8
    //   1134: astore 13
    //   1136: iload 7
    //   1138: istore 5
    //   1140: aload 14
    //   1142: monitorenter
    //   1143: aload_0
    //   1144: aload_0
    //   1145: getfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   1148: iload_3
    //   1149: isub
    //   1150: putfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   1153: aload 14
    //   1155: monitorexit
    //   1156: aload 9
    //   1158: astore 11
    //   1160: aload 10
    //   1162: astore 12
    //   1164: aload 8
    //   1166: astore 13
    //   1168: iload 7
    //   1170: istore 5
    //   1172: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1175: ifeq +914 -> 2089
    //   1178: aload 9
    //   1180: astore 11
    //   1182: aload 10
    //   1184: astore 12
    //   1186: aload 8
    //   1188: astore 13
    //   1190: iload 7
    //   1192: istore 5
    //   1194: ldc 144
    //   1196: iconst_2
    //   1197: new 33	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1204: ldc_w 275
    //   1207: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: aload_0
    //   1211: getfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   1214: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1217: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1220: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1223: iconst_1
    //   1224: istore 5
    //   1226: aload 10
    //   1228: astore_2
    //   1229: iconst_1
    //   1230: istore 6
    //   1232: goto -990 -> 242
    //   1235: astore_2
    //   1236: aload 15
    //   1238: monitorexit
    //   1239: aload 9
    //   1241: astore 11
    //   1243: aload 10
    //   1245: astore 12
    //   1247: aload 8
    //   1249: astore 13
    //   1251: iload 7
    //   1253: istore 5
    //   1255: aload_2
    //   1256: athrow
    //   1257: astore 11
    //   1259: iconst_1
    //   1260: istore 5
    //   1262: aload 9
    //   1264: astore_2
    //   1265: aload 11
    //   1267: astore 9
    //   1269: goto -323 -> 946
    //   1272: astore_2
    //   1273: aload 14
    //   1275: monitorexit
    //   1276: aload 9
    //   1278: astore 11
    //   1280: aload 10
    //   1282: astore 12
    //   1284: aload 8
    //   1286: astore 13
    //   1288: iload 7
    //   1290: istore 5
    //   1292: aload_2
    //   1293: athrow
    //   1294: astore_2
    //   1295: iconst_1
    //   1296: istore 6
    //   1298: iconst_1
    //   1299: istore 5
    //   1301: aload_2
    //   1302: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   1305: iconst_0
    //   1306: istore 7
    //   1308: aload 9
    //   1310: astore 11
    //   1312: aload 10
    //   1314: astore 12
    //   1316: aload 8
    //   1318: astore 13
    //   1320: iload 7
    //   1322: istore 5
    //   1324: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1327: ifeq +45 -> 1372
    //   1330: aload 9
    //   1332: astore 11
    //   1334: aload 10
    //   1336: astore 12
    //   1338: aload 8
    //   1340: astore 13
    //   1342: iload 7
    //   1344: istore 5
    //   1346: ldc 144
    //   1348: iconst_2
    //   1349: new 33	java/lang/StringBuilder
    //   1352: dup
    //   1353: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1356: ldc_w 280
    //   1359: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: aload_2
    //   1363: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1372: aload 9
    //   1374: ifnull +8 -> 1382
    //   1377: aload 9
    //   1379: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   1382: aload 8
    //   1384: ifnull +8 -> 1392
    //   1387: aload 8
    //   1389: invokevirtual 198	java/io/FileInputStream:close	()V
    //   1392: aload 10
    //   1394: ifnull +8 -> 1402
    //   1397: aload 10
    //   1399: invokevirtual 199	java/io/InputStream:close	()V
    //   1402: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1405: ifeq +11 -> 1416
    //   1408: ldc 144
    //   1410: iconst_2
    //   1411: ldc 201
    //   1413: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1416: aload_1
    //   1417: invokestatic 207	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   1420: pop
    //   1421: aload 14
    //   1423: invokeinterface 210 1 0
    //   1428: iload 6
    //   1430: istore 7
    //   1432: goto -968 -> 464
    //   1435: aload 9
    //   1437: astore 11
    //   1439: aload 10
    //   1441: astore 12
    //   1443: aload 8
    //   1445: astore 13
    //   1447: iload 7
    //   1449: istore 5
    //   1451: aload 15
    //   1453: monitorenter
    //   1454: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1457: ifeq +29 -> 1486
    //   1460: ldc 144
    //   1462: iconst_2
    //   1463: new 33	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1470: ldc_w 282
    //   1473: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: iload_3
    //   1477: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1486: aload 15
    //   1488: iload_3
    //   1489: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1492: aload 17
    //   1494: invokeinterface 292 3 0
    //   1499: pop
    //   1500: aload 15
    //   1502: monitorexit
    //   1503: aload 9
    //   1505: astore 11
    //   1507: aload 10
    //   1509: astore 12
    //   1511: aload 8
    //   1513: astore 13
    //   1515: iload 7
    //   1517: istore 5
    //   1519: aload 14
    //   1521: monitorenter
    //   1522: aload_0
    //   1523: aload_0
    //   1524: getfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   1527: iconst_1
    //   1528: iadd
    //   1529: putfield 79	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:bRs	I
    //   1532: aload 14
    //   1534: monitorexit
    //   1535: aload 9
    //   1537: astore 11
    //   1539: aload 10
    //   1541: astore 12
    //   1543: aload 8
    //   1545: astore 13
    //   1547: iload 7
    //   1549: istore 5
    //   1551: aload 17
    //   1553: bipush 16
    //   1555: aconst_null
    //   1556: iconst_1
    //   1557: invokestatic 296	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1560: iload_3
    //   1561: iconst_1
    //   1562: iadd
    //   1563: istore_3
    //   1564: goto -1458 -> 106
    //   1567: astore_2
    //   1568: aload 15
    //   1570: monitorexit
    //   1571: aload 9
    //   1573: astore 11
    //   1575: aload 10
    //   1577: astore 12
    //   1579: aload 8
    //   1581: astore 13
    //   1583: iload 7
    //   1585: istore 5
    //   1587: aload_2
    //   1588: athrow
    //   1589: astore_2
    //   1590: iconst_1
    //   1591: istore 5
    //   1593: goto -292 -> 1301
    //   1596: astore_2
    //   1597: aload 14
    //   1599: monitorexit
    //   1600: aload 9
    //   1602: astore 11
    //   1604: aload 10
    //   1606: astore 12
    //   1608: aload 8
    //   1610: astore 13
    //   1612: iload 7
    //   1614: istore 5
    //   1616: aload_2
    //   1617: athrow
    //   1618: astore_2
    //   1619: aload 13
    //   1621: astore 8
    //   1623: aload 12
    //   1625: astore 10
    //   1627: aload 11
    //   1629: astore 9
    //   1631: aload 9
    //   1633: ifnull +8 -> 1641
    //   1636: aload 9
    //   1638: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   1641: aload 8
    //   1643: ifnull +8 -> 1651
    //   1646: aload 8
    //   1648: invokevirtual 198	java/io/FileInputStream:close	()V
    //   1651: aload 10
    //   1653: ifnull +8 -> 1661
    //   1656: aload 10
    //   1658: invokevirtual 199	java/io/InputStream:close	()V
    //   1661: iload 5
    //   1663: ifne +29 -> 1692
    //   1666: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1669: ifeq +11 -> 1680
    //   1672: ldc 144
    //   1674: iconst_2
    //   1675: ldc 201
    //   1677: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1680: aload_1
    //   1681: invokestatic 207	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   1684: pop
    //   1685: aload 14
    //   1687: invokeinterface 210 1 0
    //   1692: aload_2
    //   1693: athrow
    //   1694: astore 10
    //   1696: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1699: ifeq -1342 -> 357
    //   1702: ldc 144
    //   1704: iconst_2
    //   1705: new 33	java/lang/StringBuilder
    //   1708: dup
    //   1709: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1712: ldc_w 298
    //   1715: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: aload 10
    //   1720: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1723: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1726: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1729: goto -1372 -> 357
    //   1732: astore 10
    //   1734: aload 14
    //   1736: monitorexit
    //   1737: aload 10
    //   1739: athrow
    //   1740: astore 11
    //   1742: aload_2
    //   1743: astore 10
    //   1745: aload 9
    //   1747: astore_2
    //   1748: aload 11
    //   1750: astore 9
    //   1752: goto -806 -> 946
    //   1755: astore_2
    //   1756: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1759: ifeq -1334 -> 425
    //   1762: ldc 144
    //   1764: iconst_2
    //   1765: new 33	java/lang/StringBuilder
    //   1768: dup
    //   1769: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1772: ldc_w 300
    //   1775: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: aload_2
    //   1779: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1782: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1785: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1788: goto -1363 -> 425
    //   1791: astore_2
    //   1792: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1795: ifeq -782 -> 1013
    //   1798: ldc 144
    //   1800: iconst_2
    //   1801: new 33	java/lang/StringBuilder
    //   1804: dup
    //   1805: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1808: ldc_w 300
    //   1811: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: aload_2
    //   1815: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1818: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1821: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1824: goto -811 -> 1013
    //   1827: astore_2
    //   1828: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1831: ifeq -429 -> 1402
    //   1834: ldc 144
    //   1836: iconst_2
    //   1837: new 33	java/lang/StringBuilder
    //   1840: dup
    //   1841: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1844: ldc_w 300
    //   1847: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: aload_2
    //   1851: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1854: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1860: goto -458 -> 1402
    //   1863: astore 8
    //   1865: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1868: ifeq -207 -> 1661
    //   1871: ldc 144
    //   1873: iconst_2
    //   1874: new 33	java/lang/StringBuilder
    //   1877: dup
    //   1878: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1881: ldc_w 300
    //   1884: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1887: aload 8
    //   1889: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1892: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1895: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1898: goto -237 -> 1661
    //   1901: aload 14
    //   1903: areturn
    //   1904: astore_2
    //   1905: aconst_null
    //   1906: astore 9
    //   1908: aconst_null
    //   1909: astore 8
    //   1911: aconst_null
    //   1912: astore 10
    //   1914: goto -283 -> 1631
    //   1917: astore_2
    //   1918: aconst_null
    //   1919: astore 9
    //   1921: aconst_null
    //   1922: astore 10
    //   1924: goto -293 -> 1631
    //   1927: astore_2
    //   1928: aconst_null
    //   1929: astore 10
    //   1931: goto -300 -> 1631
    //   1934: astore 11
    //   1936: iload 6
    //   1938: istore 5
    //   1940: aload_2
    //   1941: astore 10
    //   1943: aload 11
    //   1945: astore_2
    //   1946: goto -315 -> 1631
    //   1949: astore 11
    //   1951: aload_2
    //   1952: astore 9
    //   1954: aload 11
    //   1956: astore_2
    //   1957: iload 6
    //   1959: istore 5
    //   1961: goto -330 -> 1631
    //   1964: astore_2
    //   1965: goto -334 -> 1631
    //   1968: astore_2
    //   1969: aconst_null
    //   1970: astore 9
    //   1972: aconst_null
    //   1973: astore 8
    //   1975: aconst_null
    //   1976: astore 10
    //   1978: iconst_1
    //   1979: istore 5
    //   1981: goto -680 -> 1301
    //   1984: astore_2
    //   1985: iconst_1
    //   1986: istore 5
    //   1988: aconst_null
    //   1989: astore 9
    //   1991: aconst_null
    //   1992: astore 10
    //   1994: goto -693 -> 1301
    //   1997: astore_2
    //   1998: iconst_1
    //   1999: istore 5
    //   2001: aconst_null
    //   2002: astore 10
    //   2004: goto -703 -> 1301
    //   2007: astore 11
    //   2009: iload 5
    //   2011: istore 7
    //   2013: iload 6
    //   2015: istore 5
    //   2017: aload_2
    //   2018: astore 10
    //   2020: aload 11
    //   2022: astore_2
    //   2023: iload 7
    //   2025: istore 6
    //   2027: goto -726 -> 1301
    //   2030: astore 9
    //   2032: aconst_null
    //   2033: astore_2
    //   2034: aconst_null
    //   2035: astore 8
    //   2037: aconst_null
    //   2038: astore 10
    //   2040: iconst_0
    //   2041: istore 5
    //   2043: goto -1097 -> 946
    //   2046: astore 9
    //   2048: iconst_0
    //   2049: istore 5
    //   2051: aconst_null
    //   2052: astore_2
    //   2053: aconst_null
    //   2054: astore 10
    //   2056: goto -1110 -> 946
    //   2059: astore 11
    //   2061: iconst_0
    //   2062: istore 5
    //   2064: aload 9
    //   2066: astore_2
    //   2067: aconst_null
    //   2068: astore 10
    //   2070: aload 11
    //   2072: astore 9
    //   2074: goto -1128 -> 946
    //   2077: iconst_0
    //   2078: istore 5
    //   2080: aload 10
    //   2082: astore_2
    //   2083: iconst_1
    //   2084: istore 6
    //   2086: goto -1844 -> 242
    //   2089: iconst_1
    //   2090: istore 5
    //   2092: aload 10
    //   2094: astore_2
    //   2095: iconst_1
    //   2096: istore 6
    //   2098: goto -1856 -> 242
    //   2101: goto -1230 -> 871
    //   2104: iconst_0
    //   2105: istore 5
    //   2107: iconst_1
    //   2108: istore 6
    //   2110: aconst_null
    //   2111: astore_2
    //   2112: goto -1870 -> 242
    //   2115: iconst_0
    //   2116: istore 5
    //   2118: aload 10
    //   2120: astore_2
    //   2121: iconst_0
    //   2122: istore 6
    //   2124: goto -1882 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2127	0	this	LoadDataJob
    //   0	2127	1	paramString	String
    //   0	2127	2	parama	a
    //   105	1459	3	i	int
    //   155	523	4	j	int
    //   20	2097	5	bool1	boolean
    //   26	2097	6	bool2	boolean
    //   23	2001	7	bool3	boolean
    //   50	1597	8	localObject1	Object
    //   1863	25	8	localException1	Exception
    //   1909	127	8	localObject2	Object
    //   65	1925	9	localObject3	Object
    //   2030	1	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2046	19	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   2072	1	9	localObject4	Object
    //   81	1576	10	localObject5	Object
    //   1694	25	10	localException2	Exception
    //   1732	6	10	localObject6	Object
    //   1743	376	10	locala	a
    //   85	723	11	localObject7	Object
    //   874	25	11	localException3	Exception
    //   918	1	11	localObject8	Object
    //   934	9	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1058	184	11	localObject9	Object
    //   1257	9	11	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1278	350	11	localObject10	Object
    //   1740	9	11	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1934	10	11	localObject11	Object
    //   1949	6	11	localObject12	Object
    //   2007	14	11	localException4	Exception
    //   2059	12	11	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   89	1535	12	localObject13	Object
    //   93	1527	13	localObject14	Object
    //   7	1895	14	localArrayList	ArrayList
    //   35	1534	15	localHashMap	HashMap
    //   102	48	16	arrayOfByte	byte[]
    //   505	1047	17	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   680	717	874	java/lang/Exception
    //   717	725	874	java/lang/Exception
    //   665	674	912	finally
    //   680	717	912	finally
    //   717	725	912	finally
    //   725	728	912	finally
    //   876	909	912	finally
    //   913	916	912	finally
    //   99	104	934	java/lang/OutOfMemoryError
    //   122	133	934	java/lang/OutOfMemoryError
    //   149	157	934	java/lang/OutOfMemoryError
    //   185	191	934	java/lang/OutOfMemoryError
    //   207	233	934	java/lang/OutOfMemoryError
    //   501	507	934	java/lang/OutOfMemoryError
    //   523	538	934	java/lang/OutOfMemoryError
    //   554	560	934	java/lang/OutOfMemoryError
    //   576	602	934	java/lang/OutOfMemoryError
    //   621	646	934	java/lang/OutOfMemoryError
    //   662	665	934	java/lang/OutOfMemoryError
    //   744	757	934	java/lang/OutOfMemoryError
    //   773	779	934	java/lang/OutOfMemoryError
    //   795	803	934	java/lang/OutOfMemoryError
    //   932	934	934	java/lang/OutOfMemoryError
    //   1451	1454	934	java/lang/OutOfMemoryError
    //   1519	1522	934	java/lang/OutOfMemoryError
    //   1551	1560	934	java/lang/OutOfMemoryError
    //   1587	1589	934	java/lang/OutOfMemoryError
    //   1616	1618	934	java/lang/OutOfMemoryError
    //   824	837	1235	finally
    //   837	862	1235	finally
    //   1046	1056	1235	finally
    //   1236	1239	1235	finally
    //   821	824	1257	java/lang/OutOfMemoryError
    //   1072	1078	1257	java/lang/OutOfMemoryError
    //   1094	1120	1257	java/lang/OutOfMemoryError
    //   1140	1143	1257	java/lang/OutOfMemoryError
    //   1172	1178	1257	java/lang/OutOfMemoryError
    //   1194	1223	1257	java/lang/OutOfMemoryError
    //   1255	1257	1257	java/lang/OutOfMemoryError
    //   1292	1294	1257	java/lang/OutOfMemoryError
    //   1143	1156	1272	finally
    //   1273	1276	1272	finally
    //   821	824	1294	java/lang/Exception
    //   1072	1078	1294	java/lang/Exception
    //   1094	1120	1294	java/lang/Exception
    //   1140	1143	1294	java/lang/Exception
    //   1172	1178	1294	java/lang/Exception
    //   1194	1223	1294	java/lang/Exception
    //   1255	1257	1294	java/lang/Exception
    //   1292	1294	1294	java/lang/Exception
    //   1454	1486	1567	finally
    //   1486	1503	1567	finally
    //   1568	1571	1567	finally
    //   99	104	1589	java/lang/Exception
    //   122	133	1589	java/lang/Exception
    //   149	157	1589	java/lang/Exception
    //   185	191	1589	java/lang/Exception
    //   207	233	1589	java/lang/Exception
    //   501	507	1589	java/lang/Exception
    //   523	538	1589	java/lang/Exception
    //   554	560	1589	java/lang/Exception
    //   576	602	1589	java/lang/Exception
    //   621	646	1589	java/lang/Exception
    //   662	665	1589	java/lang/Exception
    //   744	757	1589	java/lang/Exception
    //   773	779	1589	java/lang/Exception
    //   795	803	1589	java/lang/Exception
    //   932	934	1589	java/lang/Exception
    //   1451	1454	1589	java/lang/Exception
    //   1519	1522	1589	java/lang/Exception
    //   1551	1560	1589	java/lang/Exception
    //   1587	1589	1589	java/lang/Exception
    //   1616	1618	1589	java/lang/Exception
    //   1522	1535	1596	finally
    //   1597	1600	1596	finally
    //   99	104	1618	finally
    //   122	133	1618	finally
    //   149	157	1618	finally
    //   185	191	1618	finally
    //   207	233	1618	finally
    //   501	507	1618	finally
    //   523	538	1618	finally
    //   554	560	1618	finally
    //   576	602	1618	finally
    //   621	646	1618	finally
    //   662	665	1618	finally
    //   744	757	1618	finally
    //   773	779	1618	finally
    //   795	803	1618	finally
    //   821	824	1618	finally
    //   932	934	1618	finally
    //   1072	1078	1618	finally
    //   1094	1120	1618	finally
    //   1140	1143	1618	finally
    //   1172	1178	1618	finally
    //   1194	1223	1618	finally
    //   1255	1257	1618	finally
    //   1292	1294	1618	finally
    //   1324	1330	1618	finally
    //   1346	1372	1618	finally
    //   1451	1454	1618	finally
    //   1519	1522	1618	finally
    //   1551	1560	1618	finally
    //   1587	1589	1618	finally
    //   1616	1618	1618	finally
    //   349	357	1694	java/lang/Exception
    //   245	324	1732	finally
    //   324	338	1732	finally
    //   349	357	1732	finally
    //   357	380	1732	finally
    //   380	383	1732	finally
    //   1696	1729	1732	finally
    //   1734	1737	1732	finally
    //   242	245	1740	java/lang/OutOfMemoryError
    //   383	397	1740	java/lang/OutOfMemoryError
    //   1737	1740	1740	java/lang/OutOfMemoryError
    //   402	407	1755	java/lang/Exception
    //   412	417	1755	java/lang/Exception
    //   421	425	1755	java/lang/Exception
    //   989	993	1791	java/lang/Exception
    //   998	1003	1791	java/lang/Exception
    //   1008	1013	1791	java/lang/Exception
    //   1377	1382	1827	java/lang/Exception
    //   1387	1392	1827	java/lang/Exception
    //   1397	1402	1827	java/lang/Exception
    //   1636	1641	1863	java/lang/Exception
    //   1646	1651	1863	java/lang/Exception
    //   1656	1661	1863	java/lang/Exception
    //   37	52	1904	finally
    //   52	67	1917	finally
    //   72	83	1927	finally
    //   242	245	1934	finally
    //   383	397	1934	finally
    //   1737	1740	1934	finally
    //   949	985	1949	finally
    //   1301	1305	1964	finally
    //   37	52	1968	java/lang/Exception
    //   52	67	1984	java/lang/Exception
    //   72	83	1997	java/lang/Exception
    //   242	245	2007	java/lang/Exception
    //   383	397	2007	java/lang/Exception
    //   1737	1740	2007	java/lang/Exception
    //   37	52	2030	java/lang/OutOfMemoryError
    //   52	67	2046	java/lang/OutOfMemoryError
    //   72	83	2059	java/lang/OutOfMemoryError
  }
  
  private List<wsa> a(List<wrx> paramList, Rect paramRect)
  {
    Object localObject1 = paramList.iterator();
    long l = 0L;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (wrx)((Iterator)localObject1).next();
      if (((wrx)localObject2).b() == null) {
        break label251;
      }
      l = ((wrx)localObject2).b().getTime() + l;
    }
    label251:
    for (;;)
    {
      break;
      int i;
      int j;
      if (l <= 3000L)
      {
        i = 10;
        j = 30;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadDataJob", 2, "setPathDatas params: totaltime:" + l + "  segmentLen:" + i + " timeInterval:" + j);
        }
        localObject1 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = new wsa((wrx)paramList.next(), paramRect.width(), paramRect.height(), this.mWidth, this.mHeight, i, j, 1.0F);
          if (localObject2 != null) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        if (l <= 20000L)
        {
          i = 20;
          j = 37;
        }
        else
        {
          i = 50;
          j = 45;
        }
      }
      Collections.sort((List)localObject1, new b());
      return localObject1;
    }
  }
  
  private Map<Integer, Integer> a(List<wsa> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((wsa)paramList.next()).getTexture();
      if (i > 0) {
        if (!wrq.a().ax(0, i)) {
          localHashMap.put(Integer.valueOf(i), Integer.valueOf(4));
        } else {
          localHashMap.put(Integer.valueOf(i), Integer.valueOf(0));
        }
      }
    }
    return localHashMap;
  }
  
  /* Error */
  private wro a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_1
    //   6: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 103	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 106	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 110	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   29: lconst_0
    //   30: ldc2_w 111
    //   33: iconst_1
    //   34: invokevirtual 118	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   37: astore 4
    //   39: aload 4
    //   41: astore 6
    //   43: aload 6
    //   45: ifnull +645 -> 690
    //   48: new 120	java/io/BufferedInputStream
    //   51: dup
    //   52: aload 7
    //   54: invokespecial 123	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 5
    //   59: iconst_4
    //   60: newarray byte
    //   62: astore 4
    //   64: aload 5
    //   66: aload 4
    //   68: invokevirtual 129	java/io/InputStream:read	([B)I
    //   71: iconst_4
    //   72: if_icmpne +612 -> 684
    //   75: aload 4
    //   77: iconst_0
    //   78: invokestatic 135	wre:bytesToInt	([BI)I
    //   81: istore_3
    //   82: iload_3
    //   83: ifle +9 -> 92
    //   86: iload_3
    //   87: ldc 136
    //   89: if_icmplt +105 -> 194
    //   92: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +29 -> 124
    //   98: ldc 144
    //   100: iconst_2
    //   101: new 33	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 363
    //   111: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload_3
    //   115: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: iconst_0
    //   125: istore_2
    //   126: aconst_null
    //   127: astore 4
    //   129: aload 6
    //   131: ifnull +8 -> 139
    //   134: aload 6
    //   136: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   139: aload 7
    //   141: ifnull +8 -> 149
    //   144: aload 7
    //   146: invokevirtual 198	java/io/FileInputStream:close	()V
    //   149: aload 5
    //   151: ifnull +8 -> 159
    //   154: aload 5
    //   156: invokevirtual 199	java/io/InputStream:close	()V
    //   159: aload 4
    //   161: astore 5
    //   163: iload_2
    //   164: ifne +27 -> 191
    //   167: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +12 -> 182
    //   173: ldc 144
    //   175: iconst_2
    //   176: ldc_w 365
    //   179: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_1
    //   183: invokestatic 207	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   186: pop
    //   187: aload 4
    //   189: astore 5
    //   191: aload 5
    //   193: areturn
    //   194: iload_3
    //   195: newarray byte
    //   197: astore 4
    //   199: aload 5
    //   201: aload 4
    //   203: iconst_0
    //   204: iload_3
    //   205: invokevirtual 215	java/io/InputStream:read	([BII)I
    //   208: iload_3
    //   209: if_icmpeq +38 -> 247
    //   212: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +484 -> 699
    //   218: ldc 144
    //   220: iconst_2
    //   221: new 33	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 367
    //   231: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: iload_3
    //   235: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto +455 -> 699
    //   247: aload_0
    //   248: aload 4
    //   250: invokevirtual 370	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	([B)Lwru;
    //   253: astore 4
    //   255: aload 4
    //   257: ifnull +427 -> 684
    //   260: getstatic 375	wro:a	Lwrv$a;
    //   263: aload 4
    //   265: invokeinterface 380 2 0
    //   270: checkcast 372	wro
    //   273: astore 4
    //   275: goto -146 -> 129
    //   278: astore 5
    //   280: aload 5
    //   282: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   285: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq -129 -> 159
    //   291: ldc 144
    //   293: iconst_2
    //   294: new 33	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 300
    //   304: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 5
    //   309: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: goto -159 -> 159
    //   321: astore 7
    //   323: aconst_null
    //   324: astore 6
    //   326: aconst_null
    //   327: astore 4
    //   329: aconst_null
    //   330: astore 5
    //   332: aload 7
    //   334: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   337: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +30 -> 370
    //   343: ldc 144
    //   345: iconst_2
    //   346: new 33	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 382
    //   356: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 7
    //   361: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload 6
    //   372: ifnull +8 -> 380
    //   375: aload 6
    //   377: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   380: aload 4
    //   382: ifnull +8 -> 390
    //   385: aload 4
    //   387: invokevirtual 198	java/io/FileInputStream:close	()V
    //   390: aload 5
    //   392: ifnull +8 -> 400
    //   395: aload 5
    //   397: invokevirtual 199	java/io/InputStream:close	()V
    //   400: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +12 -> 415
    //   406: ldc 144
    //   408: iconst_2
    //   409: ldc_w 365
    //   412: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: aload_1
    //   416: invokestatic 207	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   419: pop
    //   420: aconst_null
    //   421: astore 5
    //   423: goto -232 -> 191
    //   426: astore 4
    //   428: aload 4
    //   430: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   433: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq -36 -> 400
    //   439: ldc 144
    //   441: iconst_2
    //   442: new 33	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 300
    //   452: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 4
    //   457: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: goto -66 -> 400
    //   469: astore 4
    //   471: iconst_1
    //   472: istore_2
    //   473: aconst_null
    //   474: astore 7
    //   476: aconst_null
    //   477: astore 5
    //   479: aload 6
    //   481: ifnull +8 -> 489
    //   484: aload 6
    //   486: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   489: aload 7
    //   491: ifnull +8 -> 499
    //   494: aload 7
    //   496: invokevirtual 198	java/io/FileInputStream:close	()V
    //   499: aload 5
    //   501: ifnull +8 -> 509
    //   504: aload 5
    //   506: invokevirtual 199	java/io/InputStream:close	()V
    //   509: iload_2
    //   510: ifne +23 -> 533
    //   513: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq +12 -> 528
    //   519: ldc 144
    //   521: iconst_2
    //   522: ldc_w 365
    //   525: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: aload_1
    //   529: invokestatic 207	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   532: pop
    //   533: aload 4
    //   535: athrow
    //   536: astore 5
    //   538: aload 5
    //   540: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   543: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq -37 -> 509
    //   549: ldc 144
    //   551: iconst_2
    //   552: new 33	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 300
    //   562: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload 5
    //   567: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: goto -67 -> 509
    //   579: astore 4
    //   581: iconst_1
    //   582: istore_2
    //   583: aconst_null
    //   584: astore 5
    //   586: goto -107 -> 479
    //   589: astore 4
    //   591: aconst_null
    //   592: astore 5
    //   594: iconst_1
    //   595: istore_2
    //   596: goto -117 -> 479
    //   599: astore 4
    //   601: iconst_1
    //   602: istore_2
    //   603: goto -124 -> 479
    //   606: astore 8
    //   608: aload 4
    //   610: astore 7
    //   612: iconst_1
    //   613: istore_2
    //   614: aload 8
    //   616: astore 4
    //   618: goto -139 -> 479
    //   621: astore 8
    //   623: aload 4
    //   625: astore 7
    //   627: iconst_0
    //   628: istore_2
    //   629: aload 8
    //   631: astore 4
    //   633: goto -154 -> 479
    //   636: astore 8
    //   638: aconst_null
    //   639: astore 6
    //   641: aload 7
    //   643: astore 4
    //   645: aconst_null
    //   646: astore 5
    //   648: aload 8
    //   650: astore 7
    //   652: goto -320 -> 332
    //   655: astore 8
    //   657: aload 7
    //   659: astore 4
    //   661: aconst_null
    //   662: astore 5
    //   664: aload 8
    //   666: astore 7
    //   668: goto -336 -> 332
    //   671: astore 8
    //   673: aload 7
    //   675: astore 4
    //   677: aload 8
    //   679: astore 7
    //   681: goto -349 -> 332
    //   684: aconst_null
    //   685: astore 4
    //   687: goto -558 -> 129
    //   690: aconst_null
    //   691: astore 5
    //   693: aconst_null
    //   694: astore 4
    //   696: goto -567 -> 129
    //   699: iconst_0
    //   700: istore_2
    //   701: aconst_null
    //   702: astore 4
    //   704: goto -575 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	LoadDataJob
    //   0	707	1	paramString	String
    //   1	700	2	i	int
    //   81	154	3	j	int
    //   37	349	4	localObject1	Object
    //   426	30	4	localException1	Exception
    //   469	65	4	localObject2	Object
    //   579	1	4	localObject3	Object
    //   589	1	4	localObject4	Object
    //   599	10	4	localObject5	Object
    //   616	87	4	localObject6	Object
    //   57	143	5	localObject7	Object
    //   278	30	5	localException2	Exception
    //   330	175	5	localObject8	Object
    //   536	30	5	localException3	Exception
    //   584	108	5	localObject9	Object
    //   3	637	6	localObject10	Object
    //   22	123	7	localFileInputStream	java.io.FileInputStream
    //   321	39	7	localException4	Exception
    //   474	206	7	localObject11	Object
    //   606	9	8	localObject12	Object
    //   621	9	8	localObject13	Object
    //   636	13	8	localException5	Exception
    //   655	10	8	localException6	Exception
    //   671	7	8	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   134	139	278	java/lang/Exception
    //   144	149	278	java/lang/Exception
    //   154	159	278	java/lang/Exception
    //   14	24	321	java/lang/Exception
    //   375	380	426	java/lang/Exception
    //   385	390	426	java/lang/Exception
    //   395	400	426	java/lang/Exception
    //   14	24	469	finally
    //   484	489	536	java/lang/Exception
    //   494	499	536	java/lang/Exception
    //   504	509	536	java/lang/Exception
    //   24	39	579	finally
    //   48	59	589	finally
    //   59	82	599	finally
    //   92	124	599	finally
    //   194	244	599	finally
    //   247	255	599	finally
    //   260	275	599	finally
    //   332	337	606	finally
    //   337	370	621	finally
    //   24	39	636	java/lang/Exception
    //   48	59	655	java/lang/Exception
    //   59	82	671	java/lang/Exception
    //   92	124	671	java/lang/Exception
    //   194	244	671	java/lang/Exception
    //   247	255	671	java/lang/Exception
    //   260	275	671	java/lang/Exception
  }
  
  private String n(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = aUa + paramString.substring(paramString.lastIndexOf(File.separator) + 1, paramString.lastIndexOf('_')) + "_dwr";
        if (paramBoolean)
        {
          paramBoolean = aqhq.fileExists(paramString);
          if (paramBoolean) {
            return paramString;
          }
        }
        else
        {
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  private String o(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = aUa + paramString.substring(paramString.lastIndexOf(File.separator) + 1, paramString.lastIndexOf('_')) + "_prm";
        if (paramBoolean)
        {
          paramBoolean = aqhq.fileExists(paramString);
          if (paramBoolean) {
            return paramString;
          }
        }
        else
        {
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public wru.a a(wrv paramwrv)
  {
    wru localwru = new wru(102400);
    paramwrv.a(localwru, 0);
    return localwru.a();
  }
  
  public wru a(byte[] paramArrayOfByte)
  {
    wru localwru = new wru(0);
    localwru.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    return localwru;
  }
  
  /* Error */
  public void a(wro paramwro, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 7
    //   17: aload_1
    //   18: ifnull +10 -> 28
    //   21: aload_2
    //   22: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +4 -> 29
    //   28: return
    //   29: aload_2
    //   30: invokestatic 403	aqhq:fileExists	(Ljava/lang/String;)Z
    //   33: ifne -5 -> 28
    //   36: new 33	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   43: aload_2
    //   44: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 429
    //   50: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 10
    //   58: new 431	java/io/FileOutputStream
    //   61: dup
    //   62: aload 10
    //   64: invokespecial 432	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   67: astore 5
    //   69: aload 4
    //   71: astore_3
    //   72: aload 5
    //   74: astore 4
    //   76: aload 9
    //   78: astore 6
    //   80: aload 8
    //   82: astore 7
    //   84: aload 5
    //   86: invokevirtual 433	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   89: invokevirtual 436	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   92: astore 8
    //   94: aload 8
    //   96: ifnull +105 -> 201
    //   99: aload 8
    //   101: astore_3
    //   102: aload 5
    //   104: astore 4
    //   106: aload 8
    //   108: astore 6
    //   110: aload 8
    //   112: astore 7
    //   114: aload 5
    //   116: invokevirtual 433	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   119: lconst_0
    //   120: invokevirtual 440	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   123: pop
    //   124: aload 8
    //   126: astore_3
    //   127: aload 5
    //   129: astore 4
    //   131: aload 8
    //   133: astore 6
    //   135: aload 8
    //   137: astore 7
    //   139: aload_0
    //   140: aload_1
    //   141: invokevirtual 442	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Lwrv;)Lwru$a;
    //   144: astore_1
    //   145: aload 8
    //   147: astore_3
    //   148: aload 5
    //   150: astore 4
    //   152: aload 8
    //   154: astore 6
    //   156: aload 8
    //   158: astore 7
    //   160: aload 5
    //   162: aload_1
    //   163: getfield 447	wru$a:bRu	I
    //   166: invokestatic 451	wre:intToBytes	(I)[B
    //   169: invokevirtual 455	java/io/FileOutputStream:write	([B)V
    //   172: aload 8
    //   174: astore_3
    //   175: aload 5
    //   177: astore 4
    //   179: aload 8
    //   181: astore 6
    //   183: aload 8
    //   185: astore 7
    //   187: aload 5
    //   189: aload_1
    //   190: getfield 459	wru$a:mData	[B
    //   193: iconst_0
    //   194: aload_1
    //   195: getfield 447	wru$a:bRu	I
    //   198: invokevirtual 461	java/io/FileOutputStream:write	([BII)V
    //   201: aload 8
    //   203: ifnull +8 -> 211
    //   206: aload 8
    //   208: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   211: aload 5
    //   213: ifnull +8 -> 221
    //   216: aload 5
    //   218: invokevirtual 462	java/io/FileOutputStream:close	()V
    //   221: aload 10
    //   223: aload_2
    //   224: invokestatic 466	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   227: pop
    //   228: return
    //   229: astore_1
    //   230: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -12 -> 221
    //   236: ldc 144
    //   238: iconst_2
    //   239: new 33	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 468
    //   249: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -41 -> 221
    //   265: astore_1
    //   266: aconst_null
    //   267: astore 5
    //   269: aload 7
    //   271: astore_3
    //   272: aload 5
    //   274: astore 4
    //   276: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +36 -> 315
    //   282: aload 7
    //   284: astore_3
    //   285: aload 5
    //   287: astore 4
    //   289: ldc 144
    //   291: iconst_2
    //   292: new 33	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 470
    //   302: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_1
    //   306: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload 7
    //   317: ifnull +8 -> 325
    //   320: aload 7
    //   322: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   325: aload 5
    //   327: ifnull +8 -> 335
    //   330: aload 5
    //   332: invokevirtual 462	java/io/FileOutputStream:close	()V
    //   335: aload 10
    //   337: aload_2
    //   338: invokestatic 466	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   341: pop
    //   342: return
    //   343: astore_1
    //   344: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -12 -> 335
    //   350: ldc 144
    //   352: iconst_2
    //   353: new 33	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 468
    //   363: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_1
    //   367: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: goto -41 -> 335
    //   379: astore_1
    //   380: aconst_null
    //   381: astore 5
    //   383: aload 6
    //   385: astore_3
    //   386: aload 5
    //   388: astore 4
    //   390: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +36 -> 429
    //   396: aload 6
    //   398: astore_3
    //   399: aload 5
    //   401: astore 4
    //   403: ldc 144
    //   405: iconst_2
    //   406: new 33	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 472
    //   416: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_1
    //   420: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload 6
    //   431: ifnull +8 -> 439
    //   434: aload 6
    //   436: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   439: aload 5
    //   441: ifnull +8 -> 449
    //   444: aload 5
    //   446: invokevirtual 462	java/io/FileOutputStream:close	()V
    //   449: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq -424 -> 28
    //   455: ldc 144
    //   457: iconst_2
    //   458: ldc_w 474
    //   461: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: return
    //   465: astore_1
    //   466: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq -20 -> 449
    //   472: ldc 144
    //   474: iconst_2
    //   475: new 33	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 468
    //   485: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_1
    //   489: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: goto -49 -> 449
    //   501: astore_1
    //   502: aconst_null
    //   503: astore 4
    //   505: aload_3
    //   506: ifnull +7 -> 513
    //   509: aload_3
    //   510: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   513: aload 4
    //   515: ifnull +8 -> 523
    //   518: aload 4
    //   520: invokevirtual 462	java/io/FileOutputStream:close	()V
    //   523: aload 10
    //   525: aload_2
    //   526: invokestatic 466	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   529: pop
    //   530: aload_1
    //   531: athrow
    //   532: astore_3
    //   533: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq -13 -> 523
    //   539: ldc 144
    //   541: iconst_2
    //   542: new 33	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 468
    //   552: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_3
    //   556: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: goto -42 -> 523
    //   568: astore_1
    //   569: goto -64 -> 505
    //   572: astore_1
    //   573: goto -190 -> 383
    //   576: astore_1
    //   577: goto -308 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	this	LoadDataJob
    //   0	580	1	paramwro	wro
    //   0	580	2	paramString	String
    //   4	506	3	localObject1	Object
    //   532	24	3	localException	Exception
    //   6	513	4	localObject2	Object
    //   67	378	5	localFileOutputStream	java.io.FileOutputStream
    //   1	434	6	localObject3	Object
    //   15	306	7	localFileLock1	java.nio.channels.FileLock
    //   12	195	8	localFileLock2	java.nio.channels.FileLock
    //   9	68	9	localObject4	Object
    //   56	468	10	str	String
    // Exception table:
    //   from	to	target	type
    //   206	211	229	java/lang/Exception
    //   216	221	229	java/lang/Exception
    //   58	69	265	java/nio/channels/OverlappingFileLockException
    //   320	325	343	java/lang/Exception
    //   330	335	343	java/lang/Exception
    //   58	69	379	java/lang/Exception
    //   434	439	465	java/lang/Exception
    //   444	449	465	java/lang/Exception
    //   58	69	501	finally
    //   509	513	532	java/lang/Exception
    //   518	523	532	java/lang/Exception
    //   84	94	568	finally
    //   114	124	568	finally
    //   139	145	568	finally
    //   160	172	568	finally
    //   187	201	568	finally
    //   276	282	568	finally
    //   289	315	568	finally
    //   390	396	568	finally
    //   403	429	568	finally
    //   84	94	572	java/lang/Exception
    //   114	124	572	java/lang/Exception
    //   139	145	572	java/lang/Exception
    //   160	172	572	java/lang/Exception
    //   187	201	572	java/lang/Exception
    //   84	94	576	java/nio/channels/OverlappingFileLockException
    //   114	124	576	java/nio/channels/OverlappingFileLockException
    //   139	145	576	java/nio/channels/OverlappingFileLockException
    //   160	172	576	java/nio/channels/OverlappingFileLockException
    //   187	201	576	java/nio/channels/OverlappingFileLockException
  }
  
  /* Error */
  public boolean e(List<wsa> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_1
    //   16: ifnull +19 -> 35
    //   19: aload_1
    //   20: invokeinterface 163 1 0
    //   25: ifeq +10 -> 35
    //   28: aload_2
    //   29: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_2
    //   38: invokestatic 403	aqhq:fileExists	(Ljava/lang/String;)Z
    //   41: ifne -6 -> 35
    //   44: new 33	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 429
    //   58: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 11
    //   66: new 431	java/io/FileOutputStream
    //   69: dup
    //   70: aload 11
    //   72: iconst_0
    //   73: invokespecial 478	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   76: astore 4
    //   78: aload 9
    //   80: astore 5
    //   82: aload 4
    //   84: astore 7
    //   86: aload 10
    //   88: astore 8
    //   90: aload 4
    //   92: invokevirtual 433	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   95: astore 12
    //   97: aload 9
    //   99: astore 5
    //   101: aload 4
    //   103: astore 7
    //   105: aload 10
    //   107: astore 8
    //   109: aload 12
    //   111: invokevirtual 436	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +220 -> 338
    //   121: aload 6
    //   123: astore 5
    //   125: aload 4
    //   127: astore 7
    //   129: aload 6
    //   131: astore 8
    //   133: aload 12
    //   135: lconst_0
    //   136: invokevirtual 440	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   139: pop
    //   140: aload 6
    //   142: astore 5
    //   144: aload 4
    //   146: astore 7
    //   148: aload 6
    //   150: astore 8
    //   152: aload_1
    //   153: invokeinterface 304 1 0
    //   158: astore_1
    //   159: aload 6
    //   161: astore 5
    //   163: aload 4
    //   165: astore 7
    //   167: aload 6
    //   169: astore 8
    //   171: aload_1
    //   172: invokeinterface 252 1 0
    //   177: ifeq +161 -> 338
    //   180: aload 6
    //   182: astore 5
    //   184: aload 4
    //   186: astore 7
    //   188: aload 6
    //   190: astore 8
    //   192: aload_0
    //   193: aload_1
    //   194: invokeinterface 256 1 0
    //   199: checkcast 328	wsa
    //   202: invokevirtual 442	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Lwrv;)Lwru$a;
    //   205: astore 9
    //   207: aload 6
    //   209: astore 5
    //   211: aload 4
    //   213: astore 7
    //   215: aload 6
    //   217: astore 8
    //   219: aload 4
    //   221: aload 9
    //   223: getfield 447	wru$a:bRu	I
    //   226: invokestatic 451	wre:intToBytes	(I)[B
    //   229: invokevirtual 455	java/io/FileOutputStream:write	([B)V
    //   232: aload 6
    //   234: astore 5
    //   236: aload 4
    //   238: astore 7
    //   240: aload 6
    //   242: astore 8
    //   244: aload 4
    //   246: aload 9
    //   248: getfield 459	wru$a:mData	[B
    //   251: iconst_0
    //   252: aload 9
    //   254: getfield 447	wru$a:bRu	I
    //   257: invokevirtual 461	java/io/FileOutputStream:write	([BII)V
    //   260: goto -101 -> 159
    //   263: astore 5
    //   265: aload 6
    //   267: astore_1
    //   268: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +30 -> 301
    //   274: ldc 144
    //   276: iconst_2
    //   277: new 33	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 480
    //   287: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 5
    //   292: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   309: aload 4
    //   311: ifnull +8 -> 319
    //   314: aload 4
    //   316: invokevirtual 462	java/io/FileOutputStream:close	()V
    //   319: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +360 -> 682
    //   325: ldc 144
    //   327: iconst_2
    //   328: ldc_w 482
    //   331: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: iconst_0
    //   335: istore_3
    //   336: iload_3
    //   337: ireturn
    //   338: aload 6
    //   340: ifnull +8 -> 348
    //   343: aload 6
    //   345: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   348: aload 4
    //   350: ifnull +8 -> 358
    //   353: aload 4
    //   355: invokevirtual 462	java/io/FileOutputStream:close	()V
    //   358: aload 11
    //   360: aload_2
    //   361: invokestatic 466	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   364: pop
    //   365: iconst_1
    //   366: istore_3
    //   367: goto -31 -> 336
    //   370: astore_1
    //   371: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq -16 -> 358
    //   377: ldc 144
    //   379: iconst_2
    //   380: new 33	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 484
    //   390: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_1
    //   394: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: goto -45 -> 358
    //   406: astore_1
    //   407: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq -91 -> 319
    //   413: ldc 144
    //   415: iconst_2
    //   416: new 33	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   423: ldc_w 484
    //   426: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: goto -120 -> 319
    //   442: astore_1
    //   443: aconst_null
    //   444: astore 4
    //   446: aload 8
    //   448: astore 5
    //   450: aload 4
    //   452: astore 7
    //   454: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +37 -> 494
    //   460: aload 8
    //   462: astore 5
    //   464: aload 4
    //   466: astore 7
    //   468: ldc 144
    //   470: iconst_2
    //   471: new 33	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   478: ldc_w 486
    //   481: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_1
    //   485: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: aload 8
    //   496: ifnull +8 -> 504
    //   499: aload 8
    //   501: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   504: aload 4
    //   506: ifnull +8 -> 514
    //   509: aload 4
    //   511: invokevirtual 462	java/io/FileOutputStream:close	()V
    //   514: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +165 -> 682
    //   520: ldc 144
    //   522: iconst_2
    //   523: ldc_w 482
    //   526: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: iconst_0
    //   530: istore_3
    //   531: goto -195 -> 336
    //   534: astore_1
    //   535: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq -24 -> 514
    //   541: ldc 144
    //   543: iconst_2
    //   544: new 33	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 484
    //   554: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_1
    //   558: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: goto -53 -> 514
    //   570: astore_1
    //   571: aconst_null
    //   572: astore 7
    //   574: aload 5
    //   576: ifnull +8 -> 584
    //   579: aload 5
    //   581: invokevirtual 195	java/nio/channels/FileLock:release	()V
    //   584: aload 7
    //   586: ifnull +8 -> 594
    //   589: aload 7
    //   591: invokevirtual 462	java/io/FileOutputStream:close	()V
    //   594: aload 11
    //   596: aload_2
    //   597: invokestatic 466	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   600: pop
    //   601: aload_1
    //   602: athrow
    //   603: astore 4
    //   605: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq -14 -> 594
    //   611: ldc 144
    //   613: iconst_2
    //   614: new 33	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   621: ldc_w 484
    //   624: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 4
    //   629: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: goto -44 -> 594
    //   641: astore_1
    //   642: goto -68 -> 574
    //   645: astore 6
    //   647: aload_1
    //   648: astore 5
    //   650: aload 6
    //   652: astore_1
    //   653: aload 4
    //   655: astore 7
    //   657: goto -83 -> 574
    //   660: astore_1
    //   661: goto -215 -> 446
    //   664: astore 5
    //   666: aconst_null
    //   667: astore_1
    //   668: aload 6
    //   670: astore 4
    //   672: goto -404 -> 268
    //   675: astore 5
    //   677: aconst_null
    //   678: astore_1
    //   679: goto -411 -> 268
    //   682: iconst_0
    //   683: istore_3
    //   684: goto -348 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	687	0	this	LoadDataJob
    //   0	687	1	paramList	List<wsa>
    //   0	687	2	paramString	String
    //   335	349	3	bool	boolean
    //   76	434	4	localFileOutputStream	java.io.FileOutputStream
    //   603	51	4	localException	Exception
    //   670	1	4	localObject1	Object
    //   4	231	5	localObject2	Object
    //   263	28	5	localOverlappingFileLockException1	java.nio.channels.OverlappingFileLockException
    //   448	201	5	localObject3	Object
    //   664	1	5	localOverlappingFileLockException2	java.nio.channels.OverlappingFileLockException
    //   675	1	5	localOverlappingFileLockException3	java.nio.channels.OverlappingFileLockException
    //   13	331	6	localFileLock	java.nio.channels.FileLock
    //   645	24	6	localObject4	Object
    //   84	572	7	localObject5	Object
    //   1	499	8	localObject6	Object
    //   7	246	9	locala	wru.a
    //   10	96	10	localObject7	Object
    //   64	531	11	str	String
    //   95	39	12	localFileChannel	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   133	140	263	java/nio/channels/OverlappingFileLockException
    //   152	159	263	java/nio/channels/OverlappingFileLockException
    //   171	180	263	java/nio/channels/OverlappingFileLockException
    //   192	207	263	java/nio/channels/OverlappingFileLockException
    //   219	232	263	java/nio/channels/OverlappingFileLockException
    //   244	260	263	java/nio/channels/OverlappingFileLockException
    //   343	348	370	java/lang/Exception
    //   353	358	370	java/lang/Exception
    //   305	309	406	java/lang/Exception
    //   314	319	406	java/lang/Exception
    //   66	78	442	java/lang/Exception
    //   499	504	534	java/lang/Exception
    //   509	514	534	java/lang/Exception
    //   66	78	570	finally
    //   579	584	603	java/lang/Exception
    //   589	594	603	java/lang/Exception
    //   90	97	641	finally
    //   109	116	641	finally
    //   133	140	641	finally
    //   152	159	641	finally
    //   171	180	641	finally
    //   192	207	641	finally
    //   219	232	641	finally
    //   244	260	641	finally
    //   454	460	641	finally
    //   468	494	641	finally
    //   268	301	645	finally
    //   90	97	660	java/lang/Exception
    //   109	116	660	java/lang/Exception
    //   133	140	660	java/lang/Exception
    //   152	159	660	java/lang/Exception
    //   171	180	660	java/lang/Exception
    //   192	207	660	java/lang/Exception
    //   219	232	660	java/lang/Exception
    //   244	260	660	java/lang/Exception
    //   66	78	664	java/nio/channels/OverlappingFileLockException
    //   90	97	675	java/nio/channels/OverlappingFileLockException
    //   109	116	675	java/nio/channels/OverlappingFileLockException
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run  begin");
    }
    Object localObject1 = new File(aUa);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    if (this.mListenerRef != null) {}
    for (a locala = (a)this.mListenerRef.get();; locala = null)
    {
      if (locala == null) {
        QLog.d("LoadDataJob", 2, "mListener == null");
      }
      label669:
      for (;;)
      {
        return;
        if (this.mFile == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "file == null");
          }
          locala.a(null, 4, null, null, null);
          return;
        }
        if (!locala.hG(this.mFile))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "onCheck  false");
          }
        }
        else
        {
          Object localObject3 = n(this.mFile, true);
          Object localObject2 = o(this.mFile, true);
          if (locala.hG(this.mFile))
          {
            Object localObject4;
            label250:
            wsa localwsa;
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "run  read parcel begin");
              }
              localObject1 = a((String)localObject3, locala);
              if ((!locala.hG(this.mFile)) || (localObject1 == null)) {
                continue;
              }
              if (localObject1 != null)
              {
                localObject4 = ((List)localObject1).iterator();
                if (((Iterator)localObject4).hasNext())
                {
                  localwsa = (wsa)((Iterator)localObject4).next();
                  if ((localwsa == null) || (!localwsa.isValid()))
                  {
                    aqhq.deleteFile((String)localObject3);
                    localObject1 = null;
                    label294:
                    localObject2 = a((String)localObject2);
                    if (QLog.isColorLevel()) {
                      QLog.d("LoadDataJob", 2, "run  read parcel end");
                    }
                  }
                }
              }
            }
            for (;;)
            {
              if (!locala.hG(this.mFile)) {
                break label669;
              }
              if ((localObject1 != null) && (localObject2 != null))
              {
                localObject3 = localObject1;
                if (((List)localObject1).size() != 0) {}
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run load file begin:");
                }
                long l1 = System.currentTimeMillis();
                localObject2 = wre.a(this.mFile);
                if (localObject2 == null)
                {
                  locala.a(this.mFile, 4, null, null, null);
                  return;
                  localwsa.C(0, 0, this.mWidth, this.mHeight);
                  break label250;
                }
                localObject1 = ((wrb)localObject2).a();
                if (!locala.hG(this.mFile)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run setpathdata ");
                }
                localObject4 = a(((wrb)localObject2).bI(), ((wrb)localObject2).a().k());
                long l2 = System.currentTimeMillis();
                if (!locala.hG(this.mFile)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run load data time:" + (l2 - l1));
                }
                if (l2 - l1 > 100L)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("LoadDataJob", 2, "need cache:");
                  }
                  ThreadManager.post(new LoadDataJob.1(this, (wro)localObject1, (List)localObject4), 5, null, false);
                }
                localObject2 = localObject1;
                localObject3 = localObject4;
                if (QLog.isColorLevel())
                {
                  QLog.d("LoadDataJob", 2, "run load file end:");
                  localObject3 = localObject4;
                  localObject2 = localObject1;
                }
              }
              if (!locala.hG(this.mFile)) {
                break;
              }
              localObject1 = a((List)localObject3);
              locala.a(this.mFile, 0, (wro)localObject2, (List)localObject3, (Map)localObject1);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("LoadDataJob", 2, "run  end");
              return;
              break label294;
              localObject2 = null;
              localObject1 = null;
            }
          }
        }
      }
    }
  }
  
  class UnmarshallJob
    implements Runnable
  {
    private LoadDataJob.c a;
    private byte[] mData;
    private int mID = -1;
    
    public UnmarshallJob(int paramInt, byte[] paramArrayOfByte, LoadDataJob.c paramc)
    {
      this.mData = paramArrayOfByte;
      this.a = paramc;
      this.mID = paramInt;
    }
    
    public void run()
    {
      if (this.a == null) {
        return;
      }
      if (this.mData == null)
      {
        this.a.a(this.mID, null);
        return;
      }
      try
      {
        Object localObject = LoadDataJob.this.a(this.mData);
        if (localObject != null)
        {
          localObject = (wsa)wsa.a.a((wru)localObject);
          this.a.a(this.mID, (wsa)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UnmarshallJob", 2, "unmarshall  exception:" + LoadDataJob.this.mFile);
        }
        this.a.a(this.mID, null);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, wro paramwro, List<wsa> paramList, Map<Integer, Integer> paramMap);
    
    public abstract boolean hG(String paramString);
  }
  
  public class b
    implements Comparator
  {
    public b() {}
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (wsa)paramObject1;
      paramObject2 = (wsa)paramObject2;
      return paramObject1.mID - paramObject2.mID;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, wsa paramwsa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob
 * JD-Core Version:    0.7.0.1
 */