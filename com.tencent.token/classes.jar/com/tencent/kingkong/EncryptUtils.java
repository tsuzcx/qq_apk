package com.tencent.kingkong;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class EncryptUtils
{
  public static final String ALGORITHM_DES = "DES/CBC/NoPadding";
  public static final String LOG_TAG = "EncryptUtils";
  public static String RsaPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzW1ktT6zQrCG1K9H2V8X\rrW/A/ZplyeZy+RQG7loQ4/B/HlbrqBz4w4SwqMG89p/RiFP0Eh+/D4mYyMtWr9QK\rp6fNDcp1L4FMHxxNSlJhtgz+zC+nc812xqDmPa3+AI9yrpUdCBoUvcL85j7Q4glC\rmIHDU62G7qrnBW39YwRIN+P7ocSbR0/y/0DECEAwGFN+kxfHl23ZvrPYRIo7tjCX\rhAUXajP4SOfz/ej2rV17mf5+GDSwMdaJPTTCaFzFwcAMUvcFzVwiiSElzPmzj4GC\rT1Ckjc4oXvYNRuVunsGO9lL6Cdd046Z10XRIIc6FeuMHsxOndMlokOrZb+aCZhv1\rGwIDAQAB\r";
  
  public static byte[] DesDecrypt(String paramString1, String paramString2)
    throws Exception
  {
    return DesDecrypt(paramString1.getBytes(), Base64.decode(paramString2, 0));
  }
  
  public static byte[] DesDecrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    try
    {
      paramArrayOfByte1 = new DESKeySpec(paramArrayOfByte1);
      paramArrayOfByte1 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte1);
      Cipher localCipher = Cipher.getInstance("DES/CBC/NoPadding");
      localCipher.init(2, paramArrayOfByte1, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new Exception(paramArrayOfByte1);
    }
  }
  
  public static String DesEncrypt(String paramString1, String paramString2)
    throws Exception
  {
    return Base64.encodeToString(DesEncrypt(paramString1, paramString2.getBytes()), 0);
  }
  
  public static byte[] DesEncrypt(String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    try
    {
      paramString = new DESKeySpec(paramString.getBytes());
      paramString = SecretKeyFactory.getInstance("DES").generateSecret(paramString);
      Cipher localCipher = Cipher.getInstance("DES/CBC/NoPadding");
      localCipher.init(1, paramString, new IvParameterSpec("12345678".getBytes()));
      paramString = localCipher.doFinal(paramArrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
  
  public static byte[] RsaDecryptData(String paramString)
    throws Exception
  {
    return RsaDecryptData(Base64.decode(paramString, 0));
  }
  
  public static byte[] RsaDecryptData(byte[] paramArrayOfByte)
    throws Exception
  {
    return new byte[0];
  }
  
  public static byte[] RsaDecryptData(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramPrivateKey);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static String RsaEncryptData(String paramString)
    throws Exception
  {
    PublicKey localPublicKey = loadPublicKey(RsaPublicKey);
    return Base64.encodeToString(RsaEncryptData(paramString.getBytes(), localPublicKey), 0);
  }
  
  public static byte[] RsaEncryptData(byte[] paramArrayOfByte, PublicKey paramPublicKey)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(1, paramPublicKey);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static String RsaEncryptDataPrivateKey(String paramString)
    throws Exception
  {
    return "";
  }
  
  private static PrivateKey loadPrivateKey(String paramString)
    throws Exception
  {
    paramString = new PKCS8EncodedKeySpec(Base64.decode(paramString, 0));
    return (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(paramString);
  }
  
  private static PublicKey loadPublicKey(String paramString)
    throws Exception
  {
    paramString = Base64.decode(paramString, 0);
    return (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.EncryptUtils
 * JD-Core Version:    0.7.0.1
 */