package com.huawei.hianalytics.ab.bc.ab;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ef.ab;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ef
  implements fg
{
  public String ab(String paramString1, String paramString2)
  {
    ab.bc("HmacSHA256Crypt", "No HMAC_SHA256 decryption method");
    return "";
  }
  
  public String ab(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ab.cd("HmacSHA256Crypt", "encrypt: content is empty or null");
      return "";
    }
    paramString = new SecretKeySpec(paramString.getBytes(Charset.forName("UTF-8")), "HmacSHA256");
    try
    {
      Mac localMac = Mac.getInstance(paramString.getAlgorithm());
      localMac.init(paramString);
      paramString = de.ab(localMac.doFinal(paramArrayOfByte));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      ab.cd("HmacSHA256Crypt", "When digest2byte executed Exception has happened!From Algorithm error !");
      return "";
    }
    catch (InvalidKeyException paramString)
    {
      for (;;)
      {
        ab.cd("HmacSHA256Crypt", "Exception has happened when digest2byte,From Invalid key!");
      }
    }
  }
  
  public String bc(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ab.cd("HmacSHA256Crypt", "key or content is empty");
      return "";
    }
    try
    {
      paramString1 = ab(paramString1, paramString2.getBytes("UTF-8"));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      ab.bc("HmacSHA256Crypt", "Unsupported encoding exception,utf-8");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ab.ef
 * JD-Core Version:    0.7.0.1
 */