package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import efr;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetSplashImpl
{
  static final int jdField_a_of_type_Int = 3;
  static final long jdField_a_of_type_Long = 86400000L;
  static final String jdField_a_of_type_JavaLangString = "splashshowtime";
  
  private static int a(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
    try
    {
      long l = (localSimpleDateFormat.parse(paramString2).getTime() - localSimpleDateFormat.parse(paramString1).getTime()) / 86400000L;
      return (int)l;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  /* Error */
  public static long a(android.app.Activity paramActivity)
  {
    // Byte code:
    //   0: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   3: lstore 18
    //   5: ldc2_w 54
    //   8: lstore 6
    //   10: aload_0
    //   11: instanceof 57
    //   14: ifeq +737 -> 751
    //   17: aload_0
    //   18: checkcast 57	com/tencent/mobileqq/app/IphoneTitleBarActivity
    //   21: ldc 58
    //   23: invokevirtual 62	com/tencent/mobileqq/app/IphoneTitleBarActivity:setContentViewNoTitle	(I)V
    //   26: aload_0
    //   27: ldc 63
    //   29: invokevirtual 69	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   32: checkcast 71	android/widget/ImageView
    //   35: astore 24
    //   37: aconst_null
    //   38: astore 20
    //   40: aconst_null
    //   41: astore 21
    //   43: aload_0
    //   44: invokestatic 77	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   47: astore 23
    //   49: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +29 -> 81
    //   55: ldc 85
    //   57: iconst_2
    //   58: new 87	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   65: ldc 90
    //   67: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload 23
    //   72: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: invokevirtual 106	android/app/Activity:getFilesDir	()Ljava/io/File;
    //   85: astore 25
    //   87: aload 25
    //   89: ifnull +704 -> 793
    //   92: aload 25
    //   94: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   97: astore 22
    //   99: aload 23
    //   101: ldc 113
    //   103: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifne +742 -> 848
    //   109: new 23	java/text/SimpleDateFormat
    //   112: dup
    //   113: ldc 25
    //   115: invokespecial 28	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   118: new 34	java/util/Date
    //   121: dup
    //   122: invokespecial 120	java/util/Date:<init>	()V
    //   125: invokevirtual 124	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   128: aload 23
    //   130: invokestatic 126	com/tencent/mobileqq/startup/step/SetSplashImpl:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   133: ifne +715 -> 848
    //   136: aload 25
    //   138: ifnull +696 -> 834
    //   141: new 87	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   148: aload 22
    //   150: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 128
    //   155: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: invokestatic 130	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   162: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 128
    //   167: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 132
    //   172: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: astore 23
    //   180: new 108	java/io/File
    //   183: dup
    //   184: aload 23
    //   186: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   189: astore 25
    //   191: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +37 -> 231
    //   197: ldc 85
    //   199: iconst_2
    //   200: new 87	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   207: aload 23
    //   209: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc 135
    //   214: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 25
    //   219: invokevirtual 138	java/io/File:exists	()Z
    //   222: invokevirtual 141	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   225: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: lload 6
    //   233: lstore 4
    //   235: aload 25
    //   237: invokevirtual 138	java/io/File:exists	()Z
    //   240: ifeq +61 -> 301
    //   243: new 146	android/graphics/drawable/BitmapDrawable
    //   246: dup
    //   247: aload_0
    //   248: invokevirtual 150	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   251: aload 23
    //   253: invokestatic 155	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   256: invokespecial 158	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   259: astore 20
    //   261: aload 20
    //   263: ifnull +537 -> 800
    //   266: lconst_1
    //   267: lstore 4
    //   269: aload 20
    //   271: astore 21
    //   273: lload 4
    //   275: lstore 6
    //   277: aload 21
    //   279: astore 20
    //   281: lload 6
    //   283: lstore 4
    //   285: aload 21
    //   287: ifnull +14 -> 301
    //   290: invokestatic 160	com/tencent/mobileqq/startup/step/SetSplashImpl:a	()V
    //   293: lload 6
    //   295: lstore 4
    //   297: aload 21
    //   299: astore 20
    //   301: aload 20
    //   303: ifnonnull +966 -> 1269
    //   306: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +11 -> 320
    //   312: ldc 162
    //   314: iconst_2
    //   315: ldc 164
    //   317: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: new 87	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   327: aload 22
    //   329: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc 128
    //   334: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc 166
    //   339: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc 128
    //   344: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: astore 25
    //   352: new 108	java/io/File
    //   355: dup
    //   356: new 87	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   363: aload 22
    //   365: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc 128
    //   370: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc 166
    //   375: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   384: astore 26
    //   386: aconst_null
    //   387: astore 23
    //   389: aconst_null
    //   390: astore 21
    //   392: aload 23
    //   394: astore 22
    //   396: aload 26
    //   398: ifnull +557 -> 955
    //   401: aload 23
    //   403: astore 22
    //   405: aload 26
    //   407: invokevirtual 138	java/io/File:exists	()Z
    //   410: ifeq +545 -> 955
    //   413: aload 23
    //   415: astore 22
    //   417: aload 26
    //   419: invokevirtual 169	java/io/File:isDirectory	()Z
    //   422: ifeq +533 -> 955
    //   425: aload 26
    //   427: invokevirtual 173	java/io/File:listFiles	()[Ljava/io/File;
    //   430: astore 26
    //   432: aload 26
    //   434: arraylength
    //   435: istore_2
    //   436: lconst_0
    //   437: lstore 12
    //   439: lconst_0
    //   440: lstore 10
    //   442: iconst_0
    //   443: istore_1
    //   444: aload 21
    //   446: astore 22
    //   448: iload_1
    //   449: iload_2
    //   450: if_icmpge +505 -> 955
    //   453: aload 26
    //   455: iload_1
    //   456: aaload
    //   457: astore 27
    //   459: aload 21
    //   461: astore 23
    //   463: lload 12
    //   465: lstore 14
    //   467: lload 10
    //   469: lstore 16
    //   471: aload 27
    //   473: ifnull +259 -> 732
    //   476: aload 27
    //   478: invokevirtual 176	java/io/File:getName	()Ljava/lang/String;
    //   481: astore 28
    //   483: aload 28
    //   485: ldc 178
    //   487: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   490: astore 29
    //   492: aload 21
    //   494: astore 23
    //   496: lload 12
    //   498: lstore 14
    //   500: lload 10
    //   502: lstore 16
    //   504: aload 29
    //   506: ifnull +226 -> 732
    //   509: aload 21
    //   511: astore 23
    //   513: lload 12
    //   515: lstore 14
    //   517: lload 10
    //   519: lstore 16
    //   521: aload 29
    //   523: arraylength
    //   524: iconst_3
    //   525: if_icmpne +207 -> 732
    //   528: aload 29
    //   530: iconst_0
    //   531: aaload
    //   532: astore 22
    //   534: lload 12
    //   536: lstore 6
    //   538: lload 10
    //   540: lstore 8
    //   542: aload 22
    //   544: ifnull +57 -> 601
    //   547: lload 12
    //   549: lstore 6
    //   551: lload 10
    //   553: lstore 8
    //   555: aload 22
    //   557: invokevirtual 185	java/lang/String:trim	()Ljava/lang/String;
    //   560: ldc 113
    //   562: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   565: ifne +36 -> 601
    //   568: aload 22
    //   570: ldc 187
    //   572: invokevirtual 191	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   575: istore_3
    //   576: aload 22
    //   578: iconst_0
    //   579: iload_3
    //   580: invokevirtual 195	java/lang/String:substring	(II)Ljava/lang/String;
    //   583: invokestatic 201	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   586: lstore 8
    //   588: aload 22
    //   590: iload_3
    //   591: iconst_1
    //   592: iadd
    //   593: invokevirtual 204	java/lang/String:substring	(I)Ljava/lang/String;
    //   596: invokestatic 201	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   599: lstore 6
    //   601: lload 8
    //   603: lload 6
    //   605: invokestatic 207	com/tencent/mobileqq/startup/step/SetSplashImpl:a	(JJ)Z
    //   608: ifeq +262 -> 870
    //   611: aload 21
    //   613: astore 22
    //   615: aload 21
    //   617: ifnonnull +56 -> 673
    //   620: new 108	java/io/File
    //   623: dup
    //   624: new 87	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   631: aload 25
    //   633: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload 29
    //   638: iconst_1
    //   639: aaload
    //   640: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   649: astore 21
    //   651: aload 21
    //   653: astore 22
    //   655: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   658: ifeq +15 -> 673
    //   661: ldc 162
    //   663: iconst_4
    //   664: ldc 212
    //   666: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: aload 21
    //   671: astore 22
    //   673: aload 22
    //   675: astore 23
    //   677: lload 6
    //   679: lstore 14
    //   681: lload 8
    //   683: lstore 16
    //   685: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +44 -> 732
    //   691: ldc 162
    //   693: iconst_2
    //   694: new 87	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   701: ldc 214
    //   703: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload 27
    //   708: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   711: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   720: lload 8
    //   722: lstore 16
    //   724: lload 6
    //   726: lstore 14
    //   728: aload 22
    //   730: astore 23
    //   732: iload_1
    //   733: iconst_1
    //   734: iadd
    //   735: istore_1
    //   736: aload 23
    //   738: astore 21
    //   740: lload 14
    //   742: lstore 12
    //   744: lload 16
    //   746: lstore 10
    //   748: goto -304 -> 444
    //   751: aload_0
    //   752: ldc 58
    //   754: invokevirtual 217	android/app/Activity:setContentView	(I)V
    //   757: goto -731 -> 26
    //   760: astore 20
    //   762: aload 20
    //   764: invokestatic 223	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   767: astore 20
    //   769: ldc 225
    //   771: iconst_1
    //   772: aload 20
    //   774: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload_0
    //   778: ldc 227
    //   780: aload 20
    //   782: invokestatic 232	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload_0
    //   786: invokevirtual 235	android/app/Activity:finish	()V
    //   789: ldc2_w 54
    //   792: lreturn
    //   793: ldc 237
    //   795: astore 22
    //   797: goto -698 -> 99
    //   800: ldc2_w 54
    //   803: lstore 4
    //   805: goto -536 -> 269
    //   808: astore 20
    //   810: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   813: ifeq +13 -> 826
    //   816: ldc 85
    //   818: iconst_2
    //   819: ldc 239
    //   821: aload 20
    //   823: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   826: aload 20
    //   828: invokevirtual 243	java/lang/Throwable:printStackTrace	()V
    //   831: goto -554 -> 277
    //   834: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq +11 -> 848
    //   840: ldc 85
    //   842: iconst_2
    //   843: ldc 245
    //   845: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   848: aconst_null
    //   849: astore 20
    //   851: ldc2_w 54
    //   854: lstore 4
    //   856: goto -555 -> 301
    //   859: astore 22
    //   861: lconst_0
    //   862: lstore 8
    //   864: lconst_0
    //   865: lstore 6
    //   867: goto -266 -> 601
    //   870: aload 21
    //   872: astore 22
    //   874: lload 6
    //   876: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   879: lcmp
    //   880: ifge -207 -> 673
    //   883: new 108	java/io/File
    //   886: dup
    //   887: new 87	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   894: aload 25
    //   896: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload 28
    //   901: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   910: astore 23
    //   912: aload 21
    //   914: astore 22
    //   916: aload 23
    //   918: invokevirtual 138	java/io/File:exists	()Z
    //   921: ifeq -248 -> 673
    //   924: aload 23
    //   926: invokevirtual 248	java/io/File:delete	()Z
    //   929: pop
    //   930: aload 21
    //   932: astore 22
    //   934: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   937: ifeq -264 -> 673
    //   940: ldc 162
    //   942: iconst_4
    //   943: ldc 250
    //   945: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   948: aload 21
    //   950: astore 22
    //   952: goto -279 -> 673
    //   955: aload 22
    //   957: ifnull +312 -> 1269
    //   960: aload 22
    //   962: invokevirtual 138	java/io/File:exists	()Z
    //   965: ifeq +304 -> 1269
    //   968: aload 22
    //   970: invokevirtual 253	java/io/File:isFile	()Z
    //   973: ifeq +296 -> 1269
    //   976: new 146	android/graphics/drawable/BitmapDrawable
    //   979: dup
    //   980: aload_0
    //   981: invokevirtual 150	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   984: aload 22
    //   986: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   989: invokestatic 155	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   992: invokespecial 158	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   995: astore 21
    //   997: aload 21
    //   999: ifnull +185 -> 1184
    //   1002: lconst_1
    //   1003: lstore 4
    //   1005: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1008: ifeq +11 -> 1019
    //   1011: ldc 162
    //   1013: iconst_4
    //   1014: ldc 255
    //   1016: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1019: aload 21
    //   1021: astore 20
    //   1023: aload 20
    //   1025: ifnull +241 -> 1266
    //   1028: invokestatic 160	com/tencent/mobileqq/startup/step/SetSplashImpl:a	()V
    //   1031: aload 20
    //   1033: ifnonnull +192 -> 1225
    //   1036: new 146	android/graphics/drawable/BitmapDrawable
    //   1039: dup
    //   1040: aload_0
    //   1041: invokevirtual 150	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1044: aload_0
    //   1045: invokevirtual 259	android/app/Activity:getAssets	()Landroid/content/res/AssetManager;
    //   1048: ldc_w 261
    //   1051: invokevirtual 267	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1054: invokespecial 270	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   1057: astore 21
    //   1059: aload 21
    //   1061: astore 20
    //   1063: aload 20
    //   1065: ifnull +10 -> 1075
    //   1068: aload 24
    //   1070: aload 20
    //   1072: invokevirtual 274	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1075: aload 24
    //   1077: invokevirtual 278	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   1080: astore 20
    //   1082: aload 20
    //   1084: ifnull +90 -> 1174
    //   1087: aload 20
    //   1089: instanceof 146
    //   1092: ifne +11 -> 1103
    //   1095: aload 20
    //   1097: instanceof 280
    //   1100: ifeq +74 -> 1174
    //   1103: aload_0
    //   1104: invokevirtual 150	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1107: invokevirtual 286	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1110: getfield 291	android/util/DisplayMetrics:widthPixels	I
    //   1113: istore_1
    //   1114: aload_0
    //   1115: invokevirtual 150	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1118: invokevirtual 286	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1121: getfield 294	android/util/DisplayMetrics:heightPixels	I
    //   1124: istore_2
    //   1125: aload 20
    //   1127: invokevirtual 300	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   1130: iload_1
    //   1131: imul
    //   1132: aload 20
    //   1134: invokevirtual 303	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   1137: idiv
    //   1138: istore_3
    //   1139: aload 24
    //   1141: invokevirtual 307	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1144: astore_0
    //   1145: aload_0
    //   1146: iload_1
    //   1147: putfield 312	android/view/ViewGroup$LayoutParams:width	I
    //   1150: aload_0
    //   1151: iload_3
    //   1152: putfield 315	android/view/ViewGroup$LayoutParams:height	I
    //   1155: aload 24
    //   1157: aload_0
    //   1158: invokevirtual 319	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1161: iload_3
    //   1162: iload_2
    //   1163: if_icmpgt +65 -> 1228
    //   1166: aload 24
    //   1168: getstatic 325	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   1171: invokevirtual 329	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1174: lload 4
    //   1176: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   1179: lload 18
    //   1181: lsub
    //   1182: lmul
    //   1183: lreturn
    //   1184: ldc2_w 54
    //   1187: lstore 4
    //   1189: goto -184 -> 1005
    //   1192: astore 22
    //   1194: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1197: ifeq +13 -> 1210
    //   1200: ldc 85
    //   1202: iconst_2
    //   1203: ldc 239
    //   1205: aload 22
    //   1207: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1210: aload 22
    //   1212: invokevirtual 243	java/lang/Throwable:printStackTrace	()V
    //   1215: goto -192 -> 1023
    //   1218: astore 21
    //   1220: aload 21
    //   1222: invokevirtual 243	java/lang/Throwable:printStackTrace	()V
    //   1225: goto -162 -> 1063
    //   1228: iload_3
    //   1229: iload_2
    //   1230: if_icmple -56 -> 1174
    //   1233: aload 24
    //   1235: getstatic 332	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1238: invokevirtual 329	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1241: goto -67 -> 1174
    //   1244: astore_0
    //   1245: aload_0
    //   1246: invokevirtual 243	java/lang/Throwable:printStackTrace	()V
    //   1249: ldc2_w 54
    //   1252: lstore 4
    //   1254: goto -80 -> 1174
    //   1257: astore 22
    //   1259: aload 21
    //   1261: astore 20
    //   1263: goto -69 -> 1194
    //   1266: goto -235 -> 1031
    //   1269: goto -238 -> 1031
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1272	0	paramActivity	android.app.Activity
    //   443	704	1	i	int
    //   435	796	2	j	int
    //   575	656	3	k	int
    //   233	1020	4	l1	long
    //   8	867	6	l2	long
    //   540	323	8	l3	long
    //   440	307	10	l4	long
    //   437	306	12	l5	long
    //   465	276	14	l6	long
    //   469	276	16	l7	long
    //   3	1177	18	l8	long
    //   38	264	20	localObject1	Object
    //   760	3	20	localNotFoundException	android.content.res.Resources.NotFoundException
    //   767	14	20	str1	String
    //   808	19	20	localThrowable1	java.lang.Throwable
    //   849	413	20	localObject2	Object
    //   41	1019	21	localObject3	Object
    //   1218	42	21	localThrowable2	java.lang.Throwable
    //   97	699	22	localObject4	Object
    //   859	1	22	localException	Exception
    //   872	113	22	localObject5	Object
    //   1192	19	22	localThrowable3	java.lang.Throwable
    //   1257	1	22	localThrowable4	java.lang.Throwable
    //   47	878	23	localObject6	Object
    //   35	1199	24	localImageView	android.widget.ImageView
    //   85	810	25	localObject7	Object
    //   384	70	26	localObject8	Object
    //   457	250	27	localObject9	Object
    //   481	419	28	str2	String
    //   490	147	29	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   10	26	760	android/content/res/Resources$NotFoundException
    //   751	757	760	android/content/res/Resources$NotFoundException
    //   243	261	808	java/lang/Throwable
    //   568	601	859	java/lang/Exception
    //   976	997	1192	java/lang/Throwable
    //   1036	1059	1218	java/lang/Throwable
    //   1075	1082	1244	java/lang/Throwable
    //   1087	1103	1244	java/lang/Throwable
    //   1103	1161	1244	java/lang/Throwable
    //   1166	1174	1244	java/lang/Throwable
    //   1233	1241	1244	java/lang/Throwable
    //   1005	1019	1257	java/lang/Throwable
  }
  
  private static void a()
  {
    ThreadManager.a().postDelayed(new efr(), 5000L);
  }
  
  public static boolean a()
  {
    long l1 = BaseApplicationImpl.a().getSharedPreferences("banner_and_splash", 0).getLong("splashshowtime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 > l1) && (l2 <= 86400000L + l1)) {
      return false;
    }
    if (l2 > l1 + 86400000L)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
      Object localObject1 = localBaseApplicationImpl.getFilesDir();
      int j;
      long l4;
      long l3;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        localObject2 = new File((String)localObject1 + "/" + "splashpic");
        if ((localObject2 != null) && (((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
        {
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 != null)
          {
            j = localObject2.length;
            l4 = 0L;
            l3 = 0L;
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          long l5;
          long l6;
          for (;;)
          {
            if (i >= j) {
              break label342;
            }
            Object localObject3 = localObject2[i];
            l5 = l4;
            l6 = l3;
            if (localObject3 != null)
            {
              localObject3 = ((File)localObject3).getName().split("_");
              l5 = l4;
              l6 = l3;
              if (localObject3 != null)
              {
                l5 = l4;
                l6 = l3;
                if (localObject3.length == 3)
                {
                  localObject3 = localObject3[0];
                  l1 = l4;
                  l2 = l3;
                  if (localObject3 != null)
                  {
                    l1 = l4;
                    l2 = l3;
                    if (((String)localObject3).trim().equals("")) {}
                  }
                  try
                  {
                    int k = ((String)localObject3).indexOf("|");
                    l2 = Long.parseLong(((String)localObject3).substring(0, k));
                    l1 = Long.parseLong(((String)localObject3).substring(k + 1));
                    l5 = l1;
                    l6 = l2;
                    if (a(l2, l1))
                    {
                      return true;
                      localObject1 = "/data/data/com.tencent.mobileqq/files";
                    }
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      l2 = 0L;
                      l1 = 0L;
                    }
                  }
                }
              }
            }
          }
          i += 1;
          l4 = l5;
          l3 = l6;
        }
      }
      label342:
      Object localObject2 = SharedPreUtils.b(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.i("SetSplash", 2, "bir = " + (String)localObject2);
      }
      if ((!((String)localObject2).equals("")) && (a(new SimpleDateFormat("MM-dd").format(new Date()), (String)localObject2) == 0))
      {
        localObject1 = new File((String)localObject1 + "/" + SharedPreUtils.a(localBaseApplicationImpl) + "/" + "birthdayflashlogo.png");
        if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).length() > 1L)) {
          return true;
        }
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SetSplash", 2, "now time less than last show time , something is worng");
    }
    return false;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while ((l < paramLong1) || (l > paramLong2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplashImpl
 * JD-Core Version:    0.7.0.1
 */