package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.PrintStream;
import java.util.ArrayList;

public class DBDumpUtil
{
  private static final String TAG = "WCDB.DBDumpUtil";
  
  public static String buildColumnsString(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append((String)paramArrayList.get(i));
        if (i != paramArrayList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append(")");
      paramArrayList = localStringBuilder.toString();
      System.out.println(paramArrayList);
      return paramArrayList;
    }
    return "";
  }
  
  public static boolean doRecoveryDb(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3)
  {
    return doRecoveryDb(paramSQLiteDatabase, paramString1, paramString2, paramString3, null, null, null, true);
  }
  
  /* Error */
  public static boolean doRecoveryDb(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, java.util.List<String> paramList1, java.util.List<String> paramList2, ExecuteSqlCallback paramExecuteSqlCallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +887 -> 888
    //   4: aload_0
    //   5: invokevirtual 80	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   8: ifne +6 -> 14
    //   11: goto +877 -> 888
    //   14: aload_1
    //   15: aload_2
    //   16: aload_3
    //   17: invokestatic 84	com/tencent/wcdb/repair/DBDumpUtil:nativeDumpDB	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   20: ifne +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: new 86	java/io/BufferedReader
    //   28: dup
    //   29: new 88	java/io/FileReader
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 90	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 93	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore 15
    //   42: aload_0
    //   43: ldc 95
    //   45: invokevirtual 98	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: invokevirtual 101	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   52: new 103	java/util/HashMap
    //   55: dup
    //   56: invokespecial 104	java/util/HashMap:<init>	()V
    //   59: astore 16
    //   61: aconst_null
    //   62: astore_2
    //   63: iconst_0
    //   64: istore 8
    //   66: iconst_0
    //   67: istore 12
    //   69: iconst_0
    //   70: istore 10
    //   72: iconst_0
    //   73: istore 9
    //   75: aload 15
    //   77: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: astore 13
    //   82: aload 13
    //   84: ifnull +627 -> 711
    //   87: iload 8
    //   89: ifeq +72 -> 161
    //   92: new 26	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   99: astore 14
    //   101: aload 14
    //   103: aload_2
    //   104: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 14
    //   110: ldc 109
    //   112: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 14
    //   118: aload 13
    //   120: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 14
    //   126: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore 13
    //   131: aload 13
    //   133: astore_2
    //   134: aload 13
    //   136: ldc 111
    //   138: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   141: ifeq -66 -> 75
    //   144: aload 13
    //   146: astore_2
    //   147: aload 13
    //   149: invokestatic 118	com/tencent/wcdb/repair/DBDumpUtil:nativeIsSqlComplete	(Ljava/lang/String;)Z
    //   152: ifne +50 -> 202
    //   155: aload 13
    //   157: astore_2
    //   158: goto -83 -> 75
    //   161: aload 13
    //   163: ldc 120
    //   165: invokevirtual 123	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   168: ifne +13 -> 181
    //   171: aload 13
    //   173: ldc 125
    //   175: invokevirtual 123	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   178: ifeq -103 -> 75
    //   181: aload 13
    //   183: ldc 111
    //   185: invokevirtual 115	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   188: ifeq +466 -> 654
    //   191: aload 13
    //   193: invokestatic 118	com/tencent/wcdb/repair/DBDumpUtil:nativeIsSqlComplete	(Ljava/lang/String;)Z
    //   196: ifne +721 -> 917
    //   199: goto +455 -> 654
    //   202: aload 5
    //   204: ifnull +62 -> 266
    //   207: aload 5
    //   209: invokeinterface 128 1 0
    //   214: ifle +52 -> 266
    //   217: aload_2
    //   218: invokestatic 132	com/tencent/wcdb/repair/DBDumpUtil:getTableNameFromSql	(Ljava/lang/String;)Ljava/lang/String;
    //   221: astore 13
    //   223: aload 5
    //   225: invokeinterface 136 1 0
    //   230: astore 14
    //   232: aload 14
    //   234: invokeinterface 141 1 0
    //   239: ifeq +684 -> 923
    //   242: aload 13
    //   244: aload 14
    //   246: invokeinterface 145 1 0
    //   251: checkcast 39	java/lang/String
    //   254: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   257: ifeq -25 -> 232
    //   260: iconst_0
    //   261: istore 8
    //   263: goto +70 -> 333
    //   266: aload 4
    //   268: ifnull +667 -> 935
    //   271: aload 4
    //   273: invokeinterface 128 1 0
    //   278: ifle +657 -> 935
    //   281: aload_2
    //   282: invokestatic 132	com/tencent/wcdb/repair/DBDumpUtil:getTableNameFromSql	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore 13
    //   287: aload 4
    //   289: invokeinterface 136 1 0
    //   294: astore 14
    //   296: aload 14
    //   298: invokeinterface 141 1 0
    //   303: ifeq +626 -> 929
    //   306: aload 13
    //   308: aload 14
    //   310: invokeinterface 145 1 0
    //   315: checkcast 39	java/lang/String
    //   318: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   321: ifeq -25 -> 296
    //   324: ldc 61
    //   326: astore_2
    //   327: iconst_1
    //   328: istore 8
    //   330: goto +3 -> 333
    //   333: iload 8
    //   335: ifeq +25 -> 360
    //   338: ldc 11
    //   340: ldc 151
    //   342: iconst_1
    //   343: anewarray 4	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: aload 13
    //   350: aastore
    //   351: invokestatic 157	com/tencent/wcdb/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: iconst_0
    //   355: istore 8
    //   357: goto -282 -> 75
    //   360: iload 10
    //   362: istore 11
    //   364: aload_2
    //   365: ldc 125
    //   367: invokevirtual 123	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   370: ifeq +28 -> 398
    //   373: iload 10
    //   375: istore 11
    //   377: aload 16
    //   379: aload 13
    //   381: aload_2
    //   382: invokestatic 161	com/tencent/wcdb/repair/DBDumpUtil:getColumnNamesFromSql	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   385: invokestatic 163	com/tencent/wcdb/repair/DBDumpUtil:buildColumnsString	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   388: invokevirtual 167	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: aload_2
    //   393: astore 14
    //   395: goto +141 -> 536
    //   398: aload_2
    //   399: astore 14
    //   401: iload 10
    //   403: istore 11
    //   405: aload_2
    //   406: ldc 169
    //   408: invokevirtual 123	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   411: ifeq +125 -> 536
    //   414: iload 10
    //   416: istore 11
    //   418: aload 16
    //   420: aload 13
    //   422: invokevirtual 172	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   425: checkcast 39	java/lang/String
    //   428: astore 17
    //   430: aload_2
    //   431: astore 14
    //   433: iload 10
    //   435: istore 11
    //   437: aload 17
    //   439: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   442: ifne +94 -> 536
    //   445: iload 10
    //   447: istore 11
    //   449: new 26	java/lang/StringBuilder
    //   452: dup
    //   453: ldc 180
    //   455: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: astore 14
    //   460: iload 10
    //   462: istore 11
    //   464: aload 14
    //   466: ldc 183
    //   468: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: iload 10
    //   474: istore 11
    //   476: aload 14
    //   478: aload 13
    //   480: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: iload 10
    //   486: istore 11
    //   488: aload 14
    //   490: ldc 183
    //   492: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: iload 10
    //   498: istore 11
    //   500: aload 14
    //   502: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: astore 13
    //   507: iload 10
    //   509: istore 11
    //   511: aload 14
    //   513: aload 17
    //   515: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: iload 10
    //   521: istore 11
    //   523: aload_2
    //   524: aload 13
    //   526: aload 14
    //   528: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokevirtual 187	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   534: astore 14
    //   536: aload 6
    //   538: ifnull +406 -> 944
    //   541: iload 10
    //   543: istore 11
    //   545: aload 6
    //   547: aload 14
    //   549: invokeinterface 190 2 0
    //   554: astore_2
    //   555: goto +3 -> 558
    //   558: iload 10
    //   560: istore 11
    //   562: aload_2
    //   563: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   566: ifne +383 -> 949
    //   569: goto +3 -> 572
    //   572: iload 10
    //   574: iconst_1
    //   575: iadd
    //   576: istore 8
    //   578: iload 8
    //   580: istore 11
    //   582: aload_0
    //   583: aload_2
    //   584: invokevirtual 98	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   587: iload 9
    //   589: iconst_1
    //   590: iadd
    //   591: istore 10
    //   593: iload 10
    //   595: istore 9
    //   597: iload 10
    //   599: bipush 100
    //   601: if_icmplt +28 -> 629
    //   604: aload_0
    //   605: invokevirtual 193	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   608: aload_0
    //   609: invokevirtual 196	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   612: aload_0
    //   613: invokevirtual 101	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   616: iconst_0
    //   617: istore 9
    //   619: goto +10 -> 629
    //   622: iload 10
    //   624: istore 9
    //   626: goto +10 -> 636
    //   629: iload 8
    //   631: istore 10
    //   633: goto +13 -> 646
    //   636: iload 12
    //   638: iconst_1
    //   639: iadd
    //   640: istore 12
    //   642: iload 8
    //   644: istore 10
    //   646: aconst_null
    //   647: astore_2
    //   648: iconst_0
    //   649: istore 8
    //   651: goto -576 -> 75
    //   654: aload_2
    //   655: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifeq +9 -> 667
    //   661: aload 13
    //   663: astore_2
    //   664: goto +41 -> 705
    //   667: new 26	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   674: astore 14
    //   676: aload 14
    //   678: aload_2
    //   679: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 14
    //   685: ldc 109
    //   687: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload 14
    //   693: aload 13
    //   695: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 14
    //   701: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: astore_2
    //   705: iconst_1
    //   706: istore 8
    //   708: goto -633 -> 75
    //   711: aload 15
    //   713: invokevirtual 199	java/io/BufferedReader:close	()V
    //   716: goto +8 -> 724
    //   719: astore_2
    //   720: aload_2
    //   721: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   724: iload 10
    //   726: iload 12
    //   728: if_icmple +101 -> 829
    //   731: aload_0
    //   732: invokevirtual 205	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   735: ifeq +7 -> 742
    //   738: aload_0
    //   739: invokevirtual 193	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   742: aload_0
    //   743: invokevirtual 205	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   746: ifeq +7 -> 753
    //   749: aload_0
    //   750: invokevirtual 196	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   753: iload 7
    //   755: ifeq +45 -> 800
    //   758: new 207	java/io/File
    //   761: dup
    //   762: aload_3
    //   763: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   766: astore_0
    //   767: aload_0
    //   768: invokevirtual 211	java/io/File:exists	()Z
    //   771: ifeq +8 -> 779
    //   774: aload_0
    //   775: invokevirtual 214	java/io/File:delete	()Z
    //   778: pop
    //   779: new 207	java/io/File
    //   782: dup
    //   783: aload_1
    //   784: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   787: astore_0
    //   788: aload_0
    //   789: invokevirtual 211	java/io/File:exists	()Z
    //   792: ifeq +8 -> 800
    //   795: aload_0
    //   796: invokevirtual 214	java/io/File:delete	()Z
    //   799: pop
    //   800: ldc 11
    //   802: ldc 216
    //   804: iconst_2
    //   805: anewarray 4	java/lang/Object
    //   808: dup
    //   809: iconst_0
    //   810: iload 10
    //   812: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   815: aastore
    //   816: dup
    //   817: iconst_1
    //   818: iload 12
    //   820: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   823: aastore
    //   824: invokestatic 157	com/tencent/wcdb/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   827: iconst_1
    //   828: ireturn
    //   829: iconst_0
    //   830: ireturn
    //   831: astore_0
    //   832: goto +24 -> 856
    //   835: ldc 11
    //   837: ldc 224
    //   839: invokestatic 228	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   842: aload 15
    //   844: invokevirtual 199	java/io/BufferedReader:close	()V
    //   847: iconst_0
    //   848: ireturn
    //   849: astore_0
    //   850: aload_0
    //   851: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   854: iconst_0
    //   855: ireturn
    //   856: aload 15
    //   858: invokevirtual 199	java/io/BufferedReader:close	()V
    //   861: goto +8 -> 869
    //   864: astore_1
    //   865: aload_1
    //   866: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   869: aload_0
    //   870: athrow
    //   871: ldc 11
    //   873: ldc 230
    //   875: iconst_1
    //   876: anewarray 4	java/lang/Object
    //   879: dup
    //   880: iconst_0
    //   881: aload_3
    //   882: aastore
    //   883: invokestatic 232	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   886: iconst_0
    //   887: ireturn
    //   888: ldc 11
    //   890: ldc 234
    //   892: invokestatic 228	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   895: iconst_0
    //   896: ireturn
    //   897: astore_0
    //   898: goto -27 -> 871
    //   901: astore_0
    //   902: goto -67 -> 835
    //   905: astore_2
    //   906: iload 11
    //   908: istore 8
    //   910: goto -274 -> 636
    //   913: astore_2
    //   914: goto -292 -> 622
    //   917: aload 13
    //   919: astore_2
    //   920: goto -718 -> 202
    //   923: iconst_1
    //   924: istore 8
    //   926: goto -593 -> 333
    //   929: iconst_0
    //   930: istore 8
    //   932: goto -599 -> 333
    //   935: aconst_null
    //   936: astore 13
    //   938: iconst_0
    //   939: istore 8
    //   941: goto -608 -> 333
    //   944: aconst_null
    //   945: astore_2
    //   946: goto -388 -> 558
    //   949: aload 14
    //   951: astore_2
    //   952: goto -380 -> 572
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	955	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	955	1	paramString1	String
    //   0	955	2	paramString2	String
    //   0	955	3	paramString3	String
    //   0	955	4	paramList1	java.util.List<String>
    //   0	955	5	paramList2	java.util.List<String>
    //   0	955	6	paramExecuteSqlCallback	ExecuteSqlCallback
    //   0	955	7	paramBoolean	boolean
    //   64	876	8	i	int
    //   73	552	9	j	int
    //   70	741	10	k	int
    //   362	545	11	m	int
    //   67	752	12	n	int
    //   80	857	13	str1	String
    //   99	851	14	localObject	Object
    //   40	817	15	localBufferedReader	java.io.BufferedReader
    //   59	360	16	localHashMap	java.util.HashMap
    //   428	86	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   711	716	719	java/io/IOException
    //   52	61	831	finally
    //   75	82	831	finally
    //   92	131	831	finally
    //   134	144	831	finally
    //   147	155	831	finally
    //   161	181	831	finally
    //   181	199	831	finally
    //   207	232	831	finally
    //   232	260	831	finally
    //   271	296	831	finally
    //   296	324	831	finally
    //   338	354	831	finally
    //   364	373	831	finally
    //   377	392	831	finally
    //   405	414	831	finally
    //   418	430	831	finally
    //   437	445	831	finally
    //   449	460	831	finally
    //   464	472	831	finally
    //   476	484	831	finally
    //   488	496	831	finally
    //   500	507	831	finally
    //   511	519	831	finally
    //   523	536	831	finally
    //   545	555	831	finally
    //   562	569	831	finally
    //   582	587	831	finally
    //   604	616	831	finally
    //   654	661	831	finally
    //   667	705	831	finally
    //   835	842	831	finally
    //   842	847	849	java/io/IOException
    //   856	861	864	java/io/IOException
    //   25	42	897	java/io/FileNotFoundException
    //   52	61	901	java/io/IOException
    //   75	82	901	java/io/IOException
    //   92	131	901	java/io/IOException
    //   134	144	901	java/io/IOException
    //   147	155	901	java/io/IOException
    //   161	181	901	java/io/IOException
    //   181	199	901	java/io/IOException
    //   207	232	901	java/io/IOException
    //   232	260	901	java/io/IOException
    //   271	296	901	java/io/IOException
    //   296	324	901	java/io/IOException
    //   338	354	901	java/io/IOException
    //   364	373	901	java/io/IOException
    //   377	392	901	java/io/IOException
    //   405	414	901	java/io/IOException
    //   418	430	901	java/io/IOException
    //   437	445	901	java/io/IOException
    //   449	460	901	java/io/IOException
    //   464	472	901	java/io/IOException
    //   476	484	901	java/io/IOException
    //   488	496	901	java/io/IOException
    //   500	507	901	java/io/IOException
    //   511	519	901	java/io/IOException
    //   523	536	901	java/io/IOException
    //   545	555	901	java/io/IOException
    //   562	569	901	java/io/IOException
    //   582	587	901	java/io/IOException
    //   604	616	901	java/io/IOException
    //   654	661	901	java/io/IOException
    //   667	705	901	java/io/IOException
    //   364	373	905	java/lang/Exception
    //   377	392	905	java/lang/Exception
    //   405	414	905	java/lang/Exception
    //   418	430	905	java/lang/Exception
    //   437	445	905	java/lang/Exception
    //   449	460	905	java/lang/Exception
    //   464	472	905	java/lang/Exception
    //   476	484	905	java/lang/Exception
    //   488	496	905	java/lang/Exception
    //   500	507	905	java/lang/Exception
    //   511	519	905	java/lang/Exception
    //   523	536	905	java/lang/Exception
    //   545	555	905	java/lang/Exception
    //   562	569	905	java/lang/Exception
    //   582	587	905	java/lang/Exception
    //   604	616	913	java/lang/Exception
  }
  
  public static ArrayList<String> getColumnNamesFromSql(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.substring(paramString.indexOf("(") + 1, paramString.lastIndexOf(")")).trim().split(",");
    int i = 0;
    while (i < paramString.length)
    {
      paramString[i] = paramString[i].trim();
      int j = paramString[i].indexOf(" ");
      localArrayList.add(paramString[i].substring(0, j));
      i += 1;
    }
    return localArrayList;
  }
  
  public static String getTableNameFromSql(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 100) {
      str = paramString.substring(0, 100);
    }
    paramString = str.split("\\s");
    if ((paramString != null) && (paramString.length > 1)) {
      return paramString[2].replaceAll("\"", "");
    }
    return null;
  }
  
  private static native boolean nativeDumpDB(String paramString1, String paramString2, String paramString3);
  
  private static native boolean nativeIsSqlComplete(String paramString);
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: new 207	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 211	java/io/File:exists	()Z
    //   13: ifne +21 -> 34
    //   16: ldc 11
    //   18: ldc_w 273
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: aastore
    //   29: invokestatic 232	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aconst_null
    //   33: areturn
    //   34: aload_3
    //   35: invokevirtual 276	java/io/File:length	()J
    //   38: l2i
    //   39: istore_1
    //   40: new 278	java/io/FileInputStream
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 281	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: astore 4
    //   50: aload 4
    //   52: astore_3
    //   53: iload_1
    //   54: newarray byte
    //   56: astore 5
    //   58: aload 4
    //   60: astore_3
    //   61: aload 4
    //   63: aload 5
    //   65: invokevirtual 285	java/io/FileInputStream:read	([B)I
    //   68: istore_2
    //   69: iload_2
    //   70: iload_1
    //   71: if_icmpeq +50 -> 121
    //   74: aload 4
    //   76: astore_3
    //   77: ldc 11
    //   79: ldc_w 287
    //   82: iconst_3
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_0
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: iload_1
    //   93: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: iload_2
    //   100: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: invokestatic 232	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload 4
    //   109: invokevirtual 288	java/io/FileInputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   119: aconst_null
    //   120: areturn
    //   121: aload 4
    //   123: invokevirtual 288	java/io/FileInputStream:close	()V
    //   126: aload 5
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   134: aload 5
    //   136: areturn
    //   137: astore_3
    //   138: aload 4
    //   140: astore_0
    //   141: aload_3
    //   142: astore 4
    //   144: goto +13 -> 157
    //   147: astore_0
    //   148: aconst_null
    //   149: astore_3
    //   150: goto +41 -> 191
    //   153: astore 4
    //   155: aconst_null
    //   156: astore_0
    //   157: aload_0
    //   158: astore_3
    //   159: aload 4
    //   161: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   164: aload_0
    //   165: ifnull +15 -> 180
    //   168: aload_0
    //   169: invokevirtual 288	java/io/FileInputStream:close	()V
    //   172: goto +8 -> 180
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   180: ldc 11
    //   182: ldc_w 291
    //   185: invokestatic 294	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_0
    //   191: aload_3
    //   192: ifnull +15 -> 207
    //   195: aload_3
    //   196: invokevirtual 288	java/io/FileInputStream:close	()V
    //   199: goto +8 -> 207
    //   202: astore_3
    //   203: aload_3
    //   204: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   207: aload_0
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramString	String
    //   39	54	1	i	int
    //   68	32	2	j	int
    //   8	69	3	localObject1	Object
    //   137	5	3	localException1	java.lang.Exception
    //   149	47	3	str	String
    //   202	2	3	localIOException	java.io.IOException
    //   48	95	4	localObject2	Object
    //   153	7	4	localException2	java.lang.Exception
    //   56	79	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   107	112	114	java/io/IOException
    //   121	126	129	java/io/IOException
    //   53	58	137	java/lang/Exception
    //   61	69	137	java/lang/Exception
    //   77	107	137	java/lang/Exception
    //   34	50	147	finally
    //   34	50	153	java/lang/Exception
    //   168	172	175	java/io/IOException
    //   53	58	190	finally
    //   61	69	190	finally
    //   77	107	190	finally
    //   159	164	190	finally
    //   195	199	202	java/io/IOException
  }
  
  public static abstract interface ExecuteSqlCallback
  {
    public abstract String preExecute(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.DBDumpUtil
 * JD-Core Version:    0.7.0.1
 */