package com.tencent.kingkong.database;

import android.util.Log;
import com.tencent.kingkong.DatabaseErrorHandler;
import java.io.File;

public abstract class SQLiteOpenHelper
{
  private static final boolean DEBUG_STRICT_READONLY = false;
  private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
  private SQLiteDatabase.Arithmetic mArithmeticl;
  private final android.content.Context mContext;
  private SQLiteDatabase mDatabase;
  private boolean mEnableWriteAheadLogging;
  private final DatabaseErrorHandler mErrorHandler;
  private final SQLiteDatabase.CursorFactory mFactory;
  private boolean mIsInitWaited;
  private boolean mIsInitializing;
  private int mMode;
  private final String mName;
  private boolean mNeedMode;
  private final int mNewVersion;
  private String mPassword;
  private SQLiteDatabase.LockedDevice mlockedDevice;
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString, SQLiteDatabase.Arithmetic paramArithmetic, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString, SQLiteDatabase.LockedDevice.DEFAULT, paramArithmetic, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, null);
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString, SQLiteDatabase.LockedDevice.DEFAULT, null, SQLiteDatabase.Arithmetic.UNKNOWN, paramCursorFactory, paramInt, paramDatabaseErrorHandler, false);
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString, SQLiteDatabase.LockedDevice paramLockedDevice, SQLiteDatabase.Arithmetic paramArithmetic, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString, paramLockedDevice, null, paramArithmetic, paramCursorFactory, paramInt, paramDatabaseErrorHandler, true);
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString1, SQLiteDatabase.LockedDevice paramLockedDevice, String paramString2, SQLiteDatabase.Arithmetic paramArithmetic, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString1, paramLockedDevice, paramString2, paramArithmetic, paramCursorFactory, paramInt, paramDatabaseErrorHandler, false);
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString1, SQLiteDatabase.LockedDevice paramLockedDevice, String paramString2, SQLiteDatabase.Arithmetic paramArithmetic, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler, boolean paramBoolean)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("Version must be >= 1, was " + paramInt);
    }
    this.mContext = paramContext;
    this.mName = paramString1;
    this.mFactory = paramCursorFactory;
    this.mNewVersion = paramInt;
    this.mErrorHandler = paramDatabaseErrorHandler;
    this.mPassword = paramString2;
    this.mArithmeticl = paramArithmetic;
    this.mIsInitWaited = paramBoolean;
    this.mlockedDevice = paramLockedDevice;
    this.mNeedMode = false;
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString1, String paramString2, SQLiteDatabase.Arithmetic paramArithmetic, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString1, SQLiteDatabase.LockedDevice.DEFAULT, paramString2, paramArithmetic, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString1, String paramString2, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString1, paramString2, SQLiteDatabase.Arithmetic.DEFAULT, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
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
        localObject = this.mDatabase;
        return localObject;
      }
    }
    SQLiteDatabase localSQLiteDatabase3 = this.mDatabase;
    Object localObject = localSQLiteDatabase3;
    label324:
    SQLiteDatabase localSQLiteDatabase2;
    for (;;)
    {
      try
      {
        this.mIsInitializing = true;
        SQLiteDatabase localSQLiteDatabase1;
        if (localSQLiteDatabase3 != null)
        {
          localSQLiteDatabase1 = localSQLiteDatabase3;
          if (paramBoolean)
          {
            localSQLiteDatabase1 = localSQLiteDatabase3;
            localObject = localSQLiteDatabase3;
            if (localSQLiteDatabase3.isReadOnly())
            {
              localObject = localSQLiteDatabase3;
              localSQLiteDatabase3.reopenReadWrite();
              localSQLiteDatabase1 = localSQLiteDatabase3;
            }
          }
          localObject = localSQLiteDatabase1;
          if (!this.mIsInitWaited) {
            break label413;
          }
          localObject = localSQLiteDatabase1;
          this.mDatabase = localSQLiteDatabase1;
          this.mIsInitializing = false;
          localObject = localSQLiteDatabase1;
          if (localSQLiteDatabase1 == null) {
            break;
          }
          localObject = localSQLiteDatabase1;
          if (localSQLiteDatabase1 == this.mDatabase) {
            break;
          }
          localSQLiteDatabase1.close();
          return localSQLiteDatabase1;
        }
        localObject = localSQLiteDatabase3;
        if (this.mName == null)
        {
          localObject = localSQLiteDatabase3;
          localSQLiteDatabase1 = SQLiteDatabase.create(null, this.mlockedDevice, this.mPassword, this.mArithmeticl, this.mIsInitWaited);
          continue;
        }
        localObject = localSQLiteDatabase3;
        try
        {
          this.mNeedMode = true;
          localObject = localSQLiteDatabase3;
          if (this.mEnableWriteAheadLogging)
          {
            i = 8;
            localObject = localSQLiteDatabase3;
            this.mMode = i;
            localObject = localSQLiteDatabase3;
            localSQLiteDatabase1 = com.tencent.kingkong.support.Context.openOrCreateDatabase(this.mContext, this.mName, this.mlockedDevice, this.mPassword, this.mArithmeticl, this.mMode, this.mFactory, this.mErrorHandler, this.mIsInitWaited);
            continue;
          }
          int i = 0;
          continue;
          localObject = localSQLiteDatabase3;
        }
        catch (SQLiteException localSQLiteException)
        {
          if (!paramBoolean) {
            break label324;
          }
        }
        throw localSQLiteException;
      }
      finally
      {
        this.mIsInitializing = false;
        if ((localObject != null) && (localObject != this.mDatabase)) {
          ((SQLiteDatabase)localObject).close();
        }
      }
      localObject = localSQLiteDatabase3;
      Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", localThrowable);
      localObject = localSQLiteDatabase3;
      localSQLiteDatabase2 = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mlockedDevice, this.mPassword, this.mArithmeticl, this.mFactory, 1, this.mErrorHandler, this.mIsInitWaited);
    }
    label413:
    localObject = localSQLiteDatabase2;
    localSQLiteDatabase3 = getDatabaseLockedLast(localSQLiteDatabase2);
    this.mIsInitializing = false;
    if ((localSQLiteDatabase2 != null) && (localSQLiteDatabase2 != this.mDatabase)) {
      localSQLiteDatabase2.close();
    }
    return localSQLiteDatabase3;
  }
  
  private SQLiteDatabase getDatabaseLockedLast(SQLiteDatabase paramSQLiteDatabase)
  {
    onConfigure(paramSQLiteDatabase);
    int i = paramSQLiteDatabase.getVersion();
    if (i != this.mNewVersion)
    {
      if (paramSQLiteDatabase.isReadOnly()) {
        throw new SQLiteException("Can't upgrade read-only database from version " + paramSQLiteDatabase.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
      }
      paramSQLiteDatabase.beginTransaction();
      if (i != 0) {
        break label161;
      }
    }
    for (;;)
    {
      try
      {
        onCreate(paramSQLiteDatabase);
        paramSQLiteDatabase.setVersion(this.mNewVersion);
        paramSQLiteDatabase.setTransactionSuccessful();
        paramSQLiteDatabase.endTransaction();
        onOpen(paramSQLiteDatabase);
        if (paramSQLiteDatabase.isReadOnly()) {
          Log.w(TAG, "Opened " + this.mName + " in read-only mode");
        }
        this.mDatabase = paramSQLiteDatabase;
        return paramSQLiteDatabase;
      }
      finally
      {
        label161:
        paramSQLiteDatabase.endTransaction();
      }
      if (i > this.mNewVersion) {
        onDowngrade(paramSQLiteDatabase, i, this.mNewVersion);
      } else {
        onUpgrade(paramSQLiteDatabase, i, this.mNewVersion);
      }
    }
  }
  
  public void OverInitWaitedDefault()
  {
    try
    {
      this.mDatabase.OverInitWaitedDefault();
      if (this.mNeedMode) {
        com.tencent.kingkong.support.Context.OverInitWaitedDefault(this.mContext, this.mName, this.mMode);
      }
      SQLiteDatabase localSQLiteDatabase = getDatabaseLockedLast(this.mDatabase);
      this.mIsInitializing = false;
      if ((localSQLiteDatabase != null) && (localSQLiteDatabase != this.mDatabase)) {
        localSQLiteDatabase.close();
      }
      return;
    }
    finally
    {
      this.mIsInitializing = false;
      if ((0 != 0) && (this.mDatabase != null)) {
        throw new NullPointerException();
      }
    }
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
  
  /* Error */
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 148	com/tencent/kingkong/database/SQLiteOpenHelper:mEnableWriteAheadLogging	Z
    //   6: iload_1
    //   7: if_icmpeq +47 -> 54
    //   10: aload_0
    //   11: getfield 120	com/tencent/kingkong/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   14: ifnull +35 -> 49
    //   17: aload_0
    //   18: getfield 120	com/tencent/kingkong/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   21: invokevirtual 126	com/tencent/kingkong/database/SQLiteDatabase:isOpen	()Z
    //   24: ifeq +25 -> 49
    //   27: aload_0
    //   28: getfield 120	com/tencent/kingkong/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   31: invokevirtual 136	com/tencent/kingkong/database/SQLiteDatabase:isReadOnly	()Z
    //   34: ifne +15 -> 49
    //   37: iload_1
    //   38: ifeq +19 -> 57
    //   41: aload_0
    //   42: getfield 120	com/tencent/kingkong/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   45: invokevirtual 258	com/tencent/kingkong/database/SQLiteDatabase:enableWriteAheadLogging	()Z
    //   48: pop
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 148	com/tencent/kingkong/database/SQLiteOpenHelper:mEnableWriteAheadLogging	Z
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: getfield 120	com/tencent/kingkong/database/SQLiteOpenHelper:mDatabase	Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   61: invokevirtual 261	com/tencent/kingkong/database/SQLiteDatabase:disableWriteAheadLogging	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */