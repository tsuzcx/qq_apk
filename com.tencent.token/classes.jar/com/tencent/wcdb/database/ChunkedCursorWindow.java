package com.tencent.wcdb.database;

import com.tencent.token.ahq;

public class ChunkedCursorWindow
  extends ahq
{
  long a;
  
  private void a()
  {
    long l = this.a;
    if (l != 0L)
    {
      nativeDispose(l);
      this.a = 0L;
    }
  }
  
  private static native void nativeClear(long paramLong);
  
  private static native long nativeCreate(int paramInt);
  
  private static native void nativeDispose(long paramLong);
  
  private static native void nativeEndRow(long paramLong1, long paramLong2);
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt);
  
  private static native double nativeGetDouble(long paramLong, int paramInt);
  
  private static native long nativeGetLong(long paramLong, int paramInt);
  
  private static native int nativeGetNumChunks(long paramLong);
  
  private static native long nativeGetRow(long paramLong, int paramInt);
  
  private static native String nativeGetString(long paramLong, int paramInt);
  
  private static native int nativeGetType(long paramLong, int paramInt);
  
  private static native long nativeRemoveChunk(long paramLong, int paramInt);
  
  private static native boolean nativeSetNumColumns(long paramLong, int paramInt);
  
  public final void c()
  {
    a();
  }
  
  protected void finalize()
  {
    try
    {
      a();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.ChunkedCursorWindow
 * JD-Core Version:    0.7.0.1
 */