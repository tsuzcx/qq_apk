package com.tencent.ttpic.baseutils.encrypt;

import com.tencent.util.Coffee;
import java.security.Key;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

class EncryptUtils
{
  private static final String encoding = "utf-8";
  private static final String iv = "68881999";
  
  public static byte[] decode(byte[] paramArrayOfByte)
    throws Exception
  {
    Object localObject = new DESedeKeySpec(Coffee.getSignkey().getBytes());
    localObject = SecretKeyFactory.getInstance("desede").generateSecret((KeySpec)localObject);
    Cipher localCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
    localCipher.init(2, (Key)localObject, new IvParameterSpec("68881999".getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
    throws Exception
  {
    Object localObject = new DESedeKeySpec(Coffee.getSignkey().getBytes());
    localObject = SecretKeyFactory.getInstance("desede").generateSecret((KeySpec)localObject);
    Cipher localCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
    localCipher.init(1, (Key)localObject, new IvParameterSpec("68881999".getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.encrypt.EncryptUtils
 * JD-Core Version:    0.7.0.1
 */