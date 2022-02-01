package com.tencent.wcdb.repair;

import com.tencent.token.afr;
import com.tencent.token.ags.a;
import com.tencent.wcdb.database.SQLiteCipherSpec;

public class RepairKit
  implements ags.a
{
  private long a;
  private b b;
  private a c;
  private RepairCursor d;
  
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
    if (this.c == null) {
      return 0;
    }
    if (this.d == null) {
      this.d = new RepairCursor((byte)0);
    }
    this.d.i = paramLong;
    return this.c.a();
  }
  
  public final void c()
  {
    long l = this.a;
    if (l == 0L) {
      return;
    }
    nativeCancel(l);
  }
  
  protected void finalize()
  {
    b localb = this.b;
    if (localb != null)
    {
      localb.a();
      this.b = null;
    }
    long l = this.a;
    if (l != 0L)
    {
      nativeFini(l);
      this.a = 0L;
    }
    super.finalize();
  }
  
  static class RepairCursor
    extends afr
  {
    long i;
    
    private static native byte[] nativeGetBlob(long paramLong, int paramInt);
    
    private static native int nativeGetColumnCount(long paramLong);
    
    private static native double nativeGetDouble(long paramLong, int paramInt);
    
    private static native long nativeGetLong(long paramLong, int paramInt);
    
    private static native String nativeGetString(long paramLong, int paramInt);
    
    private static native int nativeGetType(long paramLong, int paramInt);
    
    public byte[] getBlob(int paramInt)
    {
      return nativeGetBlob(this.i, paramInt);
    }
    
    public int getColumnCount()
    {
      return nativeGetColumnCount(this.i);
    }
    
    public String[] getColumnNames()
    {
      throw new UnsupportedOperationException();
    }
    
    public int getCount()
    {
      throw new UnsupportedOperationException();
    }
    
    public double getDouble(int paramInt)
    {
      return nativeGetDouble(this.i, paramInt);
    }
    
    public float getFloat(int paramInt)
    {
      return (float)getDouble(paramInt);
    }
    
    public int getInt(int paramInt)
    {
      return (int)getLong(paramInt);
    }
    
    public long getLong(int paramInt)
    {
      return nativeGetLong(this.i, paramInt);
    }
    
    public short getShort(int paramInt)
    {
      return (short)(int)getLong(paramInt);
    }
    
    public String getString(int paramInt)
    {
      return nativeGetString(this.i, paramInt);
    }
    
    public int getType(int paramInt)
    {
      return nativeGetType(this.i, paramInt);
    }
    
    public boolean isNull(int paramInt)
    {
      return getType(paramInt) == 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract int a();
  }
  
  public static final class b
  {
    private long a;
    
    public final void a()
    {
      long l = this.a;
      if (l == 0L) {
        return;
      }
      RepairKit.a(l);
      this.a = 0L;
    }
    
    protected final void finalize()
    {
      a();
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit
 * JD-Core Version:    0.7.0.1
 */