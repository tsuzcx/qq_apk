package com.tencent.tpns.baseapi.base.security;

import android.content.Context;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.File;

public class Security
{
  private static final String TAG = "Security";
  private static boolean loadedTpnsSecuritySo = false;
  public static final String tpnsSecurityLibFullName = "libxgVipSecurity.so";
  private static final String tpnsSecurityLibName = "xgVipSecurity";
  
  static
  {
    try
    {
      System.loadLibrary("xgVipSecurity");
      loadedTpnsSecuritySo = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      TBaseLogger.e("Security", "can not load library,error:", localThrowable);
      loadedTpnsSecuritySo = false;
    }
  }
  
  public static boolean checkTpnsSecurityLibSo(Context paramContext)
  {
    if (loadedTpnsSecuritySo) {
      return true;
    }
    if (paramContext != null) {
      localObject = "";
    }
    try
    {
      paramContext = paramContext.getDir("lib", 0).getParentFile().getAbsolutePath() + File.separator + "lib" + File.separator + "libxgVipSecurity.so";
      localObject = paramContext;
      System.load(paramContext);
      localObject = paramContext;
      loadedTpnsSecuritySo = true;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        loadedTpnsSecuritySo = false;
        TBaseLogger.e("Security", "can not load library from " + (String)localObject + ",error:" + paramContext);
      }
    }
    return loadedTpnsSecuritySo;
  }
  
  public static byte[] decryptSrvData(byte[] paramArrayOfByte)
  {
    TBaseLogger.ii("Security", "---decrypt---");
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length <= 0)
      {
        TBaseLogger.ee("Security", ">> decryptSrvData: encData is empty");
        return null;
      }
      paramArrayOfByte = doDecryptSrvData(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        TBaseLogger.ee("Security", ">> decryptSrvData: decrypt failed!");
        return null;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      TBaseLogger.e("Security", ">> decryptSrvData: throwable", paramArrayOfByte);
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static native byte[] doDecryptSrvData(byte[] paramArrayOfByte);
  
  public static native byte[] doEncryptSrvData(byte[] paramArrayOfByte);
  
  public static byte[] encryptSrvData(byte[] paramArrayOfByte)
  {
    TBaseLogger.ii("Security", "---encrypt---");
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length <= 0)
      {
        TBaseLogger.ee("Security", ">> encryptSrvData: input text is empty");
        return null;
      }
      paramArrayOfByte = doEncryptSrvData(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        TBaseLogger.ee("Security", ">> encryptSrvData: encrypt failed!");
        return null;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      TBaseLogger.e("Security", ">> encryptSrvData: throwable", paramArrayOfByte);
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static native String generateLocalSocketServieNameNative(Object paramObject);
  
  public static native String getBusinessDeviceIdNative(Object paramObject);
  
  public static native String getEncryptAPKSignatureNative(Object paramObject);
  
  public static native byte[] oiSymmetryDecrypt2Byte(byte[] paramArrayOfByte);
  
  public static native byte[] oiSymmetryEncrypt2Byte(String paramString);
  
  private static String toCharsString(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramArrayOfByte[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label44:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label97;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label44;
        label97:
        j += 48;
      }
    }
    return new String(arrayOfChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.security.Security
 * JD-Core Version:    0.7.0.1
 */