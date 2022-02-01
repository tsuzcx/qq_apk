package com.tencent.moai.database.sqlite;

import android.content.Context;
import com.tencent.moai.database.DatabaseErrorHandler;
import java.io.File;

public abstract class SQLiteOpenHelper
{
  private static final String TAG = "SQLiteOpenHelper";
  private boolean DEBUG_STRICT_READONLY = false;
  private final Context mContext;
  private SQLiteDatabase mDatabase;
  private boolean mEnableWriteAheadLogging;
  protected final DatabaseErrorHandler mErrorHandler;
  private final SQLiteDatabase.CursorFactory mFactory;
  private boolean mIsInitializing;
  private final String mName;
  private final int mNewVersion;
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, null);
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("Version must be >= 1, was " + paramInt);
    }
    this.mContext = paramContext;
    this.mName = paramString;
    this.mFactory = paramCursorFactory;
    this.mNewVersion = paramInt;
    this.mErrorHandler = paramDatabaseErrorHandler;
  }
  
  private SQLiteDatabase getDatabaseLocked(boolean paramBoolean)
  {
    if (this.mDatabase != null)
    {
      if (this.mDatabase.isOpen()) {
        break label39;
      }
      this.mDatabase = null;
    }
    while (this.mIsInitializing)
    {
      throw new IllegalStateException("getDatabase called recursively");
      label39:
      if ((!paramBoolean) || (!this.mDatabase.isReadOnly()))
      {
        SQLiteDatabase localSQLiteDatabase = this.mDatabase;
        return localSQLiteDatabase;
      }
    }
    Object localObject1 = this.mDatabase;
    for (;;)
    {
      for (;;)
      {
        try
        {
          this.mIsInitializing = true;
          if (localObject1 == null) {
            continue;
          }
          if ((!paramBoolean) || (!((SQLiteDatabase)localObject1).isReadOnly())) {
            continue;
          }
          ((SQLiteDatabase)localObject1).reopenReadWrite();
          try
          {
            onConfigure((SQLiteDatabase)localObject1);
            i = ((SQLiteDatabase)localObject1).getVersion();
            if (i == this.mNewVersion) {
              continue;
            }
            if (!((SQLiteDatabase)localObject1).isReadOnly()) {
              continue;
            }
            throw new SQLiteException("Can't upgrade read-only database from version " + ((SQLiteDatabase)localObject1).getVersion() + " to " + this.mNewVersion + ": " + this.mName);
          }
          finally {}
        }
        finally
        {
          int i;
          Object localObject3;
          Object localObject4;
          continue;
        }
        this.mIsInitializing = false;
        if ((localObject1 != null) && (localObject1 != this.mDatabase)) {
          ((SQLiteDatabase)localObject1).close();
        }
        throw localObject2;
        if (this.mName == null)
        {
          localObject3 = SQLiteDatabase.create(null);
          localObject1 = localObject3;
        }
        else
        {
          try
          {
            if ((this.DEBUG_STRICT_READONLY) && (!paramBoolean))
            {
              localObject3 = SQLiteDatabase.openDatabase(getDatabasePath(), this.mFactory, 1, this.mErrorHandler);
              localObject1 = localObject3;
              continue;
            }
            localObject3 = getDatabasePath();
            i = 268435456;
            if (this.mEnableWriteAheadLogging) {
              i = 805306368;
            }
            localObject3 = SQLiteDatabase.openDatabase((String)localObject3, this.mFactory, i, this.mErrorHandler);
            localObject1 = localObject3;
          }
          catch (SQLiteException localSQLiteException)
          {
            if (paramBoolean) {
              throw localSQLiteException;
            }
            SQLiteDebug.Log.e("SQLiteOpenHelper", "Couldn't open " + this.mName + " for writing (will try read-only):", localSQLiteException);
            localObject4 = SQLiteDatabase.openDatabase(getDatabasePath(), this.mFactory, 1, this.mErrorHandler);
            localObject1 = localObject4;
          }
          continue;
          ((SQLiteDatabase)localObject1).beginTransaction();
          if (i != 0) {}
        }
        try
        {
          onCreate((SQLiteDatabase)localObject1);
          ((SQLiteDatabase)localObject1).setVersion(this.mNewVersion);
          ((SQLiteDatabase)localObject1).setTransactionSuccessful();
          ((SQLiteDatabase)localObject1).endTransaction();
          onOpen((SQLiteDatabase)localObject1);
          if (((SQLiteDatabase)localObject1).isReadOnly()) {
            SQLiteDebug.Log.w("SQLiteOpenHelper", "Opened " + this.mName + " in read-only mode");
          }
          this.mDatabase = ((SQLiteDatabase)localObject1);
          this.mIsInitializing = false;
          localObject4 = localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject4 = localObject1;
          if (localObject1 == this.mDatabase) {
            break;
          }
          return localObject1;
        }
        finally
        {
          ((SQLiteDatabase)localObject1).endTransaction();
        }
      }
      if (i > this.mNewVersion)
      {
        onDowngrade((SQLiteDatabase)localObject1, i, this.mNewVersion);
        if (((SQLiteDatabase)localObject1).isWriteAheadLoggingEnabled()) {
          ((SQLiteDatabase)localObject1).closeAvailableNonPrimaryConnections();
        }
      }
      else
      {
        onUpgrade((SQLiteDatabase)localObject1, i, this.mNewVersion);
        continue;
      }
    }
  }
  
  private String getDatabasePath()
  {
    if (this.mName.contains("mode=memory")) {
      return this.mName;
    }
    return this.mContext.getDatabasePath(this.mName).getPath();
  }
  
  public void close()
  {
    try
    {
      if (this.mIsInitializing) {
        throw new IllegalStateException("Closed during initialization");
      }
    }
    finally {}
    if ((this.mDatabase != null) && (this.mDatabase.isOpen()))
    {
      this.mDatabase.close();
      this.mDatabase = null;
    }
  }
  
  public String getDatabaseName()
  {
    return this.mName;
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getDatabaseLocked(false);
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getDatabaseLocked(true);
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    throw new SQLiteException("Can't downgrade database from version " + paramInt1 + " to " + paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public void setDebugStrictReadonly(boolean paramBoolean)
  {
    this.DEBUG_STRICT_READONLY = paramBoolean;
  }
  
  /* Error */
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 122	com/tencent/moai/database/sqlite/SQLiteOpenHelper:mEnableWriteAheadLogging	Z
    //   6: iload_1
    //   7: if_icmpeq +47 -> 54
    //   10: aload_0
    //   11: getfield 71	com/tencent/moai/database/sqlite/SQLiteOpenHelper:mDatabase	Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   14: ifnull +35 -> 49
    //   17: aload_0
    //   18: getfield 71	com/tencent/moai/database/sqlite/SQLiteOpenHelper:mDatabase	Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   21: invokevirtual 77	com/tencent/moai/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   24: ifeq +25 -> 49
    //   27: aload_0
    //   28: getfield 71	com/tencent/moai/database/sqlite/SQLiteOpenHelper:mDatabase	Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   31: invokevirtual 87	com/tencent/moai/database/sqlite/SQLiteDatabase:isReadOnly	()Z
    //   34: ifne +15 -> 49
    //   37: iload_1
    //   38: ifeq +19 -> 57
    //   41: aload_0
    //   42: getfield 71	com/tencent/moai/database/sqlite/SQLiteOpenHelper:mDatabase	Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   45: invokevirtual 207	com/tencent/moai/database/sqlite/SQLiteDatabase:enableWriteAheadLogging	()Z
    //   48: pop
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 122	com/tencent/moai/database/sqlite/SQLiteOpenHelper:mEnableWriteAheadLogging	Z
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: getfield 71	com/tencent/moai/database/sqlite/SQLiteOpenHelper:mDatabase	Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   61: invokevirtual 210	com/tencent/moai/database/sqlite/SQLiteDatabase:disableWriteAheadLogging	()V
    //   64: goto -15 -> 49
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	SQLiteOpenHelper
    //   0	72	1	paramBoolean	boolean
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	67	finally
    //   41	49	67	finally
    //   49	54	67	finally
    //   54	56	67	finally
    //   57	64	67	finally
    //   68	70	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */