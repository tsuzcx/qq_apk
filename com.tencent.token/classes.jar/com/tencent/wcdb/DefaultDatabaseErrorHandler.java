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
    if (!paramString.equalsIgnoreCase(":memory:"))
    {
      if (paramString.trim().length() == 0) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Remove database file: ");
      ((StringBuilder)localObject1).append(paramString);
      Log.e("WCDB.DefaultDatabaseErrorHandler", ((StringBuilder)localObject1).toString());
      boolean bool = this.mNoCorruptionBackup;
      int j = 0;
      int i = 0;
      Object localObject2;
      StringBuilder localStringBuilder1;
      if (!bool)
      {
        localObject1 = new File(paramString);
        localObject2 = new File(((File)localObject1).getParentFile(), "corrupted");
        if (!((File)localObject2).mkdirs()) {
          Log.e("WCDB.DefaultDatabaseErrorHandler", "Could not create directory for corrupted database. Corruption backup may be unavailable.");
        }
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(((File)localObject2).getPath());
        localStringBuilder1.append("/");
        localStringBuilder1.append(((File)localObject1).getName());
        localObject1 = localStringBuilder1.toString();
        localObject2 = SUFFIX_TO_BACKUP;
        j = localObject2.length;
        while (i < j)
        {
          localStringBuilder1 = localObject2[i];
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append(localStringBuilder1);
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(localStringBuilder1);
          moveOrDeleteFile((String)localObject3, localStringBuilder2.toString());
          i += 1;
        }
      }
      localObject1 = SUFFIX_TO_BACKUP;
      int k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localObject1[i];
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(paramString);
        localStringBuilder1.append((String)localObject2);
        deleteFile(localStringBuilder1.toString());
        i += 1;
      }
      return;
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
    //   0: new 59	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 122
    //   11: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_2
    //   16: aload_1
    //   17: invokevirtual 125	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   20: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 12
    //   26: aload_2
    //   27: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 75	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 128	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   37: ifne +12 -> 49
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 125	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   45: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   48: return
    //   49: aconst_null
    //   50: astore_2
    //   51: aload_1
    //   52: invokevirtual 134	com/tencent/wcdb/database/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_1
    //   59: invokevirtual 138	com/tencent/wcdb/database/SQLiteDatabase:getTraceCallback	()Lcom/tencent/wcdb/database/SQLiteTrace;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +10 -> 74
    //   67: aload_3
    //   68: aload_1
    //   69: invokeinterface 143 2 0
    //   74: aload_1
    //   75: invokevirtual 146	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   78: aload_2
    //   79: ifnull +41 -> 120
    //   82: aload_2
    //   83: invokeinterface 152 1 0
    //   88: astore_1
    //   89: aload_1
    //   90: invokeinterface 157 1 0
    //   95: ifeq +129 -> 224
    //   98: aload_0
    //   99: aload_1
    //   100: invokeinterface 161 1 0
    //   105: checkcast 163	android/util/Pair
    //   108: getfield 167	android/util/Pair:second	Ljava/lang/Object;
    //   111: checkcast 18	java/lang/String
    //   114: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   117: goto -28 -> 89
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 125	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   125: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   128: return
    //   129: astore_3
    //   130: aload_2
    //   131: ifnull +41 -> 172
    //   134: aload_2
    //   135: invokeinterface 152 1 0
    //   140: astore_1
    //   141: aload_1
    //   142: invokeinterface 157 1 0
    //   147: ifeq +33 -> 180
    //   150: aload_0
    //   151: aload_1
    //   152: invokeinterface 161 1 0
    //   157: checkcast 163	android/util/Pair
    //   160: getfield 167	android/util/Pair:second	Ljava/lang/Object;
    //   163: checkcast 18	java/lang/String
    //   166: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   169: goto -28 -> 141
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 125	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   177: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   180: aload_3
    //   181: athrow
    //   182: aload_2
    //   183: ifnull -63 -> 120
    //   186: aload_2
    //   187: invokeinterface 152 1 0
    //   192: astore_1
    //   193: aload_1
    //   194: invokeinterface 157 1 0
    //   199: ifeq +25 -> 224
    //   202: aload_0
    //   203: aload_1
    //   204: invokeinterface 161 1 0
    //   209: checkcast 163	android/util/Pair
    //   212: getfield 167	android/util/Pair:second	Ljava/lang/Object;
    //   215: checkcast 18	java/lang/String
    //   218: invokespecial 130	com/tencent/wcdb/DefaultDatabaseErrorHandler:deleteDatabaseFile	(Ljava/lang/String;)V
    //   221: goto -28 -> 193
    //   224: return
    //   225: astore_3
    //   226: goto -168 -> 58
    //   229: astore_3
    //   230: goto -48 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	DefaultDatabaseErrorHandler
    //   0	233	1	paramSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
    //   7	180	2	localObject1	Object
    //   55	13	3	localObject2	Object
    //   129	52	3	localObject3	Object
    //   225	1	3	localSQLiteException1	com.tencent.wcdb.database.SQLiteException
    //   229	1	3	localSQLiteException2	com.tencent.wcdb.database.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   74	78	129	finally
    //   51	56	225	com/tencent/wcdb/database/SQLiteException
    //   74	78	229	com/tencent/wcdb/database/SQLiteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.DefaultDatabaseErrorHandler
 * JD-Core Version:    0.7.0.1
 */