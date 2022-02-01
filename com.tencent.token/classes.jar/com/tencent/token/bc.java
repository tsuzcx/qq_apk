package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.halley.common.b;
import com.tencent.halley.common.f;

public final class bc
  extends SQLiteOpenHelper
  implements bb
{
  private static String a = "";
  private static bc b;
  
  private bc(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, null, 7);
    try
    {
      paramContext.deleteDatabase("access.db");
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static bc a()
  {
    if (b == null)
    {
      a = f.b() + "-access.db";
      b = new bc(f.a(), a, null, 7);
    }
    return b;
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  private boolean a(String paramString, az.a parama, long paramLong)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        if (!localSQLiteDatabase.isDbLockedByOtherThreads())
        {
          boolean bool2 = localSQLiteDatabase.isDbLockedByCurrentThread();
          if (!bool2) {}
        }
        else
        {
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          continue;
        }
        ContentValues localContentValues;
        int i;
        bool1 = false;
      }
      catch (Exception paramString)
      {
        bool1 = false;
        return bool1;
        localContentValues = new ContentValues();
        localContentValues.put("iplist", parama.d());
        localContentValues.put("schedule_lasttime", Long.valueOf(parama.b()));
        localContentValues.put("apn_lasttime", Long.valueOf(paramLong));
        localContentValues.put("rule", parama.e());
        i = localSQLiteDatabase.update("access_tbl", localContentValues, "apn=? and domain=?", new String[] { paramString, parama.a() });
        if (i == 0)
        {
          localContentValues.put("apn", paramString);
          localContentValues.put("domain", parama.a());
          localContentValues.put("rule", parama.e());
          paramLong = localSQLiteDatabase.insert("access_tbl", null, localContentValues);
          b.b("DataAccessDBImpl", "insert record...ret:" + paramLong + ",apnName:" + paramString + ",domain:" + parama.a() + ",ip:" + parama.d());
          if (-1L != paramLong) {
            continue;
          }
        }
        else
        {
          b.b("DataAccessDBImpl", "update record...ret:" + i + ",apnName:" + paramString + ",domain:" + parama.a() + ",ip:" + parama.d());
        }
      }
      finally {}
    }
  }
  
  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      b.b("DataAccessDBImpl", "db created.");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      throw paramSQLiteDatabase;
    }
  }
  
  public final az a(String paramString)
  {
    label269:
    label291:
    for (;;)
    {
      try
      {
        Object localObject = getReadableDatabase();
        boolean bool;
        if (!((SQLiteDatabase)localObject).isDbLockedByOtherThreads())
        {
          bool = ((SQLiteDatabase)localObject).isDbLockedByCurrentThread();
          if (!bool) {}
        }
        else
        {
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          continue;
        }
        Cursor localCursor;
        String str1;
        String str2;
        String str3;
        long l;
        paramString = null;
      }
      catch (Exception paramString)
      {
        localObject = null;
        return localObject;
      }
      finally
      {
        try
        {
          localCursor = ((SQLiteDatabase)localObject).query("access_tbl", null, "apn=?", new String[] { paramString }, null, null, null);
          if (localCursor == null) {
            break label291;
          }
        }
        finally
        {
          localObject = null;
          if (localObject != null) {
            ((Cursor)localObject).close();
          }
        }
        try
        {
          if (!localCursor.moveToFirst()) {
            break label291;
          }
          paramString = new az(paramString);
          localObject = localCursor.getString(localCursor.getColumnIndex("domain"));
          str1 = localCursor.getString(localCursor.getColumnIndex("iplist"));
          str2 = localCursor.getString(localCursor.getColumnIndex("last_suc_ip"));
          str3 = localCursor.getString(localCursor.getColumnIndex("rule"));
          l = localCursor.getLong(localCursor.getColumnIndex("schedule_lasttime"));
          localCursor.getLong(localCursor.getColumnIndex("apn_lasttime"));
          paramString.a(new az.a((String)localObject, l, str1, str3, str2));
          bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
          localObject = paramString;
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
        }
        finally
        {
          localObject = localCursor;
          break label269;
        }
        paramString = finally;
      }
    }
  }
  
  /* Error */
  public final void a(az paramaz)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: aload_0
    //   9: monitorexit
    //   10: return
    //   11: aload_1
    //   12: invokevirtual 226	com/tencent/token/az:a	()Ljava/util/Map;
    //   15: astore 6
    //   17: invokestatic 231	java/lang/System:currentTimeMillis	()J
    //   20: lstore_3
    //   21: aload 6
    //   23: invokeinterface 237 1 0
    //   28: invokeinterface 243 1 0
    //   33: astore 6
    //   35: aload 6
    //   37: invokeinterface 248 1 0
    //   42: ifeq +38 -> 80
    //   45: aload 6
    //   47: invokeinterface 252 1 0
    //   52: checkcast 100	com/tencent/token/az$a
    //   55: astore 7
    //   57: aload_0
    //   58: aload_1
    //   59: invokevirtual 253	com/tencent/token/az:b	()Ljava/lang/String;
    //   62: aload 7
    //   64: lload_3
    //   65: invokespecial 255	com/tencent/token/bc:a	(Ljava/lang/String;Lcom/tencent/token/az$a;J)Z
    //   68: istore 5
    //   70: iload 5
    //   72: ifeq +280 -> 352
    //   75: iconst_1
    //   76: istore_2
    //   77: goto -42 -> 35
    //   80: iload_2
    //   81: ifeq -73 -> 8
    //   84: ldc 150
    //   86: ldc_w 257
    //   89: invokestatic 260	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_0
    //   93: invokevirtual 77	com/tencent/token/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   96: astore 7
    //   98: aload 7
    //   100: invokevirtual 81	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   103: ifne +15 -> 118
    //   106: aload 7
    //   108: invokevirtual 84	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   111: istore 5
    //   113: iload 5
    //   115: ifeq +24 -> 139
    //   118: ldc2_w 85
    //   121: invokestatic 92	java/lang/Thread:sleep	(J)V
    //   124: goto -26 -> 98
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 93	java/lang/InterruptedException:printStackTrace	()V
    //   132: goto -34 -> 98
    //   135: astore_1
    //   136: goto -128 -> 8
    //   139: aload 7
    //   141: ldc 130
    //   143: iconst_1
    //   144: anewarray 134	java/lang/String
    //   147: dup
    //   148: iconst_0
    //   149: ldc 142
    //   151: aastore
    //   152: aconst_null
    //   153: aconst_null
    //   154: ldc 142
    //   156: aconst_null
    //   157: ldc 123
    //   159: invokevirtual 188	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +181 -> 345
    //   167: aload_1
    //   168: invokeinterface 264 1 0
    //   173: invokestatic 269	com/tencent/token/bd:a	()Lcom/tencent/token/bd;
    //   176: getfield 272	com/tencent/token/bd:b	Lcom/tencent/token/bg;
    //   179: getfield 277	com/tencent/token/bg:c	I
    //   182: if_icmple +163 -> 345
    //   185: aload_1
    //   186: invokeinterface 193 1 0
    //   191: ifeq +154 -> 345
    //   194: aload_1
    //   195: aload_1
    //   196: ldc 142
    //   198: invokeinterface 200 2 0
    //   203: invokeinterface 204 2 0
    //   208: astore 6
    //   210: aload 6
    //   212: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +130 -> 345
    //   218: ldc 150
    //   220: new 39	java/lang/StringBuilder
    //   223: dup
    //   224: ldc_w 285
    //   227: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: aload 6
    //   232: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 260	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_1
    //   242: ifnull +9 -> 251
    //   245: aload_1
    //   246: invokeinterface 222 1 0
    //   251: aload 6
    //   253: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   256: ifne -248 -> 8
    //   259: aload 7
    //   261: ldc 130
    //   263: ldc 184
    //   265: iconst_1
    //   266: anewarray 134	java/lang/String
    //   269: dup
    //   270: iconst_0
    //   271: aload 6
    //   273: aastore
    //   274: invokevirtual 289	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   277: istore_2
    //   278: ldc 150
    //   280: new 39	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 291
    //   287: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload 6
    //   292: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 293
    //   298: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: iload_2
    //   302: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 260	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: goto -303 -> 8
    //   314: astore_1
    //   315: aload_0
    //   316: monitorexit
    //   317: aload_1
    //   318: athrow
    //   319: astore 6
    //   321: aconst_null
    //   322: astore_1
    //   323: aload_1
    //   324: ifnull +9 -> 333
    //   327: aload_1
    //   328: invokeinterface 222 1 0
    //   333: aload 6
    //   335: athrow
    //   336: astore_1
    //   337: goto -329 -> 8
    //   340: astore 6
    //   342: goto -19 -> 323
    //   345: ldc 14
    //   347: astore 6
    //   349: goto -108 -> 241
    //   352: goto -275 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	bc
    //   0	355	1	paramaz	az
    //   1	301	2	i	int
    //   20	45	3	l	long
    //   68	46	5	bool	boolean
    //   15	276	6	localObject1	Object
    //   319	15	6	localObject2	Object
    //   340	1	6	localObject3	Object
    //   347	1	6	str	String
    //   55	205	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   118	124	127	java/lang/InterruptedException
    //   84	98	135	java/lang/Exception
    //   98	113	135	java/lang/Exception
    //   118	124	135	java/lang/Exception
    //   128	132	135	java/lang/Exception
    //   245	251	135	java/lang/Exception
    //   251	311	135	java/lang/Exception
    //   327	333	135	java/lang/Exception
    //   333	336	135	java/lang/Exception
    //   11	35	314	finally
    //   35	70	314	finally
    //   84	98	314	finally
    //   98	113	314	finally
    //   118	124	314	finally
    //   128	132	314	finally
    //   245	251	314	finally
    //   251	311	314	finally
    //   327	333	314	finally
    //   333	336	314	finally
    //   139	163	319	finally
    //   11	35	336	java/lang/Exception
    //   35	70	336	java/lang/Exception
    //   167	241	340	finally
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      b.b("DataAccessDBImpl", "db created.");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
      b.a("DataAccessDBImpl", "db create failed.", paramSQLiteDatabase);
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
        b.b("DataAccessDBImpl", "db created.");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      break label6;
    }
  }
  
  /* Error */
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 304	android/database/sqlite/SQLiteOpenHelper:onOpen	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   5: aload_1
    //   6: invokevirtual 307	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +17 -> 28
    //   14: iload_2
    //   15: bipush 7
    //   17: if_icmpge +12 -> 29
    //   20: aload_1
    //   21: invokestatic 309	com/tencent/token/bc:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   24: aload_1
    //   25: invokestatic 311	com/tencent/token/bc:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   28: return
    //   29: iload_2
    //   30: bipush 7
    //   32: if_icmple -4 -> 28
    //   35: aload_1
    //   36: invokestatic 309	com/tencent/token/bc:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   39: aload_1
    //   40: invokestatic 311	com/tencent/token/bc:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   43: return
    //   44: astore_1
    //   45: return
    //   46: astore_1
    //   47: return
    //   48: astore_1
    //   49: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	bc
    //   0	50	1	paramSQLiteDatabase	SQLiteDatabase
    //   9	24	2	i	int
    // Exception table:
    //   from	to	target	type
    //   35	43	44	java/lang/Exception
    //   5	10	46	java/lang/Exception
    //   20	28	48	java/lang/Exception
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
        b.b("DataAccessDBImpl", "db created.");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bc
 * JD-Core Version:    0.7.0.1
 */