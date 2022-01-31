package com.tencent.mobileqq.vip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class DownloaderFactory
  implements Manager
{
  public static final int a = 2048;
  static ConnectivityManager a;
  public static final String a;
  public static ConcurrentHashMap a;
  public static boolean a = false;
  public static final int b = 600;
  private static ConcurrentHashMap b;
  public static final int c = 5;
  public static final int d = 3;
  public static final int e = 1;
  public static final int f = 2;
  protected AppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloaderFactory.class.getSimpleName();
    jdField_a_of_type_AndroidNetConnectivityManager = null;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  }
  
  public DownloaderFactory(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    b = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(DownloadTask paramDownloadTask, AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: ldc 86
    //   12: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: bipush 254
    //   17: istore_2
    //   18: aload_0
    //   19: ifnull +280 -> 299
    //   22: iconst_m1
    //   23: istore_2
    //   24: aload_0
    //   25: invokevirtual 94	com/tencent/mobileqq/vip/DownloadTask:a	()Lcom/tencent/mobileqq/vip/DownloadListener;
    //   28: astore 37
    //   30: aload 37
    //   32: ifnull +60 -> 92
    //   35: aload 37
    //   37: aload_0
    //   38: invokevirtual 100	com/tencent/mobileqq/vip/DownloadListener:onStart	(Lcom/tencent/mobileqq/vip/DownloadTask;)Z
    //   41: ifne +51 -> 92
    //   44: aload_0
    //   45: bipush 147
    //   47: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   50: aload 37
    //   52: aload_0
    //   53: invokevirtual 107	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   56: iload_2
    //   57: istore_3
    //   58: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +4793 -> 4854
    //   64: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: iconst_2
    //   68: new 109	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   75: ldc 112
    //   77: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_m1
    //   91: ireturn
    //   92: new 124	org/apache/http/params/BasicHttpParams
    //   95: dup
    //   96: invokespecial 125	org/apache/http/params/BasicHttpParams:<init>	()V
    //   99: astore 38
    //   101: aload 38
    //   103: ldc 127
    //   105: sipush 10000
    //   108: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: invokeinterface 139 3 0
    //   116: pop
    //   117: aload 38
    //   119: ldc 141
    //   121: ldc 142
    //   123: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: invokeinterface 139 3 0
    //   131: pop
    //   132: aload_0
    //   133: getfield 145	com/tencent/mobileqq/vip/DownloadTask:i	Z
    //   136: iconst_1
    //   137: if_icmpne +198 -> 335
    //   140: ldc 147
    //   142: astore 28
    //   144: aload 38
    //   146: ldc 149
    //   148: aload 28
    //   150: invokeinterface 139 3 0
    //   155: pop
    //   156: aload_0
    //   157: getfield 152	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   160: ifnull +15 -> 175
    //   163: aload_0
    //   164: getfield 152	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   167: invokeinterface 158 1 0
    //   172: ifgt +170 -> 342
    //   175: aload_0
    //   176: bipush 149
    //   178: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   181: aload 37
    //   183: ifnull +9 -> 192
    //   186: aload 37
    //   188: aload_0
    //   189: invokevirtual 107	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   192: iload_2
    //   193: istore_3
    //   194: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +4657 -> 4854
    //   200: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   203: iconst_2
    //   204: new 109	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   211: ldc 160
    //   213: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iconst_m1
    //   227: ireturn
    //   228: astore 28
    //   230: new 162	java/util/HashMap
    //   233: dup
    //   234: invokespecial 163	java/util/HashMap:<init>	()V
    //   237: astore_0
    //   238: bipush 141
    //   240: istore_2
    //   241: aload 28
    //   243: instanceof 74
    //   246: ifeq +4148 -> 4394
    //   249: bipush 145
    //   251: istore_2
    //   252: aload_0
    //   253: ldc 165
    //   255: iload_2
    //   256: invokestatic 170	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   259: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   262: pop
    //   263: aload_1
    //   264: ifnull +4523 -> 4787
    //   267: aload_1
    //   268: invokevirtual 178	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   271: astore 28
    //   273: aload_1
    //   274: invokevirtual 181	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   277: invokevirtual 184	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   280: invokestatic 189	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   283: aload 28
    //   285: ldc 191
    //   287: iconst_0
    //   288: lconst_0
    //   289: lconst_0
    //   290: aload_0
    //   291: ldc 193
    //   293: iconst_0
    //   294: invokevirtual 196	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   297: iconst_m1
    //   298: istore_2
    //   299: iload_2
    //   300: istore_3
    //   301: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +4550 -> 4854
    //   307: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   310: iconst_2
    //   311: new 109	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   318: ldc 198
    //   320: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iload_2
    //   324: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: iload_2
    //   334: ireturn
    //   335: ldc 203
    //   337: astore 28
    //   339: goto -195 -> 144
    //   342: aload_0
    //   343: getfield 152	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   346: invokeinterface 158 1 0
    //   351: istore 6
    //   353: iconst_0
    //   354: istore 8
    //   356: aconst_null
    //   357: astore 28
    //   359: aconst_null
    //   360: astore 29
    //   362: aconst_null
    //   363: astore 30
    //   365: sipush 2048
    //   368: istore_3
    //   369: iload 8
    //   371: aload_0
    //   372: getfield 152	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   375: invokeinterface 158 1 0
    //   380: if_icmpge +3846 -> 4226
    //   383: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   386: lstore 24
    //   388: new 4	java/lang/Object
    //   391: dup
    //   392: invokespecial 46	java/lang/Object:<init>	()V
    //   395: astore 39
    //   397: lconst_0
    //   398: lstore 14
    //   400: aload_0
    //   401: getfield 152	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   404: iload 8
    //   406: invokeinterface 213 2 0
    //   411: checkcast 167	java/lang/String
    //   414: astore 31
    //   416: aload_0
    //   417: aload 31
    //   419: putfield 215	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   422: aload_0
    //   423: getfield 218	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   426: aload 31
    //   428: invokeinterface 223 2 0
    //   433: checkcast 225	java/io/File
    //   436: astore 35
    //   438: aload 35
    //   440: ifnull +3753 -> 4193
    //   443: aload 35
    //   445: invokevirtual 229	java/io/File:getParentFile	()Ljava/io/File;
    //   448: astore 40
    //   450: new 225	java/io/File
    //   453: dup
    //   454: aload 40
    //   456: new 109	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   463: aload 35
    //   465: invokevirtual 232	java/io/File:getName	()Ljava/lang/String;
    //   468: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc 234
    //   473: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokespecial 237	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   482: astore 41
    //   484: aload_0
    //   485: getfield 239	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   488: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   491: ifne +4301 -> 4792
    //   494: aload_0
    //   495: getfield 239	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   498: aload 31
    //   500: invokestatic 251	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   503: astore 33
    //   505: new 253	com/tencent/mobileqq/emoticon/DownloadInfo
    //   508: dup
    //   509: aload 33
    //   511: aconst_null
    //   512: iconst_0
    //   513: invokespecial 256	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   516: astore 36
    //   518: iconst_m1
    //   519: istore 9
    //   521: aload 30
    //   523: astore 31
    //   525: iconst_m1
    //   526: istore 4
    //   528: iconst_0
    //   529: istore 26
    //   531: iload_3
    //   532: istore_2
    //   533: lconst_0
    //   534: lstore 14
    //   536: lconst_0
    //   537: lstore 12
    //   539: iload 4
    //   541: istore_3
    //   542: aload 28
    //   544: astore 30
    //   546: aload 29
    //   548: astore 28
    //   550: aload 31
    //   552: astore 29
    //   554: aload 30
    //   556: astore 34
    //   558: aload 36
    //   560: invokevirtual 258	com/tencent/mobileqq/emoticon/DownloadInfo:a	()V
    //   563: aload 40
    //   565: ifnull +628 -> 1193
    //   568: aload 30
    //   570: astore 34
    //   572: aload 40
    //   574: invokevirtual 261	java/io/File:exists	()Z
    //   577: ifne +616 -> 1193
    //   580: aload 30
    //   582: astore 34
    //   584: aload 40
    //   586: invokevirtual 264	java/io/File:mkdirs	()Z
    //   589: istore 27
    //   591: iload 27
    //   593: ifne +600 -> 1193
    //   596: aload 30
    //   598: astore 34
    //   600: aload_0
    //   601: bipush 153
    //   603: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   606: new 76	java/lang/Exception
    //   609: dup
    //   610: new 109	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   617: ldc_w 266
    //   620: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload 40
    //   625: invokevirtual 269	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   628: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokespecial 272	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   637: athrow
    //   638: astore 32
    //   640: aload 30
    //   642: astore 31
    //   644: bipush 153
    //   646: istore 7
    //   648: aload 29
    //   650: astore 30
    //   652: aload 28
    //   654: astore 29
    //   656: iload_2
    //   657: istore 4
    //   659: iconst_1
    //   660: istore_3
    //   661: iconst_0
    //   662: istore 5
    //   664: iload 7
    //   666: istore_2
    //   667: aload 31
    //   669: astore 28
    //   671: aload 32
    //   673: astore 31
    //   675: iconst_0
    //   676: istore 7
    //   678: aload 31
    //   680: instanceof 274
    //   683: ifne +4173 -> 4856
    //   686: aload 31
    //   688: instanceof 276
    //   691: ifne +4165 -> 4856
    //   694: aload 31
    //   696: instanceof 278
    //   699: ifeq +6 -> 705
    //   702: goto +4154 -> 4856
    //   705: aload_0
    //   706: bipush 141
    //   708: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   711: aload 31
    //   713: instanceof 74
    //   716: ifeq +3306 -> 4022
    //   719: aload_0
    //   720: bipush 145
    //   722: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   725: iload 5
    //   727: ifne +18 -> 745
    //   730: iload 7
    //   732: ifeq +13 -> 745
    //   735: iload 26
    //   737: ifeq +3344 -> 4081
    //   740: aload_0
    //   741: iconst_1
    //   742: putfield 280	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   745: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq +58 -> 806
    //   751: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   754: iconst_2
    //   755: new 109	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   762: ldc_w 282
    //   765: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload 33
    //   770: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: ldc_w 284
    //   776: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload 31
    //   781: invokevirtual 287	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   784: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: ldc_w 289
    //   790: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload_0
    //   794: getfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   797: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   800: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: iload_2
    //   807: ifeq +84 -> 891
    //   810: aload_0
    //   811: invokevirtual 291	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   814: ifne +77 -> 891
    //   817: aload_0
    //   818: getfield 293	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   821: ifeq +70 -> 891
    //   824: aload 36
    //   826: getfield 294	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   829: ifeq +3266 -> 4095
    //   832: invokestatic 299	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   835: astore 31
    //   837: aload 31
    //   839: ifnull +18 -> 857
    //   842: aload 31
    //   844: aload 36
    //   846: getfield 301	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   849: aload 36
    //   851: getfield 302	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   854: invokevirtual 305	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   857: aload_1
    //   858: ifnull +3231 -> 4089
    //   861: aload_1
    //   862: invokevirtual 181	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   865: invokevirtual 184	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   868: astore 31
    //   870: aload 36
    //   872: getfield 302	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   875: aload 35
    //   877: invokevirtual 232	java/io/File:getName	()Ljava/lang/String;
    //   880: iconst_m1
    //   881: aload 31
    //   883: invokestatic 308	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   886: aload_0
    //   887: iconst_0
    //   888: putfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   891: iload 9
    //   893: iconst_1
    //   894: iadd
    //   895: istore 9
    //   897: aload 28
    //   899: ifnull +10 -> 909
    //   902: aload 28
    //   904: invokeinterface 315 1 0
    //   909: aload 29
    //   911: ifnull +8 -> 919
    //   914: aload 29
    //   916: invokevirtual 320	java/io/InputStream:close	()V
    //   919: aload 30
    //   921: ifnull +8 -> 929
    //   924: aload 30
    //   926: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   929: aload 28
    //   931: astore 31
    //   933: iload 4
    //   935: istore 7
    //   937: aload 30
    //   939: astore 28
    //   941: iload_3
    //   942: istore 5
    //   944: iload 9
    //   946: istore_3
    //   947: lload 14
    //   949: lstore 16
    //   951: aload 31
    //   953: astore 30
    //   955: lload 12
    //   957: lstore 14
    //   959: iload_2
    //   960: istore 4
    //   962: iload 7
    //   964: istore_2
    //   965: lload 16
    //   967: lstore 12
    //   969: iload 4
    //   971: ifeq +3891 -> 4862
    //   974: iload 5
    //   976: ifne +3886 -> 4862
    //   979: iload_3
    //   980: aload_0
    //   981: getfield 326	com/tencent/mobileqq/vip/DownloadTask:A	I
    //   984: if_icmpge +3878 -> 4862
    //   987: aload_0
    //   988: invokevirtual 291	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   991: ifeq +3830 -> 4821
    //   994: goto +3868 -> 4862
    //   997: aload 37
    //   999: ifnull +9 -> 1008
    //   1002: aload 37
    //   1004: aload_0
    //   1005: invokevirtual 329	com/tencent/mobileqq/vip/DownloadListener:onDoneFile	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   1008: new 162	java/util/HashMap
    //   1011: dup
    //   1012: invokespecial 163	java/util/HashMap:<init>	()V
    //   1015: astore 32
    //   1017: aload 32
    //   1019: ldc_w 331
    //   1022: aload 31
    //   1024: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1027: pop
    //   1028: aload 32
    //   1030: ldc 165
    //   1032: aload_0
    //   1033: getfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   1036: invokestatic 170	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1039: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1042: pop
    //   1043: aload 32
    //   1045: ldc_w 333
    //   1048: iload_3
    //   1049: invokestatic 170	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1052: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1055: pop
    //   1056: aload 32
    //   1058: ldc_w 335
    //   1061: lload 12
    //   1063: invokestatic 338	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1066: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1069: pop
    //   1070: aload 32
    //   1072: ldc_w 340
    //   1075: aload_0
    //   1076: getfield 152	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1079: invokeinterface 158 1 0
    //   1084: invokestatic 170	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1087: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1090: pop
    //   1091: aload 32
    //   1093: ldc_w 342
    //   1096: aload_0
    //   1097: getfield 344	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1100: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1103: pop
    //   1104: iload_2
    //   1105: ifne +4004 -> 5109
    //   1108: iconst_1
    //   1109: istore 26
    //   1111: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   1114: lstore 12
    //   1116: aload_1
    //   1117: ifnull +40 -> 1157
    //   1120: aload_1
    //   1121: invokevirtual 178	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1124: astore 31
    //   1126: aload_1
    //   1127: invokevirtual 181	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1130: invokevirtual 184	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   1133: invokestatic 189	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1136: aload 31
    //   1138: ldc 191
    //   1140: iload 26
    //   1142: lload 12
    //   1144: lload 24
    //   1146: lsub
    //   1147: lload 14
    //   1149: aload 32
    //   1151: ldc 193
    //   1153: iconst_0
    //   1154: invokevirtual 196	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1157: iload_2
    //   1158: ifne +3060 -> 4218
    //   1161: iload 6
    //   1163: iconst_1
    //   1164: isub
    //   1165: istore_3
    //   1166: iload 8
    //   1168: iconst_1
    //   1169: iadd
    //   1170: istore 8
    //   1172: iload_3
    //   1173: istore 6
    //   1175: aload 30
    //   1177: astore 31
    //   1179: iload 4
    //   1181: istore_3
    //   1182: aload 28
    //   1184: astore 30
    //   1186: aload 31
    //   1188: astore 28
    //   1190: goto -821 -> 369
    //   1193: aload 30
    //   1195: astore 34
    //   1197: getstatic 37	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1200: invokevirtual 348	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   1203: astore 43
    //   1205: aload 43
    //   1207: ifnonnull +78 -> 1285
    //   1210: aload 30
    //   1212: astore 34
    //   1214: aload_0
    //   1215: bipush 152
    //   1217: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   1220: new 76	java/lang/Exception
    //   1223: dup
    //   1224: new 109	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1231: ldc_w 350
    //   1234: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: aload 33
    //   1239: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1245: invokespecial 272	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1248: athrow
    //   1249: astore 31
    //   1251: bipush 152
    //   1253: istore 7
    //   1255: iconst_0
    //   1256: istore 5
    //   1258: iconst_0
    //   1259: istore_3
    //   1260: aload 30
    //   1262: astore 32
    //   1264: iload_2
    //   1265: istore 4
    //   1267: aload 29
    //   1269: astore 30
    //   1271: aload 28
    //   1273: astore 29
    //   1275: aload 32
    //   1277: astore 28
    //   1279: iload 7
    //   1281: istore_2
    //   1282: goto -607 -> 675
    //   1285: aload 30
    //   1287: astore 34
    //   1289: new 352	org/apache/http/client/methods/HttpGet
    //   1292: dup
    //   1293: aload 33
    //   1295: invokespecial 353	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1298: astore 32
    //   1300: aload 30
    //   1302: astore 34
    //   1304: aload_0
    //   1305: invokevirtual 356	com/tencent/mobileqq/vip/DownloadTask:a	()Ljava/util/Map;
    //   1308: astore 31
    //   1310: aload 31
    //   1312: ifnull +138 -> 1450
    //   1315: aload 30
    //   1317: astore 34
    //   1319: aload 31
    //   1321: invokeinterface 360 1 0
    //   1326: invokeinterface 366 1 0
    //   1331: astore 42
    //   1333: aload 30
    //   1335: astore 34
    //   1337: aload 42
    //   1339: invokeinterface 371 1 0
    //   1344: ifeq +106 -> 1450
    //   1347: aload 30
    //   1349: astore 34
    //   1351: aload 42
    //   1353: invokeinterface 375 1 0
    //   1358: checkcast 167	java/lang/String
    //   1361: astore 44
    //   1363: aload 30
    //   1365: astore 34
    //   1367: aload 31
    //   1369: aload 44
    //   1371: invokeinterface 223 2 0
    //   1376: checkcast 167	java/lang/String
    //   1379: astore 45
    //   1381: aload 30
    //   1383: astore 34
    //   1385: aload 32
    //   1387: aload 44
    //   1389: aload 45
    //   1391: invokevirtual 379	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1394: aload 30
    //   1396: astore 34
    //   1398: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1401: ifeq -68 -> 1333
    //   1404: aload 30
    //   1406: astore 34
    //   1408: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1411: iconst_2
    //   1412: new 109	java/lang/StringBuilder
    //   1415: dup
    //   1416: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1419: ldc_w 381
    //   1422: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: aload 44
    //   1427: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: ldc_w 383
    //   1433: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: aload 45
    //   1438: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1447: goto -114 -> 1333
    //   1450: aload 41
    //   1452: ifnull +107 -> 1559
    //   1455: aload 30
    //   1457: astore 34
    //   1459: aload 41
    //   1461: invokevirtual 261	java/io/File:exists	()Z
    //   1464: ifeq +95 -> 1559
    //   1467: aload 30
    //   1469: astore 34
    //   1471: aload 41
    //   1473: invokevirtual 386	java/io/File:length	()J
    //   1476: lstore 16
    //   1478: aload 30
    //   1480: astore 34
    //   1482: aload 32
    //   1484: ldc_w 388
    //   1487: new 109	java/lang/StringBuilder
    //   1490: dup
    //   1491: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1494: ldc_w 390
    //   1497: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: lload 16
    //   1502: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1505: ldc_w 395
    //   1508: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1514: invokevirtual 379	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1517: aload 30
    //   1519: astore 34
    //   1521: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1524: ifeq +35 -> 1559
    //   1527: aload 30
    //   1529: astore 34
    //   1531: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1534: iconst_2
    //   1535: new 109	java/lang/StringBuilder
    //   1538: dup
    //   1539: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1542: ldc_w 397
    //   1545: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: lload 16
    //   1550: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1553: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1556: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1559: aload 30
    //   1561: astore 34
    //   1563: aload_0
    //   1564: getfield 400	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   1567: ifeq +160 -> 1727
    //   1570: aload 35
    //   1572: ifnull +155 -> 1727
    //   1575: aload 30
    //   1577: astore 34
    //   1579: aload 35
    //   1581: invokevirtual 261	java/io/File:exists	()Z
    //   1584: ifeq +143 -> 1727
    //   1587: aload 30
    //   1589: astore 34
    //   1591: aload 35
    //   1593: invokevirtual 403	java/io/File:lastModified	()J
    //   1596: lstore 16
    //   1598: lload 16
    //   1600: lconst_0
    //   1601: lcmp
    //   1602: ifle +125 -> 1727
    //   1605: aload 30
    //   1607: astore 34
    //   1609: new 405	java/text/SimpleDateFormat
    //   1612: dup
    //   1613: ldc_w 407
    //   1616: getstatic 413	java/util/Locale:US	Ljava/util/Locale;
    //   1619: invokespecial 416	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   1622: astore 31
    //   1624: aload 30
    //   1626: astore 34
    //   1628: aload 31
    //   1630: ldc_w 418
    //   1633: invokestatic 424	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   1636: invokevirtual 428	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   1639: aload 30
    //   1641: astore 34
    //   1643: aload 31
    //   1645: new 430	java/util/Date
    //   1648: dup
    //   1649: lload 16
    //   1651: invokespecial 433	java/util/Date:<init>	(J)V
    //   1654: invokevirtual 437	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1657: astore 31
    //   1659: aload 30
    //   1661: astore 34
    //   1663: aload 31
    //   1665: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1668: ifne +59 -> 1727
    //   1671: aload 30
    //   1673: astore 34
    //   1675: aload 32
    //   1677: ldc_w 439
    //   1680: aload 31
    //   1682: invokevirtual 379	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1685: aload 30
    //   1687: astore 34
    //   1689: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1692: ifeq +35 -> 1727
    //   1695: aload 30
    //   1697: astore 34
    //   1699: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1702: iconst_2
    //   1703: new 109	java/lang/StringBuilder
    //   1706: dup
    //   1707: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1710: ldc_w 441
    //   1713: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: aload 31
    //   1718: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1721: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1724: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1727: aload 30
    //   1729: astore 34
    //   1731: getstatic 39	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   1734: ifeq +84 -> 1818
    //   1737: aload 30
    //   1739: astore 34
    //   1741: aload_0
    //   1742: getfield 293	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   1745: ifeq +73 -> 1818
    //   1748: aload 30
    //   1750: astore 34
    //   1752: aload_0
    //   1753: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   1756: ifeq +62 -> 1818
    //   1759: aload 30
    //   1761: astore 34
    //   1763: aload 36
    //   1765: invokestatic 446	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   1768: aload 30
    //   1770: astore 34
    //   1772: aload 36
    //   1774: getfield 294	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1777: ifeq +41 -> 1818
    //   1780: aload 30
    //   1782: astore 34
    //   1784: aload 32
    //   1786: new 448	java/net/URI
    //   1789: dup
    //   1790: aload 36
    //   1792: getfield 302	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   1795: invokespecial 449	java/net/URI:<init>	(Ljava/lang/String;)V
    //   1798: invokevirtual 453	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   1801: aload 30
    //   1803: astore 34
    //   1805: aload 32
    //   1807: ldc_w 455
    //   1810: aload 36
    //   1812: getfield 456	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1815: invokevirtual 379	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1818: aload 30
    //   1820: astore 34
    //   1822: aload 43
    //   1824: invokevirtual 461	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   1827: invokestatic 466	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   1830: astore 42
    //   1832: aload 30
    //   1834: astore 34
    //   1836: aload 42
    //   1838: aload_0
    //   1839: getfield 468	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1842: invokevirtual 472	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1845: ifne +22 -> 1867
    //   1848: aload 30
    //   1850: astore 34
    //   1852: aload_0
    //   1853: iconst_0
    //   1854: putfield 280	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   1857: aload 30
    //   1859: astore 34
    //   1861: aload_0
    //   1862: aload 42
    //   1864: putfield 468	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1867: aconst_null
    //   1868: astore 31
    //   1870: iconst_0
    //   1871: istore 4
    //   1873: iconst_0
    //   1874: istore 5
    //   1876: aload 30
    //   1878: astore 34
    //   1880: aload 43
    //   1882: invokestatic 477	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1885: ifeq +685 -> 2570
    //   1888: aload 30
    //   1890: astore 34
    //   1892: aload_0
    //   1893: getfield 280	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   1896: ifne +2915 -> 4811
    //   1899: aload 30
    //   1901: astore 34
    //   1903: invokestatic 482	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   1906: astore 31
    //   1908: aload 30
    //   1910: astore 34
    //   1912: invokestatic 485	android/net/Proxy:getDefaultPort	()I
    //   1915: istore 4
    //   1917: aload 31
    //   1919: ifnull +2889 -> 4808
    //   1922: iload 4
    //   1924: ifle +2884 -> 4808
    //   1927: aload 30
    //   1929: astore 34
    //   1931: aload 38
    //   1933: ldc_w 487
    //   1936: new 489	org/apache/http/HttpHost
    //   1939: dup
    //   1940: aload 31
    //   1942: iload 4
    //   1944: invokespecial 492	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   1947: invokeinterface 139 3 0
    //   1952: pop
    //   1953: iconst_1
    //   1954: istore 26
    //   1956: aload 30
    //   1958: astore 34
    //   1960: aload 42
    //   1962: getstatic 493	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1965: invokevirtual 472	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1968: ifne +33 -> 2001
    //   1971: aload 30
    //   1973: astore 34
    //   1975: aload 42
    //   1977: getstatic 495	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   1980: invokevirtual 472	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1983: ifne +18 -> 2001
    //   1986: aload 30
    //   1988: astore 34
    //   1990: aload 42
    //   1992: getstatic 497	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   1995: invokevirtual 472	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1998: ifeq +2807 -> 4805
    //   2001: aload 30
    //   2003: astore 34
    //   2005: aload 32
    //   2007: ldc_w 499
    //   2010: aload 36
    //   2012: getfield 456	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2015: invokevirtual 379	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2018: aload 30
    //   2020: astore 34
    //   2022: aload 38
    //   2024: ldc_w 501
    //   2027: iload_2
    //   2028: invokeinterface 505 3 0
    //   2033: pop
    //   2034: aload 30
    //   2036: astore 34
    //   2038: aload 32
    //   2040: aload 38
    //   2042: invokevirtual 509	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   2045: aload 30
    //   2047: astore 34
    //   2049: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2052: ifeq +148 -> 2200
    //   2055: aload 30
    //   2057: astore 34
    //   2059: new 511	java/lang/StringBuffer
    //   2062: dup
    //   2063: invokespecial 512	java/lang/StringBuffer:<init>	()V
    //   2066: astore 43
    //   2068: aload 30
    //   2070: astore 34
    //   2072: aload 43
    //   2074: ldc_w 514
    //   2077: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2080: getstatic 39	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   2083: invokevirtual 520	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2086: ldc_w 522
    //   2089: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2092: aload_0
    //   2093: getfield 293	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   2096: invokevirtual 520	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2099: ldc_w 524
    //   2102: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2105: aload_0
    //   2106: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   2109: invokevirtual 520	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2112: ldc_w 526
    //   2115: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2118: aload_0
    //   2119: getfield 280	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   2122: invokevirtual 520	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2125: ldc_w 528
    //   2128: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2131: iload 26
    //   2133: invokevirtual 520	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2136: ldc_w 530
    //   2139: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2142: aload 42
    //   2144: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2147: ldc_w 532
    //   2150: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2153: aload 31
    //   2155: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2158: ldc_w 534
    //   2161: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2164: iload 4
    //   2166: invokevirtual 537	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   2169: ldc_w 539
    //   2172: invokevirtual 517	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2175: aload 32
    //   2177: invokevirtual 543	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   2180: invokevirtual 546	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   2183: pop
    //   2184: aload 30
    //   2186: astore 34
    //   2188: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2191: iconst_2
    //   2192: aload 43
    //   2194: invokevirtual 547	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   2197: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2200: aload 30
    //   2202: astore 34
    //   2204: getstatic 550	com/tencent/mobileqq/utils/HttpDownloadUtil:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   2207: aload 32
    //   2209: invokevirtual 556	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   2212: astore 42
    //   2214: aload 30
    //   2216: astore 34
    //   2218: aload 30
    //   2220: astore 31
    //   2222: aload 42
    //   2224: invokeinterface 562 1 0
    //   2229: invokeinterface 567 1 0
    //   2234: istore 4
    //   2236: aload 30
    //   2238: astore 34
    //   2240: aload 30
    //   2242: astore 31
    //   2244: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2247: ifeq +39 -> 2286
    //   2250: aload 30
    //   2252: astore 34
    //   2254: aload 30
    //   2256: astore 31
    //   2258: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2261: iconst_2
    //   2262: new 109	java/lang/StringBuilder
    //   2265: dup
    //   2266: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   2269: ldc_w 569
    //   2272: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2275: iload 4
    //   2277: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2280: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2283: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2286: aload 30
    //   2288: astore 34
    //   2290: aload 30
    //   2292: astore 31
    //   2294: aload 36
    //   2296: iload 4
    //   2298: putfield 571	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   2301: sipush 200
    //   2304: iload 4
    //   2306: if_icmpeq +11 -> 2317
    //   2309: sipush 206
    //   2312: iload 4
    //   2314: if_icmpne +1378 -> 3692
    //   2317: aload 30
    //   2319: astore 34
    //   2321: aload 30
    //   2323: astore 31
    //   2325: aload 42
    //   2327: invokeinterface 575 1 0
    //   2332: astore 30
    //   2334: aload 30
    //   2336: astore 34
    //   2338: aload 30
    //   2340: astore 31
    //   2342: aload 30
    //   2344: invokeinterface 578 1 0
    //   2349: lstore 18
    //   2351: aload 30
    //   2353: astore 34
    //   2355: lload 18
    //   2357: lstore 16
    //   2359: aload 42
    //   2361: ldc_w 580
    //   2364: invokeinterface 584 2 0
    //   2369: astore 31
    //   2371: aload 30
    //   2373: astore 34
    //   2375: lload 18
    //   2377: lstore 16
    //   2379: aload 42
    //   2381: ldc_w 586
    //   2384: invokeinterface 584 2 0
    //   2389: astore 32
    //   2391: aload 31
    //   2393: ifnull +187 -> 2580
    //   2396: aload 30
    //   2398: astore 34
    //   2400: lload 18
    //   2402: lstore 16
    //   2404: aload 31
    //   2406: invokeinterface 591 1 0
    //   2411: ldc_w 593
    //   2414: invokevirtual 597	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   2417: iconst_1
    //   2418: aaload
    //   2419: invokestatic 601	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2422: i2l
    //   2423: lstore 14
    //   2425: lload 14
    //   2427: lconst_1
    //   2428: lcmp
    //   2429: iflt +42 -> 2471
    //   2432: aload 30
    //   2434: astore 34
    //   2436: lload 14
    //   2438: lstore 16
    //   2440: aload_0
    //   2441: getfield 604	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   2444: lconst_0
    //   2445: lcmp
    //   2446: ifle +167 -> 2613
    //   2449: aload 30
    //   2451: astore 34
    //   2453: lload 14
    //   2455: lstore 16
    //   2457: aload_0
    //   2458: getfield 604	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   2461: lstore 18
    //   2463: lload 14
    //   2465: lload 18
    //   2467: lcmp
    //   2468: ifle +145 -> 2613
    //   2471: aload 30
    //   2473: astore 34
    //   2475: aload_0
    //   2476: bipush 151
    //   2478: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   2481: new 76	java/lang/Exception
    //   2484: dup
    //   2485: new 109	java/lang/StringBuilder
    //   2488: dup
    //   2489: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   2492: ldc_w 606
    //   2495: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2498: lload 14
    //   2500: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2503: ldc_w 608
    //   2506: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: aload_0
    //   2510: getfield 604	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   2513: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2516: ldc_w 610
    //   2519: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2522: aload 33
    //   2524: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2527: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2530: invokespecial 272	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2533: athrow
    //   2534: astore 31
    //   2536: aload 30
    //   2538: astore 32
    //   2540: iconst_1
    //   2541: istore 5
    //   2543: bipush 151
    //   2545: istore 7
    //   2547: iconst_1
    //   2548: istore_3
    //   2549: iload_2
    //   2550: istore 4
    //   2552: aload 29
    //   2554: astore 30
    //   2556: aload 28
    //   2558: astore 29
    //   2560: aload 32
    //   2562: astore 28
    //   2564: iload 7
    //   2566: istore_2
    //   2567: goto -1892 -> 675
    //   2570: iconst_0
    //   2571: istore 26
    //   2573: sipush 4096
    //   2576: istore_2
    //   2577: goto -559 -> 2018
    //   2580: lload 18
    //   2582: lstore 14
    //   2584: aload 32
    //   2586: ifnull -161 -> 2425
    //   2589: aload 30
    //   2591: astore 34
    //   2593: lload 18
    //   2595: lstore 16
    //   2597: aload 32
    //   2599: invokeinterface 591 1 0
    //   2604: invokestatic 601	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2607: i2l
    //   2608: lstore 14
    //   2610: goto -185 -> 2425
    //   2613: aload 30
    //   2615: astore 34
    //   2617: lload 14
    //   2619: lstore 16
    //   2621: aload 41
    //   2623: invokevirtual 386	java/io/File:length	()J
    //   2626: lstore 20
    //   2628: lload 20
    //   2630: lstore 18
    //   2632: lload 20
    //   2634: lload 14
    //   2636: lcmp
    //   2637: iflt +20 -> 2657
    //   2640: aload 30
    //   2642: astore 34
    //   2644: lload 14
    //   2646: lstore 16
    //   2648: aload 41
    //   2650: invokevirtual 613	java/io/File:delete	()Z
    //   2653: pop
    //   2654: lconst_0
    //   2655: lstore 18
    //   2657: lload 18
    //   2659: lconst_0
    //   2660: lcmp
    //   2661: ifeq +2253 -> 4914
    //   2664: iconst_1
    //   2665: istore 27
    //   2667: aload 30
    //   2669: astore 34
    //   2671: lload 14
    //   2673: lstore 16
    //   2675: new 322	java/io/FileOutputStream
    //   2678: dup
    //   2679: aload 41
    //   2681: iload 27
    //   2683: invokespecial 616	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   2686: astore 32
    //   2688: aload 30
    //   2690: invokeinterface 620 1 0
    //   2695: astore 29
    //   2697: lload 12
    //   2699: lstore 16
    //   2701: iload_2
    //   2702: newarray byte
    //   2704: astore 28
    //   2706: iconst_0
    //   2707: istore 4
    //   2709: lload 12
    //   2711: lstore 16
    //   2713: aload_0
    //   2714: invokevirtual 291	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   2717: ifne +141 -> 2858
    //   2720: lload 12
    //   2722: lstore 16
    //   2724: aload 29
    //   2726: aload 28
    //   2728: invokevirtual 624	java/io/InputStream:read	([B)I
    //   2731: istore 5
    //   2733: iload 5
    //   2735: iconst_m1
    //   2736: if_icmpeq +122 -> 2858
    //   2739: lload 12
    //   2741: lstore 16
    //   2743: aload 32
    //   2745: aload 28
    //   2747: iconst_0
    //   2748: iload 5
    //   2750: invokevirtual 628	java/io/FileOutputStream:write	([BII)V
    //   2753: lload 18
    //   2755: iload 5
    //   2757: i2l
    //   2758: ladd
    //   2759: lstore 22
    //   2761: lload 12
    //   2763: iload 5
    //   2765: i2l
    //   2766: ladd
    //   2767: lstore 20
    //   2769: iload 4
    //   2771: iload 5
    //   2773: iadd
    //   2774: istore 5
    //   2776: iload 5
    //   2778: istore 4
    //   2780: lload 22
    //   2782: lstore 18
    //   2784: lload 20
    //   2786: lstore 12
    //   2788: aload 37
    //   2790: ifnull -81 -> 2709
    //   2793: iload 5
    //   2795: istore 4
    //   2797: lload 22
    //   2799: lstore 18
    //   2801: lload 20
    //   2803: lstore 12
    //   2805: lload 20
    //   2807: lstore 16
    //   2809: iload 5
    //   2811: i2l
    //   2812: aload_0
    //   2813: getfield 630	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Long	J
    //   2816: lcmp
    //   2817: iflt -108 -> 2709
    //   2820: lload 20
    //   2822: lstore 16
    //   2824: aload_0
    //   2825: lload 14
    //   2827: lload 22
    //   2829: iload 8
    //   2831: invokevirtual 633	com/tencent/mobileqq/vip/DownloadTask:a	(JJI)V
    //   2834: lload 20
    //   2836: lstore 16
    //   2838: aload 37
    //   2840: aload_0
    //   2841: invokevirtual 636	com/tencent/mobileqq/vip/DownloadListener:onProgress	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   2844: iconst_0
    //   2845: istore 4
    //   2847: lload 22
    //   2849: lstore 18
    //   2851: lload 20
    //   2853: lstore 12
    //   2855: goto -146 -> 2709
    //   2858: lload 12
    //   2860: lstore 16
    //   2862: aload 41
    //   2864: invokevirtual 386	java/io/File:length	()J
    //   2867: lload 14
    //   2869: lcmp
    //   2870: ifne +624 -> 3494
    //   2873: iconst_0
    //   2874: istore 10
    //   2876: iconst_0
    //   2877: istore 11
    //   2879: iconst_0
    //   2880: istore 7
    //   2882: lload 12
    //   2884: lstore 16
    //   2886: aload_0
    //   2887: iconst_0
    //   2888: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   2891: iload 10
    //   2893: istore 4
    //   2895: iload 11
    //   2897: istore 5
    //   2899: aload 35
    //   2901: invokevirtual 261	java/io/File:exists	()Z
    //   2904: ifeq +17 -> 2921
    //   2907: iload 10
    //   2909: istore 4
    //   2911: iload 11
    //   2913: istore 5
    //   2915: aload 35
    //   2917: invokevirtual 613	java/io/File:delete	()Z
    //   2920: pop
    //   2921: iload 10
    //   2923: istore 4
    //   2925: iload 11
    //   2927: istore 5
    //   2929: aload 41
    //   2931: aload 35
    //   2933: invokevirtual 640	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2936: pop
    //   2937: iload 7
    //   2939: istore_3
    //   2940: iload 10
    //   2942: istore 4
    //   2944: iload 11
    //   2946: istore 5
    //   2948: aload_0
    //   2949: getfield 400	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   2952: ifeq +220 -> 3172
    //   2955: iload 7
    //   2957: istore_3
    //   2958: iload 10
    //   2960: istore 4
    //   2962: iload 11
    //   2964: istore 5
    //   2966: aload 42
    //   2968: ldc_w 642
    //   2971: invokeinterface 646 2 0
    //   2976: ifeq +196 -> 3172
    //   2979: iload 10
    //   2981: istore 4
    //   2983: iload 11
    //   2985: istore 5
    //   2987: aload 42
    //   2989: ldc_w 642
    //   2992: invokeinterface 584 2 0
    //   2997: invokeinterface 591 1 0
    //   3002: astore 28
    //   3004: iload 10
    //   3006: istore 4
    //   3008: iload 11
    //   3010: istore 5
    //   3012: aload 28
    //   3014: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3017: istore 27
    //   3019: iload 7
    //   3021: istore_3
    //   3022: iload 27
    //   3024: ifne +148 -> 3172
    //   3027: iload 10
    //   3029: istore 4
    //   3031: iload 11
    //   3033: istore 5
    //   3035: new 405	java/text/SimpleDateFormat
    //   3038: dup
    //   3039: ldc_w 407
    //   3042: getstatic 413	java/util/Locale:US	Ljava/util/Locale;
    //   3045: invokespecial 416	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   3048: astore 31
    //   3050: iload 10
    //   3052: istore 4
    //   3054: iload 11
    //   3056: istore 5
    //   3058: aload 31
    //   3060: ldc_w 418
    //   3063: invokestatic 424	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   3066: invokevirtual 428	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   3069: iload 10
    //   3071: istore 4
    //   3073: iload 11
    //   3075: istore 5
    //   3077: aload 31
    //   3079: aload 28
    //   3081: invokevirtual 650	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   3084: invokevirtual 653	java/util/Date:getTime	()J
    //   3087: lstore 16
    //   3089: iload 10
    //   3091: istore 4
    //   3093: iload 11
    //   3095: istore 5
    //   3097: aload 41
    //   3099: lload 16
    //   3101: invokevirtual 657	java/io/File:setLastModified	(J)Z
    //   3104: pop
    //   3105: iload 7
    //   3107: istore_3
    //   3108: iload 10
    //   3110: istore 4
    //   3112: iload 11
    //   3114: istore 5
    //   3116: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3119: ifeq +53 -> 3172
    //   3122: iload 10
    //   3124: istore 4
    //   3126: iload 11
    //   3128: istore 5
    //   3130: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3133: iconst_2
    //   3134: new 109	java/lang/StringBuilder
    //   3137: dup
    //   3138: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   3141: ldc_w 659
    //   3144: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3147: aload 28
    //   3149: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3152: ldc_w 661
    //   3155: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3158: lload 16
    //   3160: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3163: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3166: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3169: iload 7
    //   3171: istore_3
    //   3172: iconst_0
    //   3173: istore 4
    //   3175: aload 32
    //   3177: astore 28
    //   3179: iload_3
    //   3180: ifeq +746 -> 3926
    //   3183: iload 4
    //   3185: istore 7
    //   3187: aload_0
    //   3188: invokevirtual 291	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   3191: ifne +735 -> 3926
    //   3194: iload 4
    //   3196: istore 7
    //   3198: iload 9
    //   3200: aload_0
    //   3201: getfield 326	com/tencent/mobileqq/vip/DownloadTask:A	I
    //   3204: if_icmpge +619 -> 3823
    //   3207: iload 4
    //   3209: istore 7
    //   3211: aload 39
    //   3213: monitorenter
    //   3214: sipush 2000
    //   3217: i2l
    //   3218: lstore 16
    //   3220: aload 39
    //   3222: lload 16
    //   3224: invokevirtual 664	java/lang/Object:wait	(J)V
    //   3227: aload 39
    //   3229: monitorexit
    //   3230: iload_3
    //   3231: ifeq +84 -> 3315
    //   3234: aload_0
    //   3235: invokevirtual 291	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   3238: ifne +77 -> 3315
    //   3241: aload_0
    //   3242: getfield 293	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   3245: ifeq +70 -> 3315
    //   3248: aload 36
    //   3250: getfield 294	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3253: ifeq +697 -> 3950
    //   3256: invokestatic 299	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3259: astore 31
    //   3261: aload 31
    //   3263: ifnull +18 -> 3281
    //   3266: aload 31
    //   3268: aload 36
    //   3270: getfield 301	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   3273: aload 36
    //   3275: getfield 302	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3278: invokevirtual 305	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   3281: aload_1
    //   3282: ifnull +662 -> 3944
    //   3285: aload_1
    //   3286: invokevirtual 181	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3289: invokevirtual 184	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   3292: astore 31
    //   3294: aload 36
    //   3296: getfield 302	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3299: aload 35
    //   3301: invokevirtual 232	java/io/File:getName	()Ljava/lang/String;
    //   3304: iconst_m1
    //   3305: aload 31
    //   3307: invokestatic 308	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   3310: aload_0
    //   3311: iconst_0
    //   3312: putfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   3315: iload 9
    //   3317: iconst_1
    //   3318: iadd
    //   3319: istore 7
    //   3321: aload 30
    //   3323: ifnull +10 -> 3333
    //   3326: aload 30
    //   3328: invokeinterface 315 1 0
    //   3333: aload 29
    //   3335: ifnull +8 -> 3343
    //   3338: aload 29
    //   3340: invokevirtual 320	java/io/InputStream:close	()V
    //   3343: aload 28
    //   3345: ifnull +8 -> 3353
    //   3348: aload 28
    //   3350: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   3353: iload 4
    //   3355: istore 5
    //   3357: iload_3
    //   3358: istore 4
    //   3360: lload 12
    //   3362: lstore 16
    //   3364: lload 14
    //   3366: lstore 12
    //   3368: iload 7
    //   3370: istore_3
    //   3371: lload 16
    //   3373: lstore 14
    //   3375: goto -2406 -> 969
    //   3378: astore 31
    //   3380: iload 10
    //   3382: istore 4
    //   3384: iload 11
    //   3386: istore 5
    //   3388: aload 31
    //   3390: invokevirtual 667	java/lang/Exception:printStackTrace	()V
    //   3393: iload 7
    //   3395: istore_3
    //   3396: iload 10
    //   3398: istore 4
    //   3400: iload 11
    //   3402: istore 5
    //   3404: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3407: ifeq -235 -> 3172
    //   3410: iload 10
    //   3412: istore 4
    //   3414: iload 11
    //   3416: istore 5
    //   3418: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3421: iconst_2
    //   3422: new 109	java/lang/StringBuilder
    //   3425: dup
    //   3426: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   3429: ldc_w 659
    //   3432: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3435: aload 28
    //   3437: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3440: ldc_w 669
    //   3443: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3446: aload 31
    //   3448: invokevirtual 670	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3451: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3454: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3457: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3460: iload 7
    //   3462: istore_3
    //   3463: goto -291 -> 3172
    //   3466: astore 31
    //   3468: iconst_0
    //   3469: istore_3
    //   3470: aload 30
    //   3472: astore 28
    //   3474: iload 4
    //   3476: istore 7
    //   3478: iconst_1
    //   3479: istore 5
    //   3481: iload_2
    //   3482: istore 4
    //   3484: aload 32
    //   3486: astore 30
    //   3488: iload 7
    //   3490: istore_2
    //   3491: goto -2816 -> 675
    //   3494: lload 12
    //   3496: lstore 16
    //   3498: aload_0
    //   3499: invokevirtual 291	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   3502: ifeq +23 -> 3525
    //   3505: bipush 150
    //   3507: istore 4
    //   3509: lload 12
    //   3511: lstore 16
    //   3513: aload_0
    //   3514: bipush 150
    //   3516: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3519: iload 4
    //   3521: istore_3
    //   3522: goto -350 -> 3172
    //   3525: bipush 151
    //   3527: istore 7
    //   3529: lload 12
    //   3531: lstore 16
    //   3533: aload_0
    //   3534: bipush 151
    //   3536: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3539: iload 7
    //   3541: istore 4
    //   3543: iload 7
    //   3545: istore 5
    //   3547: aload 41
    //   3549: invokevirtual 613	java/io/File:delete	()Z
    //   3552: pop
    //   3553: iload 7
    //   3555: istore_3
    //   3556: goto -384 -> 3172
    //   3559: astore 31
    //   3561: aload 29
    //   3563: astore 28
    //   3565: iload 5
    //   3567: istore_3
    //   3568: aload 32
    //   3570: astore 29
    //   3572: iload_3
    //   3573: ifeq +84 -> 3657
    //   3576: aload_0
    //   3577: invokevirtual 291	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   3580: ifne +77 -> 3657
    //   3583: aload_0
    //   3584: getfield 293	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   3587: ifeq +70 -> 3657
    //   3590: aload 36
    //   3592: getfield 294	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3595: ifeq +550 -> 4145
    //   3598: invokestatic 299	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3601: astore 32
    //   3603: aload 32
    //   3605: ifnull +18 -> 3623
    //   3608: aload 32
    //   3610: aload 36
    //   3612: getfield 301	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   3615: aload 36
    //   3617: getfield 302	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3620: invokevirtual 305	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   3623: aload_1
    //   3624: ifnull +1450 -> 5074
    //   3627: aload_1
    //   3628: invokevirtual 181	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3631: invokevirtual 184	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   3634: astore 32
    //   3636: aload 36
    //   3638: getfield 302	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3641: aload 35
    //   3643: invokevirtual 232	java/io/File:getName	()Ljava/lang/String;
    //   3646: iconst_m1
    //   3647: aload 32
    //   3649: invokestatic 308	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   3652: aload_0
    //   3653: iconst_0
    //   3654: putfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   3657: aload 30
    //   3659: ifnull +10 -> 3669
    //   3662: aload 30
    //   3664: invokeinterface 315 1 0
    //   3669: aload 28
    //   3671: ifnull +8 -> 3679
    //   3674: aload 28
    //   3676: invokevirtual 320	java/io/InputStream:close	()V
    //   3679: aload 29
    //   3681: ifnull +8 -> 3689
    //   3684: aload 29
    //   3686: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   3689: aload 31
    //   3691: athrow
    //   3692: sipush 404
    //   3695: iload 4
    //   3697: if_icmpne +34 -> 3731
    //   3700: aload 30
    //   3702: astore 34
    //   3704: aload_0
    //   3705: iload 4
    //   3707: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3710: iload 4
    //   3712: istore_3
    //   3713: aload 28
    //   3715: astore 31
    //   3717: aload 29
    //   3719: astore 28
    //   3721: iconst_1
    //   3722: istore 4
    //   3724: aload 31
    //   3726: astore 29
    //   3728: goto -549 -> 3179
    //   3731: sipush 304
    //   3734: iload 4
    //   3736: if_icmpne +36 -> 3772
    //   3739: aload 30
    //   3741: astore 34
    //   3743: aload 30
    //   3745: astore 31
    //   3747: aload_0
    //   3748: iconst_0
    //   3749: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3752: iconst_0
    //   3753: istore 4
    //   3755: aload 28
    //   3757: astore 31
    //   3759: iconst_0
    //   3760: istore_3
    //   3761: aload 29
    //   3763: astore 28
    //   3765: aload 31
    //   3767: astore 29
    //   3769: goto -590 -> 3179
    //   3772: aload 30
    //   3774: astore 34
    //   3776: aload 30
    //   3778: astore 31
    //   3780: aload_0
    //   3781: iload 4
    //   3783: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3786: iconst_0
    //   3787: istore 5
    //   3789: aload 28
    //   3791: astore 31
    //   3793: iload 4
    //   3795: istore_3
    //   3796: iload 5
    //   3798: istore 4
    //   3800: aload 29
    //   3802: astore 28
    //   3804: aload 31
    //   3806: astore 29
    //   3808: goto -629 -> 3179
    //   3811: astore 31
    //   3813: aload 39
    //   3815: monitorexit
    //   3816: iload 4
    //   3818: istore 7
    //   3820: aload 31
    //   3822: athrow
    //   3823: iload 4
    //   3825: istore 7
    //   3827: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   3830: ldc2_w 671
    //   3833: ldiv
    //   3834: l2i
    //   3835: istore 5
    //   3837: iload 4
    //   3839: istore 7
    //   3841: aload_0
    //   3842: getfield 674	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_Boolean	Z
    //   3845: ifeq +23 -> 3868
    //   3848: iload 4
    //   3850: istore 7
    //   3852: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3855: aload_0
    //   3856: getfield 675	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3859: iload 5
    //   3861: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3864: invokevirtual 676	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3867: pop
    //   3868: iconst_1
    //   3869: istore 7
    //   3871: new 76	java/lang/Exception
    //   3874: dup
    //   3875: new 109	java/lang/StringBuilder
    //   3878: dup
    //   3879: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   3882: ldc_w 678
    //   3885: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3888: aload 33
    //   3890: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3893: ldc_w 680
    //   3896: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3899: aload_0
    //   3900: getfield 293	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   3903: invokevirtual 683	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3906: ldc_w 685
    //   3909: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3912: aload_0
    //   3913: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   3916: invokevirtual 683	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3919: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3922: invokespecial 272	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   3925: athrow
    //   3926: iload 4
    //   3928: istore 7
    //   3930: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3933: aload_0
    //   3934: getfield 675	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3937: invokevirtual 688	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3940: pop
    //   3941: goto -711 -> 3230
    //   3944: aconst_null
    //   3945: astore 31
    //   3947: goto -653 -> 3294
    //   3950: aload_0
    //   3951: iconst_1
    //   3952: putfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   3955: goto -640 -> 3315
    //   3958: astore 31
    //   3960: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3963: ifeq +34 -> 3997
    //   3966: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3969: iconst_2
    //   3970: new 109	java/lang/StringBuilder
    //   3973: dup
    //   3974: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   3977: ldc_w 690
    //   3980: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3983: aload 31
    //   3985: invokevirtual 691	java/io/IOException:getMessage	()Ljava/lang/String;
    //   3988: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3991: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3994: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3997: iload 4
    //   3999: istore 5
    //   4001: iload_3
    //   4002: istore 4
    //   4004: lload 12
    //   4006: lstore 16
    //   4008: lload 14
    //   4010: lstore 12
    //   4012: iload 7
    //   4014: istore_3
    //   4015: lload 16
    //   4017: lstore 14
    //   4019: goto -3050 -> 969
    //   4022: aload 31
    //   4024: instanceof 696
    //   4027: ifeq +12 -> 4039
    //   4030: aload_0
    //   4031: bipush 144
    //   4033: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4036: goto -3311 -> 725
    //   4039: aload 31
    //   4041: instanceof 274
    //   4044: ifne +11 -> 4055
    //   4047: aload 31
    //   4049: instanceof 276
    //   4052: ifeq +12 -> 4064
    //   4055: aload_0
    //   4056: bipush 143
    //   4058: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4061: goto -3336 -> 725
    //   4064: aload 31
    //   4066: instanceof 278
    //   4069: ifeq -3344 -> 725
    //   4072: aload_0
    //   4073: bipush 142
    //   4075: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4078: goto -3353 -> 725
    //   4081: aload_0
    //   4082: iconst_0
    //   4083: putfield 280	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   4086: goto -3341 -> 745
    //   4089: aconst_null
    //   4090: astore 31
    //   4092: goto -3222 -> 870
    //   4095: aload_0
    //   4096: iconst_1
    //   4097: putfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4100: goto -3209 -> 891
    //   4103: astore 31
    //   4105: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4108: ifeq +923 -> 5031
    //   4111: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4114: iconst_2
    //   4115: new 109	java/lang/StringBuilder
    //   4118: dup
    //   4119: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   4122: ldc_w 690
    //   4125: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4128: aload 31
    //   4130: invokevirtual 691	java/io/IOException:getMessage	()Ljava/lang/String;
    //   4133: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4136: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4139: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4142: goto +889 -> 5031
    //   4145: aload_0
    //   4146: iconst_1
    //   4147: putfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4150: goto -493 -> 3657
    //   4153: astore_0
    //   4154: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4157: ifeq -468 -> 3689
    //   4160: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4163: iconst_2
    //   4164: new 109	java/lang/StringBuilder
    //   4167: dup
    //   4168: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   4171: ldc_w 690
    //   4174: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4177: aload_0
    //   4178: invokevirtual 691	java/io/IOException:getMessage	()Ljava/lang/String;
    //   4181: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4184: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4187: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4190: goto -501 -> 3689
    //   4193: aload_0
    //   4194: bipush 146
    //   4196: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4199: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4202: ifeq +878 -> 5080
    //   4205: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4208: iconst_2
    //   4209: ldc_w 698
    //   4212: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4215: goto +865 -> 5080
    //   4218: aload_0
    //   4219: getfield 701	com/tencent/mobileqq/vip/DownloadTask:j	Z
    //   4222: iconst_1
    //   4223: if_icmpne +576 -> 4799
    //   4226: iload_2
    //   4227: istore_3
    //   4228: iload 6
    //   4230: ifle +78 -> 4308
    //   4233: iload_2
    //   4234: istore_3
    //   4235: aload_0
    //   4236: getfield 152	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4239: invokeinterface 158 1 0
    //   4244: iconst_1
    //   4245: if_icmple +63 -> 4308
    //   4248: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4251: ifeq +49 -> 4300
    //   4254: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4257: iconst_2
    //   4258: new 109	java/lang/StringBuilder
    //   4261: dup
    //   4262: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   4265: ldc_w 703
    //   4268: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4271: iload 6
    //   4273: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4276: ldc_w 705
    //   4279: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4282: aload_0
    //   4283: getfield 152	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4286: invokeinterface 158 1 0
    //   4291: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4294: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4297: invokestatic 694	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4300: aload_0
    //   4301: bipush 148
    //   4303: putfield 103	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4306: iconst_m1
    //   4307: istore_3
    //   4308: iload_3
    //   4309: istore_2
    //   4310: aload 37
    //   4312: ifnull -4013 -> 299
    //   4315: aload_0
    //   4316: invokevirtual 291	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   4319: ifeq +33 -> 4352
    //   4322: aload_0
    //   4323: getfield 708	com/tencent/mobileqq/vip/DownloadTask:g	Z
    //   4326: ifne +26 -> 4352
    //   4329: iload_3
    //   4330: istore_2
    //   4331: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4334: ifeq -4035 -> 299
    //   4337: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4340: iconst_2
    //   4341: ldc_w 710
    //   4344: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4347: iload_3
    //   4348: istore_2
    //   4349: goto -4050 -> 299
    //   4352: aload_0
    //   4353: invokevirtual 291	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   4356: ifeq +759 -> 5115
    //   4359: aload_0
    //   4360: iconst_2
    //   4361: invokevirtual 713	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   4364: aload 37
    //   4366: aload_0
    //   4367: invokevirtual 716	com/tencent/mobileqq/vip/DownloadListener:onCancel	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   4370: aload 37
    //   4372: aload_0
    //   4373: invokevirtual 107	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   4376: iload_3
    //   4377: istore_2
    //   4378: goto -4079 -> 299
    //   4381: aload_0
    //   4382: iload_2
    //   4383: invokevirtual 713	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   4386: goto -16 -> 4370
    //   4389: iconst_m1
    //   4390: istore_2
    //   4391: goto -10 -> 4381
    //   4394: aload 28
    //   4396: instanceof 696
    //   4399: ifeq -4147 -> 252
    //   4402: bipush 144
    //   4404: istore_2
    //   4405: goto -4153 -> 252
    //   4408: astore_0
    //   4409: iconst_m1
    //   4410: istore_2
    //   4411: goto -4112 -> 299
    //   4414: astore 31
    //   4416: goto -1189 -> 3227
    //   4419: astore 31
    //   4421: goto -3264 -> 1157
    //   4424: astore 31
    //   4426: aload 29
    //   4428: astore 28
    //   4430: aload 32
    //   4432: astore 29
    //   4434: goto -862 -> 3572
    //   4437: astore 31
    //   4439: aload 34
    //   4441: astore 30
    //   4443: goto -871 -> 3572
    //   4446: astore 31
    //   4448: bipush 153
    //   4450: istore_3
    //   4451: goto -879 -> 3572
    //   4454: astore 31
    //   4456: bipush 152
    //   4458: istore_3
    //   4459: goto -887 -> 3572
    //   4462: astore 31
    //   4464: bipush 151
    //   4466: istore_3
    //   4467: goto -895 -> 3572
    //   4470: astore 31
    //   4472: aload 32
    //   4474: astore 29
    //   4476: goto -904 -> 3572
    //   4479: astore 31
    //   4481: aload 30
    //   4483: astore 32
    //   4485: iload_3
    //   4486: istore 7
    //   4488: iconst_1
    //   4489: istore_3
    //   4490: iconst_0
    //   4491: istore 5
    //   4493: iload_2
    //   4494: istore 4
    //   4496: aload 29
    //   4498: astore 30
    //   4500: aload 28
    //   4502: astore 29
    //   4504: aload 32
    //   4506: astore 28
    //   4508: iload 7
    //   4510: istore_2
    //   4511: goto -3836 -> 675
    //   4514: astore 31
    //   4516: iload_3
    //   4517: istore 7
    //   4519: aload 30
    //   4521: astore 32
    //   4523: iconst_0
    //   4524: istore_3
    //   4525: iconst_0
    //   4526: istore 5
    //   4528: iload_2
    //   4529: istore 4
    //   4531: aload 29
    //   4533: astore 30
    //   4535: aload 28
    //   4537: astore 29
    //   4539: aload 32
    //   4541: astore 28
    //   4543: iload 7
    //   4545: istore_2
    //   4546: goto -3871 -> 675
    //   4549: astore 31
    //   4551: iconst_0
    //   4552: istore 5
    //   4554: iconst_0
    //   4555: istore 4
    //   4557: aload 30
    //   4559: astore 32
    //   4561: iload_3
    //   4562: istore 7
    //   4564: iload 4
    //   4566: istore_3
    //   4567: iload_2
    //   4568: istore 4
    //   4570: aload 29
    //   4572: astore 30
    //   4574: aload 28
    //   4576: astore 29
    //   4578: aload 32
    //   4580: astore 28
    //   4582: iload 7
    //   4584: istore_2
    //   4585: goto -3910 -> 675
    //   4588: astore 30
    //   4590: iconst_1
    //   4591: istore 5
    //   4593: iconst_0
    //   4594: istore 4
    //   4596: aload 31
    //   4598: astore 32
    //   4600: iload_3
    //   4601: istore 7
    //   4603: aload 30
    //   4605: astore 31
    //   4607: iload 4
    //   4609: istore_3
    //   4610: iload_2
    //   4611: istore 4
    //   4613: aload 29
    //   4615: astore 30
    //   4617: aload 28
    //   4619: astore 29
    //   4621: aload 32
    //   4623: astore 28
    //   4625: iload 7
    //   4627: istore_2
    //   4628: goto -3953 -> 675
    //   4631: astore 31
    //   4633: iconst_0
    //   4634: istore 4
    //   4636: aload 30
    //   4638: astore 32
    //   4640: iload_3
    //   4641: istore 7
    //   4643: iconst_1
    //   4644: istore 5
    //   4646: lload 16
    //   4648: lstore 14
    //   4650: iload 4
    //   4652: istore_3
    //   4653: iload_2
    //   4654: istore 4
    //   4656: aload 29
    //   4658: astore 30
    //   4660: aload 28
    //   4662: astore 29
    //   4664: aload 32
    //   4666: astore 28
    //   4668: iload 7
    //   4670: istore_2
    //   4671: goto -3996 -> 675
    //   4674: astore 31
    //   4676: aload 30
    //   4678: astore 32
    //   4680: iconst_1
    //   4681: istore 5
    //   4683: iload_3
    //   4684: istore 7
    //   4686: iconst_1
    //   4687: istore_3
    //   4688: iload_2
    //   4689: istore 4
    //   4691: aload 29
    //   4693: astore 30
    //   4695: aload 28
    //   4697: astore 29
    //   4699: aload 32
    //   4701: astore 28
    //   4703: iload 7
    //   4705: istore_2
    //   4706: goto -4031 -> 675
    //   4709: astore 31
    //   4711: iconst_0
    //   4712: istore 4
    //   4714: aload 30
    //   4716: astore 34
    //   4718: iload_3
    //   4719: istore 7
    //   4721: iconst_1
    //   4722: istore 5
    //   4724: iload 4
    //   4726: istore_3
    //   4727: iload_2
    //   4728: istore 4
    //   4730: aload 32
    //   4732: astore 30
    //   4734: aload 28
    //   4736: astore 29
    //   4738: aload 34
    //   4740: astore 28
    //   4742: iload 7
    //   4744: istore_2
    //   4745: goto -4070 -> 675
    //   4748: astore 31
    //   4750: aload 30
    //   4752: astore 32
    //   4754: iconst_1
    //   4755: istore 4
    //   4757: iconst_1
    //   4758: istore 5
    //   4760: iload_3
    //   4761: istore 7
    //   4763: iload 4
    //   4765: istore_3
    //   4766: iload_2
    //   4767: istore 4
    //   4769: aload 29
    //   4771: astore 30
    //   4773: aload 28
    //   4775: astore 29
    //   4777: aload 32
    //   4779: astore 28
    //   4781: iload 7
    //   4783: istore_2
    //   4784: goto -4109 -> 675
    //   4787: iconst_m1
    //   4788: istore_2
    //   4789: goto -4490 -> 299
    //   4792: aload 31
    //   4794: astore 33
    //   4796: goto -4291 -> 505
    //   4799: iload 6
    //   4801: istore_3
    //   4802: goto -3636 -> 1166
    //   4805: goto -2787 -> 2018
    //   4808: goto -2852 -> 1956
    //   4811: aconst_null
    //   4812: astore 31
    //   4814: iload 5
    //   4816: istore 4
    //   4818: goto -2862 -> 1956
    //   4821: iload_3
    //   4822: istore 9
    //   4824: aload 29
    //   4826: astore 31
    //   4828: iload 4
    //   4830: istore_3
    //   4831: lload 12
    //   4833: lstore 16
    //   4835: lload 14
    //   4837: lstore 12
    //   4839: lload 16
    //   4841: lstore 14
    //   4843: aload 28
    //   4845: astore 29
    //   4847: aload 31
    //   4849: astore 28
    //   4851: goto -4297 -> 554
    //   4854: iload_3
    //   4855: ireturn
    //   4856: iconst_1
    //   4857: istore 7
    //   4859: goto -4154 -> 705
    //   4862: aload 33
    //   4864: astore 31
    //   4866: iload_2
    //   4867: istore 5
    //   4869: iload 4
    //   4871: istore_2
    //   4872: iload 5
    //   4874: istore 4
    //   4876: goto -3879 -> 997
    //   4879: astore 31
    //   4881: iconst_0
    //   4882: istore 5
    //   4884: iload_3
    //   4885: istore 7
    //   4887: aload 30
    //   4889: astore 32
    //   4891: iconst_0
    //   4892: istore_3
    //   4893: iload_2
    //   4894: istore 4
    //   4896: aload 29
    //   4898: astore 30
    //   4900: aload 28
    //   4902: astore 29
    //   4904: aload 32
    //   4906: astore 28
    //   4908: iload 7
    //   4910: istore_2
    //   4911: goto -4236 -> 675
    //   4914: iconst_0
    //   4915: istore 27
    //   4917: goto -2250 -> 2667
    //   4920: astore 31
    //   4922: lload 16
    //   4924: lstore 12
    //   4926: iconst_0
    //   4927: istore 4
    //   4929: aload 30
    //   4931: astore 28
    //   4933: iload_3
    //   4934: istore 7
    //   4936: iconst_1
    //   4937: istore 5
    //   4939: iload 4
    //   4941: istore_3
    //   4942: iload_2
    //   4943: istore 4
    //   4945: aload 32
    //   4947: astore 30
    //   4949: iload 7
    //   4951: istore_2
    //   4952: goto -4277 -> 675
    //   4955: astore 31
    //   4957: iconst_1
    //   4958: istore 5
    //   4960: iload_3
    //   4961: istore 10
    //   4963: aload 30
    //   4965: astore 32
    //   4967: iload 7
    //   4969: istore_3
    //   4970: iload_2
    //   4971: istore 4
    //   4973: aload 28
    //   4975: astore 30
    //   4977: aload 32
    //   4979: astore 28
    //   4981: iload 10
    //   4983: istore_2
    //   4984: goto -4309 -> 675
    //   4987: astore 31
    //   4989: aload 29
    //   4991: astore 32
    //   4993: aload 28
    //   4995: astore 29
    //   4997: aload 32
    //   4999: astore 28
    //   5001: goto -1429 -> 3572
    //   5004: astore 31
    //   5006: aload 29
    //   5008: astore 32
    //   5010: aload 28
    //   5012: astore 33
    //   5014: aload 30
    //   5016: astore 29
    //   5018: aload 32
    //   5020: astore 28
    //   5022: aload 33
    //   5024: astore 30
    //   5026: iload_2
    //   5027: istore_3
    //   5028: goto -1456 -> 3572
    //   5031: aload 28
    //   5033: astore 31
    //   5035: aload 30
    //   5037: astore 28
    //   5039: iload_3
    //   5040: istore 5
    //   5042: iload 9
    //   5044: istore_3
    //   5045: iload_2
    //   5046: istore 7
    //   5048: lload 12
    //   5050: lstore 16
    //   5052: lload 14
    //   5054: lstore 12
    //   5056: iload 4
    //   5058: istore_2
    //   5059: iload 7
    //   5061: istore 4
    //   5063: lload 16
    //   5065: lstore 14
    //   5067: aload 31
    //   5069: astore 30
    //   5071: goto -4102 -> 969
    //   5074: aconst_null
    //   5075: astore 32
    //   5077: goto -1441 -> 3636
    //   5080: aload 28
    //   5082: astore 32
    //   5084: iconst_m1
    //   5085: istore_2
    //   5086: lconst_0
    //   5087: lstore 12
    //   5089: iconst_m1
    //   5090: istore 5
    //   5092: iload_3
    //   5093: istore 4
    //   5095: aload 30
    //   5097: astore 28
    //   5099: iload 5
    //   5101: istore_3
    //   5102: aload 32
    //   5104: astore 30
    //   5106: goto -4109 -> 997
    //   5109: iconst_0
    //   5110: istore 26
    //   5112: goto -4001 -> 1111
    //   5115: iload_3
    //   5116: ifne -727 -> 4389
    //   5119: iconst_3
    //   5120: istore_2
    //   5121: goto -740 -> 4381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5124	0	paramDownloadTask	DownloadTask
    //   0	5124	1	paramAppInterface	AppInterface
    //   17	5104	2	i	int
    //   57	5059	3	j	int
    //   526	4568	4	k	int
    //   662	4438	5	m	int
    //   351	4449	6	n	int
    //   646	4414	7	i1	int
    //   354	2476	8	i2	int
    //   519	4524	9	i3	int
    //   2874	2108	10	i4	int
    //   2877	538	11	i5	int
    //   537	4551	12	l1	long
    //   398	4668	14	l2	long
    //   949	4115	16	l3	long
    //   2349	501	18	l4	long
    //   2626	226	20	l5	long
    //   2759	89	22	l6	long
    //   386	759	24	l7	long
    //   529	4582	26	bool1	boolean
    //   589	4327	27	bool2	boolean
    //   142	7	28	str1	String
    //   228	14	28	localThrowable1	java.lang.Throwable
    //   271	4827	28	localObject1	Object
    //   360	4657	29	localObject2	Object
    //   363	4210	30	localObject3	Object
    //   4588	16	30	localThrowable2	java.lang.Throwable
    //   4615	490	30	localObject4	Object
    //   414	773	31	localObject5	Object
    //   1249	1	31	localThrowable3	java.lang.Throwable
    //   1308	1097	31	localObject6	Object
    //   2534	1	31	localThrowable4	java.lang.Throwable
    //   3048	258	31	localObject7	Object
    //   3378	69	31	localException	Exception
    //   3466	1	31	localThrowable5	java.lang.Throwable
    //   3559	131	31	localObject8	Object
    //   3715	90	31	localObject9	Object
    //   3811	10	31	localObject10	Object
    //   3945	1	31	localObject11	Object
    //   3958	107	31	localIOException1	java.io.IOException
    //   4090	1	31	localObject12	Object
    //   4103	26	31	localIOException2	java.io.IOException
    //   4414	1	31	localInterruptedException	java.lang.InterruptedException
    //   4419	1	31	localThrowable6	java.lang.Throwable
    //   4424	1	31	localObject13	Object
    //   4437	1	31	localObject14	Object
    //   4446	1	31	localObject15	Object
    //   4454	1	31	localObject16	Object
    //   4462	1	31	localObject17	Object
    //   4470	1	31	localObject18	Object
    //   4479	1	31	localThrowable7	java.lang.Throwable
    //   4514	1	31	localThrowable8	java.lang.Throwable
    //   4549	48	31	localThrowable9	java.lang.Throwable
    //   4605	1	31	localThrowable10	java.lang.Throwable
    //   4631	1	31	localThrowable11	java.lang.Throwable
    //   4674	1	31	localThrowable12	java.lang.Throwable
    //   4709	1	31	localThrowable13	java.lang.Throwable
    //   4748	45	31	localThrowable14	java.lang.Throwable
    //   4812	53	31	localObject19	Object
    //   4879	1	31	localThrowable15	java.lang.Throwable
    //   4920	1	31	localThrowable16	java.lang.Throwable
    //   4955	1	31	localThrowable17	java.lang.Throwable
    //   4987	1	31	localObject20	Object
    //   5004	1	31	localObject21	Object
    //   5033	35	31	localObject22	Object
    //   638	34	32	localThrowable18	java.lang.Throwable
    //   1015	4088	32	localObject23	Object
    //   503	4520	33	localObject24	Object
    //   556	4183	34	localObject25	Object
    //   436	3206	35	localFile1	File
    //   516	3121	36	localDownloadInfo	com.tencent.mobileqq.emoticon.DownloadInfo
    //   28	4343	37	localDownloadListener	DownloadListener
    //   99	1942	38	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   395	3419	39	localObject26	Object
    //   448	176	40	localFile2	File
    //   482	3066	41	localFile3	File
    //   1331	1657	42	localObject27	Object
    //   1203	990	43	localObject28	Object
    //   1361	65	44	str2	String
    //   1379	58	45	str3	String
    // Exception table:
    //   from	to	target	type
    //   24	30	228	java/lang/Throwable
    //   35	56	228	java/lang/Throwable
    //   58	90	228	java/lang/Throwable
    //   92	140	228	java/lang/Throwable
    //   144	175	228	java/lang/Throwable
    //   175	181	228	java/lang/Throwable
    //   186	192	228	java/lang/Throwable
    //   194	226	228	java/lang/Throwable
    //   342	353	228	java/lang/Throwable
    //   369	397	228	java/lang/Throwable
    //   400	438	228	java/lang/Throwable
    //   443	505	228	java/lang/Throwable
    //   505	518	228	java/lang/Throwable
    //   810	837	228	java/lang/Throwable
    //   842	857	228	java/lang/Throwable
    //   861	870	228	java/lang/Throwable
    //   870	891	228	java/lang/Throwable
    //   902	909	228	java/lang/Throwable
    //   914	919	228	java/lang/Throwable
    //   924	929	228	java/lang/Throwable
    //   979	994	228	java/lang/Throwable
    //   1002	1008	228	java/lang/Throwable
    //   1008	1104	228	java/lang/Throwable
    //   1111	1116	228	java/lang/Throwable
    //   3234	3261	228	java/lang/Throwable
    //   3266	3281	228	java/lang/Throwable
    //   3285	3294	228	java/lang/Throwable
    //   3294	3315	228	java/lang/Throwable
    //   3326	3333	228	java/lang/Throwable
    //   3338	3343	228	java/lang/Throwable
    //   3348	3353	228	java/lang/Throwable
    //   3576	3603	228	java/lang/Throwable
    //   3608	3623	228	java/lang/Throwable
    //   3627	3636	228	java/lang/Throwable
    //   3636	3657	228	java/lang/Throwable
    //   3662	3669	228	java/lang/Throwable
    //   3674	3679	228	java/lang/Throwable
    //   3684	3689	228	java/lang/Throwable
    //   3689	3692	228	java/lang/Throwable
    //   3950	3955	228	java/lang/Throwable
    //   3960	3997	228	java/lang/Throwable
    //   4095	4100	228	java/lang/Throwable
    //   4105	4142	228	java/lang/Throwable
    //   4145	4150	228	java/lang/Throwable
    //   4154	4190	228	java/lang/Throwable
    //   4193	4215	228	java/lang/Throwable
    //   4218	4226	228	java/lang/Throwable
    //   4235	4300	228	java/lang/Throwable
    //   4300	4306	228	java/lang/Throwable
    //   4315	4329	228	java/lang/Throwable
    //   4331	4347	228	java/lang/Throwable
    //   4352	4370	228	java/lang/Throwable
    //   4370	4376	228	java/lang/Throwable
    //   4381	4386	228	java/lang/Throwable
    //   606	638	638	java/lang/Throwable
    //   1220	1249	1249	java/lang/Throwable
    //   2481	2534	2534	java/lang/Throwable
    //   3035	3050	3378	java/lang/Exception
    //   3058	3069	3378	java/lang/Exception
    //   3077	3089	3378	java/lang/Exception
    //   3097	3105	3378	java/lang/Exception
    //   3116	3122	3378	java/lang/Exception
    //   3130	3169	3378	java/lang/Exception
    //   2899	2907	3466	java/lang/Throwable
    //   2915	2921	3466	java/lang/Throwable
    //   2929	2937	3466	java/lang/Throwable
    //   2948	2955	3466	java/lang/Throwable
    //   2966	2979	3466	java/lang/Throwable
    //   2987	3004	3466	java/lang/Throwable
    //   3012	3019	3466	java/lang/Throwable
    //   3035	3050	3466	java/lang/Throwable
    //   3058	3069	3466	java/lang/Throwable
    //   3077	3089	3466	java/lang/Throwable
    //   3097	3105	3466	java/lang/Throwable
    //   3116	3122	3466	java/lang/Throwable
    //   3130	3169	3466	java/lang/Throwable
    //   3388	3393	3466	java/lang/Throwable
    //   3404	3410	3466	java/lang/Throwable
    //   3418	3460	3466	java/lang/Throwable
    //   3547	3553	3466	java/lang/Throwable
    //   2899	2907	3559	finally
    //   2915	2921	3559	finally
    //   2929	2937	3559	finally
    //   2948	2955	3559	finally
    //   2966	2979	3559	finally
    //   2987	3004	3559	finally
    //   3012	3019	3559	finally
    //   3035	3050	3559	finally
    //   3058	3069	3559	finally
    //   3077	3089	3559	finally
    //   3097	3105	3559	finally
    //   3116	3122	3559	finally
    //   3130	3169	3559	finally
    //   3388	3393	3559	finally
    //   3404	3410	3559	finally
    //   3418	3460	3559	finally
    //   3547	3553	3559	finally
    //   3220	3227	3811	finally
    //   3227	3230	3811	finally
    //   3813	3816	3811	finally
    //   3326	3333	3958	java/io/IOException
    //   3338	3343	3958	java/io/IOException
    //   3348	3353	3958	java/io/IOException
    //   902	909	4103	java/io/IOException
    //   914	919	4103	java/io/IOException
    //   924	929	4103	java/io/IOException
    //   3662	3669	4153	java/io/IOException
    //   3674	3679	4153	java/io/IOException
    //   3684	3689	4153	java/io/IOException
    //   267	297	4408	java/lang/Throwable
    //   3220	3227	4414	java/lang/InterruptedException
    //   1120	1157	4419	java/lang/Throwable
    //   2701	2706	4424	finally
    //   2713	2720	4424	finally
    //   2724	2733	4424	finally
    //   2743	2753	4424	finally
    //   2809	2820	4424	finally
    //   2824	2834	4424	finally
    //   2838	2844	4424	finally
    //   2862	2873	4424	finally
    //   2886	2891	4424	finally
    //   3498	3505	4424	finally
    //   3513	3519	4424	finally
    //   3533	3539	4424	finally
    //   558	563	4437	finally
    //   572	580	4437	finally
    //   584	591	4437	finally
    //   600	606	4437	finally
    //   1197	1205	4437	finally
    //   1214	1220	4437	finally
    //   1289	1300	4437	finally
    //   1304	1310	4437	finally
    //   1319	1333	4437	finally
    //   1337	1347	4437	finally
    //   1351	1363	4437	finally
    //   1367	1381	4437	finally
    //   1385	1394	4437	finally
    //   1398	1404	4437	finally
    //   1408	1447	4437	finally
    //   1459	1467	4437	finally
    //   1471	1478	4437	finally
    //   1482	1517	4437	finally
    //   1521	1527	4437	finally
    //   1531	1559	4437	finally
    //   1563	1570	4437	finally
    //   1579	1587	4437	finally
    //   1591	1598	4437	finally
    //   1609	1624	4437	finally
    //   1628	1639	4437	finally
    //   1643	1659	4437	finally
    //   1663	1671	4437	finally
    //   1675	1685	4437	finally
    //   1689	1695	4437	finally
    //   1699	1727	4437	finally
    //   1731	1737	4437	finally
    //   1741	1748	4437	finally
    //   1752	1759	4437	finally
    //   1763	1768	4437	finally
    //   1772	1780	4437	finally
    //   1784	1801	4437	finally
    //   1805	1818	4437	finally
    //   1822	1832	4437	finally
    //   1836	1848	4437	finally
    //   1852	1857	4437	finally
    //   1861	1867	4437	finally
    //   1880	1888	4437	finally
    //   1892	1899	4437	finally
    //   1903	1908	4437	finally
    //   1912	1917	4437	finally
    //   1931	1953	4437	finally
    //   1960	1971	4437	finally
    //   1975	1986	4437	finally
    //   1990	2001	4437	finally
    //   2005	2018	4437	finally
    //   2022	2034	4437	finally
    //   2038	2045	4437	finally
    //   2049	2055	4437	finally
    //   2059	2068	4437	finally
    //   2072	2184	4437	finally
    //   2188	2200	4437	finally
    //   2204	2214	4437	finally
    //   2222	2236	4437	finally
    //   2244	2250	4437	finally
    //   2258	2286	4437	finally
    //   2294	2301	4437	finally
    //   2325	2334	4437	finally
    //   2342	2351	4437	finally
    //   2359	2371	4437	finally
    //   2379	2391	4437	finally
    //   2404	2425	4437	finally
    //   2440	2449	4437	finally
    //   2457	2463	4437	finally
    //   2475	2481	4437	finally
    //   2597	2610	4437	finally
    //   2621	2628	4437	finally
    //   2648	2654	4437	finally
    //   2675	2688	4437	finally
    //   3704	3710	4437	finally
    //   3747	3752	4437	finally
    //   3780	3786	4437	finally
    //   606	638	4446	finally
    //   1220	1249	4454	finally
    //   2481	2534	4462	finally
    //   2688	2697	4470	finally
    //   600	606	4479	java/lang/Throwable
    //   1960	1971	4514	java/lang/Throwable
    //   1975	1986	4514	java/lang/Throwable
    //   1990	2001	4514	java/lang/Throwable
    //   2005	2018	4514	java/lang/Throwable
    //   2022	2034	4549	java/lang/Throwable
    //   2038	2045	4549	java/lang/Throwable
    //   2049	2055	4549	java/lang/Throwable
    //   2059	2068	4549	java/lang/Throwable
    //   2072	2184	4549	java/lang/Throwable
    //   2188	2200	4549	java/lang/Throwable
    //   2204	2214	4549	java/lang/Throwable
    //   2222	2236	4588	java/lang/Throwable
    //   2244	2250	4588	java/lang/Throwable
    //   2258	2286	4588	java/lang/Throwable
    //   2294	2301	4588	java/lang/Throwable
    //   2325	2334	4588	java/lang/Throwable
    //   2342	2351	4588	java/lang/Throwable
    //   3747	3752	4588	java/lang/Throwable
    //   3780	3786	4588	java/lang/Throwable
    //   2359	2371	4631	java/lang/Throwable
    //   2379	2391	4631	java/lang/Throwable
    //   2404	2425	4631	java/lang/Throwable
    //   2440	2449	4631	java/lang/Throwable
    //   2457	2463	4631	java/lang/Throwable
    //   2597	2610	4631	java/lang/Throwable
    //   2621	2628	4631	java/lang/Throwable
    //   2648	2654	4631	java/lang/Throwable
    //   2675	2688	4631	java/lang/Throwable
    //   2475	2481	4674	java/lang/Throwable
    //   2688	2697	4709	java/lang/Throwable
    //   3704	3710	4748	java/lang/Throwable
    //   558	563	4879	java/lang/Throwable
    //   572	580	4879	java/lang/Throwable
    //   584	591	4879	java/lang/Throwable
    //   1197	1205	4879	java/lang/Throwable
    //   1214	1220	4879	java/lang/Throwable
    //   1289	1300	4879	java/lang/Throwable
    //   1304	1310	4879	java/lang/Throwable
    //   1319	1333	4879	java/lang/Throwable
    //   1337	1347	4879	java/lang/Throwable
    //   1351	1363	4879	java/lang/Throwable
    //   1367	1381	4879	java/lang/Throwable
    //   1385	1394	4879	java/lang/Throwable
    //   1398	1404	4879	java/lang/Throwable
    //   1408	1447	4879	java/lang/Throwable
    //   1459	1467	4879	java/lang/Throwable
    //   1471	1478	4879	java/lang/Throwable
    //   1482	1517	4879	java/lang/Throwable
    //   1521	1527	4879	java/lang/Throwable
    //   1531	1559	4879	java/lang/Throwable
    //   1563	1570	4879	java/lang/Throwable
    //   1579	1587	4879	java/lang/Throwable
    //   1591	1598	4879	java/lang/Throwable
    //   1609	1624	4879	java/lang/Throwable
    //   1628	1639	4879	java/lang/Throwable
    //   1643	1659	4879	java/lang/Throwable
    //   1663	1671	4879	java/lang/Throwable
    //   1675	1685	4879	java/lang/Throwable
    //   1689	1695	4879	java/lang/Throwable
    //   1699	1727	4879	java/lang/Throwable
    //   1731	1737	4879	java/lang/Throwable
    //   1741	1748	4879	java/lang/Throwable
    //   1752	1759	4879	java/lang/Throwable
    //   1763	1768	4879	java/lang/Throwable
    //   1772	1780	4879	java/lang/Throwable
    //   1784	1801	4879	java/lang/Throwable
    //   1805	1818	4879	java/lang/Throwable
    //   1822	1832	4879	java/lang/Throwable
    //   1836	1848	4879	java/lang/Throwable
    //   1852	1857	4879	java/lang/Throwable
    //   1861	1867	4879	java/lang/Throwable
    //   1880	1888	4879	java/lang/Throwable
    //   1892	1899	4879	java/lang/Throwable
    //   1903	1908	4879	java/lang/Throwable
    //   1912	1917	4879	java/lang/Throwable
    //   1931	1953	4879	java/lang/Throwable
    //   2701	2706	4920	java/lang/Throwable
    //   2713	2720	4920	java/lang/Throwable
    //   2724	2733	4920	java/lang/Throwable
    //   2743	2753	4920	java/lang/Throwable
    //   2809	2820	4920	java/lang/Throwable
    //   2824	2834	4920	java/lang/Throwable
    //   2838	2844	4920	java/lang/Throwable
    //   2862	2873	4920	java/lang/Throwable
    //   2886	2891	4920	java/lang/Throwable
    //   3498	3505	4920	java/lang/Throwable
    //   3513	3519	4920	java/lang/Throwable
    //   3533	3539	4920	java/lang/Throwable
    //   3187	3194	4955	java/lang/Throwable
    //   3198	3207	4955	java/lang/Throwable
    //   3211	3214	4955	java/lang/Throwable
    //   3820	3823	4955	java/lang/Throwable
    //   3827	3837	4955	java/lang/Throwable
    //   3841	3848	4955	java/lang/Throwable
    //   3852	3868	4955	java/lang/Throwable
    //   3871	3926	4955	java/lang/Throwable
    //   3930	3941	4955	java/lang/Throwable
    //   3187	3194	4987	finally
    //   3198	3207	4987	finally
    //   3211	3214	4987	finally
    //   3820	3823	4987	finally
    //   3827	3837	4987	finally
    //   3841	3848	4987	finally
    //   3852	3868	4987	finally
    //   3871	3926	4987	finally
    //   3930	3941	4987	finally
    //   678	694	5004	finally
    //   694	702	5004	finally
    //   705	725	5004	finally
    //   740	745	5004	finally
    //   745	806	5004	finally
    //   4022	4036	5004	finally
    //   4039	4055	5004	finally
    //   4055	4061	5004	finally
    //   4064	4078	5004	finally
    //   4081	4086	5004	finally
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(NetworkUtil.a(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "VipDownload", "ip", 0, paramInt, paramString1, paramContext, paramString2, "");
      return;
      paramString2 = "unknow";
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      int i = NetworkUtil.a(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isQualityNetwork type=" + i);
      }
      if ((i != 3) && (i != 4))
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return false;
    }
    if ((paramDownloadTask.jdField_a_of_type_JavaUtilList == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilList.size() < 1) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap.size() < 1) || (TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    paramDownloadTask = paramDownloadTask.jdField_a_of_type_JavaUtilList.iterator();
    while (paramDownloadTask.hasNext())
    {
      String str = (String)paramDownloadTask.next();
      if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramFile1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        bool2 = paramFile1.exists();
        if (!bool2)
        {
          bool2 = bool1;
          return bool2;
        }
        long l = System.currentTimeMillis();
        try
        {
          if (!paramFile2.exists()) {
            break label252;
          }
          File[] arrayOfFile1 = paramFile2.listFiles();
          i = 0;
          if (i >= arrayOfFile1.length) {
            break label257;
          }
          File localFile = arrayOfFile1[i];
          if (localFile.isDirectory())
          {
            File[] arrayOfFile2 = localFile.listFiles();
            if (arrayOfFile2 != null)
            {
              int k = arrayOfFile2.length;
              int j = 0;
              if (j < k)
              {
                arrayOfFile2[j].delete();
                j += 1;
                continue;
              }
              localFile.delete();
            }
          }
          else
          {
            arrayOfFile1[i].delete();
          }
        }
        catch (Exception paramFile1)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipResource|unzip resource fail targetDir=" + paramFile2.getAbsolutePath());
            bool1 = bool3;
          }
        }
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipResource|use time " + (System.currentTimeMillis() - l) + " targetDir=" + paramFile2.getAbsolutePath());
        bool2 = bool1;
        continue;
        paramFile2.mkdirs();
      }
      finally {}
      label252:
      ZipUtils.a(paramFile1, paramFile2.getAbsolutePath() + File.separatorChar);
      label257:
      paramFile1.delete();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipResource|unzip resource succ targetDir=" + paramFile2.getAbsolutePath());
      }
      bool1 = true;
      continue;
      i += 1;
    }
  }
  
  public static boolean a(String paramString)
  {
    int i;
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      i = ((Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
    }
    while (i > 0) {
      if ((int)(System.currentTimeMillis() / 1000L) < i + 600)
      {
        return true;
        i = 0;
      }
      else
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return false;
      }
    }
    return false;
  }
  
  /* Error */
  public DownloaderInterface a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +174 -> 179
    //   8: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+21 -> 36, 1:+25->40, 2:+97->112
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: iload_1
    //   44: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 772	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   50: ifeq +20 -> 70
    //   53: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: iload_1
    //   57: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 773	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 779	com/tencent/mobileqq/vip/DownloaderInterface
    //   66: astore_2
    //   67: goto -31 -> 36
    //   70: new 781	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   73: dup
    //   74: iconst_0
    //   75: invokespecial 784	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   78: astore_2
    //   79: new 786	ewy
    //   82: dup
    //   83: aload_0
    //   84: getfield 48	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   87: aload_2
    //   88: invokespecial 789	ewy:<init>	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   91: astore_2
    //   92: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   95: iload_1
    //   96: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aload_2
    //   100: invokevirtual 676	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: goto -68 -> 36
    //   107: astore_2
    //   108: aload_3
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    //   112: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   115: iload_1
    //   116: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokevirtual 772	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   122: ifeq +20 -> 142
    //   125: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   128: iload_1
    //   129: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: invokevirtual 773	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 779	com/tencent/mobileqq/vip/DownloaderInterface
    //   138: astore_2
    //   139: goto -103 -> 36
    //   142: new 781	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   145: dup
    //   146: iconst_0
    //   147: invokespecial 784	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   150: astore_2
    //   151: new 786	ewy
    //   154: dup
    //   155: aload_0
    //   156: getfield 48	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   159: aload_2
    //   160: invokespecial 789	ewy:<init>	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   163: astore_2
    //   164: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   167: iload_1
    //   168: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: aload_2
    //   172: invokevirtual 676	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: goto -140 -> 36
    //   179: aconst_null
    //   180: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	DownloaderFactory
    //   0	181	1	paramInt	int
    //   1	99	2	localObject1	Object
    //   107	4	2	localObject2	Object
    //   138	34	2	localObject3	Object
    //   11	98	3	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   36	38	107	finally
    //   40	67	107	finally
    //   70	104	107	finally
    //   108	110	107	finally
    //   112	139	107	finally
    //   142	176	107	finally
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy...");
    }
    synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      synchronized (b)
      {
        Iterator localIterator = b.entrySet().iterator();
        if (localIterator.hasNext()) {
          ((DownloaderInterface)((Map.Entry)localIterator.next()).getValue()).a();
        }
      }
    }
    b.clear();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */