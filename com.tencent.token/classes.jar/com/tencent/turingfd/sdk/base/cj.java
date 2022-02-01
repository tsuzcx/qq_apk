package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cj
{
  public static final String a = ct.a(ct.b);
  public static final String b = ct.a(ct.c);
  public static final String c = ct.a(ct.d);
  public static final String d = ct.a(ct.e);
  public static final String e = ct.a(ct.f);
  public static long f = 0L;
  public static final String[] g = { "^/data/user/\\d+$", "^/data/data$" };
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationInfo(paramString, 0).sourceDir;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label42:
      break label42;
    }
    paramContext = "";
    try
    {
      localStringBuilder.append((String)cm.c(new File(paramContext)).get(0));
    }
    catch (Throwable paramString)
    {
      label74:
      long l2;
      long l1;
      break label74;
    }
    localStringBuilder.append("");
    localStringBuilder.append("_");
    l2 = -1L;
    l1 = l2;
    if (!TextUtils.isEmpty(paramContext))
    {
      paramContext = new File(paramContext);
      l1 = l2;
      if (paramContext.exists()) {
        l1 = paramContext.length();
      }
    }
    localStringBuilder.append(l1);
    localStringBuilder.append("_");
    localStringBuilder.append(Process.myUid());
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static ArrayList<Flat> a(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 146	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 147	java/util/ArrayList:<init>	()V
    //   11: astore 12
    //   13: aload_0
    //   14: invokevirtual 151	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: invokevirtual 155	android/content/Context:getFilesDir	()Ljava/io/File;
    //   20: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   23: astore 7
    //   25: iconst_1
    //   26: istore 6
    //   28: aload 7
    //   30: ifnonnull +18 -> 48
    //   33: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   36: dup
    //   37: iconst_0
    //   38: ldc 90
    //   40: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   43: astore 7
    //   45: goto +238 -> 283
    //   48: aload 7
    //   50: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   53: astore 8
    //   55: aload 8
    //   57: ifnonnull +18 -> 75
    //   60: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   63: dup
    //   64: iconst_0
    //   65: ldc 90
    //   67: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   70: astore 7
    //   72: goto +211 -> 283
    //   75: getstatic 54	com/tencent/turingfd/sdk/base/cj:g	[Ljava/lang/String;
    //   78: astore 9
    //   80: aload 9
    //   82: arraylength
    //   83: istore_2
    //   84: iconst_0
    //   85: istore_1
    //   86: iload_1
    //   87: iload_2
    //   88: if_icmpge +37 -> 125
    //   91: aload 9
    //   93: iload_1
    //   94: aaload
    //   95: invokestatic 167	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   98: aload 8
    //   100: invokevirtual 170	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: invokevirtual 174	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   106: invokevirtual 179	java/util/regex/Matcher:find	()Z
    //   109: ifeq +9 -> 118
    //   112: iconst_0
    //   113: istore 5
    //   115: goto +13 -> 128
    //   118: iload_1
    //   119: iconst_1
    //   120: iadd
    //   121: istore_1
    //   122: goto -36 -> 86
    //   125: iconst_1
    //   126: istore 5
    //   128: aload 7
    //   130: invokevirtual 170	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   133: astore 9
    //   135: aload_0
    //   136: invokevirtual 182	android/content/Context:getPackageName	()Ljava/lang/String;
    //   139: astore 8
    //   141: aload 9
    //   143: ldc 184
    //   145: bipush 6
    //   147: invokevirtual 188	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   150: astore 10
    //   152: aload 9
    //   154: ldc 190
    //   156: invokevirtual 194	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   159: ifeq +29 -> 188
    //   162: aload 10
    //   164: arraylength
    //   165: iconst_4
    //   166: if_icmplt +22 -> 188
    //   169: aload 10
    //   171: iconst_3
    //   172: aaload
    //   173: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +12 -> 188
    //   179: aload 10
    //   181: iconst_3
    //   182: aaload
    //   183: astore 7
    //   185: goto +48 -> 233
    //   188: aload 8
    //   190: astore 7
    //   192: aload 9
    //   194: ldc 196
    //   196: invokevirtual 194	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   199: ifeq +34 -> 233
    //   202: aload 8
    //   204: astore 7
    //   206: aload 10
    //   208: arraylength
    //   209: iconst_5
    //   210: if_icmplt +23 -> 233
    //   213: aload 8
    //   215: astore 7
    //   217: aload 10
    //   219: iconst_4
    //   220: aaload
    //   221: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne +9 -> 233
    //   227: aload 10
    //   229: iconst_4
    //   230: aaload
    //   231: astore 7
    //   233: iload 5
    //   235: ifeq +35 -> 270
    //   238: aload 7
    //   240: aload_0
    //   241: invokevirtual 182	android/content/Context:getPackageName	()Ljava/lang/String;
    //   244: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifne +23 -> 270
    //   250: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   253: dup
    //   254: iload 5
    //   256: aload_0
    //   257: aload 7
    //   259: invokestatic 202	com/tencent/turingfd/sdk/base/cj:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   262: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   265: astore 7
    //   267: goto +16 -> 283
    //   270: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   273: dup
    //   274: iload 5
    //   276: ldc 90
    //   278: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   281: astore 7
    //   283: aload 7
    //   285: getfield 205	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   288: ifeq +88 -> 376
    //   291: aload 7
    //   293: getfield 206	com/tencent/turingfd/sdk/base/cj$a:b	Ljava/lang/String;
    //   296: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   299: ifne +77 -> 376
    //   302: iconst_0
    //   303: iconst_1
    //   304: iconst_0
    //   305: invokestatic 209	com/tencent/turingfd/sdk/base/cm:a	(IZI)I
    //   308: istore_1
    //   309: new 211	com/tencent/turingfd/sdk/base/Flat
    //   312: dup
    //   313: invokespecial 212	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   316: astore 8
    //   318: new 62	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   325: astore 9
    //   327: aload 9
    //   329: getstatic 28	com/tencent/turingfd/sdk/base/cj:a	Ljava/lang/String;
    //   332: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 9
    //   338: getstatic 36	com/tencent/turingfd/sdk/base/cj:c	Ljava/lang/String;
    //   341: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 8
    //   347: aload 9
    //   349: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: putfield 215	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   355: aload 8
    //   357: aload 7
    //   359: getfield 206	com/tencent/turingfd/sdk/base/cj$a:b	Ljava/lang/String;
    //   362: putfield 218	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   365: aload 12
    //   367: aload 8
    //   369: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   372: pop
    //   373: goto +10 -> 383
    //   376: iconst_0
    //   377: iconst_0
    //   378: iconst_0
    //   379: invokestatic 209	com/tencent/turingfd/sdk/base/cm:a	(IZI)I
    //   382: istore_1
    //   383: aload_0
    //   384: invokevirtual 151	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   387: astore 13
    //   389: aload 13
    //   391: ifnonnull +18 -> 409
    //   394: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   397: dup
    //   398: iconst_0
    //   399: ldc 90
    //   401: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   404: astore 7
    //   406: goto +686 -> 1092
    //   409: new 223	java/io/FileReader
    //   412: dup
    //   413: ldc 225
    //   415: invokespecial 226	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   418: astore 8
    //   420: new 228	java/io/BufferedReader
    //   423: dup
    //   424: aload 8
    //   426: invokespecial 231	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   429: astore 10
    //   431: aload 8
    //   433: astore 7
    //   435: aload 10
    //   437: astore 9
    //   439: aload 10
    //   441: invokevirtual 234	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   444: astore 11
    //   446: aload 11
    //   448: ifnull +385 -> 833
    //   451: aload 8
    //   453: astore 7
    //   455: aload 10
    //   457: astore 9
    //   459: aload 11
    //   461: bipush 47
    //   463: invokevirtual 238	java/lang/String:indexOf	(I)I
    //   466: istore_2
    //   467: iload_2
    //   468: iconst_m1
    //   469: if_icmpne +6 -> 475
    //   472: goto -41 -> 431
    //   475: aload 8
    //   477: astore 7
    //   479: aload 10
    //   481: astore 9
    //   483: aload 11
    //   485: iload_2
    //   486: invokevirtual 242	java/lang/String:substring	(I)Ljava/lang/String;
    //   489: invokevirtual 245	java/lang/String:trim	()Ljava/lang/String;
    //   492: astore 11
    //   494: aload 8
    //   496: astore 7
    //   498: aload 10
    //   500: astore 9
    //   502: getstatic 251	android/os/Build$VERSION:SDK_INT	I
    //   505: istore_2
    //   506: iload_2
    //   507: bipush 23
    //   509: if_icmpge +230 -> 739
    //   512: aload 8
    //   514: astore 7
    //   516: aload 10
    //   518: astore 9
    //   520: aload 11
    //   522: ldc 253
    //   524: invokevirtual 194	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   527: istore 5
    //   529: iload 5
    //   531: ifne +6 -> 537
    //   534: goto -103 -> 431
    //   537: aload 8
    //   539: astore 7
    //   541: aload 10
    //   543: astore 9
    //   545: aload 11
    //   547: ldc 255
    //   549: invokevirtual 258	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   552: ifne +6 -> 558
    //   555: goto -124 -> 431
    //   558: aload 8
    //   560: astore 7
    //   562: aload 10
    //   564: astore 9
    //   566: aload 11
    //   568: bipush 47
    //   570: invokevirtual 261	java/lang/String:lastIndexOf	(I)I
    //   573: istore_2
    //   574: iload_2
    //   575: iconst_m1
    //   576: if_icmpne +6 -> 582
    //   579: goto -148 -> 431
    //   582: aload 8
    //   584: astore 7
    //   586: aload 10
    //   588: astore 9
    //   590: aload 11
    //   592: iload_2
    //   593: aload 11
    //   595: invokevirtual 263	java/lang/String:length	()I
    //   598: bipush 12
    //   600: isub
    //   601: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   604: bipush 64
    //   606: bipush 47
    //   608: invokevirtual 270	java/lang/String:replace	(CC)Ljava/lang/String;
    //   611: astore 11
    //   613: aload 8
    //   615: astore 7
    //   617: aload 10
    //   619: astore 9
    //   621: aload 11
    //   623: ldc_w 272
    //   626: invokevirtual 194	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   629: ifne +6 -> 635
    //   632: goto -201 -> 431
    //   635: aload 8
    //   637: astore 7
    //   639: aload 10
    //   641: astore 9
    //   643: new 92	java/io/File
    //   646: dup
    //   647: aload 11
    //   649: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   652: astore 11
    //   654: aload 8
    //   656: astore 7
    //   658: aload 10
    //   660: astore 9
    //   662: ldc_w 274
    //   665: aload 11
    //   667: invokevirtual 277	java/io/File:getName	()Ljava/lang/String;
    //   670: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   673: ifeq +44 -> 717
    //   676: aload 8
    //   678: astore 7
    //   680: aload 10
    //   682: astore 9
    //   684: aload 11
    //   686: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   689: ifnull +144 -> 833
    //   692: aload 8
    //   694: astore 7
    //   696: aload 10
    //   698: astore 9
    //   700: aload 11
    //   702: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   705: invokevirtual 277	java/io/File:getName	()Ljava/lang/String;
    //   708: astore 11
    //   710: aload 11
    //   712: astore 7
    //   714: goto +122 -> 836
    //   717: aload 8
    //   719: astore 7
    //   721: aload 10
    //   723: astore 9
    //   725: aload 11
    //   727: invokevirtual 277	java/io/File:getName	()Ljava/lang/String;
    //   730: astore 11
    //   732: aload 11
    //   734: astore 7
    //   736: goto +100 -> 836
    //   739: aload 8
    //   741: astore 7
    //   743: aload 10
    //   745: astore 9
    //   747: aload 11
    //   749: ldc_w 272
    //   752: invokevirtual 194	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   755: istore 5
    //   757: iload 5
    //   759: ifne +6 -> 765
    //   762: goto -331 -> 431
    //   765: aload 8
    //   767: astore 7
    //   769: aload 10
    //   771: astore 9
    //   773: aload 11
    //   775: ldc_w 279
    //   778: invokevirtual 258	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   781: istore 5
    //   783: iload 5
    //   785: ifne +6 -> 791
    //   788: goto -357 -> 431
    //   791: aload 8
    //   793: astore 7
    //   795: aload 10
    //   797: astore 9
    //   799: aload 11
    //   801: ldc 184
    //   803: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   806: astore 11
    //   808: aload 8
    //   810: astore 7
    //   812: aload 10
    //   814: astore 9
    //   816: aload 11
    //   818: arraylength
    //   819: bipush 7
    //   821: if_icmplt -390 -> 431
    //   824: aload 11
    //   826: iconst_3
    //   827: aaload
    //   828: astore 7
    //   830: goto +6 -> 836
    //   833: aconst_null
    //   834: astore 7
    //   836: aload 8
    //   838: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   841: aload 10
    //   843: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   846: goto +73 -> 919
    //   849: astore 11
    //   851: goto +42 -> 893
    //   854: astore_0
    //   855: goto +12 -> 867
    //   858: astore 7
    //   860: goto +26 -> 886
    //   863: astore_0
    //   864: aconst_null
    //   865: astore 8
    //   867: aconst_null
    //   868: astore 9
    //   870: aload 8
    //   872: astore 7
    //   874: aload 9
    //   876: astore 8
    //   878: goto +857 -> 1735
    //   881: astore 7
    //   883: aconst_null
    //   884: astore 8
    //   886: aconst_null
    //   887: astore 10
    //   889: aload 7
    //   891: astore 11
    //   893: aload 8
    //   895: astore 7
    //   897: aload 10
    //   899: astore 9
    //   901: aload 11
    //   903: invokevirtual 288	java/lang/Throwable:printStackTrace	()V
    //   906: aload 8
    //   908: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   911: aload 10
    //   913: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   916: aconst_null
    //   917: astore 7
    //   919: aload 13
    //   921: invokevirtual 182	android/content/Context:getPackageName	()Ljava/lang/String;
    //   924: astore 8
    //   926: aload 7
    //   928: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   931: ifne +116 -> 1047
    //   934: aload 7
    //   936: ldc_w 290
    //   939: invokevirtual 293	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   942: istore_2
    //   943: iload_2
    //   944: iconst_m1
    //   945: if_icmpne +6 -> 951
    //   948: goto +99 -> 1047
    //   951: aload 7
    //   953: iconst_0
    //   954: iload_2
    //   955: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   958: astore 7
    //   960: aload 7
    //   962: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   965: ifeq +6 -> 971
    //   968: goto +79 -> 1047
    //   971: new 62	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   978: astore 9
    //   980: aload 9
    //   982: ldc 190
    //   984: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 9
    //   990: aload 7
    //   992: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: new 92	java/io/File
    //   999: dup
    //   1000: aload 9
    //   1002: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   1008: astore 9
    //   1010: aload 9
    //   1012: invokevirtual 118	java/io/File:exists	()Z
    //   1015: ifeq +14 -> 1029
    //   1018: aload 9
    //   1020: invokevirtual 296	java/io/File:canWrite	()Z
    //   1023: ifeq +6 -> 1029
    //   1026: goto +7 -> 1033
    //   1029: aload 8
    //   1031: astore 7
    //   1033: aload 8
    //   1035: aload 7
    //   1037: invokestatic 299	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1040: iconst_1
    //   1041: ixor
    //   1042: istore 5
    //   1044: goto +10 -> 1054
    //   1047: iconst_0
    //   1048: istore 5
    //   1050: aload 8
    //   1052: astore 7
    //   1054: iload 5
    //   1056: ifeq +23 -> 1079
    //   1059: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   1062: dup
    //   1063: iload 5
    //   1065: aload_0
    //   1066: aload 7
    //   1068: invokestatic 202	com/tencent/turingfd/sdk/base/cj:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1071: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   1074: astore 7
    //   1076: goto +16 -> 1092
    //   1079: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   1082: dup
    //   1083: iload 5
    //   1085: ldc 90
    //   1087: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   1090: astore 7
    //   1092: iload_1
    //   1093: aload 7
    //   1095: getfield 205	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   1098: iconst_1
    //   1099: invokestatic 209	com/tencent/turingfd/sdk/base/cm:a	(IZI)I
    //   1102: istore_1
    //   1103: aload 7
    //   1105: getfield 205	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   1108: ifeq +67 -> 1175
    //   1111: new 211	com/tencent/turingfd/sdk/base/Flat
    //   1114: dup
    //   1115: invokespecial 212	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   1118: astore 8
    //   1120: new 62	java/lang/StringBuilder
    //   1123: dup
    //   1124: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1127: astore 9
    //   1129: aload 9
    //   1131: getstatic 28	com/tencent/turingfd/sdk/base/cj:a	Ljava/lang/String;
    //   1134: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload 9
    //   1140: getstatic 40	com/tencent/turingfd/sdk/base/cj:d	Ljava/lang/String;
    //   1143: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: aload 8
    //   1149: aload 9
    //   1151: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: putfield 215	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   1157: aload 8
    //   1159: aload 7
    //   1161: getfield 206	com/tencent/turingfd/sdk/base/cj$a:b	Ljava/lang/String;
    //   1164: putfield 218	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   1167: aload 12
    //   1169: aload 8
    //   1171: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1174: pop
    //   1175: getstatic 251	android/os/Build$VERSION:SDK_INT	I
    //   1178: bipush 17
    //   1180: if_icmpge +17 -> 1197
    //   1183: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   1186: dup
    //   1187: iconst_0
    //   1188: ldc 90
    //   1190: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   1193: astore_0
    //   1194: goto +380 -> 1574
    //   1197: new 62	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1204: astore 7
    //   1206: ldc_w 301
    //   1209: getstatic 306	android/os/Build:BRAND	Ljava/lang/String;
    //   1212: invokevirtual 309	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1215: ifeq +154 -> 1369
    //   1218: ldc_w 311
    //   1221: invokestatic 317	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1224: astore 8
    //   1226: aload_0
    //   1227: invokevirtual 321	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1230: astore 9
    //   1232: aload 9
    //   1234: ldc_w 323
    //   1237: invokevirtual 327	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1240: astore 9
    //   1242: aload 9
    //   1244: iconst_1
    //   1245: invokevirtual 333	java/lang/reflect/Field:setAccessible	(Z)V
    //   1248: aload_0
    //   1249: aload 9
    //   1251: aload_0
    //   1252: invokevirtual 336	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1255: checkcast 48	java/lang/String
    //   1258: invokevirtual 340	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1261: astore_0
    //   1262: aload_0
    //   1263: ifnonnull +6 -> 1269
    //   1266: goto +48 -> 1314
    //   1269: aload 8
    //   1271: ldc_w 342
    //   1274: iconst_0
    //   1275: anewarray 313	java/lang/Class
    //   1278: invokevirtual 346	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1281: astore 8
    //   1283: aload 8
    //   1285: ifnonnull +6 -> 1291
    //   1288: goto +26 -> 1314
    //   1291: aload 8
    //   1293: iconst_1
    //   1294: invokevirtual 349	java/lang/reflect/Method:setAccessible	(Z)V
    //   1297: aload 8
    //   1299: aload_0
    //   1300: iconst_0
    //   1301: anewarray 4	java/lang/Object
    //   1304: invokevirtual 353	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1307: checkcast 48	java/lang/String
    //   1310: astore_0
    //   1311: goto +6 -> 1317
    //   1314: ldc 90
    //   1316: astore_0
    //   1317: new 48	java/lang/String
    //   1320: dup
    //   1321: ldc_w 355
    //   1324: iconst_0
    //   1325: invokestatic 361	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1328: invokespecial 364	java/lang/String:<init>	([B)V
    //   1331: astore 8
    //   1333: aload_0
    //   1334: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1337: ifne +219 -> 1556
    //   1340: aload 8
    //   1342: aload_0
    //   1343: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1346: istore 5
    //   1348: iload 5
    //   1350: ifeq +206 -> 1556
    //   1353: aload 7
    //   1355: ldc_w 366
    //   1358: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: iload 6
    //   1364: istore 5
    //   1366: goto +193 -> 1559
    //   1369: ldc_w 368
    //   1372: getstatic 306	android/os/Build:BRAND	Ljava/lang/String;
    //   1375: invokevirtual 309	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1378: ifeq +25 -> 1403
    //   1381: invokestatic 370	com/tencent/turingfd/sdk/base/cj:a	()Z
    //   1384: ifeq +172 -> 1556
    //   1387: aload 7
    //   1389: ldc_w 372
    //   1392: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: iload 6
    //   1398: istore 5
    //   1400: goto +159 -> 1559
    //   1403: ldc_w 374
    //   1406: getstatic 306	android/os/Build:BRAND	Ljava/lang/String;
    //   1409: invokevirtual 309	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1412: ifeq +25 -> 1437
    //   1415: invokestatic 370	com/tencent/turingfd/sdk/base/cj:a	()Z
    //   1418: ifeq +138 -> 1556
    //   1421: aload 7
    //   1423: ldc_w 376
    //   1426: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: pop
    //   1430: iload 6
    //   1432: istore 5
    //   1434: goto +125 -> 1559
    //   1437: ldc_w 378
    //   1440: getstatic 306	android/os/Build:BRAND	Ljava/lang/String;
    //   1443: invokevirtual 309	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1446: ifeq +110 -> 1556
    //   1449: invokestatic 370	com/tencent/turingfd/sdk/base/cj:a	()Z
    //   1452: ifeq +19 -> 1471
    //   1455: aload 7
    //   1457: ldc_w 380
    //   1460: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: iload 6
    //   1466: istore 5
    //   1468: goto +91 -> 1559
    //   1471: new 48	java/lang/String
    //   1474: dup
    //   1475: ldc_w 382
    //   1478: invokestatic 385	com/tencent/turingfd/sdk/base/cm:c	(Ljava/lang/String;)[B
    //   1481: invokespecial 364	java/lang/String:<init>	([B)V
    //   1484: astore 8
    //   1486: new 62	java/lang/StringBuilder
    //   1489: dup
    //   1490: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1493: astore 9
    //   1495: aload 9
    //   1497: aload_0
    //   1498: invokevirtual 151	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1501: invokevirtual 182	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1504: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: pop
    //   1508: aload 9
    //   1510: ldc_w 387
    //   1513: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: pop
    //   1517: aload 8
    //   1519: aload 9
    //   1521: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1524: invokevirtual 390	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1527: istore 5
    //   1529: iload 5
    //   1531: ifeq +25 -> 1556
    //   1534: aload 7
    //   1536: ldc_w 392
    //   1539: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: pop
    //   1543: iload 6
    //   1545: istore 5
    //   1547: goto +12 -> 1559
    //   1550: iconst_0
    //   1551: istore 5
    //   1553: goto +6 -> 1559
    //   1556: iconst_0
    //   1557: istore 5
    //   1559: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   1562: dup
    //   1563: iload 5
    //   1565: aload 7
    //   1567: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   1573: astore_0
    //   1574: iload_1
    //   1575: aload_0
    //   1576: getfield 205	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   1579: iconst_2
    //   1580: invokestatic 209	com/tencent/turingfd/sdk/base/cm:a	(IZI)I
    //   1583: istore_1
    //   1584: aload_0
    //   1585: getfield 205	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   1588: ifeq +66 -> 1654
    //   1591: new 211	com/tencent/turingfd/sdk/base/Flat
    //   1594: dup
    //   1595: invokespecial 212	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   1598: astore 7
    //   1600: new 62	java/lang/StringBuilder
    //   1603: dup
    //   1604: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1607: astore 8
    //   1609: aload 8
    //   1611: getstatic 28	com/tencent/turingfd/sdk/base/cj:a	Ljava/lang/String;
    //   1614: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: pop
    //   1618: aload 8
    //   1620: getstatic 44	com/tencent/turingfd/sdk/base/cj:e	Ljava/lang/String;
    //   1623: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: pop
    //   1627: aload 7
    //   1629: aload 8
    //   1631: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1634: putfield 215	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   1637: aload 7
    //   1639: aload_0
    //   1640: getfield 206	com/tencent/turingfd/sdk/base/cj$a:b	Ljava/lang/String;
    //   1643: putfield 218	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   1646: aload 12
    //   1648: aload 7
    //   1650: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1653: pop
    //   1654: iload_1
    //   1655: ifle +64 -> 1719
    //   1658: new 211	com/tencent/turingfd/sdk/base/Flat
    //   1661: dup
    //   1662: invokespecial 212	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   1665: astore_0
    //   1666: new 62	java/lang/StringBuilder
    //   1669: dup
    //   1670: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1673: astore 7
    //   1675: aload 7
    //   1677: getstatic 28	com/tencent/turingfd/sdk/base/cj:a	Ljava/lang/String;
    //   1680: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: pop
    //   1684: aload 7
    //   1686: getstatic 32	com/tencent/turingfd/sdk/base/cj:b	Ljava/lang/String;
    //   1689: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: pop
    //   1693: aload_0
    //   1694: aload 7
    //   1696: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1699: putfield 215	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   1702: aload_0
    //   1703: ldc 90
    //   1705: iload_1
    //   1706: invokestatic 397	com/tencent/turingfd/sdk/base/ci:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   1709: putfield 218	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   1712: aload 12
    //   1714: aload_0
    //   1715: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1718: pop
    //   1719: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   1722: lload_3
    //   1723: lsub
    //   1724: putstatic 46	com/tencent/turingfd/sdk/base/cj:f	J
    //   1727: aload 12
    //   1729: areturn
    //   1730: astore_0
    //   1731: aload 9
    //   1733: astore 8
    //   1735: aload 7
    //   1737: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   1740: aload 8
    //   1742: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   1745: aload_0
    //   1746: athrow
    //   1747: astore_0
    //   1748: goto -198 -> 1550
    //   1751: astore_0
    //   1752: goto -438 -> 1314
    //   1755: astore_0
    //   1756: iload 6
    //   1758: istore 5
    //   1760: goto -201 -> 1559
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1763	0	paramContext	Context
    //   85	1621	1	i	int
    //   83	872	2	j	int
    //   3	1720	3	l	long
    //   113	1646	5	bool1	boolean
    //   26	1731	6	bool2	boolean
    //   23	812	7	localObject1	Object
    //   858	1	7	localThrowable1	Throwable
    //   872	1	7	localObject2	Object
    //   881	9	7	localThrowable2	Throwable
    //   895	841	7	localObject3	Object
    //   53	1688	8	localObject4	Object
    //   78	1654	9	localObject5	Object
    //   150	762	10	localObject6	Object
    //   444	381	11	localObject7	Object
    //   849	1	11	localThrowable3	Throwable
    //   891	11	11	localThrowable4	Throwable
    //   11	1717	12	localArrayList	ArrayList
    //   387	533	13	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   439	446	849	java/lang/Throwable
    //   459	467	849	java/lang/Throwable
    //   483	494	849	java/lang/Throwable
    //   502	506	849	java/lang/Throwable
    //   520	529	849	java/lang/Throwable
    //   545	555	849	java/lang/Throwable
    //   566	574	849	java/lang/Throwable
    //   590	613	849	java/lang/Throwable
    //   621	632	849	java/lang/Throwable
    //   643	654	849	java/lang/Throwable
    //   662	676	849	java/lang/Throwable
    //   684	692	849	java/lang/Throwable
    //   700	710	849	java/lang/Throwable
    //   725	732	849	java/lang/Throwable
    //   747	757	849	java/lang/Throwable
    //   773	783	849	java/lang/Throwable
    //   799	808	849	java/lang/Throwable
    //   816	824	849	java/lang/Throwable
    //   420	431	854	finally
    //   420	431	858	java/lang/Throwable
    //   409	420	863	finally
    //   409	420	881	java/lang/Throwable
    //   439	446	1730	finally
    //   459	467	1730	finally
    //   483	494	1730	finally
    //   502	506	1730	finally
    //   520	529	1730	finally
    //   545	555	1730	finally
    //   566	574	1730	finally
    //   590	613	1730	finally
    //   621	632	1730	finally
    //   643	654	1730	finally
    //   662	676	1730	finally
    //   684	692	1730	finally
    //   700	710	1730	finally
    //   725	732	1730	finally
    //   747	757	1730	finally
    //   773	783	1730	finally
    //   799	808	1730	finally
    //   816	824	1730	finally
    //   901	906	1730	finally
    //   1317	1348	1747	java/lang/Throwable
    //   1471	1508	1747	java/lang/Throwable
    //   1508	1529	1747	java/lang/Throwable
    //   1218	1232	1751	java/lang/Throwable
    //   1232	1262	1751	java/lang/Throwable
    //   1269	1283	1751	java/lang/Throwable
    //   1291	1311	1751	java/lang/Throwable
    //   1353	1362	1755	java/lang/Throwable
    //   1534	1543	1755	java/lang/Throwable
  }
  
  public static boolean a()
  {
    try
    {
      int i = Process.myUid() / 100000;
      if (999 == i) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      label17:
      break label17;
    }
    return false;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = ci.a("");
    localStringBuilder.append(f);
    return localStringBuilder.toString();
  }
  
  public static String b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = a(paramContext).iterator();
    while (paramContext.hasNext())
    {
      Flat localFlat = (Flat)paramContext.next();
      localStringBuilder.append(localFlat.sc);
      localStringBuilder.append(":");
      localStringBuilder.append(localFlat.tc);
      localStringBuilder.append(",");
    }
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public final boolean a;
    public final String b;
    
    public a(boolean paramBoolean, String paramString)
    {
      this.a = paramBoolean;
      this.b = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cj
 * JD-Core Version:    0.7.0.1
 */