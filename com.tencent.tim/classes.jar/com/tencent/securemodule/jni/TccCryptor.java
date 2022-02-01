package com.tencent.securemodule.jni;

import android.content.Context;

public class TccCryptor
{
  public static int EndianSwap(int paramInt)
  {
    return paramInt << 24 | (0xFF00 & paramInt) << 8 | (0xFF0000 & paramInt) >>> 8 | paramInt >>> 24;
  }
  
  public static native byte[] decrypt(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static String encrypt(Context paramContext, String paramString1, String paramString2)
  {
    byte[] arrayOfByte = paramString1.getBytes();
    if (paramString2 == null) {}
    for (paramString1 = null;; paramString1 = paramString2.getBytes()) {
      return new String(encrypt(paramContext, arrayOfByte, paramString1));
    }
  }
  
  public static native byte[] encrypt(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native byte[] makePassword(Context paramContext, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.securemodule.jni.TccCryptor
 * JD-Core Version:    0.7.0.1
 */