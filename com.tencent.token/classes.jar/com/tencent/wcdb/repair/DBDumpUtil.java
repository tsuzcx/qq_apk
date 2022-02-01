package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.PrintStream;
import java.util.ArrayList;

public class DBDumpUtil
{
  private static final String TAG = "WCDB.DBDumpUtil";
  
  public static String buildColumnsString(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return "";
    }
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
  
  public static boolean doRecoveryDb(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3)
  {
    return doRecoveryDb(paramSQLiteDatabase, paramString1, paramString2, paramString3, null, null, null, true);
  }
  
  /* Error */
  public static boolean doRecoveryDb(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, java.util.List<String> paramList1, java.util.List<String> paramList2, ExecuteSqlCallback paramExecuteSqlCallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 80	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   8: ifne +12 -> 20
    //   11: ldc 11
    //   13: ldc 82
    //   15: invokestatic 88	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_1
    //   21: aload_2
    //   22: aload_3
    //   23: invokestatic 92	com/tencent/wcdb/repair/DBDumpUtil:nativeDumpDB	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   26: ifne +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: new 94	java/io/BufferedReader
    //   34: dup
    //   35: new 96	java/io/FileReader
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 98	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 17
    //   48: aload_0
    //   49: ldc 103
    //   51: invokevirtual 106	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: invokevirtual 109	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   58: iconst_0
    //   59: istore 11
    //   61: iconst_0
    //   62: istore 10
    //   64: iconst_0
    //   65: istore 8
    //   67: aconst_null
    //   68: astore_2
    //   69: new 111	java/util/HashMap
    //   72: dup
    //   73: invokespecial 112	java/util/HashMap:<init>	()V
    //   76: astore 18
    //   78: iconst_0
    //   79: istore 9
    //   81: aload 17
    //   83: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   86: astore 15
    //   88: aload 15
    //   90: ifnull +562 -> 652
    //   93: iload 9
    //   95: ifeq +168 -> 263
    //   98: new 28	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   105: aload_2
    //   106: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 117
    //   111: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 15
    //   116: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 15
    //   124: aload 15
    //   126: astore_2
    //   127: aload 15
    //   129: ldc 119
    //   131: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   134: ifeq -53 -> 81
    //   137: aload 15
    //   139: astore_2
    //   140: aload 15
    //   142: invokestatic 126	com/tencent/wcdb/repair/DBDumpUtil:nativeIsSqlComplete	(Ljava/lang/String;)Z
    //   145: ifeq -64 -> 81
    //   148: aload 15
    //   150: astore_2
    //   151: iconst_0
    //   152: istore 9
    //   154: aload 5
    //   156: ifnull +186 -> 342
    //   159: aload 5
    //   161: invokeinterface 129 1 0
    //   166: ifle +176 -> 342
    //   169: aload_2
    //   170: invokestatic 133	com/tencent/wcdb/repair/DBDumpUtil:getTableNameFromSql	(Ljava/lang/String;)Ljava/lang/String;
    //   173: astore 16
    //   175: aload 5
    //   177: invokeinterface 137 1 0
    //   182: astore 15
    //   184: aload 15
    //   186: invokeinterface 142 1 0
    //   191: ifeq +672 -> 863
    //   194: aload 16
    //   196: aload 15
    //   198: invokeinterface 146 1 0
    //   203: checkcast 41	java/lang/String
    //   206: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   209: ifeq -25 -> 184
    //   212: iconst_0
    //   213: istore 9
    //   215: goto +651 -> 866
    //   218: iload 9
    //   220: ifeq +189 -> 409
    //   223: ldc 11
    //   225: ldc 152
    //   227: iconst_1
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload 16
    //   235: aastore
    //   236: invokestatic 156	com/tencent/wcdb/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: iconst_0
    //   240: istore 9
    //   242: goto -161 -> 81
    //   245: astore_0
    //   246: ldc 11
    //   248: ldc 158
    //   250: iconst_1
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_3
    //   257: aastore
    //   258: invokestatic 160	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: iconst_0
    //   262: ireturn
    //   263: aload 15
    //   265: ldc 162
    //   267: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   270: ifne +13 -> 283
    //   273: aload 15
    //   275: ldc 167
    //   277: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   280: ifeq -199 -> 81
    //   283: aload 15
    //   285: ldc 119
    //   287: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   290: ifeq +11 -> 301
    //   293: aload 15
    //   295: invokestatic 126	com/tencent/wcdb/repair/DBDumpUtil:nativeIsSqlComplete	(Ljava/lang/String;)Z
    //   298: ifne +577 -> 875
    //   301: aload_2
    //   302: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifeq +9 -> 314
    //   308: aload 15
    //   310: astore_2
    //   311: goto +558 -> 869
    //   314: new 28	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   321: aload_2
    //   322: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc 117
    //   327: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 15
    //   332: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: astore_2
    //   339: goto +530 -> 869
    //   342: aload 4
    //   344: ifnull +513 -> 857
    //   347: aload 4
    //   349: invokeinterface 129 1 0
    //   354: ifle +503 -> 857
    //   357: aload_2
    //   358: invokestatic 133	com/tencent/wcdb/repair/DBDumpUtil:getTableNameFromSql	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore 16
    //   363: aload 4
    //   365: invokeinterface 137 1 0
    //   370: astore 15
    //   372: aload 15
    //   374: invokeinterface 142 1 0
    //   379: ifeq +472 -> 851
    //   382: aload 16
    //   384: aload 15
    //   386: invokeinterface 146 1 0
    //   391: checkcast 41	java/lang/String
    //   394: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   397: ifeq -25 -> 372
    //   400: iconst_1
    //   401: istore 9
    //   403: ldc 26
    //   405: astore_2
    //   406: goto -188 -> 218
    //   409: aload_2
    //   410: ldc 167
    //   412: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   415: ifeq +128 -> 543
    //   418: aload 18
    //   420: aload 16
    //   422: aload_2
    //   423: invokestatic 177	com/tencent/wcdb/repair/DBDumpUtil:getColumnNamesFromSql	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   426: invokestatic 179	com/tencent/wcdb/repair/DBDumpUtil:buildColumnsString	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   429: invokevirtual 183	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   432: pop
    //   433: aload_2
    //   434: astore 15
    //   436: aconst_null
    //   437: astore_2
    //   438: aload 6
    //   440: ifnull +13 -> 453
    //   443: aload 6
    //   445: aload 15
    //   447: invokeinterface 186 2 0
    //   452: astore_2
    //   453: aload_2
    //   454: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   457: istore 14
    //   459: iload 14
    //   461: ifne +384 -> 845
    //   464: iload 10
    //   466: iconst_1
    //   467: iadd
    //   468: istore 12
    //   470: aload_0
    //   471: aload_2
    //   472: invokevirtual 106	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   475: iload 8
    //   477: iconst_1
    //   478: iadd
    //   479: istore 13
    //   481: iload 13
    //   483: istore 8
    //   485: iload 12
    //   487: istore 9
    //   489: iload 11
    //   491: istore 10
    //   493: iload 13
    //   495: bipush 100
    //   497: if_icmplt +26 -> 523
    //   500: aload_0
    //   501: invokevirtual 189	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   504: aload_0
    //   505: invokevirtual 192	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   508: aload_0
    //   509: invokevirtual 109	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   512: iconst_0
    //   513: istore 8
    //   515: iload 11
    //   517: istore 10
    //   519: iload 12
    //   521: istore 9
    //   523: aconst_null
    //   524: astore_2
    //   525: iload 9
    //   527: istore 12
    //   529: iconst_0
    //   530: istore 9
    //   532: iload 10
    //   534: istore 11
    //   536: iload 12
    //   538: istore 10
    //   540: goto -459 -> 81
    //   543: aload_2
    //   544: astore 15
    //   546: aload_2
    //   547: ldc 194
    //   549: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   552: ifeq -116 -> 436
    //   555: aload 18
    //   557: aload 16
    //   559: invokevirtual 197	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   562: checkcast 41	java/lang/String
    //   565: astore 19
    //   567: aload_2
    //   568: astore 15
    //   570: aload 19
    //   572: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   575: ifne -139 -> 436
    //   578: new 28	java/lang/StringBuilder
    //   581: dup
    //   582: ldc 199
    //   584: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   587: astore 15
    //   589: aload 15
    //   591: ldc 202
    //   593: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 16
    //   598: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc 202
    //   603: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload 15
    //   609: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: astore 16
    //   614: aload 15
    //   616: aload 19
    //   618: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload_2
    //   623: aload 16
    //   625: aload 15
    //   627: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokevirtual 206	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   633: astore 15
    //   635: goto -199 -> 436
    //   638: astore_2
    //   639: iload 10
    //   641: istore 9
    //   643: iload 11
    //   645: iconst_1
    //   646: iadd
    //   647: istore 10
    //   649: goto -126 -> 523
    //   652: aload 17
    //   654: ifnull +8 -> 662
    //   657: aload 17
    //   659: invokevirtual 209	java/io/BufferedReader:close	()V
    //   662: iload 10
    //   664: iload 11
    //   666: if_icmple +157 -> 823
    //   669: aload_0
    //   670: invokevirtual 212	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   673: ifeq +7 -> 680
    //   676: aload_0
    //   677: invokevirtual 189	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   680: aload_0
    //   681: invokevirtual 212	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   684: ifeq +7 -> 691
    //   687: aload_0
    //   688: invokevirtual 192	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   691: iload 7
    //   693: ifeq +45 -> 738
    //   696: new 214	java/io/File
    //   699: dup
    //   700: aload_3
    //   701: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   704: astore_0
    //   705: aload_0
    //   706: invokevirtual 218	java/io/File:exists	()Z
    //   709: ifeq +8 -> 717
    //   712: aload_0
    //   713: invokevirtual 221	java/io/File:delete	()Z
    //   716: pop
    //   717: new 214	java/io/File
    //   720: dup
    //   721: aload_1
    //   722: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   725: astore_0
    //   726: aload_0
    //   727: invokevirtual 218	java/io/File:exists	()Z
    //   730: ifeq +8 -> 738
    //   733: aload_0
    //   734: invokevirtual 221	java/io/File:delete	()Z
    //   737: pop
    //   738: ldc 11
    //   740: ldc 223
    //   742: iconst_2
    //   743: anewarray 4	java/lang/Object
    //   746: dup
    //   747: iconst_0
    //   748: iload 10
    //   750: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   753: aastore
    //   754: dup
    //   755: iconst_1
    //   756: iload 11
    //   758: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   761: aastore
    //   762: invokestatic 156	com/tencent/wcdb/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   765: iconst_1
    //   766: ireturn
    //   767: astore_2
    //   768: aload_2
    //   769: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   772: goto -110 -> 662
    //   775: astore_0
    //   776: ldc 11
    //   778: ldc 234
    //   780: invokestatic 88	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   783: aload 17
    //   785: ifnull -767 -> 18
    //   788: aload 17
    //   790: invokevirtual 209	java/io/BufferedReader:close	()V
    //   793: iconst_0
    //   794: ireturn
    //   795: astore_0
    //   796: aload_0
    //   797: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   800: iconst_0
    //   801: ireturn
    //   802: astore_0
    //   803: aload 17
    //   805: ifnull +8 -> 813
    //   808: aload 17
    //   810: invokevirtual 209	java/io/BufferedReader:close	()V
    //   813: aload_0
    //   814: athrow
    //   815: astore_1
    //   816: aload_1
    //   817: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   820: goto -7 -> 813
    //   823: iconst_0
    //   824: ireturn
    //   825: astore_2
    //   826: iload 12
    //   828: istore 9
    //   830: goto -187 -> 643
    //   833: astore_2
    //   834: iload 13
    //   836: istore 8
    //   838: iload 12
    //   840: istore 9
    //   842: goto -199 -> 643
    //   845: aload 15
    //   847: astore_2
    //   848: goto -384 -> 464
    //   851: iconst_0
    //   852: istore 9
    //   854: goto -636 -> 218
    //   857: aconst_null
    //   858: astore 16
    //   860: goto -642 -> 218
    //   863: iconst_1
    //   864: istore 9
    //   866: goto -648 -> 218
    //   869: iconst_1
    //   870: istore 9
    //   872: goto -791 -> 81
    //   875: aload 15
    //   877: astore_2
    //   878: goto -727 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	881	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	881	1	paramString1	String
    //   0	881	2	paramString2	String
    //   0	881	3	paramString3	String
    //   0	881	4	paramList1	java.util.List<String>
    //   0	881	5	paramList2	java.util.List<String>
    //   0	881	6	paramExecuteSqlCallback	ExecuteSqlCallback
    //   0	881	7	paramBoolean	boolean
    //   65	772	8	i	int
    //   79	792	9	j	int
    //   62	687	10	k	int
    //   59	698	11	m	int
    //   468	371	12	n	int
    //   479	356	13	i1	int
    //   457	3	14	bool	boolean
    //   86	790	15	localObject	Object
    //   173	686	16	str1	String
    //   46	763	17	localBufferedReader	java.io.BufferedReader
    //   76	480	18	localHashMap	java.util.HashMap
    //   565	52	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   31	48	245	java/io/FileNotFoundException
    //   409	433	638	java/lang/Exception
    //   443	453	638	java/lang/Exception
    //   453	459	638	java/lang/Exception
    //   546	567	638	java/lang/Exception
    //   570	635	638	java/lang/Exception
    //   657	662	767	java/io/IOException
    //   69	78	775	java/io/IOException
    //   81	88	775	java/io/IOException
    //   98	124	775	java/io/IOException
    //   127	137	775	java/io/IOException
    //   140	148	775	java/io/IOException
    //   159	184	775	java/io/IOException
    //   184	212	775	java/io/IOException
    //   223	239	775	java/io/IOException
    //   263	283	775	java/io/IOException
    //   283	301	775	java/io/IOException
    //   301	308	775	java/io/IOException
    //   314	339	775	java/io/IOException
    //   347	372	775	java/io/IOException
    //   372	400	775	java/io/IOException
    //   409	433	775	java/io/IOException
    //   443	453	775	java/io/IOException
    //   453	459	775	java/io/IOException
    //   470	475	775	java/io/IOException
    //   500	512	775	java/io/IOException
    //   546	567	775	java/io/IOException
    //   570	635	775	java/io/IOException
    //   788	793	795	java/io/IOException
    //   69	78	802	finally
    //   81	88	802	finally
    //   98	124	802	finally
    //   127	137	802	finally
    //   140	148	802	finally
    //   159	184	802	finally
    //   184	212	802	finally
    //   223	239	802	finally
    //   263	283	802	finally
    //   283	301	802	finally
    //   301	308	802	finally
    //   314	339	802	finally
    //   347	372	802	finally
    //   372	400	802	finally
    //   409	433	802	finally
    //   443	453	802	finally
    //   453	459	802	finally
    //   470	475	802	finally
    //   500	512	802	finally
    //   546	567	802	finally
    //   570	635	802	finally
    //   776	783	802	finally
    //   808	813	815	java/io/IOException
    //   470	475	825	java/lang/Exception
    //   500	512	833	java/lang/Exception
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
    //   0: new 214	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 218	java/io/File:exists	()Z
    //   13: ifne +21 -> 34
    //   16: ldc 11
    //   18: ldc_w 273
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: aastore
    //   29: invokestatic 160	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   71: if_icmpeq +55 -> 126
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
    //   93: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: iload_2
    //   100: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: invokestatic 160	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload 4
    //   109: ifnull -77 -> 32
    //   112: aload 4
    //   114: invokevirtual 288	java/io/FileInputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: aload 4
    //   128: ifnull +8 -> 136
    //   131: aload 4
    //   133: invokevirtual 288	java/io/FileInputStream:close	()V
    //   136: aload 5
    //   138: areturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   144: goto -8 -> 136
    //   147: astore 5
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: astore_3
    //   153: aload 5
    //   155: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 288	java/io/FileInputStream:close	()V
    //   166: ldc 11
    //   168: ldc_w 291
    //   171: invokestatic 294	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_0
    //   177: aload_0
    //   178: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   181: goto -15 -> 166
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 288	java/io/FileInputStream:close	()V
    //   195: aload_0
    //   196: athrow
    //   197: astore_3
    //   198: aload_3
    //   199: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   202: goto -7 -> 195
    //   205: astore_0
    //   206: goto -19 -> 187
    //   209: astore 5
    //   211: aload 4
    //   213: astore_0
    //   214: goto -63 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramString	String
    //   39	54	1	i	int
    //   68	32	2	j	int
    //   8	184	3	localObject	Object
    //   197	2	3	localIOException	java.io.IOException
    //   48	164	4	localFileInputStream	java.io.FileInputStream
    //   56	81	5	arrayOfByte	byte[]
    //   147	7	5	localException1	java.lang.Exception
    //   209	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   112	117	119	java/io/IOException
    //   131	136	139	java/io/IOException
    //   34	50	147	java/lang/Exception
    //   162	166	176	java/io/IOException
    //   34	50	184	finally
    //   191	195	197	java/io/IOException
    //   53	58	205	finally
    //   61	69	205	finally
    //   77	107	205	finally
    //   153	158	205	finally
    //   53	58	209	java/lang/Exception
    //   61	69	209	java/lang/Exception
    //   77	107	209	java/lang/Exception
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