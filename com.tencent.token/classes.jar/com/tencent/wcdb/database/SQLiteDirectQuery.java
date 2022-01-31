package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectQuery
  extends SQLiteProgram
{
  private static final int[] SQLITE_TYPE_MAPPING = { 3, 1, 2, 3, 4, 0 };
  private static final String TAG = "WCDB.SQLiteDirectQuery";
  private final CancellationSignal mCancellationSignal;
  
  public SQLiteDirectQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
    this.mCancellationSignal = paramCancellationSignal;
  }
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt);
  
  private static native double nativeGetDouble(long paramLong, int paramInt);
  
  private static native long nativeGetLong(long paramLong, int paramInt);
  
  private static native String nativeGetString(long paramLong, int paramInt);
  
  private static native int nativeGetType(long paramLong, int paramInt);
  
  private static native int nativeStep(long paramLong, int paramInt);
  
  public byte[] getBlob(int paramInt)
  {
    return nativeGetBlob(this.mPreparedStatement.getPtr(), paramInt);
  }
  
  public double getDouble(int paramInt)
  {
    return nativeGetDouble(this.mPreparedStatement.getPtr(), paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return nativeGetLong(this.mPreparedStatement.getPtr(), paramInt);
  }
  
  public String getString(int paramInt)
  {
    return nativeGetString(this.mPreparedStatement.getPtr(), paramInt);
  }
  
  public int getType(int paramInt)
  {
    return SQLITE_TYPE_MAPPING[nativeGetType(this.mPreparedStatement.getPtr(), paramInt)];
  }
  
  protected void onAllReferencesReleased()
  {
    try
    {
      if (this.mPreparedStatement != null)
      {
        this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
        this.mPreparedStatement.endOperation(null);
      }
      super.onAllReferencesReleased();
      return;
    }
    finally {}
  }
  
  public void reset(boolean paramBoolean)
  {
    try
    {
      if (this.mPreparedStatement != null)
      {
        this.mPreparedStatement.reset(false);
        if (paramBoolean)
        {
          this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
          this.mPreparedStatement.endOperation(null);
          releasePreparedStatement();
        }
      }
      return;
    }
    finally {}
  }
  
  public int step(int paramInt)
  {
    try
    {
      if (acquirePreparedStatement())
      {
        this.mPreparedStatement.beginOperation("directQuery", getBindArgs());
        this.mPreparedStatement.attachCancellationSignal(this.mCancellationSignal);
      }
      paramInt = nativeStep(this.mPreparedStatement.getPtr(), paramInt);
      return paramInt;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (!(localRuntimeException instanceof SQLiteDatabaseCorruptException)) {
        break label89;
      }
    }
    onCorruption();
    for (;;)
    {
      if (this.mPreparedStatement != null)
      {
        this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
        this.mPreparedStatement.failOperation(localRuntimeException);
      }
      releasePreparedStatement();
      throw localRuntimeException;
      label89:
      if ((localRuntimeException instanceof SQLiteException)) {
        Log.e("WCDB.SQLiteDirectQuery", "Got exception on stepping: " + localRuntimeException.getMessage() + ", SQL: " + getSql());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectQuery
 * JD-Core Version:    0.7.0.1
 */