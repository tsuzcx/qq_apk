package com.huawei.hms.support.api.push.c.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString.length() >= 48)
    {
      localStringBuffer.append(paramString, 6, 12);
      localStringBuffer.append(paramString, 16, 26);
      localStringBuffer.append(paramString, 32, 48);
    }
    return localStringBuffer.toString();
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramString2.length() >= 16) && (paramString1.length() >= 16))
    {
      localStringBuffer.append(paramString2, 0, 6);
      localStringBuffer.append(paramString1, 0, 6);
      localStringBuffer.append(paramString2, 6, 10);
      localStringBuffer.append(paramString1, 6, 16);
      localStringBuffer.append(paramString2, 10, 16);
      localStringBuffer.append(paramString1.substring(16));
      localStringBuffer.append(paramString2.substring(16));
    }
    return localStringBuffer.toString();
  }
  
  @SuppressLint({"TrulyRandom"})
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      SecureRandom localSecureRandom = new SecureRandom();
      paramArrayOfByte = new byte[16];
      localSecureRandom.nextBytes(paramArrayOfByte);
      localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramArrayOfByte));
      paramString = localCipher.doFinal(paramString.getBytes("UTF-8"));
      paramString = a(com.huawei.hms.support.api.push.c.a.a.a.a(paramArrayOfByte), com.huawei.hms.support.api.push.c.a.a.a.a(paramString));
      return paramString;
    }
    catch (BadPaddingException paramString)
    {
      HMSLog.e("AesCbc", "aes cbc encrypter data error");
      return "";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      break label96;
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      break label96;
    }
    catch (NoSuchPaddingException paramString)
    {
      break label96;
    }
    catch (InvalidKeyException paramString)
    {
      break label96;
    }
    catch (IllegalBlockSizeException paramString)
    {
      break label96;
    }
    catch (IllegalArgumentException paramString)
    {
      break label96;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label96:
      break label96;
    }
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString.length() >= 48)
    {
      localStringBuffer.append(paramString, 0, 6);
      localStringBuffer.append(paramString, 12, 16);
      localStringBuffer.append(paramString, 26, 32);
      localStringBuffer.append(paramString.substring(48));
    }
    return localStringBuffer.toString();
  }
  
  public static String b(String paramString, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 32) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    try
    {
      paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      String str = a(paramString);
      paramString = b(paramString);
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)))
      {
        HMSLog.w("AesCbc", "iv or enData is null");
        return "";
      }
      localCipher.init(2, paramArrayOfByte, new IvParameterSpec(com.huawei.hms.support.api.push.c.a.a.a.a(str)));
      paramString = new String(localCipher.doFinal(com.huawei.hms.support.api.push.c.a.a.a.a(paramString)), "UTF-8");
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      HMSLog.e("AesCbc", "aes cbc decrypter data error");
      return "";
    }
    catch (BadPaddingException paramString)
    {
      break label117;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      break label117;
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      break label117;
    }
    catch (NoSuchPaddingException paramString)
    {
      break label117;
    }
    catch (InvalidKeyException paramString)
    {
      break label117;
    }
    catch (IllegalBlockSizeException paramString)
    {
      break label117;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label117:
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.c.b.a
 * JD-Core Version:    0.7.0.1
 */