import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Arrays;
import java.util.List;

public class arvt
  extends SQLiteOpenHelper
{
  private static volatile arvt a;
  private static final String[] it = { "ticket", "open_appid", "download_url", "package_name", "push_title", "send_time", "uin", "trigger_time", "via", "patch_url", "update_type", "appid", "apkid", "version", "download_type", "filepath", "source", "last_download_size", "is_apk", "yyb_download_from", "icon_url", "is_show_notification", "apk_write_code_state", "extra_info", "is_autoInstall_by_sdk", "download_file_md5", "download_file_size", "download_state", "download_progress", "total_length", "recommend_id", "source_from_server", "channel_id", "page_id", "module_id", "position_id", "process_flag_id", "unique_id", "ext_param_id" };
  private final Object cW = new Object();
  private long mUin;
  
  private arvt(Context paramContext)
  {
    super(paramContext, "open_appstore_db_DownloadInfoDB.db", null, 5);
  }
  
  private static int a(Cursor paramCursor, String paramString)
  {
    if ((paramCursor == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    return paramCursor.getColumnIndex(paramString);
  }
  
  public static arvt a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a = new arvt(aroi.a().getContext());
        a.elP();
      }
      return a;
    }
    finally {}
  }
  
  private DownloadInfo a(Cursor paramCursor)
  {
    boolean bool2 = true;
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.ticket = paramCursor.getString(a(paramCursor, "ticket"));
    localDownloadInfo.appId = paramCursor.getString(a(paramCursor, "open_appid"));
    localDownloadInfo.urlStr = paramCursor.getString(a(paramCursor, "download_url"));
    localDownloadInfo.packageName = paramCursor.getString(a(paramCursor, "package_name"));
    localDownloadInfo.pushTitle = paramCursor.getString(a(paramCursor, "push_title"));
    localDownloadInfo.sendTime = paramCursor.getString(a(paramCursor, "send_time"));
    localDownloadInfo.time = paramCursor.getLong(a(paramCursor, "trigger_time"));
    localDownloadInfo.via = paramCursor.getString(a(paramCursor, "via"));
    localDownloadInfo.cDF = paramCursor.getString(a(paramCursor, "patch_url"));
    localDownloadInfo.updateType = paramCursor.getInt(a(paramCursor, "update_type"));
    localDownloadInfo.cDG = paramCursor.getString(a(paramCursor, "appid"));
    localDownloadInfo.cCL = paramCursor.getString(a(paramCursor, "apkid"));
    localDownloadInfo.versionCode = paramCursor.getInt(a(paramCursor, "version"));
    localDownloadInfo.downloadType = paramCursor.getInt(a(paramCursor, "download_type"));
    localDownloadInfo.filePath = paramCursor.getString(a(paramCursor, "filepath"));
    localDownloadInfo.source = paramCursor.getString(a(paramCursor, "source"));
    localDownloadInfo.awM = paramCursor.getLong(a(paramCursor, "last_download_size"));
    if (paramCursor.getInt(a(paramCursor, "is_apk")) == 1)
    {
      bool1 = true;
      localDownloadInfo.ddw = bool1;
      localDownloadInfo.from = paramCursor.getInt(a(paramCursor, "yyb_download_from"));
      localDownloadInfo.iconUrl = paramCursor.getString(a(paramCursor, "icon_url"));
      localDownloadInfo.ell = paramCursor.getInt(a(paramCursor, "is_show_notification"));
      localDownloadInfo.elm = paramCursor.getInt(a(paramCursor, "apk_write_code_state"));
      if (localDownloadInfo.elm == 1) {
        localDownloadInfo.elm = 0;
      }
      localDownloadInfo.extraData = paramCursor.getString(a(paramCursor, "extra_info"));
      if (paramCursor.getInt(a(paramCursor, "is_autoInstall_by_sdk")) != 1) {
        break label694;
      }
    }
    label694:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localDownloadInfo.isAutoInstallBySDK = bool1;
      localDownloadInfo.fileMd5 = paramCursor.getString(a(paramCursor, "download_file_md5"));
      localDownloadInfo.fileSize = paramCursor.getLong(a(paramCursor, "download_file_size"));
      localDownloadInfo.setState(paramCursor.getInt(a(paramCursor, "download_state")));
      localDownloadInfo.progress = paramCursor.getInt(a(paramCursor, "download_progress"));
      localDownloadInfo.awN = paramCursor.getLong(a(paramCursor, "total_length"));
      localDownloadInfo.recommendId = paramCursor.getString(a(paramCursor, "recommend_id"));
      localDownloadInfo.cCM = paramCursor.getString(a(paramCursor, "source_from_server"));
      localDownloadInfo.channelId = paramCursor.getString(a(paramCursor, "channel_id"));
      localDownloadInfo.pageId = paramCursor.getString(a(paramCursor, "page_id"));
      localDownloadInfo.kx = paramCursor.getString(a(paramCursor, "module_id"));
      localDownloadInfo.cDH = paramCursor.getString(a(paramCursor, "position_id"));
      localDownloadInfo.cDI = paramCursor.getString(a(paramCursor, "process_flag_id"));
      localDownloadInfo.uniqueId = paramCursor.getString(a(paramCursor, "unique_id"));
      localDownloadInfo.cDJ = paramCursor.getString(a(paramCursor, "ext_param_id"));
      return localDownloadInfo;
      bool1 = false;
      break;
    }
  }
  
  /* Error */
  private DownloadInfo a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 110	arvt:cW	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_0
    //   19: invokevirtual 280	arvt:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: aload_3
    //   24: ldc_w 282
    //   27: getstatic 96	arvt:it	[Ljava/lang/String;
    //   30: aload_1
    //   31: aload_2
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 288	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_2
    //   39: aload 6
    //   41: astore_1
    //   42: aload_2
    //   43: invokeinterface 292 1 0
    //   48: ifle +16 -> 64
    //   51: aload_2
    //   52: invokeinterface 296 1 0
    //   57: pop
    //   58: aload_0
    //   59: aload_2
    //   60: invokespecial 298	arvt:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +9 -> 74
    //   68: aload_2
    //   69: invokeinterface 301 1 0
    //   74: aload_1
    //   75: astore_2
    //   76: aload_3
    //   77: ifnull +9 -> 86
    //   80: aload_3
    //   81: invokevirtual 302	android/database/sqlite/SQLiteDatabase:close	()V
    //   84: aload_1
    //   85: astore_2
    //   86: aload 7
    //   88: monitorexit
    //   89: aload_2
    //   90: areturn
    //   91: astore_3
    //   92: aconst_null
    //   93: astore_2
    //   94: aconst_null
    //   95: astore_1
    //   96: ldc_w 304
    //   99: ldc_w 306
    //   102: aload_3
    //   103: invokestatic 312	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_2
    //   107: ifnull +9 -> 116
    //   110: aload_2
    //   111: invokeinterface 301 1 0
    //   116: aload 4
    //   118: astore_2
    //   119: aload_1
    //   120: ifnull -34 -> 86
    //   123: aload_1
    //   124: invokevirtual 302	android/database/sqlite/SQLiteDatabase:close	()V
    //   127: aload 4
    //   129: astore_2
    //   130: goto -44 -> 86
    //   133: astore_1
    //   134: aload 7
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: aload 5
    //   144: astore_3
    //   145: aload_3
    //   146: ifnull +9 -> 155
    //   149: aload_3
    //   150: invokeinterface 301 1 0
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 302	android/database/sqlite/SQLiteDatabase:close	()V
    //   163: aload_2
    //   164: athrow
    //   165: astore_2
    //   166: aload_3
    //   167: astore_1
    //   168: aload 5
    //   170: astore_3
    //   171: goto -26 -> 145
    //   174: astore 5
    //   176: aload_2
    //   177: astore 4
    //   179: aload_3
    //   180: astore_1
    //   181: aload 5
    //   183: astore_2
    //   184: aload 4
    //   186: astore_3
    //   187: goto -42 -> 145
    //   190: astore 4
    //   192: aload_2
    //   193: astore_3
    //   194: aload 4
    //   196: astore_2
    //   197: goto -52 -> 145
    //   200: astore_2
    //   201: aload_3
    //   202: astore_1
    //   203: aload_2
    //   204: astore_3
    //   205: aconst_null
    //   206: astore_2
    //   207: goto -111 -> 96
    //   210: astore 5
    //   212: aload_3
    //   213: astore_1
    //   214: aload 5
    //   216: astore_3
    //   217: goto -121 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	arvt
    //   0	220	1	paramString	String
    //   0	220	2	paramArrayOfString	String[]
    //   22	59	3	localSQLiteDatabase	SQLiteDatabase
    //   91	12	3	localException1	Exception
    //   144	73	3	localObject1	Object
    //   1	184	4	arrayOfString	String[]
    //   190	5	4	localObject2	Object
    //   4	165	5	localObject3	Object
    //   174	8	5	localObject4	Object
    //   210	5	5	localException2	Exception
    //   7	33	6	localObject5	Object
    //   13	122	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   18	23	91	java/lang/Exception
    //   68	74	133	finally
    //   80	84	133	finally
    //   86	89	133	finally
    //   110	116	133	finally
    //   123	127	133	finally
    //   134	137	133	finally
    //   149	155	133	finally
    //   159	163	133	finally
    //   163	165	133	finally
    //   18	23	139	finally
    //   23	39	165	finally
    //   42	64	174	finally
    //   96	106	190	finally
    //   23	39	200	java/lang/Exception
    //   42	64	210	java/lang/Exception
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  /* Error */
  private List<DownloadInfo> b(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 336	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 337	java/util/ArrayList:<init>	()V
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 110	arvt:cW	Ljava/lang/Object;
    //   19: astore 7
    //   21: aload 7
    //   23: monitorenter
    //   24: aload_0
    //   25: invokevirtual 280	arvt:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: astore 4
    //   30: aload 4
    //   32: ldc_w 282
    //   35: getstatic 96	arvt:it	[Ljava/lang/String;
    //   38: aload_1
    //   39: aload_2
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 288	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: invokeinterface 292 1 0
    //   53: ifle +34 -> 87
    //   56: aload_1
    //   57: invokeinterface 296 1 0
    //   62: pop
    //   63: aload 8
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 298	arvt:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   70: invokeinterface 343 2 0
    //   75: pop
    //   76: aload_1
    //   77: invokeinterface 346 1 0
    //   82: istore_3
    //   83: iload_3
    //   84: ifne -21 -> 63
    //   87: aload_1
    //   88: ifnull +9 -> 97
    //   91: aload_1
    //   92: invokeinterface 301 1 0
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 302	android/database/sqlite/SQLiteDatabase:close	()V
    //   107: aload 7
    //   109: monitorexit
    //   110: ldc_w 304
    //   113: new 348	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 351
    //   123: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 8
    //   128: invokeinterface 358 1 0
    //   133: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 365	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 369	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload 8
    //   144: areturn
    //   145: astore 4
    //   147: aconst_null
    //   148: astore_2
    //   149: aload 5
    //   151: astore_1
    //   152: ldc_w 304
    //   155: ldc_w 371
    //   158: aload 4
    //   160: invokestatic 312	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_2
    //   164: ifnull +9 -> 173
    //   167: aload_2
    //   168: invokeinterface 301 1 0
    //   173: aload_1
    //   174: ifnull -67 -> 107
    //   177: aload_1
    //   178: invokevirtual 302	android/database/sqlite/SQLiteDatabase:close	()V
    //   181: goto -74 -> 107
    //   184: astore_1
    //   185: aload 7
    //   187: monitorexit
    //   188: aload_1
    //   189: athrow
    //   190: astore_2
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 6
    //   196: astore_1
    //   197: aload 4
    //   199: ifnull +10 -> 209
    //   202: aload 4
    //   204: invokeinterface 301 1 0
    //   209: aload_1
    //   210: ifnull +7 -> 217
    //   213: aload_1
    //   214: invokevirtual 302	android/database/sqlite/SQLiteDatabase:close	()V
    //   217: aload_2
    //   218: athrow
    //   219: astore_2
    //   220: aconst_null
    //   221: astore 5
    //   223: aload 4
    //   225: astore_1
    //   226: aload 5
    //   228: astore 4
    //   230: goto -33 -> 197
    //   233: astore_2
    //   234: aload 4
    //   236: astore 5
    //   238: aload_1
    //   239: astore 4
    //   241: aload 5
    //   243: astore_1
    //   244: goto -47 -> 197
    //   247: astore 5
    //   249: aload_2
    //   250: astore 4
    //   252: aload 5
    //   254: astore_2
    //   255: goto -58 -> 197
    //   258: astore 5
    //   260: aconst_null
    //   261: astore_2
    //   262: aload 4
    //   264: astore_1
    //   265: aload 5
    //   267: astore 4
    //   269: goto -117 -> 152
    //   272: astore_2
    //   273: aload 4
    //   275: astore 5
    //   277: aload_2
    //   278: astore 4
    //   280: aload_1
    //   281: astore_2
    //   282: aload 5
    //   284: astore_1
    //   285: goto -133 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	arvt
    //   0	288	1	paramString	String
    //   0	288	2	paramArrayOfString	String[]
    //   82	2	3	bool	boolean
    //   28	75	4	localSQLiteDatabase	SQLiteDatabase
    //   145	14	4	localException1	Exception
    //   192	87	4	localObject1	Object
    //   4	238	5	localObject2	Object
    //   247	6	5	localObject3	Object
    //   258	8	5	localException2	Exception
    //   275	8	5	localObject4	Object
    //   1	194	6	localObject5	Object
    //   19	167	7	localObject6	Object
    //   13	130	8	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   24	30	145	java/lang/Exception
    //   91	97	184	finally
    //   102	107	184	finally
    //   107	110	184	finally
    //   167	173	184	finally
    //   177	181	184	finally
    //   185	188	184	finally
    //   202	209	184	finally
    //   213	217	184	finally
    //   217	219	184	finally
    //   24	30	190	finally
    //   30	47	219	finally
    //   47	63	233	finally
    //   63	83	233	finally
    //   152	163	247	finally
    //   30	47	258	java/lang/Exception
    //   47	63	272	java/lang/Exception
    //   63	83	272	java/lang/Exception
  }
  
  private void elP()
  {
    if (this.mUin == 0L)
    {
      this.mUin = aroi.a().getUin();
      if (this.mUin == 0L) {
        this.mUin = aroi.a().hZ();
      }
    }
  }
  
  private String getUin()
  {
    if (this.mUin == 0L)
    {
      this.mUin = aroi.a().getUin();
      if (this.mUin == 0L) {
        arwt.e("DownloadInfoDB", "getUin() is empty!");
      }
    }
    return String.valueOf(this.mUin);
  }
  
  /* Error */
  public java.util.concurrent.ConcurrentHashMap<String, DownloadInfo> D()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: ldc_w 304
    //   8: ldc_w 394
    //   11: invokestatic 397	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 399	java/util/concurrent/ConcurrentHashMap
    //   17: dup
    //   18: invokespecial 400	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   21: astore 7
    //   23: aload_0
    //   24: getfield 110	arvt:cW	Ljava/lang/Object;
    //   27: astore 6
    //   29: aload 6
    //   31: monitorenter
    //   32: aload_0
    //   33: invokevirtual 280	arvt:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore_2
    //   37: aload_2
    //   38: ldc_w 282
    //   41: getstatic 96	arvt:it	[Ljava/lang/String;
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 288	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore 4
    //   54: aload 4
    //   56: invokeinterface 292 1 0
    //   61: ifle +111 -> 172
    //   64: aload 4
    //   66: invokeinterface 296 1 0
    //   71: pop
    //   72: aload 4
    //   74: aload 4
    //   76: ldc 18
    //   78: invokestatic 146	arvt:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   81: invokeinterface 150 2 0
    //   86: astore_3
    //   87: ldc_w 304
    //   90: new 348	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 402
    //   100: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_3
    //   104: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 365	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 397	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: aload 4
    //   116: invokespecial 298	arvt:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   119: astore 5
    //   121: ldc_w 304
    //   124: new 348	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 404
    //   134: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 5
    //   139: invokevirtual 405	com/tencent/open/downloadnew/DownloadInfo:toString	()Ljava/lang/String;
    //   142: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 365	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 397	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload 7
    //   153: aload_3
    //   154: aload 5
    //   156: invokevirtual 409	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: aload 4
    //   162: invokeinterface 346 1 0
    //   167: istore_1
    //   168: iload_1
    //   169: ifne -97 -> 72
    //   172: aload 4
    //   174: ifnull +10 -> 184
    //   177: aload 4
    //   179: invokeinterface 301 1 0
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 302	android/database/sqlite/SQLiteDatabase:close	()V
    //   192: aload 6
    //   194: monitorexit
    //   195: aload 7
    //   197: areturn
    //   198: astore 4
    //   200: aconst_null
    //   201: astore 5
    //   203: aload_3
    //   204: astore_2
    //   205: aload 5
    //   207: astore_3
    //   208: ldc_w 304
    //   211: ldc_w 411
    //   214: aload 4
    //   216: invokestatic 312	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_3
    //   220: ifnull +9 -> 229
    //   223: aload_3
    //   224: invokeinterface 301 1 0
    //   229: aload_2
    //   230: ifnull -38 -> 192
    //   233: aload_2
    //   234: invokevirtual 302	android/database/sqlite/SQLiteDatabase:close	()V
    //   237: goto -45 -> 192
    //   240: astore_2
    //   241: aload 6
    //   243: monitorexit
    //   244: aload_2
    //   245: athrow
    //   246: astore_3
    //   247: aconst_null
    //   248: astore 5
    //   250: aload 4
    //   252: astore_2
    //   253: aload 5
    //   255: astore 4
    //   257: aload 4
    //   259: ifnull +10 -> 269
    //   262: aload 4
    //   264: invokeinterface 301 1 0
    //   269: aload_2
    //   270: ifnull +7 -> 277
    //   273: aload_2
    //   274: invokevirtual 302	android/database/sqlite/SQLiteDatabase:close	()V
    //   277: aload_3
    //   278: athrow
    //   279: astore_3
    //   280: aconst_null
    //   281: astore 4
    //   283: goto -26 -> 257
    //   286: astore_3
    //   287: goto -30 -> 257
    //   290: astore 5
    //   292: aload_3
    //   293: astore 4
    //   295: aload 5
    //   297: astore_3
    //   298: goto -41 -> 257
    //   301: astore 4
    //   303: aconst_null
    //   304: astore_3
    //   305: goto -97 -> 208
    //   308: astore_3
    //   309: aload 4
    //   311: astore 5
    //   313: aload_3
    //   314: astore 4
    //   316: aload 5
    //   318: astore_3
    //   319: goto -111 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	arvt
    //   167	2	1	bool	boolean
    //   36	198	2	localObject1	Object
    //   240	5	2	localObject2	Object
    //   252	22	2	localException1	Exception
    //   4	220	3	localObject3	Object
    //   246	32	3	localObject4	Object
    //   279	1	3	localObject5	Object
    //   286	7	3	localObject6	Object
    //   297	8	3	localObject7	Object
    //   308	6	3	localException2	Exception
    //   318	1	3	localObject8	Object
    //   1	177	4	localCursor	Cursor
    //   198	53	4	localException3	Exception
    //   255	39	4	localObject9	Object
    //   301	9	4	localException4	Exception
    //   314	1	4	localObject10	Object
    //   119	135	5	localDownloadInfo	DownloadInfo
    //   290	6	5	localObject11	Object
    //   311	6	5	localException5	Exception
    //   27	215	6	localObject12	Object
    //   21	175	7	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   32	37	198	java/lang/Exception
    //   177	184	240	finally
    //   188	192	240	finally
    //   192	195	240	finally
    //   223	229	240	finally
    //   233	237	240	finally
    //   241	244	240	finally
    //   262	269	240	finally
    //   273	277	240	finally
    //   277	279	240	finally
    //   32	37	246	finally
    //   37	54	279	finally
    //   54	72	286	finally
    //   72	168	286	finally
    //   208	219	290	finally
    //   37	54	301	java/lang/Exception
    //   54	72	308	java/lang/Exception
    //   72	168	308	java/lang/Exception
  }
  
  public void Xn(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      arwt.e("DownloadInfoDB", "[deleteInfoByTicket] ticket is empty");
      return;
    }
    Object localObject3 = this.cW;
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        arwt.d("DownloadInfoDB", "[deleteInfoByTicket]ticket = ?" + Arrays.toString(new String[] { paramString }));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.delete("download_info", "ticket = ?", new String[] { paramString });
        if (localSQLiteDatabase == null) {}
      }
      catch (Exception paramString)
      {
        SQLiteDatabase localSQLiteDatabase;
        localObject2 = localObject1;
        arwt.e("DownloadInfoDB", "[deleteInfoByTicket]>>>", paramString);
        if (localObject1 == null) {
          continue;
        }
        localObject1.close();
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        localObject2.close();
      }
      try
      {
        localSQLiteDatabase.close();
        return;
      }
      finally {}
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 1;
    Object localObject3 = this.cW;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("ticket", paramDownloadInfo.ticket);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("open_appid", paramDownloadInfo.appId);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("download_url", paramDownloadInfo.urlStr);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("package_name", paramDownloadInfo.packageName);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("push_title", paramDownloadInfo.pushTitle);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("send_time", paramDownloadInfo.sendTime);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("uin", getUin());
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("trigger_time", Long.valueOf(paramDownloadInfo.time));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("via", paramDownloadInfo.via);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("patch_url", paramDownloadInfo.cDF);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("update_type", Integer.valueOf(paramDownloadInfo.updateType));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("appid", paramDownloadInfo.cDG);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("apkid", paramDownloadInfo.cCL);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("version", Integer.valueOf(paramDownloadInfo.versionCode));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("download_type", Integer.valueOf(paramDownloadInfo.downloadType));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("filepath", paramDownloadInfo.filePath);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("source", paramDownloadInfo.source);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("last_download_size", Long.valueOf(paramDownloadInfo.awM));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (paramDownloadInfo.ddw)
        {
          i = 1;
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("is_apk", Integer.valueOf(i));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("yyb_download_from", Integer.valueOf(paramDownloadInfo.from));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("icon_url", paramDownloadInfo.iconUrl);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("is_show_notification", Integer.valueOf(paramDownloadInfo.ell));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (paramDownloadInfo.elm != 0) {
            continue;
          }
          i = 1;
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("apk_write_code_state", Integer.valueOf(i));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("extra_info", paramDownloadInfo.extraData);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (!paramDownloadInfo.isAutoInstallBySDK) {
            continue;
          }
          i = j;
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("is_autoInstall_by_sdk", Integer.valueOf(i));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("download_file_md5", paramDownloadInfo.fileMd5);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("download_file_size", Long.valueOf(paramDownloadInfo.fileSize));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("download_state", Integer.valueOf(paramDownloadInfo.getState()));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("download_progress", Integer.valueOf(paramDownloadInfo.progress));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("total_length", Long.valueOf(paramDownloadInfo.awN));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("recommend_id", paramDownloadInfo.recommendId);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("source_from_server", paramDownloadInfo.cCM);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("channel_id", paramDownloadInfo.channelId);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("page_id", paramDownloadInfo.pageId);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("module_id", paramDownloadInfo.kx);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("position_id", paramDownloadInfo.cDH);
          if (paramBoolean)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            localContentValues.put("process_flag_id", paramDownloadInfo.cDI);
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("unique_id", paramDownloadInfo.uniqueId);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("ext_param_id", paramDownloadInfo.cDJ);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          i = localSQLiteDatabase.update("download_info", localContentValues, "ticket = ?", new String[] { paramDownloadInfo.ticket });
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          arwt.v("DownloadInfoDB", "addDownloadInfo>>>update affected rowNum=" + i);
          if (i == 0)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            localContentValues.put("process_flag_id", paramDownloadInfo.cDI);
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            long l = localSQLiteDatabase.insert("download_info", null, localContentValues);
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            arwt.v("DownloadInfoDB", "addDownloadInfo>>>insert rowID = " + l);
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localSQLiteDatabase.setTransactionSuccessful();
        }
      }
      catch (Exception paramDownloadInfo)
      {
        SQLiteDatabase localSQLiteDatabase;
        int i;
        localObject2 = localObject1;
        arwt.e("DownloadInfoDB", "addDownloadExceptionInfo>>>", paramDownloadInfo);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          localObject1.endTransaction();
          localObject1.close();
        }
        catch (Exception paramDownloadInfo)
        {
          arwt.e("DownloadInfoDB", "addDownloadExceptionInfo>>>", paramDownloadInfo);
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          break label1171;
        }
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        localSQLiteDatabase.close();
        return;
        i = 0;
        continue;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        i = paramDownloadInfo.elm;
        continue;
        i = 0;
      }
      catch (Exception paramDownloadInfo)
      {
        arwt.e("DownloadInfoDB", "addDownloadExceptionInfo>>>", paramDownloadInfo);
      }
      finally {}
    }
    try
    {
      localObject2.endTransaction();
      localObject2.close();
      label1171:
      throw paramDownloadInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arwt.e("DownloadInfoDB", "addDownloadExceptionInfo>>>", localException);
      }
    }
  }
  
  public List<DownloadInfo> bi(String paramString)
  {
    return b("package_name = ?", new String[] { paramString });
  }
  
  public DownloadInfo d(String paramString)
  {
    return a("ticket = ?", new String[] { paramString });
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE download_info (ticket TEXT PRIMARY KEY,open_appid TEXT,download_url TEXT,package_name TEXT,push_title TEXT,send_time TEXT,uin TEXT,trigger_time INTEGER,via TEXT,patch_url TEXT,update_type INTEGER,appid TEXT,apkid TEXT,version INTEGER,download_type INTEGER,filepath TEXT,source TEXT,last_download_size INTEGER,is_apk INTEGER,yyb_download_from INTEGER,icon_url TEXT,is_show_notification INTEGER,apk_write_code_state INTEGER,extra_info TEXT,is_autoInstall_by_sdk INTEGER,download_file_md5 TEXT,download_file_size INTEGER,download_state INTEGER,download_progress INTEGER,total_length INTEGER,recommend_id TEXT,source_from_server TEXT,channel_id TEXT,page_id TEXT,module_id TEXT,position_id TEXT,process_flag_id TEXT,unique_id TEXT,ext_param_id TEXT); ");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    arwt.i("DownloadInfoDB", "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    arwt.i("DownloadInfoDB", "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvt
 * JD-Core Version:    0.7.0.1
 */