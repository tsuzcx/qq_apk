package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;
import java.lang.ref.WeakReference;

final class SQLiteConnection$PreparedStatement
{
  private WeakReference mConnection;
  private boolean mInCache;
  private boolean mInUse;
  private int mNumParameters;
  private SQLiteConnection.Operation mOperation;
  private PreparedStatement mPoolNext;
  private boolean mReadOnly;
  private String mSql;
  private long mStatementPtr;
  private int mType;
  
  SQLiteConnection$PreparedStatement(SQLiteConnection paramSQLiteConnection)
  {
    this.mConnection = new WeakReference(paramSQLiteConnection);
  }
  
  public void attachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
    if (localSQLiteConnection == null) {
      return;
    }
    SQLiteConnection.access$1100(localSQLiteConnection, paramCancellationSignal);
  }
  
  public void beginOperation(String paramString, Object[] paramArrayOfObject)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
    if (localSQLiteConnection == null) {
      return;
    }
    this.mOperation = SQLiteConnection.access$1300(localSQLiteConnection).beginOperation(paramString, this.mSql, paramArrayOfObject);
    this.mOperation.mType = this.mType;
  }
  
  public void bindArguments(Object[] paramArrayOfObject)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
    if (localSQLiteConnection == null) {
      return;
    }
    SQLiteConnection.access$900(localSQLiteConnection, this, paramArrayOfObject);
  }
  
  public void detachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
    if (localSQLiteConnection == null) {
      return;
    }
    SQLiteConnection.access$1200(localSQLiteConnection, paramCancellationSignal);
  }
  
  public void endOperation(String paramString)
  {
    if (this.mOperation == null) {}
    SQLiteConnection localSQLiteConnection;
    do
    {
      return;
      localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
    } while (localSQLiteConnection == null);
    if (SQLiteConnection.access$1300(localSQLiteConnection).endOperationDeferLog(this.mOperation.mCookie)) {
      SQLiteConnection.access$1300(localSQLiteConnection).logOperation(this.mOperation.mCookie, paramString);
    }
    this.mOperation = null;
  }
  
  public void failOperation(Exception paramException)
  {
    if (this.mOperation == null) {}
    SQLiteConnection localSQLiteConnection;
    do
    {
      return;
      localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
    } while (localSQLiteConnection == null);
    SQLiteConnection.access$1300(localSQLiteConnection).failOperation(this.mOperation.mCookie, paramException);
  }
  
  public long getPtr()
  {
    return this.mStatementPtr;
  }
  
  public String getSQL()
  {
    return this.mSql;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public boolean isReadOnly()
  {
    return this.mReadOnly;
  }
  
  public void reset(boolean paramBoolean)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
    if (localSQLiteConnection == null) {
      return;
    }
    SQLiteConnection.access$1000(localSQLiteConnection, this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection.PreparedStatement
 * JD-Core Version:    0.7.0.1
 */