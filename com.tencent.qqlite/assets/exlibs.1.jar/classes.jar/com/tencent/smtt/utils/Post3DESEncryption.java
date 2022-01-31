package com.tencent.smtt.utils;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class Post3DESEncryption
{
  private static final String Algorithm = "DESede/ECB/PKCS5Padding";
  private static final String Publickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB";
  private static final String RSA_NO_PADDING = "RSA/ECB/NoPadding";
  private static byte[] desBytes = null;
  private static String deskeys;
  protected static final char[] hexArray = "0123456789abcdef".toCharArray();
  private static String keyValue = "";
  private static Post3DESEncryption mRsaUtils = null;
  private Cipher mDESEncryptCipher = null;
  private Cipher mRSAEncryptCipher = null;
  
  private Post3DESEncryption()
    throws Exception
  {
    deskeys = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
    Object localObject = "00000000";
    int i = 0;
    while (i < 12)
    {
      localObject = (String)localObject + String.valueOf(new Random().nextInt(89999999) + 10000000);
      i += 1;
    }
    desBytes = ((String)localObject + deskeys).getBytes();
    this.mRSAEncryptCipher = Cipher.getInstance("RSA/ECB/NoPadding");
    localObject = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0));
    localObject = KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject);
    this.mRSAEncryptCipher.init(1, (Key)localObject);
    keyValue = bytesToHex(this.mRSAEncryptCipher.doFinal(desBytes));
    localObject = new DESedeKeySpec(deskeys.getBytes());
    localObject = SecretKeyFactory.getInstance("DESede").generateSecret((KeySpec)localObject);
    this.mDESEncryptCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    this.mDESEncryptCipher.init(1, (Key)localObject);
  }
  
  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = hexArray[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = hexArray[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static Post3DESEncryption getInstance()
  {
    try
    {
      if (mRsaUtils == null) {
        mRsaUtils = new Post3DESEncryption();
      }
      Post3DESEncryption localPost3DESEncryption = mRsaUtils;
      return localPost3DESEncryption;
    }
    catch (Exception localException)
    {
      mRsaUtils = null;
      localException.printStackTrace();
    }
    return null;
  }
  
  public static byte[] hexToBytes(String paramString)
  {
    paramString = paramString.toCharArray();
    int m = paramString.length / 2;
    byte[] arrayOfByte = new byte[m];
    int i = 0;
    while (i < m)
    {
      int k = Character.digit(paramString[(i * 2)], 16) << 4 | Character.digit(paramString[(i * 2 + 1)], 16);
      int j = k;
      if (k > 127) {
        j = k - 256;
      }
      arrayOfByte[i] = ((byte)j);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public byte[] DESEncrypt(byte[] paramArrayOfByte)
    throws Exception
  {
    return this.mDESEncryptCipher.doFinal(paramArrayOfByte);
  }
  
  public byte[] DesDecrypt(byte[] paramArrayOfByte)
  {
    Object localObject = deskeys.getBytes();
    try
    {
      localObject = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec((byte[])localObject));
      Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      localCipher.init(2, (Key)localObject);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String RSAEncrypt(byte[] paramArrayOfByte)
    throws Exception
  {
    return bytesToHex(this.mRSAEncryptCipher.doFinal(paramArrayOfByte));
  }
  
  public byte[] getDESBytes()
  {
    return desBytes;
  }
  
  public String getRSAKeyValue()
  {
    return keyValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.Post3DESEncryption
 * JD-Core Version:    0.7.0.1
 */