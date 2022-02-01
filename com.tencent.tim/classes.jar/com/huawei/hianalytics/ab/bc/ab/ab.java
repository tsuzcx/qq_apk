package com.huawei.hianalytics.ab.bc.ab;

import android.text.TextUtils;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ab
  implements fg
{
  private static final Charset ab = Charset.forName("UTF-8");
  
  private Pair<byte[], byte[]> ab(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 32)) {
      return new Pair(new byte[0], new byte[0]);
    }
    String str = paramString.substring(0, 32);
    paramString = paramString.substring(32);
    return new Pair(de.ab(str), de.ab(paramString));
  }
  
  private String ab(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 == null) || (paramString == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return "";
    }
    return ab(paramArrayOfByte1, de.ab(bc(paramString, paramArrayOfByte1, paramArrayOfByte2)));
  }
  
  private String ab(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramString;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return de.ab(paramArrayOfByte).concat(str);
  }
  
  private String ab(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1.length == 0) || (paramArrayOfByte2.length == 0) || (paramArrayOfByte3.length == 0))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "decrypt: parameter exception");
      return "";
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, new SecretKeySpec(paramArrayOfByte1, "AES"), new IvParameterSpec(paramArrayOfByte2));
      paramArrayOfByte1 = new String(localCipher.doFinal(paramArrayOfByte3), ab);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesDecrypt(): getInstance - No such algorithm,transformation");
      return "";
    }
    catch (InvalidKeyException paramArrayOfByte1)
    {
      for (;;)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesDecrypt(): init - Invalid key!");
      }
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte1)
    {
      for (;;)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesDecrypt(): init - Invalid algorithm parameters !");
      }
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesDecrypt():  No such filling parameters ");
      }
    }
    catch (BadPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesDecrypt(): False filling parameters!");
      }
    }
    catch (IllegalBlockSizeException paramArrayOfByte1)
    {
      for (;;)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesDecrypt(): doFinal - The provided block is not filled with");
      }
    }
  }
  
  private byte[] bc(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return new byte[0];
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, new SecretKeySpec(de.ab(paramString), "AES"), new IvParameterSpec(paramArrayOfByte1));
      paramString = localCipher.doFinal(paramArrayOfByte2);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesEncrypt(): getInstance - No such algorithm,transformation");
      return new byte[0];
    }
    catch (InvalidKeyException paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesEncrypt(): init - Invalid key!");
      return new byte[0];
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesEncrypt(): init - Invalid algorithm parameters !");
      return new byte[0];
    }
    catch (NoSuchPaddingException paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesEncrypt(): No such filling parameters ");
      return new byte[0];
    }
    catch (BadPaddingException paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesEncrypt(): False filling parameters!");
      return new byte[0];
    }
    catch (IllegalBlockSizeException paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "aesEncrypt(): doFinal - The provided block is not filled with");
    }
    return new byte[0];
  }
  
  public String ab(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("Aes", "decrypt: content or key is empty");
      return "";
    }
    paramString1 = de.ab(paramString1);
    paramString2 = ab(paramString2);
    return ab(paramString1, (byte[])paramString2.first, (byte[])paramString2.second);
  }
  
  public String ab(String paramString, byte[] paramArrayOfByte)
  {
    return ab(paramString, de.ab(), paramArrayOfByte);
  }
  
  public String bc(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = ab(paramString1, paramString2.getBytes("UTF-8"));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("Aes", "Unsupported Encoding Exception : utf-8");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ab.ab
 * JD-Core Version:    0.7.0.1
 */