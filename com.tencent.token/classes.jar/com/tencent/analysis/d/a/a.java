package com.tencent.analysis.d.a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  private byte[] a = null;
  
  a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 16) {
      throw new RuntimeException("the keys's length must be 16!");
    }
    this.a = paramArrayOfByte;
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.a, "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec("s(2L@f!.tencent*".getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.a, "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec("s(2L@f!.tencent*".getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public final String c(byte[] paramArrayOfByte)
  {
    return b.a(b(paramArrayOfByte));
  }
  
  public final String toString()
  {
    return "AESCoding [keyBytes=" + b.a(this.a) + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.d.a.a
 * JD-Core Version:    0.7.0.1
 */