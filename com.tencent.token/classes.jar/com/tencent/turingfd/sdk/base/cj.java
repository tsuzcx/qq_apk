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
      try
      {
        for (;;)
        {
          localStringBuilder.append((String)cm.c(new File(paramContext)).get(0));
          localStringBuilder.append("_");
          long l2 = -1L;
          long l1 = l2;
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
          paramContext = paramContext;
          paramContext = "";
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          localStringBuilder.append("");
        }
      }
    }
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
    //   11: astore 13
    //   13: aload_0
    //   14: invokevirtual 151	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: invokevirtual 155	android/content/Context:getFilesDir	()Ljava/io/File;
    //   20: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   23: astore 7
    //   25: aload 7
    //   27: ifnonnull +346 -> 373
    //   30: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   33: dup
    //   34: iconst_0
    //   35: ldc 138
    //   37: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   40: astore 7
    //   42: aload 7
    //   44: getfield 164	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   47: ifeq +565 -> 612
    //   50: aload 7
    //   52: getfield 165	com/tencent/turingfd/sdk/base/cj$a:b	Ljava/lang/String;
    //   55: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +554 -> 612
    //   61: iconst_0
    //   62: iconst_1
    //   63: iconst_0
    //   64: invokestatic 168	com/tencent/turingfd/sdk/base/cm:a	(IZI)I
    //   67: istore_1
    //   68: new 170	com/tencent/turingfd/sdk/base/Flat
    //   71: dup
    //   72: invokespecial 171	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   75: astore 8
    //   77: aload 8
    //   79: new 62	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   86: getstatic 28	com/tencent/turingfd/sdk/base/cj:a	Ljava/lang/String;
    //   89: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: getstatic 36	com/tencent/turingfd/sdk/base/cj:c	Ljava/lang/String;
    //   95: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: putfield 174	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   104: aload 8
    //   106: aload 7
    //   108: getfield 165	com/tencent/turingfd/sdk/base/cj$a:b	Ljava/lang/String;
    //   111: putfield 177	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   114: aload 13
    //   116: aload 8
    //   118: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: invokevirtual 151	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   126: astore 14
    //   128: aload 14
    //   130: ifnonnull +492 -> 622
    //   133: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   136: dup
    //   137: iconst_0
    //   138: ldc 138
    //   140: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   143: astore 7
    //   145: iload_1
    //   146: aload 7
    //   148: getfield 164	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   151: iconst_1
    //   152: invokestatic 168	com/tencent/turingfd/sdk/base/cm:a	(IZI)I
    //   155: istore_1
    //   156: aload 7
    //   158: getfield 164	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   161: ifeq +57 -> 218
    //   164: new 170	com/tencent/turingfd/sdk/base/Flat
    //   167: dup
    //   168: invokespecial 171	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   171: astore 8
    //   173: aload 8
    //   175: new 62	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   182: getstatic 28	com/tencent/turingfd/sdk/base/cj:a	Ljava/lang/String;
    //   185: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: getstatic 40	com/tencent/turingfd/sdk/base/cj:d	Ljava/lang/String;
    //   191: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: putfield 174	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   200: aload 8
    //   202: aload 7
    //   204: getfield 165	com/tencent/turingfd/sdk/base/cj$a:b	Ljava/lang/String;
    //   207: putfield 177	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   210: aload 13
    //   212: aload 8
    //   214: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   217: pop
    //   218: getstatic 187	android/os/Build$VERSION:SDK_INT	I
    //   221: bipush 17
    //   223: if_icmpge +926 -> 1149
    //   226: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   229: dup
    //   230: iconst_0
    //   231: ldc 138
    //   233: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   236: astore_0
    //   237: iload_1
    //   238: aload_0
    //   239: getfield 164	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   242: iconst_2
    //   243: invokestatic 168	com/tencent/turingfd/sdk/base/cm:a	(IZI)I
    //   246: istore_1
    //   247: aload_0
    //   248: getfield 164	com/tencent/turingfd/sdk/base/cj$a:a	Z
    //   251: ifeq +56 -> 307
    //   254: new 170	com/tencent/turingfd/sdk/base/Flat
    //   257: dup
    //   258: invokespecial 171	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   261: astore 7
    //   263: aload 7
    //   265: new 62	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   272: getstatic 28	com/tencent/turingfd/sdk/base/cj:a	Ljava/lang/String;
    //   275: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: getstatic 44	com/tencent/turingfd/sdk/base/cj:e	Ljava/lang/String;
    //   281: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: putfield 174	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   290: aload 7
    //   292: aload_0
    //   293: getfield 165	com/tencent/turingfd/sdk/base/cj$a:b	Ljava/lang/String;
    //   296: putfield 177	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   299: aload 13
    //   301: aload 7
    //   303: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   306: pop
    //   307: iload_1
    //   308: ifle +54 -> 362
    //   311: new 170	com/tencent/turingfd/sdk/base/Flat
    //   314: dup
    //   315: invokespecial 171	com/tencent/turingfd/sdk/base/Flat:<init>	()V
    //   318: astore_0
    //   319: aload_0
    //   320: new 62	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   327: getstatic 28	com/tencent/turingfd/sdk/base/cj:a	Ljava/lang/String;
    //   330: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: getstatic 32	com/tencent/turingfd/sdk/base/cj:b	Ljava/lang/String;
    //   336: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: putfield 174	com/tencent/turingfd/sdk/base/Flat:sc	Ljava/lang/String;
    //   345: aload_0
    //   346: ldc 138
    //   348: iload_1
    //   349: invokestatic 192	com/tencent/turingfd/sdk/base/ci:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   352: putfield 177	com/tencent/turingfd/sdk/base/Flat:tc	Ljava/lang/String;
    //   355: aload 13
    //   357: aload_0
    //   358: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   361: pop
    //   362: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   365: lload_3
    //   366: lsub
    //   367: putstatic 46	com/tencent/turingfd/sdk/base/cj:f	J
    //   370: aload 13
    //   372: areturn
    //   373: aload 7
    //   375: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   378: astore 8
    //   380: aload 8
    //   382: ifnonnull +18 -> 400
    //   385: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   388: dup
    //   389: iconst_0
    //   390: ldc 138
    //   392: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   395: astore 7
    //   397: goto -355 -> 42
    //   400: iconst_1
    //   401: istore 6
    //   403: getstatic 54	com/tencent/turingfd/sdk/base/cj:g	[Ljava/lang/String;
    //   406: astore 9
    //   408: aload 9
    //   410: arraylength
    //   411: istore_2
    //   412: iconst_0
    //   413: istore_1
    //   414: iload 6
    //   416: istore 5
    //   418: iload_1
    //   419: iload_2
    //   420: if_icmpge +27 -> 447
    //   423: aload 9
    //   425: iload_1
    //   426: aaload
    //   427: invokestatic 198	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   430: aload 8
    //   432: invokevirtual 201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   435: invokevirtual 205	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   438: invokevirtual 210	java/util/regex/Matcher:find	()Z
    //   441: ifeq +100 -> 541
    //   444: iconst_0
    //   445: istore 5
    //   447: aload 7
    //   449: invokevirtual 201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   452: astore 9
    //   454: aload_0
    //   455: invokevirtual 213	android/content/Context:getPackageName	()Ljava/lang/String;
    //   458: astore 8
    //   460: aload 9
    //   462: ldc 215
    //   464: bipush 6
    //   466: invokevirtual 219	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   469: astore 10
    //   471: aload 9
    //   473: ldc 221
    //   475: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   478: ifeq +70 -> 548
    //   481: aload 10
    //   483: arraylength
    //   484: iconst_4
    //   485: if_icmplt +63 -> 548
    //   488: aload 10
    //   490: iconst_3
    //   491: aaload
    //   492: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   495: ifne +53 -> 548
    //   498: aload 10
    //   500: iconst_3
    //   501: aaload
    //   502: astore 7
    //   504: iload 5
    //   506: ifeq +90 -> 596
    //   509: aload 7
    //   511: aload_0
    //   512: invokevirtual 213	android/content/Context:getPackageName	()Ljava/lang/String;
    //   515: invokevirtual 228	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   518: ifne +78 -> 596
    //   521: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   524: dup
    //   525: iload 5
    //   527: aload_0
    //   528: aload 7
    //   530: invokestatic 230	com/tencent/turingfd/sdk/base/cj:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   533: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   536: astore 7
    //   538: goto -496 -> 42
    //   541: iload_1
    //   542: iconst_1
    //   543: iadd
    //   544: istore_1
    //   545: goto -131 -> 414
    //   548: aload 8
    //   550: astore 7
    //   552: aload 9
    //   554: ldc 232
    //   556: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   559: ifeq -55 -> 504
    //   562: aload 8
    //   564: astore 7
    //   566: aload 10
    //   568: arraylength
    //   569: iconst_5
    //   570: if_icmplt -66 -> 504
    //   573: aload 8
    //   575: astore 7
    //   577: aload 10
    //   579: iconst_4
    //   580: aaload
    //   581: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   584: ifne -80 -> 504
    //   587: aload 10
    //   589: iconst_4
    //   590: aaload
    //   591: astore 7
    //   593: goto -89 -> 504
    //   596: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   599: dup
    //   600: iload 5
    //   602: ldc 138
    //   604: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   607: astore 7
    //   609: goto -567 -> 42
    //   612: iconst_0
    //   613: iconst_0
    //   614: iconst_0
    //   615: invokestatic 168	com/tencent/turingfd/sdk/base/cm:a	(IZI)I
    //   618: istore_1
    //   619: goto -497 -> 122
    //   622: aconst_null
    //   623: astore 7
    //   625: aconst_null
    //   626: astore 10
    //   628: aconst_null
    //   629: astore 11
    //   631: aconst_null
    //   632: astore 12
    //   634: new 234	java/io/FileReader
    //   637: dup
    //   638: ldc 236
    //   640: invokespecial 237	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   643: astore 8
    //   645: new 239	java/io/BufferedReader
    //   648: dup
    //   649: aload 8
    //   651: invokespecial 242	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   654: astore 9
    //   656: aload 9
    //   658: invokevirtual 245	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   661: astore 10
    //   663: aload 12
    //   665: astore 7
    //   667: aload 10
    //   669: ifnull +157 -> 826
    //   672: aload 10
    //   674: bipush 47
    //   676: invokevirtual 249	java/lang/String:indexOf	(I)I
    //   679: istore_2
    //   680: iload_2
    //   681: iconst_m1
    //   682: if_icmpeq -26 -> 656
    //   685: aload 10
    //   687: iload_2
    //   688: invokevirtual 253	java/lang/String:substring	(I)Ljava/lang/String;
    //   691: invokevirtual 256	java/lang/String:trim	()Ljava/lang/String;
    //   694: astore 7
    //   696: getstatic 187	android/os/Build$VERSION:SDK_INT	I
    //   699: istore_2
    //   700: iload_2
    //   701: bipush 23
    //   703: if_icmpge +204 -> 907
    //   706: aload 7
    //   708: ldc_w 258
    //   711: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   714: istore 5
    //   716: iload 5
    //   718: ifeq -62 -> 656
    //   721: aload 7
    //   723: ldc_w 260
    //   726: invokevirtual 263	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   729: ifeq -73 -> 656
    //   732: aload 7
    //   734: bipush 47
    //   736: invokevirtual 266	java/lang/String:lastIndexOf	(I)I
    //   739: istore_2
    //   740: iload_2
    //   741: iconst_m1
    //   742: if_icmpeq -86 -> 656
    //   745: aload 7
    //   747: iload_2
    //   748: aload 7
    //   750: invokevirtual 268	java/lang/String:length	()I
    //   753: bipush 12
    //   755: isub
    //   756: invokevirtual 271	java/lang/String:substring	(II)Ljava/lang/String;
    //   759: bipush 64
    //   761: bipush 47
    //   763: invokevirtual 275	java/lang/String:replace	(CC)Ljava/lang/String;
    //   766: astore 7
    //   768: aload 7
    //   770: ldc_w 277
    //   773: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   776: ifeq -120 -> 656
    //   779: new 90	java/io/File
    //   782: dup
    //   783: aload 7
    //   785: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   788: astore 10
    //   790: ldc_w 279
    //   793: aload 10
    //   795: invokevirtual 282	java/io/File:getName	()Ljava/lang/String;
    //   798: invokevirtual 228	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   801: ifeq +96 -> 897
    //   804: aload 12
    //   806: astore 7
    //   808: aload 10
    //   810: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   813: ifnull +13 -> 826
    //   816: aload 10
    //   818: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   821: invokevirtual 282	java/io/File:getName	()Ljava/lang/String;
    //   824: astore 7
    //   826: aload 8
    //   828: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   831: aload 9
    //   833: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   836: aload 14
    //   838: invokevirtual 213	android/content/Context:getPackageName	()Ljava/lang/String;
    //   841: astore 8
    //   843: aload 7
    //   845: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   848: ifne +17 -> 865
    //   851: aload 7
    //   853: ldc_w 287
    //   856: invokevirtual 290	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   859: istore_2
    //   860: iload_2
    //   861: iconst_m1
    //   862: if_icmpne +188 -> 1050
    //   865: iconst_0
    //   866: istore 5
    //   868: aload 8
    //   870: astore 7
    //   872: iload 5
    //   874: ifeq +259 -> 1133
    //   877: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   880: dup
    //   881: iload 5
    //   883: aload_0
    //   884: aload 7
    //   886: invokestatic 230	com/tencent/turingfd/sdk/base/cj:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   889: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   892: astore 7
    //   894: goto -749 -> 145
    //   897: aload 10
    //   899: invokevirtual 282	java/io/File:getName	()Ljava/lang/String;
    //   902: astore 7
    //   904: goto -78 -> 826
    //   907: aload 7
    //   909: ldc_w 277
    //   912: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   915: istore 5
    //   917: iload 5
    //   919: ifeq -263 -> 656
    //   922: aload 7
    //   924: ldc_w 292
    //   927: invokevirtual 263	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   930: istore 5
    //   932: iload 5
    //   934: ifeq -278 -> 656
    //   937: aload 7
    //   939: ldc 215
    //   941: invokevirtual 295	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   944: astore 7
    //   946: aload 7
    //   948: arraylength
    //   949: bipush 7
    //   951: if_icmplt -295 -> 656
    //   954: aload 7
    //   956: iconst_3
    //   957: aaload
    //   958: astore 7
    //   960: goto -134 -> 826
    //   963: astore 10
    //   965: aload 8
    //   967: astore 7
    //   969: aload 9
    //   971: astore 8
    //   973: aload 10
    //   975: astore 9
    //   977: aload 9
    //   979: invokevirtual 298	java/lang/Throwable:printStackTrace	()V
    //   982: aload 7
    //   984: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   987: aload 8
    //   989: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   992: aload 11
    //   994: astore 7
    //   996: goto -160 -> 836
    //   999: astore 7
    //   1001: aconst_null
    //   1002: astore 9
    //   1004: aload 8
    //   1006: astore_0
    //   1007: aload 7
    //   1009: astore 8
    //   1011: aload 9
    //   1013: astore 7
    //   1015: aload_0
    //   1016: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   1019: aload 7
    //   1021: invokestatic 285	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   1024: aload 8
    //   1026: athrow
    //   1027: astore 9
    //   1029: aload 8
    //   1031: astore 7
    //   1033: aload 10
    //   1035: astore 8
    //   1037: goto -60 -> 977
    //   1040: astore 8
    //   1042: aconst_null
    //   1043: astore 7
    //   1045: aconst_null
    //   1046: astore_0
    //   1047: goto -32 -> 1015
    //   1050: aload 7
    //   1052: iconst_0
    //   1053: iload_2
    //   1054: invokevirtual 271	java/lang/String:substring	(II)Ljava/lang/String;
    //   1057: astore 7
    //   1059: aload 7
    //   1061: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1064: ifne -199 -> 865
    //   1067: new 90	java/io/File
    //   1070: dup
    //   1071: new 62	java/lang/StringBuilder
    //   1074: dup
    //   1075: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1078: ldc 221
    //   1080: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: aload 7
    //   1085: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1091: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   1094: astore 9
    //   1096: aload 9
    //   1098: invokevirtual 116	java/io/File:exists	()Z
    //   1101: ifeq +25 -> 1126
    //   1104: aload 9
    //   1106: invokevirtual 301	java/io/File:canWrite	()Z
    //   1109: ifeq +17 -> 1126
    //   1112: aload 8
    //   1114: aload 7
    //   1116: invokestatic 304	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1119: iconst_1
    //   1120: ixor
    //   1121: istore 5
    //   1123: goto -251 -> 872
    //   1126: aload 8
    //   1128: astore 7
    //   1130: goto -18 -> 1112
    //   1133: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   1136: dup
    //   1137: iload 5
    //   1139: ldc 138
    //   1141: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   1144: astore 7
    //   1146: goto -1001 -> 145
    //   1149: new 62	java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1156: astore 7
    //   1158: ldc_w 306
    //   1161: getstatic 311	android/os/Build:BRAND	Ljava/lang/String;
    //   1164: invokevirtual 314	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1167: ifeq +162 -> 1329
    //   1170: ldc_w 316
    //   1173: invokestatic 322	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1176: astore 8
    //   1178: aload_0
    //   1179: invokevirtual 326	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1182: astore 9
    //   1184: aload 9
    //   1186: ldc_w 328
    //   1189: invokevirtual 332	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1192: astore 9
    //   1194: aload 9
    //   1196: iconst_1
    //   1197: invokevirtual 338	java/lang/reflect/Field:setAccessible	(Z)V
    //   1200: aload_0
    //   1201: aload 9
    //   1203: aload_0
    //   1204: invokevirtual 341	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1207: checkcast 48	java/lang/String
    //   1210: invokevirtual 345	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1213: astore_0
    //   1214: aload_0
    //   1215: ifnonnull +72 -> 1287
    //   1218: ldc 138
    //   1220: astore_0
    //   1221: new 48	java/lang/String
    //   1224: dup
    //   1225: ldc_w 347
    //   1228: iconst_0
    //   1229: invokestatic 353	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1232: invokespecial 356	java/lang/String:<init>	([B)V
    //   1235: astore 8
    //   1237: aload_0
    //   1238: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1241: ifne +318 -> 1559
    //   1244: aload 8
    //   1246: aload_0
    //   1247: invokevirtual 228	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1250: istore 5
    //   1252: iload 5
    //   1254: ifeq +305 -> 1559
    //   1257: iconst_1
    //   1258: istore 5
    //   1260: aload 7
    //   1262: ldc_w 358
    //   1265: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: pop
    //   1269: new 6	com/tencent/turingfd/sdk/base/cj$a
    //   1272: dup
    //   1273: iload 5
    //   1275: aload 7
    //   1277: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokespecial 161	com/tencent/turingfd/sdk/base/cj$a:<init>	(ZLjava/lang/String;)V
    //   1283: astore_0
    //   1284: goto -1047 -> 237
    //   1287: aload 8
    //   1289: ldc_w 360
    //   1292: iconst_0
    //   1293: anewarray 318	java/lang/Class
    //   1296: invokevirtual 364	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1299: astore 8
    //   1301: aload 8
    //   1303: ifnull -85 -> 1218
    //   1306: aload 8
    //   1308: iconst_1
    //   1309: invokevirtual 367	java/lang/reflect/Method:setAccessible	(Z)V
    //   1312: aload 8
    //   1314: aload_0
    //   1315: iconst_0
    //   1316: anewarray 4	java/lang/Object
    //   1319: invokevirtual 371	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1322: checkcast 48	java/lang/String
    //   1325: astore_0
    //   1326: goto -105 -> 1221
    //   1329: ldc_w 373
    //   1332: getstatic 311	android/os/Build:BRAND	Ljava/lang/String;
    //   1335: invokevirtual 314	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1338: ifeq +24 -> 1362
    //   1341: invokestatic 375	com/tencent/turingfd/sdk/base/cj:a	()Z
    //   1344: ifeq +215 -> 1559
    //   1347: iconst_1
    //   1348: istore 5
    //   1350: aload 7
    //   1352: ldc_w 377
    //   1355: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: pop
    //   1359: goto -90 -> 1269
    //   1362: ldc_w 379
    //   1365: getstatic 311	android/os/Build:BRAND	Ljava/lang/String;
    //   1368: invokevirtual 314	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1371: ifeq +24 -> 1395
    //   1374: invokestatic 375	com/tencent/turingfd/sdk/base/cj:a	()Z
    //   1377: ifeq +182 -> 1559
    //   1380: iconst_1
    //   1381: istore 5
    //   1383: aload 7
    //   1385: ldc_w 381
    //   1388: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: pop
    //   1392: goto -123 -> 1269
    //   1395: ldc_w 383
    //   1398: getstatic 311	android/os/Build:BRAND	Ljava/lang/String;
    //   1401: invokevirtual 314	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1404: ifeq +155 -> 1559
    //   1407: invokestatic 375	com/tencent/turingfd/sdk/base/cj:a	()Z
    //   1410: ifeq +18 -> 1428
    //   1413: iconst_1
    //   1414: istore 5
    //   1416: aload 7
    //   1418: ldc_w 385
    //   1421: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: pop
    //   1425: goto -156 -> 1269
    //   1428: new 48	java/lang/String
    //   1431: dup
    //   1432: ldc_w 387
    //   1435: invokestatic 390	com/tencent/turingfd/sdk/base/cm:c	(Ljava/lang/String;)[B
    //   1438: invokespecial 356	java/lang/String:<init>	([B)V
    //   1441: astore 8
    //   1443: new 62	java/lang/StringBuilder
    //   1446: dup
    //   1447: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1450: aload_0
    //   1451: invokevirtual 151	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1454: invokevirtual 213	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1457: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: astore_0
    //   1461: aload 8
    //   1463: aload_0
    //   1464: ldc_w 392
    //   1467: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1473: invokevirtual 395	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1476: istore 5
    //   1478: iload 5
    //   1480: ifeq +79 -> 1559
    //   1483: iconst_1
    //   1484: istore 5
    //   1486: aload 7
    //   1488: ldc_w 397
    //   1491: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: pop
    //   1495: goto -226 -> 1269
    //   1498: iconst_1
    //   1499: istore 5
    //   1501: astore_0
    //   1502: goto -233 -> 1269
    //   1505: astore_0
    //   1506: iconst_0
    //   1507: istore 5
    //   1509: goto -240 -> 1269
    //   1512: astore_0
    //   1513: goto -295 -> 1218
    //   1516: astore 9
    //   1518: aload 10
    //   1520: astore 8
    //   1522: goto -545 -> 977
    //   1525: astore_0
    //   1526: aload 9
    //   1528: astore 7
    //   1530: aload_0
    //   1531: astore 9
    //   1533: aload 8
    //   1535: astore_0
    //   1536: aload 9
    //   1538: astore 8
    //   1540: goto -525 -> 1015
    //   1543: astore 9
    //   1545: aload 7
    //   1547: astore_0
    //   1548: aload 8
    //   1550: astore 7
    //   1552: aload 9
    //   1554: astore 8
    //   1556: goto -541 -> 1015
    //   1559: iconst_0
    //   1560: istore 5
    //   1562: goto -293 -> 1269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1565	0	paramContext	Context
    //   67	552	1	i	int
    //   411	643	2	j	int
    //   3	363	3	l	long
    //   416	1145	5	bool1	boolean
    //   401	14	6	bool2	boolean
    //   23	972	7	localObject1	Object
    //   999	9	7	localObject2	Object
    //   1013	538	7	localObject3	Object
    //   75	961	8	localObject4	Object
    //   1040	87	8	localCharSequence	java.lang.CharSequence
    //   1176	379	8	localObject5	Object
    //   406	606	9	localObject6	Object
    //   1027	1	9	localThrowable1	Throwable
    //   1094	108	9	localObject7	Object
    //   1516	11	9	localThrowable2	Throwable
    //   1531	6	9	localContext1	Context
    //   1543	10	9	localObject8	Object
    //   469	429	10	localObject9	Object
    //   963	556	10	localThrowable3	Throwable
    //   629	364	11	localObject10	Object
    //   632	173	12	localObject11	Object
    //   11	360	13	localArrayList	ArrayList
    //   126	711	14	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   656	663	963	java/lang/Throwable
    //   672	680	963	java/lang/Throwable
    //   685	700	963	java/lang/Throwable
    //   706	716	963	java/lang/Throwable
    //   721	740	963	java/lang/Throwable
    //   745	768	963	java/lang/Throwable
    //   768	790	963	java/lang/Throwable
    //   790	804	963	java/lang/Throwable
    //   808	826	963	java/lang/Throwable
    //   897	904	963	java/lang/Throwable
    //   907	917	963	java/lang/Throwable
    //   922	932	963	java/lang/Throwable
    //   937	954	963	java/lang/Throwable
    //   645	656	999	finally
    //   645	656	1027	java/lang/Throwable
    //   634	645	1040	finally
    //   1260	1269	1498	java/lang/Throwable
    //   1486	1495	1498	java/lang/Throwable
    //   1221	1252	1505	java/lang/Throwable
    //   1428	1461	1505	java/lang/Throwable
    //   1461	1478	1505	java/lang/Throwable
    //   1170	1184	1512	java/lang/Throwable
    //   1184	1214	1512	java/lang/Throwable
    //   1287	1301	1512	java/lang/Throwable
    //   1306	1326	1512	java/lang/Throwable
    //   634	645	1516	java/lang/Throwable
    //   656	663	1525	finally
    //   672	680	1525	finally
    //   685	700	1525	finally
    //   706	716	1525	finally
    //   721	740	1525	finally
    //   745	768	1525	finally
    //   768	790	1525	finally
    //   790	804	1525	finally
    //   808	826	1525	finally
    //   897	904	1525	finally
    //   907	917	1525	finally
    //   922	932	1525	finally
    //   937	954	1525	finally
    //   977	982	1543	finally
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
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static String b()
  {
    return f;
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