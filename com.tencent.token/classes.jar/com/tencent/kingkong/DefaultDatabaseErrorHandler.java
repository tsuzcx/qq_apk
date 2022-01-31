package com.tencent.kingkong;

import android.util.Log;
import com.tencent.kingkong.database.SQLiteDatabase;
import java.io.File;

public final class DefaultDatabaseErrorHandler
  implements DatabaseErrorHandler
{
  private static final String TAG = "DefaultDatabaseErrorHandler";
  
  private void deleteDatabaseFile(String paramString)
  {
    if ((paramString.equalsIgnoreCase(":memory:")) || (paramString.trim().length() == 0)) {
      return;
    }
    Log.e("DefaultDatabaseErrorHandler", "deleting the database file: " + paramString);
    try
    {
      SQLiteDatabase.deleteDatabase(new File(paramString));
      return;
    }
    catch (Exception paramString)
    {
      Log.w("DefaultDatabaseErrorHandler", "delete failed: " + paramString.getMessage());
    }
  }
  
  /* Error */
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: ldc 10
    //   2: new 37	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   9: ldc 77
    //   11: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 80	com/tencent/kingkong/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   18: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   27: pop
    //   28: aload_1
    //   29: invokevirtual 84	com/tencent/kingkong/database/SQLiteDatabase:isOpen	()Z
    //   32: ifne +12 -> 44
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 80	com/tencent/kingkong/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   40: invokespecial 86	com/tencent/kingkong/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   43: return
    //   44: aconst_null
    //   45: astore_3
    //   46: aconst_null
    //   47: astore_2
    //   48: aload_1
    //   49: invokevirtual 90	com/tencent/kingkong/database/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   52: astore 4
    //   54: aload 4
    //   56: astore_2
    //   57: aload_2
    //   58: astore_3
    //   59: aload_1
    //   60: invokevirtual 93	com/tencent/kingkong/database/SQLiteDatabase:close	()V
    //   63: aload_2
    //   64: ifnull +41 -> 105
    //   67: aload_2
    //   68: invokeinterface 99 1 0
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 104 1 0
    //   80: ifeq -37 -> 43
    //   83: aload_0
    //   84: aload_1
    //   85: invokeinterface 108 1 0
    //   90: checkcast 110	android/util/Pair
    //   93: getfield 114	android/util/Pair:second	Ljava/lang/Object;
    //   96: checkcast 23	java/lang/String
    //   99: invokespecial 86	com/tencent/kingkong/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   102: goto -28 -> 74
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual 80	com/tencent/kingkong/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   110: invokespecial 86	com/tencent/kingkong/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   113: return
    //   114: astore_2
    //   115: aload_3
    //   116: ifnull +41 -> 157
    //   119: aload_3
    //   120: invokeinterface 99 1 0
    //   125: astore_1
    //   126: aload_1
    //   127: invokeinterface 104 1 0
    //   132: ifeq +33 -> 165
    //   135: aload_0
    //   136: aload_1
    //   137: invokeinterface 108 1 0
    //   142: checkcast 110	android/util/Pair
    //   145: getfield 114	android/util/Pair:second	Ljava/lang/Object;
    //   148: checkcast 23	java/lang/String
    //   151: invokespecial 86	com/tencent/kingkong/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   154: goto -28 -> 126
    //   157: aload_0
    //   158: aload_1
    //   159: invokevirtual 80	com/tencent/kingkong/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   162: invokespecial 86	com/tencent/kingkong/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   165: aload_2
    //   166: athrow
    //   167: astore_3
    //   168: goto -111 -> 57
    //   171: astore_3
    //   172: goto -109 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	DefaultDatabaseErrorHandler
    //   0	175	1	paramSQLiteDatabase	SQLiteDatabase
    //   47	21	2	localObject1	Object
    //   114	52	2	localObject2	Object
    //   45	75	3	localObject3	Object
    //   167	1	3	localSQLiteException1	com.tencent.kingkong.database.SQLiteException
    //   171	1	3	localSQLiteException2	com.tencent.kingkong.database.SQLiteException
    //   52	3	4	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   48	54	114	finally
    //   59	63	114	finally
    //   48	54	167	com/tencent/kingkong/database/SQLiteException
    //   59	63	171	com/tencent/kingkong/database/SQLiteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.DefaultDatabaseErrorHandler
 * JD-Core Version:    0.7.0.1
 */