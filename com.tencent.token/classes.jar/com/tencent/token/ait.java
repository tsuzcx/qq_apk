package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class ait
{
  private static aiq a;
  private static Context b;
  private static String c = "token";
  
  public static int a(aiv paramaiv, String paramString)
  {
    for (;;)
    {
      try
      {
        c(paramaiv);
        paramaiv = a().a(paramString, new String[] { "count(*)" }, null, null, null, null);
        if (paramaiv.getCount() > 0)
        {
          paramaiv.moveToFirst();
          i = paramaiv.getInt(0);
          paramaiv.close();
          xj.c("test database, tablecount=".concat(String.valueOf(i)));
          return i;
        }
      }
      catch (Throwable paramaiv)
      {
        paramString = new StringBuilder("status_kk");
        paramString.append(paramaiv.toString());
        paramString.append(paramaiv.getMessage());
        xj.c(paramString.toString());
        return 0;
      }
      catch (Exception paramaiv)
      {
        paramString = new StringBuilder("status_kk");
        paramString.append(paramaiv.toString());
        paramString.append(paramaiv.getMessage());
        xj.c(paramString.toString());
        return 0;
      }
      int i = 0;
    }
  }
  
  public static int a(aiv paramaiv, String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      c(paramaiv);
      int i = a().a(paramString1, paramContentValues, paramString2, paramArrayOfString);
      return i;
    }
    catch (Throwable paramaiv)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaiv.toString());
      paramString1.append(paramaiv.getMessage());
      xj.c(paramString1.toString());
    }
    catch (Exception paramaiv)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaiv.toString());
      paramString1.append(paramaiv.getMessage());
      xj.c(paramString1.toString());
    }
    return 0;
  }
  
  public static int a(aiv paramaiv, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      c(paramaiv);
      int i = a().a(paramString1, paramString2, paramArrayOfString);
      xj.c("test database, del=".concat(String.valueOf(i)));
      return i;
    }
    catch (Throwable paramaiv)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaiv.toString());
      paramString1.append(paramaiv.getMessage());
      xj.c(paramString1.toString());
    }
    catch (Exception paramaiv)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaiv.toString());
      paramString1.append(paramaiv.getMessage());
      xj.c(paramString1.toString());
    }
    return 0;
  }
  
  public static long a(aiv paramaiv)
  {
    try
    {
      c(paramaiv);
      long l = paramaiv.b(a());
      return l;
    }
    catch (Throwable paramaiv)
    {
      localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaiv.toString());
      localStringBuilder.append(paramaiv.getMessage());
      xj.c(localStringBuilder.toString());
    }
    catch (Exception paramaiv)
    {
      StringBuilder localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaiv.toString());
      localStringBuilder.append(paramaiv.getMessage());
      xj.c(localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static aiv a(aiv paramaiv, String paramString, String[] paramArrayOfString)
  {
    paramaiv = a(paramaiv, paramString, paramArrayOfString, null, null, null, null);
    if (paramaiv.size() > 0) {
      return (aiv)paramaiv.get(0);
    }
    return null;
  }
  
  /* Error */
  public static SQLiteDatabase a()
  {
    // Byte code:
    //   0: getstatic 119	com/tencent/token/ait:a	Lcom/tencent/token/aiq;
    //   3: ifnonnull +1549 -> 1552
    //   6: getstatic 121	com/tencent/token/ait:b	Landroid/content/Context;
    //   9: ifnonnull +9 -> 18
    //   12: invokestatic 127	com/tencent/token/global/RqdApplication:p	()Landroid/content/Context;
    //   15: putstatic 121	com/tencent/token/ait:b	Landroid/content/Context;
    //   18: getstatic 121	com/tencent/token/ait:b	Landroid/content/Context;
    //   21: ldc 129
    //   23: invokevirtual 135	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +15 -> 43
    //   31: aload_3
    //   32: invokevirtual 140	java/io/File:exists	()Z
    //   35: ifeq +8 -> 43
    //   38: aload_3
    //   39: invokevirtual 143	java/io/File:delete	()Z
    //   42: pop
    //   43: new 145	com/tencent/wcdb/database/SQLiteCipherSpec
    //   46: dup
    //   47: invokespecial 147	com/tencent/wcdb/database/SQLiteCipherSpec:<init>	()V
    //   50: astore 8
    //   52: aload 8
    //   54: sipush 1024
    //   57: putfield 151	com/tencent/wcdb/database/SQLiteCipherSpec:pageSize	I
    //   60: aload 8
    //   62: iconst_1
    //   63: putfield 155	com/tencent/wcdb/database/SQLiteCipherSpec:hmacEnabled	Z
    //   66: aload 8
    //   68: sipush 4000
    //   71: putfield 158	com/tencent/wcdb/database/SQLiteCipherSpec:kdfIteration	I
    //   74: aload 8
    //   76: ldc 160
    //   78: putfield 163	com/tencent/wcdb/database/SQLiteCipherSpec:cipher	Ljava/lang/String;
    //   81: getstatic 121	com/tencent/token/ait:b	Landroid/content/Context;
    //   84: ldc 165
    //   86: invokevirtual 135	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   89: astore_3
    //   90: aload_3
    //   91: invokevirtual 140	java/io/File:exists	()Z
    //   94: ifne +1378 -> 1472
    //   97: getstatic 121	com/tencent/token/ait:b	Landroid/content/Context;
    //   100: ldc 167
    //   102: invokevirtual 135	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   105: astore 4
    //   107: aload 4
    //   109: invokevirtual 140	java/io/File:exists	()Z
    //   112: ifeq +1369 -> 1481
    //   115: aload 4
    //   117: invokevirtual 170	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   120: iconst_1
    //   121: new 172	com/tencent/token/aio
    //   124: dup
    //   125: invokespecial 173	com/tencent/token/aio:<init>	()V
    //   128: invokestatic 176	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;ILcom/tencent/token/ahj;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   131: astore 4
    //   133: aload_3
    //   134: getstatic 178	com/tencent/token/ait:c	Ljava/lang/String;
    //   137: invokevirtual 182	java/lang/String:getBytes	()[B
    //   140: aload 8
    //   142: new 172	com/tencent/token/aio
    //   145: dup
    //   146: invokespecial 173	com/tencent/token/aio:<init>	()V
    //   149: invokestatic 185	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/io/File;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/token/ahj;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   152: astore_3
    //   153: aload_3
    //   154: astore 5
    //   156: aload 4
    //   158: astore 6
    //   160: new 187	java/util/HashSet
    //   163: dup
    //   164: invokespecial 188	java/util/HashSet:<init>	()V
    //   167: astore 7
    //   169: aload_3
    //   170: astore 5
    //   172: aload 4
    //   174: astore 6
    //   176: aload 7
    //   178: ldc 190
    //   180: invokevirtual 194	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   183: pop
    //   184: aload_3
    //   185: astore 5
    //   187: aload 4
    //   189: astore 6
    //   191: new 69	java/lang/StringBuilder
    //   194: dup
    //   195: ldc 196
    //   197: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: astore 9
    //   202: aload_3
    //   203: astore 5
    //   205: aload 4
    //   207: astore 6
    //   209: aload 4
    //   211: aload 9
    //   213: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: aconst_null
    //   217: aconst_null
    //   218: invokevirtual 199	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/ahi;
    //   221: astore 10
    //   223: aload 10
    //   225: ifnull +1076 -> 1301
    //   228: aload_3
    //   229: astore 5
    //   231: aload 4
    //   233: astore 6
    //   235: aload 10
    //   237: invokeinterface 41 1 0
    //   242: pop
    //   243: aload_3
    //   244: astore 5
    //   246: aload 4
    //   248: astore 6
    //   250: aload 10
    //   252: invokeinterface 202 1 0
    //   257: ifeq +1030 -> 1287
    //   260: aload_3
    //   261: astore 5
    //   263: aload 4
    //   265: astore 6
    //   267: aload 10
    //   269: iconst_0
    //   270: invokeinterface 205 2 0
    //   275: astore 13
    //   277: aload_3
    //   278: astore 5
    //   280: aload 4
    //   282: astore 6
    //   284: aload 9
    //   286: iconst_0
    //   287: invokevirtual 209	java/lang/StringBuilder:setLength	(I)V
    //   290: aload_3
    //   291: astore 5
    //   293: aload 4
    //   295: astore 6
    //   297: aload 9
    //   299: ldc 211
    //   301: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_3
    //   306: astore 5
    //   308: aload 4
    //   310: astore 6
    //   312: aload 9
    //   314: aload 13
    //   316: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_3
    //   321: astore 5
    //   323: aload 4
    //   325: astore 6
    //   327: aload 9
    //   329: ldc 213
    //   331: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_3
    //   336: astore 5
    //   338: aload 4
    //   340: astore 6
    //   342: aload 4
    //   344: aload 9
    //   346: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: aconst_null
    //   350: aconst_null
    //   351: invokevirtual 199	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/ahi;
    //   354: astore 11
    //   356: aload 11
    //   358: ifnull +1348 -> 1706
    //   361: aload_3
    //   362: astore 5
    //   364: aload 4
    //   366: astore 6
    //   368: aload 11
    //   370: invokeinterface 216 1 0
    //   375: ifeq +895 -> 1270
    //   378: aload_3
    //   379: astore 5
    //   381: aload 4
    //   383: astore 6
    //   385: aload 7
    //   387: aload 13
    //   389: invokevirtual 219	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   392: ifeq +20 -> 412
    //   395: aload_3
    //   396: astore 5
    //   398: aload 4
    //   400: astore 6
    //   402: aload 11
    //   404: invokeinterface 220 1 0
    //   409: goto -166 -> 243
    //   412: aload_3
    //   413: astore 5
    //   415: aload 4
    //   417: astore 6
    //   419: aload_3
    //   420: aload 11
    //   422: iconst_0
    //   423: invokeinterface 221 2 0
    //   428: invokevirtual 224	com/tencent/wcdb/database/SQLiteDatabase:b	(Ljava/lang/String;)I
    //   431: pop
    //   432: aload_3
    //   433: astore 5
    //   435: aload 4
    //   437: astore 6
    //   439: aload 4
    //   441: ldc 226
    //   443: aload 13
    //   445: invokestatic 229	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   448: invokevirtual 62	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   451: aconst_null
    //   452: aconst_null
    //   453: invokevirtual 199	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/ahi;
    //   456: astore 12
    //   458: aload 12
    //   460: ifnull +810 -> 1270
    //   463: aload_3
    //   464: astore 5
    //   466: aload 4
    //   468: astore 6
    //   470: aload 12
    //   472: invokeinterface 41 1 0
    //   477: ifle +793 -> 1270
    //   480: aload_3
    //   481: astore 5
    //   483: aload 4
    //   485: astore 6
    //   487: aload 9
    //   489: iconst_0
    //   490: invokevirtual 209	java/lang/StringBuilder:setLength	(I)V
    //   493: aload_3
    //   494: astore 5
    //   496: aload 4
    //   498: astore 6
    //   500: aload 9
    //   502: ldc 231
    //   504: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload_3
    //   509: astore 5
    //   511: aload 4
    //   513: astore 6
    //   515: aload 9
    //   517: aload 13
    //   519: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload_3
    //   524: astore 5
    //   526: aload 4
    //   528: astore 6
    //   530: aload 9
    //   532: ldc 233
    //   534: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload_3
    //   539: astore 5
    //   541: aload 4
    //   543: astore 6
    //   545: aload 12
    //   547: invokeinterface 236 1 0
    //   552: ifle +194 -> 746
    //   555: aload_3
    //   556: astore 5
    //   558: aload 4
    //   560: astore 6
    //   562: new 69	java/lang/StringBuilder
    //   565: dup
    //   566: ldc 238
    //   568: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   571: astore 13
    //   573: aload_3
    //   574: astore 5
    //   576: aload 4
    //   578: astore 6
    //   580: aload 12
    //   582: invokeinterface 242 1 0
    //   587: astore 14
    //   589: aload_3
    //   590: astore 5
    //   592: aload 4
    //   594: astore 6
    //   596: aload 14
    //   598: arraylength
    //   599: istore_1
    //   600: iconst_0
    //   601: istore_0
    //   602: iload_0
    //   603: iload_1
    //   604: if_icmpge +57 -> 661
    //   607: aload_3
    //   608: astore 5
    //   610: aload 4
    //   612: astore 6
    //   614: aload 9
    //   616: aload 14
    //   618: iload_0
    //   619: aaload
    //   620: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload_3
    //   625: astore 5
    //   627: aload 4
    //   629: astore 6
    //   631: aload 9
    //   633: ldc 244
    //   635: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload_3
    //   640: astore 5
    //   642: aload 4
    //   644: astore 6
    //   646: aload 13
    //   648: ldc 246
    //   650: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: iload_0
    //   655: iconst_1
    //   656: iadd
    //   657: istore_0
    //   658: goto -56 -> 602
    //   661: aload_3
    //   662: astore 5
    //   664: aload 4
    //   666: astore 6
    //   668: aload 13
    //   670: aload 13
    //   672: invokevirtual 249	java/lang/StringBuilder:length	()I
    //   675: iconst_1
    //   676: isub
    //   677: invokevirtual 253	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload_3
    //   682: astore 5
    //   684: aload 4
    //   686: astore 6
    //   688: aload 9
    //   690: aload 9
    //   692: invokevirtual 249	java/lang/StringBuilder:length	()I
    //   695: iconst_1
    //   696: isub
    //   697: invokevirtual 253	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload_3
    //   702: astore 5
    //   704: aload 4
    //   706: astore 6
    //   708: aload 9
    //   710: ldc 255
    //   712: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload_3
    //   717: astore 5
    //   719: aload 4
    //   721: astore 6
    //   723: aload 9
    //   725: aload 13
    //   727: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload_3
    //   732: astore 5
    //   734: aload 4
    //   736: astore 6
    //   738: aload 9
    //   740: ldc 255
    //   742: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload_3
    //   747: astore 5
    //   749: aload 4
    //   751: astore 6
    //   753: aload_3
    //   754: aload 9
    //   756: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokevirtual 261	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;)Lcom/tencent/token/aia;
    //   762: astore 13
    //   764: aload_3
    //   765: astore 5
    //   767: aload 4
    //   769: astore 6
    //   771: aload_3
    //   772: invokevirtual 264	com/tencent/wcdb/database/SQLiteDatabase:g	()V
    //   775: aload_3
    //   776: astore 5
    //   778: aload 4
    //   780: astore 6
    //   782: aload 12
    //   784: invokeinterface 236 1 0
    //   789: istore_1
    //   790: aload_3
    //   791: astore 5
    //   793: aload 4
    //   795: astore 6
    //   797: iload_1
    //   798: newarray int
    //   800: astore 14
    //   802: aload_3
    //   803: astore 5
    //   805: aload 4
    //   807: astore 6
    //   809: aload 12
    //   811: invokeinterface 45 1 0
    //   816: pop
    //   817: iconst_0
    //   818: istore_0
    //   819: iload_0
    //   820: iload_1
    //   821: if_icmpge +831 -> 1652
    //   824: aload_3
    //   825: astore 5
    //   827: aload 4
    //   829: astore 6
    //   831: aload 14
    //   833: iload_0
    //   834: aload 12
    //   836: iload_0
    //   837: invokeinterface 267 2 0
    //   842: iastore
    //   843: iload_0
    //   844: iconst_1
    //   845: iadd
    //   846: istore_0
    //   847: goto -28 -> 819
    //   850: aload_3
    //   851: astore 5
    //   853: aload 4
    //   855: astore 6
    //   857: aload 12
    //   859: iload_0
    //   860: invokeinterface 271 2 0
    //   865: astore 15
    //   867: aload 15
    //   869: ifnull +99 -> 968
    //   872: iload_0
    //   873: iconst_1
    //   874: iadd
    //   875: istore_2
    //   876: aload 15
    //   878: ifnull +21 -> 899
    //   881: aload_3
    //   882: astore 5
    //   884: aload 4
    //   886: astore 6
    //   888: aload 13
    //   890: iload_2
    //   891: aload 15
    //   893: invokevirtual 276	com/tencent/token/ahw:a	(ILjava/lang/Object;)V
    //   896: goto +800 -> 1696
    //   899: aload_3
    //   900: astore 5
    //   902: aload 4
    //   904: astore 6
    //   906: new 69	java/lang/StringBuilder
    //   909: dup
    //   910: ldc_w 278
    //   913: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   916: astore 7
    //   918: aload_3
    //   919: astore 5
    //   921: aload 4
    //   923: astore 6
    //   925: aload 7
    //   927: iload_2
    //   928: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload_3
    //   933: astore 5
    //   935: aload 4
    //   937: astore 6
    //   939: aload 7
    //   941: ldc_w 282
    //   944: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: pop
    //   948: aload_3
    //   949: astore 5
    //   951: aload 4
    //   953: astore 6
    //   955: new 284	java/lang/IllegalArgumentException
    //   958: dup
    //   959: aload 7
    //   961: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokespecial 285	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   967: athrow
    //   968: aload_3
    //   969: astore 5
    //   971: aload 4
    //   973: astore 6
    //   975: aload 13
    //   977: iload_0
    //   978: iconst_1
    //   979: iadd
    //   980: aconst_null
    //   981: invokevirtual 276	com/tencent/token/ahw:a	(ILjava/lang/Object;)V
    //   984: goto +712 -> 1696
    //   987: aload_3
    //   988: astore 5
    //   990: aload 4
    //   992: astore 6
    //   994: aload 12
    //   996: iload_0
    //   997: invokeinterface 205 2 0
    //   1002: astore 15
    //   1004: aload 15
    //   1006: ifnull +99 -> 1105
    //   1009: iload_0
    //   1010: iconst_1
    //   1011: iadd
    //   1012: istore_2
    //   1013: aload 15
    //   1015: ifnull +21 -> 1036
    //   1018: aload_3
    //   1019: astore 5
    //   1021: aload 4
    //   1023: astore 6
    //   1025: aload 13
    //   1027: iload_2
    //   1028: aload 15
    //   1030: invokevirtual 276	com/tencent/token/ahw:a	(ILjava/lang/Object;)V
    //   1033: goto +663 -> 1696
    //   1036: aload_3
    //   1037: astore 5
    //   1039: aload 4
    //   1041: astore 6
    //   1043: new 69	java/lang/StringBuilder
    //   1046: dup
    //   1047: ldc_w 278
    //   1050: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1053: astore 7
    //   1055: aload_3
    //   1056: astore 5
    //   1058: aload 4
    //   1060: astore 6
    //   1062: aload 7
    //   1064: iload_2
    //   1065: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aload_3
    //   1070: astore 5
    //   1072: aload 4
    //   1074: astore 6
    //   1076: aload 7
    //   1078: ldc_w 282
    //   1081: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: pop
    //   1085: aload_3
    //   1086: astore 5
    //   1088: aload 4
    //   1090: astore 6
    //   1092: new 284	java/lang/IllegalArgumentException
    //   1095: dup
    //   1096: aload 7
    //   1098: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1101: invokespecial 285	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1104: athrow
    //   1105: aload_3
    //   1106: astore 5
    //   1108: aload 4
    //   1110: astore 6
    //   1112: aload 13
    //   1114: iload_0
    //   1115: iconst_1
    //   1116: iadd
    //   1117: aconst_null
    //   1118: invokevirtual 276	com/tencent/token/ahw:a	(ILjava/lang/Object;)V
    //   1121: goto +575 -> 1696
    //   1124: aload_3
    //   1125: astore 5
    //   1127: aload 4
    //   1129: astore 6
    //   1131: aload 13
    //   1133: iload_0
    //   1134: iconst_1
    //   1135: iadd
    //   1136: aload 12
    //   1138: iload_0
    //   1139: invokeinterface 289 2 0
    //   1144: invokestatic 294	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1147: invokevirtual 276	com/tencent/token/ahw:a	(ILjava/lang/Object;)V
    //   1150: goto +546 -> 1696
    //   1153: aload_3
    //   1154: astore 5
    //   1156: aload 4
    //   1158: astore 6
    //   1160: aload 13
    //   1162: iload_0
    //   1163: iconst_1
    //   1164: iadd
    //   1165: aload 12
    //   1167: iload_0
    //   1168: invokeinterface 298 2 0
    //   1173: invokestatic 303	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1176: invokevirtual 276	com/tencent/token/ahw:a	(ILjava/lang/Object;)V
    //   1179: goto +517 -> 1696
    //   1182: aload_3
    //   1183: astore 5
    //   1185: aload 4
    //   1187: astore 6
    //   1189: aload 13
    //   1191: iload_0
    //   1192: iconst_1
    //   1193: iadd
    //   1194: aconst_null
    //   1195: invokevirtual 276	com/tencent/token/ahw:a	(ILjava/lang/Object;)V
    //   1198: goto +498 -> 1696
    //   1201: aload_3
    //   1202: astore 5
    //   1204: aload 4
    //   1206: astore 6
    //   1208: aload 13
    //   1210: invokevirtual 309	com/tencent/token/aia:f	()J
    //   1213: pop2
    //   1214: aload_3
    //   1215: astore 5
    //   1217: aload 4
    //   1219: astore 6
    //   1221: aload 12
    //   1223: invokeinterface 202 1 0
    //   1228: ifne +475 -> 1703
    //   1231: aload_3
    //   1232: astore 5
    //   1234: aload 4
    //   1236: astore 6
    //   1238: aload_3
    //   1239: invokevirtual 312	com/tencent/wcdb/database/SQLiteDatabase:i	()V
    //   1242: aload_3
    //   1243: astore 5
    //   1245: aload 4
    //   1247: astore 6
    //   1249: aload_3
    //   1250: invokevirtual 315	com/tencent/wcdb/database/SQLiteDatabase:h	()V
    //   1253: aload_3
    //   1254: astore 5
    //   1256: aload 4
    //   1258: astore 6
    //   1260: aload 12
    //   1262: invokeinterface 52 1 0
    //   1267: goto +3 -> 1270
    //   1270: aload_3
    //   1271: astore 5
    //   1273: aload 4
    //   1275: astore 6
    //   1277: aload 11
    //   1279: invokeinterface 220 1 0
    //   1284: goto +422 -> 1706
    //   1287: aload_3
    //   1288: astore 5
    //   1290: aload 4
    //   1292: astore 6
    //   1294: aload 10
    //   1296: invokeinterface 52 1 0
    //   1301: aload 4
    //   1303: ifnull +8 -> 1311
    //   1306: aload 4
    //   1308: invokevirtual 316	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1311: aload_3
    //   1312: ifnull +169 -> 1481
    //   1315: goto +123 -> 1438
    //   1318: astore 7
    //   1320: goto +35 -> 1355
    //   1323: astore_3
    //   1324: aconst_null
    //   1325: astore 5
    //   1327: goto +123 -> 1450
    //   1330: astore 7
    //   1332: aconst_null
    //   1333: astore_3
    //   1334: goto +21 -> 1355
    //   1337: astore_3
    //   1338: aconst_null
    //   1339: astore 5
    //   1341: aload 5
    //   1343: astore 4
    //   1345: goto +105 -> 1450
    //   1348: astore 7
    //   1350: aconst_null
    //   1351: astore_3
    //   1352: aload_3
    //   1353: astore 4
    //   1355: aload_3
    //   1356: astore 5
    //   1358: aload 4
    //   1360: astore 6
    //   1362: new 69	java/lang/StringBuilder
    //   1365: dup
    //   1366: ldc 71
    //   1368: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1371: astore 9
    //   1373: aload_3
    //   1374: astore 5
    //   1376: aload 4
    //   1378: astore 6
    //   1380: aload 9
    //   1382: aload 7
    //   1384: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   1387: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: aload_3
    //   1392: astore 5
    //   1394: aload 4
    //   1396: astore 6
    //   1398: aload 9
    //   1400: aload 7
    //   1402: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1405: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload_3
    //   1410: astore 5
    //   1412: aload 4
    //   1414: astore 6
    //   1416: aload 9
    //   1418: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1421: invokestatic 67	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1424: aload 4
    //   1426: ifnull +8 -> 1434
    //   1429: aload 4
    //   1431: invokevirtual 316	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1434: aload_3
    //   1435: ifnull +46 -> 1481
    //   1438: aload_3
    //   1439: invokevirtual 316	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1442: goto +39 -> 1481
    //   1445: astore_3
    //   1446: aload 6
    //   1448: astore 4
    //   1450: aload 4
    //   1452: ifnull +8 -> 1460
    //   1455: aload 4
    //   1457: invokevirtual 316	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1460: aload 5
    //   1462: ifnull +8 -> 1470
    //   1465: aload 5
    //   1467: invokevirtual 316	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1470: aload_3
    //   1471: athrow
    //   1472: getstatic 121	com/tencent/token/ait:b	Landroid/content/Context;
    //   1475: ldc 167
    //   1477: invokevirtual 135	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   1480: pop
    //   1481: new 318	com/tencent/token/aiq
    //   1484: dup
    //   1485: getstatic 121	com/tencent/token/ait:b	Landroid/content/Context;
    //   1488: getstatic 178	com/tencent/token/ait:c	Ljava/lang/String;
    //   1491: invokestatic 322	com/tencent/token/xf:a	()I
    //   1494: aload 8
    //   1496: invokespecial 325	com/tencent/token/aiq:<init>	(Landroid/content/Context;Ljava/lang/String;ILcom/tencent/wcdb/database/SQLiteCipherSpec;)V
    //   1499: putstatic 119	com/tencent/token/ait:a	Lcom/tencent/token/aiq;
    //   1502: goto +50 -> 1552
    //   1505: astore_3
    //   1506: aload_3
    //   1507: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1510: invokestatic 67	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1513: new 69	java/lang/StringBuilder
    //   1516: dup
    //   1517: ldc 71
    //   1519: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1522: astore 4
    //   1524: aload 4
    //   1526: aload_3
    //   1527: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   1530: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: pop
    //   1534: aload 4
    //   1536: aload_3
    //   1537: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1540: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: pop
    //   1544: aload 4
    //   1546: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1549: invokestatic 67	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1552: getstatic 119	com/tencent/token/ait:a	Lcom/tencent/token/aiq;
    //   1555: invokevirtual 326	com/tencent/token/aiq:a	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1558: astore_3
    //   1559: aload_3
    //   1560: areturn
    //   1561: astore_3
    //   1562: new 69	java/lang/StringBuilder
    //   1565: dup
    //   1566: ldc 71
    //   1568: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1571: astore 4
    //   1573: aload 4
    //   1575: aload_3
    //   1576: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1579: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: pop
    //   1583: aload 4
    //   1585: aload_3
    //   1586: invokevirtual 85	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1589: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: pop
    //   1593: aload 4
    //   1595: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1598: invokestatic 67	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1601: aconst_null
    //   1602: areturn
    //   1603: astore_3
    //   1604: aload_3
    //   1605: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1608: invokestatic 67	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1611: new 69	java/lang/StringBuilder
    //   1614: dup
    //   1615: ldc 71
    //   1617: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1620: astore 4
    //   1622: aload 4
    //   1624: aload_3
    //   1625: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   1628: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: pop
    //   1632: aload 4
    //   1634: aload_3
    //   1635: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1638: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1641: pop
    //   1642: aload 4
    //   1644: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1647: invokestatic 67	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1650: aconst_null
    //   1651: areturn
    //   1652: iconst_0
    //   1653: istore_0
    //   1654: iload_0
    //   1655: iload_1
    //   1656: if_icmpge -455 -> 1201
    //   1659: aload 14
    //   1661: iload_0
    //   1662: iaload
    //   1663: tableswitch	default:+33 -> 1696, 0:+-481->1182, 1:+-510->1153, 2:+-539->1124, 3:+-676->987, 4:+-813->850
    //   1697: iconst_1
    //   1698: iadd
    //   1699: istore_0
    //   1700: goto -46 -> 1654
    //   1703: goto -51 -> 1652
    //   1706: goto -1463 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   601	1099	0	i	int
    //   599	1058	1	j	int
    //   875	190	2	k	int
    //   26	1286	3	localObject1	Object
    //   1323	1	3	localObject2	Object
    //   1333	1	3	localObject3	Object
    //   1337	1	3	localObject4	Object
    //   1351	88	3	localObject5	Object
    //   1445	26	3	localObject6	Object
    //   1505	32	3	localException1	Exception
    //   1558	2	3	localSQLiteDatabase	SQLiteDatabase
    //   1561	25	3	localThrowable	Throwable
    //   1603	32	3	localException2	Exception
    //   105	1538	4	localObject7	Object
    //   154	1312	5	localObject8	Object
    //   158	1289	6	localObject9	Object
    //   167	930	7	localObject10	Object
    //   1318	1	7	localException3	Exception
    //   1330	1	7	localException4	Exception
    //   1348	53	7	localException5	Exception
    //   50	1445	8	localSQLiteCipherSpec	com.tencent.wcdb.database.SQLiteCipherSpec
    //   200	1217	9	localStringBuilder	StringBuilder
    //   221	1074	10	localahi1	ahi
    //   354	924	11	localahi2	ahi
    //   456	805	12	localahi3	ahi
    //   275	934	13	localObject11	Object
    //   587	1073	14	localObject12	Object
    //   865	164	15	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   160	169	1318	java/lang/Exception
    //   176	184	1318	java/lang/Exception
    //   191	202	1318	java/lang/Exception
    //   209	223	1318	java/lang/Exception
    //   235	243	1318	java/lang/Exception
    //   250	260	1318	java/lang/Exception
    //   267	277	1318	java/lang/Exception
    //   284	290	1318	java/lang/Exception
    //   297	305	1318	java/lang/Exception
    //   312	320	1318	java/lang/Exception
    //   327	335	1318	java/lang/Exception
    //   342	356	1318	java/lang/Exception
    //   368	378	1318	java/lang/Exception
    //   385	395	1318	java/lang/Exception
    //   402	409	1318	java/lang/Exception
    //   419	432	1318	java/lang/Exception
    //   439	458	1318	java/lang/Exception
    //   470	480	1318	java/lang/Exception
    //   487	493	1318	java/lang/Exception
    //   500	508	1318	java/lang/Exception
    //   515	523	1318	java/lang/Exception
    //   530	538	1318	java/lang/Exception
    //   545	555	1318	java/lang/Exception
    //   562	573	1318	java/lang/Exception
    //   580	589	1318	java/lang/Exception
    //   596	600	1318	java/lang/Exception
    //   614	624	1318	java/lang/Exception
    //   631	639	1318	java/lang/Exception
    //   646	654	1318	java/lang/Exception
    //   668	681	1318	java/lang/Exception
    //   688	701	1318	java/lang/Exception
    //   708	716	1318	java/lang/Exception
    //   723	731	1318	java/lang/Exception
    //   738	746	1318	java/lang/Exception
    //   753	764	1318	java/lang/Exception
    //   771	775	1318	java/lang/Exception
    //   782	790	1318	java/lang/Exception
    //   797	802	1318	java/lang/Exception
    //   809	817	1318	java/lang/Exception
    //   831	843	1318	java/lang/Exception
    //   857	867	1318	java/lang/Exception
    //   888	896	1318	java/lang/Exception
    //   906	918	1318	java/lang/Exception
    //   925	932	1318	java/lang/Exception
    //   939	948	1318	java/lang/Exception
    //   955	968	1318	java/lang/Exception
    //   975	984	1318	java/lang/Exception
    //   994	1004	1318	java/lang/Exception
    //   1025	1033	1318	java/lang/Exception
    //   1043	1055	1318	java/lang/Exception
    //   1062	1069	1318	java/lang/Exception
    //   1076	1085	1318	java/lang/Exception
    //   1092	1105	1318	java/lang/Exception
    //   1112	1121	1318	java/lang/Exception
    //   1131	1150	1318	java/lang/Exception
    //   1160	1179	1318	java/lang/Exception
    //   1189	1198	1318	java/lang/Exception
    //   1208	1214	1318	java/lang/Exception
    //   1221	1231	1318	java/lang/Exception
    //   1238	1242	1318	java/lang/Exception
    //   1249	1253	1318	java/lang/Exception
    //   1260	1267	1318	java/lang/Exception
    //   1277	1284	1318	java/lang/Exception
    //   1294	1301	1318	java/lang/Exception
    //   133	153	1323	finally
    //   133	153	1330	java/lang/Exception
    //   115	133	1337	finally
    //   115	133	1348	java/lang/Exception
    //   160	169	1445	finally
    //   176	184	1445	finally
    //   191	202	1445	finally
    //   209	223	1445	finally
    //   235	243	1445	finally
    //   250	260	1445	finally
    //   267	277	1445	finally
    //   284	290	1445	finally
    //   297	305	1445	finally
    //   312	320	1445	finally
    //   327	335	1445	finally
    //   342	356	1445	finally
    //   368	378	1445	finally
    //   385	395	1445	finally
    //   402	409	1445	finally
    //   419	432	1445	finally
    //   439	458	1445	finally
    //   470	480	1445	finally
    //   487	493	1445	finally
    //   500	508	1445	finally
    //   515	523	1445	finally
    //   530	538	1445	finally
    //   545	555	1445	finally
    //   562	573	1445	finally
    //   580	589	1445	finally
    //   596	600	1445	finally
    //   614	624	1445	finally
    //   631	639	1445	finally
    //   646	654	1445	finally
    //   668	681	1445	finally
    //   688	701	1445	finally
    //   708	716	1445	finally
    //   723	731	1445	finally
    //   738	746	1445	finally
    //   753	764	1445	finally
    //   771	775	1445	finally
    //   782	790	1445	finally
    //   797	802	1445	finally
    //   809	817	1445	finally
    //   831	843	1445	finally
    //   857	867	1445	finally
    //   888	896	1445	finally
    //   906	918	1445	finally
    //   925	932	1445	finally
    //   939	948	1445	finally
    //   955	968	1445	finally
    //   975	984	1445	finally
    //   994	1004	1445	finally
    //   1025	1033	1445	finally
    //   1043	1055	1445	finally
    //   1062	1069	1445	finally
    //   1076	1085	1445	finally
    //   1092	1105	1445	finally
    //   1112	1121	1445	finally
    //   1131	1150	1445	finally
    //   1160	1179	1445	finally
    //   1189	1198	1445	finally
    //   1208	1214	1445	finally
    //   1221	1231	1445	finally
    //   1238	1242	1445	finally
    //   1249	1253	1445	finally
    //   1260	1267	1445	finally
    //   1277	1284	1445	finally
    //   1294	1301	1445	finally
    //   1362	1373	1445	finally
    //   1380	1391	1445	finally
    //   1398	1409	1445	finally
    //   1416	1424	1445	finally
    //   1481	1502	1505	java/lang/Exception
    //   1552	1559	1561	java/lang/Throwable
    //   1552	1559	1603	java/lang/Exception
  }
  
  public static List<aiv> a(aiv paramaiv, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      c(paramaiv);
      paramString1 = a().a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4);
      if (paramString1.getCount() > 0)
      {
        paramString1.moveToFirst();
        do
        {
          localArrayList.add(paramaiv.a(paramString1));
        } while (paramString1.moveToNext());
      }
      paramString1.close();
      return localArrayList;
    }
    catch (Throwable paramaiv)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaiv.toString());
      paramString1.append(paramaiv.getMessage());
      xj.c(paramString1.toString());
      return localArrayList;
    }
    catch (Exception paramaiv)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaiv.toString());
      paramString1.append(paramaiv.getMessage());
      xj.c(paramString1.toString());
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext;
  }
  
  public static void a(String paramString)
  {
    try
    {
      localObject = a();
      ((SQLiteDatabase)localObject).b("DROP TABLE IF EXISTS ".concat(String.valueOf(paramString)));
      ((SQLiteDatabase)localObject).close();
      return;
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder("status_kk");
      ((StringBuilder)localObject).append(paramString.toString());
      ((StringBuilder)localObject).append(paramString.getMessage());
      xj.c(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder("status_kk");
      ((StringBuilder)localObject).append(paramString.toString());
      ((StringBuilder)localObject).append(paramString.getMessage());
      xj.c(((StringBuilder)localObject).toString());
    }
  }
  
  public static long b(aiv paramaiv)
  {
    try
    {
      c(paramaiv);
      long l = a().b(paramaiv.a(), paramaiv.b());
      return l;
    }
    catch (Throwable paramaiv)
    {
      localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaiv.toString());
      localStringBuilder.append(paramaiv.getMessage());
      xj.c(localStringBuilder.toString());
    }
    catch (Exception paramaiv)
    {
      StringBuilder localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaiv.toString());
      localStringBuilder.append(paramaiv.getMessage());
      xj.c(localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static long b(aiv paramaiv, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    for (;;)
    {
      try
      {
        c(paramaiv);
        paramaiv = a().a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4);
        if (paramaiv.getCount() > 0)
        {
          paramaiv.moveToLast();
          l = paramaiv.getLong(0);
          paramaiv.close();
          xj.c("test database, time=".concat(String.valueOf(l)));
          return l;
        }
      }
      catch (Throwable paramaiv)
      {
        paramString1 = new StringBuilder("status_kk");
        paramString1.append(paramaiv.toString());
        paramString1.append(paramaiv.getMessage());
        xj.c(paramString1.toString());
        return 0L;
      }
      catch (Exception paramaiv)
      {
        paramString1 = new StringBuilder("status_kk");
        paramString1.append(paramaiv.toString());
        paramString1.append(paramaiv.getMessage());
        xj.c(paramString1.toString());
        return 0L;
      }
      long l = 0L;
    }
  }
  
  public static void b()
  {
    aiq localaiq = a;
    if (localaiq != null) {
      try
      {
        localaiq.b();
        a = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder("status_kk");
        localStringBuilder.append(localThrowable.toString());
        localStringBuilder.append(localThrowable.getMessage());
        xj.c(localStringBuilder.toString());
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder("status_kk");
        localStringBuilder.append(localException.toString());
        localStringBuilder.append(localException.getMessage());
        xj.c(localStringBuilder.toString());
        return;
      }
    }
  }
  
  private static void c(aiv paramaiv)
  {
    try
    {
      paramaiv.a(a());
      return;
    }
    catch (Throwable paramaiv)
    {
      localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaiv.toString());
      localStringBuilder.append(paramaiv.getMessage());
      xj.c(localStringBuilder.toString());
      return;
    }
    catch (Exception paramaiv)
    {
      StringBuilder localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaiv.toString());
      localStringBuilder.append(paramaiv.getMessage());
      xj.c(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ait
 * JD-Core Version:    0.7.0.1
 */