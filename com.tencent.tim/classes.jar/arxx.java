import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class arxx
{
  protected static final String TAG = arxx.class.getName();
  protected arxx.a a = new arxx.a(aroi.a().getContext(), "agent_cgi_report.db", null, 4);
  protected SQLiteDatabase db;
  
  /* Error */
  private ArrayList<arxz> c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 48
    //   4: ldc 50
    //   6: invokestatic 56	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 58	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 59	java/util/ArrayList:<init>	()V
    //   16: astore 5
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 42	arxx:a	Larxx$a;
    //   23: invokevirtual 63	arxx$a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: putfield 65	arxx:db	Landroid/database/sqlite/SQLiteDatabase;
    //   29: aconst_null
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 65	arxx:db	Landroid/database/sqlite/SQLiteDatabase;
    //   36: new 67	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   43: ldc 70
    //   45: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 78
    //   59: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 80
    //   64: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: iconst_1
    //   71: anewarray 85	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: aload_2
    //   77: aastore
    //   78: invokevirtual 91	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +325 -> 408
    //   86: aload_3
    //   87: invokeinterface 97 1 0
    //   92: pop
    //   93: aload_3
    //   94: invokeinterface 100 1 0
    //   99: ifne +309 -> 408
    //   102: aload_3
    //   103: aload_3
    //   104: ldc 102
    //   106: invokeinterface 106 2 0
    //   111: invokeinterface 110 2 0
    //   116: astore 4
    //   118: aload_3
    //   119: aload_3
    //   120: ldc 112
    //   122: invokeinterface 106 2 0
    //   127: invokeinterface 110 2 0
    //   132: astore 6
    //   134: aload_3
    //   135: aload_3
    //   136: ldc 114
    //   138: invokeinterface 106 2 0
    //   143: invokeinterface 110 2 0
    //   148: astore 7
    //   150: aload_3
    //   151: aload_3
    //   152: ldc 116
    //   154: invokeinterface 106 2 0
    //   159: invokeinterface 110 2 0
    //   164: astore 8
    //   166: aload_3
    //   167: aload_3
    //   168: ldc 118
    //   170: invokeinterface 106 2 0
    //   175: invokeinterface 110 2 0
    //   180: astore 9
    //   182: aload_3
    //   183: aload_3
    //   184: ldc 120
    //   186: invokeinterface 106 2 0
    //   191: invokeinterface 110 2 0
    //   196: astore 10
    //   198: aload_3
    //   199: aload_3
    //   200: ldc 122
    //   202: invokeinterface 106 2 0
    //   207: invokeinterface 110 2 0
    //   212: astore 11
    //   214: aload_3
    //   215: aload_3
    //   216: ldc 124
    //   218: invokeinterface 106 2 0
    //   223: invokeinterface 110 2 0
    //   228: astore 12
    //   230: aload 5
    //   232: new 126	arxz
    //   235: dup
    //   236: aload 4
    //   238: aload 6
    //   240: aload 7
    //   242: aload 8
    //   244: aload 9
    //   246: aload 10
    //   248: aload 11
    //   250: aload_3
    //   251: aload_3
    //   252: ldc 128
    //   254: invokeinterface 106 2 0
    //   259: invokeinterface 110 2 0
    //   264: aload_3
    //   265: aload_3
    //   266: ldc 130
    //   268: invokeinterface 106 2 0
    //   273: invokeinterface 110 2 0
    //   278: aload 12
    //   280: aload_2
    //   281: invokespecial 133	arxz:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   284: invokevirtual 137	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   287: pop
    //   288: aload_3
    //   289: invokeinterface 140 1 0
    //   294: pop
    //   295: goto -202 -> 93
    //   298: astore 4
    //   300: aload_3
    //   301: astore_2
    //   302: aload 4
    //   304: astore_3
    //   305: getstatic 22	arxx:TAG	Ljava/lang/String;
    //   308: new 67	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   315: ldc 142
    //   317: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_1
    //   321: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 144
    //   326: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: aload_3
    //   333: invokestatic 148	arwt:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: aload_2
    //   337: ifnull +9 -> 346
    //   340: aload_2
    //   341: invokeinterface 151 1 0
    //   346: aload_0
    //   347: getfield 65	arxx:db	Landroid/database/sqlite/SQLiteDatabase;
    //   350: invokevirtual 152	android/database/sqlite/SQLiteDatabase:close	()V
    //   353: ldc 48
    //   355: new 67	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   362: ldc 142
    //   364: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc 154
    //   373: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload 5
    //   378: invokevirtual 158	java/util/ArrayList:size	()I
    //   381: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 56	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload_0
    //   391: monitorexit
    //   392: aload 5
    //   394: areturn
    //   395: astore_1
    //   396: getstatic 22	arxx:TAG	Ljava/lang/String;
    //   399: ldc 163
    //   401: aload_1
    //   402: invokestatic 148	arwt:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   405: goto -15 -> 390
    //   408: aload_3
    //   409: ifnull -63 -> 346
    //   412: aload_3
    //   413: invokeinterface 151 1 0
    //   418: goto -72 -> 346
    //   421: astore_1
    //   422: aload_0
    //   423: monitorexit
    //   424: aload_1
    //   425: athrow
    //   426: astore_1
    //   427: aconst_null
    //   428: astore_3
    //   429: aload_3
    //   430: ifnull +9 -> 439
    //   433: aload_3
    //   434: invokeinterface 151 1 0
    //   439: aload_1
    //   440: athrow
    //   441: astore_1
    //   442: goto -13 -> 429
    //   445: astore_1
    //   446: aload_2
    //   447: astore_3
    //   448: goto -19 -> 429
    //   451: astore_3
    //   452: aload 4
    //   454: astore_2
    //   455: goto -150 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	arxx
    //   0	458	1	paramString1	String
    //   0	458	2	paramString2	String
    //   81	367	3	localObject	Object
    //   451	1	3	localException1	Exception
    //   30	207	4	str1	String
    //   298	155	4	localException2	Exception
    //   16	377	5	localArrayList	ArrayList
    //   132	107	6	str2	String
    //   148	93	7	str3	String
    //   164	79	8	str4	String
    //   180	65	9	str5	String
    //   196	51	10	str6	String
    //   212	37	11	str7	String
    //   228	51	12	str8	String
    // Exception table:
    //   from	to	target	type
    //   86	93	298	java/lang/Exception
    //   93	295	298	java/lang/Exception
    //   18	29	395	java/lang/Exception
    //   2	18	421	finally
    //   18	29	421	finally
    //   340	346	421	finally
    //   346	390	421	finally
    //   396	405	421	finally
    //   412	418	421	finally
    //   433	439	421	finally
    //   439	441	421	finally
    //   32	82	426	finally
    //   86	93	441	finally
    //   93	295	441	finally
    //   305	336	445	finally
    //   32	82	451	java/lang/Exception
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 13
    //   5: aload_3
    //   6: ldc 168
    //   8: invokevirtual 172	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +13 -> 24
    //   14: aload_3
    //   15: ldc 174
    //   17: invokevirtual 178	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   20: iconst_0
    //   21: aaload
    //   22: astore 13
    //   24: ldc 48
    //   26: new 67	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   33: ldc 180
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 182
    //   44: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 184
    //   53: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 13
    //   58: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 186
    //   63: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 4
    //   68: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 188
    //   73: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 5
    //   78: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 190
    //   83: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload 6
    //   88: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 192
    //   93: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 7
    //   98: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 56	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: new 194	android/content/ContentValues
    //   110: dup
    //   111: invokespecial 195	android/content/ContentValues:<init>	()V
    //   114: astore_3
    //   115: aload_3
    //   116: ldc 102
    //   118: new 67	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   125: aload_1
    //   126: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 197
    //   131: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_3
    //   141: ldc 112
    //   143: new 67	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   150: aload_2
    //   151: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 197
    //   156: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_3
    //   166: ldc 114
    //   168: new 67	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   175: aload 13
    //   177: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 197
    //   182: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_3
    //   192: ldc 116
    //   194: new 67	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   201: aload 4
    //   203: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 197
    //   208: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_3
    //   218: ldc 118
    //   220: new 67	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   227: aload 5
    //   229: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 197
    //   234: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_3
    //   244: ldc 120
    //   246: new 67	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   253: aload 6
    //   255: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc 197
    //   260: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_3
    //   270: ldc 122
    //   272: new 67	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   279: aload 7
    //   281: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 197
    //   286: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_3
    //   296: ldc 128
    //   298: new 67	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   305: aload 8
    //   307: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 197
    //   312: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload_3
    //   322: ldc 78
    //   324: new 67	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   331: aload 10
    //   333: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc 197
    //   338: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: new 67	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   354: astore_2
    //   355: aload_2
    //   356: ldc 202
    //   358: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_1
    //   362: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: bipush 38
    //   367: invokevirtual 205	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload_2
    //   372: ldc 207
    //   374: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: astore_1
    //   378: invokestatic 212	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   381: ldc 214
    //   383: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   386: ifeq +166 -> 552
    //   389: iconst_1
    //   390: istore 11
    //   392: aload_1
    //   393: iload 11
    //   395: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   398: bipush 38
    //   400: invokevirtual 205	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_2
    //   405: ldc 219
    //   407: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokestatic 31	aroi:a	()Laroi;
    //   413: invokevirtual 35	aroi:getContext	()Landroid/content/Context;
    //   416: invokestatic 225	arwo:bH	(Landroid/content/Context;)Ljava/lang/String;
    //   419: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload_3
    //   424: ldc 130
    //   426: aload_2
    //   427: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: new 67	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   440: ldc 227
    //   442: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokestatic 31	aroi:a	()Laroi;
    //   448: invokevirtual 231	aroi:getUin	()J
    //   451: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   454: ldc 197
    //   456: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: astore_2
    //   463: aload_2
    //   464: astore_1
    //   465: aload 9
    //   467: ifnull +33 -> 500
    //   470: new 67	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   477: aload_2
    //   478: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: ldc 236
    //   483: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 9
    //   488: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc 197
    //   493: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: astore_1
    //   500: aload_3
    //   501: ldc 124
    //   503: aload_1
    //   504: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: aload_0
    //   508: aload_0
    //   509: getfield 42	arxx:a	Larxx$a;
    //   512: invokevirtual 239	arxx$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   515: putfield 65	arxx:db	Landroid/database/sqlite/SQLiteDatabase;
    //   518: aload_0
    //   519: getfield 65	arxx:db	Landroid/database/sqlite/SQLiteDatabase;
    //   522: ldc 241
    //   524: aconst_null
    //   525: aload_3
    //   526: invokevirtual 245	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   529: pop2
    //   530: aload_0
    //   531: getfield 65	arxx:db	Landroid/database/sqlite/SQLiteDatabase;
    //   534: invokevirtual 152	android/database/sqlite/SQLiteDatabase:close	()V
    //   537: ldc 48
    //   539: ldc 247
    //   541: invokestatic 56	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: iconst_1
    //   545: istore 12
    //   547: aload_0
    //   548: monitorexit
    //   549: iload 12
    //   551: ireturn
    //   552: iconst_0
    //   553: istore 11
    //   555: goto -163 -> 392
    //   558: astore_1
    //   559: ldc 48
    //   561: ldc 249
    //   563: invokestatic 252	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: iconst_0
    //   567: istore 12
    //   569: goto -22 -> 547
    //   572: astore_1
    //   573: aload_0
    //   574: monitorexit
    //   575: aload_1
    //   576: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	arxx
    //   0	577	1	paramString1	String
    //   0	577	2	paramString2	String
    //   0	577	3	paramString3	String
    //   0	577	4	paramString4	String
    //   0	577	5	paramString5	String
    //   0	577	6	paramString6	String
    //   0	577	7	paramString7	String
    //   0	577	8	paramString8	String
    //   0	577	9	paramString9	String
    //   0	577	10	paramString10	String
    //   390	164	11	i	int
    //   545	23	12	bool	boolean
    //   3	173	13	str	String
    // Exception table:
    //   from	to	target	type
    //   507	544	558	java/lang/Exception
    //   5	24	572	finally
    //   24	389	572	finally
    //   392	463	572	finally
    //   470	500	572	finally
    //   500	507	572	finally
    //   507	544	572	finally
    //   559	566	572	finally
  }
  
  /* Error */
  public int ai(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: invokestatic 259	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +64 -> 73
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_2
    //   16: invokestatic 259	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: istore 4
    //   21: iload 4
    //   23: ifeq +58 -> 81
    //   26: aload 6
    //   28: astore_2
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 42	arxx:a	Larxx$a;
    //   34: invokevirtual 63	arxx$a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: putfield 65	arxx:db	Landroid/database/sqlite/SQLiteDatabase;
    //   40: aload_0
    //   41: getfield 65	arxx:db	Landroid/database/sqlite/SQLiteDatabase;
    //   44: aload_1
    //   45: aconst_null
    //   46: aload 5
    //   48: aload_2
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: invokevirtual 263	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_1
    //   56: aload_1
    //   57: invokeinterface 266 1 0
    //   62: istore_3
    //   63: aload_1
    //   64: invokeinterface 151 1 0
    //   69: aload_0
    //   70: monitorexit
    //   71: iload_3
    //   72: ireturn
    //   73: ldc_w 268
    //   76: astore 5
    //   78: goto -63 -> 15
    //   81: iconst_1
    //   82: anewarray 85	java/lang/String
    //   85: astore 6
    //   87: aload 6
    //   89: iconst_0
    //   90: aload_2
    //   91: aastore
    //   92: aload 6
    //   94: astore_2
    //   95: goto -66 -> 29
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: getstatic 22	arxx:TAG	Ljava/lang/String;
    //   107: ldc 163
    //   109: aload_1
    //   110: invokestatic 148	arwt:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: istore_3
    //   115: goto -46 -> 69
    //   118: astore_1
    //   119: getstatic 22	arxx:TAG	Ljava/lang/String;
    //   122: aload_1
    //   123: invokevirtual 271	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   126: aload_1
    //   127: invokestatic 273	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -63 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	arxx
    //   0	135	1	paramString1	String
    //   0	135	2	paramString2	String
    //   62	70	3	i	int
    //   19	3	4	bool	boolean
    //   13	64	5	str	String
    //   1	92	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   5	12	98	finally
    //   15	21	98	finally
    //   29	40	98	finally
    //   40	69	98	finally
    //   81	87	98	finally
    //   104	113	98	finally
    //   119	130	98	finally
    //   29	40	103	java/lang/Exception
    //   40	69	118	java/lang/Exception
  }
  
  public ArrayList<arxz> ai(String paramString)
  {
    try
    {
      paramString = c("newdata_report", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ArrayList<arxz> aj(String paramString)
  {
    try
    {
      paramString = c("olddata_report", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int fC(String paramString)
  {
    try
    {
      int i = 0 + ai("newdata_report", paramString);
      arwt.i(TAG, "new_table>>count=" + i);
      i += ai("olddata_report", paramString);
      arwt.i(TAG, "all_table>>>count=" + i);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean su(String paramString)
  {
    boolean bool = false;
    try
    {
      arwt.i("cgi_report_debug", "ReportDataModal deleteOldItems start");
      try
      {
        this.db = this.a.getWritableDatabase();
        paramString = "delete from olddata_report where appid=" + paramString + ";";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label75:
          arwt.d(TAG, "deleteOldItems>>>", paramString);
        }
      }
    }
    finally {}
    try
    {
      this.db.execSQL(paramString);
      this.db.close();
      arwt.i("cgi_report_debug", "ReportDataModal deleteOldItems success");
      bool = true;
    }
    catch (Exception paramString)
    {
      arwt.d(TAG, "deleteOldItems>>>", paramString);
      this.db.close();
      break label75;
    }
    return bool;
  }
  
  public boolean sv(String paramString)
  {
    boolean bool = false;
    try
    {
      arwt.i("cgi_report_debug", "ReportDataModal deleteNewItems start");
      try
      {
        this.db = this.a.getWritableDatabase();
        paramString = "delete from newdata_report where appid=" + paramString + ";";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label75:
          arwt.d(TAG, "deleteNewItems>>>", paramString);
        }
      }
    }
    finally {}
    try
    {
      this.db.execSQL(paramString);
      this.db.close();
      arwt.i("cgi_report_debug", "ReportDataModal deleteNewItems success");
      bool = true;
    }
    catch (Exception paramString)
    {
      arwt.d(TAG, "deleteNewItems>>>", paramString);
      this.db.close();
      break label75;
    }
    return bool;
  }
  
  public int w(ArrayList<arxz> paramArrayList)
  {
    int i;
    try
    {
      arwt.i("cgi_report_debug", "ReportDataModal backupOldItems count = " + paramArrayList.size());
      paramArrayList = new ArrayList(paramArrayList).iterator();
      i = 0;
      for (;;)
      {
        if (paramArrayList.hasNext())
        {
          arxz localarxz = (arxz)paramArrayList.next();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("apn", localarxz.cDf);
          localContentValues.put("frequency", localarxz.cDg);
          localContentValues.put("commandid", localarxz.cDh);
          localContentValues.put("resultcode", localarxz.cDi);
          localContentValues.put("tmcost", localarxz.cDj);
          localContentValues.put("reqsize", localarxz.cDk);
          localContentValues.put("rspsize", localarxz.cDl);
          localContentValues.put("touin", localarxz.mUin);
          localContentValues.put("deviceinfo", localarxz.mDeviceInfo);
          localContentValues.put("detail", localarxz.mDetail);
          localContentValues.put("appid", localarxz.mAppId);
          try
          {
            this.db = this.a.getWritableDatabase();
            this.db.insertOrThrow("olddata_report", null, localContentValues);
            this.db.close();
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              arwt.e(TAG, "update>>>", localException);
            }
          }
        }
      }
      arwt.i("cgi_report_debug", "ReportDataModal backupOldItems succ_count = " + i);
    }
    finally {}
    return i;
  }
  
  public class a
    extends SQLiteOpenHelper
  {
    public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
    {
      super(paramString, paramCursorFactory, paramInt);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        arwt.i("cgi_report_debug", "ReportDataModal onCreate sql1 = create table if not exists newdata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
        paramSQLiteDatabase.execSQL("create table if not exists newdata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
        arwt.i("cgi_report_debug", "ReportDataModal onCreate sql2 = create table if not exists olddata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
        paramSQLiteDatabase.execSQL("create table if not exists olddata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        arwt.e("cgi_report_debug", "ReportDataModal onCreate failed");
      }
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      try
      {
        paramSQLiteDatabase.execSQL("drop table if exists newdata_report");
        paramSQLiteDatabase.execSQL("drop table if exists olddata_report");
        onCreate(paramSQLiteDatabase);
        arwt.i("cgi_report_debug", "ReportDataModal onUpgrade success");
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        arwt.e("cgi_report_debug", "ReportDataModal onUpgrade failed");
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      arwt.i("cgi_report_debug", "ReportDataModal onUpgrade oldVersion=" + paramInt1 + "  newVersion=" + paramInt2 + "");
      if (paramInt1 != paramInt2) {}
      try
      {
        paramSQLiteDatabase.execSQL("drop table if exists newdata_report");
        paramSQLiteDatabase.execSQL("drop table if exists olddata_report");
        onCreate(paramSQLiteDatabase);
        arwt.i("cgi_report_debug", "ReportDataModal onUpgrade success");
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        arwt.e("cgi_report_debug", "ReportDataModal onUpgrade failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxx
 * JD-Core Version:    0.7.0.1
 */