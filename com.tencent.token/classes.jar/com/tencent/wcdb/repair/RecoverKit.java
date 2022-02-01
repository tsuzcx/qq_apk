package com.tencent.wcdb.repair;

import com.tencent.token.aje.a;

public class RecoverKit
  implements aje.a
{
  private long a;
  
  private static native void nativeCancel(long paramLong);
  
  private static native int nativeFailureCount(long paramLong);
  
  private static native void nativeFinish(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte);
  
  private static native String nativeLastError(long paramLong);
  
  private static native int nativeRun(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native int nativeSuccessCount(long paramLong);
  
  public final void c()
  {
    long l = this.a;
    if (l != 0L) {
      nativeCancel(l);
    }
  }
  
  protected void finalize()
  {
    long l = this.a;
    if (l != 0L)
    {
      nativeFinish(l);
      this.a = 0L;
    }
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.RecoverKit
 * JD-Core Version:    0.7.0.1
 */