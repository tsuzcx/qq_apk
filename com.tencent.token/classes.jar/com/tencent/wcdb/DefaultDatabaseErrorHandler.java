package com.tencent.wcdb;

import com.tencent.wcdb.support.Log;
import java.io.File;

public final class DefaultDatabaseErrorHandler
  implements DatabaseErrorHandler
{
  private static final String[] SUFFIX_TO_BACKUP = { "", "-journal", "-wal", ".sm", ".bak", "-vfslog", "-vfslo1" };
  private static final String TAG = "WCDB.DefaultDatabaseErrorHandler";
  private final boolean mNoCorruptionBackup;
  
  public DefaultDatabaseErrorHandler()
  {
    this.mNoCorruptionBackup = false;
  }
  
  public DefaultDatabaseErrorHandler(boolean paramBoolean)
  {
    this.mNoCorruptionBackup = paramBoolean;
  }
  
  private void deleteDatabaseFile(String paramString)
  {
    int j = 0;
    int i = 0;
    if ((paramString.equalsIgnoreCase(":memory:")) || (paramString.trim().length() == 0)) {}
    for (;;)
    {
      return;
      Log.e("WCDB.DefaultDatabaseErrorHandler", "Remove database file: " + paramString);
      Object localObject1;
      Object localObject2;
      if (!this.mNoCorruptionBackup)
      {
        localObject1 = new File(paramString);
        localObject2 = new File(((File)localObject1).getParentFile(), "corrupted");
        if (!((File)localObject2).mkdirs()) {
          Log.e("WCDB.DefaultDatabaseErrorHandler", "Could not create directory for corrupted database. Corruption backup may be unavailable.");
        }
        localObject1 = ((File)localObject2).getPath() + "/" + ((File)localObject1).getName();
        localObject2 = SUFFIX_TO_BACKUP;
        j = localObject2.length;
        while (i < j)
        {
          String str = localObject2[i];
          moveOrDeleteFile(paramString + str, (String)localObject1 + str);
          i += 1;
        }
      }
      else
      {
        localObject1 = SUFFIX_TO_BACKUP;
        int k = localObject1.length;
        i = j;
        while (i < k)
        {
          localObject2 = localObject1[i];
          deleteFile(paramString + (String)localObject2);
          i += 1;
        }
      }
    }
  }
  
  private static boolean deleteFile(String paramString)
  {
    return new File(paramString).delete();
  }
  
  private static boolean moveOrDeleteFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool = paramString1.renameTo(new File(paramString2));
    if (!bool) {
      paramString1.delete();
    }
    return bool;
  }
  
  /* Error */
  public void onCorruption(com.tencent.wcdb.database.SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: ldc 12
    //   2: new 59	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   9: ldc 122
    //   11: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 125	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   18: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 75	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_1
    //   28: invokevirtual 128	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   31: ifne +12 -> 43
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 125	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   39: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   42: return
    //   43: aconst_null
    //   44: astore_2
    //   45: aload_1
    //   46: invokevirtual 134	com/tencent/wcdb/database/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: aload_1
    //   53: invokevirtual 138	com/tencent/wcdb/database/SQLiteDatabase:getTraceCallback	()Lcom/tencent/wcdb/database/SQLiteTrace;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +10 -> 68
    //   61: aload_3
    //   62: aload_1
    //   63: invokeinterface 143 2 0
    //   68: aload_1
    //   69: invokevirtual 146	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   72: aload_2
    //   73: ifnull +41 -> 114
    //   76: aload_2
    //   77: invokeinterface 152 1 0
    //   82: astore_1
    //   83: aload_1
    //   84: invokeinterface 157 1 0
    //   89: ifeq -47 -> 42
    //   92: aload_0
    //   93: aload_1
    //   94: invokeinterface 161 1 0
    //   99: checkcast 163	android/util/Pair
    //   102: getfield 167	android/util/Pair:second	Ljava/lang/Object;
    //   105: checkcast 18	java/lang/String
    //   108: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   111: goto -28 -> 83
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 125	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   119: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   122: return
    //   123: astore_3
    //   124: aload_2
    //   125: ifnull +41 -> 166
    //   128: aload_2
    //   129: invokeinterface 152 1 0
    //   134: astore_1
    //   135: aload_1
    //   136: invokeinterface 157 1 0
    //   141: ifeq -99 -> 42
    //   144: aload_0
    //   145: aload_1
    //   146: invokeinterface 161 1 0
    //   151: checkcast 163	android/util/Pair
    //   154: getfield 167	android/util/Pair:second	Ljava/lang/Object;
    //   157: checkcast 18	java/lang/String
    //   160: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   163: goto -28 -> 135
    //   166: aload_0
    //   167: aload_1
    //   168: invokevirtual 125	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   171: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   174: return
    //   175: astore_3
    //   176: aload_2
    //   177: ifnull +41 -> 218
    //   180: aload_2
    //   181: invokeinterface 152 1 0
    //   186: astore_1
    //   187: aload_1
    //   188: invokeinterface 157 1 0
    //   193: ifeq +33 -> 226
    //   196: aload_0
    //   197: aload_1
    //   198: invokeinterface 161 1 0
    //   203: checkcast 163	android/util/Pair
    //   206: getfield 167	android/util/Pair:second	Ljava/lang/Object;
    //   209: checkcast 18	java/lang/String
    //   212: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   215: goto -28 -> 187
    //   218: aload_0
    //   219: aload_1
    //   220: invokevirtual 125	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   223: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   226: aload_3
    //   227: athrow
    //   228: astore_3
    //   229: goto -177 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	DefaultDatabaseErrorHandler
    //   0	232	1	paramSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
    //   44	137	2	localObject1	Object
    //   49	13	3	localObject2	Object
    //   123	1	3	localSQLiteException1	com.tencent.wcdb.database.SQLiteException
    //   175	52	3	localObject3	Object
    //   228	1	3	localSQLiteException2	com.tencent.wcdb.database.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   68	72	123	com/tencent/wcdb/database/SQLiteException
    //   68	72	175	finally
    //   45	50	228	com/tencent/wcdb/database/SQLiteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.DefaultDatabaseErrorHandler
 * JD-Core Version:    0.7.0.1
 */