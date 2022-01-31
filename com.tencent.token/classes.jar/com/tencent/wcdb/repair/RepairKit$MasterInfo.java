package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;

public class RepairKit$MasterInfo
{
  private byte[] mKDFSalt;
  private long mMasterPtr;
  
  private RepairKit$MasterInfo(long paramLong, byte[] paramArrayOfByte)
  {
    this.mMasterPtr = paramLong;
    this.mKDFSalt = paramArrayOfByte;
  }
  
  public static MasterInfo load(String paramString, byte[] paramArrayOfByte, String[] paramArrayOfString)
  {
    if (paramString == null) {
      return make(paramArrayOfString);
    }
    byte[] arrayOfByte = new byte[16];
    long l = RepairKit.access$400(paramString, paramArrayOfByte, paramArrayOfString, arrayOfByte);
    if (l == 0L) {
      throw new SQLiteException("Cannot create MasterInfo.");
    }
    return new MasterInfo(l, arrayOfByte);
  }
  
  public static MasterInfo make(String[] paramArrayOfString)
  {
    long l = RepairKit.access$300(paramArrayOfString);
    if (l == 0L) {
      throw new SQLiteException("Cannot create MasterInfo.");
    }
    return new MasterInfo(l, null);
  }
  
  public static boolean save(SQLiteDatabase paramSQLiteDatabase, String paramString, byte[] paramArrayOfByte)
  {
    long l = paramSQLiteDatabase.acquireNativeConnectionHandle("backupMaster", true, false);
    boolean bool = RepairKit.access$500(l, paramString, paramArrayOfByte);
    paramSQLiteDatabase.releaseNativeConnection(l, null);
    return bool;
  }
  
  protected void finalize()
  {
    release();
    super.finalize();
  }
  
  public void release()
  {
    if (this.mMasterPtr == 0L) {
      return;
    }
    RepairKit.access$600(this.mMasterPtr);
    this.mMasterPtr = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit.MasterInfo
 * JD-Core Version:    0.7.0.1
 */