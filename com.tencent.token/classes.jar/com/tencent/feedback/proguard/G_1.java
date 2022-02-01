package com.tencent.feedback.proguard;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class G
  implements H
{
  private String a = null;
  
  public final void a(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    if ((this.a != null) && (paramArrayOfByte != null))
    {
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(this.a.getBytes("UTF-8"));
      localCipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(this.a.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return null;
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    if ((this.a != null) && (paramArrayOfByte != null))
    {
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(this.a.getBytes("UTF-8"));
      localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(this.a.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.G
 * JD-Core Version:    0.7.0.1
 */