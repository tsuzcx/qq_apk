package com.tencent.beacon.a.d;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.beacon.a.b.d;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class c
  extends SQLiteOpenHelper
{
  private String a = "";
  
  public c(String paramString)
  {
    super(com.tencent.beacon.a.c.c.d().c(), "beacon_db_" + paramString, null, 1);
    com.tencent.beacon.base.util.c.a("[DB]", 0, "DBOpenHelper construc.", new Object[0]);
    this.a = ("beacon_db_" + paramString);
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: new 57	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 58	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_1
    //   10: ldc 60
    //   12: iconst_1
    //   13: anewarray 62	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 64
    //   20: aastore
    //   21: ldc 66
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: invokevirtual 72	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +101 -> 133
    //   35: aload_3
    //   36: invokeinterface 78 1 0
    //   41: ifeq +92 -> 133
    //   44: aload 4
    //   46: aload_3
    //   47: iconst_0
    //   48: invokeinterface 82 2 0
    //   53: invokeinterface 88 2 0
    //   58: pop
    //   59: goto -24 -> 35
    //   62: astore_1
    //   63: invokestatic 94	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   66: astore 4
    //   68: aload 4
    //   70: ldc 96
    //   72: ldc 98
    //   74: aload_1
    //   75: invokevirtual 101	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: aload_1
    //   79: invokestatic 104	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   82: aload_3
    //   83: ifnull +18 -> 101
    //   86: aload_3
    //   87: invokeinterface 107 1 0
    //   92: ifne +9 -> 101
    //   95: aload_3
    //   96: invokeinterface 110 1 0
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_1
    //   104: aload_3
    //   105: astore 4
    //   107: aload_1
    //   108: astore_3
    //   109: aload 4
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +18 -> 131
    //   116: aload_1
    //   117: invokeinterface 107 1 0
    //   122: ifne +9 -> 131
    //   125: aload_1
    //   126: invokeinterface 110 1 0
    //   131: aload_3
    //   132: athrow
    //   133: aload 4
    //   135: invokeinterface 114 1 0
    //   140: ifle +100 -> 240
    //   143: aload 4
    //   145: invokeinterface 118 1 0
    //   150: astore 4
    //   152: aload 4
    //   154: invokeinterface 123 1 0
    //   159: ifeq +81 -> 240
    //   162: aload 4
    //   164: invokeinterface 127 1 0
    //   169: checkcast 62	java/lang/String
    //   172: astore 5
    //   174: aload 5
    //   176: ldc 129
    //   178: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: istore_2
    //   182: iload_2
    //   183: ifne -31 -> 152
    //   186: aload 5
    //   188: ldc 134
    //   190: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   193: ifne -41 -> 152
    //   196: aload_1
    //   197: new 20	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   204: ldc 136
    //   206: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 5
    //   211: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokevirtual 139	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   220: ldc 42
    //   222: iconst_1
    //   223: ldc 141
    //   225: iconst_1
    //   226: anewarray 46	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload 5
    //   233: aastore
    //   234: invokestatic 51	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/Object;)V
    //   237: goto -85 -> 152
    //   240: aload_3
    //   241: ifnull +18 -> 259
    //   244: aload_3
    //   245: invokeinterface 107 1 0
    //   250: ifne +9 -> 259
    //   253: aload_3
    //   254: invokeinterface 110 1 0
    //   259: iconst_1
    //   260: ireturn
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_1
    //   264: goto -152 -> 112
    //   267: astore_1
    //   268: aconst_null
    //   269: astore_3
    //   270: goto -207 -> 63
    //   273: astore 4
    //   275: aload_3
    //   276: astore_1
    //   277: aload 4
    //   279: astore_3
    //   280: goto -168 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	c
    //   0	283	1	paramSQLiteDatabase	SQLiteDatabase
    //   181	2	2	bool	boolean
    //   30	224	3	localObject1	Object
    //   261	1	3	localObject2	Object
    //   269	11	3	localObject3	Object
    //   7	156	4	localObject4	Object
    //   273	5	4	localObject5	Object
    //   172	60	5	str	String
    // Exception table:
    //   from	to	target	type
    //   35	59	62	java/lang/Throwable
    //   133	152	62	java/lang/Throwable
    //   152	174	62	java/lang/Throwable
    //   174	182	62	java/lang/Throwable
    //   186	220	62	java/lang/Throwable
    //   220	237	62	java/lang/Throwable
    //   35	59	103	finally
    //   133	152	103	finally
    //   152	174	103	finally
    //   174	182	103	finally
    //   186	220	103	finally
    //   220	237	103	finally
    //   0	9	261	finally
    //   9	31	261	finally
    //   0	9	267	java/lang/Throwable
    //   9	31	267	java/lang/Throwable
    //   63	68	273	finally
    //   68	82	273	finally
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (a(paramSQLiteDatabase))
    {
      com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] drop all success recreate!", new Object[0]);
      onCreate(paramSQLiteDatabase);
    }
    do
    {
      return;
      com.tencent.beacon.base.util.c.e("[db] drop all fail try deleted file,may next time will success!", new Object[0]);
      paramSQLiteDatabase = com.tencent.beacon.a.c.c.d().c().getDatabasePath(this.a);
    } while ((paramSQLiteDatabase == null) || (!paramSQLiteDatabase.canWrite()));
    paramSQLiteDatabase.delete();
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    paramSQLiteDatabase.setPageSize(4096L);
    paramSQLiteDatabase.enableWriteAheadLogging();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    com.tencent.beacon.base.util.c.a("[DB]", 0, "DBOpenHelper onCreate.", new Object[0]);
    try
    {
      Iterator localIterator = b.a.iterator();
      while (localIterator.hasNext()) {
        paramSQLiteDatabase.execSQL((String)localIterator.next());
      }
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      d.b().a("601", "error msg: " + paramSQLiteDatabase.getMessage(), paramSQLiteDatabase);
      com.tencent.beacon.base.util.c.b("[DB] crate db table error!", new Object[0]);
      com.tencent.beacon.base.util.c.a(paramSQLiteDatabase);
    }
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] Downgrade a db  [%s] from v %d to  v%d , deleted all tables!", new Object[] { this.a, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", new Object[] { this.a, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.d.c
 * JD-Core Version:    0.7.0.1
 */