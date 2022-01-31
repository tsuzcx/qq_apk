package com.tencent.open.appcommon.js;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;

public class DBHelper
  extends SQLiteOpenHelper
{
  protected static String a = "DBHelper";
  protected static String b = "sys_table";
  protected static String c = "table_name";
  protected static String d = "version";
  protected static String e = "select " + c + "," + d + " from " + b + " where " + c + "=?;";
  
  public DBHelper(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
  }
  
  /* Error */
  public java.util.List a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: new 63	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 64	java/util/ArrayList:<init>	()V
    //   19: astore 10
    //   21: aload_0
    //   22: invokevirtual 68	com/tencent/open/appcommon/js/DBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 7
    //   27: aload 6
    //   29: astore 5
    //   31: aload 7
    //   33: astore 6
    //   35: aload 9
    //   37: astore 8
    //   39: aload 7
    //   41: aload_1
    //   42: iconst_0
    //   43: anewarray 70	java/lang/String
    //   46: invokevirtual 76	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 9
    //   51: aload 9
    //   53: astore 5
    //   55: aload 7
    //   57: astore 6
    //   59: aload 9
    //   61: astore 8
    //   63: aload 9
    //   65: invokeinterface 82 1 0
    //   70: ifle +147 -> 217
    //   73: aload 9
    //   75: astore 5
    //   77: aload 7
    //   79: astore 6
    //   81: aload 9
    //   83: astore 8
    //   85: aload 9
    //   87: invokeinterface 86 1 0
    //   92: pop
    //   93: aload 9
    //   95: astore 5
    //   97: aload 7
    //   99: astore 6
    //   101: aload 9
    //   103: astore 8
    //   105: aload 9
    //   107: invokeinterface 89 1 0
    //   112: istore_3
    //   113: aload 9
    //   115: astore 5
    //   117: aload 7
    //   119: astore 6
    //   121: aload 9
    //   123: astore 8
    //   125: iload_3
    //   126: anewarray 70	java/lang/String
    //   129: astore 11
    //   131: iconst_0
    //   132: istore_2
    //   133: iload_2
    //   134: iload_3
    //   135: if_icmpge +34 -> 169
    //   138: aload 9
    //   140: astore 5
    //   142: aload 7
    //   144: astore 6
    //   146: aload 9
    //   148: astore 8
    //   150: aload 11
    //   152: iload_2
    //   153: aload 9
    //   155: iload_2
    //   156: invokeinterface 93 2 0
    //   161: aastore
    //   162: iload_2
    //   163: iconst_1
    //   164: iadd
    //   165: istore_2
    //   166: goto -33 -> 133
    //   169: aload 9
    //   171: astore 5
    //   173: aload 7
    //   175: astore 6
    //   177: aload 9
    //   179: astore 8
    //   181: aload 10
    //   183: aload 11
    //   185: invokeinterface 99 2 0
    //   190: pop
    //   191: aload 9
    //   193: astore 5
    //   195: aload 7
    //   197: astore 6
    //   199: aload 9
    //   201: astore 8
    //   203: aload 9
    //   205: invokeinterface 102 1 0
    //   210: istore 4
    //   212: iload 4
    //   214: ifne -101 -> 113
    //   217: aload 9
    //   219: ifnull +10 -> 229
    //   222: aload 9
    //   224: invokeinterface 105 1 0
    //   229: aload 7
    //   231: ifnull +8 -> 239
    //   234: aload 7
    //   236: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   239: aload 10
    //   241: areturn
    //   242: astore 9
    //   244: aconst_null
    //   245: astore 7
    //   247: aload 8
    //   249: astore 5
    //   251: aload 7
    //   253: astore 6
    //   255: getstatic 16	com/tencent/open/appcommon/js/DBHelper:a	Ljava/lang/String;
    //   258: new 30	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   265: ldc 108
    //   267: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_1
    //   271: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: aload 9
    //   279: invokestatic 113	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   282: aload 8
    //   284: ifnull +10 -> 294
    //   287: aload 8
    //   289: invokeinterface 105 1 0
    //   294: aload 7
    //   296: ifnull -57 -> 239
    //   299: aload 7
    //   301: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   304: aload 10
    //   306: areturn
    //   307: astore_1
    //   308: aconst_null
    //   309: astore 6
    //   311: aload 5
    //   313: ifnull +10 -> 323
    //   316: aload 5
    //   318: invokeinterface 105 1 0
    //   323: aload 6
    //   325: ifnull +8 -> 333
    //   328: aload 6
    //   330: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   333: aload_1
    //   334: athrow
    //   335: astore_1
    //   336: goto -25 -> 311
    //   339: astore 9
    //   341: goto -94 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	DBHelper
    //   0	344	1	paramString	String
    //   132	34	2	i	int
    //   112	24	3	j	int
    //   210	3	4	bool	boolean
    //   1	316	5	localObject1	Object
    //   4	325	6	localObject2	Object
    //   25	275	7	localSQLiteDatabase	SQLiteDatabase
    //   10	278	8	localCursor1	Cursor
    //   7	216	9	localCursor2	Cursor
    //   242	36	9	localException1	Exception
    //   339	1	9	localException2	Exception
    //   19	286	10	localArrayList	java.util.ArrayList
    //   129	55	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   21	27	242	java/lang/Exception
    //   21	27	307	finally
    //   39	51	335	finally
    //   63	73	335	finally
    //   85	93	335	finally
    //   105	113	335	finally
    //   125	131	335	finally
    //   150	162	335	finally
    //   181	191	335	finally
    //   203	212	335	finally
    //   255	282	335	finally
    //   39	51	339	java/lang/Exception
    //   63	73	339	java/lang/Exception
    //   85	93	339	java/lang/Exception
    //   105	113	339	java/lang/Exception
    //   125	131	339	java/lang/Exception
    //   150	162	339	java/lang/Exception
    //   181	191	339	java/lang/Exception
    //   203	212	339	java/lang/Exception
  }
  
  /* Error */
  public org.json.JSONObject a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 6
    //   7: aconst_null
    //   8: astore 5
    //   10: new 116	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 117	org/json/JSONObject:<init>	()V
    //   17: astore 7
    //   19: aload_0
    //   20: invokevirtual 68	com/tencent/open/appcommon/js/DBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore 4
    //   25: aload_3
    //   26: astore_2
    //   27: aload 4
    //   29: astore_3
    //   30: aload 6
    //   32: astore 5
    //   34: aload 4
    //   36: new 30	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   43: ldc 119
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 20	com/tencent/open/appcommon/js/DBHelper:b	Ljava/lang/String;
    //   51: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: iconst_0
    //   58: anewarray 70	java/lang/String
    //   61: invokevirtual 76	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore 6
    //   66: aload 6
    //   68: astore_2
    //   69: aload 4
    //   71: astore_3
    //   72: aload 6
    //   74: astore 5
    //   76: aload 6
    //   78: invokeinterface 82 1 0
    //   83: ifle +75 -> 158
    //   86: aload 6
    //   88: astore_2
    //   89: aload 4
    //   91: astore_3
    //   92: aload 6
    //   94: astore 5
    //   96: aload 6
    //   98: invokeinterface 86 1 0
    //   103: pop
    //   104: aload 6
    //   106: astore_2
    //   107: aload 4
    //   109: astore_3
    //   110: aload 6
    //   112: astore 5
    //   114: aload 7
    //   116: aload 6
    //   118: iconst_0
    //   119: invokeinterface 93 2 0
    //   124: aload 6
    //   126: iconst_1
    //   127: invokeinterface 123 2 0
    //   132: invokevirtual 127	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload 6
    //   138: astore_2
    //   139: aload 4
    //   141: astore_3
    //   142: aload 6
    //   144: astore 5
    //   146: aload 6
    //   148: invokeinterface 102 1 0
    //   153: istore_1
    //   154: iload_1
    //   155: ifne -51 -> 104
    //   158: aload 6
    //   160: ifnull +10 -> 170
    //   163: aload 6
    //   165: invokeinterface 105 1 0
    //   170: aload 4
    //   172: ifnull +8 -> 180
    //   175: aload 4
    //   177: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   180: aload 7
    //   182: areturn
    //   183: astore 6
    //   185: aconst_null
    //   186: astore 4
    //   188: aload 5
    //   190: astore_2
    //   191: aload 4
    //   193: astore_3
    //   194: getstatic 16	com/tencent/open/appcommon/js/DBHelper:a	Ljava/lang/String;
    //   197: ldc 129
    //   199: aload 6
    //   201: invokestatic 113	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   204: aload 5
    //   206: ifnull +10 -> 216
    //   209: aload 5
    //   211: invokeinterface 105 1 0
    //   216: aload 4
    //   218: ifnull -38 -> 180
    //   221: aload 4
    //   223: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   226: aload 7
    //   228: areturn
    //   229: astore 4
    //   231: aconst_null
    //   232: astore_3
    //   233: aload_2
    //   234: ifnull +9 -> 243
    //   237: aload_2
    //   238: invokeinterface 105 1 0
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   251: aload 4
    //   253: athrow
    //   254: astore 4
    //   256: goto -23 -> 233
    //   259: astore 6
    //   261: goto -73 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	DBHelper
    //   153	2	1	bool	boolean
    //   1	237	2	localObject1	Object
    //   3	245	3	localObject2	Object
    //   23	199	4	localSQLiteDatabase	SQLiteDatabase
    //   229	23	4	localObject3	Object
    //   254	1	4	localObject4	Object
    //   8	202	5	localCursor1	Cursor
    //   5	159	6	localCursor2	Cursor
    //   183	17	6	localException1	Exception
    //   259	1	6	localException2	Exception
    //   17	210	7	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   19	25	183	java/lang/Exception
    //   19	25	229	finally
    //   34	66	254	finally
    //   76	86	254	finally
    //   96	104	254	finally
    //   114	136	254	finally
    //   146	154	254	finally
    //   194	204	254	finally
    //   34	66	259	java/lang/Exception
    //   76	86	259	java/lang/Exception
    //   96	104	259	java/lang/Exception
    //   114	136	259	java/lang/Exception
    //   146	154	259	java/lang/Exception
  }
  
  protected boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    localObject = null;
    localSQLiteDatabase = null;
    bool3 = false;
    bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select count(*) as c from Sqlite_master where type ='table' and name ='" + paramString.trim() + "' ", null);
      boolean bool1 = bool2;
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      if (paramSQLiteDatabase.moveToNext())
      {
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        int i = paramSQLiteDatabase.getInt(0);
        bool1 = bool2;
        if (i > 0) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (paramSQLiteDatabase != null)
      {
        paramSQLiteDatabase.close();
        bool2 = bool1;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        localObject = localSQLiteDatabase;
        LogUtility.c(a, "tabbleIsExist", paramSQLiteDatabase);
        bool2 = bool3;
        if (localSQLiteDatabase != null)
        {
          localSQLiteDatabase.close();
          bool2 = bool3;
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label204;
      }
      ((Cursor)localObject).close();
    }
    LogUtility.c(a, "tabbleIsExist " + paramString + " " + bool2);
    return bool2;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    if (paramString.startsWith("drop")) {
      LogUtility.c(a, "ingroe drop");
    }
    for (;;)
    {
      return bool;
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.execSQL(paramString);
        if (localSQLiteDatabase != null) {
          localSQLiteDatabase.close();
        }
        LogUtility.c(a, "execSQL excepiton succ " + paramString);
        return true;
      }
      catch (Exception localException)
      {
        localObject2 = localObject1;
        LogUtility.c(a, "execSQL excepiton " + paramString, localException);
        bool = false;
        return false;
      }
      finally
      {
        if (localObject2 != null) {
          localObject2.close();
        }
      }
    }
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: invokevirtual 166	com/tencent/open/appcommon/js/DBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 7
    //   9: aload_0
    //   10: aload 7
    //   12: aload_1
    //   13: invokevirtual 177	com/tencent/open/appcommon/js/DBHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   16: istore 5
    //   18: iload 5
    //   20: ifeq +448 -> 468
    //   23: aload 7
    //   25: getstatic 53	com/tencent/open/appcommon/js/DBHelper:e	Ljava/lang/String;
    //   28: iconst_1
    //   29: anewarray 70	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: invokevirtual 76	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore 6
    //   41: getstatic 16	com/tencent/open/appcommon/js/DBHelper:a	Ljava/lang/String;
    //   44: new 30	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   51: ldc 179
    //   53: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 6
    //   58: invokeinterface 82 1 0
    //   63: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 153	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 6
    //   74: invokeinterface 82 1 0
    //   79: ifle +55 -> 134
    //   82: aload 6
    //   84: invokeinterface 86 1 0
    //   89: pop
    //   90: aload 6
    //   92: iconst_1
    //   93: invokeinterface 123 2 0
    //   98: iload_3
    //   99: if_icmpne +35 -> 134
    //   102: getstatic 16	com/tencent/open/appcommon/js/DBHelper:a	Ljava/lang/String;
    //   105: ldc 184
    //   107: invokestatic 186	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 6
    //   112: ifnull +10 -> 122
    //   115: aload 6
    //   117: invokeinterface 105 1 0
    //   122: aload 7
    //   124: ifnull +8 -> 132
    //   127: aload 7
    //   129: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: invokestatic 191	com/tencent/mobileqq/app/SQLiteDatabase:f	()V
    //   137: aload 7
    //   139: invokevirtual 194	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   142: iload 5
    //   144: ifeq +40 -> 184
    //   147: getstatic 16	com/tencent/open/appcommon/js/DBHelper:a	Ljava/lang/String;
    //   150: ldc 196
    //   152: invokestatic 153	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 7
    //   157: new 30	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   164: ldc 198
    //   166: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_1
    //   170: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 200
    //   175: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokevirtual 170	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   184: aload 7
    //   186: aload_2
    //   187: invokevirtual 170	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   190: aload 7
    //   192: new 30	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   199: ldc 202
    //   201: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: getstatic 20	com/tencent/open/appcommon/js/DBHelper:b	Ljava/lang/String;
    //   207: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc 204
    //   212: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: getstatic 24	com/tencent/open/appcommon/js/DBHelper:c	Ljava/lang/String;
    //   218: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc 41
    //   223: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: getstatic 28	com/tencent/open/appcommon/js/DBHelper:d	Ljava/lang/String;
    //   229: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 206
    //   234: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc 208
    //   239: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_1
    //   243: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc 210
    //   248: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: iload_3
    //   252: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc 212
    //   257: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokevirtual 170	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   266: aload 7
    //   268: invokevirtual 215	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   271: aload 6
    //   273: ifnull +10 -> 283
    //   276: aload 6
    //   278: invokeinterface 105 1 0
    //   283: aload 7
    //   285: ifnull +11 -> 296
    //   288: aload 7
    //   290: invokevirtual 218	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   293: invokestatic 221	com/tencent/mobileqq/app/SQLiteDatabase:g	()V
    //   296: aload 7
    //   298: ifnull +8 -> 306
    //   301: aload 7
    //   303: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   306: iconst_1
    //   307: ireturn
    //   308: astore_1
    //   309: aconst_null
    //   310: astore_2
    //   311: aconst_null
    //   312: astore 7
    //   314: iconst_0
    //   315: istore_3
    //   316: getstatic 16	com/tencent/open/appcommon/js/DBHelper:a	Ljava/lang/String;
    //   319: ldc 223
    //   321: aload_1
    //   322: invokestatic 113	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   325: aload_2
    //   326: ifnull +9 -> 335
    //   329: aload_2
    //   330: invokeinterface 105 1 0
    //   335: iload_3
    //   336: ifeq +16 -> 352
    //   339: aload 7
    //   341: ifnull +11 -> 352
    //   344: aload 7
    //   346: invokevirtual 218	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   349: invokestatic 221	com/tencent/mobileqq/app/SQLiteDatabase:g	()V
    //   352: aload 7
    //   354: ifnull -222 -> 132
    //   357: aload 7
    //   359: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   362: iconst_0
    //   363: ireturn
    //   364: astore_1
    //   365: aconst_null
    //   366: astore_2
    //   367: aconst_null
    //   368: astore 7
    //   370: iconst_0
    //   371: istore_3
    //   372: aload_2
    //   373: ifnull +9 -> 382
    //   376: aload_2
    //   377: invokeinterface 105 1 0
    //   382: iload_3
    //   383: ifeq +16 -> 399
    //   386: aload 7
    //   388: ifnull +11 -> 399
    //   391: aload 7
    //   393: invokevirtual 218	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   396: invokestatic 221	com/tencent/mobileqq/app/SQLiteDatabase:g	()V
    //   399: aload 7
    //   401: ifnull +8 -> 409
    //   404: aload 7
    //   406: invokevirtual 106	android/database/sqlite/SQLiteDatabase:close	()V
    //   409: aload_1
    //   410: athrow
    //   411: astore_1
    //   412: aconst_null
    //   413: astore_2
    //   414: iconst_0
    //   415: istore_3
    //   416: goto -44 -> 372
    //   419: astore_1
    //   420: aload 6
    //   422: astore_2
    //   423: iconst_0
    //   424: istore_3
    //   425: goto -53 -> 372
    //   428: astore_1
    //   429: iload 4
    //   431: istore_3
    //   432: aload 6
    //   434: astore_2
    //   435: goto -63 -> 372
    //   438: astore_1
    //   439: goto -67 -> 372
    //   442: astore_1
    //   443: aconst_null
    //   444: astore_2
    //   445: iconst_0
    //   446: istore_3
    //   447: goto -131 -> 316
    //   450: astore_1
    //   451: aload 6
    //   453: astore_2
    //   454: iconst_0
    //   455: istore_3
    //   456: goto -140 -> 316
    //   459: astore_1
    //   460: iconst_1
    //   461: istore_3
    //   462: aload 6
    //   464: astore_2
    //   465: goto -149 -> 316
    //   468: aconst_null
    //   469: astore 6
    //   471: goto -337 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	this	DBHelper
    //   0	474	1	paramString1	String
    //   0	474	2	paramString2	String
    //   0	474	3	paramInt	int
    //   1	429	4	i	int
    //   16	127	5	bool	boolean
    //   39	431	6	localCursor	Cursor
    //   7	398	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   3	9	308	java/lang/Exception
    //   3	9	364	finally
    //   9	18	411	finally
    //   23	41	411	finally
    //   41	110	419	finally
    //   134	142	428	finally
    //   147	184	428	finally
    //   184	271	428	finally
    //   316	325	438	finally
    //   9	18	442	java/lang/Exception
    //   23	41	442	java/lang/Exception
    //   41	110	450	java/lang/Exception
    //   134	142	459	java/lang/Exception
    //   147	184	459	java/lang/Exception
    //   184	271	459	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      LogUtility.c(a, "onCreate CREATE TABLE " + b + " (" + c + " VARCHAR(50) PRIMARY KEY," + d + " INTEGER);");
      paramSQLiteDatabase.execSQL("CREATE TABLE " + b + " (" + c + " VARCHAR(50) PRIMARY KEY," + d + " INTEGER);");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c(a, "onUpgrade " + paramInt1 + " | " + paramInt2);
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + b + ";");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DBHelper
 * JD-Core Version:    0.7.0.1
 */