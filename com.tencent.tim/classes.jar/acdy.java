import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import oicq.wlogin_sdk.tools.MD5;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class acdy
{
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString1, File paramFile, String paramString2)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      String str = MD5.getFileMD5(paramFile);
      if ((str == null) || (!str.equalsIgnoreCase(paramString2))) {}
    }
    do
    {
      return true;
      paramFile.delete();
      boolean bool = HttpDownloadUtil.a(paramQQAppInterface, paramString1, paramFile);
      if ((paramFile == null) || (!paramFile.exists())) {
        break;
      }
      if (bool != true) {
        break label82;
      }
      paramQQAppInterface = MD5.getFileMD5(paramFile);
    } while ((paramQQAppInterface != null) && (paramQQAppInterface.equalsIgnoreCase(paramString2)));
    return false;
    label82:
    paramFile.delete();
    return false;
  }
  
  /* Error */
  private static boolean av(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 7
    //   6: iload 7
    //   8: istore 8
    //   10: aload_0
    //   11: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +14 -> 28
    //   17: aload_1
    //   18: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +10 -> 31
    //   24: iload 7
    //   26: istore 8
    //   28: iload 8
    //   30: ireturn
    //   31: new 8	java/io/File
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 11
    //   41: new 8	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 12
    //   51: aload 12
    //   53: invokevirtual 12	java/io/File:exists	()Z
    //   56: ifeq +11 -> 67
    //   59: aload 12
    //   61: invokevirtual 50	java/io/File:isDirectory	()Z
    //   64: ifne +36 -> 100
    //   67: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +11 -> 81
    //   73: ldc 57
    //   75: iconst_2
    //   76: ldc 59
    //   78: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: iload 7
    //   83: istore 8
    //   85: iconst_0
    //   86: ifeq -58 -> 28
    //   89: new 65	java/lang/NullPointerException
    //   92: dup
    //   93: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   96: athrow
    //   97: astore_0
    //   98: iconst_0
    //   99: ireturn
    //   100: aload 12
    //   102: invokevirtual 72	java/io/File:listFiles	()[Ljava/io/File;
    //   105: astore 12
    //   107: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +83 -> 193
    //   113: aload 12
    //   115: arraylength
    //   116: istore_3
    //   117: iconst_0
    //   118: istore_2
    //   119: iload_2
    //   120: iload_3
    //   121: if_icmpge +45 -> 166
    //   124: aload 12
    //   126: iload_2
    //   127: aaload
    //   128: astore 13
    //   130: ldc 57
    //   132: iconst_2
    //   133: new 74	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   140: ldc 77
    //   142: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 13
    //   147: invokevirtual 85	java/io/File:getName	()Ljava/lang/String;
    //   150: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: iload_2
    //   160: iconst_1
    //   161: iadd
    //   162: istore_2
    //   163: goto -44 -> 119
    //   166: ldc 57
    //   168: iconst_2
    //   169: new 74	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   176: ldc 90
    //   178: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 12
    //   183: arraylength
    //   184: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload 12
    //   195: arraylength
    //   196: ifgt +36 -> 232
    //   199: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +11 -> 213
    //   205: ldc 57
    //   207: iconst_2
    //   208: ldc 95
    //   210: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: iload 7
    //   215: istore 8
    //   217: iconst_0
    //   218: ifeq -190 -> 28
    //   221: new 65	java/lang/NullPointerException
    //   224: dup
    //   225: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   228: athrow
    //   229: astore_0
    //   230: iconst_0
    //   231: ireturn
    //   232: aload 11
    //   234: invokevirtual 12	java/io/File:exists	()Z
    //   237: ifne +36 -> 273
    //   240: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +11 -> 254
    //   246: ldc 57
    //   248: iconst_2
    //   249: ldc 97
    //   251: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: iload 7
    //   256: istore 8
    //   258: iconst_0
    //   259: ifeq -231 -> 28
    //   262: new 65	java/lang/NullPointerException
    //   265: dup
    //   266: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   269: athrow
    //   270: astore_0
    //   271: iconst_0
    //   272: ireturn
    //   273: aload 12
    //   275: arraylength
    //   276: iconst_1
    //   277: isub
    //   278: istore 4
    //   280: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +29 -> 312
    //   286: ldc 57
    //   288: iconst_2
    //   289: new 74	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   296: ldc 99
    //   298: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: iload 4
    //   303: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: new 101	java/io/BufferedReader
    //   315: dup
    //   316: new 103	java/io/InputStreamReader
    //   319: dup
    //   320: new 105	java/io/FileInputStream
    //   323: dup
    //   324: aload_0
    //   325: invokespecial 106	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   328: invokespecial 109	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   331: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   334: astore 12
    //   336: iconst_0
    //   337: istore_2
    //   338: aload 12
    //   340: astore_0
    //   341: aload 12
    //   343: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   346: astore 11
    //   348: aload 11
    //   350: ifnull +594 -> 944
    //   353: aload 12
    //   355: astore_0
    //   356: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +32 -> 391
    //   362: aload 12
    //   364: astore_0
    //   365: ldc 57
    //   367: iconst_2
    //   368: new 74	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   375: ldc 117
    //   377: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 11
    //   382: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload 12
    //   393: astore_0
    //   394: aload 11
    //   396: invokevirtual 121	java/lang/String:length	()I
    //   399: istore_3
    //   400: iload_3
    //   401: iconst_5
    //   402: if_icmpge +61 -> 463
    //   405: iconst_1
    //   406: istore 7
    //   408: iload_2
    //   409: iload 4
    //   411: if_icmpeq +526 -> 937
    //   414: iload 10
    //   416: istore 9
    //   418: aload 12
    //   420: astore_0
    //   421: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +18 -> 442
    //   427: aload 12
    //   429: astore_0
    //   430: ldc 57
    //   432: iconst_2
    //   433: ldc 123
    //   435: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: iload 10
    //   440: istore 9
    //   442: iload 9
    //   444: istore 8
    //   446: aload 12
    //   448: ifnull -420 -> 28
    //   451: aload 12
    //   453: invokevirtual 126	java/io/BufferedReader:close	()V
    //   456: iload 9
    //   458: ireturn
    //   459: astore_0
    //   460: iload 9
    //   462: ireturn
    //   463: aload 12
    //   465: astore_0
    //   466: aload 11
    //   468: ldc 128
    //   470: invokevirtual 132	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   473: astore 11
    //   475: aload 12
    //   477: astore_0
    //   478: aload 11
    //   480: arraylength
    //   481: iconst_2
    //   482: if_icmpeq +9 -> 491
    //   485: iconst_0
    //   486: istore 7
    //   488: goto -80 -> 408
    //   491: aload 12
    //   493: astore_0
    //   494: new 74	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   501: aload_1
    //   502: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc 134
    //   507: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload 11
    //   512: iconst_0
    //   513: aaload
    //   514: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: astore 13
    //   522: aload 12
    //   524: astore_0
    //   525: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq +32 -> 560
    //   531: aload 12
    //   533: astore_0
    //   534: ldc 57
    //   536: iconst_2
    //   537: new 74	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   544: ldc 136
    //   546: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload 13
    //   551: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload 12
    //   562: astore_0
    //   563: new 8	java/io/File
    //   566: dup
    //   567: aload 13
    //   569: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   572: astore 13
    //   574: aload 12
    //   576: astore_0
    //   577: aload 13
    //   579: invokevirtual 12	java/io/File:exists	()Z
    //   582: ifne +26 -> 608
    //   585: aload 12
    //   587: astore_0
    //   588: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +359 -> 950
    //   594: aload 12
    //   596: astore_0
    //   597: ldc 57
    //   599: iconst_2
    //   600: ldc 138
    //   602: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: goto +345 -> 950
    //   608: aload 12
    //   610: astore_0
    //   611: aload 13
    //   613: invokestatic 18	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   616: astore 13
    //   618: aload 13
    //   620: ifnull +90 -> 710
    //   623: aload 12
    //   625: astore_0
    //   626: aload 13
    //   628: invokevirtual 121	java/lang/String:length	()I
    //   631: aload 11
    //   633: iconst_1
    //   634: aaload
    //   635: invokevirtual 121	java/lang/String:length	()I
    //   638: if_icmpeq +72 -> 710
    //   641: aload 12
    //   643: astore_0
    //   644: aload 13
    //   646: invokevirtual 121	java/lang/String:length	()I
    //   649: istore 5
    //   651: aload 12
    //   653: astore_0
    //   654: aload 11
    //   656: iconst_1
    //   657: aaload
    //   658: invokevirtual 121	java/lang/String:length	()I
    //   661: istore 6
    //   663: iconst_0
    //   664: istore_3
    //   665: iload_3
    //   666: iload 5
    //   668: iload 6
    //   670: isub
    //   671: if_icmpge +39 -> 710
    //   674: aload 12
    //   676: astore_0
    //   677: aload 11
    //   679: iconst_1
    //   680: new 74	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   687: ldc 140
    //   689: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload 11
    //   694: iconst_1
    //   695: aaload
    //   696: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: aastore
    //   703: iload_3
    //   704: iconst_1
    //   705: iadd
    //   706: istore_3
    //   707: goto -42 -> 665
    //   710: aload 13
    //   712: ifnull +18 -> 730
    //   715: aload 12
    //   717: astore_0
    //   718: aload 13
    //   720: aload 11
    //   722: iconst_1
    //   723: aaload
    //   724: invokevirtual 24	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   727: ifne +61 -> 788
    //   730: aload 12
    //   732: astore_0
    //   733: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   736: ifeq +220 -> 956
    //   739: aload 12
    //   741: astore_0
    //   742: ldc 57
    //   744: iconst_2
    //   745: new 74	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   752: ldc 142
    //   754: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload 13
    //   759: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: ldc 144
    //   764: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload 11
    //   769: iconst_1
    //   770: aaload
    //   771: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: ldc 146
    //   776: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   782: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   785: goto +171 -> 956
    //   788: iload_2
    //   789: iconst_1
    //   790: iadd
    //   791: istore_2
    //   792: aload 12
    //   794: astore_0
    //   795: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   798: ifeq +31 -> 829
    //   801: aload 12
    //   803: astore_0
    //   804: ldc 57
    //   806: iconst_2
    //   807: new 74	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   814: ldc 148
    //   816: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: iload_2
    //   820: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   823: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: goto -491 -> 338
    //   832: astore 11
    //   834: aconst_null
    //   835: astore_1
    //   836: iconst_1
    //   837: istore 7
    //   839: aload_1
    //   840: astore_0
    //   841: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   844: ifeq +34 -> 878
    //   847: aload_1
    //   848: astore_0
    //   849: ldc 57
    //   851: iconst_2
    //   852: new 74	java/lang/StringBuilder
    //   855: dup
    //   856: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   859: ldc 150
    //   861: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload 11
    //   866: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   869: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: iload 7
    //   880: istore 8
    //   882: aload_1
    //   883: ifnull -855 -> 28
    //   886: aload_1
    //   887: invokevirtual 126	java/io/BufferedReader:close	()V
    //   890: iload 7
    //   892: ireturn
    //   893: astore_0
    //   894: iload 7
    //   896: ireturn
    //   897: astore_1
    //   898: aconst_null
    //   899: astore_0
    //   900: aload_0
    //   901: ifnull +7 -> 908
    //   904: aload_0
    //   905: invokevirtual 126	java/io/BufferedReader:close	()V
    //   908: aload_1
    //   909: athrow
    //   910: astore_0
    //   911: goto -3 -> 908
    //   914: astore_1
    //   915: goto -15 -> 900
    //   918: astore 11
    //   920: iconst_1
    //   921: istore 7
    //   923: aload 12
    //   925: astore_1
    //   926: goto -87 -> 839
    //   929: astore 11
    //   931: aload 12
    //   933: astore_1
    //   934: goto -95 -> 839
    //   937: iload 7
    //   939: istore 9
    //   941: goto -499 -> 442
    //   944: iconst_1
    //   945: istore 7
    //   947: goto -539 -> 408
    //   950: iconst_0
    //   951: istore 7
    //   953: goto -545 -> 408
    //   956: iconst_0
    //   957: istore 7
    //   959: goto -551 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	paramString1	String
    //   0	962	1	paramString2	String
    //   118	702	2	i	int
    //   116	591	3	j	int
    //   278	134	4	k	int
    //   649	22	5	m	int
    //   661	10	6	n	int
    //   4	954	7	bool1	boolean
    //   8	873	8	bool2	boolean
    //   416	524	9	bool3	boolean
    //   1	438	10	bool4	boolean
    //   39	729	11	localObject1	Object
    //   832	33	11	localException1	Exception
    //   918	1	11	localException2	Exception
    //   929	1	11	localException3	Exception
    //   49	883	12	localObject2	Object
    //   128	630	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   89	97	97	java/lang/Exception
    //   221	229	229	java/lang/Exception
    //   262	270	270	java/lang/Exception
    //   451	456	459	java/lang/Exception
    //   31	67	832	java/lang/Exception
    //   67	81	832	java/lang/Exception
    //   100	117	832	java/lang/Exception
    //   130	159	832	java/lang/Exception
    //   166	193	832	java/lang/Exception
    //   193	213	832	java/lang/Exception
    //   232	254	832	java/lang/Exception
    //   273	312	832	java/lang/Exception
    //   312	336	832	java/lang/Exception
    //   886	890	893	java/lang/Exception
    //   31	67	897	finally
    //   67	81	897	finally
    //   100	117	897	finally
    //   130	159	897	finally
    //   166	193	897	finally
    //   193	213	897	finally
    //   232	254	897	finally
    //   273	312	897	finally
    //   312	336	897	finally
    //   904	908	910	java/lang/Exception
    //   341	348	914	finally
    //   356	362	914	finally
    //   365	391	914	finally
    //   394	400	914	finally
    //   421	427	914	finally
    //   430	438	914	finally
    //   466	475	914	finally
    //   478	485	914	finally
    //   494	522	914	finally
    //   525	531	914	finally
    //   534	560	914	finally
    //   563	574	914	finally
    //   577	585	914	finally
    //   588	594	914	finally
    //   597	605	914	finally
    //   611	618	914	finally
    //   626	641	914	finally
    //   644	651	914	finally
    //   654	663	914	finally
    //   677	703	914	finally
    //   718	730	914	finally
    //   733	739	914	finally
    //   742	785	914	finally
    //   795	801	914	finally
    //   804	829	914	finally
    //   841	847	914	finally
    //   849	878	914	finally
    //   341	348	918	java/lang/Exception
    //   356	362	918	java/lang/Exception
    //   365	391	918	java/lang/Exception
    //   394	400	918	java/lang/Exception
    //   466	475	918	java/lang/Exception
    //   478	485	918	java/lang/Exception
    //   494	522	918	java/lang/Exception
    //   525	531	918	java/lang/Exception
    //   534	560	918	java/lang/Exception
    //   563	574	918	java/lang/Exception
    //   577	585	918	java/lang/Exception
    //   588	594	918	java/lang/Exception
    //   597	605	918	java/lang/Exception
    //   611	618	918	java/lang/Exception
    //   626	641	918	java/lang/Exception
    //   644	651	918	java/lang/Exception
    //   654	663	918	java/lang/Exception
    //   677	703	918	java/lang/Exception
    //   718	730	918	java/lang/Exception
    //   733	739	918	java/lang/Exception
    //   742	785	918	java/lang/Exception
    //   795	801	918	java/lang/Exception
    //   804	829	918	java/lang/Exception
    //   421	427	929	java/lang/Exception
    //   430	438	929	java/lang/Exception
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() begin");
    }
    for (;;)
    {
      try
      {
        String str1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/dynamicSplash";
        Object localObject1 = new File(str1);
        if (!((File)localObject1).exists())
        {
          ((File)localObject1).mkdirs();
          localObject3 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          if (((Document)localObject3).getElementsByTagName("splash").getLength() < 1) {
            return false;
          }
        }
        else
        {
          if ((localObject1 == null) || (!((File)localObject1).isDirectory())) {
            continue;
          }
          localObject1 = ((File)localObject1).listFiles();
          if (localObject1 == null) {
            continue;
          }
          j = localObject1.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject2 = localObject1[i];
          if ((localObject2 == null) || (!((File)localObject2).exists())) {
            break label1073;
          }
          ((File)localObject2).delete();
          break label1073;
        }
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        paramString = ((Document)localObject3).getElementsByTagName("img").item(0).getFirstChild().getNodeValue();
        String str3 = ((Document)localObject3).getElementsByTagName("begin").item(0).getFirstChild().getNodeValue();
        String str2 = ((Document)localObject3).getElementsByTagName("end").item(0).getFirstChild().getNodeValue();
        localObject1 = ((Document)localObject3).getElementsByTagName("md5").item(0).getFirstChild().getNodeValue();
        int j = Integer.valueOf(((Document)localObject3).getElementsByTagName("download_net").item(0).getFirstChild().getNodeValue()).intValue();
        int k = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_times").item(0).getFirstChild().getNodeValue()).intValue();
        int m = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_interval").item(0).getFirstChild().getNodeValue()).intValue();
        int n = Integer.valueOf(((Document)localObject3).getElementsByTagName("total_show_times").item(0).getFirstChild().getNodeValue()).intValue();
        Object localObject3 = ((SimpleDateFormat)localObject2).parse(str3).getTime() + "|" + ((SimpleDateFormat)localObject2).parse(str2).getTime();
        int i1 = aqiw.getSystemNetwork(BaseApplication.getContext());
        i = 0;
        if (i1 == 2)
        {
          if (!QLog.isColorLevel()) {
            break label1080;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G2");
          break label1080;
          if (QLog.isColorLevel()) {
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkValue == " + i);
          }
          if (i < j)
          {
            if (!QLog.isColorLevel()) {
              break label1085;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() user network NOT allow download, return");
            break label1085;
          }
        }
        else
        {
          if (i1 == 3)
          {
            if (!QLog.isColorLevel()) {
              break label1087;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G3");
            break label1087;
          }
          if (i1 == 4)
          {
            if (!QLog.isColorLevel()) {
              break label1093;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G4");
            break label1093;
          }
          if (i1 != 1) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            break label1099;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.WIFI");
          break label1099;
        }
        aqmj.a(BaseApplicationImpl.getContext(), paramInt, k, m, n, (String)localObject1, (String)localObject3, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() SUCCESS record to SP");
        }
        if (((SimpleDateFormat)localObject2).parse(str2).getTime() < System.currentTimeMillis())
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() the config is out of date, return");
          break;
        }
        localObject2 = new File(str1 + "/" + (String)localObject1 + ".zip");
        if (!a(paramQQAppInterface, paramString, (File)localObject2, (String)localObject1))
        {
          if (!QLog.isColorLevel()) {
            break label1107;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is filed, return");
          break label1107;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is SUCCESS");
        }
        paramQQAppInterface = str1 + "/" + (String)localObject1;
        paramString = new File(paramQQAppInterface);
        if (!awcf.d((File)localObject2, paramString))
        {
          if ((paramString != null) && (paramString.exists())) {
            paramString.delete();
          }
          if (!QLog.isColorLevel()) {
            break label1109;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is filed, return");
          break label1109;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is SUCCESS");
        }
        if (!av(paramQQAppInterface + "/md5.txt", paramQQAppInterface))
        {
          if (!QLog.isColorLevel()) {
            break label1111;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is filed, return");
          break label1111;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is SUCCESS");
        }
        if ((paramString != null) && (paramString.isDirectory()))
        {
          long l = paramString.lastModified();
          paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
          paramQQAppInterface.putLong("dynamic_splash_config_folder_modify_time", l);
          paramQQAppInterface.commit();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() the folder path of splash is" + str1);
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() finish");
        }
        return true;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() ERROR = " + paramQQAppInterface.getMessage());
        }
        return false;
      }
      label1073:
      i += 1;
      continue;
      label1080:
      int i = 0;
      continue;
      label1085:
      return false;
      label1087:
      i = 10;
      continue;
      label1093:
      i = 20;
      continue;
      label1099:
      i = 100;
    }
    return true;
    label1107:
    return false;
    label1109:
    return false;
    label1111:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acdy
 * JD-Core Version:    0.7.0.1
 */