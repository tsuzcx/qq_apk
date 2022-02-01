package com.huawei.hianalytics.ab.bc.ab;

import com.huawei.hianalytics.ab.bc.ef.ab;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class gh
  implements fg
{
  private PublicKey ab(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new X509EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte);
  }
  
  private byte[] ab(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    if (paramPublicKey == null) {}
    try
    {
      throw new UnsupportedEncodingException("The loaded public key is null");
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      ab.cd("Rsa", "rsaEncrypt(): getBytes - Unsupported coding format!");
      return new byte[0];
      Cipher localCipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
      localCipher.init(1, paramPublicKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      for (;;)
      {
        ab.cd("Rsa", "rsaEncrypt(): getInstance - No such algorithm,transformation");
      }
    }
    catch (InvalidKeyException paramArrayOfByte)
    {
      for (;;)
      {
        ab.cd("Rsa", "rsaEncrypt(): init - Invalid key!");
      }
    }
    catch (NoSuchPaddingException paramArrayOfByte)
    {
      for (;;)
      {
        ab.cd("Rsa", "rsaEncrypt():  No such filling parameters ");
      }
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      for (;;)
      {
        ab.cd("Rsa", "rsaEncrypt():False filling parameters!");
      }
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      for (;;)
      {
        ab.cd("Rsa", "rsaEncrypt(): doFinal - The provided block is not filled with");
      }
    }
  }
  
  public String ab(String paramString1, String paramString2)
  {
    ab.bc("Rsa", "No RSA decryption method");
    return "";
  }
  
  public String ab(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ab.cd("Rsa", "encrypt: content is empty or null");
      return "";
    }
    try
    {
      paramString = de.ab(ab(paramArrayOfByte, ab(de.ab(paramString))));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      ab.cd("Rsa", "encrypt(): getInstance - No such algorithm,transformation");
      return "";
    }
    catch (InvalidKeySpecException paramString)
    {
      for (;;)
      {
        ab.cd("Rsa", "encrypt(): Invalid key specification");
      }
    }
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
      ab.bc("Rsa", "Unsupported encoding exception,utf-8");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ab.gh
 * JD-Core Version:    0.7.0.1
 */