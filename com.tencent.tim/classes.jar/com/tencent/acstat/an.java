package com.tencent.acstat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.acstat.common.StatLogger;

class an
  extends SQLiteOpenHelper
{
  private String a = "";
  private Context b = null;
  
  public an(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 3);
    this.a = paramString;
    this.b = paramContext.getApplicationContext();
    if (StatConfig.isDebugEnable()) {
      af.e().i("SQLiteOpenHelper " + this.a);
    }
  }
  
  /* Error */
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ldc 65
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: new 73	android/content/ContentValues
    //   21: dup
    //   22: invokespecial 76	android/content/ContentValues:<init>	()V
    //   25: astore 5
    //   27: aload_3
    //   28: astore_2
    //   29: aload_3
    //   30: invokeinterface 81 1 0
    //   35: ifeq +58 -> 93
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: iconst_0
    //   42: invokeinterface 85 2 0
    //   47: astore 4
    //   49: aload_3
    //   50: astore_2
    //   51: aload_3
    //   52: iconst_1
    //   53: invokeinterface 89 2 0
    //   58: pop
    //   59: aload_3
    //   60: astore_2
    //   61: aload_3
    //   62: iconst_2
    //   63: invokeinterface 85 2 0
    //   68: pop
    //   69: aload_3
    //   70: astore_2
    //   71: aload_3
    //   72: iconst_3
    //   73: invokeinterface 93 2 0
    //   78: pop2
    //   79: aload_3
    //   80: astore_2
    //   81: aload 5
    //   83: ldc 95
    //   85: aload 4
    //   87: invokestatic 101	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 105	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 4
    //   95: ifnull +25 -> 120
    //   98: aload_3
    //   99: astore_2
    //   100: aload_1
    //   101: ldc 65
    //   103: aload 5
    //   105: ldc 107
    //   107: iconst_1
    //   108: anewarray 109	java/lang/String
    //   111: dup
    //   112: iconst_0
    //   113: aload 4
    //   115: aastore
    //   116: invokevirtual 113	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   119: pop
    //   120: aload_3
    //   121: ifnull +9 -> 130
    //   124: aload_3
    //   125: invokeinterface 116 1 0
    //   130: return
    //   131: astore_1
    //   132: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   135: aload_1
    //   136: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   139: return
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_3
    //   143: aload_3
    //   144: astore_2
    //   145: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   148: aload_1
    //   149: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   152: aload_3
    //   153: ifnull -23 -> 130
    //   156: aload_3
    //   157: invokeinterface 116 1 0
    //   162: return
    //   163: astore_1
    //   164: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   167: aload_1
    //   168: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   171: return
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_2
    //   176: ifnull +9 -> 185
    //   179: aload_2
    //   180: invokeinterface 116 1 0
    //   185: aload_1
    //   186: athrow
    //   187: astore_2
    //   188: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   191: aload_2
    //   192: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   195: goto -10 -> 185
    //   198: astore_1
    //   199: goto -24 -> 175
    //   202: astore_1
    //   203: goto -60 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	an
    //   0	206	1	paramSQLiteDatabase	SQLiteDatabase
    //   17	163	2	localCursor1	android.database.Cursor
    //   187	5	2	localThrowable	java.lang.Throwable
    //   15	142	3	localCursor2	android.database.Cursor
    //   1	113	4	str	String
    //   25	79	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   124	130	131	java/lang/Throwable
    //   3	16	140	java/lang/Throwable
    //   156	162	163	java/lang/Throwable
    //   3	16	172	finally
    //   179	185	187	java/lang/Throwable
    //   18	27	198	finally
    //   29	38	198	finally
    //   40	49	198	finally
    //   51	59	198	finally
    //   61	69	198	finally
    //   71	79	198	finally
    //   81	93	198	finally
    //   100	120	198	finally
    //   145	152	198	finally
    //   18	27	202	java/lang/Throwable
    //   29	38	202	java/lang/Throwable
    //   40	49	202	java/lang/Throwable
    //   51	59	202	java/lang/Throwable
    //   61	69	202	java/lang/Throwable
    //   71	79	202	java/lang/Throwable
    //   81	93	202	java/lang/Throwable
    //   100	120	202	java/lang/Throwable
  }
  
  /* Error */
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 121
    //   3: aconst_null
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore_2
    //   13: new 123	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 124	java/util/ArrayList:<init>	()V
    //   20: astore 4
    //   22: aload_2
    //   23: invokeinterface 81 1 0
    //   28: ifeq +72 -> 100
    //   31: aload 4
    //   33: new 126	com/tencent/acstat/ao
    //   36: dup
    //   37: aload_2
    //   38: iconst_0
    //   39: invokeinterface 93 2 0
    //   44: aload_2
    //   45: iconst_1
    //   46: invokeinterface 85 2 0
    //   51: aload_2
    //   52: iconst_2
    //   53: invokeinterface 89 2 0
    //   58: aload_2
    //   59: iconst_3
    //   60: invokeinterface 89 2 0
    //   65: invokespecial 129	com/tencent/acstat/ao:<init>	(JLjava/lang/String;II)V
    //   68: invokeinterface 135 2 0
    //   73: pop
    //   74: goto -52 -> 22
    //   77: astore_3
    //   78: aload_2
    //   79: astore_1
    //   80: aload_3
    //   81: astore_2
    //   82: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   85: aload_2
    //   86: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   89: aload_1
    //   90: ifnull +9 -> 99
    //   93: aload_1
    //   94: invokeinterface 116 1 0
    //   99: return
    //   100: new 73	android/content/ContentValues
    //   103: dup
    //   104: invokespecial 76	android/content/ContentValues:<init>	()V
    //   107: astore_3
    //   108: aload 4
    //   110: invokeinterface 139 1 0
    //   115: astore 4
    //   117: aload 4
    //   119: invokeinterface 144 1 0
    //   124: ifeq +70 -> 194
    //   127: aload 4
    //   129: invokeinterface 148 1 0
    //   134: checkcast 126	com/tencent/acstat/ao
    //   137: astore 5
    //   139: aload_3
    //   140: ldc 150
    //   142: aload 5
    //   144: getfield 152	com/tencent/acstat/ao:b	Ljava/lang/String;
    //   147: invokestatic 101	com/tencent/acstat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   150: invokevirtual 105	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_1
    //   154: ldc 121
    //   156: aload_3
    //   157: ldc 154
    //   159: iconst_1
    //   160: anewarray 109	java/lang/String
    //   163: dup
    //   164: iconst_0
    //   165: aload 5
    //   167: getfield 157	com/tencent/acstat/ao:a	J
    //   170: invokestatic 162	java/lang/Long:toString	(J)Ljava/lang/String;
    //   173: aastore
    //   174: invokevirtual 113	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   177: pop
    //   178: goto -61 -> 117
    //   181: astore_1
    //   182: aload_2
    //   183: ifnull +9 -> 192
    //   186: aload_2
    //   187: invokeinterface 116 1 0
    //   192: aload_1
    //   193: athrow
    //   194: aload_2
    //   195: ifnull -96 -> 99
    //   198: aload_2
    //   199: invokeinterface 116 1 0
    //   204: return
    //   205: astore_1
    //   206: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   209: aload_1
    //   210: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   213: return
    //   214: astore_1
    //   215: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   218: aload_1
    //   219: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   222: return
    //   223: astore_2
    //   224: invokestatic 37	com/tencent/acstat/af:e	()Lcom/tencent/acstat/common/StatLogger;
    //   227: aload_2
    //   228: invokevirtual 119	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   231: goto -39 -> 192
    //   234: astore_1
    //   235: aconst_null
    //   236: astore_2
    //   237: goto -55 -> 182
    //   240: astore_3
    //   241: aload_1
    //   242: astore_2
    //   243: aload_3
    //   244: astore_1
    //   245: goto -63 -> 182
    //   248: astore_2
    //   249: aconst_null
    //   250: astore_1
    //   251: goto -169 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	an
    //   0	254	1	paramSQLiteDatabase	SQLiteDatabase
    //   12	187	2	localObject1	Object
    //   223	5	2	localThrowable1	java.lang.Throwable
    //   236	7	2	localSQLiteDatabase	SQLiteDatabase
    //   248	1	2	localThrowable2	java.lang.Throwable
    //   77	4	3	localThrowable3	java.lang.Throwable
    //   107	50	3	localContentValues	android.content.ContentValues
    //   240	4	3	localObject2	Object
    //   20	108	4	localObject3	Object
    //   137	29	5	localao	ao
    // Exception table:
    //   from	to	target	type
    //   13	22	77	java/lang/Throwable
    //   22	74	77	java/lang/Throwable
    //   100	117	77	java/lang/Throwable
    //   117	178	77	java/lang/Throwable
    //   13	22	181	finally
    //   22	74	181	finally
    //   100	117	181	finally
    //   117	178	181	finally
    //   198	204	205	java/lang/Throwable
    //   93	99	214	java/lang/Throwable
    //   186	192	223	java/lang/Throwable
    //   0	13	234	finally
    //   82	89	240	finally
    //   0	13	248	java/lang/Throwable
  }
  
  public boolean a()
  {
    if (StatConfig.isDebugEnable()) {
      af.e().w("delete " + this.a);
    }
    return this.b.deleteDatabase(this.a);
  }
  
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
    paramSQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    af.e().debug("upgrade DB from oldVersion " + paramInt1 + " to newVersion " + paramInt2);
    if (paramInt1 == 1)
    {
      paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
    if (paramInt1 == 2)
    {
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.an
 * JD-Core Version:    0.7.0.1
 */