package com.tencent.moai.database;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDebug.Log;
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
    SQLiteDebug.Log.e("DefaultDatabaseErrorHandler", "deleting the database file: " + paramString);
    try
    {
      SQLiteDatabase.deleteDatabase(new File(paramString));
      return;
    }
    catch (Exception paramString)
    {
      SQLiteDebug.Log.w("DefaultDatabaseErrorHandler", "delete failed: " + paramString.getMessage());
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
    //   15: invokevirtual 80	com/tencent/moai/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   18: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 53	com/tencent/moai/database/sqlite/SQLiteDebug$Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: invokestatic 84	com/tencent/moai/database/sqlite/SQLiteDatabase:hasCodec	()Z
    //   30: ifeq +4 -> 34
    //   33: return
    //   34: aload_1
    //   35: invokevirtual 87	com/tencent/moai/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   38: ifne +12 -> 50
    //   41: aload_0
    //   42: aload_1
    //   43: invokevirtual 80	com/tencent/moai/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   46: invokespecial 89	com/tencent/moai/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   49: return
    //   50: aconst_null
    //   51: astore_2
    //   52: aload_1
    //   53: invokevirtual 93	com/tencent/moai/database/sqlite/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   56: astore_3
    //   57: aload_3
    //   58: astore_2
    //   59: aload_1
    //   60: invokevirtual 96	com/tencent/moai/database/sqlite/SQLiteDatabase:close	()V
    //   63: aload_2
    //   64: ifnull +41 -> 105
    //   67: aload_2
    //   68: invokeinterface 102 1 0
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 107 1 0
    //   80: ifeq -47 -> 33
    //   83: aload_0
    //   84: aload_1
    //   85: invokeinterface 111 1 0
    //   90: checkcast 113	android/util/Pair
    //   93: getfield 117	android/util/Pair:second	Ljava/lang/Object;
    //   96: checkcast 23	java/lang/String
    //   99: invokespecial 89	com/tencent/moai/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   102: goto -28 -> 74
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual 80	com/tencent/moai/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   110: invokespecial 89	com/tencent/moai/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   113: return
    //   114: astore_2
    //   115: aconst_null
    //   116: astore_3
    //   117: aload_3
    //   118: ifnull +41 -> 159
    //   121: aload_3
    //   122: invokeinterface 102 1 0
    //   127: astore_1
    //   128: aload_1
    //   129: invokeinterface 107 1 0
    //   134: ifeq +33 -> 167
    //   137: aload_0
    //   138: aload_1
    //   139: invokeinterface 111 1 0
    //   144: checkcast 113	android/util/Pair
    //   147: getfield 117	android/util/Pair:second	Ljava/lang/Object;
    //   150: checkcast 23	java/lang/String
    //   153: invokespecial 89	com/tencent/moai/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   156: goto -28 -> 128
    //   159: aload_0
    //   160: aload_1
    //   161: invokevirtual 80	com/tencent/moai/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   164: invokespecial 89	com/tencent/moai/database/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   167: aload_2
    //   168: athrow
    //   169: astore_3
    //   170: goto -111 -> 59
    //   173: astore_3
    //   174: goto -111 -> 63
    //   177: astore 4
    //   179: aload_2
    //   180: astore_3
    //   181: aload 4
    //   183: astore_2
    //   184: goto -67 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	DefaultDatabaseErrorHandler
    //   0	187	1	paramSQLiteDatabase	SQLiteDatabase
    //   51	17	2	localObject1	Object
    //   114	66	2	localObject2	Object
    //   183	1	2	localObject3	Object
    //   56	66	3	localList	java.util.List
    //   169	1	3	localSQLiteException1	com.tencent.moai.database.sqlite.SQLiteException
    //   173	1	3	localSQLiteException2	com.tencent.moai.database.sqlite.SQLiteException
    //   180	1	3	localObject4	Object
    //   177	5	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   52	57	114	finally
    //   52	57	169	com/tencent/moai/database/sqlite/SQLiteException
    //   59	63	173	com/tencent/moai/database/sqlite/SQLiteException
    //   59	63	177	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.DefaultDatabaseErrorHandler
 * JD-Core Version:    0.7.0.1
 */