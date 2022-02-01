package com.tencent.beacon.e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.module.StrategyModule;
import java.util.Locale;

public final class j
{
  private static String a;
  
  /* Error */
  public static i a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: ifnonnull +19 -> 28
    //   12: ldc 13
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 19	com/tencent/beacon/base/util/c:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aconst_null
    //   22: astore_2
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_2
    //   27: areturn
    //   28: invokestatic 25	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   31: invokevirtual 29	com/tencent/beacon/a/c/c:f	()Ljava/lang/String;
    //   34: astore_2
    //   35: new 6	com/tencent/beacon/e/j$a
    //   38: dup
    //   39: aload_0
    //   40: aload_2
    //   41: invokespecial 33	com/tencent/beacon/e/j$a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   44: invokevirtual 39	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnonnull +32 -> 81
    //   52: ldc 41
    //   54: iconst_0
    //   55: anewarray 4	java/lang/Object
    //   58: invokestatic 19	com/tencent/beacon/base/util/c:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: ifnull +14 -> 76
    //   65: aload_0
    //   66: invokevirtual 47	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   69: ifeq +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 51	android/database/sqlite/SQLiteDatabase:close	()V
    //   76: aconst_null
    //   77: astore_2
    //   78: goto -55 -> 23
    //   81: getstatic 57	java/util/Locale:US	Ljava/util/Locale;
    //   84: astore_2
    //   85: aload_2
    //   86: ldc 59
    //   88: iconst_2
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: ldc 61
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: iload_1
    //   100: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: invokestatic 73	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   107: astore_2
    //   108: aload_0
    //   109: ldc 75
    //   111: aconst_null
    //   112: aload_2
    //   113: aconst_null
    //   114: aconst_null
    //   115: aconst_null
    //   116: aconst_null
    //   117: invokevirtual 79	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   120: astore_3
    //   121: aload_3
    //   122: ifnull +213 -> 335
    //   125: aload_3
    //   126: invokeinterface 84 1 0
    //   131: ifeq +204 -> 335
    //   134: aload_3
    //   135: invokestatic 87	com/tencent/beacon/e/j:a	(Landroid/database/Cursor;)Lcom/tencent/beacon/e/i;
    //   138: astore_2
    //   139: aload_2
    //   140: ifnull +257 -> 397
    //   143: ldc 89
    //   145: iconst_1
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_2
    //   152: getfield 95	com/tencent/beacon/e/i:b	I
    //   155: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: invokestatic 97	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aload_3
    //   163: ifnull +18 -> 181
    //   166: aload_3
    //   167: invokeinterface 100 1 0
    //   172: ifne +9 -> 181
    //   175: aload_3
    //   176: invokeinterface 101 1 0
    //   181: aload_0
    //   182: ifnull +14 -> 196
    //   185: aload_0
    //   186: invokevirtual 47	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   189: ifeq +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 51	android/database/sqlite/SQLiteDatabase:close	()V
    //   196: goto -173 -> 23
    //   199: astore 5
    //   201: aload_0
    //   202: astore 4
    //   204: aload_2
    //   205: astore_0
    //   206: aload_3
    //   207: astore_2
    //   208: aload 4
    //   210: astore_3
    //   211: aload 5
    //   213: astore 4
    //   215: invokestatic 106	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   218: astore 5
    //   220: aload 5
    //   222: ldc 108
    //   224: ldc 110
    //   226: invokevirtual 113	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 4
    //   231: invokestatic 116	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   234: aload_2
    //   235: ifnull +18 -> 253
    //   238: aload_2
    //   239: invokeinterface 100 1 0
    //   244: ifne +9 -> 253
    //   247: aload_2
    //   248: invokeinterface 101 1 0
    //   253: aload_0
    //   254: astore_2
    //   255: aload_3
    //   256: ifnull -233 -> 23
    //   259: aload_0
    //   260: astore_2
    //   261: aload_3
    //   262: invokevirtual 47	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   265: ifeq -242 -> 23
    //   268: aload_3
    //   269: invokevirtual 51	android/database/sqlite/SQLiteDatabase:close	()V
    //   272: aload_0
    //   273: astore_2
    //   274: goto -251 -> 23
    //   277: astore_0
    //   278: ldc 2
    //   280: monitorexit
    //   281: aload_0
    //   282: athrow
    //   283: astore_2
    //   284: aload_3
    //   285: ifnull +18 -> 303
    //   288: aload_3
    //   289: invokeinterface 100 1 0
    //   294: ifne +9 -> 303
    //   297: aload_3
    //   298: invokeinterface 101 1 0
    //   303: aload_0
    //   304: ifnull +14 -> 318
    //   307: aload_0
    //   308: invokevirtual 47	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   311: ifeq +7 -> 318
    //   314: aload_0
    //   315: invokevirtual 51	android/database/sqlite/SQLiteDatabase:close	()V
    //   318: aload_2
    //   319: athrow
    //   320: astore 4
    //   322: aload_0
    //   323: astore 5
    //   325: aconst_null
    //   326: astore_0
    //   327: aload_3
    //   328: astore_2
    //   329: aload 5
    //   331: astore_3
    //   332: goto -117 -> 215
    //   335: aconst_null
    //   336: astore_2
    //   337: goto -175 -> 162
    //   340: astore 4
    //   342: aconst_null
    //   343: astore_2
    //   344: aload_0
    //   345: astore_3
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -133 -> 215
    //   351: astore_2
    //   352: aconst_null
    //   353: astore_0
    //   354: aload 4
    //   356: astore_3
    //   357: goto -73 -> 284
    //   360: astore 4
    //   362: aconst_null
    //   363: astore_2
    //   364: aconst_null
    //   365: astore_0
    //   366: goto -151 -> 215
    //   369: astore_0
    //   370: aload_2
    //   371: astore 4
    //   373: aload_0
    //   374: astore_2
    //   375: aload_3
    //   376: astore_0
    //   377: aload 4
    //   379: astore_3
    //   380: goto -96 -> 284
    //   383: astore_2
    //   384: aload 4
    //   386: astore_3
    //   387: goto -103 -> 284
    //   390: astore_2
    //   391: aload 4
    //   393: astore_3
    //   394: goto -110 -> 284
    //   397: goto -235 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	paramContext	Context
    //   0	400	1	paramInt	int
    //   22	252	2	localObject1	Object
    //   283	36	2	localObject2	Object
    //   328	16	2	localObject3	Object
    //   351	1	2	localObject4	Object
    //   363	12	2	localContext	Context
    //   383	1	2	localObject5	Object
    //   390	1	2	localObject6	Object
    //   4	390	3	localObject7	Object
    //   1	229	4	localObject8	Object
    //   320	1	4	localException1	java.lang.Exception
    //   340	15	4	localException2	java.lang.Exception
    //   360	1	4	localException3	java.lang.Exception
    //   371	21	4	localObject9	Object
    //   199	13	5	localException4	java.lang.Exception
    //   218	112	5	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   143	162	199	java/lang/Exception
    //   12	21	277	finally
    //   28	35	277	finally
    //   65	76	277	finally
    //   166	181	277	finally
    //   185	196	277	finally
    //   238	253	277	finally
    //   261	272	277	finally
    //   288	303	277	finally
    //   307	318	277	finally
    //   318	320	277	finally
    //   125	139	283	finally
    //   143	162	283	finally
    //   125	139	320	java/lang/Exception
    //   52	61	340	java/lang/Exception
    //   81	85	340	java/lang/Exception
    //   85	108	340	java/lang/Exception
    //   108	121	340	java/lang/Exception
    //   35	48	351	finally
    //   35	48	360	java/lang/Exception
    //   215	220	369	finally
    //   220	234	369	finally
    //   81	85	383	finally
    //   85	108	383	finally
    //   108	121	383	finally
    //   52	61	390	finally
  }
  
  private static i a(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isBeforeFirst()) || (paramCursor.isAfterLast())) {
      return null;
    }
    com.tencent.beacon.base.util.c.a("[db] parse bean.", new Object[0]);
    i locali = new i();
    locali.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    locali.b = paramCursor.getInt(paramCursor.getColumnIndex("_key"));
    locali.c = paramCursor.getBlob(paramCursor.getColumnIndex("_datas"));
    return locali;
  }
  
  public static String a()
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    Object localObject = com.tencent.beacon.a.d.a.a();
    a = ((com.tencent.beacon.a.d.a)localObject).getString("initsdkdate", "");
    if (!com.tencent.beacon.base.util.b.d().equals(a))
    {
      localObject = ((com.tencent.beacon.a.d.a)localObject).edit();
      if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject)) {
        ((SharedPreferences.Editor)localObject).putString("initsdkdate", com.tencent.beacon.base.util.b.d());
      }
    }
    return a;
  }
  
  public static boolean b()
  {
    Object localObject = com.tencent.beacon.a.d.a.a();
    if (com.tencent.beacon.base.util.b.d().equals(a())) {}
    for (int i = ((com.tencent.beacon.a.d.a)localObject).getInt("QUERY_TIMES_KEY", 0);; i = 0)
    {
      if (i <= a.a().c())
      {
        localObject = ((com.tencent.beacon.a.d.a)localObject).edit();
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject)) {
          ((SharedPreferences.Editor)localObject).putInt("QUERY_TIMES_KEY", i + 1);
        }
        return false;
      }
      com.tencent.beacon.base.util.c.d("[strategy] sdk init max times", new Object[0]);
      return true;
    }
  }
  
  public static boolean c()
  {
    Object localObject = ((StrategyModule)com.tencent.beacon.a.c.c.d().a(ModuleName.STRATEGY)).b();
    if (((b)localObject).j())
    {
      com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
      long l1 = System.currentTimeMillis();
      long l2 = (l1 / 60000L + 480L) % 1440L;
      if ((l2 >= 0L) && (l2 <= 30L) && (l1 - locala.getLong("last_success_strategy_query_time", 0L) <= 90000000L)) {
        return true;
      }
      if (com.tencent.beacon.base.util.b.d().equals(a()))
      {
        if (locala.getInt("today_success_strategy_query_times", 0) >= ((b)localObject).c()) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      localObject = locala.edit();
      if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject)) {
        ((SharedPreferences.Editor)localObject).putInt("today_success_strategy_query_times", 0);
      }
    }
    return false;
  }
  
  public static void d()
  {
    Object localObject = ((StrategyModule)com.tencent.beacon.a.c.c.d().a(ModuleName.STRATEGY)).b();
    if ((localObject != null) && (((b)localObject).j()))
    {
      localObject = com.tencent.beacon.a.d.a.a();
      int i = ((com.tencent.beacon.a.d.a)localObject).getInt("today_success_strategy_query_times", 0);
      localObject = ((com.tencent.beacon.a.d.a)localObject).edit();
      if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject)) {
        ((SharedPreferences.Editor)localObject).putInt("today_success_strategy_query_times", i + 1).putLong("last_success_strategy_query_time", System.currentTimeMillis());
      }
    }
  }
  
  public static class a
    extends SQLiteOpenHelper
  {
    public a(@Nullable Context paramContext, @Nullable String paramString) {}
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL(String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", new Object[] { "t_strategy", "_id", "_key", "_ut", "_datas" }));
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      com.tencent.beacon.base.util.c.a("[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", new Object[] { "beacon_db", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.e.j
 * JD-Core Version:    0.7.0.1
 */