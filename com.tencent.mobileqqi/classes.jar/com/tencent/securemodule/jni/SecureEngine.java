package com.tencent.securemodule.jni;

import android.content.Context;

public class SecureEngine
{
  private int a;
  
  public SecureEngine(Context paramContext)
  {
    try
    {
      this.a = newObject(paramContext);
      if (this.a == 0) {
        throw new VerifyError();
      }
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = nativeCheckSecureStatus(paramContext);
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = nativeGetEngineVersion(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  private static native void deleteObject(int paramInt);
  
  private static native boolean nativeCheckSecureStatus(Context paramContext);
  
  private static native String nativeGetEngineVersion(Context paramContext);
  
  private static native int newObject(Context paramContext);
  
  private static native int scanThreatens(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public final int a(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      paramInt = scanThreatens(this.a, paramInt, paramArrayOfByte);
      return paramInt;
    }
    catch (Throwable paramArrayOfByte) {}
    return -1;
  }
  
  protected void finalize()
  {
    if (this.a != 0) {
      deleteObject(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.jni.SecureEngine
 * JD-Core Version:    0.7.0.1
 */