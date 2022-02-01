package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import java.util.Arrays;

public class BackupKit
  implements CancellationSignal.OnCancelListener
{
  public static final int FLAG_FIX_CORRUPTION = 4;
  public static final int FLAG_INCREMENTAL = 16;
  public static final int FLAG_NO_CIPHER = 1;
  public static final int FLAG_NO_COMPRESS = 2;
  public static final int FLAG_NO_CREATE_TABLE = 8;
  public static final int RESULT_CANCELED = 1;
  public static final int RESULT_FAILED = -1;
  public static final int RESULT_OK = 0;
  static final String TAG = "WCDB.DBBackup";
  private SQLiteDatabase mDB;
  private String mLastError;
  private long mNativePtr;
  private int mStatementCount;
  private String[] mTableDesc;
  
  public BackupKit(SQLiteDatabase paramSQLiteDatabase, String paramString, byte[] paramArrayOfByte, int paramInt, String[] paramArrayOfString)
  {
    this.mDB = paramSQLiteDatabase;
    paramSQLiteDatabase = null;
    this.mLastError = null;
    if (paramArrayOfString != null) {
      paramSQLiteDatabase = (String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length);
    }
    this.mTableDesc = paramSQLiteDatabase;
    if (paramString != null)
    {
      this.mNativePtr = nativeInit(paramString, paramArrayOfByte, paramInt);
      if (this.mNativePtr != 0L) {
        return;
      }
      throw new SQLiteException("Failed initialize backup context.");
    }
    throw new IllegalArgumentException();
  }
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeFinish(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  private static native String nativeLastError(long paramLong);
  
  private static native int nativeRun(long paramLong1, long paramLong2, String[] paramArrayOfString);
  
  private static native int nativeStatementCount(long paramLong);
  
  protected void finalize()
  {
    release();
    super.finalize();
  }
  
  public String lastError()
  {
    return this.mLastError;
  }
  
  public void onCancel()
  {
    long l = this.mNativePtr;
    if (l != 0L) {
      nativeCancel(l);
    }
  }
  
  public void release()
  {
    long l = this.mNativePtr;
    if (l != 0L)
    {
      nativeFinish(l);
      this.mNativePtr = 0L;
    }
  }
  
  public int run()
  {
    if (this.mNativePtr != 0L)
    {
      long l = this.mDB.acquireNativeConnectionHandle("backup", false, false);
      int i = nativeRun(this.mNativePtr, l, this.mTableDesc);
      this.mDB.releaseNativeConnection(l, null);
      this.mStatementCount = nativeStatementCount(this.mNativePtr);
      this.mLastError = nativeLastError(this.mNativePtr);
      nativeFinish(this.mNativePtr);
      this.mNativePtr = 0L;
      return i;
    }
    throw new IllegalStateException("BackupKit not initialized.");
  }
  
  public int run(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal.isCanceled()) {
      return 1;
    }
    paramCancellationSignal.setOnCancelListener(this);
    int i = run();
    paramCancellationSignal.setOnCancelListener(null);
    return i;
  }
  
  public int statementCount()
  {
    return this.mStatementCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.BackupKit
 * JD-Core Version:    0.7.0.1
 */