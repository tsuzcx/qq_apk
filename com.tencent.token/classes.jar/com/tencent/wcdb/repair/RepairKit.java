package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;

public class RepairKit
  implements CancellationSignal.OnCancelListener
{
  public static final int FLAG_ALL_TABLES = 2;
  public static final int FLAG_NO_CREATE_TABLES = 1;
  private static final int INTEGRITY_DATA = 2;
  private static final int INTEGRITY_HEADER = 1;
  private static final int INTEGRITY_KDF_SALT = 4;
  public static final int RESULT_CANCELED = 1;
  public static final int RESULT_FAILED = -1;
  public static final int RESULT_IGNORE = 2;
  public static final int RESULT_OK = 0;
  private RepairKit.Callback mCallback;
  private RepairKit.RepairCursor mCurrentCursor;
  private int mIntegrityFlags;
  private RepairKit.MasterInfo mMasterInfo;
  private long mNativePtr;
  
  public RepairKit(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, RepairKit.MasterInfo paramMasterInfo)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if (paramMasterInfo == null) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = RepairKit.MasterInfo.access$000(paramMasterInfo))
    {
      this.mNativePtr = nativeInit(paramString, paramArrayOfByte, paramSQLiteCipherSpec, arrayOfByte);
      if (this.mNativePtr != 0L) {
        break;
      }
      throw new SQLiteException("Failed initialize RepairKit.");
    }
    this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
    this.mMasterInfo = paramMasterInfo;
  }
  
  public static String lastError()
  {
    return nativeLastError();
  }
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeFini(long paramLong);
  
  private static native void nativeFreeMaster(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte1, SQLiteCipherSpec paramSQLiteCipherSpec, byte[] paramArrayOfByte2);
  
  private static native int nativeIntegrityFlags(long paramLong);
  
  private static native String nativeLastError();
  
  private static native long nativeLoadMaster(String paramString, byte[] paramArrayOfByte1, String[] paramArrayOfString, byte[] paramArrayOfByte2);
  
  private static native long nativeMakeMaster(String[] paramArrayOfString);
  
  private native int nativeOutput(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  private static native boolean nativeSaveMaster(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  private int onProgress(String paramString, int paramInt, long paramLong)
  {
    if (this.mCallback == null) {
      return 0;
    }
    if (this.mCurrentCursor == null) {
      this.mCurrentCursor = new RepairKit.RepairCursor(null);
    }
    this.mCurrentCursor.mPtr = paramLong;
    return this.mCallback.onProgress(paramString, paramInt, this.mCurrentCursor);
  }
  
  protected void finalize()
  {
    release();
    super.finalize();
  }
  
  public RepairKit.Callback getCallback()
  {
    return this.mCallback;
  }
  
  public boolean isDataCorrupted()
  {
    return (this.mIntegrityFlags & 0x2) == 0;
  }
  
  public boolean isHeaderCorrupted()
  {
    return (this.mIntegrityFlags & 0x1) == 0;
  }
  
  public boolean isSaltCorrupted()
  {
    return (this.mIntegrityFlags & 0x4) == 0;
  }
  
  public void onCancel()
  {
    if (this.mNativePtr == 0L) {
      return;
    }
    nativeCancel(this.mNativePtr);
  }
  
  public int output(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    long l1 = 0L;
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException();
    }
    if (this.mMasterInfo == null) {}
    for (;;)
    {
      long l2 = paramSQLiteDatabase.acquireNativeConnectionHandle("repair", false, false);
      paramInt = nativeOutput(this.mNativePtr, l2, l1, paramInt);
      paramSQLiteDatabase.releaseNativeConnection(l2, null);
      this.mCurrentCursor = null;
      this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
      return paramInt;
      l1 = RepairKit.MasterInfo.access$100(this.mMasterInfo);
    }
  }
  
  public int output(SQLiteDatabase paramSQLiteDatabase, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal.isCanceled()) {
      return 1;
    }
    paramCancellationSignal.setOnCancelListener(this);
    paramInt = output(paramSQLiteDatabase, paramInt);
    paramCancellationSignal.setOnCancelListener(null);
    return paramInt;
  }
  
  public void release()
  {
    if (this.mMasterInfo != null)
    {
      this.mMasterInfo.release();
      this.mMasterInfo = null;
    }
    if (this.mNativePtr != 0L)
    {
      nativeFini(this.mNativePtr);
      this.mNativePtr = 0L;
    }
  }
  
  public void setCallback(RepairKit.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit
 * JD-Core Version:    0.7.0.1
 */