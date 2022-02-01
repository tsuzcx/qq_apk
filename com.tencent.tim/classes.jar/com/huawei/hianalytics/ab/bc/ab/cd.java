package com.huawei.hianalytics.ab.bc.ab;

import com.huawei.hianalytics.ab.bc.ef.ab;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class cd
{
  static String ab(String paramString)
  {
    try
    {
      paramString = de.ab(MessageDigest.getInstance("SHA-256").digest(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ab.cd("EncryptUtil", "sha256Digest(): UnsupportedEncodingException: Exception when writing the log file.");
      return "";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        ab.cd("EncryptUtil", "sha256Digest(): NoSuch Algorithm Exception");
      }
    }
  }
  
  static String ab(char[] paramArrayOfChar, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfChar = new PBEKeySpec(paramArrayOfChar, paramArrayOfByte, 10000, 128);
      paramArrayOfChar = de.ab(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(paramArrayOfChar).getEncoded());
      return paramArrayOfChar;
    }
    catch (InvalidKeySpecException paramArrayOfChar)
    {
      ab.de("EncryptUtil", "getAuthToken() encryptPBKDF2 Invalid key specification !");
      return null;
    }
    catch (NoSuchAlgorithmException paramArrayOfChar)
    {
      for (;;)
      {
        ab.de("EncryptUtil", "getAuthToken() encryptPBKDF2 No such algorithm!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ab.cd
 * JD-Core Version:    0.7.0.1
 */