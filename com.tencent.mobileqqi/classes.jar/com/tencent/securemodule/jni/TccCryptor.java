package com.tencent.securemodule.jni;

import android.content.Context;

public class TccCryptor
{
  public static native byte[] decrypt(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native byte[] encrypt(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.jni.TccCryptor
 * JD-Core Version:    0.7.0.1
 */