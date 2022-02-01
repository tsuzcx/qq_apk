package com.tencent.wcdb.database;

import com.tencent.wcdb.CursorWindowAllocationException;

public class ChunkedCursorWindow
  extends SQLiteClosable
{
  public static final long CHUNK_NOT_FOUND = -1L;
  private int mNumColumns = 0;
  long mWindowPtr;
  
  public ChunkedCursorWindow(int paramInt)
  {
    this.mWindowPtr = nativeCreate(paramInt);
    if (this.mWindowPtr != 0L) {
      return;
    }
    throw new CursorWindowAllocationException("Cursor window allocation failed.");
  }
  
  private void dispose()
  {
    long l = this.mWindowPtr;
    if (l != 0L)
    {
      nativeDispose(l);
      this.mWindowPtr = 0L;
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
  
  public void clear()
  {
    acquireReference();
    try
    {
      nativeClear(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  void endRowUnsafe(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    nativeEndRow(this.mWindowPtr, paramLong);
    releaseReference();
  }
  
  protected void finalize()
  {
    try
    {
      dispose();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    long l = getRowUnsafe(paramInt1);
    if (l != 0L) {
      try
      {
        byte[] arrayOfByte = nativeGetBlob(l, paramInt2);
        return arrayOfByte;
      }
      finally
      {
        endRowUnsafe(l);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Couldn't read row ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", column ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" from ChunkedCursorWindow.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  byte[] getBlobUnsafe(long paramLong, int paramInt)
  {
    return nativeGetBlob(paramLong, paramInt);
  }
  
  public double getDouble(int paramInt1, int paramInt2)
  {
    long l = getRowUnsafe(paramInt1);
    if (l != 0L) {
      try
      {
        double d = nativeGetDouble(l, paramInt2);
        return d;
      }
      finally
      {
        endRowUnsafe(l);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Couldn't read row ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", column ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" from ChunkedCursorWindow.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  double getDoubleUnsafe(long paramLong, int paramInt)
  {
    return nativeGetDouble(paramLong, paramInt);
  }
  
  public long getLong(int paramInt1, int paramInt2)
  {
    long l1 = getRowUnsafe(paramInt1);
    if (l1 != 0L) {
      try
      {
        long l2 = nativeGetLong(l1, paramInt2);
        return l2;
      }
      finally
      {
        endRowUnsafe(l1);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Couldn't read row ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", column ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" from ChunkedCursorWindow.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  long getLongUnsafe(long paramLong, int paramInt)
  {
    return nativeGetLong(paramLong, paramInt);
  }
  
  public int getNumChunks()
  {
    acquireReference();
    try
    {
      int i = nativeGetNumChunks(this.mWindowPtr);
      return i;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int getNumColumns()
  {
    return this.mNumColumns;
  }
  
  long getRowUnsafe(int paramInt)
  {
    acquireReference();
    long l = nativeGetRow(this.mWindowPtr, paramInt);
    if (l == 0L) {
      releaseReference();
    }
    return l;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    long l = getRowUnsafe(paramInt1);
    if (l != 0L) {
      try
      {
        String str = nativeGetString(l, paramInt2);
        return str;
      }
      finally
      {
        endRowUnsafe(l);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Couldn't read row ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", column ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" from ChunkedCursorWindow.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  String getStringUnsafe(long paramLong, int paramInt)
  {
    return nativeGetString(paramLong, paramInt);
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    long l = getRowUnsafe(paramInt1);
    if (l != 0L) {
      try
      {
        paramInt1 = nativeGetType(l, paramInt2);
        return paramInt1;
      }
      finally
      {
        endRowUnsafe(l);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Couldn't read row ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", column ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" from ChunkedCursorWindow.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  int getTypeUnsafe(long paramLong, int paramInt)
  {
    return nativeGetType(paramLong, paramInt);
  }
  
  protected void onAllReferencesReleased()
  {
    dispose();
  }
  
  public long removeChunk(int paramInt)
  {
    acquireReference();
    try
    {
      long l = nativeRemoveChunk(this.mWindowPtr, paramInt);
      return l;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean setNumColumns(int paramInt)
  {
    acquireReference();
    try
    {
      boolean bool = nativeSetNumColumns(this.mWindowPtr, paramInt);
      if (bool) {
        this.mNumColumns = paramInt;
      }
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.ChunkedCursorWindow
 * JD-Core Version:    0.7.0.1
 */