package com.tencent.open.pcpush;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;

public class PCPushDBHelper
  extends SQLiteOpenHelper
{
  protected static final int a = 2;
  public static final Uri a = Uri.parse("content://open.pcpush/pcpush_package_info");
  protected static final String a = "PCPushDBHelper";
  public static final Uri b = Uri.parse("content://open.pcpush/pcpush_package_info/");
  public static final String b = "open.pcpush";
  public static final Uri c = Uri.parse("content://open.pcpush/pcpush_package_info//#");
  protected static final String c = "pcdb";
  protected static final String d = "content://";
  protected static final String e = "/pcpush_package_info";
  protected static final String f = "/pcpush_package_info/";
  public static final String g = "vnd.android.cursor.dir/vnd.tencent.pcpush";
  public static final String h = "vnd.android.cursor.item/vnd.tencent.pcpush";
  public static final String i = "pcpush_package_info";
  public static final String j = "_id";
  public static final String k = "key";
  public static final String l = "appid";
  public static final String m = "via";
  public static final String n = "pkgname";
  public static final String o = "versioncode";
  public static final String p = "appname";
  public static final String q = "appurl";
  public static final String r = "iconurl";
  public static final String s = "appsize";
  public static final String t = "filetype";
  public static final String u = "source";
  public static final String v = "srciconurl";
  public static final String w = "timestamp";
  public static final String x = "downloadtype";
  public static final String y = "installstate";
  
  public PCPushDBHelper()
  {
    super(CommonDataAdapter.a().a(), "pcdb", null, 2);
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS pcpush_package_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public void a(PCPushProxy.PkgEntry paramPkgEntry)
  {
    LogUtility.b("PCPushDBHelper", "addPkgEntry>>>insert entry = " + paramPkgEntry.toString());
    localSQLiteDatabase = getWritableDatabase();
    try
    {
      localSQLiteDatabase.beginTransaction();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("key", paramPkgEntry.jdField_a_of_type_JavaLangString);
      localContentValues.put("appid", paramPkgEntry.jdField_b_of_type_JavaLangString);
      localContentValues.put("appname", paramPkgEntry.e);
      localContentValues.put("appsize", paramPkgEntry.h);
      localContentValues.put("appurl", paramPkgEntry.f);
      localContentValues.put("downloadtype", Integer.valueOf(paramPkgEntry.jdField_d_of_type_Int));
      localContentValues.put("filetype", Integer.valueOf(paramPkgEntry.jdField_b_of_type_Int));
      localContentValues.put("iconurl", paramPkgEntry.g);
      localContentValues.put("pkgname", paramPkgEntry.jdField_d_of_type_JavaLangString);
      localContentValues.put("source", paramPkgEntry.i);
      localContentValues.put("srciconurl", paramPkgEntry.j);
      localContentValues.put("versioncode", Integer.valueOf(paramPkgEntry.jdField_a_of_type_Int));
      localContentValues.put("via", paramPkgEntry.jdField_c_of_type_JavaLangString);
      localContentValues.put("key", paramPkgEntry.jdField_a_of_type_JavaLangString);
      localContentValues.put("installstate", Integer.valueOf(paramPkgEntry.jdField_c_of_type_Int));
      localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
      int i1 = localSQLiteDatabase.update("pcpush_package_info", localContentValues, "key = ?", new String[] { paramPkgEntry.jdField_a_of_type_JavaLangString });
      LogUtility.a("PCPushDBHelper", "addPkgEntry>>>update affected rowNum=" + i1);
      if (i1 == 0)
      {
        long l1 = localSQLiteDatabase.insert("pcpush_package_info", "pkgname", localContentValues);
        LogUtility.a("PCPushDBHelper", "addPkgEntry>>>insert rowID = " + l1);
      }
      localSQLiteDatabase.setTransactionSuccessful();
    }
    catch (Exception paramPkgEntry)
    {
      for (;;)
      {
        LogUtility.c("PCPushDBHelper", "addPkgEntry error", paramPkgEntry);
        localSQLiteDatabase.endTransaction();
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    localSQLiteDatabase.close();
  }
  
  public void a(String paramString)
  {
    LogUtility.a("PCPushDBHelper", "--> delete key = " + paramString);
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localSQLiteDatabase.delete("pcpush_package_info", "key = ?", new String[] { paramString });
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("PCPushDBHelper", "deletePkgEntry error", paramString);
    }
  }
  
  /* Error */
  public void a(java.util.concurrent.ConcurrentHashMap paramConcurrentHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 270	com/tencent/open/pcpush/PCPushDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore 5
    //   6: aload 5
    //   8: ldc 35
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 274	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnull +405 -> 428
    //   26: aload 4
    //   28: astore_3
    //   29: aload 4
    //   31: invokeinterface 280 1 0
    //   36: ifle +392 -> 428
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokeinterface 284 1 0
    //   49: pop
    //   50: aload 4
    //   52: astore_3
    //   53: new 172	com/tencent/open/pcpush/PCPushProxy$PkgEntry
    //   56: dup
    //   57: invokespecial 285	com/tencent/open/pcpush/PCPushProxy$PkgEntry:<init>	()V
    //   60: astore 6
    //   62: aload 4
    //   64: astore_3
    //   65: aload 6
    //   67: aload 4
    //   69: aload 4
    //   71: ldc 44
    //   73: invokeinterface 289 2 0
    //   78: invokeinterface 293 2 0
    //   83: putfield 179	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload 4
    //   88: astore_3
    //   89: aload 6
    //   91: aload 4
    //   93: aload 4
    //   95: ldc 56
    //   97: invokeinterface 289 2 0
    //   102: invokeinterface 293 2 0
    //   107: putfield 181	com/tencent/open/pcpush/PCPushProxy$PkgEntry:e	Ljava/lang/String;
    //   110: aload 4
    //   112: astore_3
    //   113: aload 6
    //   115: aload 4
    //   117: aload 4
    //   119: ldc 65
    //   121: invokeinterface 289 2 0
    //   126: invokeinterface 293 2 0
    //   131: putfield 183	com/tencent/open/pcpush/PCPushProxy$PkgEntry:h	Ljava/lang/String;
    //   134: aload 4
    //   136: astore_3
    //   137: aload 6
    //   139: aload 4
    //   141: aload 4
    //   143: ldc 59
    //   145: invokeinterface 289 2 0
    //   150: invokeinterface 293 2 0
    //   155: putfield 185	com/tencent/open/pcpush/PCPushProxy$PkgEntry:f	Ljava/lang/String;
    //   158: aload 4
    //   160: astore_3
    //   161: aload 6
    //   163: aload 4
    //   165: aload 4
    //   167: ldc 68
    //   169: invokeinterface 289 2 0
    //   174: invokeinterface 297 2 0
    //   179: putfield 198	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_b_of_type_Int	I
    //   182: aload 4
    //   184: astore_3
    //   185: aload 6
    //   187: aload 4
    //   189: aload 4
    //   191: ldc 62
    //   193: invokeinterface 289 2 0
    //   198: invokeinterface 293 2 0
    //   203: putfield 200	com/tencent/open/pcpush/PCPushProxy$PkgEntry:g	Ljava/lang/String;
    //   206: aload 4
    //   208: astore_3
    //   209: aload 6
    //   211: aload 4
    //   213: aload 4
    //   215: ldc 50
    //   217: invokeinterface 289 2 0
    //   222: invokeinterface 293 2 0
    //   227: putfield 202	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   230: aload 4
    //   232: astore_3
    //   233: aload 6
    //   235: aload 4
    //   237: aload 4
    //   239: ldc 71
    //   241: invokeinterface 289 2 0
    //   246: invokeinterface 293 2 0
    //   251: putfield 204	com/tencent/open/pcpush/PCPushProxy$PkgEntry:i	Ljava/lang/String;
    //   254: aload 4
    //   256: astore_3
    //   257: aload 6
    //   259: aload 4
    //   261: aload 4
    //   263: ldc 74
    //   265: invokeinterface 289 2 0
    //   270: invokeinterface 293 2 0
    //   275: putfield 206	com/tencent/open/pcpush/PCPushProxy$PkgEntry:j	Ljava/lang/String;
    //   278: aload 4
    //   280: astore_3
    //   281: aload 6
    //   283: aload 4
    //   285: aload 4
    //   287: ldc 53
    //   289: invokeinterface 289 2 0
    //   294: invokeinterface 297 2 0
    //   299: putfield 208	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_Int	I
    //   302: aload 4
    //   304: astore_3
    //   305: aload 6
    //   307: aload 4
    //   309: aload 4
    //   311: ldc 47
    //   313: invokeinterface 289 2 0
    //   318: invokeinterface 293 2 0
    //   323: putfield 210	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   326: aload 4
    //   328: astore_3
    //   329: aload 6
    //   331: aload 4
    //   333: aload 4
    //   335: ldc 80
    //   337: invokeinterface 289 2 0
    //   342: invokeinterface 297 2 0
    //   347: putfield 187	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_d_of_type_Int	I
    //   350: aload 4
    //   352: astore_3
    //   353: aload 6
    //   355: aload 4
    //   357: aload 4
    //   359: ldc 41
    //   361: invokeinterface 289 2 0
    //   366: invokeinterface 293 2 0
    //   371: putfield 174	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   374: aload 4
    //   376: astore_3
    //   377: aload 6
    //   379: aload 4
    //   381: aload 4
    //   383: ldc 83
    //   385: invokeinterface 289 2 0
    //   390: invokeinterface 297 2 0
    //   395: putfield 212	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_c_of_type_Int	I
    //   398: aload 4
    //   400: astore_3
    //   401: aload_1
    //   402: aload 6
    //   404: getfield 174	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   407: aload 6
    //   409: invokevirtual 302	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   412: pop
    //   413: aload 4
    //   415: astore_3
    //   416: aload 4
    //   418: invokeinterface 305 1 0
    //   423: istore_2
    //   424: iload_2
    //   425: ifne -375 -> 50
    //   428: aload 4
    //   430: ifnull +10 -> 440
    //   433: aload 4
    //   435: invokeinterface 306 1 0
    //   440: aload 5
    //   442: invokevirtual 253	android/database/sqlite/SQLiteDatabase:close	()V
    //   445: return
    //   446: astore_1
    //   447: aconst_null
    //   448: astore 4
    //   450: aload 4
    //   452: astore_3
    //   453: ldc 11
    //   455: ldc_w 308
    //   458: aload_1
    //   459: invokestatic 258	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   462: aload 4
    //   464: ifnull -24 -> 440
    //   467: aload 4
    //   469: invokeinterface 306 1 0
    //   474: goto -34 -> 440
    //   477: astore_1
    //   478: aconst_null
    //   479: astore_3
    //   480: aload_3
    //   481: ifnull +9 -> 490
    //   484: aload_3
    //   485: invokeinterface 306 1 0
    //   490: aload_1
    //   491: athrow
    //   492: astore_1
    //   493: goto -13 -> 480
    //   496: astore_1
    //   497: goto -47 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	PCPushDBHelper
    //   0	500	1	paramConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   423	2	2	bool	boolean
    //   28	457	3	localCursor1	android.database.Cursor
    //   19	449	4	localCursor2	android.database.Cursor
    //   4	437	5	localSQLiteDatabase	SQLiteDatabase
    //   60	348	6	localPkgEntry	PCPushProxy.PkgEntry
    // Exception table:
    //   from	to	target	type
    //   6	21	446	java/lang/Exception
    //   6	21	477	finally
    //   29	39	492	finally
    //   42	50	492	finally
    //   53	62	492	finally
    //   65	86	492	finally
    //   89	110	492	finally
    //   113	134	492	finally
    //   137	158	492	finally
    //   161	182	492	finally
    //   185	206	492	finally
    //   209	230	492	finally
    //   233	254	492	finally
    //   257	278	492	finally
    //   281	302	492	finally
    //   305	326	492	finally
    //   329	350	492	finally
    //   353	374	492	finally
    //   377	398	492	finally
    //   401	413	492	finally
    //   416	424	492	finally
    //   453	462	492	finally
    //   29	39	496	java/lang/Exception
    //   42	50	496	java/lang/Exception
    //   53	62	496	java/lang/Exception
    //   65	86	496	java/lang/Exception
    //   89	110	496	java/lang/Exception
    //   113	134	496	java/lang/Exception
    //   137	158	496	java/lang/Exception
    //   161	182	496	java/lang/Exception
    //   185	206	496	java/lang/Exception
    //   209	230	496	java/lang/Exception
    //   233	254	496	java/lang/Exception
    //   257	278	496	java/lang/Exception
    //   281	302	496	java/lang/Exception
    //   305	326	496	java/lang/Exception
    //   329	350	496	java/lang/Exception
    //   353	374	496	java/lang/Exception
    //   377	398	496	java/lang/Exception
    //   401	413	496	java/lang/Exception
    //   416	424	496	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    LogUtility.a("PCPushDBHelper", "--> start--DatabaseHelper onCreate<<<<");
    paramSQLiteDatabase.execSQL("CREATE TABLE pcpush_package_info (key TEXT PRIMARY KEY,appid TEXT,via TEXT,pkgname TEXT,versioncode INTEGER,appname TEXT,appurl TEXT,iconurl TEXT,appsize TEXT,filetype TEXT,source TEXT,srciconurl TEXT,timestamp INTEGER,installstate INTEGER,downloadtype INTEGER);");
    LogUtility.a("PCPushDBHelper", "--> end--DatabaseHelper onCreate<<<<");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c("PCPushDBHelper", "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c("PCPushDBHelper", "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.pcpush.PCPushDBHelper
 * JD-Core Version:    0.7.0.1
 */