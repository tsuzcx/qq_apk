package com.tencent.wcdb.database;

import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.support.Log;
import java.io.File;

public abstract class SQLiteOpenHelper
{
  private static final boolean DEBUG_STRICT_READONLY = false;
  private static final String TAG = "WCDB.SQLiteOpenHelper";
  private SQLiteCipherSpec mCipher;
  private final android.content.Context mContext;
  private SQLiteDatabase mDatabase;
  private boolean mEnableWriteAheadLogging;
  private final DatabaseErrorHandler mErrorHandler;
  private final SQLiteDatabase.CursorFactory mFactory;
  private boolean mIsInitializing;
  private int mMode;
  private final String mName;
  private boolean mNeedMode;
  private final int mNewVersion;
  private byte[] mPassword;
  
  static {}
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, null);
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString, null, null, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramInt >= 1)
    {
      this.mContext = paramContext;
      this.mName = paramString;
      this.mFactory = paramCursorFactory;
      this.mNewVersion = paramInt;
      this.mErrorHandler = paramDatabaseErrorHandler;
      this.mPassword = paramArrayOfByte;
      if (paramSQLiteCipherSpec == null) {
        paramContext = null;
      } else {
        paramContext = new SQLiteCipherSpec(paramSQLiteCipherSpec);
      }
      this.mCipher = paramContext;
      this.mNeedMode = false;
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("Version must be >= 1, was ");
    paramContext.append(paramInt);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public SQLiteOpenHelper(android.content.Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this(paramContext, paramString, paramArrayOfByte, null, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
  }
  
  private SQLiteDatabase getDatabaseLocked(boolean paramBoolean)
  {
    Object localObject1 = this.mDatabase;
    if (localObject1 != null) {
      if (!((SQLiteDatabase)localObject1).isOpen()) {
        this.mDatabase = null;
      } else if ((!paramBoolean) || (!this.mDatabase.isReadOnly())) {
        return this.mDatabase;
      }
    }
    SQLiteDatabase localSQLiteDatabase3;
    SQLiteDatabase localSQLiteDatabase2;
    if (!this.mIsInitializing)
    {
      localSQLiteDatabase3 = this.mDatabase;
      localSQLiteDatabase2 = localSQLiteDatabase3;
    }
    for (;;)
    {
      try
      {
        this.mIsInitializing = true;
        if (localSQLiteDatabase3 != null)
        {
          localObject1 = localSQLiteDatabase3;
          if (paramBoolean)
          {
            localObject1 = localSQLiteDatabase3;
            localSQLiteDatabase2 = localSQLiteDatabase3;
            if (localSQLiteDatabase3.isReadOnly())
            {
              localSQLiteDatabase2 = localSQLiteDatabase3;
              localSQLiteDatabase3.reopenReadWrite();
              localObject1 = localSQLiteDatabase3;
            }
          }
        }
        else
        {
          localSQLiteDatabase2 = localSQLiteDatabase3;
          if (this.mName == null)
          {
            localSQLiteDatabase2 = localSQLiteDatabase3;
            localObject1 = SQLiteDatabase.create(null);
          }
          else
          {
            localSQLiteDatabase2 = localSQLiteDatabase3;
            try
            {
              this.mNeedMode = true;
              localSQLiteDatabase2 = localSQLiteDatabase3;
              if (!this.mEnableWriteAheadLogging) {
                break label398;
              }
              i = 8;
              localSQLiteDatabase2 = localSQLiteDatabase3;
              this.mMode = i;
              localSQLiteDatabase2 = localSQLiteDatabase3;
              localObject1 = com.tencent.wcdb.support.Context.openOrCreateDatabase(this.mContext, this.mName, this.mPassword, this.mCipher, this.mMode, this.mFactory, this.mErrorHandler);
            }
            catch (SQLiteException localSQLiteException)
            {
              if (paramBoolean) {
                continue;
              }
            }
            localSQLiteDatabase2 = localSQLiteDatabase3;
            StringBuilder localStringBuilder = new StringBuilder();
            localSQLiteDatabase2 = localSQLiteDatabase3;
            localStringBuilder.append("Couldn't open ");
            localSQLiteDatabase2 = localSQLiteDatabase3;
            localStringBuilder.append(this.mName);
            localSQLiteDatabase2 = localSQLiteDatabase3;
            localStringBuilder.append(" for writing (will try read-only):");
            localSQLiteDatabase2 = localSQLiteDatabase3;
            Log.e("WCDB.SQLiteOpenHelper", localStringBuilder.toString(), new Object[] { localSQLiteException });
            localSQLiteDatabase2 = localSQLiteDatabase3;
            localSQLiteDatabase1 = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mPassword, this.mCipher, this.mFactory, 1, this.mErrorHandler);
          }
        }
        localSQLiteDatabase2 = localSQLiteDatabase1;
        localSQLiteDatabase3 = getDatabaseLockedLast(localSQLiteDatabase1);
        this.mIsInitializing = false;
        if ((localSQLiteDatabase1 != null) && (localSQLiteDatabase1 != this.mDatabase)) {
          localSQLiteDatabase1.close();
        }
        return localSQLiteDatabase3;
      }
      finally
      {
        SQLiteDatabase localSQLiteDatabase1;
        this.mIsInitializing = false;
        if ((localSQLiteDatabase2 == null) || (localSQLiteDatabase2 == this.mDatabase)) {
          continue;
        }
        localSQLiteDatabase2.close();
      }
      localSQLiteDatabase2 = localSQLiteDatabase3;
      throw localSQLiteDatabase1;
      throw new IllegalStateException("getDatabase called recursively");
      label398:
      int i = 0;
    }
  }
  
  private SQLiteDatabase getDatabaseLockedLast(SQLiteDatabase paramSQLiteDatabase)
  {
    onConfigure(paramSQLiteDatabase);
    int i = paramSQLiteDatabase.getVersion();
    label72:
    StringBuilder localStringBuilder;
    if (i != this.mNewVersion) {
      if (!paramSQLiteDatabase.isReadOnly())
      {
        paramSQLiteDatabase.beginTransaction();
        if (i == 0) {}
        try
        {
          onCreate(paramSQLiteDatabase);
          break label72;
          if (i > this.mNewVersion) {
            onDowngrade(paramSQLiteDatabase, i, this.mNewVersion);
          } else {
            onUpgrade(paramSQLiteDatabase, i, this.mNewVersion);
          }
          paramSQLiteDatabase.setVersion(this.mNewVersion);
          paramSQLiteDatabase.setTransactionSuccessful();
        }
        finally
        {
          paramSQLiteDatabase.endTransaction();
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Can't upgrade read-only database from version ");
        localStringBuilder.append(paramSQLiteDatabase.getVersion());
        localStringBuilder.append(" to ");
        localStringBuilder.append(this.mNewVersion);
        localStringBuilder.append(": ");
        localStringBuilder.append(this.mName);
        throw new SQLiteException(localStringBuilder.toString());
      }
    }
    onOpen(paramSQLiteDatabase);
    if (paramSQLiteDatabase.isReadOnly())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Opened ");
      localStringBuilder.append(this.mName);
      localStringBuilder.append(" in read-only mode");
      Log.w("WCDB.SQLiteOpenHelper", localStringBuilder.toString());
    }
    this.mDatabase = paramSQLiteDatabase;
    return paramSQLiteDatabase;
  }
  
  public void close()
  {
    try
    {
      if (!this.mIsInitializing)
      {
        if ((this.mDatabase != null) && (this.mDatabase.isOpen()))
        {
          this.mDatabase.close();
          this.mDatabase = null;
        }
        return;
      }
      throw new IllegalStateException("Closed during initialization");
    }
    finally {}
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
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("Can't downgrade database from version ");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(" to ");
    paramSQLiteDatabase.append(paramInt2);
    throw new SQLiteException(paramSQLiteDatabase.toString());
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    try
    {
      if (this.mEnableWriteAheadLogging != paramBoolean)
      {
        if ((this.mDatabase != null) && (this.mDatabase.isOpen()) && (!this.mDatabase.isReadOnly())) {
          if (paramBoolean) {
            this.mDatabase.enableWriteAheadLogging();
          } else {
            this.mDatabase.disableWriteAheadLogging();
          }
        }
        this.mEnableWriteAheadLogging = paramBoolean;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */