package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

class SecurityResourcesReader
  extends ResourcesReader
{
  private static final String RX_PATH = "/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138";
  private static final String RY_PATH = "/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C";
  private static final String RZ_PATH = "/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B";
  private static final String SL_PATH = "/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD";
  private static final String TAG = "SecurityResourcesReader";
  private final Map<String, String> mConfigs = new HashMap();
  private final Object mConfigsLock = new Object();
  private SecretKey mKey;
  
  SecurityResourcesReader(Context paramContext)
  {
    super(paramContext);
    try
    {
      paramContext = getStringSuper("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
      String str1 = getStringSuper("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
      String str2 = getStringSuper("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
      String str3 = getStringSuper("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
      this.mKey = Keys.buildAesKey(Hex.decodeHexString(paramContext), Hex.decodeHexString(str1), Hex.decodeHexString(str2), Hex.decodeHexString(str3));
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
      this.mKey = null;
    }
  }
  
  private static byte[] decryptAes128(SecretKey paramSecretKey, byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    if ((paramSecretKey == null) || (paramArrayOfByte == null)) {
      throw new NullPointerException("key or cipherText must not be null.");
    }
    byte[] arrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 1, 17);
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, paramSecretKey, new IvParameterSpec(arrayOfByte));
    return localCipher.doFinal(paramArrayOfByte, arrayOfByte.length + 1, paramArrayOfByte.length - arrayOfByte.length - 1);
  }
  
  private String getStringSuper(String paramString)
  {
    return super.getString(paramString, null);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (this.mKey == null) {
      return paramString2;
    }
    String str;
    synchronized (this.mConfigsLock)
    {
      str = (String)this.mConfigs.get(paramString1);
      if (str != null) {
        return str;
      }
      str = getStringSuper(paramString1);
      if (str == null) {
        return paramString2;
      }
    }
    try
    {
      str = new String(decryptAes128(this.mKey, Hex.decodeHexString(str)), "UTF-8");
      this.mConfigs.put(paramString1, str);
      return str;
    }
    catch (Exception paramString1)
    {
      Log.e("SecurityResourcesReader", "Exception when reading the 'V' for 'Config'.");
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.config.impl.SecurityResourcesReader
 * JD-Core Version:    0.7.0.1
 */