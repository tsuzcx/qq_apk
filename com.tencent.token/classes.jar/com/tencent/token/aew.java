package com.tencent.token;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.base.Flat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aew
{
  public static final String a = afg.a(afg.b);
  public static final String b = afg.a(afg.c);
  public static final String c = afg.a(afg.d);
  public static final String d = afg.a(afg.e);
  public static final String e = afg.a(afg.f);
  public static long f = 0L;
  public static final String[] g = { "^/data/user/\\d+$", "^/data/data$" };
  
  public static String a()
  {
    StringBuilder localStringBuilder = aev.a("");
    localStringBuilder.append(f);
    return localStringBuilder.toString();
  }
  
  private static String a(Context paramContext, String paramString)
  {
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationInfo(paramString, 0).sourceDir;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      try
      {
        localStringBuilder.append((String)aez.c(new File(paramContext)).get(0));
        localStringBuilder.append("_");
        long l2 = -1L;
        long l1 = l2;
        if (TextUtils.isEmpty(paramContext)) {
          break label118;
        }
        paramContext = new File(paramContext);
        l1 = l2;
        if (!paramContext.exists()) {
          break label118;
        }
        l1 = paramContext.length();
        localStringBuilder.append(l1);
        localStringBuilder.append("_");
        localStringBuilder.append(Process.myUid());
        return localStringBuilder.toString();
        paramContext = paramContext;
      }
      catch (Throwable paramString)
      {
        break label71;
      }
    }
    paramContext = "";
  }
  
  /* Error */
  public static ArrayList<Flat> a(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 148	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 150	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 151	java/util/ArrayList:<init>	()V
    //   11: astore 12
    //   13: aload_0
    //   14: invokevirtual 155	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: invokevirtual 159	android/content/Context:getFilesDir	()Ljava/io/File;
    //   20: invokevirtual 162	java/io/File:getParentFile	()Ljava/io/File;
    //   23: astore 7
    //   25: iconst_1
    //   26: istore 6
    //   28: aload 7
    //   30: ifnonnull +18 -> 48
    //   33: new 6	com/tencent/token/aew$a
    //   36: dup
    //   37: iconst_0
    //   38: ldc 58
    //   40: invokespecial 165	com/tencent/token/aew$a:<init>	(ZLjava/lang/String;)V
    //   43: astore 7
    //   45: goto +238 -> 283
    //   48: aload 7
    //   50: invokevirtual 162	java/io/File:getParentFile	()Ljava/io/File;
    //   53: astore 8
    //   55: aload 8
    //   57: ifnonnull +18 -> 75
    //   60: new 6	com/tencent/token/aew$a
    //   63: dup
    //   64: iconst_0
    //   65: ldc 58
    //   67: invokespecial 165	com/tencent/token/aew$a:<init>	(ZLjava/lang/String;)V
    //   70: astore 7
    //   72: goto +211 -> 283
    //   75: getstatic 54	com/tencent/token/aew:g	[Ljava/lang/String;
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
    //   95: invokestatic 171	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   98: aload 8
    //   100: invokevirtual 174	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: invokevirtual 178	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   106: invokevirtual 183	java/util/regex/Matcher:find	()Z
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
    //   130: invokevirtual 174	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   133: astore 9
    //   135: aload_0
    //   136: invokevirtual 186	android/content/Context:getPackageName	()Ljava/lang/String;
    //   139: astore 8
    //   141: aload 9
    //   143: ldc 188
    //   145: bipush 6
    //   147: invokevirtual 192	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   150: astore 10
    //   152: aload 9
    //   154: ldc 194
    //   156: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   159: ifeq +29 -> 188
    //   162: aload 10
    //   164: arraylength
    //   165: iconst_4
    //   166: if_icmplt +22 -> 188
    //   169: aload 10
    //   171: iconst_3
    //   172: aaload
    //   173: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +12 -> 188
    //   179: aload 10
    //   181: iconst_3
    //   182: aaload
    //   183: astore 7
    //   185: goto +48 -> 233
    //   188: aload 8
    //   190: astore 7
    //   192: aload 9
    //   194: ldc 200
    //   196: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
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
    //   221: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne +9 -> 233
    //   227: aload 10
    //   229: iconst_4
    //   230: aaload
    //   231: astore 7
    //   233: iload 5
    //   235: ifeq +35 -> 270
    //   238: aload 7
    //   240: aload_0
    //   241: invokevirtual 186	android/content/Context:getPackageName	()Ljava/lang/String;
    //   244: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifne +23 -> 270
    //   250: new 6	com/tencent/token/aew$a
    //   253: dup
    //   254: iload 5
    //   256: aload_0
    //   257: aload 7
    //   259: invokestatic 206	com/tencent/token/aew:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   262: invokespecial 165	com/tencent/token/aew$a:<init>	(ZLjava/lang/String;)V
    //   265: astore 7
    //   267: goto +16 -> 283
    //   270: new 6	com/tencent/token/aew$a
    //   273: dup
    //   274: iload 5
    //   276: ldc 58
    //   278: invokespecial 165	com/tencent/token/aew$a:<init>	(ZLjava/lang/String;)V
    //   281: astore 7
    //   283: aload 7
    //   285: getfield 209	com/tencent/token/aew$a:a	Z
    //   288: ifeq +88 -> 376
    //   291: aload 7
    //   293: getfield 210	com/tencent/token/aew$a:b	Ljava/lang/String;
    //   296: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   299: ifne +77 -> 376
    //   302: iconst_0
    //   303: iconst_1
    //   304: iconst_0
    //   305: invokestatic 213	com/tencent/token/aez:a	(IZI)I
    //   308: istore_1
    //   309: new 215	com/tencent/turingfd/sdk/base/Flat
    //   312: dup
    //   313: invokespecial 216	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   316: astore 8
    //   318: new 65	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   325: astore 9
    //   327: aload 9
    //   329: getstatic 28	com/tencent/token/aew:a	Ljava/lang/String;
    //   332: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 9
    //   338: getstatic 36	com/tencent/token/aew:c	Ljava/lang/String;
    //   341: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 8
    //   347: aload 9
    //   349: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: putfield 219	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   355: aload 8
    //   357: aload 7
    //   359: getfield 210	com/tencent/token/aew$a:b	Ljava/lang/String;
    //   362: putfield 222	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   365: aload 12
    //   367: aload 8
    //   369: invokevirtual 225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   372: pop
    //   373: goto +10 -> 383
    //   376: iconst_0
    //   377: iconst_0
    //   378: iconst_0
    //   379: invokestatic 213	com/tencent/token/aez:a	(IZI)I
    //   382: istore_1
    //   383: aload_0
    //   384: invokevirtual 155	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   387: astore 13
    //   389: aload 13
    //   391: ifnonnull +18 -> 409
    //   394: new 6	com/tencent/token/aew$a
    //   397: dup
    //   398: iconst_0
    //   399: ldc 58
    //   401: invokespecial 165	com/tencent/token/aew$a:<init>	(ZLjava/lang/String;)V
    //   404: astore 7
    //   406: goto +638 -> 1044
    //   409: new 227	java/io/FileReader
    //   412: dup
    //   413: ldc 229
    //   415: invokespecial 230	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   418: astore 8
    //   420: new 232	java/io/BufferedReader
    //   423: dup
    //   424: aload 8
    //   426: invokespecial 235	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   429: astore 10
    //   431: aload 8
    //   433: astore 7
    //   435: aload 10
    //   437: astore 9
    //   439: aload 10
    //   441: invokevirtual 238	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   444: astore 11
    //   446: aload 11
    //   448: ifnull +366 -> 814
    //   451: aload 8
    //   453: astore 7
    //   455: aload 10
    //   457: astore 9
    //   459: aload 11
    //   461: bipush 47
    //   463: invokevirtual 242	java/lang/String:indexOf	(I)I
    //   466: istore_2
    //   467: iload_2
    //   468: iconst_m1
    //   469: if_icmpeq -38 -> 431
    //   472: aload 8
    //   474: astore 7
    //   476: aload 10
    //   478: astore 9
    //   480: aload 11
    //   482: iload_2
    //   483: invokevirtual 246	java/lang/String:substring	(I)Ljava/lang/String;
    //   486: invokevirtual 249	java/lang/String:trim	()Ljava/lang/String;
    //   489: astore 11
    //   491: aload 8
    //   493: astore 7
    //   495: aload 10
    //   497: astore 9
    //   499: getstatic 255	android/os/Build$VERSION:SDK_INT	I
    //   502: istore_2
    //   503: iload_2
    //   504: bipush 23
    //   506: if_icmpge +220 -> 726
    //   509: aload 8
    //   511: astore 7
    //   513: aload 10
    //   515: astore 9
    //   517: aload 11
    //   519: ldc_w 257
    //   522: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   525: istore 5
    //   527: iload 5
    //   529: ifeq -98 -> 431
    //   532: aload 8
    //   534: astore 7
    //   536: aload 10
    //   538: astore 9
    //   540: aload 11
    //   542: ldc_w 259
    //   545: invokevirtual 262	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   548: ifeq -117 -> 431
    //   551: aload 8
    //   553: astore 7
    //   555: aload 10
    //   557: astore 9
    //   559: aload 11
    //   561: bipush 47
    //   563: invokevirtual 265	java/lang/String:lastIndexOf	(I)I
    //   566: istore_2
    //   567: iload_2
    //   568: iconst_m1
    //   569: if_icmpeq -138 -> 431
    //   572: aload 8
    //   574: astore 7
    //   576: aload 10
    //   578: astore 9
    //   580: aload 11
    //   582: iload_2
    //   583: aload 11
    //   585: invokevirtual 267	java/lang/String:length	()I
    //   588: bipush 12
    //   590: isub
    //   591: invokevirtual 270	java/lang/String:substring	(II)Ljava/lang/String;
    //   594: bipush 64
    //   596: bipush 47
    //   598: invokevirtual 274	java/lang/String:replace	(CC)Ljava/lang/String;
    //   601: astore 11
    //   603: aload 8
    //   605: astore 7
    //   607: aload 10
    //   609: astore 9
    //   611: aload 11
    //   613: ldc_w 276
    //   616: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   619: ifeq -188 -> 431
    //   622: aload 8
    //   624: astore 7
    //   626: aload 10
    //   628: astore 9
    //   630: new 103	java/io/File
    //   633: dup
    //   634: aload 11
    //   636: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   639: astore 11
    //   641: aload 8
    //   643: astore 7
    //   645: aload 10
    //   647: astore 9
    //   649: ldc_w 278
    //   652: aload 11
    //   654: invokevirtual 281	java/io/File:getName	()Ljava/lang/String;
    //   657: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   660: ifeq +44 -> 704
    //   663: aload 8
    //   665: astore 7
    //   667: aload 10
    //   669: astore 9
    //   671: aload 11
    //   673: invokevirtual 162	java/io/File:getParentFile	()Ljava/io/File;
    //   676: ifnull +138 -> 814
    //   679: aload 8
    //   681: astore 7
    //   683: aload 10
    //   685: astore 9
    //   687: aload 11
    //   689: invokevirtual 162	java/io/File:getParentFile	()Ljava/io/File;
    //   692: invokevirtual 281	java/io/File:getName	()Ljava/lang/String;
    //   695: astore 11
    //   697: aload 11
    //   699: astore 7
    //   701: goto +116 -> 817
    //   704: aload 8
    //   706: astore 7
    //   708: aload 10
    //   710: astore 9
    //   712: aload 11
    //   714: invokevirtual 281	java/io/File:getName	()Ljava/lang/String;
    //   717: astore 11
    //   719: aload 11
    //   721: astore 7
    //   723: goto +94 -> 817
    //   726: aload 8
    //   728: astore 7
    //   730: aload 10
    //   732: astore 9
    //   734: aload 11
    //   736: ldc_w 276
    //   739: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   742: istore 5
    //   744: iload 5
    //   746: ifeq -315 -> 431
    //   749: aload 8
    //   751: astore 7
    //   753: aload 10
    //   755: astore 9
    //   757: aload 11
    //   759: ldc_w 283
    //   762: invokevirtual 262	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   765: istore 5
    //   767: iload 5
    //   769: ifeq -338 -> 431
    //   772: aload 8
    //   774: astore 7
    //   776: aload 10
    //   778: astore 9
    //   780: aload 11
    //   782: ldc 188
    //   784: invokevirtual 286	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   787: astore 11
    //   789: aload 8
    //   791: astore 7
    //   793: aload 10
    //   795: astore 9
    //   797: aload 11
    //   799: arraylength
    //   800: bipush 7
    //   802: if_icmplt -371 -> 431
    //   805: aload 11
    //   807: iconst_3
    //   808: aaload
    //   809: astore 7
    //   811: goto +6 -> 817
    //   814: aconst_null
    //   815: astore 7
    //   817: aload 8
    //   819: invokestatic 289	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   822: aload 10
    //   824: invokestatic 289	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   827: goto +73 -> 900
    //   830: astore 11
    //   832: goto +42 -> 874
    //   835: astore_0
    //   836: goto +12 -> 848
    //   839: astore 7
    //   841: goto +26 -> 867
    //   844: astore_0
    //   845: aconst_null
    //   846: astore 8
    //   848: aconst_null
    //   849: astore 9
    //   851: aload 8
    //   853: astore 7
    //   855: aload 9
    //   857: astore 8
    //   859: goto +822 -> 1681
    //   862: astore 7
    //   864: aconst_null
    //   865: astore 8
    //   867: aconst_null
    //   868: astore 10
    //   870: aload 7
    //   872: astore 11
    //   874: aload 8
    //   876: astore 7
    //   878: aload 10
    //   880: astore 9
    //   882: aload 11
    //   884: invokevirtual 292	java/lang/Throwable:printStackTrace	()V
    //   887: aload 8
    //   889: invokestatic 289	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   892: aload 10
    //   894: invokestatic 289	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   897: aconst_null
    //   898: astore 7
    //   900: aload 13
    //   902: invokevirtual 186	android/content/Context:getPackageName	()Ljava/lang/String;
    //   905: astore 8
    //   907: aload 7
    //   909: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   912: ifne +87 -> 999
    //   915: aload 7
    //   917: ldc_w 294
    //   920: invokevirtual 297	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   923: istore_2
    //   924: iload_2
    //   925: iconst_m1
    //   926: if_icmpeq +73 -> 999
    //   929: aload 7
    //   931: iconst_0
    //   932: iload_2
    //   933: invokevirtual 270	java/lang/String:substring	(II)Ljava/lang/String;
    //   936: astore 7
    //   938: aload 7
    //   940: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   943: ifne +56 -> 999
    //   946: new 103	java/io/File
    //   949: dup
    //   950: ldc 194
    //   952: aload 7
    //   954: invokestatic 301	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   957: invokevirtual 305	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   960: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   963: astore 9
    //   965: aload 9
    //   967: invokevirtual 129	java/io/File:exists	()Z
    //   970: ifeq +11 -> 981
    //   973: aload 9
    //   975: invokevirtual 308	java/io/File:canWrite	()Z
    //   978: ifne +7 -> 985
    //   981: aload 8
    //   983: astore 7
    //   985: aload 8
    //   987: aload 7
    //   989: invokestatic 311	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   992: iconst_1
    //   993: ixor
    //   994: istore 5
    //   996: goto +10 -> 1006
    //   999: iconst_0
    //   1000: istore 5
    //   1002: aload 8
    //   1004: astore 7
    //   1006: iload 5
    //   1008: ifeq +23 -> 1031
    //   1011: new 6	com/tencent/token/aew$a
    //   1014: dup
    //   1015: iload 5
    //   1017: aload_0
    //   1018: aload 7
    //   1020: invokestatic 206	com/tencent/token/aew:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1023: invokespecial 165	com/tencent/token/aew$a:<init>	(ZLjava/lang/String;)V
    //   1026: astore 7
    //   1028: goto +16 -> 1044
    //   1031: new 6	com/tencent/token/aew$a
    //   1034: dup
    //   1035: iload 5
    //   1037: ldc 58
    //   1039: invokespecial 165	com/tencent/token/aew$a:<init>	(ZLjava/lang/String;)V
    //   1042: astore 7
    //   1044: iload_1
    //   1045: aload 7
    //   1047: getfield 209	com/tencent/token/aew$a:a	Z
    //   1050: iconst_1
    //   1051: invokestatic 213	com/tencent/token/aez:a	(IZI)I
    //   1054: istore_1
    //   1055: aload 7
    //   1057: getfield 209	com/tencent/token/aew$a:a	Z
    //   1060: ifeq +67 -> 1127
    //   1063: new 215	com/tencent/turingfd/sdk/base/Flat
    //   1066: dup
    //   1067: invokespecial 216	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   1070: astore 8
    //   1072: new 65	java/lang/StringBuilder
    //   1075: dup
    //   1076: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1079: astore 9
    //   1081: aload 9
    //   1083: getstatic 28	com/tencent/token/aew:a	Ljava/lang/String;
    //   1086: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: aload 9
    //   1092: getstatic 40	com/tencent/token/aew:d	Ljava/lang/String;
    //   1095: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload 8
    //   1101: aload 9
    //   1103: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: putfield 219	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   1109: aload 8
    //   1111: aload 7
    //   1113: getfield 210	com/tencent/token/aew$a:b	Ljava/lang/String;
    //   1116: putfield 222	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   1119: aload 12
    //   1121: aload 8
    //   1123: invokevirtual 225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1126: pop
    //   1127: getstatic 255	android/os/Build$VERSION:SDK_INT	I
    //   1130: bipush 17
    //   1132: if_icmpge +17 -> 1149
    //   1135: new 6	com/tencent/token/aew$a
    //   1138: dup
    //   1139: iconst_0
    //   1140: ldc 58
    //   1142: invokespecial 165	com/tencent/token/aew$a:<init>	(ZLjava/lang/String;)V
    //   1145: astore_0
    //   1146: goto +374 -> 1520
    //   1149: new 65	java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1156: astore 7
    //   1158: ldc_w 313
    //   1161: getstatic 318	android/os/Build:BRAND	Ljava/lang/String;
    //   1164: invokevirtual 321	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1167: ifeq +148 -> 1315
    //   1170: ldc_w 323
    //   1173: invokestatic 329	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1176: astore 8
    //   1178: aload_0
    //   1179: invokevirtual 333	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1182: astore 9
    //   1184: aload 9
    //   1186: ldc_w 335
    //   1189: invokevirtual 339	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1192: astore 9
    //   1194: aload 9
    //   1196: iconst_1
    //   1197: invokevirtual 345	java/lang/reflect/Field:setAccessible	(Z)V
    //   1200: aload_0
    //   1201: aload 9
    //   1203: aload_0
    //   1204: invokevirtual 348	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1207: checkcast 48	java/lang/String
    //   1210: invokevirtual 352	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1213: astore_0
    //   1214: aload_0
    //   1215: ifnull +45 -> 1260
    //   1218: aload 8
    //   1220: ldc_w 354
    //   1223: iconst_0
    //   1224: anewarray 325	java/lang/Class
    //   1227: invokevirtual 358	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1230: astore 8
    //   1232: aload 8
    //   1234: ifnull +26 -> 1260
    //   1237: aload 8
    //   1239: iconst_1
    //   1240: invokevirtual 361	java/lang/reflect/Method:setAccessible	(Z)V
    //   1243: aload 8
    //   1245: aload_0
    //   1246: iconst_0
    //   1247: anewarray 4	java/lang/Object
    //   1250: invokevirtual 365	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1253: checkcast 48	java/lang/String
    //   1256: astore_0
    //   1257: goto +6 -> 1263
    //   1260: ldc 58
    //   1262: astore_0
    //   1263: new 48	java/lang/String
    //   1266: dup
    //   1267: ldc_w 367
    //   1270: iconst_0
    //   1271: invokestatic 373	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1274: invokespecial 376	java/lang/String:<init>	([B)V
    //   1277: astore 8
    //   1279: aload_0
    //   1280: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1283: ifne +219 -> 1502
    //   1286: aload 8
    //   1288: aload_0
    //   1289: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1292: istore 5
    //   1294: iload 5
    //   1296: ifeq +206 -> 1502
    //   1299: aload 7
    //   1301: ldc_w 378
    //   1304: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: pop
    //   1308: iload 6
    //   1310: istore 5
    //   1312: goto +193 -> 1505
    //   1315: ldc_w 380
    //   1318: getstatic 318	android/os/Build:BRAND	Ljava/lang/String;
    //   1321: invokevirtual 321	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1324: ifeq +25 -> 1349
    //   1327: invokestatic 382	com/tencent/token/aew:b	()Z
    //   1330: ifeq +172 -> 1502
    //   1333: aload 7
    //   1335: ldc_w 384
    //   1338: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: iload 6
    //   1344: istore 5
    //   1346: goto +159 -> 1505
    //   1349: ldc_w 386
    //   1352: getstatic 318	android/os/Build:BRAND	Ljava/lang/String;
    //   1355: invokevirtual 321	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1358: ifeq +25 -> 1383
    //   1361: invokestatic 382	com/tencent/token/aew:b	()Z
    //   1364: ifeq +138 -> 1502
    //   1367: aload 7
    //   1369: ldc_w 388
    //   1372: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: pop
    //   1376: iload 6
    //   1378: istore 5
    //   1380: goto +125 -> 1505
    //   1383: ldc_w 390
    //   1386: getstatic 318	android/os/Build:BRAND	Ljava/lang/String;
    //   1389: invokevirtual 321	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1392: ifeq +110 -> 1502
    //   1395: invokestatic 382	com/tencent/token/aew:b	()Z
    //   1398: ifeq +19 -> 1417
    //   1401: aload 7
    //   1403: ldc_w 392
    //   1406: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: pop
    //   1410: iload 6
    //   1412: istore 5
    //   1414: goto +91 -> 1505
    //   1417: new 48	java/lang/String
    //   1420: dup
    //   1421: ldc_w 394
    //   1424: invokestatic 397	com/tencent/token/aez:c	(Ljava/lang/String;)[B
    //   1427: invokespecial 376	java/lang/String:<init>	([B)V
    //   1430: astore 8
    //   1432: new 65	java/lang/StringBuilder
    //   1435: dup
    //   1436: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1439: astore 9
    //   1441: aload 9
    //   1443: aload_0
    //   1444: invokevirtual 155	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1447: invokevirtual 186	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1450: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: pop
    //   1454: aload 9
    //   1456: ldc_w 399
    //   1459: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: pop
    //   1463: aload 8
    //   1465: aload 9
    //   1467: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1470: invokevirtual 402	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1473: istore 5
    //   1475: iload 5
    //   1477: ifeq +25 -> 1502
    //   1480: aload 7
    //   1482: ldc_w 404
    //   1485: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: pop
    //   1489: iload 6
    //   1491: istore 5
    //   1493: goto +12 -> 1505
    //   1496: iconst_0
    //   1497: istore 5
    //   1499: goto +6 -> 1505
    //   1502: iconst_0
    //   1503: istore 5
    //   1505: new 6	com/tencent/token/aew$a
    //   1508: dup
    //   1509: iload 5
    //   1511: aload 7
    //   1513: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: invokespecial 165	com/tencent/token/aew$a:<init>	(ZLjava/lang/String;)V
    //   1519: astore_0
    //   1520: iload_1
    //   1521: aload_0
    //   1522: getfield 209	com/tencent/token/aew$a:a	Z
    //   1525: iconst_2
    //   1526: invokestatic 213	com/tencent/token/aez:a	(IZI)I
    //   1529: istore_1
    //   1530: aload_0
    //   1531: getfield 209	com/tencent/token/aew$a:a	Z
    //   1534: ifeq +66 -> 1600
    //   1537: new 215	com/tencent/turingfd/sdk/base/Flat
    //   1540: dup
    //   1541: invokespecial 216	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   1544: astore 7
    //   1546: new 65	java/lang/StringBuilder
    //   1549: dup
    //   1550: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1553: astore 8
    //   1555: aload 8
    //   1557: getstatic 28	com/tencent/token/aew:a	Ljava/lang/String;
    //   1560: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: aload 8
    //   1566: getstatic 44	com/tencent/token/aew:e	Ljava/lang/String;
    //   1569: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: pop
    //   1573: aload 7
    //   1575: aload 8
    //   1577: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: putfield 219	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   1583: aload 7
    //   1585: aload_0
    //   1586: getfield 210	com/tencent/token/aew$a:b	Ljava/lang/String;
    //   1589: putfield 222	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   1592: aload 12
    //   1594: aload 7
    //   1596: invokevirtual 225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1599: pop
    //   1600: iload_1
    //   1601: ifle +64 -> 1665
    //   1604: new 215	com/tencent/turingfd/sdk/base/Flat
    //   1607: dup
    //   1608: invokespecial 216	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   1611: astore_0
    //   1612: new 65	java/lang/StringBuilder
    //   1615: dup
    //   1616: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1619: astore 7
    //   1621: aload 7
    //   1623: getstatic 28	com/tencent/token/aew:a	Ljava/lang/String;
    //   1626: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: pop
    //   1630: aload 7
    //   1632: getstatic 32	com/tencent/token/aew:b	Ljava/lang/String;
    //   1635: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: pop
    //   1639: aload_0
    //   1640: aload 7
    //   1642: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1645: putfield 219	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   1648: aload_0
    //   1649: ldc 58
    //   1651: iload_1
    //   1652: invokestatic 407	com/tencent/token/aev:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   1655: putfield 222	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   1658: aload 12
    //   1660: aload_0
    //   1661: invokevirtual 225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1664: pop
    //   1665: invokestatic 148	java/lang/System:currentTimeMillis	()J
    //   1668: lload_3
    //   1669: lsub
    //   1670: putstatic 46	com/tencent/token/aew:f	J
    //   1673: aload 12
    //   1675: areturn
    //   1676: astore_0
    //   1677: aload 9
    //   1679: astore 8
    //   1681: aload 7
    //   1683: invokestatic 289	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   1686: aload 8
    //   1688: invokestatic 289	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   1691: aload_0
    //   1692: athrow
    //   1693: astore_0
    //   1694: goto -434 -> 1260
    //   1697: astore_0
    //   1698: goto -202 -> 1496
    //   1701: astore_0
    //   1702: iload 6
    //   1704: istore 5
    //   1706: goto -201 -> 1505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1709	0	paramContext	Context
    //   85	1567	1	i	int
    //   83	850	2	j	int
    //   3	1666	3	l	long
    //   113	1592	5	bool1	boolean
    //   26	1677	6	bool2	boolean
    //   23	793	7	localObject1	Object
    //   839	1	7	localThrowable1	Throwable
    //   853	1	7	localObject2	Object
    //   862	9	7	localThrowable2	Throwable
    //   876	806	7	localObject3	Object
    //   53	1634	8	localObject4	Object
    //   78	1600	9	localObject5	Object
    //   150	743	10	localObject6	Object
    //   444	362	11	localObject7	Object
    //   830	1	11	localThrowable3	Throwable
    //   872	11	11	localThrowable4	Throwable
    //   11	1663	12	localArrayList	ArrayList
    //   387	514	13	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   439	446	830	java/lang/Throwable
    //   459	467	830	java/lang/Throwable
    //   480	491	830	java/lang/Throwable
    //   499	503	830	java/lang/Throwable
    //   517	527	830	java/lang/Throwable
    //   540	551	830	java/lang/Throwable
    //   559	567	830	java/lang/Throwable
    //   580	603	830	java/lang/Throwable
    //   611	622	830	java/lang/Throwable
    //   630	641	830	java/lang/Throwable
    //   649	663	830	java/lang/Throwable
    //   671	679	830	java/lang/Throwable
    //   687	697	830	java/lang/Throwable
    //   712	719	830	java/lang/Throwable
    //   734	744	830	java/lang/Throwable
    //   757	767	830	java/lang/Throwable
    //   780	789	830	java/lang/Throwable
    //   797	805	830	java/lang/Throwable
    //   420	431	835	finally
    //   420	431	839	java/lang/Throwable
    //   409	420	844	finally
    //   409	420	862	java/lang/Throwable
    //   439	446	1676	finally
    //   459	467	1676	finally
    //   480	491	1676	finally
    //   499	503	1676	finally
    //   517	527	1676	finally
    //   540	551	1676	finally
    //   559	567	1676	finally
    //   580	603	1676	finally
    //   611	622	1676	finally
    //   630	641	1676	finally
    //   649	663	1676	finally
    //   671	679	1676	finally
    //   687	697	1676	finally
    //   712	719	1676	finally
    //   734	744	1676	finally
    //   757	767	1676	finally
    //   780	789	1676	finally
    //   797	805	1676	finally
    //   882	887	1676	finally
    //   1170	1184	1693	java/lang/Throwable
    //   1184	1214	1693	java/lang/Throwable
    //   1218	1232	1693	java/lang/Throwable
    //   1237	1257	1693	java/lang/Throwable
    //   1263	1294	1697	java/lang/Throwable
    //   1417	1454	1697	java/lang/Throwable
    //   1454	1475	1697	java/lang/Throwable
    //   1299	1308	1701	java/lang/Throwable
    //   1480	1489	1701	java/lang/Throwable
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
  
  private static boolean b()
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
  
  public static final class a
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
 * Qualified Name:     com.tencent.token.aew
 * JD-Core Version:    0.7.0.1
 */