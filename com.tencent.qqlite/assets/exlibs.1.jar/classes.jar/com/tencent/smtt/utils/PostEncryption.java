package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.util.Base64;
import com.tencent.smtt.sdk.stat.DesUtils;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public class PostEncryption
{
  private static final char[] HEXARRAY = "0123456789abcdef".toCharArray();
  private static final String PUBLICKEY = "MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==";
  private static final String RSA_NO_PADDING = "RSA/ECB/NoPadding";
  private static PostEncryption mInstance;
  private String mDesKeyStr;
  private String mRsaKeyStr;
  private String mRsaKeyStrTemp;
  
  private PostEncryption()
  {
    int i = new Random().nextInt(89999999);
    int j = new Random().nextInt(89999999);
    this.mDesKeyStr = String.valueOf(i + 10000000);
    this.mRsaKeyStrTemp = (this.mDesKeyStr + String.valueOf(j + 10000000));
  }
  
  private String bytesToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = HEXARRAY[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = HEXARRAY[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static PostEncryption getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new PostEncryption();
      }
      PostEncryption localPostEncryption = mInstance;
      return localPostEncryption;
    }
    finally {}
  }
  
  public byte[] DESDecrypt(byte[] paramArrayOfByte)
    throws Exception
  {
    return DesUtils.DesEncrypt(this.mDesKeyStr.getBytes(), paramArrayOfByte, 0);
  }
  
  public byte[] DESEncrypt(byte[] paramArrayOfByte)
    throws Exception
  {
    return DesUtils.DesEncrypt(this.mDesKeyStr.getBytes(), paramArrayOfByte, 1);
  }
  
  @TargetApi(8)
  public String initRSAKey()
    throws Exception
  {
    if (this.mRsaKeyStr == null)
    {
      byte[] arrayOfByte = this.mRsaKeyStrTemp.getBytes();
      Cipher localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
      X509EncodedKeySpec localX509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0));
      localCipher.init(1, KeyFactory.getInstance("RSA").generatePublic(localX509EncodedKeySpec));
      this.mRsaKeyStr = bytesToHex(localCipher.doFinal(arrayOfByte));
    }
    return this.mRsaKeyStr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.PostEncryption
 * JD-Core Version:    0.7.0.1
 */