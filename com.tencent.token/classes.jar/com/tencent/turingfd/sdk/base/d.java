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

public class d
{
  public static final String a = db.a(db.b);
  public static final String b = db.a(db.c);
  public static final String c = db.a(db.d);
  public static final String d = db.a(db.e);
  public static final String e = db.a(db.f);
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
          localStringBuilder.append((String)ed.b(new File(paramContext)).get(0));
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
  public static ArrayList a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 142	java/lang/System:currentTimeMillis	()J
    //   6: lstore 6
    //   8: new 144	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 145	java/util/ArrayList:<init>	()V
    //   15: astore 13
    //   17: aload_0
    //   18: invokevirtual 149	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   21: invokevirtual 153	android/content/Context:getFilesDir	()Ljava/io/File;
    //   24: invokevirtual 156	java/io/File:getParentFile	()Ljava/io/File;
    //   27: astore 8
    //   29: aload 8
    //   31: ifnonnull +347 -> 378
    //   34: new 158	com/tencent/turingfd/sdk/base/e
    //   37: dup
    //   38: iconst_0
    //   39: ldc 136
    //   41: invokespecial 161	com/tencent/turingfd/sdk/base/e:<init>	(ZLjava/lang/String;)V
    //   44: astore 8
    //   46: aload 8
    //   48: getfield 164	com/tencent/turingfd/sdk/base/e:a	Z
    //   51: ifeq +555 -> 606
    //   54: aload 8
    //   56: getfield 165	com/tencent/turingfd/sdk/base/e:b	Ljava/lang/String;
    //   59: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +544 -> 606
    //   65: iconst_0
    //   66: iconst_1
    //   67: iconst_0
    //   68: invokestatic 168	com/tencent/turingfd/sdk/base/ed:a	(IZI)I
    //   71: istore_1
    //   72: new 170	com/tencent/turingfd/sdk/base/Fig
    //   75: dup
    //   76: invokespecial 171	com/tencent/turingfd/sdk/base/Fig:<init>	()V
    //   79: astore 9
    //   81: aload 9
    //   83: new 60	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   90: getstatic 26	com/tencent/turingfd/sdk/base/d:a	Ljava/lang/String;
    //   93: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: getstatic 34	com/tencent/turingfd/sdk/base/d:c	Ljava/lang/String;
    //   99: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: putfield 174	com/tencent/turingfd/sdk/base/Fig:vc	Ljava/lang/String;
    //   108: aload 9
    //   110: aload 8
    //   112: getfield 165	com/tencent/turingfd/sdk/base/e:b	Ljava/lang/String;
    //   115: putfield 177	com/tencent/turingfd/sdk/base/Fig:wc	Ljava/lang/String;
    //   118: aload 13
    //   120: aload 9
    //   122: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: aload_0
    //   127: invokevirtual 149	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   130: astore 14
    //   132: aload 14
    //   134: ifnonnull +482 -> 616
    //   137: new 158	com/tencent/turingfd/sdk/base/e
    //   140: dup
    //   141: iconst_0
    //   142: ldc 136
    //   144: invokespecial 161	com/tencent/turingfd/sdk/base/e:<init>	(ZLjava/lang/String;)V
    //   147: astore 8
    //   149: iload_1
    //   150: aload 8
    //   152: getfield 164	com/tencent/turingfd/sdk/base/e:a	Z
    //   155: iconst_1
    //   156: invokestatic 168	com/tencent/turingfd/sdk/base/ed:a	(IZI)I
    //   159: istore_1
    //   160: aload 8
    //   162: getfield 164	com/tencent/turingfd/sdk/base/e:a	Z
    //   165: ifeq +57 -> 222
    //   168: new 170	com/tencent/turingfd/sdk/base/Fig
    //   171: dup
    //   172: invokespecial 171	com/tencent/turingfd/sdk/base/Fig:<init>	()V
    //   175: astore 9
    //   177: aload 9
    //   179: new 60	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   186: getstatic 26	com/tencent/turingfd/sdk/base/d:a	Ljava/lang/String;
    //   189: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: getstatic 38	com/tencent/turingfd/sdk/base/d:d	Ljava/lang/String;
    //   195: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: putfield 174	com/tencent/turingfd/sdk/base/Fig:vc	Ljava/lang/String;
    //   204: aload 9
    //   206: aload 8
    //   208: getfield 165	com/tencent/turingfd/sdk/base/e:b	Ljava/lang/String;
    //   211: putfield 177	com/tencent/turingfd/sdk/base/Fig:wc	Ljava/lang/String;
    //   214: aload 13
    //   216: aload 9
    //   218: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   221: pop
    //   222: getstatic 187	android/os/Build$VERSION:SDK_INT	I
    //   225: bipush 17
    //   227: if_icmpge +898 -> 1125
    //   230: new 158	com/tencent/turingfd/sdk/base/e
    //   233: dup
    //   234: iconst_0
    //   235: ldc 136
    //   237: invokespecial 161	com/tencent/turingfd/sdk/base/e:<init>	(ZLjava/lang/String;)V
    //   240: astore_0
    //   241: iload_1
    //   242: aload_0
    //   243: getfield 164	com/tencent/turingfd/sdk/base/e:a	Z
    //   246: iconst_2
    //   247: invokestatic 168	com/tencent/turingfd/sdk/base/ed:a	(IZI)I
    //   250: istore_1
    //   251: aload_0
    //   252: getfield 164	com/tencent/turingfd/sdk/base/e:a	Z
    //   255: ifeq +56 -> 311
    //   258: new 170	com/tencent/turingfd/sdk/base/Fig
    //   261: dup
    //   262: invokespecial 171	com/tencent/turingfd/sdk/base/Fig:<init>	()V
    //   265: astore 8
    //   267: aload 8
    //   269: new 60	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   276: getstatic 26	com/tencent/turingfd/sdk/base/d:a	Ljava/lang/String;
    //   279: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: getstatic 42	com/tencent/turingfd/sdk/base/d:e	Ljava/lang/String;
    //   285: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: putfield 174	com/tencent/turingfd/sdk/base/Fig:vc	Ljava/lang/String;
    //   294: aload 8
    //   296: aload_0
    //   297: getfield 165	com/tencent/turingfd/sdk/base/e:b	Ljava/lang/String;
    //   300: putfield 177	com/tencent/turingfd/sdk/base/Fig:wc	Ljava/lang/String;
    //   303: aload 13
    //   305: aload 8
    //   307: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   310: pop
    //   311: iload_1
    //   312: ifle +54 -> 366
    //   315: new 170	com/tencent/turingfd/sdk/base/Fig
    //   318: dup
    //   319: invokespecial 171	com/tencent/turingfd/sdk/base/Fig:<init>	()V
    //   322: astore_0
    //   323: aload_0
    //   324: new 60	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   331: getstatic 26	com/tencent/turingfd/sdk/base/d:a	Ljava/lang/String;
    //   334: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: getstatic 30	com/tencent/turingfd/sdk/base/d:b	Ljava/lang/String;
    //   340: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: putfield 174	com/tencent/turingfd/sdk/base/Fig:vc	Ljava/lang/String;
    //   349: aload_0
    //   350: ldc 136
    //   352: iload_1
    //   353: invokestatic 192	com/tencent/turingfd/sdk/base/dt:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   356: putfield 177	com/tencent/turingfd/sdk/base/Fig:wc	Ljava/lang/String;
    //   359: aload 13
    //   361: aload_0
    //   362: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   365: pop
    //   366: invokestatic 142	java/lang/System:currentTimeMillis	()J
    //   369: lload 6
    //   371: lsub
    //   372: putstatic 44	com/tencent/turingfd/sdk/base/d:f	J
    //   375: aload 13
    //   377: areturn
    //   378: aload 8
    //   380: invokevirtual 156	java/io/File:getParentFile	()Ljava/io/File;
    //   383: astore 9
    //   385: aload 9
    //   387: ifnonnull +18 -> 405
    //   390: new 158	com/tencent/turingfd/sdk/base/e
    //   393: dup
    //   394: iconst_0
    //   395: ldc 136
    //   397: invokespecial 161	com/tencent/turingfd/sdk/base/e:<init>	(ZLjava/lang/String;)V
    //   400: astore 8
    //   402: goto -356 -> 46
    //   405: getstatic 52	com/tencent/turingfd/sdk/base/d:g	[Ljava/lang/String;
    //   408: astore 10
    //   410: aload 10
    //   412: arraylength
    //   413: istore_2
    //   414: iconst_0
    //   415: istore_1
    //   416: iload_1
    //   417: iload_2
    //   418: if_icmpge +1090 -> 1508
    //   421: aload 10
    //   423: iload_1
    //   424: aaload
    //   425: invokestatic 198	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   428: aload 9
    //   430: invokevirtual 201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   433: invokevirtual 205	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   436: invokevirtual 210	java/util/regex/Matcher:find	()Z
    //   439: ifeq +97 -> 536
    //   442: iconst_0
    //   443: istore_3
    //   444: aload 8
    //   446: invokevirtual 201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   449: astore 10
    //   451: aload_0
    //   452: invokevirtual 213	android/content/Context:getPackageName	()Ljava/lang/String;
    //   455: astore 9
    //   457: aload 10
    //   459: ldc 215
    //   461: bipush 6
    //   463: invokevirtual 219	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   466: astore 11
    //   468: aload 10
    //   470: ldc 221
    //   472: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   475: ifeq +68 -> 543
    //   478: aload 11
    //   480: arraylength
    //   481: iconst_4
    //   482: if_icmplt +61 -> 543
    //   485: aload 11
    //   487: iconst_3
    //   488: aaload
    //   489: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   492: ifne +51 -> 543
    //   495: aload 11
    //   497: iconst_3
    //   498: aaload
    //   499: astore 8
    //   501: iload_3
    //   502: ifeq +89 -> 591
    //   505: aload 8
    //   507: aload_0
    //   508: invokevirtual 213	android/content/Context:getPackageName	()Ljava/lang/String;
    //   511: invokevirtual 228	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   514: ifne +77 -> 591
    //   517: new 158	com/tencent/turingfd/sdk/base/e
    //   520: dup
    //   521: iload_3
    //   522: aload_0
    //   523: aload 8
    //   525: invokestatic 230	com/tencent/turingfd/sdk/base/d:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   528: invokespecial 161	com/tencent/turingfd/sdk/base/e:<init>	(ZLjava/lang/String;)V
    //   531: astore 8
    //   533: goto -487 -> 46
    //   536: iload_1
    //   537: iconst_1
    //   538: iadd
    //   539: istore_1
    //   540: goto -124 -> 416
    //   543: aload 9
    //   545: astore 8
    //   547: aload 10
    //   549: ldc 232
    //   551: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   554: ifeq -53 -> 501
    //   557: aload 9
    //   559: astore 8
    //   561: aload 11
    //   563: arraylength
    //   564: iconst_5
    //   565: if_icmplt -64 -> 501
    //   568: aload 9
    //   570: astore 8
    //   572: aload 11
    //   574: iconst_4
    //   575: aaload
    //   576: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   579: ifne -78 -> 501
    //   582: aload 11
    //   584: iconst_4
    //   585: aaload
    //   586: astore 8
    //   588: goto -87 -> 501
    //   591: new 158	com/tencent/turingfd/sdk/base/e
    //   594: dup
    //   595: iload_3
    //   596: ldc 136
    //   598: invokespecial 161	com/tencent/turingfd/sdk/base/e:<init>	(ZLjava/lang/String;)V
    //   601: astore 8
    //   603: goto -557 -> 46
    //   606: iconst_0
    //   607: iconst_0
    //   608: iconst_0
    //   609: invokestatic 168	com/tencent/turingfd/sdk/base/ed:a	(IZI)I
    //   612: istore_1
    //   613: goto -487 -> 126
    //   616: aconst_null
    //   617: astore 8
    //   619: aconst_null
    //   620: astore 11
    //   622: aconst_null
    //   623: astore 12
    //   625: new 234	java/io/FileReader
    //   628: dup
    //   629: ldc 236
    //   631: invokespecial 237	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   634: astore 9
    //   636: new 239	java/io/BufferedReader
    //   639: dup
    //   640: aload 9
    //   642: invokespecial 242	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   645: astore 10
    //   647: aload 10
    //   649: invokevirtual 245	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   652: astore 15
    //   654: aload 12
    //   656: astore 8
    //   658: aload 15
    //   660: ifnull +155 -> 815
    //   663: aload 15
    //   665: bipush 47
    //   667: invokevirtual 249	java/lang/String:indexOf	(I)I
    //   670: istore_2
    //   671: iload_2
    //   672: iconst_m1
    //   673: if_icmpeq -26 -> 647
    //   676: aload 15
    //   678: iload_2
    //   679: invokevirtual 253	java/lang/String:substring	(I)Ljava/lang/String;
    //   682: invokevirtual 256	java/lang/String:trim	()Ljava/lang/String;
    //   685: astore 8
    //   687: getstatic 187	android/os/Build$VERSION:SDK_INT	I
    //   690: istore_2
    //   691: iload_2
    //   692: bipush 23
    //   694: if_icmpge +199 -> 893
    //   697: aload 8
    //   699: ldc_w 258
    //   702: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   705: istore_3
    //   706: iload_3
    //   707: ifeq -60 -> 647
    //   710: aload 8
    //   712: ldc_w 260
    //   715: invokevirtual 263	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   718: ifeq -71 -> 647
    //   721: aload 8
    //   723: bipush 47
    //   725: invokevirtual 266	java/lang/String:lastIndexOf	(I)I
    //   728: istore_2
    //   729: iload_2
    //   730: iconst_m1
    //   731: if_icmpeq -84 -> 647
    //   734: aload 8
    //   736: iload_2
    //   737: aload 8
    //   739: invokevirtual 268	java/lang/String:length	()I
    //   742: bipush 12
    //   744: isub
    //   745: invokevirtual 271	java/lang/String:substring	(II)Ljava/lang/String;
    //   748: bipush 64
    //   750: bipush 47
    //   752: invokevirtual 275	java/lang/String:replace	(CC)Ljava/lang/String;
    //   755: astore 8
    //   757: aload 8
    //   759: ldc_w 277
    //   762: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   765: ifeq -118 -> 647
    //   768: new 88	java/io/File
    //   771: dup
    //   772: aload 8
    //   774: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   777: astore 15
    //   779: ldc_w 279
    //   782: aload 15
    //   784: invokevirtual 282	java/io/File:getName	()Ljava/lang/String;
    //   787: invokevirtual 228	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   790: ifeq +93 -> 883
    //   793: aload 12
    //   795: astore 8
    //   797: aload 15
    //   799: invokevirtual 156	java/io/File:getParentFile	()Ljava/io/File;
    //   802: ifnull +13 -> 815
    //   805: aload 15
    //   807: invokevirtual 156	java/io/File:getParentFile	()Ljava/io/File;
    //   810: invokevirtual 282	java/io/File:getName	()Ljava/lang/String;
    //   813: astore 8
    //   815: aload 9
    //   817: invokestatic 285	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   820: aload 10
    //   822: invokestatic 285	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   825: aload 14
    //   827: invokevirtual 213	android/content/Context:getPackageName	()Ljava/lang/String;
    //   830: astore 9
    //   832: aload 8
    //   834: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   837: ifne +17 -> 854
    //   840: aload 8
    //   842: ldc_w 287
    //   845: invokevirtual 290	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   848: istore_2
    //   849: iload_2
    //   850: iconst_m1
    //   851: if_icmpne +177 -> 1028
    //   854: iconst_0
    //   855: istore_3
    //   856: aload 9
    //   858: astore 8
    //   860: iload_3
    //   861: ifeq +249 -> 1110
    //   864: new 158	com/tencent/turingfd/sdk/base/e
    //   867: dup
    //   868: iload_3
    //   869: aload_0
    //   870: aload 8
    //   872: invokestatic 230	com/tencent/turingfd/sdk/base/d:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   875: invokespecial 161	com/tencent/turingfd/sdk/base/e:<init>	(ZLjava/lang/String;)V
    //   878: astore 8
    //   880: goto -731 -> 149
    //   883: aload 15
    //   885: invokevirtual 282	java/io/File:getName	()Ljava/lang/String;
    //   888: astore 8
    //   890: goto -75 -> 815
    //   893: aload 8
    //   895: ldc_w 277
    //   898: invokevirtual 225	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   901: istore_3
    //   902: iload_3
    //   903: ifeq -256 -> 647
    //   906: aload 8
    //   908: ldc_w 292
    //   911: invokevirtual 263	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   914: istore_3
    //   915: iload_3
    //   916: ifeq -269 -> 647
    //   919: aload 8
    //   921: ldc 215
    //   923: invokevirtual 295	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   926: astore 8
    //   928: aload 8
    //   930: arraylength
    //   931: bipush 7
    //   933: if_icmplt -286 -> 647
    //   936: aload 8
    //   938: iconst_3
    //   939: aaload
    //   940: astore 8
    //   942: goto -127 -> 815
    //   945: astore_0
    //   946: aload 10
    //   948: astore 8
    //   950: aload_0
    //   951: astore 10
    //   953: aload 9
    //   955: astore_0
    //   956: aload 10
    //   958: astore 9
    //   960: aload_0
    //   961: invokestatic 285	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   964: aload 8
    //   966: invokestatic 285	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   969: aload 9
    //   971: athrow
    //   972: astore 8
    //   974: aload 10
    //   976: astore 8
    //   978: aload 9
    //   980: invokestatic 285	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   983: aload 8
    //   985: invokestatic 285	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   988: aload 11
    //   990: astore 8
    //   992: goto -167 -> 825
    //   995: astore 10
    //   997: aconst_null
    //   998: astore 8
    //   1000: aload 9
    //   1002: astore_0
    //   1003: aload 10
    //   1005: astore 9
    //   1007: goto -47 -> 960
    //   1010: astore 9
    //   1012: aconst_null
    //   1013: astore 8
    //   1015: aconst_null
    //   1016: astore_0
    //   1017: goto -57 -> 960
    //   1020: astore 9
    //   1022: aconst_null
    //   1023: astore 9
    //   1025: goto -47 -> 978
    //   1028: aload 8
    //   1030: iconst_0
    //   1031: iload_2
    //   1032: invokevirtual 271	java/lang/String:substring	(II)Ljava/lang/String;
    //   1035: astore 8
    //   1037: aload 8
    //   1039: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1042: ifne -188 -> 854
    //   1045: new 88	java/io/File
    //   1048: dup
    //   1049: new 60	java/lang/StringBuilder
    //   1052: dup
    //   1053: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1056: ldc 221
    //   1058: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload 8
    //   1063: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   1072: astore 10
    //   1074: aload 10
    //   1076: invokevirtual 114	java/io/File:exists	()Z
    //   1079: ifeq +24 -> 1103
    //   1082: aload 10
    //   1084: invokevirtual 298	java/io/File:canWrite	()Z
    //   1087: ifeq +16 -> 1103
    //   1090: aload 9
    //   1092: aload 8
    //   1094: invokestatic 301	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1097: iconst_1
    //   1098: ixor
    //   1099: istore_3
    //   1100: goto -240 -> 860
    //   1103: aload 9
    //   1105: astore 8
    //   1107: goto -17 -> 1090
    //   1110: new 158	com/tencent/turingfd/sdk/base/e
    //   1113: dup
    //   1114: iload_3
    //   1115: ldc 136
    //   1117: invokespecial 161	com/tencent/turingfd/sdk/base/e:<init>	(ZLjava/lang/String;)V
    //   1120: astore 8
    //   1122: goto -973 -> 149
    //   1125: new 60	java/lang/StringBuilder
    //   1128: dup
    //   1129: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1132: astore 8
    //   1134: ldc_w 303
    //   1137: getstatic 308	android/os/Build:BRAND	Ljava/lang/String;
    //   1140: invokevirtual 311	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1143: ifeq +166 -> 1309
    //   1146: ldc_w 313
    //   1149: invokestatic 319	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1152: astore 9
    //   1154: aload_0
    //   1155: invokevirtual 323	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1158: astore 10
    //   1160: aload 10
    //   1162: ldc_w 325
    //   1165: invokevirtual 329	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1168: astore 10
    //   1170: aload 10
    //   1172: iconst_1
    //   1173: invokevirtual 335	java/lang/reflect/Field:setAccessible	(Z)V
    //   1176: aload_0
    //   1177: aload 10
    //   1179: aload_0
    //   1180: invokevirtual 338	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1183: checkcast 46	java/lang/String
    //   1186: invokevirtual 342	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1189: astore_0
    //   1190: aload_0
    //   1191: ifnonnull +76 -> 1267
    //   1194: ldc 136
    //   1196: astore_0
    //   1197: new 46	java/lang/String
    //   1200: dup
    //   1201: ldc_w 344
    //   1204: iconst_0
    //   1205: invokestatic 350	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1208: invokespecial 353	java/lang/String:<init>	([B)V
    //   1211: astore 9
    //   1213: iload 4
    //   1215: istore_3
    //   1216: aload_0
    //   1217: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1220: ifne +30 -> 1250
    //   1223: aload 9
    //   1225: aload_0
    //   1226: invokevirtual 228	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1229: istore 5
    //   1231: iload 4
    //   1233: istore_3
    //   1234: iload 5
    //   1236: ifeq +14 -> 1250
    //   1239: aload 8
    //   1241: ldc_w 355
    //   1244: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: iconst_1
    //   1249: istore_3
    //   1250: new 158	com/tencent/turingfd/sdk/base/e
    //   1253: dup
    //   1254: iload_3
    //   1255: aload 8
    //   1257: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: invokespecial 161	com/tencent/turingfd/sdk/base/e:<init>	(ZLjava/lang/String;)V
    //   1263: astore_0
    //   1264: goto -1023 -> 241
    //   1267: aload 9
    //   1269: ldc_w 357
    //   1272: iconst_0
    //   1273: anewarray 315	java/lang/Class
    //   1276: invokevirtual 361	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1279: astore 9
    //   1281: aload 9
    //   1283: ifnull -89 -> 1194
    //   1286: aload 9
    //   1288: iconst_1
    //   1289: invokevirtual 364	java/lang/reflect/Method:setAccessible	(Z)V
    //   1292: aload 9
    //   1294: aload_0
    //   1295: iconst_0
    //   1296: anewarray 4	java/lang/Object
    //   1299: invokevirtual 368	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1302: checkcast 46	java/lang/String
    //   1305: astore_0
    //   1306: goto -109 -> 1197
    //   1309: ldc_w 370
    //   1312: getstatic 308	android/os/Build:BRAND	Ljava/lang/String;
    //   1315: invokevirtual 311	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1318: ifeq +26 -> 1344
    //   1321: iload 4
    //   1323: istore_3
    //   1324: invokestatic 372	com/tencent/turingfd/sdk/base/d:a	()Z
    //   1327: ifeq -77 -> 1250
    //   1330: aload 8
    //   1332: ldc_w 374
    //   1335: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: iconst_1
    //   1340: istore_3
    //   1341: goto -91 -> 1250
    //   1344: ldc_w 376
    //   1347: getstatic 308	android/os/Build:BRAND	Ljava/lang/String;
    //   1350: invokevirtual 311	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1353: ifeq +26 -> 1379
    //   1356: iload 4
    //   1358: istore_3
    //   1359: invokestatic 372	com/tencent/turingfd/sdk/base/d:a	()Z
    //   1362: ifeq -112 -> 1250
    //   1365: aload 8
    //   1367: ldc_w 378
    //   1370: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: pop
    //   1374: iconst_1
    //   1375: istore_3
    //   1376: goto -126 -> 1250
    //   1379: iload 4
    //   1381: istore_3
    //   1382: ldc_w 380
    //   1385: getstatic 308	android/os/Build:BRAND	Ljava/lang/String;
    //   1388: invokevirtual 311	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1391: ifeq -141 -> 1250
    //   1394: invokestatic 372	com/tencent/turingfd/sdk/base/d:a	()Z
    //   1397: ifeq +17 -> 1414
    //   1400: aload 8
    //   1402: ldc_w 382
    //   1405: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: iconst_1
    //   1410: istore_3
    //   1411: goto -161 -> 1250
    //   1414: new 46	java/lang/String
    //   1417: dup
    //   1418: ldc_w 384
    //   1421: invokestatic 387	com/tencent/turingfd/sdk/base/ed:c	(Ljava/lang/String;)[B
    //   1424: invokespecial 353	java/lang/String:<init>	([B)V
    //   1427: astore 9
    //   1429: new 60	java/lang/StringBuilder
    //   1432: dup
    //   1433: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1436: aload_0
    //   1437: invokevirtual 149	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1440: invokevirtual 213	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1443: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: astore_0
    //   1447: aload 9
    //   1449: aload_0
    //   1450: ldc_w 389
    //   1453: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1459: invokevirtual 392	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1462: istore 5
    //   1464: iload 4
    //   1466: istore_3
    //   1467: iload 5
    //   1469: ifeq -219 -> 1250
    //   1472: aload 8
    //   1474: ldc_w 394
    //   1477: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: pop
    //   1481: iconst_1
    //   1482: istore_3
    //   1483: goto -233 -> 1250
    //   1486: astore_0
    //   1487: iload 4
    //   1489: istore_3
    //   1490: goto -240 -> 1250
    //   1493: astore_0
    //   1494: iconst_1
    //   1495: istore_3
    //   1496: goto -246 -> 1250
    //   1499: astore_0
    //   1500: goto -306 -> 1194
    //   1503: astore 10
    //   1505: goto -527 -> 978
    //   1508: iconst_1
    //   1509: istore_3
    //   1510: goto -1066 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1513	0	paramContext	Context
    //   71	542	1	i	int
    //   413	619	2	j	int
    //   443	1067	3	bool1	boolean
    //   1	1487	4	bool2	boolean
    //   1229	239	5	bool3	boolean
    //   6	364	6	l	long
    //   27	938	8	localObject1	Object
    //   972	1	8	localThrowable1	Throwable
    //   976	497	8	localObject2	Object
    //   79	927	9	localObject3	Object
    //   1010	1	9	localObject4	Object
    //   1020	1	9	localThrowable2	Throwable
    //   1023	425	9	localObject5	Object
    //   408	567	10	localObject6	Object
    //   995	9	10	localObject7	Object
    //   1072	106	10	localObject8	Object
    //   1503	1	10	localThrowable3	Throwable
    //   466	523	11	arrayOfString	String[]
    //   623	171	12	localObject9	Object
    //   15	361	13	localArrayList	ArrayList
    //   130	696	14	localContext	Context
    //   652	232	15	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   647	654	945	finally
    //   663	671	945	finally
    //   676	691	945	finally
    //   697	706	945	finally
    //   710	729	945	finally
    //   734	757	945	finally
    //   757	779	945	finally
    //   779	793	945	finally
    //   797	815	945	finally
    //   883	890	945	finally
    //   893	902	945	finally
    //   906	915	945	finally
    //   919	936	945	finally
    //   647	654	972	java/lang/Throwable
    //   663	671	972	java/lang/Throwable
    //   676	691	972	java/lang/Throwable
    //   697	706	972	java/lang/Throwable
    //   710	729	972	java/lang/Throwable
    //   734	757	972	java/lang/Throwable
    //   757	779	972	java/lang/Throwable
    //   779	793	972	java/lang/Throwable
    //   797	815	972	java/lang/Throwable
    //   883	890	972	java/lang/Throwable
    //   893	902	972	java/lang/Throwable
    //   906	915	972	java/lang/Throwable
    //   919	936	972	java/lang/Throwable
    //   636	647	995	finally
    //   625	636	1010	finally
    //   625	636	1020	java/lang/Throwable
    //   1197	1213	1486	java/lang/Throwable
    //   1216	1231	1486	java/lang/Throwable
    //   1414	1447	1486	java/lang/Throwable
    //   1447	1464	1486	java/lang/Throwable
    //   1239	1248	1493	java/lang/Throwable
    //   1472	1481	1493	java/lang/Throwable
    //   1146	1160	1499	java/lang/Throwable
    //   1160	1190	1499	java/lang/Throwable
    //   1267	1281	1499	java/lang/Throwable
    //   1286	1306	1499	java/lang/Throwable
    //   636	647	1503	java/lang/Throwable
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
    return "" + f;
  }
  
  public static String b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = a(paramContext).iterator();
    while (paramContext.hasNext())
    {
      Fig localFig = (Fig)paramContext.next();
      localStringBuilder.append(localFig.vc);
      localStringBuilder.append(':');
      localStringBuilder.append(localFig.wc);
      localStringBuilder.append(",");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.d
 * JD-Core Version:    0.7.0.1
 */