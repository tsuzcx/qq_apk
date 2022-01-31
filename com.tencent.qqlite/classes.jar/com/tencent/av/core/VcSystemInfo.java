package com.tencent.av.core;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import jj;

public class VcSystemInfo
{
  public static final int a = 0;
  static long jdField_a_of_type_Long = 0L;
  static final String jdField_a_of_type_JavaLangString = "VcSystemInfo";
  static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  static long jdField_b_of_type_Long = 0L;
  static String jdField_b_of_type_JavaLangString = "";
  static boolean jdField_b_of_type_Boolean = false;
  public static final int c = 2;
  static long jdField_c_of_type_Long = 0L;
  static String jdField_c_of_type_JavaLangString = "";
  static boolean jdField_c_of_type_Boolean = false;
  public static final int d = 3;
  static String jdField_d_of_type_JavaLangString = null;
  static boolean jdField_d_of_type_Boolean = false;
  public static final int e = 4;
  static String e = null;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  static int i = 5;
  static int j;
  static int k;
  static int l;
  static int q;
  int m = 320;
  int n = 480;
  public int o = 320;
  public int p = 240;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    j = 1;
    jdField_b_of_type_Long = 0L;
    jdField_a_of_type_Boolean = false;
    k = 2;
    l = 1;
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Boolean = true;
    jdField_d_of_type_Boolean = false;
    q = 0;
  }
  
  static int a()
  {
    try
    {
      int i1 = new File("/sys/devices/system/cpu/").listFiles(new jj()).length;
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  static long a()
  {
    long l2 = 0L;
    String str1 = "";
    long l3 = l2;
    long l4 = l2;
    long l5 = l2;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
      long l1 = l2;
      if (localBufferedReader != null)
      {
        l3 = l2;
        l4 = l2;
        l5 = l2;
        String str2 = localBufferedReader.readLine();
        l3 = l2;
        l4 = l2;
        l5 = l2;
        if (!TextUtils.isEmpty(str2))
        {
          l3 = l2;
          l4 = l2;
          l5 = l2;
          str1 = str2.trim();
        }
        l1 = l2;
        if (str1 != null)
        {
          l1 = l2;
          l3 = l2;
          l4 = l2;
          l5 = l2;
          if (str1.length() > 0)
          {
            l3 = l2;
            l4 = l2;
            l5 = l2;
            l1 = Long.parseLong(str1);
          }
        }
        l3 = l1;
        l4 = l1;
        l5 = l1;
        localBufferedReader.close();
      }
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      return l3;
    }
    catch (IOException localIOException)
    {
      return l4;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return l5;
  }
  
  public static String a()
  {
    return Build.MODEL;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: getstatic 59	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 9
    //   11: ldc2_w 152
    //   14: lstore 4
    //   16: ldc 154
    //   18: fstore_0
    //   19: new 111	java/io/BufferedReader
    //   22: dup
    //   23: new 113	java/io/FileReader
    //   26: dup
    //   27: ldc 156
    //   29: invokespecial 116	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 119	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore 8
    //   37: aload 8
    //   39: invokevirtual 123	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 9
    //   44: aload 9
    //   46: ifnonnull +254 -> 300
    //   49: iconst_1
    //   50: putstatic 59	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Boolean	Z
    //   53: lload 4
    //   55: lstore 6
    //   57: fload_0
    //   58: fstore_1
    //   59: aload 8
    //   61: ifnull +14 -> 75
    //   64: aload 8
    //   66: invokevirtual 146	java/io/BufferedReader:close	()V
    //   69: fload_0
    //   70: fstore_1
    //   71: lload 4
    //   73: lstore 6
    //   75: invokestatic 158	com/tencent/av/core/VcSystemInfo:a	()J
    //   78: lstore 4
    //   80: lload 4
    //   82: lconst_0
    //   83: lcmp
    //   84: ifle +1047 -> 1131
    //   87: lload 4
    //   89: putstatic 53	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   92: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +30 -> 125
    //   98: ldc 13
    //   100: iconst_2
    //   101: new 166	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   108: ldc 169
    //   110: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: getstatic 53	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   116: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   119: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: invokestatic 184	com/tencent/av/core/VcSystemInfo:b	()J
    //   128: lstore 4
    //   130: lload 4
    //   132: lconst_0
    //   133: lcmp
    //   134: ifle +41 -> 175
    //   137: lload 4
    //   139: putstatic 57	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Long	J
    //   142: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +30 -> 175
    //   148: ldc 13
    //   150: iconst_2
    //   151: new 166	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   158: ldc 186
    //   160: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: getstatic 57	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Long	J
    //   166: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: invokestatic 188	com/tencent/av/core/VcSystemInfo:a	()I
    //   178: istore_2
    //   179: iload_2
    //   180: ifle +1041 -> 1221
    //   183: iload_2
    //   184: putstatic 55	com/tencent/av/core/VcSystemInfo:j	I
    //   187: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +30 -> 220
    //   193: ldc 13
    //   195: iconst_2
    //   196: new 166	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   203: ldc 190
    //   205: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: getstatic 55	com/tencent/av/core/VcSystemInfo:j	I
    //   211: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: invokestatic 195	com/tencent/av/core/VcSystemInfo:b	()I
    //   223: putstatic 63	com/tencent/av/core/VcSystemInfo:l	I
    //   226: invokestatic 197	com/tencent/av/core/VcSystemInfo:b	()Z
    //   229: putstatic 65	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Boolean	Z
    //   232: getstatic 65	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Boolean	Z
    //   235: ifeq +1036 -> 1271
    //   238: invokestatic 199	com/tencent/av/core/VcSystemInfo:a	()Z
    //   241: putstatic 67	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_Boolean	Z
    //   244: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq -240 -> 7
    //   250: ldc 13
    //   252: iconst_2
    //   253: new 166	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   260: ldc 201
    //   262: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: getstatic 63	com/tencent/av/core/VcSystemInfo:l	I
    //   268: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: ldc 203
    //   273: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: getstatic 67	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_Boolean	Z
    //   279: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   282: ldc 208
    //   284: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 65	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_Boolean	Z
    //   290: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   293: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: return
    //   300: aload 9
    //   302: ldc 210
    //   304: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   307: ifeq +130 -> 437
    //   310: aload 9
    //   312: bipush 58
    //   314: invokevirtual 218	java/lang/String:indexOf	(I)I
    //   317: istore_2
    //   318: iload_2
    //   319: iconst_1
    //   320: if_icmple -283 -> 37
    //   323: aload 9
    //   325: iload_2
    //   326: iconst_1
    //   327: iadd
    //   328: aload 9
    //   330: invokevirtual 137	java/lang/String:length	()I
    //   333: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
    //   336: putstatic 43	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   339: getstatic 43	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   342: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   345: putstatic 43	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   348: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq -314 -> 37
    //   354: ldc 13
    //   356: iconst_2
    //   357: new 166	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   364: ldc 224
    //   366: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: getstatic 43	com/tencent/av/core/VcSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   372: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc 226
    //   377: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 9
    //   382: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: goto -354 -> 37
    //   394: astore 9
    //   396: lload 4
    //   398: lstore 6
    //   400: fload_0
    //   401: fstore_1
    //   402: aload 8
    //   404: ifnull -329 -> 75
    //   407: aload 8
    //   409: invokevirtual 146	java/io/BufferedReader:close	()V
    //   412: lload 4
    //   414: lstore 6
    //   416: fload_0
    //   417: fstore_1
    //   418: goto -343 -> 75
    //   421: astore 8
    //   423: aload 8
    //   425: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   428: lload 4
    //   430: lstore 6
    //   432: fload_0
    //   433: fstore_1
    //   434: goto -359 -> 75
    //   437: aload 9
    //   439: ldc 231
    //   441: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   444: ifeq +208 -> 652
    //   447: aload 9
    //   449: bipush 58
    //   451: invokevirtual 218	java/lang/String:indexOf	(I)I
    //   454: istore_2
    //   455: iload_2
    //   456: iconst_1
    //   457: if_icmple +45 -> 502
    //   460: aload 9
    //   462: iload_2
    //   463: iconst_1
    //   464: iadd
    //   465: aload 9
    //   467: invokevirtual 137	java/lang/String:length	()I
    //   470: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
    //   473: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   476: astore 10
    //   478: aload 10
    //   480: ifnull +22 -> 502
    //   483: aload 10
    //   485: invokevirtual 137	java/lang/String:length	()I
    //   488: istore_2
    //   489: iload_2
    //   490: ifle +12 -> 502
    //   493: aload 10
    //   495: invokestatic 143	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   498: l2i
    //   499: putstatic 51	com/tencent/av/core/VcSystemInfo:i	I
    //   502: aload 9
    //   504: ldc 233
    //   506: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   509: ifeq +7 -> 516
    //   512: iconst_5
    //   513: putstatic 51	com/tencent/av/core/VcSystemInfo:i	I
    //   516: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq -482 -> 37
    //   522: ldc 13
    //   524: iconst_2
    //   525: new 166	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   532: ldc 238
    //   534: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: getstatic 51	com/tencent/av/core/VcSystemInfo:i	I
    //   540: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: ldc 226
    //   545: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload 9
    //   550: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: goto -522 -> 37
    //   562: astore 9
    //   564: lload 4
    //   566: lstore 6
    //   568: fload_0
    //   569: fstore_1
    //   570: aload 8
    //   572: ifnull -497 -> 75
    //   575: aload 8
    //   577: invokevirtual 146	java/io/BufferedReader:close	()V
    //   580: lload 4
    //   582: lstore 6
    //   584: fload_0
    //   585: fstore_1
    //   586: goto -511 -> 75
    //   589: astore 8
    //   591: aload 8
    //   593: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   596: lload 4
    //   598: lstore 6
    //   600: fload_0
    //   601: fstore_1
    //   602: goto -527 -> 75
    //   605: astore 11
    //   607: iconst_1
    //   608: istore_2
    //   609: aload 10
    //   611: invokevirtual 137	java/lang/String:length	()I
    //   614: istore_3
    //   615: iload_2
    //   616: iload_3
    //   617: if_icmpge -115 -> 502
    //   620: aload 10
    //   622: iconst_0
    //   623: aload 10
    //   625: invokevirtual 137	java/lang/String:length	()I
    //   628: iload_2
    //   629: isub
    //   630: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
    //   633: invokestatic 143	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   636: l2i
    //   637: putstatic 51	com/tencent/av/core/VcSystemInfo:i	I
    //   640: goto -138 -> 502
    //   643: astore 11
    //   645: iload_2
    //   646: iconst_1
    //   647: iadd
    //   648: istore_2
    //   649: goto -40 -> 609
    //   652: aload 9
    //   654: ldc 240
    //   656: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   659: ifeq +124 -> 783
    //   662: aload 9
    //   664: bipush 58
    //   666: invokevirtual 218	java/lang/String:indexOf	(I)I
    //   669: istore_2
    //   670: iload_2
    //   671: iconst_1
    //   672: if_icmple +22 -> 694
    //   675: aload 9
    //   677: iload_2
    //   678: iconst_1
    //   679: iadd
    //   680: aload 9
    //   682: invokevirtual 137	java/lang/String:length	()I
    //   685: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
    //   688: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   691: putstatic 45	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   694: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   697: ifeq -660 -> 37
    //   700: ldc 13
    //   702: iconst_2
    //   703: new 166	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   710: ldc 242
    //   712: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: getstatic 45	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   718: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: ldc 226
    //   723: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload 9
    //   728: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   737: goto -700 -> 37
    //   740: astore 9
    //   742: lload 4
    //   744: lstore 6
    //   746: fload_0
    //   747: fstore_1
    //   748: aload 8
    //   750: ifnull -675 -> 75
    //   753: aload 8
    //   755: invokevirtual 146	java/io/BufferedReader:close	()V
    //   758: lload 4
    //   760: lstore 6
    //   762: fload_0
    //   763: fstore_1
    //   764: goto -689 -> 75
    //   767: astore 8
    //   769: aload 8
    //   771: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   774: lload 4
    //   776: lstore 6
    //   778: fload_0
    //   779: fstore_1
    //   780: goto -705 -> 75
    //   783: aload 9
    //   785: ldc 244
    //   787: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   790: ifeq +104 -> 894
    //   793: aload 9
    //   795: bipush 58
    //   797: invokevirtual 218	java/lang/String:indexOf	(I)I
    //   800: istore_2
    //   801: iload_2
    //   802: iconst_1
    //   803: if_icmple +22 -> 825
    //   806: aload 9
    //   808: iload_2
    //   809: iconst_1
    //   810: iadd
    //   811: aload 9
    //   813: invokevirtual 137	java/lang/String:length	()I
    //   816: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
    //   819: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   822: putstatic 47	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   825: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq -791 -> 37
    //   831: ldc 13
    //   833: iconst_2
    //   834: new 166	java/lang/StringBuilder
    //   837: dup
    //   838: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   841: ldc 246
    //   843: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: getstatic 47	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   849: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: ldc 226
    //   854: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload 9
    //   859: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   868: goto -831 -> 37
    //   871: astore 10
    //   873: aload 8
    //   875: astore 9
    //   877: aload 10
    //   879: astore 8
    //   881: aload 9
    //   883: ifnull +8 -> 891
    //   886: aload 9
    //   888: invokevirtual 146	java/io/BufferedReader:close	()V
    //   891: aload 8
    //   893: athrow
    //   894: aload 9
    //   896: ldc 248
    //   898: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   901: ifeq +71 -> 972
    //   904: aload 9
    //   906: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   909: putstatic 49	com/tencent/av/core/VcSystemInfo:e	Ljava/lang/String;
    //   912: aload 9
    //   914: ldc 250
    //   916: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   919: ifeq +7 -> 926
    //   922: iconst_1
    //   923: putstatic 69	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_Boolean	Z
    //   926: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   929: ifeq -892 -> 37
    //   932: ldc 13
    //   934: iconst_2
    //   935: new 166	java/lang/StringBuilder
    //   938: dup
    //   939: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   942: ldc 252
    //   944: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: getstatic 69	com/tencent/av/core/VcSystemInfo:jdField_d_of_type_Boolean	Z
    //   950: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   953: ldc 226
    //   955: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: aload 9
    //   960: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   969: goto -932 -> 37
    //   972: aload 9
    //   974: ldc 254
    //   976: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   979: ifeq +67 -> 1046
    //   982: aload 9
    //   984: bipush 58
    //   986: invokevirtual 218	java/lang/String:indexOf	(I)I
    //   989: istore_2
    //   990: iload_2
    //   991: iconst_1
    //   992: if_icmple -955 -> 37
    //   995: aload 9
    //   997: iload_2
    //   998: iconst_1
    //   999: iadd
    //   1000: aload 9
    //   1002: invokevirtual 137	java/lang/String:length	()I
    //   1005: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
    //   1008: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   1011: astore 9
    //   1013: aload 9
    //   1015: invokestatic 143	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1018: lstore 6
    //   1020: lload 6
    //   1022: lconst_0
    //   1023: lcmp
    //   1024: iflt -987 -> 37
    //   1027: lconst_1
    //   1028: lload 6
    //   1030: ladd
    //   1031: lload 4
    //   1033: lcmp
    //   1034: ifle -997 -> 37
    //   1037: lconst_1
    //   1038: lload 6
    //   1040: ladd
    //   1041: lstore 4
    //   1043: goto -1006 -> 37
    //   1046: aload 9
    //   1048: ldc_w 256
    //   1051: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1054: ifeq -1017 -> 37
    //   1057: aload 9
    //   1059: bipush 58
    //   1061: invokevirtual 218	java/lang/String:indexOf	(I)I
    //   1064: istore_2
    //   1065: iload_2
    //   1066: iconst_1
    //   1067: if_icmple -1030 -> 37
    //   1070: aload 9
    //   1072: iload_2
    //   1073: iconst_1
    //   1074: iadd
    //   1075: aload 9
    //   1077: invokevirtual 137	java/lang/String:length	()I
    //   1080: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
    //   1083: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   1086: astore 9
    //   1088: aload 9
    //   1090: invokestatic 262	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1093: fstore_1
    //   1094: fload_1
    //   1095: fload_0
    //   1096: fcmpl
    //   1097: ifle +224 -> 1321
    //   1100: fload_1
    //   1101: fstore_0
    //   1102: goto -1065 -> 37
    //   1105: astore 8
    //   1107: aload 8
    //   1109: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   1112: lload 4
    //   1114: lstore 6
    //   1116: fload_0
    //   1117: fstore_1
    //   1118: goto -1043 -> 75
    //   1121: astore 9
    //   1123: aload 9
    //   1125: invokevirtual 229	java/io/IOException:printStackTrace	()V
    //   1128: goto -237 -> 891
    //   1131: fload_1
    //   1132: fconst_0
    //   1133: fcmpl
    //   1134: ifle -1009 -> 125
    //   1137: fload_1
    //   1138: ldc_w 263
    //   1141: fcmpg
    //   1142: ifge +54 -> 1196
    //   1145: fload_1
    //   1146: f2d
    //   1147: ldc2_w 264
    //   1150: dmul
    //   1151: ldc2_w 266
    //   1154: dmul
    //   1155: d2l
    //   1156: putstatic 53	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1159: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1162: ifeq -1037 -> 125
    //   1165: ldc 13
    //   1167: iconst_2
    //   1168: new 166	java/lang/StringBuilder
    //   1171: dup
    //   1172: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1175: ldc_w 269
    //   1178: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: getstatic 53	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1184: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1187: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1190: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1193: goto -1068 -> 125
    //   1196: fload_1
    //   1197: ldc_w 270
    //   1200: fcmpl
    //   1201: ifle -42 -> 1159
    //   1204: fload_1
    //   1205: f2d
    //   1206: ldc2_w 271
    //   1209: ddiv
    //   1210: ldc2_w 266
    //   1213: dmul
    //   1214: d2l
    //   1215: putstatic 53	com/tencent/av/core/VcSystemInfo:jdField_a_of_type_Long	J
    //   1218: goto -59 -> 1159
    //   1221: lload 6
    //   1223: lconst_0
    //   1224: lcmp
    //   1225: ifle -1005 -> 220
    //   1228: lload 6
    //   1230: l2i
    //   1231: putstatic 55	com/tencent/av/core/VcSystemInfo:j	I
    //   1234: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1237: ifeq -1017 -> 220
    //   1240: ldc 13
    //   1242: iconst_2
    //   1243: new 166	java/lang/StringBuilder
    //   1246: dup
    //   1247: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1250: ldc_w 274
    //   1253: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: getstatic 55	com/tencent/av/core/VcSystemInfo:j	I
    //   1259: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1262: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1265: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1268: goto -1048 -> 220
    //   1271: iconst_0
    //   1272: putstatic 67	com/tencent/av/core/VcSystemInfo:jdField_c_of_type_Boolean	Z
    //   1275: goto -1031 -> 244
    //   1278: astore 9
    //   1280: goto -1243 -> 37
    //   1283: astore 9
    //   1285: goto -1248 -> 37
    //   1288: astore 8
    //   1290: aconst_null
    //   1291: astore 9
    //   1293: goto -412 -> 881
    //   1296: astore 8
    //   1298: aconst_null
    //   1299: astore 8
    //   1301: goto -559 -> 742
    //   1304: astore 8
    //   1306: aconst_null
    //   1307: astore 8
    //   1309: goto -745 -> 564
    //   1312: astore 8
    //   1314: aload 9
    //   1316: astore 8
    //   1318: goto -922 -> 396
    //   1321: goto -219 -> 1102
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	1099	0	f1	float
    //   58	1147	1	f2	float
    //   178	897	2	i1	int
    //   614	4	3	i2	int
    //   14	1099	4	l1	long
    //   55	1174	6	l2	long
    //   35	373	8	localBufferedReader	BufferedReader
    //   421	155	8	localIOException1	IOException
    //   589	165	8	localIOException2	IOException
    //   767	107	8	localIOException3	IOException
    //   879	13	8	localObject1	Object
    //   1105	3	8	localIOException4	IOException
    //   1288	1	8	localObject2	Object
    //   1296	1	8	localNumberFormatException1	NumberFormatException
    //   1299	1	8	localObject3	Object
    //   1304	1	8	localIOException5	IOException
    //   1307	1	8	localObject4	Object
    //   1312	1	8	localFileNotFoundException1	FileNotFoundException
    //   1316	1	8	localObject5	Object
    //   9	372	9	str1	String
    //   394	155	9	localFileNotFoundException2	FileNotFoundException
    //   562	165	9	localIOException6	IOException
    //   740	118	9	localNumberFormatException2	NumberFormatException
    //   875	214	9	localObject6	Object
    //   1121	3	9	localIOException7	IOException
    //   1278	1	9	localNumberFormatException3	NumberFormatException
    //   1283	1	9	localNumberFormatException4	NumberFormatException
    //   1291	24	9	localObject7	Object
    //   476	148	10	str2	String
    //   871	7	10	localObject8	Object
    //   605	1	11	localNumberFormatException5	NumberFormatException
    //   643	1	11	localNumberFormatException6	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   37	44	394	java/io/FileNotFoundException
    //   49	53	394	java/io/FileNotFoundException
    //   300	318	394	java/io/FileNotFoundException
    //   323	391	394	java/io/FileNotFoundException
    //   437	455	394	java/io/FileNotFoundException
    //   460	478	394	java/io/FileNotFoundException
    //   483	489	394	java/io/FileNotFoundException
    //   493	502	394	java/io/FileNotFoundException
    //   502	516	394	java/io/FileNotFoundException
    //   516	559	394	java/io/FileNotFoundException
    //   609	615	394	java/io/FileNotFoundException
    //   620	640	394	java/io/FileNotFoundException
    //   652	670	394	java/io/FileNotFoundException
    //   675	694	394	java/io/FileNotFoundException
    //   694	737	394	java/io/FileNotFoundException
    //   783	801	394	java/io/FileNotFoundException
    //   806	825	394	java/io/FileNotFoundException
    //   825	868	394	java/io/FileNotFoundException
    //   894	926	394	java/io/FileNotFoundException
    //   926	969	394	java/io/FileNotFoundException
    //   972	990	394	java/io/FileNotFoundException
    //   995	1013	394	java/io/FileNotFoundException
    //   1013	1020	394	java/io/FileNotFoundException
    //   1046	1065	394	java/io/FileNotFoundException
    //   1070	1088	394	java/io/FileNotFoundException
    //   1088	1094	394	java/io/FileNotFoundException
    //   407	412	421	java/io/IOException
    //   37	44	562	java/io/IOException
    //   49	53	562	java/io/IOException
    //   300	318	562	java/io/IOException
    //   323	391	562	java/io/IOException
    //   437	455	562	java/io/IOException
    //   460	478	562	java/io/IOException
    //   483	489	562	java/io/IOException
    //   493	502	562	java/io/IOException
    //   502	516	562	java/io/IOException
    //   516	559	562	java/io/IOException
    //   609	615	562	java/io/IOException
    //   620	640	562	java/io/IOException
    //   652	670	562	java/io/IOException
    //   675	694	562	java/io/IOException
    //   694	737	562	java/io/IOException
    //   783	801	562	java/io/IOException
    //   806	825	562	java/io/IOException
    //   825	868	562	java/io/IOException
    //   894	926	562	java/io/IOException
    //   926	969	562	java/io/IOException
    //   972	990	562	java/io/IOException
    //   995	1013	562	java/io/IOException
    //   1013	1020	562	java/io/IOException
    //   1046	1065	562	java/io/IOException
    //   1070	1088	562	java/io/IOException
    //   1088	1094	562	java/io/IOException
    //   575	580	589	java/io/IOException
    //   493	502	605	java/lang/NumberFormatException
    //   620	640	643	java/lang/NumberFormatException
    //   37	44	740	java/lang/NumberFormatException
    //   49	53	740	java/lang/NumberFormatException
    //   300	318	740	java/lang/NumberFormatException
    //   323	391	740	java/lang/NumberFormatException
    //   437	455	740	java/lang/NumberFormatException
    //   460	478	740	java/lang/NumberFormatException
    //   483	489	740	java/lang/NumberFormatException
    //   502	516	740	java/lang/NumberFormatException
    //   516	559	740	java/lang/NumberFormatException
    //   609	615	740	java/lang/NumberFormatException
    //   652	670	740	java/lang/NumberFormatException
    //   675	694	740	java/lang/NumberFormatException
    //   694	737	740	java/lang/NumberFormatException
    //   783	801	740	java/lang/NumberFormatException
    //   806	825	740	java/lang/NumberFormatException
    //   825	868	740	java/lang/NumberFormatException
    //   894	926	740	java/lang/NumberFormatException
    //   926	969	740	java/lang/NumberFormatException
    //   972	990	740	java/lang/NumberFormatException
    //   995	1013	740	java/lang/NumberFormatException
    //   1046	1065	740	java/lang/NumberFormatException
    //   1070	1088	740	java/lang/NumberFormatException
    //   753	758	767	java/io/IOException
    //   37	44	871	finally
    //   49	53	871	finally
    //   300	318	871	finally
    //   323	391	871	finally
    //   437	455	871	finally
    //   460	478	871	finally
    //   483	489	871	finally
    //   493	502	871	finally
    //   502	516	871	finally
    //   516	559	871	finally
    //   609	615	871	finally
    //   620	640	871	finally
    //   652	670	871	finally
    //   675	694	871	finally
    //   694	737	871	finally
    //   783	801	871	finally
    //   806	825	871	finally
    //   825	868	871	finally
    //   894	926	871	finally
    //   926	969	871	finally
    //   972	990	871	finally
    //   995	1013	871	finally
    //   1013	1020	871	finally
    //   1046	1065	871	finally
    //   1070	1088	871	finally
    //   1088	1094	871	finally
    //   64	69	1105	java/io/IOException
    //   886	891	1121	java/io/IOException
    //   1013	1020	1278	java/lang/NumberFormatException
    //   1088	1094	1283	java/lang/NumberFormatException
    //   19	37	1288	finally
    //   19	37	1296	java/lang/NumberFormatException
    //   19	37	1304	java/io/IOException
    //   19	37	1312	java/io/FileNotFoundException
  }
  
  static boolean a()
  {
    boolean bool = true;
    k = Utils.a(BaseApplicationImpl.getContext());
    if ((k < 2) || (l < 1) || (Build.VERSION.SDK_INT < 8)) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      if ((jdField_c_of_type_JavaLangString == null) || (jdField_c_of_type_JavaLangString.equals(""))) {
        a();
      }
      int i1 = jdField_c_of_type_JavaLangString.indexOf(paramString);
      if (i1 > 0) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  static int b()
  {
    if (jdField_b_of_type_JavaLangString.contains("ARMv6")) {}
    do
    {
      return 2;
      if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
        return 4;
      }
    } while (Build.CPU_ABI.equalsIgnoreCase("armeabi"));
    if ((i == 7) && (jdField_c_of_type_JavaLangString.indexOf("neon") < 0))
    {
      long l1 = c();
      int i1 = e();
      if ((l1 < 1100000L) || (i1 < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    switch (i)
    {
    case 6: 
    default: 
      if ((jdField_d_of_type_JavaLangString != null) && ((jdField_d_of_type_JavaLangString.equalsIgnoreCase("AuthenticAMD")) || (jdField_d_of_type_JavaLangString.equalsIgnoreCase("GenuineIntel")))) {
        return 7;
      }
      break;
    case 5: 
      return 1;
    case 7: 
      return 4;
    case 8: 
      return 5;
    }
    return 0;
  }
  
  public static long b()
  {
    long l2 = 0L;
    String str1 = "";
    long l3 = l2;
    long l4 = l2;
    long l5 = l2;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
      long l1 = l2;
      if (localBufferedReader != null)
      {
        l3 = l2;
        l4 = l2;
        l5 = l2;
        String str2 = localBufferedReader.readLine();
        l3 = l2;
        l4 = l2;
        l5 = l2;
        if (!TextUtils.isEmpty(str2))
        {
          l3 = l2;
          l4 = l2;
          l5 = l2;
          str1 = str2.trim();
        }
        l1 = l2;
        if (str1 != null)
        {
          l1 = l2;
          l3 = l2;
          l4 = l2;
          l5 = l2;
          if (str1.length() > 0)
          {
            l3 = l2;
            l4 = l2;
            l5 = l2;
            l1 = Long.parseLong(str1);
          }
        }
        l3 = l1;
        l4 = l1;
        l5 = l1;
        localBufferedReader.close();
      }
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      return l3;
    }
    catch (IOException localIOException)
    {
      return l4;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return l5;
  }
  
  public static String b()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
  }
  
  static boolean b()
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.INCREMENTAL;
    String str3 = Build.MANUFACTURER;
    int i1 = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel()) {
      QLog.d("VcSystemInfo", 2, "Model: " + str1 + "\n" + "Version: " + str2 + "\n" + "Manufacturer: " + str3 + "\n" + "SDK Version: " + i1);
    }
    if ((l < 1) || (i1 < 8)) {
      if (QLog.isColorLevel()) {
        QLog.d("VcSystemInfo", 2, "CHIP or SDK NOT_SUPPORT");
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if ((!str3.equalsIgnoreCase("HUAWEI")) || (!str1.equalsIgnoreCase("C8500"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VcSystemInfo", 2, "DEVICE_NOT_SUPPORT");
        return false;
        if ((!str3.equalsIgnoreCase("Samsung")) || (!str1.equalsIgnoreCase("GT-I5508"))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VcSystemInfo", 2, "DEVICE_NOT_SUPPORT");
      return false;
      if ((!str3.equalsIgnoreCase("FIH")) || (!str1.equalsIgnoreCase("SH8128U"))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VcSystemInfo", 2, "DEVICE_NOT_SUPPORT");
    return false;
    return true;
  }
  
  public static long c()
  {
    a();
    return jdField_a_of_type_Long;
  }
  
  public static String c()
  {
    a();
    return jdField_b_of_type_JavaLangString;
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return true;
      if (q == 0) {
        q = e();
      }
      if (jdField_c_of_type_Long == 0L) {
        jdField_c_of_type_Long = c();
      }
    } while ((q <= 1) && (jdField_c_of_type_Long <= 1025000L));
    return false;
  }
  
  public static String d()
  {
    a();
    return "prcs(" + jdField_b_of_type_JavaLangString + ") " + "arch(" + i + ") " + "hard(" + e + ") " + "chip(" + l + ") " + "freq(" + jdField_a_of_type_Long + ") " + "num(" + j + ")";
  }
  
  public static boolean d()
  {
    
    if (QLog.isColorLevel()) {
      QLog.d("VcSystemInfo", 2, "[isSupportSharpVideo] [CpuInfo] mProcessorName=" + jdField_b_of_type_JavaLangString + " \n" + "mCpuArchitecture=" + i + " \n" + "mFeature=" + jdField_c_of_type_JavaLangString + " \n" + "mVendorId=" + jdField_d_of_type_JavaLangString + " \n" + "mMaxCpuFreq=" + jdField_a_of_type_Long + " \n" + "mCoreNumber=" + j + " \n" + "mOpenGLVersion=" + k + " \n" + "mIsMarvell=" + jdField_d_of_type_Boolean + " \n" + "Chip=" + l + ", Video=" + jdField_c_of_type_Boolean + ", Audio=" + jdField_b_of_type_Boolean + " \n" + "devModel=" + Build.MODEL + " \n" + "devVersion=" + Build.VERSION.INCREMENTAL + " \n" + "devManufacturer=" + Build.MANUFACTURER + " \n" + "sdkVersion=" + Build.VERSION.SDK_INT + " \n");
    }
    return jdField_c_of_type_Boolean;
  }
  
  public static int e()
  {
    a();
    return j;
  }
  
  public static String e()
  {
    a();
    return "model(" + Build.MODEL + ") " + "Mnfc(" + Build.MANUFACTURER + ") " + "dev(" + Build.VERSION.INCREMENTAL + ") " + "sdk(" + Build.VERSION.SDK_INT + ") " + "gl(" + k + ")";
  }
  
  public static boolean e()
  {
    a();
    return jdField_b_of_type_Boolean;
  }
  
  public static int f()
  {
    a();
    return l;
  }
  
  public static boolean f()
  {
    if (l > 2) {}
    Context localContext;
    do
    {
      return true;
      localContext = BaseApplicationImpl.getContext();
    } while (UpdateAvSo.a(localContext));
    if (QLog.isColorLevel()) {
      QLog.w("VcSystemInfo", 2, "EarlyDownload libs is not ready for armv6/armv5 device");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.processEvent");
    localIntent.setPackage(localContext.getPackageName());
    localIntent.putExtra("event", "triggerAvSoDownload");
    localContext.sendBroadcast(localIntent);
    return false;
  }
  
  public static boolean g()
  {
    return (a("neon")) && (e() >= 2) && (c() >= 1200L) && (f() >= 4);
  }
  
  public static boolean h()
  {
    a();
    return (l >= 3) && (jdField_a_of_type_Long / 1000L >= 800L) && (Build.VERSION.SDK_INT >= 9);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.n = paramInt2;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.o = paramInt1;
    this.p = paramInt2;
  }
  
  public int c()
  {
    int i1 = 1;
    if (Build.VERSION.SDK_INT > 9) {
      i1 = 2;
    }
    return i1;
  }
  
  public int d()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      if (str.equals("L")) {
        return 118;
      }
      if (Build.VERSION.SDK_INT == 20) {
        return 118;
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        int i2 = str.charAt(0);
        int i3 = str.charAt(2);
        int i1 = 0;
        if (str.length() >= 5) {
          i1 = str.charAt(4);
        }
        switch (i2)
        {
        default: 
          return 200;
        case 49: 
          if (i3 == 49) {
            return 101;
          }
          if (i3 == 53) {
            return 102;
          }
          if (i3 == 54) {
            return 103;
          }
          break;
        case 50: 
          if (i3 == 48)
          {
            if (i1 == 49) {
              return 105;
            }
            return 104;
          }
          if (i3 == 49) {
            return 106;
          }
          if (i3 == 50)
          {
            if (i1 == 49) {
              return 108;
            }
            return 107;
          }
          if ((i3 == 51) && (i1 >= 48) && (i1 <= 57)) {
            return 109;
          }
          break;
        case 51: 
          if (i3 == 48) {
            return 110;
          }
          if (i3 == 49) {
            return 111;
          }
          if (i3 == 50) {
            return 112;
          }
          break;
        case 52: 
          if (i3 == 48) {
            return 113;
          }
          if (i3 == 49) {
            return 114;
          }
          if (i3 == 50) {
            return 115;
          }
          if (i3 == 51) {
            return 116;
          }
          if (i3 == 52) {
            return 117;
          }
          break;
        case 53: 
          if (i3 == 48) {
            return 118;
          }
          break;
        }
      }
    }
    catch (Exception localException) {}
    return 200;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.av.core.VcSystemInfo
 * JD-Core Version:    0.7.0.1
 */