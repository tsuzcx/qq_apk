package tmsdk.common.tcc;

import android.content.Context;
import tmsdk.common.a;

public class TccCryptor
{
  static
  {
    a.a(0, TccCryptor.class);
  }
  
  public static int EndianSwap(int paramInt)
  {
    return paramInt << 24 | (0xFF00 & paramInt) << 8 | (0xFF0000 & paramInt) >>> 8 | paramInt >>> 24;
  }
  
  @Deprecated
  public static byte[] decrypt(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static native byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  @Deprecated
  public static boolean decryptBoolean(Context paramContext, boolean paramBoolean)
  {
    return decryptBoolean(paramBoolean);
  }
  
  public static boolean decryptBoolean(boolean paramBoolean)
  {
    return !paramBoolean;
  }
  
  public static int decryptInt(int paramInt)
  {
    return paramInt ^ 0xFFFFFFFF;
  }
  
  @Deprecated
  public static int decryptInt(Context paramContext, int paramInt)
  {
    return decryptInt(paramInt);
  }
  
  public static long decryptLong(long paramLong)
  {
    return 0xFFFFFFFF ^ paramLong;
  }
  
  @Deprecated
  public static long decryptLong(Context paramContext, long paramLong)
  {
    return decryptLong(paramLong);
  }
  
  @Deprecated
  public static String encrypt(Context paramContext, String paramString1, String paramString2)
  {
    return encrypt(paramString1, paramString2);
  }
  
  public static String encrypt(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = paramString1.getBytes();
    if (paramString2 == null) {}
    for (paramString1 = null;; paramString1 = paramString2.getBytes()) {
      return new String(encrypt(arrayOfByte, paramString1));
    }
  }
  
  @Deprecated
  public static byte[] encrypt(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return encrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static native byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  @Deprecated
  public static boolean encryptBoolean(Context paramContext, boolean paramBoolean)
  {
    return encryptBoolean(paramBoolean);
  }
  
  public static boolean encryptBoolean(boolean paramBoolean)
  {
    return !paramBoolean;
  }
  
  public static int encryptInt(int paramInt)
  {
    return paramInt ^ 0xFFFFFFFF;
  }
  
  @Deprecated
  public static int encryptInt(Context paramContext, int paramInt)
  {
    return encryptInt(paramInt);
  }
  
  public static long encryptLong(long paramLong)
  {
    return 0xFFFFFFFF ^ paramLong;
  }
  
  @Deprecated
  public static long encryptLong(Context paramContext, long paramLong)
  {
    return encryptLong(paramLong);
  }
  
  @Deprecated
  public static byte[] makePassword(Context paramContext, byte[] paramArrayOfByte)
  {
    return makePassword(paramArrayOfByte);
  }
  
  public static native byte[] makePassword(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.tcc.TccCryptor
 * JD-Core Version:    0.7.0.1
 */