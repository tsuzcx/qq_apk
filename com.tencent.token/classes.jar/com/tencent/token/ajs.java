package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class ajs
{
  private static ajp a;
  private static Context b;
  private static String c = "token";
  
  public static int a(aju paramaju, String paramString)
  {
    for (;;)
    {
      try
      {
        c(paramaju);
        paramaju = b().a(paramString, new String[] { "count(*)" }, null, null, null, null);
        if (paramaju.getCount() > 0)
        {
          paramaju.moveToFirst();
          i = paramaju.getInt(0);
          paramaju.close();
          xv.c("test database, tablecount=".concat(String.valueOf(i)));
          return i;
        }
      }
      catch (Throwable paramaju)
      {
        paramString = new StringBuilder("status_kk");
        paramString.append(paramaju.toString());
        paramString.append(paramaju.getMessage());
        xv.c(paramString.toString());
        return 0;
      }
      catch (Exception paramaju)
      {
        paramString = new StringBuilder("status_kk");
        paramString.append(paramaju.toString());
        paramString.append(paramaju.getMessage());
        xv.c(paramString.toString());
        return 0;
      }
      int i = 0;
    }
  }
  
  public static int a(aju paramaju, String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      c(paramaju);
      int i = b().a(paramString1, paramContentValues, paramString2, paramArrayOfString);
      return i;
    }
    catch (Throwable paramaju)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaju.toString());
      paramString1.append(paramaju.getMessage());
      xv.c(paramString1.toString());
    }
    catch (Exception paramaju)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaju.toString());
      paramString1.append(paramaju.getMessage());
      xv.c(paramString1.toString());
    }
    return 0;
  }
  
  public static int a(aju paramaju, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      c(paramaju);
      int i = b().a(paramString1, paramString2, paramArrayOfString);
      xv.c("test database, del=".concat(String.valueOf(i)));
      return i;
    }
    catch (Throwable paramaju)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaju.toString());
      paramString1.append(paramaju.getMessage());
      xv.c(paramString1.toString());
    }
    catch (Exception paramaju)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaju.toString());
      paramString1.append(paramaju.getMessage());
      xv.c(paramString1.toString());
    }
    return 0;
  }
  
  public static long a(aju paramaju)
  {
    try
    {
      c(paramaju);
      long l = paramaju.b(b());
      return l;
    }
    catch (Throwable paramaju)
    {
      localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaju.toString());
      localStringBuilder.append(paramaju.getMessage());
      xv.c(localStringBuilder.toString());
    }
    catch (Exception paramaju)
    {
      StringBuilder localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaju.toString());
      localStringBuilder.append(paramaju.getMessage());
      xv.c(localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static List<aju> a(aju paramaju, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      c(paramaju);
      paramString1 = b().a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4);
      if (paramString1.getCount() > 0)
      {
        paramString1.moveToFirst();
        do
        {
          localArrayList.add(paramaju.a(paramString1));
        } while (paramString1.moveToNext());
      }
      paramString1.close();
      return localArrayList;
    }
    catch (Throwable paramaju)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaju.toString());
      paramString1.append(paramaju.getMessage());
      xv.c(paramString1.toString());
      return localArrayList;
    }
    catch (Exception paramaju)
    {
      paramString1 = new StringBuilder("status_kk");
      paramString1.append(paramaju.toString());
      paramString1.append(paramaju.getMessage());
      xv.c(paramString1.toString());
    }
    return localArrayList;
  }
  
  public static void a()
  {
    ajp localajp = a;
    if (localajp != null) {
      try
      {
        localajp.b();
        a = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder("status_kk");
        localStringBuilder.append(localThrowable.toString());
        localStringBuilder.append(localThrowable.getMessage());
        xv.c(localStringBuilder.toString());
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder("status_kk");
        localStringBuilder.append(localException.toString());
        localStringBuilder.append(localException.getMessage());
        xv.c(localStringBuilder.toString());
        return;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext;
  }
  
  public static void a(String paramString)
  {
    try
    {
      localObject = b();
      ((SQLiteDatabase)localObject).b("DROP TABLE IF EXISTS ".concat(String.valueOf(paramString)));
      ((SQLiteDatabase)localObject).close();
      return;
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder("status_kk");
      ((StringBuilder)localObject).append(paramString.toString());
      ((StringBuilder)localObject).append(paramString.getMessage());
      xv.c(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder("status_kk");
      ((StringBuilder)localObject).append(paramString.toString());
      ((StringBuilder)localObject).append(paramString.getMessage());
      xv.c(((StringBuilder)localObject).toString());
    }
  }
  
  public static long b(aju paramaju)
  {
    try
    {
      c(paramaju);
      long l = b().b(paramaju.a(), paramaju.b());
      return l;
    }
    catch (Throwable paramaju)
    {
      localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaju.toString());
      localStringBuilder.append(paramaju.getMessage());
      xv.c(localStringBuilder.toString());
    }
    catch (Exception paramaju)
    {
      StringBuilder localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaju.toString());
      localStringBuilder.append(paramaju.getMessage());
      xv.c(localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static long b(aju paramaju, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    for (;;)
    {
      try
      {
        c(paramaju);
        paramaju = b().a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4);
        if (paramaju.getCount() > 0)
        {
          paramaju.moveToLast();
          l = paramaju.getLong(0);
          paramaju.close();
          xv.c("test database, time=".concat(String.valueOf(l)));
          return l;
        }
      }
      catch (Throwable paramaju)
      {
        paramString1 = new StringBuilder("status_kk");
        paramString1.append(paramaju.toString());
        paramString1.append(paramaju.getMessage());
        xv.c(paramString1.toString());
        return 0L;
      }
      catch (Exception paramaju)
      {
        paramString1 = new StringBuilder("status_kk");
        paramString1.append(paramaju.toString());
        paramString1.append(paramaju.getMessage());
        xv.c(paramString1.toString());
        return 0L;
      }
      long l = 0L;
    }
  }
  
  /* Error */
  private static SQLiteDatabase b()
  {
    // Byte code:
    //   0: getstatic 125	com/tencent/token/ajs:a	Lcom/tencent/token/ajp;
    //   3: ifnonnull +1557 -> 1560
    //   6: getstatic 132	com/tencent/token/ajs:b	Landroid/content/Context;
    //   9: ifnonnull +9 -> 18
    //   12: invokestatic 168	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   15: putstatic 132	com/tencent/token/ajs:b	Landroid/content/Context;
    //   18: getstatic 132	com/tencent/token/ajs:b	Landroid/content/Context;
    //   21: ldc 170
    //   23: invokevirtual 176	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +15 -> 43
    //   31: aload_3
    //   32: invokevirtual 181	java/io/File:exists	()Z
    //   35: ifeq +8 -> 43
    //   38: aload_3
    //   39: invokevirtual 184	java/io/File:delete	()Z
    //   42: pop
    //   43: new 186	com/tencent/wcdb/database/SQLiteCipherSpec
    //   46: dup
    //   47: invokespecial 187	com/tencent/wcdb/database/SQLiteCipherSpec:<init>	()V
    //   50: astore 8
    //   52: aload 8
    //   54: sipush 1024
    //   57: putfield 191	com/tencent/wcdb/database/SQLiteCipherSpec:pageSize	I
    //   60: aload 8
    //   62: iconst_1
    //   63: putfield 195	com/tencent/wcdb/database/SQLiteCipherSpec:hmacEnabled	Z
    //   66: aload 8
    //   68: sipush 4000
    //   71: putfield 198	com/tencent/wcdb/database/SQLiteCipherSpec:kdfIteration	I
    //   74: aload 8
    //   76: ldc 200
    //   78: putfield 203	com/tencent/wcdb/database/SQLiteCipherSpec:cipher	Ljava/lang/String;
    //   81: getstatic 132	com/tencent/token/ajs:b	Landroid/content/Context;
    //   84: ldc 205
    //   86: invokevirtual 176	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   89: astore_3
    //   90: aload_3
    //   91: invokevirtual 181	java/io/File:exists	()Z
    //   94: ifne +1386 -> 1480
    //   97: getstatic 132	com/tencent/token/ajs:b	Landroid/content/Context;
    //   100: ldc 207
    //   102: invokevirtual 176	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   105: astore 4
    //   107: aload 4
    //   109: invokevirtual 181	java/io/File:exists	()Z
    //   112: ifeq +1377 -> 1489
    //   115: aload 4
    //   117: invokevirtual 210	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   120: iconst_1
    //   121: new 212	com/tencent/token/ajo
    //   124: dup
    //   125: invokespecial 213	com/tencent/token/ajo:<init>	()V
    //   128: invokestatic 216	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;ILcom/tencent/token/aij;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   131: astore 4
    //   133: aload_3
    //   134: getstatic 218	com/tencent/token/ajs:c	Ljava/lang/String;
    //   137: invokevirtual 222	java/lang/String:getBytes	()[B
    //   140: aload 8
    //   142: new 212	com/tencent/token/ajo
    //   145: dup
    //   146: invokespecial 213	com/tencent/token/ajo:<init>	()V
    //   149: invokestatic 225	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/io/File;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/token/aij;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   152: astore_3
    //   153: aload_3
    //   154: astore 5
    //   156: aload 4
    //   158: astore 6
    //   160: new 227	java/util/HashSet
    //   163: dup
    //   164: invokespecial 228	java/util/HashSet:<init>	()V
    //   167: astore 7
    //   169: aload_3
    //   170: astore 5
    //   172: aload 4
    //   174: astore 6
    //   176: aload 7
    //   178: ldc 230
    //   180: invokevirtual 231	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   183: pop
    //   184: aload_3
    //   185: astore 5
    //   187: aload 4
    //   189: astore 6
    //   191: new 69	java/lang/StringBuilder
    //   194: dup
    //   195: ldc 233
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
    //   218: invokevirtual 236	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/aii;
    //   221: astore 10
    //   223: aload 10
    //   225: ifnull +1084 -> 1309
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
    //   252: invokeinterface 121 1 0
    //   257: ifeq +1038 -> 1295
    //   260: aload_3
    //   261: astore 5
    //   263: aload 4
    //   265: astore 6
    //   267: aload 10
    //   269: iconst_0
    //   270: invokeinterface 239 2 0
    //   275: astore 13
    //   277: aload_3
    //   278: astore 5
    //   280: aload 4
    //   282: astore 6
    //   284: aload 9
    //   286: iconst_0
    //   287: invokevirtual 243	java/lang/StringBuilder:setLength	(I)V
    //   290: aload_3
    //   291: astore 5
    //   293: aload 4
    //   295: astore 6
    //   297: aload 9
    //   299: ldc 245
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
    //   329: ldc 247
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
    //   351: invokevirtual 236	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/aii;
    //   354: astore 11
    //   356: aload 11
    //   358: ifnull +1356 -> 1714
    //   361: aload_3
    //   362: astore 5
    //   364: aload 4
    //   366: astore 6
    //   368: aload 11
    //   370: invokeinterface 250 1 0
    //   375: ifeq +903 -> 1278
    //   378: aload_3
    //   379: astore 5
    //   381: aload 4
    //   383: astore 6
    //   385: aload 7
    //   387: aload 13
    //   389: invokevirtual 253	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   392: ifeq +20 -> 412
    //   395: aload_3
    //   396: astore 5
    //   398: aload 4
    //   400: astore 6
    //   402: aload 11
    //   404: invokeinterface 254 1 0
    //   409: goto -166 -> 243
    //   412: aload_3
    //   413: astore 5
    //   415: aload 4
    //   417: astore 6
    //   419: aload_3
    //   420: aload 11
    //   422: iconst_0
    //   423: invokeinterface 255 2 0
    //   428: invokevirtual 140	com/tencent/wcdb/database/SQLiteDatabase:b	(Ljava/lang/String;)I
    //   431: pop
    //   432: aload_3
    //   433: astore 5
    //   435: aload 4
    //   437: astore 6
    //   439: aload 4
    //   441: ldc_w 257
    //   444: aload 13
    //   446: invokestatic 137	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   449: invokevirtual 62	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   452: aconst_null
    //   453: aconst_null
    //   454: invokevirtual 236	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/aii;
    //   457: astore 12
    //   459: aload 12
    //   461: ifnull +817 -> 1278
    //   464: aload_3
    //   465: astore 5
    //   467: aload 4
    //   469: astore 6
    //   471: aload 12
    //   473: invokeinterface 41 1 0
    //   478: ifle +800 -> 1278
    //   481: aload_3
    //   482: astore 5
    //   484: aload 4
    //   486: astore 6
    //   488: aload 9
    //   490: iconst_0
    //   491: invokevirtual 243	java/lang/StringBuilder:setLength	(I)V
    //   494: aload_3
    //   495: astore 5
    //   497: aload 4
    //   499: astore 6
    //   501: aload 9
    //   503: ldc_w 259
    //   506: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_3
    //   511: astore 5
    //   513: aload 4
    //   515: astore 6
    //   517: aload 9
    //   519: aload 13
    //   521: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload_3
    //   526: astore 5
    //   528: aload 4
    //   530: astore 6
    //   532: aload 9
    //   534: ldc_w 261
    //   537: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload_3
    //   542: astore 5
    //   544: aload 4
    //   546: astore 6
    //   548: aload 12
    //   550: invokeinterface 264 1 0
    //   555: ifle +199 -> 754
    //   558: aload_3
    //   559: astore 5
    //   561: aload 4
    //   563: astore 6
    //   565: new 69	java/lang/StringBuilder
    //   568: dup
    //   569: ldc_w 266
    //   572: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   575: astore 13
    //   577: aload_3
    //   578: astore 5
    //   580: aload 4
    //   582: astore 6
    //   584: aload 12
    //   586: invokeinterface 270 1 0
    //   591: astore 14
    //   593: aload_3
    //   594: astore 5
    //   596: aload 4
    //   598: astore 6
    //   600: aload 14
    //   602: arraylength
    //   603: istore_1
    //   604: iconst_0
    //   605: istore_0
    //   606: iload_0
    //   607: iload_1
    //   608: if_icmpge +59 -> 667
    //   611: aload_3
    //   612: astore 5
    //   614: aload 4
    //   616: astore 6
    //   618: aload 9
    //   620: aload 14
    //   622: iload_0
    //   623: aaload
    //   624: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_3
    //   629: astore 5
    //   631: aload 4
    //   633: astore 6
    //   635: aload 9
    //   637: ldc_w 272
    //   640: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload_3
    //   645: astore 5
    //   647: aload 4
    //   649: astore 6
    //   651: aload 13
    //   653: ldc_w 274
    //   656: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: iload_0
    //   661: iconst_1
    //   662: iadd
    //   663: istore_0
    //   664: goto -58 -> 606
    //   667: aload_3
    //   668: astore 5
    //   670: aload 4
    //   672: astore 6
    //   674: aload 13
    //   676: aload 13
    //   678: invokevirtual 277	java/lang/StringBuilder:length	()I
    //   681: iconst_1
    //   682: isub
    //   683: invokevirtual 281	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload_3
    //   688: astore 5
    //   690: aload 4
    //   692: astore 6
    //   694: aload 9
    //   696: aload 9
    //   698: invokevirtual 277	java/lang/StringBuilder:length	()I
    //   701: iconst_1
    //   702: isub
    //   703: invokevirtual 281	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload_3
    //   708: astore 5
    //   710: aload 4
    //   712: astore 6
    //   714: aload 9
    //   716: ldc_w 283
    //   719: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload_3
    //   724: astore 5
    //   726: aload 4
    //   728: astore 6
    //   730: aload 9
    //   732: aload 13
    //   734: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload_3
    //   739: astore 5
    //   741: aload 4
    //   743: astore 6
    //   745: aload 9
    //   747: ldc_w 283
    //   750: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload_3
    //   755: astore 5
    //   757: aload 4
    //   759: astore 6
    //   761: aload_3
    //   762: aload 9
    //   764: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokevirtual 289	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;)Lcom/tencent/token/aja;
    //   770: astore 13
    //   772: aload_3
    //   773: astore 5
    //   775: aload 4
    //   777: astore 6
    //   779: aload_3
    //   780: invokevirtual 292	com/tencent/wcdb/database/SQLiteDatabase:g	()V
    //   783: aload_3
    //   784: astore 5
    //   786: aload 4
    //   788: astore 6
    //   790: aload 12
    //   792: invokeinterface 264 1 0
    //   797: istore_1
    //   798: aload_3
    //   799: astore 5
    //   801: aload 4
    //   803: astore 6
    //   805: iload_1
    //   806: newarray int
    //   808: astore 14
    //   810: aload_3
    //   811: astore 5
    //   813: aload 4
    //   815: astore 6
    //   817: aload 12
    //   819: invokeinterface 45 1 0
    //   824: pop
    //   825: iconst_0
    //   826: istore_0
    //   827: iload_0
    //   828: iload_1
    //   829: if_icmpge +831 -> 1660
    //   832: aload_3
    //   833: astore 5
    //   835: aload 4
    //   837: astore 6
    //   839: aload 14
    //   841: iload_0
    //   842: aload 12
    //   844: iload_0
    //   845: invokeinterface 295 2 0
    //   850: iastore
    //   851: iload_0
    //   852: iconst_1
    //   853: iadd
    //   854: istore_0
    //   855: goto -28 -> 827
    //   858: aload_3
    //   859: astore 5
    //   861: aload 4
    //   863: astore 6
    //   865: aload 12
    //   867: iload_0
    //   868: invokeinterface 299 2 0
    //   873: astore 15
    //   875: aload 15
    //   877: ifnull +99 -> 976
    //   880: iload_0
    //   881: iconst_1
    //   882: iadd
    //   883: istore_2
    //   884: aload 15
    //   886: ifnull +21 -> 907
    //   889: aload_3
    //   890: astore 5
    //   892: aload 4
    //   894: astore 6
    //   896: aload 13
    //   898: iload_2
    //   899: aload 15
    //   901: invokevirtual 304	com/tencent/token/aiw:a	(ILjava/lang/Object;)V
    //   904: goto +800 -> 1704
    //   907: aload_3
    //   908: astore 5
    //   910: aload 4
    //   912: astore 6
    //   914: new 69	java/lang/StringBuilder
    //   917: dup
    //   918: ldc_w 306
    //   921: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   924: astore 7
    //   926: aload_3
    //   927: astore 5
    //   929: aload 4
    //   931: astore 6
    //   933: aload 7
    //   935: iload_2
    //   936: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload_3
    //   941: astore 5
    //   943: aload 4
    //   945: astore 6
    //   947: aload 7
    //   949: ldc_w 310
    //   952: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: aload_3
    //   957: astore 5
    //   959: aload 4
    //   961: astore 6
    //   963: new 312	java/lang/IllegalArgumentException
    //   966: dup
    //   967: aload 7
    //   969: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokespecial 313	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   975: athrow
    //   976: aload_3
    //   977: astore 5
    //   979: aload 4
    //   981: astore 6
    //   983: aload 13
    //   985: iload_0
    //   986: iconst_1
    //   987: iadd
    //   988: aconst_null
    //   989: invokevirtual 304	com/tencent/token/aiw:a	(ILjava/lang/Object;)V
    //   992: goto +712 -> 1704
    //   995: aload_3
    //   996: astore 5
    //   998: aload 4
    //   1000: astore 6
    //   1002: aload 12
    //   1004: iload_0
    //   1005: invokeinterface 239 2 0
    //   1010: astore 15
    //   1012: aload 15
    //   1014: ifnull +99 -> 1113
    //   1017: iload_0
    //   1018: iconst_1
    //   1019: iadd
    //   1020: istore_2
    //   1021: aload 15
    //   1023: ifnull +21 -> 1044
    //   1026: aload_3
    //   1027: astore 5
    //   1029: aload 4
    //   1031: astore 6
    //   1033: aload 13
    //   1035: iload_2
    //   1036: aload 15
    //   1038: invokevirtual 304	com/tencent/token/aiw:a	(ILjava/lang/Object;)V
    //   1041: goto +663 -> 1704
    //   1044: aload_3
    //   1045: astore 5
    //   1047: aload 4
    //   1049: astore 6
    //   1051: new 69	java/lang/StringBuilder
    //   1054: dup
    //   1055: ldc_w 306
    //   1058: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1061: astore 7
    //   1063: aload_3
    //   1064: astore 5
    //   1066: aload 4
    //   1068: astore 6
    //   1070: aload 7
    //   1072: iload_2
    //   1073: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: aload_3
    //   1078: astore 5
    //   1080: aload 4
    //   1082: astore 6
    //   1084: aload 7
    //   1086: ldc_w 310
    //   1089: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: pop
    //   1093: aload_3
    //   1094: astore 5
    //   1096: aload 4
    //   1098: astore 6
    //   1100: new 312	java/lang/IllegalArgumentException
    //   1103: dup
    //   1104: aload 7
    //   1106: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1109: invokespecial 313	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1112: athrow
    //   1113: aload_3
    //   1114: astore 5
    //   1116: aload 4
    //   1118: astore 6
    //   1120: aload 13
    //   1122: iload_0
    //   1123: iconst_1
    //   1124: iadd
    //   1125: aconst_null
    //   1126: invokevirtual 304	com/tencent/token/aiw:a	(ILjava/lang/Object;)V
    //   1129: goto +575 -> 1704
    //   1132: aload_3
    //   1133: astore 5
    //   1135: aload 4
    //   1137: astore 6
    //   1139: aload 13
    //   1141: iload_0
    //   1142: iconst_1
    //   1143: iadd
    //   1144: aload 12
    //   1146: iload_0
    //   1147: invokeinterface 317 2 0
    //   1152: invokestatic 322	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1155: invokevirtual 304	com/tencent/token/aiw:a	(ILjava/lang/Object;)V
    //   1158: goto +546 -> 1704
    //   1161: aload_3
    //   1162: astore 5
    //   1164: aload 4
    //   1166: astore 6
    //   1168: aload 13
    //   1170: iload_0
    //   1171: iconst_1
    //   1172: iadd
    //   1173: aload 12
    //   1175: iload_0
    //   1176: invokeinterface 157 2 0
    //   1181: invokestatic 327	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1184: invokevirtual 304	com/tencent/token/aiw:a	(ILjava/lang/Object;)V
    //   1187: goto +517 -> 1704
    //   1190: aload_3
    //   1191: astore 5
    //   1193: aload 4
    //   1195: astore 6
    //   1197: aload 13
    //   1199: iload_0
    //   1200: iconst_1
    //   1201: iadd
    //   1202: aconst_null
    //   1203: invokevirtual 304	com/tencent/token/aiw:a	(ILjava/lang/Object;)V
    //   1206: goto +498 -> 1704
    //   1209: aload_3
    //   1210: astore 5
    //   1212: aload 4
    //   1214: astore 6
    //   1216: aload 13
    //   1218: invokevirtual 333	com/tencent/token/aja:f	()J
    //   1221: pop2
    //   1222: aload_3
    //   1223: astore 5
    //   1225: aload 4
    //   1227: astore 6
    //   1229: aload 12
    //   1231: invokeinterface 121 1 0
    //   1236: ifne +475 -> 1711
    //   1239: aload_3
    //   1240: astore 5
    //   1242: aload 4
    //   1244: astore 6
    //   1246: aload_3
    //   1247: invokevirtual 336	com/tencent/wcdb/database/SQLiteDatabase:i	()V
    //   1250: aload_3
    //   1251: astore 5
    //   1253: aload 4
    //   1255: astore 6
    //   1257: aload_3
    //   1258: invokevirtual 339	com/tencent/wcdb/database/SQLiteDatabase:h	()V
    //   1261: aload_3
    //   1262: astore 5
    //   1264: aload 4
    //   1266: astore 6
    //   1268: aload 12
    //   1270: invokeinterface 52 1 0
    //   1275: goto +3 -> 1278
    //   1278: aload_3
    //   1279: astore 5
    //   1281: aload 4
    //   1283: astore 6
    //   1285: aload 11
    //   1287: invokeinterface 254 1 0
    //   1292: goto +422 -> 1714
    //   1295: aload_3
    //   1296: astore 5
    //   1298: aload 4
    //   1300: astore 6
    //   1302: aload 10
    //   1304: invokeinterface 52 1 0
    //   1309: aload 4
    //   1311: ifnull +8 -> 1319
    //   1314: aload 4
    //   1316: invokevirtual 141	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1319: aload_3
    //   1320: ifnull +169 -> 1489
    //   1323: goto +123 -> 1446
    //   1326: astore 7
    //   1328: goto +35 -> 1363
    //   1331: astore_3
    //   1332: aconst_null
    //   1333: astore 5
    //   1335: goto +123 -> 1458
    //   1338: astore 7
    //   1340: aconst_null
    //   1341: astore_3
    //   1342: goto +21 -> 1363
    //   1345: astore_3
    //   1346: aconst_null
    //   1347: astore 5
    //   1349: aload 5
    //   1351: astore 4
    //   1353: goto +105 -> 1458
    //   1356: astore 7
    //   1358: aconst_null
    //   1359: astore_3
    //   1360: aload_3
    //   1361: astore 4
    //   1363: aload_3
    //   1364: astore 5
    //   1366: aload 4
    //   1368: astore 6
    //   1370: new 69	java/lang/StringBuilder
    //   1373: dup
    //   1374: ldc 71
    //   1376: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1379: astore 9
    //   1381: aload_3
    //   1382: astore 5
    //   1384: aload 4
    //   1386: astore 6
    //   1388: aload 9
    //   1390: aload 7
    //   1392: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   1395: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: aload_3
    //   1400: astore 5
    //   1402: aload 4
    //   1404: astore 6
    //   1406: aload 9
    //   1408: aload 7
    //   1410: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1413: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: pop
    //   1417: aload_3
    //   1418: astore 5
    //   1420: aload 4
    //   1422: astore 6
    //   1424: aload 9
    //   1426: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1429: invokestatic 67	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   1432: aload 4
    //   1434: ifnull +8 -> 1442
    //   1437: aload 4
    //   1439: invokevirtual 141	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1442: aload_3
    //   1443: ifnull +46 -> 1489
    //   1446: aload_3
    //   1447: invokevirtual 141	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1450: goto +39 -> 1489
    //   1453: astore_3
    //   1454: aload 6
    //   1456: astore 4
    //   1458: aload 4
    //   1460: ifnull +8 -> 1468
    //   1463: aload 4
    //   1465: invokevirtual 141	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1468: aload 5
    //   1470: ifnull +8 -> 1478
    //   1473: aload 5
    //   1475: invokevirtual 141	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   1478: aload_3
    //   1479: athrow
    //   1480: getstatic 132	com/tencent/token/ajs:b	Landroid/content/Context;
    //   1483: ldc 207
    //   1485: invokevirtual 176	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   1488: pop
    //   1489: new 127	com/tencent/token/ajp
    //   1492: dup
    //   1493: getstatic 132	com/tencent/token/ajs:b	Landroid/content/Context;
    //   1496: getstatic 218	com/tencent/token/ajs:c	Ljava/lang/String;
    //   1499: invokestatic 343	com/tencent/token/xr:a	()I
    //   1502: aload 8
    //   1504: invokespecial 346	com/tencent/token/ajp:<init>	(Landroid/content/Context;Ljava/lang/String;ILcom/tencent/wcdb/database/SQLiteCipherSpec;)V
    //   1507: putstatic 125	com/tencent/token/ajs:a	Lcom/tencent/token/ajp;
    //   1510: goto +50 -> 1560
    //   1513: astore_3
    //   1514: aload_3
    //   1515: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1518: invokestatic 67	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   1521: new 69	java/lang/StringBuilder
    //   1524: dup
    //   1525: ldc 71
    //   1527: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1530: astore 4
    //   1532: aload 4
    //   1534: aload_3
    //   1535: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   1538: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: pop
    //   1542: aload 4
    //   1544: aload_3
    //   1545: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1548: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: pop
    //   1552: aload 4
    //   1554: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1557: invokestatic 67	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   1560: getstatic 125	com/tencent/token/ajs:a	Lcom/tencent/token/ajp;
    //   1563: invokevirtual 348	com/tencent/token/ajp:a	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   1566: astore_3
    //   1567: aload_3
    //   1568: areturn
    //   1569: astore_3
    //   1570: new 69	java/lang/StringBuilder
    //   1573: dup
    //   1574: ldc 71
    //   1576: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1579: astore 4
    //   1581: aload 4
    //   1583: aload_3
    //   1584: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1587: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: pop
    //   1591: aload 4
    //   1593: aload_3
    //   1594: invokevirtual 85	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1597: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: pop
    //   1601: aload 4
    //   1603: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1606: invokestatic 67	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   1609: aconst_null
    //   1610: areturn
    //   1611: astore_3
    //   1612: aload_3
    //   1613: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1616: invokestatic 67	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   1619: new 69	java/lang/StringBuilder
    //   1622: dup
    //   1623: ldc 71
    //   1625: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1628: astore 4
    //   1630: aload 4
    //   1632: aload_3
    //   1633: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   1636: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: pop
    //   1640: aload 4
    //   1642: aload_3
    //   1643: invokevirtual 88	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1646: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: pop
    //   1650: aload 4
    //   1652: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1655: invokestatic 67	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   1658: aconst_null
    //   1659: areturn
    //   1660: iconst_0
    //   1661: istore_0
    //   1662: iload_0
    //   1663: iload_1
    //   1664: if_icmpge -455 -> 1209
    //   1667: aload 14
    //   1669: iload_0
    //   1670: iaload
    //   1671: tableswitch	default:+33 -> 1704, 0:+-481->1190, 1:+-510->1161, 2:+-539->1132, 3:+-676->995, 4:+-813->858
    //   1705: iconst_1
    //   1706: iadd
    //   1707: istore_0
    //   1708: goto -46 -> 1662
    //   1711: goto -51 -> 1660
    //   1714: goto -1471 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   605	1103	0	i	int
    //   603	1062	1	j	int
    //   883	190	2	k	int
    //   26	1294	3	localObject1	Object
    //   1331	1	3	localObject2	Object
    //   1341	1	3	localObject3	Object
    //   1345	1	3	localObject4	Object
    //   1359	88	3	localObject5	Object
    //   1453	26	3	localObject6	Object
    //   1513	32	3	localException1	Exception
    //   1566	2	3	localSQLiteDatabase	SQLiteDatabase
    //   1569	25	3	localThrowable	Throwable
    //   1611	32	3	localException2	Exception
    //   105	1546	4	localObject7	Object
    //   154	1320	5	localObject8	Object
    //   158	1297	6	localObject9	Object
    //   167	938	7	localObject10	Object
    //   1326	1	7	localException3	Exception
    //   1338	1	7	localException4	Exception
    //   1356	53	7	localException5	Exception
    //   50	1453	8	localSQLiteCipherSpec	com.tencent.wcdb.database.SQLiteCipherSpec
    //   200	1225	9	localStringBuilder	StringBuilder
    //   221	1082	10	localaii1	aii
    //   354	932	11	localaii2	aii
    //   457	812	12	localaii3	aii
    //   275	942	13	localObject11	Object
    //   591	1077	14	localObject12	Object
    //   873	164	15	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   160	169	1326	java/lang/Exception
    //   176	184	1326	java/lang/Exception
    //   191	202	1326	java/lang/Exception
    //   209	223	1326	java/lang/Exception
    //   235	243	1326	java/lang/Exception
    //   250	260	1326	java/lang/Exception
    //   267	277	1326	java/lang/Exception
    //   284	290	1326	java/lang/Exception
    //   297	305	1326	java/lang/Exception
    //   312	320	1326	java/lang/Exception
    //   327	335	1326	java/lang/Exception
    //   342	356	1326	java/lang/Exception
    //   368	378	1326	java/lang/Exception
    //   385	395	1326	java/lang/Exception
    //   402	409	1326	java/lang/Exception
    //   419	432	1326	java/lang/Exception
    //   439	459	1326	java/lang/Exception
    //   471	481	1326	java/lang/Exception
    //   488	494	1326	java/lang/Exception
    //   501	510	1326	java/lang/Exception
    //   517	525	1326	java/lang/Exception
    //   532	541	1326	java/lang/Exception
    //   548	558	1326	java/lang/Exception
    //   565	577	1326	java/lang/Exception
    //   584	593	1326	java/lang/Exception
    //   600	604	1326	java/lang/Exception
    //   618	628	1326	java/lang/Exception
    //   635	644	1326	java/lang/Exception
    //   651	660	1326	java/lang/Exception
    //   674	687	1326	java/lang/Exception
    //   694	707	1326	java/lang/Exception
    //   714	723	1326	java/lang/Exception
    //   730	738	1326	java/lang/Exception
    //   745	754	1326	java/lang/Exception
    //   761	772	1326	java/lang/Exception
    //   779	783	1326	java/lang/Exception
    //   790	798	1326	java/lang/Exception
    //   805	810	1326	java/lang/Exception
    //   817	825	1326	java/lang/Exception
    //   839	851	1326	java/lang/Exception
    //   865	875	1326	java/lang/Exception
    //   896	904	1326	java/lang/Exception
    //   914	926	1326	java/lang/Exception
    //   933	940	1326	java/lang/Exception
    //   947	956	1326	java/lang/Exception
    //   963	976	1326	java/lang/Exception
    //   983	992	1326	java/lang/Exception
    //   1002	1012	1326	java/lang/Exception
    //   1033	1041	1326	java/lang/Exception
    //   1051	1063	1326	java/lang/Exception
    //   1070	1077	1326	java/lang/Exception
    //   1084	1093	1326	java/lang/Exception
    //   1100	1113	1326	java/lang/Exception
    //   1120	1129	1326	java/lang/Exception
    //   1139	1158	1326	java/lang/Exception
    //   1168	1187	1326	java/lang/Exception
    //   1197	1206	1326	java/lang/Exception
    //   1216	1222	1326	java/lang/Exception
    //   1229	1239	1326	java/lang/Exception
    //   1246	1250	1326	java/lang/Exception
    //   1257	1261	1326	java/lang/Exception
    //   1268	1275	1326	java/lang/Exception
    //   1285	1292	1326	java/lang/Exception
    //   1302	1309	1326	java/lang/Exception
    //   133	153	1331	finally
    //   133	153	1338	java/lang/Exception
    //   115	133	1345	finally
    //   115	133	1356	java/lang/Exception
    //   160	169	1453	finally
    //   176	184	1453	finally
    //   191	202	1453	finally
    //   209	223	1453	finally
    //   235	243	1453	finally
    //   250	260	1453	finally
    //   267	277	1453	finally
    //   284	290	1453	finally
    //   297	305	1453	finally
    //   312	320	1453	finally
    //   327	335	1453	finally
    //   342	356	1453	finally
    //   368	378	1453	finally
    //   385	395	1453	finally
    //   402	409	1453	finally
    //   419	432	1453	finally
    //   439	459	1453	finally
    //   471	481	1453	finally
    //   488	494	1453	finally
    //   501	510	1453	finally
    //   517	525	1453	finally
    //   532	541	1453	finally
    //   548	558	1453	finally
    //   565	577	1453	finally
    //   584	593	1453	finally
    //   600	604	1453	finally
    //   618	628	1453	finally
    //   635	644	1453	finally
    //   651	660	1453	finally
    //   674	687	1453	finally
    //   694	707	1453	finally
    //   714	723	1453	finally
    //   730	738	1453	finally
    //   745	754	1453	finally
    //   761	772	1453	finally
    //   779	783	1453	finally
    //   790	798	1453	finally
    //   805	810	1453	finally
    //   817	825	1453	finally
    //   839	851	1453	finally
    //   865	875	1453	finally
    //   896	904	1453	finally
    //   914	926	1453	finally
    //   933	940	1453	finally
    //   947	956	1453	finally
    //   963	976	1453	finally
    //   983	992	1453	finally
    //   1002	1012	1453	finally
    //   1033	1041	1453	finally
    //   1051	1063	1453	finally
    //   1070	1077	1453	finally
    //   1084	1093	1453	finally
    //   1100	1113	1453	finally
    //   1120	1129	1453	finally
    //   1139	1158	1453	finally
    //   1168	1187	1453	finally
    //   1197	1206	1453	finally
    //   1216	1222	1453	finally
    //   1229	1239	1453	finally
    //   1246	1250	1453	finally
    //   1257	1261	1453	finally
    //   1268	1275	1453	finally
    //   1285	1292	1453	finally
    //   1302	1309	1453	finally
    //   1370	1381	1453	finally
    //   1388	1399	1453	finally
    //   1406	1417	1453	finally
    //   1424	1432	1453	finally
    //   1489	1510	1513	java/lang/Exception
    //   1560	1567	1569	java/lang/Throwable
    //   1560	1567	1611	java/lang/Exception
  }
  
  private static void c(aju paramaju)
  {
    try
    {
      paramaju.a(b());
      return;
    }
    catch (Throwable paramaju)
    {
      localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaju.toString());
      localStringBuilder.append(paramaju.getMessage());
      xv.c(localStringBuilder.toString());
      return;
    }
    catch (Exception paramaju)
    {
      StringBuilder localStringBuilder = new StringBuilder("status_kk");
      localStringBuilder.append(paramaju.toString());
      localStringBuilder.append(paramaju.getMessage());
      xv.c(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajs
 * JD-Core Version:    0.7.0.1
 */