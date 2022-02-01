import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class asbd
  extends SQLiteOpenHelper
{
  public static final Uri CONTENT_URI = Uri.parse("content://open.pcpush/pcpush_package_info");
  public static final Uri P = Uri.parse("content://open.pcpush/pcpush_package_info/");
  public static final Uri Q = Uri.parse("content://open.pcpush/pcpush_package_info//#");
  
  public asbd()
  {
    super(aroi.a().getContext(), "pcdb", null, 2);
  }
  
  public void Xy(String paramString)
  {
    arwt.v("PCPushDBHelper", "--> delete key = " + paramString);
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localSQLiteDatabase.delete("pcpush_package_info", "key = ?", new String[] { paramString });
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception paramString)
    {
      arwt.e("PCPushDBHelper", "deletePkgEntry error", paramString);
    }
  }
  
  public void a(asbe.b paramb)
  {
    arwt.i("PCPushDBHelper", "addPkgEntry>>>insert entry = " + paramb.toString());
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      ContentValues localContentValues = new ContentValues();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("key", paramb.key);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appid", paramb.appid);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appname", paramb.appName);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appsize", paramb.cEa);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appurl", paramb.appUrl);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("downloadtype", Integer.valueOf(paramb.downloadType));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("filetype", Integer.valueOf(paramb.fileType));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("iconurl", paramb.iconUrl);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("pkgname", paramb.pkgName);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("source", paramb.source);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("srciconurl", paramb.cEb);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("versioncode", Integer.valueOf(paramb.versionCode));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("via", paramb.via);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("key", paramb.key);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("installstate", Integer.valueOf(paramb.elw));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      int i = localSQLiteDatabase.update("pcpush_package_info", localContentValues, "key = ?", new String[] { paramb.key });
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      arwt.v("PCPushDBHelper", "addPkgEntry>>>update affected rowNum=" + i);
      if (i == 0)
      {
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        long l = localSQLiteDatabase.insert("pcpush_package_info", "pkgname", localContentValues);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        arwt.v("PCPushDBHelper", "addPkgEntry>>>insert rowID = " + l);
      }
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception paramb)
    {
      localObject2 = localObject1;
      arwt.e("PCPushDBHelper", "addPkgEntry error", paramb);
      return;
    }
    finally
    {
      if (localObject2 != null)
      {
        localObject2.endTransaction();
        localObject2.close();
      }
    }
  }
  
  protected void b(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
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
  
  /* Error */
  public void h(java.util.concurrent.ConcurrentHashMap<String, asbe.b> paramConcurrentHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_0
    //   12: invokevirtual 251	asbd:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 5
    //   17: aload 7
    //   19: astore_3
    //   20: aload 6
    //   22: astore 4
    //   24: aload 5
    //   26: ldc 77
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 255	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +481 -> 522
    //   44: aload 6
    //   46: astore_3
    //   47: aload 6
    //   49: astore 4
    //   51: aload 6
    //   53: invokeinterface 261 1 0
    //   58: ifle +464 -> 522
    //   61: aload 6
    //   63: astore_3
    //   64: aload 6
    //   66: astore 4
    //   68: aload 6
    //   70: invokeinterface 265 1 0
    //   75: pop
    //   76: aload 6
    //   78: astore_3
    //   79: aload 6
    //   81: astore 4
    //   83: new 115	asbe$b
    //   86: dup
    //   87: invokespecial 266	asbe$b:<init>	()V
    //   90: astore 7
    //   92: aload 6
    //   94: astore_3
    //   95: aload 6
    //   97: astore 4
    //   99: aload 7
    //   101: aload 6
    //   103: aload 6
    //   105: ldc 123
    //   107: invokeinterface 270 2 0
    //   112: invokeinterface 274 2 0
    //   117: putfield 125	asbe$b:appid	Ljava/lang/String;
    //   120: aload 6
    //   122: astore_3
    //   123: aload 6
    //   125: astore 4
    //   127: aload 7
    //   129: aload 6
    //   131: aload 6
    //   133: ldc 127
    //   135: invokeinterface 270 2 0
    //   140: invokeinterface 274 2 0
    //   145: putfield 130	asbe$b:appName	Ljava/lang/String;
    //   148: aload 6
    //   150: astore_3
    //   151: aload 6
    //   153: astore 4
    //   155: aload 7
    //   157: aload 6
    //   159: aload 6
    //   161: ldc 132
    //   163: invokeinterface 270 2 0
    //   168: invokeinterface 274 2 0
    //   173: putfield 135	asbe$b:cEa	Ljava/lang/String;
    //   176: aload 6
    //   178: astore_3
    //   179: aload 6
    //   181: astore 4
    //   183: aload 7
    //   185: aload 6
    //   187: aload 6
    //   189: ldc 137
    //   191: invokeinterface 270 2 0
    //   196: invokeinterface 274 2 0
    //   201: putfield 140	asbe$b:appUrl	Ljava/lang/String;
    //   204: aload 6
    //   206: astore_3
    //   207: aload 6
    //   209: astore 4
    //   211: aload 7
    //   213: aload 6
    //   215: aload 6
    //   217: ldc 157
    //   219: invokeinterface 270 2 0
    //   224: invokeinterface 278 2 0
    //   229: putfield 160	asbe$b:fileType	I
    //   232: aload 6
    //   234: astore_3
    //   235: aload 6
    //   237: astore 4
    //   239: aload 7
    //   241: aload 6
    //   243: aload 6
    //   245: ldc 162
    //   247: invokeinterface 270 2 0
    //   252: invokeinterface 274 2 0
    //   257: putfield 165	asbe$b:iconUrl	Ljava/lang/String;
    //   260: aload 6
    //   262: astore_3
    //   263: aload 6
    //   265: astore 4
    //   267: aload 7
    //   269: aload 6
    //   271: aload 6
    //   273: ldc 167
    //   275: invokeinterface 270 2 0
    //   280: invokeinterface 274 2 0
    //   285: putfield 170	asbe$b:pkgName	Ljava/lang/String;
    //   288: aload 6
    //   290: astore_3
    //   291: aload 6
    //   293: astore 4
    //   295: aload 7
    //   297: aload 6
    //   299: aload 6
    //   301: ldc 172
    //   303: invokeinterface 270 2 0
    //   308: invokeinterface 274 2 0
    //   313: putfield 174	asbe$b:source	Ljava/lang/String;
    //   316: aload 6
    //   318: astore_3
    //   319: aload 6
    //   321: astore 4
    //   323: aload 7
    //   325: aload 6
    //   327: aload 6
    //   329: ldc 176
    //   331: invokeinterface 270 2 0
    //   336: invokeinterface 274 2 0
    //   341: putfield 179	asbe$b:cEb	Ljava/lang/String;
    //   344: aload 6
    //   346: astore_3
    //   347: aload 6
    //   349: astore 4
    //   351: aload 7
    //   353: aload 6
    //   355: aload 6
    //   357: ldc 181
    //   359: invokeinterface 270 2 0
    //   364: invokeinterface 278 2 0
    //   369: putfield 184	asbe$b:versionCode	I
    //   372: aload 6
    //   374: astore_3
    //   375: aload 6
    //   377: astore 4
    //   379: aload 7
    //   381: aload 6
    //   383: aload 6
    //   385: ldc 186
    //   387: invokeinterface 270 2 0
    //   392: invokeinterface 274 2 0
    //   397: putfield 188	asbe$b:via	Ljava/lang/String;
    //   400: aload 6
    //   402: astore_3
    //   403: aload 6
    //   405: astore 4
    //   407: aload 7
    //   409: aload 6
    //   411: aload 6
    //   413: ldc 142
    //   415: invokeinterface 270 2 0
    //   420: invokeinterface 278 2 0
    //   425: putfield 146	asbe$b:downloadType	I
    //   428: aload 6
    //   430: astore_3
    //   431: aload 6
    //   433: astore 4
    //   435: aload 7
    //   437: aload 6
    //   439: aload 6
    //   441: ldc 113
    //   443: invokeinterface 270 2 0
    //   448: invokeinterface 274 2 0
    //   453: putfield 118	asbe$b:key	Ljava/lang/String;
    //   456: aload 6
    //   458: astore_3
    //   459: aload 6
    //   461: astore 4
    //   463: aload 7
    //   465: aload 6
    //   467: aload 6
    //   469: ldc 190
    //   471: invokeinterface 270 2 0
    //   476: invokeinterface 278 2 0
    //   481: putfield 193	asbe$b:elw	I
    //   484: aload 6
    //   486: astore_3
    //   487: aload 6
    //   489: astore 4
    //   491: aload_1
    //   492: aload 7
    //   494: getfield 118	asbe$b:key	Ljava/lang/String;
    //   497: aload 7
    //   499: invokevirtual 283	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   502: pop
    //   503: aload 6
    //   505: astore_3
    //   506: aload 6
    //   508: astore 4
    //   510: aload 6
    //   512: invokeinterface 286 1 0
    //   517: istore_2
    //   518: iload_2
    //   519: ifne -443 -> 76
    //   522: aload 6
    //   524: ifnull +10 -> 534
    //   527: aload 6
    //   529: invokeinterface 287 1 0
    //   534: aload 5
    //   536: ifnull +8 -> 544
    //   539: aload 5
    //   541: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   544: return
    //   545: astore_3
    //   546: aconst_null
    //   547: astore_1
    //   548: ldc 51
    //   550: ldc_w 289
    //   553: aload_3
    //   554: invokestatic 96	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   557: aload 4
    //   559: ifnull +10 -> 569
    //   562: aload 4
    //   564: invokeinterface 287 1 0
    //   569: aload_1
    //   570: ifnull -26 -> 544
    //   573: aload_1
    //   574: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   577: return
    //   578: astore 5
    //   580: aconst_null
    //   581: astore_1
    //   582: aload_3
    //   583: ifnull +9 -> 592
    //   586: aload_3
    //   587: invokeinterface 287 1 0
    //   592: aload_1
    //   593: ifnull +7 -> 600
    //   596: aload_1
    //   597: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   600: aload 5
    //   602: athrow
    //   603: astore 4
    //   605: aload 5
    //   607: astore_1
    //   608: aload 4
    //   610: astore 5
    //   612: goto -30 -> 582
    //   615: astore 5
    //   617: aload 4
    //   619: astore_3
    //   620: goto -38 -> 582
    //   623: astore_3
    //   624: aload 5
    //   626: astore_1
    //   627: goto -79 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	this	asbd
    //   0	630	1	paramConcurrentHashMap	java.util.concurrent.ConcurrentHashMap<String, asbe.b>
    //   517	2	2	bool	boolean
    //   1	505	3	localObject1	Object
    //   545	42	3	localException1	Exception
    //   619	1	3	localObject2	Object
    //   623	1	3	localException2	Exception
    //   9	554	4	localCursor1	android.database.Cursor
    //   603	15	4	localObject3	Object
    //   15	525	5	localSQLiteDatabase	SQLiteDatabase
    //   578	28	5	localObject4	Object
    //   610	1	5	localObject5	Object
    //   615	10	5	localObject6	Object
    //   6	522	6	localCursor2	android.database.Cursor
    //   3	495	7	localb	asbe.b
    // Exception table:
    //   from	to	target	type
    //   11	17	545	java/lang/Exception
    //   11	17	578	finally
    //   24	39	603	finally
    //   51	61	603	finally
    //   68	76	603	finally
    //   83	92	603	finally
    //   99	120	603	finally
    //   127	148	603	finally
    //   155	176	603	finally
    //   183	204	603	finally
    //   211	232	603	finally
    //   239	260	603	finally
    //   267	288	603	finally
    //   295	316	603	finally
    //   323	344	603	finally
    //   351	372	603	finally
    //   379	400	603	finally
    //   407	428	603	finally
    //   435	456	603	finally
    //   463	484	603	finally
    //   491	503	603	finally
    //   510	518	603	finally
    //   548	557	615	finally
    //   24	39	623	java/lang/Exception
    //   51	61	623	java/lang/Exception
    //   68	76	623	java/lang/Exception
    //   83	92	623	java/lang/Exception
    //   99	120	623	java/lang/Exception
    //   127	148	623	java/lang/Exception
    //   155	176	623	java/lang/Exception
    //   183	204	623	java/lang/Exception
    //   211	232	623	java/lang/Exception
    //   239	260	623	java/lang/Exception
    //   267	288	623	java/lang/Exception
    //   295	316	623	java/lang/Exception
    //   323	344	623	java/lang/Exception
    //   351	372	623	java/lang/Exception
    //   379	400	623	java/lang/Exception
    //   407	428	623	java/lang/Exception
    //   435	456	623	java/lang/Exception
    //   463	484	623	java/lang/Exception
    //   491	503	623	java/lang/Exception
    //   510	518	623	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    arwt.v("PCPushDBHelper", "--> start--DatabaseHelper onCreate<<<<");
    paramSQLiteDatabase.execSQL("CREATE TABLE pcpush_package_info (key TEXT PRIMARY KEY,appid TEXT,via TEXT,pkgname TEXT,versioncode INTEGER,appname TEXT,appurl TEXT,iconurl TEXT,appsize TEXT,filetype TEXT,source TEXT,srciconurl TEXT,timestamp INTEGER,installstate INTEGER,downloadtype INTEGER);");
    arwt.v("PCPushDBHelper", "--> end--DatabaseHelper onCreate<<<<");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    arwt.d("PCPushDBHelper", "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    b(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    arwt.d("PCPushDBHelper", "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    b(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbd
 * JD-Core Version:    0.7.0.1
 */